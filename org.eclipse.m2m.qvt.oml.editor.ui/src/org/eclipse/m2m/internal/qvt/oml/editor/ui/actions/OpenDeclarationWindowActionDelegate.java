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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.texteditor.ITextEditor;

public class OpenDeclarationWindowActionDelegate implements IWorkbenchWindowActionDelegate {

	private IWorkbenchWindow fWindow;
	
	public OpenDeclarationWindowActionDelegate() {
	}
	
	public void init(IWorkbenchWindow window) {
		fWindow = window;
	}

	public void run(IAction action) {
		IEditorPart editor = getActiveEditor();
		ITextEditor textEditor = (ITextEditor)editor;
		IAction editorAction = textEditor.getAction(OpenDeclarationAction.OPEN_DECLARATION);
		editorAction.run();		
	}

	public void selectionChanged(IAction action, ISelection selection) {
		action.setEnabled(getActiveEditor() != null);
	}

	public void dispose() {
		// NO-OP
	}	
	
	private IEditorPart getActiveEditor() {
		if(fWindow.getActivePage() == null || fWindow.getActivePage().getActivePart() instanceof IEditorPart == false) {
			return null;
		}
		
		return fWindow.getActivePage().getActiveEditor();		
	}
}
