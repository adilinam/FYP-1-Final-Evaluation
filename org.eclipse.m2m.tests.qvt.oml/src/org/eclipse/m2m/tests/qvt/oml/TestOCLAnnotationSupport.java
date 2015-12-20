/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
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

import java.util.Arrays;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.internal.qvt.oml.evaluator.OCLAnnotationSupport;

import junit.framework.TestCase;

public class TestOCLAnnotationSupport extends TestCase {
	
	private EPackage testPackage;
	private EClass superFooClass;
	private EClass fooClass;		
	private EClass subFooClass;
	
	private OCLAnnotationSupport annotationSupport; 
	
	
	public TestOCLAnnotationSupport(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.annotationSupport = new OCLAnnotationSupport();
		
		testPackage = EcoreFactory.eINSTANCE.createEPackage();
		testPackage.setName("test"); //$NON-NLS-1$
		
		superFooClass = createClass("SuperFoo");
		fooClass = createClass("Foo", new EClass[] { superFooClass });		
		subFooClass = createClass("SubFoo", new EClass[] { fooClass });
	}
	
	public void testDirectlyInherited() throws Exception {
		EOperation superOperation = createOperation(fooClass, "oper", new EClassifier[0]); //$NON-NLS-1$
				
		EOperation resolvedOperation = annotationSupport.resolveDynamic(superOperation, newInstance(subFooClass));
		assertNotNull(resolvedOperation);
		
		resolvedOperation = annotationSupport.resolveDynamic(superOperation, newInstance(fooClass));
		assertNotNull(resolvedOperation);
		assertSame(superOperation, resolvedOperation);
		
		assertNull(annotationSupport.resolveDynamic(superOperation, newInstance(superFooClass))); //$NON-NLS-1$
		
		// test resolution from inheritance from next sibling super-type
		EClass siblingSuperClass = createClass("SiblingFoo"); //$NON-NLS-1$
		subFooClass.getESuperTypes().add(siblingSuperClass);
		EOperation siblingSuperOperation = createOperation(siblingSuperClass, "siblingOper", new EClassifier[0]); //$NON-NLS-1$

		EOperation resolvedSiblingSuperOperation = annotationSupport.resolveDynamic(siblingSuperOperation, newInstance(subFooClass));
		assertNotNull(resolvedSiblingSuperOperation);
		assertSame(siblingSuperOperation, resolvedSiblingSuperOperation);
	}
	
	public void testIndirectlyInherited() throws Exception {
		EOperation operation = createOperation(superFooClass, "oper", new EClassifier[0]); //$NON-NLS-1$
		
		EOperation subFooOperation = annotationSupport.resolveDynamic(operation, newInstance(subFooClass));
		assertNotNull(subFooOperation);
		assertSame(operation, subFooOperation);		
		
		EOperation fooOperation = annotationSupport.resolveDynamic(operation, newInstance(fooClass));
		assertNotNull(fooOperation);
		assertSame(operation, fooOperation);
		
		EOperation superFooOperation = annotationSupport.resolveDynamic(operation, newInstance(superFooClass));
		assertNotNull(superFooOperation);
		assertSame(operation, superFooOperation);
		
		// test resolution from inheritance from next sibling super-type
		EClass siblingSuperClass = createClass("SiblingSuperFoo"); //$NON-NLS-1$
		fooClass.getESuperTypes().add(siblingSuperClass);
		EOperation siblingSuperOperation = createOperation(siblingSuperClass, "siblingOper", new EClassifier[0]); //$NON-NLS-1$

		EOperation resolvedSiblingSuperOperation = annotationSupport.resolveDynamic(siblingSuperOperation, newInstance(subFooClass));
		assertNotNull(resolvedSiblingSuperOperation);
		assertSame(siblingSuperOperation, resolvedSiblingSuperOperation);
	}
	
