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

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.ProgressMonitorWrapper;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IPageChangingListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.PageChangingEvent;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.PersistedValuesWizard;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtRuntimePluginImages;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtRuntimeUIPlugin;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.progress.WorkbenchJob;

/**
 * @author sboyko
 */
public class RunInterpretedTransformationWizard extends PersistedValuesWizard implements IRunnableWithProgress {
	
	public RunInterpretedTransformationWizard(URI uriTransf, List<TargetUriData> targetUris) {
		super(QvtRuntimeUIPlugin.getDefault());
		myTransfUri = uriTransf;
		myTargetUris = targetUris != null ? targetUris : Collections.<TargetUriData>emptyList();

        setNeedsProgressMonitor(false);
        setWindowTitle(Messages.LaunchWorkspaceTransformationWizard_Title);
        ImageDescriptor desc = QvtRuntimePluginImages.getInstance().getImageDescriptor(QvtRuntimePluginImages.APPLY_WIZARD);
        setDefaultPageImageDescriptor(desc);
        
        myTransformationData = new ApplyTransformationData();
		
        URI selectedTransfUri = null;
        if (!myTargetUris.isEmpty()) {
        	try {
    	        PreferenceSection section = loadValues(SOURCE_URI, myTargetUris.get(0).getUriString());
        		selectedTransfUri = URI.createURI(section.get(IQvtLaunchConstants.MODULE, "")); //$NON-NLS-1$
        	}
        	catch (Exception e) {
        	}
        }
        
		mySelectTransformationPage = new SelectInterpretedTransformationPage("SelectTransfromationPageId", selectedTransfUri, myTargetUris); //$NON-NLS-1$
        mySelectTransformationPage.setTitle(Messages.SelectWorkspaceTransformationPage_Title);
        myTransformationParametersPage = new TransformationParametersPage("TransformationParametersPageId", myTransformationData); //$NON-NLS-1$
        myTransformationParametersPage.setTitle(Messages.TransformationParametersPage_Title);
        myQvtTransformationConfigurationPage = new QvtTransformationConfigurationPage("QvtTransformationConfigurationPage", myTransformationData); //$NON-NLS-1$
        myQvtTransformationConfigurationPage.setTitle(org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.Messages.ApplyTransformationWizard_ConfigProperties);
        myQvtTransformationConfigurationPage.setDescription(org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.Messages.ApplyTransformationWizard_SetupConfigProperty);
    }
	
	public void setRunInBackground(boolean isRunInBackground) {
		myIsRunInBackground = isRunInBackground;
	}

	@Override
	public void addPages() {
		QvtTransformation transformation = null;
		if (myTransfUri != null) {
	        try {
	            transformation = new QvtInterpretedTransformation(TransformationUtil.getQvtModule(myTransfUri));
	            
	            if (!TransformationUtil.isRunnable(transformation)) {
	            	transformation = null;
	            }
	        }
	        catch (Exception e) {
	        	transformation = null;
	        }
		}
		
		if (transformation == null) {
			addPage(mySelectTransformationPage);
		}
		else {
	        setQvtTransformation(transformation);
		}
        addPage(myTransformationParametersPage);
        addPage(myQvtTransformationConfigurationPage);
		super.addPages();

        if (getContainer() instanceof WizardDialog) {
        	((WizardDialog) getContainer()).addPageChangingListener(new IPageChangingListener() {
				public void handlePageChanging(PageChangingEvent event) {
					if (event.getTargetPage() == mySelectTransformationPage) {
						myTransformation = null;
					}
					
					if (event.getCurrentPage() == mySelectTransformationPage 
							&& event.getTargetPage() == myTransformationParametersPage) {

						setQvtTransformation(mySelectTransformationPage.getTransformation());
					}
				}
			});
		}
	}

