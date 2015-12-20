/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Name2 CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathName2CS#getOwnedPathElements2 <em>Owned Path Elements2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getPathName2CS()
 * @model
 * @generated
 */
public interface PathName2CS extends PivotableElementCS {
	/**
	 * Returns the value of the '<em><b>Owned Path Elements2</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathElement2CS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Path Elements2</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Path Elements2</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getPathName2CS_OwnedPathElements2()
	 * @model containment="true"
	 * @generated
	 */
	EList<PathElement2CS> getOwnedPathElements2();

} // PathName2CS
