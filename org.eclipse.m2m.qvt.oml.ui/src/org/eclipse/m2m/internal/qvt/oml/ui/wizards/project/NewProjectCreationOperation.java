/*******************************************************************************
 * Copyright (c) 2009, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bugs 319078, 414662
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ui.wizards.project;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager;
import org.eclipse.m2m.internal.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

class NewProjectCreationOperation extends WorkspaceModifyOperation {

	private static final String BUNDLE_EXEC_ENV = "J2SE-1.5"; //$NON-NLS-1$

	private static final String BUILD_FILENAME_DESCRIPTOR = "build.properties"; //$NON-NLS-1$
	
	private static final IPath REQUIRED_PLUGINS_CONTAINER_PATH = new Path("org.eclipse.pde.core.requiredPlugins"); //$NON-NLS-1$
	
	private static final String PLUGIN_NATURE = "org.eclipse.pde.PluginNature"; //$NON-NLS-1$
	
		
	private static Map<String, Integer> fSeverityTable = null;		
	private static final int SEVERITY_ERROR = 3;	
	private static final int SEVERITY_WARNING = 2;	
	private static final int SEVERITY_IGNORE = 1;
	
	// instance fields
	private PluginClassCodeGenerator fGenerator;	
	
	private NewProjectData fData;
	
	private IProject fProjectHandle; 

	
	public NewProjectCreationOperation(IProject projectHandle, NewProjectData projectData) {
		if(projectHandle == null || projectData == null) {
			throw new IllegalArgumentException();
		}

		fData = projectData;
		fProjectHandle = projectHandle;
	}
	
	protected void createContents(IProgressMonitor monitor, IProject project) throws CoreException, InterruptedException {
	}
	
	private void createBuildProperties(IProject project, IProgressMonitor monitor) throws CoreException {
		IFile buildProperties = project.getFile(BUILD_FILENAME_DESCRIPTOR);
		StringWriter contents = new StringWriter();
		PrintWriter wr = new PrintWriter(contents, true);
		
		if(fData.isCreateJava()) {
			IPath sourceFolder = asBinIncludesFolder(createJavaFolder(fData.getSourceFolderName(), monitor));
			IPath outFolder = asBinIncludesFolder(createJavaFolder(fData.getOutFolderName(), monitor));

			wr.append("source.. = ").println(sourceFolder.toString()); //$NON-NLS-1$
			wr.append("output.. = ").println(outFolder.toString()); //$NON-NLS-1$
		}

		char[] alignChars = new char[15];
		Arrays.fill(alignChars, ' ');
		String indent = new String(alignChars);
		
		wr.print("bin.includes = META-INF/"); //$NON-NLS-1$
		if(fData.isCreateJava()) {
			wr.println(",\\"); //$NON-NLS-1$
			wr.append(indent).append('.');
		}

		IContainer qvtContainer = createJavaFolder(fData.getQVTSourceFolderName(), monitor);
		IPath qvtFolder = asBinIncludesFolder(qvtContainer);
		if(!fProjectHandle.equals(qvtContainer) || !fData.isCreateJava()) {
			wr.println(",\\"); //$NON-NLS-1$
			wr.append(indent).append(qvtFolder.toString());
		}

		wr.println();
		wr.flush();
		
		InputStream is = createContentStreamForNewFile(buildProperties, contents.getBuffer().toString());
		buildProperties.create(is, false, monitor);
	}

	private void createManifest(IFolder metaFolder, IProgressMonitor monitor) throws CoreException {
		IFile manifest = metaFolder.getFile("MANIFEST.MF"); //$NON-NLS-1$
		StringWriter contents = new StringWriter();
		PrintWriter wr = new PrintWriter(contents, true);

		wr.println("Manifest-Version: 1.0"); //$NON-NLS-1$
		wr.println("Bundle-ManifestVersion: 2"); //$NON-NLS-1$
		wr.append("Bundle-Name: ").println(fData.getName()); //$NON-NLS-1$
		wr.append("Bundle-SymbolicName: ").println(fData.getID()); //$NON-NLS-1$
		wr.append("Bundle-Version: ").println(fData.getVersion()); //$NON-NLS-1$
		wr.append("Bundle-Vendor: ").println(fData.getProviderName()); //$NON-NLS-1$

		IPluginReference[] dependencies = getDependencies();
		if (dependencies.length > 0) {
			wr.append("Require-Bundle:"); //$NON-NLS-1$

			int i = 0;
			for (IPluginReference pluginReference : dependencies) {
				if (i++ > 0) {
					wr.println(',');
				}
				wr.append(' ');
				wr.append(pluginReference.getId());
			}
			wr.println();
		}

		if (fData.isCreateJava() && getEEnv(BUNDLE_EXEC_ENV) != null) {
			wr.append("Bundle-RequiredExecutionEnvironment: ").println(BUNDLE_EXEC_ENV); //$NON-NLS-1$
		}

		wr.flush();

		InputStream is = createContentStreamForNewFile(manifest, contents.getBuffer().toString());
		manifest.create(is, false, monitor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.actions.WorkspaceModifyOperation#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		SubMonitor progress = SubMonitor.convert(monitor, Messages.NewProjectCreationOperation_createQVTProjectTask, 2);

		createProject(progress.newChild(1));
		createContents(progress.newChild(1), fProjectHandle);
		
		monitor.done();
	}


	private void generateTopLevelPluginClass(IProgressMonitor monitor) throws CoreException {
		fGenerator.generate(monitor);
		monitor.done();
	}

	private IPluginReference[] getDependencies() {
		if (fGenerator == null) {
			return new IPluginReference[0];
		}
		return fGenerator.getDependencies();
	}
	
	private void setupJava(IProject project, boolean pde, IProgressMonitor monitor) throws CoreException, JavaModelException {		
		addNatureToProject(project, JavaCore.NATURE_ID, monitor);
		
		IContainer srcContainer = createJavaFolder(fData.getSourceFolderName(), monitor);
		IContainer binContainer = createJavaFolder(fData.getOutFolderName(), monitor);

		IJavaProject javaProject = JavaCore.create(project);
		javaProject.setOutputLocation(binContainer.getFullPath(), monitor);
		
		monitor.subTask(Messages.NewProjectCreationOperation_SetClassPathTask);
		
		IClasspathEntry[] entries = new IClasspathEntry[pde ? 3 : 1];
		if (pde) {			
			String executionEnvironment = BUNDLE_EXEC_ENV;
			setComplianceOptions(javaProject, executionEnvironment, true);
			entries[0] = createJREEntry(executionEnvironment);
			entries[1] = createContainerEntry();
		}
		
		entries[entries.length - 1] = JavaCore.newSourceEntry(srcContainer.getFullPath());
		javaProject.setRawClasspath(entries, monitor);
		
		if(fData.isDoGenerateClass()) {
			generateTopLevelPluginClass(new SubProgressMonitor(monitor, 1));
		}

		monitor.worked(1);		
	}
	
	private void createProject(IProgressMonitor monitor) throws CoreException, JavaModelException {
        SubMonitor subMonitor = SubMonitor.convert(monitor, 7);
		
        URI location = URIUtil.toURI(fData.getLocation());

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(fProjectHandle.getName());
		if (location != null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(location)) {
			location = null;
		}
		description.setLocationURI(location); 
						
		if(!fProjectHandle.exists()) {
			fProjectHandle.create(description, subMonitor.newChild(1));
		}
		subMonitor.setWorkRemaining(6);

        if (subMonitor.isCanceled()) {
            throw new OperationCanceledException();
        }

        fProjectHandle.open(IResource.BACKGROUND_REFRESH, subMonitor.newChild(1));
        
        if (fData.isPlugin()) {
			addNatureToProject(fProjectHandle, PLUGIN_NATURE, subMonitor.newChild(1));
			
			fGenerator = new PluginClassCodeGenerator(fProjectHandle, fData);
			
			if(fData.isCreateJava()) {
				setupJava(fProjectHandle, true, subMonitor.newChild(1));
			}
			subMonitor.setWorkRemaining(3);
			
			// generate the manifest file
			IFolder metaFolder = fProjectHandle.getFolder("META-INF"); //$NON-NLS-1$
			metaFolder.create(true, true, subMonitor.newChild(1));

			createManifest(metaFolder, subMonitor.newChild(1));
			
			// generate the build.properties file
			createBuildProperties(fProjectHandle, subMonitor.newChild(1));

		} else if(fData.isCreateJava()) {
			subMonitor.setWorkRemaining(1);
			setupJava(fProjectHandle, false, subMonitor.newChild(1));
		}
	}

	private void addNatureToProject(IProject proj, String natureId, IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = proj.getDescription();
		String[] prevNatures = description.getNatureIds();
		String[] newNatures = new String[prevNatures.length + 1];
		System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
		newNatures[prevNatures.length] = natureId;
		description.setNatureIds(newNatures);
		proj.setDescription(description, monitor);
	}
	
	/**
	 * Returns a classpath container entry for the given execution environment.
	 * @param ee id of the execution environment
	 * @return classpath container entry
	 */
	private static IClasspathEntry createJREEntry(String ee) {
		return JavaCore.newContainerEntry(getEEPath(ee));
	}

	/**
	 * Returns the JRE container path for the execution environment with the given id.
	 * @param ee execution environment id
	 * @return JRE container path for the execution environment
	 */
	private static IPath getEEPath(String ee) {
		IPath path = null;
		if (ee != null) {
			IExecutionEnvironment env = getEEnv(ee);
			if (env != null)
				path = JavaRuntime.newJREContainerPath(env);
		}
		if (path == null) {
			path = JavaRuntime.newDefaultJREContainerPath();
		}
		return path;
	}
	
	private static IExecutionEnvironment getEEnv(String ee) {
		if (ee != null) {
			IExecutionEnvironmentsManager manager = JavaRuntime.getExecutionEnvironmentsManager();
			return manager.getEnvironment(ee);
		}		
		return null;
	}

	private static IClasspathEntry createContainerEntry() {
		return JavaCore.newContainerEntry(REQUIRED_PLUGINS_CONTAINER_PATH);
	}
	
	
	@SuppressWarnings("unchecked") 	
	private static void setComplianceOptions(IJavaProject project, String eeId, boolean overrideExisting) {
		Map<String, String> projectMap = project.getOptions(false);
		IExecutionEnvironment ee = null;
		Map<String, String> options = null;
		if (eeId != null) {
			ee = JavaRuntime.getExecutionEnvironmentsManager().getEnvironment(eeId);
			if (ee != null) {				
				options = ee.getComplianceOptions();
			}
		}
		if (options == null) {
			if (overrideExisting && projectMap.size() > 0) {
				projectMap.remove(JavaCore.COMPILER_COMPLIANCE);
				projectMap.remove(JavaCore.COMPILER_SOURCE);
				projectMap.remove(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM);
				projectMap.remove(JavaCore.COMPILER_PB_ASSERT_IDENTIFIER);
				projectMap.remove(JavaCore.COMPILER_PB_ENUM_IDENTIFIER);
			} else {
				return;
			}
		} else {
			String compliance = options.get(JavaCore.COMPILER_COMPLIANCE);
			Iterator<?> iterator = options.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<?, ?> entry = (Entry<?, ?>) iterator.next();
				String option = (String) entry.getKey();
				String value = (String) entry.getValue();
				if (JavaCore.VERSION_1_3.equals(compliance) || JavaCore.VERSION_1_4.equals(compliance)) {
					if (JavaCore.COMPILER_PB_ASSERT_IDENTIFIER.equals(option) || JavaCore.COMPILER_PB_ENUM_IDENTIFIER.equals(option)) {
						// for 1.3 & 1.4 projects, only override the existing setting if the default setting
						// is a greater severity than the existing setting
						setMinimumCompliance(projectMap, option, value, overrideExisting);
					} else {
						setCompliance(projectMap, option, value, overrideExisting);
					}
				} else {
					setCompliance(projectMap, option, value, overrideExisting);
				}
			}
		}

		project.setOptions(projectMap);
	}

	private static void setMinimumCompliance(Map<String, String> map, String key, String minimumValue, boolean override) {
		if (minimumValue != null && (override || !map.containsKey(key))) {
			if (fSeverityTable == null) {
				fSeverityTable = new HashMap<String, Integer>(3);
				fSeverityTable.put(JavaCore.IGNORE, new Integer(SEVERITY_IGNORE));
				fSeverityTable.put(JavaCore.WARNING, new Integer(SEVERITY_WARNING));
				fSeverityTable.put(JavaCore.ERROR, new Integer(SEVERITY_ERROR));
			}
			String currentValue = (String) map.get(key);
			int current = currentValue != null && fSeverityTable.containsKey(currentValue) ? ((Integer) fSeverityTable.get(currentValue)).intValue() : 0;
			int minimum = minimumValue != null && fSeverityTable.containsKey(minimumValue) ? ((Integer) fSeverityTable.get(minimumValue)).intValue() : 0;
			if (current < minimum) {
				map.put(key, minimumValue);
			}
		}
	}
	
	private static void setCompliance(Map<String, String> map, String key, String value, boolean override) {
		if (value != null && (override || !map.containsKey(key))) {
			map.put(key, value);
		}
	}
	
	private InputStream createContentStreamForNewFile(IFile fileHandle, String contents) {
		String charset = null;
		try {
			charset = fileHandle.getProject().getDefaultCharset();
		} catch (CoreException e) {
			QVTUIPlugin.log(e.getStatus());
		}

		if(charset == null) {
			charset = ResourcesPlugin.getEncoding();
		}

		byte[] bytes;
		try {
			bytes = contents.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			bytes = contents.getBytes();	
		}
		
		return new ByteArrayInputStream(bytes);
	}
	
	private IPath asBinIncludesFolder(IContainer container) {
		if(container.equals(fProjectHandle)) {
			return new Path("."); //$NON-NLS-1$
		}
		IPath result = container.getProjectRelativePath();   
		while(result.hasTrailingSeparator()) {
			result = result.removeTrailingSeparator();
		}
		// ensure single trailing slash
		return result.addTrailingSeparator(); 
	}
	
	private IContainer createJavaFolder(String folderName, IProgressMonitor monitor) throws CoreException {
		if(folderName == null || folderName.trim().length() == 0) {
			return fProjectHandle;			
		}
		
		IFolder folder = fProjectHandle.getFolder(folderName);
		if(!folder.exists()) {
			folder.create(true, true, monitor);
		}
		return folder;
	}	
}
