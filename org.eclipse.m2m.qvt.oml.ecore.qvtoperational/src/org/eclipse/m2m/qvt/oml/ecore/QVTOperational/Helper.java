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
 * $Id: Helper.java,v 1.2 2008/09/30 22:11:49 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Helper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Helper#isIsQuery <em>Is Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getHelper()
 * @model
 * @generated
 */
public interface Helper extends ImperativeOperation {
	/**
	 * Returns the value of the '<em><b>Is Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Query</em>' attribute.
	 * @see #isSetIsQuery()
	 * @see #unsetIsQuery()
	 * @see #setIsQuery(boolean)
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getHelper_IsQuery()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isIsQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Helper#isIsQuery <em>Is Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Query</em>' attribute.
	 * @see #isSetIsQuery()
	 * @see #unsetIsQuery()
	 * @see #isIsQuery()
	 * @generated
	 */
	void setIsQuery(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Helper#isIsQuery <em>Is Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsQuery()
	 * @see #isIsQuery()
	 * @see #setIsQuery(boolean)
	 * @generated
	 */
	void unsetIsQuery();

	/**
	 * Returns whether the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Helper#isIsQuery <em>Is Query</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Query</em>' attribute is set.
	 * @see #unsetIsQuery()
	 * @see #isIsQuery()
	 * @see #setIsQuery(boolean)
	 * @generated
	 */
	boolean isSetIsQuery();

} // Helper
