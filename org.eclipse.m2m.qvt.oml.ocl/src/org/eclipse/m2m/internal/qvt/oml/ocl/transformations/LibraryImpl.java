/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
/*
 * Created on May 31, 2005
 */
package org.eclipse.m2m.internal.qvt.oml.ocl.transformations;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.m2m.internal.qvt.oml.ocl.Logger;
import org.eclipse.m2m.internal.qvt.oml.ocl.metainfo.OclMetainfo;
import org.eclipse.m2m.internal.qvt.oml.ocl.metainfo.OclMetainfoClassLazyLoader;
import org.eclipse.m2m.internal.qvt.oml.ocl.metainfo.OclMetainfoOperation;
import org.osgi.framework.Bundle;


public class LibraryImpl extends EObjectImpl implements Library {

    LibraryImpl(IConfigurationElement configuration)
            throws LibraryCreationException {
        myConfiguration = configuration;
        load();
    }

    public String[] getInMetamodels() {
        return myInMetamodel;
    }

    public String[] getOutMetamodels() {
        return myOutMetamodel;
    }

    public Collection<LibraryOperation> getLibraryOperations() throws LibraryCreationException {
        if (myLibraryOperations == null) {
            myLibraryOperations = getLibraryOperations(this);
        }

        return myLibraryOperations;
    }

    public OclMetainfo getMetainfo() throws LibraryCreationException {
        if (myMetainfo == null) {
            myMetainfo = new OclMetainfo(new OclMetainfoClassLazyLoader(getLibraryClass()));
        }
        return myMetainfo;
    }

    public static Collection<LibraryOperation> getLibraryOperations(Library library) throws LibraryCreationException {
        Collection<LibraryOperation> operations = new LinkedList<LibraryOperation>();
        List<OclMetainfoOperation> mOperations = library.getMetainfo().getOperations();
        for (OclMetainfoOperation operation : mOperations) {
            try {
                operations.add(new LibraryOperationImpl(operation, library));
            } catch (LibraryOperationException e) {
                Logger.getLogger().log(Logger.SEVERE,
                        "Unable to instantiate LibraryOperationImpl", e); //$NON-NLS-1$
                throw new LibraryCreationException(MessageFormat.format(
                        Messages.LibraryImpl_LoadErrorDueToOperation,
                        new Object[] { library.getLibraryClass().getName(),
                                operation.getName() }), e);
            }
        }        
        return operations;
    }

    public String getId() {
        return myId;
    }

    public String getNamespace() {
        return myConfiguration.getNamespaceIdentifier();
    }

    public String getLibraryClassName() {
        return myClassName;
    }

    public Class<?> getLibraryClass() throws LibraryCreationException {
        if (myLibraryClass == null) {
            String namespace = myConfiguration.getNamespaceIdentifier();
            Bundle bundle = Platform.getBundle(namespace);
            try {
                myLibraryClass = bundle.loadClass(getLibraryClassName());
            } catch (ClassNotFoundException e) {
                Logger.getLogger().log(Logger.SEVERE,
                        "Specified library class not found", e); //$NON-NLS-1$
                throw new LibraryCreationException(MessageFormat.format(
                        Messages.LibraryImpl_ClassNF,
                        new Object[] { getLibraryClassName() }), e);
            }
        }
        return myLibraryClass;
    }

    public Object getLibraryInstance() {
        if (myInstance == null) {
            try {
                myInstance = myConfiguration
                        .createExecutableExtension(CLASS_ATTR);
            } catch (CoreException e) {
                Logger.getLogger().log(Logger.SEVERE,
                        "Unable to instantiate library class", e); //$NON-NLS-1$
            }
        }
        return myInstance;
    }
    
    @Override
    public String toString() {
    	return "OCL library " + myClassName; //$NON-NLS-1$
    }

    private void load() throws LibraryCreationException {
        myInMetamodel = loadMetamodelURIs(myConfiguration
                .getChildren(IN_MM_TAG));
        myOutMetamodel = loadMetamodelURIs(myConfiguration
                .getChildren(OUT_MM_TAG));
        myClassName = myConfiguration.getAttribute(CLASS_ATTR);
        if (myClassName == null) {
            Logger.getLogger().log(Logger.SEVERE,
                    "Class was not specified for " //$NON-NLS-1$
                            + myConfiguration.getNamespaceIdentifier());
            throw new LibraryCreationException(Messages.LibraryImpl_ClassNS);
        }

        myId = myConfiguration.getAttribute(ID_ATTR);
        if (myId == null) {
            Logger.getLogger().severe(
                    "Id not specified for " + myConfiguration.getNamespaceIdentifier()); //$NON-NLS-1$
            throw new LibraryCreationException(MessageFormat.format(
                    Messages.LibraryImpl_IdNS, new Object[] {}));
        }
    }

    private String[] loadMetamodelURIs(IConfigurationElement[] metamodels) {
        Collection<String> mmURIs = new ArrayList<String>();
        for (int i = 0; i < metamodels.length; i++) {
            String nextUri = metamodels[i].getAttribute(URI_ATTR);
            if (nextUri == null) {
                Logger.getLogger().log(Logger.SEVERE,
                        "Metamodel URI not specified for: " + myClassName); //$NON-NLS-1$
                continue;
            }
            mmURIs.add(nextUri);
        }
        return mmURIs.toArray(new String[mmURIs.size()]);
    }

    public void loadOperations()
            throws LibraryCreationException {
        for (LibraryOperation nextOperation : getLibraryOperations()) {
            try {
                nextOperation.load();
            } catch (LibraryOperationException e) {
                Logger.getLogger().log(Logger.SEVERE,
                        "Library operation loading error, " //$NON-NLS-1$
                                + "library loading stopped", //$NON-NLS-1$
                        e);
                throw new LibraryCreationException(MessageFormat.format(
                        Messages.LibraryImpl_LoadErrorDueToOperation,
                        new Object[] { getId(), nextOperation.getName() }), e);
            }
        }
    }

    private static final String ID_ATTR = "id"; //$NON-NLS-1$

    private static final String CLASS_ATTR = "class"; //$NON-NLS-1$

    private static final String IN_MM_TAG = "inMetamodel"; //$NON-NLS-1$

    private static final String OUT_MM_TAG = "outMetamodel"; //$NON-NLS-1$

    private static final String URI_ATTR = "uri"; //$NON-NLS-1$

    private IConfigurationElement myConfiguration;

    private String[] myInMetamodel;

    private String[] myOutMetamodel;

    private Object myInstance;

    private String myId;
    
    private String myClassName;

    private Class<?> myLibraryClass;

    private Collection<LibraryOperation> myLibraryOperations;

    private OclMetainfo myMetainfo;

}
