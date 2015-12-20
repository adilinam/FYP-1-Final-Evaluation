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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schema Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.SchemaElement#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.RdbPackage#getSchemaElement()
 * @model abstract="true"
 * @generated
 */
public interface SchemaElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owner</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see #setOwner(String)
	 * @see rdb.RdbPackage#getSchemaElement_Owner()
	 * @model
	 * @generated
	 */
    String getOwner();

	/**
	 * Sets the value of the '{@link rdb.SchemaElement#getOwner <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #getOwner()
	 * @generated
	 */
    void setOwner(String value);

} // SchemaElement
