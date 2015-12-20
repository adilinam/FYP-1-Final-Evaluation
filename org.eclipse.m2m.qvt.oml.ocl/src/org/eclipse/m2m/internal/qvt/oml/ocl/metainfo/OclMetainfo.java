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

import java.util.ArrayList;
import java.util.List;

public class OclMetainfo {

    /**
     * @param loader - null for no loader
     */
    public OclMetainfo(LazyLoader loader) {
        myLazyLoader = loader;
    }
    
    public List<OclMetainfoOperation> getOperations() {
        if (myOperations == null) {
            myOperations = new ArrayList<OclMetainfoOperation>();
            if (myLazyLoader != null) {
                myLazyLoader.loadOperations(myOperations);
            }
        }
        return myOperations;
    }
    
    protected abstract class Visitor {        
        public abstract void visit(OclMetainfo node);       
    }
    
    public interface LazyLoader {
        void loadOperations(List<OclMetainfoOperation> operations);
    }
    
    private List<OclMetainfoOperation> myOperations;
    private final LazyLoader myLazyLoader;
}
