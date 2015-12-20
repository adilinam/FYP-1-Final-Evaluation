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
package org.eclipse.m2m.internal.qvt.oml.ocl.transformations;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.internal.qvt.oml.blackbox.AbstractCompilationUnitDescriptor;
import org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandlerAdapter;
import org.eclipse.ocl.Environment;

/**
 * This class facilitates registration and invocation of legacy java native
 * operation hooked into QVT environments.
 * <p>
 * Remark: It has come from the initial contribution.
 */
public class LegacyNativeLibSupport {

	public static final LegacyNativeLibSupport INSTANCE = createInstance(); 
	
	private LegacyNativeLibSupport() {
	}
	
	public QvtOperationalModuleEnv defineLibrary(Library lib, Map<String, List<EOperation>> definedOperations) throws LibraryCreationException {
		org.eclipse.m2m.internal.qvt.oml.expressions.Library libModule = QvtOperationalStdLibrary.createLibrary(lib.getId());		
		// FIXME - set isBlackBox=TRUE, as soon is it gets into the AST metamodel
				
        QvtOperationalModuleEnv libEnv = initLibEnvironment(lib, libModule);
        URI libUri = URI.createHierarchicalURI(AbstractCompilationUnitDescriptor.URI_SCHEME, AbstractCompilationUnitDescriptor.URI_AUTHORITY,
        		null, new String[] {lib.getId()}, null, null);
		libModule.eResource().setURI(libUri);

		org.eclipse.m2m.internal.qvt.oml.expressions.Library opModule = QvtOperationalStdLibrary.createLibrary(lib.getId());
		QvtOperationalModuleEnv opEnv = initLibEnvironment(lib, opModule);
		
		for (LibraryOperation libOp : lib.getLibraryOperations()) {
	        Helper helper = defineOperation(opModule, opEnv, libOp); 
	        
			libEnv.defineImperativeOperation(helper, false, true);
			
			List<EOperation> listOp = definedOperations.get(helper.getName());
			if (listOp == null) {
				listOp = new LinkedList<EOperation>();
				definedOperations.put(helper.getName(), listOp);
			}
			listOp.add(helper);
		}
		
		// FIXME - workaround to make Environment available with the module
		ASTBindingHelper.createCST2ASTBinding(CSTFactory.eINSTANCE.createLibraryCS(), libEnv.getModuleContextType(), libEnv);		
		return libEnv;
	}

	private static QvtOperationalModuleEnv initLibEnvironment(Library lib, Module libModule) {
		EPackage.Registry registry = new EPackageRegistryImpl();
		QvtOperationalModuleEnv libEnv = new QvtOperationalEnvFactory(registry).createModuleEnvironment(libModule);
		
		EPackage.Registry libEnvRegistry = libEnv.getEPackageRegistry();
		// set our desired stdlib version to be resolved by oclstdlib package name
		EPackage oclStdlibPackage = libEnv.getOCLStandardLibrary().getOclAny().getEPackage();
		libEnv.getEPackageRegistry().put(oclStdlibPackage.getNsURI(), oclStdlibPackage);
		
		if (lib.getInMetamodels() != null) {
			for (String mm : lib.getInMetamodels()) {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(mm);
				if(ePackage != null) {
					libEnvRegistry.put(mm, ePackage);
				}
			}
		}
		if (lib.getOutMetamodels() != null) {
			for (String mm : lib.getOutMetamodels()) {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(mm);
				if(ePackage != null) {
					libEnvRegistry.put(mm, ePackage);
				}
			}
		}
		return libEnv;
	}
		
	private static class Handler extends CallHandler {
		private LibraryOperation fOperation;
		private Class<?> fReturnClass;

		private Handler(LibraryOperation operation, Class<?> returnClass) {
			assert operation != null;
			fOperation = operation;
			fReturnClass = returnClass;
		}
		
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {		
			return callOperation(evalEnv, fOperation, source, args, fReturnClass);
		}
	}
	

	private static Object callOperation(QvtOperationalEvaluationEnv evalEnv,
			LibraryOperation libOp, Object source, Object[] args, Class<?> returnClass) {
		
		if(source == null || source == CallHandlerAdapter.getInvalidResult(evalEnv)) {
			return CallHandlerAdapter.getInvalidResult(evalEnv);
		}
		
        // reset OclInvalid to 'null'
    	Object[] callArgs = null;            
        if(args != null) {
            for (int i = 0; i < args.length; i++) {
            	if(evalEnv.isOclInvalid(args[i])) {
            		if(callArgs == null) {
            			callArgs = new Object[args.length];
            			System.arraycopy(args, 0, callArgs, 0, args.length);
            		}
            		callArgs[i] = null;
            	}
    		}
            callArgs = (callArgs == null) ? args : callArgs;
        }

        Object result = libOp.run(source, callArgs, new Object[0], returnClass);
        if (result == null) {
            return QvtOperationalUtil.getInvalid(evalEnv);
        }
        return result;
	}
	
	private Helper defineOperation(org.eclipse.m2m.internal.qvt.oml.expressions.Library opModule, QvtOperationalModuleEnv opEnv,
			LibraryOperation libOp) throws LibraryCreationException {
		QvtLibraryOperation qvtLibOp = new QvtLibraryOperation(opEnv, libOp);
		
		Helper helper = org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createHelper();
		helper.setName(libOp.getName());
		helper.setEType(qvtLibOp.getReturnType());
		int index = 1;
		for (EClassifier type : qvtLibOp.getParamTypes()) {
			VarParameter varParam = org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createVarParameter();
			varParam.setKind(DirectionKind.IN);
			varParam.setEType(type);
			varParam.setName("arg" + index); //$NON-NLS-1$;
			++index;		        
			helper.getEParameters().add(varParam);
		}
		if (qvtLibOp.getContextType() != opModule) {
			VarParameter varParam = org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createVarParameter();
			varParam.setKind(DirectionKind.IN);
			varParam.setEType(qvtLibOp.getContextType());
			varParam.setName(Environment.SELF_VARIABLE_NAME);
			helper.setContext(varParam);
		}
		
		Class<?> returnClass = (helper.getEType() != null) ? helper.getEType().getInstanceClass() : null;
		CallHandlerAdapter.attach(helper, new Handler(libOp, returnClass));
		return helper;
	}
		
	private static LegacyNativeLibSupport createInstance() {
		LegacyNativeLibSupport lib = new LegacyNativeLibSupport();
		return lib;
	}			
}
