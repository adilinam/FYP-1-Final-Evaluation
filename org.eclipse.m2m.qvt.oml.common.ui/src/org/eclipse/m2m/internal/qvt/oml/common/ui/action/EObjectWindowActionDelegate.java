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
package org.eclipse.m2m.internal.qvt.oml.common.ui.action;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;



public abstract class EObjectWindowActionDelegate extends WindowActionDelegate {
    @Override
	public void selectionChanged(IAction action, ISelection selection) {
        super.selectionChanged(action, selection);
        URI sel = getSelectedEObject(false);
        action.setEnabled(sel != null || getSelectedElement() instanceof IFile);
    }

    protected URI getSelectedEObject() {
        return getSelectedEObject(true);
    }
    
    private URI getSelectedEObject(boolean considerFiles) {
        Object sel = super.getSelectedElement();
        if(sel instanceof EObject) {
            return EcoreUtil.getURI((EObject)sel);
        }
        
        if(sel instanceof IAdaptable) {
            IAdaptable adaptable = (IAdaptable)sel;
            EObject adapted = (EObject)adaptable.getAdapter(EObject.class);
            if(adapted != null) {
                return EcoreUtil.getURI(adapted);
            }
        }
        
        if(sel instanceof IFile && considerFiles) {
            IFile file = (IFile)sel;
            try {
            	return URI.createPlatformResourceURI(file.getFullPath().toString(), false);
            }
            catch(Exception ignore) {
            }
        }

        return null;
    }
}
