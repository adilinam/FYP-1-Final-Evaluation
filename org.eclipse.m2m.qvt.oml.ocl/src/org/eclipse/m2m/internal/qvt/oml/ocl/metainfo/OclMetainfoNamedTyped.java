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

public class OclMetainfoNamedTyped extends OclMetainfoNamed {

    public OclMetainfoNamedTyped(String type, String name) {
        super(name);
        myType = type;
    }
    
    public String getType() {
        return myType;
    }    
    
    private final String myType;
}
