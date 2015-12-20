/**
 * <copyright>
 * Copyright (c) 2013 Willink Transformations, University of York, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo (University of York) - Bug397429
 * </copyright>
 */
package org.eclipse.qvto.examples.pivot.imperativeocl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage;
import org.eclipse.qvto.examples.pivot.imperativeocl.TryExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Try Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.TryExpImpl#getExceptClause <em>Except Clause</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.TryExpImpl#getTryBody <em>Try Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TryExpImpl extends ImperativeExpressionImpl implements TryExp {
	/**
	 * The cached value of the '{@link #getExceptClause() <em>Except Clause</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptClause()
	 * @generated
	 * @ordered
	 */
	protected EList<CatchExp> exceptClause;

	/**
	 * The cached value of the '{@link #getTryBody() <em>Try Body</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTryBody()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression> tryBody;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TryExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLPackage.Literals.TRY_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CatchExp> getExceptClause() {
		if (exceptClause == null) {
			exceptClause = new EObjectContainmentEList<CatchExp>(CatchExp.class, this, ImperativeOCLPackage.TRY_EXP__EXCEPT_CLAUSE);
		}
		return exceptClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpression> getTryBody() {
		if (tryBody == null) {
			tryBody = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, ImperativeOCLPackage.TRY_EXP__TRY_BODY);
		}
		return tryBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeOCLPackage.TRY_EXP__EXCEPT_CLAUSE:
				return ((InternalEList<?>)getExceptClause()).basicRemove(otherEnd, msgs);
			case ImperativeOCLPackage.TRY_EXP__TRY_BODY:
				return ((InternalEList<?>)getTryBody()).basicRemove(otherEnd, msgs);
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
			case ImperativeOCLPackage.TRY_EXP__EXCEPT_CLAUSE:
				return getExceptClause();
			case ImperativeOCLPackage.TRY_EXP__TRY_BODY:
				return getTryBody();
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
			case ImperativeOCLPackage.TRY_EXP__EXCEPT_CLAUSE:
				getExceptClause().clear();
				getExceptClause().addAll((Collection<? extends CatchExp>)newValue);
				return;
			case ImperativeOCLPackage.TRY_EXP__TRY_BODY:
				getTryBody().clear();
				getTryBody().addAll((Collection<? extends OCLExpression>)newValue);
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
			case ImperativeOCLPackage.TRY_EXP__EXCEPT_CLAUSE:
				getExceptClause().clear();
				return;
			case ImperativeOCLPackage.TRY_EXP__TRY_BODY:
				getTryBody().clear();
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
			case ImperativeOCLPackage.TRY_EXP__EXCEPT_CLAUSE:
				return exceptClause != null && !exceptClause.isEmpty();
			case ImperativeOCLPackage.TRY_EXP__TRY_BODY:
				return tryBody != null && !tryBody.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(Visitor<R> visitor) {
		return (R) ((ImperativeOCLVisitor<?>)visitor).visitTryExp(this);
	}

} //TryExpImpl
