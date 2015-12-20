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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.presentation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author Aleksandr Igdalov
 */
public class NodeContentProvider {
    public Object getParent(Object element) {
        return ((Node) element).getParent();
    }
    
    @SuppressWarnings("unchecked")
    public Object[] getElements(Object element) {
        if (element instanceof EObjectNode) {
            EObject eObject = ((EObjectNode) element).getObject();
            EList<EStructuralFeature> allStructuralFeatures = eObject.eClass().getEAllStructuralFeatures();
            Node[] children = new Node[allStructuralFeatures.size()];
            for (int i = 0; i < children.length; i++) {
                Node child = new EStructuralFeatureNode(element, allStructuralFeatures.get(i), eObject);
                children[i] = child;
            }
            return children;
        } else if (element instanceof EStructuralFeatureNode) {
            EStructuralFeatureNode node = (EStructuralFeatureNode) element;
            EStructuralFeature feature = node.getObject();
            Object value = node.getEObject().eGet(feature);
            if (value == null) {
                return new Object[0];
            }
            if (value instanceof EList) {
                List<Node> children = new ArrayList<Node>();
                for (Object eListEntry : (EList<Object>) value) {
                    children.add(toNode(eListEntry, element));
                }
                return children.toArray();
            }
            return new Object[] {toNode(value, element)};
        } else if (element instanceof StringNode) {
            return new Object[0];
        }
        throw new RuntimeException("Unknown input: " + element.getClass()); //$NON-NLS-1$
    }
    
    private static Node toNode(Object object, Object parent) {
        return (object instanceof EObject) ? 
                new EObjectNode(parent, (EObject) object) :
                    new StringNode(parent, object.toString());
    }
}