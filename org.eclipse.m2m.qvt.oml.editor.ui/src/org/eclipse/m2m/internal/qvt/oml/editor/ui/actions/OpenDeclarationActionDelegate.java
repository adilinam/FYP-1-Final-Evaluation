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
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;

public class OpenDeclarationActionDelegate implements IEditorActionDelegate, IActionDelegate2 {

	private String fActionID;
	
	private IEditorPart fEditorPart;
	
	/**
	 * This records the proxy action created by the platform.
	 */
	protected IAction action;

	/**
	 * This constructs an instance.
	 */
	public OpenDeclarationActionDelegate() {
		fActionID = OpenDeclarationAction.OPEN_DECLARATION;		
	}

	/**
	 * This is called immediately after this action delegate is created.
	 * We use this as an opportunity to record the proxy action for later use.
	 */
	public void init(IAction action) {
		this.action = action;
	}


	public void setActiveEditor(IAction action, IEditorPart editorPart) {
		this.fEditorPart = editorPart;
		this.action = action;
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
		if(fEditorPart instanceof ITextEditor) {
			ITextEditor txtEditor = (ITextEditor) fEditorPart;			
			IAction editorAction = txtEditor.getAction(fActionID);
			if(editorAction != null) {
				editorAction.run();
			}
		}
	}
	
	public void selectionChanged(IAction action, ISelection selection) {
		// NO-OP	
	}	
	
	public void dispose() {
		// NO-OP
	}	
}
