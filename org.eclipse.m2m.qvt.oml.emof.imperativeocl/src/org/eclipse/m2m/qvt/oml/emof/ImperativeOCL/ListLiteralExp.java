/**
 * <copyright>
 * </copyright>
 *
 * $Id: ListLiteralExp.java,v 1.1 2009/12/09 14:03:54 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.ImperativeOCL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvt.declarative.emof.EssentialOCL.LiteralExp;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ListLiteralExp#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getListLiteralExp()
 * @model
 * @generated
 */
public interface ListLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getListLiteralExp_Element()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='elementOwner'"
	 * @generated
	 */
	EList<OclExpression> getElement();

} // ListLiteralExp
