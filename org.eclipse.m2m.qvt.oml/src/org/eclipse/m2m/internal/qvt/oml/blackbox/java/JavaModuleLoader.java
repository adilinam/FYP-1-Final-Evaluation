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
 *     Christopher Gerking - bugs 289982, 326871
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.blackbox.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.NLS;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.blackbox.LoadContext;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.qvt.oml.blackbox.java.Module;

abstract class JavaModuleLoader {
	
	private BasicDiagnostic fDiagnostics;
	private QvtOperationalModuleEnv fEnv;
	private OperationBuilder fOperBuilder;

	JavaModuleLoader() {
		fDiagnostics = null;
	}

	public QvtOperationalModuleEnv getLoadedModule() {
		return fEnv;
	}
	
	public Diagnostic getDiagnostics() {
		return (fDiagnostics != null) ? fDiagnostics : Diagnostic.OK_INSTANCE;
	}
	
	public Diagnostic loadModule(ModuleHandle moduleHandle, Map<String, List<EOperation>> definedOperations, LoadContext loadContext) {
		fDiagnostics = DiagnosticUtil.createRootDiagnostic(NLS.bind(JavaBlackboxMessages.LoadModuleDiagnostics, moduleHandle));
		Class<?> javaClass;
		try {
			javaClass = moduleHandle.getModuleJavaClass();			
			if(!isModuleClassValid(javaClass)) {
				fDiagnostics.add(DiagnosticUtil.createErrorDiagnostic(NLS.bind(
					JavaBlackboxMessages.InvalidJavaClassForModule, 
					javaClass, moduleHandle)));
				// no sense to continue
				return fDiagnostics;
			}
		} catch (ClassNotFoundException e) {
			fDiagnostics.add(DiagnosticUtil.createErrorDiagnostic(NLS.bind(
				JavaBlackboxMessages.ModuleJavaClassNotFound, moduleHandle.getModuleName()), e));
			// no sense to continue
			return fDiagnostics;
		}
		
		Library module = QvtOperationalStdLibrary.createLibrary(moduleHandle.getModuleName());		
		fEnv = new QvtOperationalEnvFactory(loadContext.getMetamodelRegistry()).createModuleEnvironment(module);
		loadModule(fEnv, javaClass);
		
		Set<String> usedPackages = new LinkedHashSet<String>(moduleHandle.getUsedPackages());
		Module annotation = javaClass.getAnnotation(Module.class);
		if (annotation != null) {
			usedPackages.addAll(Arrays.asList(annotation.packageURIs()));
		}
		
		Java2QVTTypeResolver typeResolver = new Java2QVTTypeResolver(fEnv, 
				resolvePackages(usedPackages, fDiagnostics));
		
		fOperBuilder = new OperationBuilder(typeResolver);
		
		try {
			Method[] methods = javaClass.getDeclaredMethods();
		
			for (Method method : methods) {
				if(!isLibraryOperation(method)) {
					continue;
				}
				
				EOperation operation = fOperBuilder.buildOperation(method);
				Diagnostic operationStatus = fOperBuilder.getDiagnostics();
				if(DiagnosticUtil.isSuccess(operationStatus)) {
					loadOperation(operation, method);
					
					List<EOperation> listOp = definedOperations.get(operation.getName());
					if (listOp == null) {
						listOp = new LinkedList<EOperation>();
						definedOperations.put(operation.getName(), listOp);
					}
					listOp.add(operation);
				}
	
				if(operationStatus.getSeverity() != Diagnostic.OK) {
					fDiagnostics.add(operationStatus);
				}
	 		}
		} catch (NoClassDefFoundError e) {
			fDiagnostics.add(DiagnosticUtil.createErrorDiagnostic(NLS.bind(
					JavaBlackboxMessages.ModuleJavaClassNotLoadable, moduleHandle.getModuleName()), new Exception(e)));
			// no sense to continue
			return fDiagnostics;
		}

		return fDiagnostics;
	}
		
	protected abstract void loadModule(QvtOperationalModuleEnv moduleEnv, Class<?> javaModule);
	protected abstract void loadOperation(EOperation eOperation, Method javaOperation);
	
	private static boolean isLibraryOperation(Method method) {
		return Modifier.isPublic(method.getModifiers());
	}
	
	private static boolean isModuleClassValid(Class<?> javaClass) {
		Class<?>[] noParams = new Class<?>[0];
		try {
			Constructor<?> constructor = javaClass.getDeclaredConstructor(noParams);
			if(!Modifier.isPublic(constructor.getModifiers())) {
				return false;
			}
		} catch (SecurityException e) {
			return false;
		} catch (NoSuchMethodException e) {
			return false;
		}
		
		return Modifier.isPublic(javaClass.getModifiers());
	}
	
	private List<EPackage> resolvePackages(Collection<String> nsURIs, DiagnosticChain diagnosticChain) {
		EPackage.Registry registry = fEnv.getEPackageRegistry();
		List<EPackage> ePackages = new ArrayList<EPackage>(nsURIs.size());
		for (String nextURI : nsURIs) {
			EPackage resolvedPackage;
			try {
				resolvedPackage = registry.getEPackage(nextURI);
			}
			catch (Throwable t) {
				resolvedPackage = null;
			}
			
			if(resolvedPackage != null) {
				ePackages.add(resolvedPackage);				
			} else {
				diagnosticChain.add(DiagnosticUtil.createErrorDiagnostic(
						NLS.bind(JavaBlackboxMessages.UnresolvedMetamodelURI, nextURI)));
			}
		}
		
		return ePackages;
	}
}
