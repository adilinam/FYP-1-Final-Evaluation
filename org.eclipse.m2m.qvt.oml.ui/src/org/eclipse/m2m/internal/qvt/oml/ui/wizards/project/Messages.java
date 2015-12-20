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
package org.eclipse.m2m.internal.qvt.oml.ui.wizards.project;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.ui.wizards.project.messages"; //$NON-NLS-1$
	
	public static String QvtMetamodelMappingPage_addBtnLabel;

	public static String QvtMetamodelMappingPage_addNewMappingTitle;

	public static String QvtMetamodelMappingPage_browseWorkspaceBtnLabel;

	public static String QvtMetamodelMappingPage_editBtnLabel;

	public static String QvtMetamodelMappingPage_editMappingTitle;

	public static String QvtMetamodelMappingPage_invalidItemsInMappingTable;

	public static String QvtMetamodelMappingPage_invalidModelURI;

	public static String QvtMetamodelMappingPage_loadIOError;

	public static String QvtMetamodelMappingPage_no_QVT_projectSelected;

	public static String QvtMetamodelMappingPage_noURISpecified;

	public static String QvtMetamodelMappingPage_platformResourceURIexpected;

	public static String QvtMetamodelMappingPage_removeAllBtnLabel;

	public static String QvtMetamodelMappingPage_removeBtnLabel;

	public static String QvtMetamodelMappingPage_saveIOError;

	public static String QvtMetamodelMappingPage_sourceURILabel;

	public static String QvtMetamodelMappingPage_targetURILabel;
	
	public static String QvtMetamodelMappingPage_loadResourceMetamodelError;

	public static String QvtMetamodelMappingPage_URIAlreadyMapped;	

	public static String QvtSettingsPropertyPage_NoBuilder;	
	public static String QvtSettingsPropertyPage_SourceContainerLabel;
	public static String QvtSettingsPropertyPage_ContainerDoesNotExist;
	public static String QvtSettingsPropertyPage_BrowseLabel;
	public static String QvtSettingsPropertyPage_SourceContainerSelection;
	public static String QvtSettingsPropertyPage_SelectSourceContainerFolder;
	public static String QvtSettingsPropertyPage_ContainerIsNotFolder;

	public static String SourceContainerConfigBlock_CreateSourceFolderOperation;

	public static String SourceContainerConfigBlock_loadBuilderConfigError;

	public static String SourceContainerConfigBlock_MoveExistingSources;

	public static String SourceContainerConfigBlock_saveBuilderConfigError;
	
	
	public static String SourceContainerUpdater_InvalidSourceFolder;

	public static String SourceContainerUpdater_NonBlankSourceFolderExpected;

	public static String SourceContainerUpdater_ProjectAsSourceFolderNotRecommened;

	public static String SourceContainerUpdater_RelativeSourceFolderExpected;

	public static String ConvertToMDAProjectWizard_Title;
	public static String ConvertionPage_Title;
	public static String ConvertionPage_Description;
	public static String ConvertionPage_ProjectsListTitle;
	public static String ConvertionPage_SelectAll;
	public static String ConvertionPage_DeselectAll;
	
	public static String ContentPage_pGroup;
	public static String ContentPage_pid;
	public static String ContentPage_pversion;
	public static String ContentPage_pname;
	public static String ContentPage_pprovider;
	public static String ProjectStructurePage_library;
	public static String ContentPage_pClassGroup;
	public static String ContentPage_generate;
	public static String ContentPage_classname;
	public static String ContentPage_plugin;
	public static String ContentPage_noLibrary;
	public static String ContentPage_noversion;
	public static String ContentPage_badversion;
	public static String ContentPage_noname;
	public static String ContentPage_noid;
	public static String ContentPage_invalidId;
	public static String ContentPage_title;
	public static String ContentPage_desc;
	
	public static String ProjectStructurePage_createProjectType;
	public static String ProjectStructurePage_createSimpleProject;
	public static String ProjectStructurePage_createSimplePluginProject;
	public static String ProjectStructurePage_createJavaPluginProject;
	public static String ProjectStructurePage_JavaProjectSettings;
	public static String ProjectStructurePage_source;
	public static String ProjectStructurePage_output;
	public static String NewProjectCreationOperation_createQVTProjectTask;

	public static String NewProjectCreationOperation_SetClassPathTask;

	public static String NewTransformationProjectWizard_Title;
	public static String NewTransformationProject_Title;
	public static String NewTransformationProject_Description;
	public static String NewQVTProjectCreationPage_defaultSourceFolder;

	public static String NewQVTProjectCreationPage_projectAlreadyExists;

	public static String NewQVTProjectCreationPage_SourceContainerLabel;

	public static String NewQVTProjectCreationPage_SourceContainerTooltip;

	public static String NewQVTProjectWizard_Error;
	public static String NewQVTProjectWizard_ErrorSeeLog;
	
	public static String WizardListSelectionPage_title;
	public static String WizardListSelectionPage_message;
	public static String WizardListSelectionPage_desc;
	public static String WizardListSelectionPage_label;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
