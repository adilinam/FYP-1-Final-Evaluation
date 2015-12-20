/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 * 
 * 
 *
 * $Id: PackageRefCSImpl.java,v 1.3 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS;

import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;

import org.eclipse.ocl.cst.impl.CSTNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Ref CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.PackageRefCSImpl#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.PackageRefCSImpl#getUriCS <em>Uri CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageRefCSImpl extends CSTNodeImpl implements PackageRefCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getPathNameCS() <em>Path Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathNameCS()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS pathNameCS;

	/**
	 * The cached value of the '{@link #getUriCS() <em>Uri CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriCS()
	 * @generated
	 * @ordered
	 */
	protected StringLiteralExpCS uriCS;

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
		return CSTPackage.Literals.PACKAGE_REF_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getPathNameCS() {
		return pathNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPathNameCS(PathNameCS newPathNameCS, NotificationChain msgs) {
		PathNameCS oldPathNameCS = pathNameCS;
		pathNameCS = newPathNameCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.PACKAGE_REF_CS__PATH_NAME_CS, oldPathNameCS, newPathNameCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathNameCS(PathNameCS newPathNameCS) {
		if (newPathNameCS != pathNameCS) {
			NotificationChain msgs = null;
			if (pathNameCS != null)
				msgs = ((InternalEObject)pathNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PACKAGE_REF_CS__PATH_NAME_CS, null, msgs);
			if (newPathNameCS != null)
				msgs = ((InternalEObject)newPathNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PACKAGE_REF_CS__PATH_NAME_CS, null, msgs);
			msgs = basicSetPathNameCS(newPathNameCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PACKAGE_REF_CS__PATH_NAME_CS, newPathNameCS, newPathNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExpCS getUriCS() {
		return uriCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUriCS(StringLiteralExpCS newUriCS, NotificationChain msgs) {
		StringLiteralExpCS oldUriCS = uriCS;
		uriCS = newUriCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.PACKAGE_REF_CS__URI_CS, oldUriCS, newUriCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUriCS(StringLiteralExpCS newUriCS) {
		if (newUriCS != uriCS) {
			NotificationChain msgs = null;
			if (uriCS != null)
				msgs = ((InternalEObject)uriCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PACKAGE_REF_CS__URI_CS, null, msgs);
			if (newUriCS != null)
				msgs = ((InternalEObject)newUriCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PACKAGE_REF_CS__URI_CS, null, msgs);
			msgs = basicSetUriCS(newUriCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PACKAGE_REF_CS__URI_CS, newUriCS, newUriCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.PACKAGE_REF_CS__PATH_NAME_CS:
				return basicSetPathNameCS(null, msgs);
			case CSTPackage.PACKAGE_REF_CS__URI_CS:
				return basicSetUriCS(null, msgs);
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
			case CSTPackage.PACKAGE_REF_CS__PATH_NAME_CS:
				return getPathNameCS();
			case CSTPackage.PACKAGE_REF_CS__URI_CS:
				return getUriCS();
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
			case CSTPackage.PACKAGE_REF_CS__PATH_NAME_CS:
				setPathNameCS((PathNameCS)newValue);
				return;
			case CSTPackage.PACKAGE_REF_CS__URI_CS:
				setUriCS((StringLiteralExpCS)newValue);
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
			case CSTPackage.PACKAGE_REF_CS__PATH_NAME_CS:
				setPathNameCS((PathNameCS)null);
				return;
			case CSTPackage.PACKAGE_REF_CS__URI_CS:
				setUriCS((StringLiteralExpCS)null);
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
			case CSTPackage.PACKAGE_REF_CS__PATH_NAME_CS:
				return pathNameCS != null;
			case CSTPackage.PACKAGE_REF_CS__URI_CS:
				return uriCS != null;
		}
		return super.eIsSet(featureID);
	}

} //PackageRefCSImpl
