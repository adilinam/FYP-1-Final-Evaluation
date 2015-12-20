/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.util.IContext;


public class FilesToFilesData extends ModelTestData {

	public FilesToFilesData(String name) {
        this(name, Collections.<String>emptyList(), Collections.<String>emptyList(), new String[][] {});
    }
    
	public FilesToFilesData(String name, List<String> fromFiles, List<String> expectedFiles) {
        this(name, fromFiles, expectedFiles, new String[][] {});
    }
    
    public FilesToFilesData(String name, List<String> fromFiles, List<String> expectedFiles, String[][] props) {
    	this(name, fromFiles, expectedFiles, makeFileContext(props));
    }
    
    public FilesToFilesData(String name, List<String> fromFiles, List<String> expectedFiles, IContext context) {
        super(name, context);
        myFromFiles = fromFiles;
        myExpectedFiles = expectedFiles;
    }
    
    @Override
	public List<URI> getIn(IProject project) { 
        List<URI> inUris = new ArrayList<URI>(myFromFiles.size());
        for (String inFile : myFromFiles) {
        	IPath filePath = project.getProject().getFullPath().append(MODEL_FOLDER).append(getName()).append(inFile);
        	inUris.add(URI.createPlatformResourceURI(filePath.toString(), true));
        }
        return inUris;
    }
    
    @Override
	public List<URI> getExpected(IProject project) {
        List<URI> outUris = new ArrayList<URI>(myExpectedFiles.size());
        for (String outFile : myExpectedFiles) {
        	IPath filePath = project.getProject().getFullPath().append(MODEL_FOLDER).append(getName()).append(outFile);
        	outUris.add(URI.createPlatformResourceURI(filePath.toString(), true));
        }
        return outUris; 
    }
    
    @Override
    public URI getTrace(IProject project) {
    	IPath filePath = project.getProject().getFullPath().append(MODEL_FOLDER).append(getName()).append(getName()).addFileExtension(MDAConstants.QVTO_TRACEFILE_EXTENSION);
    	return URI.createPlatformResourceURI(filePath.toString(), true);
    }
    
    public List<String> getFromFiles() {
		return myFromFiles;
	}
    
    public List<String> getExpectedFiles() {
		return myExpectedFiles;
	}
        
    private final List<String> myFromFiles;
    private final List<String> myExpectedFiles;
}
