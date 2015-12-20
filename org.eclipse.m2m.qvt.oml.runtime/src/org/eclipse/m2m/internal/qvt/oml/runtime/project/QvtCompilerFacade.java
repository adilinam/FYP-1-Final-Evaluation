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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;

public class QvtCompilerFacade {
	
	public static interface CompilationResult {
		
		QVTOCompiler getCompiler();
		
		CompiledUnit getCompiledModule();
	}
	
	private QvtCompilerFacade() {
	}

	public static CompilationResult getCompiledModule(URI uriTransf, QvtCompilerOptions compilerOptions, IProgressMonitor monitor) throws MdaException {
		// FIXME - why is that relied on being it an IFile?
		IFile ifile = WorkspaceUtils.getWorkspaceFile(uriTransf);
		return getCompiledModule(ifile, compilerOptions, monitor);
	}
	
	static CompilationResult getCompiledModule(IFile ifile, QvtCompilerOptions compilerOptions, IProgressMonitor monitor) throws MdaException {
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }

        try {
        	URI resourceURI = URIUtils.getResourceURI(ifile);
			UnitProxy sourceUnit = UnitResolverFactory.Registry.INSTANCE.getUnit(resourceURI);
						
			if(sourceUnit == null) {
				throw new MdaException("Failed to resolve compilation unit: " + ifile); //$NON-NLS-1$
			}			

			final QVTOCompiler compiler = CompilerUtils.createCompiler();
			final CompiledUnit module = compiler.compile(sourceUnit, compilerOptions, 
					BasicMonitor.toMonitor(monitor));
			
			return new CompilationResult() {
				public CompiledUnit getCompiledModule() {
					return module;
				}
				public QVTOCompiler getCompiler() {
					return compiler;
				}				
			};
        }
        finally {
            monitor.done();
        }
	}
}
