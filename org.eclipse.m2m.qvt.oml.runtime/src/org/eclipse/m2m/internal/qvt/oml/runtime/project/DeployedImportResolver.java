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
 *     Christopher Gerking - bugs 319076, 465184
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import org.eclipse.m2m.internal.qvt.oml.common.project.CompiledTransformation;
import org.eclipse.m2m.internal.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.compiler.BlackboxUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.DelegatingUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;

public class DeployedImportResolver extends DelegatingUnitResolver {
		
	/**
	 * A single instance registry including all bundles with registered QVT
	 * modules in the platform.
	 */
	public static final DeployedImportResolver INSTANCE = new DeployedImportResolver(QvtTransformationRegistry.getInstance());
	
	private TransformationRegistry transformationRegistry;
	
	
	/**
	 * Constructs a resolver based on the given transformation registry.
	 * 
	 * @param transformationRegistry
	 *            a registry of deployed QVT transformations
	 */
	private DeployedImportResolver(TransformationRegistry transformationRegistry) {
		if(transformationRegistry == null) {
			throw new IllegalArgumentException();
		}
		this.transformationRegistry = transformationRegistry;
		setParent(BlackboxUnitResolver.DEFAULT);
	}
	
	@Override
	protected UnitProxy doResolveUnit(String qualifiedName) {
		CompiledTransformation transformation = transformationRegistry.getSingleTransformationById(qualifiedName);
				
		return transformation == null ? null : UnitResolverFactory.Registry.INSTANCE.getUnit(transformation.getUri());
	}

}
