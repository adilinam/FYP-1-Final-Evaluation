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
package org.eclipse.m2m.internal.qvt.oml.emf.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.osgi.util.NLS;


/**
 * @author pkobiakov
 */
public class EmfUtil {
    private EmfUtil() {}

    public static final String PATH_SEPARATOR = "::"; //$NON-NLS-1$
    
    public static ModelContent loadModel(URI uri) {
    	return loadModel(uri, getDefaultLoadOptions(), null);
    }
    
    public static ModelContent loadModel(URI uri, ResourceSet rs) {
    	return loadModel(uri, getDefaultLoadOptions(), rs);
    }    
    
    private static ModelContent loadModel(URI uri, Map<Object, Object> options, ResourceSet rs) {
        if(uri == null) {
            return null;
        }
        ResourceSet resourceSet = (rs != null) ? rs : createResourceSet(options);
        String fragment = uri.fragment();
        if (fragment != null && fragment.length() > 0) {
            EObject eObject = resourceSet.getEObject(uri, true);
            if (eObject == null) {
            	return null;
            }
            return new ModelContent(Collections.singletonList(eObject));
        }
        Resource resource = resourceSet.getResource(uri.trimFragment(), true);
        if (resource == null) {
        	return null;
        }
        return new ModelContent(resource.getContents());
    }
    
    public static ModelContent safeLoadModel(URI uri, ResourceSet rs) {
    	return safeLoadModel(uri, getDefaultLoadOptions(), rs);
    }
    
    private static ModelContent safeLoadModel(URI uri, Map<Object, Object> options, ResourceSet rs) {
        try {
            return loadModel(uri, options, rs);
        }
        catch(Exception e){
            return null;
        }
    }
    
    public static Resource loadResource(URI uri) {
        return createResourceSet(getDefaultLoadOptions()).getResource(uri, true);
    }
    
	private static ResourceSet createResourceSet(Map<Object, Object> options) {
		ResourceSet resourceSet = new ResourceSetImpl() {
			
			@Override
			protected Resource delegatedGetResource(URI uri, boolean loadOnDemand) {
				Resource resource = super.delegatedGetResource(uri, loadOnDemand);
				if (resource == null && false == loadOnDemand) {
					resource = lookupMetamodelRegistry(uri);
				}
				return resource;
			}
			
			@Override
			protected Resource demandCreateResource(URI uri) {
				Resource resource = super.demandCreateResource(uri);
				if (resource == null) {
					resource = lookupMetamodelRegistry(uri);
				}
				return resource;
			}
			
			private Resource lookupMetamodelRegistry(URI uri) {
				Resource resource = null;
				URI trimmedURI = uri.trimFragment();
				try {
					IMetamodelDesc descriptor = MetamodelRegistry.getInstance().getMetamodelDesc(trimmedURI.toString());
					EPackage ePackage = descriptor.getModel();
					resource = ePackage.eResource();
					if (resource == null) {
						resource = new ResourceImpl(trimmedURI);
						resource.getContents().add(ePackage);
					}
				} catch (EmfException e) {
					EmfUtilPlugin.log(e);
				}
				return resource;
			}
			
		};
        resourceSet.getLoadOptions().putAll(options);
		return resourceSet;
	}
    
	public static EObject resolveSource(EObject in, EObject inputType) {
		if (inputType == null || inputType.eResource() == null) {
			return in;
		}
        return resolveSource(in, inputType.eResource().getResourceSet());
    }
	
	public static EObject resolveSource(EObject in, ResourceSet rs) {
        if (rs != null && EmfUtil.isDynamic(in)) {
        	ResourceSet inRS = in.eResource() != null ? in.eResource().getResourceSet() : null;
        	if (rs != inRS) {
        		URI uri = EcoreUtil.getURI(in);
        		if (uri != null && !"#//".equals(uri.toString())) { //$NON-NLS-1$
        			return rs.getEObject(uri, true);
        		}
        	}
        }
        return in;
    }
	
	public static Set<EObject> getResolvedContent(Collection<EObject> content, EObject metamodel) {
		ResourceSet rs = (metamodel != null && metamodel.eResource() != null ? metamodel.eResource().getResourceSet() : null);
		return getResolvedContent(content, rs);
	}
	
	public static Set<EObject> getResolvedContent(Collection<EObject> content, ResourceSet rs) {
		Set<EObject> resolvedObjs = new LinkedHashSet<EObject>(content.size());
		for (EObject obj : content) {
			EObject resolved = null;
			try {
				resolved = resolveSource(obj, rs);
			}
			catch (Exception ex) {				
			}
			resolvedObjs.add(resolved != null ? resolved : obj);
		}
		return resolvedObjs;
	}
		
	public static boolean isUriExistsAsEObject(URI uri, ResourceSet rs, boolean validateNonEmpty) {
    	ModelContent loadModel = null;
    	try {
    		loadModel = loadModel(uri, rs);
    	}
    	catch (Exception e) {
    	}
        if (loadModel == null) {
        	return false;
        }
        return validateNonEmpty ? !loadModel.getContent().isEmpty() : true;
	}

