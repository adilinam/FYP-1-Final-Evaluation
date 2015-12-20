/**
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
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
 * $Id: CSTSwitch.java,v 1.22 2010/01/29 15:27:09 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.BreakExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.CatchExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConstructorCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ContinueExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody;
import org.eclipse.m2m.internal.qvt.oml.cst.ExceptionDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ExpressionStatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ForExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeLoopExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeOperationCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.InstantiationExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.IntermediateClassDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ListLiteralExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ListTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.RaiseExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.RenameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveOpArgsExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.StatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TagCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TryExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.LiteralExpCS;
import org.eclipse.ocl.cst.LoopExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.TypeCS;

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
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage
 * @generated
 */
public class CSTSwitch<T> extends Switch<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CSTPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSTSwitch() {
		if (modelPackage == null) {
			modelPackage = CSTPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
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
			case CSTPackage.MAPPING_MODULE_CS: {
				MappingModuleCS mappingModuleCS = (MappingModuleCS)theEObject;
				T result = caseMappingModuleCS(mappingModuleCS);
				if (result == null) result = caseCSTNode(mappingModuleCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.LIBRARY_CS: {
				LibraryCS libraryCS = (LibraryCS)theEObject;
				T result = caseLibraryCS(libraryCS);
				if (result == null) result = caseMappingModuleCS(libraryCS);
				if (result == null) result = caseCSTNode(libraryCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.IMPORT_CS: {
				ImportCS importCS = (ImportCS)theEObject;
				T result = caseImportCS(importCS);
				if (result == null) result = caseCSTNode(importCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.LIBRARY_IMPORT_CS: {
				LibraryImportCS libraryImportCS = (LibraryImportCS)theEObject;
				T result = caseLibraryImportCS(libraryImportCS);
				if (result == null) result = caseImportCS(libraryImportCS);
				if (result == null) result = caseCSTNode(libraryImportCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.RENAME_CS: {
				RenameCS renameCS = (RenameCS)theEObject;
				T result = caseRenameCS(renameCS);
				if (result == null) result = caseCSTNode(renameCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MODULE_PROPERTY_CS: {
				ModulePropertyCS modulePropertyCS = (ModulePropertyCS)theEObject;
				T result = caseModulePropertyCS(modulePropertyCS);
				if (result == null) result = caseCSTNode(modulePropertyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.CONFIG_PROPERTY_CS: {
				ConfigPropertyCS configPropertyCS = (ConfigPropertyCS)theEObject;
				T result = caseConfigPropertyCS(configPropertyCS);
				if (result == null) result = caseModulePropertyCS(configPropertyCS);
				if (result == null) result = caseCSTNode(configPropertyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.LOCAL_PROPERTY_CS: {
				LocalPropertyCS localPropertyCS = (LocalPropertyCS)theEObject;
				T result = caseLocalPropertyCS(localPropertyCS);
				if (result == null) result = caseModulePropertyCS(localPropertyCS);
				if (result == null) result = caseCSTNode(localPropertyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.CONTEXTUAL_PROPERTY_CS: {
				ContextualPropertyCS contextualPropertyCS = (ContextualPropertyCS)theEObject;
				T result = caseContextualPropertyCS(contextualPropertyCS);
				if (result == null) result = caseModulePropertyCS(contextualPropertyCS);
				if (result == null) result = caseCSTNode(contextualPropertyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.CLASSIFIER_DEF_CS: {
				ClassifierDefCS classifierDefCS = (ClassifierDefCS)theEObject;
				T result = caseClassifierDefCS(classifierDefCS);
				if (result == null) result = caseCSTNode(classifierDefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.CLASSIFIER_PROPERTY_CS: {
				ClassifierPropertyCS classifierPropertyCS = (ClassifierPropertyCS)theEObject;
				T result = caseClassifierPropertyCS(classifierPropertyCS);
				if (result == null) result = caseLocalPropertyCS(classifierPropertyCS);
				if (result == null) result = caseModulePropertyCS(classifierPropertyCS);
				if (result == null) result = caseCSTNode(classifierPropertyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.INTERMEDIATE_CLASS_DEF_CS: {
				IntermediateClassDefCS intermediateClassDefCS = (IntermediateClassDefCS)theEObject;
				T result = caseIntermediateClassDefCS(intermediateClassDefCS);
				if (result == null) result = caseClassifierDefCS(intermediateClassDefCS);
				if (result == null) result = caseCSTNode(intermediateClassDefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.EXCEPTION_DEF_CS: {
				ExceptionDefCS exceptionDefCS = (ExceptionDefCS)theEObject;
				T result = caseExceptionDefCS(exceptionDefCS);
				if (result == null) result = caseClassifierDefCS(exceptionDefCS);
				if (result == null) result = caseCSTNode(exceptionDefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.OPPOSITE_PROPERTY_CS: {
				OppositePropertyCS oppositePropertyCS = (OppositePropertyCS)theEObject;
				T result = caseOppositePropertyCS(oppositePropertyCS);
				if (result == null) result = caseCSTNode(oppositePropertyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MULTIPLICITY_DEF_CS: {
				MultiplicityDefCS multiplicityDefCS = (MultiplicityDefCS)theEObject;
				T result = caseMultiplicityDefCS(multiplicityDefCS);
				if (result == null) result = caseCSTNode(multiplicityDefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_DECLARATION_CS: {
				MappingDeclarationCS mappingDeclarationCS = (MappingDeclarationCS)theEObject;
				T result = caseMappingDeclarationCS(mappingDeclarationCS);
				if (result == null) result = caseCSTNode(mappingDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.PARAMETER_DECLARATION_CS: {
				ParameterDeclarationCS parameterDeclarationCS = (ParameterDeclarationCS)theEObject;
				T result = caseParameterDeclarationCS(parameterDeclarationCS);
				if (result == null) result = caseCSTNode(parameterDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.SIMPLE_SIGNATURE_CS: {
				SimpleSignatureCS simpleSignatureCS = (SimpleSignatureCS)theEObject;
				T result = caseSimpleSignatureCS(simpleSignatureCS);
				if (result == null) result = caseCSTNode(simpleSignatureCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.COMPLETE_SIGNATURE_CS: {
				CompleteSignatureCS completeSignatureCS = (CompleteSignatureCS)theEObject;
				T result = caseCompleteSignatureCS(completeSignatureCS);
				if (result == null) result = caseCSTNode(completeSignatureCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_METHOD_CS: {
				MappingMethodCS mappingMethodCS = (MappingMethodCS)theEObject;
				T result = caseMappingMethodCS(mappingMethodCS);
				if (result == null) result = caseCSTNode(mappingMethodCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_RULE_CS: {
				MappingRuleCS mappingRuleCS = (MappingRuleCS)theEObject;
				T result = caseMappingRuleCS(mappingRuleCS);
				if (result == null) result = caseMappingMethodCS(mappingRuleCS);
				if (result == null) result = caseCSTNode(mappingRuleCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_QUERY_CS: {
				MappingQueryCS mappingQueryCS = (MappingQueryCS)theEObject;
				T result = caseMappingQueryCS(mappingQueryCS);
				if (result == null) result = caseMappingMethodCS(mappingQueryCS);
				if (result == null) result = caseCSTNode(mappingQueryCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.CONSTRUCTOR_CS: {
				ConstructorCS constructorCS = (ConstructorCS)theEObject;
				T result = caseConstructorCS(constructorCS);
				if (result == null) result = caseMappingMethodCS(constructorCS);
				if (result == null) result = caseCSTNode(constructorCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_SECTION_CS: {
				MappingSectionCS mappingSectionCS = (MappingSectionCS)theEObject;
				T result = caseMappingSectionCS(mappingSectionCS);
				if (result == null) result = caseCSTNode(mappingSectionCS);
				if (result == null) result = caseElementWithBody(mappingSectionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_INIT_CS: {
				MappingInitCS mappingInitCS = (MappingInitCS)theEObject;
				T result = caseMappingInitCS(mappingInitCS);
				if (result == null) result = caseMappingSectionCS(mappingInitCS);
				if (result == null) result = caseCSTNode(mappingInitCS);
				if (result == null) result = caseElementWithBody(mappingInitCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_END_CS: {
				MappingEndCS mappingEndCS = (MappingEndCS)theEObject;
				T result = caseMappingEndCS(mappingEndCS);
				if (result == null) result = caseMappingSectionCS(mappingEndCS);
				if (result == null) result = caseCSTNode(mappingEndCS);
				if (result == null) result = caseElementWithBody(mappingEndCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_SECTIONS_CS: {
				MappingSectionsCS mappingSectionsCS = (MappingSectionsCS)theEObject;
				T result = caseMappingSectionsCS(mappingSectionsCS);
				if (result == null) result = caseCSTNode(mappingSectionsCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.STATEMENT_CS: {
				StatementCS statementCS = (StatementCS)theEObject;
				T result = caseStatementCS(statementCS);
				if (result == null) result = caseOCLExpressionCS(statementCS);
				if (result == null) result = caseCSTNode(statementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.BLOCK_EXP_CS: {
				BlockExpCS blockExpCS = (BlockExpCS)theEObject;
				T result = caseBlockExpCS(blockExpCS);
				if (result == null) result = caseStatementCS(blockExpCS);
				if (result == null) result = caseOCLExpressionCS(blockExpCS);
				if (result == null) result = caseCSTNode(blockExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.COMPUTE_EXP_CS: {
				ComputeExpCS computeExpCS = (ComputeExpCS)theEObject;
				T result = caseComputeExpCS(computeExpCS);
				if (result == null) result = caseStatementCS(computeExpCS);
				if (result == null) result = caseOCLExpressionCS(computeExpCS);
				if (result == null) result = caseCSTNode(computeExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.WHILE_EXP_CS: {
				WhileExpCS whileExpCS = (WhileExpCS)theEObject;
				T result = caseWhileExpCS(whileExpCS);
				if (result == null) result = caseStatementCS(whileExpCS);
				if (result == null) result = caseOCLExpressionCS(whileExpCS);
				if (result == null) result = caseCSTNode(whileExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.IMPERATIVE_LOOP_EXP_CS: {
				ImperativeLoopExpCS imperativeLoopExpCS = (ImperativeLoopExpCS)theEObject;
				T result = caseImperativeLoopExpCS(imperativeLoopExpCS);
				if (result == null) result = caseLoopExpCS(imperativeLoopExpCS);
				if (result == null) result = caseStatementCS(imperativeLoopExpCS);
				if (result == null) result = caseCallExpCS(imperativeLoopExpCS);
				if (result == null) result = caseOCLExpressionCS(imperativeLoopExpCS);
				if (result == null) result = caseCSTNode(imperativeLoopExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.FOR_EXP_CS: {
				ForExpCS forExpCS = (ForExpCS)theEObject;
				T result = caseForExpCS(forExpCS);
				if (result == null) result = caseImperativeLoopExpCS(forExpCS);
				if (result == null) result = caseLoopExpCS(forExpCS);
				if (result == null) result = caseStatementCS(forExpCS);
				if (result == null) result = caseCallExpCS(forExpCS);
				if (result == null) result = caseOCLExpressionCS(forExpCS);
				if (result == null) result = caseCSTNode(forExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.IMPERATIVE_ITERATE_EXP_CS: {
				ImperativeIterateExpCS imperativeIterateExpCS = (ImperativeIterateExpCS)theEObject;
				T result = caseImperativeIterateExpCS(imperativeIterateExpCS);
				if (result == null) result = caseImperativeLoopExpCS(imperativeIterateExpCS);
				if (result == null) result = caseLoopExpCS(imperativeIterateExpCS);
				if (result == null) result = caseStatementCS(imperativeIterateExpCS);
				if (result == null) result = caseCallExpCS(imperativeIterateExpCS);
				if (result == null) result = caseOCLExpressionCS(imperativeIterateExpCS);
				if (result == null) result = caseCSTNode(imperativeIterateExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.SWITCH_EXP_CS: {
				SwitchExpCS switchExpCS = (SwitchExpCS)theEObject;
				T result = caseSwitchExpCS(switchExpCS);
				if (result == null) result = caseStatementCS(switchExpCS);
				if (result == null) result = caseOCLExpressionCS(switchExpCS);
				if (result == null) result = caseCSTNode(switchExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.SWITCH_ALT_EXP_CS: {
				SwitchAltExpCS switchAltExpCS = (SwitchAltExpCS)theEObject;
				T result = caseSwitchAltExpCS(switchAltExpCS);
				if (result == null) result = caseStatementCS(switchAltExpCS);
				if (result == null) result = caseOCLExpressionCS(switchAltExpCS);
				if (result == null) result = caseCSTNode(switchAltExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.VARIABLE_INITIALIZATION_CS: {
				VariableInitializationCS variableInitializationCS = (VariableInitializationCS)theEObject;
				T result = caseVariableInitializationCS(variableInitializationCS);
				if (result == null) result = caseStatementCS(variableInitializationCS);
				if (result == null) result = caseOCLExpressionCS(variableInitializationCS);
				if (result == null) result = caseCSTNode(variableInitializationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.ASSIGN_STATEMENT_CS: {
				AssignStatementCS assignStatementCS = (AssignStatementCS)theEObject;
				T result = caseAssignStatementCS(assignStatementCS);
				if (result == null) result = caseStatementCS(assignStatementCS);
				if (result == null) result = caseOCLExpressionCS(assignStatementCS);
				if (result == null) result = caseCSTNode(assignStatementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.BREAK_EXP_CS: {
				BreakExpCS breakExpCS = (BreakExpCS)theEObject;
				T result = caseBreakExpCS(breakExpCS);
				if (result == null) result = caseStatementCS(breakExpCS);
				if (result == null) result = caseOCLExpressionCS(breakExpCS);
				if (result == null) result = caseCSTNode(breakExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.CONTINUE_EXP_CS: {
				ContinueExpCS continueExpCS = (ContinueExpCS)theEObject;
				T result = caseContinueExpCS(continueExpCS);
				if (result == null) result = caseStatementCS(continueExpCS);
				if (result == null) result = caseOCLExpressionCS(continueExpCS);
				if (result == null) result = caseCSTNode(continueExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.EXPRESSION_STATEMENT_CS: {
				ExpressionStatementCS expressionStatementCS = (ExpressionStatementCS)theEObject;
				T result = caseExpressionStatementCS(expressionStatementCS);
				if (result == null) result = caseStatementCS(expressionStatementCS);
				if (result == null) result = caseOCLExpressionCS(expressionStatementCS);
				if (result == null) result = caseCSTNode(expressionStatementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_BODY_CS: {
				MappingBodyCS mappingBodyCS = (MappingBodyCS)theEObject;
				T result = caseMappingBodyCS(mappingBodyCS);
				if (result == null) result = caseMappingSectionCS(mappingBodyCS);
				if (result == null) result = caseCSTNode(mappingBodyCS);
				if (result == null) result = caseElementWithBody(mappingBodyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.OBJECT_EXP_CS: {
				ObjectExpCS objectExpCS = (ObjectExpCS)theEObject;
				T result = caseObjectExpCS(objectExpCS);
				if (result == null) result = caseInstantiationExpCS(objectExpCS);
				if (result == null) result = caseElementWithBody(objectExpCS);
				if (result == null) result = caseStatementCS(objectExpCS);
				if (result == null) result = caseOCLExpressionCS(objectExpCS);
				if (result == null) result = caseCSTNode(objectExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_CALL_EXP_CS: {
				MappingCallExpCS mappingCallExpCS = (MappingCallExpCS)theEObject;
				T result = caseMappingCallExpCS(mappingCallExpCS);
				if (result == null) result = caseImperativeOperationCallExpCS(mappingCallExpCS);
				if (result == null) result = caseOperationCallExpCS(mappingCallExpCS);
				if (result == null) result = caseFeatureCallExpCS(mappingCallExpCS);
				if (result == null) result = caseCallExpCS(mappingCallExpCS);
				if (result == null) result = caseOCLExpressionCS(mappingCallExpCS);
				if (result == null) result = caseCSTNode(mappingCallExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.IMPERATIVE_OPERATION_CALL_EXP_CS: {
				ImperativeOperationCallExpCS imperativeOperationCallExpCS = (ImperativeOperationCallExpCS)theEObject;
				T result = caseImperativeOperationCallExpCS(imperativeOperationCallExpCS);
				if (result == null) result = caseOperationCallExpCS(imperativeOperationCallExpCS);
				if (result == null) result = caseFeatureCallExpCS(imperativeOperationCallExpCS);
				if (result == null) result = caseCallExpCS(imperativeOperationCallExpCS);
				if (result == null) result = caseOCLExpressionCS(imperativeOperationCallExpCS);
				if (result == null) result = caseCSTNode(imperativeOperationCallExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.DIRECTION_KIND_CS: {
				DirectionKindCS directionKindCS = (DirectionKindCS)theEObject;
				T result = caseDirectionKindCS(directionKindCS);
				if (result == null) result = caseCSTNode(directionKindCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.ELEMENT_WITH_BODY: {
				ElementWithBody elementWithBody = (ElementWithBody)theEObject;
				T result = caseElementWithBody(elementWithBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.RESOLVE_EXP_CS: {
				ResolveExpCS resolveExpCS = (ResolveExpCS)theEObject;
				T result = caseResolveExpCS(resolveExpCS);
				if (result == null) result = caseCallExpCS(resolveExpCS);
				if (result == null) result = caseOCLExpressionCS(resolveExpCS);
				if (result == null) result = caseCSTNode(resolveExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.RESOLVE_IN_EXP_CS: {
				ResolveInExpCS resolveInExpCS = (ResolveInExpCS)theEObject;
				T result = caseResolveInExpCS(resolveInExpCS);
				if (result == null) result = caseResolveExpCS(resolveInExpCS);
				if (result == null) result = caseCallExpCS(resolveInExpCS);
				if (result == null) result = caseOCLExpressionCS(resolveInExpCS);
				if (result == null) result = caseCSTNode(resolveInExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MODEL_TYPE_CS: {
				ModelTypeCS modelTypeCS = (ModelTypeCS)theEObject;
				T result = caseModelTypeCS(modelTypeCS);
				if (result == null) result = caseCSTNode(modelTypeCS);
				if (result == null) result = caseElementWithBody(modelTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.PACKAGE_REF_CS: {
				PackageRefCS packageRefCS = (PackageRefCS)theEObject;
				T result = casePackageRefCS(packageRefCS);
				if (result == null) result = caseCSTNode(packageRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.TRANSFORMATION_HEADER_CS: {
				TransformationHeaderCS transformationHeaderCS = (TransformationHeaderCS)theEObject;
				T result = caseTransformationHeaderCS(transformationHeaderCS);
				if (result == null) result = caseCSTNode(transformationHeaderCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MODULE_KIND_CS: {
				ModuleKindCS moduleKindCS = (ModuleKindCS)theEObject;
				T result = caseModuleKindCS(moduleKindCS);
				if (result == null) result = caseCSTNode(moduleKindCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MODULE_REF_CS: {
				ModuleRefCS moduleRefCS = (ModuleRefCS)theEObject;
				T result = caseModuleRefCS(moduleRefCS);
				if (result == null) result = caseCSTNode(moduleRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MODULE_USAGE_CS: {
				ModuleUsageCS moduleUsageCS = (ModuleUsageCS)theEObject;
				T result = caseModuleUsageCS(moduleUsageCS);
				if (result == null) result = caseCSTNode(moduleUsageCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.TRANSFORMATION_REFINE_CS: {
				TransformationRefineCS transformationRefineCS = (TransformationRefineCS)theEObject;
				T result = caseTransformationRefineCS(transformationRefineCS);
				if (result == null) result = caseCSTNode(transformationRefineCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.TYPE_SPEC_CS: {
				TypeSpecCS typeSpecCS = (TypeSpecCS)theEObject;
				T result = caseTypeSpecCS(typeSpecCS);
				if (result == null) result = caseCSTNode(typeSpecCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.LOG_EXP_CS: {
				LogExpCS logExpCS = (LogExpCS)theEObject;
				T result = caseLogExpCS(logExpCS);
				if (result == null) result = caseOperationCallExpCS(logExpCS);
				if (result == null) result = caseFeatureCallExpCS(logExpCS);
				if (result == null) result = caseCallExpCS(logExpCS);
				if (result == null) result = caseOCLExpressionCS(logExpCS);
				if (result == null) result = caseCSTNode(logExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.ASSERT_EXP_CS: {
				AssertExpCS assertExpCS = (AssertExpCS)theEObject;
				T result = caseAssertExpCS(assertExpCS);
				if (result == null) result = caseStatementCS(assertExpCS);
				if (result == null) result = caseOCLExpressionCS(assertExpCS);
				if (result == null) result = caseCSTNode(assertExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.RETURN_EXP_CS: {
				ReturnExpCS returnExpCS = (ReturnExpCS)theEObject;
				T result = caseReturnExpCS(returnExpCS);
				if (result == null) result = caseStatementCS(returnExpCS);
				if (result == null) result = caseOCLExpressionCS(returnExpCS);
				if (result == null) result = caseCSTNode(returnExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_EXTENSION_CS: {
				MappingExtensionCS mappingExtensionCS = (MappingExtensionCS)theEObject;
				T result = caseMappingExtensionCS(mappingExtensionCS);
				if (result == null) result = caseCSTNode(mappingExtensionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.INSTANTIATION_EXP_CS: {
				InstantiationExpCS instantiationExpCS = (InstantiationExpCS)theEObject;
				T result = caseInstantiationExpCS(instantiationExpCS);
				if (result == null) result = caseStatementCS(instantiationExpCS);
				if (result == null) result = caseOCLExpressionCS(instantiationExpCS);
				if (result == null) result = caseCSTNode(instantiationExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.LIST_TYPE_CS: {
				ListTypeCS listTypeCS = (ListTypeCS)theEObject;
				T result = caseListTypeCS(listTypeCS);
				if (result == null) result = caseTypeCS(listTypeCS);
				if (result == null) result = caseOCLExpressionCS(listTypeCS);
				if (result == null) result = caseCSTNode(listTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.LIST_LITERAL_EXP_CS: {
				ListLiteralExpCS listLiteralExpCS = (ListLiteralExpCS)theEObject;
				T result = caseListLiteralExpCS(listLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(listLiteralExpCS);
				if (result == null) result = caseOCLExpressionCS(listLiteralExpCS);
				if (result == null) result = caseCSTNode(listLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.DICTIONARY_TYPE_CS: {
				DictionaryTypeCS dictionaryTypeCS = (DictionaryTypeCS)theEObject;
				T result = caseDictionaryTypeCS(dictionaryTypeCS);
				if (result == null) result = caseTypeCS(dictionaryTypeCS);
				if (result == null) result = caseOCLExpressionCS(dictionaryTypeCS);
				if (result == null) result = caseCSTNode(dictionaryTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.DICT_LITERAL_EXP_CS: {
				DictLiteralExpCS dictLiteralExpCS = (DictLiteralExpCS)theEObject;
				T result = caseDictLiteralExpCS(dictLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(dictLiteralExpCS);
				if (result == null) result = caseOCLExpressionCS(dictLiteralExpCS);
				if (result == null) result = caseCSTNode(dictLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.DICT_LITERAL_PART_CS: {
				DictLiteralPartCS dictLiteralPartCS = (DictLiteralPartCS)theEObject;
				T result = caseDictLiteralPartCS(dictLiteralPartCS);
				if (result == null) result = caseCSTNode(dictLiteralPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.TAG_CS: {
				TagCS tagCS = (TagCS)theEObject;
				T result = caseTagCS(tagCS);
				if (result == null) result = caseCSTNode(tagCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.UNIT_CS: {
				UnitCS unitCS = (UnitCS)theEObject;
				T result = caseUnitCS(unitCS);
				if (result == null) result = caseCSTNode(unitCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.RESOLVE_OP_ARGS_EXP_CS: {
				ResolveOpArgsExpCS resolveOpArgsExpCS = (ResolveOpArgsExpCS)theEObject;
				T result = caseResolveOpArgsExpCS(resolveOpArgsExpCS);
				if (result == null) result = caseCSTNode(resolveOpArgsExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.SCOPED_NAME_CS: {
				ScopedNameCS scopedNameCS = (ScopedNameCS)theEObject;
				T result = caseScopedNameCS(scopedNameCS);
				if (result == null) result = caseCSTNode(scopedNameCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.TRY_EXP_CS: {
				TryExpCS tryExpCS = (TryExpCS)theEObject;
				T result = caseTryExpCS(tryExpCS);
				if (result == null) result = caseStatementCS(tryExpCS);
				if (result == null) result = caseOCLExpressionCS(tryExpCS);
				if (result == null) result = caseCSTNode(tryExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.CATCH_EXP_CS: {
				CatchExpCS catchExpCS = (CatchExpCS)theEObject;
				T result = caseCatchExpCS(catchExpCS);
				if (result == null) result = caseCSTNode(catchExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.RAISE_EXP_CS: {
				RaiseExpCS raiseExpCS = (RaiseExpCS)theEObject;
				T result = caseRaiseExpCS(raiseExpCS);
				if (result == null) result = caseStatementCS(raiseExpCS);
				if (result == null) result = caseOCLExpressionCS(raiseExpCS);
				if (result == null) result = caseCSTNode(raiseExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Module CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Module CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingModuleCS(MappingModuleCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibraryCS(LibraryCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportCS(ImportCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library Import CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library Import CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibraryImportCS(LibraryImportCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rename CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rename CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRenameCS(RenameCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModulePropertyCS(ModulePropertyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Config Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Config Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigPropertyCS(ConfigPropertyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalPropertyCS(LocalPropertyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contextual Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contextual Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextualPropertyCS(ContextualPropertyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Def CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Def CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierDefCS(ClassifierDefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierPropertyCS(ClassifierPropertyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intermediate Class Def CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intermediate Class Def CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateClassDefCS(IntermediateClassDefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exception Def CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exception Def CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExceptionDefCS(ExceptionDefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Opposite Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opposite Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOppositePropertyCS(OppositePropertyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicity Def CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicity Def CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicityDefCS(MultiplicityDefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Declaration CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingDeclarationCS(MappingDeclarationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Declaration CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterDeclarationCS(ParameterDeclarationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Signature CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Signature CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleSignatureCS(SimpleSignatureCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complete Signature CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complete Signature CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompleteSignatureCS(CompleteSignatureCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Method CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Method CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingMethodCS(MappingMethodCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Rule CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Rule CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingRuleCS(MappingRuleCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Query CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Query CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingQueryCS(MappingQueryCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstructorCS(ConstructorCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Section CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Section CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingSectionCS(MappingSectionCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Init CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Init CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingInitCS(MappingInitCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping End CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping End CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingEndCS(MappingEndCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Sections CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Sections CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingSectionsCS(MappingSectionsCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatementCS(StatementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockExpCS(BlockExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compute Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compute Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputeExpCS(ComputeExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileExpCS(WhileExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Loop Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Loop Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeLoopExpCS(ImperativeLoopExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForExpCS(ForExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Iterate Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Iterate Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeIterateExpCS(ImperativeIterateExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchExpCS(SwitchExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Alt Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Alt Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchAltExpCS(SwitchAltExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Initialization CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Initialization CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableInitializationCS(VariableInitializationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assign Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assign Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignStatementCS(AssignStatementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Break Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Break Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBreakExpCS(BreakExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Continue Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Continue Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContinueExpCS(ContinueExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionStatementCS(ExpressionStatementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Body CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Body CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingBodyCS(MappingBodyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectExpCS(ObjectExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingCallExpCS(MappingCallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Operation Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Operation Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeOperationCallExpCS(ImperativeOperationCallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Direction Kind CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Direction Kind CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectionKindCS(DirectionKindCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element With Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element With Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementWithBody(ElementWithBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolve Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolve Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResolveExpCS(ResolveExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolve In Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolve In Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResolveInExpCS(ResolveInExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelTypeCS(ModelTypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageRefCS(PackageRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformation Header CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformation Header CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformationHeaderCS(TransformationHeaderCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Kind CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Kind CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleKindCS(ModuleKindCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleRefCS(ModuleRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Usage CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Usage CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleUsageCS(ModuleUsageCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformation Refine CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformation Refine CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformationRefineCS(TransformationRefineCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Spec CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Spec CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeSpecCS(TypeSpecCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Log Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Log Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogExpCS(LogExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assert Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assert Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertExpCS(AssertExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnExpCS(ReturnExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Extension CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Extension CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingExtensionCS(MappingExtensionCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instantiation Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instantiation Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstantiationExpCS(InstantiationExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListTypeCS(ListTypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListLiteralExpCS(ListLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dictionary Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dictionary Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDictionaryTypeCS(DictionaryTypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dict Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dict Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDictLiteralExpCS(DictLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dict Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dict Literal Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDictLiteralPartCS(DictLiteralPartCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTagCS(TagCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitCS(UnitCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolve Op Args Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolve Op Args Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResolveOpArgsExpCS(ResolveOpArgsExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scoped Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scoped Name CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopedNameCS(ScopedNameCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Try Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Try Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTryExpCS(TryExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Catch Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Catch Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCatchExpCS(CatchExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raise Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raise Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRaiseExpCS(RaiseExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCSTNode(CSTNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Expression CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Expression CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLExpressionCS(OCLExpressionCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallExpCS(CallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopExpCS(LoopExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureCallExpCS(FeatureCallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCallExpCS(OperationCallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeCS(TypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralExpCS(LiteralExpCS object) {
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

} //CSTSwitch
