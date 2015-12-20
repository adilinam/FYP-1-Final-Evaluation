/**
 * <copyright>
 * </copyright>
 *
 * $Id: MyPackagePackageImpl.java,v 1.1 2008/08/12 16:07:14 aigdalov Exp $
 */
package org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyClass;
import org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyEnum;
import org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyPackageFactory;
import org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyPackagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MyPackagePackageImpl extends EPackageImpl implements MyPackagePackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass myClassEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum myEnumEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.m2m.internal.tests.qvt.oml.ui.mypackage.MyPackagePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private MyPackagePackageImpl() {
        super(eNS_URI, MyPackageFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static MyPackagePackage init() {
        if (isInited) return (MyPackagePackage)EPackage.Registry.INSTANCE.getEPackage(MyPackagePackage.eNS_URI);

        // Obtain or create and register package
        MyPackagePackageImpl theMyPackagePackage = (MyPackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof MyPackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new MyPackagePackageImpl());

        isInited = true;

        // Create package meta-data objects
        theMyPackagePackage.createPackageContents();

        // Initialize created meta-data
        theMyPackagePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theMyPackagePackage.freeze();

        return theMyPackagePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMyClass() {
        return myClassEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMyClass_MyEnumAttribute() {
        return (EAttribute)myClassEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMyClass_MyIntAttribute() {
        return (EAttribute)myClassEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getMyEnum() {
        return myEnumEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MyPackageFactory getMyPackageFactory() {
        return (MyPackageFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        myClassEClass = createEClass(MY_CLASS);
        createEAttribute(myClassEClass, MY_CLASS__MY_ENUM_ATTRIBUTE);
        createEAttribute(myClassEClass, MY_CLASS__MY_INT_ATTRIBUTE);

        // Create enums
        myEnumEEnum = createEEnum(MY_ENUM);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(myClassEClass, MyClass.class, "MyClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMyClass_MyEnumAttribute(), this.getMyEnum(), "MyEnumAttribute", "0", 0, 1, MyClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMyClass_MyIntAttribute(), ecorePackage.getEInt(), "MyIntAttribute", "-1", 0, 1, MyClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(myEnumEEnum, MyEnum.class, "MyEnum");
        addEEnumLiteral(myEnumEEnum, MyEnum.MY_ENUM_LITERAL1);
        addEEnumLiteral(myEnumEEnum, MyEnum.MY_ENUM_LITERAL2);
        addEEnumLiteral(myEnumEEnum, MyEnum.MY_ENUM_LITERAL3);

        // Create resource
        createResource(eNS_URI);
    }

} //MyPackagePackageImpl
