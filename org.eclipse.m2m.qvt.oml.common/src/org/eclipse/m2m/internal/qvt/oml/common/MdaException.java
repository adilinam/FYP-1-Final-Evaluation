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
package org.eclipse.m2m.internal.qvt.oml.common;

import org.eclipse.core.runtime.IStatus;


/**
 * @author pkobiakov
 */
public class MdaException extends Exception {
	private static final long serialVersionUID = 4003559255399844949L;

	public MdaException(String message) {
		super(message);
	}
	
	public MdaException(IStatus status) {
		super(status.getMessage());
		myStatus = status;
	}
	
	public MdaException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public MdaException(Throwable cause) {
		super(cause);
	}
	
	public IStatus getStatus() {
		return myStatus;
	}
	
	private IStatus myStatus; 
}
