/*******************************************************************************
 * Copyright (c) 2008, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;

public class TestBlackboxLibrary {
	
	public Set<ENamedElement> legacyAsRenamedSet(Object object, String name) {
		if(object instanceof ENamedElement) {
			ENamedElement namedElement = (ENamedElement) object;
			namedElement.setName(name);
			return Collections.singleton(namedElement);			
		}
			
		return Collections.emptySet(); 
	}
	
	@Operation(contextual=true)
	public final Set<Object> legacyOclAnyAsSet(Object self) {
		return Collections.singleton(self);
	}
	
	
    /**
     * Metainfo for the native methods should be accessible through the static
     * methods of inner class <code>Metainfo</code> with the same signature
     * ant <code>String[]</code> return type. Returned array should contains
     * string representation of OCL classifiers:
     * 
     * array[0]     - Context classifier
     * array[n]     - Classifier corresponds to the n-th operation parameter 
     * array[n+1]   - Return type classifier
     */
    public static class Metainfo {

    	private static final String[] AS_RENAMED_SET = new String[] {
        	"oclstdlib::OclVoid", // Void context -> module owned (context-less) operation
                                  // imported library module is the implicit source object of the call
        	"oclstdlib::OclAny",  // your argument1
        	"oclstdlib::String",  // your argument2            
        	"Set(ecore::ENamedElement)"  // return type
        };

        private static final String[] OCLANY_AS_SET = new String[] {
        	"oclstdlib::OclAny",
            "Set(oclstdlib::OclAny)"
        };        
        
    	public static final String[] legacyAsRenamedSet(Object arg, String name) {
    		return AS_RENAMED_SET;
    	}
    	
    	public static final String[] legacyOclAnyAsSet(Object arg) {
    		return OCLANY_AS_SET;
    	}
    	
    }
}
