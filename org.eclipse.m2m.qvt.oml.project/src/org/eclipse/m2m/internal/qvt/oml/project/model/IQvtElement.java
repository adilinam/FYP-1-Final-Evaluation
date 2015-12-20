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
import org.eclipse.core.runtime.IPath;

public interface IQvtElement {

	int QVT_PROJECT = 1;
	
	int QVT_NAMESPACE = 2;
	
	int QVT_COMPILATION_UNIT = 3;	
	

	int getElementType();
	
	String getName();
	
	IPath getFullPath();
	
	IResource getUnderlyingResource() throws QvtModelException;
	
	IQvtProject getQvtProject();
}
