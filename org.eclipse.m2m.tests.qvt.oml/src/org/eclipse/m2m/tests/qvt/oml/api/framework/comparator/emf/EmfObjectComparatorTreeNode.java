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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.CompareUtil;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ComparatorTreeNode;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ContentChange;


/** @author pkobiakov */
public class EmfObjectComparatorTreeNode extends ComparatorTreeNode {
	
	public EmfObjectComparatorTreeNode(ComparatorTreeNode parent, EObject node) {
		super(parent);
		
		if(node == null) {
			throw new IllegalArgumentException("emf node cannot be null"); //$NON-NLS-1$
		}
		myNode = node;
	}

	public EObject getNode() { return myNode; }

	@Override
	public List<ComparatorTreeNode> getChildrenImpl() {
		List<ComparatorTreeNode> children = getRefs(true);
		children.addAll(getRefs(false));
        children.addAll(getFeatureMapRefs());
		return children;
	}
	
	@Override
	public List<ComparatorTreeNode> getNoncontainmentRefsImpl() {
		return Collections.emptyList();
	}
	
	private List<ComparatorTreeNode> getRefs(boolean containment) {
		List<ComparatorTreeNode> children = new ArrayList<ComparatorTreeNode>();
		for(Iterator<?> refIt = myNode.eClass().getEAllReferences().iterator(); refIt.hasNext(); ) {
			EReference ref = (EReference)refIt.next();
			if(ref.isDerived()) {
				continue;
			}
			
			if(containment ^ ref.isContainment()) {
				continue;
			}
			
			Object value = myNode.eGet(ref);
			if(value == null) {
				continue;
			}
			
			if(value instanceof List<?> && ((List<?>)value).isEmpty()) {
				continue;
			}
			
			children.add(new EmfContainmentComparatorTreeNode(this, ref));
		}
		return children;
	}
    
    private List<EmfFeatureMapReferenceComparatorTreeNode> getFeatureMapRefs() {
        List<EmfFeatureMapReferenceComparatorTreeNode> children = new ArrayList<EmfFeatureMapReferenceComparatorTreeNode>();
        for(Iterator<?> attrIt = myNode.eClass().getEAllAttributes().iterator(); attrIt.hasNext(); ) {
            EAttribute attr = (EAttribute)attrIt.next();
            if(attr.isDerived()) {
                continue;
            }
            
            Object value = myNode.eGet(attr);
            if(value instanceof FeatureMap) {
                FeatureMap map = (FeatureMap)value;
                children.add(new EmfFeatureMapReferenceComparatorTreeNode(this, attr, map));
            }
        }
        
        return children;
    }

	@Override
	public ContentChange compareClassesImpl(ComparatorTreeNode to) {
		EmfObjectComparatorTreeNode emfTo = (EmfObjectComparatorTreeNode)to;
		if(!myNode.eClass().getName().equals(emfTo.myNode.eClass().getName())) {
			return new EClassContentChange(myNode.eClass(), emfTo.myNode.eClass());
		}
		
		return ContentChange.NULL_CHANGE;
	}

	@Override
	public ContentChange compareAttributesImpl(ComparatorTreeNode to) {
		EmfObjectComparatorTreeNode emfTo = (EmfObjectComparatorTreeNode)to;
		EClass metaclass = myNode.eClass();
		
		for(Iterator<?> attrIt = metaclass.getEAllAttributes().iterator(); attrIt.hasNext(); ) {
			EAttribute attr = (EAttribute)attrIt.next();
            Object leftValue = myNode.eGet(attr);
            Object rightValue = emfTo.myNode.eGet(attr);
            ContentChange change = compareAttributeValues(attr, leftValue, rightValue);
            if(change != ContentChange.NULL_CHANGE) {
                return change;
            }
		}
		
		return ContentChange.NULL_CHANGE;
	}
    
