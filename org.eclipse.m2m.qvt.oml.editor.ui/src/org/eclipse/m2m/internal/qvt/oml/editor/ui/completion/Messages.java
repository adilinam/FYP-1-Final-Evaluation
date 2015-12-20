/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import org.eclipse.osgi.util.NLS;

/**
 * @author Aleksandr Igdalov
 * Created on Jul 4, 2007
 */

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.messages"; //$NON-NLS-1$
	public static String QvtCompletionData_ErrorPerformingCodeCompletion;
	public static String QvtCompletionProcessor_ErrorMessage;
	public static String QvtCompletionProcessor_PressCtrlSpace;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
