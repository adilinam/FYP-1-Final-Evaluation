/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
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
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.internal.qvt.oml.QvtNamesChecker;
import org.eclipse.m2m.internal.qvt.oml.project.QVTOProjectPlugin;
import org.eclipse.m2m.internal.qvt.oml.project.builder.QVTOBuilderConfig;

public class QvtProject extends QvtBaseElement implements IQvtProject {
	
	private IProject fProject;
	private List<IQvtNamespace> rootNamespaces;
	private IQvtNamespace defaultNamespace;	
	private IContainer srcContainer;
	
	public QvtProject(IProject project) {
		super(project.getFullPath(), project.getName());
		
		fProject = project;
	}
	
	public IProject getProject() {
		return fProject;
	}
	
	public IQvtProject getQvtProject() {
		return this;
	}
	
	public IQvtNamespace getDefaultNamespace() throws QvtModelException {
		if(defaultNamespace == null) {
			defaultNamespace = new QvtRootNamespace(this, IQvtNamespace.DEFAULT_NAMESPACE_NAME);
		}
		
		return defaultNamespace;		
	}
	
	public List<IQvtNamespace> getRootNamespaces() throws QvtModelException {
		if(rootNamespaces == null) {
			try {
				IContainer container = getSourceContainer();
				List<IQvtNamespace> result = new ArrayList<IQvtNamespace>();
				
				List<String> folderNames = QvtElementMemberColllector.getMemberNamespaces(container);
				for (String folderName : folderNames) {
					result.add(new QvtRootNamespace(this, folderName));
				}

				// add virtual default name-space
				IQvtNamespace virtualDefault = getDefaultNamespace();
				if(!virtualDefault.getCompilationUnits().isEmpty()) {
					result.add(getDefaultNamespace());
				}
				
				rootNamespaces = result;
				
			} catch (CoreException e) {
				propagateAsQvtModelException(e);
			}
			
		}
		
		return rootNamespaces;
	}
	
	public IPath getQvtSourceContainerPath() throws QvtModelException {
		return getSourceContainer().getFullPath();
	}
	
	public IContainer getSourceContainer() throws QvtModelException {
		if(srcContainer == null) {
			try {
				srcContainer = QVTOBuilderConfig.getConfig(fProject).getSourceContainer();
			} catch (CoreException e) {
				propagateAsQvtModelException("Failed to read QVT builder config", e); //$NON-NLS-1$
			}
		}
		
		return srcContainer;
	}	
	
	public int getElementType() {	
		return IQvtElement.QVT_PROJECT;
	}
	
	@Override
	public IResource getUnderlyingResource() throws QvtModelException {	
		return fProject;
	}
	
    public IQvtNamespace findRootNamespace(String namespaceSimpleName) throws QvtModelException {
    	for (IQvtNamespace namespace : getRootNamespaces()) {
    		if(namespace.getName().equals(namespaceSimpleName)) {
    			return namespace;
    		}
		}
    	
    	return null;
    }	
    
    public IQvtCompilationUnit findCompilationUnit(String unitQualifiedName) throws QvtModelException {
		String localName = QvtNamesChecker.extractLocalIdentifierPart(unitQualifiedName);
		String namespace = QvtNamesChecker.extractQualifyingIdentifierPart(unitQualifiedName);

		IQvtNamespace owner = findNamespace(namespace);
		if(owner != null) {
			return owner.findCompilationUnit(localName);
		}
    	return null;
    }
    
