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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.messages"; //$NON-NLS-1$
		
	public static String ApplyWizard_FailedToApply;
	public static String ApplyWizard_Error;
	public static String ApplyWizard_ShowResultError;
	
	public static String ApplyToWizard_InputNotSupported;
	public static String ApplyToWizard_FailedToGetTransformationOutput;
	public static String ApplyToWizard_NoSource;
	
	public static String ApplyTransformationWizard_SetupConfigProperty;	
	public static String ApplyTransformationWizard_ConfigProperties;
	public static String ApplyTransformationWizard_Title;	
	public static String ApplyTransformationWizard_ApplyTransformationSelectPageTitle;
	public static String ApplyTransformationWizard_ProjectNotBuilt;
	public static String ApplyTransformationWizard_QVTErrors;
	public static String ApplyTransformationWizard_ApplyTransformationFinalPageTitle;	
	public static String ApplyTransformationWizard_ApplyTransformationFinalPageDesc;
	public static String ApplyTransformationWizard_TransfromationsListTitle;
	
	public static String ApplyTransformationFinalPage_OpenEditor;
	public static String ApplyTransformationFinalPage_NoTransformation;
	
	public static String ApplyCompiledTransformationWizard_Title;
	public static String ApplyCompiledTransformationWizard_Description;
	
	public static String SelectQvtProjectTransformationPage_Title;
	public static String SelectQvtProjectTransformationPage_RunInterpretedMode;
	public static String SelectQvtProjectTransformationPage_Description;

    public static String SelectWorkspaceTransformationPage_Title;
    public static String SelectWorkspaceTransformationPage_Description;
    
    public static String TransformationParametersPage_Title;
    public static String TransformationParametersPage_TitleWithTransf;
    public static String TransformationParametersPage_Description;
    
    public static String LaunchWorkspaceTransformationWizard_Title;
    public static String LaunchWorkspaceTransformationWizard_runningTransformation;
    public static String LaunchWorkspaceTransformationWizard_FailedToLaunch;
    public static String LaunchWorkspaceTransformationWizard_Error;
    public static String LaunchWorkspaceTransformationWizard_ShowResultError;
    public static String LaunchWorkspaceTransformationWizard_launchConfigName;
    
    public static String RunInterpretedTransformationAction_title;
    public static String RunInterpretedTransformationAction_message;
    
    public static String TransformationWizardUtil_savingTransformationResults;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
