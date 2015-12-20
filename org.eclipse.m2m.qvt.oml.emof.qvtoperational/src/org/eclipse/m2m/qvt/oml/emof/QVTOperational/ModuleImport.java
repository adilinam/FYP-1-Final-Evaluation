/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModuleImport.java,v 1.2 2009/02/20 12:55:55 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational;

import org.eclipse.emf.common.util.EList;
import org.eclipse.qvt.declarative.emof.EMOF.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModuleImport#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModuleImport#getImportedModule <em>Imported Module</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModuleImport#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModuleImport#getModule <em>Module</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getModuleImport()
 * @model
 * @generated
 */
public interface ModuleImport extends Element {
	/**
	 * Returns the value of the '<em><b>Binding</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModelType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' reference list.
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getModuleImport_Binding()
	 * @model
	 * @generated
	 */
	EList<ModelType> getBinding();

	/**
	 * Returns the value of the '<em><b>Imported Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Module</em>' reference.
	 * @see #setImportedModule(Module)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getModuleImport_ImportedModule()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='importingElement'"
	 * @generated
	 */
	Module getImportedModule();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModuleImport#getImportedModule <em>Imported Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Module</em>' reference.
	 * @see #getImportedModule()
	 * @generated
	 */
	void setImportedModule(Module value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImportKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImportKind
	 * @see #setKind(ImportKind)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getModuleImport_Kind()
	 * @model
	 * @generated
	 */
	ImportKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModuleImport#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImportKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ImportKind value);

	/**
	 * Returns the value of the '<em><b>Module</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.Module#getModuleImport <em>Module Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' container reference.
	 * @see #setModule(Module)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getModuleImport_Module()
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.Module#getModuleImport
	 * @model opposite="moduleImport"
	 * @generated
	 */
	Module getModule();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModuleImport#getModule <em>Module</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' container reference.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(Module value);

} // ModuleImport
