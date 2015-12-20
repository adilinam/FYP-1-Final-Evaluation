/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.traces;

import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.tests.qvt.oml.transform.FileToFileData;
import org.eclipse.m2m.tests.qvt.oml.transform.TestQvtInterpreter;
import org.eclipse.m2m.tests.qvt.oml.transform.TestTransformation;



public class TestTraceFile extends TestTransformation {
	private final int myExpectedTraceSize;

	public TestTraceFile(String name, int expectedTraceSize) {
		super(new FileToFileData(name));
		myExpectedTraceSize = expectedTraceSize;
	}
	
    @Override
	public void runTest() throws Exception {
		check(TestQvtInterpreter.getDefaultTransformer(getData()));
    }
    
    @Override
    public void setUp() throws Exception {   
    	super.setUp();
    	buildTestProject();
    }

    private void check(ITransformer transformer) throws Exception {
        Trace trace = TraceUtil.transform(getData(), getProject(), transformer);
        assertTrue(trace.getTraceRecords().size() == myExpectedTraceSize);
	}
}
