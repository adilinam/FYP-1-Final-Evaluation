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

import rdb.constraints.ConstraintsPackage;
import rdb.constraints.ForeignKey;
import rdb.constraints.UniqueConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.constraints.impl.ForeignKeyImpl#getReferredUC <em>Referred UC</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForeignKeyImpl extends ColumnRefConstraintImpl implements ForeignKey {
	/**
	 * The cached value of the '{@link #getReferredUC() <em>Referred UC</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getReferredUC()
	 * @generated
	 * @ordered
	 */
    protected UniqueConstraint referredUC = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ForeignKeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				protected EClass eStaticClass() {
		return ConstraintsPackage.Literals.FOREIGN_KEY;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public UniqueConstraint getReferredUC() {
		if (referredUC != null && referredUC.eIsProxy()) {
			InternalEObject oldReferredUC = (InternalEObject)referredUC;
			referredUC = (UniqueConstraint)eResolveProxy(oldReferredUC);
			if (referredUC != oldReferredUC) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConstraintsPackage.FOREIGN_KEY__REFERRED_UC, oldReferredUC, referredUC));
			}
		}
		return referredUC;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public UniqueConstraint basicGetReferredUC() {
		return referredUC;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setReferredUC(UniqueConstraint newReferredUC) {
		UniqueConstraint oldReferredUC = referredUC;
		referredUC = newReferredUC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.FOREIGN_KEY__REFERRED_UC, oldReferredUC, referredUC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintsPackage.FOREIGN_KEY__REFERRED_UC:
				if (resolve) return getReferredUC();
				return basicGetReferredUC();
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
			case ConstraintsPackage.FOREIGN_KEY__REFERRED_UC:
				setReferredUC((UniqueConstraint)newValue);
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
			case ConstraintsPackage.FOREIGN_KEY__REFERRED_UC:
				setReferredUC((UniqueConstraint)null);
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
			case ConstraintsPackage.FOREIGN_KEY__REFERRED_UC:
				return referredUC != null;
		}
		return super.eIsSet(featureID);
	}

} //ForeignKeyImpl