    @SuppressWarnings("unchecked")
	private ContentChange compareAttributeValues(EAttribute attr, Object leftValue, Object rightValue) {
        if(leftValue == null && rightValue == null) {
            return ContentChange.NULL_CHANGE;
        }
        
        int cmp = CompareUtil.compareNulls(leftValue, rightValue);
        if(cmp != 0) {
            return new AttrContentChange(myNode, attr, leftValue, rightValue, cmp);
        }

        if(!leftValue.equals(rightValue)) {
            if(leftValue instanceof Comparable) {
                cmp = ((Comparable<Object>)leftValue).compareTo(rightValue);
                if(cmp != 0) {
                    return new AttrContentChange(myNode, attr, leftValue, rightValue, cmp);
                }
            }
            
            if(rightValue instanceof Comparable) {
                cmp = ((Comparable<Object>)rightValue).compareTo(leftValue);
                if(cmp != 0) {
                    return new AttrContentChange(myNode, attr, leftValue, rightValue, cmp);
                }
            }
            
            cmp = leftValue.getClass().getName().compareTo(rightValue.getClass().getName());
            if(cmp != 0) {
                return new AttrContentChange(myNode, attr, leftValue, rightValue, cmp);
            }
            
            if(leftValue instanceof FeatureMap && rightValue instanceof FeatureMap) {
                FeatureMap leftMap = (FeatureMap)leftValue;
                FeatureMap rightMap = (FeatureMap)rightValue;
                ContentChange change = compareFeatureMaps(attr, leftMap, rightMap);
                return change;
            }
            
            if(leftValue instanceof FeatureMap.Entry && rightValue instanceof FeatureMap.Entry) {
                FeatureMap.Entry leftEntry = (Entry)leftValue;
                FeatureMap.Entry rightEntry = (Entry)rightValue;
                ContentChange change = compareFeatureMapEntries(attr, leftEntry, rightEntry);
                return change;
            }

            cmp = leftValue.toString().compareTo(rightValue.toString());
            if(cmp != 0) {
                return new AttrContentChange(myNode, attr, leftValue, rightValue, cmp);
            }
        }
        
        return ContentChange.NULL_CHANGE;
    }
    
    private ContentChange compareFeatureMaps(EAttribute attr, FeatureMap leftMap, FeatureMap rightMap) {
        if(leftMap.size() != rightMap.size()) {
            return new AttrContentChange(myNode, attr, leftMap, rightMap, leftMap.size()-rightMap.size());
        }
        
        for(Iterator<?> leftIt = leftMap.iterator(), rightIt = rightMap.iterator(); leftIt.hasNext(); ) {
            FeatureMap.Entry leftEntry = (Entry) leftIt.next();
            FeatureMap.Entry rightEntry = (Entry) rightIt.next();
            
            ContentChange change = compareFeatureMapEntries(attr, leftEntry, rightEntry);
            if(change != ContentChange.NULL_CHANGE) {
                return change;
            }
        }
        
        return ContentChange.NULL_CHANGE;
    }
    
    private ContentChange compareFeatureMapEntries(EAttribute attr, FeatureMap.Entry leftEntry, FeatureMap.Entry rightEntry) {
        int cmp = leftEntry.getEStructuralFeature().getClass().getName().compareTo(
                rightEntry.getEStructuralFeature().getClass().getName());
        if(cmp != 0) {
            return new AttrContentChange(myNode, attr, leftEntry.getClass(), rightEntry.getClass(), cmp);
        }
        
        if(leftEntry.getEStructuralFeature() instanceof EAttribute &&
            rightEntry.getEStructuralFeature() instanceof EAttribute) {
            EAttribute leftAttr = (EAttribute) leftEntry.getEStructuralFeature();
            EAttribute rightAttr = (EAttribute) rightEntry.getEStructuralFeature();
            if(!leftAttr.equals(rightAttr)) {
                return new AttrContentChange(myNode, attr, leftAttr, rightAttr, 1);
            }
            
            ContentChange change = compareAttributeValues(leftAttr, leftEntry.getValue(), rightEntry.getValue());
            if(change != ContentChange.NULL_CHANGE) {
                return change;
            }
        }
        // references are represented as separate tree nodes
        
        return ContentChange.NULL_CHANGE;
    }

    @Override
	public boolean equals(Object o) {
		if(o instanceof EmfObjectComparatorTreeNode == false) {
			return false;
		}
		
		EmfObjectComparatorTreeNode node = (EmfObjectComparatorTreeNode)o;
		return getChange(node).getCmp() == 0;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public String toString() {
		return Util.toString(myNode);
	}
	
	private final EObject  myNode;
}
