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
package org.eclipse.m2m.tests.qvt.oml.transform.api;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.tests.qvt.oml.AllTests;
import org.eclipse.m2m.tests.qvt.oml.TestProject;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

import junit.framework.TestCase;

/**
 * @author sboyko
 */
public class ApiTestCase extends TestCase {
	
	public static final String ROOT_DIR_NAME = "apiTestData"; //$NON-NLS-1$

    public ApiTestCase(ModelTestData data) {
        super(data.getName());
        myData = data;
    }
    
    public ApiTestCase(String testName) {
    	this(QvtoTransfHelperTests.getTestData(testName));
    }
    
	protected static String extractTestDataName(String testName, String prefix) {
		return testName.startsWith(prefix) ? testName.substring(prefix.length()) : testName; 
	}
	    
    @Override
	public void setUp() throws Exception {
        TestUtil.turnOffAutoBuilding();     
        
        String name = "ApiTestCase"; //$NON-NLS-1$
        myProject = TestProject.getExistingProject(name);
        if (myProject == null) {
            myProject = new TestProject(name, new String[] {}, 0); 
            myProject.getProject().setDefaultCharset(ModelTestData.ENCODING, null);
        }
        
        copyModelData(); 
    }
    
    @Override
	public void tearDown() throws Exception {
        //+myProject.delete();
    }
    
    protected ModelTestData getData() {
    	return myData;
    }
    
    protected IProject getProject() {
        return myProject.getProject();
    }
    
    private void copyModelData() throws Exception {
        File srcFolder = TestUtil.getPluginRelativeFile(AllTests.BUNDLE_ID, ROOT_DIR_NAME + "/" + myData.getName()); //$NON-NLS-1$
        File destFolder = getDestFolder();
        destFolder.mkdirs();
        FileUtil.copyFolder(srcFolder, destFolder);
        getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
    }

    protected IFile getIFile(String fileName) {
        File file = getDestFile(fileName);
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IPath location = new Path(file.getAbsolutePath());
        IFile ifile = workspace.getRoot().getFileForLocation(location);
        if(ifile == null) {
            throw new RuntimeException("File not found: " + file); //$NON-NLS-1$
        }
        
        return ifile;
    }

    private File getDestFolder() {
        return new File(getProject().getLocation().toString() + "/models/" + myData.getName()); //$NON-NLS-1$
    }
    
    private File getDestFile(final String expectedName) {
        File file = new File(getDestFolder(), expectedName);
        if(!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("No such file: " + file); //$NON-NLS-1$
        }
        
        return file;
    }
    
	private final ModelTestData myData;
    private TestProject myProject;    

}
