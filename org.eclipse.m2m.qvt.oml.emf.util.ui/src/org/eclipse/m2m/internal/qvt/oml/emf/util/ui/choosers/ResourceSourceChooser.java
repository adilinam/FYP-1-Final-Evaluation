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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.controls.SelectUriControl;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.provider.EmfModelContentProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;


public class ResourceSourceChooser extends ChooserAdapter implements ISourceChooser {
	public ResourceSourceChooser(boolean isConsiderAdapters, ResourceSet rs) {
    	myIsConsiderAdaptes = isConsiderAdapters;
    	myResourceSet = rs;
    }
    
    public Control createControl(Composite parent) {
        myControl = new SelectUriControl(parent, getDefaultFileName(), myIsConsiderAdaptes, myResourceSet);
        myControl.addSelectionListener(new SelectUriControl.ISelectionListener() {
            public void selectionChanged(URI uri) {
                if(uri == null) {
                    myUri = null;
                }
                else {
                    myUri = uri;
                }
                
                fireChangedEvent();
            }
        });
        
        if(myInitialSelection != null) {
            myControl.setSelection(myInitialSelection);
        }
        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, 
			"org.eclipse.m2m.qvt.oml.resource_source_chooser"); //$NON-NLS-1$
        return myControl;
    }
    
	protected String getDefaultFileName() {
		return null;
	}

	public void setInitialSelection(String uriString) {
    	URI uri = uriString.trim().length() == 0 ? null : URI.createURI(uriString);
        if(uri == null) {
            return;
        }

        IFile file = WorkspaceUtils.getWorkspaceFile(uri);
        if (file != null) {
            myInitialSelection = createSelectionForUri(uri, file);
            return;
        }

        ModelContent loadModel = EmfUtil.safeLoadModel(uri, myResourceSet);
        EObject obj = (loadModel != null && !loadModel.getContent().isEmpty() ? loadModel.getContent().get(0) : null);
        if (obj != null) {
            myInitialSelection = new StructuredSelection(EmfModelContentProvider.makeEObjectNode(obj, null));
            return;
        }
    }

	public static IStructuredSelection createSelectionForUri(URI uri, IFile file) {
		StructuredSelection initialSelection;
		if(!uri.hasFragment()) {
            initialSelection = new StructuredSelection(file);
        }
        else {
            ModelContent loadModel = EmfUtil.loadModel(uri);
            EObject obj = (loadModel != null && !loadModel.getContent().isEmpty() ? loadModel.getContent().get(0) : null);
	        if(obj == null) {
	        	initialSelection = new StructuredSelection(file);        	
	        }
	        else {
	        	initialSelection = new StructuredSelection(EmfModelContentProvider.makeEObjectNode(obj, file));
	        }
        }
		return initialSelection;
	}
    
    
    public String getTitle() {
        return Messages.EObjectResourceChooser_0;
    }
    
    public URI getUri() {
        return myUri;
    }
    
    public String getUriString() {
        return myUri == null ? null : myUri.toString();
    }
    
    private SelectUriControl myControl;
    protected IStructuredSelection myInitialSelection;
    private URI myUri;
    private final boolean myIsConsiderAdaptes;
    protected final ResourceSet myResourceSet;
}
