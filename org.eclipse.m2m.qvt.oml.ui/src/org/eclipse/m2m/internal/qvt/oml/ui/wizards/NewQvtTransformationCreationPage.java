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
package org.eclipse.m2m.internal.qvt.oml.ui.wizards;

import org.eclipse.m2m.internal.qvt.oml.ui.wizards.project.INewQVTElementDestinationWizardDelegate;

/**
 * @author dvorak
 */
public class NewQvtTransformationCreationPage extends NewQvtModuleCreationPage {
	

	protected NewQvtTransformationCreationPage() {
		super();
	}	
	
	protected NewQvtTransformationCreationPage(INewQVTElementDestinationWizardDelegate destinationProvider) {
		super(destinationProvider);
	}

    @Override
    protected String getNewModuleNameProposal() {    
    	return Messages.NewQvtTransformationCreationPage_newModuleNameProposal;
    }
}
