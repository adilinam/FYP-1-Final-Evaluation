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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers;

import java.text.MessageFormat;

import org.eclipse.osgi.util.NLS;

public class Messages {
	private Messages() {
	}

	public static String ResourceDestinationChooser_0;

	public static String ResourceSaver_UriNotFile;
	public static String ResourceSaver_UriCorrupted;

	public static String EObjectResourceChooser_0;

	public static String format(String pattern, Object... args) {
		try {
			return MessageFormat.format(pattern, args);
		} catch (Exception e) {
			return "!" + pattern + "!"; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.messages"; //$NON-NLS-1$
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
