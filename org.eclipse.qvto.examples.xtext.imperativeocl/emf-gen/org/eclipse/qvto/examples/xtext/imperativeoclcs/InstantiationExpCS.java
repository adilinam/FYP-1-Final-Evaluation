/**
 */
package org.eclipse.qvto.examples.xtext.imperativeoclcs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.xtext.basecs.TypeCS;

import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instantiation Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.InstantiationExpCS#getTypeSpecCS <em>Type Spec CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.InstantiationExpCS#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage#getInstantiationExpCS()
 * @model
 * @generated
 */
public interface InstantiationExpCS extends StatementCS {
	/**
	 * Returns the value of the '<em><b>Type Spec CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Spec CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Spec CS</em>' containment reference.
	 * @see #setTypeSpecCS(TypeCS)
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage#getInstantiationExpCS_TypeSpecCS()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypeCS getTypeSpecCS();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.InstantiationExpCS#getTypeSpecCS <em>Type Spec CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Spec CS</em>' containment reference.
	 * @see #getTypeSpecCS()
	 * @generated
	 */
	void setTypeSpecCS(TypeCS value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage#getInstantiationExpCS_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpCS> getArguments();

} // InstantiationExpCS
