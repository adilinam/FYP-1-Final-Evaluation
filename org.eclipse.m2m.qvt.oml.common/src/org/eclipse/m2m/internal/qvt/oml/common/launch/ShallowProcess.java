/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.m2m.internal.qvt.oml.common.CommonPlugin;
import org.eclipse.m2m.internal.qvt.oml.common.Messages;
import org.eclipse.osgi.util.NLS;


public class ShallowProcess extends BaseProcess {

	public ShallowProcess(ILaunch launch, IRunnable r) {
        myLaunch = launch;
        myRunnable = r;
    }
    
    public void run() throws Exception {
        run(null);
    }
    
    public void run(IDebugTarget debugTarget) throws Exception {
        myLaunch.addProcess(this);
        try {
            if(debugTarget != null) {
                myLaunch.addDebugTarget(debugTarget);
            }
            myRunnable.run();
        }
        finally {
            myRunnable = null;
            if (DebugPlugin.getDefault() != null) {
                DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {new DebugEvent(this, DebugEvent.TERMINATE)});
            }
        }
    }
    
    public String getLabel() {
		String transformationURI = null;
		ILaunchConfiguration configuration = myLaunch.getLaunchConfiguration();
		if(configuration != null) {
			try {
				transformationURI = configuration.getAttribute(IQvtLaunchConstants.MODULE, (String) null);
			} catch (CoreException e) {
				CommonPlugin.log(e.getStatus());
			}
		}
		
		return transformationURI != null 
				? NLS.bind(Messages.ShallowProcess_LabelTransform, transformationURI) 
						: Messages.ShallowProcess_Label;
    }

    public ILaunch getLaunch() {
        return myLaunch;
    }

    public void setAttribute(String key, String value) {
    }

    public String getAttribute(String key) {
        return null;
    }

    public int getExitValue() throws DebugException {
        if(!isTerminated()) {
            throw new DebugException(new Status(IStatus.ERROR, CommonPlugin.ID, 1, Messages.ShallowProcess_InvalidState, null));
        }
        
        return 0;
    }

    public boolean canTerminate() {
        return !isTerminated();
    }

    public boolean isTerminated() {
        return myRunnable == null;
    }

    public void terminate() throws DebugException {
    }
    
    private final ILaunch myLaunch;
    private IRunnable myRunnable;
}
