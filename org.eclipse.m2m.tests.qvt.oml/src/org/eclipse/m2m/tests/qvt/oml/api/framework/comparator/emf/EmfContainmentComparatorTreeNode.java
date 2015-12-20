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
package org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.emf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ComparatorTreeNode;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ContentChange;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.NodeClassContentChange;


/** @author pkobiakov */
public class EmfContainmentComparatorTreeNode extends ComparatorTreeNode {
	public EmfContainmentComparatorTreeNode(ComparatorTreeNode parent, EReference ref) {
		super(parent);
		myRef = ref;
	}

	@Override
	public List<ComparatorTreeNode> getChildrenImpl() {
		return myRef.isContainment() ? getValues() : Collections.<ComparatorTreeNode>emptyList();
	}
	
	@Override
	public List<ComparatorTreeNode> getNoncontainmentRefsImpl() {
		return !myRef.isContainment() ? getValues() : Collections.<ComparatorTreeNode>emptyList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ComparatorTreeNode> getValues() {
		List<EObject> emfChildren = new ArrayList<EObject>();
		
		EObject node = ((EmfObjectComparatorTreeNode)getParent()).getNode();
		Object value = node.eGet(myRef);
		if(myRef.isMany()) {
			if (value instanceof List<?>) {
				for (Object o : (List<Object>) value) {
					if (o instanceof EObject) {
						emfChildren.add((EObject) o);
					}
				}
			}
		}
		else {
			if (value instanceof EObject) {
				emfChildren.add((EObject) value);
			}
		}
		
		List<ComparatorTreeNode> children = new ArrayList<ComparatorTreeNode>();
		for(EObject child : emfChildren) {
			children.add(new EmfObjectComparatorTreeNode(this, child));
		}
		
		return children;
	}
	
	@Override
	public ContentChange compareClassesImpl(ComparatorTreeNode to) {
		if(to instanceof EmfContainmentComparatorTreeNode == false) {
			return new NodeClassContentChange(this, to);
		}
		
		EmfContainmentComparatorTreeNode emfTo = (EmfContainmentComparatorTreeNode)to;

		if(!myRef.equals(emfTo.myRef)) {
			return new EmfReferenceContentChange(myRef, emfTo.myRef); 
		}
		
		return ContentChange.NULL_CHANGE;
	}

	@Override
	public ContentChange compareAttributesImpl(ComparatorTreeNode to) {
		return ContentChange.NULL_CHANGE;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof EmfContainmentComparatorTreeNode == false) {
			return false;
		}
		
		EmfContainmentComparatorTreeNode node = (EmfContainmentComparatorTreeNode)o;
		boolean eq = myRef.equals(node.myRef);
		return eq;
		
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "ref:" + myRef.getName(); //$NON-NLS-1$
	}
	
	private final EReference  myRef;
}
