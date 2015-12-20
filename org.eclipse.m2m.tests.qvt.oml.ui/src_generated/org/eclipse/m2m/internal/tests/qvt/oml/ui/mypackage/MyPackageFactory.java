/**
 * <copyright>
 * </copyright>
 *
 * $Id: MyPackageFactory.java,v 1.1 2008/08/12 16:07:12 aigdalov Exp $
 */
package org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyPackagePackage
 * @generated
 */
public interface MyPackageFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    MyPackageFactory eINSTANCE = org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl.MyPackageFactoryImpl.init();

    /**
     * Returns a new object of class '<em>My Class</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>My Class</em>'.
     * @generated
     */
    MyClass createMyClass();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    MyPackagePackage getMyPackagePackage();

} //MyPackageFactory
