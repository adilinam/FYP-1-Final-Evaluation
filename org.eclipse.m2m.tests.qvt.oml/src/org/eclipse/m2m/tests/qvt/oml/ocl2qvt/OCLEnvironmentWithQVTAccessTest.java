/*******************************************************************************
 * Copyright (c) 2008, 2012 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.ocl2qvt;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.internal.qvt.oml.blackbox.AbstractCompilationUnitDescriptor;
import org.eclipse.m2m.internal.qvt.oml.blackbox.BlackboxRegistry;
import org.eclipse.m2m.internal.qvt.oml.blackbox.CompilationUnit;
import org.eclipse.m2m.internal.qvt.oml.blackbox.LoadContext;
import org.eclipse.m2m.internal.qvt.oml.blackbox.ResolutionContext;
import org.eclipse.m2m.internal.qvt.oml.blackbox.ResolutionContextImpl;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.OCLEnvironmentWithQVTAccessFactory;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Query;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.helper.OCLHelper;

import junit.framework.TestCase;

public class OCLEnvironmentWithQVTAccessTest extends TestCase {

	private static final String SRC_CONTAINER = "parserTestData/externlib"; //$NON-NLS-1$
	
	protected OCL fOCL;
	protected OCLEnvironmentWithQVTAccessFactory fEnvFactory;

	public OCLEnvironmentWithQVTAccessTest() {
		super();
	}
	
	protected LinkedHashSet<Module> getImportedModules() {
		return new LinkedHashSet<Module>(fEnvFactory.getQVTModules());
	}
	
	protected EcoreEvaluationEnvironment getEvaluationEnv(Query query) {
		return (EcoreEvaluationEnvironment)query.getEvaluationEnvironment();
	}
	
	protected final Object evaluate(Query query) {
		return evaluate(getEvaluationEnv(query), query);
	}
		
	protected Object evaluate(EcoreEvaluationEnvironment evalEnv, Query query) {
		return query.evaluate();
	}

	protected Object evaluate(EcoreEvaluationEnvironment evalEnv, Query query, Object self) {
		return query.evaluate(self);
	}	
	
	@Override
	protected void setUp() {
		fEnvFactory = createOCLEnvFactory();
		assertTrue(fEnvFactory.getDiagnostic().getSeverity() == Diagnostic.OK);
		fOCL = OCL.newInstance(fEnvFactory);
	}

	protected OCLEnvironmentWithQVTAccessFactory createOCLEnvFactory() {
		return new OCLEnvironmentWithQVTAccessFactory(createImportedModules(), EPackage.Registry.INSTANCE);
	}
	
	private LinkedHashSet<Module> createImportedModules() {
		final Set<CompiledUnit> compileModules = TestUtil.compileModules(SRC_CONTAINER, new String[] {
				"org.q1", "org.q2" //$NON-NLS-1$ //$NON-NLS-2$
			});
		
		LinkedHashSet<Module> modules = new LinkedHashSet<Module>();
		for (CompiledUnit compiledUnits : compileModules) {
			modules.addAll(compiledUnits.getModules());
		}
		
		try {
			ResolutionContext resolutionContext = new ResolutionContextImpl(compileModules.iterator().next().getURI());
			// import "Strings" black-box library
			AbstractCompilationUnitDescriptor abstractCompilationUnitDescriptor = BlackboxRegistry.INSTANCE.getCompilationUnitDescriptor("Strings", resolutionContext);
			assertNotNull("descriptor must be found", abstractCompilationUnitDescriptor); //$NON-NLS-1$
			LoadContext loadContext = new LoadContext(EPackage.Registry.INSTANCE);
			CompilationUnit loadCompilationUnit = BlackboxRegistry.INSTANCE.loadCompilationUnit(abstractCompilationUnitDescriptor, loadContext);
			modules.add(loadCompilationUnit.getElements().get(0).getModuleContextType());

		} catch (Exception e) {
			throw new RuntimeException("Failed to setup test", e);
		}

		return modules;
	}
	
	@Override
	protected void tearDown() throws Exception {	
		this.fEnvFactory = null;
		this.fOCL = null;
	}
			
	@SuppressWarnings("unchecked")
	public void testUserDefinedVariables() throws Exception {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			Variable var = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createVariable();
			// name it 'this' intentionally, as it also tests, that non-QVT execution context
			// has now predefined this variable and it brings now collision with QVT
			var.setName("this");
			var.setEType(helper.getEnvironment().getOCLStandardLibrary().getString());
			var.setType(var.getEType());
			
			helper.getEnvironment().addElement(var.getName(), (org.eclipse.ocl.expressions.Variable)var, true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = helper.createQuery("this.concat(getModulePropertyValue())");

			assertNull(helper.getProblems());
						
			Query query = fOCL.createQuery(q);
			EcoreEvaluationEnvironment evalEnv = getEvaluationEnv(query); 			
			evalEnv.add(var.getName(), "userVarValue");

			Object result = evaluate(evalEnv, query);
			assertEquals("userVarValuemoduleProperty_suffix_suffix", result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail("Additional operation should come from super type"); //$NON-NLS-1$
		}		
	}
		
	public void testImportedOperationAccessingModuleProperty() throws Exception {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = helper.createQuery("getModulePropertyValue()");

			assertNull(helper.getProblems());
						
			Object result = evaluate(fOCL.createQuery(q));			
			assertEquals("moduleProperty_suffix_suffix", result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail("Additional operation should come from super type"); //$NON-NLS-1$
		}		
	}

	public void testStdlibOperationAccess() throws ParserException {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = 
				helper.createQuery("createTestedInvalid().oclIsUndefined()");
								
			assertNull(helper.getProblems());
						
			Query query = fOCL.createQuery(q);
			Object result = evaluate(getEvaluationEnv(query), 
					query, EcoreFactory.eINSTANCE.createEClass());
			
			assertEquals(Boolean.TRUE, result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail("Additional operation should come from super type"); //$NON-NLS-1$
		}
	}
	

	public void testQVTStdlibOperationAccess() throws ParserException {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = 
				helper.createQuery("let e : Stdlib::Element = self in e.subobjects()"); //$NON-NLS-1$
								
			assertNull(helper.getProblems());
						
			Query query = fOCL.createQuery(q);
			Object result = evaluate(getEvaluationEnv(query), 
					query, EcorePackage.eINSTANCE);
			
			assertEquals(new HashSet<EClassifier>(EcorePackage.eINSTANCE.getEClassifiers()), result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail(e.getMessage());
		}
	}
		
	
	public void testImportedModulePropertyAccess() throws ParserException {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = 
				helper.createQuery("moduleProperty");

			assertNull(helper.getProblems());
						
			Object result = fOCL.createQuery(q).evaluate();			
			assertEquals("moduleProperty_suffix", result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail("Additional operation should come from super type"); //$NON-NLS-1$
		}
	}
		
	public void testImportedOperations() throws ParserException {		
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = helper.createQuery(
					"let c : Sequence(String) = Sequence {} in " +
					"q1(c).concat(q2(Bag{'aString'})).concat('ab'.firstToUpper()).concat('xx'.lastIndexOf('x').repr())");

			assertNull(helper.getProblems());
						
			Object result = evaluate(fOCL.createQuery(q));			
			assertEquals("name = xxxAb2", result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail(e.getLocalizedMessage());
		}
	}
		
	public void testComplextTypeInSignatures() throws Exception {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = helper.createQuery(
					"let t : Tuple(name : String, size : Integer) = Tuple { name = 'bob', size = 10} " +
					"in let result : Tuple(name1 : String, name2 : String) = callOnTupleType(t) " +
					"in result.name1.concat(result.name2) = 'bob10'");

			assertNull(helper.getProblems());
						
			Object result = evaluate(fOCL.createQuery(q));			
			assertEquals(Boolean.TRUE, result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail(e.getLocalizedMessage());
		}		
	}

	public void testImportedContextualOperation() throws ParserException {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = helper.createQuery(
					"self.getUpperName()");

			assertNull(helper.getProblems());

			EClass eClass = EcoreFactory.eINSTANCE.createEClass();
			eClass.setName("foo");

			Object result = fOCL.createQuery(q).evaluate(eClass);
			assertEquals("EClass-FOO", result);
			
			EParameter eParam = EcoreFactory.eINSTANCE.createEParameter();
			eParam.setName("foo");

			result = fOCL.createQuery(q).evaluate(eParam);
			assertEquals("FOO", result);
			
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail(e.getLocalizedMessage());
		}
	}
	
	
	public void testImportedOperationOnCollection() throws ParserException {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = helper.createQuery(
					"let c : Sequence(String) = Sequence { 'foo' } in " +
					"c->callOnCollection()->includes('foo')");

			assertNull(helper.getProblems());
						
			Object result = evaluate(fOCL.createQuery(q));			
			assertEquals(Boolean.TRUE, result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail(e.getLocalizedMessage());
		}
	}
	
	public void testCallImportedQvtFileWhichCallsJavaLibrary() throws ParserException {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = helper.createQuery(
					"callImportedQvtFileWhichCallsJavaLibrary('Hello!')");

			assertNull(helper.getProblems());
						
			Object result = evaluate(fOCL.createQuery(q));			
			assertEquals("Hello!", result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail(e.getLocalizedMessage());
		}
	}
	
	public void testValidationProblems() throws Exception {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		try {		
			helper.setContext(EcorePackage.eINSTANCE.getENamedElement());		
			helper.setValidating(true);
			
			helper.createQuery("let s : String = 1 in true");
			fail("Parser error was expected");			
		} catch (ParserException e) {
			assertNotNull(helper.getProblems());			
		}
	}
	
	public void testParsingProblems() throws Exception {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		try {					
			helper.setContext(EcorePackage.eINSTANCE.getENamedElement());			
			helper.setValidating(true);
			
			helper.createQuery("1>++2");
			fail("Parser error was expected");			
		} catch (ParserException e) {
			assertNotNull(helper.getProblems() != null);			
		}
	}

}
