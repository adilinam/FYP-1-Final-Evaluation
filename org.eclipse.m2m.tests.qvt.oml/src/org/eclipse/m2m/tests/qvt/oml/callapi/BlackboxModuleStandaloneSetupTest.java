/*******************************************************************************
 * Copyright (c) 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Boyko Sergey - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.callapi;

import java.util.Collections;

import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.tests.qvt.oml.bbox.StandaloneBBoxModule2;

public class BlackboxModuleStandaloneSetupTest extends TransformationExecutorTest {
	
	public BlackboxModuleStandaloneSetupTest(String name) {
		super(name, Collections.<String>emptyList());
	}
	
	@Override
	protected void setUp() {
		TransformationExecutor.BlackboxRegistry.INSTANCE.registerModules(StandaloneBBoxModule2.class);
		super.setUp();
	}
	
	@Override
	protected void runTest() throws Throwable {
		super.runTest();
	}
	
}
