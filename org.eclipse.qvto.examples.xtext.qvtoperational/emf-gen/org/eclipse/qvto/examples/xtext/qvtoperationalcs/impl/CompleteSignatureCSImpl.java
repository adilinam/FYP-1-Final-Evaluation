/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.xtext.basecs.impl.ElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.CompleteSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.SimpleSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Signature CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.CompleteSignatureCSImpl#getSimpleSignature <em>Simple Signature</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.CompleteSignatureCSImpl#getResultParams <em>Result Params</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompleteSignatureCSImpl extends ElementCSImpl implements CompleteSignatureCS {
	/**
	 * The cached value of the '{@link #getSimpleSignature() <em>Simple Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleSignature()
	 * @generated
	 * @ordered
	 */
	protected SimpleSignatureCS simpleSignature;

	/**
	 * The cached value of the '{@link #getResultParams() <em>Result Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultParams()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterDeclarationCS> resultParams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteSignatureCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.COMPLETE_SIGNATURE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleSignatureCS getSimpleSignature() {
		return simpleSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleSignature(SimpleSignatureCS newSimpleSignature, NotificationChain msgs) {
		SimpleSignatureCS oldSimpleSignature = simpleSignature;
		simpleSignature = newSimpleSignature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE, oldSimpleSignature, newSimpleSignature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleSignature(SimpleSignatureCS newSimpleSignature) {
		if (newSimpleSignature != simpleSignature) {
			NotificationChain msgs = null;
			if (simpleSignature != null)
				msgs = ((InternalEObject)simpleSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE, null, msgs);
			if (newSimpleSignature != null)
				msgs = ((InternalEObject)newSimpleSignature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE, null, msgs);
			msgs = basicSetSimpleSignature(newSimpleSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE, newSimpleSignature, newSimpleSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDeclarationCS> getResultParams() {
		if (resultParams == null) {
			resultParams = new EObjectContainmentEList<ParameterDeclarationCS>(ParameterDeclarationCS.class, this, QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__RESULT_PARAMS);
		}
		return resultParams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE:
				return basicSetSimpleSignature(null, msgs);
			case QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__RESULT_PARAMS:
				return ((InternalEList<?>)getResultParams()).basicRemove(otherEnd, msgs);
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
			case QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE:
				return getSimpleSignature();
			case QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__RESULT_PARAMS:
				return getResultParams();
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
			case QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE:
				setSimpleSignature((SimpleSignatureCS)newValue);
				return;
			case QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__RESULT_PARAMS:
				getResultParams().clear();
				getResultParams().addAll((Collection<? extends ParameterDeclarationCS>)newValue);
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
			case QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE:
				setSimpleSignature((SimpleSignatureCS)null);
				return;
			case QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__RESULT_PARAMS:
				getResultParams().clear();
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
			case QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE:
				return simpleSignature != null;
			case QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS__RESULT_PARAMS:
				return resultParams != null && !resultParams.isEmpty();
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
		return (R) ((QVTOperationalCSVisitor<?>)visitor).visitCompleteSignatureCS(this);
	}

} //CompleteSignatureCSImpl
