/*******************************************************************************
 * Copyright (c) 2009, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bugs 422269, 431082
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.callapi;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.Log;
import org.eclipse.m2m.qvt.oml.util.StringBufferLog;
import org.eclipse.m2m.tests.qvt.oml.AllTests;
import org.osgi.framework.Bundle;

import junit.framework.TestCase;

/**
 * @author dvorak
 */
public class InvocationTest extends TestCase {

	private TransformationExecutor fExecutor;
	private BasicModelExtent fInput;
	private List<EObject> fInitialInputContents;	
	private BasicModelExtent fOutput;	
	private ExecutionContextImpl fContext;

	
	public InvocationTest(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		URI uri = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/callapi/Ecore2Ecore.qvto", false); //$NON-NLS-1$
		fExecutor = new TransformationExecutor(uri);

		fInput = new BasicModelExtent();
		EPackage inObject = EcoreFactory.eINSTANCE.createEPackage();
		inObject.setName("input"); //$NON-NLS-1$
		fInput.add(inObject);
		
		fInitialInputContents = new ArrayList<EObject>(fInput.getContents());
		
		fOutput = new BasicModelExtent();		
		fContext = new ExecutionContextImpl();
		
		assertFalse(fInput.getContents().isEmpty());
		assertTrue(fOutput.getContents().isEmpty());		
	}
	
	private void assertOutputObject(ModelExtent outModel) {			
		EPackage result = (EPackage)EcoreUtil.getObjectByType(outModel.getContents(), EcorePackage.eINSTANCE.getEPackage());
		EPackage input = (EPackage)EcoreUtil.getObjectByType(fInput.getContents(), EcorePackage.eINSTANCE.getEPackage());
		assertEquals(input.getName() + "_Ecore2Ecore", result.getName());
		
		assertUnchangedInput();
	}
	
	private void assertUnchangedInput() {
		// check the input was not changed
		assertEquals(fInitialInputContents, fInput.getContents());		
	}
	
	public void testAssertFailed() throws Exception {
		fContext.setConfigProperty("assertFail", Boolean.TRUE); //$NON-NLS-1$		
		ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput, fOutput);		
		
