/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.ui.dialogs;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.common.ui.dialogs.messages"; //$NON-NLS-1$

    private Messages() {
    }

    public static String OpenClassifierDialog_title;
    public static String OpenClassifierDialog_queryLabel;
    public static String OpenClassifierDialog_resultsLabel;
    
    public static String BrowseInterpretedTransformationDialog_Title;
    public static String BrowseInterpretedTransformationDialog_Description;
    
    public static String DeferredAdapter_cancelJob;
    public static String DeferredAdapter_loadingContents;
    public static String DeferredAdapter_expandNode;
    
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
