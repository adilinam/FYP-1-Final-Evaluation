/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.ElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Signature CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.CompleteSignatureCS#getSimpleSignature <em>Simple Signature</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.CompleteSignatureCS#getResultParams <em>Result Params</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getCompleteSignatureCS()
 * @model
 * @generated
 */
public interface CompleteSignatureCS extends ElementCS {
	/**
	 * Returns the value of the '<em><b>Simple Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Signature</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Signature</em>' containment reference.
	 * @see #setSimpleSignature(SimpleSignatureCS)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getCompleteSignatureCS_SimpleSignature()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SimpleSignatureCS getSimpleSignature();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.CompleteSignatureCS#getSimpleSignature <em>Simple Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Signature</em>' containment reference.
	 * @see #getSimpleSignature()
	 * @generated
	 */
	void setSimpleSignature(SimpleSignatureCS value);

	/**
	 * Returns the value of the '<em><b>Result Params</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ParameterDeclarationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Params</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getCompleteSignatureCS_ResultParams()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterDeclarationCS> getResultParams();

} // CompleteSignatureCS
