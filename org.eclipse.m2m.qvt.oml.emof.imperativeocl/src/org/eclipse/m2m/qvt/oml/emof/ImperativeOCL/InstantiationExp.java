/**
 * <copyright>
 * </copyright>
 *
 * $Id: InstantiationExp.java,v 1.2 2009/01/25 23:11:17 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.ImperativeOCL;

import org.eclipse.emf.common.util.EList;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;
import org.eclipse.qvt.declarative.emof.EssentialOCL.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instantiation Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp#getExtent <em>Extent</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp#getInstantiatedClass <em>Instantiated Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getInstantiationExp()
 * @model
 * @generated
 */
public interface InstantiationExp extends ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getInstantiationExp_Argument()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='argOwner'"
	 * @generated
	 */
	EList<OclExpression> getArgument();

	/**
	 * Returns the value of the '<em><b>Extent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extent</em>' reference.
	 * @see #setExtent(Variable)
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getInstantiationExp_Extent()
	 * @model
	 * @generated
	 */
	Variable getExtent();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp#getExtent <em>Extent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extent</em>' reference.
	 * @see #getExtent()
	 * @generated
	 */
	void setExtent(Variable value);

	/**
	 * Returns the value of the '<em><b>Instantiated Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instantiated Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instantiated Class</em>' reference.
	 * @see #setInstantiatedClass(org.eclipse.qvt.declarative.emof.EMOF.Class)
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getInstantiationExp_InstantiatedClass()
	 * @model required="true"
	 * @generated
	 */
	org.eclipse.qvt.declarative.emof.EMOF.Class getInstantiatedClass();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp#getInstantiatedClass <em>Instantiated Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instantiated Class</em>' reference.
	 * @see #getInstantiatedClass()
	 * @generated
	 */
	void setInstantiatedClass(org.eclipse.qvt.declarative.emof.EMOF.Class value);

} // InstantiationExp
