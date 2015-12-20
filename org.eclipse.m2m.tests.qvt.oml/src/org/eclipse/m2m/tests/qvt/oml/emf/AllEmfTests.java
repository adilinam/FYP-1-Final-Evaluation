/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
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

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllEmfTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.m2m.tests.qvt.oml.emf"); //$NON-NLS-1$
		//$JUnit-BEGIN$
		suite.addTestSuite(TestEmfUtil.class);
		//$JUnit-END$
		return suite;
	}

}
