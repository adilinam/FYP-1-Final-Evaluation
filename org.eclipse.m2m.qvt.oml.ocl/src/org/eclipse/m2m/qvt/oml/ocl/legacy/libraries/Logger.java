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
/*
 * Created on Apr 6, 2005
 */
package org.eclipse.m2m.qvt.oml.ocl.legacy.libraries;

import java.util.logging.Level;

class Logger {
    
    public static final Level OFF = Level.OFF;
    public static final Level SEVERE = Level.SEVERE;
    public static final Level WARNING = Level.WARNING;
    public static final Level INFO = Level.INFO;
        
    public static final String LOGGER_NAME = "org.eclipse.m2m.qvt.oml.ocl"; //$NON-NLS-1$
    private static java.util.logging.Logger ourLogger;

    public static java.util.logging.Logger getLogger() {
        if (ourLogger == null) {
            ourLogger = java.util.logging.Logger.getLogger(LOGGER_NAME);
        }
        return ourLogger;
    }


}
