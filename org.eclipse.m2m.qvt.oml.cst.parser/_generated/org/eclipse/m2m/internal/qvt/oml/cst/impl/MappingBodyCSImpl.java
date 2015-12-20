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
 * $Id: MappingBodyCSImpl.java,v 1.5 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Body CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingBodyCSImpl#isHasPopulationKeyword <em>Has Population Keyword</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingBodyCSImpl extends MappingSectionCSImpl implements MappingBodyCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isHasPopulationKeyword() <em>Has Population Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasPopulationKeyword()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_POPULATION_KEYWORD_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isHasPopulationKeyword() <em>Has Population Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasPopulationKeyword()
	 * @generated
	 * @ordered
	 */
	protected static final int HAS_POPULATION_KEYWORD_EFLAG = 1 << 8;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingBodyCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.MAPPING_BODY_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasPopulationKeyword() {
		return (eFlags & HAS_POPULATION_KEYWORD_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasPopulationKeyword(boolean newHasPopulationKeyword) {
		boolean oldHasPopulationKeyword = (eFlags & HAS_POPULATION_KEYWORD_EFLAG) != 0;
		if (newHasPopulationKeyword) eFlags |= HAS_POPULATION_KEYWORD_EFLAG; else eFlags &= ~HAS_POPULATION_KEYWORD_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_BODY_CS__HAS_POPULATION_KEYWORD, oldHasPopulationKeyword, newHasPopulationKeyword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CSTPackage.MAPPING_BODY_CS__HAS_POPULATION_KEYWORD:
				return isHasPopulationKeyword();
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
			case CSTPackage.MAPPING_BODY_CS__HAS_POPULATION_KEYWORD:
				setHasPopulationKeyword((Boolean)newValue);
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
			case CSTPackage.MAPPING_BODY_CS__HAS_POPULATION_KEYWORD:
				setHasPopulationKeyword(HAS_POPULATION_KEYWORD_EDEFAULT);
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
			case CSTPackage.MAPPING_BODY_CS__HAS_POPULATION_KEYWORD:
				return ((eFlags & HAS_POPULATION_KEYWORD_EFLAG) != 0) != HAS_POPULATION_KEYWORD_EDEFAULT;
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
		result.append(" (hasPopulationKeyword: "); //$NON-NLS-1$
		result.append((eFlags & HAS_POPULATION_KEYWORD_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} //MappingBodyCSImpl
