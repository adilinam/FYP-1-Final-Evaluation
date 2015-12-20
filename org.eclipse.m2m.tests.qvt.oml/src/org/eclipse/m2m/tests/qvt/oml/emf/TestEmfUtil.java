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
package org.eclipse.m2m.tests.qvt.oml.emf;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;

import junit.framework.TestCase;

public class TestEmfUtil extends TestCase {

	EPackage package1;	
	EPackage package12;	
	EPackage package123;
	EClass typeC1InPackage123;	
	EClass typeC1InPackage12;	
	EClass typeC1InPackage1;	
	
	public TestEmfUtil(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		package123 = createEPakage(new String[] { "p1", "p2", "p3" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		package12 = package123.getESuperPackage();
		package1 = package12.getESuperPackage();
		
		typeC1InPackage123 = createEClass(package123, "C123"); //$NON-NLS-1$
		typeC1InPackage12 = createEClass(package12, "C12"); //$NON-NLS-1$		
		typeC1InPackage1 = createEClass(package1, "C1"); //$NON-NLS-1$		
	}

	public void testPackageQualifiedName() throws Exception {
		assertEquals("p1::p2::p3", EmfUtil.getFullName(package123)); //$NON-NLS-1$
		assertEquals("p1::p2", EmfUtil.getFullName(package12)); //$NON-NLS-1$
		assertEquals("p1", EmfUtil.getFullName(package1)); //$NON-NLS-1$
	}

	public void testPackageRelativeQualifiedName() throws Exception {
		assertEquals("p2::p3", EmfUtil.getFullNameRelativeToPackage(package123, package1)); //$NON-NLS-1$		
		assertEquals("p3", EmfUtil.getFullNameRelativeToPackage(package123, package12)); //$NON-NLS-1$		
		assertEquals("p1::p2::p3", EmfUtil.getFullNameRelativeToPackage(package123, package123)); //$NON-NLS-1$				
		assertEquals("p1", EmfUtil.getFullNameRelativeToPackage(package1, package1)); //$NON-NLS-1$
	}		
	
	public void testPackageRelativeQualifiedTypeName() throws Exception {
		assertEquals("p1::p2::p3::C123", EmfUtil.getFullName(typeC1InPackage123)); //$NON-NLS-1$
		
		assertEquals("C123", EmfUtil.getFullNameRelativeToPackage(typeC1InPackage123, package123)); //$NON-NLS-1$
		assertEquals("p3::C123", EmfUtil.getFullNameRelativeToPackage(typeC1InPackage123, package12)); //$NON-NLS-1$		
		assertEquals("p2::p3::C123", EmfUtil.getFullNameRelativeToPackage(typeC1InPackage123, package1)); //$NON-NLS-1$
		
		assertEquals("C12", EmfUtil.getFullNameRelativeToPackage(typeC1InPackage12, package12)); //$NON-NLS-1$		
	}
	
	public void testTypeQualifiedName() throws Exception {
		assertEquals("p1::p2::p3::C123", EmfUtil.getFullName(typeC1InPackage123)); //$NON-NLS-1$
		assertEquals("p1::p2::C12", EmfUtil.getFullName(typeC1InPackage12)); //$NON-NLS-1$		
		assertEquals("p1::C1", EmfUtil.getFullName(typeC1InPackage1)); //$NON-NLS-1$		
	}
		

	private static EClass createEClass(EPackage owningPackage, String typeName) {
		EClass eType = EcoreFactory.eINSTANCE.createEClass();
		eType.setName(typeName);

		owningPackage.getEClassifiers().add(eType);	
		return eType;
	}

	private static EPackage createEPakage(String[] path) {
		EPackage parent = null;		
		for (String name : path) {
			EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
			ePackage.setName(name);
			
			if(parent != null) {
				parent.getESubpackages().add(ePackage);
			} 
			parent = ePackage;
		}
		return parent;
	}
}
