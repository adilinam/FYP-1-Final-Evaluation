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
package org.eclipse.m2m.internal.qvt.oml.ocl.metainfo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class OclMetainfoOperation extends OclMetainfoNamedTyped {

    public OclMetainfoOperation(String contextType, String type, String name, Method method) {
        super(type, name);
        myContextType = contextType;
        myMethod = method;
    }
    
    public List<String> getParameterTypes() {
        if (myParameters == null) {
            myParameters = new ArrayList<String>();
        }
        return myParameters;
    }
    
    public String getContextType() {
        return myContextType;
    }
    
    public Method getMethod() {
        return myMethod;
    }
    
    private List<String> myParameters;
    private final String myContextType;
    private final Method myMethod;
}
