/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.project;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;


/**
 * @author pfeldman
 */
public class QvtEngine {
	public static QvtEngine getInstance(IResource resource) {
		IProject project = resource.getProject();
		QvtEngine engine = (QvtEngine) ourEnginesMap.get(project);
		if(engine == null) {
			engine = new QvtEngine();
			//ourEnginesMap.put(project, engine);
		}
		return engine;
	}
	
	private QvtEngine() {
		reset(null);
	}
	

    public CompiledUnit compileUnit(UnitProxy source,  QvtCompilerOptions options, Monitor monitor) throws MdaException {
		return myCompiler.compile(source, options, monitor);
	}
	
	
    public CompiledUnit compileUnit(UnitProxy source, Monitor monitor) throws MdaException {
		return myCompiler.compile(source, /*default*/null, monitor);
	}

//    public CompiledUnit compileUnit(IFile source, IProgressMonitor monitor) throws MdaException {
//    	return myCompiler.compile(new EclipseFile(source), /*default*/null, monitor);
//    }
    		    			
	public QVTOCompiler getQVTOCompiler() {
		return myCompiler;
	}	
    
	private void reset(QvtCompilerOptions options) { // TODO: QvtException
	    myCompiler = CompilerUtils.createCompiler();
	}
	
	private static Map<IProject, QvtEngine> ourEnginesMap = new HashMap<IProject, QvtEngine>();
	private QVTOCompiler myCompiler;	
}