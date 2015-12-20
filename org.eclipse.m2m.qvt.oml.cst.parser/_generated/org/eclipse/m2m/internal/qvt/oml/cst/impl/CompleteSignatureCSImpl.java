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
 * $Id: CompleteSignatureCSImpl.java,v 1.3 2010/01/29 15:23:40 sboyko Exp $
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

import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS;

import org.eclipse.ocl.cst.impl.CSTNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Signature CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.CompleteSignatureCSImpl#getSimpleSignature <em>Simple Signature</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.CompleteSignatureCSImpl#getResultParams <em>Result Params</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompleteSignatureCSImpl extends CSTNodeImpl implements CompleteSignatureCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getSimpleSignature() <em>Simple Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleSignature()
	 * @generated
	 * @ordered
	 */
	protected SimpleSignatureCS simpleSignature;

	/**
	 * The cached value of the '{@link #getResultParams() <em>Result Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultParams()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterDeclarationCS> resultParams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteSignatureCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.COMPLETE_SIGNATURE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleSignatureCS getSimpleSignature() {
		return simpleSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleSignature(SimpleSignatureCS newSimpleSignature, NotificationChain msgs) {
		SimpleSignatureCS oldSimpleSignature = simpleSignature;
		simpleSignature = newSimpleSignature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE, oldSimpleSignature, newSimpleSignature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleSignature(SimpleSignatureCS newSimpleSignature) {
		if (newSimpleSignature != simpleSignature) {
			NotificationChain msgs = null;
			if (simpleSignature != null)
				msgs = ((InternalEObject)simpleSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE, null, msgs);
			if (newSimpleSignature != null)
				msgs = ((InternalEObject)newSimpleSignature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE, null, msgs);
			msgs = basicSetSimpleSignature(newSimpleSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE, newSimpleSignature, newSimpleSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDeclarationCS> getResultParams() {
		if (resultParams == null) {
			resultParams = new EObjectContainmentEList<ParameterDeclarationCS>(ParameterDeclarationCS.class, this, CSTPackage.COMPLETE_SIGNATURE_CS__RESULT_PARAMS);
		}
		return resultParams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE:
				return basicSetSimpleSignature(null, msgs);
			case CSTPackage.COMPLETE_SIGNATURE_CS__RESULT_PARAMS:
				return ((InternalEList<?>)getResultParams()).basicRemove(otherEnd, msgs);
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
			case CSTPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE:
				return getSimpleSignature();
			case CSTPackage.COMPLETE_SIGNATURE_CS__RESULT_PARAMS:
				return getResultParams();
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
			case CSTPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE:
				setSimpleSignature((SimpleSignatureCS)newValue);
				return;
			case CSTPackage.COMPLETE_SIGNATURE_CS__RESULT_PARAMS:
				getResultParams().clear();
				getResultParams().addAll((Collection<? extends ParameterDeclarationCS>)newValue);
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
			case CSTPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE:
				setSimpleSignature((SimpleSignatureCS)null);
				return;
			case CSTPackage.COMPLETE_SIGNATURE_CS__RESULT_PARAMS:
				getResultParams().clear();
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
			case CSTPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE:
				return simpleSignature != null;
			case CSTPackage.COMPLETE_SIGNATURE_CS__RESULT_PARAMS:
				return resultParams != null && !resultParams.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompleteSignatureCSImpl
