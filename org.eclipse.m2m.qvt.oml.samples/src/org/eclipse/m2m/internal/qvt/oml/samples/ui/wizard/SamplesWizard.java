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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.m2m.internal.qvt.oml.samples.QVTSamplesPlugin;
import org.eclipse.m2m.internal.qvt.oml.samples.ui.Messages;
import org.eclipse.m2m.internal.qvt.oml.samples.ui.SampleProject;
import org.eclipse.m2m.internal.qvt.oml.samples.ui.SampleProjectsCreationOperation;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;


/**
 * New project wizard that creates new sample project using specified <code>SampleProject</code>
 */
public class SamplesWizard extends Wizard implements INewWizard, IExecutableExtension {
	public SamplesWizard(SampleProject project) {
		this(new SampleProject[] {project});
	}
	
	public SamplesWizard(SampleProject[] projects) {
        this();
        setProjects(projects);
	}

    public SamplesWizard() {
        setNeedsProgressMonitor(true);
    }

    public void setProject(SampleProject project) {
        setProjects(new SampleProject[] {project});
        
    }

	@Override
	public void addPages() {
/*
		if (!LicenseClient.isAvailable()) {
            return;
		}
*/		
		myPage = createPage(myProjects);
		addPage(myPage);
	}
	
	protected SamplesWizardPage createPage(SampleProject[] projects) {
		return new SamplesWizardPage(projects);
	}

    public void setInitializationData(IConfigurationElement config, String propertyName, Object data) {
    	myConfigElement = config;
	}
    
	@Override
	public boolean performFinish() {
/*
		if (!LicenseClient.isAvailable()) {
            return false;
		}
*/		
    	for(int i = 0; i < myProjects.length; i++) {
    		SampleProject project = myProjects[i];
    		try {
	            SampleProjectsCreationOperation op = new SampleProjectsCreationOperation(project, getShell());
	            getContainer().run(true, true, op);
                
                project.performActions(op.getCreatedProject());
                
	            String fileToOpen = project.getFileToOpen();
	            if (fileToOpen == null) {
	            	fileToOpen = README_TXT;
	            }
	            BasicNewProjectResourceWizard.updatePerspective(myConfigElement);
	            BasicNewResourceWizard.selectAndReveal(op.getCreatedProject(), myWorkbench.getActiveWorkbenchWindow());
	            IFile readme = op.getCreatedProject().getFile(fileToOpen);
	            if (readme.exists()) {
	            	try {
	            		IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), readme);
	            	} 
	            	catch (NullPointerException e) {
	            		// ignore
	            	}
	            }
        	}
	        catch (InterruptedException e) {
	        } 
	        catch(Exception e) {
	            Throwable t;
	            if(e instanceof InvocationTargetException) {
	                t = ((InvocationTargetException)e).getCause();
	            }
	            else {
	                t = e;
	            }
	            
	            
	            String logMessage = NLS.bind(Messages.SamplesWizard_LogMessage, project.getName(), t);
	            IStatus status = new Status(IStatus.ERROR, QVTSamplesPlugin.ID, 1, logMessage, e);
	            QVTSamplesPlugin.getDefault().getLog().log(status);
	            
	            String message = NLS.bind(Messages.SamplesWizard_ErrorMessage, project.getName());
	            String title = Messages.SamplesWizard_ErrorTitle; 
	            ErrorDialog.openError(getShell(), title, message, status);
	        }
    	}
        
        return true;
    }
	
	public void init(final IWorkbench workbench, final IStructuredSelection selection) {
		myWorkbench = workbench;
	}
    
    private SampleProject[] myProjects;
    private SamplesWizardPage myPage;
    private IConfigurationElement myConfigElement;
    private IWorkbench myWorkbench;
    
    private static final String README_TXT = "readme.txt"; //$NON-NLS-1$

    public void setProjects(SampleProject[] projects) {
        myProjects = projects;
    }
}