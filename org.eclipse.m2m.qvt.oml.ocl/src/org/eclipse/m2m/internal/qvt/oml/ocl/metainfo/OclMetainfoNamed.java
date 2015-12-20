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

public class OclMetainfoNamed {
    
    public OclMetainfoNamed(String name) {
        myName = name;
    }

    public String getName() {
        return myName;
    }
    
    @Override
    public int hashCode() {
        return myName.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OclMetainfoNamed == false) {
            return false;
        }
        OclMetainfoNamed other = (OclMetainfoNamed) obj;
        return getName().equals(other.getName());
    }

    protected final String myName;

}
