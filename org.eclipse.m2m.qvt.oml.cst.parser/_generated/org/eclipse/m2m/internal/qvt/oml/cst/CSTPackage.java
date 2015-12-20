/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 * 
 * 
 *
 * $Id: CSTPackage.java,v 1.30 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory
 * @model kind="package"
 * @generated
 */
public interface CSTPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cst"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/QVT2/1.0.0/Operational/cst"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtoperational.cst"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CSTPackage eINSTANCE = org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingModuleCSImpl <em>Mapping Module CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingModuleCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingModuleCS()
	 * @generated
	 */
	int MAPPING_MODULE_CS = 0;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Header CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__HEADER_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__IMPORTS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Metamodels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__METAMODELS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Renamings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__RENAMINGS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__PROPERTIES = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__METHODS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Classifier Def CS</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__CLASSIFIER_DEF_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__TAGS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Mapping Module CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.LibraryCSImpl <em>Library CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.LibraryCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getLibraryCS()
	 * @generated
	 */
	int LIBRARY_CS = 1;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__START_OFFSET = MAPPING_MODULE_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__END_OFFSET = MAPPING_MODULE_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__START_TOKEN = MAPPING_MODULE_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__END_TOKEN = MAPPING_MODULE_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__AST = MAPPING_MODULE_CS__AST;

	/**
	 * The feature id for the '<em><b>Header CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__HEADER_CS = MAPPING_MODULE_CS__HEADER_CS;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__IMPORTS = MAPPING_MODULE_CS__IMPORTS;

	/**
	 * The feature id for the '<em><b>Metamodels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__METAMODELS = MAPPING_MODULE_CS__METAMODELS;

	/**
	 * The feature id for the '<em><b>Renamings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__RENAMINGS = MAPPING_MODULE_CS__RENAMINGS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__PROPERTIES = MAPPING_MODULE_CS__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__METHODS = MAPPING_MODULE_CS__METHODS;

	/**
	 * The feature id for the '<em><b>Classifier Def CS</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__CLASSIFIER_DEF_CS = MAPPING_MODULE_CS__CLASSIFIER_DEF_CS;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__TAGS = MAPPING_MODULE_CS__TAGS;

	/**
	 * The number of structural features of the '<em>Library CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS_FEATURE_COUNT = MAPPING_MODULE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ImportCSImpl <em>Import CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ImportCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getImportCS()
	 * @generated
	 */
	int IMPORT_CS = 2;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__PATH_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Import CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.LibraryImportCSImpl <em>Library Import CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.LibraryImportCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getLibraryImportCS()
	 * @generated
	 */
	int LIBRARY_IMPORT_CS = 3;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__START_OFFSET = IMPORT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__END_OFFSET = IMPORT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__START_TOKEN = IMPORT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__END_TOKEN = IMPORT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__AST = IMPORT_CS__AST;

	/**
	 * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__PATH_NAME_CS = IMPORT_CS__PATH_NAME_CS;

	/**
	 * The number of structural features of the '<em>Library Import CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS_FEATURE_COUNT = IMPORT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.RenameCSImpl <em>Rename CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.RenameCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getRenameCS()
	 * @generated
	 */
	int RENAME_CS = 4;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__TYPE_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Original Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__ORIGINAL_NAME = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rename CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModulePropertyCSImpl <em>Module Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ModulePropertyCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getModulePropertyCS()
	 * @generated
	 */
	int MODULE_PROPERTY_CS = 5;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ConfigPropertyCSImpl <em>Config Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ConfigPropertyCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getConfigPropertyCS()
	 * @generated
	 */
	int CONFIG_PROPERTY_CS = 6;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_CS__START_OFFSET = MODULE_PROPERTY_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_CS__END_OFFSET = MODULE_PROPERTY_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_CS__START_TOKEN = MODULE_PROPERTY_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_CS__END_TOKEN = MODULE_PROPERTY_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_CS__AST = MODULE_PROPERTY_CS__AST;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_CS__SIMPLE_NAME_CS = MODULE_PROPERTY_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_CS__TYPE_CS = MODULE_PROPERTY_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Config Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_CS_FEATURE_COUNT = MODULE_PROPERTY_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.LocalPropertyCSImpl <em>Local Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.LocalPropertyCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getLocalPropertyCS()
	 * @generated
	 */
	int LOCAL_PROPERTY_CS = 7;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY_CS__START_OFFSET = MODULE_PROPERTY_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY_CS__END_OFFSET = MODULE_PROPERTY_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY_CS__START_TOKEN = MODULE_PROPERTY_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY_CS__END_TOKEN = MODULE_PROPERTY_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY_CS__AST = MODULE_PROPERTY_CS__AST;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY_CS__SIMPLE_NAME_CS = MODULE_PROPERTY_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY_CS__TYPE_CS = MODULE_PROPERTY_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY_CS__OCL_EXPRESSION_CS = MODULE_PROPERTY_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Local Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY_CS_FEATURE_COUNT = MODULE_PROPERTY_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ContextualPropertyCSImpl <em>Contextual Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ContextualPropertyCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getContextualPropertyCS()
	 * @generated
	 */
	int CONTEXTUAL_PROPERTY_CS = 8;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__START_OFFSET = MODULE_PROPERTY_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__END_OFFSET = MODULE_PROPERTY_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__START_TOKEN = MODULE_PROPERTY_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__END_TOKEN = MODULE_PROPERTY_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__AST = MODULE_PROPERTY_CS__AST;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__SIMPLE_NAME_CS = MODULE_PROPERTY_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Scoped Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS = MODULE_PROPERTY_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__TYPE_CS = MODULE_PROPERTY_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS = MODULE_PROPERTY_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Contextual Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS_FEATURE_COUNT = MODULE_PROPERTY_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ClassifierDefCSImpl <em>Classifier Def CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ClassifierDefCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getClassifierDefCS()
	 * @generated
	 */
	int CLASSIFIER_DEF_CS = 9;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__EXTENDS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__PROPERTIES = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__TAGS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Classifier Def CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ClassifierPropertyCSImpl <em>Classifier Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ClassifierPropertyCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getClassifierPropertyCS()
	 * @generated
	 */
	int CLASSIFIER_PROPERTY_CS = 10;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__START_OFFSET = LOCAL_PROPERTY_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__END_OFFSET = LOCAL_PROPERTY_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__START_TOKEN = LOCAL_PROPERTY_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__END_TOKEN = LOCAL_PROPERTY_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__AST = LOCAL_PROPERTY_CS__AST;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__SIMPLE_NAME_CS = LOCAL_PROPERTY_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__TYPE_CS = LOCAL_PROPERTY_CS__TYPE_CS;

	/**
	 * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__OCL_EXPRESSION_CS = LOCAL_PROPERTY_CS__OCL_EXPRESSION_CS;

	/**
	 * The feature id for the '<em><b>Stereotype Qualifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__STEREOTYPE_QUALIFIERS = LOCAL_PROPERTY_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Feature Keys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__FEATURE_KEYS = LOCAL_PROPERTY_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__MULTIPLICITY = LOCAL_PROPERTY_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__OPPOSITE = LOCAL_PROPERTY_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__IS_ORDERED = LOCAL_PROPERTY_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Classifier Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS_FEATURE_COUNT = LOCAL_PROPERTY_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.IntermediateClassDefCSImpl <em>Intermediate Class Def CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.IntermediateClassDefCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getIntermediateClassDefCS()
	 * @generated
	 */
	int INTERMEDIATE_CLASS_DEF_CS = 11;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CLASS_DEF_CS__START_OFFSET = CLASSIFIER_DEF_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CLASS_DEF_CS__END_OFFSET = CLASSIFIER_DEF_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CLASS_DEF_CS__START_TOKEN = CLASSIFIER_DEF_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CLASS_DEF_CS__END_TOKEN = CLASSIFIER_DEF_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CLASS_DEF_CS__AST = CLASSIFIER_DEF_CS__AST;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CLASS_DEF_CS__SIMPLE_NAME_CS = CLASSIFIER_DEF_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CLASS_DEF_CS__EXTENDS = CLASSIFIER_DEF_CS__EXTENDS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CLASS_DEF_CS__PROPERTIES = CLASSIFIER_DEF_CS__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CLASS_DEF_CS__TAGS = CLASSIFIER_DEF_CS__TAGS;

	/**
	 * The number of structural features of the '<em>Intermediate Class Def CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CLASS_DEF_CS_FEATURE_COUNT = CLASSIFIER_DEF_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ExceptionDefCSImpl <em>Exception Def CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ExceptionDefCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getExceptionDefCS()
	 * @generated
	 */
	int EXCEPTION_DEF_CS = 12;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_DEF_CS__START_OFFSET = CLASSIFIER_DEF_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_DEF_CS__END_OFFSET = CLASSIFIER_DEF_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_DEF_CS__START_TOKEN = CLASSIFIER_DEF_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_DEF_CS__END_TOKEN = CLASSIFIER_DEF_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_DEF_CS__AST = CLASSIFIER_DEF_CS__AST;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_DEF_CS__SIMPLE_NAME_CS = CLASSIFIER_DEF_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_DEF_CS__EXTENDS = CLASSIFIER_DEF_CS__EXTENDS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_DEF_CS__PROPERTIES = CLASSIFIER_DEF_CS__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_DEF_CS__TAGS = CLASSIFIER_DEF_CS__TAGS;

	/**
	 * The number of structural features of the '<em>Exception Def CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_DEF_CS_FEATURE_COUNT = CLASSIFIER_DEF_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.OppositePropertyCSImpl <em>Opposite Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.OppositePropertyCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getOppositePropertyCS()
	 * @generated
	 */
	int OPPOSITE_PROPERTY_CS = 13;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Is Navigable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__IS_NAVIGABLE = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__MULTIPLICITY = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Opposite Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MultiplicityDefCSImpl <em>Multiplicity Def CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MultiplicityDefCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMultiplicityDefCS()
	 * @generated
	 */
	int MULTIPLICITY_DEF_CS = 14;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__LOWER_BOUND = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__UPPER_BOUND = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multiplicity Def CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingDeclarationCSImpl <em>Mapping Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingDeclarationCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingDeclarationCS()
	 * @generated
	 */
	int MAPPING_DECLARATION_CS = 15;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS__QUALIFIERS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS__CONTEXT_TYPE = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS__PARAMETERS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS__RESULT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Direction Kind CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS__DIRECTION_KIND_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Mapping Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS__MAPPING_EXTENSION = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Is Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS__IS_QUERY = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Mapping Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_DECLARATION_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ParameterDeclarationCSImpl <em>Parameter Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ParameterDeclarationCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getParameterDeclarationCS()
	 * @generated
	 */
	int PARAMETER_DECLARATION_CS = 16;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Spec CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__TYPE_SPEC_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Direction Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__DIRECTION_KIND = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Parameter Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.SimpleSignatureCSImpl <em>Simple Signature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.SimpleSignatureCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getSimpleSignatureCS()
	 * @generated
	 */
	int SIMPLE_SIGNATURE_CS = 17;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS__PARAMS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Signature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.CompleteSignatureCSImpl <em>Complete Signature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CompleteSignatureCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getCompleteSignatureCS()
	 * @generated
	 */
	int COMPLETE_SIGNATURE_CS = 18;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Simple Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__RESULT_PARAMS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Complete Signature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingMethodCSImpl <em>Mapping Method CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingMethodCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingMethodCS()
	 * @generated
	 */
	int MAPPING_METHOD_CS = 19;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Black Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__BLACK_BOX = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Declaration CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__MAPPING_DECLARATION_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Method CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingRuleCSImpl <em>Mapping Rule CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingRuleCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingRuleCS()
	 * @generated
	 */
	int MAPPING_RULE_CS = 20;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__START_OFFSET = MAPPING_METHOD_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__END_OFFSET = MAPPING_METHOD_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__START_TOKEN = MAPPING_METHOD_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__END_TOKEN = MAPPING_METHOD_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__AST = MAPPING_METHOD_CS__AST;

	/**
	 * The feature id for the '<em><b>Black Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__BLACK_BOX = MAPPING_METHOD_CS__BLACK_BOX;

	/**
	 * The feature id for the '<em><b>Mapping Declaration CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__MAPPING_DECLARATION_CS = MAPPING_METHOD_CS__MAPPING_DECLARATION_CS;

	/**
	 * The feature id for the '<em><b>Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__GUARDS = MAPPING_METHOD_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Posts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__POSTS = MAPPING_METHOD_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mapping Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__MAPPING_BODY = MAPPING_METHOD_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapping Rule CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS_FEATURE_COUNT = MAPPING_METHOD_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingQueryCSImpl <em>Mapping Query CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingQueryCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingQueryCS()
	 * @generated
	 */
	int MAPPING_QUERY_CS = 21;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__START_OFFSET = MAPPING_METHOD_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__END_OFFSET = MAPPING_METHOD_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__START_TOKEN = MAPPING_METHOD_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__END_TOKEN = MAPPING_METHOD_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__AST = MAPPING_METHOD_CS__AST;

	/**
	 * The feature id for the '<em><b>Black Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__BLACK_BOX = MAPPING_METHOD_CS__BLACK_BOX;

	/**
	 * The feature id for the '<em><b>Mapping Declaration CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__MAPPING_DECLARATION_CS = MAPPING_METHOD_CS__MAPPING_DECLARATION_CS;

	/**
	 * The feature id for the '<em><b>Is Simple Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION = MAPPING_METHOD_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__BODY = MAPPING_METHOD_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Query CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS_FEATURE_COUNT = MAPPING_METHOD_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ConstructorCSImpl <em>Constructor CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ConstructorCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getConstructorCS()
	 * @generated
	 */
	int CONSTRUCTOR_CS = 22;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__START_OFFSET = MAPPING_METHOD_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__END_OFFSET = MAPPING_METHOD_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__START_TOKEN = MAPPING_METHOD_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__END_TOKEN = MAPPING_METHOD_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__AST = MAPPING_METHOD_CS__AST;

	/**
	 * The feature id for the '<em><b>Black Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__BLACK_BOX = MAPPING_METHOD_CS__BLACK_BOX;

	/**
	 * The feature id for the '<em><b>Mapping Declaration CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__MAPPING_DECLARATION_CS = MAPPING_METHOD_CS__MAPPING_DECLARATION_CS;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__BODY = MAPPING_METHOD_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constructor CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS_FEATURE_COUNT = MAPPING_METHOD_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionCSImpl <em>Mapping Section CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingSectionCS()
	 * @generated
	 */
	int MAPPING_SECTION_CS = 23;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__BODY_START_LOCATION = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__BODY_END_LOCATION = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__STATEMENTS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mapping Rule CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__MAPPING_RULE_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping Section CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingInitCSImpl <em>Mapping Init CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingInitCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingInitCS()
	 * @generated
	 */
	int MAPPING_INIT_CS = 24;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INIT_CS__START_OFFSET = MAPPING_SECTION_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INIT_CS__END_OFFSET = MAPPING_SECTION_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INIT_CS__START_TOKEN = MAPPING_SECTION_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INIT_CS__END_TOKEN = MAPPING_SECTION_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INIT_CS__AST = MAPPING_SECTION_CS__AST;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INIT_CS__BODY_START_LOCATION = MAPPING_SECTION_CS__BODY_START_LOCATION;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INIT_CS__BODY_END_LOCATION = MAPPING_SECTION_CS__BODY_END_LOCATION;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INIT_CS__STATEMENTS = MAPPING_SECTION_CS__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Mapping Rule CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INIT_CS__MAPPING_RULE_CS = MAPPING_SECTION_CS__MAPPING_RULE_CS;

	/**
	 * The number of structural features of the '<em>Mapping Init CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INIT_CS_FEATURE_COUNT = MAPPING_SECTION_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingEndCSImpl <em>Mapping End CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingEndCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingEndCS()
	 * @generated
	 */
	int MAPPING_END_CS = 25;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_END_CS__START_OFFSET = MAPPING_SECTION_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_END_CS__END_OFFSET = MAPPING_SECTION_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_END_CS__START_TOKEN = MAPPING_SECTION_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_END_CS__END_TOKEN = MAPPING_SECTION_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_END_CS__AST = MAPPING_SECTION_CS__AST;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_END_CS__BODY_START_LOCATION = MAPPING_SECTION_CS__BODY_START_LOCATION;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_END_CS__BODY_END_LOCATION = MAPPING_SECTION_CS__BODY_END_LOCATION;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_END_CS__STATEMENTS = MAPPING_SECTION_CS__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Mapping Rule CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_END_CS__MAPPING_RULE_CS = MAPPING_SECTION_CS__MAPPING_RULE_CS;

	/**
	 * The number of structural features of the '<em>Mapping End CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_END_CS_FEATURE_COUNT = MAPPING_SECTION_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionsCSImpl <em>Mapping Sections CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionsCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingSectionsCS()
	 * @generated
	 */
	int MAPPING_SECTIONS_CS = 26;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Mapping Init CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__MAPPING_INIT_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Body CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__MAPPING_BODY_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mapping End CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__MAPPING_END_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapping Sections CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.StatementCSImpl <em>Statement CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.StatementCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getStatementCS()
	 * @generated
	 */
	int STATEMENT_CS = 27;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__AST = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__AST;

	/**
	 * The number of structural features of the '<em>Statement CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.BlockExpCSImpl <em>Block Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.BlockExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getBlockExpCS()
	 * @generated
	 */
	int BLOCK_EXP_CS = 28;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__AST = STATEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Body Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__BODY_EXPRESSIONS = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ComputeExpCSImpl <em>Compute Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ComputeExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getComputeExpCS()
	 * @generated
	 */
	int COMPUTE_EXP_CS = 29;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__AST = STATEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Returned Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__RETURNED_ELEMENT = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__BODY = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Compute Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.WhileExpCSImpl <em>While Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.WhileExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getWhileExpCS()
	 * @generated
	 */
	int WHILE_EXP_CS = 30;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__AST = STATEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__BODY = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__CONDITION = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Result Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__RESULT_VAR = STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>While Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ImperativeLoopExpCSImpl <em>Imperative Loop Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ImperativeLoopExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getImperativeLoopExpCS()
	 * @generated
	 */
	int IMPERATIVE_LOOP_EXP_CS = 31;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__AST = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__AST;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__SOURCE = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Accessor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__ACCESSOR = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__ACCESSOR;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Variable1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__VARIABLE1 = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__VARIABLE1;

	/**
	 * The feature id for the '<em><b>Variable2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__VARIABLE2 = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__VARIABLE2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__BODY = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__BODY;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__CONDITION = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imperative Loop Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ForExpCSImpl <em>For Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ForExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getForExpCS()
	 * @generated
	 */
	int FOR_EXP_CS = 32;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__START_OFFSET = IMPERATIVE_LOOP_EXP_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__END_OFFSET = IMPERATIVE_LOOP_EXP_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__START_TOKEN = IMPERATIVE_LOOP_EXP_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__END_TOKEN = IMPERATIVE_LOOP_EXP_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__AST = IMPERATIVE_LOOP_EXP_CS__AST;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__SOURCE = IMPERATIVE_LOOP_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Accessor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__ACCESSOR = IMPERATIVE_LOOP_EXP_CS__ACCESSOR;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__SIMPLE_NAME_CS = IMPERATIVE_LOOP_EXP_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Variable1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__VARIABLE1 = IMPERATIVE_LOOP_EXP_CS__VARIABLE1;

	/**
	 * The feature id for the '<em><b>Variable2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__VARIABLE2 = IMPERATIVE_LOOP_EXP_CS__VARIABLE2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__BODY = IMPERATIVE_LOOP_EXP_CS__BODY;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__CONDITION = IMPERATIVE_LOOP_EXP_CS__CONDITION;

	/**
	 * The number of structural features of the '<em>For Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS_FEATURE_COUNT = IMPERATIVE_LOOP_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ImperativeIterateExpCSImpl <em>Imperative Iterate Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ImperativeIterateExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getImperativeIterateExpCS()
	 * @generated
	 */
	int IMPERATIVE_ITERATE_EXP_CS = 33;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__START_OFFSET = IMPERATIVE_LOOP_EXP_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__END_OFFSET = IMPERATIVE_LOOP_EXP_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__START_TOKEN = IMPERATIVE_LOOP_EXP_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__END_TOKEN = IMPERATIVE_LOOP_EXP_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__AST = IMPERATIVE_LOOP_EXP_CS__AST;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__SOURCE = IMPERATIVE_LOOP_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Accessor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__ACCESSOR = IMPERATIVE_LOOP_EXP_CS__ACCESSOR;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__SIMPLE_NAME_CS = IMPERATIVE_LOOP_EXP_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Variable1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__VARIABLE1 = IMPERATIVE_LOOP_EXP_CS__VARIABLE1;

	/**
	 * The feature id for the '<em><b>Variable2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__VARIABLE2 = IMPERATIVE_LOOP_EXP_CS__VARIABLE2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__BODY = IMPERATIVE_LOOP_EXP_CS__BODY;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__CONDITION = IMPERATIVE_LOOP_EXP_CS__CONDITION;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__TARGET = IMPERATIVE_LOOP_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imperative Iterate Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS_FEATURE_COUNT = IMPERATIVE_LOOP_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.SwitchExpCSImpl <em>Switch Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.SwitchExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getSwitchExpCS()
	 * @generated
	 */
	int SWITCH_EXP_CS = 34;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__AST = STATEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Alternative Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__ALTERNATIVE_PART = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Else Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__ELSE_PART = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Switch Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.SwitchAltExpCSImpl <em>Switch Alt Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.SwitchAltExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getSwitchAltExpCS()
	 * @generated
	 */
	int SWITCH_ALT_EXP_CS = 35;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_EXP_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_EXP_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_EXP_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_EXP_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_EXP_CS__AST = STATEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_EXP_CS__CONDITION = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_EXP_CS__BODY = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Switch Alt Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.VariableInitializationCSImpl <em>Variable Initialization CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.VariableInitializationCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getVariableInitializationCS()
	 * @generated
	 */
	int VARIABLE_INITIALIZATION_CS = 36;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__AST = STATEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__OCL_EXPRESSION_CS = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__SIMPLE_NAME_CS = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__TYPE_CS = STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>With Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__WITH_RESULT = STATEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Variable Initialization CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.AssignStatementCSImpl <em>Assign Statement CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.AssignStatementCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getAssignStatementCS()
	 * @generated
	 */
	int ASSIGN_STATEMENT_CS = 37;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__AST = STATEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>LValue CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__LVALUE_CS = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Incremental</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__INCREMENTAL = STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assign Statement CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.BreakExpCSImpl <em>Break Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.BreakExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getBreakExpCS()
	 * @generated
	 */
	int BREAK_EXP_CS = 38;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP_CS__AST = STATEMENT_CS__AST;

	/**
	 * The number of structural features of the '<em>Break Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ContinueExpCSImpl <em>Continue Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ContinueExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getContinueExpCS()
	 * @generated
	 */
	int CONTINUE_EXP_CS = 39;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP_CS__AST = STATEMENT_CS__AST;

	/**
	 * The number of structural features of the '<em>Continue Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ExpressionStatementCSImpl <em>Expression Statement CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ExpressionStatementCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getExpressionStatementCS()
	 * @generated
	 */
	int EXPRESSION_STATEMENT_CS = 40;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__AST = STATEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Statement CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingBodyCSImpl <em>Mapping Body CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingBodyCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingBodyCS()
	 * @generated
	 */
	int MAPPING_BODY_CS = 41;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__START_OFFSET = MAPPING_SECTION_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__END_OFFSET = MAPPING_SECTION_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__START_TOKEN = MAPPING_SECTION_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__END_TOKEN = MAPPING_SECTION_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__AST = MAPPING_SECTION_CS__AST;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__BODY_START_LOCATION = MAPPING_SECTION_CS__BODY_START_LOCATION;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__BODY_END_LOCATION = MAPPING_SECTION_CS__BODY_END_LOCATION;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__STATEMENTS = MAPPING_SECTION_CS__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Mapping Rule CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__MAPPING_RULE_CS = MAPPING_SECTION_CS__MAPPING_RULE_CS;

	/**
	 * The feature id for the '<em><b>Has Population Keyword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__HAS_POPULATION_KEYWORD = MAPPING_SECTION_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping Body CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS_FEATURE_COUNT = MAPPING_SECTION_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.InstantiationExpCSImpl <em>Instantiation Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.InstantiationExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getInstantiationExpCS()
	 * @generated
	 */
	int INSTANTIATION_EXP_CS = 61;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__AST = STATEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Type Spec CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__TYPE_SPEC_CS = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__ARGUMENTS = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Instantiation Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ObjectExpCSImpl <em>Object Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ObjectExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getObjectExpCS()
	 * @generated
	 */
	int OBJECT_EXP_CS = 42;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__START_OFFSET = INSTANTIATION_EXP_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__END_OFFSET = INSTANTIATION_EXP_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__START_TOKEN = INSTANTIATION_EXP_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__END_TOKEN = INSTANTIATION_EXP_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__AST = INSTANTIATION_EXP_CS__AST;

	/**
	 * The feature id for the '<em><b>Type Spec CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__TYPE_SPEC_CS = INSTANTIATION_EXP_CS__TYPE_SPEC_CS;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__ARGUMENTS = INSTANTIATION_EXP_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__BODY_START_LOCATION = INSTANTIATION_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__BODY_END_LOCATION = INSTANTIATION_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__SIMPLE_NAME_CS = INSTANTIATION_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__EXPRESSIONS = INSTANTIATION_EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__IS_IMPLICIT = INSTANTIATION_EXP_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Object Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS_FEATURE_COUNT = INSTANTIATION_EXP_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ImperativeOperationCallExpCSImpl <em>Imperative Operation Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ImperativeOperationCallExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getImperativeOperationCallExpCS()
	 * @generated
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS = 44;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__AST = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__AST;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__SOURCE = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Accessor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__ACCESSOR = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__ACCESSOR;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__PATH_NAME_CS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__PATH_NAME_CS;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__ARGUMENTS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Is Marked Pre CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__IS_MARKED_PRE_CS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__IS_MARKED_PRE_CS;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__IS_ATOMIC = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__IS_ATOMIC;

	/**
	 * The feature id for the '<em><b>Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__MODULE = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imperative Operation Call Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingCallExpCSImpl <em>Mapping Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingCallExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingCallExpCS()
	 * @generated
	 */
	int MAPPING_CALL_EXP_CS = 43;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__START_OFFSET = IMPERATIVE_OPERATION_CALL_EXP_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__END_OFFSET = IMPERATIVE_OPERATION_CALL_EXP_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__START_TOKEN = IMPERATIVE_OPERATION_CALL_EXP_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__END_TOKEN = IMPERATIVE_OPERATION_CALL_EXP_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__AST = IMPERATIVE_OPERATION_CALL_EXP_CS__AST;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__SOURCE = IMPERATIVE_OPERATION_CALL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Accessor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__ACCESSOR = IMPERATIVE_OPERATION_CALL_EXP_CS__ACCESSOR;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__SIMPLE_NAME_CS = IMPERATIVE_OPERATION_CALL_EXP_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__PATH_NAME_CS = IMPERATIVE_OPERATION_CALL_EXP_CS__PATH_NAME_CS;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__ARGUMENTS = IMPERATIVE_OPERATION_CALL_EXP_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Is Marked Pre CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__IS_MARKED_PRE_CS = IMPERATIVE_OPERATION_CALL_EXP_CS__IS_MARKED_PRE_CS;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__IS_ATOMIC = IMPERATIVE_OPERATION_CALL_EXP_CS__IS_ATOMIC;

	/**
	 * The feature id for the '<em><b>Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__MODULE = IMPERATIVE_OPERATION_CALL_EXP_CS__MODULE;

	/**
	 * The feature id for the '<em><b>Strict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__STRICT = IMPERATIVE_OPERATION_CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping Call Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS_FEATURE_COUNT = IMPERATIVE_OPERATION_CALL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.DirectionKindCSImpl <em>Direction Kind CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.DirectionKindCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getDirectionKindCS()
	 * @generated
	 */
	int DIRECTION_KIND_CS = 45;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_KIND_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_KIND_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_KIND_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_KIND_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_KIND_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Direction Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_KIND_CS__DIRECTION_KIND = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Direction Kind CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_KIND_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ElementWithBodyImpl <em>Element With Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ElementWithBodyImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getElementWithBody()
	 * @generated
	 */
	int ELEMENT_WITH_BODY = 46;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_BODY__BODY_START_LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_BODY__BODY_END_LOCATION = 1;

	/**
	 * The number of structural features of the '<em>Element With Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_BODY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveExpCSImpl <em>Resolve Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getResolveExpCS()
	 * @generated
	 */
	int RESOLVE_EXP_CS = 47;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__AST = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS__AST;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__SOURCE = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Accessor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__ACCESSOR = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS__ACCESSOR;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>One</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__ONE = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Inverse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__IS_INVERSE = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Deferred</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__IS_DEFERRED = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__TARGET = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__CONDITION = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Resolve Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveInExpCSImpl <em>Resolve In Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveInExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getResolveInExpCS()
	 * @generated
	 */
	int RESOLVE_IN_EXP_CS = 48;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__START_OFFSET = RESOLVE_EXP_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__END_OFFSET = RESOLVE_EXP_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__START_TOKEN = RESOLVE_EXP_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__END_TOKEN = RESOLVE_EXP_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__AST = RESOLVE_EXP_CS__AST;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__SOURCE = RESOLVE_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Accessor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__ACCESSOR = RESOLVE_EXP_CS__ACCESSOR;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__SIMPLE_NAME_CS = RESOLVE_EXP_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>One</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__ONE = RESOLVE_EXP_CS__ONE;

	/**
	 * The feature id for the '<em><b>Is Inverse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__IS_INVERSE = RESOLVE_EXP_CS__IS_INVERSE;

	/**
	 * The feature id for the '<em><b>Is Deferred</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__IS_DEFERRED = RESOLVE_EXP_CS__IS_DEFERRED;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__TARGET = RESOLVE_EXP_CS__TARGET;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__CONDITION = RESOLVE_EXP_CS__CONDITION;

	/**
	 * The feature id for the '<em><b>In Mapping Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE = RESOLVE_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Mapping Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__IN_MAPPING_NAME = RESOLVE_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resolve In Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS_FEATURE_COUNT = RESOLVE_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModelTypeCSImpl <em>Model Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ModelTypeCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getModelTypeCS()
	 * @generated
	 */
	int MODEL_TYPE_CS = 49;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__BODY_START_LOCATION = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__BODY_END_LOCATION = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Identifier CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__IDENTIFIER_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Compliance Kind CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__COMPLIANCE_KIND_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Package Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__PACKAGE_REFS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Where Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__WHERE_STATEMENTS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Model Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.PackageRefCSImpl <em>Package Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.PackageRefCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getPackageRefCS()
	 * @generated
	 */
	int PACKAGE_REF_CS = 50;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__PATH_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uri CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__URI_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationHeaderCSImpl <em>Transformation Header CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationHeaderCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getTransformationHeaderCS()
	 * @generated
	 */
	int TRANSFORMATION_HEADER_CS = 51;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_HEADER_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_HEADER_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_HEADER_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_HEADER_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_HEADER_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_HEADER_CS__QUALIFIERS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_HEADER_CS__PATH_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_HEADER_CS__PARAMETERS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Module Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_HEADER_CS__MODULE_USAGES = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Transformation Refine CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transformation Header CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_HEADER_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModuleKindCSImpl <em>Module Kind CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ModuleKindCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getModuleKindCS()
	 * @generated
	 */
	int MODULE_KIND_CS = 52;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Module Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS__MODULE_KIND = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module Kind CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModuleRefCSImpl <em>Module Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ModuleRefCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getModuleRefCS()
	 * @generated
	 */
	int MODULE_REF_CS = 53;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__PATH_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__PARAMETERS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Module Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModuleUsageCSImpl <em>Module Usage CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ModuleUsageCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getModuleUsageCS()
	 * @generated
	 */
	int MODULE_USAGE_CS = 54;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Import Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__IMPORT_KIND = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Module Kind CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__MODULE_KIND_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Module Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__MODULE_REFS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Module Usage CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationRefineCSImpl <em>Transformation Refine CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationRefineCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getTransformationRefineCS()
	 * @generated
	 */
	int TRANSFORMATION_REFINE_CS = 55;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Module Ref CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__MODULE_REF_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Transformation Refine CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TypeSpecCSImpl <em>Type Spec CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.TypeSpecCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getTypeSpecCS()
	 * @generated
	 */
	int TYPE_SPEC_CS = 56;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__TYPE_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Spec CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.LogExpCSImpl <em>Log Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.LogExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getLogExpCS()
	 * @generated
	 */
	int LOG_EXP_CS = 57;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__AST = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__AST;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__SOURCE = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Accessor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__ACCESSOR = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__ACCESSOR;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__PATH_NAME_CS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__PATH_NAME_CS;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__ARGUMENTS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Is Marked Pre CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__IS_MARKED_PRE_CS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__IS_MARKED_PRE_CS;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__IS_ATOMIC = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__IS_ATOMIC;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__CONDITION = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Log Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.AssertExpCSImpl <em>Assert Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.AssertExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getAssertExpCS()
	 * @generated
	 */
	int ASSERT_EXP_CS = 58;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__AST = STATEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Assertion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__ASSERTION = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Log</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__LOG = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__SEVERITY = STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assert Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ReturnExpCSImpl <em>Return Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ReturnExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getReturnExpCS()
	 * @generated
	 */
	int RETURN_EXP_CS = 59;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__AST = STATEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__VALUE = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingExtensionCSImpl <em>Mapping Extension CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingExtensionCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingExtensionCS()
	 * @generated
	 */
	int MAPPING_EXTENSION_CS = 60;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_EXTENSION_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_EXTENSION_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_EXTENSION_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_EXTENSION_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_EXTENSION_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_EXTENSION_CS__KIND = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Identifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_EXTENSION_CS__MAPPING_IDENTIFIERS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Extension CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_EXTENSION_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ListTypeCSImpl <em>List Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ListTypeCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getListTypeCS()
	 * @generated
	 */
	int LIST_TYPE_CS = 62;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.TYPE_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.TYPE_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.TYPE_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.TYPE_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_CS__AST = org.eclipse.ocl.cst.CSTPackage.TYPE_CS__AST;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_CS__TYPE_CS = org.eclipse.ocl.cst.CSTPackage.TYPE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.TYPE_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ListLiteralExpCSImpl <em>List Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ListLiteralExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getListLiteralExpCS()
	 * @generated
	 */
	int LIST_LITERAL_EXP_CS = 63;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__AST = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS__AST;

	/**
	 * The feature id for the '<em><b>Collection Literal Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.DictionaryTypeCSImpl <em>Dictionary Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.DictionaryTypeCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getDictionaryTypeCS()
	 * @generated
	 */
	int DICTIONARY_TYPE_CS = 64;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.TYPE_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.TYPE_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.TYPE_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.TYPE_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE_CS__AST = org.eclipse.ocl.cst.CSTPackage.TYPE_CS__AST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE_CS__KEY = org.eclipse.ocl.cst.CSTPackage.TYPE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE_CS__VALUE = org.eclipse.ocl.cst.CSTPackage.TYPE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dictionary Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.TYPE_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.DictLiteralExpCSImpl <em>Dict Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.DictLiteralExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getDictLiteralExpCS()
	 * @generated
	 */
	int DICT_LITERAL_EXP_CS = 65;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__AST = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS__AST;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__PARTS = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dict Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.DictLiteralPartCSImpl <em>Dict Literal Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.DictLiteralPartCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getDictLiteralPartCS()
	 * @generated
	 */
	int DICT_LITERAL_PART_CS = 66;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS__KEY = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS__VALUE = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dict Literal Part CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TagCSImpl <em>Tag CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.TagCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getTagCS()
	 * @generated
	 */
	int TAG_CS = 67;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__NAME = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scoped Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__SCOPED_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__OCL_EXPRESSION_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tag CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.UnitCSImpl <em>Unit CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.UnitCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getUnitCS()
	 * @generated
	 */
	int UNIT_CS = 68;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Top Level Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__TOP_LEVEL_ELEMENTS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__MODULES = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__MODEL_TYPES = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__IMPORTS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Unit CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveOpArgsExpCSImpl <em>Resolve Op Args Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveOpArgsExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getResolveOpArgsExpCS()
	 * @generated
	 */
	int RESOLVE_OP_ARGS_EXP_CS = 69;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__TARGET = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__CONDITION = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resolve Op Args Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ScopedNameCSImpl <em>Scoped Name CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ScopedNameCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getScopedNameCS()
	 * @generated
	 */
	int SCOPED_NAME_CS = 70;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__TYPE_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__NAME = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scoped Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TryExpCSImpl <em>Try Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.TryExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getTryExpCS()
	 * @generated
	 */
	int TRY_EXP_CS = 71;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__AST = STATEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Try Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__TRY_BODY = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Except Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__EXCEPT_CLAUSES = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Try Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.CatchExpCSImpl <em>Catch Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CatchExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getCatchExpCS()
	 * @generated
	 */
	int CATCH_EXP_CS = 72;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP_CS__START_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP_CS__END_TOKEN = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP_CS__AST = org.eclipse.ocl.cst.CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP_CS__BODY = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP_CS__EXCEPTIONS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Catch Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.RaiseExpCSImpl <em>Raise Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.RaiseExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getRaiseExpCS()
	 * @generated
	 */
	int RAISE_EXP_CS = 73;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__START_TOKEN = STATEMENT_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__END_TOKEN = STATEMENT_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__AST = STATEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__EXCEPTION = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__ARGUMENT = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Raise Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum <em>Direction Kind Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getDirectionKindEnum()
	 * @generated
	 */
	int DIRECTION_KIND_ENUM = 74;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum <em>Module Kind Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getModuleKindEnum()
	 * @generated
	 */
	int MODULE_KIND_ENUM = 75;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum <em>Import Kind Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getImportKindEnum()
	 * @generated
	 */
	int IMPORT_KIND_ENUM = 76;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionKindCS <em>Mapping Extension Kind CS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionKindCS
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingExtensionKindCS()
	 * @generated
	 */
	int MAPPING_EXTENSION_KIND_CS = 77;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS <em>Qualifier Kind CS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getQualifierKindCS()
	 * @generated
	 */
	int QUALIFIER_KIND_CS = 78;


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS <em>Mapping Module CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Module CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS
	 * @generated
	 */
	EClass getMappingModuleCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getHeaderCS <em>Header CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Header CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getHeaderCS()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_HeaderCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getImports()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getMetamodels <em>Metamodels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metamodels</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getMetamodels()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_Metamodels();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getRenamings <em>Renamings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Renamings</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getRenamings()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_Renamings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getProperties()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getMethods()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_Methods();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getClassifierDefCS <em>Classifier Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classifier Def CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getClassifierDefCS()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_ClassifierDefCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getTags()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_Tags();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.LibraryCS <em>Library CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.LibraryCS
	 * @generated
	 */
	EClass getLibraryCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImportCS <em>Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImportCS
	 * @generated
	 */
	EClass getImportCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImportCS#getPathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImportCS#getPathNameCS()
	 * @see #getImportCS()
	 * @generated
	 */
	EReference getImportCS_PathNameCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS <em>Library Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library Import CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS
	 * @generated
	 */
	EClass getLibraryImportCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.RenameCS <em>Rename CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rename CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.RenameCS
	 * @generated
	 */
	EClass getRenameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.RenameCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.RenameCS#getTypeCS()
	 * @see #getRenameCS()
	 * @generated
	 */
	EReference getRenameCS_TypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.RenameCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.RenameCS#getSimpleNameCS()
	 * @see #getRenameCS()
	 * @generated
	 */
	EReference getRenameCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.RenameCS#getOriginalName <em>Original Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Original Name</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.RenameCS#getOriginalName()
	 * @see #getRenameCS()
	 * @generated
	 */
	EReference getRenameCS_OriginalName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS <em>Module Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Property CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS
	 * @generated
	 */
	EClass getModulePropertyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS#getSimpleNameCS()
	 * @see #getModulePropertyCS()
	 * @generated
	 */
	EReference getModulePropertyCS_SimpleNameCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS <em>Config Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Property CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS
	 * @generated
	 */
	EClass getConfigPropertyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS#getTypeCS()
	 * @see #getConfigPropertyCS()
	 * @generated
	 */
	EReference getConfigPropertyCS_TypeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS <em>Local Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Property CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS
	 * @generated
	 */
	EClass getLocalPropertyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS#getTypeCS()
	 * @see #getLocalPropertyCS()
	 * @generated
	 */
	EReference getLocalPropertyCS_TypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS#getOclExpressionCS()
	 * @see #getLocalPropertyCS()
	 * @generated
	 */
	EReference getLocalPropertyCS_OclExpressionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS <em>Contextual Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contextual Property CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS
	 * @generated
	 */
	EClass getContextualPropertyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS#getScopedNameCS <em>Scoped Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scoped Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS#getScopedNameCS()
	 * @see #getContextualPropertyCS()
	 * @generated
	 */
	EReference getContextualPropertyCS_ScopedNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS#getTypeCS()
	 * @see #getContextualPropertyCS()
	 * @generated
	 */
	EReference getContextualPropertyCS_TypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS#getOclExpressionCS()
	 * @see #getContextualPropertyCS()
	 * @generated
	 */
	EReference getContextualPropertyCS_OclExpressionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS <em>Classifier Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Def CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS
	 * @generated
	 */
	EClass getClassifierDefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS#getSimpleNameCS()
	 * @see #getClassifierDefCS()
	 * @generated
	 */
	EReference getClassifierDefCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extends</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS#getExtends()
	 * @see #getClassifierDefCS()
	 * @generated
	 */
	EReference getClassifierDefCS_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS#getProperties()
	 * @see #getClassifierDefCS()
	 * @generated
	 */
	EReference getClassifierDefCS_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS#getTags()
	 * @see #getClassifierDefCS()
	 * @generated
	 */
	EReference getClassifierDefCS_Tags();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS <em>Classifier Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Property CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS
	 * @generated
	 */
	EClass getClassifierPropertyCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getStereotypeQualifiers <em>Stereotype Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stereotype Qualifiers</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getStereotypeQualifiers()
	 * @see #getClassifierPropertyCS()
	 * @generated
	 */
	EReference getClassifierPropertyCS_StereotypeQualifiers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getFeatureKeys <em>Feature Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Keys</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getFeatureKeys()
	 * @see #getClassifierPropertyCS()
	 * @generated
	 */
	EReference getClassifierPropertyCS_FeatureKeys();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Multiplicity</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getMultiplicity()
	 * @see #getClassifierPropertyCS()
	 * @generated
	 */
	EReference getClassifierPropertyCS_Multiplicity();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Opposite</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getOpposite()
	 * @see #getClassifierPropertyCS()
	 * @generated
	 */
	EReference getClassifierPropertyCS_Opposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#isIsOrdered <em>Is Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Ordered</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#isIsOrdered()
	 * @see #getClassifierPropertyCS()
	 * @generated
	 */
	EAttribute getClassifierPropertyCS_IsOrdered();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.IntermediateClassDefCS <em>Intermediate Class Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intermediate Class Def CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.IntermediateClassDefCS
	 * @generated
	 */
	EClass getIntermediateClassDefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ExceptionDefCS <em>Exception Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exception Def CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ExceptionDefCS
	 * @generated
	 */
	EClass getExceptionDefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS <em>Opposite Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opposite Property CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS
	 * @generated
	 */
	EClass getOppositePropertyCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS#isIsNavigable <em>Is Navigable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Navigable</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS#isIsNavigable()
	 * @see #getOppositePropertyCS()
	 * @generated
	 */
	EAttribute getOppositePropertyCS_IsNavigable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS#getSimpleNameCS()
	 * @see #getOppositePropertyCS()
	 * @generated
	 */
	EReference getOppositePropertyCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Multiplicity</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS#getMultiplicity()
	 * @see #getOppositePropertyCS()
	 * @generated
	 */
	EReference getOppositePropertyCS_Multiplicity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS <em>Multiplicity Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity Def CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS
	 * @generated
	 */
	EClass getMultiplicityDefCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lower Bound</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS#getLowerBound()
	 * @see #getMultiplicityDefCS()
	 * @generated
	 */
	EReference getMultiplicityDefCS_LowerBound();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Upper Bound</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS#getUpperBound()
	 * @see #getMultiplicityDefCS()
	 * @generated
	 */
	EReference getMultiplicityDefCS_UpperBound();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS <em>Mapping Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Declaration CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS
	 * @generated
	 */
	EClass getMappingDeclarationCS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getQualifiers <em>Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualifiers</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getQualifiers()
	 * @see #getMappingDeclarationCS()
	 * @generated
	 */
	EAttribute getMappingDeclarationCS_Qualifiers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getSimpleNameCS()
	 * @see #getMappingDeclarationCS()
	 * @generated
	 */
	EReference getMappingDeclarationCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getContextType <em>Context Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context Type</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getContextType()
	 * @see #getMappingDeclarationCS()
	 * @generated
	 */
	EReference getMappingDeclarationCS_ContextType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getParameters()
	 * @see #getMappingDeclarationCS()
	 * @generated
	 */
	EReference getMappingDeclarationCS_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Result</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getResult()
	 * @see #getMappingDeclarationCS()
	 * @generated
	 */
	EReference getMappingDeclarationCS_Result();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getDirectionKindCS <em>Direction Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Direction Kind CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getDirectionKindCS()
	 * @see #getMappingDeclarationCS()
	 * @generated
	 */
	EReference getMappingDeclarationCS_DirectionKindCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getMappingExtension <em>Mapping Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Extension</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getMappingExtension()
	 * @see #getMappingDeclarationCS()
	 * @generated
	 */
	EReference getMappingDeclarationCS_MappingExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#isIsQuery <em>Is Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Query</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#isIsQuery()
	 * @see #getMappingDeclarationCS()
	 * @generated
	 */
	EAttribute getMappingDeclarationCS_IsQuery();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS <em>Parameter Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Declaration CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS
	 * @generated
	 */
	EClass getParameterDeclarationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getSimpleNameCS()
	 * @see #getParameterDeclarationCS()
	 * @generated
	 */
	EReference getParameterDeclarationCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getTypeSpecCS <em>Type Spec CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Spec CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getTypeSpecCS()
	 * @see #getParameterDeclarationCS()
	 * @generated
	 */
	EReference getParameterDeclarationCS_TypeSpecCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getDirectionKind <em>Direction Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction Kind</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getDirectionKind()
	 * @see #getParameterDeclarationCS()
	 * @generated
	 */
	EAttribute getParameterDeclarationCS_DirectionKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS <em>Simple Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Signature CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS
	 * @generated
	 */
	EClass getSimpleSignatureCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS#getParams()
	 * @see #getSimpleSignatureCS()
	 * @generated
	 */
	EReference getSimpleSignatureCS_Params();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS <em>Complete Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Signature CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS
	 * @generated
	 */
	EClass getCompleteSignatureCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS#getSimpleSignature <em>Simple Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Signature</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS#getSimpleSignature()
	 * @see #getCompleteSignatureCS()
	 * @generated
	 */
	EReference getCompleteSignatureCS_SimpleSignature();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS#getResultParams <em>Result Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Result Params</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS#getResultParams()
	 * @see #getCompleteSignatureCS()
	 * @generated
	 */
	EReference getCompleteSignatureCS_ResultParams();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS <em>Mapping Method CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Method CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS
	 * @generated
	 */
	EClass getMappingMethodCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS#isBlackBox <em>Black Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Black Box</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS#isBlackBox()
	 * @see #getMappingMethodCS()
	 * @generated
	 */
	EAttribute getMappingMethodCS_BlackBox();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS#getMappingDeclarationCS <em>Mapping Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Declaration CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS#getMappingDeclarationCS()
	 * @see #getMappingMethodCS()
	 * @generated
	 */
	EReference getMappingMethodCS_MappingDeclarationCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS <em>Mapping Rule CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Rule CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS
	 * @generated
	 */
	EClass getMappingRuleCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS#getGuards <em>Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Guards</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS#getGuards()
	 * @see #getMappingRuleCS()
	 * @generated
	 */
	EReference getMappingRuleCS_Guards();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS#getPosts <em>Posts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Posts</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS#getPosts()
	 * @see #getMappingRuleCS()
	 * @generated
	 */
	EReference getMappingRuleCS_Posts();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS#getMappingBody <em>Mapping Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS#getMappingBody()
	 * @see #getMappingRuleCS()
	 * @generated
	 */
	EReference getMappingRuleCS_MappingBody();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS <em>Mapping Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Query CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS
	 * @generated
	 */
	EClass getMappingQueryCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS#isIsSimpleDefinition <em>Is Simple Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Simple Definition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS#isIsSimpleDefinition()
	 * @see #getMappingQueryCS()
	 * @generated
	 */
	EAttribute getMappingQueryCS_IsSimpleDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS#getBody()
	 * @see #getMappingQueryCS()
	 * @generated
	 */
	EReference getMappingQueryCS_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ConstructorCS <em>Constructor CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ConstructorCS
	 * @generated
	 */
	EClass getConstructorCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ConstructorCS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ConstructorCS#getBody()
	 * @see #getConstructorCS()
	 * @generated
	 */
	EReference getConstructorCS_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS <em>Mapping Section CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Section CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS
	 * @generated
	 */
	EClass getMappingSectionCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS#getStatements()
	 * @see #getMappingSectionCS()
	 * @generated
	 */
	EReference getMappingSectionCS_Statements();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS#getMappingRuleCS <em>Mapping Rule CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Rule CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS#getMappingRuleCS()
	 * @see #getMappingSectionCS()
	 * @generated
	 */
	EReference getMappingSectionCS_MappingRuleCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS <em>Mapping Init CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Init CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS
	 * @generated
	 */
	EClass getMappingInitCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS <em>Mapping End CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping End CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS
	 * @generated
	 */
	EClass getMappingEndCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS <em>Mapping Sections CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Sections CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS
	 * @generated
	 */
	EClass getMappingSectionsCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS#getMappingInitCS <em>Mapping Init CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Init CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS#getMappingInitCS()
	 * @see #getMappingSectionsCS()
	 * @generated
	 */
	EReference getMappingSectionsCS_MappingInitCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS#getMappingBodyCS <em>Mapping Body CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Body CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS#getMappingBodyCS()
	 * @see #getMappingSectionsCS()
	 * @generated
	 */
	EReference getMappingSectionsCS_MappingBodyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS#getMappingEndCS <em>Mapping End CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping End CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS#getMappingEndCS()
	 * @see #getMappingSectionsCS()
	 * @generated
	 */
	EReference getMappingSectionsCS_MappingEndCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.StatementCS <em>Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.StatementCS
	 * @generated
	 */
	EClass getStatementCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS <em>Block Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS
	 * @generated
	 */
	EClass getBlockExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS#getBodyExpressions <em>Body Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Body Expressions</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS#getBodyExpressions()
	 * @see #getBlockExpCS()
	 * @generated
	 */
	EReference getBlockExpCS_BodyExpressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS <em>Compute Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compute Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS
	 * @generated
	 */
	EClass getComputeExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS#getReturnedElement <em>Returned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Returned Element</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS#getReturnedElement()
	 * @see #getComputeExpCS()
	 * @generated
	 */
	EReference getComputeExpCS_ReturnedElement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS#getBody()
	 * @see #getComputeExpCS()
	 * @generated
	 */
	EReference getComputeExpCS_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS <em>While Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS
	 * @generated
	 */
	EClass getWhileExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS#getBody()
	 * @see #getWhileExpCS()
	 * @generated
	 */
	EReference getWhileExpCS_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS#getCondition()
	 * @see #getWhileExpCS()
	 * @generated
	 */
	EReference getWhileExpCS_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS#getResultVar <em>Result Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result Var</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS#getResultVar()
	 * @see #getWhileExpCS()
	 * @generated
	 */
	EReference getWhileExpCS_ResultVar();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImperativeLoopExpCS <em>Imperative Loop Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Loop Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImperativeLoopExpCS
	 * @generated
	 */
	EClass getImperativeLoopExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImperativeLoopExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImperativeLoopExpCS#getCondition()
	 * @see #getImperativeLoopExpCS()
	 * @generated
	 */
	EReference getImperativeLoopExpCS_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ForExpCS <em>For Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ForExpCS
	 * @generated
	 */
	EClass getForExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS <em>Imperative Iterate Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Iterate Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS
	 * @generated
	 */
	EClass getImperativeIterateExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS#getTarget()
	 * @see #getImperativeIterateExpCS()
	 * @generated
	 */
	EReference getImperativeIterateExpCS_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS <em>Switch Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS
	 * @generated
	 */
	EClass getSwitchExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS#getAlternativePart <em>Alternative Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Alternative Part</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS#getAlternativePart()
	 * @see #getSwitchExpCS()
	 * @generated
	 */
	EReference getSwitchExpCS_AlternativePart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS#getElsePart <em>Else Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Part</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS#getElsePart()
	 * @see #getSwitchExpCS()
	 * @generated
	 */
	EReference getSwitchExpCS_ElsePart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS <em>Switch Alt Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Alt Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS
	 * @generated
	 */
	EClass getSwitchAltExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS#getCondition()
	 * @see #getSwitchAltExpCS()
	 * @generated
	 */
	EReference getSwitchAltExpCS_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS#getBody()
	 * @see #getSwitchAltExpCS()
	 * @generated
	 */
	EReference getSwitchAltExpCS_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS <em>Variable Initialization CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Initialization CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS
	 * @generated
	 */
	EClass getVariableInitializationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS#getOclExpressionCS()
	 * @see #getVariableInitializationCS()
	 * @generated
	 */
	EReference getVariableInitializationCS_OclExpressionCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS#getSimpleNameCS()
	 * @see #getVariableInitializationCS()
	 * @generated
	 */
	EReference getVariableInitializationCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS#getTypeCS()
	 * @see #getVariableInitializationCS()
	 * @generated
	 */
	EReference getVariableInitializationCS_TypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS#isWithResult <em>With Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With Result</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS#isWithResult()
	 * @see #getVariableInitializationCS()
	 * @generated
	 */
	EAttribute getVariableInitializationCS_WithResult();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS <em>Assign Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assign Statement CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS
	 * @generated
	 */
	EClass getAssignStatementCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS#getLValueCS <em>LValue CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>LValue CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS#getLValueCS()
	 * @see #getAssignStatementCS()
	 * @generated
	 */
	EReference getAssignStatementCS_LValueCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS#getOclExpressionCS()
	 * @see #getAssignStatementCS()
	 * @generated
	 */
	EReference getAssignStatementCS_OclExpressionCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS#isIncremental <em>Incremental</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Incremental</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS#isIncremental()
	 * @see #getAssignStatementCS()
	 * @generated
	 */
	EAttribute getAssignStatementCS_Incremental();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.BreakExpCS <em>Break Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Break Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.BreakExpCS
	 * @generated
	 */
	EClass getBreakExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ContinueExpCS <em>Continue Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continue Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ContinueExpCS
	 * @generated
	 */
	EClass getContinueExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ExpressionStatementCS <em>Expression Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Statement CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ExpressionStatementCS
	 * @generated
	 */
	EClass getExpressionStatementCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ExpressionStatementCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ExpressionStatementCS#getOclExpressionCS()
	 * @see #getExpressionStatementCS()
	 * @generated
	 */
	EReference getExpressionStatementCS_OclExpressionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS <em>Mapping Body CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Body CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS
	 * @generated
	 */
	EClass getMappingBodyCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS#isHasPopulationKeyword <em>Has Population Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Population Keyword</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS#isHasPopulationKeyword()
	 * @see #getMappingBodyCS()
	 * @generated
	 */
	EAttribute getMappingBodyCS_HasPopulationKeyword();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS <em>Object Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS
	 * @generated
	 */
	EClass getObjectExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS#getSimpleNameCS()
	 * @see #getObjectExpCS()
	 * @generated
	 */
	EReference getObjectExpCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS#getExpressions()
	 * @see #getObjectExpCS()
	 * @generated
	 */
	EReference getObjectExpCS_Expressions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS#isIsImplicit <em>Is Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Implicit</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS#isIsImplicit()
	 * @see #getObjectExpCS()
	 * @generated
	 */
	EAttribute getObjectExpCS_IsImplicit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingCallExpCS <em>Mapping Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Call Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingCallExpCS
	 * @generated
	 */
	EClass getMappingCallExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingCallExpCS#isStrict <em>Strict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strict</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingCallExpCS#isStrict()
	 * @see #getMappingCallExpCS()
	 * @generated
	 */
	EAttribute getMappingCallExpCS_Strict();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImperativeOperationCallExpCS <em>Imperative Operation Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Operation Call Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImperativeOperationCallExpCS
	 * @generated
	 */
	EClass getImperativeOperationCallExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImperativeOperationCallExpCS#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Module</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImperativeOperationCallExpCS#getModule()
	 * @see #getImperativeOperationCallExpCS()
	 * @generated
	 */
	EReference getImperativeOperationCallExpCS_Module();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS <em>Direction Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direction Kind CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS
	 * @generated
	 */
	EClass getDirectionKindCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS#getDirectionKind <em>Direction Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction Kind</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS#getDirectionKind()
	 * @see #getDirectionKindCS()
	 * @generated
	 */
	EAttribute getDirectionKindCS_DirectionKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody <em>Element With Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element With Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody
	 * @generated
	 */
	EClass getElementWithBody();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody#getBodyStartLocation <em>Body Start Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body Start Location</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody#getBodyStartLocation()
	 * @see #getElementWithBody()
	 * @generated
	 */
	EAttribute getElementWithBody_BodyStartLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody#getBodyEndLocation <em>Body End Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body End Location</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody#getBodyEndLocation()
	 * @see #getElementWithBody()
	 * @generated
	 */
	EAttribute getElementWithBody_BodyEndLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS <em>Resolve Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS
	 * @generated
	 */
	EClass getResolveExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS#isOne <em>One</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>One</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS#isOne()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EAttribute getResolveExpCS_One();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS#isIsInverse <em>Is Inverse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Inverse</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS#isIsInverse()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EAttribute getResolveExpCS_IsInverse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS#isIsDeferred <em>Is Deferred</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Deferred</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS#isIsDeferred()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EAttribute getResolveExpCS_IsDeferred();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS#getTarget()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EReference getResolveExpCS_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS#getCondition()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EReference getResolveExpCS_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS <em>Resolve In Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve In Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS
	 * @generated
	 */
	EClass getResolveInExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS#getInMappingType <em>In Mapping Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In Mapping Type</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS#getInMappingType()
	 * @see #getResolveInExpCS()
	 * @generated
	 */
	EReference getResolveInExpCS_InMappingType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS#getInMappingName <em>In Mapping Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In Mapping Name</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS#getInMappingName()
	 * @see #getResolveInExpCS()
	 * @generated
	 */
	EReference getResolveInExpCS_InMappingName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS <em>Model Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Type CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS
	 * @generated
	 */
	EClass getModelTypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getIdentifierCS <em>Identifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getIdentifierCS()
	 * @see #getModelTypeCS()
	 * @generated
	 */
	EReference getModelTypeCS_IdentifierCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getComplianceKindCS <em>Compliance Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compliance Kind CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getComplianceKindCS()
	 * @see #getModelTypeCS()
	 * @generated
	 */
	EReference getModelTypeCS_ComplianceKindCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getPackageRefs <em>Package Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Package Refs</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getPackageRefs()
	 * @see #getModelTypeCS()
	 * @generated
	 */
	EReference getModelTypeCS_PackageRefs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getWhereStatements <em>Where Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Where Statements</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getWhereStatements()
	 * @see #getModelTypeCS()
	 * @generated
	 */
	EReference getModelTypeCS_WhereStatements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS <em>Package Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Ref CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS
	 * @generated
	 */
	EClass getPackageRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS#getPathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS#getPathNameCS()
	 * @see #getPackageRefCS()
	 * @generated
	 */
	EReference getPackageRefCS_PathNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS#getUriCS <em>Uri CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Uri CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS#getUriCS()
	 * @see #getPackageRefCS()
	 * @generated
	 */
	EReference getPackageRefCS_UriCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS <em>Transformation Header CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation Header CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS
	 * @generated
	 */
	EClass getTransformationHeaderCS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getQualifiers <em>Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualifiers</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getQualifiers()
	 * @see #getTransformationHeaderCS()
	 * @generated
	 */
	EAttribute getTransformationHeaderCS_Qualifiers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getPathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getPathNameCS()
	 * @see #getTransformationHeaderCS()
	 * @generated
	 */
	EReference getTransformationHeaderCS_PathNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getParameters()
	 * @see #getTransformationHeaderCS()
	 * @generated
	 */
	EReference getTransformationHeaderCS_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getModuleUsages <em>Module Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Module Usages</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getModuleUsages()
	 * @see #getTransformationHeaderCS()
	 * @generated
	 */
	EReference getTransformationHeaderCS_ModuleUsages();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getTransformationRefineCS <em>Transformation Refine CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transformation Refine CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getTransformationRefineCS()
	 * @see #getTransformationHeaderCS()
	 * @generated
	 */
	EReference getTransformationHeaderCS_TransformationRefineCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS <em>Module Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Kind CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS
	 * @generated
	 */
	EClass getModuleKindCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS#getModuleKind <em>Module Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module Kind</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS#getModuleKind()
	 * @see #getModuleKindCS()
	 * @generated
	 */
	EAttribute getModuleKindCS_ModuleKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS <em>Module Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Ref CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS
	 * @generated
	 */
	EClass getModuleRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS#getPathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS#getPathNameCS()
	 * @see #getModuleRefCS()
	 * @generated
	 */
	EReference getModuleRefCS_PathNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS#getParameters()
	 * @see #getModuleRefCS()
	 * @generated
	 */
	EReference getModuleRefCS_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS <em>Module Usage CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Usage CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS
	 * @generated
	 */
	EClass getModuleUsageCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS#getImportKind <em>Import Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import Kind</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS#getImportKind()
	 * @see #getModuleUsageCS()
	 * @generated
	 */
	EAttribute getModuleUsageCS_ImportKind();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS#getModuleKindCS <em>Module Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Module Kind CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS#getModuleKindCS()
	 * @see #getModuleUsageCS()
	 * @generated
	 */
	EReference getModuleUsageCS_ModuleKindCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS#getModuleRefs <em>Module Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Module Refs</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS#getModuleRefs()
	 * @see #getModuleUsageCS()
	 * @generated
	 */
	EReference getModuleUsageCS_ModuleRefs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS <em>Transformation Refine CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation Refine CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS
	 * @generated
	 */
	EClass getTransformationRefineCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS#getModuleRefCS <em>Module Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Module Ref CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS#getModuleRefCS()
	 * @see #getTransformationRefineCS()
	 * @generated
	 */
	EReference getTransformationRefineCS_ModuleRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS#getSimpleNameCS()
	 * @see #getTransformationRefineCS()
	 * @generated
	 */
	EReference getTransformationRefineCS_SimpleNameCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS <em>Type Spec CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Spec CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS
	 * @generated
	 */
	EClass getTypeSpecCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS#getTypeCS()
	 * @see #getTypeSpecCS()
	 * @generated
	 */
	EReference getTypeSpecCS_TypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS#getSimpleNameCS()
	 * @see #getTypeSpecCS()
	 * @generated
	 */
	EReference getTypeSpecCS_SimpleNameCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS <em>Log Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS
	 * @generated
	 */
	EClass getLogExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS#getCondition()
	 * @see #getLogExpCS()
	 * @generated
	 */
	EReference getLogExpCS_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS <em>Assert Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assert Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS
	 * @generated
	 */
	EClass getAssertExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS#getAssertion <em>Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assertion</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS#getAssertion()
	 * @see #getAssertExpCS()
	 * @generated
	 */
	EReference getAssertExpCS_Assertion();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS#getLog <em>Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS#getLog()
	 * @see #getAssertExpCS()
	 * @generated
	 */
	EReference getAssertExpCS_Log();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Severity</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS#getSeverity()
	 * @see #getAssertExpCS()
	 * @generated
	 */
	EReference getAssertExpCS_Severity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS <em>Return Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS
	 * @generated
	 */
	EClass getReturnExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS#getValue()
	 * @see #getReturnExpCS()
	 * @generated
	 */
	EReference getReturnExpCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS <em>Mapping Extension CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Extension CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS
	 * @generated
	 */
	EClass getMappingExtensionCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS#getKind()
	 * @see #getMappingExtensionCS()
	 * @generated
	 */
	EAttribute getMappingExtensionCS_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS#getMappingIdentifiers <em>Mapping Identifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Identifiers</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS#getMappingIdentifiers()
	 * @see #getMappingExtensionCS()
	 * @generated
	 */
	EReference getMappingExtensionCS_MappingIdentifiers();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.InstantiationExpCS <em>Instantiation Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instantiation Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.InstantiationExpCS
	 * @generated
	 */
	EClass getInstantiationExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.InstantiationExpCS#getTypeSpecCS <em>Type Spec CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Spec CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.InstantiationExpCS#getTypeSpecCS()
	 * @see #getInstantiationExpCS()
	 * @generated
	 */
	EReference getInstantiationExpCS_TypeSpecCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.InstantiationExpCS#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.InstantiationExpCS#getArguments()
	 * @see #getInstantiationExpCS()
	 * @generated
	 */
	EReference getInstantiationExpCS_Arguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ListTypeCS <em>List Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Type CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ListTypeCS
	 * @generated
	 */
	EClass getListTypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ListTypeCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ListTypeCS#getTypeCS()
	 * @see #getListTypeCS()
	 * @generated
	 */
	EReference getListTypeCS_TypeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ListLiteralExpCS <em>List Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Literal Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ListLiteralExpCS
	 * @generated
	 */
	EClass getListLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.ListLiteralExpCS#getCollectionLiteralParts <em>Collection Literal Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collection Literal Parts</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ListLiteralExpCS#getCollectionLiteralParts()
	 * @see #getListLiteralExpCS()
	 * @generated
	 */
	EReference getListLiteralExpCS_CollectionLiteralParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS <em>Dictionary Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dictionary Type CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS
	 * @generated
	 */
	EClass getDictionaryTypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS#getKey()
	 * @see #getDictionaryTypeCS()
	 * @generated
	 */
	EReference getDictionaryTypeCS_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS#getValue()
	 * @see #getDictionaryTypeCS()
	 * @generated
	 */
	EReference getDictionaryTypeCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralExpCS <em>Dict Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dict Literal Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralExpCS
	 * @generated
	 */
	EClass getDictLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralExpCS#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralExpCS#getParts()
	 * @see #getDictLiteralExpCS()
	 * @generated
	 */
	EReference getDictLiteralExpCS_Parts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS <em>Dict Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dict Literal Part CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS
	 * @generated
	 */
	EClass getDictLiteralPartCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS#getKey()
	 * @see #getDictLiteralPartCS()
	 * @generated
	 */
	EReference getDictLiteralPartCS_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS#getValue()
	 * @see #getDictLiteralPartCS()
	 * @generated
	 */
	EReference getDictLiteralPartCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.TagCS <em>Tag CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TagCS
	 * @generated
	 */
	EClass getTagCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.TagCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TagCS#getName()
	 * @see #getTagCS()
	 * @generated
	 */
	EReference getTagCS_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.TagCS#getScopedNameCS <em>Scoped Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scoped Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TagCS#getScopedNameCS()
	 * @see #getTagCS()
	 * @generated
	 */
	EReference getTagCS_ScopedNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.TagCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TagCS#getOclExpressionCS()
	 * @see #getTagCS()
	 * @generated
	 */
	EReference getTagCS_OclExpressionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.UnitCS <em>Unit CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.UnitCS
	 * @generated
	 */
	EClass getUnitCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.UnitCS#getTopLevelElements <em>Top Level Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Top Level Elements</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.UnitCS#getTopLevelElements()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_TopLevelElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.UnitCS#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Modules</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.UnitCS#getModules()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_Modules();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.UnitCS#getModelTypes <em>Model Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Types</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.UnitCS#getModelTypes()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_ModelTypes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.UnitCS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.UnitCS#getImports()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_Imports();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveOpArgsExpCS <em>Resolve Op Args Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve Op Args Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveOpArgsExpCS
	 * @generated
	 */
	EClass getResolveOpArgsExpCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveOpArgsExpCS#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveOpArgsExpCS#getTarget()
	 * @see #getResolveOpArgsExpCS()
	 * @generated
	 */
	EReference getResolveOpArgsExpCS_Target();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveOpArgsExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveOpArgsExpCS#getCondition()
	 * @see #getResolveOpArgsExpCS()
	 * @generated
	 */
	EReference getResolveOpArgsExpCS_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS <em>Scoped Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scoped Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS
	 * @generated
	 */
	EClass getScopedNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS#getTypeCS()
	 * @see #getScopedNameCS()
	 * @generated
	 */
	EReference getScopedNameCS_TypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS#getName()
	 * @see #getScopedNameCS()
	 * @generated
	 */
	EAttribute getScopedNameCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.TryExpCS <em>Try Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Try Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TryExpCS
	 * @generated
	 */
	EClass getTryExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.TryExpCS#getTryBody <em>Try Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Try Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TryExpCS#getTryBody()
	 * @see #getTryExpCS()
	 * @generated
	 */
	EReference getTryExpCS_TryBody();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.TryExpCS#getExceptClauses <em>Except Clauses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Except Clauses</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TryExpCS#getExceptClauses()
	 * @see #getTryExpCS()
	 * @generated
	 */
	EReference getTryExpCS_ExceptClauses();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.CatchExpCS <em>Catch Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catch Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CatchExpCS
	 * @generated
	 */
	EClass getCatchExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.CatchExpCS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CatchExpCS#getBody()
	 * @see #getCatchExpCS()
	 * @generated
	 */
	EReference getCatchExpCS_Body();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.cst.CatchExpCS#getExceptions <em>Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exceptions</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CatchExpCS#getExceptions()
	 * @see #getCatchExpCS()
	 * @generated
	 */
	EReference getCatchExpCS_Exceptions();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.CatchExpCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CatchExpCS#getSimpleNameCS()
	 * @see #getCatchExpCS()
	 * @generated
	 */
	EReference getCatchExpCS_SimpleNameCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.RaiseExpCS <em>Raise Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Raise Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.RaiseExpCS
	 * @generated
	 */
	EClass getRaiseExpCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.RaiseExpCS#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exception</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.RaiseExpCS#getException()
	 * @see #getRaiseExpCS()
	 * @generated
	 */
	EReference getRaiseExpCS_Exception();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.RaiseExpCS#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Argument</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.RaiseExpCS#getArgument()
	 * @see #getRaiseExpCS()
	 * @generated
	 */
	EReference getRaiseExpCS_Argument();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum <em>Direction Kind Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Direction Kind Enum</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum
	 * @generated
	 */
	EEnum getDirectionKindEnum();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum <em>Module Kind Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Module Kind Enum</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum
	 * @generated
	 */
	EEnum getModuleKindEnum();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum <em>Import Kind Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Import Kind Enum</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum
	 * @generated
	 */
	EEnum getImportKindEnum();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionKindCS <em>Mapping Extension Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Mapping Extension Kind CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionKindCS
	 * @generated
	 */
	EEnum getMappingExtensionKindCS();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS <em>Qualifier Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Qualifier Kind CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS
	 * @generated
	 */
	EEnum getQualifierKindCS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CSTFactory getCSTFactory();

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
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingModuleCSImpl <em>Mapping Module CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingModuleCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingModuleCS()
		 * @generated
		 */
		EClass MAPPING_MODULE_CS = eINSTANCE.getMappingModuleCS();

		/**
		 * The meta object literal for the '<em><b>Header CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODULE_CS__HEADER_CS = eINSTANCE.getMappingModuleCS_HeaderCS();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODULE_CS__IMPORTS = eINSTANCE.getMappingModuleCS_Imports();

		/**
		 * The meta object literal for the '<em><b>Metamodels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODULE_CS__METAMODELS = eINSTANCE.getMappingModuleCS_Metamodels();

		/**
		 * The meta object literal for the '<em><b>Renamings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODULE_CS__RENAMINGS = eINSTANCE.getMappingModuleCS_Renamings();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODULE_CS__PROPERTIES = eINSTANCE.getMappingModuleCS_Properties();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODULE_CS__METHODS = eINSTANCE.getMappingModuleCS_Methods();

		/**
		 * The meta object literal for the '<em><b>Classifier Def CS</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODULE_CS__CLASSIFIER_DEF_CS = eINSTANCE.getMappingModuleCS_ClassifierDefCS();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODULE_CS__TAGS = eINSTANCE.getMappingModuleCS_Tags();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.LibraryCSImpl <em>Library CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.LibraryCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getLibraryCS()
		 * @generated
		 */
		EClass LIBRARY_CS = eINSTANCE.getLibraryCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ImportCSImpl <em>Import CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ImportCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getImportCS()
		 * @generated
		 */
		EClass IMPORT_CS = eINSTANCE.getImportCS();

		/**
		 * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT_CS__PATH_NAME_CS = eINSTANCE.getImportCS_PathNameCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.LibraryImportCSImpl <em>Library Import CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.LibraryImportCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getLibraryImportCS()
		 * @generated
		 */
		EClass LIBRARY_IMPORT_CS = eINSTANCE.getLibraryImportCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.RenameCSImpl <em>Rename CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.RenameCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getRenameCS()
		 * @generated
		 */
		EClass RENAME_CS = eINSTANCE.getRenameCS();

		/**
		 * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENAME_CS__TYPE_CS = eINSTANCE.getRenameCS_TypeCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENAME_CS__SIMPLE_NAME_CS = eINSTANCE.getRenameCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Original Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENAME_CS__ORIGINAL_NAME = eINSTANCE.getRenameCS_OriginalName();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModulePropertyCSImpl <em>Module Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ModulePropertyCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getModulePropertyCS()
		 * @generated
		 */
		EClass MODULE_PROPERTY_CS = eINSTANCE.getModulePropertyCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_PROPERTY_CS__SIMPLE_NAME_CS = eINSTANCE.getModulePropertyCS_SimpleNameCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ConfigPropertyCSImpl <em>Config Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ConfigPropertyCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getConfigPropertyCS()
		 * @generated
		 */
		EClass CONFIG_PROPERTY_CS = eINSTANCE.getConfigPropertyCS();

		/**
		 * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG_PROPERTY_CS__TYPE_CS = eINSTANCE.getConfigPropertyCS_TypeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.LocalPropertyCSImpl <em>Local Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.LocalPropertyCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getLocalPropertyCS()
		 * @generated
		 */
		EClass LOCAL_PROPERTY_CS = eINSTANCE.getLocalPropertyCS();

		/**
		 * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_PROPERTY_CS__TYPE_CS = eINSTANCE.getLocalPropertyCS_TypeCS();

		/**
		 * The meta object literal for the '<em><b>Ocl Expression CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_PROPERTY_CS__OCL_EXPRESSION_CS = eINSTANCE.getLocalPropertyCS_OclExpressionCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ContextualPropertyCSImpl <em>Contextual Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ContextualPropertyCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getContextualPropertyCS()
		 * @generated
		 */
		EClass CONTEXTUAL_PROPERTY_CS = eINSTANCE.getContextualPropertyCS();

		/**
		 * The meta object literal for the '<em><b>Scoped Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS = eINSTANCE.getContextualPropertyCS_ScopedNameCS();

		/**
		 * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXTUAL_PROPERTY_CS__TYPE_CS = eINSTANCE.getContextualPropertyCS_TypeCS();

		/**
		 * The meta object literal for the '<em><b>Ocl Expression CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS = eINSTANCE.getContextualPropertyCS_OclExpressionCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ClassifierDefCSImpl <em>Classifier Def CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ClassifierDefCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getClassifierDefCS()
		 * @generated
		 */
		EClass CLASSIFIER_DEF_CS = eINSTANCE.getClassifierDefCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_DEF_CS__SIMPLE_NAME_CS = eINSTANCE.getClassifierDefCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_DEF_CS__EXTENDS = eINSTANCE.getClassifierDefCS_Extends();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_DEF_CS__PROPERTIES = eINSTANCE.getClassifierDefCS_Properties();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_DEF_CS__TAGS = eINSTANCE.getClassifierDefCS_Tags();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ClassifierPropertyCSImpl <em>Classifier Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ClassifierPropertyCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getClassifierPropertyCS()
		 * @generated
		 */
		EClass CLASSIFIER_PROPERTY_CS = eINSTANCE.getClassifierPropertyCS();

		/**
		 * The meta object literal for the '<em><b>Stereotype Qualifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_PROPERTY_CS__STEREOTYPE_QUALIFIERS = eINSTANCE.getClassifierPropertyCS_StereotypeQualifiers();

		/**
		 * The meta object literal for the '<em><b>Feature Keys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_PROPERTY_CS__FEATURE_KEYS = eINSTANCE.getClassifierPropertyCS_FeatureKeys();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_PROPERTY_CS__MULTIPLICITY = eINSTANCE.getClassifierPropertyCS_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_PROPERTY_CS__OPPOSITE = eINSTANCE.getClassifierPropertyCS_Opposite();

		/**
		 * The meta object literal for the '<em><b>Is Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_PROPERTY_CS__IS_ORDERED = eINSTANCE.getClassifierPropertyCS_IsOrdered();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.IntermediateClassDefCSImpl <em>Intermediate Class Def CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.IntermediateClassDefCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getIntermediateClassDefCS()
		 * @generated
		 */
		EClass INTERMEDIATE_CLASS_DEF_CS = eINSTANCE.getIntermediateClassDefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ExceptionDefCSImpl <em>Exception Def CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ExceptionDefCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getExceptionDefCS()
		 * @generated
		 */
		EClass EXCEPTION_DEF_CS = eINSTANCE.getExceptionDefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.OppositePropertyCSImpl <em>Opposite Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.OppositePropertyCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getOppositePropertyCS()
		 * @generated
		 */
		EClass OPPOSITE_PROPERTY_CS = eINSTANCE.getOppositePropertyCS();

		/**
		 * The meta object literal for the '<em><b>Is Navigable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPPOSITE_PROPERTY_CS__IS_NAVIGABLE = eINSTANCE.getOppositePropertyCS_IsNavigable();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPPOSITE_PROPERTY_CS__SIMPLE_NAME_CS = eINSTANCE.getOppositePropertyCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPPOSITE_PROPERTY_CS__MULTIPLICITY = eINSTANCE.getOppositePropertyCS_Multiplicity();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MultiplicityDefCSImpl <em>Multiplicity Def CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MultiplicityDefCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMultiplicityDefCS()
		 * @generated
		 */
		EClass MULTIPLICITY_DEF_CS = eINSTANCE.getMultiplicityDefCS();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLICITY_DEF_CS__LOWER_BOUND = eINSTANCE.getMultiplicityDefCS_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLICITY_DEF_CS__UPPER_BOUND = eINSTANCE.getMultiplicityDefCS_UpperBound();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingDeclarationCSImpl <em>Mapping Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingDeclarationCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingDeclarationCS()
		 * @generated
		 */
		EClass MAPPING_DECLARATION_CS = eINSTANCE.getMappingDeclarationCS();

		/**
		 * The meta object literal for the '<em><b>Qualifiers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_DECLARATION_CS__QUALIFIERS = eINSTANCE.getMappingDeclarationCS_Qualifiers();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_DECLARATION_CS__SIMPLE_NAME_CS = eINSTANCE.getMappingDeclarationCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Context Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_DECLARATION_CS__CONTEXT_TYPE = eINSTANCE.getMappingDeclarationCS_ContextType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_DECLARATION_CS__PARAMETERS = eINSTANCE.getMappingDeclarationCS_Parameters();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_DECLARATION_CS__RESULT = eINSTANCE.getMappingDeclarationCS_Result();

		/**
		 * The meta object literal for the '<em><b>Direction Kind CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_DECLARATION_CS__DIRECTION_KIND_CS = eINSTANCE.getMappingDeclarationCS_DirectionKindCS();

		/**
		 * The meta object literal for the '<em><b>Mapping Extension</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_DECLARATION_CS__MAPPING_EXTENSION = eINSTANCE.getMappingDeclarationCS_MappingExtension();

		/**
		 * The meta object literal for the '<em><b>Is Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_DECLARATION_CS__IS_QUERY = eINSTANCE.getMappingDeclarationCS_IsQuery();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ParameterDeclarationCSImpl <em>Parameter Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ParameterDeclarationCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getParameterDeclarationCS()
		 * @generated
		 */
		EClass PARAMETER_DECLARATION_CS = eINSTANCE.getParameterDeclarationCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS = eINSTANCE.getParameterDeclarationCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Type Spec CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DECLARATION_CS__TYPE_SPEC_CS = eINSTANCE.getParameterDeclarationCS_TypeSpecCS();

		/**
		 * The meta object literal for the '<em><b>Direction Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DECLARATION_CS__DIRECTION_KIND = eINSTANCE.getParameterDeclarationCS_DirectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.SimpleSignatureCSImpl <em>Simple Signature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.SimpleSignatureCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getSimpleSignatureCS()
		 * @generated
		 */
		EClass SIMPLE_SIGNATURE_CS = eINSTANCE.getSimpleSignatureCS();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_SIGNATURE_CS__PARAMS = eINSTANCE.getSimpleSignatureCS_Params();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.CompleteSignatureCSImpl <em>Complete Signature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CompleteSignatureCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getCompleteSignatureCS()
		 * @generated
		 */
		EClass COMPLETE_SIGNATURE_CS = eINSTANCE.getCompleteSignatureCS();

		/**
		 * The meta object literal for the '<em><b>Simple Signature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE = eINSTANCE.getCompleteSignatureCS_SimpleSignature();

		/**
		 * The meta object literal for the '<em><b>Result Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_SIGNATURE_CS__RESULT_PARAMS = eINSTANCE.getCompleteSignatureCS_ResultParams();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingMethodCSImpl <em>Mapping Method CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingMethodCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingMethodCS()
		 * @generated
		 */
		EClass MAPPING_METHOD_CS = eINSTANCE.getMappingMethodCS();

		/**
		 * The meta object literal for the '<em><b>Black Box</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_METHOD_CS__BLACK_BOX = eINSTANCE.getMappingMethodCS_BlackBox();

		/**
		 * The meta object literal for the '<em><b>Mapping Declaration CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_METHOD_CS__MAPPING_DECLARATION_CS = eINSTANCE.getMappingMethodCS_MappingDeclarationCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingRuleCSImpl <em>Mapping Rule CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingRuleCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingRuleCS()
		 * @generated
		 */
		EClass MAPPING_RULE_CS = eINSTANCE.getMappingRuleCS();

		/**
		 * The meta object literal for the '<em><b>Guards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RULE_CS__GUARDS = eINSTANCE.getMappingRuleCS_Guards();

		/**
		 * The meta object literal for the '<em><b>Posts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RULE_CS__POSTS = eINSTANCE.getMappingRuleCS_Posts();

		/**
		 * The meta object literal for the '<em><b>Mapping Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RULE_CS__MAPPING_BODY = eINSTANCE.getMappingRuleCS_MappingBody();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingQueryCSImpl <em>Mapping Query CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingQueryCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingQueryCS()
		 * @generated
		 */
		EClass MAPPING_QUERY_CS = eINSTANCE.getMappingQueryCS();

		/**
		 * The meta object literal for the '<em><b>Is Simple Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION = eINSTANCE.getMappingQueryCS_IsSimpleDefinition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_QUERY_CS__BODY = eINSTANCE.getMappingQueryCS_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ConstructorCSImpl <em>Constructor CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ConstructorCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getConstructorCS()
		 * @generated
		 */
		EClass CONSTRUCTOR_CS = eINSTANCE.getConstructorCS();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR_CS__BODY = eINSTANCE.getConstructorCS_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionCSImpl <em>Mapping Section CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingSectionCS()
		 * @generated
		 */
		EClass MAPPING_SECTION_CS = eINSTANCE.getMappingSectionCS();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_SECTION_CS__STATEMENTS = eINSTANCE.getMappingSectionCS_Statements();

		/**
		 * The meta object literal for the '<em><b>Mapping Rule CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_SECTION_CS__MAPPING_RULE_CS = eINSTANCE.getMappingSectionCS_MappingRuleCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingInitCSImpl <em>Mapping Init CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingInitCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingInitCS()
		 * @generated
		 */
		EClass MAPPING_INIT_CS = eINSTANCE.getMappingInitCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingEndCSImpl <em>Mapping End CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingEndCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingEndCS()
		 * @generated
		 */
		EClass MAPPING_END_CS = eINSTANCE.getMappingEndCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionsCSImpl <em>Mapping Sections CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingSectionsCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingSectionsCS()
		 * @generated
		 */
		EClass MAPPING_SECTIONS_CS = eINSTANCE.getMappingSectionsCS();

		/**
		 * The meta object literal for the '<em><b>Mapping Init CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_SECTIONS_CS__MAPPING_INIT_CS = eINSTANCE.getMappingSectionsCS_MappingInitCS();

		/**
		 * The meta object literal for the '<em><b>Mapping Body CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_SECTIONS_CS__MAPPING_BODY_CS = eINSTANCE.getMappingSectionsCS_MappingBodyCS();

		/**
		 * The meta object literal for the '<em><b>Mapping End CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_SECTIONS_CS__MAPPING_END_CS = eINSTANCE.getMappingSectionsCS_MappingEndCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.StatementCSImpl <em>Statement CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.StatementCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getStatementCS()
		 * @generated
		 */
		EClass STATEMENT_CS = eINSTANCE.getStatementCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.BlockExpCSImpl <em>Block Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.BlockExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getBlockExpCS()
		 * @generated
		 */
		EClass BLOCK_EXP_CS = eINSTANCE.getBlockExpCS();

		/**
		 * The meta object literal for the '<em><b>Body Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_EXP_CS__BODY_EXPRESSIONS = eINSTANCE.getBlockExpCS_BodyExpressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ComputeExpCSImpl <em>Compute Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ComputeExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getComputeExpCS()
		 * @generated
		 */
		EClass COMPUTE_EXP_CS = eINSTANCE.getComputeExpCS();

		/**
		 * The meta object literal for the '<em><b>Returned Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_EXP_CS__RETURNED_ELEMENT = eINSTANCE.getComputeExpCS_ReturnedElement();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_EXP_CS__BODY = eINSTANCE.getComputeExpCS_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.WhileExpCSImpl <em>While Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.WhileExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getWhileExpCS()
		 * @generated
		 */
		EClass WHILE_EXP_CS = eINSTANCE.getWhileExpCS();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_EXP_CS__BODY = eINSTANCE.getWhileExpCS_Body();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_EXP_CS__CONDITION = eINSTANCE.getWhileExpCS_Condition();

		/**
		 * The meta object literal for the '<em><b>Result Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_EXP_CS__RESULT_VAR = eINSTANCE.getWhileExpCS_ResultVar();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ImperativeLoopExpCSImpl <em>Imperative Loop Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ImperativeLoopExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getImperativeLoopExpCS()
		 * @generated
		 */
		EClass IMPERATIVE_LOOP_EXP_CS = eINSTANCE.getImperativeLoopExpCS();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_LOOP_EXP_CS__CONDITION = eINSTANCE.getImperativeLoopExpCS_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ForExpCSImpl <em>For Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ForExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getForExpCS()
		 * @generated
		 */
		EClass FOR_EXP_CS = eINSTANCE.getForExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ImperativeIterateExpCSImpl <em>Imperative Iterate Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ImperativeIterateExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getImperativeIterateExpCS()
		 * @generated
		 */
		EClass IMPERATIVE_ITERATE_EXP_CS = eINSTANCE.getImperativeIterateExpCS();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_ITERATE_EXP_CS__TARGET = eINSTANCE.getImperativeIterateExpCS_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.SwitchExpCSImpl <em>Switch Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.SwitchExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getSwitchExpCS()
		 * @generated
		 */
		EClass SWITCH_EXP_CS = eINSTANCE.getSwitchExpCS();

		/**
		 * The meta object literal for the '<em><b>Alternative Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_EXP_CS__ALTERNATIVE_PART = eINSTANCE.getSwitchExpCS_AlternativePart();

		/**
		 * The meta object literal for the '<em><b>Else Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_EXP_CS__ELSE_PART = eINSTANCE.getSwitchExpCS_ElsePart();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.SwitchAltExpCSImpl <em>Switch Alt Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.SwitchAltExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getSwitchAltExpCS()
		 * @generated
		 */
		EClass SWITCH_ALT_EXP_CS = eINSTANCE.getSwitchAltExpCS();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_ALT_EXP_CS__CONDITION = eINSTANCE.getSwitchAltExpCS_Condition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_ALT_EXP_CS__BODY = eINSTANCE.getSwitchAltExpCS_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.VariableInitializationCSImpl <em>Variable Initialization CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.VariableInitializationCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getVariableInitializationCS()
		 * @generated
		 */
		EClass VARIABLE_INITIALIZATION_CS = eINSTANCE.getVariableInitializationCS();

		/**
		 * The meta object literal for the '<em><b>Ocl Expression CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_INITIALIZATION_CS__OCL_EXPRESSION_CS = eINSTANCE.getVariableInitializationCS_OclExpressionCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_INITIALIZATION_CS__SIMPLE_NAME_CS = eINSTANCE.getVariableInitializationCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_INITIALIZATION_CS__TYPE_CS = eINSTANCE.getVariableInitializationCS_TypeCS();

		/**
		 * The meta object literal for the '<em><b>With Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_INITIALIZATION_CS__WITH_RESULT = eINSTANCE.getVariableInitializationCS_WithResult();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.AssignStatementCSImpl <em>Assign Statement CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.AssignStatementCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getAssignStatementCS()
		 * @generated
		 */
		EClass ASSIGN_STATEMENT_CS = eINSTANCE.getAssignStatementCS();

		/**
		 * The meta object literal for the '<em><b>LValue CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_STATEMENT_CS__LVALUE_CS = eINSTANCE.getAssignStatementCS_LValueCS();

		/**
		 * The meta object literal for the '<em><b>Ocl Expression CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS = eINSTANCE.getAssignStatementCS_OclExpressionCS();

		/**
		 * The meta object literal for the '<em><b>Incremental</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGN_STATEMENT_CS__INCREMENTAL = eINSTANCE.getAssignStatementCS_Incremental();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.BreakExpCSImpl <em>Break Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.BreakExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getBreakExpCS()
		 * @generated
		 */
		EClass BREAK_EXP_CS = eINSTANCE.getBreakExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ContinueExpCSImpl <em>Continue Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ContinueExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getContinueExpCS()
		 * @generated
		 */
		EClass CONTINUE_EXP_CS = eINSTANCE.getContinueExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ExpressionStatementCSImpl <em>Expression Statement CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ExpressionStatementCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getExpressionStatementCS()
		 * @generated
		 */
		EClass EXPRESSION_STATEMENT_CS = eINSTANCE.getExpressionStatementCS();

		/**
		 * The meta object literal for the '<em><b>Ocl Expression CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS = eINSTANCE.getExpressionStatementCS_OclExpressionCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingBodyCSImpl <em>Mapping Body CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingBodyCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingBodyCS()
		 * @generated
		 */
		EClass MAPPING_BODY_CS = eINSTANCE.getMappingBodyCS();

		/**
		 * The meta object literal for the '<em><b>Has Population Keyword</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_BODY_CS__HAS_POPULATION_KEYWORD = eINSTANCE.getMappingBodyCS_HasPopulationKeyword();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ObjectExpCSImpl <em>Object Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ObjectExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getObjectExpCS()
		 * @generated
		 */
		EClass OBJECT_EXP_CS = eINSTANCE.getObjectExpCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_EXP_CS__SIMPLE_NAME_CS = eINSTANCE.getObjectExpCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_EXP_CS__EXPRESSIONS = eINSTANCE.getObjectExpCS_Expressions();

		/**
		 * The meta object literal for the '<em><b>Is Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_EXP_CS__IS_IMPLICIT = eINSTANCE.getObjectExpCS_IsImplicit();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingCallExpCSImpl <em>Mapping Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingCallExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingCallExpCS()
		 * @generated
		 */
		EClass MAPPING_CALL_EXP_CS = eINSTANCE.getMappingCallExpCS();

		/**
		 * The meta object literal for the '<em><b>Strict</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CALL_EXP_CS__STRICT = eINSTANCE.getMappingCallExpCS_Strict();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ImperativeOperationCallExpCSImpl <em>Imperative Operation Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ImperativeOperationCallExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getImperativeOperationCallExpCS()
		 * @generated
		 */
		EClass IMPERATIVE_OPERATION_CALL_EXP_CS = eINSTANCE.getImperativeOperationCallExpCS();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_OPERATION_CALL_EXP_CS__MODULE = eINSTANCE.getImperativeOperationCallExpCS_Module();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.DirectionKindCSImpl <em>Direction Kind CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.DirectionKindCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getDirectionKindCS()
		 * @generated
		 */
		EClass DIRECTION_KIND_CS = eINSTANCE.getDirectionKindCS();

		/**
		 * The meta object literal for the '<em><b>Direction Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTION_KIND_CS__DIRECTION_KIND = eINSTANCE.getDirectionKindCS_DirectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ElementWithBodyImpl <em>Element With Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ElementWithBodyImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getElementWithBody()
		 * @generated
		 */
		EClass ELEMENT_WITH_BODY = eINSTANCE.getElementWithBody();

		/**
		 * The meta object literal for the '<em><b>Body Start Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_WITH_BODY__BODY_START_LOCATION = eINSTANCE.getElementWithBody_BodyStartLocation();

		/**
		 * The meta object literal for the '<em><b>Body End Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_WITH_BODY__BODY_END_LOCATION = eINSTANCE.getElementWithBody_BodyEndLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveExpCSImpl <em>Resolve Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getResolveExpCS()
		 * @generated
		 */
		EClass RESOLVE_EXP_CS = eINSTANCE.getResolveExpCS();

		/**
		 * The meta object literal for the '<em><b>One</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOLVE_EXP_CS__ONE = eINSTANCE.getResolveExpCS_One();

		/**
		 * The meta object literal for the '<em><b>Is Inverse</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOLVE_EXP_CS__IS_INVERSE = eINSTANCE.getResolveExpCS_IsInverse();

		/**
		 * The meta object literal for the '<em><b>Is Deferred</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOLVE_EXP_CS__IS_DEFERRED = eINSTANCE.getResolveExpCS_IsDeferred();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVE_EXP_CS__TARGET = eINSTANCE.getResolveExpCS_Target();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVE_EXP_CS__CONDITION = eINSTANCE.getResolveExpCS_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveInExpCSImpl <em>Resolve In Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveInExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getResolveInExpCS()
		 * @generated
		 */
		EClass RESOLVE_IN_EXP_CS = eINSTANCE.getResolveInExpCS();

		/**
		 * The meta object literal for the '<em><b>In Mapping Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE = eINSTANCE.getResolveInExpCS_InMappingType();

		/**
		 * The meta object literal for the '<em><b>In Mapping Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVE_IN_EXP_CS__IN_MAPPING_NAME = eINSTANCE.getResolveInExpCS_InMappingName();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModelTypeCSImpl <em>Model Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ModelTypeCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getModelTypeCS()
		 * @generated
		 */
		EClass MODEL_TYPE_CS = eINSTANCE.getModelTypeCS();

		/**
		 * The meta object literal for the '<em><b>Identifier CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE_CS__IDENTIFIER_CS = eINSTANCE.getModelTypeCS_IdentifierCS();

		/**
		 * The meta object literal for the '<em><b>Compliance Kind CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE_CS__COMPLIANCE_KIND_CS = eINSTANCE.getModelTypeCS_ComplianceKindCS();

		/**
		 * The meta object literal for the '<em><b>Package Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE_CS__PACKAGE_REFS = eINSTANCE.getModelTypeCS_PackageRefs();

		/**
		 * The meta object literal for the '<em><b>Where Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE_CS__WHERE_STATEMENTS = eINSTANCE.getModelTypeCS_WhereStatements();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.PackageRefCSImpl <em>Package Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.PackageRefCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getPackageRefCS()
		 * @generated
		 */
		EClass PACKAGE_REF_CS = eINSTANCE.getPackageRefCS();

		/**
		 * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_REF_CS__PATH_NAME_CS = eINSTANCE.getPackageRefCS_PathNameCS();

		/**
		 * The meta object literal for the '<em><b>Uri CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_REF_CS__URI_CS = eINSTANCE.getPackageRefCS_UriCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationHeaderCSImpl <em>Transformation Header CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationHeaderCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getTransformationHeaderCS()
		 * @generated
		 */
		EClass TRANSFORMATION_HEADER_CS = eINSTANCE.getTransformationHeaderCS();

		/**
		 * The meta object literal for the '<em><b>Qualifiers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION_HEADER_CS__QUALIFIERS = eINSTANCE.getTransformationHeaderCS_Qualifiers();

		/**
		 * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_HEADER_CS__PATH_NAME_CS = eINSTANCE.getTransformationHeaderCS_PathNameCS();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_HEADER_CS__PARAMETERS = eINSTANCE.getTransformationHeaderCS_Parameters();

		/**
		 * The meta object literal for the '<em><b>Module Usages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_HEADER_CS__MODULE_USAGES = eINSTANCE.getTransformationHeaderCS_ModuleUsages();

		/**
		 * The meta object literal for the '<em><b>Transformation Refine CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS = eINSTANCE.getTransformationHeaderCS_TransformationRefineCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModuleKindCSImpl <em>Module Kind CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ModuleKindCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getModuleKindCS()
		 * @generated
		 */
		EClass MODULE_KIND_CS = eINSTANCE.getModuleKindCS();

		/**
		 * The meta object literal for the '<em><b>Module Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE_KIND_CS__MODULE_KIND = eINSTANCE.getModuleKindCS_ModuleKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModuleRefCSImpl <em>Module Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ModuleRefCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getModuleRefCS()
		 * @generated
		 */
		EClass MODULE_REF_CS = eINSTANCE.getModuleRefCS();

		/**
		 * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_REF_CS__PATH_NAME_CS = eINSTANCE.getModuleRefCS_PathNameCS();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_REF_CS__PARAMETERS = eINSTANCE.getModuleRefCS_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ModuleUsageCSImpl <em>Module Usage CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ModuleUsageCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getModuleUsageCS()
		 * @generated
		 */
		EClass MODULE_USAGE_CS = eINSTANCE.getModuleUsageCS();

		/**
		 * The meta object literal for the '<em><b>Import Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE_USAGE_CS__IMPORT_KIND = eINSTANCE.getModuleUsageCS_ImportKind();

		/**
		 * The meta object literal for the '<em><b>Module Kind CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_USAGE_CS__MODULE_KIND_CS = eINSTANCE.getModuleUsageCS_ModuleKindCS();

		/**
		 * The meta object literal for the '<em><b>Module Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_USAGE_CS__MODULE_REFS = eINSTANCE.getModuleUsageCS_ModuleRefs();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationRefineCSImpl <em>Transformation Refine CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationRefineCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getTransformationRefineCS()
		 * @generated
		 */
		EClass TRANSFORMATION_REFINE_CS = eINSTANCE.getTransformationRefineCS();

		/**
		 * The meta object literal for the '<em><b>Module Ref CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_REFINE_CS__MODULE_REF_CS = eINSTANCE.getTransformationRefineCS_ModuleRefCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS = eINSTANCE.getTransformationRefineCS_SimpleNameCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TypeSpecCSImpl <em>Type Spec CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.TypeSpecCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getTypeSpecCS()
		 * @generated
		 */
		EClass TYPE_SPEC_CS = eINSTANCE.getTypeSpecCS();

		/**
		 * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_SPEC_CS__TYPE_CS = eINSTANCE.getTypeSpecCS_TypeCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_SPEC_CS__SIMPLE_NAME_CS = eINSTANCE.getTypeSpecCS_SimpleNameCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.LogExpCSImpl <em>Log Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.LogExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getLogExpCS()
		 * @generated
		 */
		EClass LOG_EXP_CS = eINSTANCE.getLogExpCS();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOG_EXP_CS__CONDITION = eINSTANCE.getLogExpCS_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.AssertExpCSImpl <em>Assert Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.AssertExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getAssertExpCS()
		 * @generated
		 */
		EClass ASSERT_EXP_CS = eINSTANCE.getAssertExpCS();

		/**
		 * The meta object literal for the '<em><b>Assertion</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT_EXP_CS__ASSERTION = eINSTANCE.getAssertExpCS_Assertion();

		/**
		 * The meta object literal for the '<em><b>Log</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT_EXP_CS__LOG = eINSTANCE.getAssertExpCS_Log();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT_EXP_CS__SEVERITY = eINSTANCE.getAssertExpCS_Severity();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ReturnExpCSImpl <em>Return Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ReturnExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getReturnExpCS()
		 * @generated
		 */
		EClass RETURN_EXP_CS = eINSTANCE.getReturnExpCS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETURN_EXP_CS__VALUE = eINSTANCE.getReturnExpCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingExtensionCSImpl <em>Mapping Extension CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingExtensionCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingExtensionCS()
		 * @generated
		 */
		EClass MAPPING_EXTENSION_CS = eINSTANCE.getMappingExtensionCS();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_EXTENSION_CS__KIND = eINSTANCE.getMappingExtensionCS_Kind();

		/**
		 * The meta object literal for the '<em><b>Mapping Identifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_EXTENSION_CS__MAPPING_IDENTIFIERS = eINSTANCE.getMappingExtensionCS_MappingIdentifiers();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.InstantiationExpCSImpl <em>Instantiation Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.InstantiationExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getInstantiationExpCS()
		 * @generated
		 */
		EClass INSTANTIATION_EXP_CS = eINSTANCE.getInstantiationExpCS();

		/**
		 * The meta object literal for the '<em><b>Type Spec CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION_EXP_CS__TYPE_SPEC_CS = eINSTANCE.getInstantiationExpCS_TypeSpecCS();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION_EXP_CS__ARGUMENTS = eINSTANCE.getInstantiationExpCS_Arguments();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ListTypeCSImpl <em>List Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ListTypeCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getListTypeCS()
		 * @generated
		 */
		EClass LIST_TYPE_CS = eINSTANCE.getListTypeCS();

		/**
		 * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_TYPE_CS__TYPE_CS = eINSTANCE.getListTypeCS_TypeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ListLiteralExpCSImpl <em>List Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ListLiteralExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getListLiteralExpCS()
		 * @generated
		 */
		EClass LIST_LITERAL_EXP_CS = eINSTANCE.getListLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Collection Literal Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS = eINSTANCE.getListLiteralExpCS_CollectionLiteralParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.DictionaryTypeCSImpl <em>Dictionary Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.DictionaryTypeCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getDictionaryTypeCS()
		 * @generated
		 */
		EClass DICTIONARY_TYPE_CS = eINSTANCE.getDictionaryTypeCS();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICTIONARY_TYPE_CS__KEY = eINSTANCE.getDictionaryTypeCS_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICTIONARY_TYPE_CS__VALUE = eINSTANCE.getDictionaryTypeCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.DictLiteralExpCSImpl <em>Dict Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.DictLiteralExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getDictLiteralExpCS()
		 * @generated
		 */
		EClass DICT_LITERAL_EXP_CS = eINSTANCE.getDictLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICT_LITERAL_EXP_CS__PARTS = eINSTANCE.getDictLiteralExpCS_Parts();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.DictLiteralPartCSImpl <em>Dict Literal Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.DictLiteralPartCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getDictLiteralPartCS()
		 * @generated
		 */
		EClass DICT_LITERAL_PART_CS = eINSTANCE.getDictLiteralPartCS();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICT_LITERAL_PART_CS__KEY = eINSTANCE.getDictLiteralPartCS_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICT_LITERAL_PART_CS__VALUE = eINSTANCE.getDictLiteralPartCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TagCSImpl <em>Tag CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.TagCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getTagCS()
		 * @generated
		 */
		EClass TAG_CS = eINSTANCE.getTagCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG_CS__NAME = eINSTANCE.getTagCS_Name();

		/**
		 * The meta object literal for the '<em><b>Scoped Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG_CS__SCOPED_NAME_CS = eINSTANCE.getTagCS_ScopedNameCS();

		/**
		 * The meta object literal for the '<em><b>Ocl Expression CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG_CS__OCL_EXPRESSION_CS = eINSTANCE.getTagCS_OclExpressionCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.UnitCSImpl <em>Unit CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.UnitCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getUnitCS()
		 * @generated
		 */
		EClass UNIT_CS = eINSTANCE.getUnitCS();

		/**
		 * The meta object literal for the '<em><b>Top Level Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CS__TOP_LEVEL_ELEMENTS = eINSTANCE.getUnitCS_TopLevelElements();

		/**
		 * The meta object literal for the '<em><b>Modules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CS__MODULES = eINSTANCE.getUnitCS_Modules();

		/**
		 * The meta object literal for the '<em><b>Model Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CS__MODEL_TYPES = eINSTANCE.getUnitCS_ModelTypes();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CS__IMPORTS = eINSTANCE.getUnitCS_Imports();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveOpArgsExpCSImpl <em>Resolve Op Args Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ResolveOpArgsExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getResolveOpArgsExpCS()
		 * @generated
		 */
		EClass RESOLVE_OP_ARGS_EXP_CS = eINSTANCE.getResolveOpArgsExpCS();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVE_OP_ARGS_EXP_CS__TARGET = eINSTANCE.getResolveOpArgsExpCS_Target();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVE_OP_ARGS_EXP_CS__CONDITION = eINSTANCE.getResolveOpArgsExpCS_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.ScopedNameCSImpl <em>Scoped Name CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.ScopedNameCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getScopedNameCS()
		 * @generated
		 */
		EClass SCOPED_NAME_CS = eINSTANCE.getScopedNameCS();

		/**
		 * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPED_NAME_CS__TYPE_CS = eINSTANCE.getScopedNameCS_TypeCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCOPED_NAME_CS__NAME = eINSTANCE.getScopedNameCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TryExpCSImpl <em>Try Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.TryExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getTryExpCS()
		 * @generated
		 */
		EClass TRY_EXP_CS = eINSTANCE.getTryExpCS();

		/**
		 * The meta object literal for the '<em><b>Try Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_EXP_CS__TRY_BODY = eINSTANCE.getTryExpCS_TryBody();

		/**
		 * The meta object literal for the '<em><b>Except Clauses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_EXP_CS__EXCEPT_CLAUSES = eINSTANCE.getTryExpCS_ExceptClauses();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.CatchExpCSImpl <em>Catch Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CatchExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getCatchExpCS()
		 * @generated
		 */
		EClass CATCH_EXP_CS = eINSTANCE.getCatchExpCS();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATCH_EXP_CS__BODY = eINSTANCE.getCatchExpCS_Body();

		/**
		 * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATCH_EXP_CS__EXCEPTIONS = eINSTANCE.getCatchExpCS_Exceptions();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATCH_EXP_CS__SIMPLE_NAME_CS = eINSTANCE.getCatchExpCS_SimpleNameCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.RaiseExpCSImpl <em>Raise Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.RaiseExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getRaiseExpCS()
		 * @generated
		 */
		EClass RAISE_EXP_CS = eINSTANCE.getRaiseExpCS();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAISE_EXP_CS__EXCEPTION = eINSTANCE.getRaiseExpCS_Exception();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAISE_EXP_CS__ARGUMENT = eINSTANCE.getRaiseExpCS_Argument();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum <em>Direction Kind Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getDirectionKindEnum()
		 * @generated
		 */
		EEnum DIRECTION_KIND_ENUM = eINSTANCE.getDirectionKindEnum();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum <em>Module Kind Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getModuleKindEnum()
		 * @generated
		 */
		EEnum MODULE_KIND_ENUM = eINSTANCE.getModuleKindEnum();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum <em>Import Kind Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getImportKindEnum()
		 * @generated
		 */
		EEnum IMPORT_KIND_ENUM = eINSTANCE.getImportKindEnum();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionKindCS <em>Mapping Extension Kind CS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionKindCS
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getMappingExtensionKindCS()
		 * @generated
		 */
		EEnum MAPPING_EXTENSION_KIND_CS = eINSTANCE.getMappingExtensionKindCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS <em>Qualifier Kind CS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTPackageImpl#getQualifierKindCS()
		 * @generated
		 */
		EEnum QUALIFIER_KIND_CS = eINSTANCE.getQualifierKindCS();

	}

} //CSTPackage
