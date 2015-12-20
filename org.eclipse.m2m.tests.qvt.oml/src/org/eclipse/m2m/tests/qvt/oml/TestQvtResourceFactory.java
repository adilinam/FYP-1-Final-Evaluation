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

package org.eclipse.m2m.tests.qvt.oml;

import java.util.Collections;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.tests.qvt.oml.transform.FileToFileData;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.transform.TestTransformation;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author sboyko
 *
 */
public class TestQvtResourceFactory extends TestTransformation {

	public static Test suite() {
        TestSuite suite = new TestSuite("QVTO EMF Resource"); //$NON-NLS-1$
        
        suite.addTest(new TestQvtResourceFactory("abstractresult") {  //$NON-NLS-1$

        	@Override
        	protected void runTest() throws Throwable {
				IPath filePath = getProject().getFullPath().append(ModelTestData.MODEL_FOLDER).append(getName())
						.append(getName() + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT);
        		checkResourceByUri(URI.createPlatformResourceURI(filePath.toString(), true));
        	}
        	
        });
        
        suite.addTest(new TestQvtResourceFactory("abstractresult") {  //$NON-NLS-1$

        	@Override
        	protected void runTest() throws Throwable {
        		String testFile = "org.eclipse.m2m.tests.qvt.oml/parserTestData/models/" + getName() + "/"  //$NON-NLS-1$ //$NON-NLS-2$
        				+ getName() + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT; 
        		checkResourceByUri(URI.createPlatformPluginURI(testFile, false));
        	}
        	
        });
        
        suite.addTest(new TestQvtResourceFactory("errorinexpressionlist") {  //$NON-NLS-1$

        	@Override
        	protected void runTest() throws Throwable {
				IPath filePath = getProject().getFullPath().append(ModelTestData.MODEL_FOLDER).append(getName())
						.append(getName() + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT);
        		checkResourceByUri(URI.createPlatformResourceURI(filePath.toString(), true));
        	}
        	
        });
        
        return suite;
    }

    public TestQvtResourceFactory(String dataName) {
		super(new FileToFileData(dataName));
	}
    
	private static void checkResourceByUri(URI scriptUri) throws Exception {
		Resource resource = Resource.Factory.Registry.INSTANCE.getFactory(scriptUri).createResource(scriptUri);
		resource.load(Collections.emptyMap());
		assertTrue(resource.getContents().get(0) instanceof Module);
	}
	
}
