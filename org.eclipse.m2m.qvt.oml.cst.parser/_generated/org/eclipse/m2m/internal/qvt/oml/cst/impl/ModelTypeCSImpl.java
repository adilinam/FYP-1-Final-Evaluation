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
 * $Id: ModelTypeCSImpl.java,v 1.6 2010/01/29 15:23:40 sboyko Exp $
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
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS;

import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;

import org.eclipse.ocl.cst.impl.CSTNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Type CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModelTypeCSImpl#getBodyStartLocation <em>Body Start Location</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModelTypeCSImpl#getBodyEndLocation <em>Body End Location</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModelTypeCSImpl#getIdentifierCS <em>Identifier CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModelTypeCSImpl#getComplianceKindCS <em>Compliance Kind CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModelTypeCSImpl#getPackageRefs <em>Package Refs</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModelTypeCSImpl#getWhereStatements <em>Where Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelTypeCSImpl extends CSTNodeImpl implements ModelTypeCS {
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
	 * The cached value of the '{@link #getIdentifierCS() <em>Identifier CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifierCS()
	 * @generated
	 * @ordered
	 */
	protected SimpleNameCS identifierCS;

	/**
	 * The cached value of the '{@link #getComplianceKindCS() <em>Compliance Kind CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplianceKindCS()
	 * @generated
	 * @ordered
	 */
	protected StringLiteralExpCS complianceKindCS;

	/**
	 * The cached value of the '{@link #getPackageRefs() <em>Package Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageRefCS> packageRefs;

	/**
	 * The cached value of the '{@link #getWhereStatements() <em>Where Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhereStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpressionCS> whereStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelTypeCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.MODEL_TYPE_CS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MODEL_TYPE_CS__BODY_START_LOCATION, oldBodyStartLocation, bodyStartLocation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MODEL_TYPE_CS__BODY_END_LOCATION, oldBodyEndLocation, bodyEndLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS getIdentifierCS() {
		return identifierCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentifierCS(SimpleNameCS newIdentifierCS, NotificationChain msgs) {
		SimpleNameCS oldIdentifierCS = identifierCS;
		identifierCS = newIdentifierCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MODEL_TYPE_CS__IDENTIFIER_CS, oldIdentifierCS, newIdentifierCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifierCS(SimpleNameCS newIdentifierCS) {
		if (newIdentifierCS != identifierCS) {
			NotificationChain msgs = null;
			if (identifierCS != null)
				msgs = ((InternalEObject)identifierCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MODEL_TYPE_CS__IDENTIFIER_CS, null, msgs);
			if (newIdentifierCS != null)
				msgs = ((InternalEObject)newIdentifierCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MODEL_TYPE_CS__IDENTIFIER_CS, null, msgs);
			msgs = basicSetIdentifierCS(newIdentifierCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MODEL_TYPE_CS__IDENTIFIER_CS, newIdentifierCS, newIdentifierCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExpCS getComplianceKindCS() {
		return complianceKindCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComplianceKindCS(StringLiteralExpCS newComplianceKindCS, NotificationChain msgs) {
		StringLiteralExpCS oldComplianceKindCS = complianceKindCS;
		complianceKindCS = newComplianceKindCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS, oldComplianceKindCS, newComplianceKindCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComplianceKindCS(StringLiteralExpCS newComplianceKindCS) {
		if (newComplianceKindCS != complianceKindCS) {
			NotificationChain msgs = null;
			if (complianceKindCS != null)
				msgs = ((InternalEObject)complianceKindCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS, null, msgs);
			if (newComplianceKindCS != null)
				msgs = ((InternalEObject)newComplianceKindCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS, null, msgs);
			msgs = basicSetComplianceKindCS(newComplianceKindCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS, newComplianceKindCS, newComplianceKindCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageRefCS> getPackageRefs() {
		if (packageRefs == null) {
			packageRefs = new EObjectContainmentEList<PackageRefCS>(PackageRefCS.class, this, CSTPackage.MODEL_TYPE_CS__PACKAGE_REFS);
		}
		return packageRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpressionCS> getWhereStatements() {
		if (whereStatements == null) {
			whereStatements = new EObjectContainmentEList<OCLExpressionCS>(OCLExpressionCS.class, this, CSTPackage.MODEL_TYPE_CS__WHERE_STATEMENTS);
		}
		return whereStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.MODEL_TYPE_CS__IDENTIFIER_CS:
				return basicSetIdentifierCS(null, msgs);
			case CSTPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS:
				return basicSetComplianceKindCS(null, msgs);
			case CSTPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				return ((InternalEList<?>)getPackageRefs()).basicRemove(otherEnd, msgs);
			case CSTPackage.MODEL_TYPE_CS__WHERE_STATEMENTS:
				return ((InternalEList<?>)getWhereStatements()).basicRemove(otherEnd, msgs);
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
			case CSTPackage.MODEL_TYPE_CS__BODY_START_LOCATION:
				return getBodyStartLocation();
			case CSTPackage.MODEL_TYPE_CS__BODY_END_LOCATION:
				return getBodyEndLocation();
			case CSTPackage.MODEL_TYPE_CS__IDENTIFIER_CS:
				return getIdentifierCS();
			case CSTPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS:
				return getComplianceKindCS();
			case CSTPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				return getPackageRefs();
			case CSTPackage.MODEL_TYPE_CS__WHERE_STATEMENTS:
				return getWhereStatements();
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
			case CSTPackage.MODEL_TYPE_CS__BODY_START_LOCATION:
				setBodyStartLocation((Integer)newValue);
				return;
			case CSTPackage.MODEL_TYPE_CS__BODY_END_LOCATION:
				setBodyEndLocation((Integer)newValue);
				return;
			case CSTPackage.MODEL_TYPE_CS__IDENTIFIER_CS:
				setIdentifierCS((SimpleNameCS)newValue);
				return;
			case CSTPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS:
				setComplianceKindCS((StringLiteralExpCS)newValue);
				return;
			case CSTPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				getPackageRefs().clear();
				getPackageRefs().addAll((Collection<? extends PackageRefCS>)newValue);
				return;
			case CSTPackage.MODEL_TYPE_CS__WHERE_STATEMENTS:
				getWhereStatements().clear();
				getWhereStatements().addAll((Collection<? extends OCLExpressionCS>)newValue);
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
			case CSTPackage.MODEL_TYPE_CS__BODY_START_LOCATION:
				setBodyStartLocation(BODY_START_LOCATION_EDEFAULT);
				return;
			case CSTPackage.MODEL_TYPE_CS__BODY_END_LOCATION:
				setBodyEndLocation(BODY_END_LOCATION_EDEFAULT);
				return;
			case CSTPackage.MODEL_TYPE_CS__IDENTIFIER_CS:
				setIdentifierCS((SimpleNameCS)null);
				return;
			case CSTPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS:
				setComplianceKindCS((StringLiteralExpCS)null);
				return;
			case CSTPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				getPackageRefs().clear();
				return;
			case CSTPackage.MODEL_TYPE_CS__WHERE_STATEMENTS:
				getWhereStatements().clear();
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
			case CSTPackage.MODEL_TYPE_CS__BODY_START_LOCATION:
				return bodyStartLocation != BODY_START_LOCATION_EDEFAULT;
			case CSTPackage.MODEL_TYPE_CS__BODY_END_LOCATION:
				return bodyEndLocation != BODY_END_LOCATION_EDEFAULT;
			case CSTPackage.MODEL_TYPE_CS__IDENTIFIER_CS:
				return identifierCS != null;
			case CSTPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS:
				return complianceKindCS != null;
			case CSTPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				return packageRefs != null && !packageRefs.isEmpty();
			case CSTPackage.MODEL_TYPE_CS__WHERE_STATEMENTS:
				return whereStatements != null && !whereStatements.isEmpty();
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
				case CSTPackage.MODEL_TYPE_CS__BODY_START_LOCATION: return CSTPackage.ELEMENT_WITH_BODY__BODY_START_LOCATION;
				case CSTPackage.MODEL_TYPE_CS__BODY_END_LOCATION: return CSTPackage.ELEMENT_WITH_BODY__BODY_END_LOCATION;
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
				case CSTPackage.ELEMENT_WITH_BODY__BODY_START_LOCATION: return CSTPackage.MODEL_TYPE_CS__BODY_START_LOCATION;
				case CSTPackage.ELEMENT_WITH_BODY__BODY_END_LOCATION: return CSTPackage.MODEL_TYPE_CS__BODY_END_LOCATION;
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

} //ModelTypeCSImpl
