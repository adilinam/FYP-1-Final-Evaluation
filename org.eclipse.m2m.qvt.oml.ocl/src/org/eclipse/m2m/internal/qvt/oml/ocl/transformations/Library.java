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
package org.eclipse.m2m.internal.qvt.oml.ocl.transformations;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.ocl.metainfo.OclMetainfo;


public interface Library extends EObject {
    String getId();

    String getNamespace();

    String getLibraryClassName();

    Class<?> getLibraryClass() throws LibraryCreationException;

    OclMetainfo getMetainfo() throws LibraryCreationException;

    Object getLibraryInstance();

    Collection<LibraryOperation> getLibraryOperations() throws LibraryCreationException;

    String[] getInMetamodels();

    String[] getOutMetamodels();

    void loadOperations() throws LibraryCreationException;

}
