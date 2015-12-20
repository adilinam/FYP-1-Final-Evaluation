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
/*
 * Created on May 31, 2005
 */
package org.eclipse.m2m.internal.qvt.oml.ocl.transformations;

public class LibraryCreationException extends Exception {

	private static final long serialVersionUID = -4703260527546635146L;

	public LibraryCreationException(String message) {
        super(message);
    }
    
    public LibraryCreationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
