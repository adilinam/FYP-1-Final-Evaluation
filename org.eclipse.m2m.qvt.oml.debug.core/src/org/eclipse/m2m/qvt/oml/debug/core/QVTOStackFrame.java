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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VMLocation;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VMStackFrame;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VMVariable;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMResponse;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMStackFrameRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMStackFrameResponse;

public class QVTOStackFrame extends QVTODebugElement implements IStackFrame {

	private final QVTOThread fThread;
	private VMStackFrame fUnderlyingFrame;
	private boolean fDeferredExecution;
	

	public QVTOStackFrame(QVTOThread thread, VMStackFrame frame) {
		super(thread.getQVTODebugTarget());
		
		if(thread == null || frame == null) {
			throw new IllegalArgumentException();
		}

		fThread = thread;
		fUnderlyingFrame = frame;
	}
	
	protected void setLocation(VMStackFrame frame) {
		if (frame == null) {
			throw new IllegalArgumentException("null frame"); //$NON-NLS-1$
		}
		fUnderlyingFrame = frame;
	}
	
	public void setDeferredExecution(boolean isDeferred) {
		this.fDeferredExecution = isDeferred;
	}
	
	public boolean isDeferredExecution() {
		return fDeferredExecution;
	}	

	public IThread getThread() {
		return fThread;
	}

	public boolean hasVariables() throws DebugException {
		return !fUnderlyingFrame.getVisibleVariables().isEmpty();  
	}
	
	public IVariable[] getVariables() throws DebugException {
		List<IVariable> result = new ArrayList<IVariable>();
		for (VMVariable next : fUnderlyingFrame.getVisibleVariables()) {
			final VMVariable vmVar = next;
			
			result.add(new QVTOVariable(getQVTODebugTarget(), vmVar, fUnderlyingFrame.id));
		}
		
		IVariable[] allVars = result.toArray(new IVariable[result.size()]);
		Arrays.sort(allVars, new Comparator<IVariable>() {
			public int compare(IVariable var1, IVariable var2) {
				try {
					return var1.getName().compareTo(var2.getName());
				} catch (DebugException e) {
					QVTODebugCore.log(e);
				}
				
				return 0;
			}
		});
		
		return allVars;
	}
		
	public URI getUnitURI() {
		return URI.createURI(getLocation().getURI());
	}

	public VMLocation getLocation() {
		return fUnderlyingFrame.getLocation();
	}
	
	public int getLineNumber() {
		return getLocation().getLineNum();
	}

	public int getCharStart() throws DebugException {		
//		return getLocation().getElement().getStartPosition();
		return -1;
	}

	public int getCharEnd() throws DebugException {
//		 int endPos = getLocation().getElement().getEndPosition();
//		 return (endPos >= 0) ? endPos + 1 : -1;
		return -1;
	}

	public String getName() throws DebugException {
		int line = getLineNumber();
		String fileName = getUnitURI().lastSegment();
		return line < -1 ? fileName : fileName + "(" + line + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return null;
	}

	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}

	public boolean canStepInto() {
		return getThread().canStepInto();
	}

	public boolean canStepOver() {
		return getThread().canStepOver();
	}

	public boolean canStepReturn() {
		return getThread().canStepReturn();
	}

	public boolean isStepping() {
		return getThread().isStepping();
	}

	public void stepInto() throws DebugException {
		getThread().stepInto();
	}

	public void stepOver() throws DebugException {
		getThread().stepOver();
	}

	public void stepReturn() throws DebugException {
		getThread().stepReturn();
	}

	public boolean canResume() {
		return getThread().canResume();
	}

	public boolean canSuspend() {
		return getThread().canSuspend();
	}

	public boolean isSuspended() {
		return getThread().isSuspended();
	}

	public void resume() throws DebugException {
		getThread().resume();
	}

	public void suspend() throws DebugException {
		getThread().suspend();
	}

	public boolean canTerminate() {
		return getThread().canTerminate();
	}

	public boolean isTerminated() {
		return getThread().isTerminated();
	}

	public void terminate() throws DebugException {
		getThread().terminate();
	}

	public IValue evaluate(String expressionText) throws CoreException {
		return ((QVTODebugTarget) getQVTODebugTarget()).evaluate(expressionText, fUnderlyingFrame.id);
	}

	VMStackFrame requestStackFrame() throws DebugException {
		VMStackFrame frame = null;
		
		VMStackFrameRequest frameRequest = new VMStackFrameRequest(fUnderlyingFrame.id);
		VMResponse response = getQVTODebugTarget().sendRequest(frameRequest);
		if(response instanceof VMStackFrameResponse) {
			VMStackFrameResponse stackFrameResponse = (VMStackFrameResponse) response;
			fDeferredExecution = stackFrameResponse.isDeferredExecution;
			frame = stackFrameResponse.getFrame();
		}
		
		if(frame == null) {
			throw new DebugException(QVTODebugCore.createStatus(
					IStatus.ERROR, "VMStackFrame request failure")); //$NON-NLS-1$
		}
		
		return frame;
	}
	
}
