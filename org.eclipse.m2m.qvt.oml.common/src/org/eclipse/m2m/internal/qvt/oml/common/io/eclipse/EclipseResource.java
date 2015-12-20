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
package org.eclipse.m2m.internal.qvt.oml.common.io.eclipse;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.internal.qvt.oml.common.io.CResource;


public class EclipseResource implements CResource {
	public EclipseResource(IResource resource) {
		myResource = resource;
	}
	
	public String getName() {
		return myResource.getName();
	}
    
	public String getFullPath() {
        IPath location = myResource.getLocation();
        if(location != null) {
            return location.toOSString();
        }
        
        String fullName = getParent() == null ? getName() : getParent().getFullPath() + File.separator + getName();
        return fullName; 
	}
	
	public boolean exists() {
		return myResource.exists();
	}

	public CFolder getParent() {
		IContainer parent = myResource.getParent();
        if(parent == null) {
            return null;
        }
        
		return EclipseContainer.makeFolder(parent);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof EclipseResource && 
			((EclipseResource)other).myResource.equals(myResource);
	}
	
	@Override
	public int hashCode() {
		return myResource.hashCode(); 
	}
	
	@Override
	public String toString() {
		return String.valueOf(myResource);
	}
	
	public IResource getResource() {
		return myResource;
	}
    
	protected final IResource  myResource;
}
