/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bug 388329 
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.ui.controls;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.common.ui.controls.UniSelectTransformationControl.ISelectionListener;
import org.eclipse.m2m.internal.qvt.oml.common.ui.dialogs.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 * @author sboyko
 */
public class BrowseInterpretedTransformationDialog extends SelectionStatusDialog {

    public BrowseInterpretedTransformationDialog(Shell shell, UniSelectTransformationControl.IResourceFilter resourceFilter,
    		TransformationRegistry registry, String selectedTransId, UniSelectTransformationControl.ISelectionListener selectionListener) {
        super(shell);

		setTitle(Messages.BrowseInterpretedTransformationDialog_Title);
		setMessage(Messages.BrowseInterpretedTransformationDialog_Description);

		setShellStyle(getShellStyle() | SWT.RESIZE);
		setStatusLineAboveButtons(true);
		
        myResourceFilter = resourceFilter;
        myRegistry = registry;
        myInitialTransId = selectedTransId;
        mySelectionListener = selectionListener;
    }
    
    public URI getSelectedUri() {
        return mySelectedUri;
    }
    
    @Override
	protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);        
		composite.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL));

		createMessageArea(composite);
        
        ISelectionListener selectionListener = new UniSelectTransformationControl.SelectionListenerAdapter(mySelectionListener) {
        	
            public IStatus selectionChanged(URI uri) {
            	IStatus status = mySelectionListener.selectionChanged(uri);
            	mySelectedUri = status.isOK() ? uri : null;
            	updateStatus(status);
            	return status;
            }
        };
        
        myControl = new UniSelectTransformationControl(parent, myResourceFilter,
        		myRegistry, TransformationRegistry.TRANSFORMATION_FILTER, selectionListener);
        myControl.selectTransformationByUri(myInitialTransId);
        
        return myControl;
    }
    
	@Override
	protected void computeResult() {
	}

    private final String myInitialTransId;
    private final TransformationRegistry myRegistry;
    private final UniSelectTransformationControl.IResourceFilter myResourceFilter;
    private final UniSelectTransformationControl.ISelectionListener mySelectionListener;
    
    private URI mySelectedUri;
    private UniSelectTransformationControl myControl;
}
