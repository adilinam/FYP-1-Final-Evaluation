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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.metamodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class EPackageSorter extends ViewerSorter {
    @Override
	public int compare(Viewer viewer, Object o1, Object o2) {
        if(o1 instanceof EObjectNode == false || o2 instanceof EObjectNode == false) {
            return 0;
        }
        
        EObject elem1 = ((EObjectNode)o1).getObj();
        EObject elem2 = ((EObjectNode)o2).getObj();
        int cmp = compareMetaclasses(elem1, elem2);
        if(cmp != 0) {
            return cmp;
        }
        
        cmp = compareNames(elem1, elem2);
        if(cmp != 0) {
            return cmp;
        }
        
        return 0;
    }

    private int compareMetaclasses(EObject elem1, EObject elem2) {
        int cls1 = getIndex(elem1);
        int cls2 = getIndex(elem2);
        
        if(cls1 == -1) {
            return cls2 != -1 ? 1 : 0;
        }
        
        if(cls2 == -1) {
            return -1;
        }
        
        return cls1 - cls2;
    }
    
    private int compareNames(EObject elem1, EObject elem2) {
        String name1 = getName(elem1);
        String name2 = getName(elem2);
        
        if(name1 == null) {
            return name2 != null ? -1 : 0;
        }

        if(name2 == null) {
            return 1;
        }
        
        return name1.compareToIgnoreCase(name2);
    }
    
    private String getName(EObject elem1) {
        EStructuralFeature nameFeature = elem1.eClass().getEStructuralFeature("name"); //$NON-NLS-1$
        if(nameFeature == null) {
            return null;
        }
        else {
            Object name = elem1.eGet(nameFeature);
            if(name instanceof String == false) {
                return null;
            }
            else {
                return (String)name;
            }
        }
    }

    private int getIndex(EObject elem) {
        for(int i = 0; i < METAS.length; i++) {
            Class<?> cls = METAS[i];
            if(cls.isAssignableFrom(elem.getClass())) {
                return i;
            }
        }
        
        return -1;
    }
    
    private final Class<?>[] METAS = new Class[] { EPackage.class, EClass.class };
}
