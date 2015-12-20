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
package org.eclipse.m2m.internal.qvt.oml.ui.wizards;

import org.eclipse.osgi.util.NLS;

class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.ui.wizards.messages"; //$NON-NLS-1$

	public static String AbstractNewQVTElementWizard_ProjectCreationFailed;

	public static String NewQvtLibraryWizard_newLibraryNameProposal;

	public static String NewQvtModuleCreationPage_browseButtonLabel;

	public static String NewQvtModuleCreationPage_defaultNamespaceLabel;

	public static String NewQvtModuleCreationPage_moduleAlreadyExists;

	public static String NewQvtModuleCreationPage_moduleNameFieldLabel;

	public static String NewQvtModuleCreationPage_namespaceFieldLabel;

	public static String NewQvtModuleCreationPage_newModuleNameProposal;

	public static String NewQvtModuleCreationPage_pathIsNotQVTContainer;

	public static String NewQvtModuleCreationPage_sourceContainerDoesNotExist;

	public static String NewQvtModuleCreationPage_sourceContainerFieldLabel;

	public static String NewQvtModuleCreationPage_sourceContainerPathMustBeSpecified;

	public static String NewQvtTransformationCreationPage_newModuleNameProposal;
	
	public static String NewQVTTransformationWizard_Title;	
	public static String NewQVTTransformationWizard_OpenEditorError;
	public static String NewQVTTransformationWizard_NewModuleFilePageTitle;
	public static String NewQVTTransformationWizard_NewModulePageDescription;
	public static String NewQVTTransformationWizard_WizardError;
		
	public static String NewQVTLibraryWizard_Title;

	public static String NewQvtLibraryWizard_NewModulePageTitle;	
	
	public static String NewQvtLibraryWizard_NewModulePageDescription;
			
	public static String Create_inplace_transformation;
	
	
	public static String SourceDestinationChooser_ChooseCUNamespaceFolder;

	public static String SourceDestinationChooser_ChooseSourceFolder;

	public static String SourceDestinationChooser_NamespaceSelectionTitle;

	public static String SourceDestinationChooser_NoNamespaceSelected;

	public static String SourceDestinationChooser_NoSourceContainerSelected;

	public static String SourceDestinationChooser_SourceContainerSelectionTitle;


	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
