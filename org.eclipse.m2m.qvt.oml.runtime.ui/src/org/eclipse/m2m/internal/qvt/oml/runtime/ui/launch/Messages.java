/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
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

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch.messages"; //$NON-NLS-1$

	public static String ConfigurationErrorHandler_launchingError;

	public static String QvtLauncherTab_ModuleLabel;
	public static String QvtLauncherTab_MissingFileNameError;
	public static String QvtLauncherTab_FileDoesNotExist;
	public static String QvtLauncherTab_BrowseButtonLabel;
	public static String QvtLauncherTab_SourceModelURILabel;
	public static String QvtLauncherTab_SelectTransformation;
	public static String QvtLauncherTab_TraceFile;
	public static String QvtLauncherTab_ParametersLabel;
	public static String QvtLauncherTab_NoTransformationModule;
	public static String QvtLauncherTab_InvalidTransformationUri;
	public static String QvtLauncherTab_TransformationSelected;
	public static String QvtLauncherTab_ValidateModels;
	
	public static String QvtCompiledLaunchTab_SourceModelURI;
	public static String QvtCompiledLaunchTab_BrowseTitle;
	
	public static String QvtTransformationConfigurationTab_Name;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
