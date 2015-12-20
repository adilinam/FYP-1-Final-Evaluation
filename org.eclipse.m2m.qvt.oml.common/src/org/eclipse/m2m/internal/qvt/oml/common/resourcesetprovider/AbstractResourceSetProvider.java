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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;


/**
 * @author aigdalov
 * Created on Feb 26, 2008
 */
public abstract class AbstractResourceSetProvider implements IResourceSetProvider {
    private final List<IResourceSetProviderListener> myListeners = Collections.synchronizedList(new ArrayList<IResourceSetProviderListener>());

    public void addResourceSetProviderListener(IResourceSetProviderListener listener) {
        myListeners.add(listener);
    }

    public boolean removeResourceSetProviderListener(
            IResourceSetProviderListener listener) {
        return myListeners.remove(listener);
    }
    
    public void fireResourceSetChanged() {
        synchronized (myListeners) {
            for (IResourceSetProviderListener listener : myListeners) {
                listener.resourceSetChanged();
            }
        }
    }

    public void dispose(ResourceSet resourceSet) {
    }
}