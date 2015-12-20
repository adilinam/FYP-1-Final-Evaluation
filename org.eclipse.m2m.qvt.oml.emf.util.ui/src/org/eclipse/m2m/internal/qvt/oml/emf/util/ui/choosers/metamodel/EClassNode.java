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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.metamodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;

public class EClassNode extends EObjectNode implements IModelElement {
    public EClassNode(EClass cls, ChooserNode parent) {
        super(cls, parent);
    }
    
    public EClass getEClass() {
        return (EClass)getObj();
    }
    
    @Override
	public boolean hasChildren() {
        return false;
    }

    @Override
	public ChooserNode[] getChildren() {
        return new ChooserNode[0];
    }

    public EPackage[] getRefs() {
        return new EPackage[] {EmfUtil.getRootPackage(getEClass().getEPackage())};
    }
}
