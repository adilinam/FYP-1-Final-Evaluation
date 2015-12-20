/*******************************************************************************
 * Copyright (c) 2008, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.EvaluationEnvironment;

/**
 * This class represents a call object to QVT helper operation, including both
 * the <code>query</code> and <code>helper</code> with side-effects operations.
 * <p>
 * The call object is intended to be used in a given execution context in which 
 * it's created and invocations with actual parameter values.
 * 
 * @see NonTransformationExecutionContext
 */
public class HelperOperationCall {

	private static final Object[] NO_ARGS = new Object[0];
	
	private NonTransformationExecutionContext fContext;
	private Module fOwningModule;
	private Helper fOperation;
	private EClassifier fContextType;
	private List<EClassifier> fArgumentTypes;	

	/**
	 * Constructs new operation call for the given operation and execution
	 * context.
	 * 
	 * @param operation
	 *            a valid AST operation to be called. <code>Note:</code> This
	 *            must be an operation owned by a valid QVT Library module
	 * @param context
	 *            non-QVT transformation context in which this operation will be
	 *            called
	 * @exception IllegalArgumentException
	 *                If the passed <code>operation</code> or
	 *                <code>context</code> are <code>null</code>; or the
	 *                operation is not valid AST element for construction of the
	 *                call
	 */
	HelperOperationCall(Helper operation, NonTransformationExecutionContext context) {
		if(operation == null || context == null) {
			throw new IllegalArgumentException();
		}
		
		fOwningModule = QvtOperationalParserUtil.getOwningModule(operation);
		if(fOwningModule == null) {
			throw new IllegalArgumentException("Not a library query or helper");  //$NON-NLS-1$
		}
		
		fOperation = operation;		
		fContextType = QvtOperationalParserUtil.getContextualType(fOperation);
		
		fArgumentTypes = new ArrayList<EClassifier>(fOperation.getEParameters().size());
		for (EParameter eParam : fOperation.getEParameters()) {
			EClassifier paramType = eParam.getEType();
			if(paramType == null) {
				throw new IllegalArgumentException("Parameter with no type"); //$NON-NLS-1$
			}
			
			fArgumentTypes.add(paramType);			
		}
		
		fContext = context;
	}

	/**
	 * Gets the operation referred by this operation call
	 * @return <code>non-null</code> operation object
	 */
	public Helper getOperation() {
		return fOperation;
	}
	
	/**
	 * Gets the library module defining the operation referred by this call object.
	 * @return <code>non-null</code> module object
	 */	
	public Module getLibrary() {
		return fOwningModule;
	}
	
	/**
	 * Gets the context type of the operation referred by this call object.
	 * @return the type or <code>null</code> if the referred operation is not contextual.
	 * 
	 * @see #isContextual()
	 */
	public EClassifier getContextType() {
		return fContextType;
	}	
	
	
	/**
	 * Indicates whether the operation referred by this operation call is
	 * contextual.
	 * 
	 * @return <code>true</code> if the operation is contextual and requires an
	 *         explicit contextual instance to be passed to every invocation.
	 *         <code>false</code> indicates that operation is owned by defined
	 *         on a library and has no context type.
	 * 
	 * @see #getContextType()
	 * @see HelperOperationCall#invoke(Object, Object[])
	 */
	public boolean isContextual() {
		return fContextType != null;
	}

	/**
	 * Invokes as a library module owned (non-contextual) operation.
	 * 
	 * @param arguments
	 *            actual parameter values passed to the invocation  or
	 *            <code>null</code> in no parameters are defined
	 * @return the value returned by this call invocation
	 * 
	 * @exception IllegalArgumentException
	 *                if the <code>arguments</code> do not conform to
	 *                corresponding parameter types or the underlying operation
	 *                is contextual
	 * @exception InvocationTargetException
	 *                if the underling operation throws an exception
	 * 
	 * @see #invoke(Object, Object[])
	 */
	public Object invoke(Object[] arguments) throws IllegalArgumentException, InvocationTargetException {
		if(isContextual()) {
			throw new IllegalArgumentException("Contextual operation called without self"); //$NON-NLS-1$
		}
		
		QvtOperationalEvaluationVisitorImpl evaluator = fContext.getEvaluator();
		Object thisObject = evaluator.getOperationalEvaluationEnv().getThisOfType(this.fOwningModule);
		assert thisObject != null;
		return doInvoke(thisObject, arguments);
	}

