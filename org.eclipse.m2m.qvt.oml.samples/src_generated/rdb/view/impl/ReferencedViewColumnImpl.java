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
package rdb.view.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rdb.Column;
import rdb.view.ReferencedViewColumn;
import rdb.view.ViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Referenced View Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.view.impl.ReferencedViewColumnImpl#getRefColumn <em>Ref Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferencedViewColumnImpl extends ViewColumnImpl implements ReferencedViewColumn {
	/**
	 * The cached value of the '{@link #getRefColumn() <em>Ref Column</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getRefColumn()
	 * @generated
	 * @ordered
	 */
    protected Column refColumn = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ReferencedViewColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				protected EClass eStaticClass() {
		return ViewPackage.Literals.REFERENCED_VIEW_COLUMN;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Column getRefColumn() {
		if (refColumn != null && refColumn.eIsProxy()) {
			InternalEObject oldRefColumn = (InternalEObject)refColumn;
			refColumn = (Column)eResolveProxy(oldRefColumn);
			if (refColumn != oldRefColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ViewPackage.REFERENCED_VIEW_COLUMN__REF_COLUMN, oldRefColumn, refColumn));
			}
		}
		return refColumn;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Column basicGetRefColumn() {
		return refColumn;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setRefColumn(Column newRefColumn) {
		Column oldRefColumn = refColumn;
		refColumn = newRefColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.REFERENCED_VIEW_COLUMN__REF_COLUMN, oldRefColumn, refColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ViewPackage.REFERENCED_VIEW_COLUMN__REF_COLUMN:
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
			case ViewPackage.REFERENCED_VIEW_COLUMN__REF_COLUMN:
				setRefColumn((Column)newValue);
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
			case ViewPackage.REFERENCED_VIEW_COLUMN__REF_COLUMN:
				setRefColumn((Column)null);
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
			case ViewPackage.REFERENCED_VIEW_COLUMN__REF_COLUMN:
				return refColumn != null;
		}
		return super.eIsSet(featureID);
	}

} //ReferencedViewColumnImpl
