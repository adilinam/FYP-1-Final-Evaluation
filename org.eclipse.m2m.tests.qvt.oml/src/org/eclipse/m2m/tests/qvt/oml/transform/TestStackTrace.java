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
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.m2m.internal.qvt.oml.evaluator.QVTStackTraceElement;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtAssertionFailed;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtStackOverFlowError;

public class TestStackTrace extends AbstractStackTraceTest {
	
	public TestStackTrace() {
		super(new FileToFileData("stacktrace")); //$NON-NLS-1$
	}

	@Override
	public void setUp() throws Exception {
		if("testUknownSourceStackTrace".equals(getName())) { //$NON-NLS-1$
			// we need to compile concrete syntax which is instructed to skip line number info
			fUseCompiledXMI = false;
		}
		
		super.setUp();
	}
	
	public void testMappingCallInProperty() throws Exception {
		String testCase = "mappingCallInProperty"; //$NON-NLS-1$
		QvtRuntimeException e = runQvtModuleTestCase(testCase);
		assertValidQVTRuntimeException(e);

		
		StringWriter strWriter = new StringWriter();
		e.printQvtStackTrace(new PrintWriter(strWriter));
				
		String dumpedContents = loadExpectedStackDump(testCase);
		assertEqualContents(dumpedContents.toString(), strWriter.getBuffer().toString());
	}
	
	
	public void testLogExpUsage() throws Exception {
		String testcase = "testLogExpUsage"; //$NON-NLS-1$
		runQvtModuleTestCase(testcase);
		assertLogMatch(testcase);
	}
	
	public void testAssertionFailed() throws Exception {
		String testcase = "assertionFailed"; //$NON-NLS-1$
		QvtRuntimeException e = runQvtModuleTestCase(testcase);						
		assertValidQVTRuntimeException(e);
		assertEquals(QvtAssertionFailed.class, e.getClass());
		
		StringWriter strWriter = new StringWriter();
		e.printQvtStackTrace(new PrintWriter(strWriter));

		String dumpedContents = loadExpectedStackDump(testcase);
		assertEqualContents(dumpedContents.toString(), strWriter.getBuffer().toString());
		
		assertLogMatch(testcase);		
	}	
	
	public void testStackOverFlow() throws Exception {
		QvtRuntimeException e = runQvtModuleTestCase("stackOverFlow"); //$NON-NLS-1$
		
		assertValidQVTRuntimeException(e);
		assertEquals(QvtStackOverFlowError.class, e.getClass());
		if(e.getCause() != null) {
			// in case java VM provoked the stack over flow, check the
			// cause is appropriate exception
			assertEquals(StackOverflowError.class, e.getCause().getClass());
		} 
		
		int elementCount = 10;	
		for (QVTStackTraceElement element : e.getQvtStackTrace()) {
			if(--elementCount == 0) {
				break;
			}
			assertEquals("causeStackOverFlow", element.getOperationName()); //$NON-NLS-1$
			assertEquals("auxtransf", element.getModuleName()); //$NON-NLS-1$
			assertEquals("auxtransf.qvto", element.getUnitName()); //$NON-NLS-1$
			// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=449753
			assertTrue((5 == element.getLineNumber()) || (6 == element.getLineNumber()));			
		}
	}
	
	/*
	 * Just verifies a complete regular stack trace 
	 */
	public void testCreateInstaceFailure() throws Exception {
		String testCase = "createInstaceFailure"; //$NON-NLS-1$
		QvtRuntimeException e = runQvtModuleTestCase(testCase);
		assertValidQVTRuntimeException(e);

		
		StringWriter strWriter = new StringWriter();
		e.printQvtStackTrace(new PrintWriter(strWriter));
				
		String dumpedContents = loadExpectedStackDump(testCase);
		assertEqualContents(dumpedContents.toString(), strWriter.getBuffer().toString());		
	}

	public void testUknownSourceStackTrace() throws Exception {
		String testCase = "createInstaceFailure"; //$NON-NLS-1$
		
		fEnableLineNumbers = false;
		QvtRuntimeException e = runQvtModuleTestCase(testCase);
		assertValidQVTRuntimeException(e);

		StringWriter strWriter = new StringWriter();
		e.printQvtStackTrace(new PrintWriter(strWriter));

		String dumpedContents = loadExpectedStackDump("testUknownSourceStackTrace"); //$NON-NLS-1$
		assertEqualContents(dumpedContents, strWriter.getBuffer().toString());
	}
}
