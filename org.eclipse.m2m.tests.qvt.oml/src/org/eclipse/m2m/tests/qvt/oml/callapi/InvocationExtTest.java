/*******************************************************************************
 * Copyright (c) 2009, 2010 Borland Software Corporation and others.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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
public class InvocationExtTest extends TestCase {

	private TransformationExecutor fExecutor;
	private BasicModelExtent fInput;
	private List<EObject> fInitialInputContents;	
	
	private BasicModelExtent fInOut;
	private String fInOutPackageInitialName = "inout"; //$NON-NLS-1$
	
	private ExecutionContextImpl fContext;

	
	public InvocationExtTest(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		URI uri = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/callapi/Ecore2EcoreExt.qvto", false); //$NON-NLS-1$
		fExecutor = new TransformationExecutor(uri);

		fInput = new BasicModelExtent();
		EPackage inObject = EcoreFactory.eINSTANCE.createEPackage();
		inObject.setName("input1"); //$NON-NLS-1$
		fInput.add(inObject);
		
		fInOut = new BasicModelExtent();
		EPackage inOutObject = EcoreFactory.eINSTANCE.createEPackage();
		inOutObject.setName(fInOutPackageInitialName);
		fInOut.add(inOutObject);
		
		fInitialInputContents = new ArrayList<EObject>(fInput.getContents());
				
		fContext = new ExecutionContextImpl();
		
		assertFalse(fInput.getContents().isEmpty());		
		assertFalse(fInOut.getContents().isEmpty());		
	}

	private void assertInOutObject() {
		EPackage inoutObjevt = (EPackage)EcoreUtil.getObjectByType(fInOut.getContents(), EcorePackage.eINSTANCE.getEPackage());
		assertEquals(fInOutPackageInitialName + "_Ecore2EcoreExt", inoutObjevt.getName()); //$NON-NLS-1$
		assertEquals(1, inoutObjevt.getEClassifiers().size());
	}
	
	private void assertOutObject(String key, ModelExtent outModel) {
		assertEquals(1, outModel.getContents().size());
		EPackage result = (EPackage)EcoreUtil.getObjectByType(outModel.getContents(), EcorePackage.eINSTANCE.getEPackage());
		assertEquals(key, result.getName());		
		assertEquals(1, result.getEClassifiers().size());
		
		assertUnchangedInput();
	}
	
	
	private void assertUnchangedInput() {
		// check the input was not changed
		assertEquals(fInitialInputContents, fInput.getContents());
	}
		
	public void testInvokeIn_InOut_Out1_Out2() throws Exception {
		BasicModelExtent output1 = new BasicModelExtent();
		BasicModelExtent output2 = new BasicModelExtent();

		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput, fInOut, output1, output2);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertEquals(0, diagnostic.getCode());

		assertOutObject("output1", output1); //$NON-NLS-1$
		assertOutObject("output2", output2); //$NON-NLS-1$
		
		assertInOutObject();
	}

	public void testInOut() throws Exception {
		URI uri = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/callapi/InplaceEcore.qvto", false); //$NON-NLS-1$
		fExecutor = new TransformationExecutor(uri);
		
		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInOut);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertEquals(0, diagnostic.getCode());
	}
	
}
