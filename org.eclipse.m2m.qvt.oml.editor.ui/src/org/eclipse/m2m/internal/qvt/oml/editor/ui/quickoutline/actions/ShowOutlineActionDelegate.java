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
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

import org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline.QvtoQuickOutlineHandler;

public class ShowOutlineActionDelegate implements IEditorActionDelegate, IActionDelegate2 {
    /**
     * This is called immediately after this action delegate is created.
     * We use this as an opportunity to record the proxy action for later use.
     */
    public void init(IAction action) {
    }


    public void setActiveEditor(IAction action, IEditorPart editorPart) {
    }

    /**
     * Because we implement {@link IActionDelegate2}, this is called instead of the old {@link #run(IAction) run}.
     * This simply calls that method, which must be invoked since a subclass may have overridden it.
     */
    public void runWithEvent(IAction action, Event event) {
        run(action);        
    }

    /**
     * The action must have been enabled for this to have been called,
     * so we must have stored the selection already by this point.
     */
    public void run(IAction action) {
    	new QvtoQuickOutlineHandler().run();
    }
    
    public void selectionChanged(IAction action, ISelection selection) {
        // NO-OP    
    }   
    
    public void dispose() {
        // NO-OP
    }   
}