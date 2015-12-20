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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.project.builder.QVTOBuilderConfig;
import org.eclipse.m2m.internal.qvt.oml.ui.IStatusChangeListener;
import org.eclipse.m2m.internal.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ide.undo.CreateFolderOperation;

class SourceContainerConfigBlock {
	
    private QVTOBuilderConfig fBuilderConfig;

	private IProject fProject;	
    private IContainer fSourceContainer;    
    private IStatus fStatus;    
    private IStatusChangeListener fStatusListener; 

    private Shell fShell;
    private Button fBrowseButton;
    private Button fMoveExistingButton;
    private Text fSourceField;
    private Label fSourceContainerLabel;
    
    
    public SourceContainerConfigBlock(Shell shell, IProject project, IStatusChangeListener statusChangeListener) {
    	if(shell == null || project == null || statusChangeListener == null) {
    		throw new IllegalArgumentException();
    	}
    	
    	this.fShell = shell;
    	this.fStatus = Status.OK_STATUS;
    	this.fProject = project;
    	this.fStatusListener = statusChangeListener;
    	
        if(fProject.exists()) {
        	loadBuilderConfig();
        }
    }
    
    public IContainer getSourceContainer() {
		return fSourceContainer;
	}
    
	public Control createContents(Composite parent) {
                        
        return createControl(parent);
    }
    

