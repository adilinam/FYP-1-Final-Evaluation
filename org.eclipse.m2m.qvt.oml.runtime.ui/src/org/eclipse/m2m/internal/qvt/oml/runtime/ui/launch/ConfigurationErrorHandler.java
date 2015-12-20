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
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.jface.util.Policy;
import org.eclipse.m2m.internal.qvt.oml.common.ui.CommonUIUtils;
import org.eclipse.osgi.util.NLS;

public class ConfigurationErrorHandler implements IStatusHandler {
	
	public ConfigurationErrorHandler() {	
	}
	
	public Object handleStatus(final IStatus status, final Object source) throws CoreException {
		if(source instanceof ILaunchConfiguration == false) {
			throw new CoreException(status);
		}
		
		final ILaunchConfiguration configuration = (ILaunchConfiguration)source;
		CommonUIUtils.getStandardDisplay().asyncExec(new Runnable() {
			public void run() {
				String errorMessage = NLS.bind(Messages.ConfigurationErrorHandler_launchingError, configuration.getName());
				Policy.getStatusHandler().show(status, errorMessage);
			}
		});

		return Status.OK_STATUS;
	}
}