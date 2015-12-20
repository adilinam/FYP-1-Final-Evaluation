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
package org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class DependencyHelper {
    private DependencyHelper(EPackage pack) {
        myPackage = pack;
        myReferencedPackages = new LinkedHashSet<EPackage>();
        myResourceSet = new ResourceSetImpl();
    }
    
    public static EPackage[] getReferencedPackages(EPackage pack) {
        DependencyHelper helper = new DependencyHelper(pack);
        helper.findReferencedPackages(pack);
        return (EPackage[])helper.myReferencedPackages.toArray(new EPackage[helper.myReferencedPackages.size()]);
    }
    
    private void findReferencedPackages(EPackage pack) {
        for(EClassifier classifier : pack.getEClassifiers()) {
            findReferencedPackages(classifier);
        }

        for(EPackage childPack : pack.getESubpackages()) {
            findReferencedPackages(childPack);
        }
    }

    private void findReferencedPackages(EClassifier classifier) {
        if (classifier instanceof EClass == false) {
            return;
        }
        
        EClass cls = (EClass)classifier;
        
        for(EClass superClass : cls.getEAllSuperTypes()) {
            referenced(superClass);
        }
        
        for(EReference ref : cls.getEAllReferences()) {
            EClassifier type = ref.getEType();
            if(type != null) {
            	referenced(type);
            }
        }
    }

    private void referenced(EClassifier classifier) {
        classifier = (EClassifier)resolveProxy(classifier);
        EObject rootContainer = EcoreUtil.getRootContainer(classifier);
        if(rootContainer instanceof EPackage && 
                rootContainer != myPackage &&
                rootContainer != EcorePackage.eINSTANCE) {
            myReferencedPackages.add((EPackage)rootContainer);
        }
    }
    
    public EObject resolveProxy(EObject obj) {
        if (!obj.eIsProxy()) {
            return obj;
        }
        else {
            return EcoreUtil.resolve(obj, myResourceSet);
        }
    }
    
    private final EPackage myPackage;
    private final Set<EPackage> myReferencedPackages;
    private final ResourceSet myResourceSet;
}
