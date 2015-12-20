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

/**
 * @author pkobiakov
 */
public class ContentChangeEdit implements TreeEdit {
	public ContentChangeEdit(ComparatorTreeNode left, ComparatorTreeNode right, ContentChange change) {
		myLeft = left;
		myRight = right;
		myChange = change;
	}
	
	public int getCost() {
		return myChange.getCost();
	}
	
	@Override
	public String toString() {
		return getCost() == 0 ? "null change" : "ContentChange:" + myChange; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ContentChangeEdit == false) {
			return false;
		}
		
		ContentChangeEdit edit = (ContentChangeEdit)o;
		return myLeft.equals(edit.myLeft) &&
			myRight.equals(edit.myRight) && 
			myChange.equals(edit.myChange);
	}
	
	@Override
	public int hashCode() { return 0; }
	

	private final ComparatorTreeNode  myLeft;
	private final ComparatorTreeNode  myRight;
	private final ContentChange  myChange;
}
