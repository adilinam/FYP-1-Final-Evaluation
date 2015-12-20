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
package org.eclipse.m2m.internal.qvt.oml.common.ui.launch;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.common.ui.launch.messages"; //$NON-NLS-1$

    private Messages() {
    }

    public static String MdaLaunchTab_Name;
    public static String MdaCompiledLaunchTab_TransformationId;
    
    public static String BrowseButtonLabel;
    public static String BrowseFolderTitle;
    
    public static String TargetUriSelector_Uri;
    public static String TargetUriSelector_Browse;
    public static String TargetUriSelector_Feature;
    public static String TargetUriSelector_Select;
    public static String TargetUriSelector_ClearContents;
    
    public static String ReferenceSelectionDialog_Title;
    
    public static String UniSelectTransformationControl_CurrentSelection;
    public static String UniSelectTransformationControl_DeployedTransformations;
    public static String UniSelectTransformationControl_fetchingTransformations;
    public static String UniSelectTransformationControl_addingTransformations;
    public static String UniSelectTransformationControl_workspaceTransformations;
	public static String UniSelectTransformationControl_platformTransformations;
	
	public static String TraceFileControl_inrementalUpdate;

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
