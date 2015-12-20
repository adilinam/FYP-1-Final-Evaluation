/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.EvaluationVisitorDecorator;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.IntegerLiteralExp;

import junit.framework.TestCase;

/**
 * This test class is to check for MDT OCL implementation dependant semantics, not covered in detail by
 * the OCL specification.   
 */
public class TestOCLSemantics extends TestCase {

	private CheckPointVisitor checkPointVisitor;
	
	public TestOCLSemantics(String name) {
		super(name);
	}

	public void testImpliesRightPartCalled() throws Exception {
		OCLExpression expression = createExpression("true implies 1 <> 1", EcorePackage.eINSTANCE.getEString());
		Object result = checkedEvaluate(null, expression);
		
		assertTrue(getLastEvaluationVisitor().intLiteralCalled);		
		assertTrue(Boolean.FALSE.equals(result));
	}	
	
	public void testImpliesRightPartSkipped() throws Exception {
		OCLExpression expression = createExpression("false implies 1 <> 1", EcorePackage.eINSTANCE.getEString());
		Object result = checkedEvaluate(null, expression);
		
		assertFalse(getLastEvaluationVisitor().intLiteralCalled);		
		assertTrue(Boolean.TRUE.equals(result));
	}

	
	private OCLExpression createExpression(String body, EClassifier contextType) {
		OCL.Helper oclHelper = OCL.newInstance().createOCLHelper();
		Exception error = null;
		try {
			oclHelper.setContext(contextType);
			return oclHelper.createQuery(body);
		} catch (Exception e) {
			error = e;
		}
		
		String detail = (error != null) ? error.getLocalizedMessage() : ""; //$NON-NLS-1$ 
		fail("Failed to parse OCL expression. " + detail); //$NON-NLS-1$
		return null; // make compiler happy, never reached
	}

	public Object checkedEvaluate(Object context, OCLExpression expression) {
		this.checkPointVisitor = null;
		
		EcoreEnvironmentFactory environmentFactory = new EcoreEnvironmentFactory() {
			@Override
			public EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEvaluationVisitor(
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
					EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
					Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
				checkPointVisitor = new CheckPointVisitor(super.createEvaluationVisitor(env, evalEnv, extentMap));
				return checkPointVisitor;
			}
		};
		
		EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> ev =
			environmentFactory.createEvaluationVisitor(
					environmentFactory.createEnvironment(),
					environmentFactory.createEvaluationEnvironment(),
					new HashMap<EClass, Set<EObject>>());
				
		return ev.visitExpression(expression);
	}
	

	private CheckPointVisitor getLastEvaluationVisitor() {
		if(checkPointVisitor == null) {
			throw new IllegalStateException("no last evaluation visitor is evailable"); //$NON-NLS-1$
		}
		return this.checkPointVisitor;
	}
	
	private static class CheckPointVisitor extends EvaluationVisitorDecorator<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> {
		boolean intLiteralCalled = false;
		
		CheckPointVisitor(EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> decorated) {
			super(decorated);
		}

		@Override
		public Object visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> literalExp) {		
			intLiteralCalled = true;
			return super.visitIntegerLiteralExp(literalExp);
		}
	}
}