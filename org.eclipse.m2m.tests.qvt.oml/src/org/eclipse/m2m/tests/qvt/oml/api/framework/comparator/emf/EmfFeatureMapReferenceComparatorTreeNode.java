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
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ComparatorTreeNode;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ContentChange;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.NodeClassContentChange;


/** @author pkobiakov */
public class EmfFeatureMapReferenceComparatorTreeNode extends ComparatorTreeNode {
	public EmfFeatureMapReferenceComparatorTreeNode(ComparatorTreeNode parent, EAttribute attr, FeatureMap map) {
		super(parent);
        myAttr = attr;
        myMap = map;
	}

    @Override
	public List<ComparatorTreeNode> getChildrenImpl() {
        return getValues();
    }
    
    @Override
	public List<ComparatorTreeNode> getNoncontainmentRefsImpl() {
        return Collections.emptyList();
    }
	
    @SuppressWarnings("unchecked")
	public List<ComparatorTreeNode> getValues() {
		List<Object> emfChildren = new ArrayList<Object>();
		
		for(FeatureMap.Entry entry : myMap) {
            if(entry.getEStructuralFeature() instanceof EReference == false) {
                continue;
            }
            
		    Object value = entry.getValue();
            if(value instanceof Collection<?>) {
                emfChildren.addAll((Collection<Object>)value);
            }
            else {
                emfChildren.add(value);
            }
        }
		
		List<ComparatorTreeNode> children = new ArrayList<ComparatorTreeNode>();
		for(Object child : emfChildren) {
			children.add(new EmfObjectComparatorTreeNode(this, (EObject) child));
		}
		
		return children;
	}
	
	@Override
	public ContentChange compareClassesImpl(ComparatorTreeNode to) {
		if(to instanceof EmfFeatureMapReferenceComparatorTreeNode == false) {
			return new NodeClassContentChange(this, to);
		}
		
		EmfFeatureMapReferenceComparatorTreeNode emfTo = (EmfFeatureMapReferenceComparatorTreeNode)to;

		if(!myAttr.equals(emfTo.myAttr)) {
			return new AttrContentChange(myAttr.eContainer(), myAttr, this, to, 1);
		}
		
		return ContentChange.NULL_CHANGE;
	}

	@Override
	public ContentChange compareAttributesImpl(ComparatorTreeNode to) {
		return ContentChange.NULL_CHANGE;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof EmfFeatureMapReferenceComparatorTreeNode == false) {
			return false;
		}
		
		EmfFeatureMapReferenceComparatorTreeNode node = (EmfFeatureMapReferenceComparatorTreeNode)o;
		boolean eq = myAttr.equals(node.myAttr);
		return eq;
		
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "fm-ref:" + myAttr.getName(); //$NON-NLS-1$ 
	}
    
    private final EAttribute myAttr;
    private final FeatureMap myMap;
}
