/**
 * <copyright>
 * </copyright>
 *
 * $Id: MyClassImpl.java,v 1.1 2008/08/12 16:07:14 aigdalov Exp $
 */
package org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyClass;
import org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyEnum;
import org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyPackagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>My Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl.MyClassImpl#getMyEnumAttribute <em>My Enum Attribute</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl.MyClassImpl#getMyIntAttribute <em>My Int Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MyClassImpl extends EObjectImpl implements MyClass {
    /**
     * The default value of the '{@link #getMyEnumAttribute() <em>My Enum Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMyEnumAttribute()
     * @generated
     * @ordered
     */
    protected static final MyEnum MY_ENUM_ATTRIBUTE_EDEFAULT = MyEnum.MY_ENUM_LITERAL1;

    /**
     * The cached value of the '{@link #getMyEnumAttribute() <em>My Enum Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMyEnumAttribute()
     * @generated
     * @ordered
     */
    protected MyEnum myEnumAttribute = MY_ENUM_ATTRIBUTE_EDEFAULT;

    /**
     * The default value of the '{@link #getMyIntAttribute() <em>My Int Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMyIntAttribute()
     * @generated
     * @ordered
     */
    protected static final int MY_INT_ATTRIBUTE_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getMyIntAttribute() <em>My Int Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMyIntAttribute()
     * @generated
     * @ordered
     */
    protected int myIntAttribute = MY_INT_ATTRIBUTE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MyClassImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MyPackagePackage.Literals.MY_CLASS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MyEnum getMyEnumAttribute() {
        return myEnumAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMyEnumAttribute(MyEnum newMyEnumAttribute) {
        MyEnum oldMyEnumAttribute = myEnumAttribute;
        myEnumAttribute = newMyEnumAttribute == null ? MY_ENUM_ATTRIBUTE_EDEFAULT : newMyEnumAttribute;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MyPackagePackage.MY_CLASS__MY_ENUM_ATTRIBUTE, oldMyEnumAttribute, myEnumAttribute));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getMyIntAttribute() {
        return myIntAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMyIntAttribute(int newMyIntAttribute) {
        int oldMyIntAttribute = myIntAttribute;
        myIntAttribute = newMyIntAttribute;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MyPackagePackage.MY_CLASS__MY_INT_ATTRIBUTE, oldMyIntAttribute, myIntAttribute));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MyPackagePackage.MY_CLASS__MY_ENUM_ATTRIBUTE:
                return getMyEnumAttribute();
            case MyPackagePackage.MY_CLASS__MY_INT_ATTRIBUTE:
                return new Integer(getMyIntAttribute());
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MyPackagePackage.MY_CLASS__MY_ENUM_ATTRIBUTE:
                setMyEnumAttribute((MyEnum)newValue);
                return;
            case MyPackagePackage.MY_CLASS__MY_INT_ATTRIBUTE:
                setMyIntAttribute(((Integer)newValue).intValue());
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case MyPackagePackage.MY_CLASS__MY_ENUM_ATTRIBUTE:
                setMyEnumAttribute(MY_ENUM_ATTRIBUTE_EDEFAULT);
                return;
            case MyPackagePackage.MY_CLASS__MY_INT_ATTRIBUTE:
                setMyIntAttribute(MY_INT_ATTRIBUTE_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case MyPackagePackage.MY_CLASS__MY_ENUM_ATTRIBUTE:
                return myEnumAttribute != MY_ENUM_ATTRIBUTE_EDEFAULT;
            case MyPackagePackage.MY_CLASS__MY_INT_ATTRIBUTE:
                return myIntAttribute != MY_INT_ATTRIBUTE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (MyEnumAttribute: ");
        result.append(myEnumAttribute);
        result.append(", MyIntAttribute: ");
        result.append(myIntAttribute);
        result.append(')');
        return result.toString();
    }

} //MyClassImpl
