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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rdb.TableColumn;
import rdb.constraints.ConstraintsPackage;
import rdb.constraints.IndexedColumn;
import rdb.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indexed Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.constraints.impl.IndexedColumnImpl#isAscending <em>Ascending</em>}</li>
 *   <li>{@link rdb.constraints.impl.IndexedColumnImpl#getRefColumn <em>Ref Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IndexedColumnImpl extends NamedElementImpl implements IndexedColumn {
	/**
	 * The default value of the '{@link #isAscending() <em>Ascending</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isAscending()
	 * @generated
	 * @ordered
	 */
    protected static final boolean ASCENDING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAscending() <em>Ascending</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isAscending()
	 * @generated
	 * @ordered
	 */
    protected boolean ascending = ASCENDING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefColumn() <em>Ref Column</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getRefColumn()
	 * @generated
	 * @ordered
	 */
    protected TableColumn refColumn = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected IndexedColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				protected EClass eStaticClass() {
		return ConstraintsPackage.Literals.INDEXED_COLUMN;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public boolean isAscending() {
		return ascending;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setAscending(boolean newAscending) {
		boolean oldAscending = ascending;
		ascending = newAscending;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.INDEXED_COLUMN__ASCENDING, oldAscending, ascending));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public TableColumn getRefColumn() {
		if (refColumn != null && refColumn.eIsProxy()) {
			InternalEObject oldRefColumn = (InternalEObject)refColumn;
			refColumn = (TableColumn)eResolveProxy(oldRefColumn);
			if (refColumn != oldRefColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConstraintsPackage.INDEXED_COLUMN__REF_COLUMN, oldRefColumn, refColumn));
			}
		}
		return refColumn;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public TableColumn basicGetRefColumn() {
		return refColumn;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setRefColumn(TableColumn newRefColumn) {
		TableColumn oldRefColumn = refColumn;
		refColumn = newRefColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.INDEXED_COLUMN__REF_COLUMN, oldRefColumn, refColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintsPackage.INDEXED_COLUMN__ASCENDING:
				return isAscending() ? Boolean.TRUE : Boolean.FALSE;
			case ConstraintsPackage.INDEXED_COLUMN__REF_COLUMN:
				if (resolve) return getRefColumn();
				return basicGetRefColumn();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintsPackage.INDEXED_COLUMN__ASCENDING:
				setAscending(((Boolean)newValue).booleanValue());
				return;
			case ConstraintsPackage.INDEXED_COLUMN__REF_COLUMN:
				setRefColumn((TableColumn)newValue);
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
			case ConstraintsPackage.INDEXED_COLUMN__ASCENDING:
				setAscending(ASCENDING_EDEFAULT);
				return;
			case ConstraintsPackage.INDEXED_COLUMN__REF_COLUMN:
				setRefColumn((TableColumn)null);
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
			case ConstraintsPackage.INDEXED_COLUMN__ASCENDING:
				return ascending != ASCENDING_EDEFAULT;
			case ConstraintsPackage.INDEXED_COLUMN__REF_COLUMN:
				return refColumn != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ascending: "); //$NON-NLS-1$
		result.append(ascending);
		result.append(')');
		return result.toString();
	}

} //IndexedColumnImpl
