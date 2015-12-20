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
package org.eclipse.m2m.internal.tests.qvt.oml.ui.completion;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;


/**
 * @author vrepeshko
 */
public class CompletionTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Operational QVT code completion"); //$NON-NLS-1$
		try {
			TestSuite generalSuite = new TestSuite("general"); //$NON-NLS-1$
			TestSuite detachedSuite = new TestSuite("detached"); //$NON-NLS-1$
			
			loadTestCases(generalSuite, detachedSuite, TestUtil.getPluginRelativeFile(CompletionTest.BUNDLE, ICompletionTestConstants.COMPLETION_TEST_FOLDER));
			
			suite.addTest(generalSuite);
			suite.addTest(detachedSuite);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return suite;
	}
	
	private static void loadTestCases(final TestSuite generalSuite, final TestSuite detachedSuite, final File folder) {
		File[] contents = folder.listFiles();
		for (int i = 0; i < contents.length; i++) {
			if (isCompletionTestFolder(contents[i])) {
				String testName = contents[i].getName();
				if (ourDetachedTests.contains(testName)) {
					detachedSuite.addTest(new DetachedCompletionTest(testName));
				}
				else {
					generalSuite.addTest(new CompletionTest(testName));
				}
			}
		}
	}
	
	private static boolean isCompletionTestFolder(final File file) {
		if (file.isDirectory()) {
			List<String> list = Arrays.asList(file.list());
			return list.contains(ICompletionTestConstants.ANNOTATED_TRANSFORMATION_FILE); 
		}
		return false;
	}
	
	private static final Set<String> ourDetachedTests = new HashSet<String>(Arrays.asList(
			"bugzilla1978", //$NON-NLS-1$
			"mixedImportItems" //$NON-NLS-1$
			));

}
