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
package org.eclipse.m2m.tests.qvt.oml.ocl2qvt;

import junit.framework.Test;
import junit.framework.TestSuite;

public class OCLEnvWithQVTTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for OCL environments with QVT access"); //$NON-NLS-1$
		
		//$JUnit-BEGIN$
		suite.addTestSuite(ExtOCLEnvironmentWithQVTAccessTest.class);
		suite.addTestSuite(OCLEnvironmentWithQVTAccessTest.class);
		suite.addTestSuite(OCLEnvironmentWithQVTAccessByURITest.class);
		suite.addTestSuite(OCLEnvironmentWithQVTAccessByURITest.DynamicPackageTest.class);
		suite.addTestSuite(OCLEnvWithQVTAccessDiagnosticTest.class);
		//$JUnit-END$
		return suite;
	}

}
