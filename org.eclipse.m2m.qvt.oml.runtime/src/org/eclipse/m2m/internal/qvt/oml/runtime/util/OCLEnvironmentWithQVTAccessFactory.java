/*******************************************************************************
 * Copyright (c) 2008, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribQVTution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImportKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.EvaluationVisitorDecorator;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.parser.OCLProblemHandler;
import org.eclipse.ocl.utilities.TypedElement;


/**
 * This class represents ecore based OCL environment factory capable of resolving 
 * operation, properties from the given set of imported libraries.
 * <p>
 * Module owned operations, properties are resolved via implicit source of calls
 */
public final class OCLEnvironmentWithQVTAccessFactory extends EcoreEnvironmentFactory {
	
	private static final String DIAGNOSTIC_SOURCE = "OCLEnvironmentWithQVTAccessFactory"; //$NON-NLS-1$
	
	private NonTransformationExecutionContext fExecCtx;
	private final Set<Module> fImportedModules;
	private final QvtOperationalEnvFactory fQVTEnvFactory;
	private Diagnostic fDiagnostic = Diagnostic.OK_INSTANCE;

	
	/**
	 * Creates environment factory importing the given QVT unit via referencing
	 * URIs. </p> The global package registry is used for meta-model resolution.
	 * 
	 * @param imports
	 *            URI referencing QVTO library units to be imported to the scope
	 *            of OCL expressions
	 */
	public OCLEnvironmentWithQVTAccessFactory(List<URI> imports) {
		this(imports, EPackage.Registry.INSTANCE);
	}
	
	/**
	 * Creates environment factory importing the given QVT unit via referencing
	 * URIs
	 * 
	 * @param imports
	 *            URI referencing QVTO library units to be imported to the scope
	 *            of OCL expressions
	 * @param registry
	 *            custom meta-model registry
	 */
	public OCLEnvironmentWithQVTAccessFactory(List<URI> imports, EPackage.Registry registry) {
		super(setupRegistry(registry));

		if(registry == null || imports == null || imports.contains(null)) {
			throw new IllegalArgumentException("null in constructor argments"); //$NON-NLS-1$
		}

		HashSet<Module> modules = new HashSet<Module>();		
		try {
			CompiledUnit[] compiledUnits = QVTOCompiler.compile(new HashSet<URI>(imports), registry);
			for (CompiledUnit unit : compiledUnits) {
				// TODO perhaps we should skip units with errors?
				modules.addAll(unit.getModules());
			}			
			
			fDiagnostic = createDiagnostic(imports, compiledUnits);
		} catch (MdaException e) {
			fDiagnostic = new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, e.getMessage(), new Object[] { e });
		}
		
