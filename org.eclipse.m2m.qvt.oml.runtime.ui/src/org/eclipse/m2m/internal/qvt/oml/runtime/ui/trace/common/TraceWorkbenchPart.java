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

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.TraceViewContentProvider;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.TraceViewLabelProvider;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.actions.OpenEObjectAction;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author aigdalov
 */
public class TraceWorkbenchPart {
	private TreeViewer myTraceViewer;
	private final IWorkbenchPart myWorkbenchPart;
	
	public TraceWorkbenchPart(IWorkbenchPart workbenchPart) {
		myWorkbenchPart = workbenchPart;
	}
	
	public void createPartControl(Composite parent) {
        Tree tree = new Tree(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE | SWT.BORDER);
        
        GridData gridData = new GridData(GridData.FILL_BOTH);
        gridData.heightHint = 200;
        tree.setLayoutData(gridData);
        
        tree.setFont(parent.getFont());
        
        myTraceViewer = new TreeViewer(tree);
        TraceViewContentProvider contentProvider = new TraceViewContentProvider();
        myTraceViewer.setContentProvider(contentProvider);
        TraceViewLabelProvider labelProvider = new TraceViewLabelProvider();
        myTraceViewer.setLabelProvider(labelProvider);
        myTraceViewer.setUseHashlookup(true);
        
        hookDoubleClickAction();
	}
	
    public Trace getInput() {
        return (Trace) myTraceViewer.getInput();
    }
    
    public void setInput(Trace trace) {
		myTraceViewer.setInput(trace);
	}
	
    public void setSelection(Object objToSelect) {
		myTraceViewer.setSelection(new StructuredSelection(objToSelect));
	}
	
	public TreeViewer getViewer() {
		return myTraceViewer;
	}
	
	private void hookDoubleClickAction() {
        final OpenEObjectAction openEObjectAction = new OpenEObjectAction(myWorkbenchPart.getSite().getPage(), myTraceViewer.getTree());
        myTraceViewer.addDoubleClickListener(new IDoubleClickListener() {
            public void doubleClick(DoubleClickEvent event) {
                openEObjectAction.run();
            }
        });
    }
}