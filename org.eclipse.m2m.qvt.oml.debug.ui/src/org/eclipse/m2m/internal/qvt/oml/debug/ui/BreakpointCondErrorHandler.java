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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.debug.ui.actions.QVTOBreakpointPropertiesAction;
import org.eclipse.m2m.qvt.oml.debug.core.BreakpointError;
import org.eclipse.m2m.qvt.oml.debug.core.QVTOBreakpoint;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class BreakpointCondErrorHandler implements IStatusHandler {
	
	private static class CondErrorDialog extends ErrorDialog {
	    
	    CondErrorDialog(Shell parentShell, String message, IStatus status) {
	        super(parentShell, DebugUIMessages.BreakpointCondErrorHandler_DialogTitle, message, status, IStatus.ERROR); 
	    }

	    @Override
	    protected void createButtonsForButtonBar(Composite parent) {
	        // create buttons to cancel the handler or edit the condition settings
			createButton(parent, IDialogConstants.CANCEL_ID,
					IDialogConstants.CANCEL_LABEL, false);
			createButton(
					parent,
					IDialogConstants.OK_ID,
					DebugUIMessages.BreakpointCondErrorHandler_EditConditionButtonLabel,
					true);
	    }
	}	
	
	public BreakpointCondErrorHandler() {
		super();
	}
	
	public Object handleStatus(IStatus status, Object source) throws CoreException {
		if(source instanceof IDebugTarget == false) {
			throw new CoreException(QVTODebugCore.createStatus(IStatus.ERROR,
					"Unable to resolve status for:" + source)); //$NON-NLS-1$
		}
		
		BreakpointError breakpointError = (BreakpointError) status;
		final IDebugTarget target = (IDebugTarget) source;
		
		suspendDebugUI(target);

		showErrorDialog(
				breakpointError.getfBreakpointID(), 
				breakpointError.getMessage(), 
				breakpointError.getDetail());
		
		return Boolean.TRUE;
	}

    public void showErrorDialog(final long breakPointID, final String errorMessage, final String detail) {    	
        final Display display = QVTODebugUIPlugin.getStandardDisplay();

        display.asyncExec(new Runnable() {
            public void run() {               
            	QVTOBreakpoint breakpoint = QVTOBreakpoint.getBreakpointByID(breakPointID);
            	if(breakpoint == null) {
    				QVTODebugCore.log(QVTODebugCore.createStatus(IStatus.ERROR,"Breakpoint not found")); //$NON-NLS-1$
         			return;
            	}

                if (display.isDisposed()) {
                    return;
                }
                
                Shell shell = QVTODebugUIPlugin.getActiveWorkbenchShell();
                IStatus errorStatus = QVTODebugUIPlugin.createErrorStatus(detail);
                
                CondErrorDialog dialog = new CondErrorDialog(shell, errorMessage, errorStatus);
                int result = dialog.open();
                if (result == Window.OK) {
                	// jump to breakpoint properties
                    QVTOBreakpointPropertiesAction action = new QVTOBreakpointPropertiesAction();
                    action.selectionChanged(null, new StructuredSelection(breakpoint));
                    action.run(null);
                }
            }
        });
    }	
    
	private void suspendDebugUI(final IDebugTarget target) {
		QVTODebugUIPlugin.getStandardDisplay().asyncExec(new Runnable() {
			public void run() {
				try {
					IThread[] threads = target.getThreads();
					IThread mainThread = (threads.length > 0) ? threads[0] : null;
					// check if we still execute
					if(mainThread != null) {
						// Note: broadcast the suspend even to update the debug framework UI
						DebugEvent debugEvent = new DebugEvent(mainThread, DebugEvent.SUSPEND, DebugEvent.BREAKPOINT);
						DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { debugEvent });
					}
					
				} catch (DebugException e) {
					QVTODebugUIPlugin.log(e.getStatus());
				}
			}
		});
	}	    
}