    public IQvtNamespace findNamespace(String namespaceQualifiedName) throws QvtModelException {    	
		if(IQvtNamespace.DEFAULT_NAMESPACE_NAME.equals(namespaceQualifiedName)) {
			return getDefaultNamespace();
		}

    	IStatus nameStatus = QvtNamesChecker.validateNamespaceQualifiedIdentifier(namespaceQualifiedName);
    	if(!nameStatus.isOK()) {
    		throw new IllegalArgumentException(nameStatus.getMessage());
    	}

		String[] nsSegments = QvtNamesChecker.getQualifiedNameSegments(namespaceQualifiedName);
		IQvtNamespace rootNamespace = findRootNamespace(nsSegments[0]);
		if(rootNamespace == null) {
			return null;
		}
		
		// look down the hierarchy if required
		if(nsSegments.length > 1) {
			List<String> subNamespace = new ArrayList<String>(Arrays.asList(nsSegments));
			subNamespace.remove(0);
			return findRecursively(subNamespace.toArray(new String[subNamespace.size()]), rootNamespace);
		}
		
		return rootNamespace;
    }
    
	public IQvtElement findElement(IResource resource, boolean exactMatchOnly) throws QvtModelException {
		if(!fProject.equals(resource.getProject())) {
			return null;
		} else if(resource.getType() == IResource.PROJECT) {
			return this;
		}

		IQvtElement element = findExactElement(resource);
		if(element == null && !exactMatchOnly) {
			if(resource.getParent() != null) {
				element = findClosestElement(resource.getParent());
			}
		}
		
		return element;
	}
	
    private IPath getPathInSrcContainer(IResource resource) {
    	try {
			IPath containerPath = getSourceContainer().getFullPath();
			IPath resourcePath = resource.getFullPath();
			if(containerPath.equals(resourcePath)) {
				return Path.ROOT;
			}
			if(containerPath.segmentCount() < resourcePath.segmentCount() && containerPath.isPrefixOf(resourcePath)) {
				return resourcePath.removeFirstSegments(containerPath.segmentCount());
			}
		} catch (QvtModelException e) {
			QVTOProjectPlugin.log(e);
		}
		
		return null;
    }
    
    
    private IQvtElement findClosestElement(IResource resource) throws QvtModelException  {    	
		IQvtElement element = findExactElement(resource);
		if(element == null) {
			if(resource.getType() == IResource.PROJECT) {
				return this;
			}
			
			IContainer parent = resource.getParent();
	    	if(parent != null) {
	    		element = findClosestElement(parent);
	    	}
		}

    	return element;
    }
	
    private IQvtElement findExactElement(IResource resource) throws QvtModelException  {
    	IPath srcRelativePath = getPathInSrcContainer(resource);
    	if(srcRelativePath == null) {
    		return null;
    	} 
    	
    	if(srcRelativePath.isRoot()) {
    		return getDefaultNamespace();
    	}
    	    
    	IPath namespacePath = srcRelativePath;
    	boolean isFile = resource.getType() == IResource.FILE;
    	if(isFile) {
    		if(!QvtNamesChecker.isValidCompilationUnitFileName(resource.getName())) {
    			return null;
    		}
    		
    		namespacePath = (srcRelativePath.segmentCount() > 1) ? srcRelativePath.removeLastSegments(1) :  null;    		
    	}

    	IQvtNamespace namespace = null;
    	if(namespacePath == null) {
			namespace = getDefaultNamespace();
		} else {	    	
			IQvtNamespace root = findRootNamespace(namespacePath.segment(0));
			if(root != null) {
				if(namespacePath.segmentCount() > 1) {    			
					namespace = findRecursively(namespacePath.removeFirstSegments(1).segments(), root);
				} else {
					namespace = root;
				}
			}
		}
    	    	
    	if(isFile && namespace != null) {
			// QVT module in default name-space
			String cuName = QvtNamesChecker.getCompilationUnitMainModuleName(resource.getName());
			return namespace.findCompilationUnit(cuName);    		
    	}
    	
    	return namespace;
    }
    
    private static IQvtNamespace findRecursively(String[] path, IQvtNamespace startNamespace) throws QvtModelException {
    	IQvtNamespace parent = startNamespace;
    	
    	for (String nameElement : path) {
    		IQvtNamespace next = parent.findOwnedNamespace(nameElement);    		
    		if(next == null) {
    			return null;
    		}
    		
    		parent = next;
    	}
    	
    	return parent;
    }
}