/**
 */
package org.eclipse.qvto.examples.xtext.imperativeoclcs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.ocl.xtext.basecs.BaseCSPackage;

import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;

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
 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSFactory
 * @model kind="package"
 * @generated
 */
public interface ImperativeOCLCSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "imperativeoclcs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/pivot/1.0/ImperativeOCLCS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "imperativeoclcs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImperativeOCLCSPackage eINSTANCE = org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.StatementCSImpl <em>Statement CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.StatementCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getStatementCS()
	 * @generated
	 */
	int STATEMENT_CS = 21;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__CSI = EssentialOCLCSPackage.EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__PARENT = EssentialOCLCSPackage.EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__PIVOT = EssentialOCLCSPackage.EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__OWNED_ANNOTATIONS = EssentialOCLCSPackage.EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__HAS_ERROR = EssentialOCLCSPackage.EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__LOCAL_LEFT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__LOCAL_LEFTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__LOCAL_PARENT = EssentialOCLCSPackage.EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__LOCAL_RIGHT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__LOCAL_RIGHTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__PRECEDENCE = EssentialOCLCSPackage.EXP_CS__PRECEDENCE;

	/**
	 * The number of structural features of the '<em>Statement CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS_FEATURE_COUNT = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssertExpCSImpl <em>Assert Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssertExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getAssertExpCS()
	 * @generated
	 */
	int ASSERT_EXP_CS = 0;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__CSI = STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__PARENT = STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__PIVOT = STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__ORIGINAL_XMI_ID = STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__OWNED_ANNOTATIONS = STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__HAS_ERROR = STATEMENT_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__LOCAL_LEFT = STATEMENT_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = STATEMENT_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__LOCAL_PARENT = STATEMENT_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__LOCAL_RIGHT = STATEMENT_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = STATEMENT_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_CS__PRECEDENCE = STATEMENT_CS__PRECEDENCE;

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
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssignStatementCSImpl <em>Assign Statement CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssignStatementCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getAssignStatementCS()
	 * @generated
	 */
	int ASSIGN_STATEMENT_CS = 1;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__CSI = STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__PARENT = STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__PIVOT = STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__ORIGINAL_XMI_ID = STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__OWNED_ANNOTATIONS = STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__HAS_ERROR = STATEMENT_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__LOCAL_LEFT = STATEMENT_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__LOCAL_LEFTMOST_DESCENDANT = STATEMENT_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__LOCAL_PARENT = STATEMENT_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__LOCAL_RIGHT = STATEMENT_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__LOCAL_RIGHTMOST_DESCENDANT = STATEMENT_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_CS__PRECEDENCE = STATEMENT_CS__PRECEDENCE;

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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.BlockExpCSImpl <em>Block Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.BlockExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getBlockExpCS()
	 * @generated
	 */
	int BLOCK_EXP_CS = 2;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__CSI = STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__PARENT = STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__PIVOT = STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__ORIGINAL_XMI_ID = STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__OWNED_ANNOTATIONS = STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__HAS_ERROR = STATEMENT_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__LOCAL_LEFT = STATEMENT_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = STATEMENT_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__LOCAL_PARENT = STATEMENT_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__LOCAL_RIGHT = STATEMENT_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = STATEMENT_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__PRECEDENCE = STATEMENT_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS__EXPRESSIONS = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DictLiteralExpCSImpl <em>Dict Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DictLiteralExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getDictLiteralExpCS()
	 * @generated
	 */
	int DICT_LITERAL_EXP_CS = 3;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__CSI = EssentialOCLCSPackage.EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__PARENT = EssentialOCLCSPackage.EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__PIVOT = EssentialOCLCSPackage.EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__OWNED_ANNOTATIONS = EssentialOCLCSPackage.EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__HAS_ERROR = EssentialOCLCSPackage.EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__LOCAL_LEFT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__LOCAL_PARENT = EssentialOCLCSPackage.EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__LOCAL_RIGHT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__PRECEDENCE = EssentialOCLCSPackage.EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS__OWNED_PARTS = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dict Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_CS_FEATURE_COUNT = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DictLiteralPartCSImpl <em>Dict Literal Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DictLiteralPartCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getDictLiteralPartCS()
	 * @generated
	 */
	int DICT_LITERAL_PART_CS = 4;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS__KEY = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS__VALUE = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dict Literal Part CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DictTypeCSImpl <em>Dict Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DictTypeCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getDictTypeCS()
	 * @generated
	 */
	int DICT_TYPE_CS = 5;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_TYPE_CS__CSI = BaseCSPackage.TYPED_REF_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_TYPE_CS__PARENT = BaseCSPackage.TYPED_REF_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_TYPE_CS__PIVOT = BaseCSPackage.TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_TYPE_CS__OWNED_MULTIPLICITY = BaseCSPackage.TYPED_REF_CS__OWNED_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Key Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_TYPE_CS__KEY_TYPE = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_TYPE_CS__VALUE_TYPE = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dict Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_TYPE_CS_FEATURE_COUNT = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ExpressionBlockCSImpl <em>Expression Block CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ExpressionBlockCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getExpressionBlockCS()
	 * @generated
	 */
	int EXPRESSION_BLOCK_CS = 12;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS__CSI = EssentialOCLCSPackage.EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS__PARENT = EssentialOCLCSPackage.EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS__PIVOT = EssentialOCLCSPackage.EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS__OWNED_ANNOTATIONS = EssentialOCLCSPackage.EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS__HAS_ERROR = EssentialOCLCSPackage.EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS__LOCAL_LEFT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS__LOCAL_LEFTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS__LOCAL_PARENT = EssentialOCLCSPackage.EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS__LOCAL_RIGHT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS__LOCAL_RIGHTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS__PRECEDENCE = EssentialOCLCSPackage.EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS__BODY = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Block CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOCK_CS_FEATURE_COUNT = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ComputeExpCSImpl <em>Compute Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ComputeExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getComputeExpCS()
	 * @generated
	 */
	int COMPUTE_EXP_CS = 6;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__CSI = EXPRESSION_BLOCK_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__PARENT = EXPRESSION_BLOCK_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__PIVOT = EXPRESSION_BLOCK_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__ORIGINAL_XMI_ID = EXPRESSION_BLOCK_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__OWNED_ANNOTATIONS = EXPRESSION_BLOCK_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__HAS_ERROR = EXPRESSION_BLOCK_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__LOCAL_LEFT = EXPRESSION_BLOCK_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = EXPRESSION_BLOCK_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__LOCAL_PARENT = EXPRESSION_BLOCK_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__LOCAL_RIGHT = EXPRESSION_BLOCK_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = EXPRESSION_BLOCK_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__PRECEDENCE = EXPRESSION_BLOCK_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__BODY = EXPRESSION_BLOCK_CS__BODY;

	/**
	 * The feature id for the '<em><b>Returned Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS__RETURNED_ELEMENT = EXPRESSION_BLOCK_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compute Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_CS_FEATURE_COUNT = EXPRESSION_BLOCK_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeLoopExpCSImpl <em>Imperative Loop Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeLoopExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getImperativeLoopExpCS()
	 * @generated
	 */
	int IMPERATIVE_LOOP_EXP_CS = 8;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__CSI = EssentialOCLCSPackage.CALL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__PARENT = EssentialOCLCSPackage.CALL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__PIVOT = EssentialOCLCSPackage.CALL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.CALL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__OWNED_ANNOTATIONS = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__HAS_ERROR = EssentialOCLCSPackage.CALL_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__LOCAL_LEFT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__LOCAL_PARENT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__LOCAL_RIGHT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__PRECEDENCE = EssentialOCLCSPackage.CALL_EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__IS_PRE = EssentialOCLCSPackage.CALL_EXP_CS__IS_PRE;

	/**
	 * The feature id for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__OWNED_PATH_NAME = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_PATH_NAME;

	/**
	 * The feature id for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Square Bracketed Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__SOURCE_TYPE = EssentialOCLCSPackage.CALL_EXP_CS__SOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Source Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__SOURCE_TYPE_VALUE = EssentialOCLCSPackage.CALL_EXP_CS__SOURCE_TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__ARGUMENTS = EssentialOCLCSPackage.CALL_EXP_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__SOURCE = EssentialOCLCSPackage.CALL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS__CONDITION = EssentialOCLCSPackage.CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imperative Loop Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_CS_FEATURE_COUNT = EssentialOCLCSPackage.CALL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeIterateExpCSImpl <em>Imperative Iterate Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeIterateExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getImperativeIterateExpCS()
	 * @generated
	 */
	int IMPERATIVE_ITERATE_EXP_CS = 7;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__CSI = IMPERATIVE_LOOP_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__PARENT = IMPERATIVE_LOOP_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__PIVOT = IMPERATIVE_LOOP_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__ORIGINAL_XMI_ID = IMPERATIVE_LOOP_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__OWNED_ANNOTATIONS = IMPERATIVE_LOOP_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__HAS_ERROR = IMPERATIVE_LOOP_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__LOCAL_LEFT = IMPERATIVE_LOOP_EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = IMPERATIVE_LOOP_EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__LOCAL_PARENT = IMPERATIVE_LOOP_EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__LOCAL_RIGHT = IMPERATIVE_LOOP_EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = IMPERATIVE_LOOP_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__PRECEDENCE = IMPERATIVE_LOOP_EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__IS_PRE = IMPERATIVE_LOOP_EXP_CS__IS_PRE;

	/**
	 * The feature id for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = IMPERATIVE_LOOP_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__OWNED_PATH_NAME = IMPERATIVE_LOOP_EXP_CS__OWNED_PATH_NAME;

	/**
	 * The feature id for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE = IMPERATIVE_LOOP_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Square Bracketed Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES = IMPERATIVE_LOOP_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__SOURCE_TYPE = IMPERATIVE_LOOP_EXP_CS__SOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Source Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__SOURCE_TYPE_VALUE = IMPERATIVE_LOOP_EXP_CS__SOURCE_TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__ARGUMENTS = IMPERATIVE_LOOP_EXP_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_CS__SOURCE = IMPERATIVE_LOOP_EXP_CS__SOURCE;

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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.InstantiationExpCSImpl <em>Instantiation Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.InstantiationExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getInstantiationExpCS()
	 * @generated
	 */
	int INSTANTIATION_EXP_CS = 9;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__CSI = STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__PARENT = STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__PIVOT = STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__ORIGINAL_XMI_ID = STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__OWNED_ANNOTATIONS = STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__HAS_ERROR = STATEMENT_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__LOCAL_LEFT = STATEMENT_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = STATEMENT_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__LOCAL_PARENT = STATEMENT_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__LOCAL_RIGHT = STATEMENT_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = STATEMENT_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_CS__PRECEDENCE = STATEMENT_CS__PRECEDENCE;

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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DoExpCSImpl <em>Do Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DoExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getDoExpCS()
	 * @generated
	 */
	int DO_EXP_CS = 10;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__CSI = EXPRESSION_BLOCK_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__PARENT = EXPRESSION_BLOCK_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__PIVOT = EXPRESSION_BLOCK_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__ORIGINAL_XMI_ID = EXPRESSION_BLOCK_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__OWNED_ANNOTATIONS = EXPRESSION_BLOCK_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__HAS_ERROR = EXPRESSION_BLOCK_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__LOCAL_LEFT = EXPRESSION_BLOCK_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = EXPRESSION_BLOCK_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__LOCAL_PARENT = EXPRESSION_BLOCK_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__LOCAL_RIGHT = EXPRESSION_BLOCK_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = EXPRESSION_BLOCK_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__PRECEDENCE = EXPRESSION_BLOCK_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__BODY = EXPRESSION_BLOCK_CS__BODY;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS__CONDITION = EXPRESSION_BLOCK_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Do Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_EXP_CS_FEATURE_COUNT = EXPRESSION_BLOCK_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ExceptCSImpl <em>Except CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ExceptCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getExceptCS()
	 * @generated
	 */
	int EXCEPT_CS = 11;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPT_CS__CSI = BaseCSPackage.ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPT_CS__PARENT = BaseCSPackage.ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Except</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPT_CS__EXCEPT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPT_CS__BODY = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Except CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPT_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ExpressionStatementCSImpl <em>Expression Statement CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ExpressionStatementCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getExpressionStatementCS()
	 * @generated
	 */
	int EXPRESSION_STATEMENT_CS = 13;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__CSI = STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__PARENT = STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__PIVOT = STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__ORIGINAL_XMI_ID = STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__OWNED_ANNOTATIONS = STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__HAS_ERROR = STATEMENT_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__LOCAL_LEFT = STATEMENT_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__LOCAL_LEFTMOST_DESCENDANT = STATEMENT_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__LOCAL_PARENT = STATEMENT_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__LOCAL_RIGHT = STATEMENT_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__LOCAL_RIGHTMOST_DESCENDANT = STATEMENT_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_CS__PRECEDENCE = STATEMENT_CS__PRECEDENCE;

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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ForExpCSImpl <em>For Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ForExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getForExpCS()
	 * @generated
	 */
	int FOR_EXP_CS = 14;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__CSI = IMPERATIVE_LOOP_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__PARENT = IMPERATIVE_LOOP_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__PIVOT = IMPERATIVE_LOOP_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__ORIGINAL_XMI_ID = IMPERATIVE_LOOP_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__OWNED_ANNOTATIONS = IMPERATIVE_LOOP_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__HAS_ERROR = IMPERATIVE_LOOP_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__LOCAL_LEFT = IMPERATIVE_LOOP_EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = IMPERATIVE_LOOP_EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__LOCAL_PARENT = IMPERATIVE_LOOP_EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__LOCAL_RIGHT = IMPERATIVE_LOOP_EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = IMPERATIVE_LOOP_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__PRECEDENCE = IMPERATIVE_LOOP_EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__IS_PRE = IMPERATIVE_LOOP_EXP_CS__IS_PRE;

	/**
	 * The feature id for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = IMPERATIVE_LOOP_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__OWNED_PATH_NAME = IMPERATIVE_LOOP_EXP_CS__OWNED_PATH_NAME;

	/**
	 * The feature id for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE = IMPERATIVE_LOOP_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Square Bracketed Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES = IMPERATIVE_LOOP_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__SOURCE_TYPE = IMPERATIVE_LOOP_EXP_CS__SOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Source Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__SOURCE_TYPE_VALUE = IMPERATIVE_LOOP_EXP_CS__SOURCE_TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__ARGUMENTS = IMPERATIVE_LOOP_EXP_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_CS__SOURCE = IMPERATIVE_LOOP_EXP_CS__SOURCE;

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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ListTypeCSImpl <em>List Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ListTypeCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getListTypeCS()
	 * @generated
	 */
	int LIST_TYPE_CS = 15;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_CS__CSI = BaseCSPackage.TYPED_REF_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_CS__PARENT = BaseCSPackage.TYPED_REF_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_CS__PIVOT = BaseCSPackage.TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_CS__OWNED_MULTIPLICITY = BaseCSPackage.TYPED_REF_CS__OWNED_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_CS__TYPE = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_CS_FEATURE_COUNT = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ListLiteralExpCSImpl <em>List Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ListLiteralExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getListLiteralExpCS()
	 * @generated
	 */
	int LIST_LITERAL_EXP_CS = 16;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__CSI = EssentialOCLCSPackage.EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__PARENT = EssentialOCLCSPackage.EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__PIVOT = EssentialOCLCSPackage.EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__OWNED_ANNOTATIONS = EssentialOCLCSPackage.EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__HAS_ERROR = EssentialOCLCSPackage.EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__LOCAL_LEFT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__LOCAL_PARENT = EssentialOCLCSPackage.EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__LOCAL_RIGHT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__PRECEDENCE = EssentialOCLCSPackage.EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS__OWNED_PARTS = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_CS_FEATURE_COUNT = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.LogExpCSImpl <em>Log Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.LogExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getLogExpCS()
	 * @generated
	 */
	int LOG_EXP_CS = 17;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__CSI = EssentialOCLCSPackage.CALL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__PARENT = EssentialOCLCSPackage.CALL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__PIVOT = EssentialOCLCSPackage.CALL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.CALL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__OWNED_ANNOTATIONS = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__HAS_ERROR = EssentialOCLCSPackage.CALL_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__LOCAL_LEFT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__LOCAL_PARENT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__LOCAL_RIGHT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = EssentialOCLCSPackage.CALL_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__PRECEDENCE = EssentialOCLCSPackage.CALL_EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__IS_PRE = EssentialOCLCSPackage.CALL_EXP_CS__IS_PRE;

	/**
	 * The feature id for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__OWNED_PATH_NAME = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_PATH_NAME;

	/**
	 * The feature id for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE;

	/**
	 * The feature id for the '<em><b>Owned Square Bracketed Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES = EssentialOCLCSPackage.CALL_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__SOURCE_TYPE = EssentialOCLCSPackage.CALL_EXP_CS__SOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Source Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__SOURCE_TYPE_VALUE = EssentialOCLCSPackage.CALL_EXP_CS__SOURCE_TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__ARGUMENTS = EssentialOCLCSPackage.CALL_EXP_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__SOURCE = EssentialOCLCSPackage.CALL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS__CONDITION = EssentialOCLCSPackage.CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Log Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_CS_FEATURE_COUNT = EssentialOCLCSPackage.CALL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.QuitExpCSImpl <em>Quit Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.QuitExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getQuitExpCS()
	 * @generated
	 */
	int QUIT_EXP_CS = 18;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__CSI = STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__PARENT = STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__PIVOT = STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__ORIGINAL_XMI_ID = STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__OWNED_ANNOTATIONS = STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__HAS_ERROR = STATEMENT_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__LOCAL_LEFT = STATEMENT_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = STATEMENT_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__LOCAL_PARENT = STATEMENT_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__LOCAL_RIGHT = STATEMENT_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = STATEMENT_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__PRECEDENCE = STATEMENT_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Keyword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__KEYWORD = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS__VALUE = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Quit Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUIT_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.RaiseExpCSImpl <em>Raise Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.RaiseExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getRaiseExpCS()
	 * @generated
	 */
	int RAISE_EXP_CS = 19;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__CSI = STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__PARENT = STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__PIVOT = STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__ORIGINAL_XMI_ID = STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__OWNED_ANNOTATIONS = STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__HAS_ERROR = STATEMENT_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__LOCAL_LEFT = STATEMENT_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = STATEMENT_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__LOCAL_PARENT = STATEMENT_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__LOCAL_RIGHT = STATEMENT_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = STATEMENT_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS__PRECEDENCE = STATEMENT_CS__PRECEDENCE;

	/**
	 * The number of structural features of the '<em>Raise Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ReturnExpCSImpl <em>Return Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ReturnExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getReturnExpCS()
	 * @generated
	 */
	int RETURN_EXP_CS = 20;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__CSI = EssentialOCLCSPackage.EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__PARENT = EssentialOCLCSPackage.EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__PIVOT = EssentialOCLCSPackage.EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__OWNED_ANNOTATIONS = EssentialOCLCSPackage.EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__HAS_ERROR = EssentialOCLCSPackage.EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__LOCAL_LEFT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__LOCAL_PARENT = EssentialOCLCSPackage.EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__LOCAL_RIGHT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__PRECEDENCE = EssentialOCLCSPackage.EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS__VALUE = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_CS_FEATURE_COUNT = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.SwitchAltCSImpl <em>Switch Alt CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.SwitchAltCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getSwitchAltCS()
	 * @generated
	 */
	int SWITCH_ALT_CS = 22;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__CSI = STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__PARENT = STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__PIVOT = STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__ORIGINAL_XMI_ID = STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__OWNED_ANNOTATIONS = STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__HAS_ERROR = STATEMENT_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__LOCAL_LEFT = STATEMENT_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__LOCAL_LEFTMOST_DESCENDANT = STATEMENT_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__LOCAL_PARENT = STATEMENT_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__LOCAL_RIGHT = STATEMENT_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__LOCAL_RIGHTMOST_DESCENDANT = STATEMENT_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__PRECEDENCE = STATEMENT_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__CONDITION = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__BODY = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Keyword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS__KEYWORD = STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Switch Alt CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ALT_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.SwitchExpCSImpl <em>Switch Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.SwitchExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getSwitchExpCS()
	 * @generated
	 */
	int SWITCH_EXP_CS = 23;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__CSI = STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__PARENT = STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__PIVOT = STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__ORIGINAL_XMI_ID = STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__OWNED_ANNOTATIONS = STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__HAS_ERROR = STATEMENT_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__LOCAL_LEFT = STATEMENT_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = STATEMENT_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__LOCAL_PARENT = STATEMENT_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__LOCAL_RIGHT = STATEMENT_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = STATEMENT_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_CS__PRECEDENCE = STATEMENT_CS__PRECEDENCE;

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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.TryExpCSImpl <em>Try Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.TryExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getTryExpCS()
	 * @generated
	 */
	int TRY_EXP_CS = 24;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__CSI = EXPRESSION_BLOCK_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__PARENT = EXPRESSION_BLOCK_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__PIVOT = EXPRESSION_BLOCK_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__ORIGINAL_XMI_ID = EXPRESSION_BLOCK_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__OWNED_ANNOTATIONS = EXPRESSION_BLOCK_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__HAS_ERROR = EXPRESSION_BLOCK_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__LOCAL_LEFT = EXPRESSION_BLOCK_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = EXPRESSION_BLOCK_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__LOCAL_PARENT = EXPRESSION_BLOCK_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__LOCAL_RIGHT = EXPRESSION_BLOCK_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = EXPRESSION_BLOCK_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__PRECEDENCE = EXPRESSION_BLOCK_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__BODY = EXPRESSION_BLOCK_CS__BODY;

	/**
	 * The feature id for the '<em><b>Catch</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS__CATCH = EXPRESSION_BLOCK_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Try Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_CS_FEATURE_COUNT = EXPRESSION_BLOCK_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.VariableInitializationCSImpl <em>Variable Initialization CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.VariableInitializationCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getVariableInitializationCS()
	 * @generated
	 */
	int VARIABLE_INITIALIZATION_CS = 25;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__CSI = STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__PARENT = STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__PIVOT = STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__ORIGINAL_XMI_ID = STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__OWNED_ANNOTATIONS = STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__HAS_ERROR = STATEMENT_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__LOCAL_LEFT = STATEMENT_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__LOCAL_LEFTMOST_DESCENDANT = STATEMENT_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__LOCAL_PARENT = STATEMENT_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__LOCAL_RIGHT = STATEMENT_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__LOCAL_RIGHTMOST_DESCENDANT = STATEMENT_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__PRECEDENCE = STATEMENT_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_CS__OCL_EXPRESSION_CS = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.WhileExpCSImpl <em>While Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.WhileExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getWhileExpCS()
	 * @generated
	 */
	int WHILE_EXP_CS = 26;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__CSI = EXPRESSION_BLOCK_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__PARENT = EXPRESSION_BLOCK_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__PIVOT = EXPRESSION_BLOCK_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__ORIGINAL_XMI_ID = EXPRESSION_BLOCK_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__OWNED_ANNOTATIONS = EXPRESSION_BLOCK_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__HAS_ERROR = EXPRESSION_BLOCK_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__LOCAL_LEFT = EXPRESSION_BLOCK_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__LOCAL_LEFTMOST_DESCENDANT = EXPRESSION_BLOCK_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__LOCAL_PARENT = EXPRESSION_BLOCK_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__LOCAL_RIGHT = EXPRESSION_BLOCK_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__LOCAL_RIGHTMOST_DESCENDANT = EXPRESSION_BLOCK_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__PRECEDENCE = EXPRESSION_BLOCK_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__BODY = EXPRESSION_BLOCK_CS__BODY;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__CONDITION = EXPRESSION_BLOCK_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS__RESULT_VAR = EXPRESSION_BLOCK_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>While Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_CS_FEATURE_COUNT = EXPRESSION_BLOCK_CS_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.AssertExpCS <em>Assert Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assert Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.AssertExpCS
	 * @generated
	 */
	EClass getAssertExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.AssertExpCS#getAssertion <em>Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assertion</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.AssertExpCS#getAssertion()
	 * @see #getAssertExpCS()
	 * @generated
	 */
	EReference getAssertExpCS_Assertion();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.AssertExpCS#getLog <em>Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.AssertExpCS#getLog()
	 * @see #getAssertExpCS()
	 * @generated
	 */
	EReference getAssertExpCS_Log();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.AssertExpCS#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.AssertExpCS#getSeverity()
	 * @see #getAssertExpCS()
	 * @generated
	 */
	EAttribute getAssertExpCS_Severity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.AssignStatementCS <em>Assign Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assign Statement CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.AssignStatementCS
	 * @generated
	 */
	EClass getAssignStatementCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.AssignStatementCS#getLValueCS <em>LValue CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>LValue CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.AssignStatementCS#getLValueCS()
	 * @see #getAssignStatementCS()
	 * @generated
	 */
	EReference getAssignStatementCS_LValueCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.AssignStatementCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.AssignStatementCS#getOclExpressionCS()
	 * @see #getAssignStatementCS()
	 * @generated
	 */
	EReference getAssignStatementCS_OclExpressionCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.AssignStatementCS#isIncremental <em>Incremental</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Incremental</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.AssignStatementCS#isIncremental()
	 * @see #getAssignStatementCS()
	 * @generated
	 */
	EAttribute getAssignStatementCS_Incremental();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.BlockExpCS <em>Block Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.BlockExpCS
	 * @generated
	 */
	EClass getBlockExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.BlockExpCS#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.BlockExpCS#getExpressions()
	 * @see #getBlockExpCS()
	 * @generated
	 */
	EReference getBlockExpCS_Expressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralExpCS <em>Dict Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dict Literal Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralExpCS
	 * @generated
	 */
	EClass getDictLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralExpCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralExpCS#getOwnedParts()
	 * @see #getDictLiteralExpCS()
	 * @generated
	 */
	EReference getDictLiteralExpCS_OwnedParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralPartCS <em>Dict Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dict Literal Part CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralPartCS
	 * @generated
	 */
	EClass getDictLiteralPartCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralPartCS#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralPartCS#getKey()
	 * @see #getDictLiteralPartCS()
	 * @generated
	 */
	EReference getDictLiteralPartCS_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralPartCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralPartCS#getValue()
	 * @see #getDictLiteralPartCS()
	 * @generated
	 */
	EReference getDictLiteralPartCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.DictTypeCS <em>Dict Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dict Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.DictTypeCS
	 * @generated
	 */
	EClass getDictTypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.DictTypeCS#getKeyType <em>Key Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key Type</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.DictTypeCS#getKeyType()
	 * @see #getDictTypeCS()
	 * @generated
	 */
	EReference getDictTypeCS_KeyType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.DictTypeCS#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Type</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.DictTypeCS#getValueType()
	 * @see #getDictTypeCS()
	 * @generated
	 */
	EReference getDictTypeCS_ValueType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ComputeExpCS <em>Compute Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compute Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ComputeExpCS
	 * @generated
	 */
	EClass getComputeExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ComputeExpCS#getReturnedElement <em>Returned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Returned Element</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ComputeExpCS#getReturnedElement()
	 * @see #getComputeExpCS()
	 * @generated
	 */
	EReference getComputeExpCS_ReturnedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeIterateExpCS <em>Imperative Iterate Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Iterate Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeIterateExpCS
	 * @generated
	 */
	EClass getImperativeIterateExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeIterateExpCS#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeIterateExpCS#getTarget()
	 * @see #getImperativeIterateExpCS()
	 * @generated
	 */
	EReference getImperativeIterateExpCS_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeLoopExpCS <em>Imperative Loop Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Loop Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeLoopExpCS
	 * @generated
	 */
	EClass getImperativeLoopExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeLoopExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeLoopExpCS#getCondition()
	 * @see #getImperativeLoopExpCS()
	 * @generated
	 */
	EReference getImperativeLoopExpCS_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.InstantiationExpCS <em>Instantiation Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instantiation Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.InstantiationExpCS
	 * @generated
	 */
	EClass getInstantiationExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.InstantiationExpCS#getTypeSpecCS <em>Type Spec CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Spec CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.InstantiationExpCS#getTypeSpecCS()
	 * @see #getInstantiationExpCS()
	 * @generated
	 */
	EReference getInstantiationExpCS_TypeSpecCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.InstantiationExpCS#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.InstantiationExpCS#getArguments()
	 * @see #getInstantiationExpCS()
	 * @generated
	 */
	EReference getInstantiationExpCS_Arguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.DoExpCS <em>Do Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Do Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.DoExpCS
	 * @generated
	 */
	EClass getDoExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.DoExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.DoExpCS#getCondition()
	 * @see #getDoExpCS()
	 * @generated
	 */
	EReference getDoExpCS_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ExceptCS <em>Except CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Except CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ExceptCS
	 * @generated
	 */
	EClass getExceptCS();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ExceptCS#getExcept <em>Except</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Except</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ExceptCS#getExcept()
	 * @see #getExceptCS()
	 * @generated
	 */
	EReference getExceptCS_Except();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ExceptCS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ExceptCS#getBody()
	 * @see #getExceptCS()
	 * @generated
	 */
	EReference getExceptCS_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ExpressionBlockCS <em>Expression Block CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Block CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ExpressionBlockCS
	 * @generated
	 */
	EClass getExpressionBlockCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ExpressionBlockCS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Body</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ExpressionBlockCS#getBody()
	 * @see #getExpressionBlockCS()
	 * @generated
	 */
	EReference getExpressionBlockCS_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ExpressionStatementCS <em>Expression Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Statement CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ExpressionStatementCS
	 * @generated
	 */
	EClass getExpressionStatementCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ExpressionStatementCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ExpressionStatementCS#getOclExpressionCS()
	 * @see #getExpressionStatementCS()
	 * @generated
	 */
	EReference getExpressionStatementCS_OclExpressionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ForExpCS <em>For Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ForExpCS
	 * @generated
	 */
	EClass getForExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ListTypeCS <em>List Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ListTypeCS
	 * @generated
	 */
	EClass getListTypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ListTypeCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ListTypeCS#getType()
	 * @see #getListTypeCS()
	 * @generated
	 */
	EReference getListTypeCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ListLiteralExpCS <em>List Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Literal Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ListLiteralExpCS
	 * @generated
	 */
	EClass getListLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ListLiteralExpCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ListLiteralExpCS#getOwnedParts()
	 * @see #getListLiteralExpCS()
	 * @generated
	 */
	EReference getListLiteralExpCS_OwnedParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.LogExpCS <em>Log Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.LogExpCS
	 * @generated
	 */
	EClass getLogExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.LogExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.LogExpCS#getCondition()
	 * @see #getLogExpCS()
	 * @generated
	 */
	EReference getLogExpCS_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.QuitExpCS <em>Quit Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quit Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.QuitExpCS
	 * @generated
	 */
	EClass getQuitExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.QuitExpCS#getKeyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Keyword</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.QuitExpCS#getKeyword()
	 * @see #getQuitExpCS()
	 * @generated
	 */
	EAttribute getQuitExpCS_Keyword();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.QuitExpCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.QuitExpCS#getValue()
	 * @see #getQuitExpCS()
	 * @generated
	 */
	EReference getQuitExpCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.RaiseExpCS <em>Raise Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Raise Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.RaiseExpCS
	 * @generated
	 */
	EClass getRaiseExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ReturnExpCS <em>Return Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ReturnExpCS
	 * @generated
	 */
	EClass getReturnExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ReturnExpCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ReturnExpCS#getValue()
	 * @see #getReturnExpCS()
	 * @generated
	 */
	EReference getReturnExpCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.StatementCS <em>Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.StatementCS
	 * @generated
	 */
	EClass getStatementCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchAltCS <em>Switch Alt CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Alt CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchAltCS
	 * @generated
	 */
	EClass getSwitchAltCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchAltCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchAltCS#getCondition()
	 * @see #getSwitchAltCS()
	 * @generated
	 */
	EReference getSwitchAltCS_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchAltCS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchAltCS#getBody()
	 * @see #getSwitchAltCS()
	 * @generated
	 */
	EReference getSwitchAltCS_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchAltCS#getKeyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Keyword</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchAltCS#getKeyword()
	 * @see #getSwitchAltCS()
	 * @generated
	 */
	EAttribute getSwitchAltCS_Keyword();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchExpCS <em>Switch Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchExpCS
	 * @generated
	 */
	EClass getSwitchExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchExpCS#getAlternativePart <em>Alternative Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Alternative Part</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchExpCS#getAlternativePart()
	 * @see #getSwitchExpCS()
	 * @generated
	 */
	EReference getSwitchExpCS_AlternativePart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchExpCS#getElsePart <em>Else Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Part</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchExpCS#getElsePart()
	 * @see #getSwitchExpCS()
	 * @generated
	 */
	EReference getSwitchExpCS_ElsePart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.TryExpCS <em>Try Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Try Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.TryExpCS
	 * @generated
	 */
	EClass getTryExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.TryExpCS#getCatch <em>Catch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Catch</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.TryExpCS#getCatch()
	 * @see #getTryExpCS()
	 * @generated
	 */
	EReference getTryExpCS_Catch();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.VariableInitializationCS <em>Variable Initialization CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Initialization CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.VariableInitializationCS
	 * @generated
	 */
	EClass getVariableInitializationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.VariableInitializationCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.VariableInitializationCS#getOclExpressionCS()
	 * @see #getVariableInitializationCS()
	 * @generated
	 */
	EReference getVariableInitializationCS_OclExpressionCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.VariableInitializationCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.VariableInitializationCS#getSimpleNameCS()
	 * @see #getVariableInitializationCS()
	 * @generated
	 */
	EAttribute getVariableInitializationCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.VariableInitializationCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.VariableInitializationCS#getTypeCS()
	 * @see #getVariableInitializationCS()
	 * @generated
	 */
	EReference getVariableInitializationCS_TypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.VariableInitializationCS#isWithResult <em>With Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With Result</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.VariableInitializationCS#isWithResult()
	 * @see #getVariableInitializationCS()
	 * @generated
	 */
	EAttribute getVariableInitializationCS_WithResult();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.WhileExpCS <em>While Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.WhileExpCS
	 * @generated
	 */
	EClass getWhileExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.WhileExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.WhileExpCS#getCondition()
	 * @see #getWhileExpCS()
	 * @generated
	 */
	EReference getWhileExpCS_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.WhileExpCS#getResultVar <em>Result Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result Var</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.WhileExpCS#getResultVar()
	 * @see #getWhileExpCS()
	 * @generated
	 */
	EReference getWhileExpCS_ResultVar();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImperativeOCLCSFactory getImperativeOCLCSFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssertExpCSImpl <em>Assert Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssertExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getAssertExpCS()
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
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_EXP_CS__SEVERITY = eINSTANCE.getAssertExpCS_Severity();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssignStatementCSImpl <em>Assign Statement CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssignStatementCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getAssignStatementCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.BlockExpCSImpl <em>Block Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.BlockExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getBlockExpCS()
		 * @generated
		 */
		EClass BLOCK_EXP_CS = eINSTANCE.getBlockExpCS();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_EXP_CS__EXPRESSIONS = eINSTANCE.getBlockExpCS_Expressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DictLiteralExpCSImpl <em>Dict Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DictLiteralExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getDictLiteralExpCS()
		 * @generated
		 */
		EClass DICT_LITERAL_EXP_CS = eINSTANCE.getDictLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICT_LITERAL_EXP_CS__OWNED_PARTS = eINSTANCE.getDictLiteralExpCS_OwnedParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DictLiteralPartCSImpl <em>Dict Literal Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DictLiteralPartCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getDictLiteralPartCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DictTypeCSImpl <em>Dict Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DictTypeCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getDictTypeCS()
		 * @generated
		 */
		EClass DICT_TYPE_CS = eINSTANCE.getDictTypeCS();

		/**
		 * The meta object literal for the '<em><b>Key Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICT_TYPE_CS__KEY_TYPE = eINSTANCE.getDictTypeCS_KeyType();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICT_TYPE_CS__VALUE_TYPE = eINSTANCE.getDictTypeCS_ValueType();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ComputeExpCSImpl <em>Compute Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ComputeExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getComputeExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeIterateExpCSImpl <em>Imperative Iterate Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeIterateExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getImperativeIterateExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeLoopExpCSImpl <em>Imperative Loop Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeLoopExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getImperativeLoopExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.InstantiationExpCSImpl <em>Instantiation Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.InstantiationExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getInstantiationExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DoExpCSImpl <em>Do Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.DoExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getDoExpCS()
		 * @generated
		 */
		EClass DO_EXP_CS = eINSTANCE.getDoExpCS();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DO_EXP_CS__CONDITION = eINSTANCE.getDoExpCS_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ExceptCSImpl <em>Except CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ExceptCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getExceptCS()
		 * @generated
		 */
		EClass EXCEPT_CS = eINSTANCE.getExceptCS();

		/**
		 * The meta object literal for the '<em><b>Except</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCEPT_CS__EXCEPT = eINSTANCE.getExceptCS_Except();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCEPT_CS__BODY = eINSTANCE.getExceptCS_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ExpressionBlockCSImpl <em>Expression Block CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ExpressionBlockCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getExpressionBlockCS()
		 * @generated
		 */
		EClass EXPRESSION_BLOCK_CS = eINSTANCE.getExpressionBlockCS();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_BLOCK_CS__BODY = eINSTANCE.getExpressionBlockCS_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ExpressionStatementCSImpl <em>Expression Statement CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ExpressionStatementCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getExpressionStatementCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ForExpCSImpl <em>For Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ForExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getForExpCS()
		 * @generated
		 */
		EClass FOR_EXP_CS = eINSTANCE.getForExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ListTypeCSImpl <em>List Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ListTypeCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getListTypeCS()
		 * @generated
		 */
		EClass LIST_TYPE_CS = eINSTANCE.getListTypeCS();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_TYPE_CS__TYPE = eINSTANCE.getListTypeCS_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ListLiteralExpCSImpl <em>List Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ListLiteralExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getListLiteralExpCS()
		 * @generated
		 */
		EClass LIST_LITERAL_EXP_CS = eINSTANCE.getListLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_LITERAL_EXP_CS__OWNED_PARTS = eINSTANCE.getListLiteralExpCS_OwnedParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.LogExpCSImpl <em>Log Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.LogExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getLogExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.QuitExpCSImpl <em>Quit Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.QuitExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getQuitExpCS()
		 * @generated
		 */
		EClass QUIT_EXP_CS = eINSTANCE.getQuitExpCS();

		/**
		 * The meta object literal for the '<em><b>Keyword</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUIT_EXP_CS__KEYWORD = eINSTANCE.getQuitExpCS_Keyword();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUIT_EXP_CS__VALUE = eINSTANCE.getQuitExpCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.RaiseExpCSImpl <em>Raise Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.RaiseExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getRaiseExpCS()
		 * @generated
		 */
		EClass RAISE_EXP_CS = eINSTANCE.getRaiseExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ReturnExpCSImpl <em>Return Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ReturnExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getReturnExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.StatementCSImpl <em>Statement CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.StatementCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getStatementCS()
		 * @generated
		 */
		EClass STATEMENT_CS = eINSTANCE.getStatementCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.SwitchAltCSImpl <em>Switch Alt CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.SwitchAltCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getSwitchAltCS()
		 * @generated
		 */
		EClass SWITCH_ALT_CS = eINSTANCE.getSwitchAltCS();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_ALT_CS__CONDITION = eINSTANCE.getSwitchAltCS_Condition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_ALT_CS__BODY = eINSTANCE.getSwitchAltCS_Body();

		/**
		 * The meta object literal for the '<em><b>Keyword</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWITCH_ALT_CS__KEYWORD = eINSTANCE.getSwitchAltCS_Keyword();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.SwitchExpCSImpl <em>Switch Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.SwitchExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getSwitchExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.TryExpCSImpl <em>Try Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.TryExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getTryExpCS()
		 * @generated
		 */
		EClass TRY_EXP_CS = eINSTANCE.getTryExpCS();

		/**
		 * The meta object literal for the '<em><b>Catch</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_EXP_CS__CATCH = eINSTANCE.getTryExpCS_Catch();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.VariableInitializationCSImpl <em>Variable Initialization CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.VariableInitializationCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getVariableInitializationCS()
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
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_INITIALIZATION_CS__SIMPLE_NAME_CS = eINSTANCE.getVariableInitializationCS_SimpleNameCS();

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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.WhileExpCSImpl <em>While Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.WhileExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ImperativeOCLCSPackageImpl#getWhileExpCS()
		 * @generated
		 */
		EClass WHILE_EXP_CS = eINSTANCE.getWhileExpCS();

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

	}

} //ImperativeOCLCSPackage
