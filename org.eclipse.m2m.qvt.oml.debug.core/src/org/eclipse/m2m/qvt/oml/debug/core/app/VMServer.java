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
package org.eclipse.m2m.qvt.oml.debug.core.app;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.channels.ServerSocketChannel;

import org.eclipse.m2m.qvt.oml.debug.core.DebugOptions;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;

public class VMServer {

	private final int fEventPort;
	private final int fRequestPort;
	private final VMInitializer fVMProvider;
	
	public VMServer(int requestPort, VMInitializer vmProvider) throws IOException {
		if(vmProvider == null) {
			throw new IllegalArgumentException();
		}
		
		fVMProvider = vmProvider;
		fRequestPort = requestPort;
		fEventPort = SocketUtil.findFreePort();
		
		if(fEventPort == -1) {
			throw new SocketException("Could find free port for the debugger"); //$NON-NLS-1$
		}
	}
	
	public int run() {
		QVTODebugCore.TRACE.trace("Starting VM Server..."); //$NON-NLS-1$
		
		ServerSocket fServerSocket = null;
		Socket requestSocket = null;
		
		try {
			ServerSocketChannel serveChannel = ServerSocketChannel.open();
			fServerSocket = serveChannel.socket();
			fServerSocket.bind(new InetSocketAddress(fRequestPort));
			
			QVTODebugCore.TRACE.trace(DebugOptions.VM,
					"VM Server starts listening, port:" + fRequestPort); //$NON-NLS-1$
			
			requestSocket = fServerSocket.accept();
	
			QVTODebugCore.TRACE.trace(DebugOptions.VM,
					"VM Server accepted debug client connection"); //$NON-NLS-1$
		
			AbstractRequestProcessor processor = new VMRequestProcessor(requestSocket, fVMProvider);
			processor.run();
			
		} catch (Throwable e) {
			System.err.println("QVTO Debugger terminated unexpectedly...");
			e.printStackTrace();
			
		} finally {
			if(requestSocket != null) {
				SocketUtil.close(requestSocket);
			}
			
			if(fServerSocket != null) {
				SocketUtil.close(fServerSocket);	
			}
		}

		QVTODebugCore.TRACE.trace(DebugOptions.VM, "VM Server terminated"); //$NON-NLS-1$
		return 0;
	}
}
