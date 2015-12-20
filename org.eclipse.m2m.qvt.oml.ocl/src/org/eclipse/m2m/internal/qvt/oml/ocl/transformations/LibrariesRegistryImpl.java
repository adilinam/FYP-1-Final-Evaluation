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
/*
 * Created on Jun 29, 2005
 */
package org.eclipse.m2m.internal.qvt.oml.ocl.transformations;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.m2m.internal.qvt.oml.ocl.Logger;


public class LibrariesRegistryImpl implements LibrariesRegistry {

    private static final String LIBRARY_TAG = "library"; //$NON-NLS-1$

    private final Collection<Library> myLibraries;

    public LibrariesRegistryImpl(IConfigurationElement[] configurations) {
        myLibraries = Collections.unmodifiableCollection(load(configurations));
    }

    public Collection<Library> getLibraries() {
        return myLibraries;
    }
    
    public Library getLibrary(String id) {
        for (Library lib : getLibraries()) {
            if (lib.getId().equals(id)) {
                return lib;
            }
        }
        
        return null;
    }
    
    private static Collection<Library> load(IConfigurationElement[] configurations) {
        Set<Class<?>> registeredLibraryClasses = new HashSet<Class<?>>();
        Collection<Library> libraries = new LinkedList<Library>();
        for (int i = 0; i < configurations.length; i++) {
            if (!LIBRARY_TAG.equals(configurations[i].getName())) {
                Logger.getLogger().log(Logger.WARNING,
                        "Unrecognized tag passed into" //$NON-NLS-1$
                                + " TransformationConfigurationReader: " //$NON-NLS-1$
                                + configurations[i].getName());
                continue;
            }
            try {
                Library nextLibrary = new LibraryImpl(configurations[i]);
                if (!registeredLibraryClasses.contains(nextLibrary
                        .getLibraryClass())) {
					libraries.add(nextLibrary);
                    registeredLibraryClasses.add(nextLibrary.getLibraryClass());
                } else {
                    Logger.getLogger().log(Logger.SEVERE,
                            "Same library with the same class was registered twice. Skipping: " //$NON-NLS-1$
                                    + configurations[i].getNamespaceIdentifier());
                }
            } catch (LibraryCreationException e) {
                Logger.getLogger().log(Logger.SEVERE,
                        "LibraryImpl was not created", e); //$NON-NLS-1$
            }
        }
		return libraries;
    }
}
