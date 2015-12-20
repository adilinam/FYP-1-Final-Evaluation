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

import org.eclipse.emf.ecore.EPackage;


public class MetamodelEPackageNode extends EPackageNode {

    public MetamodelEPackageNode(EPackage pack, ChooserNode parent) {
        super(pack, parent);
        // TODO Auto-generated constructor stub
    }

    @Override
	public boolean hasChildren() {
        return false;
    }
    
    @Override
	protected ChooserNode[] getChildNodes() {
        return null;
    }
    
}
