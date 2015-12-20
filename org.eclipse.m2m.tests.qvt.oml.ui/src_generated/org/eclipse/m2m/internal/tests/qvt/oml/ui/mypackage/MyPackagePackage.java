/**
 * <copyright>
 * </copyright>
 *
 * $Id: MyPackagePackage.java,v 1.1 2008/08/12 16:07:12 aigdalov Exp $
 */
package org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyPackageFactory
 * @model kind="package"
 * @generated
 */
public interface MyPackagePackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "mypackage";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/m2m/qvt/oml/ui/test/codesense";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "cdstst";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    MyPackagePackage eINSTANCE = org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl.MyPackagePackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl.MyClassImpl <em>My Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl.MyClassImpl
     * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl.MyPackagePackageImpl#getMyClass()
     * @generated
     */
    int MY_CLASS = 0;

    /**
     * The feature id for the '<em><b>My Enum Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MY_CLASS__MY_ENUM_ATTRIBUTE = 0;

    /**
     * The feature id for the '<em><b>My Int Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MY_CLASS__MY_INT_ATTRIBUTE = 1;

    /**
     * The number of structural features of the '<em>My Class</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MY_CLASS_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyEnum <em>My Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyEnum
     * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl.MyPackagePackageImpl#getMyEnum()
     * @generated
     */
    int MY_ENUM = 1;


    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyClass <em>My Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>My Class</em>'.
     * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyClass
     * @generated
     */
    EClass getMyClass();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyClass#getMyEnumAttribute <em>My Enum Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>My Enum Attribute</em>'.
     * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyClass#getMyEnumAttribute()
     * @see #getMyClass()
     * @generated
     */
    EAttribute getMyClass_MyEnumAttribute();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyClass#getMyIntAttribute <em>My Int Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>My Int Attribute</em>'.
     * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyClass#getMyIntAttribute()
     * @see #getMyClass()
     * @generated
     */
    EAttribute getMyClass_MyIntAttribute();

    /**
     * Returns the meta object for enum '{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyEnum <em>My Enum</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>My Enum</em>'.
     * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyEnum
     * @generated
     */
    EEnum getMyEnum();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    MyPackageFactory getMyPackageFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl.MyClassImpl <em>My Class</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl.MyClassImpl
         * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl.MyPackagePackageImpl#getMyClass()
         * @generated
         */
        EClass MY_CLASS = eINSTANCE.getMyClass();

        /**
         * The meta object literal for the '<em><b>My Enum Attribute</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MY_CLASS__MY_ENUM_ATTRIBUTE = eINSTANCE.getMyClass_MyEnumAttribute();

        /**
         * The meta object literal for the '<em><b>My Int Attribute</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MY_CLASS__MY_INT_ATTRIBUTE = eINSTANCE.getMyClass_MyIntAttribute();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyEnum <em>My Enum</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyEnum
         * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl.MyPackagePackageImpl#getMyEnum()
         * @generated
         */
        EEnum MY_ENUM = eINSTANCE.getMyEnum();

    }

} //MyPackagePackage
