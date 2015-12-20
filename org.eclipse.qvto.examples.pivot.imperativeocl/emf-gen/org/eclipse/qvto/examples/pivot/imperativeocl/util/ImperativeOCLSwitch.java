/**
 * <copyright>
 * Copyright (c) 2013 Willink Transformations, University of York, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo (University of York) - Bug397429
 * </copyright>
 */
package org.eclipse.qvto.examples.pivot.imperativeocl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.FeatureCallExp;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.ReferringElement;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvto.examples.pivot.imperativeocl.AltExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType;
import org.eclipse.qvto.examples.pivot.imperativeocl.ForExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage;
import org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ListType;
import org.eclipse.qvto.examples.pivot.imperativeocl.LogExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType;
import org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.TryExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.Typedef;
import org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage
 * @generated
 */
public class ImperativeOCLSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImperativeOCLPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOCLSwitch() {
		if (modelPackage == null) {
			modelPackage = ImperativeOCLPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ImperativeOCLPackage.ALT_EXP: {
				AltExp altExp = (AltExp)theEObject;
				T result = caseAltExp(altExp);
				if (result == null) result = caseImperativeExpression(altExp);
				if (result == null) result = caseOCLExpression(altExp);
				if (result == null) result = caseTypedElement(altExp);
				if (result == null) result = caseNamedElement(altExp);
				if (result == null) result = caseElement(altExp);
				if (result == null) result = caseNameable(altExp);
				if (result == null) result = caseVisitable(altExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.ASSERT_EXP: {
				AssertExp assertExp = (AssertExp)theEObject;
				T result = caseAssertExp(assertExp);
				if (result == null) result = caseImperativeExpression(assertExp);
				if (result == null) result = caseOCLExpression(assertExp);
				if (result == null) result = caseTypedElement(assertExp);
				if (result == null) result = caseNamedElement(assertExp);
				if (result == null) result = caseElement(assertExp);
				if (result == null) result = caseNameable(assertExp);
				if (result == null) result = caseVisitable(assertExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.ASSIGN_EXP: {
				AssignExp assignExp = (AssignExp)theEObject;
				T result = caseAssignExp(assignExp);
				if (result == null) result = caseImperativeExpression(assignExp);
				if (result == null) result = caseOCLExpression(assignExp);
				if (result == null) result = caseTypedElement(assignExp);
				if (result == null) result = caseNamedElement(assignExp);
				if (result == null) result = caseElement(assignExp);
				if (result == null) result = caseNameable(assignExp);
				if (result == null) result = caseVisitable(assignExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.BLOCK_EXP: {
				BlockExp blockExp = (BlockExp)theEObject;
				T result = caseBlockExp(blockExp);
				if (result == null) result = caseImperativeExpression(blockExp);
				if (result == null) result = caseOCLExpression(blockExp);
				if (result == null) result = caseTypedElement(blockExp);
				if (result == null) result = caseNamedElement(blockExp);
				if (result == null) result = caseElement(blockExp);
				if (result == null) result = caseNameable(blockExp);
				if (result == null) result = caseVisitable(blockExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.BREAK_EXP: {
				BreakExp breakExp = (BreakExp)theEObject;
				T result = caseBreakExp(breakExp);
				if (result == null) result = caseImperativeExpression(breakExp);
				if (result == null) result = caseOCLExpression(breakExp);
				if (result == null) result = caseTypedElement(breakExp);
				if (result == null) result = caseNamedElement(breakExp);
				if (result == null) result = caseElement(breakExp);
				if (result == null) result = caseNameable(breakExp);
				if (result == null) result = caseVisitable(breakExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.CATCH_EXP: {
				CatchExp catchExp = (CatchExp)theEObject;
				T result = caseCatchExp(catchExp);
				if (result == null) result = caseImperativeExpression(catchExp);
				if (result == null) result = caseOCLExpression(catchExp);
				if (result == null) result = caseTypedElement(catchExp);
				if (result == null) result = caseNamedElement(catchExp);
				if (result == null) result = caseElement(catchExp);
				if (result == null) result = caseNameable(catchExp);
				if (result == null) result = caseVisitable(catchExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.COMPUTE_EXP: {
				ComputeExp computeExp = (ComputeExp)theEObject;
				T result = caseComputeExp(computeExp);
				if (result == null) result = caseImperativeExpression(computeExp);
				if (result == null) result = caseOCLExpression(computeExp);
				if (result == null) result = caseTypedElement(computeExp);
				if (result == null) result = caseNamedElement(computeExp);
				if (result == null) result = caseElement(computeExp);
				if (result == null) result = caseNameable(computeExp);
				if (result == null) result = caseVisitable(computeExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.CONTINUE_EXP: {
				ContinueExp continueExp = (ContinueExp)theEObject;
				T result = caseContinueExp(continueExp);
				if (result == null) result = caseImperativeExpression(continueExp);
				if (result == null) result = caseOCLExpression(continueExp);
				if (result == null) result = caseTypedElement(continueExp);
				if (result == null) result = caseNamedElement(continueExp);
				if (result == null) result = caseElement(continueExp);
				if (result == null) result = caseNameable(continueExp);
				if (result == null) result = caseVisitable(continueExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.DICT_LITERAL_EXP: {
				DictLiteralExp dictLiteralExp = (DictLiteralExp)theEObject;
				T result = caseDictLiteralExp(dictLiteralExp);
				if (result == null) result = caseLiteralExp(dictLiteralExp);
				if (result == null) result = caseOCLExpression(dictLiteralExp);
				if (result == null) result = caseTypedElement(dictLiteralExp);
				if (result == null) result = caseNamedElement(dictLiteralExp);
				if (result == null) result = caseElement(dictLiteralExp);
				if (result == null) result = caseNameable(dictLiteralExp);
				if (result == null) result = caseVisitable(dictLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.DICT_LITERAL_PART: {
				DictLiteralPart dictLiteralPart = (DictLiteralPart)theEObject;
				T result = caseDictLiteralPart(dictLiteralPart);
				if (result == null) result = caseElement(dictLiteralPart);
				if (result == null) result = caseVisitable(dictLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.DICTIONARY_TYPE: {
				DictionaryType dictionaryType = (DictionaryType)theEObject;
				T result = caseDictionaryType(dictionaryType);
				if (result == null) result = caseCollectionType(dictionaryType);
				if (result == null) result = caseDataType(dictionaryType);
				if (result == null) result = caseClass(dictionaryType);
				if (result == null) result = caseType(dictionaryType);
				if (result == null) result = caseNamespace(dictionaryType);
				if (result == null) result = caseTemplateableElement(dictionaryType);
				if (result == null) result = caseNamedElement(dictionaryType);
				if (result == null) result = caseElement(dictionaryType);
				if (result == null) result = caseNameable(dictionaryType);
				if (result == null) result = caseVisitable(dictionaryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.FOR_EXP: {
				ForExp forExp = (ForExp)theEObject;
				T result = caseForExp(forExp);
				if (result == null) result = caseImperativeLoopExp(forExp);
				if (result == null) result = caseLoopExp(forExp);
				if (result == null) result = caseImperativeExpression(forExp);
				if (result == null) result = caseCallExp(forExp);
				if (result == null) result = caseOCLExpression(forExp);
				if (result == null) result = caseTypedElement(forExp);
				if (result == null) result = caseNamedElement(forExp);
				if (result == null) result = caseElement(forExp);
				if (result == null) result = caseNameable(forExp);
				if (result == null) result = caseVisitable(forExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.IMPERATIVE_EXPRESSION: {
				ImperativeExpression imperativeExpression = (ImperativeExpression)theEObject;
				T result = caseImperativeExpression(imperativeExpression);
				if (result == null) result = caseOCLExpression(imperativeExpression);
				if (result == null) result = caseTypedElement(imperativeExpression);
				if (result == null) result = caseNamedElement(imperativeExpression);
				if (result == null) result = caseElement(imperativeExpression);
				if (result == null) result = caseNameable(imperativeExpression);
				if (result == null) result = caseVisitable(imperativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.IMPERATIVE_ITERATE_EXP: {
				ImperativeIterateExp imperativeIterateExp = (ImperativeIterateExp)theEObject;
				T result = caseImperativeIterateExp(imperativeIterateExp);
				if (result == null) result = caseImperativeLoopExp(imperativeIterateExp);
				if (result == null) result = caseLoopExp(imperativeIterateExp);
				if (result == null) result = caseImperativeExpression(imperativeIterateExp);
				if (result == null) result = caseCallExp(imperativeIterateExp);
				if (result == null) result = caseOCLExpression(imperativeIterateExp);
				if (result == null) result = caseTypedElement(imperativeIterateExp);
				if (result == null) result = caseNamedElement(imperativeIterateExp);
				if (result == null) result = caseElement(imperativeIterateExp);
				if (result == null) result = caseNameable(imperativeIterateExp);
				if (result == null) result = caseVisitable(imperativeIterateExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP: {
				ImperativeLoopExp imperativeLoopExp = (ImperativeLoopExp)theEObject;
				T result = caseImperativeLoopExp(imperativeLoopExp);
				if (result == null) result = caseLoopExp(imperativeLoopExp);
				if (result == null) result = caseImperativeExpression(imperativeLoopExp);
				if (result == null) result = caseCallExp(imperativeLoopExp);
				if (result == null) result = caseOCLExpression(imperativeLoopExp);
				if (result == null) result = caseTypedElement(imperativeLoopExp);
				if (result == null) result = caseNamedElement(imperativeLoopExp);
				if (result == null) result = caseElement(imperativeLoopExp);
				if (result == null) result = caseNameable(imperativeLoopExp);
				if (result == null) result = caseVisitable(imperativeLoopExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.INSTANTIATION_EXP: {
				InstantiationExp instantiationExp = (InstantiationExp)theEObject;
				T result = caseInstantiationExp(instantiationExp);
				if (result == null) result = caseImperativeExpression(instantiationExp);
				if (result == null) result = caseOCLExpression(instantiationExp);
				if (result == null) result = caseTypedElement(instantiationExp);
				if (result == null) result = caseNamedElement(instantiationExp);
				if (result == null) result = caseElement(instantiationExp);
				if (result == null) result = caseNameable(instantiationExp);
				if (result == null) result = caseVisitable(instantiationExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.LIST_LITERAL_EXP: {
				ListLiteralExp listLiteralExp = (ListLiteralExp)theEObject;
				T result = caseListLiteralExp(listLiteralExp);
				if (result == null) result = caseLiteralExp(listLiteralExp);
				if (result == null) result = caseOCLExpression(listLiteralExp);
				if (result == null) result = caseTypedElement(listLiteralExp);
				if (result == null) result = caseNamedElement(listLiteralExp);
				if (result == null) result = caseElement(listLiteralExp);
				if (result == null) result = caseNameable(listLiteralExp);
				if (result == null) result = caseVisitable(listLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.LIST_TYPE: {
				ListType listType = (ListType)theEObject;
				T result = caseListType(listType);
				if (result == null) result = caseCollectionType(listType);
				if (result == null) result = caseDataType(listType);
				if (result == null) result = caseClass(listType);
				if (result == null) result = caseType(listType);
				if (result == null) result = caseNamespace(listType);
				if (result == null) result = caseTemplateableElement(listType);
				if (result == null) result = caseNamedElement(listType);
				if (result == null) result = caseElement(listType);
				if (result == null) result = caseNameable(listType);
				if (result == null) result = caseVisitable(listType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.LOG_EXP: {
				LogExp logExp = (LogExp)theEObject;
				T result = caseLogExp(logExp);
				if (result == null) result = caseOperationCallExp(logExp);
				if (result == null) result = caseImperativeExpression(logExp);
				if (result == null) result = caseFeatureCallExp(logExp);
				if (result == null) result = caseReferringElement(logExp);
				if (result == null) result = caseCallExp(logExp);
				if (result == null) result = caseOCLExpression(logExp);
				if (result == null) result = caseTypedElement(logExp);
				if (result == null) result = caseNamedElement(logExp);
				if (result == null) result = caseElement(logExp);
				if (result == null) result = caseNameable(logExp);
				if (result == null) result = caseVisitable(logExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.ORDERED_TUPLE_LITERAL_EXP: {
				OrderedTupleLiteralExp orderedTupleLiteralExp = (OrderedTupleLiteralExp)theEObject;
				T result = caseOrderedTupleLiteralExp(orderedTupleLiteralExp);
				if (result == null) result = caseLiteralExp(orderedTupleLiteralExp);
				if (result == null) result = caseOCLExpression(orderedTupleLiteralExp);
				if (result == null) result = caseTypedElement(orderedTupleLiteralExp);
				if (result == null) result = caseNamedElement(orderedTupleLiteralExp);
				if (result == null) result = caseElement(orderedTupleLiteralExp);
				if (result == null) result = caseNameable(orderedTupleLiteralExp);
				if (result == null) result = caseVisitable(orderedTupleLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.ORDERED_TUPLE_LITERAL_PART: {
				OrderedTupleLiteralPart orderedTupleLiteralPart = (OrderedTupleLiteralPart)theEObject;
				T result = caseOrderedTupleLiteralPart(orderedTupleLiteralPart);
				if (result == null) result = caseElement(orderedTupleLiteralPart);
				if (result == null) result = caseVisitable(orderedTupleLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.ORDERED_TUPLE_TYPE: {
				OrderedTupleType orderedTupleType = (OrderedTupleType)theEObject;
				T result = caseOrderedTupleType(orderedTupleType);
				if (result == null) result = caseClass(orderedTupleType);
				if (result == null) result = caseType(orderedTupleType);
				if (result == null) result = caseNamespace(orderedTupleType);
				if (result == null) result = caseTemplateableElement(orderedTupleType);
				if (result == null) result = caseNamedElement(orderedTupleType);
				if (result == null) result = caseElement(orderedTupleType);
				if (result == null) result = caseNameable(orderedTupleType);
				if (result == null) result = caseVisitable(orderedTupleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.RAISE_EXP: {
				RaiseExp raiseExp = (RaiseExp)theEObject;
				T result = caseRaiseExp(raiseExp);
				if (result == null) result = caseImperativeExpression(raiseExp);
				if (result == null) result = caseOCLExpression(raiseExp);
				if (result == null) result = caseTypedElement(raiseExp);
				if (result == null) result = caseNamedElement(raiseExp);
				if (result == null) result = caseElement(raiseExp);
				if (result == null) result = caseNameable(raiseExp);
				if (result == null) result = caseVisitable(raiseExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.RETURN_EXP: {
				ReturnExp returnExp = (ReturnExp)theEObject;
				T result = caseReturnExp(returnExp);
				if (result == null) result = caseImperativeExpression(returnExp);
				if (result == null) result = caseOCLExpression(returnExp);
				if (result == null) result = caseTypedElement(returnExp);
				if (result == null) result = caseNamedElement(returnExp);
				if (result == null) result = caseElement(returnExp);
				if (result == null) result = caseNameable(returnExp);
				if (result == null) result = caseVisitable(returnExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.SWITCH_EXP: {
				SwitchExp switchExp = (SwitchExp)theEObject;
				T result = caseSwitchExp(switchExp);
				if (result == null) result = caseImperativeExpression(switchExp);
				if (result == null) result = caseOCLExpression(switchExp);
				if (result == null) result = caseTypedElement(switchExp);
				if (result == null) result = caseNamedElement(switchExp);
				if (result == null) result = caseElement(switchExp);
				if (result == null) result = caseNameable(switchExp);
				if (result == null) result = caseVisitable(switchExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.TRY_EXP: {
				TryExp tryExp = (TryExp)theEObject;
				T result = caseTryExp(tryExp);
				if (result == null) result = caseImperativeExpression(tryExp);
				if (result == null) result = caseOCLExpression(tryExp);
				if (result == null) result = caseTypedElement(tryExp);
				if (result == null) result = caseNamedElement(tryExp);
				if (result == null) result = caseElement(tryExp);
				if (result == null) result = caseNameable(tryExp);
				if (result == null) result = caseVisitable(tryExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.TYPEDEF: {
				Typedef typedef = (Typedef)theEObject;
				T result = caseTypedef(typedef);
				if (result == null) result = caseClass(typedef);
				if (result == null) result = caseType(typedef);
				if (result == null) result = caseNamespace(typedef);
				if (result == null) result = caseTemplateableElement(typedef);
				if (result == null) result = caseNamedElement(typedef);
				if (result == null) result = caseElement(typedef);
				if (result == null) result = caseNameable(typedef);
				if (result == null) result = caseVisitable(typedef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.UNLINK_EXP: {
				UnlinkExp unlinkExp = (UnlinkExp)theEObject;
				T result = caseUnlinkExp(unlinkExp);
				if (result == null) result = caseImperativeExpression(unlinkExp);
				if (result == null) result = caseOCLExpression(unlinkExp);
				if (result == null) result = caseTypedElement(unlinkExp);
				if (result == null) result = caseNamedElement(unlinkExp);
				if (result == null) result = caseElement(unlinkExp);
				if (result == null) result = caseNameable(unlinkExp);
				if (result == null) result = caseVisitable(unlinkExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.UNPACK_EXP: {
				UnpackExp unpackExp = (UnpackExp)theEObject;
				T result = caseUnpackExp(unpackExp);
				if (result == null) result = caseImperativeExpression(unpackExp);
				if (result == null) result = caseOCLExpression(unpackExp);
				if (result == null) result = caseTypedElement(unpackExp);
				if (result == null) result = caseNamedElement(unpackExp);
				if (result == null) result = caseElement(unpackExp);
				if (result == null) result = caseNameable(unpackExp);
				if (result == null) result = caseVisitable(unpackExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.VARIABLE_INIT_EXP: {
				VariableInitExp variableInitExp = (VariableInitExp)theEObject;
				T result = caseVariableInitExp(variableInitExp);
				if (result == null) result = caseImperativeExpression(variableInitExp);
				if (result == null) result = caseOCLExpression(variableInitExp);
				if (result == null) result = caseTypedElement(variableInitExp);
				if (result == null) result = caseNamedElement(variableInitExp);
				if (result == null) result = caseElement(variableInitExp);
				if (result == null) result = caseNameable(variableInitExp);
				if (result == null) result = caseVisitable(variableInitExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.WHILE_EXP: {
				WhileExp whileExp = (WhileExp)theEObject;
				T result = caseWhileExp(whileExp);
				if (result == null) result = caseImperativeExpression(whileExp);
				if (result == null) result = caseOCLExpression(whileExp);
				if (result == null) result = caseTypedElement(whileExp);
				if (result == null) result = caseNamedElement(whileExp);
				if (result == null) result = caseElement(whileExp);
				if (result == null) result = caseNameable(whileExp);
				if (result == null) result = caseVisitable(whileExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alt Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alt Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAltExp(AltExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assert Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assert Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertExp(AssertExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assign Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assign Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignExp(AssignExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockExp(BlockExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Break Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Break Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBreakExp(BreakExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Catch Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Catch Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCatchExp(CatchExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compute Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compute Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputeExp(ComputeExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Continue Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Continue Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContinueExp(ContinueExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dict Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dict Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDictLiteralExp(DictLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dict Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dict Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDictLiteralPart(DictLiteralPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dictionary Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dictionary Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDictionaryType(DictionaryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForExp(ForExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeExpression(ImperativeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Iterate Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeIterateExp(ImperativeIterateExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Loop Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeLoopExp(ImperativeLoopExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instantiation Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instantiation Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstantiationExp(InstantiationExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListLiteralExp(ListLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListType(ListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Log Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Log Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogExp(LogExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Tuple Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Tuple Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedTupleLiteralExp(OrderedTupleLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Tuple Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Tuple Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedTupleLiteralPart(OrderedTupleLiteralPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Tuple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedTupleType(OrderedTupleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raise Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raise Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRaiseExp(RaiseExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnExp(ReturnExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchExp(SwitchExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Try Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Try Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTryExp(TryExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typedef</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typedef</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedef(Typedef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unlink Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unlink Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnlinkExp(UnlinkExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unpack Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unpack Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnpackExp(UnpackExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Init Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Init Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableInitExp(VariableInitExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileExp(WhileExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitable(Visitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLExpression(OCLExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralExp(LiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Templateable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Templateable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateableElement(TemplateableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClass(org.eclipse.ocl.pivot.Class object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionType(CollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallExp(CallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopExp(LoopExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureCallExp(FeatureCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Referring Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referring Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferringElement(ReferringElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCallExp(OperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ImperativeOCLSwitch