	@Override
	protected void saveValues() {
        try {
        	// save selected transformation
	        if (!myTargetUris.isEmpty()) {
	            PreferenceSection section = loadValues(SOURCE_URI, myTargetUris.get(0).getUriString());
				section.put(IQvtLaunchConstants.MODULE, myTransformation.getURI().toString());
		        section.save();
        	}
        	
        	// save properties of selected transformation
	        if (!myTargetUris.isEmpty()) {
	        	ILaunchConfigurationWorkingCopy launchConfig = createLaunchConfiguration(new NullProgressMonitor());
	            PreferenceSection section = loadValues(
	                    SOURCE_URI, myTargetUris.get(0).getUriString(),
	                    IQvtLaunchConstants.MODULE, myTransformation.getURI().toString()
	            );
	            section.put(IQvtLaunchConstants.TRACE_FILE, launchConfig.getAttribute(IQvtLaunchConstants.TRACE_FILE, "")); //$NON-NLS-1$
	            section.put(IQvtLaunchConstants.USE_TRACE_FILE, launchConfig.getAttribute(IQvtLaunchConstants.USE_TRACE_FILE, false));
	            section.put(IQvtLaunchConstants.IS_INCREMENTAL_UPDATE, launchConfig.getAttribute(IQvtLaunchConstants.IS_INCREMENTAL_UPDATE, false));
	            section.put(IQvtLaunchConstants.DONE_ACTION, myTransformationData.isOpenResult());
	            section.put(IQvtLaunchConstants.CONFIGURATION_PROPERTIES, myTransformationData.getConfiguration());
	            
	        	List<TargetUriData> targetUris = QvtLaunchUtil.getTargetUris(launchConfig);	        	
	        	if (targetUris.size() > 1) {
	        		section.put(IQvtLaunchConstants.ELEM_COUNT, targetUris.size());
	        		for (int i = 1; i < targetUris.size(); ++i) {
		        		section.put(IQvtLaunchConstants.TARGET_TYPE+i, targetUris.get(i).getTargetType().name());
		        		section.put(IQvtLaunchConstants.TARGET_MODEL+i, targetUris.get(i).getUriString());
		        		section.put(IQvtLaunchConstants.FEATURE_NAME+i, targetUris.get(i).getFeature());
		        		section.put(IQvtLaunchConstants.CLEAR_CONTENTS+i, targetUris.get(i).isClearContents());
	        		}
	        	}
	        	
	        	section.save();
	        }
        } catch (Exception e) {
			Logger.getLogger().log(Logger.SEVERE, "Failed to save preferences", e); //$NON-NLS-1$
		}
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
	public IWizardPage getNextPage(IWizardPage page) {
        if (page == myTransformationParametersPage) {
            try {
                if (myTransformation.getConfigurationProperties().size() <= 0) {
                    return null;
                }
            } catch (MdaException e) {
                return null;
            }
        }
		return super.getNextPage(page);
	}
	
	@Override
	public boolean canFinish() {
		return super.canFinish() && myTransformation != null;
	}
	
	@Override
	protected boolean performFinishBody() {
        try {
        	if (myIsRunInBackground) {
                ILaunchConfigurationWorkingCopy workingCopy = createLaunchConfiguration(null);
                DebugUITools.launch(workingCopy, ILaunchManager.RUN_MODE);
        	}
			else {
	            getContainer().run(true, true, this);
			}
		} catch (Exception e) {
            String message = NLS.bind(Messages.LaunchWorkspaceTransformationWizard_FailedToLaunch, TransformationUtil.getTransformationFqn(myTransformation));
            Logger.getLogger().log(Logger.SEVERE, message, e); 
            MessageDialog.openError(getShell(), Messages.LaunchWorkspaceTransformationWizard_Error, message);
		}
        return true;
	}

	public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {		
		WorkbenchJob updateJob = new WorkbenchJob(Messages.LaunchWorkspaceTransformationWizard_Title) {
			@Override
			public IStatus runInUIThread(IProgressMonitor updateMonitor) {
				IProgressMonitor wrappedMonitor = new ProgressMonitorWrapper(monitor) {
					@Override
					public boolean isCanceled() {
						getContainer().getShell().getDisplay().readAndDispatch();
						return super.isCanceled();
					}
				};
				wrappedMonitor.beginTask(NLS.bind(Messages.LaunchWorkspaceTransformationWizard_runningTransformation, TransformationUtil.getTransformationFqn(myTransformation)),
						IProgressMonitor.UNKNOWN);

				try {
		            ILaunchConfigurationWorkingCopy workingCopy = createLaunchConfiguration(wrappedMonitor);
		            DebugUITools.buildAndLaunch(workingCopy, ILaunchManager.RUN_MODE, wrappedMonitor);
				}
				catch (Exception e) {
					return new Status(IStatus.ERROR, QvtRuntimeUIPlugin.PLUGIN_ID, IStatus.OK, Messages.LaunchWorkspaceTransformationWizard_Error, e);
				}
				return Status.OK_STATUS;
			}
		};
		updateJob.setSystem(true);
		updateJob.schedule();
		updateJob.join();
	}
	
    private ILaunchConfigurationWorkingCopy createLaunchConfiguration(IProgressMonitor monitor) throws Exception {
        ILaunchConfigurationWorkingCopy workingCopy = QvtLaunchUtil.getInMemoryLaunchConfigurationType().newInstance(null, Messages.LaunchWorkspaceTransformationWizard_launchConfigName); 
        
        workingCopy.setAttribute(IDebugUIConstants.ATTR_LAUNCH_IN_BACKGROUND, myIsRunInBackground); 
        workingCopy.setAttribute(IQvtLaunchConstants.LAUNCH_IN_BACKGROUND, String.valueOf(myIsRunInBackground));
        
        workingCopy.setAttribute(IQvtLaunchConstants.MODULE, String.valueOf(myTransformation.getURI()));

        myTransformationParametersPage.applyConfiguration(workingCopy);
        
		if (myTransformationData.isOpenResult()) {
			List<TargetUriData> targetUris = QvtLaunchUtil.getTargetUris(workingCopy);
			Map<String, Object> attributes = new LinkedHashMap<String, Object>(workingCopy.getAttributes());
			attributes.put(IQvtLaunchConstants.DONE_ACTION, createShowResultAction(targetUris));
			workingCopy.setAttributes(attributes);
		}
		
		if (monitor != null) {
			Map<String, Object> attributes = new LinkedHashMap<String, Object>(workingCopy.getAttributes());
			attributes.put(IQvtLaunchConstants.MONITOR, monitor);
			workingCopy.setAttributes(attributes);
		}
        
        workingCopy.setAttribute(IQvtLaunchConstants.CONFIGURATION_PROPERTIES, myTransformationData.getConfiguration());

        return workingCopy;
    }

	private Runnable createShowResultAction(final List<TargetUriData> targetUris) {
		if (myTransformation == null) {
			return null;
		}
		return new Runnable() {
							
			public void run() {
				IWorkbenchPage page = QvtRuntimeUIPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
				
		        Iterator<TargetUriData> itrTargetData = targetUris.iterator();
				try {
					for (TransformationParameter transfParam : myTransformation.getParameters()) {
						if (!itrTargetData.hasNext()) {
							break;
						}
						TargetUriData targetData = itrTargetData.next();
						if (transfParam.getDirectionKind() == DirectionKind.IN) {
							continue;
						}
						
						IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(String.valueOf(targetData.getUri()));
					    ModelContent result = EmfUtil.loadModel(targetData.getUri());
					    if (result == null || result.getContent().isEmpty()) {
					    	return;
					    }
					    try {
							handler.getSaver().select(result.getContent().get(0), page);
						} catch (Exception e) {
					        Logger.getLogger().log(Logger.SEVERE, Messages.LaunchWorkspaceTransformationWizard_ShowResultError, e); 
						}
					}
				} catch (MdaException e) {
			        Logger.getLogger().log(Logger.SEVERE, Messages.LaunchWorkspaceTransformationWizard_ShowResultError, e); 
				}
			}
			
		};
	}
	
	private void setQvtTransformation(QvtTransformation transformation) {
		if (!myTargetUris.isEmpty()) {
			try {
		        PreferenceSection section = loadValues(
		                SOURCE_URI, myTargetUris.get(0).getUriString(),
		                IQvtLaunchConstants.MODULE, transformation.getURI().toString()
		        );
		        Map<String, String> configProps = section.getStringMap(IQvtLaunchConstants.CONFIGURATION_PROPERTIES);
		        myTransformationData.getConfiguration().clear();
		        myTransformationData.getConfiguration().putAll(configProps);
		        
		        myTransformationData.setUseTraceFile(section.getBoolean(IQvtLaunchConstants.USE_TRACE_FILE, false));
		        myTransformationData.setIncrementalUpdate(section.getBoolean(IQvtLaunchConstants.IS_INCREMENTAL_UPDATE, false));
		        myTransformationData.setTraceFile(section.get(IQvtLaunchConstants.TRACE_FILE, "")); //$NON-NLS-1$
		        myTransformationData.setOpenResult(section.getBoolean(IQvtLaunchConstants.DONE_ACTION, false));
	
	    		int targetDataCount = Integer.valueOf(section.get(IQvtLaunchConstants.ELEM_COUNT, new Integer(0).toString()));
	    		for (int i = 1; i < targetDataCount; ++i) {
	    			if (myTargetUris.size() <= i) {
	    				myTargetUris.add(new TargetUriData(
		        				TargetUriData.TargetType.valueOf(section.get(IQvtLaunchConstants.TARGET_TYPE+i)),
		        				section.get(IQvtLaunchConstants.TARGET_MODEL+i),
		        				section.get(IQvtLaunchConstants.FEATURE_NAME+i),
		        				Boolean.valueOf(section.get(IQvtLaunchConstants.CLEAR_CONTENTS+i))
		        				));
	    			}
	    		}
		        
			}
			catch (Exception e) {
			}
		}
		
        myTransformation = transformation;
		myTransformationParametersPage.setTransformation(myTransformation, myTargetUris);
		myTransformationData.setTransformation(myTransformation);
	}

	private final SelectInterpretedTransformationPage mySelectTransformationPage;
	private final TransformationParametersPage myTransformationParametersPage;
    private final QvtTransformationConfigurationPage myQvtTransformationConfigurationPage;
    private final ApplyTransformationData myTransformationData;
    private final URI myTransfUri;
    private final List<TargetUriData> myTargetUris;
    private QvtTransformation myTransformation;
    private boolean myIsRunInBackground = true;

    private static final String SOURCE_URI = "SOURCE_URI"; //$NON-NLS-1$
    
}
