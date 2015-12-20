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

import rdb.NamedColumnSet;
import rdb.impl.NamedElementImpl;
import rdb.view.ViewAlias;
import rdb.view.ViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alias</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.view.impl.ViewAliasImpl#getReferencedTableOrView <em>Referenced Table Or View</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewAliasImpl extends NamedElementImpl implements ViewAlias {
	/**
	 * The cached value of the '{@link #getReferencedTableOrView() <em>Referenced Table Or View</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getReferencedTableOrView()
	 * @generated
	 * @ordered
	 */
    protected NamedColumnSet referencedTableOrView = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ViewAliasImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				protected EClass eStaticClass() {
		return ViewPackage.Literals.VIEW_ALIAS;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NamedColumnSet getReferencedTableOrView() {
		if (referencedTableOrView != null && referencedTableOrView.eIsProxy()) {
			InternalEObject oldReferencedTableOrView = (InternalEObject)referencedTableOrView;
			referencedTableOrView = (NamedColumnSet)eResolveProxy(oldReferencedTableOrView);
			if (referencedTableOrView != oldReferencedTableOrView) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ViewPackage.VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW, oldReferencedTableOrView, referencedTableOrView));
			}
		}
		return referencedTableOrView;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NamedColumnSet basicGetReferencedTableOrView() {
		return referencedTableOrView;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setReferencedTableOrView(NamedColumnSet newReferencedTableOrView) {
		NamedColumnSet oldReferencedTableOrView = referencedTableOrView;
		referencedTableOrView = newReferencedTableOrView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW, oldReferencedTableOrView, referencedTableOrView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ViewPackage.VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW:
				if (resolve) return getReferencedTableOrView();
				return basicGetReferencedTableOrView();
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
			case ViewPackage.VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW:
				setReferencedTableOrView((NamedColumnSet)newValue);
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
			case ViewPackage.VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW:
				setReferencedTableOrView((NamedColumnSet)null);
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
			case ViewPackage.VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW:
				return referencedTableOrView != null;
		}
		return super.eIsSet(featureID);
	}

} //ViewAliasImpl
