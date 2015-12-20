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

import org.eclipse.ocl.pivot.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assert Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#getAssertion <em>Assertion</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#getLog <em>Log</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#getSeverity <em>Severity</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getAssertExp()
 * @model
 * @generated
 */
public interface AssertExp extends ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Assertion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assertion</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assertion</em>' containment reference.
	 * @see #setAssertion(OCLExpression)
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getAssertExp_Assertion()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='assertOwner'"
	 * @generated
	 */
	OCLExpression getAssertion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#getAssertion <em>Assertion</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assertion</em>' containment reference.
	 * @see #getAssertion()
	 * @generated
	 */
	void setAssertion(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Log</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log</em>' containment reference.
	 * @see #setLog(LogExp)
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getAssertExp_Log()
	 * @model containment="true"
	 * @generated
	 */
	LogExp getLog();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#getLog <em>Log</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log</em>' containment reference.
	 * @see #getLog()
	 * @generated
	 */
	void setLog(LogExp value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The default value is <code>"error"</code>.
	 * The literals are from the enumeration {@link org.eclipse.qvto.examples.pivot.imperativeocl.SeverityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.SeverityKind
	 * @see #setSeverity(SeverityKind)
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getAssertExp_Severity()
	 * @model default="error"
	 * @generated
	 */
	SeverityKind getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.SeverityKind
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(SeverityKind value);

} // AssertExp
