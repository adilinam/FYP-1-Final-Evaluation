/**
 * <copyright>
 * </copyright>
 *
 * $Id: MyEnum.java,v 1.1 2008/08/12 16:07:12 aigdalov Exp $
 */
package org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>My Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyPackagePackage#getMyEnum()
 * @model
 * @generated
 */
public enum MyEnum implements Enumerator {
    /**
     * The '<em><b>My Enum Literal1</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MY_ENUM_LITERAL1_VALUE
     * @generated
     * @ordered
     */
    MY_ENUM_LITERAL1(0, "MyEnumLiteral1", "MyEnumLiteral1"),

    /**
     * The '<em><b>My Enum Literal2</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MY_ENUM_LITERAL2_VALUE
     * @generated
     * @ordered
     */
    MY_ENUM_LITERAL2(1, "MyEnumLiteral2", "MyEnumLiteral2"),

    /**
     * The '<em><b>My Enum Literal3</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MY_ENUM_LITERAL3_VALUE
     * @generated
     * @ordered
     */
    MY_ENUM_LITERAL3(2, "MyEnumLiteral3", "MyEnumLiteral3");

    /**
     * The '<em><b>My Enum Literal1</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>My Enum Literal1</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MY_ENUM_LITERAL1
     * @model name="MyEnumLiteral1"
     * @generated
     * @ordered
     */
    public static final int MY_ENUM_LITERAL1_VALUE = 0;

    /**
     * The '<em><b>My Enum Literal2</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>My Enum Literal2</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MY_ENUM_LITERAL2
     * @model name="MyEnumLiteral2"
     * @generated
     * @ordered
     */
    public static final int MY_ENUM_LITERAL2_VALUE = 1;

    /**
     * The '<em><b>My Enum Literal3</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>My Enum Literal3</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MY_ENUM_LITERAL3
     * @model name="MyEnumLiteral3"
     * @generated
     * @ordered
     */
    public static final int MY_ENUM_LITERAL3_VALUE = 2;

    /**
     * An array of all the '<em><b>My Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final MyEnum[] VALUES_ARRAY =
        new MyEnum[] {
            MY_ENUM_LITERAL1,
            MY_ENUM_LITERAL2,
            MY_ENUM_LITERAL3,
        };

    /**
     * A public read-only list of all the '<em><b>My Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<MyEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>My Enum</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MyEnum get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            MyEnum result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>My Enum</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MyEnum getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            MyEnum result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>My Enum</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MyEnum get(int value) {
        switch (value) {
            case MY_ENUM_LITERAL1_VALUE: return MY_ENUM_LITERAL1;
            case MY_ENUM_LITERAL2_VALUE: return MY_ENUM_LITERAL2;
            case MY_ENUM_LITERAL3_VALUE: return MY_ENUM_LITERAL3;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private MyEnum(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getValue() {
      return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
      return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLiteral() {
      return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }
    
} //MyEnum
