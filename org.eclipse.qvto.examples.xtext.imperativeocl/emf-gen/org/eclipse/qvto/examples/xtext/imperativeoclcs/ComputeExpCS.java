/**
 */
package org.eclipse.qvto.examples.xtext.imperativeoclcs;

import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compute Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ComputeExpCS#getReturnedElement <em>Returned Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage#getComputeExpCS()
 * @model
 * @generated
 */
public interface ComputeExpCS extends ExpressionBlockCS {
	/**
	 * Returns the value of the '<em><b>Returned Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Returned Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Returned Element</em>' containment reference.
	 * @see #setReturnedElement(VariableCS)
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage#getComputeExpCS_ReturnedElement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableCS getReturnedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ComputeExpCS#getReturnedElement <em>Returned Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Returned Element</em>' containment reference.
	 * @see #getReturnedElement()
	 * @generated
	 */
	void setReturnedElement(VariableCS value);

} // ComputeExpCS
