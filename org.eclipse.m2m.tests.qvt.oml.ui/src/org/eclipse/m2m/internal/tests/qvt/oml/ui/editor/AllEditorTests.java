/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.tests.qvt.oml.ui.editor;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllEditorTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.m2m.tests.qvt.oml.ui.editor"); //$NON-NLS-1$
		//$JUnit-BEGIN$
		suite.addTestSuite(TestQvtProblemAnnotations.class);
		suite.addTestSuite(TestSourceAnnotationReader.class);	
		suite.addTestSuite(TestEditorHyperLinks.class);
		//$JUnit-END$
		return suite;
	}

}
