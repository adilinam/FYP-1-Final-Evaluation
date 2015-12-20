/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.io.eclipse;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;


public abstract class EclipseContainer extends EclipseResource implements CFolder {
	EclipseContainer(IContainer cont) {
		super(cont);
	}
	
	public static CFolder makeFolder(IContainer cont) {
		if(cont instanceof IFolder) {
			return new EclipseFolder((IFolder)cont);
		}
		else if(cont instanceof IProject) {
			return new EclipseProject((IProject)cont);
		}
        else if(cont instanceof IWorkspaceRoot) {
            return new EclipseRoot((IWorkspaceRoot)cont);
        }
		else {
			throw new IllegalArgumentException("Not a folder: " + cont); //$NON-NLS-1$
		}
	}

	public CFile getFile(String name) {
		return new EclipseFile(getContainer().getFile(new Path(name)));
	}

	private IContainer getContainer() {
		return (IContainer)myResource;
	}
}
