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

import java.io.ByteArrayInputStream;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.ecore.Generator;

/**
 * This strategy is copied from GMF project unittest (www.eclipse.org/gmf)
 * 
 * ALMOST TRUE: With PDE, we need source code in the running workspace to allow compilation of our code 
 * (because PDE doesn't reexport set of plugins from it's running configuration, and it's no longer possible 
 * to set Target Platform to "same as running" as it was back in Eclipse 2.x).
 * 
 * !!! NEW !!!
 * 
 * Now, we managed to compile against linked binary folders, although using linked content instead of plugins 
 * requires us to explicitly add some plugins earlier available through plugin re-export (namely, oe.jface.text) 
 *  
 * 
 * Classloading works because there's -dev argument in the command line. With PDE launch, it's done by PDE.
 * Without PDE, running tests as part of the build relies on Eclipse Testing Framework's org.eclipse.test_3.1.0/library.xml
 * which specifies "-dev bin,runtime". Once it's not specified, or new format (properties file with plugin-id=binfolder) 
 * is in use, classloading of the generated code will fail and another mechanism should be invented then.
 * 
 * If you get ClassNotFoundException while running tests in PDE environment, try to set read-only attribute for the next file:
 * 'development-workspace'\.metadata\.plugins\org.eclipse.pde.core\'JUnitLaunchConfigName'\dev.properties
 * @author artem
 */
public class RuntimeWorkspaceSetup {
	private static RuntimeWorkspaceSetup INSTANCE;
	
	private boolean isDevLaunchMode;

	private RuntimeWorkspaceSetup() {
		isDevLaunchMode = isDevLaunchMode();
	}

	public static RuntimeWorkspaceSetup getInstance() {
		if(INSTANCE == null) {
			try {
				INSTANCE = new RuntimeWorkspaceSetup();
				INSTANCE.initFull();
			} catch (Exception e) {
				throw new RuntimeException("Runtime Unittest workspace error", e); //$NON-NLS-1$
			}
		}
		return INSTANCE;
	}
	
	public boolean getIsDevLaunchMode() {
		return isDevLaunchMode;
	}
	
	/**
	 * Copy (almost, except for strange unused assignment) of <code>PDECore.isDevLaunchMode()</code>
	 */
	private static boolean isDevLaunchMode() {
		String[] args = Platform.getApplicationArgs();
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-pdelaunch")) { //$NON-NLS-1$
				return true;
			}
		}
		return false;
	}

	private RuntimeWorkspaceSetup initFull() throws Exception {
		init(new String[] { 
			"org.eclipse.emf.ecore", //$NON-NLS-1$
			"org.eclipse.emf.common", //$NON-NLS-1$
			"org.eclipse.m2m.qvt.oml", //$NON-NLS-1$ 
			"org.eclipse.m2m.qvt.oml.samples", //$NON-NLS-1$			
			"org.eclipse.m2m.qvt.oml.ocl", //$NON-NLS-1$                
			AllTests.BUNDLE_ID,

		});
		return this;
	}

	private void init(String... pluginsToImport) throws Exception {
		if (isDevLaunchMode) {
			// Need to get some gmf source code into target workspace 
			importDevPluginsIntoRunTimeWorkspace(pluginsToImport);
		}
	}

	public static IProject getSOSProject() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(".SOSProject"); //$NON-NLS-1$
	}

	/**
	 * Another approach - output binary folders of required plugins are linked as subfolders 
	 * of our own sosProject (created in the target workspace). Then, we could use library classpathEntries
	 * (details why we should use _workspace_ paths for libraries could be found at 
	 * <code>org.eclipse.jdt.internal.core.builder.NameEnvironment#computeClasspathLocations</code>)
	 *  
	 * TODO don't assume workspace is clear, check sosProject existence first
	 * TODO utilize GenDiagram.requiredPluginIDs once it's a field (i.e. add oe.jface.text and don't create plugin project then, just plain project with links
	 */
	private void importDevPluginsIntoRunTimeWorkspace(String[] pluginIDs) throws CoreException {
		IProject p = getSOSProject();
		final Path srcPath = new Path('/' + p.getName() + "/src"); //$NON-NLS-1$
		Generator.createEMFProject(srcPath, null, Collections.<IProject>emptyList(), new NullProgressMonitor(), Generator.EMF_PLUGIN_PROJECT_STYLE, null);
		
		StringBuffer pluginXmlContent = new StringBuffer();
		pluginXmlContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<?eclipse version=\"3.0\"?>\n<plugin "); //$NON-NLS-1$
		pluginXmlContent.append(" version=\"1.0.0\" name='%providerName' id='"); //$NON-NLS-1$
		pluginXmlContent.append(p.getName());
		pluginXmlContent.append("'>\n<requires>\n"); //$NON-NLS-1$
		pluginXmlContent.append("<import plugin='org.eclipse.jface.text' export='true'/>\n"); //$NON-NLS-1$
		pluginXmlContent.append("<import plugin='org.eclipse.ui.views.properties.tabbed' export='true'/>\n"); //$NON-NLS-1$

		pluginXmlContent.append("</requires>\n</plugin>"); //$NON-NLS-1$
		p.getFile("plugin.xml").create(new ByteArrayInputStream(pluginXmlContent.toString().getBytes()), true, new NullProgressMonitor()); //$NON-NLS-1$
	}
}