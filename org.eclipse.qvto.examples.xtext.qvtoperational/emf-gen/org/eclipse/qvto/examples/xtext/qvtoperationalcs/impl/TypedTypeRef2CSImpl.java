/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;

import org.eclipse.ocl.xtext.basecs.impl.TypedRefCSImpl;

import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathName2CS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypedTypeRef2CS;

import org.eclipse.qvto.examples.xtext.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Type Ref2 CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TypedTypeRef2CSImpl#getOwnedPathName <em>Owned Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TypedTypeRef2CSImpl#getOwnedBinding <em>Owned Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypedTypeRef2CSImpl extends TypedRefCSImpl implements TypedTypeRef2CS {
	/**
	 * The cached value of the '{@link #getOwnedPathName() <em>Owned Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPathName()
	 * @generated
	 * @ordered
	 */
	protected PathName2CS ownedPathName;

	/**
	 * The cached value of the '{@link #getOwnedBinding() <em>Owned Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBinding()
	 * @generated
	 * @ordered
	 */
	protected TemplateBindingCS ownedBinding;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedTypeRef2CSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.TYPED_TYPE_REF2_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathName2CS getOwnedPathName() {
		return ownedPathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedPathName(PathName2CS newOwnedPathName, NotificationChain msgs) {
		PathName2CS oldOwnedPathName = ownedPathName;
		ownedPathName = newOwnedPathName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_PATH_NAME, oldOwnedPathName, newOwnedPathName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedPathName(PathName2CS newOwnedPathName) {
		if (newOwnedPathName != ownedPathName) {
			NotificationChain msgs = null;
			if (ownedPathName != null)
				msgs = ((InternalEObject)ownedPathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_PATH_NAME, null, msgs);
			if (newOwnedPathName != null)
				msgs = ((InternalEObject)newOwnedPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_PATH_NAME, null, msgs);
			msgs = basicSetOwnedPathName(newOwnedPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_PATH_NAME, newOwnedPathName, newOwnedPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBindingCS getOwnedBinding() {
		return ownedBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedBinding(TemplateBindingCS newOwnedBinding, NotificationChain msgs) {
		TemplateBindingCS oldOwnedBinding = ownedBinding;
		ownedBinding = newOwnedBinding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_BINDING, oldOwnedBinding, newOwnedBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedBinding(TemplateBindingCS newOwnedBinding) {
		if (newOwnedBinding != ownedBinding) {
			NotificationChain msgs = null;
			if (ownedBinding != null)
				msgs = ((InternalEObject)ownedBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_BINDING, null, msgs);
			if (newOwnedBinding != null)
				msgs = ((InternalEObject)newOwnedBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_BINDING, null, msgs);
			msgs = basicSetOwnedBinding(newOwnedBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_BINDING, newOwnedBinding, newOwnedBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_PATH_NAME:
				return basicSetOwnedPathName(null, msgs);
			case QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_BINDING:
				return basicSetOwnedBinding(null, msgs);
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
			case QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_PATH_NAME:
				return getOwnedPathName();
			case QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_BINDING:
				return getOwnedBinding();
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
			case QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_PATH_NAME:
				setOwnedPathName((PathName2CS)newValue);
				return;
			case QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_BINDING:
				setOwnedBinding((TemplateBindingCS)newValue);
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
			case QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_PATH_NAME:
				setOwnedPathName((PathName2CS)null);
				return;
			case QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_BINDING:
				setOwnedBinding((TemplateBindingCS)null);
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
			case QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_PATH_NAME:
				return ownedPathName != null;
			case QVTOperationalCSPackage.TYPED_TYPE_REF2_CS__OWNED_BINDING:
				return ownedBinding != null;
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
		return (R) ((QVTOperationalCSVisitor<?>)visitor).visitTypedTypeRef2CS(this);
	}

} //TypedTypeRef2CSImpl
