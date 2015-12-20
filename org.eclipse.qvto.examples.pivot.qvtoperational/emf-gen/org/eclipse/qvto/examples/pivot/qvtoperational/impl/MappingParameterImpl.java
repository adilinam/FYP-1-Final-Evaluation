/**
 * <copyright>
 * Copyright (c) 2013 Willink Transformations, University of York, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo (University of York) - Bug397429
 * </copyright>
 */
package org.eclipse.qvto.examples.pivot.qvtoperational.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.MappingParameterImpl#getExtent <em>Extent</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.MappingParameterImpl#getReferredDomain <em>Referred Domain</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingParameterImpl extends VarParameterImpl implements MappingParameter {
	/**
	 * The cached value of the '{@link #getExtent() <em>Extent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtent()
	 * @generated
	 * @ordered
	 */
	protected ModelParameter extent;

	/**
	 * The cached value of the '{@link #getReferredDomain() <em>Referred Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredDomain()
	 * @generated
	 * @ordered
	 */
	protected DummyRelationDomain referredDomain;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.MAPPING_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelParameter getExtent() {
		if (extent != null && extent.eIsProxy()) {
			InternalEObject oldExtent = (InternalEObject)extent;
			extent = (ModelParameter)eResolveProxy(oldExtent);
			if (extent != oldExtent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalPackage.MAPPING_PARAMETER__EXTENT, oldExtent, extent));
			}
		}
		return extent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelParameter basicGetExtent() {
		return extent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtent(ModelParameter newExtent) {
		ModelParameter oldExtent = extent;
		extent = newExtent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MAPPING_PARAMETER__EXTENT, oldExtent, extent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DummyRelationDomain getReferredDomain() {
		if (referredDomain != null && referredDomain.eIsProxy()) {
			InternalEObject oldReferredDomain = (InternalEObject)referredDomain;
			referredDomain = (DummyRelationDomain)eResolveProxy(oldReferredDomain);
			if (referredDomain != oldReferredDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalPackage.MAPPING_PARAMETER__REFERRED_DOMAIN, oldReferredDomain, referredDomain));
			}
		}
		return referredDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DummyRelationDomain basicGetReferredDomain() {
		return referredDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredDomain(DummyRelationDomain newReferredDomain) {
		DummyRelationDomain oldReferredDomain = referredDomain;
		referredDomain = newReferredDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MAPPING_PARAMETER__REFERRED_DOMAIN, oldReferredDomain, referredDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTOperationalPackage.MAPPING_PARAMETER__EXTENT:
				if (resolve) return getExtent();
				return basicGetExtent();
			case QVTOperationalPackage.MAPPING_PARAMETER__REFERRED_DOMAIN:
				if (resolve) return getReferredDomain();
				return basicGetReferredDomain();
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
			case QVTOperationalPackage.MAPPING_PARAMETER__EXTENT:
				setExtent((ModelParameter)newValue);
				return;
			case QVTOperationalPackage.MAPPING_PARAMETER__REFERRED_DOMAIN:
				setReferredDomain((DummyRelationDomain)newValue);
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
			case QVTOperationalPackage.MAPPING_PARAMETER__EXTENT:
				setExtent((ModelParameter)null);
				return;
			case QVTOperationalPackage.MAPPING_PARAMETER__REFERRED_DOMAIN:
				setReferredDomain((DummyRelationDomain)null);
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
			case QVTOperationalPackage.MAPPING_PARAMETER__EXTENT:
				return extent != null;
			case QVTOperationalPackage.MAPPING_PARAMETER__REFERRED_DOMAIN:
				return referredDomain != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(Visitor<R> visitor) {
		return (R) ((QVTOperationalVisitor<?>)visitor).visitMappingParameter(this);
	}

} //MappingParameterImpl
