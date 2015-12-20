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
package org.eclipse.m2m.tests.qvt.oml.transform.api;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.tests.qvt.oml.AllTests;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;

/**
 * @author sboyko
 */
public class ExecDeployedTransformationTestCase extends ExecTransformationTestCase {
	
	private static final String TEST_PREFIX = "deployed_";	
	
	private static final String TEST_USEFILE_PREFIX = "file_deployed_";
	

	public static class UseFileName extends ExecDeployedTransformationTestCase {

		public UseFileName(ModelTestData data) {
			super(true, data);
			setName(TEST_USEFILE_PREFIX + getData().getName());			
		}

		public UseFileName(String testName) {
			super(extractTestDataName(testName, TEST_USEFILE_PREFIX));
			myUseFilename = true;
			setName(TEST_USEFILE_PREFIX + getData().getName());
		}
	}
	
    public ExecDeployedTransformationTestCase(String testName) {
		super(extractTestDataName(testName, TEST_PREFIX));
		myUseFilename = false;
		setName(TEST_PREFIX + getData().getName()); //$NON-NLS-1$		
	}
    
	public ExecDeployedTransformationTestCase(ModelTestData data) {
		this(false, data);
	}
	
	protected String getPrefix() {
		return TEST_PREFIX;
	}

	private ExecDeployedTransformationTestCase(boolean useFilename, ModelTestData data) {
        super(data);
        myUseFilename = useFilename;
        setName(TEST_PREFIX + data.getName()); //$NON-NLS-1$
    }
    
    @Override
	protected URI createScriptUri(String scriptName) {
    	if (myUseFilename) {
			return URI.createPlatformPluginURI("/" + AllTests.BUNDLE_ID + "/" + ROOT_DIR_NAME //$NON-NLS-1$ //$NON-NLS-2$
					+ "/" + scriptName + "/" + scriptName + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT, false); //$NON-NLS-1$ //$NON-NLS-2$
    	} 
    	
		return URI.createURI(ROOT_DIR_NAME + "." + scriptName + "." + scriptName, false); //$NON-NLS-1$ //$NON-NLS-2$
	}
    
    protected boolean myUseFilename;
}
