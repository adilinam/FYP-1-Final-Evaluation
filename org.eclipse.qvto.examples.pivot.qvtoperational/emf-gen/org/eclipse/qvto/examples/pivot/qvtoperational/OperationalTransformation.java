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
import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operational Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation#getIntermediateClass <em>Intermediate Class</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation#getIntermediateProperty <em>Intermediate Property</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation#getRelation <em>Relation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getOperationalTransformation()
 * @model
 * @generated
 */
public interface OperationalTransformation extends Module {
	/**
	 * Returns the value of the '<em><b>Intermediate Class</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intermediate Class</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Class</em>' reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getOperationalTransformation_IntermediateClass()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='transfClient'"
	 * @generated
	 */
	EList<org.eclipse.ocl.pivot.Class> getIntermediateClass();

	/**
	 * Returns the value of the '<em><b>Intermediate Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intermediate Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Property</em>' reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getOperationalTransformation_IntermediateProperty()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='tranfClient'"
	 * @generated
	 */
	EList<Property> getIntermediateProperty();

	/**
	 * Returns the value of the '<em><b>Model Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Parameter</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getOperationalTransformation_ModelParameter()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='module'"
	 * @generated
	 */
	EList<ModelParameter> getModelParameter();

	/**
	 * Returns the value of the '<em><b>Refined</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined</em>' reference.
	 * @see #setRefined(DummyRelationalTransformation)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getOperationalTransformation_Refined()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='refinement'"
	 * @generated
	 */
	DummyRelationalTransformation getRefined();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation#getRefined <em>Refined</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refined</em>' reference.
	 * @see #getRefined()
	 * @generated
	 */
	void setRefined(DummyRelationalTransformation value);

	/**
	 * Returns the value of the '<em><b>Relation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getOperationalTransformation_Relation()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='owner'"
	 * @generated
	 */
	EList<DummyRelation> getRelation();

} // OperationalTransformation
