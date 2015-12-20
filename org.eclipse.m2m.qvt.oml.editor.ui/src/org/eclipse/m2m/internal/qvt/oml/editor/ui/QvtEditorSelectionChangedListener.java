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

import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;


public class QvtEditorSelectionChangedListener implements ISelectionChangedListener {
	public QvtEditorSelectionChangedListener(final QvtEditor editor) {
		myEditor = editor;
	}
	
	public void install() {
		ISelectionProvider p = myEditor.getSelectionProvider();
		if (p instanceof IPostSelectionProvider) {
			((IPostSelectionProvider)p).addPostSelectionChangedListener(this);
		} else {
			p.addSelectionChangedListener(this);
		}
	}
	
	public void uninstall() {
		ISelectionProvider p = myEditor.getSelectionProvider();
		if (p instanceof IPostSelectionProvider) {
			((IPostSelectionProvider)p).removePostSelectionChangedListener(this);
		} else {
			p.removeSelectionChangedListener(this);
		}
	}

	public void selectionChanged(final SelectionChangedEvent event) {
		uninstall();
		myEditor.selectionChanged((TextSelection)event.getSelection());
		install();
	}

	
	private final QvtEditor myEditor;
}
