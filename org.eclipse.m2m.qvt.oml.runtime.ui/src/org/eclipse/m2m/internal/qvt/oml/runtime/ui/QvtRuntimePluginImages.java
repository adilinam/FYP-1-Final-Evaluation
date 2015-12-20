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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui;

import java.net.URL;

import org.eclipse.m2m.internal.qvt.oml.common.ui.PluginImages;

public class QvtRuntimePluginImages extends PluginImages {
    private QvtRuntimePluginImages() {
        super(BASE_URL);
        declareImages();
    }
    
    public static final String APPLY_WIZARD = "apply_wizard"; //$NON-NLS-1$
    public static final String SHOW_SOURCE = "show_source"; //$NON-NLS-1$
    public static final String SHOW_TARGET = "show_target"; //$NON-NLS-1$
    public static final String METHOD = "method"; //$NON-NLS-1$
    public static final String TRACE_VIEWER_ELCL_SHOW_QUALIFIED_ACTION = "elcl_show_qualified"; //$NON-NLS-1$
    public static final String TRACE_VIEWER_DLCL_SHOW_QUALIFIED_ACTION = "dlcl_show_qualified"; //$NON-NLS-1$
    public static final String IMG_ELCL_COLLAPSE_ALL = "IMG_ELCL_COLLAPSE_ALL"; //$NON-NLS-1$
    public static final String IMG_DLCL_COLLAPSE_ALL = "IMG_DLCL_COLLAPSE_ALL"; //$NON-NLS-1$
    public static final String IMG_LCL_COLLAPSE_ALL = "IMG_LCL_COLLAPSE_ALL"; //$NON-NLS-1$
    

    public static QvtRuntimePluginImages getInstance() {
        return ourInstance;
    }
    
    @Override
	protected void declareImages() {
        declareRegistryImage(APPLY_WIZARD, "icons/apply-wizard.gif"); //$NON-NLS-1$
        declareRegistryImage(SHOW_SOURCE, "icons/show-source.gif"); //$NON-NLS-1$
        declareRegistryImage(SHOW_TARGET, "icons/show-target.gif"); //$NON-NLS-1$
        declareRegistryImage(METHOD, "icons/cat-method.gif"); //$NON-NLS-1$
        declareRegistryImage(TRACE_VIEWER_ELCL_SHOW_QUALIFIED_ACTION, "icons/elcl16/th_showqualified.gif"); //$NON-NLS-1$
        declareRegistryImage(TRACE_VIEWER_DLCL_SHOW_QUALIFIED_ACTION, "icons/dlcl16/th_showqualified.gif"); //$NON-NLS-1$
        declareRegistryImage(IMG_ELCL_COLLAPSE_ALL, "icons/elcl16/collapseall.gif"); //$NON-NLS-1$
        declareRegistryImage(IMG_DLCL_COLLAPSE_ALL, "icons/dlcl16/collapseall.gif"); //$NON-NLS-1$
        declareRegistryImage(IMG_LCL_COLLAPSE_ALL, "icons/elcl16/collapseall.gif"); //$NON-NLS-1$
    }
    
    private final static URL BASE_URL = QvtRuntimeUIPlugin.getDefault().getBundle().getEntry("/"); //$NON-NLS-1$
    
    private static final QvtRuntimePluginImages ourInstance = new QvtRuntimePluginImages();
}
