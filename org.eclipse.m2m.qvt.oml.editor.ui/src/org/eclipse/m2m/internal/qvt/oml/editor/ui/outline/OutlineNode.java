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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ocl.cst.CSTNode;


public class OutlineNode {
    public OutlineNode(final String identity, final Object parent, int type) {
        this(identity, parent, type, null);
    }
    
	public OutlineNode(final String identity, final Object parent, int type, CSTNode syntaxElement) {
		myIdentity = identity;
		myParent = parent;
		myType = type;
        mySyntaxElement = syntaxElement;
	}
	
	public void setCalculated(final boolean isCalculated) {
		myIsCalculated = isCalculated;
	}
	
    public boolean isCalculated() {
		return myIsCalculated;
	}
	
	public void setSyntaxElement(final CSTNode e) {
		mySyntaxElement = e;
	}
	
	public CSTNode getSyntaxElement() {
		return mySyntaxElement;
	}
	
	public void setIdentity(final String identity) {
		myIdentity = identity;
	}
	
	public Object getParent() {
		return myParent;
	}
	
	public List<OutlineNode> getChildren() {
		return myChildren;
	}
	
	public String getIdentity() {
		return myIdentity;
	}
	
	@Override
	public String toString() {
		return getIdentity();
	}
	
	public int getType() {
		return myType;
	}

    @Override
	public boolean equals(Object o) {
        if(o instanceof OutlineNode == false) {
            return false;
        }
        
        OutlineNode other = (OutlineNode) o;
        return getIdentity().equals(other.getIdentity()) &&
            getType() == other.getType();
    }
    
    @Override
	public int hashCode() {
        return getType();
    }

	private final Object myParent;
	private final List<OutlineNode> myChildren = new ArrayList<OutlineNode>();
	private String myIdentity;
	private CSTNode mySyntaxElement;
	private int myType;
	
	private boolean myIsCalculated;
}
