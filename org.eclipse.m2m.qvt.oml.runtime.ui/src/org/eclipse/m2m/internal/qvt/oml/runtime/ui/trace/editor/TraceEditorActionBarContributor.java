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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.editor;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.common.TraceActionBarContributor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * @author aigdalov
 */
public class TraceEditorActionBarContributor extends EditorActionBarContributor {
    private final TraceActionBarContributor myTraceActionBarContributor = new TraceActionBarContributor();

	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
        myTraceActionBarContributor.contributeToToolBar(toolBarManager);
	}

	@Override
	public void setActiveEditor(IEditorPart targetEditor) {
		TraceEditorPart traceEditorPart = (TraceEditorPart) targetEditor;
		TreeViewer viewer = traceEditorPart.getViewer();
        myTraceActionBarContributor.setViewer(viewer);
	}
}