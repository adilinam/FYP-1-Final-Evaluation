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
package org.eclipse.m2m.internal.qvt.oml.runtime.launch;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.m2m.internal.qvt.oml.ModelExtentHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.BaseProcess;
import org.eclipse.m2m.internal.qvt.oml.common.launch.BaseProcess.IRunnable;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.SafeRunner;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TraceSerializer;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtValidator.ValidationType;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtModule;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.eclipse.osgi.util.NLS;

public abstract class QvtLaunchConfigurationDelegateBase extends LaunchConfigurationDelegate {
    @Override
	protected IProject[] getProjectsForProblemSearch(ILaunchConfiguration configuration, String mode) throws CoreException {
    	IFile moduleFile = getModuleFile(configuration);
    	if (moduleFile == null || !moduleFile.exists()) {
    		return new IProject[0];
    	}
        return new IProject[] { moduleFile.getProject() };
    }
 
    public static QvtModule getQvtModule(ILaunchConfiguration configuration) throws CoreException {
		try {
	        String moduleUri = QvtLaunchUtil.getTransformationURI(configuration);
			return TransformationUtil.getQvtModule(EmfUtil.makeUri(moduleUri));
		} catch (MdaException e) {
        	IStatus errorStatus = MiscUtil.makeErrorStatus(e.getMessage());
        	throw new CoreException(errorStatus);
		}
    }

    public static IFile getModuleFile(ILaunchConfiguration configuration) throws CoreException {
        String moduleFileName = configuration.getAttribute(IQvtLaunchConstants.MODULE, ""); //$NON-NLS-1$
        URI moduleUri = URI.createURI(moduleFileName);
        IFile moduleFile = WorkspaceUtils.getWorkspaceFile(moduleUri);
        if(moduleFile == null) {
        	//IStatus errorStatus = MiscUtil.makeErrorStatus( 
        		//	NLS.bind(Messages.QvtLaunchConfigurationDelegate_transformationFileNotFound, moduleFileName));
        	//throw new CoreException(errorStatus);
        }
        
        return moduleFile;
    }

    public static IStatus validate(QvtTransformation transformation, ILaunchConfiguration configuration) throws CoreException {
    	List<TargetUriData> targetUris = QvtLaunchUtil.getTargetUris(configuration);
        String traceFile = configuration.getAttribute(IQvtLaunchConstants.TRACE_FILE, ""); //$NON-NLS-1$
        boolean useTraceFile = configuration.getAttribute(IQvtLaunchConstants.USE_TRACE_FILE, false); 
        boolean isIncrementalUpdate = configuration.getAttribute(IQvtLaunchConstants.IS_INCREMENTAL_UPDATE, false); 
        
        try {
        	return QvtValidator.validateTransformation(transformation, targetUris, traceFile, useTraceFile,
        			isIncrementalUpdate, ValidationType.FULL_VALIDATION);
        }
        catch (MdaException ex) {
        	throw new CoreException(StatusUtil.makeErrorStatus(ex.getMessage(), ex));
        }
    }
    
    public static BaseProcess.IRunnable getSafeRunnable(QvtTransformation transformation, IRunnable r) throws CoreException {
        return SafeRunner.getSafeRunnable(r);
    }
    
    public static void doLaunch(QvtTransformation transformation, ILaunchConfiguration configuration, IContext context) throws Exception {
    	List<ModelContent> inObjects = new ArrayList<ModelContent>();
    	List<TargetUriData> targetData = new ArrayList<TargetUriData>();
		List<TargetUriData> targetUris = QvtLaunchUtil.getTargetUris(configuration);
		
		Iterator<TargetUriData> itrTargetData = targetUris.iterator();
		for (TransformationParameter transfParam : transformation.getParameters()) {
			if (!itrTargetData.hasNext()) {
	            throw new MdaException(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
	            		transfParam.getName()));
			}
			TargetUriData nextUri = itrTargetData.next();
			if (transfParam.getDirectionKind() == DirectionKind.IN || transfParam.getDirectionKind() == DirectionKind.INOUT) {
				ModelContent inModel = null;
				if (nextUri.getContentProvider() != null) {
					inModel = new ModelContent(nextUri.getContentProvider().getContents());
				}
				else {
			        URI inUri = toUri(nextUri.getUriString());
			        inModel = transformation.loadInput(inUri);
				}
				inObjects.add(inModel);
			}
			if (transfParam.getDirectionKind() == DirectionKind.OUT || transfParam.getDirectionKind() == DirectionKind.INOUT) {
				targetData.add(nextUri);
			}
		}

