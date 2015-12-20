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
 * $Id: ImperativeOCLSwitch.java,v 1.4 2009/12/09 12:45:12 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
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
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.SwitchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.TryExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.Typedef;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnlinkExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnpackExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.VariableInitExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.WhileExp;
import org.eclipse.ocl.expressions.CallExp;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.LiteralExp;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.Visitable;


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
 * @see org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage
 * @generated
 */
public class ImperativeOCLSwitch<T> {
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
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ImperativeOCLPackage.ALT_EXP: {
				AltExp altExp = (AltExp)theEObject;
				T result = caseAltExp(altExp);
				if (result == null) result = caseImperativeExpression(altExp);
				if (result == null) result = caseEcore_OCLExpression(altExp);
				if (result == null) result = caseETypedElement(altExp);
				if (result == null) result = caseOCLExpression(altExp);
				if (result == null) result = caseENamedElement(altExp);
				if (result == null) result = caseTypedElement(altExp);
				if (result == null) result = caseVisitable(altExp);
				if (result == null) result = caseASTNode(altExp);
				if (result == null) result = caseEModelElement(altExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.ASSERT_EXP: {
				AssertExp assertExp = (AssertExp)theEObject;
				T result = caseAssertExp(assertExp);
				if (result == null) result = caseImperativeExpression(assertExp);
				if (result == null) result = caseEcore_OCLExpression(assertExp);
				if (result == null) result = caseETypedElement(assertExp);
				if (result == null) result = caseOCLExpression(assertExp);
				if (result == null) result = caseENamedElement(assertExp);
				if (result == null) result = caseTypedElement(assertExp);
				if (result == null) result = caseVisitable(assertExp);
				if (result == null) result = caseASTNode(assertExp);
				if (result == null) result = caseEModelElement(assertExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.ASSIGN_EXP: {
				AssignExp assignExp = (AssignExp)theEObject;
				T result = caseAssignExp(assignExp);
				if (result == null) result = caseImperativeExpression(assignExp);
				if (result == null) result = caseEcore_OCLExpression(assignExp);
				if (result == null) result = caseETypedElement(assignExp);
				if (result == null) result = caseOCLExpression(assignExp);
				if (result == null) result = caseENamedElement(assignExp);
				if (result == null) result = caseTypedElement(assignExp);
				if (result == null) result = caseVisitable(assignExp);
				if (result == null) result = caseASTNode(assignExp);
				if (result == null) result = caseEModelElement(assignExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.BLOCK_EXP: {
				BlockExp blockExp = (BlockExp)theEObject;
				T result = caseBlockExp(blockExp);
				if (result == null) result = caseImperativeExpression(blockExp);
				if (result == null) result = caseEcore_OCLExpression(blockExp);
				if (result == null) result = caseETypedElement(blockExp);
				if (result == null) result = caseOCLExpression(blockExp);
				if (result == null) result = caseENamedElement(blockExp);
				if (result == null) result = caseTypedElement(blockExp);
				if (result == null) result = caseVisitable(blockExp);
				if (result == null) result = caseASTNode(blockExp);
				if (result == null) result = caseEModelElement(blockExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.BREAK_EXP: {
				BreakExp breakExp = (BreakExp)theEObject;
				T result = caseBreakExp(breakExp);
				if (result == null) result = caseImperativeExpression(breakExp);
				if (result == null) result = caseEcore_OCLExpression(breakExp);
				if (result == null) result = caseETypedElement(breakExp);
				if (result == null) result = caseOCLExpression(breakExp);
				if (result == null) result = caseENamedElement(breakExp);
				if (result == null) result = caseTypedElement(breakExp);
				if (result == null) result = caseVisitable(breakExp);
				if (result == null) result = caseASTNode(breakExp);
				if (result == null) result = caseEModelElement(breakExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.CATCH_EXP: {
				CatchExp catchExp = (CatchExp)theEObject;
				T result = caseCatchExp(catchExp);
				if (result == null) result = caseImperativeExpression(catchExp);
				if (result == null) result = caseEcore_OCLExpression(catchExp);
				if (result == null) result = caseETypedElement(catchExp);
				if (result == null) result = caseOCLExpression(catchExp);
				if (result == null) result = caseENamedElement(catchExp);
				if (result == null) result = caseTypedElement(catchExp);
				if (result == null) result = caseVisitable(catchExp);
				if (result == null) result = caseASTNode(catchExp);
				if (result == null) result = caseEModelElement(catchExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.COMPUTE_EXP: {
				ComputeExp computeExp = (ComputeExp)theEObject;
				T result = caseComputeExp(computeExp);
				if (result == null) result = caseImperativeExpression(computeExp);
				if (result == null) result = caseEcore_OCLExpression(computeExp);
				if (result == null) result = caseETypedElement(computeExp);
				if (result == null) result = caseOCLExpression(computeExp);
				if (result == null) result = caseENamedElement(computeExp);
				if (result == null) result = caseTypedElement(computeExp);
				if (result == null) result = caseVisitable(computeExp);
				if (result == null) result = caseASTNode(computeExp);
				if (result == null) result = caseEModelElement(computeExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.CONTINUE_EXP: {
				ContinueExp continueExp = (ContinueExp)theEObject;
				T result = caseContinueExp(continueExp);
				if (result == null) result = caseImperativeExpression(continueExp);
				if (result == null) result = caseEcore_OCLExpression(continueExp);
				if (result == null) result = caseETypedElement(continueExp);
				if (result == null) result = caseOCLExpression(continueExp);
				if (result == null) result = caseENamedElement(continueExp);
				if (result == null) result = caseTypedElement(continueExp);
				if (result == null) result = caseVisitable(continueExp);
				if (result == null) result = caseASTNode(continueExp);
				if (result == null) result = caseEModelElement(continueExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.DICT_LITERAL_EXP: {
				DictLiteralExp dictLiteralExp = (DictLiteralExp)theEObject;
				T result = caseDictLiteralExp(dictLiteralExp);
				if (result == null) result = caseEcore_LiteralExp(dictLiteralExp);
				if (result == null) result = caseEcore_OCLExpression(dictLiteralExp);
				if (result == null) result = caseLiteralExp(dictLiteralExp);
				if (result == null) result = caseETypedElement(dictLiteralExp);
				if (result == null) result = caseOCLExpression(dictLiteralExp);
				if (result == null) result = caseENamedElement(dictLiteralExp);
				if (result == null) result = caseTypedElement(dictLiteralExp);
				if (result == null) result = caseVisitable(dictLiteralExp);
				if (result == null) result = caseASTNode(dictLiteralExp);
				if (result == null) result = caseEModelElement(dictLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.DICT_LITERAL_PART: {
				DictLiteralPart dictLiteralPart = (DictLiteralPart)theEObject;
				T result = caseDictLiteralPart(dictLiteralPart);
				if (result == null) result = caseEModelElement(dictLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.DICTIONARY_TYPE: {
				DictionaryType dictionaryType = (DictionaryType)theEObject;
				T result = caseDictionaryType(dictionaryType);
				if (result == null) result = caseEcore_CollectionType(dictionaryType);
				if (result == null) result = caseEDataType(dictionaryType);
				if (result == null) result = caseCollectionType(dictionaryType);
				if (result == null) result = caseEClassifier(dictionaryType);
				if (result == null) result = casePredefinedType(dictionaryType);
				if (result == null) result = caseTypedASTNode(dictionaryType);
				if (result == null) result = caseENamedElement(dictionaryType);
				if (result == null) result = caseASTNode(dictionaryType);
				if (result == null) result = caseEModelElement(dictionaryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.FOR_EXP: {
				ForExp forExp = (ForExp)theEObject;
				T result = caseForExp(forExp);
				if (result == null) result = caseImperativeLoopExp(forExp);
				if (result == null) result = caseEcore_LoopExp(forExp);
				if (result == null) result = caseImperativeExpression(forExp);
				if (result == null) result = caseEcore_CallExp(forExp);
				if (result == null) result = caseLoopExp(forExp);
				if (result == null) result = caseEcore_OCLExpression(forExp);
				if (result == null) result = caseCallExp(forExp);
				if (result == null) result = caseETypedElement(forExp);
				if (result == null) result = caseOCLExpression(forExp);
				if (result == null) result = caseCallingASTNode(forExp);
				if (result == null) result = caseENamedElement(forExp);
				if (result == null) result = caseTypedElement(forExp);
				if (result == null) result = caseVisitable(forExp);
				if (result == null) result = caseASTNode(forExp);
				if (result == null) result = caseEModelElement(forExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.IMPERATIVE_EXPRESSION: {
				ImperativeExpression imperativeExpression = (ImperativeExpression)theEObject;
				T result = caseImperativeExpression(imperativeExpression);
				if (result == null) result = caseEcore_OCLExpression(imperativeExpression);
				if (result == null) result = caseETypedElement(imperativeExpression);
				if (result == null) result = caseOCLExpression(imperativeExpression);
				if (result == null) result = caseENamedElement(imperativeExpression);
				if (result == null) result = caseTypedElement(imperativeExpression);
				if (result == null) result = caseVisitable(imperativeExpression);
				if (result == null) result = caseASTNode(imperativeExpression);
				if (result == null) result = caseEModelElement(imperativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.IMPERATIVE_ITERATE_EXP: {
				ImperativeIterateExp imperativeIterateExp = (ImperativeIterateExp)theEObject;
				T result = caseImperativeIterateExp(imperativeIterateExp);
				if (result == null) result = caseImperativeLoopExp(imperativeIterateExp);
				if (result == null) result = caseEcore_LoopExp(imperativeIterateExp);
				if (result == null) result = caseImperativeExpression(imperativeIterateExp);
				if (result == null) result = caseEcore_CallExp(imperativeIterateExp);
				if (result == null) result = caseLoopExp(imperativeIterateExp);
				if (result == null) result = caseEcore_OCLExpression(imperativeIterateExp);
				if (result == null) result = caseCallExp(imperativeIterateExp);
				if (result == null) result = caseETypedElement(imperativeIterateExp);
				if (result == null) result = caseOCLExpression(imperativeIterateExp);
				if (result == null) result = caseCallingASTNode(imperativeIterateExp);
				if (result == null) result = caseENamedElement(imperativeIterateExp);
				if (result == null) result = caseTypedElement(imperativeIterateExp);
				if (result == null) result = caseVisitable(imperativeIterateExp);
				if (result == null) result = caseASTNode(imperativeIterateExp);
				if (result == null) result = caseEModelElement(imperativeIterateExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP: {
				ImperativeLoopExp imperativeLoopExp = (ImperativeLoopExp)theEObject;
				T result = caseImperativeLoopExp(imperativeLoopExp);
				if (result == null) result = caseEcore_LoopExp(imperativeLoopExp);
				if (result == null) result = caseImperativeExpression(imperativeLoopExp);
				if (result == null) result = caseEcore_CallExp(imperativeLoopExp);
				if (result == null) result = caseLoopExp(imperativeLoopExp);
				if (result == null) result = caseEcore_OCLExpression(imperativeLoopExp);
				if (result == null) result = caseCallExp(imperativeLoopExp);
				if (result == null) result = caseETypedElement(imperativeLoopExp);
				if (result == null) result = caseOCLExpression(imperativeLoopExp);
				if (result == null) result = caseCallingASTNode(imperativeLoopExp);
				if (result == null) result = caseENamedElement(imperativeLoopExp);
				if (result == null) result = caseTypedElement(imperativeLoopExp);
				if (result == null) result = caseVisitable(imperativeLoopExp);
				if (result == null) result = caseASTNode(imperativeLoopExp);
				if (result == null) result = caseEModelElement(imperativeLoopExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.INSTANTIATION_EXP: {
				InstantiationExp instantiationExp = (InstantiationExp)theEObject;
				T result = caseInstantiationExp(instantiationExp);
				if (result == null) result = caseImperativeExpression(instantiationExp);
				if (result == null) result = caseEcore_OCLExpression(instantiationExp);
				if (result == null) result = caseETypedElement(instantiationExp);
				if (result == null) result = caseOCLExpression(instantiationExp);
				if (result == null) result = caseENamedElement(instantiationExp);
				if (result == null) result = caseTypedElement(instantiationExp);
				if (result == null) result = caseVisitable(instantiationExp);
				if (result == null) result = caseASTNode(instantiationExp);
				if (result == null) result = caseEModelElement(instantiationExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.LIST_LITERAL_EXP: {
				ListLiteralExp listLiteralExp = (ListLiteralExp)theEObject;
				T result = caseListLiteralExp(listLiteralExp);
				if (result == null) result = caseEcore_LiteralExp(listLiteralExp);
				if (result == null) result = caseEcore_OCLExpression(listLiteralExp);
				if (result == null) result = caseLiteralExp(listLiteralExp);
				if (result == null) result = caseETypedElement(listLiteralExp);
				if (result == null) result = caseOCLExpression(listLiteralExp);
				if (result == null) result = caseENamedElement(listLiteralExp);
				if (result == null) result = caseTypedElement(listLiteralExp);
				if (result == null) result = caseVisitable(listLiteralExp);
				if (result == null) result = caseASTNode(listLiteralExp);
				if (result == null) result = caseEModelElement(listLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.LIST_TYPE: {
				ListType listType = (ListType)theEObject;
				T result = caseListType(listType);
				if (result == null) result = caseEcore_CollectionType(listType);
				if (result == null) result = caseEDataType(listType);
				if (result == null) result = caseCollectionType(listType);
				if (result == null) result = caseEClassifier(listType);
				if (result == null) result = casePredefinedType(listType);
				if (result == null) result = caseTypedASTNode(listType);
				if (result == null) result = caseENamedElement(listType);
				if (result == null) result = caseASTNode(listType);
				if (result == null) result = caseEModelElement(listType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.LOG_EXP: {
				LogExp logExp = (LogExp)theEObject;
				T result = caseLogExp(logExp);
				if (result == null) result = caseEcore_OperationCallExp(logExp);
				if (result == null) result = caseImperativeExpression(logExp);
				if (result == null) result = caseEcore_FeatureCallExp(logExp);
				if (result == null) result = caseOperationCallExp(logExp);
				if (result == null) result = caseEcore_CallExp(logExp);
				if (result == null) result = caseFeatureCallExp(logExp);
				if (result == null) result = caseEcore_OCLExpression(logExp);
				if (result == null) result = caseCallExp(logExp);
				if (result == null) result = caseETypedElement(logExp);
				if (result == null) result = caseOCLExpression(logExp);
				if (result == null) result = caseCallingASTNode(logExp);
				if (result == null) result = caseENamedElement(logExp);
				if (result == null) result = caseTypedElement(logExp);
				if (result == null) result = caseVisitable(logExp);
				if (result == null) result = caseASTNode(logExp);
				if (result == null) result = caseEModelElement(logExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.ORDERED_TUPLE_LITERAL_EXP: {
				OrderedTupleLiteralExp orderedTupleLiteralExp = (OrderedTupleLiteralExp)theEObject;
				T result = caseOrderedTupleLiteralExp(orderedTupleLiteralExp);
				if (result == null) result = caseEcore_LiteralExp(orderedTupleLiteralExp);
				if (result == null) result = caseEcore_OCLExpression(orderedTupleLiteralExp);
				if (result == null) result = caseLiteralExp(orderedTupleLiteralExp);
				if (result == null) result = caseETypedElement(orderedTupleLiteralExp);
				if (result == null) result = caseOCLExpression(orderedTupleLiteralExp);
				if (result == null) result = caseENamedElement(orderedTupleLiteralExp);
				if (result == null) result = caseTypedElement(orderedTupleLiteralExp);
				if (result == null) result = caseVisitable(orderedTupleLiteralExp);
				if (result == null) result = caseASTNode(orderedTupleLiteralExp);
				if (result == null) result = caseEModelElement(orderedTupleLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.ORDERED_TUPLE_LITERAL_PART: {
				OrderedTupleLiteralPart orderedTupleLiteralPart = (OrderedTupleLiteralPart)theEObject;
				T result = caseOrderedTupleLiteralPart(orderedTupleLiteralPart);
				if (result == null) result = caseEModelElement(orderedTupleLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.ORDERED_TUPLE_TYPE: {
				OrderedTupleType orderedTupleType = (OrderedTupleType)theEObject;
				T result = caseOrderedTupleType(orderedTupleType);
				if (result == null) result = caseEClass(orderedTupleType);
				if (result == null) result = caseEClassifier(orderedTupleType);
				if (result == null) result = caseENamedElement(orderedTupleType);
				if (result == null) result = caseEModelElement(orderedTupleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.RAISE_EXP: {
				RaiseExp raiseExp = (RaiseExp)theEObject;
				T result = caseRaiseExp(raiseExp);
				if (result == null) result = caseImperativeExpression(raiseExp);
				if (result == null) result = caseEcore_OCLExpression(raiseExp);
				if (result == null) result = caseETypedElement(raiseExp);
				if (result == null) result = caseOCLExpression(raiseExp);
				if (result == null) result = caseENamedElement(raiseExp);
				if (result == null) result = caseTypedElement(raiseExp);
				if (result == null) result = caseVisitable(raiseExp);
				if (result == null) result = caseASTNode(raiseExp);
				if (result == null) result = caseEModelElement(raiseExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.RETURN_EXP: {
				ReturnExp returnExp = (ReturnExp)theEObject;
				T result = caseReturnExp(returnExp);
				if (result == null) result = caseImperativeExpression(returnExp);
				if (result == null) result = caseEcore_OCLExpression(returnExp);
				if (result == null) result = caseETypedElement(returnExp);
				if (result == null) result = caseOCLExpression(returnExp);
				if (result == null) result = caseENamedElement(returnExp);
				if (result == null) result = caseTypedElement(returnExp);
				if (result == null) result = caseVisitable(returnExp);
				if (result == null) result = caseASTNode(returnExp);
				if (result == null) result = caseEModelElement(returnExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.SWITCH_EXP: {
				SwitchExp switchExp = (SwitchExp)theEObject;
				T result = caseSwitchExp(switchExp);
				if (result == null) result = caseImperativeExpression(switchExp);
				if (result == null) result = caseEcore_OCLExpression(switchExp);
				if (result == null) result = caseETypedElement(switchExp);
				if (result == null) result = caseOCLExpression(switchExp);
				if (result == null) result = caseENamedElement(switchExp);
				if (result == null) result = caseTypedElement(switchExp);
				if (result == null) result = caseVisitable(switchExp);
				if (result == null) result = caseASTNode(switchExp);
				if (result == null) result = caseEModelElement(switchExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.TRY_EXP: {
				TryExp tryExp = (TryExp)theEObject;
				T result = caseTryExp(tryExp);
				if (result == null) result = caseImperativeExpression(tryExp);
				if (result == null) result = caseEcore_OCLExpression(tryExp);
				if (result == null) result = caseETypedElement(tryExp);
				if (result == null) result = caseOCLExpression(tryExp);
				if (result == null) result = caseENamedElement(tryExp);
				if (result == null) result = caseTypedElement(tryExp);
				if (result == null) result = caseVisitable(tryExp);
				if (result == null) result = caseASTNode(tryExp);
				if (result == null) result = caseEModelElement(tryExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.TYPEDEF: {
				Typedef typedef = (Typedef)theEObject;
				T result = caseTypedef(typedef);
				if (result == null) result = caseEClass(typedef);
				if (result == null) result = caseEClassifier(typedef);
				if (result == null) result = caseENamedElement(typedef);
				if (result == null) result = caseEModelElement(typedef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.UNLINK_EXP: {
				UnlinkExp unlinkExp = (UnlinkExp)theEObject;
				T result = caseUnlinkExp(unlinkExp);
				if (result == null) result = caseImperativeExpression(unlinkExp);
				if (result == null) result = caseEcore_OCLExpression(unlinkExp);
				if (result == null) result = caseETypedElement(unlinkExp);
				if (result == null) result = caseOCLExpression(unlinkExp);
				if (result == null) result = caseENamedElement(unlinkExp);
				if (result == null) result = caseTypedElement(unlinkExp);
				if (result == null) result = caseVisitable(unlinkExp);
				if (result == null) result = caseASTNode(unlinkExp);
				if (result == null) result = caseEModelElement(unlinkExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.UNPACK_EXP: {
				UnpackExp unpackExp = (UnpackExp)theEObject;
				T result = caseUnpackExp(unpackExp);
				if (result == null) result = caseImperativeExpression(unpackExp);
				if (result == null) result = caseEcore_OCLExpression(unpackExp);
				if (result == null) result = caseETypedElement(unpackExp);
				if (result == null) result = caseOCLExpression(unpackExp);
				if (result == null) result = caseENamedElement(unpackExp);
				if (result == null) result = caseTypedElement(unpackExp);
				if (result == null) result = caseVisitable(unpackExp);
				if (result == null) result = caseASTNode(unpackExp);
				if (result == null) result = caseEModelElement(unpackExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.VARIABLE_INIT_EXP: {
				VariableInitExp variableInitExp = (VariableInitExp)theEObject;
				T result = caseVariableInitExp(variableInitExp);
				if (result == null) result = caseImperativeExpression(variableInitExp);
				if (result == null) result = caseEcore_OCLExpression(variableInitExp);
				if (result == null) result = caseETypedElement(variableInitExp);
				if (result == null) result = caseOCLExpression(variableInitExp);
				if (result == null) result = caseENamedElement(variableInitExp);
				if (result == null) result = caseTypedElement(variableInitExp);
				if (result == null) result = caseVisitable(variableInitExp);
				if (result == null) result = caseASTNode(variableInitExp);
				if (result == null) result = caseEModelElement(variableInitExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeOCLPackage.WHILE_EXP: {
				WhileExp whileExp = (WhileExp)theEObject;
				T result = caseWhileExp(whileExp);
				if (result == null) result = caseImperativeExpression(whileExp);
				if (result == null) result = caseEcore_OCLExpression(whileExp);
				if (result == null) result = caseETypedElement(whileExp);
				if (result == null) result = caseOCLExpression(whileExp);
				if (result == null) result = caseENamedElement(whileExp);
				if (result == null) result = caseTypedElement(whileExp);
				if (result == null) result = caseVisitable(whileExp);
				if (result == null) result = caseASTNode(whileExp);
				if (result == null) result = caseEModelElement(whileExp);
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
	 * @since 3.0
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
	 * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModelElement(EModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ENamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ENamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseENamedElement(ENamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETyped Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETyped Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseETypedElement(ETypedElement object) {
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
	public <C> T caseTypedElement(TypedElement<C> object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>AST Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AST Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseASTNode(ASTNode object) {
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
	public <C> T caseOCLExpression(OCLExpression<C> object) {
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
	public T caseEcore_OCLExpression(org.eclipse.ocl.ecore.OCLExpression object) {
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
	public <C> T caseLiteralExp(LiteralExp<C> object) {
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
	public T caseEcore_LiteralExp(org.eclipse.ocl.ecore.LiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EClassifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EClassifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEClassifier(EClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EData Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EData Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDataType(EDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predefined Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predefined Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <O> T casePredefinedType(PredefinedType<O> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed AST Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed AST Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedASTNode(TypedASTNode object) {
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
	public <C, O> T caseCollectionType(CollectionType<C, O> object) {
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
	public T caseEcore_CollectionType(org.eclipse.ocl.ecore.CollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Calling AST Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Calling AST Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallingASTNode(CallingASTNode object) {
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
	public <C> T caseCallExp(CallExp<C> object) {
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
	public T caseEcore_CallExp(org.eclipse.ocl.ecore.CallExp object) {
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
	public <C, PM> T caseLoopExp(LoopExp<C, PM> object) {
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
	public T caseEcore_LoopExp(org.eclipse.ocl.ecore.LoopExp object) {
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
	public <C> T caseFeatureCallExp(FeatureCallExp<C> object) {
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
	public T caseEcore_FeatureCallExp(org.eclipse.ocl.ecore.FeatureCallExp object) {
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
	public <C, O> T caseOperationCallExp(OperationCallExp<C, O> object) {
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
	public T caseEcore_OperationCallExp(org.eclipse.ocl.ecore.OperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EClass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EClass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEClass(EClass object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //ImperativeOCLSwitch
