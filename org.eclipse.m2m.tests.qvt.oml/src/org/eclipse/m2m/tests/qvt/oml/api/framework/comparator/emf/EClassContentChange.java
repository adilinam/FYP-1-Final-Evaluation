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
package org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.emf;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.TreeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ContentChange;


/**
 * @author pkobiakov
 */
public class EClassContentChange extends ContentChange.Adapter {
	public EClassContentChange(EClass left, EClass right) {
		myLeft = left;
		myRight = right;
	}
	
	public int getCmp() {
		int cmp = myLeft.getName().compareTo(myRight.getName());
		return cmp*TreeEdit.UNWANTED_CHANGE_COST;
	}
	
	@Override
	public String toString() {
		return "EClassContentChange:" + myLeft + "->" + myRight; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	private final EClass myLeft;
	private final EClass myRight;
}
