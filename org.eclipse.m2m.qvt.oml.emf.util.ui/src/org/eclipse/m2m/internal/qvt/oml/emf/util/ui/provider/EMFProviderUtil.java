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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;


/**
 * @author vrepeshko
 */
public class EMFProviderUtil {
    public static ILabelProvider createLabelProvider() {
        return new AdapterFactoryLabelProvider(ourAdapterFactory);
    }
    
    public static ITreeContentProvider createTreeContentProvider() {
        return new AdapterFactoryContentProvider(ourAdapterFactory);
    }
    
    public static AdapterFactoryContentProvider createAdapterFactoryContentProvider() {
        return new AdapterFactoryContentProvider(ourAdapterFactory);
    }
    
    private static AdapterFactory ourAdapterFactory; 
    	
    static {
    	List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
    	factories.add(new ResourceItemProviderAdapterFactory());
    	factories.add(new EcoreItemProviderAdapterFactory());
    	factories.add(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
    	factories.add(new ReflectiveItemProviderAdapterFactory());
    	ourAdapterFactory = new ComposedAdapterFactory(factories);
    }
}
