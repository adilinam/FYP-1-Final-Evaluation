/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch;

import java.lang.reflect.Method;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;

/**
 * Maintain compatibility with Eclipse 3.4 by means of reflective invocation of v3.9 specific method. 
 *  
 */
class AbstractLaunchConfigurationTabCompatibility {

	/**
	 * <code>
	 * Class org.eclipse.debug.ui.AbstractLaunchConfigurationTab {
	 *   ..
	 *   protected void setWarningMessage(String warningMessage) {
	 *     fWarningMessage = warningMessage;
	 *   }
	 * </code>
	 * <p>
	 * Sets this page's warning message, possibly <code>null</code>.
	 * 
	 * @param warningMessage the warning message or <code>null</code>
	 * @since 3.9
	 */	
	private static Method ABSTRACT_LAUNCH_CONFIGURATION_TAB_SET_WARNING_METHOD = null;
	static {
		try {
			for (Method method : AbstractLaunchConfigurationTab.class.getDeclaredMethods()) {
				if ("setWarningMessage".equals(method.getName()) //$NON-NLS-1$ 
						&& (method.getParameterTypes().length == 1)
						&& (method.getParameterTypes()[0] == String.class)) {
					ABSTRACT_LAUNCH_CONFIGURATION_TAB_SET_WARNING_METHOD = method;
					ABSTRACT_LAUNCH_CONFIGURATION_TAB_SET_WARNING_METHOD.setAccessible(true);
					break;
				}
			}
		} catch (Throwable e) {
			ABSTRACT_LAUNCH_CONFIGURATION_TAB_SET_WARNING_METHOD = null;
		}
	}

	static boolean setWarningMessage(Object thisObj, String message) {
		if (ABSTRACT_LAUNCH_CONFIGURATION_TAB_SET_WARNING_METHOD != null) {
			try {
				ABSTRACT_LAUNCH_CONFIGURATION_TAB_SET_WARNING_METHOD.invoke(thisObj, new Object[] {message});
				return true;
			} catch (Throwable e) {
				// Not available in Juno
			}
		}
		return false;
	}
	
}
