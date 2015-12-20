/*******************************************************************************
 * Copyright (c) 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Christopher Gerking - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.transform;

import org.eclipse.m2m.tests.qvt.oml.callapi.TestQvtStandaloneExecutor;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class StandaloneTests extends TestCase {

	public static Test suite() {
				
		TestSuite suite = new TestSuite("QVT standalone executor");
		//$JUnit-BEGIN$
		
		ModelTestData[] datas = TransformTests.createTestData();
		
		for (ModelTestData data : datas) {
			suite.addTest(new TestQvtStandaloneExecutor(data));
	    }
		
		//$JUnit-END$
		return suite;
	}
	
}
