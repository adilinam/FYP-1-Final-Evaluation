/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs;

import org.eclipse.ocl.xtext.basecs.ElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Kind CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindCS#getModuleKind <em>Module Kind</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getModuleKindCS()
 * @model
 * @generated
 */
public interface ModuleKindCS extends ElementCS {
	/**
	 * Returns the value of the '<em><b>Module Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindEnum
	 * @see #setModuleKind(ModuleKindEnum)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getModuleKindCS_ModuleKind()
	 * @model
	 * @generated
	 */
	ModuleKindEnum getModuleKind();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindCS#getModuleKind <em>Module Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindEnum
	 * @see #getModuleKind()
	 * @generated
	 */
	void setModuleKind(ModuleKindEnum value);

} // ModuleKindCS
