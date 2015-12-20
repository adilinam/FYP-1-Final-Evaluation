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
package org.eclipse.qvto.examples.pivot.imperativeocl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catch Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp#getException <em>Exception</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getCatchExp()
 * @model
 * @generated
 */
public interface CatchExp extends ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getCatchExp_Body()
	 * @model containment="true"
	 * @generated
	 */
	EList<OCLExpression> getBody();

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' reference list.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getCatchExp_Exception()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='tryExpression'"
	 * @generated
	 */
	EList<Type> getException();

} // CatchExp
