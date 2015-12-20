/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs;

import org.eclipse.ocl.xtext.basecs.PackageCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metamodel CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelCS#getMetamodelKind <em>Metamodel Kind</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getMetamodelCS()
 * @model
 * @generated
 */
public interface MetamodelCS extends PackageCS {
	/**
	 * Returns the value of the '<em><b>Metamodel Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelKind
	 * @see #setMetamodelKind(MetamodelKind)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getMetamodelCS_MetamodelKind()
	 * @model
	 * @generated
	 */
	MetamodelKind getMetamodelKind();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelCS#getMetamodelKind <em>Metamodel Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelKind
	 * @see #getMetamodelKind()
	 * @generated
	 */
	void setMetamodelKind(MetamodelKind value);

} // MetamodelCS
