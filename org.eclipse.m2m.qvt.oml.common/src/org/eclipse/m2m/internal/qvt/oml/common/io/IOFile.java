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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class IOFile extends IOResource implements CFile {
    public IOFile(String file) {
        this(new File(file));
    }
    
	public IOFile(File file) {
		super(file);
        if(file.exists() && !file.isFile()) {
            throw new IllegalArgumentException("Not a file: " + file); //$NON-NLS-1$
        }
        
        myUnitName = myFile.getName();
        int dot = myUnitName.lastIndexOf('.');
        if(dot != -1) {
            myUnitName = myUnitName.substring(0, dot);
        }
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof IOFile && 
			((IOFile)other).myFile.equals(myFile);
	}
	
	@Override
	public int hashCode() {
		return myFile.hashCode(); 
	}
	
	public InputStream getContents() throws IOException {
		return new FileInputStream(myFile);
	}
	
	public String getUnitName() {
		return myUnitName;
	}
	
	public String getCharset() throws IOException {
		return getWorkspaceCharset();
	}
	
	private String myUnitName;
}
