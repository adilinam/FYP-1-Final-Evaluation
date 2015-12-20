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
 * $Id: ResolveExpImpl.java,v 1.5 2009/12/09 14:03:08 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.util.QVTOperationalToStringVisitor;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.util.QVTOperationalVisitor;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.impl.CallExpImpl;
import org.eclipse.ocl.utilities.Visitor;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolve Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ResolveExpImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ResolveExpImpl#isIsDeferred <em>Is Deferred</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ResolveExpImpl#isIsInverse <em>Is Inverse</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ResolveExpImpl#isOne <em>One</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ResolveExpImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResolveExpImpl extends CallExpImpl implements ResolveExp {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression condition;

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
	 * The cached value of the '{@link #isIsDeferred() <em>Is Deferred</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDeferred()
	 * @generated
	 * @ordered
	 */
	protected boolean isDeferred = IS_DEFERRED_EDEFAULT;

	/**
	 * This is true if the Is Deferred attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isDeferredESet;

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
	 * The cached value of the '{@link #isIsInverse() <em>Is Inverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInverse()
	 * @generated
	 * @ordered
	 */
	protected boolean isInverse = IS_INVERSE_EDEFAULT;

	/**
	 * This is true if the Is Inverse attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isInverseESet;

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
	 * The cached value of the '{@link #isOne() <em>One</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOne()
	 * @generated
	 * @ordered
	 */
	protected boolean one = ONE_EDEFAULT;

	/**
	 * This is true if the One attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean oneESet;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Variable target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResolveExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.RESOLVE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(OCLExpression newCondition, NotificationChain msgs) {
		OCLExpression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.RESOLVE_EXP__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(OCLExpression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalPackage.RESOLVE_EXP__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalPackage.RESOLVE_EXP__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.RESOLVE_EXP__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDeferred() {
		return isDeferred;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDeferred(boolean newIsDeferred) {
		boolean oldIsDeferred = isDeferred;
		isDeferred = newIsDeferred;
		boolean oldIsDeferredESet = isDeferredESet;
		isDeferredESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.RESOLVE_EXP__IS_DEFERRED, oldIsDeferred, isDeferred, !oldIsDeferredESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsDeferred() {
		boolean oldIsDeferred = isDeferred;
		boolean oldIsDeferredESet = isDeferredESet;
		isDeferred = IS_DEFERRED_EDEFAULT;
		isDeferredESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTOperationalPackage.RESOLVE_EXP__IS_DEFERRED, oldIsDeferred, IS_DEFERRED_EDEFAULT, oldIsDeferredESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsDeferred() {
		return isDeferredESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsInverse() {
		return isInverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInverse(boolean newIsInverse) {
		boolean oldIsInverse = isInverse;
		isInverse = newIsInverse;
		boolean oldIsInverseESet = isInverseESet;
		isInverseESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.RESOLVE_EXP__IS_INVERSE, oldIsInverse, isInverse, !oldIsInverseESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsInverse() {
		boolean oldIsInverse = isInverse;
		boolean oldIsInverseESet = isInverseESet;
		isInverse = IS_INVERSE_EDEFAULT;
		isInverseESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTOperationalPackage.RESOLVE_EXP__IS_INVERSE, oldIsInverse, IS_INVERSE_EDEFAULT, oldIsInverseESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsInverse() {
		return isInverseESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOne() {
		return one;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOne(boolean newOne) {
		boolean oldOne = one;
		one = newOne;
		boolean oldOneESet = oneESet;
		oneESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.RESOLVE_EXP__ONE, oldOne, one, !oldOneESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOne() {
		boolean oldOne = one;
		boolean oldOneESet = oneESet;
		one = ONE_EDEFAULT;
		oneESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTOperationalPackage.RESOLVE_EXP__ONE, oldOne, ONE_EDEFAULT, oldOneESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOne() {
		return oneESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Variable newTarget, NotificationChain msgs) {
		Variable oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.RESOLVE_EXP__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Variable newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalPackage.RESOLVE_EXP__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalPackage.RESOLVE_EXP__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.RESOLVE_EXP__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.RESOLVE_EXP__CONDITION:
				return basicSetCondition(null, msgs);
			case QVTOperationalPackage.RESOLVE_EXP__TARGET:
				return basicSetTarget(null, msgs);
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
			case QVTOperationalPackage.RESOLVE_EXP__CONDITION:
				return getCondition();
			case QVTOperationalPackage.RESOLVE_EXP__IS_DEFERRED:
				return isIsDeferred();
			case QVTOperationalPackage.RESOLVE_EXP__IS_INVERSE:
				return isIsInverse();
			case QVTOperationalPackage.RESOLVE_EXP__ONE:
				return isOne();
			case QVTOperationalPackage.RESOLVE_EXP__TARGET:
				return getTarget();
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
			case QVTOperationalPackage.RESOLVE_EXP__CONDITION:
				setCondition((OCLExpression)newValue);
				return;
			case QVTOperationalPackage.RESOLVE_EXP__IS_DEFERRED:
				setIsDeferred((Boolean)newValue);
				return;
			case QVTOperationalPackage.RESOLVE_EXP__IS_INVERSE:
				setIsInverse((Boolean)newValue);
				return;
			case QVTOperationalPackage.RESOLVE_EXP__ONE:
				setOne((Boolean)newValue);
				return;
			case QVTOperationalPackage.RESOLVE_EXP__TARGET:
				setTarget((Variable)newValue);
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
			case QVTOperationalPackage.RESOLVE_EXP__CONDITION:
				setCondition((OCLExpression)null);
				return;
			case QVTOperationalPackage.RESOLVE_EXP__IS_DEFERRED:
				unsetIsDeferred();
				return;
			case QVTOperationalPackage.RESOLVE_EXP__IS_INVERSE:
				unsetIsInverse();
				return;
			case QVTOperationalPackage.RESOLVE_EXP__ONE:
				unsetOne();
				return;
			case QVTOperationalPackage.RESOLVE_EXP__TARGET:
				setTarget((Variable)null);
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
			case QVTOperationalPackage.RESOLVE_EXP__CONDITION:
				return condition != null;
			case QVTOperationalPackage.RESOLVE_EXP__IS_DEFERRED:
				return isSetIsDeferred();
			case QVTOperationalPackage.RESOLVE_EXP__IS_INVERSE:
				return isSetIsInverse();
			case QVTOperationalPackage.RESOLVE_EXP__ONE:
				return isSetOne();
			case QVTOperationalPackage.RESOLVE_EXP__TARGET:
				return target != null;
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
		if (eIsProxy()) {
			return super.toString();
		}
		return accept(QVTOperationalToStringVisitor.getInstance(this));		
	}
	
	/**
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T, U extends Visitor<T,?,?,?,?,?,?,?,?,?>> T accept(U v) {		
		if (v instanceof QVTOperationalVisitor)
			return (T) ((QVTOperationalVisitor) v).visitResolveExp(this);
		return super.accept(v);
	}

} //ResolveExpImpl
