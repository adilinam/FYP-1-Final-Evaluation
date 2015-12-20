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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ContentChange;


/**
 * @author pkobiakov
 */
public class AttrContentChange extends ContentChange.Adapter {
	public AttrContentChange(EObject obj, EAttribute attr, Object left, Object right, int cmp) {
		myObj = obj;
		myAttr = attr;
		myLeft = left;
		myRight = right;
		myCmp = cmp;
	}
	
	public int getCmp() {
		return myCmp;
	}
	
	@Override
	public String toString() {
		return "AttrContentChange:obj=" + myObj.eClass().getName() + ",attr=" + myAttr.getName() + ":" + myLeft + "->" + myRight; // ",cont=" + myObj.eContainer().eClass().getName() +  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}
	
	private final EObject      myObj;
	private final EAttribute   myAttr;
	private final Object       myLeft;
	private final Object       myRight;
	private final int          myCmp;
}
