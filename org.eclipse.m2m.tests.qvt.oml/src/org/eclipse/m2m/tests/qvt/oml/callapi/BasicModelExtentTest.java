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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;

import junit.framework.TestCase;

/**
 * @author dvorak
 *
 */
public class BasicModelExtentTest extends TestCase {

	private List<EPackage> fInContents;
	private EPackage fP1;
	private EPackage fP2;
	
	/**
	 * @param name
	 */
	public BasicModelExtentTest(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {	
		super.setUp();
		
		fInContents = new ArrayList<EPackage>();
		fP1 = EcoreFactory.eINSTANCE.createEPackage();
		fP2 = EcoreFactory.eINSTANCE.createEPackage();
		fInContents.add(fP1);
		fInContents.add(fP2);
	}
	
	public void testAddition() throws Exception {
		BasicModelExtent in = new BasicModelExtent();
		assertTrue(in.getContents().isEmpty());		
		in.add(fP1);
		assertTrue(in.getContents().contains(fP1));
		assertFalse(in.getContents().isEmpty());
	}
	
	public void testSet() throws Exception {
		BasicModelExtent in = new BasicModelExtent(fInContents);
		assertEquals(2, in.getContents().size());		
		assertTrue(in.getContents().contains(fP1));
		assertTrue(in.getContents().contains(fP2));
		
		in.setContents(Collections.<EPackage>emptyList());
		assertEquals(0, in.getContents().size());	

		in.setContents(fInContents);
		assertEquals(2, in.getContents().size());		
		assertTrue(in.getContents().contains(fP1));
		assertTrue(in.getContents().contains(fP2));
	}
	

}
