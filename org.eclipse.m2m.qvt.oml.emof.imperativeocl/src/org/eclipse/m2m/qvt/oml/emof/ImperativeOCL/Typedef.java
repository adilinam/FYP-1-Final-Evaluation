/**
 * <copyright>
 * </copyright>
 *
 * $Id: Typedef.java,v 1.2 2009/01/25 23:11:18 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.ImperativeOCL;

import org.eclipse.qvt.declarative.emof.EMOF.Type;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typedef</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.Typedef#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.Typedef#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getTypedef()
 * @model
 * @generated
 */
public interface Typedef extends org.eclipse.qvt.declarative.emof.EMOF.Class {
	/**
	 * Returns the value of the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' reference.
	 * @see #setBase(Type)
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getTypedef_Base()
	 * @model required="true"
	 * @generated
	 */
	Type getBase();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.Typedef#getBase <em>Base</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' reference.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(Type value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(OclExpression)
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getTypedef_Condition()
	 * @model containment="true"
	 * @generated
	 */
	OclExpression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.Typedef#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(OclExpression value);

} // Typedef
