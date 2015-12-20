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
package rdb.view;

import org.eclipse.emf.common.util.EList;

import rdb.NamedColumnSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.view.View#getColumns <em>Columns</em>}</li>
 *   <li>{@link rdb.view.View#getReferencedTablesAndViews <em>Referenced Tables And Views</em>}</li>
 *   <li>{@link rdb.view.View#getDdl <em>Ddl</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.view.ViewPackage#getView()
 * @model
 * @generated
 */
public interface View extends NamedColumnSet {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link rdb.view.ViewColumn}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see rdb.view.ViewPackage#getView_Columns()
	 * @model type="rdb.view.ViewColumn" containment="true" required="true"
	 * @generated
	 */
    EList<ViewColumn> getColumns();

	/**
	 * Returns the value of the '<em><b>Referenced Tables And Views</b></em>' containment reference list.
	 * The list contents are of type {@link rdb.view.ViewAlias}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referenced Tables And Views</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Tables And Views</em>' containment reference list.
	 * @see rdb.view.ViewPackage#getView_ReferencedTablesAndViews()
	 * @model type="rdb.view.ViewAlias" containment="true"
	 * @generated
	 */
    EList<ViewAlias> getReferencedTablesAndViews();

	/**
	 * Returns the value of the '<em><b>Ddl</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ddl</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Ddl</em>' attribute.
	 * @see #setDdl(String)
	 * @see rdb.view.ViewPackage#getView_Ddl()
	 * @model
	 * @generated
	 */
    String getDdl();

	/**
	 * Sets the value of the '{@link rdb.view.View#getDdl <em>Ddl</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ddl</em>' attribute.
	 * @see #getDdl()
	 * @generated
	 */
    void setDdl(String value);

} // View
