/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bug 391289
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.ui.texteditor.ITextEditor;


public class QvtReconcilingStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {
    private static final int MAX_LOGGED_COMPILATION_EXCEPTIONS = 5;
    
	private IProgressMonitor myMonitor;
	private IDocument myDocument;
	private IQVTReconcilingListener myReconcilingListener;	
	private final ITextEditor myEditor;
	private int myLoggedCompilationExceptionsCount = 0;

    public QvtReconcilingStrategy(final ITextEditor editor) {
        myEditor = editor;
        if(editor instanceof IQVTReconcilingListener) {
			myReconcilingListener = (IQVTReconcilingListener) editor;
        }
    }
    
    public void setDocument(final IDocument document) {
        myDocument = document;
    }
    
    public void reconcile(final DirtyRegion dirtyRegion, final IRegion subRegion) {
        reconcileInternal();
    }
    
    public void reconcile(final IRegion partition) {
        reconcileInternal();
    }
    
    public void setProgressMonitor(final IProgressMonitor monitor) {
        myMonitor = monitor;
    }
    
    public void initialReconcile() {
        reconcileInternal();
    }
    
    private void reconcileInternal() {
        boolean editingInQvtSourceContainer = QvtCompilerFacade.isEditingInQvtSourceContainer(myEditor);
        if(!editingInQvtSourceContainer) {
        	return;
        }
                                
        CompiledUnit compilationResult = null;
        try {
			myReconcilingListener.aboutToBeReconciled();			
	        compilationResult = getCompilationResult(editingInQvtSourceContainer);	        
        } 
        catch (Exception ex) {
            handleError(ex);
        } finally {
        	myReconcilingListener.reconciled(compilationResult, myMonitor);
        }
    }

	private CompiledUnit getCompilationResult(boolean editingInQvtSourceContainer) {
		CompiledUnit compilationResult;
		QvtCompilerOptions options = new QvtCompilerOptions();
		options.setShowAnnotations(editingInQvtSourceContainer);
		options.setSourceLineNumbersEnabled(false);
		options.enableCSTModelToken(true);
		
		compilationResult = QvtCompilerFacade.getInstance().compile(myEditor, myDocument, options, myMonitor);
		return compilationResult;
	}

	private void handleError(Exception ex) {
		
		if (ex instanceof OperationCanceledException) {
			return;
		}
		
		if (myLoggedCompilationExceptionsCount < MAX_LOGGED_COMPILATION_EXCEPTIONS) {
		    myLoggedCompilationExceptionsCount ++;
		    Activator.log(ex);
		    if (myLoggedCompilationExceptionsCount == MAX_LOGGED_COMPILATION_EXCEPTIONS) {
		        Activator.log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, Messages.QvtReconcilingStrategy_TooManyExceptions));
		    }
		}
	}
}