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

import rdb.constraints.CheckConstraint;
import rdb.constraints.ForeignKey;
import rdb.constraints.Index;
import rdb.constraints.PrimaryKey;
import rdb.constraints.UniqueConstraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.Table#getColumns <em>Columns</em>}</li>
 *   <li>{@link rdb.Table#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link rdb.Table#getUniqueConstraints <em>Unique Constraints</em>}</li>
 *   <li>{@link rdb.Table#getForeignKeys <em>Foreign Keys</em>}</li>
 *   <li>{@link rdb.Table#getIndices <em>Indices</em>}</li>
 *   <li>{@link rdb.Table#getChecks <em>Checks</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.RdbPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends NamedColumnSet {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link rdb.TableColumn}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see rdb.RdbPackage#getTable_Columns()
	 * @model type="rdb.TableColumn" containment="true" required="true"
	 * @generated
	 */
    EList<TableColumn> getColumns();

	/**
	 * Returns the value of the '<em><b>Primary Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Primary Key</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key</em>' containment reference.
	 * @see #setPrimaryKey(PrimaryKey)
	 * @see rdb.RdbPackage#getTable_PrimaryKey()
	 * @model containment="true"
	 * @generated
	 */
    PrimaryKey getPrimaryKey();

	/**
	 * Sets the value of the '{@link rdb.Table#getPrimaryKey <em>Primary Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Key</em>' containment reference.
	 * @see #getPrimaryKey()
	 * @generated
	 */
    void setPrimaryKey(PrimaryKey value);

	/**
	 * Returns the value of the '<em><b>Unique Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link rdb.constraints.UniqueConstraint}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Unique Constraints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique Constraints</em>' containment reference list.
	 * @see rdb.RdbPackage#getTable_UniqueConstraints()
	 * @model type="rdb.constraints.UniqueConstraint" containment="true"
	 * @generated
	 */
    EList<UniqueConstraint> getUniqueConstraints();

	/**
	 * Returns the value of the '<em><b>Foreign Keys</b></em>' containment reference list.
	 * The list contents are of type {@link rdb.constraints.ForeignKey}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Foreign Keys</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Keys</em>' containment reference list.
	 * @see rdb.RdbPackage#getTable_ForeignKeys()
	 * @model type="rdb.constraints.ForeignKey" containment="true"
	 * @generated
	 */
    EList<ForeignKey> getForeignKeys();

	/**
	 * Returns the value of the '<em><b>Indices</b></em>' containment reference list.
	 * The list contents are of type {@link rdb.constraints.Index}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Indices</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Indices</em>' containment reference list.
	 * @see rdb.RdbPackage#getTable_Indices()
	 * @model type="rdb.constraints.Index" containment="true"
	 * @generated
	 */
    EList<Index> getIndices();

	/**
	 * Returns the value of the '<em><b>Checks</b></em>' containment reference list.
	 * The list contents are of type {@link rdb.constraints.CheckConstraint}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Checks</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Checks</em>' containment reference list.
	 * @see rdb.RdbPackage#getTable_Checks()
	 * @model type="rdb.constraints.CheckConstraint" containment="true"
	 * @generated
	 */
    EList<CheckConstraint> getChecks();

} // Table
