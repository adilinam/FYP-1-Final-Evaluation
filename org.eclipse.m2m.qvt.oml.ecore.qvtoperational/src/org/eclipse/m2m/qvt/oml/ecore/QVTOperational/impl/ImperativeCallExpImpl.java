/**
 * <copyright>
 * Copyright (c) 2008 Open Canarias and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ImperativeCallExpImpl.java,v 1.3 2009/02/20 11:04:08 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ImperativeCallExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.util.QVTOperationalToStringVisitor;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.util.QVTOperationalVisitor;
import org.eclipse.ocl.ecore.impl.OperationCallExpImpl;
import org.eclipse.ocl.utilities.Visitor;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imperative Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ImperativeCallExpImpl#isIsVirtual <em>Is Virtual</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImperativeCallExpImpl extends OperationCallExpImpl implements ImperativeCallExp {
	/**
	 * The default value of the '{@link #isIsVirtual() <em>Is Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsVirtual()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_VIRTUAL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsVirtual() <em>Is Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsVirtual()
	 * @generated
	 * @ordered
	 */
	protected boolean isVirtual = IS_VIRTUAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImperativeCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.IMPERATIVE_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsVirtual() {
		return isVirtual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsVirtual(boolean newIsVirtual) {
		boolean oldIsVirtual = isVirtual;
		isVirtual = newIsVirtual;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.IMPERATIVE_CALL_EXP__IS_VIRTUAL, oldIsVirtual, isVirtual));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTOperationalPackage.IMPERATIVE_CALL_EXP__IS_VIRTUAL:
				return isIsVirtual();
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
			case QVTOperationalPackage.IMPERATIVE_CALL_EXP__IS_VIRTUAL:
				setIsVirtual((Boolean)newValue);
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
			case QVTOperationalPackage.IMPERATIVE_CALL_EXP__IS_VIRTUAL:
				setIsVirtual(IS_VIRTUAL_EDEFAULT);
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
			case QVTOperationalPackage.IMPERATIVE_CALL_EXP__IS_VIRTUAL:
				return isVirtual != IS_VIRTUAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();
		
		return accept(QVTOperationalToStringVisitor.getInstance(this));		
	}
	
	/**
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T, U extends Visitor<T,?,?,?,?,?,?,?,?,?>> T accept(U v) {
		if (v instanceof QVTOperationalVisitor)
			return (T) ((QVTOperationalVisitor) v).visitImperativeCallExp(this);
		return super.accept(v);
	}

} //ImperativeCallExpImpl
