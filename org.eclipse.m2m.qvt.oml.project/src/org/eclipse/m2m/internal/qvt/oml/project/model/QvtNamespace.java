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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

public class QvtNamespace extends QvtBaseElement implements IQvtNamespace {
	
	private QvtNamespace fParentNamespace;
	private IContainer fContainer;
	
	private List<IQvtCompilationUnit> compilationUnits;
	private List<IQvtNamespace> ownedNamespaces;
	

	/**
	 * Owned name-space constructor.
	 */	
	protected QvtNamespace(QvtNamespace parent, String name) {
		super(parent, name);		
		fParentNamespace = parent;
	}
	
	/**
	 * Root name-space constructor.
	 */
	protected QvtNamespace(IPath parentPath, String name) {
		super(parentPath, name);		
		fParentNamespace = null;
	}
	
	public IQvtProject getQvtProject() {
		return fParentNamespace.getQvtProject();
	}
	
	public int getElementType() {	
		return IQvtElement.QVT_NAMESPACE;
	}		
	
	public List<IQvtCompilationUnit> getCompilationUnits() throws QvtModelException {
		if(compilationUnits == null) {
			IContainer container = (IContainer)getUnderlyingResource();
			List<String> moduleFileNames = null;
			try {
				moduleFileNames = QvtElementMemberColllector.getMemberModules(container);
				List<IQvtCompilationUnit> units = new ArrayList<IQvtCompilationUnit>(moduleFileNames.size());
				for (String moduleFileName  : moduleFileNames) {
					units.add(new QvtCompilationUnit(this, moduleFileName));
				}
				
				compilationUnits = units;			
				
			} catch (CoreException e) {
				propagateAsQvtModelException("Can't retrieve compilation units", e); //$NON-NLS-1$
			}			
		}
		
		return compilationUnits;
	}

	public IQvtCompilationUnit findCompilationUnit(String compilationUnitName) throws QvtModelException {
		if(!getUnderlyingResource().exists()) {
			return null;
		}
		for (IQvtCompilationUnit cu : getCompilationUnits()) {
			if(cu.getName().equals(compilationUnitName)) {
				return cu;
			}
		}
		return null;		
	}
	
	public IQvtNamespace findOwnedNamespace(String namespaceSimpleName) throws QvtModelException {
		for (IQvtNamespace namespace : getOwnedNamespaces()) {
			if(namespace.getName().equals(namespaceSimpleName)) {
				return namespace;
			}
		}
		return null;		
	}

	@Override
	public IResource getUnderlyingResource() throws QvtModelException {
		if(fContainer == null) {		
			IPath path = getFullPath();
			IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();						
			if(path.segmentCount() > 1) {
				fContainer = wsRoot.getFolder(path);
			} else {
				fContainer = wsRoot.getProject(path.segment(0));
			}
		}
		
		return fContainer;
	}

	public List<IQvtNamespace> getOwnedNamespaces() throws QvtModelException {
		if(ownedNamespaces == null) {
			try {
				IContainer container = (IContainer)getUnderlyingResource();				
				List<String> folderNames = QvtElementMemberColllector.getMemberNamespaces(container);
				List<IQvtNamespace> namespaces = new ArrayList<IQvtNamespace>(folderNames.size());
				
				for (String folderName  : folderNames) {
					namespaces.add(new QvtNamespace(this, folderName));
				}

				ownedNamespaces = namespaces;			
				
			} catch (CoreException e) {
				propagateAsQvtModelException("Can't retrieve compilation units", e); //$NON-NLS-1$
			}			
		}
		return ownedNamespaces;
		
	}

	public String getQualifiedName() {
		if(fParentNamespace == null) {
			return getName();
		}
		return fParentNamespace.getQualifiedName() + IQvtNamespace.NAME_SEGMENT_DELIMITER + getName();
	}
	
	public IQvtNamespace getParentNamespace() {	
		return fParentNamespace;
	}

	public boolean isDefaultNamespace() {
		return IQvtNamespace.DEFAULT_NAMESPACE_NAME.equals(getName());
	}
	
}