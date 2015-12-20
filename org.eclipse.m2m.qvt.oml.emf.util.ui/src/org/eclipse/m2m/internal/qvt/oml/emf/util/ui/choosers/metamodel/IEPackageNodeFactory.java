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


/**
 * Used as an abstract factory to control producing chooser node objects
 * of particular classes
 * @author abreslav
 */
public interface IEPackageNodeFactory {
    public EPackageNode createNode(EPackage pack, ChooserNode parent);
    
    IEPackageNodeFactory MM_FACTORY = new IEPackageNodeFactory() {
        public EPackageNode createNode(EPackage pack, ChooserNode parent) {
            return new MetamodelEPackageNode(pack, parent);
        }
    };
    
    IEPackageNodeFactory FACTORY = new IEPackageNodeFactory() {
        public EPackageNode createNode(EPackage pack, ChooserNode parent) {
            return new EPackageNode(pack, parent);
        }
    };
}
