/**
 * <copyright>
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 * </copyright>
 *
 * $Id: QVTOperationalPlugin.java,v 1.1 2009/01/25 23:12:23 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.util;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

public class QVTOperationalPlugin extends EMFPlugin {
	
	/**
	 * The singleton instance of the plugin.
	 */
	public static final QVTOperationalPlugin INSTANCE = new QVTOperationalPlugin();

	/**
	 * The plugin singleton
	 */
	private static Implementation plugin;	

	/**
	 * Creates the singleton instance.
	 */
	private QVTOperationalPlugin() {
		super(new ResourceLocator[] {});
	}

	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	static public class Implementation extends EclipsePlugin {
		
		public Implementation()	{
			super();
			plugin = this;
		}		
	}
}