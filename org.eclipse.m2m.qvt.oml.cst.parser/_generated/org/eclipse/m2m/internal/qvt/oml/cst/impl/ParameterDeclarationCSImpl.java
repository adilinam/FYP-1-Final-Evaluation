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
 * $Id: ParameterDeclarationCSImpl.java,v 1.5 2010/01/29 15:23:40 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;

import org.eclipse.ocl.cst.SimpleNameCS;

import org.eclipse.ocl.cst.impl.CSTNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ParameterDeclarationCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ParameterDeclarationCSImpl#getTypeSpecCS <em>Type Spec CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ParameterDeclarationCSImpl#getDirectionKind <em>Direction Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterDeclarationCSImpl extends CSTNodeImpl implements ParameterDeclarationCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

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
	 * The cached value of the '{@link #getTypeSpecCS() <em>Type Spec CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeSpecCS()
	 * @generated
	 * @ordered
	 */
	protected TypeSpecCS typeSpecCS;

	/**
	 * The default value of the '{@link #getDirectionKind() <em>Direction Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectionKind()
	 * @generated
	 * @ordered
	 */
	protected static final DirectionKindEnum DIRECTION_KIND_EDEFAULT = DirectionKindEnum.DEFAULT;

	/**
	 * The cached value of the '{@link #getDirectionKind() <em>Direction Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectionKind()
	 * @generated
	 * @ordered
	 */
	protected DirectionKindEnum directionKind = DIRECTION_KIND_EDEFAULT;

	/**
	 * The flag representing whether the Direction Kind attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int DIRECTION_KIND_ESETFLAG = 1 << 8;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterDeclarationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.PARAMETER_DECLARATION_CS;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS, oldSimpleNameCS, newSimpleNameCS);
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
				msgs = ((InternalEObject)simpleNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS, null, msgs);
			if (newSimpleNameCS != null)
				msgs = ((InternalEObject)newSimpleNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS, null, msgs);
			msgs = basicSetSimpleNameCS(newSimpleNameCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS, newSimpleNameCS, newSimpleNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSpecCS getTypeSpecCS() {
		return typeSpecCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeSpecCS(TypeSpecCS newTypeSpecCS, NotificationChain msgs) {
		TypeSpecCS oldTypeSpecCS = typeSpecCS;
		typeSpecCS = newTypeSpecCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS, oldTypeSpecCS, newTypeSpecCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeSpecCS(TypeSpecCS newTypeSpecCS) {
		if (newTypeSpecCS != typeSpecCS) {
			NotificationChain msgs = null;
			if (typeSpecCS != null)
				msgs = ((InternalEObject)typeSpecCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS, null, msgs);
			if (newTypeSpecCS != null)
				msgs = ((InternalEObject)newTypeSpecCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS, null, msgs);
			msgs = basicSetTypeSpecCS(newTypeSpecCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS, newTypeSpecCS, newTypeSpecCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindEnum getDirectionKind() {
		return directionKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectionKind(DirectionKindEnum newDirectionKind) {
		DirectionKindEnum oldDirectionKind = directionKind;
		directionKind = newDirectionKind == null ? DIRECTION_KIND_EDEFAULT : newDirectionKind;
		boolean oldDirectionKindESet = (eFlags & DIRECTION_KIND_ESETFLAG) != 0;
		eFlags |= DIRECTION_KIND_ESETFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PARAMETER_DECLARATION_CS__DIRECTION_KIND, oldDirectionKind, directionKind, !oldDirectionKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDirectionKind() {
		DirectionKindEnum oldDirectionKind = directionKind;
		boolean oldDirectionKindESet = (eFlags & DIRECTION_KIND_ESETFLAG) != 0;
		directionKind = DIRECTION_KIND_EDEFAULT;
		eFlags &= ~DIRECTION_KIND_ESETFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CSTPackage.PARAMETER_DECLARATION_CS__DIRECTION_KIND, oldDirectionKind, DIRECTION_KIND_EDEFAULT, oldDirectionKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDirectionKind() {
		return (eFlags & DIRECTION_KIND_ESETFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS:
				return basicSetSimpleNameCS(null, msgs);
			case CSTPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS:
				return basicSetTypeSpecCS(null, msgs);
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
			case CSTPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS:
				return getSimpleNameCS();
			case CSTPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS:
				return getTypeSpecCS();
			case CSTPackage.PARAMETER_DECLARATION_CS__DIRECTION_KIND:
				return getDirectionKind();
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
			case CSTPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)newValue);
				return;
			case CSTPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS:
				setTypeSpecCS((TypeSpecCS)newValue);
				return;
			case CSTPackage.PARAMETER_DECLARATION_CS__DIRECTION_KIND:
				setDirectionKind((DirectionKindEnum)newValue);
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
			case CSTPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)null);
				return;
			case CSTPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS:
				setTypeSpecCS((TypeSpecCS)null);
				return;
			case CSTPackage.PARAMETER_DECLARATION_CS__DIRECTION_KIND:
				unsetDirectionKind();
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
			case CSTPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS:
				return simpleNameCS != null;
			case CSTPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS:
				return typeSpecCS != null;
			case CSTPackage.PARAMETER_DECLARATION_CS__DIRECTION_KIND:
				return isSetDirectionKind();
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
		result.append(" (directionKind: "); //$NON-NLS-1$
		if ((eFlags & DIRECTION_KIND_ESETFLAG) != 0) result.append(directionKind); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //ParameterDeclarationCSImpl
