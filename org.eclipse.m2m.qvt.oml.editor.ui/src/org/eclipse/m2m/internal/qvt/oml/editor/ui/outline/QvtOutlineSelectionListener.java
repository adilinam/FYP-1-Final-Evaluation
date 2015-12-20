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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.outline;

import java.util.List;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ocl.cst.CSTNode;



public class QvtOutlineSelectionListener implements ISelectionChangedListener, IDoubleClickListener {
	public QvtOutlineSelectionListener(final ISourceViewer v) {
		myViewer = v;
	}
	
	public void selectionChanged(final SelectionChangedEvent event) {
		OutlineNode selectedNode = (OutlineNode)((IStructuredSelection)event.getSelection()).getFirstElement();
		if(selectedNode == null) {
			return;
		}
		
		CSTNode e = selectedNode.getSyntaxElement();
		if (e == null) {
			List<OutlineNode> children = selectedNode.getChildren();
			if (children.isEmpty()) {
				return;
			}
			OutlineNode childNode = (OutlineNode) children.get(0);
			e = childNode.getSyntaxElement();
			if (e == null) {
				return;
			}
		}
		
		myViewer.revealRange(e.getStartOffset(), e.getEndOffset()-e.getStartOffset());
		myViewer.setSelectedRange(e.getStartOffset(), 0);
	}
	
    public void doubleClick(DoubleClickEvent event) {
		myViewer.getTextWidget().forceFocus();
    }

    private final ISourceViewer myViewer;
}
