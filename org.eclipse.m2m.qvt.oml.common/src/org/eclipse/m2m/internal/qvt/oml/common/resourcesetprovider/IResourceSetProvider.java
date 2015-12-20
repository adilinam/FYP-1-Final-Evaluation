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
package org.eclipse.m2m.internal.qvt.oml.common.resourcesetprovider;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;

/**
 * @author aigdalov
 * Created on Feb 26, 2008
 */
public interface IResourceSetProvider {
    public ResourceSet getResourceSet(CFile script);
    public void dispose(ResourceSet resourceSet);
    public void addResourceSetProviderListener(IResourceSetProviderListener listener);
    public boolean removeResourceSetProviderListener(IResourceSetProviderListener listener);
}