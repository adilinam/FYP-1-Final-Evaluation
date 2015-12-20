/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.project.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

class BaseNature implements IProjectNature {

	private IProject myProject;

	protected BaseNature() {
		super();
	}

	public IProject getProject() {
	    return myProject;
	}

	public void setProject(IProject project) {
	    myProject = project;
	}

	public void configure() throws CoreException {
		// do nothing
	}
	
	public void deconfigure() throws CoreException {
		// do nothing
	}	
}