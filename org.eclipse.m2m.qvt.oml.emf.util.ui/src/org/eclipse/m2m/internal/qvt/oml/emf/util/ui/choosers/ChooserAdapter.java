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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ChooserAdapter implements IChooser {
    public void addChangeListener(IChangeListener listener) {
        myListeners.add(listener);
    }
    
    public void removeChangeListener(IChangeListener listener) {
        myListeners.remove(listener);
    }
    
    protected void fireChangedEvent(){
        for (Iterator<IChangeListener> it = new ArrayList<IChangeListener>(myListeners).iterator(); it.hasNext(); ) {
            IChangeListener listener = it.next();
            try {
                listener.changed();
            }
            catch(Exception e) {
            }                
        }
    }
    
    private final List<IChangeListener> myListeners = new ArrayList<IChangeListener>(); 
}
