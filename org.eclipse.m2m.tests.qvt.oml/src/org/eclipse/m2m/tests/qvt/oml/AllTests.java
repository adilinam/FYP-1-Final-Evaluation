/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
/*
 * Created on Feb 7, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.eclipse.m2m.tests.qvt.oml;

import org.eclipse.m2m.tests.qvt.oml.ant.QvtAntScriptTests;
import org.eclipse.m2m.tests.qvt.oml.callapi.AllCallAPITests;
import org.eclipse.m2m.tests.qvt.oml.callapi.SourceContainerTests;
import org.eclipse.m2m.tests.qvt.oml.compile.AllCompileTests;
import org.eclipse.m2m.tests.qvt.oml.emf.AllEmfTests;
import org.eclipse.m2m.tests.qvt.oml.env.QVTOperationalEnvTest;
import org.eclipse.m2m.tests.qvt.oml.ocl2qvt.OCLEnvWithQVTTests;
import org.eclipse.m2m.tests.qvt.oml.perf.ExecutionTimeGuardTest;
import org.eclipse.m2m.tests.qvt.oml.transform.TraceTests;
import org.eclipse.m2m.tests.qvt.oml.transform.TransformManyModelTests;
import org.eclipse.m2m.tests.qvt.oml.transform.TransformTests;
import org.eclipse.m2m.tests.qvt.oml.transform.api.QvtoTransfHelperTests;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * @author vrepeshko
 * 
 */
public class AllTests {

	public static final String BUNDLE_ID = "org.eclipse.m2m.tests.qvt.oml"; //$NON-NLS-1$
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(AllTests.suite());
	}

	public static Test suite() {
		TestUtil.suppressGitPrefixPopUp();
		TestSuite suite = new TestSuite("Tests for " + BUNDLE_ID); //$NON-NLS-1$
		//$JUnit-BEGIN$
		suite.addTestSuite(IntermediatePropertyCleanupTest.class);
		suite.addTest(AllCompileTests.suite());
		suite.addTest(AllCallAPITests.suite());
				
		suite.addTestSuite(QVTOperationalEnvTest.class);
		
		suite.addTest(OCLEnvWithQVTTests.suite());
		
		suite.addTestSuite(TestExternHelperCall.class);
		suite.addTest(AllEmfTests.suite());
		suite.addTestSuite(TestMetamodelRegistry.class);
        suite.addTestSuite(TestLaunchConfiguration.class);
        suite.addTest(ParserTests.suite());

        suite.addTest(TransformTests.interpreterSuite());
        suite.addTest(TransformTests.javalessSuite());
        suite.addTest(TransformTests.walkerSuite());
        suite.addTest(TransformTests.executorSuite());
        suite.addTest(TransformTests.debugExecutorSuite());
        suite.addTest(TransformManyModelTests.interpreterSuite());
        suite.addTest(QvtoTransfHelperTests.suite());
        
        suite.addTestSuite(TestQvtBuilder.class);        
        suite.addTestSuite(TestSamples.class);
        suite.addTestSuite(TestGraphWalker.class);
        suite.addTest(TraceTests.suite());
        suite.addTest(TestQvtResourceFactory.suite());
        
        suite.addTestSuite(TestOCLSemantics.class);
        suite.addTestSuite(TestOCLAnnotationSupport.class);     
                
        suite.addTest(QvtAntScriptTests.suite());
        suite.addTest(SourceContainerTests.suite());
        
		suite.addTestSuite(ExecutionTimeGuardTest.class);

		//$JUnit-END$
		return suite;
	}
}
