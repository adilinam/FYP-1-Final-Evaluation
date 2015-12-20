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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtRuntimePluginImages;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtRuntimeUIPlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.TraceViewLabelProvider;
import org.eclipse.swt.custom.BusyIndicator;

/**
 * @author Aleksandr Igdalov
 */
public class ShowQualifiedNamesAction extends Action {

    private TreeViewer myViewer;

    public ShowQualifiedNamesAction() {
        super(Messages.ShowQualifiedNamesAction_0, IAction.AS_CHECK_BOX); 
        setToolTipText(Messages.ShowQualifiedNamesAction_1); 
        setDisabledImageDescriptor(QvtRuntimePluginImages.getInstance().getImageDescriptor(QvtRuntimePluginImages.TRACE_VIEWER_DLCL_SHOW_QUALIFIED_ACTION));
        setImageDescriptor(QvtRuntimePluginImages.getInstance().getImageDescriptor(QvtRuntimePluginImages.TRACE_VIEWER_ELCL_SHOW_QUALIFIED_ACTION));
        setHoverImageDescriptor(QvtRuntimePluginImages.getInstance().getImageDescriptor(QvtRuntimePluginImages.TRACE_VIEWER_ELCL_SHOW_QUALIFIED_ACTION));
        setId(QvtRuntimeUIPlugin.getDefault().getBundle().getSymbolicName() + ".ShowQualifiedNames"); //$NON-NLS-1$
        setChecked(false);
    }
    
    @Override
    public void run() {
        if (myViewer.getControl().isDisposed()) {
            return;
        }
        TraceViewLabelProvider labelProvider = (TraceViewLabelProvider) myViewer.getLabelProvider();
        labelProvider.setShowQualifiedNames(isChecked());
        BusyIndicator.showWhile(myViewer.getControl().getDisplay(), new Runnable() {
            public void run() {
                if (!myViewer.getControl().isDisposed()) {
                    myViewer.refresh();                    
                }
            }
        });
    }
    

	public TreeViewer getViewer() {
		return myViewer;
	}

	public void setViewer(TreeViewer viewer) {
		myViewer = viewer;
	}
}