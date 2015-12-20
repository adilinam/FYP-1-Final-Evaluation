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

import org.eclipse.emf.ecore.EDataType;

public class EMFType extends QvtConfigurationPropertyType {

    public EMFType(EDataType type) {
        myType = type;
    }
    
    @Override
	public String getName() {
        return myType.getName();
    }

    @Override
	public Object getImplementation() {
        return myType;
    }

    @Override
	public Object doValueOf(String str) throws IllegalArgumentException {
        Object value = myType.getEPackage().getEFactoryInstance().createFromString(myType, str);
        if (value == null) {
            throw new IllegalArgumentException("Cannot create from string"); //$NON-NLS-1$
        }
        return new ValueWrapper(value);
    }
    
    // Generic workaround for
    // #31713 [configProps] values of Date type set in LaunchConfiguration are treated incorrectly
    /**
     * Delegates toString() to the EFactory
     */
    private class ValueWrapper {
        
        ValueWrapper(Object obj) {
            myObject = obj;
        }
        
        @Override
        public String toString() {
            return myType.getEPackage().getEFactoryInstance().convertToString(myType, myObject);
        }
        
        private final Object myObject;
    }
    
    private final EDataType myType;        
}