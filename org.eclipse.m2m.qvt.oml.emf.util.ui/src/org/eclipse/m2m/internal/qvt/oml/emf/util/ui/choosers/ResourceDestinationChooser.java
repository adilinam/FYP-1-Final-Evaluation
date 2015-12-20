/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.controls.IPathUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.controls.SelectFileControl;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;


public class ResourceDestinationChooser extends ChooserAdapter implements IDestinationChooser {
    public static final int DEFAUL_AUTO_EXPAND_LEVEL = 2;
    
    public ResourceDestinationChooser() {
    }
    
    public String getTitle() {
        return Messages.ResourceDestinationChooser_0;
    }
    
    public Control createControl(final Composite parent) {
        myControl = new SelectFileControl(parent, myFileName, myDefaultFileName, false, null);
        myControl.addSelectionListener(new SelectFileControl.ISelectionListener() {
            public void selectionChanged(IPath path) {
                myPath = myControl.getSelectedPath();
                fireChangedEvent();
            }
        });
        
        if(myInitialSelection != null) {
            myControl.setSelection(myInitialSelection);
        }
        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, 
			"org.eclipse.m2m.qvt.oml.resource_destination_chooser"); //$NON-NLS-1$
        return myControl;
    }
    
    public void setInitialSelection(String uriString) {
        URI uri = uriString.trim().length() == 0 ? null : URI.createURI(uriString);
        if(uri == null) {
            return;
        }
        
        IFile file = WorkspaceUtils.getWorkspaceFile(uri);
        if(file == null) {
            return;
        }
        
        if(file.exists()) {
    		myInitialSelection = ResourceSourceChooser.createSelectionForUri(uri, file);
        }
        else {
            myInitialSelection = new StructuredSelection(file.getParent());
        }
        
        myFileName = file.getName();
    }
    
    public void initNewName(String baseName, String extension) {
        myDefaultFileName = baseName;
        if(extension.length() > 0) {
            myDefaultFileName += "." + extension; //$NON-NLS-1$
        }
    }
    
    public IPath getPath() {
        return myPath;
    }
    
    public String getUriString() {
        URI uri = IPathUtils.getUri(getPath());
        return uri == null ? null : uri.toString();
    }
    
    private SelectFileControl myControl;
    private IStructuredSelection myInitialSelection;
    private String myFileName;
    private String myDefaultFileName;
    private IPath myPath;
}
