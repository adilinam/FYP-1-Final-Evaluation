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
 * $Id: WhileExpCSImpl.java,v 1.5 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS;

import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.VariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>While Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.WhileExpCSImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.WhileExpCSImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.WhileExpCSImpl#getResultVar <em>Result Var</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WhileExpCSImpl extends StatementCSImpl implements WhileExpCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS body;

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
	 * The cached value of the '{@link #getResultVar() <em>Result Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultVar()
	 * @generated
	 * @ordered
	 */
	protected VariableCS resultVar;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhileExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.WHILE_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(OCLExpressionCS newBody, NotificationChain msgs) {
		OCLExpressionCS oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.WHILE_EXP_CS__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(OCLExpressionCS newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.WHILE_EXP_CS__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.WHILE_EXP_CS__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.WHILE_EXP_CS__BODY, newBody, newBody));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.WHILE_EXP_CS__CONDITION, oldCondition, newCondition);
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
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.WHILE_EXP_CS__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.WHILE_EXP_CS__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.WHILE_EXP_CS__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCS getResultVar() {
		return resultVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultVar(VariableCS newResultVar, NotificationChain msgs) {
		VariableCS oldResultVar = resultVar;
		resultVar = newResultVar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.WHILE_EXP_CS__RESULT_VAR, oldResultVar, newResultVar);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultVar(VariableCS newResultVar) {
		if (newResultVar != resultVar) {
			NotificationChain msgs = null;
			if (resultVar != null)
				msgs = ((InternalEObject)resultVar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.WHILE_EXP_CS__RESULT_VAR, null, msgs);
			if (newResultVar != null)
				msgs = ((InternalEObject)newResultVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.WHILE_EXP_CS__RESULT_VAR, null, msgs);
			msgs = basicSetResultVar(newResultVar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.WHILE_EXP_CS__RESULT_VAR, newResultVar, newResultVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.WHILE_EXP_CS__BODY:
				return basicSetBody(null, msgs);
			case CSTPackage.WHILE_EXP_CS__CONDITION:
				return basicSetCondition(null, msgs);
			case CSTPackage.WHILE_EXP_CS__RESULT_VAR:
				return basicSetResultVar(null, msgs);
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
			case CSTPackage.WHILE_EXP_CS__BODY:
				return getBody();
			case CSTPackage.WHILE_EXP_CS__CONDITION:
				return getCondition();
			case CSTPackage.WHILE_EXP_CS__RESULT_VAR:
				return getResultVar();
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
			case CSTPackage.WHILE_EXP_CS__BODY:
				setBody((OCLExpressionCS)newValue);
				return;
			case CSTPackage.WHILE_EXP_CS__CONDITION:
				setCondition((OCLExpressionCS)newValue);
				return;
			case CSTPackage.WHILE_EXP_CS__RESULT_VAR:
				setResultVar((VariableCS)newValue);
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
			case CSTPackage.WHILE_EXP_CS__BODY:
				setBody((OCLExpressionCS)null);
				return;
			case CSTPackage.WHILE_EXP_CS__CONDITION:
				setCondition((OCLExpressionCS)null);
				return;
			case CSTPackage.WHILE_EXP_CS__RESULT_VAR:
				setResultVar((VariableCS)null);
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
			case CSTPackage.WHILE_EXP_CS__BODY:
				return body != null;
			case CSTPackage.WHILE_EXP_CS__CONDITION:
				return condition != null;
			case CSTPackage.WHILE_EXP_CS__RESULT_VAR:
				return resultVar != null;
		}
		return super.eIsSet(featureID);
	}

} //WhileExpCSImpl
