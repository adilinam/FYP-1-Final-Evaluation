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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.editor.ui.messages"; //$NON-NLS-1$

	//public static String QvtEditor_title;
	
	public static String QvtCompilerFacade_compilingDoc;
	
	public static String QvtCompilerFacade_acquiringDoc;
	
	public static String QvtAnnotationHover_multipleMarkers;

    public static String QvtReconcilingStrategy_TooManyExceptions;

	public static String OpenDeclarationAction_selectionDoesNotResolveToElement;

	public static String OverrideAnnotationText;	
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
