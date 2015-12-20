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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.ui.PlatformUI;

public abstract class ViewRepresentationCheckboxAction extends Action {
    private final IDialogSettings myDialogSettings;
    private final String myStorageKey;
    private final TreeViewer myViewer;

    public ViewRepresentationCheckboxAction(TreeViewer outlineViewer, 
            IDialogSettings dialogSettings, String storageKey,
            String text, String toolTipText, String description,
            String icon, String helpContextId) {
        super(text, IAction.AS_CHECK_BOX);
        myDialogSettings = dialogSettings;
        myStorageKey = storageKey;
        setToolTipText(toolTipText);
        setDescription(description);

        setImageDescriptors(icon);

        myViewer = outlineViewer;

        boolean checked = dialogSettings.getBoolean(storageKey);
        setChecked(checked);
        if (helpContextId != null) {
            PlatformUI.getWorkbench().getHelpSystem().setHelp(this, helpContextId);
        }
    }

    @Override
	public void run() {
        valueChanged(isChecked(), true);
    }

    private void valueChanged(final boolean on, boolean store) {
        setChecked(on);
        BusyIndicator.showWhile(myViewer.getControl().getDisplay(), new Runnable() {
            public void run() {
                myViewer.refresh(true);
            }
        });

        if (store) {
            myDialogSettings.put(myStorageKey, on);
        }
    }

    private void setImageDescriptors(String descriptorKey) {
        ImageDescriptor descriptor = CompletionProposalUtil.getImageDescriptor(descriptorKey);
        if (descriptor != null) {
            setDisabledImageDescriptor(descriptor);
            setHoverImageDescriptor(descriptor);
            setImageDescriptor(descriptor); 
        }
    }
}