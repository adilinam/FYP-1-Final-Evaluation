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
 * $Id: MappingSectionsCSImpl.java,v 1.3 2010/01/29 15:23:40 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;

import org.eclipse.ocl.cst.impl.CSTNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Sections CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionsCSImpl#getMappingInitCS <em>Mapping Init CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionsCSImpl#getMappingBodyCS <em>Mapping Body CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionsCSImpl#getMappingEndCS <em>Mapping End CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingSectionsCSImpl extends CSTNodeImpl implements MappingSectionsCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getMappingInitCS() <em>Mapping Init CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingInitCS()
	 * @generated
	 * @ordered
	 */
	protected MappingInitCS mappingInitCS;

	/**
	 * The cached value of the '{@link #getMappingBodyCS() <em>Mapping Body CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingBodyCS()
	 * @generated
	 * @ordered
	 */
	protected MappingBodyCS mappingBodyCS;

	/**
	 * The cached value of the '{@link #getMappingEndCS() <em>Mapping End CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingEndCS()
	 * @generated
	 * @ordered
	 */
	protected MappingEndCS mappingEndCS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingSectionsCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.MAPPING_SECTIONS_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingInitCS getMappingInitCS() {
		return mappingInitCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingInitCS(MappingInitCS newMappingInitCS, NotificationChain msgs) {
		MappingInitCS oldMappingInitCS = mappingInitCS;
		mappingInitCS = newMappingInitCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_SECTIONS_CS__MAPPING_INIT_CS, oldMappingInitCS, newMappingInitCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingInitCS(MappingInitCS newMappingInitCS) {
		if (newMappingInitCS != mappingInitCS) {
			NotificationChain msgs = null;
			if (mappingInitCS != null)
				msgs = ((InternalEObject)mappingInitCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_SECTIONS_CS__MAPPING_INIT_CS, null, msgs);
			if (newMappingInitCS != null)
				msgs = ((InternalEObject)newMappingInitCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_SECTIONS_CS__MAPPING_INIT_CS, null, msgs);
			msgs = basicSetMappingInitCS(newMappingInitCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_SECTIONS_CS__MAPPING_INIT_CS, newMappingInitCS, newMappingInitCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingBodyCS getMappingBodyCS() {
		return mappingBodyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingBodyCS(MappingBodyCS newMappingBodyCS, NotificationChain msgs) {
		MappingBodyCS oldMappingBodyCS = mappingBodyCS;
		mappingBodyCS = newMappingBodyCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_SECTIONS_CS__MAPPING_BODY_CS, oldMappingBodyCS, newMappingBodyCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingBodyCS(MappingBodyCS newMappingBodyCS) {
		if (newMappingBodyCS != mappingBodyCS) {
			NotificationChain msgs = null;
			if (mappingBodyCS != null)
				msgs = ((InternalEObject)mappingBodyCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_SECTIONS_CS__MAPPING_BODY_CS, null, msgs);
			if (newMappingBodyCS != null)
				msgs = ((InternalEObject)newMappingBodyCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_SECTIONS_CS__MAPPING_BODY_CS, null, msgs);
			msgs = basicSetMappingBodyCS(newMappingBodyCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_SECTIONS_CS__MAPPING_BODY_CS, newMappingBodyCS, newMappingBodyCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingEndCS getMappingEndCS() {
		return mappingEndCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingEndCS(MappingEndCS newMappingEndCS, NotificationChain msgs) {
		MappingEndCS oldMappingEndCS = mappingEndCS;
		mappingEndCS = newMappingEndCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_SECTIONS_CS__MAPPING_END_CS, oldMappingEndCS, newMappingEndCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingEndCS(MappingEndCS newMappingEndCS) {
		if (newMappingEndCS != mappingEndCS) {
			NotificationChain msgs = null;
			if (mappingEndCS != null)
				msgs = ((InternalEObject)mappingEndCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_SECTIONS_CS__MAPPING_END_CS, null, msgs);
			if (newMappingEndCS != null)
				msgs = ((InternalEObject)newMappingEndCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_SECTIONS_CS__MAPPING_END_CS, null, msgs);
			msgs = basicSetMappingEndCS(newMappingEndCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_SECTIONS_CS__MAPPING_END_CS, newMappingEndCS, newMappingEndCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_INIT_CS:
				return basicSetMappingInitCS(null, msgs);
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_BODY_CS:
				return basicSetMappingBodyCS(null, msgs);
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_END_CS:
				return basicSetMappingEndCS(null, msgs);
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
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_INIT_CS:
				return getMappingInitCS();
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_BODY_CS:
				return getMappingBodyCS();
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_END_CS:
				return getMappingEndCS();
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
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_INIT_CS:
				setMappingInitCS((MappingInitCS)newValue);
				return;
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_BODY_CS:
				setMappingBodyCS((MappingBodyCS)newValue);
				return;
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_END_CS:
				setMappingEndCS((MappingEndCS)newValue);
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
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_INIT_CS:
				setMappingInitCS((MappingInitCS)null);
				return;
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_BODY_CS:
				setMappingBodyCS((MappingBodyCS)null);
				return;
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_END_CS:
				setMappingEndCS((MappingEndCS)null);
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
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_INIT_CS:
				return mappingInitCS != null;
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_BODY_CS:
				return mappingBodyCS != null;
			case CSTPackage.MAPPING_SECTIONS_CS__MAPPING_END_CS:
				return mappingEndCS != null;
		}
		return super.eIsSet(featureID);
	}

} //MappingSectionsCSImpl
