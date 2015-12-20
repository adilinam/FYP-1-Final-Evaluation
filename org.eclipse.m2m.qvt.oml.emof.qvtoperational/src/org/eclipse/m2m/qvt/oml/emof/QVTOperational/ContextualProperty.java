/**
 * <copyright>
 * </copyright>
 *
 * $Id: ContextualProperty.java,v 1.2 2009/02/20 12:55:55 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational;

import org.eclipse.qvt.declarative.emof.EMOF.Property;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contextual Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ContextualProperty#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ContextualProperty#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ContextualProperty#getOverridden <em>Overridden</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getContextualProperty()
 * @model
 * @generated
 */
public interface ContextualProperty extends Property {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(org.eclipse.qvt.declarative.emof.EMOF.Class)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getContextualProperty_Context()
	 * @model required="true"
	 * @generated
	 */
	org.eclipse.qvt.declarative.emof.EMOF.Class getContext();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ContextualProperty#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(org.eclipse.qvt.declarative.emof.EMOF.Class value);

	/**
	 * Returns the value of the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Expression</em>' containment reference.
	 * @see #setInitExpression(OclExpression)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getContextualProperty_InitExpression()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='ownerProperty'"
	 * @generated
	 */
	OclExpression getInitExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ContextualProperty#getInitExpression <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Expression</em>' containment reference.
	 * @see #getInitExpression()
	 * @generated
	 */
	void setInitExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Overridden</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overridden</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overridden</em>' reference.
	 * @see #setOverridden(Property)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getContextualProperty_Overridden()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='overriding'"
	 * @generated
	 */
	Property getOverridden();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ContextualProperty#getOverridden <em>Overridden</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overridden</em>' reference.
	 * @see #getOverridden()
	 * @generated
	 */
	void setOverridden(Property value);

} // ContextualProperty
