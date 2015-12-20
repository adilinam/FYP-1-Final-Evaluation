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
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.ExeXMISerializer;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.WorkspaceQvtModule;
import org.eclipse.m2m.qvt.oml.util.IContext;

public class TestQvtInterpreter extends TestTransformation {
	
	static final String PREFIX = "interpret_"; //$NON-NLS-1$
	
    public TestQvtInterpreter(ModelTestData data) {
        super(data);        
		setName(PREFIX + data.getName());
    }
    
    protected ITransformer getTransformer() {
		return new DefaultTransformer(getData(), getProject());
    }
       
	@Override
    public void setUp() throws Exception {   
    	super.setUp();
    	
    	try {
    		buildTestProject();
    	}
       	catch (Throwable e) {
			tearDown();
    		onBuildFailed(e);			
		}
    }
	
	protected void onBuildFailed(Throwable e) {
		throw new RuntimeException(e);
	}
    
    @Override
	public void runTest() throws Exception {
        checkTransformation(new TransformationChecker(getTransformer()));
    }
    
    public static ITransformer getDefaultTransformer(ModelTestData data) {
    	return new DefaultTransformer(data);
    }
    
	public static class DefaultTransformer implements ITransformer {
		
		private final boolean fExecuteCompiledAST;
		private final ResourceSet fResourceSet;
		
		public DefaultTransformer(ModelTestData data) {
			this(data, null);
		}
		
		public DefaultTransformer(ModelTestData data, IProject project) {
			this(data.isUseCompiledXmi(), data.getResourceSet(project));
		}
				
		protected DefaultTransformer(boolean executeCompiledAST, ResourceSet resourceSet) {
			fExecuteCompiledAST = executeCompiledAST;
			fResourceSet = resourceSet;
		}
				
			    
	    protected QvtInterpretedTransformation getTransformation(IFile transformation) {
			if(!fExecuteCompiledAST) {
				return new QvtInterpretedTransformation(transformation);
			}
			
			WorkspaceQvtModule qvtModule = new WorkspaceQvtModule(transformation) {
				@Override
				protected CompiledUnit loadModule() throws MdaException {
			        QvtCompilerOptions options = getQvtCompilerOptions();
			        if (options == null) {
			            options = new QvtCompilerOptions();
			        }            
			    	IFile transformationFile = getTransformationFile();
					URI resourceURI = URI.createPlatformResourceURI(transformationFile.getFullPath().toString(), true);
													        
			        URI binURI = ExeXMISerializer.toXMIUnitURI(resourceURI);		
			        assertTrue("Requires serialized AST for execution", URIConverter.INSTANCE.exists(binURI, null)); //$NON-NLS-1$
			    	
			        return new CompiledUnit(binURI, fResourceSet);       			
				}
				
				@Override
				protected ResourceSet getResourceSetImpl() {
					return fResourceSet;
				}
				
				@Override
				public void cleanup() {
				}
			};

			return new QvtInterpretedTransformation(qvtModule); 
		}
		
		public List<URI> transform(IFile transformation, List<URI> inUris, URI traceUri, IContext qvtContext) throws Exception {
        	QvtInterpretedTransformation transf = getTransformation(transformation);
        	
        	//TestUtil.assertAllPersistableAST(transf.getModule().getUnit());
        	return launchTransform(transformation, inUris, traceUri, qvtContext, transf);
		}

	}
}
