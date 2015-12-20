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
package org.eclipse.m2m.tests.qvt.oml.api.framework.comparator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.ChangeNodeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.CompositeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.ContentChangeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.RefChangeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.TreeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ComparatorTreeNode;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.RefSizeContentChange;


/**
 * @author pkobiakov
 * uses Selkow's algorithm
 */
public class TreeComparator {
	public TreeComparator() {
		myCmp = new HashMap<ObjectPair, TreeEdit>();
	}
	
	public TreeEdit compare(ComparatorTreeNode left, ComparatorTreeNode right) {
		TreeEdit edit = compareStructure(left, right);
		if(edit.getCost() != 0) {
			return edit;
		}
		
		edit = compareReferences(left, right);
		if(edit.getCost() != 0) {
			return edit;
		}
		
		return TreeEdit.NULL_EDIT;
	}
	
	private TreeEdit compareStructure(ComparatorTreeNode left, ComparatorTreeNode right) {
		int numLeftChildren = left.getChildren().size();
		int numRightChildren = right.getChildren().size();
		
		TreeEdit[][] edits = new TreeEdit[numLeftChildren+1][numRightChildren+1];
		edits[0][0] = new ChangeNodeEdit(left, right);
		registerEdit(left, right, edits[0][0]);
		
		for(int i = 1; i <= numLeftChildren; i++) {
			ComparatorTreeNode leftChild = (ComparatorTreeNode)left.getChildren().get(i-1);
			edits[i][0] = new CompositeEdit(new TreeEdit[] {edits[i-1][0], leftChild.getCumulativeDeleteEdit()});
		}
		
		for(int j = 1; j <= numRightChildren; j++) {
			ComparatorTreeNode rightChild = (ComparatorTreeNode)right.getChildren().get(j-1);
			edits[0][j] = new CompositeEdit(new TreeEdit[] {edits[0][j-1], rightChild.getCumulativeInsertEdit()});
		}
		
		for(int i = 1; i <= numLeftChildren; i++) {
			ComparatorTreeNode leftChild = (ComparatorTreeNode)left.getChildren().get(i-1);
			for(int j = 1; j <= numRightChildren; j++) {
				ComparatorTreeNode rightChild = (ComparatorTreeNode)right.getChildren().get(j-1);
				
				TreeEdit change = new CompositeEdit(new TreeEdit[] {edits[i-1][j-1], compareStructure(leftChild, rightChild)});
				TreeEdit delete = new CompositeEdit(new TreeEdit[] {edits[i-1][j], leftChild.getCumulativeDeleteEdit()});
				TreeEdit insert = new CompositeEdit(new TreeEdit[] {edits[i][j-1], rightChild.getCumulativeInsertEdit()});
				
				if(change.getCost() <= delete.getCost() && change.getCost() <= insert.getCost()) {
					edits[i][j] = change;
				}
				else if(delete.getCost() <= insert.getCost()) {
					edits[i][j] = delete;
				}
				else {
					edits[i][j] = insert;
				}
			}
		}
		
		//System.err.println("*** compare " + left + "<->" + right + "=" + edits[numLeftChildren][numRightChildren].getCost());
		return edits[numLeftChildren][numRightChildren];
	}
	
	private TreeEdit compareReferences(ComparatorTreeNode left, ComparatorTreeNode right) {
		class RefTraverser {
			TreeEdit compareReferences(ComparatorTreeNode left, ComparatorTreeNode right) {
				List<?> leftRefs = left.getNoncontainmentReferences();
				List<?> rightRefs = right.getNoncontainmentReferences();
				if(leftRefs.size() != rightRefs.size()) {
					ContentChangeEdit edit = new ContentChangeEdit(left, right, new RefSizeContentChange(left, leftRefs, rightRefs, leftRefs.size() - rightRefs.size()));
					return edit;
				}
				
				for(int i = 0; i < leftRefs.size(); i++) {
					ComparatorTreeNode leftRef = (ComparatorTreeNode)leftRefs.get(i);
					ComparatorTreeNode rightRef = (ComparatorTreeNode)rightRefs.get(i);
					
					TreeEdit edit = getEdit(leftRef, rightRef);
					if(edit.getCost() != 0) {
						return new RefChangeEdit(left, right, edit);
					}
				}
				
				for(int i = 0; i < left.getChildren().size(); i++) {
					ComparatorTreeNode leftChild = (ComparatorTreeNode)left.getChildren().get(i);
					ComparatorTreeNode rightChild = (ComparatorTreeNode)right.getChildren().get(i);
					
					TreeEdit edit = compareReferences(leftChild, rightChild);
					if(edit.getCost() != 0) {
						return edit;
					}
				}
				
				return TreeEdit.NULL_EDIT;
			}
		}
		
		return new RefTraverser().compareReferences(left, right);
	}
	
	private void registerEdit(ComparatorTreeNode left, ComparatorTreeNode right, TreeEdit edit) {
		myCmp.put(new ObjectPair(left, right), edit);
	}
	
	private TreeEdit getEdit(ComparatorTreeNode left, ComparatorTreeNode right) {
		TreeEdit edit = (TreeEdit)myCmp.get(new ObjectPair(left, right));
		if(edit == null) {
			// must be something outside our tree, like PrimitiveType
			edit = left.equals(right) ? TreeEdit.NULL_EDIT : new ChangeNodeEdit(left, right);
			registerEdit(left, right, edit);
		}
		
		return edit;
	}
	
	private final Map<ObjectPair, TreeEdit>  myCmp;
}

class ObjectPair {
	public ObjectPair(Object first, Object second) {
		myFirst = first;
		mySecond = second;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ObjectPair == false) {
			return false;
		}
		
		ObjectPair pair = (ObjectPair)o;
		return myFirst.equals(pair.myFirst) && mySecond.equals(pair.mySecond); 
	}
	
	@Override
	public int hashCode() {
		return 17 + myFirst.hashCode()*37 + mySecond.hashCode(); 
	}
	
	private final Object myFirst;
	private final Object mySecond;
}
