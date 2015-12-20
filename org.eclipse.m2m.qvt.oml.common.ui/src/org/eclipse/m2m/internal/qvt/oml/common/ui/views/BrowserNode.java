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
package org.eclipse.m2m.internal.qvt.oml.common.ui.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;

class BrowserNode implements IAdaptable {

	private final EObject myEObject;
	private final BrowserNode myParent;
	private List<BrowserNode> myChildren;
	private List<BrowserNode> myAllChildren;
			
	public BrowserNode() {
		this(null, null);
	}
		
	public BrowserNode(final EObject eObject, final BrowserNode parent) {
		myEObject = eObject;
		myParent = parent;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object getAdapter(Class adapter) {		
		if (getEObject() != null && adapter.isAssignableFrom(getEObject().getClass())) {
			return getEObject();
		}
		return null;
	}
	
	public EObject getEObject() {
		return myEObject;
	}
	
	public BrowserNode getParent() {
		return myParent;
	}
	
	public boolean hasChildren(final boolean includeInheritedFeatures) {
		return getChildren(includeInheritedFeatures).size() > 0;
	}
	
	public List<BrowserNode> getChildren(final boolean includeInheritedFeatures) {
		if (getEObject() != null) {
			if (includeInheritedFeatures && getEObject() instanceof EClass) {
				if (myAllChildren == null) {
					List<BrowserNode> allChildren = new ArrayList<BrowserNode>();
					EClass eClass = (EClass) getEObject();
					for (EObject feature : eClass.getEAllStructuralFeatures()) {
						allChildren.add(new BrowserNode(feature, this));
					}
					for (EObject operation : eClass.getEAllOperations()) {
						allChildren.add(new BrowserNode(operation, this));
					}
					for (EObject annotation : eClass.getEAnnotations()) {
						allChildren.add(new BrowserNode(annotation, this));
					}
					myAllChildren = allChildren;
				}
				return myAllChildren;
			} 
			
			if (myChildren == null) {
				List<BrowserNode> children = new ArrayList<BrowserNode>();
				for (EObject child : getEObject().eContents()) {
					children.add(new BrowserNode(child, this));
				}
				myChildren = children;
			}
			return myChildren;
		}
		
		return myChildren != null ? myChildren : Collections.<BrowserNode>emptyList();
	}
	
	public void addChild(BrowserNode child) {
		if(myChildren == null) {
			myChildren = new ArrayList<BrowserNode>();
		}
		myChildren.add(child);
	}
	
	public void removeChild(BrowserNode child) {
		if(myChildren != null) {
			myChildren.remove(child);
		}
	}
	

	public Image getImage() {
		return null;
	}
	
	public String getText() {
		return null;
	}		
	
	public static BrowserNode findNodeForInstance(final BrowserNode node, final EObject ownedEObject) {
		if (node.getEObject() == ownedEObject) {
			return node;
		}
				
		List<BrowserNode> children = node.getChildren(false);
		BrowserNode foundNode = null;
		
		for (int i = 0; i < children.size(); i++) {
			foundNode = findNodeForInstance(children.get(i), ownedEObject);
			if(foundNode != null) break;
		}
		return foundNode;
	}		
}