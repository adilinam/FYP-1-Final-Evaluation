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
 * $Id: OperationBodyImpl.java,v 1.3 2009/02/19 20:52:04 sboyko Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.OperationBody;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.OperationBodyImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.OperationBodyImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.OperationBodyImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationBodyImpl extends EModelElementImpl implements OperationBody {
	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression> content;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationBodyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.OPERATION_BODY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpression> getContent() {
		if (content == null) {
			content = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, QVTOperationalPackage.OPERATION_BODY__CONTENT);
		}
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOperation getOperation() {
		if (eContainerFeatureID() != QVTOperationalPackage.OPERATION_BODY__OPERATION) return null;
		return (ImperativeOperation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperation(ImperativeOperation newOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperation, QVTOperationalPackage.OPERATION_BODY__OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(ImperativeOperation newOperation) {
		if (newOperation != eInternalContainer() || (eContainerFeatureID() != QVTOperationalPackage.OPERATION_BODY__OPERATION && newOperation != null)) {
			if (EcoreUtil.isAncestor(this, newOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperation != null)
				msgs = ((InternalEObject)newOperation).eInverseAdd(this, QVTOperationalPackage.IMPERATIVE_OPERATION__BODY, ImperativeOperation.class, msgs);
			msgs = basicSetOperation(newOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.OPERATION_BODY__OPERATION, newOperation, newOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariable() {
		if (variable == null) {
			variable = new EObjectContainmentEList<Variable>(Variable.class, this, QVTOperationalPackage.OPERATION_BODY__VARIABLE);
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.OPERATION_BODY__OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperation((ImperativeOperation)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.OPERATION_BODY__CONTENT:
				return ((InternalEList<?>)getContent()).basicRemove(otherEnd, msgs);
			case QVTOperationalPackage.OPERATION_BODY__OPERATION:
				return basicSetOperation(null, msgs);
			case QVTOperationalPackage.OPERATION_BODY__VARIABLE:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QVTOperationalPackage.OPERATION_BODY__OPERATION:
				return eInternalContainer().eInverseRemove(this, QVTOperationalPackage.IMPERATIVE_OPERATION__BODY, ImperativeOperation.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTOperationalPackage.OPERATION_BODY__CONTENT:
				return getContent();
			case QVTOperationalPackage.OPERATION_BODY__OPERATION:
				return getOperation();
			case QVTOperationalPackage.OPERATION_BODY__VARIABLE:
				return getVariable();
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
			case QVTOperationalPackage.OPERATION_BODY__CONTENT:
				getContent().clear();
				getContent().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case QVTOperationalPackage.OPERATION_BODY__OPERATION:
				setOperation((ImperativeOperation)newValue);
				return;
			case QVTOperationalPackage.OPERATION_BODY__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection<? extends Variable>)newValue);
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
			case QVTOperationalPackage.OPERATION_BODY__CONTENT:
				getContent().clear();
				return;
			case QVTOperationalPackage.OPERATION_BODY__OPERATION:
				setOperation((ImperativeOperation)null);
				return;
			case QVTOperationalPackage.OPERATION_BODY__VARIABLE:
				getVariable().clear();
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
			case QVTOperationalPackage.OPERATION_BODY__CONTENT:
				return content != null && !content.isEmpty();
			case QVTOperationalPackage.OPERATION_BODY__OPERATION:
				return getOperation() != null;
			case QVTOperationalPackage.OPERATION_BODY__VARIABLE:
				return variable != null && !variable.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OperationBodyImpl
