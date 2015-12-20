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
 * $Id: TransformationRefineCSImpl.java,v 1.3 2010/01/29 15:23:40 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS;

import org.eclipse.ocl.cst.SimpleNameCS;

import org.eclipse.ocl.cst.impl.CSTNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation Refine CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationRefineCSImpl#getModuleRefCS <em>Module Ref CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationRefineCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationRefineCSImpl extends CSTNodeImpl implements TransformationRefineCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getModuleRefCS() <em>Module Ref CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleRefCS()
	 * @generated
	 * @ordered
	 */
	protected ModuleRefCS moduleRefCS;

	/**
	 * The cached value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected SimpleNameCS simpleNameCS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationRefineCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.TRANSFORMATION_REFINE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleRefCS getModuleRefCS() {
		return moduleRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModuleRefCS(ModuleRefCS newModuleRefCS, NotificationChain msgs) {
		ModuleRefCS oldModuleRefCS = moduleRefCS;
		moduleRefCS = newModuleRefCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS, oldModuleRefCS, newModuleRefCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModuleRefCS(ModuleRefCS newModuleRefCS) {
		if (newModuleRefCS != moduleRefCS) {
			NotificationChain msgs = null;
			if (moduleRefCS != null)
				msgs = ((InternalEObject)moduleRefCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS, null, msgs);
			if (newModuleRefCS != null)
				msgs = ((InternalEObject)newModuleRefCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS, null, msgs);
			msgs = basicSetModuleRefCS(newModuleRefCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS, newModuleRefCS, newModuleRefCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS getSimpleNameCS() {
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleNameCS(SimpleNameCS newSimpleNameCS, NotificationChain msgs) {
		SimpleNameCS oldSimpleNameCS = simpleNameCS;
		simpleNameCS = newSimpleNameCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS, oldSimpleNameCS, newSimpleNameCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleNameCS(SimpleNameCS newSimpleNameCS) {
		if (newSimpleNameCS != simpleNameCS) {
			NotificationChain msgs = null;
			if (simpleNameCS != null)
				msgs = ((InternalEObject)simpleNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS, null, msgs);
			if (newSimpleNameCS != null)
				msgs = ((InternalEObject)newSimpleNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS, null, msgs);
			msgs = basicSetSimpleNameCS(newSimpleNameCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS, newSimpleNameCS, newSimpleNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS:
				return basicSetModuleRefCS(null, msgs);
			case CSTPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS:
				return basicSetSimpleNameCS(null, msgs);
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
			case CSTPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS:
				return getModuleRefCS();
			case CSTPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS:
				return getSimpleNameCS();
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
			case CSTPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS:
				setModuleRefCS((ModuleRefCS)newValue);
				return;
			case CSTPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)newValue);
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
			case CSTPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS:
				setModuleRefCS((ModuleRefCS)null);
				return;
			case CSTPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)null);
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
			case CSTPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS:
				return moduleRefCS != null;
			case CSTPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS:
				return simpleNameCS != null;
		}
		return super.eIsSet(featureID);
	}

} //TransformationRefineCSImpl
