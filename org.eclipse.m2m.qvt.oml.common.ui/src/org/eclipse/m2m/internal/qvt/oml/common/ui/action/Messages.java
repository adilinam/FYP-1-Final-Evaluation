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
package org.eclipse.m2m.internal.qvt.oml.common.ui.action;

import java.text.MessageFormat;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.common.ui.action.messages"; //$NON-NLS-1$

	public static String ActionDelegate_Failed;
	
	public static String format(String pattern, Object ... args) {
    	try {
    		return MessageFormat.format(pattern, args);
    	}
    	catch(RuntimeException e) {
    		return "!" + pattern + "!"; //$NON-NLS-1$ //$NON-NLS-2$
    	}
    }
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
