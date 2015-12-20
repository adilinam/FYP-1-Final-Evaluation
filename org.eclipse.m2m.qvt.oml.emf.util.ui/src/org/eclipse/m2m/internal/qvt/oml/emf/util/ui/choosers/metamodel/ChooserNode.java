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


public abstract class ChooserNode {
    public ChooserNode(ChooserNode parent) {
        myParent = parent;
    }

    public ChooserNode getParent() {
        return myParent;
    }
    
    public abstract boolean hasChildren();    
    public abstract ChooserNode[] getChildren();
    
    private final ChooserNode myParent;    
}
