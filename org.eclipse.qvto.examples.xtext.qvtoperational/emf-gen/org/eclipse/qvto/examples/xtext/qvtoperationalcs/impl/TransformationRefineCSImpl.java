/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.xtext.basecs.impl.ElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleRefCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationRefineCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation Refine CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TransformationRefineCSImpl#getModuleRefCS <em>Module Ref CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TransformationRefineCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationRefineCSImpl extends ElementCSImpl implements TransformationRefineCS {
	/**
	 * The cached value of the '{@link #getModuleRefCS() <em>Module Ref CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleRefCS()
	 * @generated
	 * @ordered
	 */
	protected ModuleRefCS moduleRefCS;

	/**
	 * The default value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_NAME_CS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected String simpleNameCS = SIMPLE_NAME_CS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationRefineCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.TRANSFORMATION_REFINE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleRefCS getModuleRefCS() {
		return moduleRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModuleRefCS(ModuleRefCS newModuleRefCS, NotificationChain msgs) {
		ModuleRefCS oldModuleRefCS = moduleRefCS;
		moduleRefCS = newModuleRefCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS, oldModuleRefCS, newModuleRefCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModuleRefCS(ModuleRefCS newModuleRefCS) {
		if (newModuleRefCS != moduleRefCS) {
			NotificationChain msgs = null;
			if (moduleRefCS != null)
				msgs = ((InternalEObject)moduleRefCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS, null, msgs);
			if (newModuleRefCS != null)
				msgs = ((InternalEObject)newModuleRefCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS, null, msgs);
			msgs = basicSetModuleRefCS(newModuleRefCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS, newModuleRefCS, newModuleRefCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleNameCS() {
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleNameCS(String newSimpleNameCS) {
		String oldSimpleNameCS = simpleNameCS;
		simpleNameCS = newSimpleNameCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
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
			case QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS:
				return basicSetModuleRefCS(null, msgs);
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
			case QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS:
				return getModuleRefCS();
			case QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS:
				return getSimpleNameCS();
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
			case QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS:
				setModuleRefCS((ModuleRefCS)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((String)newValue);
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
			case QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS:
				setModuleRefCS((ModuleRefCS)null);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS:
				setSimpleNameCS(SIMPLE_NAME_CS_EDEFAULT);
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
			case QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__MODULE_REF_CS:
				return moduleRefCS != null;
			case QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS:
				return SIMPLE_NAME_CS_EDEFAULT == null ? simpleNameCS != null : !SIMPLE_NAME_CS_EDEFAULT.equals(simpleNameCS);
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
		return (R) ((QVTOperationalCSVisitor<?>)visitor).visitTransformationRefineCS(this);
	}

} //TransformationRefineCSImpl
