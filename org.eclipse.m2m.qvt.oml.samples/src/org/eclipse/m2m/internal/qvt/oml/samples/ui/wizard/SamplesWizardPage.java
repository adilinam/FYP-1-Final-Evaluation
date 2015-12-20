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
package org.eclipse.m2m.internal.qvt.oml.samples.ui.wizard;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.internal.qvt.oml.samples.ui.Messages;
import org.eclipse.m2m.internal.qvt.oml.samples.ui.SampleProject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class SamplesWizardPage extends WizardPage {
	public SamplesWizardPage(SampleProject[] projects) {
		super("wizardPage"); //$NON-NLS-1$
		if(projects.length == 0) {
			throw new IllegalArgumentException("No projects"); //$NON-NLS-1$
		}
		
		setTitle(Messages.SamplesWizardPage_title); 
		setDescription(Messages.SamplesWizardPage_desc); 
        myProjects = projects;
	}

	public void createControl(final Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		doCreateContents(container);
        setPageComplete(validatePage());
	}

	protected void doCreateContents(Composite container) {
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
        
        ModifyListener modifyListener = new ModifyListener() {
            public void modifyText(final ModifyEvent e) {
                setPageComplete(validatePage());
            }
        };        
        
        myNames = new Text[myProjects.length];
        for (int i = 0; i < myProjects.length; i++) {
			SampleProject project = myProjects[i];
			
            Label label = new Label(container, SWT.NULL);
            if (project.getLabel() != null) {
                label.setText(project.getLabel());
            } else {
                label.setText(NLS.bind(Messages.SamplesWizardPage_projectNameIndexed, new Integer(i+1))); 
            }
            
	        Text name = new Text(container, SWT.BORDER | SWT.SINGLE);
	        name.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	        name.setText(project.getName());
	        name.setSelection(name.getCharCount());
	        name.setData(project);
	        name.addModifyListener(modifyListener);
	        
	        myNames[i] = name;
        }
	}
    
    @Override
	public void setVisible(boolean visible) {
        super.setVisible(visible);
        if(visible && myNames != null) {
            myNames[0].setFocus();
        }
    }
    
    private boolean projectExists(final String projectName) {
        return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).exists();
    }
    
    private IStatus validateProjectName(String projectName) {
    	IPath projectPath = new Path(projectName).makeAbsolute();    	
    	IStatus status = ResourcesPlugin.getWorkspace().validatePath(projectPath.toString(), IResource.PROJECT);
    	return status;
    }

	protected boolean validatePage() {
        setMessage(null);
        setErrorMessage(null);
        
        for (int i = 0; i < myNames.length; i++) {
			Text name = myNames[i];
			IStatus projectPathStatus = validateProjectName(name.getText());
			if(projectPathStatus.getSeverity() == IStatus.ERROR) {
				setErrorMessage(projectPathStatus.getMessage());				
				return false;
			}
			else if (projectExists(name.getText())) {
	            setErrorMessage(NLS.bind(Messages.SamplesWizardPage_alreadyExists, name.getText()));
	            return false;
	        }
	        
	        myProjects[i].setName(name.getText());
        }
        
        return true;
	}

    private Text[] myNames;
    private final SampleProject[] myProjects;
}