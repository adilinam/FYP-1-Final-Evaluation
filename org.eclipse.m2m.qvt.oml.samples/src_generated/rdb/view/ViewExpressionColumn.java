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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.view.ViewExpressionColumn#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.view.ViewPackage#getViewExpressionColumn()
 * @model
 * @generated
 */
public interface ViewExpressionColumn extends ViewColumn {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expression</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see rdb.view.ViewPackage#getViewExpressionColumn_Expression()
	 * @model
	 * @generated
	 */
    String getExpression();

	/**
	 * Sets the value of the '{@link rdb.view.ViewExpressionColumn#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
    void setExpression(String value);

} // ViewExpressionColumn
