/*******************************************************************************
 * Copyright (c) 2008, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bugs 289982, 427237
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ocl.transformations;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.blackbox.AbstractBlackboxProvider;
import org.eclipse.m2m.internal.qvt.oml.blackbox.AbstractCompilationUnitDescriptor;
import org.eclipse.m2m.internal.qvt.oml.blackbox.BlackboxException;
import org.eclipse.m2m.internal.qvt.oml.blackbox.CompilationUnit;
import org.eclipse.m2m.internal.qvt.oml.blackbox.LoadContext;
import org.eclipse.m2m.internal.qvt.oml.blackbox.OperationMatcher;
import org.eclipse.m2m.internal.qvt.oml.blackbox.ResolutionContext;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.ocl.OclQvtoPlugin;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandlerAdapter;

public class LegacyNativeLibraryProviderAdapter extends AbstractBlackboxProvider {
	
	private Map<String, AbstractCompilationUnitDescriptor> fDescriptorMap;
	private final Map<LibraryDescriptor, CompilationUnit> fBlackboxUnits = new LinkedHashMap<LibraryDescriptor, CompilationUnit>();
	
	public LegacyNativeLibraryProviderAdapter() {
		super();
	}

	@Override
	public Collection<AbstractCompilationUnitDescriptor> getModuleDescriptors(ResolutionContext loadContext) {
		return getDescriptorMap().values();
	}
	
	@Override
	public AbstractCompilationUnitDescriptor getModuleDescriptor(String qualifiedName, ResolutionContext resolutionContext) {
		return getDescriptorMap().get(qualifiedName);		
	}
	
	@Override
	public CompilationUnit loadCompilationUnit(AbstractCompilationUnitDescriptor descriptor, LoadContext loadContext) throws BlackboxException {
		if(descriptor instanceof LibraryDescriptor == false) {
			throw new IllegalArgumentException("Descriptor not recognized by provider"); //$NON-NLS-1$
		}
		LibraryDescriptor libDescriptor = (LibraryDescriptor) descriptor;
		
		if (fBlackboxUnits.containsKey(libDescriptor)) {
			return fBlackboxUnits.get(libDescriptor);
		}
		
		try {
			CompilationUnit compilationUnit = createCompilationUnit(LegacyNativeLibSupport.INSTANCE.defineLibrary(libDescriptor.fLibrary, libDescriptor.fDefinedOperations));			
			fBlackboxUnits.put(libDescriptor, compilationUnit);
			return compilationUnit;
		} catch (LibraryCreationException e) {
			fBlackboxUnits.put(libDescriptor, null);
			throw new BlackboxException(e.getMessage(), e);			
		}
	}
	
	@Override
	public void cleanup() {
		fBlackboxUnits.clear();
		fDescriptorMap = null;
	}
	
	private Map<String, AbstractCompilationUnitDescriptor> getDescriptorMap() {
		if (fDescriptorMap != null) {
			return fDescriptorMap;
		}
		
		LibrariesRegistry registry = OclQvtoPlugin.getDefault().getLibrariesRegistry();

		fDescriptorMap = new LinkedHashMap<String, AbstractCompilationUnitDescriptor>(registry.getLibraries().size());
		for (final Library lib : registry.getLibraries()) {
			fDescriptorMap.put(lib.getId(), new LibraryDescriptor(lib));			
		}
		
		return fDescriptorMap;
	}
	
	
	private class LibraryDescriptor extends AbstractCompilationUnitDescriptor {

		private final Library fLibrary;
		private final Map<String, List<EOperation>> fDefinedOperations;
		
		protected LibraryDescriptor(Library library) {
			super(LegacyNativeLibraryProviderAdapter.this, library.getId());
			fLibrary = library;
			fDefinedOperations = new LinkedHashMap<String, List<EOperation>>();
		}
				
		@Override
		public String getDescription() {
			return fLibrary.getLibraryClassName();
		}
		
		public Collection<CallHandler> getBlackboxCallHandler(ImperativeOperation imperativeOp, QvtOperationalModuleEnv env) {
			if (!env.getImportedNativeLibs().isEmpty()) {
				Set<String> importedLibs = env.getImportedNativeLibs().get(getURI());
				if (!importedLibs.contains(fLibrary.getId())) {
					return Collections.emptyList();
				}
			}
			
			List<EOperation> listOp = fDefinedOperations.get(imperativeOp.getName());
			if (listOp == null) {
				return Collections.emptyList();
			}
			
			Collection<CallHandler> result = Collections.emptyList();
			for (EOperation libraryOp : listOp) {
				if (OperationMatcher.matchOperation(env, imperativeOp, libraryOp)) {
					if (result.isEmpty()) {
						result = new LinkedList<CallHandler>();
					}
					result.add(CallHandlerAdapter.getDispatcher(libraryOp));
				}
			}
			
			return result;
		}
		
		public Collection<CallHandler> getBlackboxCallHandler(OperationalTransformation operationalTrans, QvtOperationalModuleEnv env) {
			if (!env.getImportedNativeLibs().isEmpty()) {
				Set<String> importedLibs = env.getImportedNativeLibs().get(getURI());
				if (!importedLibs.contains(fLibrary.getId())) {
					return Collections.emptyList();
				}
			}
			
			List<EOperation> listOp = fDefinedOperations.get(operationalTrans.getName());
			if (listOp == null) {
				return Collections.emptyList();
			}
			
			Collection<CallHandler> result = Collections.emptyList();
			for (EOperation libraryOp : listOp) {
				if (OperationMatcher.matchOperation(env, operationalTrans, libraryOp)) {
					if (result.isEmpty()) {
						result = new LinkedList<CallHandler>();
					}
					result.add(CallHandlerAdapter.getDispatcher(libraryOp));
				}
			}
			
			return result;
		}
		
	}	
}
