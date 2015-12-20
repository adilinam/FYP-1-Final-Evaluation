/**
 * <copyright>
 * Copyright (c) 2008, 2009 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo  - initial API and implementation
 * </copyright>
 *
 * $Id: ImperativeExpressionImpl.java,v 1.2 2009/01/25 23:10:43 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeExpression;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.util.ImperativeOCLToStringVisitor;
import org.eclipse.ocl.ecore.impl.OCLExpressionImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imperative Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ImperativeExpressionImpl extends OCLExpressionImpl implements ImperativeExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImperativeExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLPackage.Literals.IMPERATIVE_EXPRESSION;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())	return super.toString();

		return accept(ImperativeOCLToStringVisitor.getInstance(this));
	}
} //ImperativeExpressionImpl
