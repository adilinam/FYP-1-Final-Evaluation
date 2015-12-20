/**
 */
package generics;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see generics.GenericsPackage
 * @generated
 */
public interface GenericsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GenericsFactory eINSTANCE = generics.impl.GenericsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Generic Cls</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Cls</em>'.
	 * @generated
	 */
	<E extends Number> GenericCls<E> createGenericCls();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GenericsPackage getGenericsPackage();

} //GenericsFactory
