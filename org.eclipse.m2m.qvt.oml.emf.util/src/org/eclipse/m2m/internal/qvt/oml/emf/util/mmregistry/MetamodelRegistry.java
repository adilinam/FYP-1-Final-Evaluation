/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bug 428620
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtilPlugin;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.osgi.util.NLS;


/** @author pkobiakov */
public class MetamodelRegistry {
    
    public static boolean isMetamodelFileName(String fileName) {
    	return fileName.endsWith(".ecore") //$NON-NLS-1$
	        || fileName.endsWith(".xcore") //$NON-NLS-1$
	        || fileName.endsWith(".emof") //$NON-NLS-1$
	        || fileName.endsWith(".oclinecore") //$NON-NLS-1$
	        ;
    }
	
	
    public static final String MM_POINT_ID = "metamodelProvider"; //$NON-NLS-1$
    
    private static final MetamodelRegistry ourInstance = new MetamodelRegistry();
		
	private final IMetamodelProvider myMetamodelProvider;
	
	
	private MetamodelRegistry() {	
		this(getDefaultMetamodelProvider());
    }
	
	public MetamodelRegistry(EPackage.Registry packageRegistry) {
		this(getDefaultMetamodelProvider(packageRegistry));
	}
		
	public MetamodelRegistry(IMetamodelProvider metamodelProvider) {				
		myMetamodelProvider = metamodelProvider;
	}
	
    public EPackage.Registry toEPackageRegistry() {
    	return myMetamodelProvider.getPackageRegistry();
    }
    
    public static IMetamodelProvider getDefaultMetamodelProvider() {
		return getDefaultMetamodelProvider(EPackage.Registry.INSTANCE);
	}
    
    public static IMetamodelProvider getDefaultMetamodelProvider(EPackage.Registry packageRegistry) {
		return getDefaultMetamodelProvider(new EmfStandaloneMetamodelProvider(packageRegistry));
	}
	
	public static IMetamodelProvider getDefaultMetamodelProvider(IMetamodelProvider base) {
		return EMFPlugin.IS_ECLIPSE_RUNNING ? Eclipse.getMetamodelProvider(base) : base;
	}	
    
    public static MetamodelRegistry getInstance() {
        return ourInstance;
    }
        
	public String[] getMetamodelIds() {
		IMetamodelDesc[] metamodels = myMetamodelProvider.getMetamodels();
		
		final Set<String> ids = new LinkedHashSet<String>(metamodels.length);		
		for(IMetamodelDesc desc : metamodels) {
			ids.add(desc.getId());
		}
		
		return ids.toArray(new String[ids.size()]);
	}

	public static EPackage tryLookupEmptyRootPackage(String nsURI, EPackage.Registry registry) {
		URI rootURI = URI.createURI(nsURI);
		if(rootURI.segmentCount() == 0) {
			return null;
		}
		
		String base = rootURI.segment(0);
		String commonBaseURI = rootURI.trimSegments(rootURI.segmentCount()).appendSegment(base).toString().toLowerCase();
		
		LinkedList<String> candidates = new LinkedList<String>();
		for (String nextURI : registry.keySet()) {
			if(nextURI.toLowerCase().startsWith(commonBaseURI)) {
				candidates.add(nextURI);
			}
		}
				
		// first attempt to select few packages which are likely
		// to be child packages to avoid initialization of all packages
		// in the registry
        for(String nextNsURI : candidates) {
        	EPackage pack = null;
        	
        	try {
        		pack = registry.getEPackage(nextNsURI);
        	}
        	catch(Throwable t) {
        		EmfUtilPlugin.log(t);
        	}
        	
        	if (pack != null) {
	        	pack = EmfUtil.getRootPackage(pack);
	        	
	        	if (nsURI.equals(pack.getNsURI())) {
	        		return pack;
	        	}
        	}
        }

        // too greedy to check all packages
//        // check all packages in the registry
//        for(String nextNsURI : registry.keySet()) {
//        	EPackage pack = registry.getEPackage(nextNsURI);
//
//        	while (pack.getESuperPackage() != null) {
//    			pack = pack.getESuperPackage();
//    		}
//        	
//        	if (nsURI.equals(pack.getNsURI())) {
//        		return pack;
//        	}
//        }
        
		return null;
	}
	
