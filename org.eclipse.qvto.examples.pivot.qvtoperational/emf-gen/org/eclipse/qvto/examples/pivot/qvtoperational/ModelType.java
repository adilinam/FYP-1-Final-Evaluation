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
 * A representation of the model object '<em><b>Model Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.ModelType#getAdditionalCondition <em>Additional Condition</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.ModelType#getConformanceKind <em>Conformance Kind</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.ModelType#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getModelType()
 * @model
 * @generated
 */
public interface ModelType extends org.eclipse.ocl.pivot.Class {
	/**
	 * Returns the value of the '<em><b>Additional Condition</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Condition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Condition</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getModelType_AdditionalCondition()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='condOwner'"
	 * @generated
	 */
	EList<OCLExpression> getAdditionalCondition();

	/**
	 * Returns the value of the '<em><b>Conformance Kind</b></em>' attribute.
	 * The default value is <code>"effective"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conformance Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conformance Kind</em>' attribute.
	 * @see #setConformanceKind(String)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getModelType_ConformanceKind()
	 * @model default="effective" dataType="org.eclipse.ocl.pivot.String"
	 * @generated
	 */
	String getConformanceKind();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.ModelType#getConformanceKind <em>Conformance Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conformance Kind</em>' attribute.
	 * @see #getConformanceKind()
	 * @generated
	 */
	void setConformanceKind(String value);

	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getModelType_Metamodel()
	 * @model required="true"
	 * @generated
	 */
	EList<org.eclipse.ocl.pivot.Package> getMetamodel();

} // ModelType
