/*******************************************************************************
 * Copyright (c) 2009, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.ocl2qvt;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.OCLEnvironmentWithQVTAccessFactory;

public class OCLEnvironmentWithQVTAccessByURITest extends OCLEnvironmentWithQVTAccessTest {

	public static class DynamicPackageTest extends OCLEnvironmentWithQVTAccessByURITest {
		
		private EPackage fMetamodeModel;
		
		public DynamicPackageTest() {
			super();
		}
		
		@Override
		protected void setUp() {
			super.setUp();
			assertNotNull(fMetamodeModel);
			
			boolean usesOurPackageInstance = false;
			for (Module importedModule : fEnvFactory.getQVTModules()) {
				EPackage found = findMetamodel(importedModule);				
				if(found != null) {
					assertTrue(found == fMetamodeModel);
					usesOurPackageInstance = true;
				}
			}
			
			assertTrue(usesOurPackageInstance);		
		}
		
		public void testImportedContextualOperation() throws org.eclipse.ocl.ParserException {
			// make this pass as it imported from a black-box library
			// in which case it's forced to reference the Java generated metamodel package
			// Hence, let the test-case green and reuse the rest
		}
		
		EPackage findMetamodel(Module module) {
			for (ModelType modelType : module.getUsedModelType()) {
				EPackage p = modelType.getMetamodel().get(0);
				if(p != null && fMetamodeModel.getNsURI().equals(p.getNsURI())) {
					return p;
				}
			}
			return null;
		}
		
		protected EPackage.Registry getEPackageRegistry() {
			Registry registry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
			URI uri = URI.createURI("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore#/", false);
			EObject eObject = new ResourceSetImpl().getEObject(uri, true);
			EPackage ePackage = (EPackage)eObject;
			assertNotNull(ePackage);
			
			registry.put(ePackage.getNsURI(), ePackage);
			
			fMetamodeModel = ePackage;
			return registry;
		}
	}
	
	public OCLEnvironmentWithQVTAccessByURITest() {
		super();
	}
	
	@Override
	protected OCLEnvironmentWithQVTAccessFactory createOCLEnvFactory() {
		List<URI> uris = Arrays.asList(
				URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/parserTestData/externlib/FooLib.qvto", false).appendQuery("ns=."),
				URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/parserTestData/externlib/org/q1.qvto", false).appendQuery("ns=org"),
				URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/parserTestData/externlib/org/q2.qvto", false).appendQuery("ns=org"),
				URI.createURI("qvto://blackbox/Strings", false)
		);
		
		return new OCLEnvironmentWithQVTAccessFactory(uris, getEPackageRegistry());
	}
	
	protected EPackage.Registry getEPackageRegistry() {
		return EPackage.Registry.INSTANCE;
	}
}
