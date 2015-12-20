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


public class ErrorType extends QvtConfigurationPropertyType {
    
    public ErrorType(String name) {
        myName = name;
    }

    @Override
    protected Object doValueOf(String str) throws IllegalArgumentException {
        throw new IllegalArgumentException(org.eclipse.m2m.internal.qvt.oml.runtime.project.config.Messages.ErrorType_NOT_RESOLVED);
    }

    @Override
    public Object getImplementation() {
        return this;
    }

    @Override
    public String getName() {
        return myName;
    }

    private final String myName;

}
