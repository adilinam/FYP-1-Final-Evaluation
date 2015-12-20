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
 * $Id: ClassifierPropertyCSImpl.java,v 1.5 2010/01/29 15:23:40 sboyko Exp $
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
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS;

import org.eclipse.ocl.cst.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Property CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ClassifierPropertyCSImpl#getStereotypeQualifiers <em>Stereotype Qualifiers</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ClassifierPropertyCSImpl#getFeatureKeys <em>Feature Keys</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ClassifierPropertyCSImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ClassifierPropertyCSImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ClassifierPropertyCSImpl#isIsOrdered <em>Is Ordered</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifierPropertyCSImpl extends LocalPropertyCSImpl implements ClassifierPropertyCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getStereotypeQualifiers() <em>Stereotype Qualifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypeQualifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<SimpleNameCS> stereotypeQualifiers;

	/**
	 * The cached value of the '{@link #getFeatureKeys() <em>Feature Keys</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<SimpleNameCS> featureKeys;

	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityDefCS multiplicity;

	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected OppositePropertyCS opposite;

	/**
	 * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORDERED_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_ORDERED_EFLAG = 1 << 8;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierPropertyCSImpl() {
		super();
		eFlags |= IS_ORDERED_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.CLASSIFIER_PROPERTY_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimpleNameCS> getStereotypeQualifiers() {
		if (stereotypeQualifiers == null) {
			stereotypeQualifiers = new EObjectContainmentEList<SimpleNameCS>(SimpleNameCS.class, this, CSTPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPE_QUALIFIERS);
		}
		return stereotypeQualifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimpleNameCS> getFeatureKeys() {
		if (featureKeys == null) {
			featureKeys = new EObjectContainmentEList<SimpleNameCS>(SimpleNameCS.class, this, CSTPackage.CLASSIFIER_PROPERTY_CS__FEATURE_KEYS);
		}
		return featureKeys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityDefCS getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMultiplicity(MultiplicityDefCS newMultiplicity, NotificationChain msgs) {
		MultiplicityDefCS oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY, oldMultiplicity, newMultiplicity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(MultiplicityDefCS newMultiplicity) {
		if (newMultiplicity != multiplicity) {
			NotificationChain msgs = null;
			if (multiplicity != null)
				msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY, null, msgs);
			if (newMultiplicity != null)
				msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY, null, msgs);
			msgs = basicSetMultiplicity(newMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY, newMultiplicity, newMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OppositePropertyCS getOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpposite(OppositePropertyCS newOpposite, NotificationChain msgs) {
		OppositePropertyCS oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE, oldOpposite, newOpposite);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpposite(OppositePropertyCS newOpposite) {
		if (newOpposite != opposite) {
			NotificationChain msgs = null;
			if (opposite != null)
				msgs = ((InternalEObject)opposite).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE, null, msgs);
			if (newOpposite != null)
				msgs = ((InternalEObject)newOpposite).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE, null, msgs);
			msgs = basicSetOpposite(newOpposite, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE, newOpposite, newOpposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsOrdered() {
		return (eFlags & IS_ORDERED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOrdered(boolean newIsOrdered) {
		boolean oldIsOrdered = (eFlags & IS_ORDERED_EFLAG) != 0;
		if (newIsOrdered) eFlags |= IS_ORDERED_EFLAG; else eFlags &= ~IS_ORDERED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CLASSIFIER_PROPERTY_CS__IS_ORDERED, oldIsOrdered, newIsOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPE_QUALIFIERS:
				return ((InternalEList<?>)getStereotypeQualifiers()).basicRemove(otherEnd, msgs);
			case CSTPackage.CLASSIFIER_PROPERTY_CS__FEATURE_KEYS:
				return ((InternalEList<?>)getFeatureKeys()).basicRemove(otherEnd, msgs);
			case CSTPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY:
				return basicSetMultiplicity(null, msgs);
			case CSTPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE:
				return basicSetOpposite(null, msgs);
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
			case CSTPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPE_QUALIFIERS:
				return getStereotypeQualifiers();
			case CSTPackage.CLASSIFIER_PROPERTY_CS__FEATURE_KEYS:
				return getFeatureKeys();
			case CSTPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY:
				return getMultiplicity();
			case CSTPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE:
				return getOpposite();
			case CSTPackage.CLASSIFIER_PROPERTY_CS__IS_ORDERED:
				return isIsOrdered();
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
			case CSTPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPE_QUALIFIERS:
				getStereotypeQualifiers().clear();
				getStereotypeQualifiers().addAll((Collection<? extends SimpleNameCS>)newValue);
				return;
			case CSTPackage.CLASSIFIER_PROPERTY_CS__FEATURE_KEYS:
				getFeatureKeys().clear();
				getFeatureKeys().addAll((Collection<? extends SimpleNameCS>)newValue);
				return;
			case CSTPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY:
				setMultiplicity((MultiplicityDefCS)newValue);
				return;
			case CSTPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE:
				setOpposite((OppositePropertyCS)newValue);
				return;
			case CSTPackage.CLASSIFIER_PROPERTY_CS__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
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
			case CSTPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPE_QUALIFIERS:
				getStereotypeQualifiers().clear();
				return;
			case CSTPackage.CLASSIFIER_PROPERTY_CS__FEATURE_KEYS:
				getFeatureKeys().clear();
				return;
			case CSTPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY:
				setMultiplicity((MultiplicityDefCS)null);
				return;
			case CSTPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE:
				setOpposite((OppositePropertyCS)null);
				return;
			case CSTPackage.CLASSIFIER_PROPERTY_CS__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
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
			case CSTPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPE_QUALIFIERS:
				return stereotypeQualifiers != null && !stereotypeQualifiers.isEmpty();
			case CSTPackage.CLASSIFIER_PROPERTY_CS__FEATURE_KEYS:
				return featureKeys != null && !featureKeys.isEmpty();
			case CSTPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY:
				return multiplicity != null;
			case CSTPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE:
				return opposite != null;
			case CSTPackage.CLASSIFIER_PROPERTY_CS__IS_ORDERED:
				return ((eFlags & IS_ORDERED_EFLAG) != 0) != IS_ORDERED_EDEFAULT;
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
		result.append(" (isOrdered: "); //$NON-NLS-1$
		result.append((eFlags & IS_ORDERED_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} //ClassifierPropertyCSImpl
