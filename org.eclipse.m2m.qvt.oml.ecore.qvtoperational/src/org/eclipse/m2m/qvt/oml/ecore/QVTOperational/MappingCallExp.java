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
 * $Id: MappingCallExp.java,v 1.2 2008/09/30 22:11:49 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.MappingCallExp#isIsStrict <em>Is Strict</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getMappingCallExp()
 * @model
 * @generated
 */
public interface MappingCallExp extends ImperativeCallExp {
	/**
	 * Returns the value of the '<em><b>Is Strict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Strict</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Strict</em>' attribute.
	 * @see #isSetIsStrict()
	 * @see #unsetIsStrict()
	 * @see #setIsStrict(boolean)
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getMappingCallExp_IsStrict()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isIsStrict();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.MappingCallExp#isIsStrict <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Strict</em>' attribute.
	 * @see #isSetIsStrict()
	 * @see #unsetIsStrict()
	 * @see #isIsStrict()
	 * @generated
	 */
	void setIsStrict(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.MappingCallExp#isIsStrict <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsStrict()
	 * @see #isIsStrict()
	 * @see #setIsStrict(boolean)
	 * @generated
	 */
	void unsetIsStrict();

	/**
	 * Returns whether the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.MappingCallExp#isIsStrict <em>Is Strict</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Strict</em>' attribute is set.
	 * @see #unsetIsStrict()
	 * @see #isIsStrict()
	 * @see #setIsStrict(boolean)
	 * @generated
	 */
	boolean isSetIsStrict();

} // MappingCallExp
