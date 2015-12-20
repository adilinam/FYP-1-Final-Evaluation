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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor;


/**
 * @author vrepeshko
 */
public class ExtendedEMFUtil {
	
	public static Collection<AdapterFactory> getAdapterFactories(EPackage ePackage, Class<?>[] requiredClasses) {
		Set<AdapterFactory> adapterFactories = new LinkedHashSet<AdapterFactory>();
		for (int i = 0; i < requiredClasses.length; i++) {
			List<Object> types = new ArrayList<Object>();
			types.add(ePackage);
		    types.add(requiredClasses[i]);
			Descriptor descriptor = ComposedAdapterFactory.Descriptor.Registry.INSTANCE.getDescriptor(types);
			if (descriptor == null) {
				continue;
			}
			AdapterFactory adapterFactory = descriptor.createAdapterFactory();
			if (adapterFactory == null) {
				continue;
			}
			adapterFactories.add(adapterFactory);
		}
		return Collections.unmodifiableSet(adapterFactories);
	}
	
    /**
     * Returns the {@link ComposedAdapterFactory composed adapter factory} built using specified adapter factories 
     * and {@link ReflectiveItemProviderAdapterFactory reflective adapter factory}.
     * 
     * @param adapterFactories the list of adapter factories
     * @return the {@link ComposedAdapterFactory composed adapter factory} built using specified adapter factories 
     * and {@link ReflectiveItemProviderAdapterFactory reflective adapter factory}
     */
    public static ComposedAdapterFactory createComposedAdapterFactory(Collection<AdapterFactory> adapterFactories) {
    	List<AdapterFactory> factories = new ArrayList<AdapterFactory>(adapterFactories);
    	factories.add(new ReflectiveItemProviderAdapterFactory());
    	return new ComposedAdapterFactory(factories);
    }
    
}
