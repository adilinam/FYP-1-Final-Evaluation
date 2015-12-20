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
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.qvt.oml.debug.core.DebugOptions;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;
import org.eclipse.m2m.qvt.oml.debug.core.vm.IQVTOVirtualMachineShell;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMEvent;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMTerminateEvent;

class VMEventDispatcher {
	
	interface TerminationListener {
		void terminated();
	}

	private final class DispatchJob implements Runnable {
		private final Object startLock;
		private final int fPort;
		private boolean fReady;
		private boolean fRunning;
		
		
		DispatchJob(int port) {
			this.startLock = new Object();
			fPort = port;
			fReady = false;
			fRunning = false;
		}
				
		public void run() {
			QVTODebugCore.TRACE.trace(DebugOptions.VM,
					"VM Server Event Dispatcher started");				
											
			ObjectOutputStream eventStream = null;
			ServerSocket serverSocket = null;
			Socket eventSocket = null;
			
			try {				
				synchronized (startLock) {
					fReady = true;
					startLock.notify();
				}
				
				serverSocket = new ServerSocket(fPort);
				eventSocket = serverSocket.accept();

				QVTODebugCore.TRACE.trace(DebugOptions.VM,
						"VM Server Event Dispatcher accepted connection");
				
				eventStream = new ObjectOutputStream(eventSocket.getOutputStream());
				
				doRun(eventStream);
				
			} catch(IOException e) {
				e.printStackTrace();
				// TODO - failed to initialize
				QVTODebugCore.log(e);
				
			} finally {
				if(eventStream != null) {
					SocketUtil.close(eventStream);
				}
				
				if(eventSocket != null) {
					SocketUtil.close(eventSocket);
				}
				
				if(serverSocket != null) {
					SocketUtil.close(serverSocket);
				}
			}
		}
		
		private void doRun(ObjectOutputStream eventStream) {
			IQVTOVirtualMachineShell vm;
			// FIXME
			try {
				vm = fVMProvider.getVM();
			} catch (CoreException e) {
				// Note: we are not to report this issues, just one of the clients waiting for
				// the VM initialization on background				
				QVTODebugCore.TRACE.trace(DebugOptions.VM,
					"VM Server Event dispatcher exiting, VM failed not available"); //$NON-NLS-1$
				return;
			}
			
			fRunning = true;

			while (fRunning) {
				VMEvent event = null;
				try {
					event = vm.readVMEvent();
				} catch (IOException e) {
					QVTODebugCore.TRACE.trace(DebugOptions.VM,
							"VM Server Event dispatcher interrupted"); //$NON-NLS-1$
				}
					
				if (event != null) {
					QVTODebugCore.TRACE.trace(DebugOptions.VM,
							"VM Server - sending VM event: " + event); //$NON-NLS-1$
					
					try {
						eventStream.writeObject(event);
						eventStream.flush();
					} catch (IOException e) {
						// TODO
						e.printStackTrace();
					}
				}

				if(event == null || event instanceof VMTerminateEvent) {
					// Note: VMTerminate has already been sent, we can exit
					fRunning = false;
					fReady = false;
					terminated();
					continue;
				}
			}
				
			QVTODebugCore.TRACE.trace(DebugOptions.VM,
					"VM Server Event dispather terminated"); //$NON-NLS-1$
		}
				
		private void waitToReachAccept() {
			synchronized (startLock) {
				while(!fReady) {
					try {
						startLock.wait();
					} catch (InterruptedException e) {
						// nothing
					}
				}
			}
		}		
	}
	
	private VMProvider fVMProvider;
	private Thread fDispatchThread;
	private DispatchJob fDispatchJob;
	private TerminationListener fTerminationListener;

	VMEventDispatcher(VMProvider vmProvider, int port, TerminationListener listener) {
		fDispatchJob = new DispatchJob(port);
		fTerminationListener = listener;
		fVMProvider = vmProvider;
	}
	
	protected void terminated() {
		if(fTerminationListener != null) {
			try {
				fTerminationListener.terminated();
			} catch(Throwable e) {
				e.printStackTrace();
			}
		}
	}

	void start() {
		synchronized (this) {
			if(fDispatchThread != null) {
				throw new IllegalStateException("Dispatcher already started"); //$NON-NLS-1$
			}

			fDispatchThread = new Thread(fDispatchJob, "QVTO Srv-VMEvent dispatch"); //$NON-NLS-1$
		}

		fDispatchThread.setDaemon(true);		
		fDispatchThread.start();

		fDispatchJob.waitToReachAccept();
		
		QVTODebugCore.TRACE.trace(DebugOptions.VM,
				"VM Server Event dispatcher ready"); //$NON-NLS-1$
	}
	
	boolean joinTermination(long timeOut) {
		try {
			fDispatchThread.join(timeOut);			
		} catch (InterruptedException e) {
			Thread.interrupted();
		}
		return !fDispatchThread.isAlive();
	}

}