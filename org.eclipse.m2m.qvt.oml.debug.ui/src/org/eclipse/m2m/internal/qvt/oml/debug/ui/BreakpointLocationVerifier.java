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

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.m2m.internal.qvt.oml.common.util.LineNumberProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.qvt.oml.debug.core.vm.ValidBreakpointLocator;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.IEditorStatusLine;

class BreakpointLocationVerifier {
	
	private static LineNumberProvider getLineNumberProvider(final IDocument doc) {
		
		return new LineNumberProvider() {
			
			public int getLineNumber(int offset) {
				try {
					return doc.getLineOfOffset(offset) + 1;
				} catch (BadLocationException e) {
					return -1;
				}
			}
			
			public int getLineEnd(int lineNumber) {
				try {
					IRegion lineInfo = doc.getLineInformation(lineNumber);
					return lineInfo.getOffset() + lineInfo.getLength();
				} catch (BadLocationException e) {
					return -1;
				}
			}

			public int getLineCount() {
				return doc.getNumberOfLines();
			}
		};
	}		
	
	private static final int GET_AST_TIMEOUT = 10 * 1000;
	
	private final ILineBreakpoint fBreakpoint;
	private final QvtEditor fEditor;
	private final String fInvalidLocationMessage;
	
	BreakpointLocationVerifier(QvtEditor editor, ILineBreakpoint breakpoint, String invalidLocationMessage) {
		if(editor == null || breakpoint == null || invalidLocationMessage == null) {
			throw new IllegalArgumentException();
		}
		
		fEditor = editor; 			
		fBreakpoint = breakpoint;
		fInvalidLocationMessage = invalidLocationMessage; 			
	}
	
	IStatus run()  {
		IStatus status = checkBreakpointableElements();
		if(!status.isOK()) {				
			if (fBreakpoint != null) {
				try {
					DebugPlugin.getDefault().getBreakpointManager().removeBreakpoint(fBreakpoint, true);
				} catch (CoreException e) {
					QVTODebugUIPlugin.log(e.getStatus());
				}
			}
		}
		return status;
	}
	
	private IStatus checkBreakpointableElements()  {
		int lineNumber;
		try {
			lineNumber = fBreakpoint.getLineNumber();
		} catch (CoreException e) {
			return e.getStatus();
		}
		
		IDocumentProvider docProvider = fEditor.getDocumentProvider();
		if(docProvider == null) {
			return canceled();
		}
		
		IDocument doc = docProvider.getDocument(fEditor.getEditorInput());
		if(doc == null) {
			return canceled();
		}
		
        CompiledUnit compilationUnit = fEditor.getValidCompiledModule(GET_AST_TIMEOUT);
        if(compilationUnit == null) {
        	return QVTODebugUIPlugin.createErrorStatus("Failed to obtain AST"); //$NON-NLS-1$
        }

		List<ASTNode> elements = ValidBreakpointLocator
				.getBreakpointableElementsForLine(compilationUnit,
						getLineNumberProvider(doc), lineNumber);                    	 
		if(elements.isEmpty()) {
            report(NLS.bind(fInvalidLocationMessage, new Integer(lineNumber)));
            return canceled();
		}

		return Status.OK_STATUS;
	}
		
	/**
	 * Reports any status to the current active workbench shell
	 * @param message the message to display
	 */
	protected void report(final String message) {
		QVTODebugUIPlugin.getStandardDisplay().asyncExec(new Runnable() {
			public void run() {
				IEditorStatusLine statusLine = (IEditorStatusLine) fEditor.getAdapter(IEditorStatusLine.class);
				if (statusLine != null) {
					statusLine.setMessage(true, message, null);
				}
				if (message != null && QVTODebugUIPlugin.getActiveWorkbenchShell() != null) {
					Display.getCurrent().beep();
				}
			}
		});
	}
	
	private IStatus canceled() {
		return QVTODebugUIPlugin.createStatus(IStatus.CANCEL, fInvalidLocationMessage);
	}
}