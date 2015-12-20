/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author sboyko
 *
 */
public abstract class BaseUriGroup extends Composite implements IUriGroup {

    public BaseUriGroup(Composite parent, int style) {
    	super(parent, style);
		myListeners = new ArrayList<IModifyListener>();
    }
	
	public void addModifyListener(IModifyListener listener) {
		myListeners.add(listener);
	}

	public void removeModifyListener(IModifyListener listener) {
		myListeners.remove(listener);
	}

    void fireModified() {
        for (IModifyListener listener : myListeners) {
            try {
                listener.modified();
            }
            catch(Exception e) {
            }
        }
    }

    Label createLabel(String text, int span){
        Label label = new Label(this, SWT.NONE);
        label.setText(text);
        GridData data = new GridData();
        data.horizontalSpan = span;
        label.setLayoutData(data);
        return label;
    }
    
	private final List<IModifyListener> myListeners;
}
