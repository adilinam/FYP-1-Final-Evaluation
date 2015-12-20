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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.m2m.internal.qvt.oml.common.ui.CommonUIUtils;
import org.eclipse.ui.progress.IProgressConstants;

public class TransformationJobDoneHandler implements IStatusHandler {
	
	public TransformationJobDoneHandler() {	
	}
	
	public Object handleStatus(IStatus status, Object source) throws CoreException {
		if(!(source instanceof Object[])) {
			return null;
		}
		Object[] args = (Object[])source;
		if(args.length == 0) {
			return null;
		}
		
		if (args[0] instanceof Job) {
			Job doneJob = (Job)args[0];
			IAction doneAction = null;
			if(args.length > 1 && args[1] instanceof Runnable) {
				final Runnable runnable = (Runnable)args[1];
				doneAction = new Action() {
					@Override
					public void run() {
						runnable.run();
					}
				};
			}
			handleDone(doneJob, doneAction);			
		}
		
		return Status.OK_STATUS;
	}
	
	private void handleDone(Job doneJob, final IAction doneAction) {
		if (doneAction != null) {
				CommonUIUtils.getStandardDisplay().asyncExec(new Runnable() {
					public void run() {
						doneAction.run();
					}
				});
		}
		
		doneJob.setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.FALSE);
	}
	
	boolean isModal(Job doneJob) {
		Boolean inDialog = (Boolean) doneJob.getProperty(IProgressConstants.PROPERTY_IN_DIALOG);
		return (inDialog == null) ? false : inDialog.booleanValue();
	}	
}