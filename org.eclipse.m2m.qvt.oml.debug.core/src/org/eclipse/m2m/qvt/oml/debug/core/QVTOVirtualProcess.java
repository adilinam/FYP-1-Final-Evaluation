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
package org.eclipse.m2m.qvt.oml.debug.core;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.m2m.internal.qvt.oml.NLS;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.qvt.oml.debug.core.vm.IQVTOVirtualMachineShell;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMTerminateRequest;


public class QVTOVirtualProcess extends PlatformObject implements IProcess {

	private final ILaunch fLaunch;
	private final IQVTOVirtualMachineShell fVM;
    private IStreamsProxy fStreamsPxy;	
	
	public QVTOVirtualProcess(final ILaunch launch, IQVTOVirtualMachineShell vm) {
		fLaunch = launch;
		fVM = vm;
		fLaunch.addProcess(this);
	}
	
	protected void terminated() {
		DebugPlugin manager = DebugPlugin.getDefault();
		if (manager != null) {
			DebugEvent event = new DebugEvent(this, DebugEvent.TERMINATE);
			manager.fireDebugEventSet(new DebugEvent[]{ event });
		}
	}
	
	public void setStreamsProxy(IStreamsProxy streamsProxy) {
		fStreamsPxy = streamsProxy;
	}
	
    public IStreamsProxy getStreamsProxy() {
    	return fStreamsPxy;
    }	

	public String getLabel() {
		String transformationURI = null;
		ILaunchConfiguration configuration = fLaunch.getLaunchConfiguration();
		if(configuration != null) {
			try {
				transformationURI = QvtLaunchUtil.getTransformationURI(configuration);
			} catch (CoreException e) {
				QVTODebugCore.log(e.getStatus());
			}
		}
		
		return transformationURI != null 
				? NLS.bind(DebugMessages.QVTOVirtualProcess_processLabel, transformationURI) 
						: DebugMessages.QVTOVirtualProcess_defaultLabel;
	}

	public ILaunch getLaunch() {
		return fLaunch;
	}

	public void setAttribute(String key, String value) {
	}

	public String getAttribute(String key) {
		return null;
	}

	public int getExitValue() throws DebugException {
		return 0;
	}

	public boolean isTerminated() {
		return fVM.isTerminated();
	}

	public boolean canTerminate() {
		return !isTerminated();
	}
	
	public void terminate() throws DebugException {
		try {
			fVM.sendRequest(new VMTerminateRequest());
		} catch (IOException e) {
			throw new DebugException(QVTODebugUtil.createDebugError("Process termination Failed", e));
		}			
	}
	
}
