/**
 * <copyright>
 * </copyright>
 *
 * $Id: ImperativeOCLPackage.java,v 1.3 2009/12/09 14:03:54 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.ImperativeOCL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;
import org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage;

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
 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLFactory
 * @model kind="package"
 * @generated
 */
public interface ImperativeOCLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ImperativeOCL";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://schema.omg.org/spec/QVT/1.1/imperativeocl.xml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "impocl";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.m2m.qvt.oml.emof.imperativeocl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImperativeOCLPackage eINSTANCE = org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeExpressionImpl <em>Imperative Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeExpressionImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getImperativeExpression()
	 * @generated
	 */
	int IMPERATIVE_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION__OWNED_COMMENT = EssentialOCLPackage.OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION__NAME = EssentialOCLPackage.OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION__TYPE = EssentialOCLPackage.OCL_EXPRESSION__TYPE;

	/**
	 * The number of structural features of the '<em>Imperative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION_FEATURE_COUNT = EssentialOCLPackage.OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.AltExpImpl <em>Alt Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.AltExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getAltExp()
	 * @generated
	 */
	int ALT_EXP = 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__CONDITION = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Alt Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.AssertExpImpl <em>Assert Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.AssertExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getAssertExp()
	 * @generated
	 */
	int ASSERT_EXP = 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Assertion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__ASSERTION = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Log</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__LOG = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__SEVERITY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assert Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.AssignExpImpl <em>Assign Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.AssignExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getAssignExp()
	 * @generated
	 */
	int ASSIGN_EXP = 2;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__DEFAULT_VALUE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Reset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__IS_RESET = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__LEFT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__VALUE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Assign Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.BlockExpImpl <em>Block Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.BlockExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getBlockExp()
	 * @generated
	 */
	int BLOCK_EXP = 3;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.BreakExpImpl <em>Break Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.BreakExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getBreakExp()
	 * @generated
	 */
	int BREAK_EXP = 4;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The number of structural features of the '<em>Break Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.CatchExpImpl <em>Catch Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.CatchExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getCatchExp()
	 * @generated
	 */
	int CATCH_EXP = 5;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__EXCEPTION = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Catch Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ComputeExpImpl <em>Compute Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ComputeExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getComputeExp()
	 * @generated
	 */
	int COMPUTE_EXP = 6;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Returned Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__RETURNED_ELEMENT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Compute Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ContinueExpImpl <em>Continue Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ContinueExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getContinueExp()
	 * @generated
	 */
	int CONTINUE_EXP = 7;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The number of structural features of the '<em>Continue Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.DictLiteralExpImpl <em>Dict Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.DictLiteralExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getDictLiteralExp()
	 * @generated
	 */
	int DICT_LITERAL_EXP = 8;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP__OWNED_COMMENT = EssentialOCLPackage.LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP__NAME = EssentialOCLPackage.LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP__TYPE = EssentialOCLPackage.LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP__PART = EssentialOCLPackage.LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dict Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_FEATURE_COUNT = EssentialOCLPackage.LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.DictLiteralPartImpl <em>Dict Literal Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.DictLiteralPartImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getDictLiteralPart()
	 * @generated
	 */
	int DICT_LITERAL_PART = 9;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART__OWNED_COMMENT = EMOFPackage.ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART__KEY = EMOFPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART__VALUE = EMOFPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dict Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_FEATURE_COUNT = EMOFPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.DictionaryTypeImpl <em>Dictionary Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.DictionaryTypeImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getDictionaryType()
	 * @generated
	 */
	int DICTIONARY_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__OWNED_COMMENT = EssentialOCLPackage.COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__NAME = EssentialOCLPackage.COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__PACKAGE = EssentialOCLPackage.COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__ELEMENT_TYPE = EssentialOCLPackage.COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Key Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__KEY_TYPE = EssentialOCLPackage.COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dictionary Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE_FEATURE_COUNT = EssentialOCLPackage.COLLECTION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeLoopExpImpl <em>Imperative Loop Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeLoopExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getImperativeLoopExp()
	 * @generated
	 */
	int IMPERATIVE_LOOP_EXP = 14;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__OWNED_COMMENT = EssentialOCLPackage.LOOP_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__NAME = EssentialOCLPackage.LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__TYPE = EssentialOCLPackage.LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__SOURCE = EssentialOCLPackage.LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__BODY = EssentialOCLPackage.LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__ITERATOR = EssentialOCLPackage.LOOP_EXP__ITERATOR;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__CONDITION = EssentialOCLPackage.LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imperative Loop Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_FEATURE_COUNT = EssentialOCLPackage.LOOP_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ForExpImpl <em>For Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ForExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getForExp()
	 * @generated
	 */
	int FOR_EXP = 11;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__OWNED_COMMENT = IMPERATIVE_LOOP_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__NAME = IMPERATIVE_LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__TYPE = IMPERATIVE_LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__SOURCE = IMPERATIVE_LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__BODY = IMPERATIVE_LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__ITERATOR = IMPERATIVE_LOOP_EXP__ITERATOR;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__CONDITION = IMPERATIVE_LOOP_EXP__CONDITION;

	/**
	 * The number of structural features of the '<em>For Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_FEATURE_COUNT = IMPERATIVE_LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeIterateExpImpl <em>Imperative Iterate Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeIterateExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getImperativeIterateExp()
	 * @generated
	 */
	int IMPERATIVE_ITERATE_EXP = 13;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__OWNED_COMMENT = IMPERATIVE_LOOP_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__NAME = IMPERATIVE_LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__TYPE = IMPERATIVE_LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__SOURCE = IMPERATIVE_LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__BODY = IMPERATIVE_LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__ITERATOR = IMPERATIVE_LOOP_EXP__ITERATOR;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__CONDITION = IMPERATIVE_LOOP_EXP__CONDITION;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__TARGET = IMPERATIVE_LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imperative Iterate Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_FEATURE_COUNT = IMPERATIVE_LOOP_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.InstantiationExpImpl <em>Instantiation Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.InstantiationExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getInstantiationExp()
	 * @generated
	 */
	int INSTANTIATION_EXP = 15;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__ARGUMENT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__EXTENT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instantiated Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__INSTANTIATED_CLASS = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Instantiation Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ListLiteralExpImpl <em>List Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ListLiteralExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getListLiteralExp()
	 * @generated
	 */
	int LIST_LITERAL_EXP = 16;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP__OWNED_COMMENT = EssentialOCLPackage.LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP__NAME = EssentialOCLPackage.LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP__TYPE = EssentialOCLPackage.LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP__ELEMENT = EssentialOCLPackage.LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_FEATURE_COUNT = EssentialOCLPackage.LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ListTypeImpl <em>List Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ListTypeImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getListType()
	 * @generated
	 */
	int LIST_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__OWNED_COMMENT = EssentialOCLPackage.COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__NAME = EssentialOCLPackage.COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__PACKAGE = EssentialOCLPackage.COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__ELEMENT_TYPE = EssentialOCLPackage.COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>List Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_FEATURE_COUNT = EssentialOCLPackage.COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.LogExpImpl <em>Log Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.LogExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getLogExp()
	 * @generated
	 */
	int LOG_EXP = 18;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__OWNED_COMMENT = EssentialOCLPackage.OPERATION_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__NAME = EssentialOCLPackage.OPERATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__TYPE = EssentialOCLPackage.OPERATION_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__SOURCE = EssentialOCLPackage.OPERATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__ARGUMENT = EssentialOCLPackage.OPERATION_CALL_EXP__ARGUMENT;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__REFERRED_OPERATION = EssentialOCLPackage.OPERATION_CALL_EXP__REFERRED_OPERATION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__CONDITION = EssentialOCLPackage.OPERATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Log Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_FEATURE_COUNT = EssentialOCLPackage.OPERATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.OrderedTupleLiteralExpImpl <em>Ordered Tuple Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.OrderedTupleLiteralExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getOrderedTupleLiteralExp()
	 * @generated
	 */
	int ORDERED_TUPLE_LITERAL_EXP = 19;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP__OWNED_COMMENT = EssentialOCLPackage.LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP__NAME = EssentialOCLPackage.LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP__TYPE = EssentialOCLPackage.LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP__PART = EssentialOCLPackage.LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ordered Tuple Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP_FEATURE_COUNT = EssentialOCLPackage.LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.OrderedTupleLiteralPartImpl <em>Ordered Tuple Literal Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.OrderedTupleLiteralPartImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getOrderedTupleLiteralPart()
	 * @generated
	 */
	int ORDERED_TUPLE_LITERAL_PART = 20;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_PART__OWNED_COMMENT = EMOFPackage.ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_PART__VALUE = EMOFPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ordered Tuple Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_PART_FEATURE_COUNT = EMOFPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.OrderedTupleTypeImpl <em>Ordered Tuple Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.OrderedTupleTypeImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getOrderedTupleType()
	 * @generated
	 */
	int ORDERED_TUPLE_TYPE = 21;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__OWNED_COMMENT = EMOFPackage.CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__NAME = EMOFPackage.CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__PACKAGE = EMOFPackage.CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__IS_ABSTRACT = EMOFPackage.CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__OWNED_ATTRIBUTE = EMOFPackage.CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__OWNED_OPERATION = EMOFPackage.CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__SUPER_CLASS = EMOFPackage.CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__ELEMENT_TYPE = EMOFPackage.CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ordered Tuple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE_FEATURE_COUNT = EMOFPackage.CLASS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.RaiseExpImpl <em>Raise Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.RaiseExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getRaiseExp()
	 * @generated
	 */
	int RAISE_EXP = 22;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__ARGUMENT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__EXCEPTION = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Raise Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ReturnExpImpl <em>Return Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ReturnExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getReturnExp()
	 * @generated
	 */
	int RETURN_EXP = 23;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__VALUE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.SwitchExpImpl <em>Switch Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.SwitchExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getSwitchExp()
	 * @generated
	 */
	int SWITCH_EXP = 24;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Alternative Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__ALTERNATIVE_PART = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Else Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__ELSE_PART = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Switch Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.TryExpImpl <em>Try Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.TryExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getTryExp()
	 * @generated
	 */
	int TRY_EXP = 25;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Except Clause</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__EXCEPT_CLAUSE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Try Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__TRY_BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Try Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.TypedefImpl <em>Typedef</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.TypedefImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getTypedef()
	 * @generated
	 */
	int TYPEDEF = 26;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__OWNED_COMMENT = EMOFPackage.CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__NAME = EMOFPackage.CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__PACKAGE = EMOFPackage.CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__IS_ABSTRACT = EMOFPackage.CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__OWNED_ATTRIBUTE = EMOFPackage.CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__OWNED_OPERATION = EMOFPackage.CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__SUPER_CLASS = EMOFPackage.CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__BASE = EMOFPackage.CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__CONDITION = EMOFPackage.CLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Typedef</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF_FEATURE_COUNT = EMOFPackage.CLASS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.UnlinkExpImpl <em>Unlink Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.UnlinkExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getUnlinkExp()
	 * @generated
	 */
	int UNLINK_EXP = 27;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__ITEM = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__TARGET = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unlink Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.UnpackExpImpl <em>Unpack Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.UnpackExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getUnpackExp()
	 * @generated
	 */
	int UNPACK_EXP = 28;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__SOURCE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Variable</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__TARGET_VARIABLE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unpack Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.VariableInitExpImpl <em>Variable Init Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.VariableInitExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getVariableInitExp()
	 * @generated
	 */
	int VARIABLE_INIT_EXP = 29;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__REFERRED_VARIABLE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>With Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__WITH_RESULT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Init Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.WhileExpImpl <em>While Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.WhileExpImpl
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getWhileExp()
	 * @generated
	 */
	int WHILE_EXP = 30;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__CONDITION = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>While Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SeverityKind <em>Severity Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SeverityKind
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getSeverityKind()
	 * @generated
	 */
	int SEVERITY_KIND = 31;


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AltExp <em>Alt Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alt Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AltExp
	 * @generated
	 */
	EClass getAltExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AltExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AltExp#getBody()
	 * @see #getAltExp()
	 * @generated
	 */
	EReference getAltExp_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AltExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AltExp#getCondition()
	 * @see #getAltExp()
	 * @generated
	 */
	EReference getAltExp_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp <em>Assert Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assert Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp
	 * @generated
	 */
	EClass getAssertExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp#getAssertion <em>Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assertion</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp#getAssertion()
	 * @see #getAssertExp()
	 * @generated
	 */
	EReference getAssertExp_Assertion();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp#getLog <em>Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp#getLog()
	 * @see #getAssertExp()
	 * @generated
	 */
	EReference getAssertExp_Log();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp#getSeverity()
	 * @see #getAssertExp()
	 * @generated
	 */
	EAttribute getAssertExp_Severity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssignExp <em>Assign Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assign Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssignExp
	 * @generated
	 */
	EClass getAssignExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssignExp#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssignExp#getDefaultValue()
	 * @see #getAssignExp()
	 * @generated
	 */
	EReference getAssignExp_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssignExp#getIsReset <em>Is Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Reset</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssignExp#getIsReset()
	 * @see #getAssignExp()
	 * @generated
	 */
	EAttribute getAssignExp_IsReset();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssignExp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssignExp#getLeft()
	 * @see #getAssignExp()
	 * @generated
	 */
	EReference getAssignExp_Left();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssignExp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssignExp#getValue()
	 * @see #getAssignExp()
	 * @generated
	 */
	EReference getAssignExp_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.BlockExp <em>Block Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.BlockExp
	 * @generated
	 */
	EClass getBlockExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.BlockExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Body</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.BlockExp#getBody()
	 * @see #getBlockExp()
	 * @generated
	 */
	EReference getBlockExp_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.BreakExp <em>Break Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Break Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.BreakExp
	 * @generated
	 */
	EClass getBreakExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.CatchExp <em>Catch Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catch Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.CatchExp
	 * @generated
	 */
	EClass getCatchExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.CatchExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Body</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.CatchExp#getBody()
	 * @see #getCatchExp()
	 * @generated
	 */
	EReference getCatchExp_Body();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.CatchExp#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Exception</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.CatchExp#getException()
	 * @see #getCatchExp()
	 * @generated
	 */
	EReference getCatchExp_Exception();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ComputeExp <em>Compute Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compute Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ComputeExp
	 * @generated
	 */
	EClass getComputeExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ComputeExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ComputeExp#getBody()
	 * @see #getComputeExp()
	 * @generated
	 */
	EReference getComputeExp_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ComputeExp#getReturnedElement <em>Returned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Returned Element</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ComputeExp#getReturnedElement()
	 * @see #getComputeExp()
	 * @generated
	 */
	EReference getComputeExp_ReturnedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ContinueExp <em>Continue Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continue Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ContinueExp
	 * @generated
	 */
	EClass getContinueExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralExp <em>Dict Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dict Literal Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralExp
	 * @generated
	 */
	EClass getDictLiteralExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralExp#getPart()
	 * @see #getDictLiteralExp()
	 * @generated
	 */
	EReference getDictLiteralExp_Part();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralPart <em>Dict Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dict Literal Part</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralPart
	 * @generated
	 */
	EClass getDictLiteralPart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralPart#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralPart#getKey()
	 * @see #getDictLiteralPart()
	 * @generated
	 */
	EReference getDictLiteralPart_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralPart#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralPart#getValue()
	 * @see #getDictLiteralPart()
	 * @generated
	 */
	EReference getDictLiteralPart_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictionaryType <em>Dictionary Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dictionary Type</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictionaryType
	 * @generated
	 */
	EClass getDictionaryType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictionaryType#getKeyType <em>Key Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key Type</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictionaryType#getKeyType()
	 * @see #getDictionaryType()
	 * @generated
	 */
	EReference getDictionaryType_KeyType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ForExp <em>For Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ForExp
	 * @generated
	 */
	EClass getForExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeExpression <em>Imperative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Expression</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeExpression
	 * @generated
	 */
	EClass getImperativeExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeIterateExp <em>Imperative Iterate Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Iterate Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeIterateExp
	 * @generated
	 */
	EClass getImperativeIterateExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeIterateExp#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeIterateExp#getTarget()
	 * @see #getImperativeIterateExp()
	 * @generated
	 */
	EReference getImperativeIterateExp_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeLoopExp <em>Imperative Loop Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Loop Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeLoopExp
	 * @generated
	 */
	EClass getImperativeLoopExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeLoopExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeLoopExp#getCondition()
	 * @see #getImperativeLoopExp()
	 * @generated
	 */
	EReference getImperativeLoopExp_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp <em>Instantiation Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instantiation Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp
	 * @generated
	 */
	EClass getInstantiationExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp#getArgument()
	 * @see #getInstantiationExp()
	 * @generated
	 */
	EReference getInstantiationExp_Argument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extent</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp#getExtent()
	 * @see #getInstantiationExp()
	 * @generated
	 */
	EReference getInstantiationExp_Extent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp#getInstantiatedClass <em>Instantiated Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instantiated Class</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp#getInstantiatedClass()
	 * @see #getInstantiationExp()
	 * @generated
	 */
	EReference getInstantiationExp_InstantiatedClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ListLiteralExp <em>List Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Literal Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ListLiteralExp
	 * @generated
	 */
	EClass getListLiteralExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ListLiteralExp#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ListLiteralExp#getElement()
	 * @see #getListLiteralExp()
	 * @generated
	 */
	EReference getListLiteralExp_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ListType <em>List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Type</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ListType
	 * @generated
	 */
	EClass getListType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.LogExp <em>Log Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.LogExp
	 * @generated
	 */
	EClass getLogExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.LogExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.LogExp#getCondition()
	 * @see #getLogExp()
	 * @generated
	 */
	EReference getLogExp_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleLiteralExp <em>Ordered Tuple Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Tuple Literal Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleLiteralExp
	 * @generated
	 */
	EClass getOrderedTupleLiteralExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleLiteralExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleLiteralExp#getPart()
	 * @see #getOrderedTupleLiteralExp()
	 * @generated
	 */
	EReference getOrderedTupleLiteralExp_Part();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleLiteralPart <em>Ordered Tuple Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Tuple Literal Part</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleLiteralPart
	 * @generated
	 */
	EClass getOrderedTupleLiteralPart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleLiteralPart#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleLiteralPart#getValue()
	 * @see #getOrderedTupleLiteralPart()
	 * @generated
	 */
	EReference getOrderedTupleLiteralPart_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleType <em>Ordered Tuple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Tuple Type</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleType
	 * @generated
	 */
	EClass getOrderedTupleType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleType#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Element Type</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleType#getElementType()
	 * @see #getOrderedTupleType()
	 * @generated
	 */
	EReference getOrderedTupleType_ElementType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.RaiseExp <em>Raise Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Raise Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.RaiseExp
	 * @generated
	 */
	EClass getRaiseExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.RaiseExp#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Argument</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.RaiseExp#getArgument()
	 * @see #getRaiseExp()
	 * @generated
	 */
	EReference getRaiseExp_Argument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.RaiseExp#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exception</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.RaiseExp#getException()
	 * @see #getRaiseExp()
	 * @generated
	 */
	EReference getRaiseExp_Exception();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ReturnExp <em>Return Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ReturnExp
	 * @generated
	 */
	EClass getReturnExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ReturnExp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ReturnExp#getValue()
	 * @see #getReturnExp()
	 * @generated
	 */
	EReference getReturnExp_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SwitchExp <em>Switch Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SwitchExp
	 * @generated
	 */
	EClass getSwitchExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SwitchExp#getAlternativePart <em>Alternative Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Alternative Part</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SwitchExp#getAlternativePart()
	 * @see #getSwitchExp()
	 * @generated
	 */
	EReference getSwitchExp_AlternativePart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SwitchExp#getElsePart <em>Else Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Part</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SwitchExp#getElsePart()
	 * @see #getSwitchExp()
	 * @generated
	 */
	EReference getSwitchExp_ElsePart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.TryExp <em>Try Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Try Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.TryExp
	 * @generated
	 */
	EClass getTryExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.TryExp#getExceptClause <em>Except Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Except Clause</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.TryExp#getExceptClause()
	 * @see #getTryExp()
	 * @generated
	 */
	EReference getTryExp_ExceptClause();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.TryExp#getTryBody <em>Try Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Try Body</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.TryExp#getTryBody()
	 * @see #getTryExp()
	 * @generated
	 */
	EReference getTryExp_TryBody();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.Typedef <em>Typedef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typedef</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.Typedef
	 * @generated
	 */
	EClass getTypedef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.Typedef#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.Typedef#getBase()
	 * @see #getTypedef()
	 * @generated
	 */
	EReference getTypedef_Base();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.Typedef#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.Typedef#getCondition()
	 * @see #getTypedef()
	 * @generated
	 */
	EReference getTypedef_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnlinkExp <em>Unlink Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlink Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnlinkExp
	 * @generated
	 */
	EClass getUnlinkExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnlinkExp#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Item</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnlinkExp#getItem()
	 * @see #getUnlinkExp()
	 * @generated
	 */
	EReference getUnlinkExp_Item();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnlinkExp#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnlinkExp#getTarget()
	 * @see #getUnlinkExp()
	 * @generated
	 */
	EReference getUnlinkExp_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnpackExp <em>Unpack Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unpack Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnpackExp
	 * @generated
	 */
	EClass getUnpackExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnpackExp#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnpackExp#getSource()
	 * @see #getUnpackExp()
	 * @generated
	 */
	EReference getUnpackExp_Source();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnpackExp#getTargetVariable <em>Target Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Variable</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnpackExp#getTargetVariable()
	 * @see #getUnpackExp()
	 * @generated
	 */
	EReference getUnpackExp_TargetVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.VariableInitExp <em>Variable Init Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Init Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.VariableInitExp
	 * @generated
	 */
	EClass getVariableInitExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.VariableInitExp#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.VariableInitExp#getReferredVariable()
	 * @see #getVariableInitExp()
	 * @generated
	 */
	EReference getVariableInitExp_ReferredVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.VariableInitExp#getWithResult <em>With Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With Result</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.VariableInitExp#getWithResult()
	 * @see #getVariableInitExp()
	 * @generated
	 */
	EAttribute getVariableInitExp_WithResult();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.WhileExp <em>While Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Exp</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.WhileExp
	 * @generated
	 */
	EClass getWhileExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.WhileExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.WhileExp#getBody()
	 * @see #getWhileExp()
	 * @generated
	 */
	EReference getWhileExp_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.WhileExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.WhileExp#getCondition()
	 * @see #getWhileExp()
	 * @generated
	 */
	EReference getWhileExp_Condition();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SeverityKind <em>Severity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Severity Kind</em>'.
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SeverityKind
	 * @generated
	 */
	EEnum getSeverityKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImperativeOCLFactory getImperativeOCLFactory();

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
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.AltExpImpl <em>Alt Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.AltExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getAltExp()
		 * @generated
		 */
		EClass ALT_EXP = eINSTANCE.getAltExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALT_EXP__BODY = eINSTANCE.getAltExp_Body();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALT_EXP__CONDITION = eINSTANCE.getAltExp_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.AssertExpImpl <em>Assert Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.AssertExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getAssertExp()
		 * @generated
		 */
		EClass ASSERT_EXP = eINSTANCE.getAssertExp();

		/**
		 * The meta object literal for the '<em><b>Assertion</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT_EXP__ASSERTION = eINSTANCE.getAssertExp_Assertion();

		/**
		 * The meta object literal for the '<em><b>Log</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT_EXP__LOG = eINSTANCE.getAssertExp_Log();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_EXP__SEVERITY = eINSTANCE.getAssertExp_Severity();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.AssignExpImpl <em>Assign Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.AssignExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getAssignExp()
		 * @generated
		 */
		EClass ASSIGN_EXP = eINSTANCE.getAssignExp();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_EXP__DEFAULT_VALUE = eINSTANCE.getAssignExp_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Is Reset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGN_EXP__IS_RESET = eINSTANCE.getAssignExp_IsReset();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_EXP__LEFT = eINSTANCE.getAssignExp_Left();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_EXP__VALUE = eINSTANCE.getAssignExp_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.BlockExpImpl <em>Block Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.BlockExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getBlockExp()
		 * @generated
		 */
		EClass BLOCK_EXP = eINSTANCE.getBlockExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_EXP__BODY = eINSTANCE.getBlockExp_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.BreakExpImpl <em>Break Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.BreakExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getBreakExp()
		 * @generated
		 */
		EClass BREAK_EXP = eINSTANCE.getBreakExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.CatchExpImpl <em>Catch Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.CatchExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getCatchExp()
		 * @generated
		 */
		EClass CATCH_EXP = eINSTANCE.getCatchExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATCH_EXP__BODY = eINSTANCE.getCatchExp_Body();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATCH_EXP__EXCEPTION = eINSTANCE.getCatchExp_Exception();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ComputeExpImpl <em>Compute Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ComputeExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getComputeExp()
		 * @generated
		 */
		EClass COMPUTE_EXP = eINSTANCE.getComputeExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_EXP__BODY = eINSTANCE.getComputeExp_Body();

		/**
		 * The meta object literal for the '<em><b>Returned Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_EXP__RETURNED_ELEMENT = eINSTANCE.getComputeExp_ReturnedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ContinueExpImpl <em>Continue Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ContinueExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getContinueExp()
		 * @generated
		 */
		EClass CONTINUE_EXP = eINSTANCE.getContinueExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.DictLiteralExpImpl <em>Dict Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.DictLiteralExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getDictLiteralExp()
		 * @generated
		 */
		EClass DICT_LITERAL_EXP = eINSTANCE.getDictLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICT_LITERAL_EXP__PART = eINSTANCE.getDictLiteralExp_Part();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.DictLiteralPartImpl <em>Dict Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.DictLiteralPartImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getDictLiteralPart()
		 * @generated
		 */
		EClass DICT_LITERAL_PART = eINSTANCE.getDictLiteralPart();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICT_LITERAL_PART__KEY = eINSTANCE.getDictLiteralPart_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICT_LITERAL_PART__VALUE = eINSTANCE.getDictLiteralPart_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.DictionaryTypeImpl <em>Dictionary Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.DictionaryTypeImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getDictionaryType()
		 * @generated
		 */
		EClass DICTIONARY_TYPE = eINSTANCE.getDictionaryType();

		/**
		 * The meta object literal for the '<em><b>Key Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICTIONARY_TYPE__KEY_TYPE = eINSTANCE.getDictionaryType_KeyType();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ForExpImpl <em>For Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ForExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getForExp()
		 * @generated
		 */
		EClass FOR_EXP = eINSTANCE.getForExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeExpressionImpl <em>Imperative Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeExpressionImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getImperativeExpression()
		 * @generated
		 */
		EClass IMPERATIVE_EXPRESSION = eINSTANCE.getImperativeExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeIterateExpImpl <em>Imperative Iterate Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeIterateExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getImperativeIterateExp()
		 * @generated
		 */
		EClass IMPERATIVE_ITERATE_EXP = eINSTANCE.getImperativeIterateExp();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_ITERATE_EXP__TARGET = eINSTANCE.getImperativeIterateExp_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeLoopExpImpl <em>Imperative Loop Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeLoopExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getImperativeLoopExp()
		 * @generated
		 */
		EClass IMPERATIVE_LOOP_EXP = eINSTANCE.getImperativeLoopExp();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_LOOP_EXP__CONDITION = eINSTANCE.getImperativeLoopExp_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.InstantiationExpImpl <em>Instantiation Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.InstantiationExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getInstantiationExp()
		 * @generated
		 */
		EClass INSTANTIATION_EXP = eINSTANCE.getInstantiationExp();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION_EXP__ARGUMENT = eINSTANCE.getInstantiationExp_Argument();

		/**
		 * The meta object literal for the '<em><b>Extent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION_EXP__EXTENT = eINSTANCE.getInstantiationExp_Extent();

		/**
		 * The meta object literal for the '<em><b>Instantiated Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION_EXP__INSTANTIATED_CLASS = eINSTANCE.getInstantiationExp_InstantiatedClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ListLiteralExpImpl <em>List Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ListLiteralExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getListLiteralExp()
		 * @generated
		 */
		EClass LIST_LITERAL_EXP = eINSTANCE.getListLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_LITERAL_EXP__ELEMENT = eINSTANCE.getListLiteralExp_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ListTypeImpl <em>List Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ListTypeImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getListType()
		 * @generated
		 */
		EClass LIST_TYPE = eINSTANCE.getListType();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.LogExpImpl <em>Log Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.LogExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getLogExp()
		 * @generated
		 */
		EClass LOG_EXP = eINSTANCE.getLogExp();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOG_EXP__CONDITION = eINSTANCE.getLogExp_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.OrderedTupleLiteralExpImpl <em>Ordered Tuple Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.OrderedTupleLiteralExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getOrderedTupleLiteralExp()
		 * @generated
		 */
		EClass ORDERED_TUPLE_LITERAL_EXP = eINSTANCE.getOrderedTupleLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDERED_TUPLE_LITERAL_EXP__PART = eINSTANCE.getOrderedTupleLiteralExp_Part();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.OrderedTupleLiteralPartImpl <em>Ordered Tuple Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.OrderedTupleLiteralPartImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getOrderedTupleLiteralPart()
		 * @generated
		 */
		EClass ORDERED_TUPLE_LITERAL_PART = eINSTANCE.getOrderedTupleLiteralPart();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDERED_TUPLE_LITERAL_PART__VALUE = eINSTANCE.getOrderedTupleLiteralPart_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.OrderedTupleTypeImpl <em>Ordered Tuple Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.OrderedTupleTypeImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getOrderedTupleType()
		 * @generated
		 */
		EClass ORDERED_TUPLE_TYPE = eINSTANCE.getOrderedTupleType();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDERED_TUPLE_TYPE__ELEMENT_TYPE = eINSTANCE.getOrderedTupleType_ElementType();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.RaiseExpImpl <em>Raise Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.RaiseExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getRaiseExp()
		 * @generated
		 */
		EClass RAISE_EXP = eINSTANCE.getRaiseExp();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAISE_EXP__ARGUMENT = eINSTANCE.getRaiseExp_Argument();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAISE_EXP__EXCEPTION = eINSTANCE.getRaiseExp_Exception();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ReturnExpImpl <em>Return Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ReturnExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getReturnExp()
		 * @generated
		 */
		EClass RETURN_EXP = eINSTANCE.getReturnExp();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETURN_EXP__VALUE = eINSTANCE.getReturnExp_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.SwitchExpImpl <em>Switch Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.SwitchExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getSwitchExp()
		 * @generated
		 */
		EClass SWITCH_EXP = eINSTANCE.getSwitchExp();

		/**
		 * The meta object literal for the '<em><b>Alternative Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_EXP__ALTERNATIVE_PART = eINSTANCE.getSwitchExp_AlternativePart();

		/**
		 * The meta object literal for the '<em><b>Else Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_EXP__ELSE_PART = eINSTANCE.getSwitchExp_ElsePart();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.TryExpImpl <em>Try Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.TryExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getTryExp()
		 * @generated
		 */
		EClass TRY_EXP = eINSTANCE.getTryExp();

		/**
		 * The meta object literal for the '<em><b>Except Clause</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_EXP__EXCEPT_CLAUSE = eINSTANCE.getTryExp_ExceptClause();

		/**
		 * The meta object literal for the '<em><b>Try Body</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_EXP__TRY_BODY = eINSTANCE.getTryExp_TryBody();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.TypedefImpl <em>Typedef</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.TypedefImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getTypedef()
		 * @generated
		 */
		EClass TYPEDEF = eINSTANCE.getTypedef();

		/**
		 * The meta object literal for the '<em><b>Base</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPEDEF__BASE = eINSTANCE.getTypedef_Base();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPEDEF__CONDITION = eINSTANCE.getTypedef_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.UnlinkExpImpl <em>Unlink Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.UnlinkExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getUnlinkExp()
		 * @generated
		 */
		EClass UNLINK_EXP = eINSTANCE.getUnlinkExp();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNLINK_EXP__ITEM = eINSTANCE.getUnlinkExp_Item();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNLINK_EXP__TARGET = eINSTANCE.getUnlinkExp_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.UnpackExpImpl <em>Unpack Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.UnpackExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getUnpackExp()
		 * @generated
		 */
		EClass UNPACK_EXP = eINSTANCE.getUnpackExp();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNPACK_EXP__SOURCE = eINSTANCE.getUnpackExp_Source();

		/**
		 * The meta object literal for the '<em><b>Target Variable</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNPACK_EXP__TARGET_VARIABLE = eINSTANCE.getUnpackExp_TargetVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.VariableInitExpImpl <em>Variable Init Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.VariableInitExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getVariableInitExp()
		 * @generated
		 */
		EClass VARIABLE_INIT_EXP = eINSTANCE.getVariableInitExp();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_INIT_EXP__REFERRED_VARIABLE = eINSTANCE.getVariableInitExp_ReferredVariable();

		/**
		 * The meta object literal for the '<em><b>With Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_INIT_EXP__WITH_RESULT = eINSTANCE.getVariableInitExp_WithResult();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.WhileExpImpl <em>While Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.WhileExpImpl
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getWhileExp()
		 * @generated
		 */
		EClass WHILE_EXP = eINSTANCE.getWhileExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_EXP__BODY = eINSTANCE.getWhileExp_Body();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_EXP__CONDITION = eINSTANCE.getWhileExp_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SeverityKind <em>Severity Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SeverityKind
		 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl.ImperativeOCLPackageImpl#getSeverityKind()
		 * @generated
		 */
		EEnum SEVERITY_KIND = eINSTANCE.getSeverityKind();

	}

} //ImperativeOCLPackage
