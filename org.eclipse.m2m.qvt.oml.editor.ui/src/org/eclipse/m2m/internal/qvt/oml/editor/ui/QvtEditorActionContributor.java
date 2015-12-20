/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
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

import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.texteditor.BasicTextEditorActionContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;

public class QvtEditorActionContributor extends BasicTextEditorActionContributor {
    private GotoAnnotationAction myPreviousAnnotation;
    private GotoAnnotationAction myNextAnnotation;

    public QvtEditorActionContributor() {
        myPreviousAnnotation = new GotoAnnotationAction("PreviousAnnotation.", false); //$NON-NLS-1$
        myNextAnnotation = new GotoAnnotationAction("NextAnnotation.", true); //$NON-NLS-1$
    }

    @Override
	public void init(IActionBars bars, IWorkbenchPage page) {
        super.init(bars, page);

        // register actions that have a dynamic editor.
        bars.setGlobalActionHandler(ITextEditorActionDefinitionIds.GOTO_NEXT_ANNOTATION, myNextAnnotation);
        bars.setGlobalActionHandler(ITextEditorActionDefinitionIds.GOTO_PREVIOUS_ANNOTATION, myPreviousAnnotation);
        bars.setGlobalActionHandler(ActionFactory.NEXT.getId(), myNextAnnotation);
        bars.setGlobalActionHandler(ActionFactory.PREVIOUS.getId(), myPreviousAnnotation);
    }

    @Override
	public void setActiveEditor(IEditorPart part) {
        super.setActiveEditor(part);

        IActionBars actionBars = getActionBars();
        IStatusLineManager manager = actionBars.getStatusLineManager();
        manager.setMessage(null);
        manager.setErrorMessage(null);

        ITextEditor textEditor= null;
        if (part instanceof ITextEditor) {
            textEditor = (ITextEditor) part;
        }

        myPreviousAnnotation.setEditor(textEditor);
        myNextAnnotation.setEditor(textEditor);
    }

    @Override
	public void dispose() {
        setActiveEditor(null);
        super.dispose();
    }
}
