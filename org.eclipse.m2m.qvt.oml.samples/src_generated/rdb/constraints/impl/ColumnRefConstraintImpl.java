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
package rdb.constraints.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import rdb.TableColumn;
import rdb.constraints.ColumnRefConstraint;
import rdb.constraints.ConstraintsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column Ref Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.constraints.impl.ColumnRefConstraintImpl#getIncludedColumns <em>Included Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ColumnRefConstraintImpl extends ConstraintImpl implements ColumnRefConstraint {
	/**
	 * The cached value of the '{@link #getIncludedColumns() <em>Included Columns</em>}' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getIncludedColumns()
	 * @generated
	 * @ordered
	 */
    protected EList<TableColumn> includedColumns = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ColumnRefConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				protected EClass eStaticClass() {
		return ConstraintsPackage.Literals.COLUMN_REF_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<TableColumn> getIncludedColumns() {
		if (includedColumns == null) {
			includedColumns = new EObjectResolvingEList<TableColumn>(TableColumn.class, this, ConstraintsPackage.COLUMN_REF_CONSTRAINT__INCLUDED_COLUMNS);
		}
		return includedColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__INCLUDED_COLUMNS:
				return getIncludedColumns();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__INCLUDED_COLUMNS:
				getIncludedColumns().clear();
				getIncludedColumns().addAll((Collection<? extends TableColumn>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__INCLUDED_COLUMNS:
				getIncludedColumns().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__INCLUDED_COLUMNS:
				return includedColumns != null && !includedColumns.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ColumnRefConstraintImpl
