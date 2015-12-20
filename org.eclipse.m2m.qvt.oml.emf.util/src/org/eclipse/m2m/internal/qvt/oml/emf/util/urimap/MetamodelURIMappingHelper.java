/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.emf.util.urimap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtilPlugin;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.WorkspaceMetamodelProvider;
import org.eclipse.osgi.util.NLS;

public class MetamodelURIMappingHelper {

	private static final String MAPPING_CONTAINER = ".settings"; //$NON-NLS-1$ 
	
	private static final String MMODEL_URI_MAPPING_FILENAME = "org.eclipse.m2m.qvt.oml.mmodel.urimap"; //$NON-NLS-1$
	

	private MetamodelURIMappingHelper() {
		super();
	}
	
	public static IFile getMappingFileHandle(IProject project) {
		return project.getFolder(MAPPING_CONTAINER).getFile(MMODEL_URI_MAPPING_FILENAME);
	}
	
	/**
	 * Persists the given metamodel URI mappings for the given project.
	 * 
	 * @param project the project to which to associate the mappings  
	 * @param mappings container of mappings to be persisted
	 * @param merge indicate whether the passed mappings should be merged with 
	 * existing if any or overwrite them.
	 * 
	 * @return the resulting status of the save mappings operation
	 * @throws IllegalArgumentException if <code>project<code> or <code>mappings</code> is <code>null</code>
	 */
	public static IStatus saveMappings(IProject project, MappingContainer mappings, boolean merge) {
		if(mappings == null || project == null) {
			throw new IllegalArgumentException();
		}
		
		try {	
			Resource resource = null;
			
			if(hasMappingResource(project) && merge) {
				MappingContainer result = loadMappings(project);
				resource = result.eResource();
				// merge with existing mappings
				Map<String, URIMapping> currentMap = new HashMap<String, URIMapping>();
				for (URIMapping nextMapping : result.getMapping()) {
					if(nextMapping.getSourceURI() != null) {
						currentMap.put(nextMapping.getSourceURI(), nextMapping);
					}
				}
				
				for (URIMapping newMapping : mappings.getMapping()) {
					URIMapping oldMapping = currentMap.get(newMapping.getSourceURI());
					if(oldMapping != null) {
						oldMapping.setTargetURI(newMapping.getTargetURI());
					} else {
						result.getMapping().add((URIMapping)EcoreUtil.copy(newMapping));
					}
				}
				
			} else {
				resource = createMappingResource(project);
				resource.getContents().add(mappings);				
			}
			
			resource.save(null);
			
		} catch (IOException e) {
			return new Status(IStatus.ERROR, EmfUtilPlugin.ID, "Failed to save metamodel URI mappings", e); //$NON-NLS-1$
		} finally {
			try {
				project.refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (CoreException e) {
				// well, not much we can do here 
			}
		}
		
		return Status.OK_STATUS;
	}
	
	public static Resource createMappingResource(IProject project) {
    	// ensure mapping package gets into registry before loading
    	MModelURIMapPackage.eINSTANCE.getNsURI();

		IFile file = getMappingFileHandle(project);
    	URI mapFileUri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);    

    	ResourceSet rs = new ResourceSetImpl();
		Resource res = rs.getResource(mapFileUri, false);
		if(res == null) {
			res = rs.createResource(mapFileUri);
		}
		
		return res;
	}
	
	public static MappingContainer loadMappings(IProject project) throws IOException {
		Resource res = createMappingResource(project);
		res.load(null);
		return getMappings(res);
	}
	
	public static boolean hasMappingResource(IProject project) {
		return getMappingFileHandle(project).exists();
	}
	
	public static MappingContainer getMappings(Resource resource) {
		for (EObject root : resource.getContents()) {
			if(root instanceof MappingContainer) {
				return (MappingContainer) root;
			}
		}

		return null;
	}
	
	public static MappingContainer createNewMappings(Resource resource) {
		if(getMappings(resource) != null) {
			throw new IllegalArgumentException("Resource already has mappings"); //$NON-NLS-1$
		}
		
		MappingContainer container = MModelURIMapFactory.eINSTANCE.createMappingContainer();
		resource.getContents().add(container);		
		return container;
	}

	public static EPackage.Registry mappingsToEPackageRegistry(final IProject project, ResourceSet resourceSet) {
		if (!hasMappingResource(project)) {
			return null;
		}

		IMetamodelProvider provider = createMetamodelProvider(project, MetamodelRegistry.getDefaultMetamodelProvider(),
				resourceSet);

		return provider.getPackageRegistry();
	}

	public static IMetamodelProvider createMetamodelProvider(IProject project, IMetamodelProvider delegate,
			ResourceSet resourceSet) {

		MappingContainer mappings;

		try {
			mappings = loadMappings(project);
		} catch (IOException e) {
			EmfUtilPlugin.log(e);
			return delegate;
		}

		WorkspaceMetamodelProvider metamodelProvider = new WorkspaceMetamodelProvider(delegate, resourceSet);

		for (URIMapping nextMapping : mappings.getMapping()) {
			URI uri = null;
			IllegalArgumentException error = null;
			try {
				uri = URI.createURI(nextMapping.getTargetURI());
			} catch (IllegalArgumentException e) {
				error = e;
			}

			if (uri != null && nextMapping.getSourceURI() != null) {
				metamodelProvider.addMetamodel(nextMapping.getSourceURI(), uri);
			} else {
				String message = NLS.bind("Invalid metamodel uri mapping. nsUri:''{0}'' modelUri:''{1}''", //$NON-NLS-1$
						nextMapping.getSourceURI(), nextMapping.getTargetURI());
				EmfUtilPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, EmfUtilPlugin.ID, message, error));

			}
		}

		return metamodelProvider;
	}

}
