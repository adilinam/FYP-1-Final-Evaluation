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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.internal.junit.JUnitCorePlugin;
import org.eclipse.jdt.junit.JUnitCore;
import org.eclipse.jdt.junit.launcher.JUnitLaunchConfigurationDelegate;
import org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.qvt.oml.tools.coverage.ui.CoveragePlugin;
import org.osgi.framework.Bundle;

@SuppressWarnings("restriction")
public class JUnitCoverageLaunchDelegate extends JUnitLaunchConfigurationDelegate {

    @Override
    public synchronized void launch(ILaunchConfiguration configuration, String mode, ILaunch launch,
            IProgressMonitor monitor) throws CoreException {

        // Add test listener
        JUnitCore.addTestRunListener(CoverageTestRunListener.INSTANCE);
        super.launch(configuration, mode, launch, monitor);
    }

    @Override
    public String verifyMainTypeName(ILaunchConfiguration configuration) throws CoreException {
        return CoveragePlugin.PLUGIN_ID + ".Shell"; //$NON-NLS-1$
    }

    @Override
    public String[] getClasspath(ILaunchConfiguration configuration) throws CoreException {
        String[] cp = super.getClasspath(configuration);

        String[] bundles = new String[] { CoveragePlugin.PLUGIN_ID, CoveragePlugin.UI_PLUGIN_ID, };

        List<String> classList = new ArrayList<String>(Arrays.asList(cp));

        try {
            for (int i = 0; i < bundles.length; i++) {
                Bundle bundle = JUnitCorePlugin.getDefault().getBundle(bundles[i]);
                URL url = bundle.getEntry("/");

                classList.add(0, FileLocator.toFileURL(url).getFile());

                // TODO Seems needed for runtime eclipse...
                classList.add(0, FileLocator.toFileURL(url).getFile() + "bin/");
            }

        } catch (IOException e) {
        	throw new CoreException(StatusUtil.makeErrorStatus(e.getMessage(), e));
        }

        return classList.toArray(new String[classList.size()]);
    }

}
