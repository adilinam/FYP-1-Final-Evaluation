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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.constraints.Index#getIndexedColumns <em>Indexed Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.constraints.ConstraintsPackage#getIndex()
 * @model
 * @generated
 */
public interface Index extends Constraint {
	/**
	 * Returns the value of the '<em><b>Indexed Columns</b></em>' containment reference list.
	 * The list contents are of type {@link rdb.constraints.IndexedColumn}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Indexed Columns</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Indexed Columns</em>' containment reference list.
	 * @see rdb.constraints.ConstraintsPackage#getIndex_IndexedColumns()
	 * @model type="rdb.constraints.IndexedColumn" containment="true"
	 * @generated
	 */
    EList<IndexedColumn> getIndexedColumns();

} // Index
