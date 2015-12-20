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
 *     Christopher Gerking - bug 427237
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.launch;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.osgi.util.NLS;

public class QvtValidator {
	
	public static enum ValidationType {
		FULL_VALIDATION,
		LIGHTWEIGHT_VALIDATION
	}

	private QvtValidator() {		
	}

	public static IStatus validateTransformation(QvtTransformation transformation, List<TargetUriData> targetUris, String traceFilePath,
			boolean useTrace, boolean isIncrementalUpdate, ValidationType validationType) throws MdaException {
        IStatus result = StatusUtil.makeOkStatus();
        
        if (!TransformationUtil.isRunnable(transformation)) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_TransformationMissedEntryOp,
            		transformation.getModuleName()));
        }
        
		ResourceSet validationRS = CompilerUtils.cloneResourceSet(transformation.getURI(), transformation.getResourceSet());
		
        Iterator<TargetUriData> itrTargetData = targetUris.iterator();
		for (TransformationParameter transfParam : transformation.getParameters()) {
			if (!itrTargetData.hasNext()) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
	            		transfParam.getName()));
			}
			
			IStatus nextStatus = validateTransformationParameter(transfParam, itrTargetData.next(), validationRS, validationType, isIncrementalUpdate);
            if (nextStatus.getSeverity() > result.getSeverity()) {
        		result = nextStatus;
        	}
		}

		if (isIncrementalUpdate) {
			IStatus traceStatus;			
			if (validationType == ValidationType.LIGHTWEIGHT_VALIDATION) {
				traceStatus = validateTraceObjectLightweight(traceFilePath, validationRS);
			} else {
				traceStatus = validateTraceObject(traceFilePath, validationRS);
			}
			
	        if (StatusUtil.isError(traceStatus)) {
	        	return traceStatus;
	        }
	        if (traceStatus.getSeverity() > result.getSeverity()) {
	    		result = traceStatus;
	    	}
		}
		
		if (useTrace) {
	    	IStatus traceStatus = validateTrace(traceFilePath, validationRS); 
	        if (StatusUtil.isError(traceStatus)) {
	        	return traceStatus;
	        }
	        if (traceStatus.getSeverity() > result.getSeverity()) {
	    		result = traceStatus;
	    	}
		}
		
        return result;
	}
	
	public static IStatus validateTransformation(QvtTransformation transformation, List<ModelContent> inModels,
			String traceFileName) throws MdaException {
        IStatus result = StatusUtil.makeOkStatus();
        
        if (!TransformationUtil.isRunnable(transformation)) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_TransformationMissedEntryOp,
            		transformation.getModuleName()));
        }
        
        Iterator<ModelContent> itrInObjs = inModels.iterator();
		for (TransformationParameter transfParam : transformation.getParameters()) {
			if (transfParam.getDirectionKind() == DirectionKind.IN
					|| transfParam.getDirectionKind() == DirectionKind.INOUT) {
				if (!itrInObjs.hasNext()) {
		            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_MissedInputTransfParam,
		            		transfParam.getName()));
				}

				IStatus nextStatus = validateTransformationParameterIn(transfParam, itrInObjs.next());
	            if (nextStatus.getSeverity() > result.getSeverity()) {
	        		result = nextStatus;
	        	}
			}
		}

		StringBuffer superfluousParams = new StringBuffer();
		while (itrInObjs.hasNext()) {
			if (superfluousParams.length() > 0) {
				superfluousParams.append(", "); //$NON-NLS-1$
			}
			ModelContent obj = itrInObjs.next();
			if (obj != null && !obj.getContent().isEmpty()) {
				superfluousParams.append(EmfUtil.getFullName(obj.getContent().get(0).eClass()));
			}
		}
		if (superfluousParams.length() > 0) {
			return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_SuperfluousInputTransfParam, superfluousParams.toString()));
		}

		if (traceFileName != null) {
	    	IStatus traceStatus = validateTrace(traceFileName, transformation.getResourceSet()); 
	        if (StatusUtil.isError(traceStatus)) {
	        	return traceStatus;
	        }
	        if (traceStatus.getSeverity() > result.getSeverity()) {
	    		result = traceStatus;
	    	}
		}
		
        return result;
	}
	
	private static IStatus validateTransformationParameter(TransformationParameter transfParam, TargetUriData targetData, ResourceSet validationRS,
			final ValidationType validationType, boolean isIncrementalUpdate) {
		if (transfParam.getMetamodels().isEmpty()) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
            		transfParam.getName()));
		}
		
		if (targetData.getContentProvider() != null) {
			return StatusUtil.makeOkStatus();
		}

		if (transfParam.getDirectionKind() == DirectionKind.IN) {
			if (validationType == ValidationType.LIGHTWEIGHT_VALIDATION) {
				return validateTransformationParameterInLightweight(transfParam, targetData, validationRS);
			} else {
				return validateTransformationParameterIn(transfParam, targetData, validationRS);
			}
		}
		if (transfParam.getDirectionKind() == DirectionKind.INOUT) {
			if (validationType == ValidationType.LIGHTWEIGHT_VALIDATION) {
				return validateTransformationParameterInOutLightweight(transfParam, targetData, validationRS);
			} else {
				return validateTransformationParameterInOut(transfParam, targetData, validationRS);
			}
		}
		
		if (validationType == ValidationType.LIGHTWEIGHT_VALIDATION) {
			return validateTransformationParameterOutLightweight(transfParam, targetData, validationRS, isIncrementalUpdate);
		} else {
			return validateTransformationParameterOut(transfParam, targetData, validationRS, isIncrementalUpdate);
		}
	}
	
	private static IStatus validateTrace(String traceFilePath, ResourceSet validationRS) {
	    try {
            if (traceFilePath == null || traceFilePath.length() == 0) {
                return StatusUtil.makeErrorStatus(Messages.QvtValidator_NoTraceFile);
            }
            else {
        		URI traceUri = URI.createURI(traceFilePath);
        		IStatus result = canSaveEx(null, StatusUtil.makeOkStatus(), traceUri, validationRS);
                if (StatusUtil.isError(result)) {
                	return result;
                }
            	
                if (!traceFilePath.endsWith(MDAConstants.QVTO_TRACEFILE_EXTENSION_WITH_DOT)) {
                	if (result.getSeverity() < IStatus.WARNING) {
                		result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_NoTraceFileExtension, MDAConstants.QVTO_TRACEFILE_EXTENSION_WITH_DOT));
                	}
                }
                return result;
            }	        
	    }
	    catch (Exception e) {
	        return StatusUtil.makeErrorStatus(e.getMessage(), e);
	    }
	}

	private static IStatus validateTraceObjectLightweight(String traceFilePath, ResourceSet validationRS) {
		URI sourceUri = EmfUtil.makeUri(traceFilePath);
		if (sourceUri == null) {
			return StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_InvalidTraceObjectUri, traceFilePath));
		}
		
		if (!EmfUtil.isUriExists(sourceUri, validationRS, false)) {
			return StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_InvalidTraceObjectUri, traceFilePath));
		}
		
		return StatusUtil.makeOkStatus();
	}

	private static IStatus validateTraceObject(String traceFilePath, ResourceSet validationRS) {
		URI sourceUri = EmfUtil.makeUri(traceFilePath);
        ModelContent in = null;
        
        try {
        	in = EmfUtil.loadModel(sourceUri, validationRS);
        }
        catch (Exception e) {
        }
        
        if (in == null) {
            return StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_InvalidTraceObjectUri, traceFilePath));
        }
        else {
	    	if (validationRS == null) {
	    		EmfUtil.cleanupResourceSet(in.getResourceSet());
	    	}
        }
        
		return StatusUtil.makeOkStatus();
	}
	
	private static IStatus validateTransformationParameterIn(TransformationParameter transfParam, TargetUriData targetData, ResourceSet validationRS) {
		if (transfParam.getEntryType() != null) {
			EClassifier classifier = transfParam.getEntryType();

			URI sourceUri = EmfUtil.makeUri(targetData.getUriString());
	        EObject in = null;
	        try {
	        	ModelContent loadModel = EmfUtil.loadModel(sourceUri, validationRS);
	        	in = (loadModel != null && !loadModel.getContent().isEmpty() ? loadModel.getContent().get(0) : null);
	        }
	        catch (Exception e) {
	        }
	        if (in == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, targetData.getUriString(), transfParam.getName()));
	        }
	        ResourceSet inputRs = (validationRS == null ? in.eResource().getResourceSet() : null);
	        try {
		        try {
		        	in = EmfUtil.resolveSource(in, classifier);
		        }
		        catch (WrappedException e) {
		            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, targetData.getUriString(), transfParam.getName()));
		        }
				
		    	if (!EmfUtil.isAssignableFrom(classifier, in.eClass()) || !classifier.isInstance(in)) {
		            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes, new Object[] {
		            		EmfUtil.getFullName(in.eClass()),
		            		EmfUtil.getFullName(classifier),
		            		transfParam.getName()
		            		}));
		    	}
	        }
	        finally {
	        	if (inputRs != null) {
	        		EmfUtil.cleanupResourceSet(inputRs);
	        	}
	        }
		}
		else {
			EPackage metamodel = transfParam.getMetamodels().get(0);

			URI sourceUri = EmfUtil.makeUri(targetData.getUriString());
	        ModelContent in = null;
	        
	        try {
	        	in = EmfUtil.loadModel(sourceUri, validationRS);
	        }
	        catch (Exception e) {
	        }
	        if (in == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, targetData.getUriString(), transfParam.getName()));
	        }
	        ResourceSet inputRs = (validationRS == null ? in.getResourceSet() : null);
	        try {
	        	in = in.getResolvedContent(metamodel);
	        }
	        catch (WrappedException e) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, targetData.getUriString(), transfParam.getName()));
	        }
	        finally {
	        	if (inputRs != null) {
	        		EmfUtil.cleanupResourceSet(inputRs);
	        	}
	        }
	        
        	/*
        	 * See: https://bugs.eclipse.org/bugs/show_bug.cgi?id=216903 (QVT run configuration should consider all objects in selected model)
        	 * 
	        if (EcoreUtil.getRootContainer(in.eClass()) != metamodel) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputMetamodels, 
	            		EmfUtil.getFullName(in.eClass()),
	            		EmfUtil.getMetamodelName(metamodel)
	            		));
	        }
	        */
		}
		
		return StatusUtil.makeOkStatus();
	}

	private static IStatus validateTransformationParameterInLightweight(TransformationParameter transfParam, TargetUriData targetData, ResourceSet validationRS) {
		URI sourceUri = EmfUtil.makeUri(targetData.getUriString());
		if (sourceUri == null) {
			return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, targetData.getUriString(), transfParam.getName()));
		}
		
		if (!EmfUtil.isUriExists(sourceUri, validationRS, false)) {
			return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, targetData.getUriString(), transfParam.getName()));
		}
		
		return StatusUtil.makeOkStatus();
	}

	private static IStatus validateTransformationParameterIn(TransformationParameter transfParam, ModelContent in) {
		if (transfParam.getMetamodels().isEmpty()) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam, transfParam.getName()));
		}

		if (transfParam.getEntryType() != null) {
			EClassifier classifier = transfParam.getEntryType();
			EObject inObj = (in != null && !in.getContent().isEmpty() ? in.getContent().get(0) : null);

	    	if (inObj == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes, new Object[] { 
	            		"<null>", //$NON-NLS-1$
	            		EmfUtil.getFullName(classifier),
	            		transfParam.getName()
	            		}));
	    	}
	    	else if (!EmfUtil.isAssignableFrom(classifier, inObj.eClass()) || !classifier.isInstance(inObj)) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes, new Object[] {
	            		EmfUtil.getFullName(inObj.eClass()),
	            		EmfUtil.getFullName(classifier),
	            		transfParam.getName()
	            		}));
	    	}
		}
		else {
//			EPackage metamodel = transfParam.getMetamodels().get(0);
//
//	        if (EcoreUtil.getRootContainer(in.eClass()) != metamodel) {
//	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputMetamodels, 
//	            		EmfUtil.getFullName(in.eClass()),
//	            		EmfUtil.getMetamodelName(metamodel)
//	            		));
//	        }
		}
		
		return StatusUtil.makeOkStatus();
	}

	private static IStatus validateTransformationParameterInOut(TransformationParameter transfParam, TargetUriData targetData, ResourceSet validationRS) {
		IStatus result = validateTransformationParameterIn(transfParam, targetData, validationRS);
		if (result.getSeverity() >= IStatus.WARNING) {
			return result;
		}

		URI sourceUri = URI.createURI(targetData.getUriString());
    	result = canSaveEx(transfParam, result, sourceUri, validationRS);
		return result;
	}

	private static IStatus validateTransformationParameterInOutLightweight(TransformationParameter transfParam, TargetUriData targetData, ResourceSet validationRS) {
		IStatus result = validateTransformationParameterInLightweight(transfParam, targetData, validationRS);
		if (result.getSeverity() >= IStatus.WARNING) {
			return result;
		}

		URI sourceUri = URI.createURI(targetData.getUriString());
    	result = canSaveEx(transfParam, result, sourceUri, validationRS);
		return result;
	}

	private static IStatus validateTransformationParameterOut(TransformationParameter transfParam, TargetUriData targetData,
			ResourceSet validationRS, boolean isIncrementalUpdate) {
        URI destUri = EmfUtil.makeUri(targetData.getUriString());
        if (destUri == null) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidTargetUri,
            		targetData.getUriString(), transfParam.getName()));
        }
        
        IStatus result = StatusUtil.makeOkStatus();
        switch(targetData.getTargetType()) {
        case NEW_MODEL: {
        	if (EmfUtil.isUriExists(destUri, validationRS, true)) {
                if (result.getSeverity() < IStatus.WARNING) {
                	if (EmfUtil.isUriExistsAsEObject(destUri, validationRS, true)) {
                		if (!isIncrementalUpdate) {
	                		result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExists,
	                				destUri, transfParam.getName()));
                		}
                	}
                	else {
                		result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExistsNonEObject,
                				destUri, transfParam.getName()));
                	}
                }
            }
            
        	IStatus canSave = canSave(transfParam, destUri, validationRS); 
            if (StatusUtil.isError(canSave)) {
            	return canSave;
            }
            if (canSave.getSeverity() > result.getSeverity()) {
        		result = canSave;
        	}
            
            if (destUri.hasFragment()) {
                if (result.getSeverity() < IStatus.WARNING) {
                    result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_NewDestinationHasFragment,
                    		destUri.fragment(), transfParam.getName()));
                }
            }
            break;
        }

        case EXISTING_CONTAINER: {
        	ModelContent loadModel = EmfUtil.loadModel(destUri, validationRS);
        	EObject eContainer = (loadModel != null && !loadModel.getContent().isEmpty() ? loadModel.getContent().get(0) : null);
        	if (eContainer == null) {
                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidTargetUri,
                		destUri, transfParam.getName()));
        	}
        	
        	result = canSaveEx(transfParam, result, destUri, validationRS);
            if (StatusUtil.isError(result)) {
            	return result;
            }
        	
        	String feature = targetData.getFeature();
        	if (feature == null || feature.trim().length() == 0) {
                if (!isIncrementalUpdate && result.getSeverity() < IStatus.WARNING) {
                	result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExists,
                			destUri, transfParam.getName()));
                }
        	}
        	else {
	        	EStructuralFeature eFeature = eContainer.eClass().getEStructuralFeature(feature);
	        	if (eFeature instanceof EReference == false) {
	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidFeature,
	                		feature, transfParam.getName()));
	        	}
	        	
	        	EReference ref = (EReference)eFeature;
	        	if (!ref.isChangeable()) {
	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidFeature,
	                		ref.getName(), transfParam.getName())); 
	        	}
	        	
	        	// no need for the check since always whole model extent is saved
