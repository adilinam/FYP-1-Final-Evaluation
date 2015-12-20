/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.project;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.Messages;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.osgi.util.NLS;


public abstract class TransformationRegistry {

    public static final Filter EMPTY_FILTER = new Filter() {
        public boolean accept(IConfigurationElement element) {
            return true;
        }        
    };
	
    public static final Filter TRANSFORMATION_FILTER = new Filter() {
        public boolean accept(IConfigurationElement element) {
        	return IRegistryConstants.TRANSFORMATION.equals(element.getName());
        }        
    };
	

    protected TransformationRegistry(String point) {
        myPoint = point;
    }
    
    public static interface Filter {
        boolean accept(IConfigurationElement element);
    };
    
    @Deprecated
    public static class InputFilter implements Filter {
        
    	private List<EClass> myInput = new ArrayList<EClass>();
    	
    	@Deprecated
		public InputFilter(EClass input) {
            myInput.add(input);
            myInput.addAll(input.getEAllSuperTypes());
        }
        
        public boolean accept(IConfigurationElement element) {
            try {
            	if(element.getChildren(IRegistryConstants.INPUT).length == 0) {
            		return false;
            	}
                for (EClass cl : myInput) {
                    if (checkEClassElement(element, IRegistryConstants.INPUT, cl)) {
                        return true;
                    }
                }
                return false;
            } catch (MdaException e) {
                return false;
            }
        }
    }
    
    public List<CompiledTransformation> getTransformations(Filter filter) {
        List<CompiledTransformation> transformations = new ArrayList<CompiledTransformation>();
        
        IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(myPoint);
        for (int i = 0; i < configurationElements.length; i++) {
            IConfigurationElement element = configurationElements[i];
            try { 
                if(filter == null || filter.accept(element)) {
                    CompiledTransformation transformation = makeTransformation(element);
                    transformations.add(transformation);
                }
            }
            catch(MdaException e) {
                Logger.getLogger().log(Logger.SEVERE, "Failed to parse extension " + element, e); //$NON-NLS-1$
            }
        }

        return transformations;
    }
    
    public CompiledTransformation getSingleTransformationById(final String id) {
        List<CompiledTransformation> transformations = getTransformations(
                new Filter() {
                    public boolean accept(IConfigurationElement element) {
                        return id.equals(element.getAttribute(IRegistryConstants.ID));
                    }
               });
        
        return transformations.isEmpty() ? null : transformations.get(0);
    }
    
    @Deprecated
    public List<CompiledTransformation> getTransformationsByInput(final EClass input) {
        return getTransformations(new InputFilter(input));            
    }

    public List<CompiledTransformation> getTransformations() {
        return getTransformations(null);
    }

    protected abstract CompiledTransformation makeTransformation(IConfigurationElement element) throws MdaException;
    
    protected static EClass getEClassElement(IConfigurationElement parent, String name) throws MdaException {
        Pair<String, String> eCl = parseEClassElement(parent, name);
        return getEClassElement(eCl.getFirst(), eCl.getSecond());
    }

    private static Pair<String, String> parseEClassElement(IConfigurationElement parent, String name) throws MdaException, InvalidRegistryObjectException {
        IConfigurationElement elem = getSingleElement(parent, name);
        
        String metamodel = elem.getAttribute(IRegistryConstants.METAMODEL);
        if(metamodel == null) {
            throw new MdaException(NLS.bind(Messages.TransformationRegistry_MissingMetamodelAttr, parent));
        }
        
        String metaclass = elem.getAttribute(IRegistryConstants.METACLASS);
        if(metaclass == null) {
            throw new MdaException(NLS.bind(Messages.TransformationRegistry_MissingMetaclassAttr, parent));
        }
        
        return new Pair<String, String>(metamodel, metaclass);
    }

    private static boolean checkEClassElement(IConfigurationElement parent, String name, EClass eClass) throws MdaException {
        Pair<String, String> eCl = parseEClassElement(parent, name);
        
        String metamodel = eCl.getFirst();
        String metaclass = eCl.getSecond();
        String[] components = metaclass.split(IRegistryConstants.DELIM);
        if (components[components.length - 1].equals(eClass.getName())) {
            EPackage ePack = eClass.getEPackage();
            for (int pack = components.length - 2; pack >= 0; pack--) {
                if (ePack == null) {
                    return false;
                }                                    
                if (!components[pack].equals(ePack.getName())) {
                    return false;
                }
                if (pack == 0) {
                    if (metamodel.equals(ePack.getNsURI())) {
                        return true;
                    } 
                    
                    return false;                    
                }
                ePack = ePack.getESuperPackage();
            };
        }
        
        return false;
    }

    private static EClass getEClassElement(String metamodel,String metaclass) throws MdaException {
        EPackage pack = EPackage.Registry.INSTANCE.getEPackage(metamodel);
        if(pack == null) {
            throw new MdaException(NLS.bind(Messages.TransformationRegistry_UnknownMetamodel, metamodel));
        }
            
        String[] components = metaclass.split(IRegistryConstants.DELIM);
        try {
        	EClass cls = EmfUtil.getEClass(pack, components);
        	return cls;
        }
        catch(EmfException e) {
        	throw new MdaException(e);
        }
    }
    
    private static IConfigurationElement getSingleElement(IConfigurationElement parent, String name) throws MdaException {
        IConfigurationElement[] elems = parent.getChildren(name);
        if(elems == null || elems.length == 0) {
            throw new MdaException(NLS.bind(Messages.TransformationRegistry_NoElements, name, parent)); 
        }
        
        return elems[0];
    }
    
    private final String  myPoint;
}