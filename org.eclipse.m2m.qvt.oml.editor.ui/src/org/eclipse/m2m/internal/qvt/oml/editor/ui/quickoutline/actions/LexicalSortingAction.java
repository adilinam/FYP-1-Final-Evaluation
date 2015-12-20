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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline.actions;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.TreeViewer;

public class LexicalSortingAction extends ViewRepresentationCheckboxAction {
    public LexicalSortingAction(TreeViewer outlineViewer, IDialogSettings dialogSettings) {
        super(outlineViewer, dialogSettings, "LexicalSortingAction.isChecked",  //$NON-NLS-1$
                Messages.LexicalSortingAction_label,
                Messages.LexicalSortingAction_tooltip, 
                Messages.LexicalSortingAction_description,
                "alphab_sort_co", null); //$NON-NLS-1$
    }
}