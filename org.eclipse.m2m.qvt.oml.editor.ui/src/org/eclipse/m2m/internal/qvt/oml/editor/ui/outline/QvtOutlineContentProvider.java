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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.outline;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;


public class QvtOutlineContentProvider implements ITreeContentProvider {
        
    public Object[] getChildren(Object parentElement) {
    	OutlineNode parentNode = (OutlineNode) parentElement;
		return parentNode.getChildren().toArray();
    }
    
    public Object getParent(Object element) {
    	return ((OutlineNode) element).getParent();
    }

    public boolean hasChildren(Object element) {
    	OutlineNode node = (OutlineNode) element;
        return !node.getChildren().isEmpty();
    }

    public Object[] getElements(Object inputElement) {
        if (inputElement instanceof QvtOutlineInput) {
            return ((QvtOutlineInput) inputElement).getChildren();
        } else {
            return new Object[0];
        }
    }
   
    public void dispose() {}

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
   
}