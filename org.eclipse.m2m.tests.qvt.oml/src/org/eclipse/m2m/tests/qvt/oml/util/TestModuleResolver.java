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
package org.eclipse.m2m.tests.qvt.oml.util;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.compiler.BlackboxUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.PlatformPluginUnitResolver;
import org.eclipse.m2m.tests.qvt.oml.AllTests;
import org.osgi.framework.Bundle;

public class TestModuleResolver implements UnitResolver {
	
	private UnitResolver fPluginResolver;	
	private IPath fBasePath;
			
	/**
	 * Creates import resolver for this test plug-in.
	 * 
	 * @param sourceContainerPath
	 *            a path relative to the given bundle
	 * @return the resolver instance
	 */
	public static TestModuleResolver createTestPluginResolver(String sourceContainerPath) {
		return new TestModuleResolver(AllTests.BUNDLE_ID, sourceContainerPath);
	}
	
	public TestModuleResolver(final String bundleSymbolicName, final String sourceContainerPath) {
		if(bundleSymbolicName == null || sourceContainerPath == null) {
			throw new IllegalArgumentException();
		}
		
		Bundle bundle =  Platform.getBundle(bundleSymbolicName);
		if(bundle == null) {
			throw new IllegalArgumentException("Bundle not existing: " + bundleSymbolicName); //$NON-NLS-1$
		}
		
		fBasePath = new Path(sourceContainerPath).makeAbsolute();
		
		fPluginResolver = new PlatformPluginUnitResolver(bundle, fBasePath) {
			UnitResolver fBlackboxResolver = new BlackboxUnitResolver(URI.createPlatformPluginURI(bundleSymbolicName, false));

			@Override
			public UnitProxy doResolveUnit(String qualifiedName) {			
				UnitProxy unit = super.doResolveUnit(qualifiedName);
				if(unit == null) {
					unit = fBlackboxResolver.resolveUnit(qualifiedName);
				}
				return unit;
			}
		};
		
	}

	public UnitProxy resolveUnit(String qualifiedName) {
		return fPluginResolver.resolveUnit(qualifiedName);		
//		CFile resolvedImport = fDeployedResolver.resolveUnit(qualifiedName);
//		if(resolvedImport == null) {
//			return fBlackboxResolver.resolveUnit(qualifiedName);			
//		}
//		
//		return DeployedImportResolver.UNIT_RESOLVER_INSTANCE.createUnit(qualifiedName, (BundleFile) resolvedImport);		
	}
}
