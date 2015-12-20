/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.ElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Usage CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS#getImportKind <em>Import Kind</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS#getModuleKind <em>Module Kind</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS#getModuleRefs <em>Module Refs</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getModuleUsageCS()
 * @model
 * @generated
 */
public interface ModuleUsageCS extends ElementCS {
	/**
	 * Returns the value of the '<em><b>Import Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImportKindEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImportKindEnum
	 * @see #setImportKind(ImportKindEnum)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getModuleUsageCS_ImportKind()
	 * @model
	 * @generated
	 */
	ImportKindEnum getImportKind();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS#getImportKind <em>Import Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImportKindEnum
	 * @see #getImportKind()
	 * @generated
	 */
	void setImportKind(ImportKindEnum value);

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
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getModuleUsageCS_ModuleKind()
	 * @model
	 * @generated
	 */
	ModuleKindEnum getModuleKind();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS#getModuleKind <em>Module Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindEnum
	 * @see #getModuleKind()
	 * @generated
	 */
	void setModuleKind(ModuleKindEnum value);

	/**
	 * Returns the value of the '<em><b>Module Refs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Refs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Refs</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getModuleUsageCS_ModuleRefs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ModuleRefCS> getModuleRefs();

} // ModuleUsageCS
