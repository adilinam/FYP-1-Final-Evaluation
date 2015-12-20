/*******************************************************************************
 * Copyright (c) 2008, 2012 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;

public class TestInvalidConfigProperty extends AbstractStackTraceTest {
	
	public TestInvalidConfigProperty() {
		super(new FileToFileData("invalidConfigProp")); //$NON-NLS-1$
	}
	
	public void testInvalidConfigProp() throws Exception {
		String testCase = "invalidConfigProp"; //$NON-NLS-1$
		
		Map<String, Object> configProps = new HashMap<String, Object>();
		configProps.put("intProp", "xxx"); //$NON-NLS-1$ //$NON-NLS-2$
		
		QvtRuntimeException e = runQvtModuleTestCase(testCase, configProps);
		
		assertValidQVTRuntimeException(e);
		
		StringWriter strWriter = new StringWriter();
		e.printQvtStackTrace(new PrintWriter(strWriter));

		String dumpedContents = loadExpectedStackDump("invalidIntConfigProp"); //$NON-NLS-1$
		assertEqualContents(dumpedContents.toString(), strWriter.getBuffer().toString());
	}
	
	public void testInvalidRealConfigProp() throws Exception {
		String testCase = "invalidConfigProp"; //$NON-NLS-1$
		
		Map<String, Object> configProps = new HashMap<String, Object>();
		configProps.put("realProp", "xxx"); //$NON-NLS-1$ //$NON-NLS-2$
		
		QvtRuntimeException e = runQvtModuleTestCase(testCase, configProps);
		
		assertValidQVTRuntimeException(e);
		
		StringWriter strWriter = new StringWriter();
		e.printQvtStackTrace(new PrintWriter(strWriter));

		String dumpedContents = loadExpectedStackDump("invalidRealConfigProp"); //$NON-NLS-1$
		assertEqualContents(dumpedContents.toString(), strWriter.getBuffer().toString());
	}
	
	public void testUndefinedConfigProp() throws Exception {
		String testCase = "invalidConfigProp"; //$NON-NLS-1$
		
		QvtRuntimeException e = runQvtModuleTestCase(testCase);
		assertNull(e);
	}	
}
