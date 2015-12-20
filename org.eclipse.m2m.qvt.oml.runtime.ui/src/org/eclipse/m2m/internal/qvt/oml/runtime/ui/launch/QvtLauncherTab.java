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
 *     Alex Paperno - bugs 416584
 *     Christopher Gerking - bug 428610
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessage;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessageEx;
import org.eclipse.m2m.internal.qvt.oml.common.ui.controls.BrowseInterpretedTransformationDialog;
import org.eclipse.m2m.internal.qvt.oml.common.ui.controls.UniSelectTransformationControl;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.IUriGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.MdaLaunchTab;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.OptionalFileGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TraceFileControl;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.project.QvtEngine;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtValidator.ValidationType;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.ITransformationMaker;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformationRegistry;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

/** @author pkobiakov */
public class QvtLauncherTab extends MdaLaunchTab {
	public QvtLauncherTab(ITransformationMaker transformationMaker) {
		myTransformationMaker = transformationMaker;

        myUriListeners = new ArrayList<IUriGroup.IModifyListener>(1);
        myUriListeners.add(new IUriGroup.IModifyListener() {
			public void modified() {
				initTraceFileText();
				updateLaunchConfigurationDialog();
			}
			public void performValidation(boolean isLightweight) {
				validateTab(isLightweight ? ValidationType.LIGHTWEIGHT_VALIDATION : ValidationType.FULL_VALIDATION);
			}
		});
	}
	
	@Override
	public void createControl(Composite parent) {
/*	   
		if (!LicenseClient.isAvailable()) {
            Composite composite = new Composite(parent, SWT.NONE);
            composite.setLayout(new GridLayout());
            LicenseClient.createLimitedPane(composite, QvtRuntimePlugin.getResourceString("QvtLaunch.Feature")); //$NON-NLS-1$
            setControl(composite);
            return;
        }
*/      
        super.createControl(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, MDAConstants.QVTO_TRANSFORMATION_CONTEXTID);
    }
	
	@Override
	public void dispose() {
		super.dispose();
		try {
			if (myTransformation != null) {
				myTransformation.cleanup();
			}
		} catch (MdaException e) {
		}
	}
    
	@Override
	protected void createTransformationSection(Composite parent) {
        TransformationControls.createLabel(parent, Messages.QvtLauncherTab_ModuleLabel, TransformationControls.GRID);
        
        myQvtFile = TransformationControls.createText(parent, TransformationControls.TEXT_GRID);
        myQvtFile.addModifyListener(QVT_FILE_MODIFY_LISTENER);
        
        Button button = TransformationControls.createButton(parent, Messages.QvtLauncherTab_BrowseButtonLabel);
        button.addSelectionListener(new SelectionAdapter(){
            @Override
			public void widgetSelected(SelectionEvent e) {
            	
            	final String fileName = myQvtFile.getText();
            	
            	UniSelectTransformationControl.ISelectionListener selectionListener = new UniSelectTransformationControl.SelectionListenerAdapter() {
            		            		
					public IStatus selectionChanged(URI selectedUri) {
						String transfName = ""; //$NON-NLS-1$
				        try {
				            if (selectedUri == null) {
				            	return TransformationControls.makeStatus(IStatus.ERROR, Messages.QvtLauncherTab_NoTransformationModule);
				            }
				            QvtTransformation transformation = myTransformationMaker.makeTransformation(selectedUri);
				            transfName = transformation.getModuleName();
				        }
				        catch (Exception e) {
				        	return TransformationControls.makeStatus(IStatus.ERROR, e.getMessage());
				        }
				        return TransformationControls.makeStatus(IStatus.OK, NLS.bind(Messages.QvtLauncherTab_TransformationSelected, transfName));
					}
					
					@Override
					public TreeAction getTreeAction(URI uri) {
						String item = uri.toString();
						
						if (fileName.equals(item)) {
							return TreeAction.SELECT;
						}
						return fileName.startsWith(item) ? TreeAction.EXPAND : TreeAction.NONE;
					}
            	};
            	
            	BrowseInterpretedTransformationDialog dialog = new BrowseInterpretedTransformationDialog(getShell(),
            			UniSelectTransformationControl.QVTO_FILE_FILTER,
                		QvtTransformationRegistry.getInstance(), fileName, selectionListener);
                dialog.create();
                PlatformUI.getWorkbench().getHelpSystem().setHelp(dialog.getShell(), MDAConstants.QVTO_TRANSFORMATION_CONTEXTID);
                
                if (dialog.open() == Window.OK) {
                    URI selectedUri = dialog.getSelectedUri();
                    if (selectedUri != null){
                    	myQvtFile.setText(selectedUri.toString());
                    }
                }
            } 
        });

        myTraceFile = new TraceFileControl(parent, Messages.QvtLauncherTab_TraceFile);
        myTraceFile.addModifyListener(new OptionalFileGroup.IModifyListener() {
            public void modified() {
            	myTraceNameNonChanged = myTraceFile.getText().equals(getTraceFileName());
                updateLaunchConfigurationDialog();
            }});

        TransformationControls.createLabel(parent, Messages.QvtLauncherTab_ParametersLabel, TransformationControls.GRID);
        myTransfSignatureControl = new TransformationSignatureLaunchControl(parent, SWT.NONE|SWT.BORDER);

	}

