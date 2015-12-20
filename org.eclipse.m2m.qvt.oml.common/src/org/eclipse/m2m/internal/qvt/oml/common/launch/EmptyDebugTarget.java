/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
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

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;

public class EmptyDebugTarget extends PlatformObject implements IDebugTarget {
    public EmptyDebugTarget(ILaunch launch, IProcess process, String modelId, String name) {
        myLaunch = launch;
        myProcess = process;
        myModelId = modelId;
        myName = name;
        
        myIsTerminated = false;
    }
    
    public IProcess getProcess() {
        return myProcess;
    }

    public IThread[] getThreads() throws DebugException {
        return new IThread[0];
    }

    public boolean hasThreads() throws DebugException {
        return false;
    }

    public String getName() throws DebugException {
        return myName;
    }

    public boolean supportsBreakpoint(IBreakpoint breakpoint) {
        return false;
    }

    public String getModelIdentifier() {
        return myModelId;
    }

    public IDebugTarget getDebugTarget() {
        return this;
    }

    public ILaunch getLaunch() {
        return myLaunch;
    }

    public boolean canTerminate() {
        return !myIsTerminated;
    }

    public void terminate() throws DebugException {
        DebugEvent terminatedEvent = new DebugEvent(this, DebugEvent.TERMINATE);  
        DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {terminatedEvent});
        myIsTerminated = true;
    }
    
    public boolean isTerminated() {
        return myIsTerminated;
    }

    public boolean canResume() {
        return false;
    }

    public void resume() throws DebugException {
    }


    public boolean canSuspend() {
        return false;
    }

    public void suspend() throws DebugException {
    }

    public boolean isSuspended() {
        return false;
    }

    public void breakpointAdded(IBreakpoint breakpoint) {
    }

    public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
    }

    public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
    }

    public boolean canDisconnect() {
        return false;
    }

    public void disconnect() throws DebugException {
    }

    public boolean isDisconnected() {
        return false;
    }

    public boolean supportsStorageRetrieval() {
        return false;
    }

    public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
        return null;
    }
    
    private final ILaunch myLaunch;
    private final IProcess myProcess;
    private final String myModelId;
    private final String myName;
    private boolean myIsTerminated;
}
