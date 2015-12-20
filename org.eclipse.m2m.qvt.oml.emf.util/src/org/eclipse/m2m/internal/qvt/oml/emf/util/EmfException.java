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
package org.eclipse.m2m.internal.qvt.oml.emf.util;

public class EmfException extends Exception {
	private static final long serialVersionUID = 334684920943331092L;

	public EmfException(String message) {
		super(message);
	}
	
	public EmfException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EmfException(Throwable cause) {
		super(cause);
	}
}
