/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.xtext.basecs.TypeCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveInExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolve In Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveInExpCSImpl#getInMappingType <em>In Mapping Type</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveInExpCSImpl#getInMappingName <em>In Mapping Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResolveInExpCSImpl extends ResolveExpCSImpl implements ResolveInExpCS {
	/**
	 * The cached value of the '{@link #getInMappingType() <em>In Mapping Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInMappingType()
	 * @generated
	 * @ordered
	 */
	protected TypeCS inMappingType;

	/**
	 * The default value of the '{@link #getInMappingName() <em>In Mapping Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInMappingName()
	 * @generated
	 * @ordered
	 */
	protected static final String IN_MAPPING_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInMappingName() <em>In Mapping Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInMappingName()
	 * @generated
	 * @ordered
	 */
	protected String inMappingName = IN_MAPPING_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResolveInExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.RESOLVE_IN_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeCS getInMappingType() {
		return inMappingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInMappingType(TypeCS newInMappingType, NotificationChain msgs) {
		TypeCS oldInMappingType = inMappingType;
		inMappingType = newInMappingType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE, oldInMappingType, newInMappingType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInMappingType(TypeCS newInMappingType) {
		if (newInMappingType != inMappingType) {
			NotificationChain msgs = null;
			if (inMappingType != null)
				msgs = ((InternalEObject)inMappingType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE, null, msgs);
			if (newInMappingType != null)
				msgs = ((InternalEObject)newInMappingType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE, null, msgs);
			msgs = basicSetInMappingType(newInMappingType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE, newInMappingType, newInMappingType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInMappingName() {
		return inMappingName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInMappingName(String newInMappingName) {
		String oldInMappingName = inMappingName;
		inMappingName = newInMappingName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_NAME, oldInMappingName, inMappingName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE:
				return basicSetInMappingType(null, msgs);
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
			case QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE:
				return getInMappingType();
			case QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_NAME:
				return getInMappingName();
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
			case QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE:
				setInMappingType((TypeCS)newValue);
				return;
			case QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_NAME:
				setInMappingName((String)newValue);
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
			case QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE:
				setInMappingType((TypeCS)null);
				return;
			case QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_NAME:
				setInMappingName(IN_MAPPING_NAME_EDEFAULT);
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
			case QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE:
				return inMappingType != null;
			case QVTOperationalCSPackage.RESOLVE_IN_EXP_CS__IN_MAPPING_NAME:
				return IN_MAPPING_NAME_EDEFAULT == null ? inMappingName != null : !IN_MAPPING_NAME_EDEFAULT.equals(inMappingName);
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
		return (R) ((QVTOperationalCSVisitor<?>)visitor).visitResolveInExpCS(this);
	}

} //ResolveInExpCSImpl