//	        	EClassifier refType = ref.getEType();
//	        	if (!EmfUtil.isAssignableFrom(refType, classifier)) {
//	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes,
//	                		EmfUtil.getFullName(classifier), EmfUtil.getFullName(refType)));
//	        	}
        	}
        	
            break;
        }
        
        case INPLACE:
        	return StatusUtil.makeErrorStatus(Messages.QvtValidator_InplaceConfigNotSupported);
        }
        
		return result;
	}

	private static IStatus validateTransformationParameterOutLightweight(TransformationParameter transfParam, TargetUriData targetData,
			ResourceSet validationRS, boolean isIncrementalUpdate) {
        URI destUri = EmfUtil.makeUri(targetData.getUriString());
        if (destUri == null) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidTargetUri,
            		targetData.getUriString(), transfParam.getName()));
        }
        
        IStatus result = StatusUtil.makeOkStatus();
        switch(targetData.getTargetType()) {
        case NEW_MODEL: {
        	if (!isIncrementalUpdate && EmfUtil.isUriExists(destUri, validationRS, true)) {
                if (result.getSeverity() < IStatus.WARNING) {
               		result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExists,
               				destUri, transfParam.getName()));
                }
            }
            
        	IStatus canSave = canSave(transfParam, destUri, validationRS); 
            if (StatusUtil.isError(canSave)) {
            	return canSave;
            }
            if (canSave.getSeverity() > result.getSeverity()) {
        		result = canSave;
        	}
            
            if (destUri.hasFragment()) {
                if (result.getSeverity() < IStatus.WARNING) {
                    result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_NewDestinationHasFragment,
                    		destUri.fragment(), transfParam.getName()));
                }
            }
            break;
        }

        case EXISTING_CONTAINER: {
        	result = canSaveEx(transfParam, result, destUri, validationRS);
            if (StatusUtil.isError(result)) {
            	return result;
            }
        	
        	String feature = targetData.getFeature();
        	if (feature == null || feature.trim().length() == 0) {
                if (!isIncrementalUpdate && result.getSeverity() < IStatus.WARNING) {
                	result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExists,
                			destUri, transfParam.getName()));
                }
        	}
        	
            break;
        }
        
        case INPLACE:
        	return StatusUtil.makeErrorStatus(Messages.QvtValidator_InplaceConfigNotSupported);
        }
        
		return result;
	}

	private static IStatus canSave(TransformationParameter transfParam, URI destUri, ResourceSet validationRS) {
		URIConverter uriConverter = (validationRS != null ? validationRS.getURIConverter() : URIConverter.INSTANCE);
		URI converted = uriConverter.normalize(destUri);
		
		IStatus okStatus = StatusUtil.makeOkStatus();
		String scheme = converted.scheme();
		if (converted.isFile()) {
			if (!"file".equals(scheme) && !"platform".equals(scheme)) { //$NON-NLS-1$ //$NON-NLS-2$
				if (transfParam == null) {
					return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_UriNotFile,
							new Object[] {destUri, scheme}));
				}
				else {
					return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_UriNotFileParam,
							new Object[] {destUri, scheme, transfParam.getName()}));
				}
			}
		}
		return okStatus;
    }
	
	private static IStatus canSaveEx(TransformationParameter transfParam, IStatus result, URI destUri, ResourceSet validationRS) {
    	IFile file = WorkspaceUtils.getWorkspaceFile(destUri);
    	if (file != null && file.exists() && file.isReadOnly()) {
            if (result.getSeverity() < IStatus.WARNING) {
            	if (transfParam == null) {
                	result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationReadonly, destUri));
            	}
            	else {
                	result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationReadonlyParam,
                			destUri, transfParam.getName()));
            	}
            }
    	}

    	IStatus canSave = canSave(transfParam, destUri, validationRS); 
        if (StatusUtil.isError(canSave)) {
        	return canSave;
        }
		return result;
    }
	
}
