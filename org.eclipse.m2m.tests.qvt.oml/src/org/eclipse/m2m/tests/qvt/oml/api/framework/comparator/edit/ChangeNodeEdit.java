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
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ContentChange;

/** @author pkobiakov */
public class ChangeNodeEdit implements TreeEdit {

	public ChangeNodeEdit(ComparatorTreeNode from, ComparatorTreeNode to) {
		myFrom = from;
		myTo = to;
		
		myChange = null;
	}
	
	public int getCost() {
		if(myChange == null) {
			myChange = myFrom.getChange(myTo);
		}
		
		return myChange.getCost();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ChangeNodeEdit == false) {
			return false;
		}
		
		ChangeNodeEdit edit = (ChangeNodeEdit)o;
		return myFrom.equals(edit.myFrom) && myTo.equals(edit.myTo);
	}
	
	@Override
	public int hashCode() { return 0; }
	
	@Override
	public String toString() {
		return getCost() == 0 ? "null change" : "ChangeNodeEdit:" + myChange; // + " " + myFrom + "->" + myTo; //$NON-NLS-1$ //$NON-NLS-2$
	}

	private final ComparatorTreeNode  myFrom;
	private final ComparatorTreeNode  myTo;
	private ContentChange myChange;
}
