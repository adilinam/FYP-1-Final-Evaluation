/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.ocl.legacy.libraries;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.EcoreEnvironment;

class Libraries extends Plugin {
	
	public static final String OCL_LIBRARY_PACKAGE =
		EPackage.Registry.INSTANCE.get(EcoreEnvironment.OCL_STANDARD_LIBRARY_NS_URI) instanceof EPackage ?
				((EPackage) EPackage.Registry.INSTANCE.get(EcoreEnvironment.OCL_STANDARD_LIBRARY_NS_URI)).getName() : "oclstdlib"; //$NON-NLS-1$

}
