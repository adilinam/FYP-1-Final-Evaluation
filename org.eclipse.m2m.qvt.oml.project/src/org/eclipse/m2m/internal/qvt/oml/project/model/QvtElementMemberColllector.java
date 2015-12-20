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
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.internal.qvt.oml.QvtNamesChecker;

public class QvtElementMemberColllector {
	
	public static List<String> getMemberModules(final IContainer container) throws CoreException {
		return getMemberNames(container, true);
	}
	
	public static List<String> getMemberNamespaces(final IContainer container) throws CoreException {
		return getMemberNames(container, false);
	}
	
	
	private static List<String> getMemberNames(final IContainer container, final boolean collectModules) throws CoreException {
		
		final List<String> result = new ArrayList<String>();
		
		IResourceProxyVisitor visitor = new IResourceProxyVisitor() {
			private boolean rootVisited = false;
			
			public boolean visit(IResourceProxy proxy) throws CoreException {
				if(!rootVisited) {
					rootVisited = true;
					return true;
				}
				
				String name = proxy.getName();
				if(!collectModules && proxy.getType() == IResource.FOLDER) {
					if(isQvtFolderName(name)) {
						result.add(name);
					}
				} 
				else if(collectModules && proxy.getType() == IResource.FILE) {
					if(isQvtFileName(name)) {
						result.add(name);
					}					
				}
				return false;
			}
		};

		container.accept(visitor, IResource.NONE);
		
		return result;
	}
	
    public static boolean isQvtFolderName(String folderName) {
    	return QvtNamesChecker.validateNamespaceSimpleIdenfier(folderName).isOK();
    }
	
    public static boolean isQvtFileName(String fileName) {
    	return QvtNamesChecker.isValidCompilationUnitFileName(fileName);
    }
}
