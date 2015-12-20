/*******************************************************************************
 * Copyright (c) 2009, 2014 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *     Christopher Gerking - bug 326871
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.blackbox.java;

import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

class BundleModuleHandle extends ModuleHandle {

	private final String bundleId;
	private final List<String> usedPackages;		
	
	BundleModuleHandle(String bundleId, String className, String moduleName, List<String> usedPackages) {
		super(className, moduleName);
		
		if(bundleId == null || usedPackages == null) {
			throw new IllegalArgumentException();
		}

		this.bundleId = bundleId;
		this.usedPackages = usedPackages;
	}
	
	public List<String> getUsedPackages() {
		return usedPackages;
	}
	
	@Override
	public Class<?> getModuleJavaClass() throws ClassNotFoundException {
		Bundle bundle = Platform.getBundle(bundleId);
		if(bundle != null) {
			return bundle.loadClass(getJavaClassName());
		}
		return getClass().getClassLoader().loadClass(getJavaClassName());
	}
	
	@Override
	public String toString() {			
		return super.toString() + ", bundle: " + bundleId; //$NON-NLS-1$
	}				
}