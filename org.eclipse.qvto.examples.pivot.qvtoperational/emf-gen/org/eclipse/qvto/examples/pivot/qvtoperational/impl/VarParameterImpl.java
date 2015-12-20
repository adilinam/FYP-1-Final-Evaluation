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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.VariableImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.DirectionKind;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.VarParameterImpl#isIsTypeof <em>Is Typeof</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.VarParameterImpl#getOwningOperation <em>Owning Operation</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.VarParameterImpl#getCtxOwner <em>Ctx Owner</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.VarParameterImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.VarParameterImpl#getResOwner <em>Res Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VarParameterImpl extends VariableImpl implements VarParameter {
	/**
	 * The default value of the '{@link #isIsTypeof() <em>Is Typeof</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTypeof()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TYPEOF_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTypeof() <em>Is Typeof</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTypeof()
	 * @generated
	 * @ordered
	 */
	protected boolean isTypeof = IS_TYPEOF_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final DirectionKind KIND_EDEFAULT = DirectionKind.IN;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected DirectionKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VarParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.VAR_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsTypeof() {
		return isTypeof;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTypeof(boolean newIsTypeof) {
		boolean oldIsTypeof = isTypeof;
		isTypeof = newIsTypeof;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.VAR_PARAMETER__IS_TYPEOF, oldIsTypeof, isTypeof));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getOwningOperation() {
		if (eContainerFeatureID() != QVTOperationalPackage.VAR_PARAMETER__OWNING_OPERATION) return null;
		return (Operation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningOperation(Operation newOwningOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningOperation, QVTOperationalPackage.VAR_PARAMETER__OWNING_OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningOperation(Operation newOwningOperation) {
		if (newOwningOperation != eInternalContainer() || (eContainerFeatureID() != QVTOperationalPackage.VAR_PARAMETER__OWNING_OPERATION && newOwningOperation != null)) {
			if (EcoreUtil.isAncestor(this, newOwningOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningOperation != null)
				msgs = ((InternalEObject)newOwningOperation).eInverseAdd(this, PivotPackage.OPERATION__OWNED_PARAMETERS, Operation.class, msgs);
			msgs = basicSetOwningOperation(newOwningOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.VAR_PARAMETER__OWNING_OPERATION, newOwningOperation, newOwningOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOperation getCtxOwner() {
		if (eContainerFeatureID() != QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER) return null;
		return (ImperativeOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCtxOwner(ImperativeOperation newCtxOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCtxOwner, QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCtxOwner(ImperativeOperation newCtxOwner) {
		if (newCtxOwner != eInternalContainer() || (eContainerFeatureID() != QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER && newCtxOwner != null)) {
			if (EcoreUtil.isAncestor(this, newCtxOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCtxOwner != null)
				msgs = ((InternalEObject)newCtxOwner).eInverseAdd(this, QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT, ImperativeOperation.class, msgs);
			msgs = basicSetCtxOwner(newCtxOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER, newCtxOwner, newCtxOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(DirectionKind newKind) {
		DirectionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.VAR_PARAMETER__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOperation getResOwner() {
		if (eContainerFeatureID() != QVTOperationalPackage.VAR_PARAMETER__RES_OWNER) return null;
		return (ImperativeOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResOwner(ImperativeOperation newResOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newResOwner, QVTOperationalPackage.VAR_PARAMETER__RES_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResOwner(ImperativeOperation newResOwner) {
		if (newResOwner != eInternalContainer() || (eContainerFeatureID() != QVTOperationalPackage.VAR_PARAMETER__RES_OWNER && newResOwner != null)) {
			if (EcoreUtil.isAncestor(this, newResOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newResOwner != null)
				msgs = ((InternalEObject)newResOwner).eInverseAdd(this, QVTOperationalPackage.IMPERATIVE_OPERATION__RESULT, ImperativeOperation.class, msgs);
			msgs = basicSetResOwner(newResOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.VAR_PARAMETER__RES_OWNER, newResOwner, newResOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.VAR_PARAMETER__OWNING_OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningOperation((Operation)otherEnd, msgs);
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCtxOwner((ImperativeOperation)otherEnd, msgs);
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetResOwner((ImperativeOperation)otherEnd, msgs);
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
			case QVTOperationalPackage.VAR_PARAMETER__OWNING_OPERATION:
				return basicSetOwningOperation(null, msgs);
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				return basicSetCtxOwner(null, msgs);
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				return basicSetResOwner(null, msgs);
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
			case QVTOperationalPackage.VAR_PARAMETER__OWNING_OPERATION:
				return eInternalContainer().eInverseRemove(this, PivotPackage.OPERATION__OWNED_PARAMETERS, Operation.class, msgs);
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				return eInternalContainer().eInverseRemove(this, QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT, ImperativeOperation.class, msgs);
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				return eInternalContainer().eInverseRemove(this, QVTOperationalPackage.IMPERATIVE_OPERATION__RESULT, ImperativeOperation.class, msgs);
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
			case QVTOperationalPackage.VAR_PARAMETER__IS_TYPEOF:
				return isIsTypeof();
			case QVTOperationalPackage.VAR_PARAMETER__OWNING_OPERATION:
				return getOwningOperation();
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				return getCtxOwner();
			case QVTOperationalPackage.VAR_PARAMETER__KIND:
				return getKind();
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				return getResOwner();
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
			case QVTOperationalPackage.VAR_PARAMETER__IS_TYPEOF:
				setIsTypeof((Boolean)newValue);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__OWNING_OPERATION:
				setOwningOperation((Operation)newValue);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				setCtxOwner((ImperativeOperation)newValue);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__KIND:
				setKind((DirectionKind)newValue);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				setResOwner((ImperativeOperation)newValue);
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
			case QVTOperationalPackage.VAR_PARAMETER__IS_TYPEOF:
				setIsTypeof(IS_TYPEOF_EDEFAULT);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__OWNING_OPERATION:
				setOwningOperation((Operation)null);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				setCtxOwner((ImperativeOperation)null);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				setResOwner((ImperativeOperation)null);
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
			case QVTOperationalPackage.VAR_PARAMETER__IS_TYPEOF:
				return isTypeof != IS_TYPEOF_EDEFAULT;
			case QVTOperationalPackage.VAR_PARAMETER__OWNING_OPERATION:
				return getOwningOperation() != null;
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				return getCtxOwner() != null;
			case QVTOperationalPackage.VAR_PARAMETER__KIND:
				return kind != KIND_EDEFAULT;
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				return getResOwner() != null;
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
		if (baseClass == Parameter.class) {
			switch (derivedFeatureID) {
				case QVTOperationalPackage.VAR_PARAMETER__IS_TYPEOF: return PivotPackage.PARAMETER__IS_TYPEOF;
				case QVTOperationalPackage.VAR_PARAMETER__OWNING_OPERATION: return PivotPackage.PARAMETER__OWNING_OPERATION;
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
		if (baseClass == Parameter.class) {
			switch (baseFeatureID) {
				case PivotPackage.PARAMETER__IS_TYPEOF: return QVTOperationalPackage.VAR_PARAMETER__IS_TYPEOF;
				case PivotPackage.PARAMETER__OWNING_OPERATION: return QVTOperationalPackage.VAR_PARAMETER__OWNING_OPERATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		return (R) ((QVTOperationalVisitor<?>)visitor).visitVarParameter(this);
	}

} //VarParameterImpl