		assertEquals(Diagnostic.ERROR, diagnostic.getSeverity());
		assertEquals(ExecutionDiagnostic.FATAL_ASSERTION, diagnostic.getCode());		
		assertFalse(diagnostic.getStackTrace().isEmpty());		
		assertTrue(fOutput.getContents().isEmpty());
	}
	
	public void testStackTrace() throws Exception {
		// provoke an exception
		fContext.setConfigProperty("assertFail", Boolean.TRUE); //$NON-NLS-1$		
		ExecutionDiagnostic diagnostic = fExecutor.execute(fContext, fInput, fOutput);
		assertEquals(2, diagnostic.getStackTrace().size());
		
		StringWriter strWr = new StringWriter();  
		diagnostic.printStackTrace(new PrintWriter(strWr));
		strWr.flush();
		
		StringWriter expected = new StringWriter();
		PrintWriter pwr = new PrintWriter(expected);
		pwr.println("	at Ecore2Ecore::checkAssert(Ecore2Ecore.qvto:27)"); //$NON-NLS-1$
		pwr.print("	at Ecore2Ecore::main(Ecore2Ecore.qvto:12)"); //$NON-NLS-1$
		pwr.flush();
		
		assertEquals(expected.toString(), strWr.toString());
	}

	public void testMutlipleOutObjects() throws Exception {
		fContext.setConfigProperty("createTwoObjects", true);
		ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput, fOutput);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertOutputObject(fOutput);
		assertEquals(2, fOutput.getContents().size());
	}	
	
	public void testInvokeSuccess() throws Exception {
		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput, fOutput);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertEquals(0, diagnostic.getCode());		
		
		List<?> outContents = fOutput.getContents();
		assertEquals(1, outContents.size());		
		assertOutputObject(fOutput);
		
		// test re-execution
		BasicModelExtent nextOut = new BasicModelExtent();
		fContext = new ExecutionContextImpl();
		ExecutionDiagnostic nextDiagnostic = fExecutor.execute(fContext, fInput, nextOut);
		
		assertOutputObject(nextOut);
		assertEquals(Diagnostic.OK, nextDiagnostic.getSeverity());
	}
	
	public void testLogging() throws Exception {
		StringBufferLog log = new StringBufferLog();
		fContext.setLog(log);
		
		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput, fOutput);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertTrue(log.getContents().contains("Hello")); //$NON-NLS-1$
	}

	public void testInterruption() throws Exception {
		final IProgressMonitor monitor = new NullProgressMonitor();
		
		Log log = new Log() {
			public void log(int level, String message, Object param) {
				monitor.setCanceled(true);
			}

			public void log(int level, String message) {
				monitor.setCanceled(true);				
			}

			public void log(String message, Object param) {
				monitor.setCanceled(true);		
			}

			public void log(String message) {
				monitor.setCanceled(true);				
			}
		};
		
		fContext.setProgressMonitor(monitor);
		fContext.setLog(log);

		final ExecutionDiagnostic diagnostic = fExecutor.execute(fContext, fInput, fOutput);	
		assertEquals(Diagnostic.CANCEL, diagnostic.getSeverity());
		assertEquals(ExecutionDiagnostic.USER_INTERRUPTED, diagnostic.getCode());		
		assertEquals(1, diagnostic.getStackTrace().size());
	}

	public void testTransformationLoadFailure() throws Exception {
		URI uri = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/callapi/NotExisting.qvto", false); //$NON-NLS-1$
		fExecutor = new TransformationExecutor(uri);
		
		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput, fOutput);		
		assertEquals(Diagnostic.ERROR, diagnostic.getSeverity());
		assertEquals(ExecutionDiagnostic.TRANSFORMATION_LOAD_FAILED, diagnostic.getCode());		
		assertUnchangedInput();
		assertTrue(fOutput.getContents().isEmpty());		
	}
	
	public void testCompilationErrors() throws Exception {
		URI uri = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/callapi/CompilationErrors.qvto", false); //$NON-NLS-1$
		fExecutor = new TransformationExecutor(uri);
		
		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput, fOutput);		
		assertEquals(Diagnostic.ERROR, diagnostic.getSeverity());
		assertEquals(ExecutionDiagnostic.VALIDATION, diagnostic.getCode());
		assertFalse(diagnostic.getChildren().isEmpty());
		assertTrue(diagnostic.getChildren().get(0).getMessage().contains("(at:")); //$NON-NLS-1$		
		
		assertUnchangedInput();
		assertTrue(fOutput.getContents().isEmpty());
	}
	
	public void testNonExecutable() throws Exception {
		URI uri = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/callapi/NonExecutable.qvto", false); //$NON-NLS-1$
		fExecutor = new TransformationExecutor(uri);
		
		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput, fOutput);		
		assertEquals(Diagnostic.ERROR, diagnostic.getSeverity());
		assertEquals(ExecutionDiagnostic.VALIDATION, diagnostic.getCode());

		assertUnchangedInput();
		assertTrue(fOutput.getContents().isEmpty());
	}

	public void testLessModelParams() throws Exception {
		ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput);
		assertEquals(Diagnostic.ERROR, diagnostic.getSeverity());
		assertEquals(ExecutionDiagnostic.MODEL_PARAMETER_MISMATCH, diagnostic.getCode());
	}

	public void testModelModelParams() throws Exception {
		ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput, fOutput, new BasicModelExtent());
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertEquals(0, diagnostic.getCode());
	}
	
	public void testNullModelParams() throws Exception {
		try {
			fExecutor.execute(fContext, (ModelExtent) null);
		} catch(IllegalArgumentException e) {
			return;
		}
		
		fail("Must have thrown exception"); //$NON-NLS-1$
	}
	
	public void testNullOneOfModelParams() throws Exception {
		try {
			fExecutor.execute(fContext, new ModelExtent[] { fInput, null });
		} catch(IllegalArgumentException e) {
			return;
		}
		
		fail("Must have thrown exception"); //$NON-NLS-1$
	}

	public void testNullContext() throws Exception {
		try {
			fExecutor.execute(null, fInput, fOutput);
		} catch(IllegalArgumentException e) {
			return;
		}
		
		fail("Must have thrown exception"); //$NON-NLS-1$
	}
	
	public void testInvokeOnGenericURIs() throws Exception {
		Bundle testBundle = Platform.getBundle(AllTests.BUNDLE_ID);
		File bundleFile = FileLocator.getBundleFile(testBundle);
		assertNotNull(bundleFile);

		URI fileURI = URI.createURI(new File(bundleFile, "deployed/callapi/Ecore2Ecore.qvto").toURI().toString(), true);
		fExecutor = new TransformationExecutor(fileURI);
		
		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput, fOutput);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertEquals(0, diagnostic.getCode());
	}	

	public void testConfigProperties() throws Exception {
		URI uri = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/parserTestData/models/bug267917/bug267917.qvto", false); //$NON-NLS-1$
		fExecutor = new TransformationExecutor(uri);
		
		fContext.setConfigProperty("optionsDict1", "b=b1, c=c1, a=a1"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("optionsDict2", "b=10, c=100, a=-1"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("optionsDict3", "true=false, false=true"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("optionsDict4", "b=2.2, c=3.3, a=1.1"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("optionsDict5", "1=a, 2=b, 3=c"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("optionsDict6", "1=true, 2=false"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("optionsDict7", null); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("optionsSet", "1.0, 1.1, 1.2"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("optionsList", "foo, bar"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("optionsSequence", "-1, 10"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("optionsOrderedSet", "bar, foo"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("nestedDict1", "[a\\\\a=[a, b], a\\,a=[b, c], a\\[\\[a=[b, c]]"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("nestedDict2", "[[3.0=]=[4=4.0], [1.0=a]=[2=2.0]]"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("nestedSet1", "[[1.0]]"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("nestedSet2", "[[1.1], [2.2], [0.0, 3.3]]"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("nestedSet3", "[]"); //$NON-NLS-1$ //$NON-NLS-2$
		fContext.setConfigProperty("nestedSet4", "[[]]"); //$NON-NLS-1$ //$NON-NLS-2$
		
		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
	}

}
