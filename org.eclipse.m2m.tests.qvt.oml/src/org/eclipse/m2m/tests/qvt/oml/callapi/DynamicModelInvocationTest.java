/*******************************************************************************
 * Copyright (c) 2009, 2012 Borland Software Corporation and others.
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

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

import junit.framework.TestCase;

/**
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=279251  
 * 
 * @author dvorak
 */
public class DynamicModelInvocationTest extends TestCase {

	private TransformationExecutor fExecutor;
	private BasicModelExtent fInput;	
	private BasicModelExtent fInMemoryOnlyInput;
	private ExecutionContextImpl fContext;

	
	public DynamicModelInvocationTest(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		URI transfURI = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/dynamicmodel/nonregisteredDynamic.qvto", false); //$NON-NLS-1$
		
		URI metamodelURI = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/dynamicmodel/nonregistered.ecore", false);
		URI modelInstanceURI = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/dynamicmodel/nonregisteredDynClass.xmi", false);
		
		ResourceSet rs = new ResourceSetImpl();
		Resource ecoreFile = rs.getResource(metamodelURI, true);
		Resource instanceFile = rs.getResource(modelInstanceURI, true);
		
		fInput = new BasicModelExtent();
		EObject inObject = instanceFile.getContents().get(0);
		fInput.add(inObject);
		assertFalse(fInput.getContents().isEmpty());
		
		fInMemoryOnlyInput = new BasicModelExtent();
		EObject inputCopy = EcoreUtil.copy(inObject);
		assertNull(inputCopy.eResource());
		fInMemoryOnlyInput.add(inputCopy);
		assertFalse(fInMemoryOnlyInput.getContents().isEmpty());
			
		fContext = new ExecutionContextImpl();			
	
		EPackage.Registry registry = new EPackageRegistryImpl();
		EPackage dynPackage = (EPackage) ecoreFile.getContents().get(0);
		registry.put(dynPackage.getNsURI(), dynPackage);
		
		assertNull("dynamic package must not be in the package registry", //$NON-NLS-1$ 
				EPackage.Registry.INSTANCE.get(dynPackage.getNsURI()));
		assertNull(EPackage.Registry.INSTANCE.get(inObject.eClass().getEPackage().getNsURI())); 
		assertTrue(inObject.eClass().eResource().getURI().isPlatform());
			
		assertTrue(inObject.eClass().getEPackage() == dynPackage);
		
		fExecutor = new TransformationExecutor(transfURI, registry);		
	}
		
	public void testDynamicModelInput() throws Exception {
		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertEquals(0, diagnostic.getCode());		
		assertEquals(2, fInput.getContents().size());
		
		fContext = new ExecutionContextImpl();
		ExecutionDiagnostic nextDiagnostic = fExecutor.execute(fContext, fInput);
		assertEquals(Diagnostic.OK, nextDiagnostic.getSeverity());
		assertEquals(0, nextDiagnostic.getCode());		
		
		assertEquals(3, fInput.getContents().size());
	}	
	
	public void testDynamicModelInputInMemoryOnly() throws Exception {
		ModelExtent input = fInMemoryOnlyInput;
		
		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, input);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertEquals(0, diagnostic.getCode());
		
		assertEquals(2, input.getContents().size());
	}		
}
