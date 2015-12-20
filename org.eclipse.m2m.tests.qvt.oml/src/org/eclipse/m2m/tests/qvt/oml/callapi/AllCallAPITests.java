/*******************************************************************************
 * Copyright (c) 2009, 2015 Borland Software Corporation and others.
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

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllCallAPITests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.m2m.tests.qvt.oml.callapi"); //$NON-NLS-1$
		//$JUnit-BEGIN$
		suite.addTestSuite(BasicModelExtentTest.class);
		suite.addTestSuite(InvocationTest.class);
		suite.addTestSuite(InvocationExtTest.class);
		suite.addTestSuite(DynamicModelInvocationTest.class);
		suite.addTestSuite(DynamicRegisteredModelInvocationTest.class);
		suite.addTestSuite(ChildInTreeInputInvocationTest.class);
		suite.addTestSuite(Bug431055.class);
		suite.addTest(new TransformationExecutorWithVisitorDecoratorTest());
		suite.addTest(new IncrementalUpdateExecutorTest());
		suite.addTest(new BlackboxModuleStandaloneSetupTest("bug326871_standalone")); //$NON-NLS-1$
		suite.addTest(new BlackboxModuleStandaloneSetupTest("bug326871a_standalone")); //$NON-NLS-1$
		
		//$JUnit-END$
		return suite;
	}

}
