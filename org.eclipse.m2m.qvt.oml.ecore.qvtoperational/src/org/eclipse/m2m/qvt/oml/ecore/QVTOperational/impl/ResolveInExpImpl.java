/**
 * <copyright>
 * Copyright (c) 2008 Open Canarias and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ResolveInExpImpl.java,v 1.2 2009/01/25 23:12:23 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.MappingOperation;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveInExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.util.QVTOperationalToStringVisitor;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.util.QVTOperationalVisitor;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolve In Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ResolveInExpImpl#getInMapping <em>In Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResolveInExpImpl extends ResolveExpImpl implements ResolveInExp {
	/**
	 * The cached value of the '{@link #getInMapping() <em>In Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInMapping()
	 * @generated
	 * @ordered
	 */
	protected MappingOperation inMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResolveInExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.RESOLVE_IN_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingOperation getInMapping() {
		if (inMapping != null && inMapping.eIsProxy()) {
			InternalEObject oldInMapping = (InternalEObject)inMapping;
			inMapping = (MappingOperation)eResolveProxy(oldInMapping);
			if (inMapping != oldInMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalPackage.RESOLVE_IN_EXP__IN_MAPPING, oldInMapping, inMapping));
			}
		}
		return inMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingOperation basicGetInMapping() {
		return inMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInMapping(MappingOperation newInMapping) {
		MappingOperation oldInMapping = inMapping;
		inMapping = newInMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.RESOLVE_IN_EXP__IN_MAPPING, oldInMapping, inMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTOperationalPackage.RESOLVE_IN_EXP__IN_MAPPING:
				if (resolve) return getInMapping();
				return basicGetInMapping();
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
			case QVTOperationalPackage.RESOLVE_IN_EXP__IN_MAPPING:
				setInMapping((MappingOperation)newValue);
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
			case QVTOperationalPackage.RESOLVE_IN_EXP__IN_MAPPING:
				setInMapping((MappingOperation)null);
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
			case QVTOperationalPackage.RESOLVE_IN_EXP__IN_MAPPING:
				return inMapping != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}
		return accept(QVTOperationalToStringVisitor.getInstance(this));		
	}
	
	/**
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T, U extends Visitor<T,?,?,?,?,?,?,?,?,?>> T accept(U v) {
		if (v instanceof QVTOperationalVisitor)
			return (T) ((QVTOperationalVisitor) v).visitResolveInExp(this);
		return super.accept(v);
	}

} //ResolveInExpImpl
