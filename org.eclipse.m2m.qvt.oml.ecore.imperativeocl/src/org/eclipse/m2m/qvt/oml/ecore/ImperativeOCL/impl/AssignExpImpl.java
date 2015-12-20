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
 * $Id: AssignExpImpl.java,v 1.6 2009/05/15 16:13:08 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.util.ImperativeOCLVisitor;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.utilities.Visitor;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assign Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl.AssignExpImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl.AssignExpImpl#isIsReset <em>Is Reset</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl.AssignExpImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl.AssignExpImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignExpImpl extends ImperativeExpressionImpl implements AssignExp {
	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression defaultValue;

	/**
	 * The default value of the '{@link #isIsReset() <em>Is Reset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReset()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_RESET_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsReset() <em>Is Reset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReset()
	 * @generated
	 * @ordered
	 */
	protected boolean isReset = IS_RESET_EDEFAULT;

	/**
	 * This is true if the Is Reset attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isResetESet;

	/**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression left;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression> value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLPackage.Literals.ASSIGN_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultValue(OCLExpression newDefaultValue, NotificationChain msgs) {
		OCLExpression oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.ASSIGN_EXP__DEFAULT_VALUE, oldDefaultValue, newDefaultValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(OCLExpression newDefaultValue) {
		if (newDefaultValue != defaultValue) {
			NotificationChain msgs = null;
			if (defaultValue != null)
				msgs = ((InternalEObject)defaultValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLPackage.ASSIGN_EXP__DEFAULT_VALUE, null, msgs);
			if (newDefaultValue != null)
				msgs = ((InternalEObject)newDefaultValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLPackage.ASSIGN_EXP__DEFAULT_VALUE, null, msgs);
			msgs = basicSetDefaultValue(newDefaultValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.ASSIGN_EXP__DEFAULT_VALUE, newDefaultValue, newDefaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsReset() {
		return isReset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsReset(boolean newIsReset) {
		boolean oldIsReset = isReset;
		isReset = newIsReset;
		boolean oldIsResetESet = isResetESet;
		isResetESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.ASSIGN_EXP__IS_RESET, oldIsReset, isReset, !oldIsResetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsReset() {
		boolean oldIsReset = isReset;
		boolean oldIsResetESet = isResetESet;
		isReset = IS_RESET_EDEFAULT;
		isResetESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ImperativeOCLPackage.ASSIGN_EXP__IS_RESET, oldIsReset, IS_RESET_EDEFAULT, oldIsResetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsReset() {
		return isResetESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getLeft() {
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeft(OCLExpression newLeft, NotificationChain msgs) {
		OCLExpression oldLeft = left;
		left = newLeft;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.ASSIGN_EXP__LEFT, oldLeft, newLeft);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft(OCLExpression newLeft) {
		if (newLeft != left) {
			NotificationChain msgs = null;
			if (left != null)
				msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLPackage.ASSIGN_EXP__LEFT, null, msgs);
			if (newLeft != null)
				msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLPackage.ASSIGN_EXP__LEFT, null, msgs);
			msgs = basicSetLeft(newLeft, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.ASSIGN_EXP__LEFT, newLeft, newLeft));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpression> getValue() {
		if (value == null) {
			value = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, ImperativeOCLPackage.ASSIGN_EXP__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeOCLPackage.ASSIGN_EXP__DEFAULT_VALUE:
				return basicSetDefaultValue(null, msgs);
			case ImperativeOCLPackage.ASSIGN_EXP__LEFT:
				return basicSetLeft(null, msgs);
			case ImperativeOCLPackage.ASSIGN_EXP__VALUE:
				return ((InternalEList<?>)getValue()).basicRemove(otherEnd, msgs);
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
			case ImperativeOCLPackage.ASSIGN_EXP__DEFAULT_VALUE:
				return getDefaultValue();
			case ImperativeOCLPackage.ASSIGN_EXP__IS_RESET:
				return isIsReset();
			case ImperativeOCLPackage.ASSIGN_EXP__LEFT:
				return getLeft();
			case ImperativeOCLPackage.ASSIGN_EXP__VALUE:
				return getValue();
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
			case ImperativeOCLPackage.ASSIGN_EXP__DEFAULT_VALUE:
				setDefaultValue((OCLExpression)newValue);
				return;
			case ImperativeOCLPackage.ASSIGN_EXP__IS_RESET:
				setIsReset((Boolean)newValue);
				return;
			case ImperativeOCLPackage.ASSIGN_EXP__LEFT:
				setLeft((OCLExpression)newValue);
				return;
			case ImperativeOCLPackage.ASSIGN_EXP__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends OCLExpression>)newValue);
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
			case ImperativeOCLPackage.ASSIGN_EXP__DEFAULT_VALUE:
				setDefaultValue((OCLExpression)null);
				return;
			case ImperativeOCLPackage.ASSIGN_EXP__IS_RESET:
				unsetIsReset();
				return;
			case ImperativeOCLPackage.ASSIGN_EXP__LEFT:
				setLeft((OCLExpression)null);
				return;
			case ImperativeOCLPackage.ASSIGN_EXP__VALUE:
				getValue().clear();
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
			case ImperativeOCLPackage.ASSIGN_EXP__DEFAULT_VALUE:
				return defaultValue != null;
			case ImperativeOCLPackage.ASSIGN_EXP__IS_RESET:
				return isSetIsReset();
			case ImperativeOCLPackage.ASSIGN_EXP__LEFT:
				return left != null;
			case ImperativeOCLPackage.ASSIGN_EXP__VALUE:
				return value != null && !value.isEmpty();
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
		result.append(" (isReset: "); //$NON-NLS-1$
		if (isResetESet) result.append(isReset); else result.append("<unset>"); //$NON-NLS-1$
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
			return (T) ((ImperativeOCLVisitor) v).visitAssignExp(this);
		return super.<T, U>accept(v);
	}

} //AssignExpImpl
