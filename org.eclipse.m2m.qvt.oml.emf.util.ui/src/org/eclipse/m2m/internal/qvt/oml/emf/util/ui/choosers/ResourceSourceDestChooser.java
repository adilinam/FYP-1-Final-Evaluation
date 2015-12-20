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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.provider.EmfModelContentProvider;

public class ResourceSourceDestChooser extends ResourceSourceChooser implements IDestinationChooser {
    public ResourceSourceDestChooser(ResourceSet rs) {
    	super(true, rs);
    }
    
    @Override
	protected String getDefaultFileName() {
		return myFileName;
	}
    
    @Override
	public void setInitialSelection(String uriString) {
    	myFileName = myDefaultFileName;
    	
    	URI uri = uriString.trim().length() == 0 ? null : URI.createURI(uriString);
        if(uri == null) {
            return;
        }

        IFile file = WorkspaceUtils.getWorkspaceFile(uri);
        if(file != null) {
	        if (file.exists()) {
	        	myInitialSelection = createSelectionForUri(uri, file);
	        }
	        else {
	            myInitialSelection = new StructuredSelection(file.getParent());
	            myFileName = file.getName();
	        }
	        return;
        }

        ModelContent loadModel = EmfUtil.safeLoadModel(uri, myResourceSet);
        EObject obj = (loadModel != null && !loadModel.getContent().isEmpty() ? loadModel.getContent().get(0) : null);
        if (obj != null) {
            myInitialSelection = new StructuredSelection(EmfModelContentProvider.makeEObjectNode(obj, null));
            return;
        }
    }

	public void initNewName(String baseName, String extension) {
        myDefaultFileName = baseName;
        if(extension.length() > 0) {
            myDefaultFileName += "." + extension; //$NON-NLS-1$
        }
	}
    
    private String myFileName;
    private String myDefaultFileName;
}
