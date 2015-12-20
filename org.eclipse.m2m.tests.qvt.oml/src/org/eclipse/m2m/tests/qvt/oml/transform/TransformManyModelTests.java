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
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.util.Arrays;
import java.util.Collections;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * @author sboyko
 */
public class TransformManyModelTests {
	public static Test suite() {
		return interpreterSuite();
	}
	
    public static TestSuite interpreterSuite() {
    	TestSuite suite = new TestSuite("QVT interpreter (many files)"); //$NON-NLS-1$

    	ModelTestData[] datas = createTestData();
    	
    	for (ModelTestData data : datas) {
            suite.addTest(new TestQvtInterpreter(data));
        }

        return suite;
    }
    
    public static ModelTestData[] createTestData() {
    	return new ModelTestData[] {
    	new FilesToFilesData("mm_modifyvar", Arrays.asList("in.ecore", "in2.ecore"), Arrays.asList("expected.ecore")), //$NON-NLS-1$
    	new FilesToFilesData("mm_header1", Arrays.asList("in.ecore"), Arrays.asList("expected.simpleuml", "expected.ecore")), //$NON-NLS-1$ //$NON-NLS-2$
    	new FilesToFilesData("mm_header2", Arrays.asList("in.ecore"), Arrays.asList("expected.uml", "expected.ecore")), //$NON-NLS-1$ //$NON-NLS-2$
    	new FilesToFilesData("mm_header3", Arrays.asList("in.ecore"), Arrays.asList("expected.simpleuml", "expected.rdb")), //$NON-NLS-1$ //$NON-NLS-2$
    	new FilesToFilesData("mm_header4", Arrays.asList("in1.ecore", "in2.ecore", "in3.ecore"), Arrays.asList("expected.simpleuml", "expected.rdb")), //$NON-NLS-1$ //$NON-NLS-2$
    	new FilesToFilesData("entryOp", Arrays.asList("in1.ecore", "in2.ecore", "in3.ecore"), Arrays.asList("expected.simpleuml", "expected.rdb")), //$NON-NLS-1$ //$NON-NLS-2$
    	new FilesToFilesData("importedExtents", Collections.<String>emptyList(), Arrays.asList("expected.ecore")), //$NON-NLS-1$ //$NON-NLS-2$
    	};
    }
    
}
