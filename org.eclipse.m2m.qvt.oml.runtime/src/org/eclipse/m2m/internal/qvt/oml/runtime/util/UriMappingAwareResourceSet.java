/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.util;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapPackage;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MappingContainer;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MetamodelURIMappingHelper;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping;

/**
 * @author aigdalov
 * Created on Jun 26, 2008
 */
public class UriMappingAwareResourceSet implements ResourceSet {
    private final ResourceSet myDelegate;
    private MappingContainer myUriMap;

    public UriMappingAwareResourceSet(ResourceSet delegate, IFile myTransfFile) throws IOException {
        myDelegate = delegate;
        IProject project = myTransfFile.getProject();
        myUriMap = loadMappings(project);
    }

    public Resource getResource(URI uri, boolean loadOnDemand) {
        if (EmfUtil.isUriMapped(myDelegate, uri)) {
            return myDelegate.getResource(uri, loadOnDemand);
        }
        if ((uri != null) && (myUriMap != null)) {
            for (URIMapping uriMapping : myUriMap.getMapping()) {
                if (uriMapping.getSourceURI() != null) {
                    URI mappedUri = URI.createURI(uriMapping.getSourceURI());
                    if (uri.equals(mappedUri)) {
                        if (uriMapping.getTargetURI() != null) {
                            URI targetUri = URI.createURI(uriMapping.getTargetURI());
                            return myDelegate.getResource(targetUri, loadOnDemand);
                        }
                    }
                }
            }
        }
        return myDelegate.getResource(uri, loadOnDemand);
    }

    private static MappingContainer loadMappings(IProject project) throws IOException {
        // ensure mapping package gets into registry before loading
        MModelURIMapPackage.eINSTANCE.getNsURI();

        Resource res = MetamodelURIMappingHelper.createMappingResource(project);
        if(MetamodelURIMappingHelper.hasMappingResource(project)) {
            res.load(null);
        }
        
        return res.getContents().isEmpty() ? null : MetamodelURIMappingHelper.getMappings(res);
    }
    
    public Resource createResource(URI uri, String contentType) {
        return myDelegate.createResource(uri, contentType);
    }

    public Resource createResource(URI uri) {
        return myDelegate.createResource(uri);
    }

    public EList<Adapter> eAdapters() {
        return myDelegate.eAdapters();
    }

    public boolean eDeliver() {
        return myDelegate.eDeliver();
    }

    public void eNotify(Notification notification) {
        myDelegate.eNotify(notification);
    }

    public void eSetDeliver(boolean deliver) {
        myDelegate.eSetDeliver(deliver);
    }

    public EList<AdapterFactory> getAdapterFactories() {
        return myDelegate.getAdapterFactories();
    }

    public TreeIterator<Notifier> getAllContents() {
        return myDelegate.getAllContents();
    }

    public EObject getEObject(URI uri, boolean loadOnDemand) {
        return myDelegate.getEObject(uri, loadOnDemand);
    }

    public Map<Object, Object> getLoadOptions() {
        return myDelegate.getLoadOptions();
    }

    public Registry getPackageRegistry() {
        return myDelegate.getPackageRegistry();
    }

    public Resource.Factory.Registry getResourceFactoryRegistry() {
        return myDelegate.getResourceFactoryRegistry();
    }

    public EList<Resource> getResources() {
        return myDelegate.getResources();
    }

    public URIConverter getURIConverter() {
        return myDelegate.getURIConverter();
    }

    public void setPackageRegistry(Registry packageRegistry) {
        myDelegate.setPackageRegistry(packageRegistry);
    }

    public void setResourceFactoryRegistry(Resource.Factory.Registry resourceFactoryRegistry) {
        myDelegate.setResourceFactoryRegistry(resourceFactoryRegistry);
    }

    public void setURIConverter(URIConverter converter) {
        myDelegate.setURIConverter(converter);
    }
}