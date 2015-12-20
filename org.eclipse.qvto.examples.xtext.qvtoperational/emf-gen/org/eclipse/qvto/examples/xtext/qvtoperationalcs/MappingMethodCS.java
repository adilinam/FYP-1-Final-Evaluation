/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs;

import org.eclipse.ocl.xtext.basecs.ElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Method CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingMethodCS#isBlackBox <em>Black Box</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingMethodCS#getMappingDeclarationCS <em>Mapping Declaration CS</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getMappingMethodCS()
 * @model abstract="true"
 * @generated
 */
public interface MappingMethodCS extends ElementCS {
	/**
	 * Returns the value of the '<em><b>Black Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Black Box</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Black Box</em>' attribute.
	 * @see #setBlackBox(boolean)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getMappingMethodCS_BlackBox()
	 * @model
	 * @generated
	 */
	boolean isBlackBox();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingMethodCS#isBlackBox <em>Black Box</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Black Box</em>' attribute.
	 * @see #isBlackBox()
	 * @generated
	 */
	void setBlackBox(boolean value);

	/**
	 * Returns the value of the '<em><b>Mapping Declaration CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Declaration CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Declaration CS</em>' containment reference.
	 * @see #setMappingDeclarationCS(MappingOperationCS)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getMappingMethodCS_MappingDeclarationCS()
	 * @model containment="true"
	 * @generated
	 */
	MappingOperationCS getMappingDeclarationCS();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingMethodCS#getMappingDeclarationCS <em>Mapping Declaration CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Declaration CS</em>' containment reference.
	 * @see #getMappingDeclarationCS()
	 * @generated
	 */
	void setMappingDeclarationCS(MappingOperationCS value);

} // MappingMethodCS
