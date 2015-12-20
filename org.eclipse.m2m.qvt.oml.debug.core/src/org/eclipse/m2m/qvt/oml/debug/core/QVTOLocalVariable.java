/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.debug.core.QVTOLocalValue.LocalValue;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VMFrameExecutionContext;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VMVariable;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VariableFinder;

public class QVTOLocalVariable extends QVTOVariable {
	QVTOLocalVariable(IQVTODebugTarget debugTarget, VMVariable vmVar, long frameID, VMFrameExecutionContext execContext) {
		super(debugTarget, vmVar, frameID);
		myFrameID = frameID;
		myExecContext = execContext;
	}
	
	@Override
	public IValue getValue() throws DebugException {
		if (fValue == null) {
			LocalValue lv = new LocalValue();
			lv.valueObject = vmVar.valueObject;
			lv.valueType = vmVar.valueObject instanceof EObject ? ((EObject) vmVar.valueObject).eClass() : null;
			fValue = new QVTOLocalValue(getQVTODebugTarget(), myFrameID,
					VariableFinder.getVariablePath(VariableFinder.parseURI(vmVar.variableURI)), lv, myExecContext);
		}
		return fValue;
	}
	
	private final long myFrameID;
	private final VMFrameExecutionContext myExecContext;
}
