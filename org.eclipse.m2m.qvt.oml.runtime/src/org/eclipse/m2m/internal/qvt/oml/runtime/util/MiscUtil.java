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
package org.eclipse.m2m.internal.qvt.oml.runtime.util;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFileUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.osgi.util.NLS;

/**
 * @author pkobiakov
 */
public class MiscUtil {
	private MiscUtil() {}

    
    public static IStatus makeErrorStatus(Exception e) {
        return new Status(IStatus.ERROR, QvtRuntimePlugin.ID, IStatus.ERROR, NLS.bind(Messages.MiscUtil_ErrorMessage, e.getMessage()), e);
    }
    
	public static IStatus makeErrorStatus(String message, Exception e) {
		return new Status(IStatus.ERROR, QvtRuntimePlugin.ID, IStatus.ERROR, message, e);
	}

	public static IStatus makeErrorStatus(String message) {
		return new Status(IStatus.ERROR, QvtRuntimePlugin.ID, IStatus.ERROR, message, null);
	}	
	
	public static String readStream(CFile file) throws IOException {
	    return readAndClose(CFileUtil.getReader(file));
	}

	public static String readAndClose(Reader reader) throws IOException {
	    StringBuffer contents = new StringBuffer();
	    try {
	        char[] buf = new char[4096];
	        int read;
	        while((read=reader.read(buf)) > 0) {
	            contents.append(buf, 0, read);
	        }
	    }
	    finally {
	        try { reader.close(); } catch(IOException e) {}
	    }
	 
	    return contents.toString();
	}	
	
}
