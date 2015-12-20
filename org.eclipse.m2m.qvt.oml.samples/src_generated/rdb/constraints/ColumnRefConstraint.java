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

import rdb.TableColumn;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column Ref Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.constraints.ColumnRefConstraint#getIncludedColumns <em>Included Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.constraints.ConstraintsPackage#getColumnRefConstraint()
 * @model abstract="true"
 * @generated
 */
public interface ColumnRefConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Included Columns</b></em>' reference list.
	 * The list contents are of type {@link rdb.TableColumn}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Included Columns</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Included Columns</em>' reference list.
	 * @see rdb.constraints.ConstraintsPackage#getColumnRefConstraint_IncludedColumns()
	 * @model type="rdb.TableColumn" required="true"
	 * @generated
	 */
    EList<TableColumn> getIncludedColumns();

} // ColumnRefConstraint
