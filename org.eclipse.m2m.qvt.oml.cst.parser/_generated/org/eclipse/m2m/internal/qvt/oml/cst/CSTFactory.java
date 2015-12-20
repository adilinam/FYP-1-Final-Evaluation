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
 * $Id: CSTFactory.java,v 1.19 2010/01/29 15:23:42 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage
 * @generated
 */
public interface CSTFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CSTFactory eINSTANCE = org.eclipse.m2m.internal.qvt.oml.cst.impl.CSTFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Mapping Module CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Module CS</em>'.
	 * @generated
	 */
	MappingModuleCS createMappingModuleCS();

	/**
	 * Returns a new object of class '<em>Library CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library CS</em>'.
	 * @generated
	 */
	LibraryCS createLibraryCS();

	/**
	 * Returns a new object of class '<em>Import CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import CS</em>'.
	 * @generated
	 */
	ImportCS createImportCS();

	/**
	 * Returns a new object of class '<em>Library Import CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library Import CS</em>'.
	 * @generated
	 */
	LibraryImportCS createLibraryImportCS();

	/**
	 * Returns a new object of class '<em>Rename CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rename CS</em>'.
	 * @generated
	 */
	RenameCS createRenameCS();

	/**
	 * Returns a new object of class '<em>Config Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Config Property CS</em>'.
	 * @generated
	 */
	ConfigPropertyCS createConfigPropertyCS();

	/**
	 * Returns a new object of class '<em>Local Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Property CS</em>'.
	 * @generated
	 */
	LocalPropertyCS createLocalPropertyCS();

	/**
	 * Returns a new object of class '<em>Contextual Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contextual Property CS</em>'.
	 * @generated
	 */
	ContextualPropertyCS createContextualPropertyCS();

	/**
	 * Returns a new object of class '<em>Classifier Def CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Classifier Def CS</em>'.
	 * @generated
	 */
	ClassifierDefCS createClassifierDefCS();

	/**
	 * Returns a new object of class '<em>Classifier Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Classifier Property CS</em>'.
	 * @generated
	 */
	ClassifierPropertyCS createClassifierPropertyCS();

	/**
	 * Returns a new object of class '<em>Intermediate Class Def CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Intermediate Class Def CS</em>'.
	 * @generated
	 */
	IntermediateClassDefCS createIntermediateClassDefCS();

	/**
	 * Returns a new object of class '<em>Exception Def CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exception Def CS</em>'.
	 * @generated
	 */
	ExceptionDefCS createExceptionDefCS();

	/**
	 * Returns a new object of class '<em>Opposite Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opposite Property CS</em>'.
	 * @generated
	 */
	OppositePropertyCS createOppositePropertyCS();

	/**
	 * Returns a new object of class '<em>Multiplicity Def CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicity Def CS</em>'.
	 * @generated
	 */
	MultiplicityDefCS createMultiplicityDefCS();

	/**
	 * Returns a new object of class '<em>Mapping Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Declaration CS</em>'.
	 * @generated
	 */
	MappingDeclarationCS createMappingDeclarationCS();

	/**
	 * Returns a new object of class '<em>Parameter Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Declaration CS</em>'.
	 * @generated
	 */
	ParameterDeclarationCS createParameterDeclarationCS();

	/**
	 * Returns a new object of class '<em>Simple Signature CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Signature CS</em>'.
	 * @generated
	 */
	SimpleSignatureCS createSimpleSignatureCS();

	/**
	 * Returns a new object of class '<em>Complete Signature CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Signature CS</em>'.
	 * @generated
	 */
	CompleteSignatureCS createCompleteSignatureCS();

	/**
	 * Returns a new object of class '<em>Mapping Rule CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Rule CS</em>'.
	 * @generated
	 */
	MappingRuleCS createMappingRuleCS();

	/**
	 * Returns a new object of class '<em>Mapping Query CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Query CS</em>'.
	 * @generated
	 */
	MappingQueryCS createMappingQueryCS();

	/**
	 * Returns a new object of class '<em>Constructor CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constructor CS</em>'.
	 * @generated
	 */
	ConstructorCS createConstructorCS();

	/**
	 * Returns a new object of class '<em>Mapping Init CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Init CS</em>'.
	 * @generated
	 */
	MappingInitCS createMappingInitCS();

	/**
	 * Returns a new object of class '<em>Mapping End CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping End CS</em>'.
	 * @generated
	 */
	MappingEndCS createMappingEndCS();

	/**
	 * Returns a new object of class '<em>Mapping Sections CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Sections CS</em>'.
	 * @generated
	 */
	MappingSectionsCS createMappingSectionsCS();

	/**
	 * Returns a new object of class '<em>Block Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Exp CS</em>'.
	 * @generated
	 */
	BlockExpCS createBlockExpCS();

	/**
	 * Returns a new object of class '<em>Compute Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compute Exp CS</em>'.
	 * @generated
	 */
	ComputeExpCS createComputeExpCS();

	/**
	 * Returns a new object of class '<em>While Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Exp CS</em>'.
	 * @generated
	 */
	WhileExpCS createWhileExpCS();

	/**
	 * Returns a new object of class '<em>Imperative Loop Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Loop Exp CS</em>'.
	 * @generated
	 */
	ImperativeLoopExpCS createImperativeLoopExpCS();

	/**
	 * Returns a new object of class '<em>For Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Exp CS</em>'.
	 * @generated
	 */
	ForExpCS createForExpCS();

	/**
	 * Returns a new object of class '<em>Imperative Iterate Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Iterate Exp CS</em>'.
	 * @generated
	 */
	ImperativeIterateExpCS createImperativeIterateExpCS();

	/**
	 * Returns a new object of class '<em>Switch Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Exp CS</em>'.
	 * @generated
	 */
	SwitchExpCS createSwitchExpCS();

	/**
	 * Returns a new object of class '<em>Switch Alt Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Alt Exp CS</em>'.
	 * @generated
	 */
	SwitchAltExpCS createSwitchAltExpCS();

	/**
	 * Returns a new object of class '<em>Variable Initialization CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Initialization CS</em>'.
	 * @generated
	 */
	VariableInitializationCS createVariableInitializationCS();

	/**
	 * Returns a new object of class '<em>Assign Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assign Statement CS</em>'.
	 * @generated
	 */
	AssignStatementCS createAssignStatementCS();

	/**
	 * Returns a new object of class '<em>Break Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Break Exp CS</em>'.
	 * @generated
	 */
	BreakExpCS createBreakExpCS();

	/**
	 * Returns a new object of class '<em>Continue Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Continue Exp CS</em>'.
	 * @generated
	 */
	ContinueExpCS createContinueExpCS();

	/**
	 * Returns a new object of class '<em>Expression Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Statement CS</em>'.
	 * @generated
	 */
	ExpressionStatementCS createExpressionStatementCS();

	/**
	 * Returns a new object of class '<em>Mapping Body CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Body CS</em>'.
	 * @generated
	 */
	MappingBodyCS createMappingBodyCS();

	/**
	 * Returns a new object of class '<em>Object Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Exp CS</em>'.
	 * @generated
	 */
	ObjectExpCS createObjectExpCS();

	/**
	 * Returns a new object of class '<em>Mapping Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Call Exp CS</em>'.
	 * @generated
	 */
	MappingCallExpCS createMappingCallExpCS();

	/**
	 * Returns a new object of class '<em>Imperative Operation Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Operation Call Exp CS</em>'.
	 * @generated
	 */
	ImperativeOperationCallExpCS createImperativeOperationCallExpCS();

	/**
	 * Returns a new object of class '<em>Direction Kind CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Direction Kind CS</em>'.
	 * @generated
	 */
	DirectionKindCS createDirectionKindCS();

	/**
	 * Returns a new object of class '<em>Resolve Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolve Exp CS</em>'.
	 * @generated
	 */
	ResolveExpCS createResolveExpCS();

	/**
	 * Returns a new object of class '<em>Resolve In Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolve In Exp CS</em>'.
	 * @generated
	 */
	ResolveInExpCS createResolveInExpCS();

	/**
	 * Returns a new object of class '<em>Model Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Type CS</em>'.
	 * @generated
	 */
	ModelTypeCS createModelTypeCS();

	/**
	 * Returns a new object of class '<em>Package Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Ref CS</em>'.
	 * @generated
	 */
	PackageRefCS createPackageRefCS();

	/**
	 * Returns a new object of class '<em>Transformation Header CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation Header CS</em>'.
	 * @generated
	 */
	TransformationHeaderCS createTransformationHeaderCS();

	/**
	 * Returns a new object of class '<em>Module Kind CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Kind CS</em>'.
	 * @generated
	 */
	ModuleKindCS createModuleKindCS();

	/**
	 * Returns a new object of class '<em>Module Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Ref CS</em>'.
	 * @generated
	 */
	ModuleRefCS createModuleRefCS();

	/**
	 * Returns a new object of class '<em>Module Usage CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Usage CS</em>'.
	 * @generated
	 */
	ModuleUsageCS createModuleUsageCS();

	/**
	 * Returns a new object of class '<em>Transformation Refine CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation Refine CS</em>'.
	 * @generated
	 */
	TransformationRefineCS createTransformationRefineCS();

	/**
	 * Returns a new object of class '<em>Type Spec CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Spec CS</em>'.
	 * @generated
	 */
	TypeSpecCS createTypeSpecCS();

	/**
	 * Returns a new object of class '<em>Log Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Log Exp CS</em>'.
	 * @generated
	 */
	LogExpCS createLogExpCS();

	/**
	 * Returns a new object of class '<em>Assert Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assert Exp CS</em>'.
	 * @generated
	 */
	AssertExpCS createAssertExpCS();

	/**
	 * Returns a new object of class '<em>Return Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Return Exp CS</em>'.
	 * @generated
	 */
	ReturnExpCS createReturnExpCS();

	/**
	 * Returns a new object of class '<em>Mapping Extension CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Extension CS</em>'.
	 * @generated
	 */
	MappingExtensionCS createMappingExtensionCS();

	/**
	 * Returns a new object of class '<em>Instantiation Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instantiation Exp CS</em>'.
	 * @generated
	 */
	InstantiationExpCS createInstantiationExpCS();

	/**
	 * Returns a new object of class '<em>List Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Type CS</em>'.
	 * @generated
	 */
	ListTypeCS createListTypeCS();

	/**
	 * Returns a new object of class '<em>List Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Literal Exp CS</em>'.
	 * @generated
	 */
	ListLiteralExpCS createListLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Dictionary Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dictionary Type CS</em>'.
	 * @generated
	 */
	DictionaryTypeCS createDictionaryTypeCS();

	/**
	 * Returns a new object of class '<em>Dict Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dict Literal Exp CS</em>'.
	 * @generated
	 */
	DictLiteralExpCS createDictLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Dict Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dict Literal Part CS</em>'.
	 * @generated
	 */
	DictLiteralPartCS createDictLiteralPartCS();

	/**
	 * Returns a new object of class '<em>Tag CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag CS</em>'.
	 * @generated
	 */
	TagCS createTagCS();

	/**
	 * Returns a new object of class '<em>Unit CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit CS</em>'.
	 * @generated
	 */
	UnitCS createUnitCS();

	/**
	 * Returns a new object of class '<em>Resolve Op Args Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolve Op Args Exp CS</em>'.
	 * @generated
	 */
	ResolveOpArgsExpCS createResolveOpArgsExpCS();

	/**
	 * Returns a new object of class '<em>Scoped Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scoped Name CS</em>'.
	 * @generated
	 */
	ScopedNameCS createScopedNameCS();

	/**
	 * Returns a new object of class '<em>Try Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Try Exp CS</em>'.
	 * @generated
	 */
	TryExpCS createTryExpCS();

	/**
	 * Returns a new object of class '<em>Catch Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Catch Exp CS</em>'.
	 * @generated
	 */
	CatchExpCS createCatchExpCS();

	/**
	 * Returns a new object of class '<em>Raise Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Raise Exp CS</em>'.
	 * @generated
	 */
	RaiseExpCS createRaiseExpCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CSTPackage getCSTPackage();

} //CSTFactory
