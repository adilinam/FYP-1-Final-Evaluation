/**
 * <copyright>
 * Copyright (c) 2008, 2009 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo  - initial API and implementation
 * </copyright>
 *
 * $Id: ImperativeOCLValidator.java,v 1.8 2009/12/09 12:45:12 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.*;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AltExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssertExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BlockExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BreakExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.CatchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ComputeExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ContinueExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralPart;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictionaryType;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ForExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeExpression;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeIterateExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeLoopExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.InstantiationExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ListType;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.LogExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleLiteralExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleLiteralPart;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleType;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.RaiseExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ReturnExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.SeverityKind;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.SwitchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.TryExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.Typedef;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnlinkExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnpackExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.VariableInitExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.WhileExp;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.types.util.TypesValidator;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage
 * @generated
 */
public class ImperativeOCLValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ImperativeOCLValidator INSTANCE = new ImperativeOCLValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL"; //$NON-NLS-1$

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcoreValidator ecoreValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected org.eclipse.ocl.ecore.util.EcoreValidator ecore_1Validator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypesValidator typesValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionsValidator expressionsValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOCLValidator() {
		super();
		ecoreValidator = EcoreValidator.INSTANCE;
		ecore_1Validator = org.eclipse.ocl.ecore.util.EcoreValidator.INSTANCE;
		typesValidator = TypesValidator.INSTANCE;
		expressionsValidator = ExpressionsValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return ImperativeOCLPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case ImperativeOCLPackage.ALT_EXP:
				return validateAltExp((AltExp)value, diagnostics, context);
			case ImperativeOCLPackage.ASSERT_EXP:
				return validateAssertExp((AssertExp)value, diagnostics, context);
			case ImperativeOCLPackage.ASSIGN_EXP:
				return validateAssignExp((AssignExp)value, diagnostics, context);
			case ImperativeOCLPackage.BLOCK_EXP:
				return validateBlockExp((BlockExp)value, diagnostics, context);
			case ImperativeOCLPackage.BREAK_EXP:
				return validateBreakExp((BreakExp)value, diagnostics, context);
			case ImperativeOCLPackage.CATCH_EXP:
				return validateCatchExp((CatchExp)value, diagnostics, context);
			case ImperativeOCLPackage.COMPUTE_EXP:
				return validateComputeExp((ComputeExp)value, diagnostics, context);
			case ImperativeOCLPackage.CONTINUE_EXP:
				return validateContinueExp((ContinueExp)value, diagnostics, context);
			case ImperativeOCLPackage.DICT_LITERAL_EXP:
				return validateDictLiteralExp((DictLiteralExp)value, diagnostics, context);
			case ImperativeOCLPackage.DICT_LITERAL_PART:
				return validateDictLiteralPart((DictLiteralPart)value, diagnostics, context);
			case ImperativeOCLPackage.DICTIONARY_TYPE:
				return validateDictionaryType((DictionaryType)value, diagnostics, context);
			case ImperativeOCLPackage.FOR_EXP:
				return validateForExp((ForExp)value, diagnostics, context);
			case ImperativeOCLPackage.IMPERATIVE_EXPRESSION:
				return validateImperativeExpression((ImperativeExpression)value, diagnostics, context);
			case ImperativeOCLPackage.IMPERATIVE_ITERATE_EXP:
				return validateImperativeIterateExp((ImperativeIterateExp)value, diagnostics, context);
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP:
				return validateImperativeLoopExp((ImperativeLoopExp)value, diagnostics, context);
			case ImperativeOCLPackage.INSTANTIATION_EXP:
				return validateInstantiationExp((InstantiationExp)value, diagnostics, context);
			case ImperativeOCLPackage.LIST_LITERAL_EXP:
				return validateListLiteralExp((ListLiteralExp)value, diagnostics, context);
			case ImperativeOCLPackage.LIST_TYPE:
				return validateListType((ListType)value, diagnostics, context);
			case ImperativeOCLPackage.LOG_EXP:
				return validateLogExp((LogExp)value, diagnostics, context);
			case ImperativeOCLPackage.ORDERED_TUPLE_LITERAL_EXP:
				return validateOrderedTupleLiteralExp((OrderedTupleLiteralExp)value, diagnostics, context);
			case ImperativeOCLPackage.ORDERED_TUPLE_LITERAL_PART:
				return validateOrderedTupleLiteralPart((OrderedTupleLiteralPart)value, diagnostics, context);
			case ImperativeOCLPackage.ORDERED_TUPLE_TYPE:
				return validateOrderedTupleType((OrderedTupleType)value, diagnostics, context);
			case ImperativeOCLPackage.RAISE_EXP:
				return validateRaiseExp((RaiseExp)value, diagnostics, context);
			case ImperativeOCLPackage.RETURN_EXP:
				return validateReturnExp((ReturnExp)value, diagnostics, context);
			case ImperativeOCLPackage.SWITCH_EXP:
				return validateSwitchExp((SwitchExp)value, diagnostics, context);
			case ImperativeOCLPackage.TRY_EXP:
				return validateTryExp((TryExp)value, diagnostics, context);
			case ImperativeOCLPackage.TYPEDEF:
				return validateTypedef((Typedef)value, diagnostics, context);
			case ImperativeOCLPackage.UNLINK_EXP:
				return validateUnlinkExp((UnlinkExp)value, diagnostics, context);
			case ImperativeOCLPackage.UNPACK_EXP:
				return validateUnpackExp((UnpackExp)value, diagnostics, context);
			case ImperativeOCLPackage.VARIABLE_INIT_EXP:
				return validateVariableInitExp((VariableInitExp)value, diagnostics, context);
			case ImperativeOCLPackage.WHILE_EXP:
				return validateWhileExp((WhileExp)value, diagnostics, context);
			case ImperativeOCLPackage.SEVERITY_KIND:
				return validateSeverityKind((SeverityKind)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAltExp(AltExp altExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(altExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(altExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(altExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(altExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(altExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(altExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(altExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(altExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(altExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(altExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(altExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(altExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssertExp(AssertExp assertExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(assertExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assertExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assertExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assertExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(assertExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(assertExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(assertExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(assertExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(assertExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(assertExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(assertExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(assertExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignExp(AssignExp assignExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(assignExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assignExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assignExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assignExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(assignExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(assignExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(assignExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(assignExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(assignExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(assignExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(assignExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(assignExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignExp_WellFormedLeftExp(assignExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignExp_checkLeftAndValueExpConformance(assignExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the WellFormedLeftExp constraint of '<em>Assign Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateAssignExp_WellFormedLeftExp(AssignExp assignExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		String message = null;
		
		OCLExpression left = assignExp.getLeft();
		if (left != null) {
			if (!(left instanceof VariableExp)
				&& !(left instanceof PropertyCallExp)) {
				result = false;
				message = "_UI_InvalidLeftExpression_diagnostic";  //$NON-NLS-1$
			}
			else {	// We check  isReset				
				EClassifier leftType = left.getType();
				if (!(leftType instanceof CollectionType)) {	
					// A monovalued property or variable cann't have additive semantics 
					if (!assignExp.isIsReset()) { //must be isReset = true
						result = false;
						message = "_UI_InvalidIsReset_diagnostic";	  //$NON-NLS-1$			
					}
				}
			}
		}
		
		if (!result) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 message,
						 new Object[] { getObjectLabel(assignExp.getLeft(), context) },
						 new Object[] { assignExp },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the checkLeftAndValueExpConformance constraint of '<em>Assign Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateAssignExp_checkLeftAndValueExpConformance(AssignExp assignExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Environment<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter,
		EObject, CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> env = OCLUtil.getValidationEnvironment(assignExp, context);
		
		boolean result = true;
			
		OCLExpression left = assignExp.getLeft();
		if (left != null) {
			EClassifier leftType = left.getType();
			if (leftType != null) {
				boolean multivaluedLeft = false;			
				if (leftType instanceof CollectionType) {
					multivaluedLeft = true;
					leftType = ((CollectionType)leftType).getElementType();
				}				
				for (OCLExpression value : assignExp.getValue()) {
					EClassifier valueType = value.getType();
					if (valueType != null) {
						boolean multivaluedValue = false;
						if (valueType instanceof CollectionType) {
							multivaluedValue = true;
							valueType = ((CollectionType)valueType).getElementType();							
						}
						if (multivaluedValue && !multivaluedLeft) {
							result = false;
							if (diagnostics != null) {
								diagnostics.add
									(createDiagnostic
										(Diagnostic.ERROR,
										 DIAGNOSTIC_SOURCE,
										 0,
										 "_UI_InvalidCollectionValue_diagnostic",  //$NON-NLS-1$
										 new Object[] { getObjectLabel(left.getType(), context),
														getObjectLabel(value.getType(), context)},
										 new Object[] { assignExp },
										 context));
							}
						}
						else {
							if(!TypeUtil.compatibleTypeMatch(env, valueType, leftType)) {						
								result = false;
								if (diagnostics != null) {
									diagnostics.add
										(createDiagnostic
											(Diagnostic.ERROR,
											 DIAGNOSTIC_SOURCE,
											 0,
											 "_UI_NonConformanceLeftValueTypes_diagnostic",  //$NON-NLS-1$
											 new Object[] { getObjectLabel(left.getType(), context),
															getObjectLabel(value.getType(), context)
															},
											 new Object[] { assignExp },
											 context));
								}
							}
						}
					}
				}
			}
		}
		return result;
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockExp(BlockExp blockExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(blockExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(blockExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(blockExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(blockExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(blockExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(blockExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(blockExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(blockExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(blockExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(blockExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(blockExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(blockExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBreakExp(BreakExp breakExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(breakExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(breakExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(breakExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(breakExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(breakExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(breakExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(breakExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(breakExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(breakExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(breakExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(breakExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(breakExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCatchExp(CatchExp catchExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(catchExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(catchExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(catchExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(catchExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(catchExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(catchExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(catchExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(catchExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(catchExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(catchExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(catchExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(catchExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComputeExp(ComputeExp computeExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(computeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(computeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(computeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(computeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(computeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(computeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(computeExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(computeExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(computeExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(computeExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(computeExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(computeExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContinueExp(ContinueExp continueExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(continueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(continueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(continueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(continueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(continueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(continueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(continueExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(continueExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(continueExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(continueExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(continueExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(continueExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDictLiteralExp(DictLiteralExp dictLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(dictLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dictLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dictLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dictLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dictLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dictLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dictLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(dictLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(dictLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(dictLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(dictLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(dictLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDictLiteralPart(DictLiteralPart dictLiteralPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dictLiteralPart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDictionaryType(DictionaryType dictionaryType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(dictionaryType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dictionaryType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dictionaryType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dictionaryType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dictionaryType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dictionaryType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dictionaryType, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateCollectionType_WellFormedName(dictionaryType, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateCollectionType_WellFormedInstanceTypeName(dictionaryType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_UniqueTypeParameterNames(dictionaryType, diagnostics, context);
		if (result || diagnostics != null) result &= typesValidator.validateCollectionType_checkCollectionTypeName(dictionaryType, diagnostics, context);
		if (result || diagnostics != null) result &= typesValidator.validateCollectionType_checkNoInvalidValues(dictionaryType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForExp(ForExp forExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateLoopExp_checkSourceCollection(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateLoopExp_checkLoopVariableInit(forExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateLoopExp_checkLoopVariableType(forExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImperativeExpression(ImperativeExpression imperativeExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(imperativeExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(imperativeExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(imperativeExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(imperativeExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(imperativeExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(imperativeExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(imperativeExpression, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(imperativeExpression, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(imperativeExpression, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(imperativeExpression, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(imperativeExpression, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(imperativeExpression, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImperativeIterateExp(ImperativeIterateExp imperativeIterateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateImperativeIterateExp_WellFormedName(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateLoopExp_checkSourceCollection(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateLoopExp_checkLoopVariableInit(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateLoopExp_checkLoopVariableType(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateImperativeIterateExp_WellFormedTargetVar(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateImperativeIterateExp_WellFormedBody(imperativeIterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateImperativeIterateExp_WellFormedCondition(imperativeIterateExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the WellFormedName constraint of '<em>Imperative Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateImperativeIterateExp_WellFormedName(ImperativeIterateExp imperativeIterateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		String name = imperativeIterateExp.getName();
		if (name == null
			|| (!name.equals("xcollect") //$NON-NLS-1$
			&& !name.equals("xselect") //$NON-NLS-1$
			&& !name.equals("selectOne") //$NON-NLS-1$
			&& !name.equals("collectselect") //$NON-NLS-1$
			&& !name.equals("collectselectOne"))) //$NON-NLS-1$
			result = false;
		
		if (!result) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_UnrecognizedImperativeIterateExp_diagnostic", //$NON-NLS-1$
						 new Object[] { getObjectLabel(imperativeIterateExp, context) },
						 new Object[] { imperativeIterateExp },
						 context));
			}
			return false;
		}
		return ecore_1Validator.validateOCLExpression_WellFormedName(imperativeIterateExp, diagnostics, context);
	}

	/**
	 * Validates the WellFormedTargetVar constraint of '<em>Imperative Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateImperativeIterateExp_WellFormedTargetVar(ImperativeIterateExp imperativeIterateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Environment<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter,
		EObject, CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> env = OCLUtil.getValidationEnvironment(imperativeIterateExp, context);
		
		boolean result = true;
		String message = null;
		int severity=0;
		Variable target = imperativeIterateExp.getTarget();
		String name = imperativeIterateExp.getName();
		if (target != null) {			
			if (name.equals("xcollect") //$NON-NLS-1$
				|| name.equals("select") //$NON-NLS-1$
				|| name.equals("selectOne")) { //$NON-NLS-1$
				result = false;
				severity = Diagnostic.WARNING;
				message = "_UI_UnexpectedTargetVar_diagnostic"; //$NON-NLS-1$
			}
			else {
				OCLExpression body = (OCLExpression) imperativeIterateExp.getBody();
				if (body != null && target.getType()!= null && body.getType() != null					
					&&	!TypeUtil.compatibleTypeMatch(env, body.getType(),
						target.getType())) {
					result = false;
					severity = Diagnostic.ERROR;
					message = "_UI_BodyTypeDoesNotConformTargetVarType_diagnostic"; //$NON-NLS-1$
					
				}
			}
		} 
		else {
			if (name.equals("collectselect") //$NON-NLS-1$
			|| name.equals("collectselectOne")) { //$NON-NLS-1$
				result = false;
				severity = Diagnostic.ERROR;
				message = "_UI_MissedTargetVar_diagnostic"; //$NON-NLS-1$
			}
		}
		if (!result) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(severity,
						 DIAGNOSTIC_SOURCE,
						 0,
						 message,
						 new Object[] { getObjectLabel(imperativeIterateExp, context) },
						 new Object[] { imperativeIterateExp },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the WellFormedBody constraint of '<em>Imperative Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateImperativeIterateExp_WellFormedBody(ImperativeIterateExp imperativeIterateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		OCLExpression body = (OCLExpression) imperativeIterateExp.getBody();
		String name = imperativeIterateExp.getName();
		String message = null;
		int severity=0;
		if (body != null) {
			if (name.equals("xselect") 		//$NON-NLS-1$
			|| name.equals("selectOne")) { 	//$NON-NLS-1$
				result = false;
				severity = Diagnostic.WARNING;
				message = "_UI_UnexpectedBodyExpression_diagnostic";  //$NON-NLS-1$
			}
		}
		else {
			if (name.equals("xcollect") 			//$NON-NLS-1$
			|| name.equals("collectselect") 		//$NON-NLS-1$
			|| name.equals("collectselectOne")) { 	//$NON-NLS-1$
				result = false;
				severity = Diagnostic.ERROR;
				message = "_UI_MissedBodyExpression_diagnostic";  //$NON-NLS-1$
			}
		}
		
		if (!result) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(severity,
						 DIAGNOSTIC_SOURCE,
						 0,
						 message,
						 new Object[] { getObjectLabel(imperativeIterateExp, context) },
						 new Object[] { imperativeIterateExp },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the WellFormedCondition constraint of '<em>Imperative Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateImperativeIterateExp_WellFormedCondition(ImperativeIterateExp imperativeIterateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Environment<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter,
		EObject, CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> env = OCLUtil.getValidationEnvironment(imperativeIterateExp, context);
		
		boolean result = true;
		OCLExpression condition = imperativeIterateExp.getCondition();
		String name = imperativeIterateExp.getName();
		String message = null;
		Object[] objects = null;
		int severity=0;
		if (condition != null) {			
			if (name.equals("xcollect")) { //$NON-NLS-1$
				result = false;
				severity = Diagnostic.WARNING;
				message = "_UI_UnexpectedConditionExpression_diagnostic"; //$NON-NLS-1$
				objects = new Object[] { getObjectLabel(imperativeIterateExp, context) };
			}
			else {
				// Specification says that if condition is an typeExp
				// should be evaluated as oclIsKind(typeExp) which always
				// will return a boolean value
				if (!(condition instanceof TypeExp)
					&& condition.getType() != null) {
					EClassifier type = env.getUMLReflection().asOCLType(condition.getType());
					if (!TypeUtil.exactTypeMatch(env, type, env.getOCLStandardLibrary().getBoolean())) {
						result = false;
						severity = Diagnostic.ERROR;
						message = "_UI_NonBooleanCondition_diagnostic"; //$NON-NLS-1$
						objects = new Object[] { getObjectLabel(type, context)};
					}
				}
				else {	// we will check that the referred type is compatible with the source element type
					OCLExpression source = (OCLExpression )imperativeIterateExp.getSource();
					if (source != null) {
						EClassifier referredType = ((TypeExp)condition).getReferredType();
						EClassifier sourceType = source.getType();
						if (sourceType instanceof CollectionType)  {
							sourceType = ((CollectionType)sourceType).getElementType();
						}
						if (sourceType != null && referredType != null) {
							if (!TypeUtil.compatibleTypeMatch(env, referredType, sourceType)) {
								result = false;
								severity = Diagnostic.ERROR;
								message = "_UI_ReferredTypeDoesNotConformWithSourceElementType_diagnostic"; //$NON-NLS-1$
								objects = new Object[] { getObjectLabel(referredType, context),
														getObjectLabel(sourceType, context)};
							}
						}
					}					
				}
			}
		}
		else {
			if (name.equals("xselect") //$NON-NLS-1$
			|| name.equals("selectOne") //$NON-NLS-1$
			|| name.equals("collectselect") //$NON-NLS-1$
			|| name.equals("collectselectOne")) { //$NON-NLS-1$
				result = false;
				severity = Diagnostic.ERROR;
				message = "_UI_MissedConditionExpression_diagnostic"; //$NON-NLS-1$
				objects = new Object[] { getObjectLabel(imperativeIterateExp, context) };
			}
		}
		
		if (!result) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(severity,
						 DIAGNOSTIC_SOURCE,
						 0,
						 message,
						 objects,
						 new Object[] { imperativeIterateExp },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImperativeLoopExp(ImperativeLoopExp imperativeLoopExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateLoopExp_checkSourceCollection(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateLoopExp_checkLoopVariableInit(imperativeLoopExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateLoopExp_checkLoopVariableType(imperativeLoopExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstantiationExp(InstantiationExp instantiationExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(instantiationExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(instantiationExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(instantiationExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(instantiationExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(instantiationExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(instantiationExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(instantiationExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(instantiationExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(instantiationExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(instantiationExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(instantiationExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(instantiationExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @since 3.0
	 */
	public boolean validateListLiteralExp(ListLiteralExp listLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(listLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(listLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(listLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(listLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(listLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(listLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(listLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(listLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(listLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(listLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(listLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(listLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateListType(ListType listType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(listType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(listType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(listType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(listType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(listType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(listType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(listType, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateCollectionType_WellFormedName(listType, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateCollectionType_WellFormedInstanceTypeName(listType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_UniqueTypeParameterNames(listType, diagnostics, context);
		if (result || diagnostics != null) result &= typesValidator.validateCollectionType_checkCollectionTypeName(listType, diagnostics, context);
		if (result || diagnostics != null) result &= typesValidator.validateCollectionType_checkNoInvalidValues(listType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogExp(LogExp logExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(logExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(logExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(logExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(logExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(logExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(logExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(logExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(logExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(logExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(logExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(logExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(logExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateOperationCallExp_checkArgumentsConform(logExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateOperationCallExp_checkArgumentCount(logExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderedTupleLiteralExp(OrderedTupleLiteralExp orderedTupleLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(orderedTupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(orderedTupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(orderedTupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(orderedTupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(orderedTupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(orderedTupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(orderedTupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(orderedTupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(orderedTupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(orderedTupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(orderedTupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(orderedTupleLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderedTupleLiteralPart(OrderedTupleLiteralPart orderedTupleLiteralPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(orderedTupleLiteralPart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderedTupleType(OrderedTupleType orderedTupleType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validateOrderedTupleType_WellFormedName(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_WellFormedInstanceTypeName(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_UniqueTypeParameterNames(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_InterfaceIsAbstract(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_AtMostOneID(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueFeatureNames(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueOperationSignatures(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_NoCircularSuperTypes(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_WellFormedMapEntryClass(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_ConsistentSuperTypes(orderedTupleType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_DisjointFeatureAndOperationSignatures(orderedTupleType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the WellFormedName constraint of '<em>Ordered Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateOrderedTupleType_WellFormedName(OrderedTupleType orderedTupleType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // The Ecore constraint is not applicable to OrderedTupleType
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRaiseExp(RaiseExp raiseExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(raiseExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(raiseExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(raiseExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(raiseExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(raiseExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(raiseExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(raiseExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(raiseExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(raiseExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(raiseExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(raiseExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(raiseExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReturnExp(ReturnExp returnExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(returnExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(returnExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(returnExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(returnExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(returnExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(returnExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(returnExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(returnExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(returnExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(returnExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(returnExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(returnExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchExp(SwitchExp switchExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(switchExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(switchExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(switchExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(switchExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(switchExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(switchExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(switchExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(switchExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(switchExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(switchExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(switchExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(switchExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTryExp(TryExp tryExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(tryExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(tryExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(tryExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(tryExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(tryExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(tryExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(tryExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(tryExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(tryExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(tryExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(tryExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(tryExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedef(Typedef typedef, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_WellFormedInstanceTypeName(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_UniqueTypeParameterNames(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_InterfaceIsAbstract(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_AtMostOneID(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueFeatureNames(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueOperationSignatures(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_NoCircularSuperTypes(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_WellFormedMapEntryClass(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_ConsistentSuperTypes(typedef, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_DisjointFeatureAndOperationSignatures(typedef, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnlinkExp(UnlinkExp unlinkExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(unlinkExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(unlinkExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(unlinkExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(unlinkExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(unlinkExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(unlinkExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(unlinkExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(unlinkExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(unlinkExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(unlinkExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(unlinkExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(unlinkExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnpackExp(UnpackExp unpackExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(unpackExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(unpackExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(unpackExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(unpackExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(unpackExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(unpackExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(unpackExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(unpackExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(unpackExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(unpackExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(unpackExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(unpackExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableInitExp(VariableInitExp variableInitExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(variableInitExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variableInitExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variableInitExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(variableInitExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(variableInitExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(variableInitExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variableInitExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(variableInitExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(variableInitExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(variableInitExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(variableInitExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(variableInitExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWhileExp(WhileExp whileExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(whileExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(whileExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(whileExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(whileExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(whileExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(whileExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(whileExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(whileExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(whileExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(whileExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(whileExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(whileExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSeverityKind(SeverityKind severityKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ImperativeOCLPlugin.INSTANCE;
	}

} //ImperativeOCLValidator
