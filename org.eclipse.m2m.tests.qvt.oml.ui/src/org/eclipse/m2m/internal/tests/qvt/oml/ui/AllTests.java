/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.tests.qvt.oml.ui;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.m2m.internal.tests.qvt.oml.debugger.DebuggerTests;
import org.eclipse.m2m.internal.tests.qvt.oml.ui.completion.CompletionTests;
import org.eclipse.m2m.internal.tests.qvt.oml.ui.editor.AllEditorTests;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

/**
 * @author sboyko
 */
public class AllTests {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AllTests.suite());
	}

	public static Test suite() {
		TestUtil.suppressGitPrefixPopUp();
		TestSuite suite = new TestSuite("Tests for org.eclipse.m2m.tests.qvt.oml.ui"); //$NON-NLS-1$
		//$JUnit-BEGIN$
        suite.addTest(CompletionTests.suite());
		suite.addTest(AllEditorTests.suite());
        suite.addTest(DebuggerTests.suite());
		//$JUnit-END$
		return suite;
	}
}