	public IMetamodelDesc getMetamodelDesc(String id) throws EmfException {
		IMetamodelDesc desc = myMetamodelProvider.getMetamodel(id);
		
		// FIXME - hack for #35157 
		if(desc == null && id != null) {
            for(IMetamodelDesc d: myMetamodelProvider.getMetamodels()) {
            	EPackage pack = d.getModel();
            	if (pack == null) {
            		continue;
            	}
            	if (id.equals(pack.getNsURI())) {
            		desc = d;
            		break;
            	}
        		pack = EmfUtil.getRootPackage(pack);
            	if (id.equals(pack.getNsURI())) {
            		desc = new EmfMetamodelDesc(pack, pack.getNsURI());
            		break;
            	}
            }
        }
        				
//        if (desc == null && id != null) {
//            // Unregistered platform metamodels, e.g. available via "platform:/resource" or "platform:/plugin"
//            URI uri = URI.createURI(id);
//            if (uri.isPlatform()) {
//                desc = MetamodelRegistry.createUndeclaredMetamodel(uri, id, resolutionRS != null ? resolutionRS : new ResourceSetImpl());
//            }
//        }
        
        if (desc == null) {
        	throw new EmfException(NLS.bind(Messages.MetamodelRegistry_0, id, myMetamodelProvider.getMetamodels()));
        }
        
        return desc;      		
	}

	public static List<EPackage> resolveMetamodels(EPackage.Registry registry, List<String> packageName) {	
		final List<EPackage> metamodels = new UniqueEList<EPackage>(findPackages(registry, packageName));
		
		if (metamodels.isEmpty()) {
			metamodels.addAll(resolveUrilessMetamodels(registry, packageName));
		}

        return metamodels; 
	}
	
	/**
	 * Special case for uriless ModelType registration like
	 * 'modeltype Ecore uses ecore;'
	 */
	private static List<EPackage> resolveUrilessMetamodels(EPackage.Registry registry, List<String> packageName) {	
		final List<EPackage> metamodels = new UniqueEList<EPackage>(1);
		
		for(EPackage globalPack : findPackages(EPackage.Registry.INSTANCE, packageName)) {
			
			// check if this global package is a valid finding
			// i.e. if its root package is actually registered in the given registry
			EPackage rootPack = EmfUtil.getRootPackage(globalPack);
    		EPackage registeredPack = null;
    		
    		try {
    			registeredPack = registry.getEPackage(rootPack.getNsURI());
    		}
    		catch(Throwable t) {
    			EmfUtilPlugin.log(t);
    		}
    		
			if(registeredPack == rootPack) {
    			metamodels.add(globalPack);
    		}
		}
      
        return metamodels; 
	}
    
    private static List<EPackage> findPackages(EPackage.Registry registry, List<String> packageName) {
    	final List<EPackage> metamodels = new UniqueEList<EPackage>(1);
		
    	// do not iterate over the key set itself to avoid concurrent modification
    	final List<String> keys = new ArrayList<String>(registry.keySet());
        for (String nsURI : keys) {
        	EPackage pack = null;
        	
        	try {
        		pack = registry.getEPackage(nsURI);
        	}
        	catch(Throwable t) {
        		EmfUtilPlugin.log(t);
        	}
        	
        	if (pack == null || pack.getESuperPackage() != null) {
        		continue;
        	}
        	EPackage lookupPackage = lookupPackage(pack, packageName);
        	if (lookupPackage != null) {
        		metamodels.add(lookupPackage);
        	}
        }
                
        return metamodels;
    }
	
	public static EPackage lookupPackage(EPackage rootPackage, List<String> path) {
		EPackage.Registry registry = new EPackageRegistryImpl();
		registry.put(rootPackage.getNsURI(), rootPackage);
		
		return EcoreEnvironment.findPackage(path, registry);
	}
			
	private static class Eclipse {
						
		static IMetamodelProvider getMetamodelProvider(IMetamodelProvider base) {
			if(base == null) {
	    		throw new IllegalArgumentException();
	    	}
			 			
			IMetamodelProvider metamodelProvider = base;
							
			IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EmfUtilPlugin.getDefault().getBundle().getSymbolicName(), MM_POINT_ID);
			
			for (IConfigurationElement configElement : configElements) {
				IMetamodelProvider provider = EclipseMetamodelProvider.Factory.create(configElement, metamodelProvider);
				if (provider != null) {
					metamodelProvider = provider;
				}
			}
					
			return metamodelProvider;
		}		
	}
}
