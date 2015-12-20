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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.m2m.internal.qvt.oml.QvtNamesChecker;

public class QvtCompilationUnit extends QvtBaseElement implements IQvtCompilationUnit {

	private QvtNamespace fNamespace;
	private IFile fFile;
	private String fMainModuleName;	
	
	protected QvtCompilationUnit(QvtNamespace parent, String compilationUnitFileName) {
		super(parent, compilationUnitFileName);
		
		if(parent == null || compilationUnitFileName == null) {
			throw new IllegalArgumentException();
		}

		assert QvtNamesChecker.isValidCompilationUnitFileName(compilationUnitFileName);
		
		fNamespace = parent;
		fMainModuleName = QvtNamesChecker.getCompilationUnitMainModuleName(compilationUnitFileName);
	}
	
	@Override
	public String getName() {	
		return fMainModuleName;  
	}

	public IQvtNamespace getNamespace() { 
		return fNamespace;
	}
	
	public IQvtProject getQvtProject() {
		return fNamespace.getQvtProject();
	}

	public String getQualifiedName() {
		if(fNamespace.isDefaultNamespace()) {
			return getName();
		}
		return fNamespace.getQualifiedName() + IQvtNamespace.NAME_SEGMENT_DELIMITER + getName();
	}
	
	public int getElementType() {	
		return IQvtElement.QVT_COMPILATION_UNIT;
	}	

	@Override
	public IResource getUnderlyingResource() throws QvtModelException {		
		return getUnderlyingFile();
	}
	
	public IFile getUnderlyingFile() {
		if(fFile == null) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(getFullPath());			
		}
		
		return fFile; 
	}	
}
