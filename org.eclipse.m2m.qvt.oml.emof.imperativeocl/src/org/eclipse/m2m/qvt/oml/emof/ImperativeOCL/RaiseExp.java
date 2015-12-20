/**
 * <copyright>
 * </copyright>
 *
 * $Id: RaiseExp.java,v 1.2 2009/01/25 23:11:17 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.ImperativeOCL;

import org.eclipse.qvt.declarative.emof.EMOF.Type;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Raise Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.RaiseExp#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.RaiseExp#getException <em>Exception</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getRaiseExp()
 * @model
 * @generated
 */
public interface RaiseExp extends ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference.
	 * @see #setArgument(OclExpression)
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getRaiseExp_Argument()
	 * @model containment="true"
	 * @generated
	 */
	OclExpression getArgument();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.RaiseExp#getArgument <em>Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument</em>' containment reference.
	 * @see #getArgument()
	 * @generated
	 */
	void setArgument(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' reference.
	 * @see #setException(Type)
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getRaiseExp_Exception()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='raiseExpression'"
	 * @generated
	 */
	Type getException();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.RaiseExp#getException <em>Exception</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' reference.
	 * @see #getException()
	 * @generated
	 */
	void setException(Type value);

} // RaiseExp
