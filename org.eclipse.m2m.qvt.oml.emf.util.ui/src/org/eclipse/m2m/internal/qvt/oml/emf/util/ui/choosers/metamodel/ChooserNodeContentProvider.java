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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.metamodel;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * Responsible for providing content for tree views filled by {@link ChooserNode}
 * objects
 * @author abreslav
 *
 */
public class ChooserNodeContentProvider implements ITreeContentProvider {
    public Object[] getChildren(Object parentElement) {
        return getElements(parentElement);
    }

    public Object getParent(Object element) {
        return ((ChooserNode)element).getParent();
    }

    public boolean hasChildren(Object element) {
        return ((ChooserNode)element).hasChildren();
    }

    public Object[] getElements(Object inputElement) {
        if(inputElement instanceof ChooserNode[]) {
            return (ChooserNode[])inputElement;
        }
        else {
            ChooserNode node = (ChooserNode) inputElement;
            return node.getChildren();
        }
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
}
