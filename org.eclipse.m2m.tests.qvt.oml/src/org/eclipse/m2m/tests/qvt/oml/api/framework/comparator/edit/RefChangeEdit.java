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

/**
 * @author pkobiakov
 */
public class RefChangeEdit implements TreeEdit {
	public RefChangeEdit(ComparatorTreeNode left, ComparatorTreeNode right, TreeEdit edit) {
		myLeft = left;		
		myRight = right;
		myEdit = edit;
	}
	
	public int getCost() {
		return myEdit.getCost()*2;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof RefChangeEdit == false) {
			return false;
		}
		
		RefChangeEdit edit = (RefChangeEdit)o;
		boolean eq = myLeft.equals(edit.myLeft) &&
		    myRight.equals(edit.myRight) && 
			myEdit.equals(edit.myEdit);
		return eq;
	}
	
	@Override
	public int hashCode() { return 0; }
	
	@Override
	public String toString() {
		return getCost() == 0 ? "null change" : "RefChangeEdit:" + myLeft + "->" + myRight + " edit=" + myEdit; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	private final ComparatorTreeNode  myLeft;
	private final ComparatorTreeNode  myRight;
	private final TreeEdit  myEdit;
}
