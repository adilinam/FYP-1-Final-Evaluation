/**
 * <copyright>
 * Copyright (c) 2008 Open Canarias and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTOperationalEditPlugin.java,v 1.3 2009/12/09 14:02:29 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.provider;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.provider.ImperativeOCLEditPlugin;
import org.eclipse.ocl.ecore.edit.OCLEcoreEditPlugin;
import org.eclipse.ocl.edit.OCLEditPlugin;
import org.eclipse.qvt.declarative.ecore.QVTBase.provider.QVTBaseEditPlugin;
import org.eclipse.qvt.declarative.ecore.QVTRelation.provider.QVTRelationEditPlugin;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.provider.QVTTemplateEditPlugin;


/**
 * This is the central singleton for the QVTOperational edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class QVTOperationalEditPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTOperationalEditPlugin INSTANCE = new QVTOperationalEditPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTOperationalEditPlugin() {
		super
		  (new ResourceLocator [] {
		     EcoreEditPlugin.INSTANCE,
		     ImperativeOCLEditPlugin.INSTANCE,
		     QVTBaseEditPlugin.INSTANCE,
		     QVTRelationEditPlugin.INSTANCE,
		     QVTTemplateEditPlugin.INSTANCE,
		     OCLEditPlugin.INSTANCE,
		     OCLEcoreEditPlugin.INSTANCE,
		   });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

}