    protected Composite createControl(Composite parent) {
        Composite containerGroup = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        containerGroup.setLayout(layout);
        containerGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));

        fSourceContainerLabel = new Label(containerGroup, SWT.CHECK);
        fSourceContainerLabel.setText(Messages.QvtSettingsPropertyPage_SourceContainerLabel);        
        GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
        data.horizontalSpan = 2;
        fSourceContainerLabel.setLayoutData(data);

        fSourceField = new Text(containerGroup, SWT.BORDER);
        fSourceField.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
        IContainer container = (fBuilderConfig != null) ? fBuilderConfig.getSourceContainer() : fProject;
        
        fSourceField.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                updateStatus();
                fStatusListener.statusChanged(fStatus);
                if(fMoveExistingButton != null) {
                	fMoveExistingButton.setEnabled(isContainerChanged());
                }
            }
        });
        
        // Note: this line is must be placed after listener is added 
        fSourceField.setText(getContainerPathString(container));        

        if(fProject.exists()) {
	        fBrowseButton = new Button(containerGroup, SWT.PUSH);
	        fBrowseButton.setText(Messages.QvtSettingsPropertyPage_BrowseLabel);
	        fBrowseButton.setLayoutData(new GridData(GridData.BEGINNING));
	
	        fBrowseButton.addSelectionListener(new SelectionAdapter() {
	            @Override
				public void widgetSelected(SelectionEvent e) {
	                IContainer container = chooseOutputLocation();
	                if(container != null) {
	                    fSourceField.setText(getContainerPathString(container));
	                }
	            }
	        });
	        
	        fMoveExistingButton = new Button(parent, SWT.CHECK);
	        fMoveExistingButton.setText(Messages.SourceContainerConfigBlock_MoveExistingSources);
	        fMoveExistingButton.setEnabled(false);	        
        }
        
        return containerGroup;
    }

    public boolean isValid() {
    	return !fStatus.matches(IStatus.ERROR);
    }
    
	public boolean performApply() {
		if(!fProject.exists()) {
			throw new IllegalStateException("Containing project must exist"); //$NON-NLS-1$
		}
		
		if(fSourceContainer == null) {
			IFolder folderToCreate = fProject.getFolder(new Path(fSourceField.getText()));
			CreateFolderOperation createFolderOperation = new CreateFolderOperation(folderToCreate, null, Messages.SourceContainerConfigBlock_CreateSourceFolderOperation);
			try {			
				if(createFolderOperation.execute(null, null).isOK()) {
					fSourceContainer = folderToCreate;
				}
			} catch (ExecutionException e) {
				setError(e.getLocalizedMessage(), null, true);
				return false;
			}
		}
		
        if(fBuilderConfig == null) {        	
        	if(!loadBuilderConfig()) {
				return false;
			}
        }
        
        IContainer newSourceContainer = getNewContainer();
		IContainer oldSourceContainer = getConfiguredContainer();
		if(newSourceContainer != null && newSourceContainer.equals(oldSourceContainer)) {
			// nothing to change, keeping the previous settings
			return true;
		}

		boolean shouldMoveSources = fMoveExistingButton != null && fMoveExistingButton.getSelection();
		if(shouldMoveSources) {
			SourceContainerUpdater containerHelper = new SourceContainerUpdater(oldSourceContainer);
			IStatus updateStatus = containerHelper.setContainer(newSourceContainer, shouldMoveSources, null, fShell);
			if(updateStatus.isOK()) {
					
			}
		}
        
        if(fSourceContainer != null) {
            fBuilderConfig.setSourceContainer(newSourceContainer);
        }
        
        try {        	
            fBuilderConfig.save();
            updateStatus();
            fStatusListener.statusChanged(fStatus);
            
        } catch (CoreException e) {
        	setError(Messages.SourceContainerConfigBlock_saveBuilderConfigError, e, true);
            return false;
        }
        
        return true;
    }
  
	public void performDefaults() {
    	fSourceField.setText(""); //$NON-NLS-1$
    }
    
    private void updateStatus() {
		this.fStatus = Status.OK_STATUS;

		fSourceContainer = null;
		
		String containerPath = fSourceField.getText();
		if (containerPath == null || containerPath.length() == 0) {
			// setErrorMessage(Messages.QvtSettingsPropertyPage_EmptySourceContainer);
			// allow empty container as representing the project
			fSourceContainer = fProject;
			return;
		}

		IPath absPath = fProject.getFullPath().append(new Path(containerPath));
		// only check if the path is valid for creation
		IStatus pathStatus = ResourcesPlugin.getWorkspace().validatePath(absPath.toString(), IResource.PROJECT | IResource.FOLDER);
		if(!pathStatus.isOK()) {
			fStatus = pathStatus; 
			return;
		}

		if(fProject.exists()) {
			IResource container = (IResource)fProject.getWorkspace().getRoot().findMember(absPath);
			if (container == null || !container.exists()) {
				setWarningMessage(NLS.bind(Messages.QvtSettingsPropertyPage_ContainerDoesNotExist, absPath));
			} 
			else if(!(container instanceof IContainer)) {
				setErrorMessage(NLS.bind(Messages.QvtSettingsPropertyPage_ContainerIsNotFolder, absPath));				
			}
			
			if(fStatus.isOK()) {
				fSourceContainer = (IContainer) container;			
			}
		} else {
			fSourceContainer = (IContainer)fProject.getFolder(absPath.removeFirstSegments(1)); 
		}
	}
    
    private IContainer chooseOutputLocation() {
        String title = Messages.QvtSettingsPropertyPage_SourceContainerSelection;
        String message = Messages.QvtSettingsPropertyPage_SelectSourceContainerFolder;
        ChooseProjectFolderDialog dialog = new ChooseProjectFolderDialog(fProject, fSourceContainer, fShell, title, message);
        if (dialog.open() == Window.OK) {
            return (IContainer) dialog.getFirstResult();
        }
        
        return null;
    }

    private boolean loadBuilderConfig() {
    	// used with a newly created project, acquire the configuration now
    	try {
			fBuilderConfig = QVTOBuilderConfig.getConfig(fProject);
		} catch (CoreException e) {
			setError(Messages.SourceContainerConfigBlock_loadBuilderConfigError, e, true);
			return false;
		}
		return true;
    }
    
    
    private void setErrorMessage(String message) {
    	fStatus = QVTUIPlugin.createStatus(IStatus.ERROR, message, null);
    }
    
    private void setWarningMessage(String message) {
    	fStatus = QVTUIPlugin.createStatus(IStatus.WARNING, message, null);
    }    
    
    private void setError(String message, CoreException coreException, boolean notifyListener) {
    	IStatus status = QVTUIPlugin.createStatus(IStatus.ERROR, message, coreException);
    	QVTUIPlugin.log(status);
        fStatus = status;
        if(notifyListener) {
        	fStatusListener.statusChanged(fStatus);
        }
    }

    private static String getContainerPathString(IResource resource) {
        return resource.getProjectRelativePath().toString();
    }
    
    private IContainer getNewContainer() {
    	return fSourceContainer;
    }
    private IContainer getConfiguredContainer() {
    	return fBuilderConfig != null ? fBuilderConfig.getSourceContainer() : fProject;
    }
    
    private boolean isContainerChanged() {
    	IContainer configuredContainer = getConfiguredContainer();
    	if(configuredContainer != null) {    		
    		return configuredContainer.exists() && !configuredContainer.equals(getNewContainer());
    	}
    	return true;
    }
}
