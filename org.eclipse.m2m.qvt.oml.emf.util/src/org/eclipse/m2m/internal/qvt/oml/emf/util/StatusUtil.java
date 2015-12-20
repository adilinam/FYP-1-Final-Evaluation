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
package org.eclipse.m2m.internal.qvt.oml.emf.util;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.WrappedException;

public class StatusUtil {
    private StatusUtil() {}
    
    public static IStatus makeErrorStatus(String message) {
        return makeStatus(IStatus.ERROR, message, null);
    }

    public static IStatus makeErrorStatus(String message, Exception e) {
        if (e instanceof WrappedException) {
            message = e.getCause().getMessage();
        }
        return makeStatus(IStatus.ERROR, message, e);
    }
    
    public static IStatus makeErrorStatus(String format, String message, Exception e) {
        if (e instanceof WrappedException) {
            message = e.getCause().getMessage();
        }
        return makeStatus(IStatus.ERROR, MessageFormat.format(format, message), e);
    }
    
    public static IStatus makeWarningStatus(String message) {
        return makeStatus(IStatus.WARNING, message, null);
    }

    public static IStatus makeWarningStatus(String message, Exception e) {
        if (e instanceof WrappedException) {
            message = e.getCause().getMessage();
        }
        return makeStatus(IStatus.WARNING, message, e);
    }
    
    public static IStatus makeOkStatus() {
        return makeStatus(IStatus.OK, "", null); //$NON-NLS-1$
    }
    
    private static IStatus makeStatus(int severity, String message, Exception e) {
        if(message == null) {
            message = ""; //$NON-NLS-1$
        }
        
        return new Status(severity, EmfUtilPlugin.ID, 1, message, e);
    }
    

    public static boolean isError (IStatus status) {
    	return status.getSeverity() >= IStatus.ERROR ? true : false;
    }
    public static String getExceptionMessages(Throwable ex) {
        StringBuffer message = new StringBuffer();
        Set<String> used = new HashSet<String>();
        for(Throwable t = ex; t != null; t = t.getCause()) {
            if(t instanceof InvocationTargetException) {
                continue;
            }
            
            String m = t.getMessage();
            if(m != null && m.length() > 0 && !used.contains(m)) {
                if(message.length() > 0) {
                    message.append("\n"); //$NON-NLS-1$
                }
                message.append(m);
                used.add(m);
            }
        }
        
        if(message.length() == 0) {
            message.append(ex.getClass().getName());
        }
        
        return message.toString();
    }
}
