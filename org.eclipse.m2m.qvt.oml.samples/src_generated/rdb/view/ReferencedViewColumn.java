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

import rdb.Column;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Referenced View Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.view.ReferencedViewColumn#getRefColumn <em>Ref Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.view.ViewPackage#getReferencedViewColumn()
 * @model
 * @generated
 */
public interface ReferencedViewColumn extends ViewColumn {
	/**
	 * Returns the value of the '<em><b>Ref Column</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Column</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Column</em>' reference.
	 * @see #setRefColumn(Column)
	 * @see rdb.view.ViewPackage#getReferencedViewColumn_RefColumn()
	 * @model required="true"
	 * @generated
	 */
    Column getRefColumn();

	/**
	 * Sets the value of the '{@link rdb.view.ReferencedViewColumn#getRefColumn <em>Ref Column</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Column</em>' reference.
	 * @see #getRefColumn()
	 * @generated
	 */
    void setRefColumn(Column value);

} // ReferencedViewColumn
