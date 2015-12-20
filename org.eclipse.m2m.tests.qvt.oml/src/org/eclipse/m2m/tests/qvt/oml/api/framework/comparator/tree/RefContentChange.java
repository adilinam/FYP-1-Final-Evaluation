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
package org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree;

/**
 * @author pkobiakov
 */
public class RefContentChange extends ContentChange.Adapter {
	public RefContentChange(ComparatorTreeNode obj, ComparatorTreeNode left, ComparatorTreeNode right, ContentChange change) {
		myObj = obj;
		myLeft = left;
		myRight = right;
		myChange = change;
	}
	
	public int getCmp() {
		return myChange.getCmp()*2;
	}
	
	@Override
	public String toString() {
		return "RefContentChange:obj=" + myObj + ",change=" + myChange + ":" + myLeft + "->" + myRight; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	
	private final ComparatorTreeNode myObj;
	private final ComparatorTreeNode myLeft;
	private final ComparatorTreeNode myRight;
	private final ContentChange myChange;
}
