/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package rdb.datatypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import rdb.RdbPackage;

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
 * @see rdb.datatypes.DatatypesFactory
 * @model kind="package"
 * @generated
 */
public interface DatatypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNAME = "datatypes"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_URI = "http://www.eclipse.org/qvt/1.0.0/Operational/examples/rdb/datatypes"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_PREFIX = "datatypes"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    DatatypesPackage eINSTANCE = rdb.datatypes.impl.DatatypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link rdb.datatypes.impl.DomainImpl <em>Domain</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.datatypes.impl.DomainImpl
	 * @see rdb.datatypes.impl.DatatypesPackageImpl#getDomain()
	 * @generated
	 */
    int DOMAIN = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOMAIN__PARENT = RdbPackage.SCHEMA_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOMAIN__NAME = RdbPackage.SCHEMA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOMAIN__OWNER = RdbPackage.SCHEMA_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOMAIN__SIZE = RdbPackage.SCHEMA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Decimal Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOMAIN__DECIMAL_DIGITS = RdbPackage.SCHEMA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOMAIN__NULLABLE = RdbPackage.SCHEMA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOMAIN__DEFAULT = RdbPackage.SCHEMA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOMAIN__CHECK = RdbPackage.SCHEMA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOMAIN__VAR = RdbPackage.SCHEMA_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOMAIN__TYPE = RdbPackage.SCHEMA_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Parent Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOMAIN__PARENT_DOMAIN = RdbPackage.SCHEMA_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOMAIN_FEATURE_COUNT = RdbPackage.SCHEMA_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link rdb.datatypes.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.datatypes.impl.DataTypeImpl
	 * @see rdb.datatypes.impl.DatatypesPackageImpl#getDataType()
	 * @generated
	 */
    int DATA_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE__PARENT = RdbPackage.NAMED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE__NAME = RdbPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE__SIZE = RdbPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Decimal Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE__DECIMAL_DIGITS = RdbPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE__NULLABLE = RdbPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE__DEFAULT = RdbPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE__CHECK = RdbPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE__VAR = RdbPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE_FEATURE_COUNT = RdbPackage.NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link rdb.datatypes.impl.PrimitiveDataTypeImpl <em>Primitive Data Type</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.datatypes.impl.PrimitiveDataTypeImpl
	 * @see rdb.datatypes.impl.DatatypesPackageImpl#getPrimitiveDataType()
	 * @generated
	 */
    int PRIMITIVE_DATA_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_DATA_TYPE__PARENT = DATA_TYPE__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_DATA_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_DATA_TYPE__SIZE = DATA_TYPE__SIZE;

	/**
	 * The feature id for the '<em><b>Decimal Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_DATA_TYPE__DECIMAL_DIGITS = DATA_TYPE__DECIMAL_DIGITS;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_DATA_TYPE__NULLABLE = DATA_TYPE__NULLABLE;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_DATA_TYPE__DEFAULT = DATA_TYPE__DEFAULT;

	/**
	 * The feature id for the '<em><b>Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_DATA_TYPE__CHECK = DATA_TYPE__CHECK;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_DATA_TYPE__VAR = DATA_TYPE__VAR;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_DATA_TYPE__TYPE = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Data Type</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_DATA_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link rdb.datatypes.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain</em>'.
	 * @see rdb.datatypes.Domain
	 * @generated
	 */
    EClass getDomain();

	/**
	 * Returns the meta object for the reference '{@link rdb.datatypes.Domain#getParentDomain <em>Parent Domain</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Domain</em>'.
	 * @see rdb.datatypes.Domain#getParentDomain()
	 * @see #getDomain()
	 * @generated
	 */
    EReference getDomain_ParentDomain();

	/**
	 * Returns the meta object for class '{@link rdb.datatypes.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see rdb.datatypes.DataType
	 * @generated
	 */
    EClass getDataType();

	/**
	 * Returns the meta object for the attribute '{@link rdb.datatypes.DataType#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see rdb.datatypes.DataType#getSize()
	 * @see #getDataType()
	 * @generated
	 */
    EAttribute getDataType_Size();

	/**
	 * Returns the meta object for the attribute '{@link rdb.datatypes.DataType#getDecimalDigits <em>Decimal Digits</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decimal Digits</em>'.
	 * @see rdb.datatypes.DataType#getDecimalDigits()
	 * @see #getDataType()
	 * @generated
	 */
    EAttribute getDataType_DecimalDigits();

	/**
	 * Returns the meta object for the attribute '{@link rdb.datatypes.DataType#isNullable <em>Nullable</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nullable</em>'.
	 * @see rdb.datatypes.DataType#isNullable()
	 * @see #getDataType()
	 * @generated
	 */
    EAttribute getDataType_Nullable();

	/**
	 * Returns the meta object for the attribute '{@link rdb.datatypes.DataType#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see rdb.datatypes.DataType#getDefault()
	 * @see #getDataType()
	 * @generated
	 */
    EAttribute getDataType_Default();

	/**
	 * Returns the meta object for the attribute '{@link rdb.datatypes.DataType#getCheck <em>Check</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Check</em>'.
	 * @see rdb.datatypes.DataType#getCheck()
	 * @see #getDataType()
	 * @generated
	 */
    EAttribute getDataType_Check();

	/**
	 * Returns the meta object for the attribute '{@link rdb.datatypes.DataType#getVar <em>Var</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var</em>'.
	 * @see rdb.datatypes.DataType#getVar()
	 * @see #getDataType()
	 * @generated
	 */
    EAttribute getDataType_Var();

	/**
	 * Returns the meta object for class '{@link rdb.datatypes.PrimitiveDataType <em>Primitive Data Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Data Type</em>'.
	 * @see rdb.datatypes.PrimitiveDataType
	 * @generated
	 */
    EClass getPrimitiveDataType();

	/**
	 * Returns the meta object for the attribute '{@link rdb.datatypes.PrimitiveDataType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see rdb.datatypes.PrimitiveDataType#getType()
	 * @see #getPrimitiveDataType()
	 * @generated
	 */
    EAttribute getPrimitiveDataType_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
    DatatypesFactory getDatatypesFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link rdb.datatypes.impl.DomainImpl <em>Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.datatypes.impl.DomainImpl
		 * @see rdb.datatypes.impl.DatatypesPackageImpl#getDomain()
		 * @generated
		 */
		EClass DOMAIN = eINSTANCE.getDomain();

		/**
		 * The meta object literal for the '<em><b>Parent Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN__PARENT_DOMAIN = eINSTANCE.getDomain_ParentDomain();

		/**
		 * The meta object literal for the '{@link rdb.datatypes.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.datatypes.impl.DataTypeImpl
		 * @see rdb.datatypes.impl.DatatypesPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__SIZE = eINSTANCE.getDataType_Size();

		/**
		 * The meta object literal for the '<em><b>Decimal Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__DECIMAL_DIGITS = eINSTANCE.getDataType_DecimalDigits();

		/**
		 * The meta object literal for the '<em><b>Nullable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__NULLABLE = eINSTANCE.getDataType_Nullable();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__DEFAULT = eINSTANCE.getDataType_Default();

		/**
		 * The meta object literal for the '<em><b>Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__CHECK = eINSTANCE.getDataType_Check();

		/**
		 * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__VAR = eINSTANCE.getDataType_Var();

		/**
		 * The meta object literal for the '{@link rdb.datatypes.impl.PrimitiveDataTypeImpl <em>Primitive Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.datatypes.impl.PrimitiveDataTypeImpl
		 * @see rdb.datatypes.impl.DatatypesPackageImpl#getPrimitiveDataType()
		 * @generated
		 */
		EClass PRIMITIVE_DATA_TYPE = eINSTANCE.getPrimitiveDataType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_DATA_TYPE__TYPE = eINSTANCE.getPrimitiveDataType_Type();

	}

} //DatatypesPackage
