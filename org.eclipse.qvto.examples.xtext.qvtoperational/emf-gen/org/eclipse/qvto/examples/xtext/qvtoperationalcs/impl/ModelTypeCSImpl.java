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
import org.eclipse.ocl.xtext.basecs.impl.ClassCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.BlockExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ElementWithBody;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PackageRefCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Type CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModelTypeCSImpl#getBodyStartLocation <em>Body Start Location</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModelTypeCSImpl#getBodyEndLocation <em>Body End Location</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModelTypeCSImpl#getComplianceKind <em>Compliance Kind</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModelTypeCSImpl#getPackageRefs <em>Package Refs</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModelTypeCSImpl#getWhere <em>Where</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelTypeCSImpl extends ClassCSImpl implements ModelTypeCS {
	/**
	 * The default value of the '{@link #getBodyStartLocation() <em>Body Start Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyStartLocation()
	 * @generated
	 * @ordered
	 */
	protected static final int BODY_START_LOCATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBodyStartLocation() <em>Body Start Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyStartLocation()
	 * @generated
	 * @ordered
	 */
	protected int bodyStartLocation = BODY_START_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getBodyEndLocation() <em>Body End Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyEndLocation()
	 * @generated
	 * @ordered
	 */
	protected static final int BODY_END_LOCATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBodyEndLocation() <em>Body End Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyEndLocation()
	 * @generated
	 * @ordered
	 */
	protected int bodyEndLocation = BODY_END_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getComplianceKind() <em>Compliance Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplianceKind()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPLIANCE_KIND_EDEFAULT = "strict";

	/**
	 * The cached value of the '{@link #getComplianceKind() <em>Compliance Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplianceKind()
	 * @generated
	 * @ordered
	 */
	protected String complianceKind = COMPLIANCE_KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPackageRefs() <em>Package Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageRefCS> packageRefs;

	/**
	 * The cached value of the '{@link #getWhere() <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhere()
	 * @generated
	 * @ordered
	 */
	protected BlockExpCS where;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelTypeCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.MODEL_TYPE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBodyStartLocation() {
		return bodyStartLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyStartLocation(int newBodyStartLocation) {
		int oldBodyStartLocation = bodyStartLocation;
		bodyStartLocation = newBodyStartLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_START_LOCATION, oldBodyStartLocation, bodyStartLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBodyEndLocation() {
		return bodyEndLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyEndLocation(int newBodyEndLocation) {
		int oldBodyEndLocation = bodyEndLocation;
		bodyEndLocation = newBodyEndLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_END_LOCATION, oldBodyEndLocation, bodyEndLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComplianceKind() {
		return complianceKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComplianceKind(String newComplianceKind) {
		String oldComplianceKind = complianceKind;
		complianceKind = newComplianceKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MODEL_TYPE_CS__COMPLIANCE_KIND, oldComplianceKind, complianceKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageRefCS> getPackageRefs() {
		if (packageRefs == null) {
			packageRefs = new EObjectContainmentEList<PackageRefCS>(PackageRefCS.class, this, QVTOperationalCSPackage.MODEL_TYPE_CS__PACKAGE_REFS);
		}
		return packageRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockExpCS getWhere() {
		return where;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhere(BlockExpCS newWhere, NotificationChain msgs) {
		BlockExpCS oldWhere = where;
		where = newWhere;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MODEL_TYPE_CS__WHERE, oldWhere, newWhere);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhere(BlockExpCS newWhere) {
		if (newWhere != where) {
			NotificationChain msgs = null;
			if (where != null)
				msgs = ((InternalEObject)where).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MODEL_TYPE_CS__WHERE, null, msgs);
			if (newWhere != null)
				msgs = ((InternalEObject)newWhere).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MODEL_TYPE_CS__WHERE, null, msgs);
			msgs = basicSetWhere(newWhere, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MODEL_TYPE_CS__WHERE, newWhere, newWhere));
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
			case QVTOperationalCSPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				return ((InternalEList<?>)getPackageRefs()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.MODEL_TYPE_CS__WHERE:
				return basicSetWhere(null, msgs);
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
			case QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_START_LOCATION:
				return getBodyStartLocation();
			case QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_END_LOCATION:
				return getBodyEndLocation();
			case QVTOperationalCSPackage.MODEL_TYPE_CS__COMPLIANCE_KIND:
				return getComplianceKind();
			case QVTOperationalCSPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				return getPackageRefs();
			case QVTOperationalCSPackage.MODEL_TYPE_CS__WHERE:
				return getWhere();
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
			case QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_START_LOCATION:
				setBodyStartLocation((Integer)newValue);
				return;
			case QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_END_LOCATION:
				setBodyEndLocation((Integer)newValue);
				return;
			case QVTOperationalCSPackage.MODEL_TYPE_CS__COMPLIANCE_KIND:
				setComplianceKind((String)newValue);
				return;
			case QVTOperationalCSPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				getPackageRefs().clear();
				getPackageRefs().addAll((Collection<? extends PackageRefCS>)newValue);
				return;
			case QVTOperationalCSPackage.MODEL_TYPE_CS__WHERE:
				setWhere((BlockExpCS)newValue);
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
			case QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_START_LOCATION:
				setBodyStartLocation(BODY_START_LOCATION_EDEFAULT);
				return;
			case QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_END_LOCATION:
				setBodyEndLocation(BODY_END_LOCATION_EDEFAULT);
				return;
			case QVTOperationalCSPackage.MODEL_TYPE_CS__COMPLIANCE_KIND:
				setComplianceKind(COMPLIANCE_KIND_EDEFAULT);
				return;
			case QVTOperationalCSPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				getPackageRefs().clear();
				return;
			case QVTOperationalCSPackage.MODEL_TYPE_CS__WHERE:
				setWhere((BlockExpCS)null);
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
			case QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_START_LOCATION:
				return bodyStartLocation != BODY_START_LOCATION_EDEFAULT;
			case QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_END_LOCATION:
				return bodyEndLocation != BODY_END_LOCATION_EDEFAULT;
			case QVTOperationalCSPackage.MODEL_TYPE_CS__COMPLIANCE_KIND:
				return COMPLIANCE_KIND_EDEFAULT == null ? complianceKind != null : !COMPLIANCE_KIND_EDEFAULT.equals(complianceKind);
			case QVTOperationalCSPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				return packageRefs != null && !packageRefs.isEmpty();
			case QVTOperationalCSPackage.MODEL_TYPE_CS__WHERE:
				return where != null;
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
		if (baseClass == ElementWithBody.class) {
			switch (derivedFeatureID) {
				case QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_START_LOCATION: return QVTOperationalCSPackage.ELEMENT_WITH_BODY__BODY_START_LOCATION;
				case QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_END_LOCATION: return QVTOperationalCSPackage.ELEMENT_WITH_BODY__BODY_END_LOCATION;
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
		if (baseClass == ElementWithBody.class) {
			switch (baseFeatureID) {
				case QVTOperationalCSPackage.ELEMENT_WITH_BODY__BODY_START_LOCATION: return QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_START_LOCATION;
				case QVTOperationalCSPackage.ELEMENT_WITH_BODY__BODY_END_LOCATION: return QVTOperationalCSPackage.MODEL_TYPE_CS__BODY_END_LOCATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(BaseCSVisitor<R> visitor) {
		return (R) ((QVTOperationalCSVisitor<?>)visitor).visitModelTypeCS(this);
	}

} //ModelTypeCSImpl
