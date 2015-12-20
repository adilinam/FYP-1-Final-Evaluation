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
package rdb.view;

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
 * @see rdb.view.ViewFactory
 * @model kind="package"
 * @generated
 */
public interface ViewPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNAME = "view"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_URI = "http://www.eclipse.org/qvt/1.0.0/Operational/examples/rdb/view"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_PREFIX = "view"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    ViewPackage eINSTANCE = rdb.view.impl.ViewPackageImpl.init();

	/**
	 * The meta object id for the '{@link rdb.view.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.view.impl.ViewImpl
	 * @see rdb.view.impl.ViewPackageImpl#getView()
	 * @generated
	 */
    int VIEW = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW__PARENT = RdbPackage.NAMED_COLUMN_SET__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW__NAME = RdbPackage.NAMED_COLUMN_SET__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW__OWNER = RdbPackage.NAMED_COLUMN_SET__OWNER;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW__COLUMNS = RdbPackage.NAMED_COLUMN_SET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Tables And Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW__REFERENCED_TABLES_AND_VIEWS = RdbPackage.NAMED_COLUMN_SET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ddl</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW__DDL = RdbPackage.NAMED_COLUMN_SET_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW_FEATURE_COUNT = RdbPackage.NAMED_COLUMN_SET_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link rdb.view.impl.ViewAliasImpl <em>Alias</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.view.impl.ViewAliasImpl
	 * @see rdb.view.impl.ViewPackageImpl#getViewAlias()
	 * @generated
	 */
    int VIEW_ALIAS = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW_ALIAS__PARENT = RdbPackage.NAMED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW_ALIAS__NAME = RdbPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Referenced Table Or View</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW = RdbPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Alias</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW_ALIAS_FEATURE_COUNT = RdbPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link rdb.view.impl.ViewColumnImpl <em>Column</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.view.impl.ViewColumnImpl
	 * @see rdb.view.impl.ViewPackageImpl#getViewColumn()
	 * @generated
	 */
    int VIEW_COLUMN = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW_COLUMN__PARENT = RdbPackage.COLUMN__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW_COLUMN__NAME = RdbPackage.COLUMN__NAME;

	/**
	 * The number of structural features of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW_COLUMN_FEATURE_COUNT = RdbPackage.COLUMN_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link rdb.view.impl.ViewExpressionColumnImpl <em>Expression Column</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.view.impl.ViewExpressionColumnImpl
	 * @see rdb.view.impl.ViewPackageImpl#getViewExpressionColumn()
	 * @generated
	 */
    int VIEW_EXPRESSION_COLUMN = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW_EXPRESSION_COLUMN__PARENT = VIEW_COLUMN__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW_EXPRESSION_COLUMN__NAME = VIEW_COLUMN__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW_EXPRESSION_COLUMN__EXPRESSION = VIEW_COLUMN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Column</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int VIEW_EXPRESSION_COLUMN_FEATURE_COUNT = VIEW_COLUMN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link rdb.view.impl.ReferencedViewColumnImpl <em>Referenced View Column</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.view.impl.ReferencedViewColumnImpl
	 * @see rdb.view.impl.ViewPackageImpl#getReferencedViewColumn()
	 * @generated
	 */
    int REFERENCED_VIEW_COLUMN = 4;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int REFERENCED_VIEW_COLUMN__PARENT = VIEW_COLUMN__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int REFERENCED_VIEW_COLUMN__NAME = VIEW_COLUMN__NAME;

	/**
	 * The feature id for the '<em><b>Ref Column</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int REFERENCED_VIEW_COLUMN__REF_COLUMN = VIEW_COLUMN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Referenced View Column</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int REFERENCED_VIEW_COLUMN_FEATURE_COUNT = VIEW_COLUMN_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link rdb.view.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see rdb.view.View
	 * @generated
	 */
    EClass getView();

	/**
	 * Returns the meta object for the containment reference list '{@link rdb.view.View#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see rdb.view.View#getColumns()
	 * @see #getView()
	 * @generated
	 */
    EReference getView_Columns();

	/**
	 * Returns the meta object for the containment reference list '{@link rdb.view.View#getReferencedTablesAndViews <em>Referenced Tables And Views</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Referenced Tables And Views</em>'.
	 * @see rdb.view.View#getReferencedTablesAndViews()
	 * @see #getView()
	 * @generated
	 */
    EReference getView_ReferencedTablesAndViews();

	/**
	 * Returns the meta object for the attribute '{@link rdb.view.View#getDdl <em>Ddl</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ddl</em>'.
	 * @see rdb.view.View#getDdl()
	 * @see #getView()
	 * @generated
	 */
    EAttribute getView_Ddl();

	/**
	 * Returns the meta object for class '{@link rdb.view.ViewAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alias</em>'.
	 * @see rdb.view.ViewAlias
	 * @generated
	 */
    EClass getViewAlias();

	/**
	 * Returns the meta object for the reference '{@link rdb.view.ViewAlias#getReferencedTableOrView <em>Referenced Table Or View</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Table Or View</em>'.
	 * @see rdb.view.ViewAlias#getReferencedTableOrView()
	 * @see #getViewAlias()
	 * @generated
	 */
    EReference getViewAlias_ReferencedTableOrView();

	/**
	 * Returns the meta object for class '{@link rdb.view.ViewColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column</em>'.
	 * @see rdb.view.ViewColumn
	 * @generated
	 */
    EClass getViewColumn();

	/**
	 * Returns the meta object for class '{@link rdb.view.ViewExpressionColumn <em>Expression Column</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Column</em>'.
	 * @see rdb.view.ViewExpressionColumn
	 * @generated
	 */
    EClass getViewExpressionColumn();

	/**
	 * Returns the meta object for the attribute '{@link rdb.view.ViewExpressionColumn#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see rdb.view.ViewExpressionColumn#getExpression()
	 * @see #getViewExpressionColumn()
	 * @generated
	 */
    EAttribute getViewExpressionColumn_Expression();

	/**
	 * Returns the meta object for class '{@link rdb.view.ReferencedViewColumn <em>Referenced View Column</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referenced View Column</em>'.
	 * @see rdb.view.ReferencedViewColumn
	 * @generated
	 */
    EClass getReferencedViewColumn();

	/**
	 * Returns the meta object for the reference '{@link rdb.view.ReferencedViewColumn#getRefColumn <em>Ref Column</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Column</em>'.
	 * @see rdb.view.ReferencedViewColumn#getRefColumn()
	 * @see #getReferencedViewColumn()
	 * @generated
	 */
    EReference getReferencedViewColumn_RefColumn();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
    ViewFactory getViewFactory();

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
		 * The meta object literal for the '{@link rdb.view.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.view.impl.ViewImpl
		 * @see rdb.view.impl.ViewPackageImpl#getView()
		 * @generated
		 */
		EClass VIEW = eINSTANCE.getView();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__COLUMNS = eINSTANCE.getView_Columns();

		/**
		 * The meta object literal for the '<em><b>Referenced Tables And Views</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__REFERENCED_TABLES_AND_VIEWS = eINSTANCE.getView_ReferencedTablesAndViews();

		/**
		 * The meta object literal for the '<em><b>Ddl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__DDL = eINSTANCE.getView_Ddl();

		/**
		 * The meta object literal for the '{@link rdb.view.impl.ViewAliasImpl <em>Alias</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.view.impl.ViewAliasImpl
		 * @see rdb.view.impl.ViewPackageImpl#getViewAlias()
		 * @generated
		 */
		EClass VIEW_ALIAS = eINSTANCE.getViewAlias();

		/**
		 * The meta object literal for the '<em><b>Referenced Table Or View</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW = eINSTANCE.getViewAlias_ReferencedTableOrView();

		/**
		 * The meta object literal for the '{@link rdb.view.impl.ViewColumnImpl <em>Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.view.impl.ViewColumnImpl
		 * @see rdb.view.impl.ViewPackageImpl#getViewColumn()
		 * @generated
		 */
		EClass VIEW_COLUMN = eINSTANCE.getViewColumn();

		/**
		 * The meta object literal for the '{@link rdb.view.impl.ViewExpressionColumnImpl <em>Expression Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.view.impl.ViewExpressionColumnImpl
		 * @see rdb.view.impl.ViewPackageImpl#getViewExpressionColumn()
		 * @generated
		 */
		EClass VIEW_EXPRESSION_COLUMN = eINSTANCE.getViewExpressionColumn();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_EXPRESSION_COLUMN__EXPRESSION = eINSTANCE.getViewExpressionColumn_Expression();

		/**
		 * The meta object literal for the '{@link rdb.view.impl.ReferencedViewColumnImpl <em>Referenced View Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.view.impl.ReferencedViewColumnImpl
		 * @see rdb.view.impl.ViewPackageImpl#getReferencedViewColumn()
		 * @generated
		 */
		EClass REFERENCED_VIEW_COLUMN = eINSTANCE.getReferencedViewColumn();

		/**
		 * The meta object literal for the '<em><b>Ref Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCED_VIEW_COLUMN__REF_COLUMN = eINSTANCE.getReferencedViewColumn_RefColumn();

	}

} //ViewPackage
