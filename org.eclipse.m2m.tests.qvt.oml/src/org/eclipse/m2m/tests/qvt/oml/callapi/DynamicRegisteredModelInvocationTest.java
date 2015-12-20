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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

import junit.framework.TestCase;

/**
 * @author dvorak
 */
public class DynamicRegisteredModelInvocationTest extends TestCase {

	private BasicModelExtent fRegistryModelInput;	
	private BasicModelExtent fNonRegistryModelInput;
	private ExecutionContextImpl fContext;
	private EPackageRegistryImpl fDynamicPackageRegistry;
	private URI fTransfURI;

	
	public DynamicRegisteredModelInvocationTest(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		fTransfURI = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/dynamicmodel/registeredDynamic.qvto", false);
		
		URI metamodelURI = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/dynamicmodel/registered.ecore", false);
		URI modelInstanceURI = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/dynamicmodel/registeredDynClass.xmi", false);
		
		ResourceSet rs = new ResourceSetImpl();
		Resource ecoreFile = rs.getResource(metamodelURI, true);
		Resource instanceFile = rs.getResource(modelInstanceURI, true);
		
		fRegistryModelInput = new BasicModelExtent();
		EObject inObject = instanceFile.getContents().get(0);
		fRegistryModelInput.add(inObject);
		assertFalse(fRegistryModelInput.getContents().isEmpty());
					
		fContext = new ExecutionContextImpl();			
	
		EPackage dynPackage = (EPackage) ecoreFile.getContents().get(0);
		assertNotNull("dynamic package must be in the package registry", //$NON-NLS-1$ 
				EPackage.Registry.INSTANCE.get(dynPackage.getNsURI()));
		assertNotNull(EPackage.Registry.INSTANCE.get(inObject.eClass().getEPackage().getNsURI())); 
		assertTrue(inObject.eClass().eResource().getURI().isPlatform());
		
		fNonRegistryModelInput = new BasicModelExtent();
		EObject dynamicNonRegistered = dynPackage.getEFactoryInstance().create((EClass)dynPackage.getEClassifier("DynClass"));
		fNonRegistryModelInput.add(dynamicNonRegistered);
		assertFalse(fNonRegistryModelInput.getContents().isEmpty());
		
		assertTrue(inObject.eClass().getEPackage() != dynPackage);
		assertTrue(inObject.eClass().getEPackage() == EPackage.Registry.INSTANCE.get(dynPackage.getNsURI()));
		
		fDynamicPackageRegistry = new EPackageRegistryImpl();	
		fDynamicPackageRegistry.put(dynPackage.getNsURI(), dynPackage);	
	}
		
	public void testDynamicRegisteredModelInput() throws Exception {
		TransformationExecutor executor = new TransformationExecutor(fTransfURI);
		final ExecutionDiagnostic  diagnostic = executor.execute(fContext, fRegistryModelInput);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertEquals(0, diagnostic.getCode());		
		assertEquals(2, fRegistryModelInput.getContents().size());
		
		fContext = new ExecutionContextImpl();
		ExecutionDiagnostic nextDiagnostic = executor.execute(fContext, fRegistryModelInput);
		assertEquals(Diagnostic.OK, nextDiagnostic.getSeverity());
		assertEquals(0, nextDiagnostic.getCode());		
		
		assertEquals(3, fRegistryModelInput.getContents().size());
	}	
	
	public void testDynamicModelInputOverRegistered() throws Exception {
		ModelExtent input = fNonRegistryModelInput;
		TransformationExecutor executor = new TransformationExecutor(fTransfURI, fDynamicPackageRegistry);
		final ExecutionDiagnostic  diagnostic = executor.execute(fContext, input);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertEquals(0, diagnostic.getCode());
		
		assertEquals(2, input.getContents().size());
	}		
}
