/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
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

import java.util.List;


/**
 * @author pkobiakov
 */
public class RefSizeContentChange extends ContentChange.Adapter {
	public RefSizeContentChange(ComparatorTreeNode obj, List<?> left, List<?> right, int cmp) {
		myObj = obj;
		myLeft = left;
		myRight = right;
		myCmp = cmp;
	}

	public int getCmp() {
		return myCmp;
	}
	
	@Override
	public String toString() {
		return "RefSizeContentChange: myObj=" + myObj + ":" + myLeft + "->" + myRight; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
	
	private final ComparatorTreeNode  myObj;
	private final List<?>  myLeft;
	private final List<?>  myRight;
	private final int   myCmp;
}
