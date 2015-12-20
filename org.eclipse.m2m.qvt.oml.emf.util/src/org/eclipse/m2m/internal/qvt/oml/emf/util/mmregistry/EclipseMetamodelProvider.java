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
package org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtilPlugin;

public abstract class EclipseMetamodelProvider extends DelegatingMetamodelProvider {

	protected EclipseMetamodelProvider() {
		super(Factory.delegate);
	}
	
	static class Factory {
		
		private static IMetamodelProvider delegate;
		
		static synchronized EclipseMetamodelProvider create(IConfigurationElement configElement, IMetamodelProvider delegateProvider) {
			try {
				delegate = delegateProvider; 
				Object extension = configElement.createExecutableExtension("class"); //$NON-NLS-1$
				if(extension instanceof EclipseMetamodelProvider) {
					return (EclipseMetamodelProvider) extension;
				}
			}
			catch(CoreException e) {
				EmfUtilPlugin.getDefault().getLog().log(e.getStatus());
			}
			finally {
				delegate = null;
			}
			
			return null;
		}
		
	}
						
}