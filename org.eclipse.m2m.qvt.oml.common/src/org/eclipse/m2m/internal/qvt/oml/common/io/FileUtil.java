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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class FileUtil {
	private FileUtil() {}
	
	public static void copyFolder(File sourceDir, File destDir) throws IOException {
        if (!sourceDir.isDirectory()) {
            throw new RuntimeException("sourceDir '" + sourceDir.getAbsolutePath() + "' must be an existing directory"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        if (!destDir.isDirectory()) {
            throw new RuntimeException("destDir '" + destDir.getAbsolutePath() + "' must be an existing directory"); //$NON-NLS-1$ //$NON-NLS-2$
        }   
        
        File[] children = sourceDir.listFiles();
        for(int i = 0;  i< children.length; i++) {
        	File source = children[i];
            File dest = new File(destDir, source.getName());
        	
            if(source.isDirectory()) {
            	dest.mkdir();
                copyFolder(source, dest);
            }
            else {
                copyFile(source, dest);
            }
        }
    }
    
    public static void copyFile(File from, File to) throws IOException {
    	FileInputStream input = null;
        FileOutputStream output = null;
        try {
        	input = new FileInputStream(from);
        	output = new FileOutputStream(to);

        	copyStream(input, output);
        }
        finally {
        	if(input != null) {
        		try { input.close(); } catch(IOException e) {}
        	}
        	
        	if(output != null) {
        		try { output.close(); } catch(IOException e) {}
        	}
        }
    }
    
    public static void setContents(File to, InputStream input) throws IOException {
        FileOutputStream output = null;
        try {
        	output = new FileOutputStream(to);
        	copyStream(input, output);
        }
        finally {
        	if(output != null) {
        		try { output.close(); } catch(IOException e) {}
        	}
        }
    }
    
    private static void copyStream(InputStream input, OutputStream output) throws IOException {
    	byte[] buffer = new byte[8192];
        int read;
        while((read=input.read(buffer)) > 0) {
        	output.write(buffer, 0, read);
        }
    }

	public static String getStreamContents(InputStream stream, String charset) throws IOException {
	    StringBuffer contents = new StringBuffer();
	    char[] buf = new char[4096];
	    InputStreamReader reader = null;
	    
	    try {
	        if(charset == null) {
	        	reader = new InputStreamReader(stream);
	        }
	        else {
	        	reader = new InputStreamReader(stream, charset);
	        }
	        
	        int read;
	        while((read = reader.read(buf)) > 0) {
	            contents.append(buf, 0, read);
	        }
	        return contents.toString();
	    } 
	    finally {
	        try { reader.close(); } catch(Exception e) {}
	    }
	}

    public static void delete(File file) {
        if(file.isDirectory()) {
            File[] children = file.listFiles();
            for(int i = 0; i < children.length; i++) {
                delete(children[i]);
            }
        }
        
        file.delete();
    }	
	    
}
