/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Class that gives access to the action messages resource bundle.
 */
public class ActionMessages {

	private static final String BUNDLE_NAME= "org.eclipse.m2m.internal.qvt.oml.editor.ui.ActionMessages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE= ResourceBundle.getBundle(BUNDLE_NAME);

	private ActionMessages() {
		// no instance
	}

	/**
	 * Returns the resource string associated with the given key in the resource bundle. If there isn't 
	 * any value under the given key, the key is returned.
	 *
	 * @param key the resource key
	 * @return the string
	 */	
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	/**
	 * Returns the resource bundle managed by the receiver.
	 * 
	 * @return the resource bundle
	 */
	public static ResourceBundle getResourceBundle() {
		return RESOURCE_BUNDLE;
	}	
}
