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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;


import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtCompilerFacade.CompilationResult;

public class WorkspaceQvtModule extends QvtModule {
    
	public WorkspaceQvtModule(IFile transformationFile) {
        myTransformationFile = transformationFile;
    }
	    
    protected CompiledUnit loadModule() throws MdaException {
        QvtCompilerOptions options = getQvtCompilerOptions();
        if (options == null) {
            options = new QvtCompilerOptions();
        }
        
    	CompilationResult result = QvtCompilerFacade.getCompiledModule(myTransformationFile, options, null);  
        myResourceSet = result.getCompiler().getResourceSet();
    	return result.getCompiledModule();
    }
    
    protected ResourceSet getResourceSetImpl() {
    	return myResourceSet;
    }
	
    @Override
    public final Module getModule() throws MdaException {
        if(myModule == null) {
            myUnit = loadModule();
            
            QvtCompilerOptions options = getQvtCompilerOptions();
            if (options == null) {
                options = new QvtCompilerOptions();
            }
            if (!options.isModuleWithErrorAllowed()) {
            	checkModuleErrors(myUnit);
            }            

            myModule = myUnit.getModules().isEmpty() ? null : myUnit.getModules().get(0);
        }
        
        return myModule;
    }

    @Override
    public CompiledUnit getUnit() throws MdaException {
    	getModule();
    	return myUnit;
    }
    
	@Override
	public ResourceSet getResourceSet() throws MdaException {
		getModule();
		return getResourceSetImpl();
	}
	
	@Override
	public void cleanup() {
		if (getResourceSetImpl() != null) {
			EmfUtil.cleanupResourceSet(getResourceSetImpl());
		}
	}
	
    public IFile getTransformationFile() {
        return myTransformationFile;
    }
    
	@Override
	public String toString() {
        return myTransformationFile.getFullPath().toString();
    }    
    
    private final IFile myTransformationFile;
    private Module myModule;
    private CompiledUnit myUnit;    
    private ResourceSet myResourceSet;
}
