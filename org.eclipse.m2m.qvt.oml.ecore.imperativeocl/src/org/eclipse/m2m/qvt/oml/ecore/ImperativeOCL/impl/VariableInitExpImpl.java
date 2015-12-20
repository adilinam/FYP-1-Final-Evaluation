/**
 * <copyright>
 * Copyright (c) 2008, 2009 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo  - initial API and implementation
 * </copyright>
 *
 * $Id: VariableInitExpImpl.java,v 1.5 2009/05/15 16:13:08 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.VariableInitExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.util.ImperativeOCLVisitor;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.utilities.Visitor;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Init Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl.VariableInitExpImpl#getReferredVariable <em>Referred Variable</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl.VariableInitExpImpl#isWithResult <em>With Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableInitExpImpl extends ImperativeExpressionImpl implements VariableInitExp {
	/**
	 * The cached value of the '{@link #getReferredVariable() <em>Referred Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable referredVariable;

	/**
	 * The default value of the '{@link #isWithResult() <em>With Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithResult()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WITH_RESULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWithResult() <em>With Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithResult()
	 * @generated
	 * @ordered
	 */
	protected boolean withResult = WITH_RESULT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableInitExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLPackage.Literals.VARIABLE_INIT_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getReferredVariable() {
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferredVariable(Variable newReferredVariable, NotificationChain msgs) {
		Variable oldReferredVariable = referredVariable;
		referredVariable = newReferredVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.VARIABLE_INIT_EXP__REFERRED_VARIABLE, oldReferredVariable, newReferredVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredVariable(Variable newReferredVariable) {
		if (newReferredVariable != referredVariable) {
			NotificationChain msgs = null;
			if (referredVariable != null)
				msgs = ((InternalEObject)referredVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLPackage.VARIABLE_INIT_EXP__REFERRED_VARIABLE, null, msgs);
			if (newReferredVariable != null)
				msgs = ((InternalEObject)newReferredVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLPackage.VARIABLE_INIT_EXP__REFERRED_VARIABLE, null, msgs);
			msgs = basicSetReferredVariable(newReferredVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.VARIABLE_INIT_EXP__REFERRED_VARIABLE, newReferredVariable, newReferredVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWithResult() {
		return withResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWithResult(boolean newWithResult) {
		boolean oldWithResult = withResult;
		withResult = newWithResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.VARIABLE_INIT_EXP__WITH_RESULT, oldWithResult, withResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeOCLPackage.VARIABLE_INIT_EXP__REFERRED_VARIABLE:
				return basicSetReferredVariable(null, msgs);
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
			case ImperativeOCLPackage.VARIABLE_INIT_EXP__REFERRED_VARIABLE:
				return getReferredVariable();
			case ImperativeOCLPackage.VARIABLE_INIT_EXP__WITH_RESULT:
				return isWithResult();
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
			case ImperativeOCLPackage.VARIABLE_INIT_EXP__REFERRED_VARIABLE:
				setReferredVariable((Variable)newValue);
				return;
			case ImperativeOCLPackage.VARIABLE_INIT_EXP__WITH_RESULT:
				setWithResult((Boolean)newValue);
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
			case ImperativeOCLPackage.VARIABLE_INIT_EXP__REFERRED_VARIABLE:
				setReferredVariable((Variable)null);
				return;
			case ImperativeOCLPackage.VARIABLE_INIT_EXP__WITH_RESULT:
				setWithResult(WITH_RESULT_EDEFAULT);
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
			case ImperativeOCLPackage.VARIABLE_INIT_EXP__REFERRED_VARIABLE:
				return referredVariable != null;
			case ImperativeOCLPackage.VARIABLE_INIT_EXP__WITH_RESULT:
				return withResult != WITH_RESULT_EDEFAULT;
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
		result.append(" (withResult: "); //$NON-NLS-1$
		result.append(withResult);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		if (v instanceof ImperativeOCLVisitor)
			return (T) ((ImperativeOCLVisitor) v).visitVariableInitExp(this);
		return super.<T, U>accept(v);
	}

} //VariableInitExpImpl
