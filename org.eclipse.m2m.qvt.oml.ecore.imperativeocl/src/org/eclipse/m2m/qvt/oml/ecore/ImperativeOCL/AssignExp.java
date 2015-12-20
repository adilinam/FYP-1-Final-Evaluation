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
 * $Id: AssignExp.java,v 1.3 2009/01/25 23:10:43 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assign Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp#isIsReset <em>Is Reset</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage#getAssignExp()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='WellFormedLeftExp checkLeftAndValueExpConformance'"
 * @generated
 */
public interface AssignExp extends ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' containment reference.
	 * @see #setDefaultValue(OCLExpression)
	 * @see org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage#getAssignExp_DefaultValue()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='defaultOwner'"
	 * @generated
	 */
	OCLExpression getDefaultValue();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp#getDefaultValue <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' containment reference.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Is Reset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Reset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Reset</em>' attribute.
	 * @see #isSetIsReset()
	 * @see #unsetIsReset()
	 * @see #setIsReset(boolean)
	 * @see org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage#getAssignExp_IsReset()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isIsReset();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp#isIsReset <em>Is Reset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Reset</em>' attribute.
	 * @see #isSetIsReset()
	 * @see #unsetIsReset()
	 * @see #isIsReset()
	 * @generated
	 */
	void setIsReset(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp#isIsReset <em>Is Reset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsReset()
	 * @see #isIsReset()
	 * @see #setIsReset(boolean)
	 * @generated
	 */
	void unsetIsReset();

	/**
	 * Returns whether the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp#isIsReset <em>Is Reset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Reset</em>' attribute is set.
	 * @see #unsetIsReset()
	 * @see #isIsReset()
	 * @see #setIsReset(boolean)
	 * @generated
	 */
	boolean isSetIsReset();

	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(OCLExpression)
	 * @see org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage#getAssignExp_Left()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='leftOwner'"
	 * @generated
	 */
	OCLExpression getLeft();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.ecore.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage#getAssignExp_Value()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='valueOwner'"
	 * @generated
	 */
	EList<OCLExpression> getValue();

} // AssignExp
