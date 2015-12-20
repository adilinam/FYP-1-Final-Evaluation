/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ui.wizards.project;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IMessageProvider;

public class Util {

	private Util() {
	}

	
    public static int getIMessageProviderSeverity(IStatus status) {
    	int type = IMessageProvider.NONE;    	
		switch (status.getSeverity()) {
		case IStatus.INFO:
			type = IMessageProvider.INFORMATION;
			break;
		case IStatus.WARNING:
			type = IMessageProvider.WARNING;
			break;
		case IStatus.ERROR:
			type = IMessageProvider.ERROR;				
			break;
		}
    	
    	return type;
    }
    
}
