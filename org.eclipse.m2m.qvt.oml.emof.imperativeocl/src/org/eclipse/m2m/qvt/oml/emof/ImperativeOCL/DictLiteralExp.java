/**
 * <copyright>
 * </copyright>
 *
 * $Id: DictLiteralExp.java,v 1.2 2009/01/25 23:11:18 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.ImperativeOCL;

import org.eclipse.emf.common.util.EList;
import org.eclipse.qvt.declarative.emof.EssentialOCL.LiteralExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dict Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralExp#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getDictLiteralExp()
 * @model
 * @generated
 */
public interface DictLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getDictLiteralExp_Part()
	 * @model containment="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='partOwner'"
	 * @generated
	 */
	EList<DictLiteralPart> getPart();

} // DictLiteralExp
