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
package org.eclipse.m2m.qvt.oml.tools.coverage.startup;

import java.util.Collections;
import java.util.Set;

import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchDelegate;
import org.eclipse.ui.IStartup;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}


	public static class LauncherDelegatesPreferenceInitializer implements IStartup {

		private static final String DEBUG_PLUGIN_ID = DebugPlugin.getUniqueIdentifier();

		private static final String LAUNCH_MODE = "run"; //$NON-NLS-1$
		private static final Set<String> LAUNCH_MODES = Collections.singleton(LAUNCH_MODE);

		private static final String QVTO_LAUNCH_CONFIGURATION_ID = "org.eclipse.m2m.qvt.oml.QvtTransformation"; //$NON-NLS-1$

		private static final String QVTO_PREFERRED_DELEGATE_KEY = DEBUG_PLUGIN_ID
				+ ".PREFERRED_DELEGATES/" + QVTO_LAUNCH_CONFIGURATION_ID; //$NON-NLS-1$
		private static final String QVTO_PREFERRED_DELEGATE_VALUE = QVTO_LAUNCH_CONFIGURATION_ID + ',' + LAUNCH_MODE + ",;"; //$NON-NLS-1$

		private static final String JUNIT_LAUNCH_CONFIGURATION_ID = "org.eclipse.jdt.junit.launchconfig"; //$NON-NLS-1$

		private static final String JUNIT_PREFERRED_DELEGATE_KEY = DEBUG_PLUGIN_ID
				+ ".PREFERRED_DELEGATES/" + JUNIT_LAUNCH_CONFIGURATION_ID; //$NON-NLS-1$
		private static final String JUNIT_PREFERRED_DELEGATE_VALUE = JUNIT_LAUNCH_CONFIGURATION_ID + ',' + LAUNCH_MODE + ",;"; //$NON-NLS-1$

		
		@Override
		public void earlyStartup() {
			IEclipsePreferences node = DefaultScope.INSTANCE.getNode(DEBUG_PLUGIN_ID);

			String preferredDelegate = node.get(QVTO_PREFERRED_DELEGATE_KEY, QVTO_PREFERRED_DELEGATE_VALUE);
			node.put(QVTO_PREFERRED_DELEGATE_KEY, preferredDelegate);

			preferredDelegate = node.get(JUNIT_PREFERRED_DELEGATE_KEY, JUNIT_PREFERRED_DELEGATE_VALUE);
			node.put(JUNIT_PREFERRED_DELEGATE_KEY, preferredDelegate);

			// Sometimes method LaunchConfigurationType.initializePreferredDelegates() is performed 
			// before this hook (IStartup.earlyStartup()).
			// This results in lack of preferred delegate for the given launch configuration type.
			// So here we perform the explicit initialization of preferred launch delegates.
			//
			try {
				ILaunchConfigurationType qvtLaunchConfigType = DebugPlugin.getDefault().getLaunchManager()
						.getLaunchConfigurationType(QVTO_LAUNCH_CONFIGURATION_ID);
				if (qvtLaunchConfigType.getPreferredDelegate(LAUNCH_MODES) == null) {
					for (ILaunchDelegate delegate : qvtLaunchConfigType.getDelegates(LAUNCH_MODES)) {
						if (QVTO_LAUNCH_CONFIGURATION_ID.equals(delegate.getId())) {
							qvtLaunchConfigType.setPreferredDelegate(LAUNCH_MODES, delegate);
						}
					}
				}
			} catch (Exception e) {
			}

			try {
				ILaunchConfigurationType junitLaunchConfigType = DebugPlugin.getDefault().getLaunchManager()
						.getLaunchConfigurationType(JUNIT_LAUNCH_CONFIGURATION_ID);
				if (junitLaunchConfigType.getPreferredDelegate(LAUNCH_MODES) == null) {
					for (ILaunchDelegate delegate : junitLaunchConfigType.getDelegates(LAUNCH_MODES)) {
						if (JUNIT_LAUNCH_CONFIGURATION_ID.equals(delegate.getId())) {
							junitLaunchConfigType.setPreferredDelegate(LAUNCH_MODES, delegate);
						}
					}
				}
			} catch (Exception e) {
			}

		}

	}
	
}
