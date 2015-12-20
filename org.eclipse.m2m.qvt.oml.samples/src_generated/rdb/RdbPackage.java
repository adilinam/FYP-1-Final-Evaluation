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
package rdb;

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
 * @see rdb.RdbFactory
 * @model kind="package"
 * @generated
 */
public interface RdbPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNAME = "rdb"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_URI = "http://www.eclipse.org/qvt/1.0.0/Operational/examples/rdb"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_PREFIX = "rdb"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    RdbPackage eINSTANCE = rdb.impl.RdbPackageImpl.init();

	/**
	 * The meta object id for the '{@link rdb.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.impl.ElementImpl
	 * @see rdb.impl.RdbPackageImpl#getElement()
	 * @generated
	 */
    int ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ELEMENT__PARENT = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link rdb.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.impl.NamedElementImpl
	 * @see rdb.impl.RdbPackageImpl#getNamedElement()
	 * @generated
	 */
    int NAMED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int NAMED_ELEMENT__PARENT = ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int NAMED_ELEMENT__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int NAMED_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link rdb.impl.SchemaElementImpl <em>Schema Element</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.impl.SchemaElementImpl
	 * @see rdb.impl.RdbPackageImpl#getSchemaElement()
	 * @generated
	 */
    int SCHEMA_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SCHEMA_ELEMENT__PARENT = NAMED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SCHEMA_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SCHEMA_ELEMENT__OWNER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Schema Element</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SCHEMA_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link rdb.impl.NamedColumnSetImpl <em>Named Column Set</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.impl.NamedColumnSetImpl
	 * @see rdb.impl.RdbPackageImpl#getNamedColumnSet()
	 * @generated
	 */
    int NAMED_COLUMN_SET = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int NAMED_COLUMN_SET__PARENT = SCHEMA_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int NAMED_COLUMN_SET__NAME = SCHEMA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int NAMED_COLUMN_SET__OWNER = SCHEMA_ELEMENT__OWNER;

	/**
	 * The number of structural features of the '<em>Named Column Set</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int NAMED_COLUMN_SET_FEATURE_COUNT = SCHEMA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link rdb.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.impl.ModelImpl
	 * @see rdb.impl.RdbPackageImpl#getModel()
	 * @generated
	 */
    int MODEL = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL__PARENT = NAMED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Schemas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL__SCHEMAS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Server id</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL__SERVER_ID = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link rdb.impl.SchemaImpl <em>Schema</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.impl.SchemaImpl
	 * @see rdb.impl.RdbPackageImpl#getSchema()
	 * @generated
	 */
    int SCHEMA = 4;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SCHEMA__PARENT = NAMED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SCHEMA__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SCHEMA__ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Schema</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SCHEMA_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link rdb.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.impl.TableImpl
	 * @see rdb.impl.RdbPackageImpl#getTable()
	 * @generated
	 */
    int TABLE = 6;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE__PARENT = NAMED_COLUMN_SET__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE__NAME = NAMED_COLUMN_SET__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE__OWNER = NAMED_COLUMN_SET__OWNER;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE__COLUMNS = NAMED_COLUMN_SET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Primary Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE__PRIMARY_KEY = NAMED_COLUMN_SET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unique Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE__UNIQUE_CONSTRAINTS = NAMED_COLUMN_SET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Foreign Keys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE__FOREIGN_KEYS = NAMED_COLUMN_SET_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Indices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE__INDICES = NAMED_COLUMN_SET_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Checks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE__CHECKS = NAMED_COLUMN_SET_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE_FEATURE_COUNT = NAMED_COLUMN_SET_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link rdb.impl.ColumnImpl <em>Column</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.impl.ColumnImpl
	 * @see rdb.impl.RdbPackageImpl#getColumn()
	 * @generated
	 */
    int COLUMN = 7;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int COLUMN__PARENT = NAMED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int COLUMN__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int COLUMN_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link rdb.impl.TableColumnImpl <em>Table Column</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see rdb.impl.TableColumnImpl
	 * @see rdb.impl.RdbPackageImpl#getTableColumn()
	 * @generated
	 */
    int TABLE_COLUMN = 8;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE_COLUMN__PARENT = COLUMN__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE_COLUMN__NAME = COLUMN__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE_COLUMN__DOMAIN = COLUMN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE_COLUMN__TYPE = COLUMN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE_COLUMN__IS_PRIMARY_KEY = COLUMN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Foreign Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE_COLUMN__IS_FOREIGN_KEY = COLUMN_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Table Column</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TABLE_COLUMN_FEATURE_COUNT = COLUMN_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link rdb.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see rdb.Element
	 * @generated
	 */
    EClass getElement();

	/**
	 * Returns the meta object for the reference '{@link rdb.Element#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see rdb.Element#getParent()
	 * @see #getElement()
	 * @generated
	 */
    EReference getElement_Parent();

	/**
	 * Returns the meta object for class '{@link rdb.NamedColumnSet <em>Named Column Set</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Column Set</em>'.
	 * @see rdb.NamedColumnSet
	 * @generated
	 */
    EClass getNamedColumnSet();

	/**
	 * Returns the meta object for class '{@link rdb.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see rdb.NamedElement
	 * @generated
	 */
    EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link rdb.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see rdb.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
    EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link rdb.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see rdb.Model
	 * @generated
	 */
    EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link rdb.Model#getSchemas <em>Schemas</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Schemas</em>'.
	 * @see rdb.Model#getSchemas()
	 * @see #getModel()
	 * @generated
	 */
    EReference getModel_Schemas();

	/**
	 * Returns the meta object for the attribute '{@link rdb.Model#getServer_id <em>Server id</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server id</em>'.
	 * @see rdb.Model#getServer_id()
	 * @see #getModel()
	 * @generated
	 */
    EAttribute getModel_Server_id();

	/**
	 * Returns the meta object for class '{@link rdb.Schema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schema</em>'.
	 * @see rdb.Schema
	 * @generated
	 */
    EClass getSchema();

	/**
	 * Returns the meta object for the containment reference list '{@link rdb.Schema#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see rdb.Schema#getElements()
	 * @see #getSchema()
	 * @generated
	 */
    EReference getSchema_Elements();

	/**
	 * Returns the meta object for class '{@link rdb.SchemaElement <em>Schema Element</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schema Element</em>'.
	 * @see rdb.SchemaElement
	 * @generated
	 */
    EClass getSchemaElement();

	/**
	 * Returns the meta object for the attribute '{@link rdb.SchemaElement#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see rdb.SchemaElement#getOwner()
	 * @see #getSchemaElement()
	 * @generated
	 */
    EAttribute getSchemaElement_Owner();

	/**
	 * Returns the meta object for class '{@link rdb.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see rdb.Table
	 * @generated
	 */
    EClass getTable();

	/**
	 * Returns the meta object for the containment reference list '{@link rdb.Table#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see rdb.Table#getColumns()
	 * @see #getTable()
	 * @generated
	 */
    EReference getTable_Columns();

	/**
	 * Returns the meta object for the containment reference '{@link rdb.Table#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Primary Key</em>'.
	 * @see rdb.Table#getPrimaryKey()
	 * @see #getTable()
	 * @generated
	 */
    EReference getTable_PrimaryKey();

	/**
	 * Returns the meta object for the containment reference list '{@link rdb.Table#getUniqueConstraints <em>Unique Constraints</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unique Constraints</em>'.
	 * @see rdb.Table#getUniqueConstraints()
	 * @see #getTable()
	 * @generated
	 */
    EReference getTable_UniqueConstraints();

	/**
	 * Returns the meta object for the containment reference list '{@link rdb.Table#getForeignKeys <em>Foreign Keys</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Foreign Keys</em>'.
	 * @see rdb.Table#getForeignKeys()
	 * @see #getTable()
	 * @generated
	 */
    EReference getTable_ForeignKeys();

	/**
	 * Returns the meta object for the containment reference list '{@link rdb.Table#getIndices <em>Indices</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Indices</em>'.
	 * @see rdb.Table#getIndices()
	 * @see #getTable()
	 * @generated
	 */
    EReference getTable_Indices();

	/**
	 * Returns the meta object for the containment reference list '{@link rdb.Table#getChecks <em>Checks</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Checks</em>'.
	 * @see rdb.Table#getChecks()
	 * @see #getTable()
	 * @generated
	 */
    EReference getTable_Checks();

	/**
	 * Returns the meta object for class '{@link rdb.Column <em>Column</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column</em>'.
	 * @see rdb.Column
	 * @generated
	 */
    EClass getColumn();

	/**
	 * Returns the meta object for class '{@link rdb.TableColumn <em>Table Column</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Column</em>'.
	 * @see rdb.TableColumn
	 * @generated
	 */
    EClass getTableColumn();

	/**
	 * Returns the meta object for the reference '{@link rdb.TableColumn#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain</em>'.
	 * @see rdb.TableColumn#getDomain()
	 * @see #getTableColumn()
	 * @generated
	 */
    EReference getTableColumn_Domain();

	/**
	 * Returns the meta object for the containment reference '{@link rdb.TableColumn#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see rdb.TableColumn#getType()
	 * @see #getTableColumn()
	 * @generated
	 */
    EReference getTableColumn_Type();

	/**
	 * Returns the meta object for the attribute '{@link rdb.TableColumn#getIsPrimaryKey <em>Is Primary Key</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Primary Key</em>'.
	 * @see rdb.TableColumn#getIsPrimaryKey()
	 * @see #getTableColumn()
	 * @generated
	 */
    EAttribute getTableColumn_IsPrimaryKey();

	/**
	 * Returns the meta object for the attribute '{@link rdb.TableColumn#getIsForeignKey <em>Is Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Foreign Key</em>'.
	 * @see rdb.TableColumn#getIsForeignKey()
	 * @see #getTableColumn()
	 * @generated
	 */
    EAttribute getTableColumn_IsForeignKey();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
    RdbFactory getRdbFactory();

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
		 * The meta object literal for the '{@link rdb.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.impl.ElementImpl
		 * @see rdb.impl.RdbPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__PARENT = eINSTANCE.getElement_Parent();

		/**
		 * The meta object literal for the '{@link rdb.impl.NamedColumnSetImpl <em>Named Column Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.impl.NamedColumnSetImpl
		 * @see rdb.impl.RdbPackageImpl#getNamedColumnSet()
		 * @generated
		 */
		EClass NAMED_COLUMN_SET = eINSTANCE.getNamedColumnSet();

		/**
		 * The meta object literal for the '{@link rdb.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.impl.NamedElementImpl
		 * @see rdb.impl.RdbPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link rdb.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.impl.ModelImpl
		 * @see rdb.impl.RdbPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Schemas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__SCHEMAS = eINSTANCE.getModel_Schemas();

		/**
		 * The meta object literal for the '<em><b>Server id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__SERVER_ID = eINSTANCE.getModel_Server_id();

		/**
		 * The meta object literal for the '{@link rdb.impl.SchemaImpl <em>Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.impl.SchemaImpl
		 * @see rdb.impl.RdbPackageImpl#getSchema()
		 * @generated
		 */
		EClass SCHEMA = eINSTANCE.getSchema();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEMA__ELEMENTS = eINSTANCE.getSchema_Elements();

		/**
		 * The meta object literal for the '{@link rdb.impl.SchemaElementImpl <em>Schema Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.impl.SchemaElementImpl
		 * @see rdb.impl.RdbPackageImpl#getSchemaElement()
		 * @generated
		 */
		EClass SCHEMA_ELEMENT = eINSTANCE.getSchemaElement();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEMA_ELEMENT__OWNER = eINSTANCE.getSchemaElement_Owner();

		/**
		 * The meta object literal for the '{@link rdb.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.impl.TableImpl
		 * @see rdb.impl.RdbPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__COLUMNS = eINSTANCE.getTable_Columns();

		/**
		 * The meta object literal for the '<em><b>Primary Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__PRIMARY_KEY = eINSTANCE.getTable_PrimaryKey();

		/**
		 * The meta object literal for the '<em><b>Unique Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__UNIQUE_CONSTRAINTS = eINSTANCE.getTable_UniqueConstraints();

		/**
		 * The meta object literal for the '<em><b>Foreign Keys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__FOREIGN_KEYS = eINSTANCE.getTable_ForeignKeys();

		/**
		 * The meta object literal for the '<em><b>Indices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__INDICES = eINSTANCE.getTable_Indices();

		/**
		 * The meta object literal for the '<em><b>Checks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__CHECKS = eINSTANCE.getTable_Checks();

		/**
		 * The meta object literal for the '{@link rdb.impl.ColumnImpl <em>Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.impl.ColumnImpl
		 * @see rdb.impl.RdbPackageImpl#getColumn()
		 * @generated
		 */
		EClass COLUMN = eINSTANCE.getColumn();

		/**
		 * The meta object literal for the '{@link rdb.impl.TableColumnImpl <em>Table Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rdb.impl.TableColumnImpl
		 * @see rdb.impl.RdbPackageImpl#getTableColumn()
		 * @generated
		 */
		EClass TABLE_COLUMN = eINSTANCE.getTableColumn();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_COLUMN__DOMAIN = eINSTANCE.getTableColumn_Domain();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_COLUMN__TYPE = eINSTANCE.getTableColumn_Type();

		/**
		 * The meta object literal for the '<em><b>Is Primary Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_COLUMN__IS_PRIMARY_KEY = eINSTANCE.getTableColumn_IsPrimaryKey();

		/**
		 * The meta object literal for the '<em><b>Is Foreign Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_COLUMN__IS_FOREIGN_KEY = eINSTANCE.getTableColumn_IsForeignKey();

	}

} //RdbPackage
