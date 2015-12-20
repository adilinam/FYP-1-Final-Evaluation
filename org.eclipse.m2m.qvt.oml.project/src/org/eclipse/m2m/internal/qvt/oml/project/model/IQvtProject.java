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

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;

public interface IQvtProject extends IQvtElement {

	IProject getProject();

	List<IQvtNamespace> getRootNamespaces() throws QvtModelException;
	
	IQvtNamespace getDefaultNamespace() throws QvtModelException;
	
	IPath getQvtSourceContainerPath() throws QvtModelException;
	
	/**
	 * Find QVT element related to the given resource.
	 * 
	 * @param resource
	 *            the context within a QVT project
	 * @param exactMatchOnly
	 *            If <code>true</code>, returned element exactly matches the
	 *            given resource by its underlying resource. If
	 *            <code>false</code>, the inner most enclosing QVT element is
	 *            to be found
	 * 
	 * @return QVT element or <code>null</code> if no is found.
	 */
	IQvtElement findElement(IResource resource, boolean exactMatchOnly) throws QvtModelException;
	
	IQvtCompilationUnit findCompilationUnit(String qualifiedName) throws QvtModelException;
	
	IQvtNamespace findNamespace(String namespaceQualifiedName) throws QvtModelException;
}
