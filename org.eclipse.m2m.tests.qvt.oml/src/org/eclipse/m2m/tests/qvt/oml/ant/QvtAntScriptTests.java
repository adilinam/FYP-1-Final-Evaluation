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
package org.eclipse.m2m.tests.qvt.oml.ant;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.m2m.tests.qvt.oml.AllTests;
import org.eclipse.m2m.tests.qvt.oml.transform.FilesToFilesData;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author sboyko
 */
public class QvtAntScriptTests {
	public static Test suite() {
		return interpreterSuite();
	}
	
    public static TestSuite interpreterSuite() {
    	TestSuite suite = new TestSuite("QVT interpreter from Ant"); //$NON-NLS-1$

    	ModelTestData[] datas = createTestData();
    	
    	for (ModelTestData data : datas) {
            suite.addTest(new TestQvtAntScript(data));
        }

        return suite;
    }
    
    public static ModelTestData[] createTestData() {
    	return new ModelTestData[] {
    	new AntModelTestData("simple", Collections.<String>emptyList(), Arrays.asList("expected.ecore")), //$NON-NLS-1$ //$NON-NLS-2$
    	new AntModelTestData("twomodels", Collections.<String>emptyList(), Arrays.asList("expected.rdb")), //$NON-NLS-1$ //$NON-NLS-2$
    	new AntModelTestData("twomodels_new", Collections.<String>emptyList(), Arrays.asList("expected.rdb")), //$NON-NLS-1$ //$NON-NLS-2$
    	};
    }
    
    private static class AntModelTestData extends FilesToFilesData {
    	public AntModelTestData(String name, List<String> fromFiles, List<String> expectedFiles) {
            super(name, fromFiles, expectedFiles);
        }

        @Override
		protected File getDestFolder(IProject project) {
            try {
                return AntModelTestData.getDestFolder(getName(), project);
            }
            catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
        
        private static File getDestFolder(String name, IProject project) throws IOException {
            File srcRootFolder = TestUtil.getPluginRelativeFile(AllTests.BUNDLE_ID, TestQvtAntScript.ROOT_DIR_NAME);
            File srcFolder = AntModelTestData.getFolder(srcRootFolder, name);
            File destFolder = AntModelTestData.getFolder(new File(project.getLocation().toString() + "/models/"), srcFolder.getName()); //$NON-NLS-1$
            return destFolder;
        }
        
        private static File getFolder(File folder, final String expectedName) {
            File dir = new File(folder, expectedName);
            if(!dir.exists() || !dir.isDirectory()) {
                throw new IllegalArgumentException("Invalid directory: " + dir); //$NON-NLS-1$
            }
            
            return dir;
        }
    }
}