		this.fQVTEnvFactory = new QvtOperationalEnvFactory(registry);
		this.fImportedModules = modules;
	}
	
	/**
	 * Constructs environment with QVT imports and metamodel registry.
	 * @parameter imports  set of imported QVT libraries
	 * @parameter registry metamodel registry
	 */
	public OCLEnvironmentWithQVTAccessFactory(Set<Module> imports, EPackage.Registry registry) {
		super(registry);

		if(imports == null || registry == null) {
			throw new IllegalArgumentException();
		}
		
		this.fQVTEnvFactory = new QvtOperationalEnvFactory(registry);
		this.fImportedModules = imports;
		// mark is OK, the caller is responsible for error analysis
		this.fDiagnostic = Diagnostic.OK_INSTANCE;
	}
	
	public Diagnostic getDiagnostic() {
		return fDiagnostic;
	}
	
	public Set<Module> getQVTModules() {
		return Collections.unmodifiableSet(fImportedModules);
	}
	
	public OCLEnvironmentWithQVTAccessFactory(Set<Module> importedModules) {
		this(importedModules, EPackage.Registry.INSTANCE);
	}

	@Override
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment() {		
		return new EvalEnvImpl(execContext(), null);
	}

	@Override
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment(
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
		return new EvalEnvImpl(execContext(), parent);
	}

	@Override
	public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment() {
		EnvImpl result = new EnvImpl(this.getEPackageRegistry());
		result.setFactory(this);
		return result;
	}

	@Override
	public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
		if (!(parent instanceof EcoreEnvironment)) {
			throw new IllegalArgumentException("Parent environment must be an Ecore environment: " + parent); //$NON-NLS-1$
		}

		EnvImpl result = new EnvImpl(parent);
		result.setFactory(this);
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")	
	public EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEvaluationVisitor(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
			Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {

		EvaluationVisitorDecorator<EPackage, EClassifier, EOperation, 
		EStructuralFeature, EEnumLiteral, EParameter, EObject, 
		CallOperationAction, SendSignalAction, Constraint, EClass, EObject> decorator = 
			new EvaluationVisitorDecorator<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>(super.createEvaluationVisitor(env, evalEnv, extentMap)) 
		{
			@Override
			public Object visitVariableExp(VariableExp variableExp) {
				Variable var = variableExp.getReferredVariable();
				if(var != null && var.getType() != null) {
					if(ExpressionsPackage.eINSTANCE.getModule().isInstance(var.getType())) {
						return execContext().getEvaluator().visitVariableExp(variableExp);
					}
				}
				return super.visitVariableExp(variableExp);
			}
		};
		
		return decorator;
	}
	
	private NonTransformationExecutionContext execContext() {
		if(fExecCtx == null) {
			this.fExecCtx = new ReusableCallCtx(fImportedModules);			
		}
		return fExecCtx;
	}

	
	private static class ReusableCallCtx extends NonTransformationExecutionContext {
		private Map<EOperation, HelperOperationCall> fCallMap = new HashMap<EOperation, HelperOperationCall>();

		private ReusableCallCtx(Set<Module> libraryImports) {
			super(libraryImports);
		}

		@Override
		public HelperOperationCall createHelperCall(Helper operation) {
			HelperOperationCall call = fCallMap.get(operation);
			if(call == null) {
				call = super.createHelperCall(operation); 
				fCallMap.put(operation, call);
			}
		
			return call;
		}
	}

	private class EnvImpl extends EcoreEnvironment {

		private QvtOperationalEnv fQVTdelegate;
						
		protected EnvImpl(Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
			super(parent);

			if(parent instanceof EnvImpl) {
				EnvImpl qvtParentEnv = (EnvImpl)parent;
				fQVTdelegate = qvtParentEnv.fQVTdelegate;
			} else {
				fQVTdelegate = OCLEnvironmentWithQVTAccessFactory.this.fQVTEnvFactory.createEnvironment();
				initiliazeImports();				
			}						
		}

		protected EnvImpl(EPackage.Registry reg, Resource resource) {
			super(reg, resource);
			fQVTdelegate = OCLEnvironmentWithQVTAccessFactory.this.fQVTEnvFactory.createEnvironment();
			initiliazeImports();			
		}

		protected EnvImpl(EPackage.Registry reg) {
			super(reg);
			fQVTdelegate = OCLEnvironmentWithQVTAccessFactory.this.fQVTEnvFactory.createEnvironment();			
			initiliazeImports();			
		}

		@Override
		protected ProblemHandler createDefaultProblemHandler(AbstractParser parser) {
			return new OCLProblemHandler(parser) {				
				@Override
				public void handleProblem(Severity problemSeverity,
						Phase processingPhase, String problemMessage,
						String processingContext, int startOffset, int endOffset) {
					boolean allowCsUnboundValidationProblems = true;
					// Note: We are an OCL based environment, but still need relax some restrictions
					// imposed by pending compatibility issues
					if(QvtOperationalEnv.isMDTOCLCompatibilityFalseProblem(allowCsUnboundValidationProblems,
							problemSeverity, processingPhase, problemMessage, processingContext, 
							startOffset, endOffset)) {
						return;
					}
					
					super.handleProblem(problemSeverity, processingPhase, problemMessage,
							processingContext, startOffset, endOffset);
				}
			};			
		}		
		
		@Override
		public Variable<EClassifier, EParameter> lookupImplicitSourceForOperation(String name, List<? extends TypedElement<EClassifier>> args) {			
			Variable<EClassifier, EParameter> result = super.lookupImplicitSourceForOperation(name, args);
			if(result == null) {
				result = fQVTdelegate.lookupImplicitSourceForOperation(name, args);
			}
			return result;
		}
		
		@Override
		public Variable<EClassifier, EParameter> lookupImplicitSourceForProperty(String name) {
			Variable<EClassifier, EParameter> result = super.lookupImplicitSourceForProperty(name);
			if(result == null) {
				result = fQVTdelegate.lookupImplicitSourceForProperty(name);
			}

			return result;
		}
		
		@Override
		public List<EOperation> getAdditionalOperations(EClassifier classifier) {
			List<EOperation> result = super.getAdditionalOperations(classifier);
			List<EOperation> qvtAdditionals = fQVTdelegate.getAdditionalOperations(classifier);
			
			if(qvtAdditionals != null && !qvtAdditionals.isEmpty()) {
				if(result == null) {
					return qvtAdditionals;
				}
				// FIXME - using LinkedHashset to skip duplicates from Stdlib, which is imported to 
				// every QVT-Environment.				
				LinkedHashSet<EOperation> completeResult = new LinkedHashSet<EOperation>(result.size() + qvtAdditionals.size()); 
				completeResult.addAll(result);
				completeResult.addAll(qvtAdditionals);	
				result = new ArrayList<EOperation>(completeResult);
			}
			
			return result;
		}

		@Override
		protected void setFactory(EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral,
				EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> factory) {
			super.setFactory(factory);
		}
		
		private void initiliazeImports() {
			assert fQVTdelegate != null;
			
			setOption(ParsingOptions.implicitRootClass(this), QvtOperationalStdLibrary.INSTANCE.getElementType());
			
			QvtOperationalStdLibrary.INSTANCE.importTo(fQVTdelegate);			
			for (Module nextImport : OCLEnvironmentWithQVTAccessFactory.this.fImportedModules) {
				fQVTdelegate.addImport(ImportKind.ACCESS, (QvtOperationalEnv)ASTBindingHelper.resolveEnvironment(nextImport));
			}
		}
	}

	private static class EvalEnvImpl extends EcoreEvaluationEnvironment {

		private NonTransformationExecutionContext fExecCtx;
		
		public EvalEnvImpl(NonTransformationExecutionContext execCtx, 
				EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
			super(parent == null ? new EcoreEvaluationEnvironment((EcoreEnvironmentFactory) null) : parent);
			fExecCtx = execCtx;
		}
		
		@Override
		public boolean overrides(EOperation operation, int opcode) {
			if(QvtOperationalParserUtil.getOwningModule(operation) != null) {
				// the operation must have come from QVT
				return true;
			}
			
			return false;
		}
		
		@Override
		public Object callOperation(EOperation operation, int opcode, Object source, Object[] args) throws IllegalArgumentException {
			CallHandler callHandler = CallHandler.Access.getHandler(operation);
			if(callHandler != null) {
				if(source == null || source == getInvalidResult()) {
					return getInvalidResult();
				}
				
				QvtOperationalEvaluationEnv qvtEvalEnv = fExecCtx.getEvaluator().getOperationalEvaluationEnv();
				ModuleInstance moduleInstance = qvtEvalEnv.getThisOfType(QvtOperationalParserUtil.getOwningModule(operation));
				assert moduleInstance != null;
				return callHandler.invoke(moduleInstance, source, args, qvtEvalEnv);
			}			
			
			if(operation instanceof Helper) {
				Helper helper = (Helper) operation;
				HelperOperationCall call = fExecCtx.createHelperCall((Helper)operation); 
				try {
					Object result = null;  
					if(QvtOperationalParserUtil.isContextual(helper)) {
						result = call.invoke(source, args);
					} else {
						result = call.invoke(args);					
					}
					
					return result;
					
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return getInvalidResult();
				}
			}
			
			return super.callOperation(operation, opcode, source, args);
		}
		
		@Override
		public Object navigateProperty(EStructuralFeature property, List<?> qualifiers, Object target) throws IllegalArgumentException {
				return fExecCtx.getEvaluator().getEvaluationEnvironment()
							.navigateProperty(property, qualifiers, target);
		}
	}
	
	private static EPackage.Registry setupRegistry(EPackage.Registry registry) {
		EPackageRegistryImpl result = new EPackageRegistryImpl();
		result.putAll(registry);
		
		Library stdLibPackage = QvtOperationalStdLibrary.INSTANCE.getStdLibModule();		
		result.put(stdLibPackage.getNsURI(), stdLibPackage);
		
		return result;
	}	
	
	private static Diagnostic createDiagnostic(List<URI> imports, CompiledUnit[] compiledUnits) {
		List<Diagnostic> children = new LinkedList<Diagnostic>();
		
		for (CompiledUnit unit : compiledUnits) {
			Diagnostic unitDiagnostic = CompilerUtils.createUnitProblemDiagnostic(unit);
			
			if(unitDiagnostic.getSeverity() != Diagnostic.OK) {
				children.add(unitDiagnostic);
			}
		}
		
		if(imports.size() != compiledUnits.length) {
			List<URI> unresolved = new ArrayList<URI>();
			for (URI uri : imports) {
				boolean found = false;
				for (CompiledUnit unit : compiledUnits) {
					if(unit.getURI().equals(uri)) {
						found = true;
						break;
					}
				}
				
				if(!found) {
					unresolved.add(uri);
				}
			}
			
			children.add(new BasicDiagnostic(Diagnostic.ERROR,
					DIAGNOSTIC_SOURCE, 0,
					"Unresolved compilation units", unresolved.toArray()));
		}
		
		// TODO - move to the qvto core plugin => externalize String 
		if(!children.isEmpty()) {
			return new BasicDiagnostic(
					DIAGNOSTIC_SOURCE, 0, children,
					"QVT imports diagnostic", null);		
		}
		
		return Diagnostic.OK_INSTANCE;
	}
	
}