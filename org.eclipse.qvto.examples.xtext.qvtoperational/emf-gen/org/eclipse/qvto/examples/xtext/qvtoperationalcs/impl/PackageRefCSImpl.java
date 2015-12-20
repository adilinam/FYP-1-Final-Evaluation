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
import org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PackageRefCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathName2CS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Ref CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PackageRefCSImpl#getPackagePath <em>Package Path</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PackageRefCSImpl#getUri <em>Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PackageRefCSImpl extends ElementCSImpl implements PackageRefCS {
	/**
	 * The cached value of the '{@link #getPackagePath() <em>Package Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackagePath()
	 * @generated
	 * @ordered
	 */
	protected PathName2CS packagePath;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected StringLiteralExpCS uri;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageRefCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.PACKAGE_REF_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathName2CS getPackagePath() {
		return packagePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPackagePath(PathName2CS newPackagePath, NotificationChain msgs) {
		PathName2CS oldPackagePath = packagePath;
		packagePath = newPackagePath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.PACKAGE_REF_CS__PACKAGE_PATH, oldPackagePath, newPackagePath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackagePath(PathName2CS newPackagePath) {
		if (newPackagePath != packagePath) {
			NotificationChain msgs = null;
			if (packagePath != null)
				msgs = ((InternalEObject)packagePath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.PACKAGE_REF_CS__PACKAGE_PATH, null, msgs);
			if (newPackagePath != null)
				msgs = ((InternalEObject)newPackagePath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.PACKAGE_REF_CS__PACKAGE_PATH, null, msgs);
			msgs = basicSetPackagePath(newPackagePath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.PACKAGE_REF_CS__PACKAGE_PATH, newPackagePath, newPackagePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExpCS getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUri(StringLiteralExpCS newUri, NotificationChain msgs) {
		StringLiteralExpCS oldUri = uri;
		uri = newUri;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.PACKAGE_REF_CS__URI, oldUri, newUri);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(StringLiteralExpCS newUri) {
		if (newUri != uri) {
			NotificationChain msgs = null;
			if (uri != null)
				msgs = ((InternalEObject)uri).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.PACKAGE_REF_CS__URI, null, msgs);
			if (newUri != null)
				msgs = ((InternalEObject)newUri).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.PACKAGE_REF_CS__URI, null, msgs);
			msgs = basicSetUri(newUri, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.PACKAGE_REF_CS__URI, newUri, newUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalCSPackage.PACKAGE_REF_CS__PACKAGE_PATH:
				return basicSetPackagePath(null, msgs);
			case QVTOperationalCSPackage.PACKAGE_REF_CS__URI:
				return basicSetUri(null, msgs);
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
			case QVTOperationalCSPackage.PACKAGE_REF_CS__PACKAGE_PATH:
				return getPackagePath();
			case QVTOperationalCSPackage.PACKAGE_REF_CS__URI:
				return getUri();
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
			case QVTOperationalCSPackage.PACKAGE_REF_CS__PACKAGE_PATH:
				setPackagePath((PathName2CS)newValue);
				return;
			case QVTOperationalCSPackage.PACKAGE_REF_CS__URI:
				setUri((StringLiteralExpCS)newValue);
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
			case QVTOperationalCSPackage.PACKAGE_REF_CS__PACKAGE_PATH:
				setPackagePath((PathName2CS)null);
				return;
			case QVTOperationalCSPackage.PACKAGE_REF_CS__URI:
				setUri((StringLiteralExpCS)null);
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
			case QVTOperationalCSPackage.PACKAGE_REF_CS__PACKAGE_PATH:
				return packagePath != null;
			case QVTOperationalCSPackage.PACKAGE_REF_CS__URI:
				return uri != null;
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
		return (R) ((QVTOperationalCSVisitor<?>)visitor).visitPackageRefCS(this);
	}

} //PackageRefCSImpl
