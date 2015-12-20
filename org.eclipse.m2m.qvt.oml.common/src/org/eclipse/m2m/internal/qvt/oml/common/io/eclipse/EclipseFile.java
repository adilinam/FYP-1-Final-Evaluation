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

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;


/**
 * @author pfeldman
 */
public class EclipseFile extends EclipseResource implements CFile {
	public EclipseFile(org.eclipse.core.resources.IFile file) {
		super(file);
        myUnitName = file.getName();
        int dot = myUnitName.lastIndexOf('.');
        if(dot != -1) {
            myUnitName = myUnitName.substring(0, dot);
        }
	}
	
	public InputStream getContents() throws IOException {
		try {
			return getFile().getContents();
		} 
		catch(CoreException e) {
			IOException io = new IOException();
			io.initCause(e);
			throw io;
		}
	}
	
	public String getUnitName() {
		return myUnitName;
	}
	
	public String getCharset() throws IOException {
		try {
			String charset = getFile().getCharset();
			return charset;
		}
		catch (CoreException e) {
			IOException io = new IOException();
			io.initCause(e);
			throw io;
		}
	}
	
	public org.eclipse.core.resources.IFile getFile() {
		return (org.eclipse.core.resources.IFile)myResource;
	}
	
	@Override
	public String toString() {
		return getFile().toString();
	}
	
	private String myUnitName;
}
