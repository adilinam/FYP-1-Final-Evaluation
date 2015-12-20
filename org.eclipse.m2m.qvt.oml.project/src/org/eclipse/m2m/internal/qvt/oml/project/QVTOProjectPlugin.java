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
package org.eclipse.m2m.internal.qvt.oml.project;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The main plug-in class to be used in the desktop.
 */
public class QVTOProjectPlugin extends Plugin {
	/**
	 * Plug-in NATURE_ID.
	 */
    public static final String ID = "org.eclipse.m2m.qvt.oml.project"; //$NON-NLS-1$
	
        
	public static final String NATURE_ID = "org.eclipse.m2m.qvt.oml.project.QVTONature";//$NON-NLS-1$
	
	public static final String BUILDER_ID = "org.eclipse.m2m.qvt.oml.project.QVTOBuilder";//$NON-NLS-1$
	
	public static final String PROBLEM_MARKER = "org.eclipse.m2m.qvt.oml.project.QVTOProblem"; //$NON-NLS-1$	
	
	
	//The shared instance.
	private static QVTOProjectPlugin plugin;

	/**
	 * The constructor.
	 */
	public QVTOProjectPlugin() {
		super();
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
	}

	/**
	 * Returns the shared instance.
	 */
	public static QVTOProjectPlugin getDefault() {
		return plugin;
	}
	
	public static void log(IStatus status) {
        getDefault().getLog().log(status);
    }
	
	public static void log(Throwable t) {
	    log(new Status(IStatus.ERROR, ID, 100001, "Unexpected error", t));//$NON-NLS-1$ 
	}

	public static IStatus createStatus(int severity, String message, Throwable throwable) {
		return new Status(severity, ID, message != null ? message : "", throwable); //$NON-NLS-1$
	} 
}
