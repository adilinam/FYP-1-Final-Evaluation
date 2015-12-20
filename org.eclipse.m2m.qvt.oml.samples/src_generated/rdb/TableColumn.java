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

import rdb.datatypes.Domain;
import rdb.datatypes.PrimitiveDataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.TableColumn#getDomain <em>Domain</em>}</li>
 *   <li>{@link rdb.TableColumn#getType <em>Type</em>}</li>
 *   <li>{@link rdb.TableColumn#getIsPrimaryKey <em>Is Primary Key</em>}</li>
 *   <li>{@link rdb.TableColumn#getIsForeignKey <em>Is Foreign Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.RdbPackage#getTableColumn()
 * @model
 * @generated
 */
public interface TableColumn extends Column {
	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Domain</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see #setDomain(Domain)
	 * @see rdb.RdbPackage#getTableColumn_Domain()
	 * @model
	 * @generated
	 */
    Domain getDomain();

	/**
	 * Sets the value of the '{@link rdb.TableColumn#getDomain <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' reference.
	 * @see #getDomain()
	 * @generated
	 */
    void setDomain(Domain value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(PrimitiveDataType)
	 * @see rdb.RdbPackage#getTableColumn_Type()
	 * @model containment="true"
	 * @generated
	 */
    PrimitiveDataType getType();

	/**
	 * Sets the value of the '{@link rdb.TableColumn#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
    void setType(PrimitiveDataType value);

	/**
	 * Returns the value of the '<em><b>Is Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Primary Key</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Primary Key</em>' attribute.
	 * @see #setIsPrimaryKey(Boolean)
	 * @see rdb.RdbPackage#getTableColumn_IsPrimaryKey()
	 * @model
	 * @generated
	 */
    Boolean getIsPrimaryKey();

	/**
	 * Sets the value of the '{@link rdb.TableColumn#getIsPrimaryKey <em>Is Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Primary Key</em>' attribute.
	 * @see #getIsPrimaryKey()
	 * @generated
	 */
    void setIsPrimaryKey(Boolean value);

	/**
	 * Returns the value of the '<em><b>Is Foreign Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Foreign Key</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Foreign Key</em>' attribute.
	 * @see #setIsForeignKey(Boolean)
	 * @see rdb.RdbPackage#getTableColumn_IsForeignKey()
	 * @model
	 * @generated
	 */
    Boolean getIsForeignKey();

	/**
	 * Sets the value of the '{@link rdb.TableColumn#getIsForeignKey <em>Is Foreign Key</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Foreign Key</em>' attribute.
	 * @see #getIsForeignKey()
	 * @generated
	 */
    void setIsForeignKey(Boolean value);

} // TableColumn
