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
 * $Id: TryExp.java,v 1.2 2009/01/25 23:10:43 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Try Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.TryExp#getExceptClause <em>Except Clause</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.TryExp#getTryBody <em>Try Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage#getTryExp()
 * @model
 * @generated
 */
public interface TryExp extends ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Except Clause</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.CatchExp}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Except Clause</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Except Clause</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage#getTryExp_ExceptClause()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='exceptOwner'"
	 * @generated
	 */
	EList<CatchExp> getExceptClause();

	/**
	 * Returns the value of the '<em><b>Try Body</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.ecore.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Try Body</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Try Body</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage#getTryExp_TryBody()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='tryBodyOwner'"
	 * @generated
	 */
	EList<OCLExpression> getTryBody();

} // TryExp
