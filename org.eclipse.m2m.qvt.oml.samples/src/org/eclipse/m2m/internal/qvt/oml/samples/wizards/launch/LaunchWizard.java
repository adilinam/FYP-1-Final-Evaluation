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
package org.eclipse.m2m.internal.qvt.oml.samples.wizards.launch;

import java.text.MessageFormat;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.m2m.internal.qvt.oml.samples.QVTSamplesPlugin;
import org.eclipse.m2m.internal.qvt.oml.samples.ui.SampleProject;
import org.eclipse.m2m.internal.qvt.oml.samples.ui.wizard.SamplesWizard;
import org.eclipse.m2m.internal.qvt.oml.samples.ui.wizard.SamplesWizardPage;
import org.eclipse.m2m.internal.qvt.oml.samples.wizards.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class LaunchWizard extends SamplesWizard {
	
	private static final String DEFAULT_IMAGE_PATH = "icons/pr-MDA_wizard.gif"; //$NON-NLS-1$
	
	protected LaunchWizard(SampleProject[] projects) {
		super(projects);
		myProjects = projects;
		setDefaultPageImageDescriptor(QVTSamplesPlugin.getImageDescriptor(DEFAULT_IMAGE_PATH));
	}
	
	protected LaunchWizard(final SampleProject project) {
		this(new SampleProject[] {project});
	}
	
	protected void setLaunchData(String defaultName, ILaunchData launchData){
		myLaunch = new Launch(defaultName, launchData);
	}
	
	@Override
	public boolean performFinish() {
		if(!super.performFinish()){
			return false;
		}
		try {
			myLaunch.registerLaunchConfiguration(ResourcesPlugin.getWorkspace().getRoot().getProject(myProjects[0].getName()));
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	protected SamplesWizardPage createPage(SampleProject[] projects) {
		myLaunchPage = new PageWithLaunch(projects);
		return myLaunchPage;
	}
	
	protected SampleProject getProject(int index){
		return myProjects[index];
	}
	
	private PageWithLaunch myLaunchPage;
	private Launch myLaunch;
	private final SampleProject[] myProjects;

	private final class PageWithLaunch extends SamplesWizardPage {
		private Text myLaunchText;

		PageWithLaunch(SampleProject[] projects) {
			super(projects);
		}

		@Override
		protected boolean validatePage() {
		    boolean result = super.validatePage();
            if (!result) {
                return result;
            }
            
			String configName = myLaunchText.getText();			
			if(configName.trim().length() == 0){
				setErrorMessage(Messages.SamplesWizardPage_notLaunchName);
				return false;
			}
			try {
				if(DebugPlugin.getDefault().getLaunchManager().isExistingLaunchConfigurationName(configName)){
					setErrorMessage(MessageFormat.format(Messages.SamplesWizardPage_existingLaunch, configName)); 
					return false;
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
            return result;
		}

		@Override
		protected void doCreateContents(Composite parent) {
			super.doCreateContents(parent);
		    Label label = new Label(parent, SWT.NULL);
		    label.setText(Messages.SamplesWizardPage_LaunchConfiguration); 
		    myLaunchText = new Text(parent, SWT.BORDER | SWT.SINGLE);
			myLaunchText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		    myLaunchText.setText(myLaunch.getLaunchName());
	        ModifyListener modifyListener = new ModifyListener() {
	            public void modifyText(final ModifyEvent e) {
	                setPageComplete(validatePage());
	                myLaunch.setLaunchName(myLaunchText.getText());
	            }
	        };        
	        myLaunchText.addModifyListener(modifyListener);
		}
	}
    
}
