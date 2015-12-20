/*******************************************************************************
 * Copyright (c) 2008, 2015 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import org.eclipse.m2m.internal.qvt.oml.common.io.IOFile;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.qvt.oml.util.WriterLog;

public class TestFailedTransformation extends TestTransformation {

    public TestFailedTransformation(ModelTestData data) {
        super(data);
        setName(TestQvtInterpreter.PREFIX + data.getName());
    }
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		buildTestProject();
	}
    
    @Override
	public void runTest() throws Exception {
		runTransformation();
		assertLogMatch("qvtTraceLog.stack"); //$NON-NLS-1$
	}
	
	private QvtRuntimeException runTransformation() throws Exception {
        ITransformer transformer = TestQvtInterpreter.getDefaultTransformer(getData());
		try {
			Context context = (Context) getData().getContext();
			context.setLog(new WriterLog(myLogger));
			
			transformer.transform(
					getIFile(getData().getTransformation(getProject())),
					getData().getIn(getProject()), getData().getTrace(getProject()), context);
		} catch (QvtRuntimeException e) {
			return e;			
		}
		
		return null;
	}

	private void assertLogMatch(String testCase) throws Exception {
		String expectedContents = loadExpectedTraceLog(testCase);
		assertFalse("Non-empty trace expected", expectedContents.length() == 0); //$NON-NLS-1$
		
		String logContents = myLogger.getBuffer().toString();
		assertFalse("Non-empty trace expected", logContents.length() == 0); //$NON-NLS-1$
		
		assertEqualContents(expectedContents, logContents);
	}
	
	private String loadExpectedTraceLog(String fileName) throws IOException {
		File parentFolder = getData().getTransformation(getTestProject().getProject()).getParentFile();
		return MiscUtil.readStream(new IOFile(new File(parentFolder, fileName)));
	}
	
	private final StringWriter myLogger = new StringWriter();
}
