/**
 * <copyright>
 * </copyright>
 *
 * $Id: OrderedTupleType.java,v 1.2 2009/01/25 23:11:18 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.ImperativeOCL;

import org.eclipse.emf.common.util.EList;
import org.eclipse.qvt.declarative.emof.EMOF.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ordered Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleType#getElementType <em>Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getOrderedTupleType()
 * @model
 * @generated
 */
public interface OrderedTupleType extends org.eclipse.qvt.declarative.emof.EMOF.Class {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EMOF.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' reference list.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getOrderedTupleType_ElementType()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='eltTuple'"
	 * @generated
	 */
	EList<Type> getElementType();

} // OrderedTupleType