	/**
	 * Performs contextual operation call on the operation referred by this call
	 * object.
	 * 
	 * @param self
	 *            a <code>non-null</code> context type instance on which the invocation is performed
	 * @param arguments
	 *            actual parameter values passed to the invocation or
	 *            <code>null</code> in no parameters are defined
	 * @return the value returned by this call invocation
	 * 
	 * @exception IllegalArgumentException
	 *                if the <code>self</code> does not conform to the operation
	 *                context type or the <code>arguments</code> do not conform
	 *                to corresponding parameter types or the underlying
	 *                operation is non-contextual
	 * @exception InvocationTargetException
	 *                if the underling operation throws an exception
	 * @see #invoke(Object[])
	 */
	public Object invoke(Object self, Object[] arguments) throws IllegalArgumentException, InvocationTargetException  {
		if(!isContextual()) {
			throw new IllegalArgumentException("Self passed to non-contextual operation"); //$NON-NLS-1$
		}
		
		return doInvoke(self, arguments);
	}
	
	/**
	 * Performs contextual operation call on the operation referred by this call
	 * object.
	 * 
	 * @param self
	 *            a <code>non-null</code> context type instance on which the invocation is performed
	 * @param arguments
	 *            actual parameter values passed to the invocation or
	 *            <code>null</code> in no parameters are defined
	 * @return the value returned by this call invocation
	 * 
	 * @exception IllegalArgumentException
	 *                if the <code>self</code> does not conform to the operation
	 *                context type or the <code>arguments</code> do not conform
	 *                to corresponding parameter types or the underlying
	 *                operation is non-contextual
	 * @exception InvocationTargetException
	 *                if the underling operation throws an exception
	 * @see #invoke(Object[])
	 */
	private Object doInvoke(Object self, Object[] arguments) throws IllegalArgumentException, InvocationTargetException  {		
		if(self == null) {
			throw new IllegalArgumentException("Null context instance"); //$NON-NLS-1$
		}
				
		Object[] actualArguments = (arguments == null) ? NO_ARGS : arguments;		
		checkArgumentType(self, actualArguments);
		
		QvtOperationalEvaluationVisitorImpl evaluator = fContext.getEvaluator();
		Object result = null;
		try {
			result = evaluator.executeHelperOperation(fOperation, self, Arrays.asList(actualArguments));
			if(result == evaluator.getOperationalEvaluationEnv().getAdapter(InternalEvaluationEnv.class).getInvalid()) {
				// OclInvalid is not valid for non-QVT external callers	 
				result = null;
			}		
		} catch (RuntimeException e) {
			throw new InvocationTargetException(e);
		}
		
		return result;
	}

	private void checkArgumentType(Object self, Object[] arguments) {
		if(arguments.length != fArgumentTypes.size()) {
			throw new IllegalArgumentException("Parameter count mismatch"); //$NON-NLS-1$
		}
		
		EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv = fContext.getEvaluator().getEvaluationEnvironment();
		if(self != null) {
			EClassifier callContextType = fContextType;
			if(callContextType == null) {
				callContextType = fOwningModule;
			}
			if(!evalEnv.isKindOf(self, callContextType)) {
				throw new IllegalArgumentException("Invalid context instance type"); //$NON-NLS-1$
			}
		}
			
		int argIndex = 0;
		for (EClassifier nextArgType : fArgumentTypes) {
			Object nextArg = arguments[argIndex++];
			if(nextArg != null) {
				if(!evalEnv.isKindOf(nextArg, nextArgType)) {
					throw new IllegalArgumentException("Invalid type of argument, pos = " + argIndex); //$NON-NLS-1$					
				}
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		if(fContext != null) {
			buf.append(fContextType).append("::"); //$NON-NLS-1$
		}
		
		buf.append(fOperation.getName()).append(" - ").append(fOwningModule.getName()); //$NON-NLS-1$ 
		return buf.toString();
	}
}
