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
 * $Id: AssignStatementCSImpl.java,v 1.4 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;

import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assign Statement CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.AssignStatementCSImpl#getLValueCS <em>LValue CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.AssignStatementCSImpl#getOclExpressionCS <em>Ocl Expression CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.AssignStatementCSImpl#isIncremental <em>Incremental</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignStatementCSImpl extends StatementCSImpl implements AssignStatementCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getLValueCS() <em>LValue CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLValueCS()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS lValueCS;

	/**
	 * The cached value of the '{@link #getOclExpressionCS() <em>Ocl Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS oclExpressionCS;

	/**
	 * The default value of the '{@link #isIncremental() <em>Incremental</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncremental()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCREMENTAL_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIncremental() <em>Incremental</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncremental()
	 * @generated
	 * @ordered
	 */
	protected static final int INCREMENTAL_EFLAG = 1 << 8;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignStatementCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.ASSIGN_STATEMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getLValueCS() {
		return lValueCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLValueCS(OCLExpressionCS newLValueCS, NotificationChain msgs) {
		OCLExpressionCS oldLValueCS = lValueCS;
		lValueCS = newLValueCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.ASSIGN_STATEMENT_CS__LVALUE_CS, oldLValueCS, newLValueCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLValueCS(OCLExpressionCS newLValueCS) {
		if (newLValueCS != lValueCS) {
			NotificationChain msgs = null;
			if (lValueCS != null)
				msgs = ((InternalEObject)lValueCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.ASSIGN_STATEMENT_CS__LVALUE_CS, null, msgs);
			if (newLValueCS != null)
				msgs = ((InternalEObject)newLValueCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.ASSIGN_STATEMENT_CS__LVALUE_CS, null, msgs);
			msgs = basicSetLValueCS(newLValueCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.ASSIGN_STATEMENT_CS__LVALUE_CS, newLValueCS, newLValueCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getOclExpressionCS() {
		return oclExpressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOclExpressionCS(OCLExpressionCS newOclExpressionCS, NotificationChain msgs) {
		OCLExpressionCS oldOclExpressionCS = oclExpressionCS;
		oclExpressionCS = newOclExpressionCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS, oldOclExpressionCS, newOclExpressionCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclExpressionCS(OCLExpressionCS newOclExpressionCS) {
		if (newOclExpressionCS != oclExpressionCS) {
			NotificationChain msgs = null;
			if (oclExpressionCS != null)
				msgs = ((InternalEObject)oclExpressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS, null, msgs);
			if (newOclExpressionCS != null)
				msgs = ((InternalEObject)newOclExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS, null, msgs);
			msgs = basicSetOclExpressionCS(newOclExpressionCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS, newOclExpressionCS, newOclExpressionCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIncremental() {
		return (eFlags & INCREMENTAL_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncremental(boolean newIncremental) {
		boolean oldIncremental = (eFlags & INCREMENTAL_EFLAG) != 0;
		if (newIncremental) eFlags |= INCREMENTAL_EFLAG; else eFlags &= ~INCREMENTAL_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.ASSIGN_STATEMENT_CS__INCREMENTAL, oldIncremental, newIncremental));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.ASSIGN_STATEMENT_CS__LVALUE_CS:
				return basicSetLValueCS(null, msgs);
			case CSTPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS:
				return basicSetOclExpressionCS(null, msgs);
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
			case CSTPackage.ASSIGN_STATEMENT_CS__LVALUE_CS:
				return getLValueCS();
			case CSTPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS:
				return getOclExpressionCS();
			case CSTPackage.ASSIGN_STATEMENT_CS__INCREMENTAL:
				return isIncremental();
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
			case CSTPackage.ASSIGN_STATEMENT_CS__LVALUE_CS:
				setLValueCS((OCLExpressionCS)newValue);
				return;
			case CSTPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS:
				setOclExpressionCS((OCLExpressionCS)newValue);
				return;
			case CSTPackage.ASSIGN_STATEMENT_CS__INCREMENTAL:
				setIncremental((Boolean)newValue);
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
			case CSTPackage.ASSIGN_STATEMENT_CS__LVALUE_CS:
				setLValueCS((OCLExpressionCS)null);
				return;
			case CSTPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS:
				setOclExpressionCS((OCLExpressionCS)null);
				return;
			case CSTPackage.ASSIGN_STATEMENT_CS__INCREMENTAL:
				setIncremental(INCREMENTAL_EDEFAULT);
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
			case CSTPackage.ASSIGN_STATEMENT_CS__LVALUE_CS:
				return lValueCS != null;
			case CSTPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS:
				return oclExpressionCS != null;
			case CSTPackage.ASSIGN_STATEMENT_CS__INCREMENTAL:
				return ((eFlags & INCREMENTAL_EFLAG) != 0) != INCREMENTAL_EDEFAULT;
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
		result.append(" (incremental: "); //$NON-NLS-1$
		result.append((eFlags & INCREMENTAL_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} //AssignStatementCSImpl