        boolean saveTrace = configuration.getAttribute(IQvtLaunchConstants.USE_TRACE_FILE, false);
        String traceFile = configuration.getAttribute(IQvtLaunchConstants.TRACE_FILE, ""); //$NON-NLS-1$        
        boolean isIncrementalUpdate = configuration.getAttribute(IQvtLaunchConstants.IS_INCREMENTAL_UPDATE, false);
        
		if (isIncrementalUpdate && traceFile != null) {
			ModelContent traceContent = EmfUtil.safeLoadModel(URI.createURI(traceFile), transformation.getResourceSet());
			if (traceContent != null) {
				context.getTrace().setTraceContent(traceContent.getContent());
			}
		}
        
        doLaunch(transformation, inObjects, targetData, saveTrace ? traceFile : null, context);
    }
    
    public static void doLaunch(QvtTransformation transformation, List<ModelContent> inObjs, Map<String, Object> configProps,
    		List<ModelExtentContents> outExtents, List<EObject> outMainParams, List<Trace> outTraces, List<String> outConsole) throws MdaException {

        IStatus status = QvtValidator.validateTransformation(transformation, inObjs, null);                    
        if (status.getSeverity() > IStatus.WARNING) {
        	throw new MdaException(status);
        }      	
    	
        Context context = QvtLaunchUtil.createContext(configProps);

		final StringWriter consoleLogger = new StringWriter();
		context.setLog(new WriterLog(consoleLogger));
    	
        TransformationRunner.In in = new TransformationRunner.In(inObjs.toArray(new ModelContent[inObjs.size()]), context);
        TransformationRunner.Out out = transformation.run(in);

        outExtents.addAll(out.getExtents());

        for (Object outValue : out.getOutParamValues()) {
        	if (outValue instanceof EObject) {
        		outMainParams.add((EObject) outValue);
        	}
        	else {
        		outMainParams.add(null);
        	}
        }
        
        if (out.getTrace() != null) {
        	outTraces.add(out.getTrace());
        }
        outConsole.add(consoleLogger.getBuffer().toString());
    }
        
    public static List<URI> doLaunch(final QvtTransformation transformation, final List<ModelContent> inObjs,
    		List<TargetUriData> targetData, final String traceFileName, IContext context) throws Exception {
    	
        TransformationRunner.In in = new TransformationRunner.In(inObjs.toArray(new ModelContent[inObjs.size()]), context);
        TransformationRunner.Out out = transformation.run(in);

        ResourceSet resSet = transformation.getResourceSet();
        if(resSet == null) {
	        for (ModelContent inModel : inObjs) {
				resSet = inModel.getResourceSet();
				if(resSet != null) {
					break;
				}
			}
        }
        if(resSet == null) {
        	resSet = EmfUtil.getOutputResourceSet();
        }

        Iterator<ModelExtentContents> itrExtent = out.getExtents().iterator();
        for (TargetUriData outUriData : targetData) {
        	if (!itrExtent.hasNext()) {
        		throw new MdaException("Incomplete transformation results"); //$NON-NLS-1$
        	}
        	saveTransformationResult(itrExtent.next(), outUriData, resSet);
        }

        List<URI> result = new ArrayList<URI>(out.getOutParamValues().size());
        for (Object outValue : out.getOutParamValues()) {
        	if (outValue instanceof EObject) {
        		result.add(EcoreUtil.getURI((EObject) outValue));
        	}
        	else {
        		result.add(null);
        	}
        }
        
        if(out.getTrace() != null) {
            if(traceFileName != null) {
	        	URI traceUri = EmfUtil.makeUri(traceFileName);
	           	TraceSerializer traceSerializer = new TraceSerializer(out.getTrace());
	           	traceSerializer.saveTraceModel(traceUri);
	           	traceSerializer.markUnboundObjects(traceUri);
            }
            //context.getTrace().setTraceContent(Collections.singletonList(out.getTrace()));
        }
        
        return result;
    }
    
    @SuppressWarnings("unchecked")
	private static void saveTransformationResult(ModelExtentContents extent, TargetUriData targetData, ResourceSet resSet) throws MdaException {
    	if (targetData.getContentProvider() != null) {
    		targetData.getContentProvider().setContents(extent.getAllRootElements());
    		return;
    	}
    	
    	URI outUri = toUri(targetData.getUriString());
    	
        switch(targetData.getTargetType()) {
        	case NEW_MODEL: {
        		try {
            		ModelExtentHelper.saveExtentToResources(extent.getAllRootElements(), resSet, outUri);
        		}
        		catch(EmfException e) {
        			throw new MdaException(e);
        		}
        		break;
        	}
        	
        	case EXISTING_CONTAINER: {
        		ModelContent loadModel = EmfUtil.loadModel(outUri, resSet);
	        	EObject container = (loadModel != null && !loadModel.getContent().isEmpty() ? loadModel.getContent().get(0) : null);
	            if(container == null) {
	                throw new MdaException("No object at " + outUri); //$NON-NLS-1$
	            }
	            
		        EStructuralFeature feature = container.eClass().getEStructuralFeature(targetData.getFeature());
		        if (feature == null) {
	                throw new MdaException("Reference " + targetData.getFeature() + " not found in " + container); //$NON-NLS-1$ //$NON-NLS-2$
		        }

		        if (targetData.isClearContents() && FeatureMapUtil.isMany(container, feature)) {
		        	List<EObject> value = (List<EObject>) container.eGet(feature);
		        	if (value != null) {
		        		value.clear();
		        	}
		        }
		        
        		for (EObject out : extent.getAllRootElements()) {
			        if (FeatureMapUtil.isMany(container, feature)) {
			        	List<EObject> value = (List<EObject>) container.eGet(feature);
			        	try {
			        		value.add(out);
			        	}
			        	catch (RuntimeException ex) {
			        		throw new MdaException(NLS.bind(Messages.QvtLaunchConfigurationDelegateBase_FeatureSetFailure,
			        				EmfUtil.getFullName(out.eClass()), targetData.getFeature()));
			        	}
			        }
			        else {
			        	container.eSet(feature, out);
			        }
        		}
        		
		        try {
		        	saveResource(container);
		        }
		        catch(IOException e) {
		        	throw new MdaException(e.getMessage(), e);
		        }
		        
		        break;
        	}
        	
        	case INPLACE: {
       			throw new MdaException(Messages.QvtValidator_InplaceConfigNotSupported);
        	}
        }
        
        org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils.refresh(outUri);
    }

	private static void saveResource(EObject obj) throws IOException {
    	Resource resource = obj.eResource();
    	if(resource == null) {
    		Logger.getLogger().warning("Object has no resource: " + obj); //$NON-NLS-1$
    		return;
    	}

		resource.save(EmfUtil.DEFAULT_SAVE_OPTIONS);
	}

    private static URI toUri(String uriString) throws MdaException {
        URI uri = URI.createURI(uriString);  
        if(uri == null) {
            throw new MdaException(NLS.bind(Messages.QvtValidator_InvalidUri, uriString));
        }
        
        return uri;
    }
    
}
