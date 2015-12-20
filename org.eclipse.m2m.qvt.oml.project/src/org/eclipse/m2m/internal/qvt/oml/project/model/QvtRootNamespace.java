/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.project.model;


public class QvtRootNamespace extends QvtNamespace {

	private IQvtProject fProject;
	
	protected QvtRootNamespace(IQvtProject project, String name) throws QvtModelException {
		super(project.getQvtSourceContainerPath(), name);

		this.fProject = project;
	}

	@Override
	public IQvtProject getQvtProject() {
		return fProject;
	}
}
