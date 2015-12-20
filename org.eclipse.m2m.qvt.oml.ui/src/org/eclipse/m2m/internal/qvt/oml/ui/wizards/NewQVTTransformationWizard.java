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
import org.eclipse.m2m.internal.qvt.oml.QvtNamesChecker;
import org.eclipse.m2m.internal.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.m2m.internal.qvt.oml.ui.QvtPluginImages;


public class NewQVTTransformationWizard extends AbstractNewQVTElementWizard {
 
	private NewQvtTransformationCreationPage fNewQvtModulePage;
	private boolean fOpenInEditor = true;
	
	public NewQVTTransformationWizard() {
    	setWindowTitle(Messages.NewQVTTransformationWizard_Title);
    	
        ImageDescriptor desc = QvtPluginImages.getInstance().getImageDescriptor(QvtPluginImages.NEW_WIZARD);
        setDefaultPageImageDescriptor(desc);        
        setHelpAvailable(false);
    }
    
    protected NewQvtTransformationCreationPage createQvtTransformationCreationPage() {
    	if(getDestinationProvider() != null) {
    		return new NewQvtTransformationCreationPage(getDestinationProvider());
    	}
    	return new NewQvtTransformationCreationPage();
    }
    
    protected final NewQvtTransformationCreationPage getQvtTransformationCreationPage() {
    	return fNewQvtModulePage;
    }
    
    public void setOpenNewTransformationInEditor(boolean openFlag) {
    	fOpenInEditor = openFlag;
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
	public boolean doPerformFinish(IProgressMonitor monitor) {
        try {
        	String moduleName = fNewQvtModulePage.getModuleName(); 
        	assert QvtNamesChecker.validateQvtModuleIdentifier(moduleName).isOK();
        	
        	String contents = createTransformationContents(moduleName);
        	IFile transformationFile = fNewQvtModulePage.createNewFile(contents, monitor);            		
            
        	if(fOpenInEditor) {
        		NewQvtModuleCreationPage.openInEditor(getShell(), transformationFile);
        	}
            return true;
        } catch (Exception exception) {
            QVTUIPlugin.log(exception);
            return false;
        }
	}
	
	public IFile getNewTransformationFile() {
		if(fNewQvtModulePage != null) {
			return fNewQvtModulePage.getNewCreatedModuleFile();
		}
		return null;
	}
	
    protected String createTransformationContents(String moduleName) {
    	StringBuffer contents = new StringBuffer();
    	contents.append("transformation ").append(moduleName).append("();"); //$NON-NLS-1$ //$NON-NLS-2$
    	contents.append("\n\n"); //$NON-NLS-1$
    	contents.append("main() {\n\n}\n"); //$NON-NLS-1$    	    	

    	return contents.toString();
    }
	
	@Override
	public void addPages() {
		doAddPages();
	}

	protected void doAddPages() {
        fNewQvtModulePage = createQvtTransformationCreationPage();        
        fNewQvtModulePage.setTitle(Messages.NewQVTTransformationWizard_NewModuleFilePageTitle);
        fNewQvtModulePage.setDescription(Messages.NewQVTTransformationWizard_NewModulePageDescription);
        addPage(fNewQvtModulePage);

        setContentsCreated(true);        
    }
}
