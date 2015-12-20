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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.actions;

/**
 * @author Aleksandr Igdalov
 */

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtRuntimePluginImages;

public class CollapseAllAction extends Action {
    private TreeViewer myViewer;
    
    public CollapseAllAction() {
        super(Messages.CollapseAllAction_0, QvtRuntimePluginImages.getInstance().getImageDescriptor(QvtRuntimePluginImages.IMG_ELCL_COLLAPSE_ALL));
        setToolTipText(Messages.CollapseAllAction_1);
        setDisabledImageDescriptor(QvtRuntimePluginImages.getInstance().getImageDescriptor(QvtRuntimePluginImages.IMG_DLCL_COLLAPSE_ALL));
        setHoverImageDescriptor(QvtRuntimePluginImages.getInstance().getImageDescriptor(QvtRuntimePluginImages.IMG_LCL_COLLAPSE_ALL));
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.action.IAction#run()
     */
    @Override
	public void run() {
        myViewer.collapseAll();
    }

	public TreeViewer getViewer() {
		return myViewer;
	}

	public void setViewer(TreeViewer viewer) {
		myViewer = viewer;
	}
}