/*******************************************************************************
 * Copyright (c) 2013 S.Boyko and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     S.Boyko - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.tests.qvt.oml.ui.completion;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.internal.qvt.oml.project.QVTOProjectPlugin;
import org.eclipse.m2m.tests.qvt.oml.TestProject;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

/**
 * @author sboyko
 */
public class DetachedCompletionTest extends CompletionTest {

	public DetachedCompletionTest(String folder) {
		super(folder);
	}
	
	@Override
	protected void setUp() throws Exception {
        myTestProject = null;
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
        myTestProject.getProject().close(null);
	}

	protected void initializeProject() throws Exception {
		myTestProject = new TestProject("CompletionTest", new String[] {QVTOProjectPlugin.NATURE_ID}); //$NON-NLS-1$
        File srcFolder = TestUtil.getPluginRelativeFile(BUNDLE, ICompletionTestConstants.COMPLETION_TEST_FOLDER
                + "/" + myFolder); //$NON-NLS-1$
        FileUtil.copyFolder(srcFolder, myTestProject.getQVTSourceContainer().getLocation().toFile());
		myTestProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
	}
	
	@Override
	protected IContainer getTransfromationContainer() throws CoreException {
		return myTestProject.getQVTSourceContainer();
	}
	
}
