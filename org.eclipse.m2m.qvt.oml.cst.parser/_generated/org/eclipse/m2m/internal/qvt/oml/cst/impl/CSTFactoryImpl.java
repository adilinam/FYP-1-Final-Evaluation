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
 * $Id: CSTFactoryImpl.java,v 1.21 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.m2m.internal.qvt.oml.cst.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CSTFactoryImpl extends EFactoryImpl implements CSTFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CSTFactory init() {
		try {
			CSTFactory theCSTFactory = (CSTFactory)EPackage.Registry.INSTANCE.getEFactory(CSTPackage.eNS_URI);
			if (theCSTFactory != null) {
				return theCSTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSTFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CSTPackage.MAPPING_MODULE_CS: return createMappingModuleCS();
			case CSTPackage.LIBRARY_CS: return createLibraryCS();
			case CSTPackage.IMPORT_CS: return createImportCS();
			case CSTPackage.LIBRARY_IMPORT_CS: return createLibraryImportCS();
			case CSTPackage.RENAME_CS: return createRenameCS();
			case CSTPackage.CONFIG_PROPERTY_CS: return createConfigPropertyCS();
			case CSTPackage.LOCAL_PROPERTY_CS: return createLocalPropertyCS();
			case CSTPackage.CONTEXTUAL_PROPERTY_CS: return createContextualPropertyCS();
			case CSTPackage.CLASSIFIER_DEF_CS: return createClassifierDefCS();
			case CSTPackage.CLASSIFIER_PROPERTY_CS: return createClassifierPropertyCS();
			case CSTPackage.INTERMEDIATE_CLASS_DEF_CS: return createIntermediateClassDefCS();
			case CSTPackage.EXCEPTION_DEF_CS: return createExceptionDefCS();
			case CSTPackage.OPPOSITE_PROPERTY_CS: return createOppositePropertyCS();
			case CSTPackage.MULTIPLICITY_DEF_CS: return createMultiplicityDefCS();
			case CSTPackage.MAPPING_DECLARATION_CS: return createMappingDeclarationCS();
			case CSTPackage.PARAMETER_DECLARATION_CS: return createParameterDeclarationCS();
			case CSTPackage.SIMPLE_SIGNATURE_CS: return createSimpleSignatureCS();
			case CSTPackage.COMPLETE_SIGNATURE_CS: return createCompleteSignatureCS();
			case CSTPackage.MAPPING_RULE_CS: return createMappingRuleCS();
			case CSTPackage.MAPPING_QUERY_CS: return createMappingQueryCS();
			case CSTPackage.CONSTRUCTOR_CS: return createConstructorCS();
			case CSTPackage.MAPPING_INIT_CS: return createMappingInitCS();
			case CSTPackage.MAPPING_END_CS: return createMappingEndCS();
			case CSTPackage.MAPPING_SECTIONS_CS: return createMappingSectionsCS();
			case CSTPackage.BLOCK_EXP_CS: return createBlockExpCS();
			case CSTPackage.COMPUTE_EXP_CS: return createComputeExpCS();
			case CSTPackage.WHILE_EXP_CS: return createWhileExpCS();
			case CSTPackage.IMPERATIVE_LOOP_EXP_CS: return createImperativeLoopExpCS();
			case CSTPackage.FOR_EXP_CS: return createForExpCS();
			case CSTPackage.IMPERATIVE_ITERATE_EXP_CS: return createImperativeIterateExpCS();
			case CSTPackage.SWITCH_EXP_CS: return createSwitchExpCS();
			case CSTPackage.SWITCH_ALT_EXP_CS: return createSwitchAltExpCS();
			case CSTPackage.VARIABLE_INITIALIZATION_CS: return createVariableInitializationCS();
			case CSTPackage.ASSIGN_STATEMENT_CS: return createAssignStatementCS();
			case CSTPackage.BREAK_EXP_CS: return createBreakExpCS();
			case CSTPackage.CONTINUE_EXP_CS: return createContinueExpCS();
			case CSTPackage.EXPRESSION_STATEMENT_CS: return createExpressionStatementCS();
			case CSTPackage.MAPPING_BODY_CS: return createMappingBodyCS();
			case CSTPackage.OBJECT_EXP_CS: return createObjectExpCS();
			case CSTPackage.MAPPING_CALL_EXP_CS: return createMappingCallExpCS();
			case CSTPackage.IMPERATIVE_OPERATION_CALL_EXP_CS: return createImperativeOperationCallExpCS();
			case CSTPackage.DIRECTION_KIND_CS: return createDirectionKindCS();
			case CSTPackage.RESOLVE_EXP_CS: return createResolveExpCS();
			case CSTPackage.RESOLVE_IN_EXP_CS: return createResolveInExpCS();
			case CSTPackage.MODEL_TYPE_CS: return createModelTypeCS();
			case CSTPackage.PACKAGE_REF_CS: return createPackageRefCS();
			case CSTPackage.TRANSFORMATION_HEADER_CS: return createTransformationHeaderCS();
			case CSTPackage.MODULE_KIND_CS: return createModuleKindCS();
			case CSTPackage.MODULE_REF_CS: return createModuleRefCS();
			case CSTPackage.MODULE_USAGE_CS: return createModuleUsageCS();
			case CSTPackage.TRANSFORMATION_REFINE_CS: return createTransformationRefineCS();
			case CSTPackage.TYPE_SPEC_CS: return createTypeSpecCS();
			case CSTPackage.LOG_EXP_CS: return createLogExpCS();
			case CSTPackage.ASSERT_EXP_CS: return createAssertExpCS();
			case CSTPackage.RETURN_EXP_CS: return createReturnExpCS();
			case CSTPackage.MAPPING_EXTENSION_CS: return createMappingExtensionCS();
			case CSTPackage.INSTANTIATION_EXP_CS: return createInstantiationExpCS();
			case CSTPackage.LIST_TYPE_CS: return createListTypeCS();
			case CSTPackage.LIST_LITERAL_EXP_CS: return createListLiteralExpCS();
			case CSTPackage.DICTIONARY_TYPE_CS: return createDictionaryTypeCS();
			case CSTPackage.DICT_LITERAL_EXP_CS: return createDictLiteralExpCS();
			case CSTPackage.DICT_LITERAL_PART_CS: return createDictLiteralPartCS();
			case CSTPackage.TAG_CS: return createTagCS();
			case CSTPackage.UNIT_CS: return createUnitCS();
			case CSTPackage.RESOLVE_OP_ARGS_EXP_CS: return createResolveOpArgsExpCS();
			case CSTPackage.SCOPED_NAME_CS: return createScopedNameCS();
			case CSTPackage.TRY_EXP_CS: return createTryExpCS();
			case CSTPackage.CATCH_EXP_CS: return createCatchExpCS();
			case CSTPackage.RAISE_EXP_CS: return createRaiseExpCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CSTPackage.DIRECTION_KIND_ENUM:
				return createDirectionKindEnumFromString(eDataType, initialValue);
			case CSTPackage.MODULE_KIND_ENUM:
				return createModuleKindEnumFromString(eDataType, initialValue);
			case CSTPackage.IMPORT_KIND_ENUM:
				return createImportKindEnumFromString(eDataType, initialValue);
			case CSTPackage.MAPPING_EXTENSION_KIND_CS:
				return createMappingExtensionKindCSFromString(eDataType, initialValue);
			case CSTPackage.QUALIFIER_KIND_CS:
				return createQualifierKindCSFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CSTPackage.DIRECTION_KIND_ENUM:
				return convertDirectionKindEnumToString(eDataType, instanceValue);
			case CSTPackage.MODULE_KIND_ENUM:
				return convertModuleKindEnumToString(eDataType, instanceValue);
			case CSTPackage.IMPORT_KIND_ENUM:
				return convertImportKindEnumToString(eDataType, instanceValue);
			case CSTPackage.MAPPING_EXTENSION_KIND_CS:
				return convertMappingExtensionKindCSToString(eDataType, instanceValue);
			case CSTPackage.QUALIFIER_KIND_CS:
				return convertQualifierKindCSToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingModuleCS createMappingModuleCS() {
		MappingModuleCSImpl mappingModuleCS = new MappingModuleCSImpl();
		return mappingModuleCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryCS createLibraryCS() {
		LibraryCSImpl libraryCS = new LibraryCSImpl();
		return libraryCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportCS createImportCS() {
		ImportCSImpl importCS = new ImportCSImpl();
		return importCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryImportCS createLibraryImportCS() {
		LibraryImportCSImpl libraryImportCS = new LibraryImportCSImpl();
		return libraryImportCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenameCS createRenameCS() {
		RenameCSImpl renameCS = new RenameCSImpl();
		return renameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigPropertyCS createConfigPropertyCS() {
		ConfigPropertyCSImpl configPropertyCS = new ConfigPropertyCSImpl();
		return configPropertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalPropertyCS createLocalPropertyCS() {
		LocalPropertyCSImpl localPropertyCS = new LocalPropertyCSImpl();
		return localPropertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextualPropertyCS createContextualPropertyCS() {
		ContextualPropertyCSImpl contextualPropertyCS = new ContextualPropertyCSImpl();
		return contextualPropertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierDefCS createClassifierDefCS() {
		ClassifierDefCSImpl classifierDefCS = new ClassifierDefCSImpl();
		return classifierDefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierPropertyCS createClassifierPropertyCS() {
		ClassifierPropertyCSImpl classifierPropertyCS = new ClassifierPropertyCSImpl();
		return classifierPropertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateClassDefCS createIntermediateClassDefCS() {
		IntermediateClassDefCSImpl intermediateClassDefCS = new IntermediateClassDefCSImpl();
		return intermediateClassDefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExceptionDefCS createExceptionDefCS() {
		ExceptionDefCSImpl exceptionDefCS = new ExceptionDefCSImpl();
		return exceptionDefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OppositePropertyCS createOppositePropertyCS() {
		OppositePropertyCSImpl oppositePropertyCS = new OppositePropertyCSImpl();
		return oppositePropertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityDefCS createMultiplicityDefCS() {
		MultiplicityDefCSImpl multiplicityDefCS = new MultiplicityDefCSImpl();
		return multiplicityDefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingDeclarationCS createMappingDeclarationCS() {
		MappingDeclarationCSImpl mappingDeclarationCS = new MappingDeclarationCSImpl();
		return mappingDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDeclarationCS createParameterDeclarationCS() {
		ParameterDeclarationCSImpl parameterDeclarationCS = new ParameterDeclarationCSImpl();
		return parameterDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleSignatureCS createSimpleSignatureCS() {
		SimpleSignatureCSImpl simpleSignatureCS = new SimpleSignatureCSImpl();
		return simpleSignatureCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteSignatureCS createCompleteSignatureCS() {
		CompleteSignatureCSImpl completeSignatureCS = new CompleteSignatureCSImpl();
		return completeSignatureCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRuleCS createMappingRuleCS() {
		MappingRuleCSImpl mappingRuleCS = new MappingRuleCSImpl();
		return mappingRuleCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingQueryCS createMappingQueryCS() {
		MappingQueryCSImpl mappingQueryCS = new MappingQueryCSImpl();
		return mappingQueryCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstructorCS createConstructorCS() {
		ConstructorCSImpl constructorCS = new ConstructorCSImpl();
		return constructorCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingInitCS createMappingInitCS() {
		MappingInitCSImpl mappingInitCS = new MappingInitCSImpl();
		return mappingInitCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingEndCS createMappingEndCS() {
		MappingEndCSImpl mappingEndCS = new MappingEndCSImpl();
		return mappingEndCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingSectionsCS createMappingSectionsCS() {
		MappingSectionsCSImpl mappingSectionsCS = new MappingSectionsCSImpl();
		return mappingSectionsCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockExpCS createBlockExpCS() {
		BlockExpCSImpl blockExpCS = new BlockExpCSImpl();
		return blockExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputeExpCS createComputeExpCS() {
		ComputeExpCSImpl computeExpCS = new ComputeExpCSImpl();
		return computeExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileExpCS createWhileExpCS() {
		WhileExpCSImpl whileExpCS = new WhileExpCSImpl();
		return whileExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeLoopExpCS createImperativeLoopExpCS() {
		ImperativeLoopExpCSImpl imperativeLoopExpCS = new ImperativeLoopExpCSImpl();
		return imperativeLoopExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForExpCS createForExpCS() {
		ForExpCSImpl forExpCS = new ForExpCSImpl();
		return forExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeIterateExpCS createImperativeIterateExpCS() {
		ImperativeIterateExpCSImpl imperativeIterateExpCS = new ImperativeIterateExpCSImpl();
		return imperativeIterateExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchExpCS createSwitchExpCS() {
		SwitchExpCSImpl switchExpCS = new SwitchExpCSImpl();
		return switchExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchAltExpCS createSwitchAltExpCS() {
		SwitchAltExpCSImpl switchAltExpCS = new SwitchAltExpCSImpl();
		return switchAltExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableInitializationCS createVariableInitializationCS() {
		VariableInitializationCSImpl variableInitializationCS = new VariableInitializationCSImpl();
		return variableInitializationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignStatementCS createAssignStatementCS() {
		AssignStatementCSImpl assignStatementCS = new AssignStatementCSImpl();
		return assignStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BreakExpCS createBreakExpCS() {
		BreakExpCSImpl breakExpCS = new BreakExpCSImpl();
		return breakExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContinueExpCS createContinueExpCS() {
		ContinueExpCSImpl continueExpCS = new ContinueExpCSImpl();
		return continueExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionStatementCS createExpressionStatementCS() {
		ExpressionStatementCSImpl expressionStatementCS = new ExpressionStatementCSImpl();
		return expressionStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingBodyCS createMappingBodyCS() {
		MappingBodyCSImpl mappingBodyCS = new MappingBodyCSImpl();
		return mappingBodyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectExpCS createObjectExpCS() {
		ObjectExpCSImpl objectExpCS = new ObjectExpCSImpl();
		return objectExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingCallExpCS createMappingCallExpCS() {
		MappingCallExpCSImpl mappingCallExpCS = new MappingCallExpCSImpl();
		return mappingCallExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOperationCallExpCS createImperativeOperationCallExpCS() {
		ImperativeOperationCallExpCSImpl imperativeOperationCallExpCS = new ImperativeOperationCallExpCSImpl();
		return imperativeOperationCallExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindCS createDirectionKindCS() {
		DirectionKindCSImpl directionKindCS = new DirectionKindCSImpl();
		return directionKindCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolveExpCS createResolveExpCS() {
		ResolveExpCSImpl resolveExpCS = new ResolveExpCSImpl();
		return resolveExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolveInExpCS createResolveInExpCS() {
		ResolveInExpCSImpl resolveInExpCS = new ResolveInExpCSImpl();
		return resolveInExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTypeCS createModelTypeCS() {
		ModelTypeCSImpl modelTypeCS = new ModelTypeCSImpl();
		return modelTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageRefCS createPackageRefCS() {
		PackageRefCSImpl packageRefCS = new PackageRefCSImpl();
		return packageRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationHeaderCS createTransformationHeaderCS() {
		TransformationHeaderCSImpl transformationHeaderCS = new TransformationHeaderCSImpl();
		return transformationHeaderCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleKindCS createModuleKindCS() {
		ModuleKindCSImpl moduleKindCS = new ModuleKindCSImpl();
		return moduleKindCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleRefCS createModuleRefCS() {
		ModuleRefCSImpl moduleRefCS = new ModuleRefCSImpl();
		return moduleRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleUsageCS createModuleUsageCS() {
		ModuleUsageCSImpl moduleUsageCS = new ModuleUsageCSImpl();
		return moduleUsageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationRefineCS createTransformationRefineCS() {
		TransformationRefineCSImpl transformationRefineCS = new TransformationRefineCSImpl();
		return transformationRefineCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSpecCS createTypeSpecCS() {
		TypeSpecCSImpl typeSpecCS = new TypeSpecCSImpl();
		return typeSpecCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogExpCS createLogExpCS() {
		LogExpCSImpl logExpCS = new LogExpCSImpl();
		return logExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssertExpCS createAssertExpCS() {
		AssertExpCSImpl assertExpCS = new AssertExpCSImpl();
		return assertExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnExpCS createReturnExpCS() {
		ReturnExpCSImpl returnExpCS = new ReturnExpCSImpl();
		return returnExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingExtensionCS createMappingExtensionCS() {
		MappingExtensionCSImpl mappingExtensionCS = new MappingExtensionCSImpl();
		return mappingExtensionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstantiationExpCS createInstantiationExpCS() {
		InstantiationExpCSImpl instantiationExpCS = new InstantiationExpCSImpl();
		return instantiationExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListTypeCS createListTypeCS() {
		ListTypeCSImpl listTypeCS = new ListTypeCSImpl();
		return listTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListLiteralExpCS createListLiteralExpCS() {
		ListLiteralExpCSImpl listLiteralExpCS = new ListLiteralExpCSImpl();
		return listLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DictionaryTypeCS createDictionaryTypeCS() {
		DictionaryTypeCSImpl dictionaryTypeCS = new DictionaryTypeCSImpl();
		return dictionaryTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DictLiteralExpCS createDictLiteralExpCS() {
		DictLiteralExpCSImpl dictLiteralExpCS = new DictLiteralExpCSImpl();
		return dictLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DictLiteralPartCS createDictLiteralPartCS() {
		DictLiteralPartCSImpl dictLiteralPartCS = new DictLiteralPartCSImpl();
		return dictLiteralPartCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TagCS createTagCS() {
		TagCSImpl tagCS = new TagCSImpl();
		return tagCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitCS createUnitCS() {
		UnitCSImpl unitCS = new UnitCSImpl();
		return unitCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolveOpArgsExpCS createResolveOpArgsExpCS() {
		ResolveOpArgsExpCSImpl resolveOpArgsExpCS = new ResolveOpArgsExpCSImpl();
		return resolveOpArgsExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopedNameCS createScopedNameCS() {
		ScopedNameCSImpl scopedNameCS = new ScopedNameCSImpl();
		return scopedNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TryExpCS createTryExpCS() {
		TryExpCSImpl tryExpCS = new TryExpCSImpl();
		return tryExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CatchExpCS createCatchExpCS() {
		CatchExpCSImpl catchExpCS = new CatchExpCSImpl();
		return catchExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RaiseExpCS createRaiseExpCS() {
		RaiseExpCSImpl raiseExpCS = new RaiseExpCSImpl();
		return raiseExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindEnum createDirectionKindEnumFromString(EDataType eDataType, String initialValue) {
		DirectionKindEnum result = DirectionKindEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionKindEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleKindEnum createModuleKindEnumFromString(EDataType eDataType, String initialValue) {
		ModuleKindEnum result = ModuleKindEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertModuleKindEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportKindEnum createImportKindEnumFromString(EDataType eDataType, String initialValue) {
		ImportKindEnum result = ImportKindEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImportKindEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingExtensionKindCS createMappingExtensionKindCSFromString(EDataType eDataType, String initialValue) {
		MappingExtensionKindCS result = MappingExtensionKindCS.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMappingExtensionKindCSToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifierKindCS createQualifierKindCSFromString(EDataType eDataType, String initialValue) {
		QualifierKindCS result = QualifierKindCS.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQualifierKindCSToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSTPackage getCSTPackage() {
		return (CSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CSTPackage getPackage() {
		return CSTPackage.eINSTANCE;
	}

} //CSTFactoryImpl
