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
package org.eclipse.m2m.internal.qvt.oml.common.io;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;

public class IOResource implements CResource {
	public IOResource(File file) {
		myFile = file.getAbsoluteFile();
	}
	
	public String getName() {
		return myFile.getName();
	}
    
    public static String getExtension(String name) {
        int lastDot = name.lastIndexOf('.');
        if(lastDot == -1 || lastDot == name.length()-1) {
            return ""; //$NON-NLS-1$
        }
        else {
            return name.substring(lastDot+1);
        }
    }

	public String getFullPath() {
		return myFile.getAbsolutePath();
	}
	
	public boolean exists() {
		return myFile.exists();
	}
	
	public CFolder getParent() {
		return new IOFolder(myFile.getParentFile());
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof IOResource && 
			((IOResource)other).myFile.equals(myFile);
	}
	
	@Override
	public int hashCode() {
		return myFile.hashCode(); 
	}
	
	@Override
	public String toString() {
		return String.valueOf(myFile);
	}

    public static String getWorkspaceCharset() {
		return ResourcesPlugin.getEncoding();
    }
    
	protected final File myFile;
}
