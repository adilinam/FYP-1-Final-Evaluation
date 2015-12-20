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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class EmfModelContentProvider implements ITreeContentProvider {
	public EmfModelContentProvider() {
		
	}
	
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof Node) {
			return ((Node)parentElement).getChildren();
		}
		
		return new Object[0];
	}

	public Object getParent(Object element) {
		if(element instanceof Node) {
			return ((Node)element).getParent();
		}
		
		return null;
	}

	public boolean hasChildren(Object element) {
		if(element instanceof Node) {
			return ((Node)element).hasChildren();
		}
		
		return true;
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
	
	public static interface IUriNode {
		URI getUri();
	}
	
	public static abstract class Node {
		public Node(Object parent) {
			myParent = parent;
		}
		
		public Object getParent() {
			return myParent;
		}
		
		public boolean hasChildren() {
			return getChildren().length > 0;
		}

		public abstract Object getData();
		public abstract Object[] getChildren();
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Node == false) {
				return false;
			}
			
			Node node = (Node)obj;
			boolean eq = getData() == null ? 
					node.getData() == null : 
					getData().equals(node.getData());
			return eq;
		}
		
		@Override
		public int hashCode() {
			return getData() == null ? 0 : getData().hashCode();
		}
		
		private final Object myParent;
	}
	
	public static class EReferenceNode extends Node {
		public EReferenceNode(EReference ref, EObjectNode parent) {
			super(parent);
			myRef = ref;
		}

		@Override
		public Object getData() {
			return myRef;
		}

		@Override
		public Object[] getChildren() {
			EObjectNode parent = (EObjectNode)getParent();
			EObject obj = parent.getObject();
			
			Object value = obj.eGet(myRef);

			List<Object> children = new ArrayList<Object>();
			if(value instanceof List<?>) {
				for(Iterator<?> it = ((List<?>) value).iterator(); it.hasNext(); ) {
					EObject child = (EObject)it.next();
					children.add(new EObjectNode(child, this));
				}
			}
			else if(value instanceof EObject) {
				children.add(new EObjectNode((EObject)value, this));
			}
				
			return children.toArray();
		}
		
		private final EReference myRef;
	}
	
	public static class EObjectNode extends Node implements IUriNode {
		public EObjectNode(EObject obj, Object parent) {
			super(parent);
			myObj = obj;
		}
		
		public URI getUri() {
			return EcoreUtil.getURI(myObj);
		}
		
		@Override
		public Object getData() {
			return getObject();
		}
		
		public EObject getObject() {
			return myObj;
		}
		
		@Override
		public Object[] getChildren() {
			List<Object> children = new ArrayList<Object>();
			for(EReference ref : myObj.eClass().getEAllContainments()) {
				if(ref.isDerived()) {
					continue;
				}
				
				EReferenceNode node = new EReferenceNode(ref, this);
				if(!node.hasChildren()) {
					continue;
				}
				
				children.add(node);
			}
			
			return children.toArray();
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof EObjectNode == false) {
				return false;
			}
			
			EObjectNode node = (EObjectNode) obj;
			return getUri() == null ? node.getUri() == null : getUri().equals(node.getUri()); 
		}
		
		@Override
		public int hashCode() {
			return getUri() == null ? 0 : getUri().hashCode();
		}
		
		public final EObject myObj;
	}
	
	public static class ResourceNode extends Node implements IUriNode {
		public ResourceNode(Resource resource) {
			super(null);
			myResource = resource;
		}
		
		public URI getUri() {
			return myResource.getURI();
		}

		@Override
		public Object getData() {
			return getResource();
		}
		
		public Resource getResource() {
			return myResource;
		}

		@Override
		public Object[] getChildren() {
			List<Object> children = new ArrayList<Object>();
			for(EObject child : myResource.getContents()) {
				children.add(new EObjectNode(child, this));
			}
			
			return children.toArray();
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof ResourceNode == false) {
				return false;
			}
			
			ResourceNode other = (ResourceNode)obj;
			boolean eq = myResource.getURI() == null ? 
					other.myResource.getURI() == null :
					myResource.getURI().equals(other.myResource.getURI());
			return eq;
		}
		
		@Override
		public int hashCode() {
			return myResource == null ? 0 : myResource.hashCode();
		}
		
		private final Resource myResource;
	}

	public static EObjectNode makeEObjectNode(EObject obj, Object root) {
		EObject container = obj.eContainer();
		
		if(container == null) {
			return new EObjectNode(obj, root);
		}
		else {
			return new EObjectNode(obj, makeEReferenceNode(container, (EReference)obj.eContainingFeature(), root));
		}
	}

	public static Node makeEReferenceNode(EObject container, EReference ref, Object root) {
		return new EReferenceNode(ref, makeEObjectNode(container, root));
	}
}
