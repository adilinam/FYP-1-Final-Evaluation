/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.eclipse.m2m.qvt.oml.debug.core.app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.SocketChannel;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMResponse;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMTerminateRequest;

abstract class AbstractRequestProcessor {
	
	private boolean fTerminated;
	
	private InputStream fRequestStream;
	
	private OutputStream fResponseStream;
	
	private Socket fRequestSocket;

	
	public AbstractRequestProcessor(Socket requestSocket) throws IOException {
		if (requestSocket == null || !requestSocket.isConnected()
				|| requestSocket.isClosed()) {
			throw new IllegalArgumentException("Socket not connected or closed"); //$NON-NLS-1$
		}

		if(requestSocket.getChannel() == null) {
			throw new IllegalArgumentException("Requires a socket with open channel"); //$NON-NLS-1$
		}
		
		fRequestStream = new BufferedInputStream(requestSocket.getInputStream());
		fResponseStream =  new BufferedOutputStream(requestSocket.getOutputStream());
		
		fRequestSocket = requestSocket;
		fTerminated = false;
	}

	public void run() throws IOException {
		ObjectInputStream requestObjects = null;
		ObjectOutputStream responseObjects = null;
		try {
			responseObjects = new ObjectOutputStream(fResponseStream);
			// Note: blocks until the first request => object input stream reads the header
			requestObjects = new ObjectInputStream(fRequestStream);

			while (!fTerminated) {
				VMResponse response;
				VMRequest request;
				Object rawRequest;

				try {
					rawRequest = requestObjects.readObject();
				} catch (AsynchronousCloseException e) {
					// continue to check if we have been interrupted
					continue;					
				} catch (SocketException e) {
					// FIXME - ??
					e.printStackTrace();
					fTerminated = true;
					break;
					
				} catch (IOException e) {
					if(e instanceof EOFException) {
						QVTODebugCore.TRACE.trace("VM Server - Client disconnected, going to shutdown");
						
						fTerminated = true;
						break;
					}
					// TODO - traces should see that logged  exception
					rawRequest = null;
					QVTODebugCore.log(e);

				} catch (ClassNotFoundException e) {
					rawRequest = null;
					// could not unmarshall request, just report an fError
					// TODO - invalid request
					response = VMResponse.createERROR();
				}

				request = validateRequestObject(rawRequest);
				if (request != null) {
					try {
						response = processRequest(request);
					} catch(CoreException e) {
						System.err.println(e.getStatus());
						fTerminated = true;
						break;
					}
				} else {
					// TODO invalid request
					response = VMResponse.createERROR();
				}

				try {
					responseObjects.writeObject(response);
					responseObjects.flush();					
				} catch (IOException e) {
					reportSendReponseError(response, e);
				}

				if (request instanceof VMTerminateRequest) {
					// time to exit request processing
					fTerminated = true;
					break;
				}
			} // request processing loop

		} finally {
			// Note: object streams close the underlying I/O streams
			if (responseObjects != null) {
				SocketUtil.close(responseObjects);
			}

			if (requestObjects != null) {
				SocketUtil.close(requestObjects);
			}
		}
	}

	protected void postTerminate() {
		// do nothing
	}

	protected abstract VMResponse processRequest(VMRequest request) throws CoreException;

	private VMRequest validateRequestObject(Object rawRequest) {
		if (rawRequest instanceof VMRequest == false) {
			QVTODebugCore.TRACE.trace("Invalid VM request: " + rawRequest); //$NON-NLS-1$
			return null;
		}

		return (VMRequest) rawRequest;
	}

	private void reportSendReponseError(VMResponse response, IOException e) {
		QVTODebugCore.TRACE.catching(VMServer.class, "sendResponse", e); //$NON-NLS-1$
		QVTODebugCore.log(e);
	}

	public void terminate() {
		synchronized (this) {
			fTerminated = true;
			 
			SocketChannel channel = fRequestSocket.getChannel();
			assert channel != null;
			// interrupt the socket channel
			try {
				channel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}