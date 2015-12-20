/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationCS#getRefines <em>Refines</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getTransformationCS()
 * @model
 * @generated
 */
public interface TransformationCS extends ModuleCS {
	/**
	 * Returns the value of the '<em><b>Refines</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refines</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines</em>' containment reference.
	 * @see #setRefines(ModuleRefCS)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getTransformationCS_Refines()
	 * @model containment="true"
	 * @generated
	 */
	ModuleRefCS getRefines();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationCS#getRefines <em>Refines</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refines</em>' containment reference.
	 * @see #getRefines()
	 * @generated
	 */
	void setRefines(ModuleRefCS value);

} // TransformationCS
