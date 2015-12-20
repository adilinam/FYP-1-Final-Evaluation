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
 * Created on Jul 27, 2005
 */
package org.eclipse.m2m.internal.qvt.oml.ocl.transformations;

public class LibraryOperationException extends Exception {

	private static final long serialVersionUID = 4842759010574321180L;
	
	private LibraryOperation myOperation;

    public LibraryOperationException(String message) {
        super(message);
    }

    public LibraryOperationException(String message,
            LibraryOperation libraryOperation) {
        super(message);
        myOperation = libraryOperation;
    }
    
    public LibraryOperationException(String message, LibraryOperation libraryOperation, Throwable cause) {
        super(message, cause);
        myOperation = libraryOperation;
    }

    public LibraryOperation getLibraryOperation() {
        return myOperation;
    }

}
