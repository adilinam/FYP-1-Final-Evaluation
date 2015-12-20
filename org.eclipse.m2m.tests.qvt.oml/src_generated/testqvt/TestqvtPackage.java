/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package testqvt;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see testqvt.TestqvtFactory
 * @model kind="package"
 * @generated
 */
public interface TestqvtPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testqvt";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/m2m/qvt/oml/testqvt";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testqvt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestqvtPackage eINSTANCE = testqvt.impl.TestqvtPackageImpl.init();

	/**
	 * The meta object id for the '{@link testqvt.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testqvt.impl.ElementImpl
	 * @see testqvt.impl.TestqvtPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link testqvt.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testqvt.impl.ModelImpl
	 * @see testqvt.impl.TestqvtPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ELEMENTS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link testqvt.impl.BooleanElementImpl <em>Boolean Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testqvt.impl.BooleanElementImpl
	 * @see testqvt.impl.TestqvtPackageImpl#getBooleanElement()
	 * @generated
	 */
	int BOOLEAN_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ELEMENT__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Small Boolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ELEMENT__IS_SMALL_BOOLEAN = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Small Boolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ELEMENT__SMALL_BOOLEAN = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Large Boolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ELEMENT__IS_LARGE_BOOLEAN = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Large Boolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ELEMENT__LARGE_BOOLEAN = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Boolean Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;


	/**
	 * The meta object id for the '{@link testqvt.impl.NumbersImpl <em>Numbers</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testqvt.impl.NumbersImpl
	 * @see testqvt.impl.TestqvtPackageImpl#getNumbers()
	 * @generated
	 */
	int NUMBERS = 3;

	/**
	 * The feature id for the '<em><b>Big Integer100</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBERS__BIG_INTEGER100 = 0;

	/**
	 * The feature id for the '<em><b>Big Decimal100</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBERS__BIG_DECIMAL100 = 1;

	/**
	 * The number of structural features of the '<em>Numbers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBERS_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link testqvt.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see testqvt.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link testqvt.Model#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see testqvt.Model#getElements()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Elements();

	/**
	 * Returns the meta object for class '{@link testqvt.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see testqvt.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link testqvt.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see testqvt.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for class '{@link testqvt.BooleanElement <em>Boolean Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Element</em>'.
	 * @see testqvt.BooleanElement
	 * @generated
	 */
	EClass getBooleanElement();

	/**
	 * Returns the meta object for the attribute '{@link testqvt.BooleanElement#isIsSmallBoolean <em>Is Small Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Small Boolean</em>'.
	 * @see testqvt.BooleanElement#isIsSmallBoolean()
	 * @see #getBooleanElement()
	 * @generated
	 */
	EAttribute getBooleanElement_IsSmallBoolean();

	/**
	 * Returns the meta object for the attribute '{@link testqvt.BooleanElement#isSmallBoolean <em>Small Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Small Boolean</em>'.
	 * @see testqvt.BooleanElement#isSmallBoolean()
	 * @see #getBooleanElement()
	 * @generated
	 */
	EAttribute getBooleanElement_SmallBoolean();

	/**
	 * Returns the meta object for the attribute '{@link testqvt.BooleanElement#getIsLargeBoolean <em>Is Large Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Large Boolean</em>'.
	 * @see testqvt.BooleanElement#getIsLargeBoolean()
	 * @see #getBooleanElement()
	 * @generated
	 */
	EAttribute getBooleanElement_IsLargeBoolean();

	/**
	 * Returns the meta object for the attribute '{@link testqvt.BooleanElement#getLargeBoolean <em>Large Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Large Boolean</em>'.
	 * @see testqvt.BooleanElement#getLargeBoolean()
	 * @see #getBooleanElement()
	 * @generated
	 */
	EAttribute getBooleanElement_LargeBoolean();

	/**
	 * Returns the meta object for class '{@link testqvt.Numbers <em>Numbers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numbers</em>'.
	 * @see testqvt.Numbers
	 * @generated
	 */
	EClass getNumbers();

	/**
	 * Returns the meta object for the attribute '{@link testqvt.Numbers#getBigInteger100 <em>Big Integer100</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Big Integer100</em>'.
	 * @see testqvt.Numbers#getBigInteger100()
	 * @see #getNumbers()
	 * @generated
	 */
	EAttribute getNumbers_BigInteger100();

	/**
	 * Returns the meta object for the attribute '{@link testqvt.Numbers#getBigDecimal100 <em>Big Decimal100</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Big Decimal100</em>'.
	 * @see testqvt.Numbers#getBigDecimal100()
	 * @see #getNumbers()
	 * @generated
	 */
	EAttribute getNumbers_BigDecimal100();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestqvtFactory getTestqvtFactory();

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
		 * The meta object literal for the '{@link testqvt.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testqvt.impl.ModelImpl
		 * @see testqvt.impl.TestqvtPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ELEMENTS = eINSTANCE.getModel_Elements();

		/**
		 * The meta object literal for the '{@link testqvt.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testqvt.impl.ElementImpl
		 * @see testqvt.impl.TestqvtPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

		/**
		 * The meta object literal for the '{@link testqvt.impl.BooleanElementImpl <em>Boolean Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testqvt.impl.BooleanElementImpl
		 * @see testqvt.impl.TestqvtPackageImpl#getBooleanElement()
		 * @generated
		 */
		EClass BOOLEAN_ELEMENT = eINSTANCE.getBooleanElement();

		/**
		 * The meta object literal for the '<em><b>Is Small Boolean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_ELEMENT__IS_SMALL_BOOLEAN = eINSTANCE.getBooleanElement_IsSmallBoolean();

		/**
		 * The meta object literal for the '<em><b>Small Boolean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_ELEMENT__SMALL_BOOLEAN = eINSTANCE.getBooleanElement_SmallBoolean();

		/**
		 * The meta object literal for the '<em><b>Is Large Boolean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_ELEMENT__IS_LARGE_BOOLEAN = eINSTANCE.getBooleanElement_IsLargeBoolean();

		/**
		 * The meta object literal for the '<em><b>Large Boolean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_ELEMENT__LARGE_BOOLEAN = eINSTANCE.getBooleanElement_LargeBoolean();

		/**
		 * The meta object literal for the '{@link testqvt.impl.NumbersImpl <em>Numbers</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testqvt.impl.NumbersImpl
		 * @see testqvt.impl.TestqvtPackageImpl#getNumbers()
		 * @generated
		 */
		EClass NUMBERS = eINSTANCE.getNumbers();

		/**
		 * The meta object literal for the '<em><b>Big Integer100</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBERS__BIG_INTEGER100 = eINSTANCE.getNumbers_BigInteger100();

		/**
		 * The meta object literal for the '<em><b>Big Decimal100</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBERS__BIG_DECIMAL100 = eINSTANCE.getNumbers_BigDecimal100();

	}

} //TestqvtPackage
