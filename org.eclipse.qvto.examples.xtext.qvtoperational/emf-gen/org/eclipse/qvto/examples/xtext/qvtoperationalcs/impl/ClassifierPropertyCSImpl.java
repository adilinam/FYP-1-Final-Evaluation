/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.impl.StructuralFeatureCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Property CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierPropertyCSImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierPropertyCSImpl#getOpposite <em>Opposite</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassifierPropertyCSImpl extends StructuralFeatureCSImpl implements ClassifierPropertyCS {
	/**
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected ElementCS stereotypes;

	/**
	 * The default value of the '{@link #getOpposite() <em>Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected static final String OPPOSITE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected String opposite = OPPOSITE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierPropertyCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.CLASSIFIER_PROPERTY_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementCS getStereotypes() {
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStereotypes(ElementCS newStereotypes, NotificationChain msgs) {
		ElementCS oldStereotypes = stereotypes;
		stereotypes = newStereotypes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPES, oldStereotypes, newStereotypes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypes(ElementCS newStereotypes) {
		if (newStereotypes != stereotypes) {
			NotificationChain msgs = null;
			if (stereotypes != null)
				msgs = ((InternalEObject)stereotypes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPES, null, msgs);
			if (newStereotypes != null)
				msgs = ((InternalEObject)newStereotypes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPES, null, msgs);
			msgs = basicSetStereotypes(newStereotypes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPES, newStereotypes, newStereotypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpposite(String newOpposite) {
		String oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE, oldOpposite, opposite));
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
			case QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPES:
				return basicSetStereotypes(null, msgs);
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
			case QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPES:
				return getStereotypes();
			case QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE:
				return getOpposite();
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
			case QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPES:
				setStereotypes((ElementCS)newValue);
				return;
			case QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE:
				setOpposite((String)newValue);
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
			case QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPES:
				setStereotypes((ElementCS)null);
				return;
			case QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE:
				setOpposite(OPPOSITE_EDEFAULT);
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
			case QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPES:
				return stereotypes != null;
			case QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE:
				return OPPOSITE_EDEFAULT == null ? opposite != null : !OPPOSITE_EDEFAULT.equals(opposite);
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
		return (R) ((QVTOperationalCSVisitor<?>)visitor).visitClassifierPropertyCS(this);
	}

} //ClassifierPropertyCSImpl
