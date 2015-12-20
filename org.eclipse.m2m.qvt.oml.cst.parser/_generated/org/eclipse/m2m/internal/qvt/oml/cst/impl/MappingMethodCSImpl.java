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
 * $Id: MappingMethodCSImpl.java,v 1.5 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;

import org.eclipse.ocl.cst.impl.CSTNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Method CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingMethodCSImpl#isBlackBox <em>Black Box</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingMethodCSImpl#getMappingDeclarationCS <em>Mapping Declaration CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MappingMethodCSImpl extends CSTNodeImpl implements MappingMethodCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isBlackBox() <em>Black Box</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBlackBox()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BLACK_BOX_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isBlackBox() <em>Black Box</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBlackBox()
	 * @generated
	 * @ordered
	 */
	protected static final int BLACK_BOX_EFLAG = 1 << 8;

	/**
	 * The cached value of the '{@link #getMappingDeclarationCS() <em>Mapping Declaration CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingDeclarationCS()
	 * @generated
	 * @ordered
	 */
	protected MappingDeclarationCS mappingDeclarationCS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingMethodCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.MAPPING_METHOD_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBlackBox() {
		return (eFlags & BLACK_BOX_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlackBox(boolean newBlackBox) {
		boolean oldBlackBox = (eFlags & BLACK_BOX_EFLAG) != 0;
		if (newBlackBox) eFlags |= BLACK_BOX_EFLAG; else eFlags &= ~BLACK_BOX_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_METHOD_CS__BLACK_BOX, oldBlackBox, newBlackBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingDeclarationCS getMappingDeclarationCS() {
		return mappingDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingDeclarationCS(MappingDeclarationCS newMappingDeclarationCS, NotificationChain msgs) {
		MappingDeclarationCS oldMappingDeclarationCS = mappingDeclarationCS;
		mappingDeclarationCS = newMappingDeclarationCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS, oldMappingDeclarationCS, newMappingDeclarationCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingDeclarationCS(MappingDeclarationCS newMappingDeclarationCS) {
		if (newMappingDeclarationCS != mappingDeclarationCS) {
			NotificationChain msgs = null;
			if (mappingDeclarationCS != null)
				msgs = ((InternalEObject)mappingDeclarationCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS, null, msgs);
			if (newMappingDeclarationCS != null)
				msgs = ((InternalEObject)newMappingDeclarationCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS, null, msgs);
			msgs = basicSetMappingDeclarationCS(newMappingDeclarationCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS, newMappingDeclarationCS, newMappingDeclarationCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS:
				return basicSetMappingDeclarationCS(null, msgs);
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
			case CSTPackage.MAPPING_METHOD_CS__BLACK_BOX:
				return isBlackBox();
			case CSTPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS:
				return getMappingDeclarationCS();
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
			case CSTPackage.MAPPING_METHOD_CS__BLACK_BOX:
				setBlackBox((Boolean)newValue);
				return;
			case CSTPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS:
				setMappingDeclarationCS((MappingDeclarationCS)newValue);
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
			case CSTPackage.MAPPING_METHOD_CS__BLACK_BOX:
				setBlackBox(BLACK_BOX_EDEFAULT);
				return;
			case CSTPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS:
				setMappingDeclarationCS((MappingDeclarationCS)null);
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
			case CSTPackage.MAPPING_METHOD_CS__BLACK_BOX:
				return ((eFlags & BLACK_BOX_EFLAG) != 0) != BLACK_BOX_EDEFAULT;
			case CSTPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS:
				return mappingDeclarationCS != null;
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
		result.append(" (blackBox: "); //$NON-NLS-1$
		result.append((eFlags & BLACK_BOX_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} //MappingMethodCSImpl
