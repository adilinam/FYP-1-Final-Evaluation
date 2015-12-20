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
package org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.CompositeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.DeleteNodeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.InsertNodeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.TreeEdit;


/** @author pkobiakov */
public abstract class ComparatorTreeNode {
	public ComparatorTreeNode(ComparatorTreeNode parent) {
		myParent = parent;
		
		myChildren = null;
		myNoncontainmentRefs = null;
		
		myCumulativeInsertEdits = null;
		myCumulativeDeleteEdits = null;
	}
	
	public ComparatorTreeNode getParent() { return myParent; }
	
	public abstract List<ComparatorTreeNode> getChildrenImpl();
	public abstract List<ComparatorTreeNode> getNoncontainmentRefsImpl();
	
	public abstract ContentChange compareClassesImpl(ComparatorTreeNode to);
	public abstract ContentChange compareAttributesImpl(ComparatorTreeNode to);
	
	public List<ComparatorTreeNode> getChildren() {
		if(myChildren == null) {
			myChildren = makeSortedList(getChildrenImpl());
		}
		
		return myChildren;
	}
	
	public List<ComparatorTreeNode> getNoncontainmentReferences() {
		if(myNoncontainmentRefs == null) {
			myNoncontainmentRefs = makeSortedList(getNoncontainmentRefsImpl());
		}
		
		return myNoncontainmentRefs;
	}
	
	private static List<ComparatorTreeNode> makeSortedList(List<ComparatorTreeNode> refs) {
		if(refs == null) {
			return Collections.emptyList();
		}
		
		Collections.sort(refs, new ContentChangeComparator());
		return refs;
	}
	
	public ContentChange getChange(ComparatorTreeNode to) {
		if(!getClass().equals(to.getClass())) {
			return new NodeClassContentChange(this, to);
		}
		
		ContentChange change = compareClassesImpl(to);
		if(change.getCost() != 0) {
			return change;
		}
		
		change = compareAttributesImpl(to);
		if(change.getCost() != 0) {
			return change;
		}
		
		return ContentChange.NULL_CHANGE;
	}
	
	public TreeEdit getInsertEdit() {
		return new InsertNodeEdit(this, myParent); 
	}
	
	public TreeEdit getDeleteEdit() {
		return new DeleteNodeEdit(this, myParent);
	}
	
	public TreeEdit getCumulativeInsertEdit() {
		if(myCumulativeInsertEdits == null) {
			List<TreeEdit> edits = new ArrayList<TreeEdit>();
			edits.add(getInsertEdit());
			for(ComparatorTreeNode child : getChildren()) {
				edits.add(child.getCumulativeInsertEdit());
			}
			myCumulativeInsertEdits = new CompositeEdit(edits);
		}		
		return myCumulativeInsertEdits;
	}
	
	public TreeEdit getCumulativeDeleteEdit() {
		if(myCumulativeDeleteEdits == null) {
			List<TreeEdit> edits = new ArrayList<TreeEdit>();
			for(ComparatorTreeNode child : getChildren()) {
				edits.add(child.getCumulativeDeleteEdit());
			}
			edits.add(getDeleteEdit());
			myCumulativeDeleteEdits = new CompositeEdit(edits);
		}		
		return myCumulativeDeleteEdits;
	}
	
	static class ContentChangeComparator implements Comparator<ComparatorTreeNode> {
		public int compare(ComparatorTreeNode left, ComparatorTreeNode right) {
			ContentChange change = left.getChange(right);
			return change.getCmp();
		}
	}
	
	private final ComparatorTreeNode  myParent;
	private List<ComparatorTreeNode> myChildren;  
	private List<ComparatorTreeNode> myNoncontainmentRefs;
	private TreeEdit  myCumulativeInsertEdits;
	private TreeEdit  myCumulativeDeleteEdits;
}
