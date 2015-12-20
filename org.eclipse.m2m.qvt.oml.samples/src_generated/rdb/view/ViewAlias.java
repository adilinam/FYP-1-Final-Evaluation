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

import rdb.NamedColumnSet;
import rdb.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alias</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.view.ViewAlias#getReferencedTableOrView <em>Referenced Table Or View</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.view.ViewPackage#getViewAlias()
 * @model
 * @generated
 */
public interface ViewAlias extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Referenced Table Or View</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referenced Table Or View</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Table Or View</em>' reference.
	 * @see #setReferencedTableOrView(NamedColumnSet)
	 * @see rdb.view.ViewPackage#getViewAlias_ReferencedTableOrView()
	 * @model required="true"
	 * @generated
	 */
    NamedColumnSet getReferencedTableOrView();

	/**
	 * Sets the value of the '{@link rdb.view.ViewAlias#getReferencedTableOrView <em>Referenced Table Or View</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Table Or View</em>' reference.
	 * @see #getReferencedTableOrView()
	 * @generated
	 */
    void setReferencedTableOrView(NamedColumnSet value);

} // ViewAlias
