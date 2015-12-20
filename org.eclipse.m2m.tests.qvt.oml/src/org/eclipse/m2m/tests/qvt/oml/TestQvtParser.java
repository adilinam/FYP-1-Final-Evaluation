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
package org.eclipse.m2m.tests.qvt.oml;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.project.builder.WorkspaceUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.tests.qvt.oml.ParserTests.TestData;
import org.eclipse.m2m.tests.qvt.oml.util.ProblemSourceAnnotationHelper;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

import junit.framework.TestCase;

/**
 * @author pkobiakov
 */
public class TestQvtParser extends TestCase {
	
	public TestQvtParser(String testName) {
		this(ParserTests.getTestData(testName));
	}
	
	public TestQvtParser(TestData data) {
        super(data.getDir());
        myData = data;        
    }
	
	protected CompiledUnit[] getCompiledResults() {
		return myCompiled;
	}
	    
	@Override
	public void setUp() throws Exception {
		TestUtil.turnOffAutoBuilding();		
		
		String name = "ParserTest"; //$NON-NLS-1$
        myProject = TestProject.getExistingProject(name);
        if(myProject == null) {
            myProject = new TestProject(name, new String[] {}, 0); 
        }
	}
	
	@Override
	public void tearDown() throws Exception {
		myCompiled = null;
        File destinationFolder = getDestinationFolder();
        if (destinationFolder.exists()) {
            FileUtil.delete(destinationFolder);
        }		
	}
	    
    public TestProject getTestProject() {
        return myProject;
    }
    
