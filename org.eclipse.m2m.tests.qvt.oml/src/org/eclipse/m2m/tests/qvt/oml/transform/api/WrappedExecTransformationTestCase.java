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
package org.eclipse.m2m.tests.qvt.oml.transform.api;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.qvt.oml.runtime.util.QvtoTransformationValidator;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;

/**
 * @author sboyko
 */

public class WrappedExecTransformationTestCase extends ExecDeployedTransformationTestCase {
	
    public WrappedExecTransformationTestCase(String testName) {
		super(testName);
		myUseFilename = true;		
	}

	public WrappedExecTransformationTestCase(ModelTestData data) {
        super(data);
        myUseFilename = true;
    }
    
    @Override
    public void runTest() throws Exception {
    	boolean isFailed = false;
    	try {
    		super.runTest();
    	}
    	catch (Exception e) {
    		isFailed = e.getMessage().length() > 0;
    	}
    	assertTrue("Compilation errors should be reported", isFailed); //$NON-NLS-1$
    }
    
    @Override
    protected void validateScript(URI scriptUri) {
		Diagnostic validateQvtoScript = QvtoTransformationValidator.validateQvtoScript(scriptUri, null, null);
		assertTrue(validateQvtoScript.toString(), validateQvtoScript.getSeverity() == Diagnostic.ERROR);
    }
}