	public void testOverrideInherited() throws Exception {  
		EOperation referencedSuperFooOperation = createOperation(superFooClass, "oper", new EClassifier[0]); //$NON-NLS-1$
		// override operation from Foo in SubFoo
		EOperation referencedFooOperation = createOperation(fooClass, "oper", new EClassifier[0]); //$NON-NLS-1$
			
		int count = 0;
		while(++count <= 2) {
			// Check repeatability due to caching
			EOperation resolvedFooOperation = annotationSupport.resolveDynamic(referencedSuperFooOperation, newInstance(subFooClass));
			assertNotNull(resolvedFooOperation);
			assertSame("SubFoo should resolve to Foo::oper", referencedFooOperation, resolvedFooOperation); //$NON-NLS-1$
			
			resolvedFooOperation = annotationSupport.resolveDynamic(referencedSuperFooOperation, newInstance(fooClass));
			assertNotNull(resolvedFooOperation);
			assertSame("Foo should resolve to Foo::oper", referencedFooOperation, resolvedFooOperation); //$NON-NLS-1$
			
			EOperation resolvedSuperFooOperation = annotationSupport.resolveDynamic(referencedSuperFooOperation, newInstance(superFooClass));
			assertNotNull(resolvedSuperFooOperation);
			assertSame("SuperFoo should resolve to SuperFoo::oper", referencedSuperFooOperation, resolvedSuperFooOperation); //$NON-NLS-1$
			
			// 
			resolvedFooOperation = annotationSupport.resolveDynamic(referencedFooOperation, newInstance(subFooClass));
			assertNotNull(resolvedFooOperation);
			assertSame("SubFoo should resolve to Foo::oper", referencedFooOperation, resolvedFooOperation); //$NON-NLS-1$		
			
			resolvedFooOperation = annotationSupport.resolveDynamic(referencedFooOperation, newInstance(fooClass));
			assertNotNull(resolvedFooOperation);
			assertSame("Foo should resolve to Foo::oper", referencedFooOperation, resolvedFooOperation); //$NON-NLS-1$
		}
	}
	
	public void testOperationMatch() throws Exception {
		// add confusing similar signature operations
		String sharedName = "oper"; //$NON-NLS-1$
		// create some operations for the same name to check exact matching
		createOperation(superFooClass, sharedName, new EClassifier[0]);
		createOperation(superFooClass, sharedName, new EClassifier[] { fooClass });		
		
		EOperation referencedSuperFooOperation = createOperation(superFooClass, sharedName, 
				new EClassifier[] { EcorePackage.eINSTANCE.getEString() });
		

		EOperation subFooOperation = annotationSupport.resolveDynamic(referencedSuperFooOperation, newInstance(subFooClass));
		assertNotNull(subFooOperation);
		assertSame("SubFoo should resolve to SuperFoo::oper", referencedSuperFooOperation, subFooOperation); //$NON-NLS-1$
	}
	
	
	
	private EClass createClass(String name) {
		return createClass(name, new EClass[0]);
	}
	
	private EClass createClass(String name, EClass[] superTypes) {
		EClass result = EcoreFactory.eINSTANCE.createEClass();
		result.setName(name);		
		result.getESuperTypes().addAll(Arrays.asList(superTypes));
		
		testPackage.getEClassifiers().add(result);
		return result;
	}
		
	private EOperation createOperation(EClass owner, String name, EClassifier[] paramTypes) {
		String paramNameBase = "par";		
		
		EOperation result = EcoreFactory.eINSTANCE.createEOperation();
		result.setName(name);		
		
		int pos = 1; 
		for (EClassifier nextParamType : paramTypes) {
			EParameter param = EcoreFactory.eINSTANCE.createEParameter();
			param.setName(paramNameBase + pos++);
			param.setEType(nextParamType);
		}
		
		owner.getEOperations().add(result);		
		return result;
	}
	
	private EObject newInstance(EClass eClass) {
		return testPackage.getEFactoryInstance().create(eClass);
	}
}
