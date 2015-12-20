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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.TextEditorAction;

public class GotoAnnotationAction extends TextEditorAction {
    public GotoAnnotationAction(String prefix, boolean forward) {
        super(ActionMessages.getResourceBundle(), prefix, null);
        myForward = forward;
    }

    @Override
	public void run() {
        QvtEditor editor = (QvtEditor) getTextEditor();
        editor.gotoAnnotation(myForward);
    }

    @Override
	public void setEditor(ITextEditor editor) {
        if (editor instanceof QvtEditor) {
            super.setEditor(editor);
        }
        
        update();
    }

    @Override
	public void update() {
        setEnabled(getTextEditor() instanceof QvtEditor);
    }

    private boolean myForward;
}
