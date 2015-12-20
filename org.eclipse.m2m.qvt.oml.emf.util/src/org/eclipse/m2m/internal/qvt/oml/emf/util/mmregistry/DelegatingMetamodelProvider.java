/*******************************************************************************
 * Copyright (c) 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Christopher Gerking - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtilPlugin;

public abstract class DelegatingMetamodelProvider implements IMetamodelProvider {
	
	private IMetamodelProvider delegate;
	
	DelegatingMetamodelProvider(IMetamodelProvider delegate) {
		if(delegate == null) {
    		throw new IllegalArgumentException();
    	}
		
		this.delegate = delegate;
	}
	
	public final IMetamodelDesc[] getMetamodels() {
		List<IMetamodelDesc> metamodels = new ArrayList<IMetamodelDesc>();
		metamodels.addAll(Arrays.asList(getLocalMetamodels()));
		metamodels.addAll(Arrays.asList(delegate.getMetamodels()));
		
		return metamodels.toArray(new IMetamodelDesc[metamodels.size()]);
		
	};
	
	public final IMetamodelDesc getMetamodel(String id) {
		IMetamodelDesc desc = getLocalMetamodel(id);
		
		if (desc == null || !EmfUtilPlugin.isSuccess(desc.getLoadStatus())) {
			IMetamodelDesc delegateDesc = delegate.getMetamodel(id);
		
			if (desc == null || (delegateDesc != null && EmfUtilPlugin.isSuccess(delegateDesc.getLoadStatus()))) {
				desc = delegateDesc;
			}
		}
		
		return desc;
	}
	
	protected abstract IMetamodelDesc[] getLocalMetamodels();
	
	protected IMetamodelDesc getLocalMetamodel(String id) {
		IMetamodelDesc desc = null;
		
		for(IMetamodelDesc d : getLocalMetamodels()) {
			if(d.getId().equals(id)) {
				desc = d;
				break;
			}
		}
		
		return desc;
		
	}
	
	public final EPackage.Registry getPackageRegistry() {
		EPackage.Registry registry = new EPackageRegistryImpl(delegate.getPackageRegistry());
		
		for(IMetamodelDesc desc : getLocalMetamodels()) {
			if (EmfUtilPlugin.isSuccess(desc.getLoadStatus())) {
				registry.put(desc.getId(), desc.getModel());
			}
		}
		
		return registry;
	}
	
}
