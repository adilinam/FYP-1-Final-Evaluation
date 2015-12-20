/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others.
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
 *
 * $Id: ResolveExpCSImpl.java,v 1.4 2010/01/29 15:23:40 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS;

import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.VariableCS;

import org.eclipse.ocl.cst.impl.CallExpCSImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolve Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveExpCSImpl#isOne <em>One</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveExpCSImpl#isIsInverse <em>Is Inverse</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveExpCSImpl#isIsDeferred <em>Is Deferred</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveExpCSImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveExpCSImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResolveExpCSImpl extends CallExpCSImpl implements ResolveExpCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isOne() <em>One</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOne()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ONE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isOne() <em>One</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOne()
	 * @generated
	 * @ordered
	 */
	protected static final int ONE_EFLAG = 1 << 8;

	/**
	 * The default value of the '{@link #isIsInverse() <em>Is Inverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInverse()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INVERSE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsInverse() <em>Is Inverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInverse()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_INVERSE_EFLAG = 1 << 9;

	/**
	 * The default value of the '{@link #isIsDeferred() <em>Is Deferred</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDeferred()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DEFERRED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsDeferred() <em>Is Deferred</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDeferred()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_DEFERRED_EFLAG = 1 << 10;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected VariableCS target;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS condition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResolveExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.RESOLVE_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOne() {
		return (eFlags & ONE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOne(boolean newOne) {
		boolean oldOne = (eFlags & ONE_EFLAG) != 0;
		if (newOne) eFlags |= ONE_EFLAG; else eFlags &= ~ONE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.RESOLVE_EXP_CS__ONE, oldOne, newOne));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsInverse() {
		return (eFlags & IS_INVERSE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInverse(boolean newIsInverse) {
		boolean oldIsInverse = (eFlags & IS_INVERSE_EFLAG) != 0;
		if (newIsInverse) eFlags |= IS_INVERSE_EFLAG; else eFlags &= ~IS_INVERSE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.RESOLVE_EXP_CS__IS_INVERSE, oldIsInverse, newIsInverse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDeferred() {
		return (eFlags & IS_DEFERRED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDeferred(boolean newIsDeferred) {
		boolean oldIsDeferred = (eFlags & IS_DEFERRED_EFLAG) != 0;
		if (newIsDeferred) eFlags |= IS_DEFERRED_EFLAG; else eFlags &= ~IS_DEFERRED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.RESOLVE_EXP_CS__IS_DEFERRED, oldIsDeferred, newIsDeferred));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCS getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(VariableCS newTarget, NotificationChain msgs) {
		VariableCS oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.RESOLVE_EXP_CS__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(VariableCS newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.RESOLVE_EXP_CS__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.RESOLVE_EXP_CS__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.RESOLVE_EXP_CS__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(OCLExpressionCS newCondition, NotificationChain msgs) {
		OCLExpressionCS oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.RESOLVE_EXP_CS__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(OCLExpressionCS newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.RESOLVE_EXP_CS__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.RESOLVE_EXP_CS__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.RESOLVE_EXP_CS__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.RESOLVE_EXP_CS__TARGET:
				return basicSetTarget(null, msgs);
			case CSTPackage.RESOLVE_EXP_CS__CONDITION:
				return basicSetCondition(null, msgs);
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
			case CSTPackage.RESOLVE_EXP_CS__ONE:
				return isOne();
			case CSTPackage.RESOLVE_EXP_CS__IS_INVERSE:
				return isIsInverse();
			case CSTPackage.RESOLVE_EXP_CS__IS_DEFERRED:
				return isIsDeferred();
			case CSTPackage.RESOLVE_EXP_CS__TARGET:
				return getTarget();
			case CSTPackage.RESOLVE_EXP_CS__CONDITION:
				return getCondition();
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
			case CSTPackage.RESOLVE_EXP_CS__ONE:
				setOne((Boolean)newValue);
				return;
			case CSTPackage.RESOLVE_EXP_CS__IS_INVERSE:
				setIsInverse((Boolean)newValue);
				return;
			case CSTPackage.RESOLVE_EXP_CS__IS_DEFERRED:
				setIsDeferred((Boolean)newValue);
				return;
			case CSTPackage.RESOLVE_EXP_CS__TARGET:
				setTarget((VariableCS)newValue);
				return;
			case CSTPackage.RESOLVE_EXP_CS__CONDITION:
				setCondition((OCLExpressionCS)newValue);
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
			case CSTPackage.RESOLVE_EXP_CS__ONE:
				setOne(ONE_EDEFAULT);
				return;
			case CSTPackage.RESOLVE_EXP_CS__IS_INVERSE:
				setIsInverse(IS_INVERSE_EDEFAULT);
				return;
			case CSTPackage.RESOLVE_EXP_CS__IS_DEFERRED:
				setIsDeferred(IS_DEFERRED_EDEFAULT);
				return;
			case CSTPackage.RESOLVE_EXP_CS__TARGET:
				setTarget((VariableCS)null);
				return;
			case CSTPackage.RESOLVE_EXP_CS__CONDITION:
				setCondition((OCLExpressionCS)null);
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
			case CSTPackage.RESOLVE_EXP_CS__ONE:
				return ((eFlags & ONE_EFLAG) != 0) != ONE_EDEFAULT;
			case CSTPackage.RESOLVE_EXP_CS__IS_INVERSE:
				return ((eFlags & IS_INVERSE_EFLAG) != 0) != IS_INVERSE_EDEFAULT;
			case CSTPackage.RESOLVE_EXP_CS__IS_DEFERRED:
				return ((eFlags & IS_DEFERRED_EFLAG) != 0) != IS_DEFERRED_EDEFAULT;
			case CSTPackage.RESOLVE_EXP_CS__TARGET:
				return target != null;
			case CSTPackage.RESOLVE_EXP_CS__CONDITION:
				return condition != null;
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
		result.append(" (one: "); //$NON-NLS-1$
		result.append((eFlags & ONE_EFLAG) != 0);
		result.append(", isInverse: "); //$NON-NLS-1$
		result.append((eFlags & IS_INVERSE_EFLAG) != 0);
		result.append(", isDeferred: "); //$NON-NLS-1$
		result.append((eFlags & IS_DEFERRED_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} //ResolveExpCSImpl
