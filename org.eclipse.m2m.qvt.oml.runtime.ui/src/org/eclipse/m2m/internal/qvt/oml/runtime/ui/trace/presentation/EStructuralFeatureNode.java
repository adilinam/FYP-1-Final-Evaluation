/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author Aleksandr Igdalov
 */
public class EStructuralFeatureNode extends Node {
    private final EObject myEObject;

    public EStructuralFeatureNode(Object parent, EStructuralFeature object, EObject eObject) {
        super(parent, object);
        myEObject = eObject;
    }
    
    @Override
	public EStructuralFeature getObject() {
        return (EStructuralFeature) super.getObject();
    }

    public EObject getEObject() {
        return myEObject;
    }
}