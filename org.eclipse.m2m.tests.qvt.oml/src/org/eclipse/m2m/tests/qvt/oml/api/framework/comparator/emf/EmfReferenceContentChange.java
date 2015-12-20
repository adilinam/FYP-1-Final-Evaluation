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

import org.eclipse.emf.ecore.EReference;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.TreeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ContentChange;


/**
 * @author pkobiakov
 */
public class EmfReferenceContentChange extends ContentChange.Adapter {
	public EmfReferenceContentChange(EReference left, EReference right) {
		myLeft = left;
		myRight = right;
	}
	
	public int getCmp() {
		int cmp = myLeft.getName().compareTo(myRight.getName());
		return cmp*TreeEdit.UNWANTED_CHANGE_COST;
	}
	
	@Override
	public String toString() {
		return "EmfReferenceContentChange:" + myLeft + "->" + myRight; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	private final EReference myLeft;
	private final EReference myRight;
}
