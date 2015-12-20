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
package org.eclipse.m2m.tests.qvt.oml;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.m2m.internal.qvt.oml.samples.ui.SampleProject;
import org.eclipse.m2m.internal.qvt.oml.samples.ui.SampleProjectsCreationOperation;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import junit.framework.TestCase;


public class TestSamples extends TestCase {
	public TestSamples() {
	}
	
	@Override
	public void setUp() throws Exception {
	}
	
	@Override
	public void tearDown() throws Exception {
	}
	    
    public void testUml2Rdb() throws Exception {
        checkSample("org.eclipse.m2m.qvt.oml.samples.simpleuml2rdb", "samples/simpleuml2rdb.zip", OML_SAMPLES_PLUGIN); //$NON-NLS-1$ //$NON-NLS-2$
    }
        
	private void checkSample(String name, String archive, String hostPlugin) throws Exception {
        SampleProject project = new SampleProject(name, archive, hostPlugin);
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        SampleProjectsCreationOperation op = new SampleProjectsCreationOperation(project, shell);
        op.run(new NullProgressMonitor());
        
        IProject sampleProject = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
        assertNotNull("project not created", sampleProject); //$NON-NLS-1$
        TestUtil.buildProject(sampleProject);
	}

    private static final String OML_SAMPLES_PLUGIN = "org.eclipse.m2m.qvt.oml.samples";  //$NON-NLS-1$	
	
}
