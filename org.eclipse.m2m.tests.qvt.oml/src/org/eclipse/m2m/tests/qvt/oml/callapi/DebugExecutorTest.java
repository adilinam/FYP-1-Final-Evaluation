/*******************************************************************************
 * Copyright (c) 2014, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Boyko Sergey - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.callapi;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.InternalTransformationExecutor;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.debug.core.launch.TransformationRunnerFactory;
import org.eclipse.m2m.tests.qvt.oml.TestProject;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

import junit.framework.TestCase;


public class DebugExecutorTest extends TestCase {

	private ModelTestData myData;
	private TestProject myProject;
	private File myDestFolder;
	
	private TransformationRunnerFactory factory;
	private ExecutionContextImpl executionContext;
	private List<DirectionKind> paramKinds;
	private ResourceSet resSet;
	

	public DebugExecutorTest(ModelTestData data) {
		super(DebugExecutorTest.class.getSimpleName() + " : " + data.getName()); //$NON-NLS-1$
		myData = data;
	}
	
	@Override
	protected void setUp() throws Exception {
        TestUtil.turnOffAutoBuilding();     
        
        String name = DebugExecutorTest.class.getSimpleName();
        myProject = TestProject.getExistingProject(name);
        if (myProject == null) {
            myProject = new TestProject(name, new String[] {}, 0); 
            myProject.getProject().setDefaultCharset(ModelTestData.ENCODING, null);
        }
        
        copyModelData();
        myData.prepare(myProject);
		
		resSet = getMetamodelResolutionRS();
		paramKinds = getParamKinds();

		factory = new TransformationRunnerFactory() {
			@Override
			protected TransformationRunner createRunner(URI transformationURI, Registry packageRegistry, List<URI> modelParamURIs) {
				return super.createRunner(transformationURI, resSet.getPackageRegistry(), modelParamURIs);
			}
		};
		
		factory.modelParamURI = new ArrayList<String>(paramKinds.size());
		int inIndex = 0, outIndex = 0;
		for (DirectionKind kind : paramKinds) {
			URI modelUri = null;
			if (kind == DirectionKind.OUT) {
				URI origUri = getOutModelUri(TestQvtExecutor.getOutModels(myData).get(outIndex++));
				modelUri = origUri.appendFileExtension(DirectionKind.OUT.getLiteral());
			}
			else if (kind == DirectionKind.INOUT) {
				outIndex++;
				modelUri = getModelUri(TestQvtExecutor.getInModels(myData).get(inIndex++));
			}
			else {
				modelUri = getModelUri(TestQvtExecutor.getInModels(myData).get(inIndex++));
			}
			factory.modelParamURI.add(modelUri.toString());
		}

		factory.transformationURI = getTransformationUri().toString();
		
		executionContext = new ExecutionContextImpl();
		for (String key : myData.getContext().getConfigProperties().keySet()) {
			executionContext.setConfigProperty(key, myData.getContext().getConfigProperties().get(key));
		}
	}
	
	@Override
	protected void tearDown() throws Exception {
    	if (myData == null) {
    		return;
    	}
    	
    	myData.dispose(myProject);
        if (myDestFolder.exists()) {
            FileUtil.delete(myDestFolder);
        }
        myProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
    	myData = null;
	}
	
	/**
	 * Test if transformation can be successfully executed when running via TransformationRunner.
	 */
	@Override
	protected void runTest() throws Throwable {
		TransformationRunner runner = factory.createRunner();

		URI traceUri = getTraceUri();
		if (resSet.getURIConverter().exists(traceUri, Collections.emptyMap())) {
			runner.setIncrementalUpdate(true);
			runner.setTraceFile(traceUri);
		}
		
		Diagnostic diagnostic = runner.execute(executionContext);
		
		if (Diagnostic.OK != diagnostic.getSeverity()
				|| 0 != diagnostic.getCode()
				) {
			fail(diagnostic.getMessage() + " : " + diagnostic);
		}

		int inIndex = 0, outIndex = 0;
		for (DirectionKind kind : paramKinds) {
			if (kind == DirectionKind.OUT) {
				URI origUri = getModelUri(TestQvtExecutor.getOutModels(myData).get(outIndex++));
				URI outUri = origUri.appendFileExtension(DirectionKind.OUT.getLiteral());
				Resource origResource = resSet.getResource(origUri, true);
				Resource outResource = resSet.getResource(outUri, true);
				ModelTestData.compareWithExpected(myData.getName(), origResource.getContents(), outResource.getContents());
			}
			else if (kind == DirectionKind.INOUT) {
				URI origUri = getModelUri(TestQvtExecutor.getInModels(myData).get(inIndex++));
				URI outUri = getModelUri(TestQvtExecutor.getOutModels(myData).get(outIndex++));
				Resource origResource = resSet.getResource(origUri, true);
				Resource outResource = resSet.getResource(outUri, true);
				ModelTestData.compareWithExpected(myData.getName(), origResource.getContents(), outResource.getContents());
			}
			else {
				inIndex++;
				continue;
			}
		}
	}
	
    private List<DirectionKind> getParamKinds() {
		InternalTransformationExecutor executor = new InternalTransformationExecutor(getTransformationUri(),
				resSet.getPackageRegistry());

		Diagnostic loadDiagnostic = executor.loadTransformation(new NullProgressMonitor());
		if (!QvtPlugin.isSuccess(loadDiagnostic)) {
			return Collections.emptyList();
		}

		OperationalTransformation transformation = executor.getTransformation();
		if (transformation == null) {
			return Collections.emptyList();
		}
		
		List<DirectionKind> paramKinds = new ArrayList<DirectionKind>(transformation.getModelParameter().size());
		for (ModelParameter p : transformation.getModelParameter()) {
			paramKinds.add(p.getKind());
		}
		
		executor.cleanup();
		
		return paramKinds;
    }
    
    protected ResourceSet getMetamodelResolutionRS() {
    	ResourceSet resSet = new ResourceSetImpl();
    	
    	if (myData.getEcoreMetamodels().isEmpty()) {
    		return resSet;
    	}
    	
    	EPackage.Registry packageRegistry = resSet.getPackageRegistry();
    	
    	for (URI ecoreFileURI : myData.getEcoreMetamodels()) { 
    		URI absoluteURI = ecoreFileURI;
    		if(ecoreFileURI.isRelative()) {
        		 absoluteURI = getModelUri(ecoreFileURI.toString());  
    		}
        	
        	EPackage metamodelPackage = null;
        	try {
        		Resource ecoreResource = resSet.getResource(absoluteURI, true);
            	if(!ecoreResource.getContents().isEmpty()) {
            		EObject obj = ecoreResource.getContents().get(0);
            		if(obj instanceof EPackage) {
            			metamodelPackage = (EPackage) obj;
            		}
            	}
        	} catch (WrappedException e) {
        		TestCase.fail("Failed to load metamodel EPackage. " + e.getMessage()); //$NON-NLS-1$
			}
        	
        	if(metamodelPackage == null) {
        		TestCase.fail("No metamodel EPackage available in " + absoluteURI); //$NON-NLS-1$
        	}
        	
        	packageRegistry.put(metamodelPackage.getNsURI(), metamodelPackage);
		}
    	
    	return resSet;
    }

    private void copyModelData() throws Exception {
        File srcFolder = TestUtil.getPluginRelativeFile(myData.getBundle(), myData.getTestDataFolder() + "/models/" + myData.getName()); //$NON-NLS-1$
        myDestFolder = new File(myProject.getProject().getLocation().toString() + "/models/" + myData.getName()); //$NON-NLS-1$
        myDestFolder.mkdirs();
        FileUtil.copyFolder(srcFolder, myDestFolder);
        myProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
    }
    
    private URI getTransformationUri() {
		IFile qvtoFile = getIFile(myData.getName() + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT, true);
		return URI.createPlatformResourceURI(qvtoFile.getFullPath().toString(), true);
	}
	
    private URI getTraceUri() {
		IFile qvtoFile = getIFile(myData.getName() + MDAConstants.QVTO_TRACEFILE_EXTENSION_WITH_DOT, false);
		return URI.createPlatformResourceURI(qvtoFile.getFullPath().toString(), true);
	}
	
	private URI getOutModelUri(String name) {
		IFile qvtoFile = getIFile(name, false);
		return URI.createPlatformResourceURI(qvtoFile.getFullPath().toString(), true);
	}

	private URI getModelUri(String name) {
		IFile qvtoFile = getIFile(name, true);
		return URI.createPlatformResourceURI(qvtoFile.getFullPath().toString(), true);
	}

	private IFile getIFile(String fileName, boolean shouldExists) {
        File file = new File(myDestFolder, fileName);
        if (shouldExists) {
            if(!file.exists() || !file.isFile()) {
                throw new IllegalArgumentException("No such file: " + file); //$NON-NLS-1$
            }
        }
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IPath location = new Path(file.getAbsolutePath());
        IFile ifile = workspace.getRoot().getFileForLocation(location);
        if(ifile == null) {
            throw new RuntimeException("File not found: " + file); //$NON-NLS-1$
        }
        
        return ifile;
    }

}
