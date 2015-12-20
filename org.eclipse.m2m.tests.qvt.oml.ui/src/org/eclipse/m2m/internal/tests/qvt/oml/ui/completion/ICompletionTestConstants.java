/*******************************************************************************
 * Copyright (c) 2007, 2012 Borland Software Corporation and others.
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

import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;

/**
 * @author vrepeshko
 */
public interface ICompletionTestConstants {
	public static final String COMPLETION_TEST_FOLDER = "completionTestData"; //$NON-NLS-1$
	
	public static final String COMPLETION_TEST_FOLDER_WITH_NS_URIS = "completionTestDataWithNsURIs"; //$NON-NLS-1$
	
	public static final String ANNOTATED_TRANSFORMATION_FILE = "t.a" + MDAConstants.QVTO_FILE_EXTENSION; //$NON-NLS-1$
	
	public static final String COMPLETION_ANNOTATION = "/*@*/"; //$NON-NLS-1$
	
	public static final String TRANSFORMATION_FILE = "t" + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT; //$NON-NLS-1$
	
	public static final String EXPECTED_PROPOSALS_FILE = "expected.txt";  //$NON-NLS-1$
	
	public static final String UPDATE_MARKER_FILE = "update";  //$NON-NLS-1$
	
	public static final int LINE_SEPARATOR_LENGTH = System.getProperty("line.separator").length();  //$NON-NLS-1$

	public static final String MODE_STRICT = ".strict";  //$NON-NLS-1$

	public static final String MODE_INCLUSIVE = ".inclusive";  //$NON-NLS-1$
}
