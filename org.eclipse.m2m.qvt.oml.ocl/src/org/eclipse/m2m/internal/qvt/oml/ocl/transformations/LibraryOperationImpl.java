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
/*
 * Created on Jun 28, 2005
 */
package org.eclipse.m2m.internal.qvt.oml.ocl.transformations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.ocl.Logger;
import org.eclipse.m2m.internal.qvt.oml.ocl.metainfo.OclMetainfoOperation;


class LibraryOperationImpl implements LibraryOperation {

    public LibraryOperationImpl(OclMetainfoOperation meta, Library library)
            throws LibraryOperationException, LibraryCreationException {
        myLibrary = library;
        myName = meta.getMethod().getName();
        myMethod = meta.getMethod();
        myContext = meta.getContextType();
        myReturnType = meta.getType();
        myParameterTypes = new LinkedList<String>(meta.getParameterTypes());
    }

    public Library getLibrary() {
        return myLibrary;
    }

    public void load() throws LibraryOperationException {
    }

    public String getContext() {
        return myContext;
    }

    public String getName() {
        return myName;
    }

    public String getReturnType() {
        return myReturnType;
    }

    public List<String> getParameterTypes() {
        return myParameterTypes;
    }

    public List<String> getImplicitParameterNames() {
        return IMPLICIT_PARAMETERS_LIST;
    }

    public Object run(Object context, Object[] explicitParameterValues,
            Object[] implicitParameterValues, Class<?> returnTypeClass) {
        Object[] explicitParameterValuesWithContext = getJoinArray(
                new Object[] { context }, explicitParameterValues);
        Object[] parameters = getJoinArray(implicitParameterValues,
                explicitParameterValuesWithContext);
        if (!isMethodApplicable(parameters, returnTypeClass)) {
            parameters = explicitParameterValuesWithContext;
            if (!isMethodApplicable(parameters, returnTypeClass)) {
                parameters = explicitParameterValues;
                if (!isMethodApplicable(parameters, returnTypeClass)) {
                	throw new RuntimeException("Unable to execute native method -- incorrect parameters passed: " + Arrays.asList(parameters)); //$NON-NLS-1$
                }
            }
        }

        Method method = getMethod();
        try {
            return method.invoke(getLibrary().getLibraryInstance(), parameters);
        } 
        catch (IllegalArgumentException e) {
        	throw new RuntimeException(e);
        } 
        catch (IllegalAccessException e) {
        	throw new RuntimeException(e);
        } 
        catch (InvocationTargetException e) {
        	throw new RuntimeException(e.getTargetException());
        }
    }

    public String getOperationReference(String[] parameterNames) {
        String className = getLibrary().getLibraryClassName().replaceAll(
                "\\$", "."); //$NON-NLS-1$ //$NON-NLS-2$

        StringBuffer paramString = new StringBuffer();
        for (int i = 0, len = parameterNames.length; i < len; i++) {
            paramString.append(parameterNames[i]);
            if (i < len - 1) {
                paramString.append(", "); //$NON-NLS-1$
            }
        }

        String call = "new " + className + "()." + getName() + "(" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                + paramString + ")"; //$NON-NLS-1$
        return call;
    }

    private Object[] getJoinArray(Object[] first, Object[] second) {
        Object[] result = new Object[first.length + second.length];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    private boolean isMethodApplicable(Object[] parameterValues,
            Class<?> returnType) {
        Class<?>[] parameterClasses = getParameterClasses(parameterValues);
        Method method = getMethod();
        Class<?>[] methodParameters = method.getParameterTypes();

        if (parameterClasses.length != methodParameters.length) {
            return false;
        }

        for (int i = 0; i < parameterClasses.length; i++) {
            // null parameters are conformed to any classes
            Class<?> required = methodParameters[i];
            Class<?> actual = parameterClasses[i];
            if (actual != null && !required.isAssignableFrom(actual)) {
                Logger.getLogger().log(Logger.WARNING, "Type " + required //$NON-NLS-1$
                        + " is not assignable from " + actual); //$NON-NLS-1$
                return false;
            }
        }

        if (returnType != null && !returnType.isAssignableFrom(method.getReturnType())) {
            Logger.getLogger().log(Logger.SEVERE,
                    "Required return type " + returnType //$NON-NLS-1$
                            + " is not assignable from method return type " //$NON-NLS-1$
                            + method.getReturnType());
            return false;
        }
        return true;
    }

    private Class<?>[] getParameterClasses(Object[] parameters) {
        Collection<Class<?>> parameterClasses = new ArrayList<Class<?>>();
        for (Object param : parameters) {
            // null parameters are conformed to any classes
            parameterClasses.add(param == null ? null : param.getClass());
        }
        return parameterClasses.toArray(new Class[parameterClasses.size()]);
    }

    private Method getMethod() {
        return myMethod;
    }

    @Override
    public String toString() {
    	return myName + myParameterTypes + "/" + myLibrary; //$NON-NLS-1$
    }

    private Library myLibrary;
    private String myName;
    private String myContext;
    private String myReturnType;
    private List<String> myParameterTypes;
    private Method myMethod;

    private static final List<String> IMPLICIT_PARAMETERS_LIST = new LinkedList<String>();
    
}
