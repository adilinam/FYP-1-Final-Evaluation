/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.callapi;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

import junit.framework.TestCase;

/**
 * @author dvorak
 */
public class ChildInTreeInputInvocationTest extends TestCase {

	private TransformationExecutor fExecutor;
	private BasicModelExtent fInput;
	private EAttribute fInObject;
	private BasicModelExtent fOutput;	
	private ExecutionContextImpl fContext;

	
	public ChildInTreeInputInvocationTest(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		URI uri = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/callapi/ChildInTreeInput.qvto", false); //$NON-NLS-1$
		fExecutor = new TransformationExecutor(uri);

		fInput = new BasicModelExtent();
		fInObject = createInputTree(); //$NON-NLS-1$
		assertNotNull(fInObject.eContainer());
		
		fInput.add(fInObject);
		fOutput = new BasicModelExtent();		
		fContext = new ExecutionContextImpl();
		
		assertFalse(fInput.getContents().isEmpty());
		assertTrue(fOutput.getContents().isEmpty());		
	}

	private EAttribute createInputTree() {
		EPackage inObject = EcoreFactory.eINSTANCE.createEPackage();
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("input"); //$NON-NLS-1$
		eClass.getEStructuralFeatures().add(attribute);
		inObject.getEClassifiers().add(eClass);
		
		return attribute;
	}
	
	private void assertOutputObject(ModelExtent outModel) {			
		EAnnotation result = (EAnnotation)EcoreUtil.getObjectByType(outModel.getContents(), EcorePackage.eINSTANCE.getEAnnotation());
		assertNotNull(fInObject.getName());
		assertEquals(fInObject.getName(), result.getSource());
	}
	
	
	public void testInvokeSuccess() throws Exception {
		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput, fOutput);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertEquals(0, diagnostic.getCode());		
		
		assertFalse(fInput.getContents().isEmpty());
		
		List<?> outContents = fOutput.getContents();
		assertEquals(1, outContents.size());		
		assertOutputObject(fOutput);
		
		// test re-execution
		BasicModelExtent nextOut = new BasicModelExtent();
		fContext = new ExecutionContextImpl();
		ExecutionDiagnostic nextDiagnostic = fExecutor.execute(fContext, fInput, nextOut);
		assertFalse(fInput.getContents().isEmpty());
		
		assertOutputObject(nextOut);
		assertEquals(Diagnostic.OK, nextDiagnostic.getSeverity());
	}	
}
