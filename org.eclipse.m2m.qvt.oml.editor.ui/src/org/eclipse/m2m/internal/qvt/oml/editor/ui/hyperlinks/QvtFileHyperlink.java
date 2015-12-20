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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.hyperlinks;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;


/**
 * @author vrepeshko
 */
public class QvtFileHyperlink extends AbstractHyperlink {
	
	private final URI myDestinationURI;
	
	private final IRegion myDestinationRevealRegion;
	
	private final IRegion myDestinationSelectRegion;
	
	
	public QvtFileHyperlink(IRegion hyperlinkRegion, URI destinationURI, 
			IRegion destinationRevealRegion, IRegion destinationSelectRegion) {
		super(hyperlinkRegion);
		if (destinationURI == null) {
			throw new IllegalArgumentException();
		}
		
		
		
		myDestinationURI = destinationURI;
		myDestinationRevealRegion = destinationRevealRegion;
		myDestinationSelectRegion = destinationSelectRegion;
	}

	public void open() {
		try {
			IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if (activeWorkbenchWindow == null) {
				return;
			}
			IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
			if (activePage == null) {
				return;
			}
            
            // If you want to be able to return to the initial location, uncomment the line below
            activePage.getNavigationHistory().markLocation(activePage.getActiveEditor());

			IFile file = URIUtils.getFile(myDestinationURI);
			if(file == null) {
				return;
			}
			
            FileEditorInput fileEditorInput = new FileEditorInput(file);
			QvtEditor newEditor = (QvtEditor) activePage.openEditor(fileEditorInput, QvtEditor.ID, true);
			ISourceViewer viewer = newEditor.getSourceViewerOpened();
			if (viewer == null || viewer.getTextWidget().isDisposed()) {
				return;
			}
			if (myDestinationRevealRegion != null) {
				viewer.revealRange(myDestinationRevealRegion.getOffset(), myDestinationRevealRegion.getLength());
			}
			if (myDestinationSelectRegion != null) {
				viewer.setSelectedRange(myDestinationSelectRegion.getOffset(), myDestinationSelectRegion.getLength());
			}

            activePage.getNavigationHistory().markLocation(activePage.getActiveEditor());
		} catch (PartInitException e) {
			// ignored
		}
	}

}
