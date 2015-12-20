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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VMFrameExecutionContext;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VMVariable;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VariableFinder;

public class QVTOLocalValue extends QVTOValue {
	
	public static class LocalValue {
		public Object valueObject;
		public EClassifier valueType;
	}
	
	public QVTOLocalValue(IQVTODebugTarget debugTarget, long frameID,
			String[] varPath, LocalValue evalResult, VMFrameExecutionContext execContext) {
		super(debugTarget, createVmVar(varPath, evalResult, execContext.getEvalEnv()), frameID);
		myFrameID = frameID;
		myExecContext = execContext;
	}
	
	@Override
	public IVariable[] getVariables() throws DebugException {
		List<VMVariable> variables = requestVariables();
		List<IVariable> result = new ArrayList<IVariable>();
		
		for (VMVariable nextVar : variables) {
			result.add(new QVTOLocalVariable(getQVTODebugTarget(), nextVar, myFrameID, myExecContext));
		}					
		
		return result.toArray(new IVariable[result.size()]);
	}
	
	@Override
	protected List<VMVariable> requestVariables() throws DebugException {
		List<VMVariable> vars = new ArrayList<VMVariable>();
		new VariableFinder(myExecContext, true).collectChildVars(vmVar.valueObject,
				VariableFinder.getVariablePath(VariableFinder.parseURI(vmVar.variableURI)), null, vars);
		return vars;
	}
	
	private static VMVariable createVmVar(String[] varPath, LocalValue evalResult, QvtOperationalEvaluationEnv evalEnv) {
		VMVariable var = new VMVariable();
		var.name = varPath.length > 0 ? varPath[varPath.length-1] : String.valueOf(null);
		var.kind = VMVariable.LOCAL;
		var.variableURI = VariableFinder.createURI(varPath).toString();
		var.valueObject = evalResult.valueObject;
		VariableFinder.setValueAndType(var, evalResult.valueObject, evalResult.valueType, evalEnv);
		return var;
	}

	private final long myFrameID;
	private final VMFrameExecutionContext myExecContext;
}
