/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.util;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.m2m.tests.qvt.oml.AllTests;

public class CustomEmfResourceFactory implements Resource.Factory {
	
    public static final String SCHEME = "custom_scheme"; //$NON-NLS-1$
    public static final String EMPTY_MODEL = "empty"; //$NON-NLS-1$
    public static final String NON_EMPTY_MODEL = "nonEmpty"; //$NON-NLS-1$
    public static final String INVALID_MODEL = "invalid"; //$NON-NLS-1$
	
    public Resource createResource(URI uri) {
    	CustomEmfResource resource = new CustomEmfResource(uri);
        return resource;
    }

    public static URI createUri(String modelName) {
    	return URI.createURI(SCHEME + ":/" + AllTests.BUNDLE_ID + '_' + modelName); //$NON-NLS-1$
    }

    
    private static class CustomEmfResource extends ResourceImpl {
    	
        public CustomEmfResource(URI uri) {
        	this.uri = uri;
            if (!SCHEME.equals(uri.scheme())) {
                throw new IllegalArgumentException("Invalid scheme: " + uri.scheme()); //$NON-NLS-1$
            }
        }
        
        public void load(Map<?, ?> options) throws IOException {
            if (!isLoaded) {
            	try {
    	            isLoading = true;
    	            
    	            if (('/' + AllTests.BUNDLE_ID + '_' + EMPTY_MODEL).equals(getURI().devicePath())) {
    	            }
    	            else if (('/' + AllTests.BUNDLE_ID + '_' + NON_EMPTY_MODEL).equals(getURI().devicePath())) {
    	            	getContents().add(EcoreFactory.eINSTANCE.createEPackage());
    	            }
    	            else {
    	            	// invalid case
    	            	throw new IOException("Failed to load resource"); //$NON-NLS-1$
    	            }
            	}
            	finally {
    	            isLoaded = true;
    	       		isLoading = false;
            	}
            }
        }
        
    }
    
}