	public static boolean isDynamic(EObject eObject) {
		return eObject instanceof EStructuralFeature.Internal.DynamicValueHolder;
	}
	

	public static void saveModel(EObject eObject, URI uri, Map<Object, Object> opts) throws EmfException {    
        ResourceSet resourceSet = getOutputResourceSet();

        Resource resource = resourceSet.createResource(uri);
        resource.getContents().add(eObject);

        Map<Object, Object> options = new HashMap<Object, Object>(opts);
        options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
        
        if(isDynamic(eObject)) {
        	options.put("SCHEMA_LOCATION", Boolean.TRUE); //$NON-NLS-1$
        }
        
        try {
            resource.save(options);
        } catch (Exception e) {
            throw new EmfException(NLS.bind(Messages.EmfUtil_1, uri), e);
        }
    }
    
	public static void saveModel(Resource modelExtent, Map<Object, Object> opts) throws EmfException {    
        Map<Object, Object> options = new HashMap<Object, Object>(opts);
        options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
        options.put(XMIResource.OPTION_PROCESS_DANGLING_HREF, XMIResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);       
        for (EObject eObject : modelExtent.getContents()) {
	        if(isDynamic(eObject)) {
	        	options.put("SCHEMA_LOCATION", Boolean.TRUE); //$NON-NLS-1$
	        	break;
	        }
        }
        
        try {
        	modelExtent.save(options);
        } catch (Exception e) {
            throw new EmfException(NLS.bind(Messages.EmfUtil_1, modelExtent.getURI()), e);
        }
    }
	
	public static ResourceSet getOutputResourceSet() {
		return new ResourceSetImpl();
	}
    
    public static EPackage getRootPackage(EPackage pack) {
        EPackage parent = pack.getESuperPackage();
        if(parent == null) {
            return pack;
        }
        else {
            return getRootPackage(parent);
        }
    }
    
    public static String getFullName(EClassifier cls) {
        return getFullName(cls, PATH_SEPARATOR);
    }

    private static String getFullName(EClassifier cls, String delim) {
    	if(cls.getEPackage() == null) {
    		return cls.getName();
    	}
        return getFullName(cls.getEPackage(), delim) + delim + cls.getName();
    }

    public static String getFullName(EPackage pack) {
        return getFullName(pack, PATH_SEPARATOR);
    }    
    
    private static String getFullName(EPackage pack, String delim) {
        if(pack.getESuperPackage() != null) {
            return getFullName(pack.getESuperPackage(), delim) + delim + pack.getName();
        } else {
            return pack.getName();
        }
    }
    
    /**
	 * Get the given package full name relative to the specified owning package
	 * 
	 * @param ePackage
	 *            the package of which to retrieve the full name
	 * @param baseOwningPackage
	 *            the package representing the root context for relative name
	 *            resolution.
	 *            <p>
	 *            This package and its possible super-packages will be excluded
	 *            from the full-name. If it is the immediate owning package of
	 *            the <code>ePackage</code>, the local name of <code>ePackage</code> is
	 *            returned.
	 */    
    public static String getFullNameRelativeToPackage(EPackage ePackage, EPackage baseQwningPackage) {
        if(ePackage.getESuperPackage() != null && ePackage.getESuperPackage() != baseQwningPackage) {
        	StringBuilder buf = new StringBuilder();        	
        	
        	EPackage nextPackage = ePackage;        	
        	for(int i = 0; nextPackage != null && nextPackage != baseQwningPackage ; i++) {
        		if(i > 0) {
        			buf.insert(0, PATH_SEPARATOR);
        		}
        		buf.insert(0, nextPackage.getName());        		
        		
        		nextPackage = nextPackage.getESuperPackage(); 
        	}
        	
            return getFullNameRelativeToPackage(ePackage.getESuperPackage(), baseQwningPackage) + PATH_SEPARATOR + ePackage.getName();
        } else {
            return ePackage.getName();
        }
    }
    
    /**
	 * Get the given classifier's full name relative to the specified owning package
	 * 
	 * @param eClassifier
	 *            the classifier of which to retrieve name
	 * @param baseOwningPackage
	 *            the package representing the root context for relative name
	 *            resolution.
	 *            <p>
	 *            This package and its possible super-packages will be excluded
	 *            from the full-name. If it is the immediate owning package of
	 *            the given classifier, the local name of the classifier is
	 *            returned.
	 */
    public static String getFullNameRelativeToPackage(EClassifier eClassifier, EPackage baseOwningPackage) {
		EPackage immediateOwner = eClassifier.getEPackage();		
		if(baseOwningPackage != null && immediateOwner != null && baseOwningPackage != immediateOwner) {
			String parentName = EmfUtil.getFullNameRelativeToPackage(immediateOwner, baseOwningPackage);
			return parentName + PATH_SEPARATOR + eClassifier.getName(); 
		}
		return eClassifier.getName();		
	}

