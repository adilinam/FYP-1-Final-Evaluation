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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.controls;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

/**
 * @author sboyko
 *
 */
public class IPathUtils {
	private IPathUtils() {}

    public static URI getUri(IPath modelPath) {
        if (modelPath == null) {
            return null;
        }
        return URI.createPlatformResourceURI(modelPath.toString(), false);
    }
	
    public static IPath computePath(IResource resource, String fname) {
        IPath path;
        if(resource == null) {
            path = null;
        }
        else {
            if(resource instanceof IFile) {
                if(resource.getName().equals(fname)) {
                    path = resource.getFullPath();
                }
                else {
                    path = makePath(resource.getParent(), fname);
                }
            }
            else {
                path = makePath(resource, fname);
            }
        }
        
        return path;
    }
    
    private static IPath makePath(IResource parent, String childName) {
        IPath path;
        if(childName == null || childName.length() == 0) {
            path = null;
        }
        else {
            path = parent.getFullPath().append(childName);
        }
        
        return path;
    }
}
