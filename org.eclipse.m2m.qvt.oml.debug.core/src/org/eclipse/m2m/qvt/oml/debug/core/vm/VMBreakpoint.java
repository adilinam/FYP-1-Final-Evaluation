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
package org.eclipse.m2m.qvt.oml.debug.core.vm;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.NewBreakpointData;
import org.eclipse.ocl.utilities.ASTNode;


public class VMBreakpoint {
	
	private final long fID;	
	private final String fTargetURI;
	private final int fLineNumber;	
	
	private final int fHitCount;
	private final ASTNode fElement;
	private final boolean fIsTemporary;			
	private final String fConditionBody;
	
	// intermediate calculated values
	private int fCurrentHitCount;		
	private boolean fConditionEnabled;
	private boolean fConditionSuspendOnTrue;
	private boolean fLastValue;
	private ConditionChecker fChecker;

	
	public VMBreakpoint(ASTNode element, NewBreakpointData data, boolean isTemporary)  {
		fID = data.ID;
		fTargetURI = data.targetURI;
		fElement = element;
		fLineNumber = data.line;		
		fIsTemporary = isTemporary;
		
		fHitCount = data.hitCount;
		fCurrentHitCount = 0;

		fConditionBody = data.condition;
		fConditionEnabled = data.conditionEnabled;
		fConditionSuspendOnTrue = data.conditionSuspendOnTrue;
	}
	
	public String getUri() {
		return fTargetURI;
	}

	public long getID() {
		return fID;
	}

	public ASTNode getElement() {
		return fElement;
	}

	public boolean isTemporary() {
		return fIsTemporary;
	}

	public int getLineNumber() {	
		return fLineNumber;
	}

	public int getHitCount() {
		return fCurrentHitCount;
	}

	public boolean expired() {
		return fHitCount > 0 && fCurrentHitCount >= fHitCount;
	}
	
	public boolean hitAndCheckIfTriggered(QvtOperationalEvaluationVisitorImpl visitor) throws CoreException {
		if(expired()) {
			return false;
		}
		
		if (fConditionBody != null) {
			if(!fConditionEnabled || !checkCondition(visitor)) {
				return false;
			}
		}
		
		if(fHitCount > 0) {
			return (++fCurrentHitCount == fHitCount);
		}
	
		return true;
	}

	private boolean checkCondition(QvtOperationalEvaluationVisitorImpl visitor) throws CoreException {
		if(fChecker == null) {
			fChecker = new ConditionChecker(fConditionBody, fElement);
		}
		
		boolean prevValue = fLastValue;
		fLastValue = fChecker.checkCondition(visitor);
		
		if (fConditionSuspendOnTrue) {
			return fLastValue;
		}

		return fLastValue == prevValue;
	}

	@Override
	public String toString() {
		return "VM Breakpoint:" + fLineNumber + ", isTemp:" + fIsTemporary; //$NON-NLS-1$ //$NON-NLS-2$
	}
}