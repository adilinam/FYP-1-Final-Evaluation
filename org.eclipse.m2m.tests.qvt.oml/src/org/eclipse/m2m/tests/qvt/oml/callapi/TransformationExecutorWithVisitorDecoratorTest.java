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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.eclipse.m2m.internal.qvt.oml.evaluator.InternalEvaluator;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QVTEvaluationOptions;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtGenericVisitorDecorator;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;

public class TransformationExecutorWithVisitorDecoratorTest extends TransformationExecutorTest {
	
	static String testBuffer = ""; //$NON-NLS-1$

	public static class TestQvtGenericVisitorDecorator extends QvtGenericVisitorDecorator {
		public TestQvtGenericVisitorDecorator(InternalEvaluator qvtExtVisitor) {
			super(qvtExtVisitor);
		}
		
		@Override
		public Object visitModule(Module module) {
			testBuffer += module.getName() + " "; //$NON-NLS-1$
			return super.visitModule(module);
		}
		
		@Override
		public Object visitHelper(Helper helper) {
			testBuffer += helper.getName() + " "; //$NON-NLS-1$
			return super.visitHelper(helper);
		}
	}
	
	
	public TransformationExecutorWithVisitorDecoratorTest() {
		super("bug416584", Arrays.asList("in.ecore"), Collections.<String>emptyList(), //$NON-NLS-1$ //$NON-NLS-2$
				new String[][] {
					new String[] { "libProp", "123" }, //$NON-NLS-1$ //$NON-NLS-2$
					new String[] { "prop", "prop" }, //$NON-NLS-1$ //$NON-NLS-2$
					new String[] { "prop2", "prop2" }, //$NON-NLS-1$ //$NON-NLS-2$
				});
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		
		testBuffer = ""; //$NON-NLS-1$
		
		ArrayList<Class<? extends QvtGenericVisitorDecorator>> decorators = new ArrayList<Class<? extends QvtGenericVisitorDecorator>>();
		decorators.add(TestQvtGenericVisitorDecorator.class);
		executionContext.getSessionData().setValue(QVTEvaluationOptions.VISITOR_DECORATORS, decorators);
	}
	
	@Override
	protected void runTest() throws Throwable {
		super.runTest();
		assertEquals(testBuffer, "T2 lib_helper lib_helper T3_helper T3_helper lib_helper "); //$NON-NLS-1$
	}
	
}
