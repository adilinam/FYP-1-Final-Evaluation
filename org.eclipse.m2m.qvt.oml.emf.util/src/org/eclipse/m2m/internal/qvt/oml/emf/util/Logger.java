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

import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;

/**
 * @author pkobiakov
 */
public class Logger {
	public static final Level INFO = Level.INFO;
	public static final Level WARNING = Level.WARNING;
	public static final Level SEVERE = Level.SEVERE;

	private Logger() {
	}
	
	public static java.util.logging.Logger getLogger() {
		return getLogger("org.eclipse.m2m.qvt.oml.emf.util"); //$NON-NLS-1$
	}

	public static java.util.logging.Logger getLogger(String id) {
        return new java.util.logging.Logger(id, null) {
            @Override
			public void log(LogRecord record) {
            	if(EMFPlugin.IS_ECLIPSE_RUNNING) {
	                ILog pluginLog = EmfUtilPlugin.getDefault().getLog();
	                IStatus status = new Status(getStatusSeverity(record.getLevel()), EmfUtilPlugin.ID, 1, record.getMessage(), record.getThrown());
	                pluginLog.log(status);
            	} else {
            		System.err.println(record.getLevel() + " - " + record.getMessage()); //$NON-NLS-1$
            	}
            }
        };
	}
    
    public static int getStatusSeverity(Level level) {
        if(level == INFO) {
            return IStatus.INFO;
        }
        else if(level == WARNING) {
            return IStatus.WARNING;
        }
        else if(level == SEVERE) {
            return IStatus.ERROR;
        }
        else {
            return IStatus.ERROR;
        }
    }
}
