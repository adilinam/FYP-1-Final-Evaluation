/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssertExp.java,v 1.1 2008/09/02 20:36:35 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.ImperativeOCL;

import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assert Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp#getAssertion <em>Assertion</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp#getLog <em>Log</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getAssertExp()
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
	 * @see #setAssertion(OclExpression)
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getAssertExp_Assertion()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='assertOwner'"
	 * @generated
	 */
	OclExpression getAssertion();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp#getAssertion <em>Assertion</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assertion</em>' containment reference.
	 * @see #getAssertion()
	 * @generated
	 */
	void setAssertion(OclExpression value);

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
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getAssertExp_Log()
	 * @model containment="true"
	 * @generated
	 */
	LogExp getLog();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp#getLog <em>Log</em>}' containment reference.
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
	 * The literals are from the enumeration {@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SeverityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SeverityKind
	 * @see #setSeverity(SeverityKind)
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getAssertExp_Severity()
	 * @model default="error"
	 * @generated
	 */
	SeverityKind getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SeverityKind
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(SeverityKind value);

} // AssertExp
