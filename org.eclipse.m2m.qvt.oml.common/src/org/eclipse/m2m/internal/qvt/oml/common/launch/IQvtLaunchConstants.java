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
package org.eclipse.m2m.internal.qvt.oml.common.launch;

/** @author pkobiakov */
public interface IQvtLaunchConstants {
	String PREFIX = "org.eclipse.m2m.qvt.oml.interpreter.";  //$NON-NLS-1$
	
	String MODULE                = PREFIX + "module"; //$NON-NLS-1$
    String TRACE_FILE            = PREFIX + "traceFile"; //$NON-NLS-1$
    String USE_TRACE_FILE        = PREFIX + "useTraceFile"; //$NON-NLS-1$
    String IS_INCREMENTAL_UPDATE = PREFIX + "isInrementalUpdate"; //$NON-NLS-1$

    // indexed attributes (1..elemCount)
    String TARGET_TYPE      = PREFIX + "targetType"; //$NON-NLS-1$
	String TARGET_MODEL     = PREFIX + "targetModel"; //$NON-NLS-1$
    String FEATURE_NAME     = PREFIX + "featureName"; //$NON-NLS-1$
    String CLEAR_CONTENTS   = PREFIX + "clearContents"; //$NON-NLS-1$
    String CONTENT_PROVIDER = PREFIX + "contentProvider"; //$NON-NLS-1$

    String ELEM_COUNT       = PREFIX + "elemCount"; //$NON-NLS-1$
    
    String DONE_ACTION = PREFIX + "doneAction"; //$NON-NLS-1$
    String LAUNCH_IN_BACKGROUND = PREFIX + "launchInBackground"; //$NON-NLS-1$
    String MONITOR = PREFIX + "monitor"; //$NON-NLS-1$

    String CONFIGURATION_PROPERTIES = PREFIX + "configurationProperties"; //$NON-NLS-1$
}
