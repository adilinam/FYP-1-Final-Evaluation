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
package org.eclipse.m2m.internal.qvt.oml.runtime.project.config;


public class PrimitiveType extends QvtConfigurationPropertyType {

    public PrimitiveType(Class<?> cl) {
        myClass = cl;
    }
    
    @Override
	public String getName() {
        return myClass.getName();
    }

    @Override
	public Object getImplementation() {
        return myClass;
    }

    @Override
	public Object doValueOf(String str) throws IllegalArgumentException {
        if (myClass == Character.class || myClass == Character.TYPE) {
            if (str.length() != 1) {
                throw new IllegalArgumentException(org.eclipse.m2m.internal.qvt.oml.runtime.project.config.Messages.Unable_to_convert_String_to_Character);
            }
            return str.charAt(0);
        } else if (myClass == Byte.class || myClass == Byte.TYPE) {
            return Byte.valueOf(str);
        } else if (myClass == Short.class || myClass == Short.TYPE) {
            return Short.valueOf(str);
        } else if (myClass == Integer.class || myClass == Integer.TYPE) {
            return Integer.valueOf(str);
        } else if (myClass == Long.class || myClass == Long.TYPE) {
            return Long.valueOf(str);
        } else if (myClass == Float.class || myClass == Float.TYPE) {
            return Float.valueOf(str);
        } else if (myClass == Double.class || myClass == Double.TYPE) {
            return Double.valueOf(str);
        } else if (myClass == Boolean.class || myClass == Boolean.TYPE) {
            return Boolean.valueOf(str);
        } else if (myClass == String.class) {
            return str;
        } else throw new IllegalArgumentException(org.eclipse.m2m.internal.qvt.oml.runtime.project.config.Messages.Non_primitive_type);
    }
    
    private final Class<?> myClass;
}