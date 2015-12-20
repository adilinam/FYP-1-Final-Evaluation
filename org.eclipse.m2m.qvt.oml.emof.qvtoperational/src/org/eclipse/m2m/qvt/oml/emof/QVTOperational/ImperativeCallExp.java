/**
 * <copyright>
 * </copyright>
 *
 * $Id: ImperativeCallExp.java,v 1.1 2008/09/02 20:36:00 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational;

import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeExpression;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OperationCallExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imperative Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImperativeCallExp#getIsVirtual <em>Is Virtual</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getImperativeCallExp()
 * @model
 * @generated
 */
public interface ImperativeCallExp extends OperationCallExp, ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Is Virtual</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Virtual</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Virtual</em>' attribute.
	 * @see #setIsVirtual(Boolean)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getImperativeCallExp_IsVirtual()
	 * @model default="true" dataType="org.eclipse.qvt.declarative.emof.EMOF.Boolean"
	 * @generated
	 */
	Boolean getIsVirtual();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImperativeCallExp#getIsVirtual <em>Is Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Virtual</em>' attribute.
	 * @see #getIsVirtual()
	 * @generated
	 */
	void setIsVirtual(Boolean value);

} // ImperativeCallExp
