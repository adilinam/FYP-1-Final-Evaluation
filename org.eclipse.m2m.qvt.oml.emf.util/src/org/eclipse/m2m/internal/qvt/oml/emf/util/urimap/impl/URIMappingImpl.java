/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapPackage;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>URI Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.URIMappingImpl#getSourceURI <em>Source URI</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.URIMappingImpl#getTargetURI <em>Target URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class URIMappingImpl extends EObjectImpl implements URIMapping {
	/**
	 * The default value of the '{@link #getSourceURI() <em>Source URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceURI()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceURI() <em>Source URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceURI()
	 * @generated
	 * @ordered
	 */
	protected String sourceURI = SOURCE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetURI() <em>Target URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetURI()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetURI() <em>Target URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetURI()
	 * @generated
	 * @ordered
	 */
	protected String targetURI = TARGET_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected URIMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MModelURIMapPackage.Literals.URI_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceURI() {
		return sourceURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceURI(String newSourceURI) {
		String oldSourceURI = sourceURI;
		sourceURI = newSourceURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MModelURIMapPackage.URI_MAPPING__SOURCE_URI, oldSourceURI, sourceURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetURI() {
		return targetURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetURI(String newTargetURI) {
		String oldTargetURI = targetURI;
		targetURI = newTargetURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MModelURIMapPackage.URI_MAPPING__TARGET_URI, oldTargetURI, targetURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MModelURIMapPackage.URI_MAPPING__SOURCE_URI:
				return getSourceURI();
			case MModelURIMapPackage.URI_MAPPING__TARGET_URI:
				return getTargetURI();
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
			case MModelURIMapPackage.URI_MAPPING__SOURCE_URI:
				setSourceURI((String)newValue);
				return;
			case MModelURIMapPackage.URI_MAPPING__TARGET_URI:
				setTargetURI((String)newValue);
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
			case MModelURIMapPackage.URI_MAPPING__SOURCE_URI:
				setSourceURI(SOURCE_URI_EDEFAULT);
				return;
			case MModelURIMapPackage.URI_MAPPING__TARGET_URI:
				setTargetURI(TARGET_URI_EDEFAULT);
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
			case MModelURIMapPackage.URI_MAPPING__SOURCE_URI:
				return SOURCE_URI_EDEFAULT == null ? sourceURI != null : !SOURCE_URI_EDEFAULT.equals(sourceURI);
			case MModelURIMapPackage.URI_MAPPING__TARGET_URI:
				return TARGET_URI_EDEFAULT == null ? targetURI != null : !TARGET_URI_EDEFAULT.equals(targetURI);
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
		result.append(" (sourceURI: "); //$NON-NLS-1$
		result.append(sourceURI);
		result.append(", targetURI: "); //$NON-NLS-1$
		result.append(targetURI);
		result.append(')');
		return result.toString();
	}

} //URIMappingImpl
