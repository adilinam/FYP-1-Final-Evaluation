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


public interface IQvtNamespace extends IQvtElement {
	
	/**
	 * <p>
	 * The name for the default name-space (value: the empty string,
	 * <code>""</code>).
	 * </p>
	 */
	String DEFAULT_NAMESPACE_NAME = ""; //$NON-NLS-1$
	
	String NAME_SEGMENT_DELIMITER = "."; //$NON-NLS-1$	
	
	String getQualifiedName();

	boolean isDefaultNamespace();
	
	List<IQvtCompilationUnit> getCompilationUnits() throws QvtModelException;
	
	List<IQvtNamespace> getOwnedNamespaces() throws QvtModelException;
	
	IQvtNamespace getParentNamespace();
	
	IQvtCompilationUnit findCompilationUnit(String compilationUnitName) throws QvtModelException;
	
	IQvtNamespace findOwnedNamespace(String namespaceSimpleName) throws QvtModelException;	
}