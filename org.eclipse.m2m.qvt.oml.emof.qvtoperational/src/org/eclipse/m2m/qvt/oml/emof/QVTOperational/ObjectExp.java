/**
 * <copyright>
 * </copyright>
 *
 * $Id: ObjectExp.java,v 1.1 2008/09/02 20:36:01 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational;

import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp;
import org.eclipse.qvt.declarative.emof.EssentialOCL.Variable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ObjectExp#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ObjectExp#getReferredObject <em>Referred Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getObjectExp()
 * @model
 * @generated
 */
public interface ObjectExp extends InstantiationExp {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(ConstructorBody)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getObjectExp_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConstructorBody getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ObjectExp#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(ConstructorBody value);

	/**
	 * Returns the value of the '<em><b>Referred Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Object</em>' reference.
	 * @see #setReferredObject(Variable)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getObjectExp_ReferredObject()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='objectExpression'"
	 * @generated
	 */
	Variable getReferredObject();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ObjectExp#getReferredObject <em>Referred Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Object</em>' reference.
	 * @see #getReferredObject()
	 * @generated
	 */
	void setReferredObject(Variable value);

} // ObjectExp
