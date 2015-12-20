/*******************************************************************************
 * Copyright (c) 2008, 2015 Borland Software Corporation and others.
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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtAssertionFailed;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.HelperOperationCall;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.NonTransformationExecutionContext;
import org.eclipse.m2m.tests.qvt.oml.util.TestModuleResolver;

import junit.framework.TestCase;


public class TestExternHelperCall extends TestCase {

	private static String fLibraryName = "FooLib";
	private NonTransformationExecutionContext fExecContext;
	private HelperOperationCall fCall;
	
	private String srcContainer = "parserTestData/externlib"; //$NON-NLS-1$

	public TestExternHelperCall(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		setupLibrary(fLibraryName);
	}

	protected void setupLibrary(String libraryName) throws MdaException {
		TestModuleResolver importResolver = TestModuleResolver.createTestPluginResolver(srcContainer);

		QVTOCompiler compiler = CompilerUtils.createCompiler();				
		UnitProxy srcUnit = importResolver.resolveUnit(libraryName);
		
		CompiledUnit result = compiler.compile(srcUnit, new QvtCompilerOptions(), null);
		assertTrue("Library must no have compilation errors", result.getErrors().size() == 0);
		
		Module module = result.getModules().get(0);
		Helper operation = findOperationByName(module, getName());
		assertNotNull("Library operation for the "+ getName() +"testcase not found", operation);

		HashSet<Module> importedModules = new HashSet<Module>();
		importedModules.add(module);
		QvtOperationalParserUtil.collectAllImports(module, importedModules);
		
		fExecContext = new NonTransformationExecutionContext(importedModules);
		fCall = fExecContext.createHelperCall(operation);
	}
	
	@Override
	protected void tearDown() throws Exception {
		fExecContext.dispose();
	}

	public void testEchoContextual() throws Exception {		
		Object callResult = fCall.invoke("self", new Object[] { "aStringArg", true });
		assertEquals("self" + "ASTRINGARG" + "_suffix", callResult);
		
		callResult = fCall.invoke("self", new Object[] { "aStringArg", false });
		assertEquals("self" + "aStringArg" + "_suffix", callResult);		
	}
	
	public void testEchoContextless() throws Exception {
		Object callResult = fCall.invoke(new Object[] { "aStringArg", true });		
		assertEquals("ASTRINGARG" + "_suffix", callResult);
		
		callResult = fCall.invoke(new Object[] { "aStringArg", false });
		assertEquals("aStringArg" + "_suffix", callResult);
		
	}	
	
	public void testHelperWithAssertFailed() throws Exception {
		try {
			Object callResult = fCall.invoke(null);		
			assertNotNull(callResult);
		} catch (InvocationTargetException e) {
			// OK, expected
			assertTrue(e.getCause() instanceof QvtAssertionFailed);
		} catch(Exception e1) {
			fail("InvocationTargetException expected");  
		}
	}
	
	
	public void testNoArgsHelper() throws Exception {
		final String expectedResult = "testNoArgsHelper";
		assertEquals(expectedResult, fCall.invoke(null));
		assertEquals(expectedResult, fCall.invoke(new Object[0]));
	}
	
	public void testHelperWithResolve() throws Exception {
		final String expectedResult = "testHelperWithResolve";
		assertEquals(expectedResult, fCall.invoke(EcoreFactory.eINSTANCE.createEClass(), new Object[0]));		
	}
	
	public void testImportedVirtualCall() throws Exception {
		// test imported operation call
		Module mainModule = fCall.getLibrary();
		assertFalse("Need imported lib to test", mainModule.getModuleImport().isEmpty());
		Module imported = mainModule.getModuleImport().get(0).getImportedModule();
		assertNotNull(imported);
		HelperOperationCall call = fExecContext.createHelperCall(findOperationByName(imported, "testImportedFooLibImport"));
		// test virtual call semantics		
		assertEquals("EClass", call.invoke(EcoreFactory.eINSTANCE.createEClass(), new Object[0]));		
		assertEquals("EClassifier", call.invoke(EcoreFactory.eINSTANCE.createEDataType(), new Object[0]));		
	}
	
	
	public void testQueryNonContextual() throws Exception {
		assertNotNull("Call must refer to operation", fCall.getOperation());
		assertNotNull("Call must be imported from a library", fCall.getLibrary());
		assertSame(QvtOperationalParserUtil.getOwningModule(fCall.getOperation()), fCall.getLibrary());
		assertFalse(fCall.isContextual());
		assertNull("Non-contextual operation must not have context type", fCall.getContextType());		
	}
	
	public void testQueryContextual()  throws Exception {
		assertNotNull("Call must refer to operation", fCall.getOperation());
		assertNotNull("Call must be imported from a library", fCall.getLibrary());
		assertSame(QvtOperationalParserUtil.getOwningModule(fCall.getOperation()), fCall.getLibrary());
		assertTrue(fCall.isContextual());
		assertSame(EcorePackage.eINSTANCE.getEClass(), fCall.getContextType());		
	}
	
	/*
	 * Tests the Collection type as the context type
	 */	
	public void testToUpperStrings() throws Exception {
		ArrayList<String> self = new ArrayList<String>();
		self.add("aaa");
		Object result = fCall.invoke(self, new Object[0]);
		assertTrue(result instanceof Collection<?>);
		@SuppressWarnings("unchecked")
		Collection<String> collection = (Collection<String>)result;
		assertEquals(1, collection.size());
		assertEquals("AAA", collection.toArray()[0]);
	}

	/*
	 * Test collection type matching from a library and an imported library.
	 * Quite similar to testToUpperStrings(), the difference is that in this case
	 * both collections are parse-time (testToUpperStrings needs to convert ArrayList
	 * to proper collection at evaluation time - different code location, though
	 * same TypeResolver trouble, perhaps)
	 */
	public void testCollectionTypeInImportsMatch() throws Exception {
		assertTrue(fCall.isContextual());
		Object result = fCall.invoke("anything", new Object[0]);
		assertEquals("COLLECTION SUCCESS", result);
	}

	private static Helper findOperationByName(Module module, String operationName) {		
		for (EOperation eOperation : module.getEOperations()) {
			if(operationName.equals(eOperation.getName()) && eOperation instanceof Helper) {
				return (Helper) eOperation;
			}
		}

		return null;
	}
}
