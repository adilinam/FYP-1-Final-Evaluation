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

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class CFileUtil {
	private CFileUtil() {}
	
    public static Reader getReader(CFile file) throws IOException {
    	String charset = file.getCharset();
    	
    	Reader reader;
    	if(charset == null) {
    		reader = new InputStreamReader(file.getContents());
    	}
    	else {
    		reader = new InputStreamReader(file.getContents(), charset);
    	}
    	
    	return reader;
    }
    
}
