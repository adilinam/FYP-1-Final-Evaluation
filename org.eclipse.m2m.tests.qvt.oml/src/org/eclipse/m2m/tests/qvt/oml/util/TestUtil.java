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
package org.eclipse.m2m.tests.qvt.oml.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.internal.qvt.oml.compiler.BlackboxUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.tests.qvt.oml.AllTests;
import org.eclipse.m2m.tests.qvt.oml.RuntimeWorkspaceSetup;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.junit.Assert;
import org.osgi.framework.Bundle;

import junit.framework.TestCase;

/**
 * @author vrepeshko
 */
public class TestUtil extends Assert {
	
	private TestUtil() {}

	static Set<CompiledUnit> collectAllCompiledModules(CompiledUnit unit, Set<CompiledUnit> result) {
		result.add(unit);
		for (CompiledUnit imported : unit.getCompiledImports()) {
			collectAllCompiledModules(imported, result);
		}
		return result;
	}
	
	public static void assertPersistableAST(Module module, URI targetUri) {
		OutputStream os = null;
		try {
			os = new ExtensibleURIConverterImpl().createOutputStream(targetUri);
			module.eResource().save(os, Collections.emptyMap());
		} catch (Exception e) {
			TestCase.fail("Failed to serialize AST: " + e.getMessage()); //$NON-NLS-1$ 
		} finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void assertAllPersistableAST(CompiledUnit compiledModule) {
		Collection<CompiledUnit> all = collectAllCompiledModules(compiledModule, new HashSet<CompiledUnit>());
		
		HashMap<CompiledUnit, Resource> resourceMap = new HashMap<CompiledUnit, Resource>();
		for (CompiledUnit nextModule : all) {
			if(!BlackboxUnitResolver.isBlackboxUnitURI(nextModule.getURI())) {
				resourceMap.put(nextModule, confineInResource(nextModule));
			}
		}
		
		for (Map.Entry<CompiledUnit, Resource> nextUnit : resourceMap.entrySet()) {
			assertPersistableAST(nextUnit.getKey(), nextUnit.getValue());
		}
	}
	
	private static Resource confineInResource(CompiledUnit unit) {
		URI uri = unit.getURI().appendFileExtension("xmi"); //$NON-NLS-1$
		Resource res = null;
		for (Module nextModule : unit.getModules()) {
			if(res == null) {
				res = nextModule.eResource();
				res.setURI(uri);				
			}
			
			res.getContents().add(nextModule);
		}
		
		assertNotNull("A resource must be bound to AST Module: " + uri, res); //$NON-NLS-1$		

		return res;
	}
	
	private static Resource assertPersistableAST(CompiledUnit module, Resource res) {
		try {
			res.save(null);
		} catch (Exception e) {
			System.err.print(module.getURI());
			e.printStackTrace();							
			fail("Invalid module AST for serialization" + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertTrue(new ExtensibleURIConverterImpl().exists(res.getURI(), Collections.emptyMap()));
		
		return res;
	}
	
	public static Set<CompiledUnit> compileModules(String srcContainer, String[] modulePaths)  {
		TestModuleResolver testResolver = TestModuleResolver.createTestPluginResolver(srcContainer);
		
		QVTOCompiler compiler = CompilerUtils.createCompiler();				
		QvtCompilerOptions options = new QvtCompilerOptions();
		options.setGenerateCompletionData(true);
		
		
		UnitProxy[] sourceFiles = new UnitProxy[modulePaths.length];
		int pos = 0;
		for (String nextModulePath : modulePaths) {
			sourceFiles[pos] = testResolver.resolveUnit(nextModulePath);
			pos++;
		}
		
		CompiledUnit[] result;
		Set<CompiledUnit> modules;		
		try {
			result = compiler.compile(sourceFiles, options, null);
			modules = new LinkedHashSet<CompiledUnit>();
			for (CompiledUnit nextResult : result) {
				assertEquals(nextResult.getURI() + " must not have compilation error", //$NON-NLS-1$ 
						0, nextResult.getErrors().size()); //$NON-NLS-1$
				modules.add(nextResult);
			}
			
		} catch (MdaException e) {
			fail("Compilation errors: " + e.getMessage());
			return null; // never gets here			
		}

		return modules;
	}
		
	public static QVTOCompiler createTestPluginQvtCompiler(String sourceContainerPath) {
		return CompilerUtils.createCompiler();
	}
	
	public static void turnOffAutoBuilding() throws CoreException {
		IWorkspaceDescription workspaceDescription = ResourcesPlugin.getWorkspace().getDescription();
        workspaceDescription.setAutoBuilding(false);
        ResourcesPlugin.getWorkspace().setDescription(workspaceDescription);
	}
	
	public static void turnOnAutoBuilding() throws CoreException {
		IWorkspaceDescription workspaceDescription = ResourcesPlugin.getWorkspace().getDescription();
        workspaceDescription.setAutoBuilding(true);
        ResourcesPlugin.getWorkspace().setDescription(workspaceDescription);
	}	
	
	public static void copyFolder(final IProject project, final String folderName) throws Exception {
		File sourceFolder = getPluginRelativeFolder(folderName);
		File destFolder = new File(project.getLocation().toString());
		FileUtil.copyFolder(sourceFolder, destFolder);
//		System.out.println("source: " + sourceFolder.getAbsolutePath());
//		System.out.println("dest: " + destFolder.getAbsolutePath());
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
	}
	
	public static File getPluginRelativeFolder(final String folderName) throws IOException {
        return getPluginRelativeFile(AllTests.BUNDLE_ID, folderName);
	}
	
    public static File getPluginRelativeFile(String plugin, String folderName) throws IOException {
        Bundle bundle = Platform.getBundle(plugin);
        
        URL url = bundle.getEntry(folderName);
        if(url == null) {
            throw new RuntimeException("File " + folderName + " not found in " + plugin); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        File file = new File(FileLocator.toFileURL(url).getPath()).getCanonicalFile();
        return file;
    }
	
	public static void deleteJavaFiles(final IProject project) throws CoreException {
	    IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
	        public void run(IProgressMonitor monitor) throws CoreException {
                final List<IFile> filesToDelete = new ArrayList<IFile>();
                
	            project.accept(new IResourceVisitor() {
	                public boolean visit(final IResource resource) {
	                    if(resource.getType() == IResource.FILE) {
	                        String extension = resource.getFileExtension();
	                        if("java".equals(extension) || "class".equals(extension)) { //$NON-NLS-1$ //$NON-NLS-2$
	                            IFile file = (IFile) resource;
	                            filesToDelete.add(file);
	                        }
	                        return false;
	                    }
	                    return true;
	                }
	            });
                
                for (IFile file : filesToDelete) {
                    try {
                        file.delete(true, null);
                    }
                    catch(Exception e) {}
                }
	        }
	    };
	    
	    project.getWorkspace().run(runnable, null);
	}

	public static void buildProject(final IProject project) throws CoreException {
	    buildProject(project, IncrementalProjectBuilder.FULL_BUILD);
	}
    
    public static void buildProject(final IProject project, final int kind) throws CoreException {
		project.build(kind, null);
        List<String> errors = getBuildErrors(project);
        assertTrue("Build failed for " + project + ": " + errors, errors.isEmpty()); //$NON-NLS-1$ //$NON-NLS-2$
    }
	
	public static List<String> getBuildErrors(final IProject project) throws CoreException {
		IMarker[] markers = project.findMarkers(
//				IJavaModelMarker.JAVA_MODEL_PROBLEM_MARKER, false,
                IMarker.PROBLEM, true,
				IResource.DEPTH_INFINITE);
		List<String> errors = new ArrayList<String>();
		for(int i = 0; i < markers.length; i++) {
			IMarker marker = markers[i];
			if(RuntimeWorkspaceSetup.getInstance().getIsDevLaunchMode() &&
				"plugin.xml".equals(marker.getResource().getName()) && //$NON-NLS-1$ 
				marker.getResource().getParent() == project) {
				continue;
			}
			if(marker.getAttribute(IMarker.SEVERITY, 0) == IMarker.SEVERITY_ERROR) {
				String message = marker.getResource().getName() + 
					" " + marker.getAttribute(IMarker.LINE_NUMBER, "") +  //$NON-NLS-1$ //$NON-NLS-2$
					": " + marker.getAttribute(IMarker.MESSAGE, "") + //$NON-NLS-1$ //$NON-NLS-2$
					" " + marker.getAttribute(IMarker.LOCATION, "");  //$NON-NLS-1$ //$NON-NLS-2$
				errors.add(message);
				System.err.println(message);
			}
		}
		
		return errors;
	}
	
	public static void logQVTStackTrace(QvtRuntimeException e) {
		PrintWriter pw = new PrintWriter(System.err);
		pw.println("QVT stacktrace:"); //$NON-NLS-1$
		e.printQvtStackTrace(pw);
		pw.flush();
	}    

	public static void suppressGitPrefixPopUp() {				// Workaround BUG 390479
		try {
			Class<?> activatorClass = Class.forName("org.eclipse.egit.ui.Activator");
			try {
				Class<?> preferencesClass = Class.forName("org.eclipse.egit.ui.UIPreferences");
				Field field = preferencesClass.getField("SHOW_GIT_PREFIX_WARNING");
				String name = (String)field.get(null);
				Method getDefaultMethod = activatorClass.getMethod("getDefault");
				AbstractUIPlugin activator = (AbstractUIPlugin) getDefaultMethod.invoke(null);
				IPreferenceStore store = activator.getPreferenceStore();
				store.setValue(name, false);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (ClassNotFoundException e) {
		}
	}
}
