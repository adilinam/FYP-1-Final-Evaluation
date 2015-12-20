/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessageEx;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.IUriGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.OptionalFileGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TraceFileControl;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtValidator.ValidationType;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch.Messages;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch.TransformationSignatureLaunchControl;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * @author sboyko
 */
public class TransformationParametersPage extends WizardPage {
	
	public TransformationParametersPage(String pageId, ApplyTransformationData data) {
		super(pageId);
        setDescription(org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.Messages.TransformationParametersPage_Description);
        
        myData = data;
	}

	public void setTransformation(QvtTransformation transformation, List<TargetUriData> targetUris) {
		isSkipValidation = true;

		myInitialTargetUris = targetUris;
		myTransformation = transformation;
		if (myTransformation != null) {
			setTitle(NLS.bind(org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.Messages.TransformationParametersPage_TitleWithTransf, myTransformation));
		}
		if (myTransfSignatureControl != null) {
			myTransfSignatureControl.setTransformation(myTransformation, myUriListeners);
		}
		if (myTransfSignatureControl != null && myTransformation != null) {
	    	try {
    			applyTargetUris(initTargetUriData());
	    	}
	    	catch (MdaException e) {
	    	}
		}
		
		myOpenEditor.setSelection(myData.isOpenResult());
		if (myData.getTraceFile().length() > 0) {
			myTraceFile.setText(myData.getTraceFile());
		}
		else {
			myTraceNameNonChanged = true;
			initTraceFileText();
		}
        myTraceFile.setUseFileFlag(myData.isUseTraceFile());
        myTraceFile.setIncrementalUpdate(myData.isIncrementalUpdate());

        isSkipValidation = false;
        performPageValidation();
	}

	public void createControl(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout(TransformationControls.GRID, false));
        
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
        composite.setLayoutData(gridData);
        
        createTransformationSection(composite);
        
