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
package org.eclipse.m2m.internal.qvt.oml.project.model;

public class QvtModelException extends Exception {

	private static final long serialVersionUID = 7653104289303444500L;

	protected QvtModelException() {
		super();
	}

	public QvtModelException(String message, Throwable cause) {
		super(message, cause);
	}

	public QvtModelException(String message) {
		super(message);
	}

	public QvtModelException(Throwable cause) {
		super(cause);	
	}
}
