/*******************************************************************************
 * Copyright (c) 2008, 2009 Borland Software Corporation and others.
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

import org.eclipse.m2m.tests.qvt.oml.traces.TestTraceFile;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author aigdalov
 * Created on Mar 3, 2009
 */
public class TraceTests {
    public static Test suite() {
        TestSuite suite = new TestSuite("QVT traces"); //$NON-NLS-1$

        suite.addTest(new TestTraceFile("multipletracerecords", 5)); //$NON-NLS-1$
        suite.addTest(new TestTraceFile("mappingWithNoResultTrace_266854", 1)); //$NON-NLS-1$

        return suite;
    }

}
