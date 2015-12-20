/**
 */
package generics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Cls</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link generics.GenericCls#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see generics.GenericsPackage#getGenericCls()
 * @model EBounds="generics.MyNumber"
 * @generated
 */
public interface GenericCls<E extends Number> extends EObject {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link E}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see generics.GenericsPackage#getGenericCls_Values()
	 * @model
	 * @generated
	 */
	EList<E> getValues();

} // GenericCls
