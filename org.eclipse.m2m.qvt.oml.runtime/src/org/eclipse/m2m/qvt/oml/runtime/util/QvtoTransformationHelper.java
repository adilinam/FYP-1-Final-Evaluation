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
package org.eclipse.m2m.qvt.oml.runtime.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegateBase;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtCompilerFacade;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtModule;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.Messages;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.osgi.util.NLS;

/**
 * @author sboyko
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @deprecated use {@link TransformationExecutor} class instead 
 */
public class QvtoTransformationHelper {

	/**
	 * This interface provides read-only access to the contents of a model extent.
	 */
	public interface ModelExtent {
		/**
		 * Gets the elements which were initially contained at the creation time of this extent.
		 */
		List<EObject> getInitialElements();
		/**
		 * Gets all the root objects of the current extent contents.
		 * Note: The result may include the original objects if not removed or moved to container.
		 */
		List<EObject> getAllRootElements();
	}	
	
	public static interface TransfExecutionResult {

		/**
		 * 
		 * @return List of resources (model extents) created for each 'inout' / 'out' model parameter. Extent contains root objects only.
		 * <br>Model parameter comes from 'transformation' definition: <br> <code>transformation T(inout model1 : ecore, out model2 : uml);</code>
		 */
		List<ModelExtent> getOutModelExtents();
		
		/**
		 * 
		 * @return List of transformation output parameters created for each 'out' parameter of transformation's entry operation.
		 * <br>Output parameter comes from transformation's main() operation: <br> <code>main(out outParam : ecore::EPackage@model1) { .. }</code>
		 */
		List<EObject> getOutParameters();
		
		/**
		 * 
		 * @return Console output produced by transformation.
		 */
		String getConsoleOutput();
	}
	
	/**
	 * @param transfUri uri of the transformation script: <br>
	 * files like <code>file:/</code> <br>
	 * platform resources like <code>platform:/resource/</code> <br>  
	 * platform plugins like <code>platform:/plugin/</code> <br>
	 */
	public QvtoTransformationHelper(URI transfUri) {
		myTransfUri = transfUri;
	}
	
	public QvtoTransformationHelper(IFile qvtoFile) {
		this(URI.createPlatformResourceURI(qvtoFile.getFullPath().toString(), false));
	}
		
	public TransfExecutionResult executeTransformation(final List<? extends EObject> inObjects, final Map<String, Object> inConfigProperties, ResourceSet metamodelResourceSet) throws CoreException {
        try {
            if (metamodelResourceSet == null) {
                metamodelResourceSet = new ResourceSetImpl();
            }
            QvtModule qvtModule = TransformationUtil.getQvtModule(myTransfUri);

            final List<ModelExtentContents> outExtents = new ArrayList<ModelExtentContents>();
        	final List<EObject> outMainParams = new ArrayList<EObject>();
        	final List<Trace> outTraces = new ArrayList<Trace>(1);
        	final List<String> outConsole = new ArrayList<String>(1);
            final QvtInterpretedTransformation transf = new QvtInterpretedTransformation(qvtModule);
        	
        	QvtCompilerOptions options = new QvtCompilerOptions();
        	options.setGenerateCompletionData(false);
        	//options.setMetamodelResourceSet(wrappedMetamodelResourceSet);
        	transf.setQvtCompilerOptions(options);
        	
            ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {
                public void run() throws Exception {
                	List<ModelContent> inModels = new ArrayList<ModelContent>(inObjects.size());
                	for (EObject inObj : inObjects) {
                		inModels.add(new ModelContent(Collections.singletonList(inObj)));
                	}
            		QvtLaunchConfigurationDelegateBase.doLaunch(transf, inModels, inConfigProperties,
            				outExtents, outMainParams, outTraces, outConsole);
            		
            		transf.cleanup();
                }

            };
            
            r = QvtLaunchConfigurationDelegateBase.getSafeRunnable(transf, r);
            r.run();
            
            final List<ModelExtent> extents = new ArrayList<ModelExtent>();
            for (ModelExtentContents nextExtent : outExtents) {
            	final ModelExtentContents internExtent = nextExtent;
				
            	ModelExtent modelExtent = new ModelExtent() {
					public List<EObject> getAllRootElements() {					
						return internExtent.getAllRootElements();
					}
					public List<EObject> getInitialElements() {						
						return internExtent.getInitialElements();
					}
				};
				
				extents.add(modelExtent);
			}
            
            return new TransfExecutionResult() {
				public List<ModelExtent> getOutModelExtents() {
					return extents;
				}

				public List<EObject> getOutParameters() {
					return outMainParams;
				}
				
				public String getConsoleOutput() {
					return outConsole.isEmpty() ? "" : outConsole.get(0); //$NON-NLS-1$
				}
            };
        } 
		catch (MdaException e) {
			throw new CoreException(e.getStatus() != null ? e.getStatus() : new Status(IStatus.ERROR, QvtRuntimePlugin.ID, e.getMessage()));
		}
		catch (CoreException e) {
			throw e;
		}
		catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, QvtRuntimePlugin.ID, e.getMessage()));
		}
	}
	
	/**
	 * 
	 * @return List(Transformation File URI)
	 * <ul>
	 * <li> File URI is workspace-relative created with URI.createPlatformResourceURI() call
	 * <li> All returned file URIs necessarily belong to single workspace plugin
	 * </ul>
	 * @throws CoreException in case file URI cannot be converted to workspace-relative scheme 
	 */
	public List<URI> getImportedTransformations() throws CoreException {
		try {
			List<URI> importUris = new ArrayList<URI>();
			
			QvtCompilerOptions compilerOptions = new QvtCompilerOptions();
			compilerOptions.setGenerateCompletionData(true);
			CompiledUnit compiledUnit = QvtCompilerFacade.getCompiledModule(myTransfUri, compilerOptions, null).getCompiledModule();		
			
			{
				
				IFile file = URIUtils.getFile(compiledUnit.getURI());
				if (file == null) {
					throw new MdaException(NLS.bind(Messages.ImportedTransformation_NoWsFileForLocation, compiledUnit.getURI().toPlatformString(true)));
				}
				importUris.add(compiledUnit.getURI());
			}
			
			Set<CompiledUnit> imports = new LinkedHashSet<CompiledUnit>();
			QvtOperationalParserUtil.collectAllImports(compiledUnit, imports);
			
			for (CompiledUnit importedUnit : imports) {
				URI unitURI = importedUnit.getURI();
				IFile ifile = URIUtils.getFile(unitURI);
				if (ifile == null) {
					continue;
				}
				
				importUris.add(URI.createPlatformResourceURI(ifile.getFullPath().toString(), false));
			}
			
			return importUris;
		}
		catch (MdaException e) {
			throw new CoreException(new Status(IStatus.ERROR, QvtRuntimePlugin.ID, e.getMessage()));
		}
	}

	public List<String> getInputModelExtensions() throws CoreException {
		try {
			QvtModule qvtModule = TransformationUtil.getQvtModule(myTransfUri);
	
			List<String> extensions = new ArrayList<String>();
			for (TransformationParameter param : qvtModule.getParameters()) {
				if (param.getDirectionKind() == DirectionKind.OUT) {
					continue;
				}
				if (!param.getMetamodels().isEmpty()) {
					extensions.add(param.getMetamodels().get(0).getName());
				}
			}
			
			return extensions;
		}
		catch (MdaException e) {
			throw new CoreException(new Status(IStatus.ERROR, QvtRuntimePlugin.ID, e.getMessage()));
		}
	}

	private final URI myTransfUri;

}