    private void initTraceFileText() {
    	if (myTraceNameNonChanged || myTraceFile.getText().length() == 0) {
	        String traceFileName = getTraceFileName();
	        myTraceFile.setText(traceFileName);
	        //myTraceFile.setUseFileFlag(traceFileName != null);
	        if (traceFileName != null) {
	            IPath path = Path.fromOSString(traceFileName);
	        	myTraceFile.update(path.lastSegment().replaceAll(MDAConstants.QVTO_TRACEFILE_EXTENSION_WITH_DOT, ""), //$NON-NLS-1$
	        			MDAConstants.QVTO_TRACEFILE_EXTENSION);
	        }
    	}
    }
    
    private String getTraceFileName() {
        URI uri = myTransfSignatureControl.getDefaultTraceName();
        return uri == null ? null : uri.toString();
    }
	
    @Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
        IFile file = getFileContext();
        if(file == null) {
            return;
        }
        
        // FIXME - strange error condition processing
        try {
        	URI uri = URIUtils.getResourceURI(file);
        	UnitProxy unit = UnitResolverFactory.Registry.INSTANCE.getUnit(uri);
        	if(unit == null) {
        		return;
        	}
            CompiledUnit compiledUnit = QvtEngine.getInstance(file).compileUnit(unit, null);
            if(compiledUnit != null && compiledUnit.getModules().size() >= 1) {
	            Module module = compiledUnit.getModules().get(0);
	            ImperativeOperation mainOperation = QvtOperationalParserUtil.getMainOperation(module);
				if(mainOperation != null) {
	                initializeName(configuration, compiledUnit.getName());
	                URI transfUri = URI.createPlatformResourceURI(file.getFullPath().toString(), false);
	                configuration.setAttribute(IQvtLaunchConstants.MODULE, transfUri.toString());
	            }
            }
        }
        catch (MdaException e) {
            Logger.getLogger().log(Logger.INFO, e.getMessage(), e);
        }
    }
    
    private void initializeName(ILaunchConfigurationWorkingCopy config, String name) {
        if (name == null) {
            name = ""; //$NON-NLS-1$
        }

        if (name.length() > 0) {
            name = getLaunchConfigurationDialog().generateName(name);
            config.rename(name);
        }
    }
	
	public void initializeFrom(ILaunchConfiguration configuration) {
/*        
		if (!LicenseClient.isAvailable()) {
            return;
        }
*/
		try {
			String module = configuration.getAttribute(IQvtLaunchConstants.MODULE, ""); //$NON-NLS-1$
			if (!myQvtFile.getText().equals(module)) {
				myQvtFile.setText(module);
			}
		} catch (CoreException e) {
			myQvtFile.setText(""); //$NON-NLS-1$
		}
		
		try {
			myTransfSignatureControl.initializeFrom(configuration);
		} catch (CoreException e) {
		}

        try {
        	String traceFile = configuration.getAttribute(IQvtLaunchConstants.TRACE_FILE, ""); //$NON-NLS-1$
        	if (traceFile.length() > 0) {
        		if (!myTraceFile.getText().equals(traceFile)) {
        			myTraceFile.setText(traceFile);
        		}
        	}
        	else {
        		myTraceNameNonChanged = true;
        		initTraceFileText();
        	}
        } catch (CoreException e) {
        }

        try {
            myTraceFile.setUseFileFlag(configuration.getAttribute(IQvtLaunchConstants.USE_TRACE_FILE, false)); 
        } catch (CoreException e) {
        }

        try {
            myTraceFile.setIncrementalUpdate(configuration.getAttribute(IQvtLaunchConstants.IS_INCREMENTAL_UPDATE, false)); 
        } catch (CoreException e) {
        }
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
/*       
		if (!LicenseClient.isAvailable()) {
            return;
        }
*/        
		configuration.setAttribute(IQvtLaunchConstants.MODULE, myQvtFile.getText());
		myTransfSignatureControl.performApply(configuration);
        configuration.setAttribute(IQvtLaunchConstants.TRACE_FILE, myTraceFile.getText());
        configuration.setAttribute(IQvtLaunchConstants.USE_TRACE_FILE, myTraceFile.getUseFileFlag());
        configuration.setAttribute(IQvtLaunchConstants.IS_INCREMENTAL_UPDATE, myTraceFile.isIncrementalUpdate());
	}
    
    @Override
	public boolean isValid(ILaunchConfiguration unused) {
    	return validateTab(ValidationType.LIGHTWEIGHT_VALIDATION);
    }
    
    private boolean validateTab(ValidationType validationType) {
    	
/*        
    	if (!LicenseClient.isAvailable()) {
            return true;
        }
*/
        if(myTransformation == null) {
            return false;
        }
        else{
            setMessage(null);
			AbstractLaunchConfigurationTabCompatibility.setWarningMessage(this, null);
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
    }
    
    private boolean validateQvtFile() {
        if (myTransformation != null) {
        	try {
				myTransformation.cleanup();
			} catch (MdaException e) {
			}
        	myTransformation = null;
        }

        String fileName = myQvtFile.getText();
        if (fileName == null || fileName.length() == 0) {
            setErrorMessage(NLS.bind(Messages.QvtLauncherTab_NoTransformationModule, null));
            return false;
        }
        
        URI uri = EmfUtil.makeUri(fileName);
        if (uri == null) {
            setErrorMessage(NLS.bind(Messages.QvtLauncherTab_InvalidTransformationUri, fileName));
            return false;
        }
        
        try {
        	myTransformation = myTransformationMaker.makeTransformation(uri);
        }
        catch (MdaException e) {
            setErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }
    
    private final ModifyListener QVT_FILE_MODIFY_LISTENER = new ModifyListener() {
        public void modifyText(ModifyEvent e) {
            validateQvtFile();
            myTransfSignatureControl.setTransformation(myTransformation, myUriListeners);
            myTraceNameNonChanged = true;
            initTraceFileText();
            updateLaunchConfigurationDialog();            
        }
    };
    
    private final ISetMessage SET_MESSAGE = new ISetMessageEx() {
		
        public void setErrorMessage(String message) {
            QvtLauncherTab.this.setErrorMessage(message);
            QvtLauncherTab.this.getLaunchConfigurationDialog().updateMessage();
        }

        public void setMessage(String message) {
            QvtLauncherTab.this.setMessage(message);
            QvtLauncherTab.this.getLaunchConfigurationDialog().updateMessage();
        }

		public void setWarningMessage(String message) {
			if (!AbstractLaunchConfigurationTabCompatibility.setWarningMessage(QvtLauncherTab.this, message)) {
				QvtLauncherTab.this.setMessage(message);
			}			
            QvtLauncherTab.this.getLaunchConfigurationDialog().updateMessage();
		}
    };
    
    private final ITransformationMaker myTransformationMaker; 
    private Text myQvtFile;
    private QvtTransformation myTransformation;
    private TraceFileControl myTraceFile;
    private boolean myTraceNameNonChanged;
    private TransformationSignatureLaunchControl myTransfSignatureControl;
    private final List<IUriGroup.IModifyListener> myUriListeners;
}
