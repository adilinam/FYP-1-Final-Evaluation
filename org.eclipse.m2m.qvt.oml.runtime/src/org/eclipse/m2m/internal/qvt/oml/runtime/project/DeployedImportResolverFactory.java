/*******************************************************************************
 * Copyright (c) 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Christopher Gerking - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;

public class DeployedImportResolverFactory extends UnitResolverFactory {

	@Override
	public boolean accepts(URI uri) {
		return EMFPlugin.IS_ECLIPSE_RUNNING && isDeployedByID(uri);
	}

	@Override
	public UnitResolver getResolver(URI uri) {
		return DeployedImportResolver.INSTANCE;
	}

	@Override
	public String getQualifiedName(URI uri) {
		return uri.path();
	}
	
	private static boolean isDeployedByID(URI uri) {
		return uri.scheme() == null && !uri.hasDevice() && !uri.hasAuthority()
				&& !uri.hasEmptyPath() && !uri.hasQuery() && !uri.hasFragment()
				&& !uri.hasAbsolutePath();
	}

}
