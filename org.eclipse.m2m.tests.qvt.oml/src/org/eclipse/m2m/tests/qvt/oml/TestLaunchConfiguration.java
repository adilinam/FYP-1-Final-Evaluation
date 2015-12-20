/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegate;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;

import junit.framework.TestCase;

public class TestLaunchConfiguration extends TestCase {
    
    private static final String IN_ECORE = "platform:/resource/porject/in.ecore"; //$NON-NLS-1$
    private static final String INOUT_ECORE = "platform:/resource/porject/inout.ecore"; //$NON-NLS-1$
    private static final String OUT_ECORE_NEW = "platform:/resource/porject/out.ecore"; //$NON-NLS-1$
    private static final String OUT_ECORE_EXISTING = "platform:/resource/project/out.ecore#//@eClassifiers.0"; //$NON-NLS-1$
    
    public static final TestLaunchConfiguration TEST = new TestLaunchConfiguration();
    
    public TestLaunchConfiguration() {
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testEmptyEmpty() throws Throwable {
        performTest("", "", TargetType.NEW_MODEL);  //$NON-NLS-1$//$NON-NLS-2$
    }

    public void testEcoreNew() throws Throwable {
        performTest(IN_ECORE, OUT_ECORE_NEW, TargetType.NEW_MODEL);
    }

    public void testEcoreInplace() throws CoreException {
        performTest(INOUT_ECORE, "", TargetType.NEW_MODEL); //$NON-NLS-1$
    }

    public void testEcoreExsisting() throws CoreException {
        performTest(IN_ECORE, OUT_ECORE_EXISTING, TargetType.NEW_MODEL);
    }

    private void performTest(String in, String out, TargetType targetType) throws CoreException {
        ILaunchConfigurationType type = DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurationType(QvtLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE_ID);
        ILaunchConfigurationWorkingCopy copy = type.newInstance(null, "testOne"); //$NON-NLS-1$
        copy.setAttribute(IQvtLaunchConstants.ELEM_COUNT, 2);
        copy.setAttribute(IQvtLaunchConstants.TARGET_MODEL+"1", in); //$NON-NLS-1$
        copy.setAttribute(IQvtLaunchConstants.TARGET_MODEL+"2", out); //$NON-NLS-1$
        TargetUriData targetUriData = QvtLaunchUtil.getTargetUriData(copy.doSave(), 1);
        assertEquals(targetUriData.getTargetType().toString(), targetUriData.getTargetType(), targetType);
    }
}
