/*******************************************************************************
 * Copyright (c) 2013 S. Boyko and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Sergey Boyko - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline.QvtoQuickOutlineHandler;

public class ShowOutlineWindowActionDelegate implements IWorkbenchWindowActionDelegate {

    private IWorkbenchWindow myWindow;
    
    public ShowOutlineWindowActionDelegate() {
    }
    
    public void init(IWorkbenchWindow window) {
        myWindow = window;
    }

    public void run(IAction action) {
    	new QvtoQuickOutlineHandler().run();
    }

    public void selectionChanged(IAction action, ISelection selection) {
        action.setEnabled(getActiveEditor() != null);
    }

    public void dispose() {
        // NO-OP
    }   
    
    private IEditorPart getActiveEditor() {
        if(myWindow.getActivePage() == null || myWindow.getActivePage().getActivePart() instanceof IEditorPart == false) {
            return null;
        }
        
        return myWindow.getActivePage().getActiveEditor();       
    }
}