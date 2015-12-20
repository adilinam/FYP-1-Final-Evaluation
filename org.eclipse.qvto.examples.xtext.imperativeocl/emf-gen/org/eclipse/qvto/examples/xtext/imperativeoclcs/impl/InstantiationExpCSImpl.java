/**
 */
package org.eclipse.qvto.examples.xtext.imperativeoclcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.xtext.basecs.TypeCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.InstantiationExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.util.ImperativeOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instantiation Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.InstantiationExpCSImpl#getTypeSpecCS <em>Type Spec CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.InstantiationExpCSImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstantiationExpCSImpl extends StatementCSImpl implements InstantiationExpCS {
	/**
	 * The cached value of the '{@link #getTypeSpecCS() <em>Type Spec CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeSpecCS()
	 * @generated
	 * @ordered
	 */
	protected TypeCS typeSpecCS;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpCS> arguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstantiationExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLCSPackage.Literals.INSTANTIATION_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeCS getTypeSpecCS() {
		return typeSpecCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeSpecCS(TypeCS newTypeSpecCS, NotificationChain msgs) {
		TypeCS oldTypeSpecCS = typeSpecCS;
		typeSpecCS = newTypeSpecCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__TYPE_SPEC_CS, oldTypeSpecCS, newTypeSpecCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeSpecCS(TypeCS newTypeSpecCS) {
		if (newTypeSpecCS != typeSpecCS) {
			NotificationChain msgs = null;
			if (typeSpecCS != null)
				msgs = ((InternalEObject)typeSpecCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__TYPE_SPEC_CS, null, msgs);
			if (newTypeSpecCS != null)
				msgs = ((InternalEObject)newTypeSpecCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__TYPE_SPEC_CS, null, msgs);
			msgs = basicSetTypeSpecCS(newTypeSpecCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__TYPE_SPEC_CS, newTypeSpecCS, newTypeSpecCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpCS> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentEList<ExpCS>(ExpCS.class, this, ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__TYPE_SPEC_CS:
				return basicSetTypeSpecCS(null, msgs);
			case ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
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
			case ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__TYPE_SPEC_CS:
				return getTypeSpecCS();
			case ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__ARGUMENTS:
				return getArguments();
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
			case ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__TYPE_SPEC_CS:
				setTypeSpecCS((TypeCS)newValue);
				return;
			case ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends ExpCS>)newValue);
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
			case ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__TYPE_SPEC_CS:
				setTypeSpecCS((TypeCS)null);
				return;
			case ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__ARGUMENTS:
				getArguments().clear();
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
			case ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__TYPE_SPEC_CS:
				return typeSpecCS != null;
			case ImperativeOCLCSPackage.INSTANTIATION_EXP_CS__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(BaseCSVisitor<R> visitor) {
		return (R) ((ImperativeOCLCSVisitor<?>)visitor).visitInstantiationExpCS(this);
	}

} //InstantiationExpCSImpl
