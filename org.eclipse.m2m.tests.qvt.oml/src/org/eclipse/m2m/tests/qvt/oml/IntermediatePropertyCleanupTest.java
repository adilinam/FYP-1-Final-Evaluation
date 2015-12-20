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
package org.eclipse.m2m.tests.qvt.oml;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

import junit.framework.TestCase;

/**
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=279251  
 * 
 * @author dvorak
 */
public class IntermediatePropertyCleanupTest extends TestCase {

	private TransformationExecutor fExecutor;
	private BasicModelExtent fInput;	
	private BasicModelExtent fOutput;	
	private ExecutionContextImpl fContext;

	
	public IntermediatePropertyCleanupTest(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		URI uri = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/intermprop_cleanup/CheckMemoryLeak.qvto", false); //$NON-NLS-1$
		fExecutor = new TransformationExecutor(uri);

		fInput = new BasicModelExtent();
		EPackage inObject = EcoreFactory.eINSTANCE.createEPackage();
		inObject.setName("input"); //$NON-NLS-1$
		fInput.add(inObject);
		
		fOutput = new BasicModelExtent();		
		fContext = new ExecutionContextImpl();
		
		assertFalse(fInput.getContents().isEmpty());
		assertTrue(fOutput.getContents().isEmpty());		
	}
		
	public void testIntermPropCleanup() throws Exception {
		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput, fOutput);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertEquals(0, diagnostic.getCode());		
		
		List<?> outContents = fOutput.getContents();
		assertTrue(outContents.isEmpty());		

		// test re-execution and all interm-property data cleanup
		BasicModelExtent nextOut = new BasicModelExtent();
		fContext = new ExecutionContextImpl();
		ExecutionDiagnostic nextDiagnostic = fExecutor.execute(fContext, fInput, nextOut);
		
		assertEquals(Diagnostic.OK, nextDiagnostic.getSeverity());
	}	
}
