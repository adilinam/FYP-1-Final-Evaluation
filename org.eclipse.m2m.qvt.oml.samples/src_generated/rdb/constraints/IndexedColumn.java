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
package rdb.constraints;

import rdb.NamedElement;
import rdb.TableColumn;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Indexed Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.constraints.IndexedColumn#isAscending <em>Ascending</em>}</li>
 *   <li>{@link rdb.constraints.IndexedColumn#getRefColumn <em>Ref Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.constraints.ConstraintsPackage#getIndexedColumn()
 * @model
 * @generated
 */
public interface IndexedColumn extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Ascending</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ascending</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Ascending</em>' attribute.
	 * @see #setAscending(boolean)
	 * @see rdb.constraints.ConstraintsPackage#getIndexedColumn_Ascending()
	 * @model
	 * @generated
	 */
    boolean isAscending();

	/**
	 * Sets the value of the '{@link rdb.constraints.IndexedColumn#isAscending <em>Ascending</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ascending</em>' attribute.
	 * @see #isAscending()
	 * @generated
	 */
    void setAscending(boolean value);

	/**
	 * Returns the value of the '<em><b>Ref Column</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Column</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Column</em>' reference.
	 * @see #setRefColumn(TableColumn)
	 * @see rdb.constraints.ConstraintsPackage#getIndexedColumn_RefColumn()
	 * @model required="true"
	 * @generated
	 */
    TableColumn getRefColumn();

	/**
	 * Sets the value of the '{@link rdb.constraints.IndexedColumn#getRefColumn <em>Ref Column</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Column</em>' reference.
	 * @see #getRefColumn()
	 * @generated
	 */
    void setRefColumn(TableColumn value);

} // IndexedColumn
