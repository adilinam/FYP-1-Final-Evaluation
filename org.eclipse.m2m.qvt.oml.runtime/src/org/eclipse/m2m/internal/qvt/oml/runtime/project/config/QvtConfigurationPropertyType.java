/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
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


public abstract class QvtConfigurationPropertyType {
    public abstract String getName();
    public abstract Object getImplementation();
    protected abstract Object doValueOf(String str) throws IllegalArgumentException;
    
    public final Object valueOf(String str) {
        if (str == null) {
            return NOT_SET;
        }
        try {
            return doValueOf(str);
        } catch (Exception e) {
            return new ErrorValue(str, e);
        }
    }
    
    public String stringValueOf(Object obj) {
        if (obj == NOT_SET || obj == null) {
            return null;
        }
        return obj.toString();
    }
    
    /**
     * Such objects are returned by valueOf on errors 
     */
    public static class ErrorValue {
        
        public ErrorValue(String str) {
            myString = str;
            myException = null;
        }
        
        public ErrorValue(String str, Exception exception) {
            myString = str;
            myException = exception;
        }
        
        @Override
		public String toString() {
            return myString;
        };
        
        public Exception getException() {
            return myException;
        }
        
        private final String myString;
        private final Exception myException;
    };
    
    /**
     * Value is not set
     */
    public static final Object NOT_SET = new Object() {
        @Override
		public String toString() {
            return org.eclipse.m2m.internal.qvt.oml.runtime.project.config.Messages.QvtConfigurationPropertyType_NOT_SET;
        };
    };
}