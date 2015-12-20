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
package org.eclipse.m2m.internal.qvt.oml.emf.util;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class EmfUtilPlugin extends Plugin {

	//The shared instance.
	private static EmfUtilPlugin plugin;
	
	/**
	 * The constructor.
	 */
	public EmfUtilPlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static EmfUtilPlugin getDefault() {
		return plugin;
	}

    public static void log(Throwable e) {
        getDefault().getLog().log(new Status(IStatus.ERROR, ID, 0, "Unexpected error caught", e)); //$NON-NLS-1$
    }
	
	public static BasicDiagnostic createDiagnostic(String message) {
		return new BasicDiagnostic(Diagnostic.OK, ID, 0, message, null);
	}

	public static Diagnostic createErrorDiagnostic(String message, Throwable throwable) {
		Object[] data = (throwable == null) ? null : new Object [] { throwable };
		return new BasicDiagnostic(Diagnostic.ERROR, ID, 0, message, data);
	}
	
	public static Diagnostic createWarnDiagnostic(String message) {
		return new BasicDiagnostic(Diagnostic.ERROR, ID, 0, message, null);
	}	

	public static boolean isSuccess(Diagnostic diagnostic) {
		int severity = diagnostic.getSeverity();
		return severity == Diagnostic.OK || severity == Diagnostic.WARNING || severity == Diagnostic.INFO;
	}	
	
	public static final String ID = "org.eclipse.m2m.qvt.oml.emf.util"; //$NON-NLS-1$
}
