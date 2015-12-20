/**
 * <copyright>
 * </copyright>
 *
 * $Id: ImperativeOperationImpl.java,v 1.2 2009/02/20 12:55:55 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.OperationBody;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.VarParameter;
import org.eclipse.qvt.declarative.emof.EMOF.impl.OperationImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imperative Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ImperativeOperationImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ImperativeOperationImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ImperativeOperationImpl#getIsBlackbox <em>Is Blackbox</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ImperativeOperationImpl#getOverridden <em>Overridden</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ImperativeOperationImpl#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImperativeOperationImpl extends OperationImpl implements ImperativeOperation {
	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected OperationBody body;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected VarParameter context;

	/**
	 * The default value of the '{@link #getIsBlackbox() <em>Is Blackbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsBlackbox()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean IS_BLACKBOX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsBlackbox() <em>Is Blackbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsBlackbox()
	 * @generated
	 * @ordered
	 */
	protected Boolean isBlackbox = IS_BLACKBOX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOverridden() <em>Overridden</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverridden()
	 * @generated
	 * @ordered
	 */
	protected ImperativeOperation overridden;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected EList<VarParameter> result;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImperativeOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.IMPERATIVE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationBody getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(OperationBody newBody, NotificationChain msgs) {
		OperationBody oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.IMPERATIVE_OPERATION__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(OperationBody newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, QVTOperationalPackage.OPERATION_BODY__OPERATION, OperationBody.class, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, QVTOperationalPackage.OPERATION_BODY__OPERATION, OperationBody.class, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.IMPERATIVE_OPERATION__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarParameter getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(VarParameter newContext, NotificationChain msgs) {
		VarParameter oldContext = context;
		context = newContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT, oldContext, newContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(VarParameter newContext) {
		if (newContext != context) {
			NotificationChain msgs = null;
			if (context != null)
				msgs = ((InternalEObject)context).eInverseRemove(this, QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER, VarParameter.class, msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER, VarParameter.class, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getIsBlackbox() {
		return isBlackbox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBlackbox(Boolean newIsBlackbox) {
		Boolean oldIsBlackbox = isBlackbox;
		isBlackbox = newIsBlackbox;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.IMPERATIVE_OPERATION__IS_BLACKBOX, oldIsBlackbox, isBlackbox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOperation getOverridden() {
		if (overridden != null && overridden.eIsProxy()) {
			InternalEObject oldOverridden = (InternalEObject)overridden;
			overridden = (ImperativeOperation)eResolveProxy(oldOverridden);
			if (overridden != oldOverridden) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalPackage.IMPERATIVE_OPERATION__OVERRIDDEN, oldOverridden, overridden));
			}
		}
		return overridden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOperation basicGetOverridden() {
		return overridden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverridden(ImperativeOperation newOverridden) {
		ImperativeOperation oldOverridden = overridden;
		overridden = newOverridden;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.IMPERATIVE_OPERATION__OVERRIDDEN, oldOverridden, overridden));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VarParameter> getResult() {
		if (result == null) {
			result = new EObjectContainmentWithInverseEList<VarParameter>(VarParameter.class, this, QVTOperationalPackage.IMPERATIVE_OPERATION__RESULT, QVTOperationalPackage.VAR_PARAMETER__RES_OWNER);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.IMPERATIVE_OPERATION__BODY:
				if (body != null)
					msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalPackage.IMPERATIVE_OPERATION__BODY, null, msgs);
				return basicSetBody((OperationBody)otherEnd, msgs);
			case QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT:
				if (context != null)
					msgs = ((InternalEObject)context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT, null, msgs);
				return basicSetContext((VarParameter)otherEnd, msgs);
			case QVTOperationalPackage.IMPERATIVE_OPERATION__RESULT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResult()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.IMPERATIVE_OPERATION__BODY:
				return basicSetBody(null, msgs);
			case QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT:
				return basicSetContext(null, msgs);
			case QVTOperationalPackage.IMPERATIVE_OPERATION__RESULT:
				return ((InternalEList<?>)getResult()).basicRemove(otherEnd, msgs);
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
			case QVTOperationalPackage.IMPERATIVE_OPERATION__BODY:
				return getBody();
			case QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT:
				return getContext();
			case QVTOperationalPackage.IMPERATIVE_OPERATION__IS_BLACKBOX:
				return getIsBlackbox();
			case QVTOperationalPackage.IMPERATIVE_OPERATION__OVERRIDDEN:
				if (resolve) return getOverridden();
				return basicGetOverridden();
			case QVTOperationalPackage.IMPERATIVE_OPERATION__RESULT:
				return getResult();
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
			case QVTOperationalPackage.IMPERATIVE_OPERATION__BODY:
				setBody((OperationBody)newValue);
				return;
			case QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT:
				setContext((VarParameter)newValue);
				return;
			case QVTOperationalPackage.IMPERATIVE_OPERATION__IS_BLACKBOX:
				setIsBlackbox((Boolean)newValue);
				return;
			case QVTOperationalPackage.IMPERATIVE_OPERATION__OVERRIDDEN:
				setOverridden((ImperativeOperation)newValue);
				return;
			case QVTOperationalPackage.IMPERATIVE_OPERATION__RESULT:
				getResult().clear();
				getResult().addAll((Collection<? extends VarParameter>)newValue);
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
			case QVTOperationalPackage.IMPERATIVE_OPERATION__BODY:
				setBody((OperationBody)null);
				return;
			case QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT:
				setContext((VarParameter)null);
				return;
			case QVTOperationalPackage.IMPERATIVE_OPERATION__IS_BLACKBOX:
				setIsBlackbox(IS_BLACKBOX_EDEFAULT);
				return;
			case QVTOperationalPackage.IMPERATIVE_OPERATION__OVERRIDDEN:
				setOverridden((ImperativeOperation)null);
				return;
			case QVTOperationalPackage.IMPERATIVE_OPERATION__RESULT:
				getResult().clear();
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
			case QVTOperationalPackage.IMPERATIVE_OPERATION__BODY:
				return body != null;
			case QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT:
				return context != null;
			case QVTOperationalPackage.IMPERATIVE_OPERATION__IS_BLACKBOX:
				return IS_BLACKBOX_EDEFAULT == null ? isBlackbox != null : !IS_BLACKBOX_EDEFAULT.equals(isBlackbox);
			case QVTOperationalPackage.IMPERATIVE_OPERATION__OVERRIDDEN:
				return overridden != null;
			case QVTOperationalPackage.IMPERATIVE_OPERATION__RESULT:
				return result != null && !result.isEmpty();
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
		result.append(" (isBlackbox: ");
		result.append(isBlackbox);
		result.append(')');
		return result.toString();
	}

} //ImperativeOperationImpl
