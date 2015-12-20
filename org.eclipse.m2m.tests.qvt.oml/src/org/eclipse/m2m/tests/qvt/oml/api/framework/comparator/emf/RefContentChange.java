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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ContentChange;


/**
 * @author pkobiakov
 */
public class RefContentChange extends ContentChange.Adapter {
	public RefContentChange(EObject obj, EReference ref, Object left, Object right, final int cmp) {
		this(obj, ref, left, right, new ContentChange.Adapter () {
			public int getCmp() { return cmp;}
			@Override
			public String toString() { return "FixedCostChange:" + cmp; } //$NON-NLS-1$
		});
	}
	
	public RefContentChange(EObject obj, EReference ref, Object left, Object right, ContentChange change) {
		myObj = obj;
		myRef = ref;
		myLeft = left;
		myRight = right;
		myChange = change;
	}
	
	public int getCmp() {
		return myChange.getCmp();
	}
	
	@Override
	public String toString() {
		return "RefContentChange:obj=" + myObj.eClass().getName() + ",ref=" + myRef.getName() + ",change=" + myChange + " (" + myLeft + "->" + myRight + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
	}
	
	private final EObject      myObj;
	private final EReference   myRef;
	private final Object       myLeft;
	private final Object       myRight;
	private final ContentChange  myChange;
}
