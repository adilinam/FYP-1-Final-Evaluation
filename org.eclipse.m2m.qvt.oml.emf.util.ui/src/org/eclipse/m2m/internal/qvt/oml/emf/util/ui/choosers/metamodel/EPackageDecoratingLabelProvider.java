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

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.EmfUtilUiImages;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.provider.EMFProviderUtil;
import org.eclipse.swt.graphics.Image;


public class EPackageDecoratingLabelProvider implements ILabelProvider {
    public EPackageDecoratingLabelProvider() {
        myLabelProvider = EMFProviderUtil.createLabelProvider();
    }

    public String getText(Object element) {
        String text;
        
        if(element instanceof MetamodelsNode) {
            text = Messages.metamodels;
        }
        else if(element instanceof EPackageNode) {
            EPackageNode node = (EPackageNode)element;
            text = myLabelProvider.getText(node.getEPackage());
            if(node.getEPackage().getESuperPackage() == null) {
                text += " (" + node.getEPackage().getNsURI() + ")";  //$NON-NLS-1$//$NON-NLS-2$
            }
        }
        else if(element instanceof EClassNode) {
            EClassNode node = (EClassNode)element;
            text = myLabelProvider.getText(node.getEClass());
        }
        else {
            text = myLabelProvider.getText(element);
        }
        
        return text;
    }
    
    public Image getImage(Object element) {
        Image image;
        
        if(element instanceof MetamodelsNode) {
        	image = EmfUtilUiImages.getImage(EmfUtilUiImages.METAMODELS);
        }
        else if(element instanceof EPackageNode) {
            EPackageNode node = (EPackageNode)element;
            image = myLabelProvider.getImage(node.getEPackage());
        }
        else if(element instanceof EClassNode) {
            EClassNode node = (EClassNode)element;
            image = myLabelProvider.getImage(node.getEClass());
        }
        else {
            image = myLabelProvider.getImage(element);
        }

        return image;
    }

    public void addListener(ILabelProviderListener listener) {
        myLabelProvider.addListener(listener);        
    }

    public void dispose() {
        myLabelProvider.dispose();
    }

    public boolean isLabelProperty(Object element, String property) {
        return myLabelProvider.isLabelProperty(element, property);
    }

    public void removeListener(ILabelProviderListener listener) {
        myLabelProvider.removeListener(listener);
    }

    private final ILabelProvider myLabelProvider;
}
