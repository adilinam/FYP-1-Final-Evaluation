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
 * $Id: ContextualPropertyImpl.java,v 1.2 2009/01/25 23:12:23 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ContextualProperty;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage;
import org.eclipse.ocl.ecore.OCLExpression;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contextual Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ContextualPropertyImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ContextualPropertyImpl#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ContextualPropertyImpl#getOverridden <em>Overridden</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextualPropertyImpl extends EStructuralFeatureImpl implements ContextualProperty {
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected EClass context;

	/**
	 * The cached value of the '{@link #getInitExpression() <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression initExpression;

	/**
	 * The cached value of the '{@link #getOverridden() <em>Overridden</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverridden()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature overridden;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextualPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.CONTEXTUAL_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject)context;
			context = (EClass)eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalPackage.CONTEXTUAL_PROPERTY__CONTEXT, oldContext, context));
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(EClass newContext) {
		EClass oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.CONTEXTUAL_PROPERTY__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getInitExpression() {
		return initExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitExpression(OCLExpression newInitExpression, NotificationChain msgs) {
		OCLExpression oldInitExpression = initExpression;
		initExpression = newInitExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.CONTEXTUAL_PROPERTY__INIT_EXPRESSION, oldInitExpression, newInitExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitExpression(OCLExpression newInitExpression) {
		if (newInitExpression != initExpression) {
			NotificationChain msgs = null;
			if (initExpression != null)
				msgs = ((InternalEObject)initExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalPackage.CONTEXTUAL_PROPERTY__INIT_EXPRESSION, null, msgs);
			if (newInitExpression != null)
				msgs = ((InternalEObject)newInitExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalPackage.CONTEXTUAL_PROPERTY__INIT_EXPRESSION, null, msgs);
			msgs = basicSetInitExpression(newInitExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.CONTEXTUAL_PROPERTY__INIT_EXPRESSION, newInitExpression, newInitExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getOverridden() {
		if (overridden != null && overridden.eIsProxy()) {
			InternalEObject oldOverridden = (InternalEObject)overridden;
			overridden = (EStructuralFeature)eResolveProxy(oldOverridden);
			if (overridden != oldOverridden) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalPackage.CONTEXTUAL_PROPERTY__OVERRIDDEN, oldOverridden, overridden));
			}
		}
		return overridden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetOverridden() {
		return overridden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverridden(EStructuralFeature newOverridden) {
		EStructuralFeature oldOverridden = overridden;
		overridden = newOverridden;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.CONTEXTUAL_PROPERTY__OVERRIDDEN, oldOverridden, overridden));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__INIT_EXPRESSION:
				return basicSetInitExpression(null, msgs);
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
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__INIT_EXPRESSION:
				return getInitExpression();
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__OVERRIDDEN:
				if (resolve) return getOverridden();
				return basicGetOverridden();
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
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__CONTEXT:
				setContext((EClass)newValue);
				return;
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__INIT_EXPRESSION:
				setInitExpression((OCLExpression)newValue);
				return;
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__OVERRIDDEN:
				setOverridden((EStructuralFeature)newValue);
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
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__CONTEXT:
				setContext((EClass)null);
				return;
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__INIT_EXPRESSION:
				setInitExpression((OCLExpression)null);
				return;
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__OVERRIDDEN:
				setOverridden((EStructuralFeature)null);
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
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__CONTEXT:
				return context != null;
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__INIT_EXPRESSION:
				return initExpression != null;
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__OVERRIDDEN:
				return overridden != null;
		}
		return super.eIsSet(featureID);
	}

} //ContextualPropertyImpl
