/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.ant;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.runtime.ui.ant.messages"; //$NON-NLS-1$

	public static String AntTaskWizard_windowTitle;

	public static String LaunchConfigError_msg;

	public static String LaunchConfigError_title;

	public static String SourceTypePage_title;
	public static String SourceTypePage_descr;
	public static String SourceTypePage_opt1;
	public static String SourceTypePage_opt2;

	public static String SourcePage_title1;
	public static String SourcePage_descr1;
	public static String SourcePage_configBtn;

	public static String ResultPage_title;
	public static String ResultPage_descr;

	public static String TransformWizard_windowTitle;
	public static String TransformFilePage_title;

	public static String TransformPage_title;
	public static String TransformPage_descr;
	public static String TransformPage_task;
	public static String TransformPage_project;

	public static String Name;
	public static String Value;
	public static String Add;
	public static String Delete;
	public static String Up;
	public static String Down;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