    public static EClass getEClass(EPackage root, String[] fullName) throws EmfException {
        EClassifier classifier = getEClassifier(root, fullName);
        if(classifier instanceof EClass == false) {
            throw new EmfException(NLS.bind(Messages.EmfUtil_6, fullName[fullName.length-1]));
        }
        
        return (EClass)classifier;
     }

    private static EClassifier getEClassifier(EPackage root, String[] fullName) throws EmfException {
        if(fullName.length < 2) {
            throw new EmfException(NLS.bind(Messages.EmfUtil_2, Arrays.asList(fullName)));
        }
        
        String rootPackName = fullName[0];
        if(!rootPackName.equals(root.getName())) {
            throw new EmfException(NLS.bind(Messages.EmfUtil_3, rootPackName, root.getName()));
        }
        
        MAIN: 
        for(int i = 1; i < fullName.length-1; i++) {
            for (EPackage pack : root.getESubpackages()) {
                if(fullName[i].equals(pack.getName())) {
                    root = pack;
                    continue MAIN;
                }
            }
            
            throw new EmfException(NLS.bind(Messages.EmfUtil_5, fullName[i]));
        }
        
        EClassifier classifier = root.getEClassifier(fullName[fullName.length-1]);
        return classifier;
    }
    
    public static URI makeUri(String uriString) {
        if(uriString == null || uriString.length() == 0) {
            return null;
        }
        
        URI uri = null;
        try {
	        uri = URI.createURI(uriString);
        }
        catch (Exception e) {
        	return null;
        }
        
        return uri;
    }
    
    public static String getRootPackageUri(EClassifier cls) {
        String uri = cls == null ? null : getRootPackage(cls.getEPackage()).getNsURI();
        return uri;
    }
    
    public static boolean isAssignableFrom(EClassifier type, EClassifier from) {
    	if (type == from) {
    		return true;
    	}
    	if (false == from instanceof EClass) {
    		return false;
    	}
    	return ((EClass) from).getEAllSuperTypes().contains(type);
    }

    public static Map<Object, Object> getDefaultLoadOptions() {
    	Map<Object, Object> options = new HashMap<Object, Object>();
    	// create new session to avoid problems with parallel filling of containments lists (#31662, etc.) 
    	return options;
    }
    
	public static Resource createResource(URI uri, ResourceSet outResourceSet) {
		Resource resource = outResourceSet.createResource(uri);
		if(resource != null) {
			return resource;
		}
		
		Object possibleFactory = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(uri.fileExtension());
		Resource.Factory factory = null;
		if (possibleFactory instanceof Resource.Factory) {
			factory = (Resource.Factory) possibleFactory;
		}
		if (possibleFactory instanceof Resource.Factory.Descriptor) {
			factory = ((Resource.Factory.Descriptor) possibleFactory).createFactory();
		}
		
		if(factory == null) {
			factory = new XMIResourceFactoryImpl();			
		}
		
		return factory.createResource(uri);
	}    
    
	public static boolean isUriMapped(ResourceSet resourceSet, URI uri) {
	    if (uri != null) {
	        URIConverter converter = resourceSet.getURIConverter();
	        if (converter != null) {
	            Map<URI, URI> uriMap = converter.getURIMap();
	            if (uriMap != null) {
	                return uriMap.containsKey(uri);
	            }
	        }
	    }
	    return false;
	}
	
	public static void cleanupResourceSet(ResourceSet rs) {
		URI uri = URI.createURI(""); //$NON-NLS-1$
		
		List<Resource> resCopy = new ArrayList<Resource>(rs.getResources()); 
		for (Resource res : resCopy) {
//			for (TreeIterator<EObject> it = res.getAllContents(); it.hasNext();) {
//				EObject eObject = it.next();
//				eObject.eAdapters().clear();				
//			}
//			res.getContents().clear();
//			res.eAdapters().clear();

			if (res.isLoaded()) {
				for (TreeIterator<EObject> it = res.getAllContents(); it.hasNext();) {
					EObject eObject = it.next();
					((InternalEObject) eObject).eSetProxyURI(uri);
				}
				res.unload();
			}
		}
		rs.getResources().clear();
		rs.eAdapters().clear();
	}
	
	public static boolean isUriExists(URI uri, ResourceSet rs, boolean validateNonEmpty) {
		URIConverter uriConverter = (rs != null ? rs.getURIConverter() : URIConverter.INSTANCE);
		if (uriConverter.exists(uri, Collections.emptyMap())) {
			return true;
		}
		return isUriExistsAsEObject(uri, rs, validateNonEmpty);
	}
	
	
    public static final Map<Object, Object> DEFAULT_SAVE_OPTIONS = new HashMap<Object, Object>();
    static {
    	DEFAULT_SAVE_OPTIONS.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
    }
}
