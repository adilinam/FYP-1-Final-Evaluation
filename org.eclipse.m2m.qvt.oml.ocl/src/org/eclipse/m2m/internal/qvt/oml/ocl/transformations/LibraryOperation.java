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
package org.eclipse.m2m.internal.qvt.oml.ocl.transformations;

import java.util.List;


public interface LibraryOperation {

    Library getLibrary();

    void load() throws LibraryOperationException;

    /**
     * @return OCL path to the context class of an operation (e.g. uml::kernel::Class)
     */
    String getContext();

    /**
     * @return The name of an operation 
     */
	String getName();

    /**
     * @return OCL path to the return type (e.g. uml::kernel::Class)
     */
    String getReturnType();
    
    /**
     * @return list of a Strings == OCL paths to the parameter types (e.g.
     *         uml::kernel::Class) in a proper sequence
     */
    List<String> getParameterTypes();

    /**
     * Impicit means that these parameters are not specified by </code>getParameterTypes()</code>
     * and should be loaded from the environment object using their names
     * without any changes. These parameters are prepended to the list of
     * "explicit" parameters on execution of <code>run(...)</code> method i.e.
     * added into the parameterValues array as a first part of it.
     * 
     * @return list of Strings == implicit parameter names in a proper sequence.
     */
    List<String> getImplicitParameterNames();
    
    /**
     * Called then native extension should be executed.
     * 
     * @param java
     *            object representing context element ("self" variable)
     * @param parameterValues
     *            array of java objects which should be passed as a parameters
     *            to the native operation implementation
     * @param implicitParameters
     *            array of java objects which should be passes as an implicit
     *            parameters to the native operation implementation
     * @param returnTypeClass
     *            java class which should be returned by this native operation
     */
    Object run(Object context, Object[] parameterValues,
            Object[] implicitParameterValues, Class<?> returnTypeClass);

    String getOperationReference(String[] parameterNames);
    
}
