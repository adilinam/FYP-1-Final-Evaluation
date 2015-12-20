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

import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtInterruptedExecutionException;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;

public class TestBlackboxLibContext extends AbstractStackTraceTest {
	
	public TestBlackboxLibContext() {
		super(new FileToFileData("blackboxlib_context", //$NON-NLS-1$
				new String[][] {
				{"strTest", "test"},  //$NON-NLS-1$ //$NON-NLS-2$
				{"strTest2", "test2"},  //$NON-NLS-1$ //$NON-NLS-2$
				}
			));
	}
	
	public void testInvalidConfigProp() throws Exception {
		String testcase = "executionTerminated"; //$NON-NLS-1$
		QvtRuntimeException e = runQvtModuleTestCase(testcase, getData().getContext().getConfigProperties());						
		assertValidQVTRuntimeException(e);
		assertEquals(QvtInterruptedExecutionException.class, e.getClass());
		
		StringWriter strWriter = new StringWriter();
		e.printQvtStackTrace(new PrintWriter(strWriter));

		String dumpedContents = loadExpectedStackDump(testcase);
		assertEqualContents(dumpedContents.toString(), strWriter.getBuffer().toString());
		
		assertLogMatch(testcase);		
	}
	
}
