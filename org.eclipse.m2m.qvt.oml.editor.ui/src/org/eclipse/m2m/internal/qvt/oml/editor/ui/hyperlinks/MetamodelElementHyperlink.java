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

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.jface.text.IRegion;
import org.eclipse.m2m.internal.qvt.oml.common.ui.views.MetamodelBrowserView;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * @author vrepeshko
 */
public class MetamodelElementHyperlink extends AbstractHyperlink {

	public MetamodelElementHyperlink(IRegion hyperlinkRegion, EModelElement metamodelElement) {
		super(hyperlinkRegion);
		if (metamodelElement == null) {
			throw new IllegalArgumentException();
		}
		myMetamodelElement = metamodelElement;
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
			MetamodelBrowserView metamodelBrowserView = (MetamodelBrowserView) activePage.showView(MetamodelBrowserView.ID);
			metamodelBrowserView.navigate(myMetamodelElement);
		} catch (PartInitException e) {
			Activator.log(e);
		}
	}

	private final EModelElement myMetamodelElement;
	
}
