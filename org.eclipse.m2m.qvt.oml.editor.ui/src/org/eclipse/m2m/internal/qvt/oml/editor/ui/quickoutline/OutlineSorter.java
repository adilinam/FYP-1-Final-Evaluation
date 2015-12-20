/*******************************************************************************
 * Copyright (c) 2013 S. Boyko and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Sergey Boyko - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

import org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline.actions.LexicalSortingAction;

public class OutlineSorter extends ViewerComparator {
    private final LexicalSortingAction myLexicalSortingAction;

    public OutlineSorter(QvtOutlineInformationControl qvtOutlineInformationControl) {
        myLexicalSortingAction = qvtOutlineInformationControl.getLexicalSortingAction();
    }
    
    public boolean isSortAlphabetically() {
        return myLexicalSortingAction.isChecked();
    }

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {
        if (isSortAlphabetically()) {
            return super.compare(viewer, e1, e2);
        }
        return 0;
    }
}