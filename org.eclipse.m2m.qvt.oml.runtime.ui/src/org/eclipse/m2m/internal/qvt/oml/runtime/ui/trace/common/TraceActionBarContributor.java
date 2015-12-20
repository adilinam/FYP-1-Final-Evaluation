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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.common;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.actions.CollapseAllAction;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.actions.ShowQualifiedNamesAction;

/**
 * @author aigdalov
 */
public class TraceActionBarContributor {
	private CollapseAllAction myCollapseAllAction;
	private ShowQualifiedNamesAction myShowQualifiedNamesAction;
    private TreeViewer myViewer;

	public void contributeToToolBar(IToolBarManager toolBarManager) {
        toolBarManager.add(new Separator(this.getClass().getName()));
        toolBarManager.add(new Separator(IDebugUIConstants.RENDER_GROUP));
        myCollapseAllAction = new CollapseAllAction();
        toolBarManager.add(myCollapseAllAction);
        myShowQualifiedNamesAction = new ShowQualifiedNamesAction();
		toolBarManager.add(myShowQualifiedNamesAction);
        setViewerToActions();
	}

	public void setViewer(TreeViewer viewer) {
		myViewer = viewer;
        setViewerToActions();
	}
    
    public IAction[] getActions() {
        return new IAction[] {myCollapseAllAction, myShowQualifiedNamesAction};
    }
    
    private void setViewerToActions() {
        if ((myCollapseAllAction != null) && (myViewer != null)) {
            myCollapseAllAction.setViewer(myViewer);
            myShowQualifiedNamesAction.setViewer(myViewer);
        }
    }
}