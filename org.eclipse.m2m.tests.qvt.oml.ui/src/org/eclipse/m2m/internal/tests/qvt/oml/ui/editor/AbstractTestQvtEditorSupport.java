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
package org.eclipse.m2m.internal.tests.qvt.oml.ui.editor;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtDocumentProvider;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.internal.qvt.oml.project.QVTOProjectPlugin;
import org.eclipse.m2m.internal.qvt.oml.project.builder.QVTOBuilderConfig;
import org.eclipse.m2m.tests.qvt.oml.AllTests;
import org.eclipse.m2m.tests.qvt.oml.TestProject;
import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;
import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader.AnnotationData;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

public abstract class AbstractTestQvtEditorSupport extends TestCase {

	protected String fTestFolder;
	protected QvtEditor fEditor;
	protected IContainer fSrcContainer;
	protected TestProject fTestProject;
	protected Map<IFile, List<AnnotationData>> fAnnotationMap;

	public AbstractTestQvtEditorSupport(String name) {
		super(name);
		fTestFolder = name;
	}
	
	protected static String getSourceContents(ITextEditor editor) {
		return editor.getDocumentProvider().getDocument(editor.getEditorInput()).get();
	}
	
	protected List<AnnotationData> readSourceAnnotations(ITextEditor editor) {
		assertTrue("QVT Editor instance expected", editor instanceof QvtEditor); //$NON-NLS-1$
		QvtEditor qvtEditor = (QvtEditor) editor;
		
		IFile file = getSourceFile(qvtEditor);
		return fAnnotationMap.get(file);
		
		//return new SourceAnnotationReader(qvtEditor.getEditorSourceViewer().getDocument().get()).getAnnotations();		
	}
	
	protected static QvtDocumentProvider getQVTDocumentProvider(ITextEditor editor) {
		assertTrue("QVT Editor instance expected", editor instanceof QvtEditor); //$NON-NLS-1$
		assertTrue("Requires QVT document provider", editor.getDocumentProvider() instanceof QvtDocumentProvider); //$NON-NLS-1$
		return (QvtDocumentProvider) editor.getDocumentProvider();
	}
	
	protected static QvtEditor openInEditor(IFile transformationFile) {
		QvtEditor editor = null;
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		try {
			ITextEditor textEditor = (QvtEditor) IDE.openEditor(page, transformationFile);
			assertTrue("QVT Editor instance expected", textEditor instanceof QvtEditor); //$NON-NLS-1$
			editor = (QvtEditor) textEditor;
			
			final int WAIT_FOR_RECONCILE = 15000;
			editor.forceReconciling();
			CompiledUnit compiledModule = editor.getValidCompiledModule(WAIT_FOR_RECONCILE);
			
			assertNotNull("Failed to aquire AST model in QVT Editor", compiledModule); //$NON-NLS-1$
			
		} catch (PartInitException e) {
			fail("Failed to open QVTEditor. " + e); //$NON-NLS-1$
		}
		return editor;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	
		Set<String> enabledActivityIds = PlatformUI.getWorkbench().getActivitySupport().getActivityManager().getEnabledActivityIds();
		Set<String> copyEnabledActivityIds = new HashSet<String>(enabledActivityIds);
		copyEnabledActivityIds.add("com.borland.qvto");  //$NON-NLS-1$
		PlatformUI.getWorkbench().getActivitySupport().setEnabledActivityIds(copyEnabledActivityIds);
		
		initializeProject();
		IFile sourceFile = (IFile)fSrcContainer.findMember(fTestFolder + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT);
		assertNotNull(sourceFile);
		fEditor = openInEditor(sourceFile);
		assertNotNull(fEditor);	
	}	
	
	protected void initializeProject() throws Exception {
		fTestProject = new TestProject("Editor", new String[] {QVTOProjectPlugin.NATURE_ID}); //$NON-NLS-1$
	
		File srcFolder = TestUtil.getPluginRelativeFile(AllTests.BUNDLE_ID, "parserTestData/editor/" + fTestFolder); //$NON-NLS-1$
	    fSrcContainer = QVTOBuilderConfig.getConfig(fTestProject.getProject()).getSourceContainer();
	    File destFolder = fSrcContainer.getLocation().toFile();
	    FileUtil.copyFolder(srcFolder, destFolder);
	    
	    fTestProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
	    processSourceAnnotations(destFolder);
	}
	
	protected IEditorPart getActiveEditor() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		return page.getActiveEditor();
	}
	
	private void processSourceAnnotations(File dest) throws Exception {
		fAnnotationMap = new HashMap<IFile, List<AnnotationData>>();
		
		IContainer[] containers = ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(dest.toURI());
		IContainer c = containers[0];
		IResource[] members = c.members();
		for (IResource resource : members) {
			if(resource.getType() == IResource.FILE && 
				MDAConstants.QVTO_FILE_EXTENSION.equals(resource.getFileExtension())) {
				IFile file = (IFile) resource;
				String contents = FileUtil.getStreamContents(file.getContents(), file.getCharset());
				
				SourceAnnotationReader annotationReader = new SourceAnnotationReader(contents);				

				String newContents  = annotationReader.getSource();				
				InputStream is = new ByteArrayInputStream(newContents.getBytes(file.getCharset()));
				file.setContents(is, true, false, null);
				
				fAnnotationMap.put(file, annotationReader.getAnnotations());
			}
		}
	}

	static IFile getSourceFile(QvtEditor editor) {
		FileEditorInput editorInput = (FileEditorInput)editor.getEditorInput();
		return editorInput.getFile();
	}
}