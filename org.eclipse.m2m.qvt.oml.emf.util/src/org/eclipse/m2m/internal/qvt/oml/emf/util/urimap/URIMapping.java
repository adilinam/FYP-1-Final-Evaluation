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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>URI Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping#getSourceURI <em>Source URI</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping#getTargetURI <em>Target URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapPackage#getURIMapping()
 * @model
 * @generated
 */
public interface URIMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Source URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source URI</em>' attribute.
	 * @see #setSourceURI(String)
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapPackage#getURIMapping_SourceURI()
	 * @model required="true"
	 * @generated
	 */
	String getSourceURI();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping#getSourceURI <em>Source URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source URI</em>' attribute.
	 * @see #getSourceURI()
	 * @generated
	 */
	void setSourceURI(String value);

	/**
	 * Returns the value of the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target URI</em>' attribute.
	 * @see #setTargetURI(String)
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapPackage#getURIMapping_TargetURI()
	 * @model required="true"
	 * @generated
	 */
	String getTargetURI();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping#getTargetURI <em>Target URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target URI</em>' attribute.
	 * @see #getTargetURI()
	 * @generated
	 */
	void setTargetURI(String value);

} // URIMapping
