/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.*;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierKind;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.CompleteSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConfigPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConstructorCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ContextualPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.DirectionKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ExceptionCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.FeatureKey;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImperativeOperationCallExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImportKindEnum;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitOp;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitPartCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.LibraryImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.LocalPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingBodyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingCallExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingEndCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingExtensionKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingInitCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingQueryCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingRuleCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionsCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelKind;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindEnum;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleRefCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MultiplicityDefCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ObjectExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.OppositePropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PackageRefCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathElement2CS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathName2CS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PrimitiveTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSFactory;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToClassCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToLibraryCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QualifierKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.RenameCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveInExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveOpArgsExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ScopedNameCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.SimpleSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.StereotypeQualifierCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TagCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TopLevelCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationRefineCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypeSpecCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTOperationalCSFactoryImpl extends EFactoryImpl implements QVTOperationalCSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTOperationalCSFactory init() {
		try {
			QVTOperationalCSFactory theQVTOperationalCSFactory = (QVTOperationalCSFactory)EPackage.Registry.INSTANCE.getEFactory(QVTOperationalCSPackage.eNS_URI);
			if (theQVTOperationalCSFactory != null) {
				return theQVTOperationalCSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTOperationalCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTOperationalCSFactoryImpl() {
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
			case QVTOperationalCSPackage.PATH_NAME2_CS: return createPathName2CS();
			case QVTOperationalCSPackage.PATH_ELEMENT2_CS: return createPathElement2CS();
			case QVTOperationalCSPackage.TYPED_TYPE_REF2_CS: return createTypedTypeRef2CS();
			case QVTOperationalCSPackage.TOP_LEVEL_CS: return createTopLevelCS();
			case QVTOperationalCSPackage.QV_TO_CLASS_CS: return createQVToClassCS();
			case QVTOperationalCSPackage.QV_TO_IMPORT_CS: return createQVToImportCS();
			case QVTOperationalCSPackage.QV_TO_LIBRARY_CS: return createQVToLibraryCS();
			case QVTOperationalCSPackage.QV_TO_OPERATION_CS: return createQVToOperationCS();
			case QVTOperationalCSPackage.INIT_PART_CS: return createInitPartCS();
			case QVTOperationalCSPackage.METAMODEL_CS: return createMetamodelCS();
			case QVTOperationalCSPackage.PRIMITIVE_TYPE_CS: return createPrimitiveTypeCS();
			case QVTOperationalCSPackage.CLASSIFIER_PROPERTY_CS: return createClassifierPropertyCS();
			case QVTOperationalCSPackage.STEREOTYPE_QUALIFIER_CS: return createStereotypeQualifierCS();
			case QVTOperationalCSPackage.TAG_CS: return createTagCS();
			case QVTOperationalCSPackage.EXCEPTION_CS: return createExceptionCS();
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS: return createClassifierDefCS();
			case QVTOperationalCSPackage.CLASSIFIER_PROPERTY2_CS: return createClassifierProperty2CS();
			case QVTOperationalCSPackage.COMPLETE_SIGNATURE_CS: return createCompleteSignatureCS();
			case QVTOperationalCSPackage.CONFIG_PROPERTY_CS: return createConfigPropertyCS();
			case QVTOperationalCSPackage.CONSTRUCTOR_CS: return createConstructorCS();
			case QVTOperationalCSPackage.CONTEXTUAL_PROPERTY_CS: return createContextualPropertyCS();
			case QVTOperationalCSPackage.IMPERATIVE_OPERATION_CALL_EXP_CS: return createImperativeOperationCallExpCS();
			case QVTOperationalCSPackage.LIBRARY_IMPORT_CS: return createLibraryImportCS();
			case QVTOperationalCSPackage.LOCAL_PROPERTY_CS: return createLocalPropertyCS();
			case QVTOperationalCSPackage.MAPPING_BODY_CS: return createMappingBodyCS();
			case QVTOperationalCSPackage.MAPPING_CALL_EXP_CS: return createMappingCallExpCS();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS: return createMappingOperationCS();
			case QVTOperationalCSPackage.MAPPING_END_CS: return createMappingEndCS();
			case QVTOperationalCSPackage.MAPPING_INIT_CS: return createMappingInitCS();
			case QVTOperationalCSPackage.MAPPING_QUERY_CS: return createMappingQueryCS();
			case QVTOperationalCSPackage.MAPPING_RULE_CS: return createMappingRuleCS();
			case QVTOperationalCSPackage.MAPPING_SECTIONS_CS: return createMappingSectionsCS();
			case QVTOperationalCSPackage.MODULE_KIND_CS: return createModuleKindCS();
			case QVTOperationalCSPackage.MODULE_REF_CS: return createModuleRefCS();
			case QVTOperationalCSPackage.MODEL_TYPE_CS: return createModelTypeCS();
			case QVTOperationalCSPackage.MODEL_TYPE_REF_CS: return createModelTypeRefCS();
			case QVTOperationalCSPackage.MODULE_CS: return createModuleCS();
			case QVTOperationalCSPackage.MODULE_USAGE_CS: return createModuleUsageCS();
			case QVTOperationalCSPackage.MULTIPLICITY_DEF_CS: return createMultiplicityDefCS();
			case QVTOperationalCSPackage.OBJECT_EXP_CS: return createObjectExpCS();
			case QVTOperationalCSPackage.OPPOSITE_PROPERTY_CS: return createOppositePropertyCS();
			case QVTOperationalCSPackage.PARAMETER_DECLARATION_CS: return createParameterDeclarationCS();
			case QVTOperationalCSPackage.RENAME_CS: return createRenameCS();
			case QVTOperationalCSPackage.RESOLVE_OP_ARGS_EXP_CS: return createResolveOpArgsExpCS();
			case QVTOperationalCSPackage.PACKAGE_REF_CS: return createPackageRefCS();
			case QVTOperationalCSPackage.SCOPED_NAME_CS: return createScopedNameCS();
			case QVTOperationalCSPackage.SIMPLE_SIGNATURE_CS: return createSimpleSignatureCS();
			case QVTOperationalCSPackage.TRANSFORMATION_CS: return createTransformationCS();
			case QVTOperationalCSPackage.TRANSFORMATION_REFINE_CS: return createTransformationRefineCS();
			case QVTOperationalCSPackage.TYPE_SPEC_CS: return createTypeSpecCS();
			case QVTOperationalCSPackage.UNIT_CS: return createUnitCS();
			case QVTOperationalCSPackage.RESOLVE_EXP_CS: return createResolveExpCS();
			case QVTOperationalCSPackage.RESOLVE_IN_EXP_CS: return createResolveInExpCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
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
			case QVTOperationalCSPackage.CLASSIFIER_KIND:
				return createClassifierKindFromString(eDataType, initialValue);
			case QVTOperationalCSPackage.FEATURE_KEY:
				return createFeatureKeyFromString(eDataType, initialValue);
			case QVTOperationalCSPackage.INIT_OP:
				return createInitOpFromString(eDataType, initialValue);
			case QVTOperationalCSPackage.METAMODEL_KIND:
				return createMetamodelKindFromString(eDataType, initialValue);
			case QVTOperationalCSPackage.DIRECTION_KIND_CS:
				return createDirectionKindCSFromString(eDataType, initialValue);
			case QVTOperationalCSPackage.IMPORT_KIND_ENUM:
				return createImportKindEnumFromString(eDataType, initialValue);
			case QVTOperationalCSPackage.MAPPING_EXTENSION_KIND_CS:
				return createMappingExtensionKindCSFromString(eDataType, initialValue);
			case QVTOperationalCSPackage.MODULE_KIND_ENUM:
				return createModuleKindEnumFromString(eDataType, initialValue);
			case QVTOperationalCSPackage.QUALIFIER_KIND_CS:
				return createQualifierKindCSFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
			case QVTOperationalCSPackage.CLASSIFIER_KIND:
				return convertClassifierKindToString(eDataType, instanceValue);
			case QVTOperationalCSPackage.FEATURE_KEY:
				return convertFeatureKeyToString(eDataType, instanceValue);
			case QVTOperationalCSPackage.INIT_OP:
				return convertInitOpToString(eDataType, instanceValue);
			case QVTOperationalCSPackage.METAMODEL_KIND:
				return convertMetamodelKindToString(eDataType, instanceValue);
			case QVTOperationalCSPackage.DIRECTION_KIND_CS:
				return convertDirectionKindCSToString(eDataType, instanceValue);
			case QVTOperationalCSPackage.IMPORT_KIND_ENUM:
				return convertImportKindEnumToString(eDataType, instanceValue);
			case QVTOperationalCSPackage.MAPPING_EXTENSION_KIND_CS:
				return convertMappingExtensionKindCSToString(eDataType, instanceValue);
			case QVTOperationalCSPackage.MODULE_KIND_ENUM:
				return convertModuleKindEnumToString(eDataType, instanceValue);
			case QVTOperationalCSPackage.QUALIFIER_KIND_CS:
				return convertQualifierKindCSToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathName2CS createPathName2CS() {
		PathName2CSImpl pathName2CS = new PathName2CSImpl();
		return pathName2CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathElement2CS createPathElement2CS() {
		PathElement2CSImpl pathElement2CS = new PathElement2CSImpl();
		return pathElement2CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedTypeRef2CS createTypedTypeRef2CS() {
		TypedTypeRef2CSImpl typedTypeRef2CS = new TypedTypeRef2CSImpl();
		return typedTypeRef2CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopLevelCS createTopLevelCS() {
		TopLevelCSImpl topLevelCS = new TopLevelCSImpl();
		return topLevelCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVToClassCS createQVToClassCS() {
		QVToClassCSImpl qvToClassCS = new QVToClassCSImpl();
		return qvToClassCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVToImportCS createQVToImportCS() {
		QVToImportCSImpl qvToImportCS = new QVToImportCSImpl();
		return qvToImportCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVToLibraryCS createQVToLibraryCS() {
		QVToLibraryCSImpl qvToLibraryCS = new QVToLibraryCSImpl();
		return qvToLibraryCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVToOperationCS createQVToOperationCS() {
		QVToOperationCSImpl qvToOperationCS = new QVToOperationCSImpl();
		return qvToOperationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitPartCS createInitPartCS() {
		InitPartCSImpl initPartCS = new InitPartCSImpl();
		return initPartCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelCS createMetamodelCS() {
		MetamodelCSImpl metamodelCS = new MetamodelCSImpl();
		return metamodelCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeCS createPrimitiveTypeCS() {
		PrimitiveTypeCSImpl primitiveTypeCS = new PrimitiveTypeCSImpl();
		return primitiveTypeCS;
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
	public StereotypeQualifierCS createStereotypeQualifierCS() {
		StereotypeQualifierCSImpl stereotypeQualifierCS = new StereotypeQualifierCSImpl();
		return stereotypeQualifierCS;
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
	public ExceptionCS createExceptionCS() {
		ExceptionCSImpl exceptionCS = new ExceptionCSImpl();
		return exceptionCS;
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
	public ClassifierProperty2CS createClassifierProperty2CS() {
		ClassifierProperty2CSImpl classifierProperty2CS = new ClassifierProperty2CSImpl();
		return classifierProperty2CS;
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
	public ConfigPropertyCS createConfigPropertyCS() {
		ConfigPropertyCSImpl configPropertyCS = new ConfigPropertyCSImpl();
		return configPropertyCS;
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
	public ContextualPropertyCS createContextualPropertyCS() {
		ContextualPropertyCSImpl contextualPropertyCS = new ContextualPropertyCSImpl();
		return contextualPropertyCS;
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
	public LibraryImportCS createLibraryImportCS() {
		LibraryImportCSImpl libraryImportCS = new LibraryImportCSImpl();
		return libraryImportCS;
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
	public MappingBodyCS createMappingBodyCS() {
		MappingBodyCSImpl mappingBodyCS = new MappingBodyCSImpl();
		return mappingBodyCS;
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
	public MappingOperationCS createMappingOperationCS() {
		MappingOperationCSImpl mappingOperationCS = new MappingOperationCSImpl();
		return mappingOperationCS;
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
	public MappingInitCS createMappingInitCS() {
		MappingInitCSImpl mappingInitCS = new MappingInitCSImpl();
		return mappingInitCS;
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
	public MappingRuleCS createMappingRuleCS() {
		MappingRuleCSImpl mappingRuleCS = new MappingRuleCSImpl();
		return mappingRuleCS;
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
	public ModelTypeCS createModelTypeCS() {
		ModelTypeCSImpl modelTypeCS = new ModelTypeCSImpl();
		return modelTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTypeRefCS createModelTypeRefCS() {
		ModelTypeRefCSImpl modelTypeRefCS = new ModelTypeRefCSImpl();
		return modelTypeRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleCS createModuleCS() {
		ModuleCSImpl moduleCS = new ModuleCSImpl();
		return moduleCS;
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
	public MultiplicityDefCS createMultiplicityDefCS() {
		MultiplicityDefCSImpl multiplicityDefCS = new MultiplicityDefCSImpl();
		return multiplicityDefCS;
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
	public OppositePropertyCS createOppositePropertyCS() {
		OppositePropertyCSImpl oppositePropertyCS = new OppositePropertyCSImpl();
		return oppositePropertyCS;
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
	public RenameCS createRenameCS() {
		RenameCSImpl renameCS = new RenameCSImpl();
		return renameCS;
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
	public PackageRefCS createPackageRefCS() {
		PackageRefCSImpl packageRefCS = new PackageRefCSImpl();
		return packageRefCS;
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
	public SimpleSignatureCS createSimpleSignatureCS() {
		SimpleSignatureCSImpl simpleSignatureCS = new SimpleSignatureCSImpl();
		return simpleSignatureCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationCS createTransformationCS() {
		TransformationCSImpl transformationCS = new TransformationCSImpl();
		return transformationCS;
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
	public UnitCS createUnitCS() {
		UnitCSImpl unitCS = new UnitCSImpl();
		return unitCS;
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
	public ClassifierKind createClassifierKindFromString(EDataType eDataType, String initialValue) {
		ClassifierKind result = ClassifierKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassifierKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureKey createFeatureKeyFromString(EDataType eDataType, String initialValue) {
		FeatureKey result = FeatureKey.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeatureKeyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitOp createInitOpFromString(EDataType eDataType, String initialValue) {
		InitOp result = InitOp.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInitOpToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelKind createMetamodelKindFromString(EDataType eDataType, String initialValue) {
		MetamodelKind result = MetamodelKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMetamodelKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindCS createDirectionKindCSFromString(EDataType eDataType, String initialValue) {
		DirectionKindCS result = DirectionKindCS.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionKindCSToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportKindEnum createImportKindEnumFromString(EDataType eDataType, String initialValue) {
		ImportKindEnum result = ImportKindEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public ModuleKindEnum createModuleKindEnumFromString(EDataType eDataType, String initialValue) {
		ModuleKindEnum result = ModuleKindEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public QualifierKindCS createQualifierKindCSFromString(EDataType eDataType, String initialValue) {
		QualifierKindCS result = QualifierKindCS.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public QVTOperationalCSPackage getQVTOperationalCSPackage() {
		return (QVTOperationalCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTOperationalCSPackage getPackage() {
		return QVTOperationalCSPackage.eINSTANCE;
	}

} //QVTOperationalCSFactoryImpl
