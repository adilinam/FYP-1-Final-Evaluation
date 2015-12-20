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
package rdb.datatypes;

import rdb.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.datatypes.DataType#getSize <em>Size</em>}</li>
 *   <li>{@link rdb.datatypes.DataType#getDecimalDigits <em>Decimal Digits</em>}</li>
 *   <li>{@link rdb.datatypes.DataType#isNullable <em>Nullable</em>}</li>
 *   <li>{@link rdb.datatypes.DataType#getDefault <em>Default</em>}</li>
 *   <li>{@link rdb.datatypes.DataType#getCheck <em>Check</em>}</li>
 *   <li>{@link rdb.datatypes.DataType#getVar <em>Var</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.datatypes.DatatypesPackage#getDataType()
 * @model abstract="true"
 * @generated
 */
public interface DataType extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Size</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see rdb.datatypes.DatatypesPackage#getDataType_Size()
	 * @model
	 * @generated
	 */
    int getSize();

	/**
	 * Sets the value of the '{@link rdb.datatypes.DataType#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
    void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Decimal Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Decimal Digits</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Decimal Digits</em>' attribute.
	 * @see #setDecimalDigits(int)
	 * @see rdb.datatypes.DatatypesPackage#getDataType_DecimalDigits()
	 * @model
	 * @generated
	 */
    int getDecimalDigits();

	/**
	 * Sets the value of the '{@link rdb.datatypes.DataType#getDecimalDigits <em>Decimal Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decimal Digits</em>' attribute.
	 * @see #getDecimalDigits()
	 * @generated
	 */
    void setDecimalDigits(int value);

	/**
	 * Returns the value of the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nullable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Nullable</em>' attribute.
	 * @see #setNullable(boolean)
	 * @see rdb.datatypes.DatatypesPackage#getDataType_Nullable()
	 * @model
	 * @generated
	 */
    boolean isNullable();

	/**
	 * Sets the value of the '{@link rdb.datatypes.DataType#isNullable <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nullable</em>' attribute.
	 * @see #isNullable()
	 * @generated
	 */
    void setNullable(boolean value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(String)
	 * @see rdb.datatypes.DatatypesPackage#getDataType_Default()
	 * @model
	 * @generated
	 */
    String getDefault();

	/**
	 * Sets the value of the '{@link rdb.datatypes.DataType#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #getDefault()
	 * @generated
	 */
    void setDefault(String value);

	/**
	 * Returns the value of the '<em><b>Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Check</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Check</em>' attribute.
	 * @see #setCheck(String)
	 * @see rdb.datatypes.DatatypesPackage#getDataType_Check()
	 * @model
	 * @generated
	 */
    String getCheck();

	/**
	 * Sets the value of the '{@link rdb.datatypes.DataType#getCheck <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check</em>' attribute.
	 * @see #getCheck()
	 * @generated
	 */
    void setCheck(String value);

	/**
	 * Returns the value of the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Var</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Var</em>' attribute.
	 * @see #setVar(String)
	 * @see rdb.datatypes.DatatypesPackage#getDataType_Var()
	 * @model
	 * @generated
	 */
    String getVar();

	/**
	 * Sets the value of the '{@link rdb.datatypes.DataType#getVar <em>Var</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var</em>' attribute.
	 * @see #getVar()
	 * @generated
	 */
    void setVar(String value);

} // DataType
