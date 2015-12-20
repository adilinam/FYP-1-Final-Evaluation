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
package org.eclipse.m2m.internal.qvt.oml.debug.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.m2m.internal.qvt.oml.debug.ui.QVTODebugUIPlugin;
import org.eclipse.m2m.qvt.oml.debug.core.QVTOBreakpoint;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.PropertyDialogAction;

/**
 * Presents the standard properties dialog to configure the attributes of a QVTO
 * Breakpoint.
 */
public class QVTOBreakpointPropertiesAction implements IObjectActionDelegate {

	private IWorkbenchPart fPart;
	private QVTOBreakpoint fBreakpoint;

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		if (fBreakpoint != null) {
			IShellProvider provider;
			if (fPart != null) {
				provider = fPart.getSite();
			} else {
				provider = new IShellProvider() {
					public Shell getShell() {
						return QVTODebugUIPlugin.getActiveWorkbenchShell();
					}
				};
			}
			PropertyDialogAction propertyAction = new PropertyDialogAction(
					provider, new ISelectionProvider() {
						public void addSelectionChangedListener(
								ISelectionChangedListener listener) {
						}

						public ISelection getSelection() {
							return new StructuredSelection(fBreakpoint);
						}

						public void removeSelectionChangedListener(
								ISelectionChangedListener listener) {
						}

						public void setSelection(ISelection selection) {
						}
					});
			propertyAction.run();
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) selection;
			if (ss.isEmpty() || ss.size() > 1) {
				return;
			}
			Object element = ss.getFirstElement();
			if (element instanceof QVTOBreakpoint) {
				setBreakpoint((QVTOBreakpoint) element);
			} else {
				setBreakpoint(null);
			}
		}
	}

	/**
	 * Allows the underlying breakpoint for the properties page to be set
	 * 
	 * @param breakpoint
	 */
	public void setBreakpoint(QVTOBreakpoint breakpoint) {
		fBreakpoint = breakpoint;
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		fPart = targetPart;
	}
}