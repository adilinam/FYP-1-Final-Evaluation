/*******************************************************************************
 * Copyright (c) 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.ui.launch;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


public class TraceFileControl extends OptionalFileGroup {

	public TraceFileControl(final Composite parent, String name) {
		this(parent, name, TransformationControls.createCheckBox(parent, Messages.TraceFileControl_inrementalUpdate));
    }

	private TraceFileControl(final Composite parent, String name, Button checkBox) {
		super(parent, name);
		
		myIncrementalUpdateCB = checkBox;
		myIncrementalUpdateCB.addSelectionListener(new SelectionAdapter() {
            @Override
			public void widgetSelected(SelectionEvent e) {
            	setIncrementalUpdate(isIncrementalUpdate());
                //fireModifiedEvent();
            }
        });
		setIncrementalUpdate(false);
    }
	
	public boolean isIncrementalUpdate() {
		return myIncrementalUpdateCB != null && myIncrementalUpdateCB.getSelection();
	}

    public void setUseFileFlag(boolean flag) {
        myCheckBox.setSelection(flag);
        myBrowse.setEnabled(getUseFileFlag() || isIncrementalUpdate());
        myTextControl.setEnabled(getUseFileFlag() || isIncrementalUpdate());
        myTextControl.setText(myText);
    }

    public void setIncrementalUpdate(boolean flag) {
    	myIncrementalUpdateCB.setSelection(flag);
    	setUseFileFlag(getUseFileFlag());
    }
    
    private final Button myIncrementalUpdateCB;
}
