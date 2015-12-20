/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;

public class QVTODebugUtil {
	
	private QVTODebugUtil() {
		super();
	}

	public static URI getResourceURI(IResource resource) {
		return URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
	}
	
	public static IFile toFile(URI uri) {
		List<IFile> files = toFiles(uri);
		return files.isEmpty() ? null : files.get(0);
	}
	
	public static List<IFile> toFiles(URI uri) {
		if(uri.isPlatformResource()) {
			String platformString = uri.toPlatformString(true);
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
			return Collections.singletonList(file);
		} else if(uri.isFile()) {
			java.net.URI javaURI;
			try {
				javaURI = java.net.URI.create(uri.toString());
			} catch(IllegalArgumentException e) {
				// not a valid EMF uri, can't look for IFile
				QVTODebugCore.log(e);
				return Collections.emptyList();
			}
			
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(javaURI);
			List<IFile> result = new ArrayList<IFile>(files.length);
			
			for (IFile nextFile : files) {
				result.add(nextFile);
			}
			return result;
		}
		return Collections.emptyList();
	}
	
	public static void refreshInWorkspace(List<URI> uris) {
		Set<IContainer> containers = new HashSet<IContainer>();
		for (URI nextURI : uris) {
			List<IFile> files = toFiles(nextURI);
			for (IFile iFile : files) {
				containers.add(iFile.getParent());
			}
		}

		for (IContainer iContainer : containers) {
			try {
				iContainer.refreshLocal(IResource.DEPTH_ONE, null);		
			} catch (CoreException e) {
				QVTODebugCore.log(e.getStatus());
			}			
		}
	}
	
	public static URI toFileURI(String uriStr) {
		URI uri = URI.createURI(uriStr);
		if(uri.isPlatformResource()) {
			URI baseURI = URI.createURI(ResourcesPlugin.getWorkspace().getRoot().getLocationURI().toString());
			uri = URI.createURI(baseURI.toString() + uri.toPlatformString(true), true);			
		}
 		return uri;
	}
			
	public static IStatus createDebugError(String message, Throwable throwable) {
		return QVTODebugCore.createStatus(IStatus.ERROR, message, throwable);
	}
	
	public static IStatus createDebugError(String message) {
		return QVTODebugCore.createStatus(IStatus.ERROR, message, null);
	}

	public static QvtOperationalModuleEnv getEnvironment(Module module) {
		return ASTBindingHelper.getEnvironment(module, QvtOperationalModuleEnv.class);
	}

	public static void attachEnvironment(CompiledUnit unit) {
		HashSet<CompiledUnit> allUnits = new HashSet<CompiledUnit>();		
		QvtOperationalParserUtil.collectAllImports(unit, allUnits);
		allUnits.add(unit);
		for (CompiledUnit nextUnit : allUnits) {
			for(QvtOperationalModuleEnv moduleEnv : nextUnit.getModuleEnvironments()) {
				Module module = moduleEnv.getModuleContextType();
				if(module != null) {
					ASTBindingHelper.setEnvironment(module, moduleEnv);
				}
			}
		}
	}
		
}
