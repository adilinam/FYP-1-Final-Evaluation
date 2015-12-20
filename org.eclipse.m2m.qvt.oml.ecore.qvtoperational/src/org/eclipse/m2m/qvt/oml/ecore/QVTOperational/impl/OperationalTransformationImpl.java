/**
 * <copyright>
 * Copyright (c) 2008 Open Canarias and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OperationalTransformationImpl.java,v 1.2 2009/01/25 23:12:23 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ModelParameter;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.OperationalTransformation;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operational Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.OperationalTransformationImpl#getIntermediateClass <em>Intermediate Class</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.OperationalTransformationImpl#getIntermediateProperty <em>Intermediate Property</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.OperationalTransformationImpl#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.OperationalTransformationImpl#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.OperationalTransformationImpl#getRelation <em>Relation</em>}</li>
 * </ul>
 * </p>
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
	protected EList<EClass> intermediateClass;

	/**
	 * The cached value of the '{@link #getIntermediateProperty() <em>Intermediate Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<EStructuralFeature> intermediateProperty;

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
	protected RelationalTransformation refined;

	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> relation;

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
	public EList<EClass> getIntermediateClass() {
		if (intermediateClass == null) {
			intermediateClass = new EObjectResolvingEList<EClass>(EClass.class, this, QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_CLASS);
		}
		return intermediateClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EStructuralFeature> getIntermediateProperty() {
		if (intermediateProperty == null) {
			intermediateProperty = new EObjectResolvingEList<EStructuralFeature>(EStructuralFeature.class, this, QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_PROPERTY);
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
	public RelationalTransformation getRefined() {
		if (refined != null && refined.eIsProxy()) {
			InternalEObject oldRefined = (InternalEObject)refined;
			refined = (RelationalTransformation)eResolveProxy(oldRefined);
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
	public RelationalTransformation basicGetRefined() {
		return refined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefined(RelationalTransformation newRefined) {
		RelationalTransformation oldRefined = refined;
		refined = newRefined;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__REFINED, oldRefined, refined));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getRelation() {
		if (relation == null) {
			relation = new EObjectContainmentEList<Relation>(Relation.class, this, QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__RELATION);
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
				getIntermediateClass().addAll((Collection<? extends EClass>)newValue);
				return;
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_PROPERTY:
				getIntermediateProperty().clear();
				getIntermediateProperty().addAll((Collection<? extends EStructuralFeature>)newValue);
				return;
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__MODEL_PARAMETER:
				getModelParameter().clear();
				getModelParameter().addAll((Collection<? extends ModelParameter>)newValue);
				return;
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__REFINED:
				setRefined((RelationalTransformation)newValue);
				return;
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION__RELATION:
				getRelation().clear();
				getRelation().addAll((Collection<? extends Relation>)newValue);
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
				setRefined((RelationalTransformation)null);
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

} //OperationalTransformationImpl