	@Override
	public void runTest() throws Exception {
		copyData("sources/" + myData.getDir(), "parserTestData/sources/" + myData.getDir()); //$NON-NLS-1$ //$NON-NLS-2$
		
        File folder = getDestinationFolder(); //$NON-NLS-1$
		assertTrue("Invalid folder " + folder, folder.exists() && folder.isDirectory()); //$NON-NLS-1$
		
		//System.err.println("testParsing: " + folder.getName()); //$NON-NLS-1$
		myCompiled = compile(folder);
		
		assertTrue("No results", myCompiled.length > 0); //$NON-NLS-1$
		
		boolean collectOnlyCSTProblems = myData.usesSourceAnnotations();
		
		List<QvtMessage> allErrors = getAllErrors(myCompiled, collectOnlyCSTProblems);
		assertEquals("Wrong error count for '" + folder.getName() + "', error(s)=" + allErrors, myData.getErrCount(), allErrors.size()); //$NON-NLS-1$ //$NON-NLS-2$
		if (myData.getWarnCount() != -1) {
			List<QvtMessage> allWarnings = getAllWarnings(myCompiled, collectOnlyCSTProblems);
			assertEquals("Wrong warning count for '" + folder.getName() + "', warning(s)=" + allWarnings, myData.getWarnCount(), allWarnings.size()); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		// check the AST is consistent
		for (CompiledUnit compilationResult : myCompiled) {
			if(compilationResult.getErrors().size() == 0) {
				TestUtil.assertAllPersistableAST(compilationResult);
			}
		}		
		//		
		
		if(myData.usesSourceAnnotations()) {
			Set<ProblemSourceAnnotationHelper> helpers = new HashSet<ProblemSourceAnnotationHelper>();	
			for (CompiledUnit compilationResult : myCompiled) {
				doCompiledUnitCheck(compilationResult, helpers);
			}

			// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=458233
			//
			// int expectedProblemCount = myData.getAllProblemsCount();
			// int foundProblemCount = 0;				
			// for (ProblemSourceAnnotationHelper nextHelper : helpers) {
			// 		foundProblemCount += nextHelper.getProblemsMap().size();
			// }
			// 
			// if (expectedProblemCount >= 0) {
			// 		TestCase.assertEquals(expectedProblemCount, foundProblemCount);
			// }			
		}
	}

	protected File getDestinationFolder() {
		return new File(myProject.getProject().getLocation().toString() + "/sources/" + myData.getDir());
	}
	
	private void doCompiledUnitCheck(CompiledUnit module, Set<ProblemSourceAnnotationHelper> annotationCollector) {
		if(!MDAConstants.QVTO_FILE_EXTENSION.equals(module.getURI().fileExtension())) {
			// check only .qvto file as these have CST stream
			return;
		}
		
		ProblemSourceAnnotationHelper helper = ProblemSourceAnnotationHelper
				.assertCompilationProblemMatchExpectedAnnotations(module);
		annotationCollector.add(helper);
		for (CompiledUnit importedModule : module.getCompiledImports()) {
			if (!annotationCollector.contains(importedModule)) {
				doCompiledUnitCheck(importedModule, annotationCollector);
			}
		}
	}
	
    static class CompositeException extends Exception {
		private static final long serialVersionUID = -1045874581781288741L;

		public CompositeException(String message, List<Throwable> exceptions) {
            super(message);
            myExceptions = exceptions;
        }
        
        @Override
		public String toString() {
            StringBuffer s = new StringBuffer();
            s.append(super.toString());
            for(Throwable t : myExceptions) {
                StringWriter trace = new StringWriter();
                t.printStackTrace(new PrintWriter(trace));
                s.append("\n" + trace.toString()); //$NON-NLS-1$
            }
            
            return s.toString();
        }
        
        private final List<Throwable> myExceptions;
    }
    
    private List<QvtMessage> getAllErrors(CompiledUnit[] compiled, boolean concreteSyntaxOnly) {
        List<QvtMessage> errors = new ArrayList<QvtMessage>();
        for (CompiledUnit compilationResult : compiled) {        	
            TransformationUtil.getErrors(compilationResult, errors, concreteSyntaxOnly);
        }

        return errors;
    }
    
    private List<QvtMessage> getAllWarnings(CompiledUnit[] compiled, boolean concreteSyntaxOnly) {
        List<QvtMessage> warnings = new ArrayList<QvtMessage>();
        for (CompiledUnit compilationResult : compiled) {
            TransformationUtil.getWarnings(compilationResult, warnings, concreteSyntaxOnly);
        }

        return warnings;
    }
    
	private CompiledUnit[] compile(File folder) throws Exception {
		final String topName = folder.getName() + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT;
		getFile(folder, topName);
		WorkspaceUnitResolver resolver = new WorkspaceUnitResolver(Collections.singletonList(getIFolder(folder)));
		QVTOCompiler compiler = CompilerUtils.createCompiler();
		
        QvtCompilerOptions options = new QvtCompilerOptions();
        options.setGenerateCompletionData(false);
        
        UnitProxy unit = resolver.resolveUnit(folder.getName());
		return new CompiledUnit[] { compiler.compile(unit, options, new BasicMonitor()) };
	}
	
	private static File getFile(File folder, final String expectedName) {
		File file = new File(folder, expectedName);
        assertTrue("Invalid file: " + file, file.exists() && file.isFile()); //$NON-NLS-1$
        return file;
	}
    
	private IContainer getIFolder(File folderUnderWorkspace) throws MalformedURLException, URISyntaxException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath location = new Path(folderUnderWorkspace.getAbsolutePath());
		IContainer[] containers = workspace.getRoot().findContainersForLocationURI(URIUtil.toURI(location.makeAbsolute().toFile().toURI().toURL()));
		if(containers == null || containers.length != 1 || containers[0] instanceof IFolder == false) {
			throw new RuntimeException("Folder not found: " + folderUnderWorkspace); //$NON-NLS-1$
		}
		
		return (IFolder)containers[0];
	}
	
	private void copyData(String destPath, String srcPath) throws Exception {
		File sourceFolder = TestUtil.getPluginRelativeFolder(srcPath);
		File destFolder = new File(myProject.getProject().getLocation().toString() + "/" + destPath); //$NON-NLS-1$
		destFolder.mkdirs();
		FileUtil.copyFolder(sourceFolder, destFolder);
		myProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
	}	
	
    private final TestData myData;
	private TestProject myProject;
	private CompiledUnit[] myCompiled;
}
