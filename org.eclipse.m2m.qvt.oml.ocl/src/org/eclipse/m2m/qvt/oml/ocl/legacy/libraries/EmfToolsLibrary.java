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
/*
 * Created on Jul 11, 2005
 */
package org.eclipse.m2m.qvt.oml.ocl.legacy.libraries;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.VoidType;

/**
 * @since 3.5
 */
public class EmfToolsLibrary {

    public static class Metainfo {
    	
        private static final String[] GET_DATATYPE_INSTANCE = new String[] {
        	Libraries.OCL_LIBRARY_PACKAGE + "::" + VoidType.SINGLETON_NAME, //$NON-NLS-1$
        	PrimitiveType.STRING_NAME, PrimitiveType.STRING_NAME, "ecore::EDataType" //$NON-NLS-1$
        };
        
        private static final String[] GET_DETAILS = new String[] {
        	"ecore::EAnnotation", //$NON-NLS-1$
        	PrimitiveType.STRING_NAME, PrimitiveType.STRING_NAME 
        }; 
        
        private static final String[] AS_EOBJECT = new String[] {
        	Libraries.OCL_LIBRARY_PACKAGE + "::" + AnyType.SINGLETON_NAME, //$NON-NLS-1$
        	"ecore::EObject" //$NON-NLS-1$
        };

        private static final String[] CURRENTTIME_MILLIS = new String[] {
        	Libraries.OCL_LIBRARY_PACKAGE + "::" + AnyType.SINGLETON_NAME, //$NON-NLS-1$
        	PrimitiveType.INTEGER_NAME 
        }; 
        
        public static String[] getDataTypeInstance(String nsURI, String dataTypeName) {
            return GET_DATATYPE_INSTANCE;
        }
        
        public static String[] getDetails(EAnnotation self, String key) {
        	return GET_DETAILS;
        }
        
        public static String[] asEObject(Object self) {
        	return AS_EOBJECT; 
        }
        
        public static String[] currentTimeMillis() {
        	return CURRENTTIME_MILLIS; 
        }
        
    }

    private static final Class<?>[] EMPTY_CLASSES = new Class[0];

    private static final Object[] EMPTY_OBJECTS = new Object[0];

    private static final String GETTER_PREFIX = "get"; //$NON-NLS-1$

    public EDataType getDataTypeInstance(String nsURI, String dataTypeName) {
        if (nsURI == null || dataTypeName == null) {
            return null;
        }
        EPackage ePkg = Registry.INSTANCE.getEPackage(nsURI);
        if (ePkg == null) {
            return null;
        }
        try {
            Method method = ePkg.getClass().getMethod(
                    getMethodName(dataTypeName), EMPTY_CLASSES);
            Object result = method.invoke(ePkg, EMPTY_OBJECTS);
            if (result == null || result instanceof EDataType) {
                return (EDataType) result;
            }
            Logger.getLogger().log(Logger.SEVERE,
                    "Result of an accessor method execution is not an instance of EDataType: " //$NON-NLS-1$
                            + result.getClass());
        } catch (SecurityException e) {
            Logger.getLogger().log(Logger.SEVERE,
                    "Exception while looking for an accessor method for EDataType" //$NON-NLS-1$
                            + dataTypeName, e);
        } catch (NoSuchMethodException e) {
            Logger.getLogger().log(Logger.SEVERE,
                    "Exception while looking for an accessor method for EDataType" //$NON-NLS-1$
                            + dataTypeName, e);
        } catch (IllegalArgumentException e) {
            Logger.getLogger().log(Logger.SEVERE,
                    "Exception while executing accessor method for EDataType" //$NON-NLS-1$
                            + dataTypeName, e);
        } catch (IllegalAccessException e) {
            Logger.getLogger().log(Logger.SEVERE,
                    "Exception while executing accessor method for EDataType" //$NON-NLS-1$
                            + dataTypeName, e);
        } catch (InvocationTargetException e) {
            Logger.getLogger().log(Logger.SEVERE,
                    "Exception while executing accessor method for EDataType" //$NON-NLS-1$
                            + dataTypeName, e);
        }
        return null;
    }

    private String getMethodName(String datatypeName) {
        return GETTER_PREFIX + datatypeName;
    }
    
    @Operation(contextual=true)
    public String getDetails(EAnnotation self, String key) {
    	if (self == null) {
    		return null;
    	}
    	return (String) self.getDetails().get(key);
    }
    
    @Operation(contextual=true)
    public EObject asEObject(Object self) {
    	if (self instanceof EObject) {
    		return (EObject) self;
    	}
    	return null;
    }

    public Integer currentTimeMillis() {
    	return new Integer(new Long(System.currentTimeMillis()).intValue());
    }

}
