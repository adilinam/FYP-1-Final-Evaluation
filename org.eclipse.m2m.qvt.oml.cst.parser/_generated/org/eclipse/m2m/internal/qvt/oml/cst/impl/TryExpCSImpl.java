/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 * 
 * 
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.CatchExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TryExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Try Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TryExpCSImpl#getTryBody <em>Try Body</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TryExpCSImpl#getExceptClauses <em>Except Clauses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TryExpCSImpl extends StatementCSImpl implements TryExpCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getTryBody() <em>Try Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTryBody()
	 * @generated
	 * @ordered
	 */
	protected BlockExpCS tryBody;

	/**
	 * The cached value of the '{@link #getExceptClauses() <em>Except Clauses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptClauses()
	 * @generated
	 * @ordered
	 */
	protected EList<CatchExpCS> exceptClauses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TryExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.TRY_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockExpCS getTryBody() {
		return tryBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTryBody(BlockExpCS newTryBody, NotificationChain msgs) {
		BlockExpCS oldTryBody = tryBody;
		tryBody = newTryBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.TRY_EXP_CS__TRY_BODY, oldTryBody, newTryBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTryBody(BlockExpCS newTryBody) {
		if (newTryBody != tryBody) {
			NotificationChain msgs = null;
			if (tryBody != null)
				msgs = ((InternalEObject)tryBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.TRY_EXP_CS__TRY_BODY, null, msgs);
			if (newTryBody != null)
				msgs = ((InternalEObject)newTryBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.TRY_EXP_CS__TRY_BODY, null, msgs);
			msgs = basicSetTryBody(newTryBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.TRY_EXP_CS__TRY_BODY, newTryBody, newTryBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CatchExpCS> getExceptClauses() {
		if (exceptClauses == null) {
			exceptClauses = new EObjectContainmentEList<CatchExpCS>(CatchExpCS.class, this, CSTPackage.TRY_EXP_CS__EXCEPT_CLAUSES);
		}
		return exceptClauses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.TRY_EXP_CS__TRY_BODY:
				return basicSetTryBody(null, msgs);
			case CSTPackage.TRY_EXP_CS__EXCEPT_CLAUSES:
				return ((InternalEList<?>)getExceptClauses()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CSTPackage.TRY_EXP_CS__TRY_BODY:
				return getTryBody();
			case CSTPackage.TRY_EXP_CS__EXCEPT_CLAUSES:
				return getExceptClauses();
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
			case CSTPackage.TRY_EXP_CS__TRY_BODY:
				setTryBody((BlockExpCS)newValue);
				return;
			case CSTPackage.TRY_EXP_CS__EXCEPT_CLAUSES:
				getExceptClauses().clear();
				getExceptClauses().addAll((Collection<? extends CatchExpCS>)newValue);
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
			case CSTPackage.TRY_EXP_CS__TRY_BODY:
				setTryBody((BlockExpCS)null);
				return;
			case CSTPackage.TRY_EXP_CS__EXCEPT_CLAUSES:
				getExceptClauses().clear();
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
			case CSTPackage.TRY_EXP_CS__TRY_BODY:
				return tryBody != null;
			case CSTPackage.TRY_EXP_CS__EXCEPT_CLAUSES:
				return exceptClauses != null && !exceptClauses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TryExpCSImpl
