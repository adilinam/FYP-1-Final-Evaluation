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
package org.eclipse.m2m.internal.qvt.oml.emf.util;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

/** @author pkobiakov */
public class WorkspaceUtils {
	private WorkspaceUtils() {}
	
    public static IFile getIFile(String fileUnderWorkspace) {
		IPath location = new Path(fileUnderWorkspace);
		IFile ifile = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(location);
		return ifile;
	}
    
    public static IFile getWorkspaceFile(String name) {
        try {
            IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(name));
            return file;
        }
        catch(Exception e) {
            return null;
        }
    }
    
    public static IFile getWorkspaceFile(URI uri) {
		String uriPath;
		if (uri.isFile()) {
			uriPath = uri.toFileString();
		}
		else if (uri.isPlatform()) {
			uriPath = uri.toPlatformString(true);
		}
		else {
			uriPath = uri.toString();
		}
		IFile ifile = getWorkspaceFile(uriPath);
		
		if (ifile == null || !ifile.exists()) {
			if (uri.isFile()) {
				IFile wsfile = getIFile(uriPath);
				if (wsfile != null && wsfile.exists()) {
					return wsfile;
				}
			}
		}
		return ifile;
    }
    
    public static IContainer getIContainer(String folderUnderWorkspace) {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IPath location = new Path(folderUnderWorkspace);
        IContainer cont = workspace.getRoot().getContainerForLocation(location);
        return cont;
    }
    
}
