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
package org.eclipse.m2m.internal.qvt.oml.runtime.launch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;


public class DeleteBuilderMarkersListener implements IResourceChangeListener {
    public DeleteBuilderMarkersListener() {
    }
    
    public void resourceChanged(IResourceChangeEvent event) {
        if(event.getType() != IResourceChangeEvent.PRE_BUILD) {
            return;
        }
        
        IResourceDelta delta = event.getDelta();
        if(delta == null) {
            return;
        }
        
        final List<IProject> projects = new ArrayList<IProject>();
        try {
            delta.accept(new IResourceDeltaVisitor() {
                public boolean visit(IResourceDelta delta) throws CoreException {
                    if(delta.getResource() instanceof IWorkspaceRoot) {
                        return true;
                    }
                    else if(delta.getResource() instanceof IProject) {
                        projects.add((IProject)delta.getResource());
                        return false;
                    }
                    else {
                        return false;
                    }
                }
            });
        } 
        catch (CoreException e) {
            Logger.getLogger().log(Logger.SEVERE, "Failed to traverse " + delta); //$NON-NLS-1$
        }
        
        for(IProject project : projects) {
            if(project.isOpen()) {
                deleteMarkers(project, QvtBuilderLaunchConfigurationDelegate.QVTO_BUILDER_MARKER);
            }
        }
    }

    private void deleteMarkers(IProject project, String type) {
        try {
            project.deleteMarkers(type, false, IResource.DEPTH_ONE);
        }
        catch (CoreException e) {
            Logger.getLogger().log(Logger.SEVERE, "Failed to delete markers on " + project, e); //$NON-NLS-1$
        }
    }

}

