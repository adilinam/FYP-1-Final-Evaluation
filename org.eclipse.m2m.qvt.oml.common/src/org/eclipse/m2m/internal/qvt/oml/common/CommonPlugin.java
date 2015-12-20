/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;


/**
 * The main plugin class to be used in the desktop.
 */
public class CommonPlugin extends Plugin {
	//The shared instance.
	private static CommonPlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	
	public static final String ID = "org.eclipse.m2m.qvt.oml.common";//$NON-NLS-1$
	/**
	 * The constructor.
	 */
	public CommonPlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("org.eclipse.m2m.internal.qvt.oml.common.common");//$NON-NLS-1$
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
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
	public static CommonPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = CommonPlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return "!" + key + "!";  //$NON-NLS-1$//$NON-NLS-2$
		}
	}
	
    public static String getResourceString(String key, Object [] substitutions) {
        String pattern = getResourceString(key);
        try {
            return MessageFormat.format(pattern, substitutions);
        }
        catch(Exception e) {
            return "!" + pattern + "!";  //$NON-NLS-1$//$NON-NLS-2$
        }
    }

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public static void log(IStatus status) {
        getDefault().getLog().log(status);
    }
    
    public static void log(Throwable e) {
        log(new Status(IStatus.ERROR, ID, 100001, "Caught exception", e)); //$NON-NLS-1$
    }
    
	public static IStatus createStatus(int severity, String message, Throwable throwable) {
		return new Status(severity, getDefault().getBundle().getSymbolicName(), message != null ? message : "", throwable); //$NON-NLS-1$
	}    
}
