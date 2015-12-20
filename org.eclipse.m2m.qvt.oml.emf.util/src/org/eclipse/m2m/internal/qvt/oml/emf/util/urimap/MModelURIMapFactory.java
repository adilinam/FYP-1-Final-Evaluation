/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.emf.util.urimap;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapPackage
 * @generated
 */
public interface MModelURIMapFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MModelURIMapFactory eINSTANCE = org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.MModelURIMapFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Mapping Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Container</em>'.
	 * @generated
	 */
	MappingContainer createMappingContainer();

	/**
	 * Returns a new object of class '<em>URI Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>URI Mapping</em>'.
	 * @generated
	 */
	URIMapping createURIMapping();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MModelURIMapPackage getMModelURIMapPackage();

} //MModelURIMapFactory
