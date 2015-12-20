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
package org.eclipse.m2m.internal.qvt.oml.runtime.launch;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.variables.IDynamicVariable;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.BaseProcess;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.internal.qvt.oml.common.launch.StreamsProxy;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtModule;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.eclipse.osgi.util.NLS;

public class QvtBuilderLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String QVTO_BUILDER_MARKER = "org.eclipse.m2m.qvt.oml.runtime.qvtBuilderMarker"; //$NON-NLS-1$
	
    public void launch(final ILaunchConfiguration configuration, String mode, ILaunch launch, final IProgressMonitor monitor) throws CoreException {
        
        try {
        	final String buildType = getVariableValue("build_type"); //$NON-NLS-1$
        	IPath path = new Path(getVariableValue("build_project")); //$NON-NLS-1$
            final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(path.lastSegment());

            StreamsProxy streamsProxy = new StreamsProxy();
            final PrintWriter printWriter = new PrintWriter(streamsProxy.getOutputWriter());
            
            ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {
                public void run() throws Exception {
                    if(BUILD_TYPE_CLEAN.equals(buildType)) {
                        clean(project, configuration);
                    }
                    else {
                        build(project, configuration, printWriter, monitor);
                    }
                }
            };
            
            ShallowProcess shallowProcess = new ShallowProcess(launch, r);
            shallowProcess.setStreamsProxy(streamsProxy);
			shallowProcess.run();
        }
        catch(Exception e) {
            throw new CoreException(MiscUtil.makeErrorStatus(org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil.getExceptionMessages(e), e));
        }
    }

    private void build(final IProject project, final ILaunchConfiguration configuration, final PrintWriter printWriter,
    		final IProgressMonitor monitor) throws Exception {
    	
        String moduleUri = QvtLaunchUtil.getTransformationURI(configuration);
        final QvtInterpretedTransformation transformation;
		try {
			QvtModule qvtModule = TransformationUtil.getQvtModule(EmfUtil.makeUri(moduleUri));
			transformation = new QvtInterpretedTransformation(qvtModule);
		} catch (MdaException e) {
            createMarker(project, NLS.bind(Messages.QvtBuilderLaunchTab_TransformationNotFound, moduleUri));
            return;
		}
        
        BaseProcess.IRunnable r = new BaseProcess.IRunnable() {
            public void run() throws Exception {
            	try {
	                IStatus status = QvtLaunchConfigurationDelegateBase.validate(transformation, configuration);
	                if(status.getSeverity() > IStatus.WARNING) {
	                    createMarker(project, status.getMessage());
	                    return;
	                }
	
	            	Context context = QvtLaunchUtil.createContext(configuration);
	                context.setLog(new WriterLog(printWriter));
	                context.setProgressMonitor(monitor);
	
	                QvtLaunchConfigurationDelegateBase.doLaunch(transformation, configuration, context);
            	}
            	finally {
            		transformation.cleanup();
            	}
            }
        };
        
        r = QvtLaunchConfigurationDelegateBase.getSafeRunnable(transformation, r);
        r.run();
    }
    
    private void clean(IProject project, ILaunchConfiguration configuration) throws Exception {
        String moduleUri = QvtLaunchUtil.getTransformationURI(configuration);
        final QvtInterpretedTransformation transformation;
		try {
			transformation = new QvtInterpretedTransformation(TransformationUtil.getQvtModule(EmfUtil.makeUri(moduleUri)));
		} catch (MdaException e) {
            createMarker(project, NLS.bind(Messages.QvtBuilderLaunchTab_TransformationNotFound, moduleUri));
            return;
		}
        
        List<TransformationParameter> transfParams = transformation.getParameters();
        List<TargetUriData> targetUris = QvtLaunchUtil.getTargetUris(configuration);
        for (int i = 0, n = targetUris.size(); i < n; ++i) {
        	if (transfParams.size() > i && transfParams.get(i).getDirectionKind() == DirectionKind.OUT) {
	        	URI outUri = URI.createURI(targetUris.get(i).getUriString());
	        	if (outUri != null) {
	                IFile file = URIUtils.getFile(outUri);
	                if (file != null) {
		                file.delete(true, true, null);
	                }
	        	}
        	}
        }
        
        String traceFile = configuration.getAttribute(IQvtLaunchConstants.TRACE_FILE, ""); //$NON-NLS-1$
        if (traceFile != null) {
        	URI traceUri = URI.createPlatformResourceURI(traceFile, false);
        	if (traceUri != null) {
                IFile file = URIUtils.getFile(traceUri);
                if (file != null) {
	                file.delete(true, true, null);
                }
        	}
        }
    }

	private void createMarker(IProject project, String message) {
	    if(project == null) {
	        return;
	    }
	    
	    Map<String, Object> attributes = new HashMap<String, Object>();
	    attributes.put(IMarker.MESSAGE, message);
	    attributes.put(IMarker.SEVERITY, new Integer(IMarker.SEVERITY_ERROR));
	    try {
	        IMarker marker = project.createMarker(QVTO_BUILDER_MARKER);
	        marker.setAttributes(attributes);
	    }
	    catch (CoreException e) {
	        Logger.getLogger().log(Logger.SEVERE, "Failed to create marker on " + project, e); //$NON-NLS-1$
	    }
	}
	
	private String getVariableValue(String variableName) throws CoreException {
    	IDynamicVariable dynamicVar = VariablesPlugin.getDefault().getStringVariableManager().getDynamicVariable(variableName);
    	return dynamicVar.getValue(null);
	}

    /**
     * Copied from org.eclipse.ui.externaltools.internal.model.IExternalToolConstants
     * 
     * Looks like it's never evolved to API (see: http://dev.eclipse.org/newslists/news.eclipse.platform/msg38656.html)
     * 
     */

	// ------- Build Types -------
	/**
	 * Build type indicating an incremental project build request for
	 * the external tool running as a builder (value <code>incremental</code>).
	 */
	public static final String BUILD_TYPE_INCREMENTAL = "incremental"; //$NON-NLS-1$

	/**
	 * Build type indicating a full project build request for
	 * the external tool running as a builder (value <code>full</code>).
	 */
	public static final String BUILD_TYPE_FULL = "full"; //$NON-NLS-1$

	/**
	 * Build type indicating an automatic project build request for
	 * the external tool running as a builder (value <code>auto</code>).
	 */
	public static final String BUILD_TYPE_AUTO = "auto"; //$NON-NLS-1$
	
	/**
	 * Build type indicating a clean project build request for
	 * the external tool running as a builder (value <code>clean</code>).
	 */
	public static final String BUILD_TYPE_CLEAN = "clean"; //$NON-NLS-1$

	/**
	 * Plugin identifier for external tools (value <code>org.eclipse.ui.externaltools</code>).
	 */
	private static final String PLUGIN_ID = "org.eclipse.ui.externaltools"; //$NON-NLS-1$;

	/**
	 * String attribute containing an array of build kinds for which an
	 * external tool builder should be run.
	 */
	public static final String ATTR_RUN_BUILD_KINDS = PLUGIN_ID + ".ATTR_RUN_BUILD_KINDS"; //$NON-NLS-1$

}
