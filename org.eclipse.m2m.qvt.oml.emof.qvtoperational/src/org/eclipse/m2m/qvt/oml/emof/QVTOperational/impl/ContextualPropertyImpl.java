/**
 * <copyright>
 * </copyright>
 *
 * $Id: ContextualPropertyImpl.java,v 1.2 2009/02/20 12:55:55 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ContextualProperty;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage;
import org.eclipse.qvt.declarative.emof.EMOF.Property;
import org.eclipse.qvt.declarative.emof.EMOF.impl.PropertyImpl;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contextual Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ContextualPropertyImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ContextualPropertyImpl#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ContextualPropertyImpl#getOverridden <em>Overridden</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextualPropertyImpl extends PropertyImpl implements ContextualProperty {
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.qvt.declarative.emof.EMOF.Class context;

	/**
	 * The cached value of the '{@link #getInitExpression() <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression initExpression;

	/**
	 * The cached value of the '{@link #getOverridden() <em>Overridden</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverridden()
	 * @generated
	 * @ordered
	 */
	protected Property overridden;

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
	public org.eclipse.qvt.declarative.emof.EMOF.Class getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject)context;
			context = (org.eclipse.qvt.declarative.emof.EMOF.Class)eResolveProxy(oldContext);
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
	public org.eclipse.qvt.declarative.emof.EMOF.Class basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(org.eclipse.qvt.declarative.emof.EMOF.Class newContext) {
		org.eclipse.qvt.declarative.emof.EMOF.Class oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.CONTEXTUAL_PROPERTY__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getInitExpression() {
		return initExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitExpression(OclExpression newInitExpression, NotificationChain msgs) {
		OclExpression oldInitExpression = initExpression;
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
	public void setInitExpression(OclExpression newInitExpression) {
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
	public Property getOverridden() {
		if (overridden != null && overridden.eIsProxy()) {
			InternalEObject oldOverridden = (InternalEObject)overridden;
			overridden = (Property)eResolveProxy(oldOverridden);
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
	public Property basicGetOverridden() {
		return overridden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverridden(Property newOverridden) {
		Property oldOverridden = overridden;
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
				setContext((org.eclipse.qvt.declarative.emof.EMOF.Class)newValue);
				return;
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__INIT_EXPRESSION:
				setInitExpression((OclExpression)newValue);
				return;
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__OVERRIDDEN:
				setOverridden((Property)newValue);
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
				setContext((org.eclipse.qvt.declarative.emof.EMOF.Class)null);
				return;
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__INIT_EXPRESSION:
				setInitExpression((OclExpression)null);
				return;
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY__OVERRIDDEN:
				setOverridden((Property)null);
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
