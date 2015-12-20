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
 * $Id: ContextualPropertyCSImpl.java,v 1.3 2010/01/29 15:23:40 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS;

import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.TypeCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contextual Property CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ContextualPropertyCSImpl#getScopedNameCS <em>Scoped Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ContextualPropertyCSImpl#getTypeCS <em>Type CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ContextualPropertyCSImpl#getOclExpressionCS <em>Ocl Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextualPropertyCSImpl extends ModulePropertyCSImpl implements ContextualPropertyCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getScopedNameCS() <em>Scoped Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopedNameCS()
	 * @generated
	 * @ordered
	 */
	protected ScopedNameCS scopedNameCS;

	/**
	 * The cached value of the '{@link #getTypeCS() <em>Type CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeCS()
	 * @generated
	 * @ordered
	 */
	protected TypeCS typeCS;

	/**
	 * The cached value of the '{@link #getOclExpressionCS() <em>Ocl Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS oclExpressionCS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextualPropertyCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.CONTEXTUAL_PROPERTY_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopedNameCS getScopedNameCS() {
		return scopedNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScopedNameCS(ScopedNameCS newScopedNameCS, NotificationChain msgs) {
		ScopedNameCS oldScopedNameCS = scopedNameCS;
		scopedNameCS = newScopedNameCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS, oldScopedNameCS, newScopedNameCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScopedNameCS(ScopedNameCS newScopedNameCS) {
		if (newScopedNameCS != scopedNameCS) {
			NotificationChain msgs = null;
			if (scopedNameCS != null)
				msgs = ((InternalEObject)scopedNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS, null, msgs);
			if (newScopedNameCS != null)
				msgs = ((InternalEObject)newScopedNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS, null, msgs);
			msgs = basicSetScopedNameCS(newScopedNameCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS, newScopedNameCS, newScopedNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeCS getTypeCS() {
		return typeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeCS(TypeCS newTypeCS, NotificationChain msgs) {
		TypeCS oldTypeCS = typeCS;
		typeCS = newTypeCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.CONTEXTUAL_PROPERTY_CS__TYPE_CS, oldTypeCS, newTypeCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeCS(TypeCS newTypeCS) {
		if (newTypeCS != typeCS) {
			NotificationChain msgs = null;
			if (typeCS != null)
				msgs = ((InternalEObject)typeCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CONTEXTUAL_PROPERTY_CS__TYPE_CS, null, msgs);
			if (newTypeCS != null)
				msgs = ((InternalEObject)newTypeCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CONTEXTUAL_PROPERTY_CS__TYPE_CS, null, msgs);
			msgs = basicSetTypeCS(newTypeCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CONTEXTUAL_PROPERTY_CS__TYPE_CS, newTypeCS, newTypeCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getOclExpressionCS() {
		return oclExpressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOclExpressionCS(OCLExpressionCS newOclExpressionCS, NotificationChain msgs) {
		OCLExpressionCS oldOclExpressionCS = oclExpressionCS;
		oclExpressionCS = newOclExpressionCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS, oldOclExpressionCS, newOclExpressionCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclExpressionCS(OCLExpressionCS newOclExpressionCS) {
		if (newOclExpressionCS != oclExpressionCS) {
			NotificationChain msgs = null;
			if (oclExpressionCS != null)
				msgs = ((InternalEObject)oclExpressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS, null, msgs);
			if (newOclExpressionCS != null)
				msgs = ((InternalEObject)newOclExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS, null, msgs);
			msgs = basicSetOclExpressionCS(newOclExpressionCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS, newOclExpressionCS, newOclExpressionCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS:
				return basicSetScopedNameCS(null, msgs);
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__TYPE_CS:
				return basicSetTypeCS(null, msgs);
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS:
				return basicSetOclExpressionCS(null, msgs);
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
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS:
				return getScopedNameCS();
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__TYPE_CS:
				return getTypeCS();
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS:
				return getOclExpressionCS();
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
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS:
				setScopedNameCS((ScopedNameCS)newValue);
				return;
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__TYPE_CS:
				setTypeCS((TypeCS)newValue);
				return;
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS:
				setOclExpressionCS((OCLExpressionCS)newValue);
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
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS:
				setScopedNameCS((ScopedNameCS)null);
				return;
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__TYPE_CS:
				setTypeCS((TypeCS)null);
				return;
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS:
				setOclExpressionCS((OCLExpressionCS)null);
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
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS:
				return scopedNameCS != null;
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__TYPE_CS:
				return typeCS != null;
			case CSTPackage.CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS:
				return oclExpressionCS != null;
		}
		return super.eIsSet(featureID);
	}

} //ContextualPropertyCSImpl
