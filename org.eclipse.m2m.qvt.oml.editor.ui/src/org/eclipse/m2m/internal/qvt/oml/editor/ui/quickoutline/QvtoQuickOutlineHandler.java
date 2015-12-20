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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.AbstractInformationControlManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.information.IInformationPresenter;
import org.eclipse.jface.text.information.IInformationProvider;
import org.eclipse.jface.text.information.InformationPresenter;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class QvtoQuickOutlineHandler extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		return run();
	}

	public Object run() {
		QvtEditor qvtEditor = getActiveEditor();
		if (qvtEditor != null) {
			IInformationPresenter outlinePresenter = getOutlinePresenter(qvtEditor);
			outlinePresenter.install(qvtEditor.getEditorSourceViewer());
			outlinePresenter.showInformation();
		}
		return null;
	}
	
    public IInformationPresenter getOutlinePresenter(QvtEditor qvtEditor) {
        InformationPresenter presenter = new InformationPresenter(getOutlinePresenterControlCreator(qvtEditor));
        presenter.setDocumentPartitioning(qvtEditor.getQvtConfiguration().getConfiguredDocumentPartitioning(qvtEditor.getEditorSourceViewer()));
        presenter.setAnchor(AbstractInformationControlManager.ANCHOR_GLOBAL);
        IInformationProvider provider = new QvtElementProvider();
        presenter.setInformationProvider(provider, IDocument.DEFAULT_CONTENT_TYPE);
        presenter.setSizeConstraints(50, 20, true, false);
        return presenter;
    }

    private IInformationControlCreator getOutlinePresenterControlCreator(final QvtEditor qvtEditor) {
        return new IInformationControlCreator() {
            public IInformationControl createInformationControl(Shell parent) {
                int shellStyle = SWT.RESIZE;
                int treeStyle = SWT.V_SCROLL | SWT.H_SCROLL;
    			QvtOutlineInformationControl qvtOutlineInformationControl = new QvtOutlineInformationControl(qvtEditor.getEditorSite().getShell(), shellStyle, treeStyle, 
    					"org.eclipse.m2m.qvt.oml.editor.ui.show.outline", qvtEditor, qvtEditor.getEditorSourceViewer()); //$NON-NLS-1$
                return qvtOutlineInformationControl;
            }
        };
    }
    
	private QvtEditor getActiveEditor() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			IWorkbenchPage page = window.getActivePage();
			if (page != null) {
				IEditorPart editor = page.getActiveEditor();
				if (editor instanceof QvtEditor)
					return (QvtEditor) editor;
			}
		}
		return null;
	}
}
