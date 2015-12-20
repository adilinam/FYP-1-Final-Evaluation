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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.m2m.internal.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.m2m.internal.qvt.oml.ui.QvtPluginImages;
import org.eclipse.m2m.internal.qvt.oml.ui.wizards.project.INewQVTElementDestinationWizardDelegate;


public class NewQvtLibraryWizard extends AbstractNewQVTElementWizard {

	private NewQvtModuleCreationPage fNewQvtModuleCreationPage;
    
	public NewQvtLibraryWizard() {
    	setWindowTitle(Messages.NewQVTLibraryWizard_Title);    	
        ImageDescriptor desc = QvtPluginImages.getInstance().getImageDescriptor(QvtPluginImages.NEW_WIZARD);
        setDefaultPageImageDescriptor(desc);        
    }
    
	protected NewQvtModuleCreationPage createNewQvtLibraryCreationPage() {
    	if(getDestinationProvider() != null) {
    		return new NewQvtLibraryPage(getDestinationProvider());
    	}
    	return new NewQvtLibraryPage();
    }
        
    protected final NewQvtModuleCreationPage getNewQvtLibraryCreationPage() {    	
		return fNewQvtModuleCreationPage;
	}
    
    protected String createModuleContents() {
        String moduleName = fNewQvtModuleCreationPage.getModuleName(); 
        String contents = "library " + moduleName + ";\n";  //$NON-NLS-1$//$NON-NLS-2$        

        return contents.toString();
    }
    
	protected void doAddPages() {
        fNewQvtModuleCreationPage = createNewQvtLibraryCreationPage();
        
        fNewQvtModuleCreationPage.setTitle(Messages.NewQvtLibraryWizard_NewModulePageTitle);
        fNewQvtModuleCreationPage.setDescription(Messages.NewQvtLibraryWizard_NewModulePageDescription);
        addPage(fNewQvtModuleCreationPage);
        
        setContentsCreated(true);
    }    
    	
	@Override
	public boolean doPerformFinish(IProgressMonitor monitor) {
        try {
            IFile transformationFile = fNewQvtModuleCreationPage.createNewFile(createModuleContents(), monitor);            
            NewQvtModuleCreationPage.openInEditor(getShell(), transformationFile);
            return true;
        } 
        catch (Exception exception) {
            QVTUIPlugin.log(exception);
            return false;
        }
	}
	
    @Override
    public boolean canFinish() {
        IWizardPage[] pages = getPages();
        for (int i = 0; i < pages.length; i++) {
            if (!pages[i].isPageComplete()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addPages() {    
    	doAddPages();
    }
    

    private static final class NewQvtLibraryPage extends NewQvtModuleCreationPage {
		NewQvtLibraryPage() {
			super();
		}

		NewQvtLibraryPage(INewQVTElementDestinationWizardDelegate destinationProvider) {
			super(destinationProvider);
		}

		@Override
		protected String getNewModuleNameProposal() {    
			return Messages.NewQvtLibraryWizard_newLibraryNameProposal;
		}
	}	
}
