/*****************************************************************************
 * Copyright (c) 2014,2015 ASML Netherlands B.V. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  ASML Netherlands B.V. - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.tools.coverage.ui.launching;

import org.eclipse.jdt.junit.JUnitCore;
import org.eclipse.jdt.junit.TestRunListener;
import org.eclipse.jdt.junit.model.ITestRunSession;
import org.eclipse.m2m.internal.qvt.oml.tools.coverage.common.CoverageData;
import org.eclipse.m2m.internal.qvt.oml.tools.coverage.common.CoverageDataPersistor;
import org.eclipse.m2m.qvt.oml.tools.coverage.ui.CoveragePlugin;

public class CoverageTestRunListener extends TestRunListener {

    public final static CoverageTestRunListener INSTANCE = new CoverageTestRunListener();

    @Override
    public void sessionFinished(ITestRunSession session) {
    	JUnitCore.removeTestRunListener(INSTANCE);

        // Show view
        CoverageData data = new CoverageDataPersistor().load();
        if (data != null) {
        	CoveragePlugin.getDefault().showCoverageView(data);
        }
    }
}
