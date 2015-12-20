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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public interface IChooser {
    String getUriString();
    
    Control createControl(Composite parent);
    void setInitialSelection(String uri);
    String getTitle();
    
    interface IChangeListener {
        void changed();
    }
    
    void addChangeListener(IChangeListener listener);
    void removeChangeListener(IChangeListener listener);
}
