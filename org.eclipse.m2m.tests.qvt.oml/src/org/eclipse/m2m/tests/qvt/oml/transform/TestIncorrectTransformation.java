/*******************************************************************************
 * Copyright (c) 2014 Borland Software Corporation and others.
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

import junit.framework.AssertionFailedError;

public class TestIncorrectTransformation extends TestQvtInterpreter {

	public TestIncorrectTransformation(ModelTestData data) {
		super(data);
	}
	
	@Override
	protected void onBuildFailed(Throwable e) {
		if (e instanceof AssertionFailedError) {
			// it's compilation error so skip it
			return;
		}
		
		super.onBuildFailed(e);
	}
	
	@Override
	public void runTest() throws Exception {
		// skip test execution since it's failed to build
	}

}
