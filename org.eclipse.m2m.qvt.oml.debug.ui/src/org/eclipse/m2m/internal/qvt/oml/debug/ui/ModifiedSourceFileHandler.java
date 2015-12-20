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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;


public class ModifiedSourceFileHandler implements IStatusHandler {
	
	public ModifiedSourceFileHandler() {
		super();
	}
	
	public Object handleStatus(IStatus status, Object source) throws CoreException {
		if(source instanceof IPath == false) {
			throw new CoreException(QVTODebugCore.createStatus(IStatus.ERROR,
					"Unable to resolve status for:" + source)); //$NON-NLS-1$			
		}
		
		IStatus presentStatus = QVTODebugUIPlugin.createStatus(IStatus.WARNING, DebugUIMessages.ModifiedSourceFileHandler_HotReplaceNotSupported);
		ErrorDialog errorDialog = new ErrorDialog(
				QVTODebugUIPlugin.getActiveWorkbenchShell(),
				null,
				DebugUIMessages.ModifiedSourceFileHandler_ModifiedDebuggedSource,
				presentStatus, IStatus.WARNING);

		errorDialog.open();
		return Boolean.TRUE;
	}	    
}
