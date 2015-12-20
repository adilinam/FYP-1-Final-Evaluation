/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage;

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
 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSFactory
 * @model kind="package"
 * @generated
 */
public interface QVTOperationalCSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvtoperationalcs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/pivot/1.0/QVTOperationalCS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtoperationalcs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTOperationalCSPackage eINSTANCE = org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PathName2CSImpl <em>Path Name2 CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PathName2CSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getPathName2CS()
	 * @generated
	 */
	int PATH_NAME2_CS = 0;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME2_CS__CSI = BaseCSPackage.PIVOTABLE_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME2_CS__PARENT = BaseCSPackage.PIVOTABLE_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME2_CS__PIVOT = BaseCSPackage.PIVOTABLE_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Path Elements2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME2_CS__OWNED_PATH_ELEMENTS2 = BaseCSPackage.PIVOTABLE_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Path Name2 CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME2_CS_FEATURE_COUNT = BaseCSPackage.PIVOTABLE_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PathElement2CSImpl <em>Path Element2 CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PathElement2CSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getPathElement2CS()
	 * @generated
	 */
	int PATH_ELEMENT2_CS = 1;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT2_CS__CSI = BaseCSPackage.PIVOTABLE_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT2_CS__PARENT = BaseCSPackage.PIVOTABLE_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT2_CS__PIVOT = BaseCSPackage.PIVOTABLE_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT2_CS__NAME = BaseCSPackage.PIVOTABLE_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Path Name CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT2_CS__OWNING_PATH_NAME_CS = BaseCSPackage.PIVOTABLE_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Path Element2 CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT2_CS_FEATURE_COUNT = BaseCSPackage.PIVOTABLE_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TypedTypeRef2CSImpl <em>Typed Type Ref2 CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TypedTypeRef2CSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTypedTypeRef2CS()
	 * @generated
	 */
	int TYPED_TYPE_REF2_CS = 2;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF2_CS__CSI = BaseCSPackage.TYPED_REF_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF2_CS__PARENT = BaseCSPackage.TYPED_REF_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF2_CS__PIVOT = BaseCSPackage.TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF2_CS__OWNED_MULTIPLICITY = BaseCSPackage.TYPED_REF_CS__OWNED_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF2_CS__OWNED_PATH_NAME = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF2_CS__OWNED_BINDING = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Typed Type Ref2 CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF2_CS_FEATURE_COUNT = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TopLevelCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTopLevelCS()
	 * @generated
	 */
	int TOP_LEVEL_CS = 3;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__CSI = BaseCSPackage.ROOT_PACKAGE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__PARENT = BaseCSPackage.ROOT_PACKAGE_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__PIVOT = BaseCSPackage.ROOT_PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__ORIGINAL_XMI_ID = BaseCSPackage.ROOT_PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_ANNOTATIONS = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_PACKAGES = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_PACKAGES;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_IMPORTS = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Owned Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_TYPES = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Top Level CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS_FEATURE_COUNT = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToClassCSImpl <em>QV To Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToClassCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToClassCS()
	 * @generated
	 */
	int QV_TO_CLASS_CS = 4;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__CSI = BaseCSPackage.STRUCTURED_CLASS_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__PARENT = BaseCSPackage.STRUCTURED_CLASS_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__PIVOT = BaseCSPackage.STRUCTURED_CLASS_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__ORIGINAL_XMI_ID = BaseCSPackage.STRUCTURED_CLASS_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_ANNOTATIONS = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__NAME = BaseCSPackage.STRUCTURED_CLASS_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_SIGNATURE = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__INSTANCE_CLASS_NAME = BaseCSPackage.STRUCTURED_CLASS_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_CONSTRAINTS = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNING_PACKAGE = BaseCSPackage.STRUCTURED_CLASS_CS__OWNING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__IS_ABSTRACT = BaseCSPackage.STRUCTURED_CLASS_CS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__IS_INTERFACE = BaseCSPackage.STRUCTURED_CLASS_CS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Owned Metaclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_METACLASS = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_METACLASS;

	/**
	 * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_OPERATIONS = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Owned Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_PROPERTIES = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owned Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_SUPER_TYPES = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Intermediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__INTERMEDIATE = BaseCSPackage.STRUCTURED_CLASS_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>QV To Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS_FEATURE_COUNT = BaseCSPackage.STRUCTURED_CLASS_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToImportCSImpl <em>QV To Import CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToImportCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToImportCS()
	 * @generated
	 */
	int QV_TO_IMPORT_CS = 5;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__CSI = BaseCSPackage.IMPORT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__PARENT = BaseCSPackage.IMPORT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__PIVOT = BaseCSPackage.IMPORT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__ORIGINAL_XMI_ID = BaseCSPackage.IMPORT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__OWNED_ANNOTATIONS = BaseCSPackage.IMPORT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__NAME = BaseCSPackage.IMPORT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__IS_ALL = BaseCSPackage.IMPORT_CS__IS_ALL;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__OWNED_PATH_NAME = BaseCSPackage.IMPORT_CS__OWNED_PATH_NAME;

	/**
	 * The feature id for the '<em><b>Referred Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__REFERRED_NAMESPACE = BaseCSPackage.IMPORT_CS__REFERRED_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__UNIT = BaseCSPackage.IMPORT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imported Unit Element</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__IMPORTED_UNIT_ELEMENT = BaseCSPackage.IMPORT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>QV To Import CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS_FEATURE_COUNT = BaseCSPackage.IMPORT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleCSImpl <em>Module CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleCS()
	 * @generated
	 */
	int MODULE_CS = 39;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__CSI = BaseCSPackage.STRUCTURED_CLASS_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__PARENT = BaseCSPackage.STRUCTURED_CLASS_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__PIVOT = BaseCSPackage.STRUCTURED_CLASS_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__ORIGINAL_XMI_ID = BaseCSPackage.STRUCTURED_CLASS_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__OWNED_ANNOTATIONS = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__NAME = BaseCSPackage.STRUCTURED_CLASS_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__OWNED_SIGNATURE = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__INSTANCE_CLASS_NAME = BaseCSPackage.STRUCTURED_CLASS_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__OWNED_CONSTRAINTS = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__OWNING_PACKAGE = BaseCSPackage.STRUCTURED_CLASS_CS__OWNING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__IS_ABSTRACT = BaseCSPackage.STRUCTURED_CLASS_CS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__IS_INTERFACE = BaseCSPackage.STRUCTURED_CLASS_CS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Owned Metaclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__OWNED_METACLASS = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_METACLASS;

	/**
	 * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__OWNED_OPERATIONS = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Owned Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__OWNED_PROPERTIES = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owned Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__OWNED_SUPER_TYPES = BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__PARAMETERS = BaseCSPackage.STRUCTURED_CLASS_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Module Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__MODULE_USAGES = BaseCSPackage.STRUCTURED_CLASS_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__TAGS = BaseCSPackage.STRUCTURED_CLASS_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS__QUALIFIERS = BaseCSPackage.STRUCTURED_CLASS_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Module CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CS_FEATURE_COUNT = BaseCSPackage.STRUCTURED_CLASS_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToLibraryCSImpl <em>QV To Library CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToLibraryCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToLibraryCS()
	 * @generated
	 */
	int QV_TO_LIBRARY_CS = 6;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__CSI = MODULE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__PARENT = MODULE_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__PIVOT = MODULE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__ORIGINAL_XMI_ID = MODULE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__OWNED_ANNOTATIONS = MODULE_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__NAME = MODULE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__OWNED_SIGNATURE = MODULE_CS__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__INSTANCE_CLASS_NAME = MODULE_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__OWNED_CONSTRAINTS = MODULE_CS__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__OWNING_PACKAGE = MODULE_CS__OWNING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__IS_ABSTRACT = MODULE_CS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__IS_INTERFACE = MODULE_CS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Owned Metaclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__OWNED_METACLASS = MODULE_CS__OWNED_METACLASS;

	/**
	 * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__OWNED_OPERATIONS = MODULE_CS__OWNED_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Owned Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__OWNED_PROPERTIES = MODULE_CS__OWNED_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owned Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__OWNED_SUPER_TYPES = MODULE_CS__OWNED_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__PARAMETERS = MODULE_CS__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Module Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__MODULE_USAGES = MODULE_CS__MODULE_USAGES;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__TAGS = MODULE_CS__TAGS;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__QUALIFIERS = MODULE_CS__QUALIFIERS;

	/**
	 * The number of structural features of the '<em>QV To Library CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS_FEATURE_COUNT = MODULE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToOperationCSImpl <em>QV To Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToOperationCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToOperationCS()
	 * @generated
	 */
	int QV_TO_OPERATION_CS = 7;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__CSI = BaseCSPackage.OPERATION_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__PARENT = BaseCSPackage.OPERATION_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__PIVOT = BaseCSPackage.OPERATION_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.OPERATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_ANNOTATIONS = BaseCSPackage.OPERATION_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__NAME = BaseCSPackage.OPERATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__IS_OPTIONAL = BaseCSPackage.OPERATION_CS__IS_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_TYPE = BaseCSPackage.OPERATION_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__QUALIFIERS = BaseCSPackage.OPERATION_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_SIGNATURE = BaseCSPackage.OPERATION_CS__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owned Body Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_BODY_EXPRESSIONS = BaseCSPackage.OPERATION_CS__OWNED_BODY_EXPRESSIONS;

	/**
	 * The feature id for the '<em><b>Owned Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_EXCEPTIONS = BaseCSPackage.OPERATION_CS__OWNED_EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_PARAMETERS = BaseCSPackage.OPERATION_CS__OWNED_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owned Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_POSTCONDITIONS = BaseCSPackage.OPERATION_CS__OWNED_POSTCONDITIONS;

	/**
	 * The feature id for the '<em><b>Owned Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_PRECONDITIONS = BaseCSPackage.OPERATION_CS__OWNED_PRECONDITIONS;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNING_CLASS = BaseCSPackage.OPERATION_CS__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__STEREOTYPES = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>QV To Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS_FEATURE_COUNT = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.InitPartCSImpl <em>Init Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.InitPartCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getInitPartCS()
	 * @generated
	 */
	int INIT_PART_CS = 8;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_PART_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_PART_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Init Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_PART_CS__INIT_OP = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_PART_CS__EXPRESSION = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Init Part CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_PART_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MetamodelCSImpl <em>Metamodel CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MetamodelCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMetamodelCS()
	 * @generated
	 */
	int METAMODEL_CS = 9;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__CSI = BaseCSPackage.PACKAGE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__PARENT = BaseCSPackage.PACKAGE_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__PIVOT = BaseCSPackage.PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__ORIGINAL_XMI_ID = BaseCSPackage.PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__OWNED_ANNOTATIONS = BaseCSPackage.PACKAGE_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__OWNED_PACKAGES = BaseCSPackage.PACKAGE_CS__OWNED_PACKAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__NAME = BaseCSPackage.PACKAGE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__NS_PREFIX = BaseCSPackage.PACKAGE_CS__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__NS_URI = BaseCSPackage.PACKAGE_CS__NS_URI;

	/**
	 * The feature id for the '<em><b>Owned Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__OWNED_CLASSES = BaseCSPackage.PACKAGE_CS__OWNED_CLASSES;

	/**
	 * The feature id for the '<em><b>Metamodel Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__METAMODEL_KIND = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Metamodel CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS_FEATURE_COUNT = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PrimitiveTypeCSImpl <em>Primitive Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PrimitiveTypeCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getPrimitiveTypeCS()
	 * @generated
	 */
	int PRIMITIVE_TYPE_CS = 10;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__CSI = BaseCSPackage.DATA_TYPE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__PARENT = BaseCSPackage.DATA_TYPE_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__PIVOT = BaseCSPackage.DATA_TYPE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__ORIGINAL_XMI_ID = BaseCSPackage.DATA_TYPE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__OWNED_ANNOTATIONS = BaseCSPackage.DATA_TYPE_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__NAME = BaseCSPackage.DATA_TYPE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__OWNED_SIGNATURE = BaseCSPackage.DATA_TYPE_CS__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__INSTANCE_CLASS_NAME = BaseCSPackage.DATA_TYPE_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__OWNED_CONSTRAINTS = BaseCSPackage.DATA_TYPE_CS__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__OWNING_PACKAGE = BaseCSPackage.DATA_TYPE_CS__OWNING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Is Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__IS_PRIMITIVE = BaseCSPackage.DATA_TYPE_CS__IS_PRIMITIVE;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__IS_SERIALIZABLE = BaseCSPackage.DATA_TYPE_CS__IS_SERIALIZABLE;

	/**
	 * The number of structural features of the '<em>Primitive Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS_FEATURE_COUNT = BaseCSPackage.DATA_TYPE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierPropertyCSImpl <em>Classifier Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierPropertyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierPropertyCS()
	 * @generated
	 */
	int CLASSIFIER_PROPERTY_CS = 11;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__CSI = BaseCSPackage.STRUCTURAL_FEATURE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__PARENT = BaseCSPackage.STRUCTURAL_FEATURE_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__PIVOT = BaseCSPackage.STRUCTURAL_FEATURE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__ORIGINAL_XMI_ID = BaseCSPackage.STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__OWNED_ANNOTATIONS = BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__NAME = BaseCSPackage.STRUCTURAL_FEATURE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__IS_OPTIONAL = BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__OWNED_TYPE = BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__QUALIFIERS = BaseCSPackage.STRUCTURAL_FEATURE_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__DEFAULT = BaseCSPackage.STRUCTURAL_FEATURE_CS__DEFAULT;

	/**
	 * The feature id for the '<em><b>Owned Default Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__OWNED_DEFAULT_EXPRESSIONS = BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__OWNING_CLASS = BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__STEREOTYPES = BaseCSPackage.STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__OPPOSITE = BaseCSPackage.STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Classifier Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS_FEATURE_COUNT = BaseCSPackage.STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.StereotypeQualifierCSImpl <em>Stereotype Qualifier CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.StereotypeQualifierCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getStereotypeQualifierCS()
	 * @generated
	 */
	int STEREOTYPE_QUALIFIER_CS = 12;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_QUALIFIER_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_QUALIFIER_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_QUALIFIER_CS__STEREOTYPE = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stereotype Qualifier CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_QUALIFIER_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TagCSImpl <em>Tag CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TagCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTagCS()
	 * @generated
	 */
	int TAG_CS = 13;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__CSI = BaseCSPackage.ANNOTATION_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__PARENT = BaseCSPackage.ANNOTATION_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__PIVOT = BaseCSPackage.ANNOTATION_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__ORIGINAL_XMI_ID = BaseCSPackage.ANNOTATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__OWNED_ANNOTATIONS = BaseCSPackage.ANNOTATION_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__NAME = BaseCSPackage.ANNOTATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Details</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__OWNED_DETAILS = BaseCSPackage.ANNOTATION_CS__OWNED_DETAILS;

	/**
	 * The feature id for the '<em><b>Owned Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__OWNED_CONTENTS = BaseCSPackage.ANNOTATION_CS__OWNED_CONTENTS;

	/**
	 * The feature id for the '<em><b>Owned References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__OWNED_REFERENCES = BaseCSPackage.ANNOTATION_CS__OWNED_REFERENCES;

	/**
	 * The feature id for the '<em><b>Element Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__ELEMENT_PATH = BaseCSPackage.ANNOTATION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__EXPRESSION = BaseCSPackage.ANNOTATION_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tag CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS_FEATURE_COUNT = BaseCSPackage.ANNOTATION_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ExceptionCSImpl <em>Exception CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ExceptionCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getExceptionCS()
	 * @generated
	 */
	int EXCEPTION_CS = 14;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__CSI = BaseCSPackage.CLASS_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__PARENT = BaseCSPackage.CLASS_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__PIVOT = BaseCSPackage.CLASS_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__ORIGINAL_XMI_ID = BaseCSPackage.CLASS_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__OWNED_ANNOTATIONS = BaseCSPackage.CLASS_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__NAME = BaseCSPackage.CLASS_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__OWNED_SIGNATURE = BaseCSPackage.CLASS_CS__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__INSTANCE_CLASS_NAME = BaseCSPackage.CLASS_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__OWNED_CONSTRAINTS = BaseCSPackage.CLASS_CS__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__OWNING_PACKAGE = BaseCSPackage.CLASS_CS__OWNING_PACKAGE;

	/**
	 * The number of structural features of the '<em>Exception CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS_FEATURE_COUNT = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierDefCSImpl <em>Classifier Def CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierDefCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierDefCS()
	 * @generated
	 */
	int CLASSIFIER_DEF_CS = 15;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__SIMPLE_NAME_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__EXTENDS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__PROPERTIES = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__TAGS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Classifier Def CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModulePropertyCSImpl <em>Module Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModulePropertyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModulePropertyCS()
	 * @generated
	 */
	int MODULE_PROPERTY_CS = 40;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS__SIMPLE_NAME_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.LocalPropertyCSImpl <em>Local Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.LocalPropertyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getLocalPropertyCS()
	 * @generated
	 */
	int LOCAL_PROPERTY_CS = 24;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY_CS__CSI = MODULE_PROPERTY_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY_CS__PARENT = MODULE_PROPERTY_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierProperty2CSImpl <em>Classifier Property2 CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierProperty2CSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierProperty2CS()
	 * @generated
	 */
	int CLASSIFIER_PROPERTY2_CS = 16;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__CSI = LOCAL_PROPERTY_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__PARENT = LOCAL_PROPERTY_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__SIMPLE_NAME_CS = LOCAL_PROPERTY_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__TYPE_CS = LOCAL_PROPERTY_CS__TYPE_CS;

	/**
	 * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__OCL_EXPRESSION_CS = LOCAL_PROPERTY_CS__OCL_EXPRESSION_CS;

	/**
	 * The feature id for the '<em><b>Stereotype Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__STEREOTYPE_QUALIFIERS = LOCAL_PROPERTY_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Feature Keys</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__FEATURE_KEYS = LOCAL_PROPERTY_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__MULTIPLICITY = LOCAL_PROPERTY_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__OPPOSITE = LOCAL_PROPERTY_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__IS_ORDERED = LOCAL_PROPERTY_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Classifier Property2 CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS_FEATURE_COUNT = LOCAL_PROPERTY_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.CompleteSignatureCSImpl <em>Complete Signature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.CompleteSignatureCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getCompleteSignatureCS()
	 * @generated
	 */
	int COMPLETE_SIGNATURE_CS = 17;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Simple Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__RESULT_PARAMS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Complete Signature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ConfigPropertyCSImpl <em>Config Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ConfigPropertyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getConfigPropertyCS()
	 * @generated
	 */
	int CONFIG_PROPERTY_CS = 18;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_CS__CSI = MODULE_PROPERTY_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_CS__PARENT = MODULE_PROPERTY_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingMethodCSImpl <em>Mapping Method CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingMethodCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingMethodCS()
	 * @generated
	 */
	int MAPPING_METHOD_CS = 30;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Black Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__BLACK_BOX = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Declaration CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__MAPPING_DECLARATION_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Method CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ConstructorCSImpl <em>Constructor CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ConstructorCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getConstructorCS()
	 * @generated
	 */
	int CONSTRUCTOR_CS = 19;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__CSI = MAPPING_METHOD_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__PARENT = MAPPING_METHOD_CS__PARENT;

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
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__EXPRESSIONS = MAPPING_METHOD_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constructor CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS_FEATURE_COUNT = MAPPING_METHOD_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ContextualPropertyCSImpl <em>Contextual Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ContextualPropertyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getContextualPropertyCS()
	 * @generated
	 */
	int CONTEXTUAL_PROPERTY_CS = 20;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__CSI = MODULE_PROPERTY_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__PARENT = MODULE_PROPERTY_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ElementWithBodyImpl <em>Element With Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ElementWithBodyImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getElementWithBody()
	 * @generated
	 */
	int ELEMENT_WITH_BODY = 21;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_BODY__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_BODY__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_BODY__BODY_START_LOCATION = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_BODY__BODY_END_LOCATION = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Element With Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_BODY_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ImperativeOperationCallExpCSImpl <em>Imperative Operation Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ImperativeOperationCallExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getImperativeOperationCallExpCS()
	 * @generated
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS = 22;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__CSI = EssentialOCLCSPackage.CALL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__PARENT = EssentialOCLCSPackage.CALL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__PIVOT = EssentialOCLCSPackage.CALL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.CALL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__OWNED_ANNOTATIONS = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__HAS_ERROR = EssentialOCLCSPackage.CALL_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__LOCAL_LEFT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__LOCAL_PARENT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__LOCAL_RIGHT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__PRECEDENCE = EssentialOCLCSPackage.CALL_EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__IS_PRE = EssentialOCLCSPackage.CALL_EXP_CS__IS_PRE;

	/**
	 * The feature id for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__OWNED_PATH_NAME = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_PATH_NAME;

	/**
	 * The feature id for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Square Bracketed Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__SOURCE_TYPE = EssentialOCLCSPackage.CALL_EXP_CS__SOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Source Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__SOURCE_TYPE_VALUE = EssentialOCLCSPackage.CALL_EXP_CS__SOURCE_TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__ARGUMENTS = EssentialOCLCSPackage.CALL_EXP_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__SOURCE = EssentialOCLCSPackage.CALL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__MODULE = EssentialOCLCSPackage.CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imperative Operation Call Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS_FEATURE_COUNT = EssentialOCLCSPackage.CALL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.LibraryImportCSImpl <em>Library Import CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.LibraryImportCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getLibraryImportCS()
	 * @generated
	 */
	int LIBRARY_IMPORT_CS = 23;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__CSI = QV_TO_IMPORT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__PARENT = QV_TO_IMPORT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__PIVOT = QV_TO_IMPORT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__ORIGINAL_XMI_ID = QV_TO_IMPORT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__OWNED_ANNOTATIONS = QV_TO_IMPORT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__NAME = QV_TO_IMPORT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__IS_ALL = QV_TO_IMPORT_CS__IS_ALL;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__OWNED_PATH_NAME = QV_TO_IMPORT_CS__OWNED_PATH_NAME;

	/**
	 * The feature id for the '<em><b>Referred Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__REFERRED_NAMESPACE = QV_TO_IMPORT_CS__REFERRED_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__UNIT = QV_TO_IMPORT_CS__UNIT;

	/**
	 * The feature id for the '<em><b>Imported Unit Element</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__IMPORTED_UNIT_ELEMENT = QV_TO_IMPORT_CS__IMPORTED_UNIT_ELEMENT;

	/**
	 * The number of structural features of the '<em>Library Import CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS_FEATURE_COUNT = QV_TO_IMPORT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingSectionCSImpl <em>Mapping Section CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingSectionCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingSectionCS()
	 * @generated
	 */
	int MAPPING_SECTION_CS = 33;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__BODY_START_LOCATION = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__BODY_END_LOCATION = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__STATEMENTS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mapping Rule CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__MAPPING_RULE_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping Section CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingBodyCSImpl <em>Mapping Body CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingBodyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingBodyCS()
	 * @generated
	 */
	int MAPPING_BODY_CS = 25;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__CSI = MAPPING_SECTION_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__PARENT = MAPPING_SECTION_CS__PARENT;

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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingCallExpCSImpl <em>Mapping Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingCallExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingCallExpCS()
	 * @generated
	 */
	int MAPPING_CALL_EXP_CS = 26;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__CSI = IMPERATIVE_OPERATION_CALL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__PARENT = IMPERATIVE_OPERATION_CALL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__PIVOT = IMPERATIVE_OPERATION_CALL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__ORIGINAL_XMI_ID = IMPERATIVE_OPERATION_CALL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__OWNED_ANNOTATIONS = IMPERATIVE_OPERATION_CALL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__HAS_ERROR = IMPERATIVE_OPERATION_CALL_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__LOCAL_LEFT = IMPERATIVE_OPERATION_CALL_EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = IMPERATIVE_OPERATION_CALL_EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__LOCAL_PARENT = IMPERATIVE_OPERATION_CALL_EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__LOCAL_RIGHT = IMPERATIVE_OPERATION_CALL_EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = IMPERATIVE_OPERATION_CALL_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__PRECEDENCE = IMPERATIVE_OPERATION_CALL_EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__IS_PRE = IMPERATIVE_OPERATION_CALL_EXP_CS__IS_PRE;

	/**
	 * The feature id for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = IMPERATIVE_OPERATION_CALL_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__OWNED_PATH_NAME = IMPERATIVE_OPERATION_CALL_EXP_CS__OWNED_PATH_NAME;

	/**
	 * The feature id for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE = IMPERATIVE_OPERATION_CALL_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Square Bracketed Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES = IMPERATIVE_OPERATION_CALL_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__SOURCE_TYPE = IMPERATIVE_OPERATION_CALL_EXP_CS__SOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Source Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__SOURCE_TYPE_VALUE = IMPERATIVE_OPERATION_CALL_EXP_CS__SOURCE_TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__ARGUMENTS = IMPERATIVE_OPERATION_CALL_EXP_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__SOURCE = IMPERATIVE_OPERATION_CALL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Module</b></em>' attribute.
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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl <em>Mapping Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingOperationCS()
	 * @generated
	 */
	int MAPPING_OPERATION_CS = 27;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__CSI = BaseCSPackage.OPERATION_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__PARENT = BaseCSPackage.OPERATION_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__PIVOT = BaseCSPackage.OPERATION_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.OPERATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_ANNOTATIONS = BaseCSPackage.OPERATION_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__NAME = BaseCSPackage.OPERATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__IS_OPTIONAL = BaseCSPackage.OPERATION_CS__IS_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_TYPE = BaseCSPackage.OPERATION_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__QUALIFIERS = BaseCSPackage.OPERATION_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_SIGNATURE = BaseCSPackage.OPERATION_CS__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owned Body Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_BODY_EXPRESSIONS = BaseCSPackage.OPERATION_CS__OWNED_BODY_EXPRESSIONS;

	/**
	 * The feature id for the '<em><b>Owned Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_EXCEPTIONS = BaseCSPackage.OPERATION_CS__OWNED_EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_PARAMETERS = BaseCSPackage.OPERATION_CS__OWNED_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owned Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_POSTCONDITIONS = BaseCSPackage.OPERATION_CS__OWNED_POSTCONDITIONS;

	/**
	 * The feature id for the '<em><b>Owned Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_PRECONDITIONS = BaseCSPackage.OPERATION_CS__OWNED_PRECONDITIONS;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNING_CLASS = BaseCSPackage.OPERATION_CS__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__RESULTS = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__DIRECTION = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__IS_QUERY = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__WHEN = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__WHERE = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Inherits</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__INHERITS = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Disjuncts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__DISJUNCTS = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Merges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__MERGES = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__REFINES = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Scoped Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__SCOPED_NAME = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Mapping Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS_FEATURE_COUNT = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingEndCSImpl <em>Mapping End CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingEndCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingEndCS()
	 * @generated
	 */
	int MAPPING_END_CS = 28;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_END_CS__CSI = MAPPING_SECTION_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_END_CS__PARENT = MAPPING_SECTION_CS__PARENT;

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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingInitCSImpl <em>Mapping Init CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingInitCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingInitCS()
	 * @generated
	 */
	int MAPPING_INIT_CS = 29;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INIT_CS__CSI = MAPPING_SECTION_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INIT_CS__PARENT = MAPPING_SECTION_CS__PARENT;

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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingQueryCSImpl <em>Mapping Query CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingQueryCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingQueryCS()
	 * @generated
	 */
	int MAPPING_QUERY_CS = 31;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__CSI = MAPPING_METHOD_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__PARENT = MAPPING_METHOD_CS__PARENT;

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
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__EXPRESSIONS = MAPPING_METHOD_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Simple Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION = MAPPING_METHOD_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Query CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS_FEATURE_COUNT = MAPPING_METHOD_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingRuleCSImpl <em>Mapping Rule CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingRuleCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingRuleCS()
	 * @generated
	 */
	int MAPPING_RULE_CS = 32;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__CSI = MAPPING_METHOD_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__PARENT = MAPPING_METHOD_CS__PARENT;

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
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__GUARD = MAPPING_METHOD_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__MAPPING_BODY = MAPPING_METHOD_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Rule CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS_FEATURE_COUNT = MAPPING_METHOD_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingSectionsCSImpl <em>Mapping Sections CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingSectionsCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingSectionsCS()
	 * @generated
	 */
	int MAPPING_SECTIONS_CS = 34;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Mapping Init CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__MAPPING_INIT_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Body CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__MAPPING_BODY_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mapping End CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__MAPPING_END_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapping Sections CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleKindCSImpl <em>Module Kind CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleKindCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleKindCS()
	 * @generated
	 */
	int MODULE_KIND_CS = 35;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Module Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS__MODULE_KIND = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module Kind CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleRefCSImpl <em>Module Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleRefCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleRefCS()
	 * @generated
	 */
	int MODULE_REF_CS = 36;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Module Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__MODULE_PATH = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__PARAMETERS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Module Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModelTypeCSImpl <em>Model Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModelTypeCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModelTypeCS()
	 * @generated
	 */
	int MODEL_TYPE_CS = 37;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__CSI = BaseCSPackage.CLASS_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__PARENT = BaseCSPackage.CLASS_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__PIVOT = BaseCSPackage.CLASS_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__ORIGINAL_XMI_ID = BaseCSPackage.CLASS_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__OWNED_ANNOTATIONS = BaseCSPackage.CLASS_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__NAME = BaseCSPackage.CLASS_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__OWNED_SIGNATURE = BaseCSPackage.CLASS_CS__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__INSTANCE_CLASS_NAME = BaseCSPackage.CLASS_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__OWNED_CONSTRAINTS = BaseCSPackage.CLASS_CS__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__OWNING_PACKAGE = BaseCSPackage.CLASS_CS__OWNING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__BODY_START_LOCATION = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__BODY_END_LOCATION = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Compliance Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__COMPLIANCE_KIND = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Package Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__PACKAGE_REFS = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__WHERE = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Model Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS_FEATURE_COUNT = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModelTypeRefCSImpl <em>Model Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModelTypeRefCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModelTypeRefCS()
	 * @generated
	 */
	int MODEL_TYPE_REF_CS = 38;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_REF_CS__CSI = BaseCSPackage.PARAMETER_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_REF_CS__PARENT = BaseCSPackage.PARAMETER_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_REF_CS__PIVOT = BaseCSPackage.PARAMETER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_REF_CS__ORIGINAL_XMI_ID = BaseCSPackage.PARAMETER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_REF_CS__OWNED_ANNOTATIONS = BaseCSPackage.PARAMETER_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_REF_CS__NAME = BaseCSPackage.PARAMETER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_REF_CS__IS_OPTIONAL = BaseCSPackage.PARAMETER_CS__IS_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_REF_CS__OWNED_TYPE = BaseCSPackage.PARAMETER_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_REF_CS__QUALIFIERS = BaseCSPackage.PARAMETER_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Owning Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_REF_CS__OWNING_OPERATION = BaseCSPackage.PARAMETER_CS__OWNING_OPERATION;

	/**
	 * The number of structural features of the '<em>Model Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_REF_CS_FEATURE_COUNT = BaseCSPackage.PARAMETER_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleUsageCSImpl <em>Module Usage CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleUsageCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleUsageCS()
	 * @generated
	 */
	int MODULE_USAGE_CS = 41;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Import Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__IMPORT_KIND = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Module Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__MODULE_KIND = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Module Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__MODULE_REFS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Module Usage CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MultiplicityDefCSImpl <em>Multiplicity Def CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MultiplicityDefCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMultiplicityDefCS()
	 * @generated
	 */
	int MULTIPLICITY_DEF_CS = 42;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__LOWER_BOUND = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__UPPER_BOUND = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multiplicity Def CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ObjectExpCSImpl <em>Object Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ObjectExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getObjectExpCS()
	 * @generated
	 */
	int OBJECT_EXP_CS = 43;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__CSI = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__PARENT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__PIVOT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__ORIGINAL_XMI_ID = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__OWNED_ANNOTATIONS = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__HAS_ERROR = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__LOCAL_LEFT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__LOCAL_PARENT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__LOCAL_RIGHT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__PRECEDENCE = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__BODY = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__BODY;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__SIMPLE_NAME_CS = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__IS_IMPLICIT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS_FEATURE_COUNT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.OppositePropertyCSImpl <em>Opposite Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.OppositePropertyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getOppositePropertyCS()
	 * @generated
	 */
	int OPPOSITE_PROPERTY_CS = 44;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Is Navigable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__IS_NAVIGABLE = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__SIMPLE_NAME_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__MULTIPLICITY = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Opposite Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ParameterDeclarationCSImpl <em>Parameter Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ParameterDeclarationCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getParameterDeclarationCS()
	 * @generated
	 */
	int PARAMETER_DECLARATION_CS = 45;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__CSI = BaseCSPackage.PARAMETER_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__PARENT = BaseCSPackage.PARAMETER_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__PIVOT = BaseCSPackage.PARAMETER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.PARAMETER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__OWNED_ANNOTATIONS = BaseCSPackage.PARAMETER_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__NAME = BaseCSPackage.PARAMETER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__IS_OPTIONAL = BaseCSPackage.PARAMETER_CS__IS_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__OWNED_TYPE = BaseCSPackage.PARAMETER_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__QUALIFIERS = BaseCSPackage.PARAMETER_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Owning Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__OWNING_OPERATION = BaseCSPackage.PARAMETER_CS__OWNING_OPERATION;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__DIRECTION = BaseCSPackage.PARAMETER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__INIT_PART = BaseCSPackage.PARAMETER_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS_FEATURE_COUNT = BaseCSPackage.PARAMETER_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.RenameCSImpl <em>Rename CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.RenameCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getRenameCS()
	 * @generated
	 */
	int RENAME_CS = 46;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__TYPE_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__SIMPLE_NAME_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Original Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__ORIGINAL_NAME = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rename CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveOpArgsExpCSImpl <em>Resolve Op Args Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveOpArgsExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getResolveOpArgsExpCS()
	 * @generated
	 */
	int RESOLVE_OP_ARGS_EXP_CS = 47;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__TARGET = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__CONDITION = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resolve Op Args Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PackageRefCSImpl <em>Package Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PackageRefCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getPackageRefCS()
	 * @generated
	 */
	int PACKAGE_REF_CS = 48;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Package Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__PACKAGE_PATH = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__URI = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ScopedNameCSImpl <em>Scoped Name CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ScopedNameCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getScopedNameCS()
	 * @generated
	 */
	int SCOPED_NAME_CS = 49;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__TYPE_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__NAME = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scoped Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.SimpleSignatureCSImpl <em>Simple Signature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.SimpleSignatureCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getSimpleSignatureCS()
	 * @generated
	 */
	int SIMPLE_SIGNATURE_CS = 50;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS__PARAMETER = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Signature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TransformationCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTransformationCS()
	 * @generated
	 */
	int TRANSFORMATION_CS = 51;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__CSI = MODULE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PARENT = MODULE_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PIVOT = MODULE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__ORIGINAL_XMI_ID = MODULE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_ANNOTATIONS = MODULE_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__NAME = MODULE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_SIGNATURE = MODULE_CS__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__INSTANCE_CLASS_NAME = MODULE_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_CONSTRAINTS = MODULE_CS__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNING_PACKAGE = MODULE_CS__OWNING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__IS_ABSTRACT = MODULE_CS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__IS_INTERFACE = MODULE_CS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Owned Metaclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_METACLASS = MODULE_CS__OWNED_METACLASS;

	/**
	 * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_OPERATIONS = MODULE_CS__OWNED_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Owned Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_PROPERTIES = MODULE_CS__OWNED_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owned Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_SUPER_TYPES = MODULE_CS__OWNED_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PARAMETERS = MODULE_CS__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Module Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__MODULE_USAGES = MODULE_CS__MODULE_USAGES;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__TAGS = MODULE_CS__TAGS;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__QUALIFIERS = MODULE_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__REFINES = MODULE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Transformation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS_FEATURE_COUNT = MODULE_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TransformationRefineCSImpl <em>Transformation Refine CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TransformationRefineCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTransformationRefineCS()
	 * @generated
	 */
	int TRANSFORMATION_REFINE_CS = 52;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Module Ref CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__MODULE_REF_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Transformation Refine CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TypeSpecCSImpl <em>Type Spec CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TypeSpecCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTypeSpecCS()
	 * @generated
	 */
	int TYPE_SPEC_CS = 53;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__CSI = BaseCSPackage.TYPED_REF_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__PARENT = BaseCSPackage.TYPED_REF_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__PIVOT = BaseCSPackage.TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__OWNED_MULTIPLICITY = BaseCSPackage.TYPED_REF_CS__OWNED_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__OWNED_TYPE = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extent Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__EXTENT_LOCATION = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Spec CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS_FEATURE_COUNT = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.UnitCSImpl <em>Unit CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.UnitCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getUnitCS()
	 * @generated
	 */
	int UNIT_CS = 54;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Segment</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__SEGMENT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Top Level Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__TOP_LEVEL_ELEMENTS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__MODULES = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Model Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__MODEL_TYPES = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__IMPORTS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Unit CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveExpCSImpl <em>Resolve Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getResolveExpCS()
	 * @generated
	 */
	int RESOLVE_EXP_CS = 55;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__CSI = EssentialOCLCSPackage.CALL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__PARENT = EssentialOCLCSPackage.CALL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__PIVOT = EssentialOCLCSPackage.CALL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.CALL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__OWNED_ANNOTATIONS = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__HAS_ERROR = EssentialOCLCSPackage.CALL_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__LOCAL_LEFT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__LOCAL_PARENT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__LOCAL_RIGHT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__PRECEDENCE = EssentialOCLCSPackage.CALL_EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__IS_PRE = EssentialOCLCSPackage.CALL_EXP_CS__IS_PRE;

	/**
	 * The feature id for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__OWNED_PATH_NAME = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_PATH_NAME;

	/**
	 * The feature id for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Square Bracketed Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__SOURCE_TYPE = EssentialOCLCSPackage.CALL_EXP_CS__SOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Source Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__SOURCE_TYPE_VALUE = EssentialOCLCSPackage.CALL_EXP_CS__SOURCE_TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__ARGUMENTS = EssentialOCLCSPackage.CALL_EXP_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__SOURCE = EssentialOCLCSPackage.CALL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>One</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__ONE = EssentialOCLCSPackage.CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Inverse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__IS_INVERSE = EssentialOCLCSPackage.CALL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Deferred</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__IS_DEFERRED = EssentialOCLCSPackage.CALL_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__TARGET = EssentialOCLCSPackage.CALL_EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__CONDITION = EssentialOCLCSPackage.CALL_EXP_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Resolve Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS_FEATURE_COUNT = EssentialOCLCSPackage.CALL_EXP_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveInExpCSImpl <em>Resolve In Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveInExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getResolveInExpCS()
	 * @generated
	 */
	int RESOLVE_IN_EXP_CS = 56;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__CSI = RESOLVE_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__PARENT = RESOLVE_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__PIVOT = RESOLVE_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__ORIGINAL_XMI_ID = RESOLVE_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__OWNED_ANNOTATIONS = RESOLVE_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__HAS_ERROR = RESOLVE_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__LOCAL_LEFT = RESOLVE_EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = RESOLVE_EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__LOCAL_PARENT = RESOLVE_EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__LOCAL_RIGHT = RESOLVE_EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = RESOLVE_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__PRECEDENCE = RESOLVE_EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__IS_PRE = RESOLVE_EXP_CS__IS_PRE;

	/**
	 * The feature id for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = RESOLVE_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__OWNED_PATH_NAME = RESOLVE_EXP_CS__OWNED_PATH_NAME;

	/**
	 * The feature id for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE = RESOLVE_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Square Bracketed Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES = RESOLVE_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__SOURCE_TYPE = RESOLVE_EXP_CS__SOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Source Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__SOURCE_TYPE_VALUE = RESOLVE_EXP_CS__SOURCE_TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__ARGUMENTS = RESOLVE_EXP_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__SOURCE = RESOLVE_EXP_CS__SOURCE;

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
	 * The feature id for the '<em><b>In Mapping Name</b></em>' attribute.
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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierKind <em>Classifier Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierKind
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierKind()
	 * @generated
	 */
	int CLASSIFIER_KIND = 57;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.FeatureKey <em>Feature Key</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.FeatureKey
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getFeatureKey()
	 * @generated
	 */
	int FEATURE_KEY = 58;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitOp <em>Init Op</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitOp
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getInitOp()
	 * @generated
	 */
	int INIT_OP = 59;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelKind <em>Metamodel Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelKind
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMetamodelKind()
	 * @generated
	 */
	int METAMODEL_KIND = 60;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.DirectionKindCS <em>Direction Kind CS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.DirectionKindCS
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getDirectionKindCS()
	 * @generated
	 */
	int DIRECTION_KIND_CS = 61;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImportKindEnum <em>Import Kind Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImportKindEnum
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getImportKindEnum()
	 * @generated
	 */
	int IMPORT_KIND_ENUM = 62;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingExtensionKindCS <em>Mapping Extension Kind CS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingExtensionKindCS
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingExtensionKindCS()
	 * @generated
	 */
	int MAPPING_EXTENSION_KIND_CS = 63;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindEnum <em>Module Kind Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindEnum
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleKindEnum()
	 * @generated
	 */
	int MODULE_KIND_ENUM = 64;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.QualifierKindCS <em>Qualifier Kind CS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QualifierKindCS
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQualifierKindCS()
	 * @generated
	 */
	int QUALIFIER_KIND_CS = 65;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathName2CS <em>Path Name2 CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Name2 CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathName2CS
	 * @generated
	 */
	EClass getPathName2CS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathName2CS#getOwnedPathElements2 <em>Owned Path Elements2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Path Elements2</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathName2CS#getOwnedPathElements2()
	 * @see #getPathName2CS()
	 * @generated
	 */
	EReference getPathName2CS_OwnedPathElements2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathElement2CS <em>Path Element2 CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Element2 CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathElement2CS
	 * @generated
	 */
	EClass getPathElement2CS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathElement2CS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathElement2CS#getName()
	 * @see #getPathElement2CS()
	 * @generated
	 */
	EAttribute getPathElement2CS_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathElement2CS#getOwningPathNameCS <em>Owning Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owning Path Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathElement2CS#getOwningPathNameCS()
	 * @see #getPathElement2CS()
	 * @generated
	 */
	EReference getPathElement2CS_OwningPathNameCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypedTypeRef2CS <em>Typed Type Ref2 CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Type Ref2 CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypedTypeRef2CS
	 * @generated
	 */
	EClass getTypedTypeRef2CS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypedTypeRef2CS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypedTypeRef2CS#getOwnedPathName()
	 * @see #getTypedTypeRef2CS()
	 * @generated
	 */
	EReference getTypedTypeRef2CS_OwnedPathName();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypedTypeRef2CS#getOwnedBinding <em>Owned Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Binding</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypedTypeRef2CS#getOwnedBinding()
	 * @see #getTypedTypeRef2CS()
	 * @generated
	 */
	EReference getTypedTypeRef2CS_OwnedBinding();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TopLevelCS <em>Top Level CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TopLevelCS
	 * @generated
	 */
	EClass getTopLevelCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TopLevelCS#getOwnedTypes <em>Owned Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Types</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TopLevelCS#getOwnedTypes()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_OwnedTypes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToClassCS <em>QV To Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QV To Class CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToClassCS
	 * @generated
	 */
	EClass getQVToClassCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToClassCS#isIntermediate <em>Intermediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intermediate</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToClassCS#isIntermediate()
	 * @see #getQVToClassCS()
	 * @generated
	 */
	EAttribute getQVToClassCS_Intermediate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToImportCS <em>QV To Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QV To Import CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToImportCS
	 * @generated
	 */
	EClass getQVToImportCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToImportCS#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToImportCS#getUnit()
	 * @see #getQVToImportCS()
	 * @generated
	 */
	EReference getQVToImportCS_Unit();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToImportCS#getImportedUnitElement <em>Imported Unit Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Imported Unit Element</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToImportCS#getImportedUnitElement()
	 * @see #getQVToImportCS()
	 * @generated
	 */
	EAttribute getQVToImportCS_ImportedUnitElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToLibraryCS <em>QV To Library CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QV To Library CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToLibraryCS
	 * @generated
	 */
	EClass getQVToLibraryCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToOperationCS <em>QV To Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QV To Operation CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToOperationCS
	 * @generated
	 */
	EClass getQVToOperationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToOperationCS#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stereotypes</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToOperationCS#getStereotypes()
	 * @see #getQVToOperationCS()
	 * @generated
	 */
	EReference getQVToOperationCS_Stereotypes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitPartCS <em>Init Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Init Part CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitPartCS
	 * @generated
	 */
	EClass getInitPartCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitPartCS#getInitOp <em>Init Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init Op</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitPartCS#getInitOp()
	 * @see #getInitPartCS()
	 * @generated
	 */
	EAttribute getInitPartCS_InitOp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitPartCS#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitPartCS#getExpression()
	 * @see #getInitPartCS()
	 * @generated
	 */
	EReference getInitPartCS_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelCS <em>Metamodel CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metamodel CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelCS
	 * @generated
	 */
	EClass getMetamodelCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelCS#getMetamodelKind <em>Metamodel Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metamodel Kind</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelCS#getMetamodelKind()
	 * @see #getMetamodelCS()
	 * @generated
	 */
	EAttribute getMetamodelCS_MetamodelKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.PrimitiveTypeCS <em>Primitive Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.PrimitiveTypeCS
	 * @generated
	 */
	EClass getPrimitiveTypeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierPropertyCS <em>Classifier Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Property CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierPropertyCS
	 * @generated
	 */
	EClass getClassifierPropertyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierPropertyCS#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stereotypes</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierPropertyCS#getStereotypes()
	 * @see #getClassifierPropertyCS()
	 * @generated
	 */
	EReference getClassifierPropertyCS_Stereotypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierPropertyCS#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opposite</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierPropertyCS#getOpposite()
	 * @see #getClassifierPropertyCS()
	 * @generated
	 */
	EAttribute getClassifierPropertyCS_Opposite();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.StereotypeQualifierCS <em>Stereotype Qualifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype Qualifier CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.StereotypeQualifierCS
	 * @generated
	 */
	EClass getStereotypeQualifierCS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.StereotypeQualifierCS#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Stereotype</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.StereotypeQualifierCS#getStereotype()
	 * @see #getStereotypeQualifierCS()
	 * @generated
	 */
	EAttribute getStereotypeQualifierCS_Stereotype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TagCS <em>Tag CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TagCS
	 * @generated
	 */
	EClass getTagCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TagCS#getElementPath <em>Element Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element Path</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TagCS#getElementPath()
	 * @see #getTagCS()
	 * @generated
	 */
	EReference getTagCS_ElementPath();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TagCS#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TagCS#getExpression()
	 * @see #getTagCS()
	 * @generated
	 */
	EReference getTagCS_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ExceptionCS <em>Exception CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exception CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ExceptionCS
	 * @generated
	 */
	EClass getExceptionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS <em>Classifier Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Def CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS
	 * @generated
	 */
	EClass getClassifierDefCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS#getSimpleNameCS()
	 * @see #getClassifierDefCS()
	 * @generated
	 */
	EAttribute getClassifierDefCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extends</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS#getExtends()
	 * @see #getClassifierDefCS()
	 * @generated
	 */
	EReference getClassifierDefCS_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS#getProperties()
	 * @see #getClassifierDefCS()
	 * @generated
	 */
	EReference getClassifierDefCS_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS#getTags()
	 * @see #getClassifierDefCS()
	 * @generated
	 */
	EReference getClassifierDefCS_Tags();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS <em>Classifier Property2 CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Property2 CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS
	 * @generated
	 */
	EClass getClassifierProperty2CS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS#getStereotypeQualifiers <em>Stereotype Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Stereotype Qualifiers</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS#getStereotypeQualifiers()
	 * @see #getClassifierProperty2CS()
	 * @generated
	 */
	EAttribute getClassifierProperty2CS_StereotypeQualifiers();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS#getFeatureKeys <em>Feature Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Keys</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS#getFeatureKeys()
	 * @see #getClassifierProperty2CS()
	 * @generated
	 */
	EAttribute getClassifierProperty2CS_FeatureKeys();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Multiplicity</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS#getMultiplicity()
	 * @see #getClassifierProperty2CS()
	 * @generated
	 */
	EReference getClassifierProperty2CS_Multiplicity();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Opposite</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS#getOpposite()
	 * @see #getClassifierProperty2CS()
	 * @generated
	 */
	EReference getClassifierProperty2CS_Opposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS#isIsOrdered <em>Is Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Ordered</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS#isIsOrdered()
	 * @see #getClassifierProperty2CS()
	 * @generated
	 */
	EAttribute getClassifierProperty2CS_IsOrdered();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.CompleteSignatureCS <em>Complete Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Signature CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.CompleteSignatureCS
	 * @generated
	 */
	EClass getCompleteSignatureCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.CompleteSignatureCS#getSimpleSignature <em>Simple Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Signature</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.CompleteSignatureCS#getSimpleSignature()
	 * @see #getCompleteSignatureCS()
	 * @generated
	 */
	EReference getCompleteSignatureCS_SimpleSignature();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.CompleteSignatureCS#getResultParams <em>Result Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Result Params</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.CompleteSignatureCS#getResultParams()
	 * @see #getCompleteSignatureCS()
	 * @generated
	 */
	EReference getCompleteSignatureCS_ResultParams();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConfigPropertyCS <em>Config Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Property CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConfigPropertyCS
	 * @generated
	 */
	EClass getConfigPropertyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConfigPropertyCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConfigPropertyCS#getTypeCS()
	 * @see #getConfigPropertyCS()
	 * @generated
	 */
	EReference getConfigPropertyCS_TypeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConstructorCS <em>Constructor CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConstructorCS
	 * @generated
	 */
	EClass getConstructorCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConstructorCS#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConstructorCS#getExpressions()
	 * @see #getConstructorCS()
	 * @generated
	 */
	EReference getConstructorCS_Expressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ContextualPropertyCS <em>Contextual Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contextual Property CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ContextualPropertyCS
	 * @generated
	 */
	EClass getContextualPropertyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ContextualPropertyCS#getScopedNameCS <em>Scoped Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scoped Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ContextualPropertyCS#getScopedNameCS()
	 * @see #getContextualPropertyCS()
	 * @generated
	 */
	EReference getContextualPropertyCS_ScopedNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ContextualPropertyCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ContextualPropertyCS#getTypeCS()
	 * @see #getContextualPropertyCS()
	 * @generated
	 */
	EReference getContextualPropertyCS_TypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ContextualPropertyCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ContextualPropertyCS#getOclExpressionCS()
	 * @see #getContextualPropertyCS()
	 * @generated
	 */
	EReference getContextualPropertyCS_OclExpressionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ElementWithBody <em>Element With Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element With Body</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ElementWithBody
	 * @generated
	 */
	EClass getElementWithBody();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ElementWithBody#getBodyStartLocation <em>Body Start Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body Start Location</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ElementWithBody#getBodyStartLocation()
	 * @see #getElementWithBody()
	 * @generated
	 */
	EAttribute getElementWithBody_BodyStartLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ElementWithBody#getBodyEndLocation <em>Body End Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body End Location</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ElementWithBody#getBodyEndLocation()
	 * @see #getElementWithBody()
	 * @generated
	 */
	EAttribute getElementWithBody_BodyEndLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImperativeOperationCallExpCS <em>Imperative Operation Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Operation Call Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImperativeOperationCallExpCS
	 * @generated
	 */
	EClass getImperativeOperationCallExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImperativeOperationCallExpCS#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImperativeOperationCallExpCS#getModule()
	 * @see #getImperativeOperationCallExpCS()
	 * @generated
	 */
	EAttribute getImperativeOperationCallExpCS_Module();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.LibraryImportCS <em>Library Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library Import CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.LibraryImportCS
	 * @generated
	 */
	EClass getLibraryImportCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.LocalPropertyCS <em>Local Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Property CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.LocalPropertyCS
	 * @generated
	 */
	EClass getLocalPropertyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.LocalPropertyCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.LocalPropertyCS#getTypeCS()
	 * @see #getLocalPropertyCS()
	 * @generated
	 */
	EReference getLocalPropertyCS_TypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.LocalPropertyCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.LocalPropertyCS#getOclExpressionCS()
	 * @see #getLocalPropertyCS()
	 * @generated
	 */
	EReference getLocalPropertyCS_OclExpressionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingBodyCS <em>Mapping Body CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Body CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingBodyCS
	 * @generated
	 */
	EClass getMappingBodyCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingBodyCS#isHasPopulationKeyword <em>Has Population Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Population Keyword</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingBodyCS#isHasPopulationKeyword()
	 * @see #getMappingBodyCS()
	 * @generated
	 */
	EAttribute getMappingBodyCS_HasPopulationKeyword();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingCallExpCS <em>Mapping Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Call Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingCallExpCS
	 * @generated
	 */
	EClass getMappingCallExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingCallExpCS#isStrict <em>Strict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strict</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingCallExpCS#isStrict()
	 * @see #getMappingCallExpCS()
	 * @generated
	 */
	EAttribute getMappingCallExpCS_Strict();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS <em>Mapping Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Operation CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS
	 * @generated
	 */
	EClass getMappingOperationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getResults()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EReference getMappingOperationCS_Results();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getDirection()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EAttribute getMappingOperationCS_Direction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#isIsQuery <em>Is Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Query</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#isIsQuery()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EAttribute getMappingOperationCS_IsQuery();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>When</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getWhen()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EReference getMappingOperationCS_When();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getWhere <em>Where</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Where</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getWhere()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EReference getMappingOperationCS_Where();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getInherits <em>Inherits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inherits</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getInherits()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EReference getMappingOperationCS_Inherits();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getDisjuncts <em>Disjuncts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Disjuncts</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getDisjuncts()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EReference getMappingOperationCS_Disjuncts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getMerges <em>Merges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Merges</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getMerges()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EReference getMappingOperationCS_Merges();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getRefines <em>Refines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Refines</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getRefines()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EReference getMappingOperationCS_Refines();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getScopedName <em>Scoped Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scoped Name</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS#getScopedName()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EReference getMappingOperationCS_ScopedName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingEndCS <em>Mapping End CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping End CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingEndCS
	 * @generated
	 */
	EClass getMappingEndCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingInitCS <em>Mapping Init CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Init CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingInitCS
	 * @generated
	 */
	EClass getMappingInitCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingMethodCS <em>Mapping Method CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Method CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingMethodCS
	 * @generated
	 */
	EClass getMappingMethodCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingMethodCS#isBlackBox <em>Black Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Black Box</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingMethodCS#isBlackBox()
	 * @see #getMappingMethodCS()
	 * @generated
	 */
	EAttribute getMappingMethodCS_BlackBox();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingMethodCS#getMappingDeclarationCS <em>Mapping Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Declaration CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingMethodCS#getMappingDeclarationCS()
	 * @see #getMappingMethodCS()
	 * @generated
	 */
	EReference getMappingMethodCS_MappingDeclarationCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingQueryCS <em>Mapping Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Query CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingQueryCS
	 * @generated
	 */
	EClass getMappingQueryCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingQueryCS#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingQueryCS#getExpressions()
	 * @see #getMappingQueryCS()
	 * @generated
	 */
	EReference getMappingQueryCS_Expressions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingQueryCS#isIsSimpleDefinition <em>Is Simple Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Simple Definition</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingQueryCS#isIsSimpleDefinition()
	 * @see #getMappingQueryCS()
	 * @generated
	 */
	EAttribute getMappingQueryCS_IsSimpleDefinition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingRuleCS <em>Mapping Rule CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Rule CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingRuleCS
	 * @generated
	 */
	EClass getMappingRuleCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingRuleCS#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingRuleCS#getGuard()
	 * @see #getMappingRuleCS()
	 * @generated
	 */
	EReference getMappingRuleCS_Guard();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingRuleCS#getMappingBody <em>Mapping Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Body</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingRuleCS#getMappingBody()
	 * @see #getMappingRuleCS()
	 * @generated
	 */
	EReference getMappingRuleCS_MappingBody();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionCS <em>Mapping Section CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Section CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionCS
	 * @generated
	 */
	EClass getMappingSectionCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionCS#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionCS#getStatements()
	 * @see #getMappingSectionCS()
	 * @generated
	 */
	EReference getMappingSectionCS_Statements();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionCS#getMappingRuleCS <em>Mapping Rule CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Rule CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionCS#getMappingRuleCS()
	 * @see #getMappingSectionCS()
	 * @generated
	 */
	EReference getMappingSectionCS_MappingRuleCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionsCS <em>Mapping Sections CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Sections CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionsCS
	 * @generated
	 */
	EClass getMappingSectionsCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionsCS#getMappingInitCS <em>Mapping Init CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Init CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionsCS#getMappingInitCS()
	 * @see #getMappingSectionsCS()
	 * @generated
	 */
	EReference getMappingSectionsCS_MappingInitCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionsCS#getMappingBodyCS <em>Mapping Body CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Body CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionsCS#getMappingBodyCS()
	 * @see #getMappingSectionsCS()
	 * @generated
	 */
	EReference getMappingSectionsCS_MappingBodyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionsCS#getMappingEndCS <em>Mapping End CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping End CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionsCS#getMappingEndCS()
	 * @see #getMappingSectionsCS()
	 * @generated
	 */
	EReference getMappingSectionsCS_MappingEndCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindCS <em>Module Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Kind CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindCS
	 * @generated
	 */
	EClass getModuleKindCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindCS#getModuleKind <em>Module Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module Kind</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindCS#getModuleKind()
	 * @see #getModuleKindCS()
	 * @generated
	 */
	EAttribute getModuleKindCS_ModuleKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleRefCS <em>Module Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Ref CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleRefCS
	 * @generated
	 */
	EClass getModuleRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleRefCS#getModulePath <em>Module Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Module Path</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleRefCS#getModulePath()
	 * @see #getModuleRefCS()
	 * @generated
	 */
	EReference getModuleRefCS_ModulePath();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleRefCS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleRefCS#getParameters()
	 * @see #getModuleRefCS()
	 * @generated
	 */
	EReference getModuleRefCS_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS <em>Model Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS
	 * @generated
	 */
	EClass getModelTypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS#getComplianceKind <em>Compliance Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compliance Kind</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS#getComplianceKind()
	 * @see #getModelTypeCS()
	 * @generated
	 */
	EAttribute getModelTypeCS_ComplianceKind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS#getPackageRefs <em>Package Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Package Refs</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS#getPackageRefs()
	 * @see #getModelTypeCS()
	 * @generated
	 */
	EReference getModelTypeCS_PackageRefs();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS#getWhere <em>Where</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Where</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS#getWhere()
	 * @see #getModelTypeCS()
	 * @generated
	 */
	EReference getModelTypeCS_Where();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeRefCS <em>Model Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Type Ref CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeRefCS
	 * @generated
	 */
	EClass getModelTypeRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS <em>Module CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS
	 * @generated
	 */
	EClass getModuleCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS#getParameters()
	 * @see #getModuleCS()
	 * @generated
	 */
	EReference getModuleCS_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS#getModuleUsages <em>Module Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Module Usages</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS#getModuleUsages()
	 * @see #getModuleCS()
	 * @generated
	 */
	EReference getModuleCS_ModuleUsages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS#getTags()
	 * @see #getModuleCS()
	 * @generated
	 */
	EReference getModuleCS_Tags();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS#getQualifiers <em>Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualifiers</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS#getQualifiers()
	 * @see #getModuleCS()
	 * @generated
	 */
	EAttribute getModuleCS_Qualifiers();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModulePropertyCS <em>Module Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Property CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModulePropertyCS
	 * @generated
	 */
	EClass getModulePropertyCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModulePropertyCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModulePropertyCS#getSimpleNameCS()
	 * @see #getModulePropertyCS()
	 * @generated
	 */
	EAttribute getModulePropertyCS_SimpleNameCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS <em>Module Usage CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Usage CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS
	 * @generated
	 */
	EClass getModuleUsageCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS#getImportKind <em>Import Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import Kind</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS#getImportKind()
	 * @see #getModuleUsageCS()
	 * @generated
	 */
	EAttribute getModuleUsageCS_ImportKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS#getModuleKind <em>Module Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module Kind</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS#getModuleKind()
	 * @see #getModuleUsageCS()
	 * @generated
	 */
	EAttribute getModuleUsageCS_ModuleKind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS#getModuleRefs <em>Module Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Module Refs</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS#getModuleRefs()
	 * @see #getModuleUsageCS()
	 * @generated
	 */
	EReference getModuleUsageCS_ModuleRefs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MultiplicityDefCS <em>Multiplicity Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity Def CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MultiplicityDefCS
	 * @generated
	 */
	EClass getMultiplicityDefCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MultiplicityDefCS#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lower Bound</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MultiplicityDefCS#getLowerBound()
	 * @see #getMultiplicityDefCS()
	 * @generated
	 */
	EReference getMultiplicityDefCS_LowerBound();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MultiplicityDefCS#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Upper Bound</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MultiplicityDefCS#getUpperBound()
	 * @see #getMultiplicityDefCS()
	 * @generated
	 */
	EReference getMultiplicityDefCS_UpperBound();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ObjectExpCS <em>Object Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ObjectExpCS
	 * @generated
	 */
	EClass getObjectExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ObjectExpCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ObjectExpCS#getSimpleNameCS()
	 * @see #getObjectExpCS()
	 * @generated
	 */
	EAttribute getObjectExpCS_SimpleNameCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ObjectExpCS#isIsImplicit <em>Is Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Implicit</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ObjectExpCS#isIsImplicit()
	 * @see #getObjectExpCS()
	 * @generated
	 */
	EAttribute getObjectExpCS_IsImplicit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.OppositePropertyCS <em>Opposite Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opposite Property CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.OppositePropertyCS
	 * @generated
	 */
	EClass getOppositePropertyCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.OppositePropertyCS#isIsNavigable <em>Is Navigable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Navigable</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.OppositePropertyCS#isIsNavigable()
	 * @see #getOppositePropertyCS()
	 * @generated
	 */
	EAttribute getOppositePropertyCS_IsNavigable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.OppositePropertyCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.OppositePropertyCS#getSimpleNameCS()
	 * @see #getOppositePropertyCS()
	 * @generated
	 */
	EAttribute getOppositePropertyCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.OppositePropertyCS#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Multiplicity</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.OppositePropertyCS#getMultiplicity()
	 * @see #getOppositePropertyCS()
	 * @generated
	 */
	EReference getOppositePropertyCS_Multiplicity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ParameterDeclarationCS <em>Parameter Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Declaration CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ParameterDeclarationCS
	 * @generated
	 */
	EClass getParameterDeclarationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ParameterDeclarationCS#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ParameterDeclarationCS#getDirection()
	 * @see #getParameterDeclarationCS()
	 * @generated
	 */
	EAttribute getParameterDeclarationCS_Direction();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ParameterDeclarationCS#getInitPart <em>Init Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Part</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ParameterDeclarationCS#getInitPart()
	 * @see #getParameterDeclarationCS()
	 * @generated
	 */
	EReference getParameterDeclarationCS_InitPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.RenameCS <em>Rename CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rename CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.RenameCS
	 * @generated
	 */
	EClass getRenameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.RenameCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.RenameCS#getTypeCS()
	 * @see #getRenameCS()
	 * @generated
	 */
	EReference getRenameCS_TypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.RenameCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.RenameCS#getSimpleNameCS()
	 * @see #getRenameCS()
	 * @generated
	 */
	EAttribute getRenameCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.RenameCS#getOriginalName <em>Original Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Original Name</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.RenameCS#getOriginalName()
	 * @see #getRenameCS()
	 * @generated
	 */
	EReference getRenameCS_OriginalName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveOpArgsExpCS <em>Resolve Op Args Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve Op Args Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveOpArgsExpCS
	 * @generated
	 */
	EClass getResolveOpArgsExpCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveOpArgsExpCS#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveOpArgsExpCS#getTarget()
	 * @see #getResolveOpArgsExpCS()
	 * @generated
	 */
	EReference getResolveOpArgsExpCS_Target();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveOpArgsExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveOpArgsExpCS#getCondition()
	 * @see #getResolveOpArgsExpCS()
	 * @generated
	 */
	EReference getResolveOpArgsExpCS_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.PackageRefCS <em>Package Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Ref CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.PackageRefCS
	 * @generated
	 */
	EClass getPackageRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.PackageRefCS#getPackagePath <em>Package Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Package Path</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.PackageRefCS#getPackagePath()
	 * @see #getPackageRefCS()
	 * @generated
	 */
	EReference getPackageRefCS_PackagePath();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.PackageRefCS#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Uri</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.PackageRefCS#getUri()
	 * @see #getPackageRefCS()
	 * @generated
	 */
	EReference getPackageRefCS_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ScopedNameCS <em>Scoped Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scoped Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ScopedNameCS
	 * @generated
	 */
	EClass getScopedNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ScopedNameCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ScopedNameCS#getTypeCS()
	 * @see #getScopedNameCS()
	 * @generated
	 */
	EReference getScopedNameCS_TypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ScopedNameCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ScopedNameCS#getName()
	 * @see #getScopedNameCS()
	 * @generated
	 */
	EAttribute getScopedNameCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.SimpleSignatureCS <em>Simple Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Signature CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.SimpleSignatureCS
	 * @generated
	 */
	EClass getSimpleSignatureCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.SimpleSignatureCS#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.SimpleSignatureCS#getParameter()
	 * @see #getSimpleSignatureCS()
	 * @generated
	 */
	EReference getSimpleSignatureCS_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationCS <em>Transformation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationCS
	 * @generated
	 */
	EClass getTransformationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationCS#getRefines <em>Refines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Refines</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationCS#getRefines()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Refines();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationRefineCS <em>Transformation Refine CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation Refine CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationRefineCS
	 * @generated
	 */
	EClass getTransformationRefineCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationRefineCS#getModuleRefCS <em>Module Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Module Ref CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationRefineCS#getModuleRefCS()
	 * @see #getTransformationRefineCS()
	 * @generated
	 */
	EReference getTransformationRefineCS_ModuleRefCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationRefineCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationRefineCS#getSimpleNameCS()
	 * @see #getTransformationRefineCS()
	 * @generated
	 */
	EAttribute getTransformationRefineCS_SimpleNameCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypeSpecCS <em>Type Spec CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Spec CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypeSpecCS
	 * @generated
	 */
	EClass getTypeSpecCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypeSpecCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypeSpecCS#getOwnedType()
	 * @see #getTypeSpecCS()
	 * @generated
	 */
	EReference getTypeSpecCS_OwnedType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypeSpecCS#getExtentLocation <em>Extent Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extent Location</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypeSpecCS#getExtentLocation()
	 * @see #getTypeSpecCS()
	 * @generated
	 */
	EAttribute getTypeSpecCS_ExtentLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS <em>Unit CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS
	 * @generated
	 */
	EClass getUnitCS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS#getSegment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Segment</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS#getSegment()
	 * @see #getUnitCS()
	 * @generated
	 */
	EAttribute getUnitCS_Segment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS#getTopLevelElements <em>Top Level Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Top Level Elements</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS#getTopLevelElements()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_TopLevelElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Modules</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS#getModules()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_Modules();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS#getModelTypes <em>Model Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Types</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS#getModelTypes()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_ModelTypes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS#getImports()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_Imports();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS <em>Resolve Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS
	 * @generated
	 */
	EClass getResolveExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS#isOne <em>One</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>One</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS#isOne()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EAttribute getResolveExpCS_One();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS#isIsInverse <em>Is Inverse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Inverse</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS#isIsInverse()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EAttribute getResolveExpCS_IsInverse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS#isIsDeferred <em>Is Deferred</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Deferred</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS#isIsDeferred()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EAttribute getResolveExpCS_IsDeferred();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS#getTarget()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EReference getResolveExpCS_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS#getCondition()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EReference getResolveExpCS_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveInExpCS <em>Resolve In Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve In Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveInExpCS
	 * @generated
	 */
	EClass getResolveInExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveInExpCS#getInMappingType <em>In Mapping Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In Mapping Type</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveInExpCS#getInMappingType()
	 * @see #getResolveInExpCS()
	 * @generated
	 */
	EReference getResolveInExpCS_InMappingType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveInExpCS#getInMappingName <em>In Mapping Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In Mapping Name</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveInExpCS#getInMappingName()
	 * @see #getResolveInExpCS()
	 * @generated
	 */
	EAttribute getResolveInExpCS_InMappingName();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierKind <em>Classifier Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Classifier Kind</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierKind
	 * @generated
	 */
	EEnum getClassifierKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.FeatureKey <em>Feature Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Feature Key</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.FeatureKey
	 * @generated
	 */
	EEnum getFeatureKey();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitOp <em>Init Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Init Op</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitOp
	 * @generated
	 */
	EEnum getInitOp();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelKind <em>Metamodel Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Metamodel Kind</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelKind
	 * @generated
	 */
	EEnum getMetamodelKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.DirectionKindCS <em>Direction Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Direction Kind CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.DirectionKindCS
	 * @generated
	 */
	EEnum getDirectionKindCS();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImportKindEnum <em>Import Kind Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Import Kind Enum</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImportKindEnum
	 * @generated
	 */
	EEnum getImportKindEnum();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingExtensionKindCS <em>Mapping Extension Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Mapping Extension Kind CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingExtensionKindCS
	 * @generated
	 */
	EEnum getMappingExtensionKindCS();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindEnum <em>Module Kind Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Module Kind Enum</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindEnum
	 * @generated
	 */
	EEnum getModuleKindEnum();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.QualifierKindCS <em>Qualifier Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Qualifier Kind CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QualifierKindCS
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
	QVTOperationalCSFactory getQVTOperationalCSFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PathName2CSImpl <em>Path Name2 CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PathName2CSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getPathName2CS()
		 * @generated
		 */
		EClass PATH_NAME2_CS = eINSTANCE.getPathName2CS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Elements2</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NAME2_CS__OWNED_PATH_ELEMENTS2 = eINSTANCE.getPathName2CS_OwnedPathElements2();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PathElement2CSImpl <em>Path Element2 CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PathElement2CSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getPathElement2CS()
		 * @generated
		 */
		EClass PATH_ELEMENT2_CS = eINSTANCE.getPathElement2CS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_ELEMENT2_CS__NAME = eINSTANCE.getPathElement2CS_Name();

		/**
		 * The meta object literal for the '<em><b>Owning Path Name CS</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_ELEMENT2_CS__OWNING_PATH_NAME_CS = eINSTANCE.getPathElement2CS_OwningPathNameCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TypedTypeRef2CSImpl <em>Typed Type Ref2 CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TypedTypeRef2CSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTypedTypeRef2CS()
		 * @generated
		 */
		EClass TYPED_TYPE_REF2_CS = eINSTANCE.getTypedTypeRef2CS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_TYPE_REF2_CS__OWNED_PATH_NAME = eINSTANCE.getTypedTypeRef2CS_OwnedPathName();

		/**
		 * The meta object literal for the '<em><b>Owned Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_TYPE_REF2_CS__OWNED_BINDING = eINSTANCE.getTypedTypeRef2CS_OwnedBinding();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TopLevelCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTopLevelCS()
		 * @generated
		 */
		EClass TOP_LEVEL_CS = eINSTANCE.getTopLevelCS();

		/**
		 * The meta object literal for the '<em><b>Owned Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__OWNED_TYPES = eINSTANCE.getTopLevelCS_OwnedTypes();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToClassCSImpl <em>QV To Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToClassCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToClassCS()
		 * @generated
		 */
		EClass QV_TO_CLASS_CS = eINSTANCE.getQVToClassCS();

		/**
		 * The meta object literal for the '<em><b>Intermediate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QV_TO_CLASS_CS__INTERMEDIATE = eINSTANCE.getQVToClassCS_Intermediate();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToImportCSImpl <em>QV To Import CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToImportCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToImportCS()
		 * @generated
		 */
		EClass QV_TO_IMPORT_CS = eINSTANCE.getQVToImportCS();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QV_TO_IMPORT_CS__UNIT = eINSTANCE.getQVToImportCS_Unit();

		/**
		 * The meta object literal for the '<em><b>Imported Unit Element</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QV_TO_IMPORT_CS__IMPORTED_UNIT_ELEMENT = eINSTANCE.getQVToImportCS_ImportedUnitElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToLibraryCSImpl <em>QV To Library CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToLibraryCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToLibraryCS()
		 * @generated
		 */
		EClass QV_TO_LIBRARY_CS = eINSTANCE.getQVToLibraryCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToOperationCSImpl <em>QV To Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVToOperationCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToOperationCS()
		 * @generated
		 */
		EClass QV_TO_OPERATION_CS = eINSTANCE.getQVToOperationCS();

		/**
		 * The meta object literal for the '<em><b>Stereotypes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QV_TO_OPERATION_CS__STEREOTYPES = eINSTANCE.getQVToOperationCS_Stereotypes();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.InitPartCSImpl <em>Init Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.InitPartCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getInitPartCS()
		 * @generated
		 */
		EClass INIT_PART_CS = eINSTANCE.getInitPartCS();

		/**
		 * The meta object literal for the '<em><b>Init Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INIT_PART_CS__INIT_OP = eINSTANCE.getInitPartCS_InitOp();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INIT_PART_CS__EXPRESSION = eINSTANCE.getInitPartCS_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MetamodelCSImpl <em>Metamodel CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MetamodelCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMetamodelCS()
		 * @generated
		 */
		EClass METAMODEL_CS = eINSTANCE.getMetamodelCS();

		/**
		 * The meta object literal for the '<em><b>Metamodel Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METAMODEL_CS__METAMODEL_KIND = eINSTANCE.getMetamodelCS_MetamodelKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PrimitiveTypeCSImpl <em>Primitive Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PrimitiveTypeCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getPrimitiveTypeCS()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_CS = eINSTANCE.getPrimitiveTypeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierPropertyCSImpl <em>Classifier Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierPropertyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierPropertyCS()
		 * @generated
		 */
		EClass CLASSIFIER_PROPERTY_CS = eINSTANCE.getClassifierPropertyCS();

		/**
		 * The meta object literal for the '<em><b>Stereotypes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_PROPERTY_CS__STEREOTYPES = eINSTANCE.getClassifierPropertyCS_Stereotypes();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_PROPERTY_CS__OPPOSITE = eINSTANCE.getClassifierPropertyCS_Opposite();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.StereotypeQualifierCSImpl <em>Stereotype Qualifier CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.StereotypeQualifierCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getStereotypeQualifierCS()
		 * @generated
		 */
		EClass STEREOTYPE_QUALIFIER_CS = eINSTANCE.getStereotypeQualifierCS();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_QUALIFIER_CS__STEREOTYPE = eINSTANCE.getStereotypeQualifierCS_Stereotype();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TagCSImpl <em>Tag CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TagCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTagCS()
		 * @generated
		 */
		EClass TAG_CS = eINSTANCE.getTagCS();

		/**
		 * The meta object literal for the '<em><b>Element Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG_CS__ELEMENT_PATH = eINSTANCE.getTagCS_ElementPath();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG_CS__EXPRESSION = eINSTANCE.getTagCS_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ExceptionCSImpl <em>Exception CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ExceptionCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getExceptionCS()
		 * @generated
		 */
		EClass EXCEPTION_CS = eINSTANCE.getExceptionCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierDefCSImpl <em>Classifier Def CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierDefCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierDefCS()
		 * @generated
		 */
		EClass CLASSIFIER_DEF_CS = eINSTANCE.getClassifierDefCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_DEF_CS__SIMPLE_NAME_CS = eINSTANCE.getClassifierDefCS_SimpleNameCS();

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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierProperty2CSImpl <em>Classifier Property2 CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierProperty2CSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierProperty2CS()
		 * @generated
		 */
		EClass CLASSIFIER_PROPERTY2_CS = eINSTANCE.getClassifierProperty2CS();

		/**
		 * The meta object literal for the '<em><b>Stereotype Qualifiers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_PROPERTY2_CS__STEREOTYPE_QUALIFIERS = eINSTANCE.getClassifierProperty2CS_StereotypeQualifiers();

		/**
		 * The meta object literal for the '<em><b>Feature Keys</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_PROPERTY2_CS__FEATURE_KEYS = eINSTANCE.getClassifierProperty2CS_FeatureKeys();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_PROPERTY2_CS__MULTIPLICITY = eINSTANCE.getClassifierProperty2CS_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_PROPERTY2_CS__OPPOSITE = eINSTANCE.getClassifierProperty2CS_Opposite();

		/**
		 * The meta object literal for the '<em><b>Is Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_PROPERTY2_CS__IS_ORDERED = eINSTANCE.getClassifierProperty2CS_IsOrdered();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.CompleteSignatureCSImpl <em>Complete Signature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.CompleteSignatureCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getCompleteSignatureCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ConfigPropertyCSImpl <em>Config Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ConfigPropertyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getConfigPropertyCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ConstructorCSImpl <em>Constructor CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ConstructorCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getConstructorCS()
		 * @generated
		 */
		EClass CONSTRUCTOR_CS = eINSTANCE.getConstructorCS();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR_CS__EXPRESSIONS = eINSTANCE.getConstructorCS_Expressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ContextualPropertyCSImpl <em>Contextual Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ContextualPropertyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getContextualPropertyCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ElementWithBodyImpl <em>Element With Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ElementWithBodyImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getElementWithBody()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ImperativeOperationCallExpCSImpl <em>Imperative Operation Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ImperativeOperationCallExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getImperativeOperationCallExpCS()
		 * @generated
		 */
		EClass IMPERATIVE_OPERATION_CALL_EXP_CS = eINSTANCE.getImperativeOperationCallExpCS();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPERATIVE_OPERATION_CALL_EXP_CS__MODULE = eINSTANCE.getImperativeOperationCallExpCS_Module();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.LibraryImportCSImpl <em>Library Import CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.LibraryImportCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getLibraryImportCS()
		 * @generated
		 */
		EClass LIBRARY_IMPORT_CS = eINSTANCE.getLibraryImportCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.LocalPropertyCSImpl <em>Local Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.LocalPropertyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getLocalPropertyCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingBodyCSImpl <em>Mapping Body CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingBodyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingBodyCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingCallExpCSImpl <em>Mapping Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingCallExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingCallExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl <em>Mapping Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingOperationCS()
		 * @generated
		 */
		EClass MAPPING_OPERATION_CS = eINSTANCE.getMappingOperationCS();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION_CS__RESULTS = eINSTANCE.getMappingOperationCS_Results();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_OPERATION_CS__DIRECTION = eINSTANCE.getMappingOperationCS_Direction();

		/**
		 * The meta object literal for the '<em><b>Is Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_OPERATION_CS__IS_QUERY = eINSTANCE.getMappingOperationCS_IsQuery();

		/**
		 * The meta object literal for the '<em><b>When</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION_CS__WHEN = eINSTANCE.getMappingOperationCS_When();

		/**
		 * The meta object literal for the '<em><b>Where</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION_CS__WHERE = eINSTANCE.getMappingOperationCS_Where();

		/**
		 * The meta object literal for the '<em><b>Inherits</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION_CS__INHERITS = eINSTANCE.getMappingOperationCS_Inherits();

		/**
		 * The meta object literal for the '<em><b>Disjuncts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION_CS__DISJUNCTS = eINSTANCE.getMappingOperationCS_Disjuncts();

		/**
		 * The meta object literal for the '<em><b>Merges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION_CS__MERGES = eINSTANCE.getMappingOperationCS_Merges();

		/**
		 * The meta object literal for the '<em><b>Refines</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION_CS__REFINES = eINSTANCE.getMappingOperationCS_Refines();

		/**
		 * The meta object literal for the '<em><b>Scoped Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION_CS__SCOPED_NAME = eINSTANCE.getMappingOperationCS_ScopedName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingEndCSImpl <em>Mapping End CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingEndCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingEndCS()
		 * @generated
		 */
		EClass MAPPING_END_CS = eINSTANCE.getMappingEndCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingInitCSImpl <em>Mapping Init CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingInitCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingInitCS()
		 * @generated
		 */
		EClass MAPPING_INIT_CS = eINSTANCE.getMappingInitCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingMethodCSImpl <em>Mapping Method CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingMethodCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingMethodCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingQueryCSImpl <em>Mapping Query CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingQueryCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingQueryCS()
		 * @generated
		 */
		EClass MAPPING_QUERY_CS = eINSTANCE.getMappingQueryCS();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_QUERY_CS__EXPRESSIONS = eINSTANCE.getMappingQueryCS_Expressions();

		/**
		 * The meta object literal for the '<em><b>Is Simple Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION = eINSTANCE.getMappingQueryCS_IsSimpleDefinition();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingRuleCSImpl <em>Mapping Rule CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingRuleCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingRuleCS()
		 * @generated
		 */
		EClass MAPPING_RULE_CS = eINSTANCE.getMappingRuleCS();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RULE_CS__GUARD = eINSTANCE.getMappingRuleCS_Guard();

		/**
		 * The meta object literal for the '<em><b>Mapping Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RULE_CS__MAPPING_BODY = eINSTANCE.getMappingRuleCS_MappingBody();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingSectionCSImpl <em>Mapping Section CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingSectionCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingSectionCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingSectionsCSImpl <em>Mapping Sections CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingSectionsCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingSectionsCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleKindCSImpl <em>Module Kind CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleKindCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleKindCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleRefCSImpl <em>Module Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleRefCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleRefCS()
		 * @generated
		 */
		EClass MODULE_REF_CS = eINSTANCE.getModuleRefCS();

		/**
		 * The meta object literal for the '<em><b>Module Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_REF_CS__MODULE_PATH = eINSTANCE.getModuleRefCS_ModulePath();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_REF_CS__PARAMETERS = eINSTANCE.getModuleRefCS_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModelTypeCSImpl <em>Model Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModelTypeCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModelTypeCS()
		 * @generated
		 */
		EClass MODEL_TYPE_CS = eINSTANCE.getModelTypeCS();

		/**
		 * The meta object literal for the '<em><b>Compliance Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_TYPE_CS__COMPLIANCE_KIND = eINSTANCE.getModelTypeCS_ComplianceKind();

		/**
		 * The meta object literal for the '<em><b>Package Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE_CS__PACKAGE_REFS = eINSTANCE.getModelTypeCS_PackageRefs();

		/**
		 * The meta object literal for the '<em><b>Where</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE_CS__WHERE = eINSTANCE.getModelTypeCS_Where();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModelTypeRefCSImpl <em>Model Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModelTypeRefCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModelTypeRefCS()
		 * @generated
		 */
		EClass MODEL_TYPE_REF_CS = eINSTANCE.getModelTypeRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleCSImpl <em>Module CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleCS()
		 * @generated
		 */
		EClass MODULE_CS = eINSTANCE.getModuleCS();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_CS__PARAMETERS = eINSTANCE.getModuleCS_Parameters();

		/**
		 * The meta object literal for the '<em><b>Module Usages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_CS__MODULE_USAGES = eINSTANCE.getModuleCS_ModuleUsages();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_CS__TAGS = eINSTANCE.getModuleCS_Tags();

		/**
		 * The meta object literal for the '<em><b>Qualifiers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE_CS__QUALIFIERS = eINSTANCE.getModuleCS_Qualifiers();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModulePropertyCSImpl <em>Module Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModulePropertyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModulePropertyCS()
		 * @generated
		 */
		EClass MODULE_PROPERTY_CS = eINSTANCE.getModulePropertyCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE_PROPERTY_CS__SIMPLE_NAME_CS = eINSTANCE.getModulePropertyCS_SimpleNameCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleUsageCSImpl <em>Module Usage CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ModuleUsageCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleUsageCS()
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
		 * The meta object literal for the '<em><b>Module Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE_USAGE_CS__MODULE_KIND = eINSTANCE.getModuleUsageCS_ModuleKind();

		/**
		 * The meta object literal for the '<em><b>Module Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_USAGE_CS__MODULE_REFS = eINSTANCE.getModuleUsageCS_ModuleRefs();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MultiplicityDefCSImpl <em>Multiplicity Def CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MultiplicityDefCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMultiplicityDefCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ObjectExpCSImpl <em>Object Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ObjectExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getObjectExpCS()
		 * @generated
		 */
		EClass OBJECT_EXP_CS = eINSTANCE.getObjectExpCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_EXP_CS__SIMPLE_NAME_CS = eINSTANCE.getObjectExpCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Is Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_EXP_CS__IS_IMPLICIT = eINSTANCE.getObjectExpCS_IsImplicit();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.OppositePropertyCSImpl <em>Opposite Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.OppositePropertyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getOppositePropertyCS()
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
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPPOSITE_PROPERTY_CS__SIMPLE_NAME_CS = eINSTANCE.getOppositePropertyCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPPOSITE_PROPERTY_CS__MULTIPLICITY = eINSTANCE.getOppositePropertyCS_Multiplicity();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ParameterDeclarationCSImpl <em>Parameter Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ParameterDeclarationCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getParameterDeclarationCS()
		 * @generated
		 */
		EClass PARAMETER_DECLARATION_CS = eINSTANCE.getParameterDeclarationCS();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DECLARATION_CS__DIRECTION = eINSTANCE.getParameterDeclarationCS_Direction();

		/**
		 * The meta object literal for the '<em><b>Init Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DECLARATION_CS__INIT_PART = eINSTANCE.getParameterDeclarationCS_InitPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.RenameCSImpl <em>Rename CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.RenameCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getRenameCS()
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
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RENAME_CS__SIMPLE_NAME_CS = eINSTANCE.getRenameCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Original Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENAME_CS__ORIGINAL_NAME = eINSTANCE.getRenameCS_OriginalName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveOpArgsExpCSImpl <em>Resolve Op Args Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveOpArgsExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getResolveOpArgsExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PackageRefCSImpl <em>Package Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.PackageRefCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getPackageRefCS()
		 * @generated
		 */
		EClass PACKAGE_REF_CS = eINSTANCE.getPackageRefCS();

		/**
		 * The meta object literal for the '<em><b>Package Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_REF_CS__PACKAGE_PATH = eINSTANCE.getPackageRefCS_PackagePath();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_REF_CS__URI = eINSTANCE.getPackageRefCS_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ScopedNameCSImpl <em>Scoped Name CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ScopedNameCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getScopedNameCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.SimpleSignatureCSImpl <em>Simple Signature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.SimpleSignatureCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getSimpleSignatureCS()
		 * @generated
		 */
		EClass SIMPLE_SIGNATURE_CS = eINSTANCE.getSimpleSignatureCS();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_SIGNATURE_CS__PARAMETER = eINSTANCE.getSimpleSignatureCS_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TransformationCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTransformationCS()
		 * @generated
		 */
		EClass TRANSFORMATION_CS = eINSTANCE.getTransformationCS();

		/**
		 * The meta object literal for the '<em><b>Refines</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__REFINES = eINSTANCE.getTransformationCS_Refines();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TransformationRefineCSImpl <em>Transformation Refine CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TransformationRefineCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTransformationRefineCS()
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
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS = eINSTANCE.getTransformationRefineCS_SimpleNameCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TypeSpecCSImpl <em>Type Spec CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.TypeSpecCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTypeSpecCS()
		 * @generated
		 */
		EClass TYPE_SPEC_CS = eINSTANCE.getTypeSpecCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_SPEC_CS__OWNED_TYPE = eINSTANCE.getTypeSpecCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Extent Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_SPEC_CS__EXTENT_LOCATION = eINSTANCE.getTypeSpecCS_ExtentLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.UnitCSImpl <em>Unit CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.UnitCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getUnitCS()
		 * @generated
		 */
		EClass UNIT_CS = eINSTANCE.getUnitCS();

		/**
		 * The meta object literal for the '<em><b>Segment</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_CS__SEGMENT = eINSTANCE.getUnitCS_Segment();

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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveExpCSImpl <em>Resolve Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getResolveExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveInExpCSImpl <em>Resolve In Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ResolveInExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getResolveInExpCS()
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
		 * The meta object literal for the '<em><b>In Mapping Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOLVE_IN_EXP_CS__IN_MAPPING_NAME = eINSTANCE.getResolveInExpCS_InMappingName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierKind <em>Classifier Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierKind
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierKind()
		 * @generated
		 */
		EEnum CLASSIFIER_KIND = eINSTANCE.getClassifierKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.FeatureKey <em>Feature Key</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.FeatureKey
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getFeatureKey()
		 * @generated
		 */
		EEnum FEATURE_KEY = eINSTANCE.getFeatureKey();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitOp <em>Init Op</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitOp
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getInitOp()
		 * @generated
		 */
		EEnum INIT_OP = eINSTANCE.getInitOp();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelKind <em>Metamodel Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelKind
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMetamodelKind()
		 * @generated
		 */
		EEnum METAMODEL_KIND = eINSTANCE.getMetamodelKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.DirectionKindCS <em>Direction Kind CS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.DirectionKindCS
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getDirectionKindCS()
		 * @generated
		 */
		EEnum DIRECTION_KIND_CS = eINSTANCE.getDirectionKindCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImportKindEnum <em>Import Kind Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImportKindEnum
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getImportKindEnum()
		 * @generated
		 */
		EEnum IMPORT_KIND_ENUM = eINSTANCE.getImportKindEnum();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingExtensionKindCS <em>Mapping Extension Kind CS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingExtensionKindCS
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingExtensionKindCS()
		 * @generated
		 */
		EEnum MAPPING_EXTENSION_KIND_CS = eINSTANCE.getMappingExtensionKindCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindEnum <em>Module Kind Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindEnum
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleKindEnum()
		 * @generated
		 */
		EEnum MODULE_KIND_ENUM = eINSTANCE.getModuleKindEnum();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.QualifierKindCS <em>Qualifier Kind CS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QualifierKindCS
		 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQualifierKindCS()
		 * @generated
		 */
		EEnum QUALIFIER_KIND_CS = eINSTANCE.getQualifierKindCS();

	}

} //QVTOperationalCSPackage
