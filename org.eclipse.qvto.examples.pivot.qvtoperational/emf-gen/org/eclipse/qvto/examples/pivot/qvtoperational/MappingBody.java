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
package org.eclipse.qvto.examples.pivot.qvtoperational;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody#getEndSection <em>End Section</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody#getInitSection <em>Init Section</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getMappingBody()
 * @model
 * @generated
 */
public interface MappingBody extends OperationBody {
	/**
	 * Returns the value of the '<em><b>End Section</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Section</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Section</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getMappingBody_EndSection()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='endOwner'"
	 * @generated
	 */
	EList<OCLExpression> getEndSection();

	/**
	 * Returns the value of the '<em><b>Init Section</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Section</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Section</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getMappingBody_InitSection()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='initOwner'"
	 * @generated
	 */
	EList<OCLExpression> getInitSection();

} // MappingBody
