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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.constraints.ForeignKey#getReferredUC <em>Referred UC</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.constraints.ConstraintsPackage#getForeignKey()
 * @model
 * @generated
 */
public interface ForeignKey extends ColumnRefConstraint {
	/**
	 * Returns the value of the '<em><b>Referred UC</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referred UC</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred UC</em>' reference.
	 * @see #setReferredUC(UniqueConstraint)
	 * @see rdb.constraints.ConstraintsPackage#getForeignKey_ReferredUC()
	 * @model required="true"
	 * @generated
	 */
    UniqueConstraint getReferredUC();

	/**
	 * Sets the value of the '{@link rdb.constraints.ForeignKey#getReferredUC <em>Referred UC</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred UC</em>' reference.
	 * @see #getReferredUC()
	 * @generated
	 */
    void setReferredUC(UniqueConstraint value);

} // ForeignKey
