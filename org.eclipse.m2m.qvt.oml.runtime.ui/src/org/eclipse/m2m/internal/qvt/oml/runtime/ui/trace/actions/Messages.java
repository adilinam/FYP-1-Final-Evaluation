/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.actions;

import org.eclipse.osgi.util.NLS;

/**
 * @author Aleksandr Igdalov
 */
public class Messages extends NLS {
    private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.actions.messages"; //$NON-NLS-1$
    public static String CollapseAllAction_0;
    public static String CollapseAllAction_1;
    public static String OpenEObjectAction_FailedToNavigateTo;
    public static String OpenEObjectAction_NavigationFailed;
    public static String ShowQualifiedNamesAction_0;
    public static String ShowQualifiedNamesAction_1;
    
    public static String OpenEObjectAction_UnboundObjectTitle;
    public static String OpenEObjectAction_UnboundObjectMsg;
    
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
