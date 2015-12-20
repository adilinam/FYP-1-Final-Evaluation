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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

public abstract class QvtBaseElement implements IQvtElement {
	
	private String fName;
	private IPath fPath;
	
	public QvtBaseElement(IPath path, String name) {		
		if(name == null || path == null) {
			throw new IllegalArgumentException();
		}
		
		fName = name;
		fPath = path.append(name);
	}
	
	public QvtBaseElement(QvtBaseElement parent, String name) {		
		this(parent.fPath, name);
	}

	public abstract IResource getUnderlyingResource() throws QvtModelException;	
	
	public String getName() {
		return fName;
	}
	
	public IPath getFullPath() {
		return fPath;
	}
	
	protected void propagateAsQvtModelException(String message, CoreException coreException) throws QvtModelException {
		throw new QvtModelException(message, coreException); 
	}
	
	protected void propagateAsQvtModelException(CoreException coreException) throws QvtModelException {
		throw new QvtModelException(coreException); 
	}
	
	@Override
	public String toString() {
		return getFullPath().toString();
	}
}