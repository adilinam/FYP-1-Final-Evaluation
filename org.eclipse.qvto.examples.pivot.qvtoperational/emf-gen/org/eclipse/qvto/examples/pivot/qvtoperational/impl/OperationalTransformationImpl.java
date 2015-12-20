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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operational Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.OperationalTransformationImpl#getIntermediateClass <em>Intermediate Class</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.OperationalTransformationImpl#getIntermediateProperty <em>Intermediate Property</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.OperationalTransformationImpl#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.OperationalTransformationImpl#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.OperationalTransformationImpl#getRelation <em>Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationalTransformationImpl extends ModuleImpl implements OperationalTransformation {
	/**
	 * The cached value of the '{@link #getIntermediateClass() <em>Intermediate Class</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateClass()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.pivot.Class> intermediateClass;

	/**
	 * The cached value of the '{@link #getIntermediateProperty() <em>Intermediate Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> intermediateProperty;

	/**
	 * The cached value of the '{@link #getModelParameter() <em>Model Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelParameter> modelParameter;

	/**
	 * The cached value of the '{@link #getRefined() <em>Refined</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefined()
	 * @generated
	 * @ordered
	 */
	protected DummyRelationalTransformation refined;

	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected EList<DummyRelation> relation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationalTransformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.ocl.pivot.Class> getIntermediateClass() {
		if (intermediateClass == null) {
			intermediateClass = new EObjectResolvingEList<org.eclipse.ocl.pivot.Class>(org.eclipse.ocl.pivot.Class.class, this, QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_CLASS);
		}
		return intermediateClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getIntermediateProperty() {
		if (intermediateProperty == null) {
			intermediateProperty = new EObjectResolvingEList<Property>(Property.class, this, QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_PROPERTY);
		}
		return intermediateProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelParameter> getModelParameter() {
		if (modelParameter == null) {
			modelParameter = new EObjectContainmentEList<ModelParameter>(ModelParameter.class, this, QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__MODEL_PARAMETER);
		}
		return modelParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DummyRelationalTransformation getRefined() {
		if (refined != null && refined.eIsProxy()) {
			InternalEObject oldRefined = (InternalEObject)refined;
			refined = (DummyRelationalTransformation)eResolveProxy(oldRefined);
			if (refined != oldRefined) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__REFINED, oldRefined, refined));
			}
		}
		return refined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DummyRelationalTransformation basicGetRefined() {
		return refined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefined(DummyRelationalTransformation newRefined) {
		DummyRelationalTransformation oldRefined = refined;
		refined = newRefined;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__REFINED, oldRefined, refined));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DummyRelation> getRelation() {
		if (relation == null) {
			relation = new EObjectContainmentEList<DummyRelation>(DummyRelation.class, this, QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__RELATION);
		}
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__MODEL_PARAMETER:
				return ((InternalEList<?>)getModelParameter()).basicRemove(otherEnd, msgs);
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__RELATION:
				return ((InternalEList<?>)getRelation()).basicRemove(otherEnd, msgs);
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
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_CLASS:
				return getIntermediateClass();
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_PROPERTY:
				return getIntermediateProperty();
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__MODEL_PARAMETER:
				return getModelParameter();
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__REFINED:
				if (resolve) return getRefined();
				return basicGetRefined();
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__RELATION:
				return getRelation();
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
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_CLASS:
				getIntermediateClass().clear();
				getIntermediateClass().addAll((Collection<? extends org.eclipse.ocl.pivot.Class>)newValue);
				return;
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_PROPERTY:
				getIntermediateProperty().clear();
				getIntermediateProperty().addAll((Collection<? extends Property>)newValue);
				return;
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__MODEL_PARAMETER:
				getModelParameter().clear();
				getModelParameter().addAll((Collection<? extends ModelParameter>)newValue);
				return;
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__REFINED:
				setRefined((DummyRelationalTransformation)newValue);
				return;
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__RELATION:
				getRelation().clear();
				getRelation().addAll((Collection<? extends DummyRelation>)newValue);
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
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_CLASS:
				getIntermediateClass().clear();
				return;
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_PROPERTY:
				getIntermediateProperty().clear();
				return;
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__MODEL_PARAMETER:
				getModelParameter().clear();
				return;
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__REFINED:
				setRefined((DummyRelationalTransformation)null);
				return;
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__RELATION:
				getRelation().clear();
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
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_CLASS:
				return intermediateClass != null && !intermediateClass.isEmpty();
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_PROPERTY:
				return intermediateProperty != null && !intermediateProperty.isEmpty();
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__MODEL_PARAMETER:
				return modelParameter != null && !modelParameter.isEmpty();
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__REFINED:
				return refined != null;
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__RELATION:
				return relation != null && !relation.isEmpty();
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
		return (R) ((QVTOperationalVisitor<?>)visitor).visitOperationalTransformation(this);
	}

} //OperationalTransformationImpl
