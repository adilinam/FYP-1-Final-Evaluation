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
 * $Id: MappingSectionCSImpl.java,v 1.5 2010/01/29 15:23:40 sboyko Exp $
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
import org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS;

import org.eclipse.ocl.cst.OCLExpressionCS;

import org.eclipse.ocl.cst.impl.CSTNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Section CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionCSImpl#getBodyStartLocation <em>Body Start Location</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionCSImpl#getBodyEndLocation <em>Body End Location</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionCSImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionCSImpl#getMappingRuleCS <em>Mapping Rule CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MappingSectionCSImpl extends CSTNodeImpl implements MappingSectionCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getBodyStartLocation() <em>Body Start Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyStartLocation()
	 * @generated
	 * @ordered
	 */
	protected static final int BODY_START_LOCATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBodyStartLocation() <em>Body Start Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyStartLocation()
	 * @generated
	 * @ordered
	 */
	protected int bodyStartLocation = BODY_START_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getBodyEndLocation() <em>Body End Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyEndLocation()
	 * @generated
	 * @ordered
	 */
	protected static final int BODY_END_LOCATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBodyEndLocation() <em>Body End Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyEndLocation()
	 * @generated
	 * @ordered
	 */
	protected int bodyEndLocation = BODY_END_LOCATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpressionCS> statements;

	/**
	 * The cached value of the '{@link #getMappingRuleCS() <em>Mapping Rule CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingRuleCS()
	 * @generated
	 * @ordered
	 */
	protected MappingRuleCS mappingRuleCS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingSectionCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.MAPPING_SECTION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBodyStartLocation() {
		return bodyStartLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyStartLocation(int newBodyStartLocation) {
		int oldBodyStartLocation = bodyStartLocation;
		bodyStartLocation = newBodyStartLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_SECTION_CS__BODY_START_LOCATION, oldBodyStartLocation, bodyStartLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBodyEndLocation() {
		return bodyEndLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyEndLocation(int newBodyEndLocation) {
		int oldBodyEndLocation = bodyEndLocation;
		bodyEndLocation = newBodyEndLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_SECTION_CS__BODY_END_LOCATION, oldBodyEndLocation, bodyEndLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpressionCS> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<OCLExpressionCS>(OCLExpressionCS.class, this, CSTPackage.MAPPING_SECTION_CS__STATEMENTS);
		}
		return statements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRuleCS getMappingRuleCS() {
		return mappingRuleCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingRuleCS(MappingRuleCS newMappingRuleCS, NotificationChain msgs) {
		MappingRuleCS oldMappingRuleCS = mappingRuleCS;
		mappingRuleCS = newMappingRuleCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_SECTION_CS__MAPPING_RULE_CS, oldMappingRuleCS, newMappingRuleCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingRuleCS(MappingRuleCS newMappingRuleCS) {
		if (newMappingRuleCS != mappingRuleCS) {
			NotificationChain msgs = null;
			if (mappingRuleCS != null)
				msgs = ((InternalEObject)mappingRuleCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_SECTION_CS__MAPPING_RULE_CS, null, msgs);
			if (newMappingRuleCS != null)
				msgs = ((InternalEObject)newMappingRuleCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_SECTION_CS__MAPPING_RULE_CS, null, msgs);
			msgs = basicSetMappingRuleCS(newMappingRuleCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_SECTION_CS__MAPPING_RULE_CS, newMappingRuleCS, newMappingRuleCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.MAPPING_SECTION_CS__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
			case CSTPackage.MAPPING_SECTION_CS__MAPPING_RULE_CS:
				return basicSetMappingRuleCS(null, msgs);
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
			case CSTPackage.MAPPING_SECTION_CS__BODY_START_LOCATION:
				return getBodyStartLocation();
			case CSTPackage.MAPPING_SECTION_CS__BODY_END_LOCATION:
				return getBodyEndLocation();
			case CSTPackage.MAPPING_SECTION_CS__STATEMENTS:
				return getStatements();
			case CSTPackage.MAPPING_SECTION_CS__MAPPING_RULE_CS:
				return getMappingRuleCS();
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
			case CSTPackage.MAPPING_SECTION_CS__BODY_START_LOCATION:
				setBodyStartLocation((Integer)newValue);
				return;
			case CSTPackage.MAPPING_SECTION_CS__BODY_END_LOCATION:
				setBodyEndLocation((Integer)newValue);
				return;
			case CSTPackage.MAPPING_SECTION_CS__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends OCLExpressionCS>)newValue);
				return;
			case CSTPackage.MAPPING_SECTION_CS__MAPPING_RULE_CS:
				setMappingRuleCS((MappingRuleCS)newValue);
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
			case CSTPackage.MAPPING_SECTION_CS__BODY_START_LOCATION:
				setBodyStartLocation(BODY_START_LOCATION_EDEFAULT);
				return;
			case CSTPackage.MAPPING_SECTION_CS__BODY_END_LOCATION:
				setBodyEndLocation(BODY_END_LOCATION_EDEFAULT);
				return;
			case CSTPackage.MAPPING_SECTION_CS__STATEMENTS:
				getStatements().clear();
				return;
			case CSTPackage.MAPPING_SECTION_CS__MAPPING_RULE_CS:
				setMappingRuleCS((MappingRuleCS)null);
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
			case CSTPackage.MAPPING_SECTION_CS__BODY_START_LOCATION:
				return bodyStartLocation != BODY_START_LOCATION_EDEFAULT;
			case CSTPackage.MAPPING_SECTION_CS__BODY_END_LOCATION:
				return bodyEndLocation != BODY_END_LOCATION_EDEFAULT;
			case CSTPackage.MAPPING_SECTION_CS__STATEMENTS:
				return statements != null && !statements.isEmpty();
			case CSTPackage.MAPPING_SECTION_CS__MAPPING_RULE_CS:
				return mappingRuleCS != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ElementWithBody.class) {
			switch (derivedFeatureID) {
				case CSTPackage.MAPPING_SECTION_CS__BODY_START_LOCATION: return CSTPackage.ELEMENT_WITH_BODY__BODY_START_LOCATION;
				case CSTPackage.MAPPING_SECTION_CS__BODY_END_LOCATION: return CSTPackage.ELEMENT_WITH_BODY__BODY_END_LOCATION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ElementWithBody.class) {
			switch (baseFeatureID) {
				case CSTPackage.ELEMENT_WITH_BODY__BODY_START_LOCATION: return CSTPackage.MAPPING_SECTION_CS__BODY_START_LOCATION;
				case CSTPackage.ELEMENT_WITH_BODY__BODY_END_LOCATION: return CSTPackage.MAPPING_SECTION_CS__BODY_END_LOCATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (bodyStartLocation: "); //$NON-NLS-1$
		result.append(bodyStartLocation);
		result.append(", bodyEndLocation: "); //$NON-NLS-1$
		result.append(bodyEndLocation);
		result.append(')');
		return result.toString();
	}

} //MappingSectionCSImpl