        setControl(composite);
        Dialog.applyDialogFont(composite);
	}

	protected void createTransformationSection(Composite parent) {
        myTraceFile = new TraceFileControl(parent, Messages.QvtLauncherTab_TraceFile);
        myTraceFile.addModifyListener(new OptionalFileGroup.IModifyListener() {
            public void modified() {
            	myTraceNameNonChanged = myTraceFile.getText().equals(getTraceFileName());
            	performPageValidation();
            }});

        myUriListeners.add(new IUriGroup.IModifyListener() {
			public void modified() {
				initTraceFileText();
				performPageValidation();
			}
			public void performValidation(boolean isLightweight) {
				validatePage(ValidationType.FULL_VALIDATION);
			}
		});
        
        TransformationControls.createLabel(parent, Messages.QvtLauncherTab_ParametersLabel, TransformationControls.GRID);
        myTransfSignatureControl = new TransformationSignatureLaunchControl(parent, SWT.NONE|SWT.BORDER);

        TransformationControls.createLabel(parent, "", TransformationControls.GRID); //$NON-NLS-1$
        myOpenEditor = new Button(parent, SWT.CHECK);
        myOpenEditor.setText(org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.Messages.ApplyTransformationFinalPage_OpenEditor);
        myOpenEditor.setSelection(false);
        //myOpenEditor.setVisible(false);
        myOpenEditor.addSelectionListener(new SelectionAdapter() {
            @Override
			public void widgetSelected(SelectionEvent e) {
            	myData.setOpenResult(myOpenEditor.getSelection());
            	performPageValidation();
            }
        });
        myOpenEditor.setLayoutData(new GridData());
	}
	
    private void applyTargetUris(List<TargetUriData> paramTargetUris) {
    	try {
	        ILaunchConfigurationWorkingCopy workingCopy = QvtLaunchUtil.getInMemoryLaunchConfigurationType().newInstance(null, MDAConstants.QVTO_LAUNCH_CONFIGURATION_NAME); 
	        
	        workingCopy.setAttribute(IQvtLaunchConstants.ELEM_COUNT, paramTargetUris.size());
	        int index = 1;
	        for (TargetUriData targetUri : paramTargetUris) {
	    		QvtLaunchUtil.saveTargetUriData(workingCopy, targetUri, index);
	    		++index;
	        }
	
	        myTransfSignatureControl.initializeFrom(workingCopy);
    	}
    	catch (CoreException e) {
            Logger.getLogger().log(Logger.SEVERE, "Fail to initialize luanch configuration", e); //$NON-NLS-1$
    	}
    }

    private List<TargetUriData> initTargetUriData() throws MdaException {
    	URI firstUri = myInitialTargetUris.isEmpty() ? myTransformation.getURI() : myInitialTargetUris.get(0).getUri();
        IFile ifile = firstUri != null ? WorkspaceUtils.getWorkspaceFile(firstUri) : null;
        
        List<TransformationParameter> parameters = myTransformation.getParameters();
        List<TargetUriData> proposedUris = new ArrayList<TargetUriData>(parameters.size());
        
        for (int i = 0; i < parameters.size(); ++i) {
        	if (myInitialTargetUris.size() > i) {
        		proposedUris.add(myInitialTargetUris.get(i));
        		continue;
        	}
        	
        	TransformationParameter transfParam = parameters.get(i);
        	if (transfParam.getDirectionKind() == DirectionKind.IN
        			|| transfParam.getDirectionKind() == DirectionKind.INOUT) {
                proposedUris.add(new TargetUriData("")); //$NON-NLS-1$
            	continue;            	
        	}

        	if (ifile == null) {
                proposedUris.add(new TargetUriData("")); //$NON-NLS-1$
                continue;
        	}
        	
        	try {
        		String extension = transfParam.getMetamodels().isEmpty() ? "xmi" : transfParam.getMetamodels().get(0).getName(); //$NON-NLS-1$
                String fileName = myTransformation.getModuleName() + "." + extension; //$NON-NLS-1$
                IPath targetPath = new Path(ifile.getParent().getFullPath() + "/" + fileName);  //$NON-NLS-1$
                URI targetUri = URI.createPlatformResourceURI(targetPath.toString(), false);
                proposedUris.add(new TargetUriData(targetUri == null ? "" : targetUri.toString())); //$NON-NLS-1$
            }
            catch (Exception e) {
                proposedUris.add(new TargetUriData("")); //$NON-NLS-1$
            }
        }
        
        return proposedUris;
    }
    
	public void applyConfiguration(ILaunchConfigurationWorkingCopy workingCopy) {
		myTransfSignatureControl.performApply(workingCopy);
		workingCopy.setAttribute(IQvtLaunchConstants.TRACE_FILE, myTraceFile.getText());
		workingCopy.setAttribute(IQvtLaunchConstants.USE_TRACE_FILE, myTraceFile.getUseFileFlag());
		workingCopy.setAttribute(IQvtLaunchConstants.IS_INCREMENTAL_UPDATE, myTraceFile.isIncrementalUpdate());
    	myData.setTraceFile(myTraceFile.getText());
    	myData.setUseTraceFile(myTraceFile.getUseFileFlag());
    	myData.setIncrementalUpdate(myTraceFile.isIncrementalUpdate());
	}
	
	private void performPageValidation() {
    	if (!isSkipValidation) {
    		setPageComplete(validatePage(ValidationType.LIGHTWEIGHT_VALIDATION));
    	}
	}
	
	protected boolean validatePage(ValidationType validationType) {
        if (myTransformation == null) {
            return false;
        }

        setMessage(null);
        setErrorMessage(null);
        String moduleName;
        try {
        	moduleName = myTransformation.getModuleName();
        }
        catch (MdaException e) {
        	IStatus status = StatusUtil.makeErrorStatus(e.getMessage(), e);
        	return TransformationControls.statusToTab(status, SET_MESSAGE);
        }
        if (myTraceFile.getText().length() == 0) {
        	myTraceFile.update(moduleName, MDAConstants.QVTO_TRACEFILE_EXTENSION);
        }
        IStatus status = myTransfSignatureControl.validate(moduleName, getShell(), myTraceFile.getText(),
        		myTraceFile.getUseFileFlag(), myTraceFile.isIncrementalUpdate(), validationType);
        return TransformationControls.statusToTab(status, SET_MESSAGE);
    }

    private String getTraceFileName() {
        URI uri = myTransfSignatureControl.getDefaultTraceName();
        return uri == null ? null : uri.toString();
    }

    private void initTraceFileText() {
    	if (myTraceNameNonChanged || myTraceFile.getText().length() == 0) {
    		boolean oldIsSkipValidation = isSkipValidation;
	        isSkipValidation = true;
	        
	        String traceFileName = getTraceFileName();
	        myTraceFile.setText(traceFileName);
	        //myTraceFile.setUseFileFlag(traceFileName != null);
	        if (traceFileName != null) {
	            IPath path = Path.fromOSString(traceFileName);
	        	myTraceFile.update(path.lastSegment().replaceAll(MDAConstants.QVTO_TRACEFILE_EXTENSION_WITH_DOT, ""), //$NON-NLS-1$
	        			MDAConstants.QVTO_TRACEFILE_EXTENSION);
	        }

	        isSkipValidation = oldIsSkipValidation;
    	}
    }
    
    private final ISetMessageEx SET_MESSAGE = new ISetMessageEx() {
        public void setErrorMessage(String message) {
        	TransformationParametersPage.this.setErrorMessage(message);
        }

        public void setWarningMessage(String message) {
        	TransformationParametersPage.this.setMessage(message, WARNING);
        }

        public void setMessage(String message) {
        	TransformationParametersPage.this.setMessage(message);
        }
    };
    
    private QvtTransformation myTransformation;
    private final ApplyTransformationData myData;
    private final List<IUriGroup.IModifyListener> myUriListeners = new ArrayList<IUriGroup.IModifyListener>(1);
    private TraceFileControl myTraceFile;
    private boolean myTraceNameNonChanged;
    private boolean isSkipValidation;
    private TransformationSignatureLaunchControl myTransfSignatureControl;
    private List<TargetUriData> myInitialTargetUris;
    private Button myOpenEditor;
}
