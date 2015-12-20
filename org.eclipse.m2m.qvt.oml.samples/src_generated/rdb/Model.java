/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package rdb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.Model#getSchemas <em>Schemas</em>}</li>
 *   <li>{@link rdb.Model#getServer_id <em>Server id</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.RdbPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Schemas</b></em>' containment reference list.
	 * The list contents are of type {@link rdb.Schema}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Schemas</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Schemas</em>' containment reference list.
	 * @see rdb.RdbPackage#getModel_Schemas()
	 * @model type="rdb.Schema" containment="true"
	 * @generated
	 */
    EList<Schema> getSchemas();

	/**
	 * Returns the value of the '<em><b>Server id</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Server id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Server id</em>' attribute.
	 * @see #setServer_id(String)
	 * @see rdb.RdbPackage#getModel_Server_id()
	 * @model
	 * @generated
	 */
    String getServer_id();

	/**
	 * Sets the value of the '{@link rdb.Model#getServer_id <em>Server id</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server id</em>' attribute.
	 * @see #getServer_id()
	 * @generated
	 */
    void setServer_id(String value);

} // Model
