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
package org.eclipse.m2m.internal.qvt.oml.ui.wizards.project;

import java.util.ArrayList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.m2m.internal.qvt.oml.common.ui.FolderSelectionDialog;
import org.eclipse.m2m.internal.qvt.oml.common.ui.TypedElementSelectionValidator;
import org.eclipse.m2m.internal.qvt.oml.common.ui.TypedViewerFilter;
import org.eclipse.m2m.internal.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

public class ChooseProjectFolderDialog extends FolderSelectionDialog {
    public ChooseProjectFolderDialog(IProject project, IContainer initialContainer, Shell shell, String title, String message) {
        super(shell, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
        
        IWorkspaceRoot root = project.getWorkspace().getRoot();
        final Class<?>[] acceptedClasses = new Class[] { IProject.class, IFolder.class };
        IProject[] allProjects = root.getProjects();
        ArrayList<IProject> rejectedElements = new ArrayList<IProject>(allProjects.length);
        for (int i = 0; i < allProjects.length; i++) {
            if (!allProjects[i].equals(project)) {
                rejectedElements.add(allProjects[i]);
            }
        }
        
        ViewerFilter filter = new TypedViewerFilter(acceptedClasses, rejectedElements.toArray());

        IResource initSelection = null;
        if (initialContainer != null) {
            initSelection = root.findMember(initialContainer.getFullPath());
        }

        setTitle(title);

        setValidator(new ISelectionStatusValidator() {
            ISelectionStatusValidator validator = new TypedElementSelectionValidator(acceptedClasses, false);

            public IStatus validate(Object[] selection) {
                IStatus typedStatus = validator.validate(selection);
                if (!typedStatus.isOK())
                    return typedStatus;
                
                return new Status(IStatus.OK, QVTUIPlugin.PLUGIN_ID, 0, "", null); //$NON-NLS-1$
            }
        });
        
        setMessage(message);
        addFilter(filter);
        setInput(root);
        setInitialSelection(initSelection);
        setComparator(new ResourceComparator(ResourceComparator.NAME));
    }
}
