/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelTypeImpl.java,v 1.2 2009/02/20 12:55:55 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl;

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
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModelType;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage;
import org.eclipse.qvt.declarative.emof.EMOF.impl.ClassImpl;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModelTypeImpl#getAdditionalCondition <em>Additional Condition</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModelTypeImpl#getConformanceKind <em>Conformance Kind</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModelTypeImpl#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelTypeImpl extends ClassImpl implements ModelType {
	/**
	 * The cached value of the '{@link #getAdditionalCondition() <em>Additional Condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalCondition()
	 * @generated
	 * @ordered
	 */
	protected EList<OclExpression> additionalCondition;

	/**
	 * The default value of the '{@link #getConformanceKind() <em>Conformance Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConformanceKind()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFORMANCE_KIND_EDEFAULT = "effective";

	/**
	 * The cached value of the '{@link #getConformanceKind() <em>Conformance Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConformanceKind()
	 * @generated
	 * @ordered
	 */
	protected String conformanceKind = CONFORMANCE_KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.qvt.declarative.emof.EMOF.Package> metamodel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.MODEL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OclExpression> getAdditionalCondition() {
		if (additionalCondition == null) {
			additionalCondition = new EObjectContainmentEList<OclExpression>(OclExpression.class, this, QVTOperationalPackage.MODEL_TYPE__ADDITIONAL_CONDITION);
		}
		return additionalCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConformanceKind() {
		return conformanceKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConformanceKind(String newConformanceKind) {
		String oldConformanceKind = conformanceKind;
		conformanceKind = newConformanceKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODEL_TYPE__CONFORMANCE_KIND, oldConformanceKind, conformanceKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.qvt.declarative.emof.EMOF.Package> getMetamodel() {
		if (metamodel == null) {
			metamodel = new EObjectResolvingEList<org.eclipse.qvt.declarative.emof.EMOF.Package>(org.eclipse.qvt.declarative.emof.EMOF.Package.class, this, QVTOperationalPackage.MODEL_TYPE__METAMODEL);
		}
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.MODEL_TYPE__ADDITIONAL_CONDITION:
				return ((InternalEList<?>)getAdditionalCondition()).basicRemove(otherEnd, msgs);
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
			case QVTOperationalPackage.MODEL_TYPE__ADDITIONAL_CONDITION:
				return getAdditionalCondition();
			case QVTOperationalPackage.MODEL_TYPE__CONFORMANCE_KIND:
				return getConformanceKind();
			case QVTOperationalPackage.MODEL_TYPE__METAMODEL:
				return getMetamodel();
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
			case QVTOperationalPackage.MODEL_TYPE__ADDITIONAL_CONDITION:
				getAdditionalCondition().clear();
				getAdditionalCondition().addAll((Collection<? extends OclExpression>)newValue);
				return;
			case QVTOperationalPackage.MODEL_TYPE__CONFORMANCE_KIND:
				setConformanceKind((String)newValue);
				return;
			case QVTOperationalPackage.MODEL_TYPE__METAMODEL:
				getMetamodel().clear();
				getMetamodel().addAll((Collection<? extends org.eclipse.qvt.declarative.emof.EMOF.Package>)newValue);
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
			case QVTOperationalPackage.MODEL_TYPE__ADDITIONAL_CONDITION:
				getAdditionalCondition().clear();
				return;
			case QVTOperationalPackage.MODEL_TYPE__CONFORMANCE_KIND:
				setConformanceKind(CONFORMANCE_KIND_EDEFAULT);
				return;
			case QVTOperationalPackage.MODEL_TYPE__METAMODEL:
				getMetamodel().clear();
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
			case QVTOperationalPackage.MODEL_TYPE__ADDITIONAL_CONDITION:
				return additionalCondition != null && !additionalCondition.isEmpty();
			case QVTOperationalPackage.MODEL_TYPE__CONFORMANCE_KIND:
				return CONFORMANCE_KIND_EDEFAULT == null ? conformanceKind != null : !CONFORMANCE_KIND_EDEFAULT.equals(conformanceKind);
			case QVTOperationalPackage.MODEL_TYPE__METAMODEL:
				return metamodel != null && !metamodel.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (conformanceKind: ");
		result.append(conformanceKind);
		result.append(')');
		return result.toString();
	}

} //ModelTypeImpl
