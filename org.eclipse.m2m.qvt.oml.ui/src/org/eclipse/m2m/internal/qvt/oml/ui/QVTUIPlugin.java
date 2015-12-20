/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class QVTUIPlugin extends Plugin {

	// The plug-in NATURE_ID
	public static final String PLUGIN_ID = "org.eclipse.m2m.qvt.oml.ui"; //$NON-NLS-1$

	// The shared instance
	private static QVTUIPlugin plugin;
	
	/**
	 * The constructor
	 */
	public QVTUIPlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static QVTUIPlugin getDefault() {
		return plugin;
	}
	
    public static void log(Throwable e) {
        log(new Status(IStatus.ERROR, PLUGIN_ID, 0, "Unexpected error caught", e)); //$NON-NLS-1$
    }

	public static void log(IStatus status) {
        getDefault().getLog().log(status);
    }
	
	public static IStatus createStatus(int severity, String message, Throwable throwable) {
		return new Status(severity, PLUGIN_ID, message != null ? message : "", throwable); //$NON-NLS-1$
	}
	
	public static IStatus createStatus(int severity, String message, int code) {
		return new Status(severity, PLUGIN_ID, code, message != null ? message : "", null); //$NON-NLS-1$
	}
	
	public static IStatus createStatus(int severity, String message) {
		return createStatus(severity, message, null);
	}	
}
