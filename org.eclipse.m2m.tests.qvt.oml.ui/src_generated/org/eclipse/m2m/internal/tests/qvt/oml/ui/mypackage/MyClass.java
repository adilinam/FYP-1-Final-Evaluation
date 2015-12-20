/**
 * <copyright>
 * </copyright>
 *
 * $Id: MyClass.java,v 1.1 2008/08/12 16:07:12 aigdalov Exp $
 */
package org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyClass#getMyEnumAttribute <em>My Enum Attribute</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyClass#getMyIntAttribute <em>My Int Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyPackagePackage#getMyClass()
 * @model
 * @generated
 */
public interface MyClass extends EObject {
    /**
     * Returns the value of the '<em><b>My Enum Attribute</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * The literals are from the enumeration {@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyEnum}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>My Enum Attribute</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>My Enum Attribute</em>' attribute.
     * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyEnum
     * @see #setMyEnumAttribute(MyEnum)
     * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyPackagePackage#getMyClass_MyEnumAttribute()
     * @model default="0"
     * @generated
     */
    MyEnum getMyEnumAttribute();

    /**
     * Sets the value of the '{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyClass#getMyEnumAttribute <em>My Enum Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>My Enum Attribute</em>' attribute.
     * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyEnum
     * @see #getMyEnumAttribute()
     * @generated
     */
    void setMyEnumAttribute(MyEnum value);

    /**
     * Returns the value of the '<em><b>My Int Attribute</b></em>' attribute.
     * The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>My Int Attribute</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>My Int Attribute</em>' attribute.
     * @see #setMyIntAttribute(int)
     * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyPackagePackage#getMyClass_MyIntAttribute()
     * @model default="-1"
     * @generated
     */
    int getMyIntAttribute();

    /**
     * Sets the value of the '{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyClass#getMyIntAttribute <em>My Int Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>My Int Attribute</em>' attribute.
     * @see #getMyIntAttribute()
     * @generated
     */
    void setMyIntAttribute(int value);

} // MyClass
