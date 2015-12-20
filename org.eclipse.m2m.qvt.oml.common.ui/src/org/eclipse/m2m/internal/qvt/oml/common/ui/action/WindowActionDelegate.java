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
package org.eclipse.m2m.internal.qvt.oml.common.ui.action;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;


/**
 * @author dstadnik
 */
public abstract class WindowActionDelegate
		implements
		IWorkbenchWindowActionDelegate {

	public void init(IWorkbenchWindow window) {
		myWindow = window;
	}

	public void dispose() {
		myWindow = null;
		mySelection = null;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		mySelection = selection;
	}

	protected abstract void runImpl(IAction action) throws Exception;

	public void run(IAction action) {
		try {
			runImpl(action);
		} catch (InterruptedException canceled) {} catch (Exception e) {
			showError(action, e.getMessage(), e);
		}
	}

	public void showError(IAction action, String message, Exception e) {
		String exMessage = e.getMessage();
		if (exMessage == null) {
			exMessage = ""; //$NON-NLS-1$
		}
		if (message == null) {
			message = exMessage;
		}
		Logger.getLogger().log(Logger.SEVERE, message, e);
		Status status = new Status(IStatus.ERROR,
				"org.eclipse.m2m.qvt.oml", IStatus.ERROR, exMessage, e); //$NON-NLS-1$
		ErrorDialog.openError(
				getShell(),
				Messages.ActionDelegate_Failed, action.getText(), status);
	}

	protected Object getSelectedElement() {
		if (!(mySelection instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection elements = (IStructuredSelection)mySelection;
		if (elements.size() != 1) {
			return null;
		}
		return elements.getFirstElement();
	}

	public ISelection getSelection() {
		return mySelection;
	}

	public Shell getShell() {
		return myWindow != null ? myWindow.getShell() : null;
	}

	private IWorkbenchWindow myWindow;
	private ISelection mySelection;
}