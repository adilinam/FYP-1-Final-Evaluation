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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.internal.ClassImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelType;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModelTypeImpl#getAdditionalCondition <em>Additional Condition</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModelTypeImpl#getConformanceKind <em>Conformance Kind</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModelTypeImpl#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelTypeImpl extends ClassImpl implements ModelType {
	/**
	 * The cached value of the '{@link #getAdditionalCondition() <em>Additional Condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalCondition()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression> additionalCondition;

	/**
	 * The default value of the '{@link #getConformanceKind() <em>Conformance Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConformanceKind()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFORMANCE_KIND_EDEFAULT = "effective";

	/**
	 * The cached value of the '{@link #getConformanceKind() <em>Conformance Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConformanceKind()
	 * @generated
	 * @ordered
	 */
	protected String conformanceKind = CONFORMANCE_KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.pivot.Package> metamodel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.MODEL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpression> getAdditionalCondition() {
		if (additionalCondition == null) {
			additionalCondition = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, QVTOperationalPackage.MODEL_TYPE__ADDITIONAL_CONDITION);
		}
		return additionalCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConformanceKind() {
		return conformanceKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConformanceKind(String newConformanceKind) {
		String oldConformanceKind = conformanceKind;
		conformanceKind = newConformanceKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODEL_TYPE__CONFORMANCE_KIND, oldConformanceKind, conformanceKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.ocl.pivot.Package> getMetamodel() {
		if (metamodel == null) {
			metamodel = new EObjectResolvingEList<org.eclipse.ocl.pivot.Package>(org.eclipse.ocl.pivot.Package.class, this, QVTOperationalPackage.MODEL_TYPE__METAMODEL);
		}
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.MODEL_TYPE__ADDITIONAL_CONDITION:
				return ((InternalEList<?>)getAdditionalCondition()).basicRemove(otherEnd, msgs);
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
			case QVTOperationalPackage.MODEL_TYPE__ADDITIONAL_CONDITION:
				return getAdditionalCondition();
			case QVTOperationalPackage.MODEL_TYPE__CONFORMANCE_KIND:
				return getConformanceKind();
			case QVTOperationalPackage.MODEL_TYPE__METAMODEL:
				return getMetamodel();
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
			case QVTOperationalPackage.MODEL_TYPE__ADDITIONAL_CONDITION:
				getAdditionalCondition().clear();
				getAdditionalCondition().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case QVTOperationalPackage.MODEL_TYPE__CONFORMANCE_KIND:
				setConformanceKind((String)newValue);
				return;
			case QVTOperationalPackage.MODEL_TYPE__METAMODEL:
				getMetamodel().clear();
				getMetamodel().addAll((Collection<? extends org.eclipse.ocl.pivot.Package>)newValue);
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
			case QVTOperationalPackage.MODEL_TYPE__ADDITIONAL_CONDITION:
				getAdditionalCondition().clear();
				return;
			case QVTOperationalPackage.MODEL_TYPE__CONFORMANCE_KIND:
				setConformanceKind(CONFORMANCE_KIND_EDEFAULT);
				return;
			case QVTOperationalPackage.MODEL_TYPE__METAMODEL:
				getMetamodel().clear();
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
			case QVTOperationalPackage.MODEL_TYPE__ADDITIONAL_CONDITION:
				return additionalCondition != null && !additionalCondition.isEmpty();
			case QVTOperationalPackage.MODEL_TYPE__CONFORMANCE_KIND:
				return CONFORMANCE_KIND_EDEFAULT == null ? conformanceKind != null : !CONFORMANCE_KIND_EDEFAULT.equals(conformanceKind);
			case QVTOperationalPackage.MODEL_TYPE__METAMODEL:
				return metamodel != null && !metamodel.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(Visitor<R> visitor) {
		return (R) ((QVTOperationalVisitor<?>)visitor).visitModelType(this);
	}

} //ModelTypeImpl
