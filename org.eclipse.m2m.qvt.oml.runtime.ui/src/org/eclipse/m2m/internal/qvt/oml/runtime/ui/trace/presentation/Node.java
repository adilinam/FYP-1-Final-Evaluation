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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.presentation;

/**
 * @author Aleksandr Igdalov
 */
public abstract class Node {
    private Object myParent;
    private Object myObject;
    
    public Node(Object parent, Object object) {
        myParent = parent;
        myObject = object;
    }

    public Object getParent() {
        return myParent;
    }

    public Object getObject() {
        return myObject;
    }

	@Override
	public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node candidate = (Node) obj;
            if (!getObject().equals(candidate.getObject())) {
                return false;
            }
            return getParent().equals(candidate.getParent());
        }
		return false;
	}

	@Override
	public int hashCode() {
		return getObject().hashCode();
	}
}