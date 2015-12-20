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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.project.QVTOProjectPlugin;
import org.eclipse.m2m.internal.qvt.oml.project.nature.NatureUtils;
import org.eclipse.m2m.internal.qvt.oml.ui.IStatusChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PropertyPage;

public class QvtSettingsPropertyPage extends PropertyPage {
	
	private IProject fProject;
    private SourceContainerConfigBlock fSrcContainerBlock;

    
    public QvtSettingsPropertyPage() {
    	super();
    }
    
    @Override
	protected Control createContents(Composite parent) {        
        Control control = null;

        fProject = getSelectedProject();        
        if(fProject != null && isQvtProject(fProject)) {
            fSrcContainerBlock = new SourceContainerConfigBlock(getShell(), fProject, createStatusListener());
        	control = fSrcContainerBlock.createContents(parent);        	
        }
        else {
            control = createClosedControl(parent);
        }
		PlatformUI.getWorkbench().getHelpSystem().setHelp(control, 
			"org.eclipse.m2m.qvt.oml.transformation_project");  //$NON-NLS-1$
        return control;
    }
    

    @Override
	public boolean performOk() {
        performApply();
        return isValid();
    }

    @Override
	protected void performApply() {
    	fSrcContainerBlock.performApply();
    }

    @Override
	protected void performDefaults() {
    	fSrcContainerBlock.performDefaults();
    }
    
    private IStatusChangeListener createStatusListener() {
    	return new IStatusChangeListener() {
    		public void statusChanged(IStatus status) {
    			setMessage(null);
    			setErrorMessage(null);

    			setValid(fSrcContainerBlock.isValid());    			
    			if(!status.isOK()) {
    				setMessage(status.getMessage(), Util.getIMessageProviderSeverity(status));
    			}
    		}
    	};
    }
    
    private Control createClosedControl(Composite parent) {
        Label closedProjectLabel = new Label(parent, SWT.NONE);
        closedProjectLabel.setText(Messages.QvtSettingsPropertyPage_NoBuilder);
        return closedProjectLabel;
    }

    private IProject getSelectedProject() {
        Object element = getElement();
        if(element instanceof IProject) {
            IProject project = (IProject)element;            
            return isQvtProject(project) ? project : null; 
        } else if(element instanceof IAdaptable) {
        	IAdaptable adaptable = (IAdaptable) element;
            return (IProject)adaptable.getAdapter(IProject.class);
        }
        return null;
    }

    private static boolean isQvtProject(IProject project) {
        try {
            return project.isOpen() && NatureUtils.isBuilderEnabled(project, QVTOProjectPlugin.BUILDER_ID);
        } 
        catch (CoreException e) {
            Logger.getLogger().log(Logger.SEVERE, "Builder check failed", e); //$NON-NLS-1$
            return false;
        }
    }
}
