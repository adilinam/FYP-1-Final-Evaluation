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
package org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit;

import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ComparatorTreeNode;

/** @author pkobiakov */
public class InsertNodeEdit implements TreeEdit {
	public InsertNodeEdit(ComparatorTreeNode node, ComparatorTreeNode parent) {
		myNode = node;
		myParent = parent;
	}
	
	public int getCost() {
		return DELETE_INSERT_COST;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof InsertNodeEdit == false) {
			return false;
		}
		
		InsertNodeEdit edit = (InsertNodeEdit)o;
		return myParent.equals(edit.myParent) && myNode.equals(myNode);
	}
	
	@Override
	public int hashCode() { return 0; }
	
	@Override
	public String toString() {
		return "insert " + myNode + " under " + myParent; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	private final ComparatorTreeNode  myParent;
	private final ComparatorTreeNode  myNode;
}
