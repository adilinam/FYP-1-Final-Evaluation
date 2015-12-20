/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
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

import java.util.ResourceBundle;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Messages;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.hyperlinks.QvtHyperlinkDetector;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.texteditor.IEditorStatusLine;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.TextEditorAction;

public class OpenDeclarationAction extends TextEditorAction {
	
	public static final String OPEN_DECLARATION = "org.eclipse.m2m.qvt.oml.editor.ui.actions.OpenDeclaration"; //$NON-NLS-1$
	
	public OpenDeclarationAction(ResourceBundle bundle, String prefix, ITextEditor editor) {
		super(bundle, prefix, editor);
		setEnabled(true);
		setActionDefinitionId(OPEN_DECLARATION);
	}
		
	@Override
	public void run() {
		QvtEditor qvtEditor = (QvtEditor) super.getTextEditor();
		ISourceViewer sourceViewer = qvtEditor.getSourceViewerOpened();
		Point range = sourceViewer.getSelectedRange();
		if(range == null) {
			return;
		}

		IRegion region = new Region(range.x, range.y);
		IHyperlink[] links = new QvtHyperlinkDetector(qvtEditor.getQVTDocumentProvider()).detectHyperlinks(sourceViewer, region, false);
		if(links != null && links.length > 0) {
			links[0].open();
		} else {
			IEditorStatusLine statusLine = (IEditorStatusLine) qvtEditor.getAdapter(IEditorStatusLine.class);
			if (statusLine != null) {
				statusLine.setMessage(true, Messages.OpenDeclarationAction_selectionDoesNotResolveToElement, null);
			}			
		}
	}
}
