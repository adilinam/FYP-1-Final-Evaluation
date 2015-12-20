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
 *     Christopher Gerking - bug 431082
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IDocument;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitContents;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.project.builder.QVTOBuilderConfig;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * @author vrepeshko
 */
public class QvtCompilerFacade {
	
	private QvtCompilerFacade() {}
	
	public CompiledUnit compile(final ITextEditor editor, final IDocument document, 
			QvtCompilerOptions options, IProgressMonitor monitor) {
		if (!checkEditor(editor)) {
			return null;
		}
		
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
        monitor.beginTask(Messages.QvtCompilerFacade_compilingDoc, 4);
        CompiledUnit result = null;
		
		try {
			monitor.subTask(Messages.QvtCompilerFacade_acquiringDoc);
			IFile file = ((FileEditorInput) editor.getEditorInput()).getFile();
			QvtDocumentProvider documentProvider = (QvtDocumentProvider) editor.getDocumentProvider();
			
			monitor.worked(1);

			final String contents = document.get();			
			try {
				UnitProxy unit = UnitResolverFactory.Registry.INSTANCE.getUnit(URIUtils.getResourceURI(file));
				UnitResolver unitResolver = unit.getResolver();
				final UnitProxy inMemoryUnit = new InMemoryUnitProxy(unit.getNamespace(), unit.getName(), unit.getURI(), contents, unitResolver);
				
				QVTOCompiler compiler = CompilerUtils.createCompiler();				
                result = compiler.compile(inMemoryUnit, options, CompilerUtils.createMonitor(BasicMonitor.toMonitor(monitor), 3));
                
                if (result != null) {
                    documentProvider.setMappingModule(result);
                }
            } catch (MdaException e) {
                documentProvider.setMappingModule(result);
                Activator.log(e);
            }
            
            if (options.isReportErrors() && options.isShowAnnotations()) {
            	//reportProblems(result, editor.getAnnotationModel());
            }
        } finally {
            monitor.done();
        }
        return result;
	}	
	
	public static QvtCompilerFacade getInstance() {
		if (ourInstance == null) {
			ourInstance = new QvtCompilerFacade();
		}
		return ourInstance;
	}
	
	private boolean checkEditor(final ITextEditor editor) {
		return editor != null 
			&& editor.getEditorInput() instanceof FileEditorInput
			&& editor.getDocumentProvider() != null;
	}
	
	static boolean isEditingInQvtSourceContainer(ITextEditor editor) {
		IEditorInput editorInput = editor.getEditorInput();
		if(editorInput instanceof IFileEditorInput == false) {
			return false;
		}

		IFile file = ((FileEditorInput) editorInput).getFile();
		if(file != null && file.exists()) {
			try {
				IContainer srcContainer = QVTOBuilderConfig.getConfig(file.getProject()).getSourceContainer();
				if(srcContainer.exists()) {
					IPath editedPath = file.getFullPath();
					IPath srcPath = srcContainer.getFullPath();
					return srcPath.isPrefixOf(editedPath);
				}
			} catch (CoreException e) {
				QvtPlugin.getDefault().log(e.getStatus());
			}
		}
		return false;
	}
	
	private static QvtCompilerFacade ourInstance;
	
	
	static class InMemoryUnitProxy extends UnitProxy {
		
		public InMemoryUnitProxy(String namespace, String unitName, URI uri,
				String fContents, UnitResolver fMyResolver) {
			super(namespace, unitName, uri);
			this.fContents = fContents;
			this.fMyResolver = fMyResolver;
		}

		private final String fContents;
		private final UnitResolver fMyResolver; 
		
		@Override
		public UnitContents getContents() throws IOException {
			return new UnitContents.CSTContents() {				
				public Reader getContents() throws IOException {
					return new StringReader(fContents);
				}
			};			
		}

		@Override
		public int getContentType() {
			return UnitProxy.TYPE_CST_STREAM;
		}

		@Override
		public UnitResolver getResolver() {
			return fMyResolver;
		}
	}
}
