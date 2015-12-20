/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/** @author pkobiakov */
public class CompositeEdit implements TreeEdit {
	public CompositeEdit(TreeEdit[] edits) {
		this(new ArrayList<TreeEdit>(Arrays.asList(edits)));
	}
	
	public CompositeEdit(List<TreeEdit> edits) {
		myEdits = new ArrayList<TreeEdit>();
		
		for(TreeEdit edit : edits) {
			if(edit.getCost() > 0) {
				if(edit instanceof CompositeEdit) {
					CompositeEdit compositeEdit = (CompositeEdit)edit;
					myEdits.addAll(compositeEdit.myEdits);
				}
				else {
					myEdits.add(edit);
				}
			}
		}
		
		myCumulativeCost = -1;
	}
	
	public int getCost() {
		if(myCumulativeCost == -1) {
			myCumulativeCost = 0;
			for(Iterator<?> editIt = myEdits.iterator(); editIt.hasNext(); ) {
				TreeEdit edit = (TreeEdit)editIt.next();
				myCumulativeCost += edit.getCost();
			}
		}
		
		return myCumulativeCost;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof CompositeEdit == false) {
			return false;
		}
		
		CompositeEdit edit = (CompositeEdit)o;
		return myEdits.equals(edit.myEdits);
	}
	
	@Override
	public int hashCode() { return 0; }

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		
		for(Iterator<?> editIt = myEdits.iterator(); editIt.hasNext(); ) {
			TreeEdit edit = (TreeEdit)editIt.next();
			if(s.length() > 0) {
				s.append("\n"); //$NON-NLS-1$
			}
			s.append(edit.toString());
		}
		
		return "[" + s.toString() + "]"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	private final List<TreeEdit>  myEdits;
	private int   myCumulativeCost;
}
