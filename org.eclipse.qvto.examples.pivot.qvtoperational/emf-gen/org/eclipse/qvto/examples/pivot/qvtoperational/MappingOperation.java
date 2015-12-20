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
 * A representation of the model object '<em><b>Mapping Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation#getDisjunct <em>Disjunct</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation#getInherited <em>Inherited</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation#getMerged <em>Merged</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation#getRefinedRelation <em>Refined Relation</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation#getWhen <em>When</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation#getWhere <em>Where</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getMappingOperation()
 * @model
 * @generated
 */
public interface MappingOperation extends ImperativeOperation {
	/**
	 * Returns the value of the '<em><b>Disjunct</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disjunct</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disjunct</em>' reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getMappingOperation_Disjunct()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='disjuncter'"
	 * @generated
	 */
	EList<MappingOperation> getDisjunct();

	/**
	 * Returns the value of the '<em><b>Inherited</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited</em>' reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getMappingOperation_Inherited()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='inheriting'"
	 * @generated
	 */
	EList<MappingOperation> getInherited();

	/**
	 * Returns the value of the '<em><b>Merged</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merged</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merged</em>' reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getMappingOperation_Merged()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='merging'"
	 * @generated
	 */
	EList<MappingOperation> getMerged();

	/**
	 * Returns the value of the '<em><b>Refined Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined Relation</em>' reference.
	 * @see #setRefinedRelation(DummyRelation)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getMappingOperation_RefinedRelation()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='refiningOperation'"
	 * @generated
	 */
	DummyRelation getRefinedRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation#getRefinedRelation <em>Refined Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refined Relation</em>' reference.
	 * @see #getRefinedRelation()
	 * @generated
	 */
	void setRefinedRelation(DummyRelation value);

	/**
	 * Returns the value of the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' containment reference.
	 * @see #setWhen(OCLExpression)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getMappingOperation_When()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='whenOwner'"
	 * @generated
	 */
	OCLExpression getWhen();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation#getWhen <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When</em>' containment reference.
	 * @see #getWhen()
	 * @generated
	 */
	void setWhen(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where</em>' containment reference.
	 * @see #setWhere(OCLExpression)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getMappingOperation_Where()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='whereOwner'"
	 * @generated
	 */
	OCLExpression getWhere();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation#getWhere <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Where</em>' containment reference.
	 * @see #getWhere()
	 * @generated
	 */
	void setWhere(OCLExpression value);

} // MappingOperation
