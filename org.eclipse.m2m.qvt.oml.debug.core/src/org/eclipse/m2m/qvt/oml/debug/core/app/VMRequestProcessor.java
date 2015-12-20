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

import java.io.IOException;
import java.net.Socket;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;
import org.eclipse.m2m.qvt.oml.debug.core.vm.IQVTOVirtualMachineShell;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMConnectRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMConnectResponse;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMResponse;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMStartRequest;

class VMRequestProcessor extends AbstractRequestProcessor {
	
	private IQVTOVirtualMachineShell fVM;
	private VMProvider fVMProvider;
	private VMEventDispatcher fEventDispatcher;
	
	public VMRequestProcessor(Socket requestSocket, VMProvider vmProvider) throws IOException {
		super(requestSocket);	
		
		if(vmProvider == null) {
			throw new IllegalArgumentException();
		}

		fVMProvider = vmProvider;
	}

	@Override
	protected void postTerminate() {		
		super.postTerminate();
		
		if(fEventDispatcher != null) {
			fEventDispatcher.joinTermination(1000);
		}
	}

	protected VMResponse processRequest(VMRequest request) throws CoreException {
		try {
			if (request instanceof VMConnectRequest) {
				return connect((VMConnectRequest) request);
			} else if (request instanceof VMStartRequest) {			
				fVM = fVMProvider.getVM();
				return fVM.sendRequest(request);
			} 
			
			if (fVM != null) {
				return fVM.sendRequest(request);
			}
		} catch(IOException e) {
			throw new CoreException(QVTODebugCore.getDefault().createStatus(IStatus.ERROR,
					e.getMessage(), e));
		}

		return VMResponse.createERROR();
	}

	private VMResponse connect(VMConnectRequest connectRequest) {		
		int eventPort = SocketUtil.findFreePort();
		if(eventPort != -1) {
			// start event dispatcher
			fEventDispatcher = new VMEventDispatcher(fVMProvider, eventPort,
					new VMEventDispatcher.TerminationListener() {
						public void terminated() {
							terminate();
						}
					});					
			fEventDispatcher.start();
			
			return new VMConnectResponse(eventPort);
		}
		
		// FIXME no free port for debugger error
		return VMResponse.createERROR();
	}

}