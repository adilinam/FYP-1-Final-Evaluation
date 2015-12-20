/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.debug.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.ISuspendResume;
import org.eclipse.debug.ui.actions.IRunToLineTarget;
import org.eclipse.debug.ui.actions.RunToLineHandler;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.qvt.oml.debug.core.QVTOBreakpoint;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugElement;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;


public class QVTORunToLineAdapter implements IRunToLineTarget {
	
	public QVTORunToLineAdapter() {
		super();
	}
	
	public void runToLine(IWorkbenchPart part, ISelection selection, ISuspendResume target) throws CoreException {
		IEditorPart editorPart = (IEditorPart)part;
		IEditorInput input = editorPart.getEditorInput();
		if(input == null) {
			throw new CoreException(QVTODebugUIPlugin.createErrorStatus(DebugUIMessages.QVTORunToLineAdapter_NoInput));
		}
		
		ITextEditor textEditor = (ITextEditor)editorPart;
		IDocumentProvider provider = textEditor.getDocumentProvider();
		IDocument document = provider.getDocument(input);
		if(document == null) {
			throw new CoreException(QVTODebugUIPlugin.createErrorStatus(DebugUIMessages.QVTORunToLineAdapter_NoDocument));
		}
		
		IFile file = (IFile)input.getAdapter(IFile.class);
		if (file == null) {
			throw new CoreException(QVTODebugUIPlugin.createErrorStatus(DebugUIMessages.QVTORunToLineAdapter_NoFile)); 
		}
		
		ITextSelection textSelection = (ITextSelection) selection;
		int lineNumber = textSelection.getStartLine() + 1;
				
		URI resourceURI = QVTODebugUtil.getResourceURI(file);
		QVTOBreakpoint qvtBreakpoint = QVTOBreakpoint.createRunToLineBreakpoint(resourceURI, lineNumber);

		String invalidLocationMessage = DebugUIMessages.QVTORunToLineAdapter_invalidLocation;
		IStatus verifyStatus = new BreakpointLocationVerifier(
				(QvtEditor) textEditor, qvtBreakpoint,
				invalidLocationMessage).run();
		if(!verifyStatus.isOK()) {
			new ErrorDialog(part.getSite().getShell(), null,
					DebugUIMessages.QVTORunToLineAdapter_runFailed, verifyStatus, IStatus.CANCEL).open();
			return;
		}

		
		IAdaptable adaptableTarget = (IAdaptable)target;
		IDebugTarget debugTarget = (IDebugTarget) adaptableTarget.getAdapter(IDebugTarget.class);
		if (debugTarget != null) {
            RunToLineHandler handler = new RunToLineHandler(debugTarget, target, qvtBreakpoint);
            handler.run(new NullProgressMonitor());
			return;
		}
	}

	public boolean canRunToLine(IWorkbenchPart part, ISelection selection, ISuspendResume target) {
		return target instanceof QVTODebugElement && getEditor(part) != null;
	}
	
	private QvtEditor getEditor(IWorkbenchPart part) {
		if(part instanceof QvtEditor) {
			return (QvtEditor) part;
 		}
		
		return null;		
	}	
	
}
