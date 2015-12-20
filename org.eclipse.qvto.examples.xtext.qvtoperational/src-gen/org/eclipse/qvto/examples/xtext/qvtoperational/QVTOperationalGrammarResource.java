/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************
 * This code is 100% auto-generated
 * from: D:\git\org.eclipse.qvto-master\examples..\..\examples\org.eclipse.qvto.examples.xtext.qvtoperational\src-gen\org\eclipse\qvto\examples\xtext\qvtoperational\QVTOperational.xtextbin
 * by: org.eclipse.ocl.examples.build.xtend.generateGrammar.xtend
 *
 * Do not edit it.
 *******************************************************************************/
package	org.eclipse.qvto.examples.xtext.qvtoperational;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.base.utilities.AbstractGrammarResource;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * QVTOperationalGrammarResource provides a programmatically initialized org.eclipse.qvto.examples.xtext.qvtoperational.QVTOperational Grammar model avoiding
 * the speed limitations of the pre-Xtext 2.4 *.xmi models and the binary incompatibilities between differing *.xtextbin versions.
 * <p>
 * The grammar is immutable and is available as static INSTANCE and GRAMMAR fields.
 */
@SuppressWarnings({"nls", "unused"})
public class QVTOperationalGrammarResource extends AbstractGrammarResource
{
	private static final @NonNull Grammar G_QVTOperational = createGrammar("org.eclipse.qvto.examples.xtext.qvtoperational.QVTOperational");
	private static final @NonNull Grammar G_ImperativeOCL = createGrammar("org.eclipse.qvto.examples.xtext.imperativeocl.ImperativeOCL");
	private static final @NonNull Grammar G_EssentialOCL = createGrammar("org.eclipse.ocl.xtext.essentialocl.EssentialOCL");
	private static final @NonNull Grammar G_Base = createGrammar("org.eclipse.ocl.xtext.base.Base");

	/**
	 *	The shared immutable instance of the org.eclipse.qvto.examples.xtext.qvtoperational.QVTOperational Grammar resource.
	 */
	public static final @NonNull QVTOperationalGrammarResource INSTANCE = new QVTOperationalGrammarResource();

	/**
	 *	The shared immutable instance of the org.eclipse.qvto.examples.xtext.qvtoperational.QVTOperational Grammar model.
	 */
	public static final @SuppressWarnings("null")@NonNull Grammar GRAMMAR = (Grammar)INSTANCE.getContents().get(0);

	/**
	 *	The name of the language supported by this grammar.
	 */
	public static final @NonNull String LANGUAGE_NAME = "org.eclipse.qvto.examples.xtext.qvtoperational.QVTOperational";

	protected QVTOperationalGrammarResource() {
		super(URI.createURI(LANGUAGE_NAME));
		List<EObject> contents = getContents();
		contents.add(_QVTOperational.initGrammar());
		contents.add(_ImperativeOCL.initGrammar());
		contents.add(_EssentialOCL.initGrammar());
		contents.add(_Base.initGrammar());
	}

	/*
	 * This class should be bound to org.eclipse.xtext.service.GrammarProvider.
	 */ 
	@Singleton
	public static class GrammarProvider extends org.eclipse.xtext.service.GrammarProvider
	{
		@Inject
		public GrammarProvider(Provider<XtextResourceSet> resourceSetProvider) {
			super(LANGUAGE_NAME, resourceSetProvider);
		}

		@Override
		public Grammar getGrammar(Object requestor) {
			return QVTOperationalGrammarResource.GRAMMAR;
		}
	}
	
	private static class _QVTOperational
	{
		private static final @NonNull ReferencedMetamodel MM = createReferencedMetamodel(org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.eINSTANCE, null); // http://www.eclipse.org/qvt/pivot/1.0/QVTOperationalCS
		private static final @NonNull ReferencedMetamodel MM_base = createReferencedMetamodel(org.eclipse.ocl.xtext.basecs.BaseCSPackage.eINSTANCE, "base"); // http://www.eclipse.org/ocl/2015/BaseCS
		private static final @NonNull ReferencedMetamodel MM_ecore = createReferencedMetamodel(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, "ecore"); // http://www.eclipse.org/emf/2002/Ecore
		private static final @NonNull ReferencedMetamodel MM_essentialocl = createReferencedMetamodel(org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.eINSTANCE, "essentialocl"); // http://www.eclipse.org/ocl/2015/EssentialOCLCS
		private static final @NonNull ReferencedMetamodel MM_imperativeocl = createReferencedMetamodel(org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage.eINSTANCE, "imperativeocl"); // http://www.eclipse.org/qvt/pivot/1.0/ImperativeOCLCS
		
		private static final @NonNull EnumRule ER_DirectionKindCS = createEnumRule("DirectionKindCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.DIRECTION_KIND_CS));
		private static final @NonNull EnumRule ER_ImportKindEnum = createEnumRule("ImportKindEnum", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.IMPORT_KIND_ENUM));
		private static final @NonNull EnumRule ER_InitOp = createEnumRule("InitOp", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.INIT_OP));
		private static final @NonNull EnumRule ER_MetamodelKind = createEnumRule("MetamodelKind", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.METAMODEL_KIND));
		private static final @NonNull EnumRule ER_ModuleKindEnum = createEnumRule("ModuleKindEnum", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.MODULE_KIND_ENUM));
		
		private static void initEnumRules() {
			ER_DirectionKindCS.setAlternatives(createAlternatives(createEnumLiteral(createKeyword("in"), org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.DIRECTION_KIND_CS.getEEnumLiteral("in")), createEnumLiteral(createKeyword("out"), org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.DIRECTION_KIND_CS.getEEnumLiteral("out")), createEnumLiteral(createKeyword("inout"), org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.DIRECTION_KIND_CS.getEEnumLiteral("inout"))));
			ER_ImportKindEnum.setAlternatives(createAlternatives(createEnumLiteral(createKeyword("access"), org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.IMPORT_KIND_ENUM.getEEnumLiteral("access")), createEnumLiteral(createKeyword("extends"), org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.IMPORT_KIND_ENUM.getEEnumLiteral("extension"))));
			ER_InitOp.setAlternatives(createAlternatives(createEnumLiteral(createKeyword("="), org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.INIT_OP.getEEnumLiteral("EQUALS")), createEnumLiteral(createKeyword(":="), org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.INIT_OP.getEEnumLiteral("COLON_EQUALS")), createEnumLiteral(createKeyword("::="), org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.INIT_OP.getEEnumLiteral("COLON_COLON_EQUALS"))));
			ER_MetamodelKind.setAlternatives(createAlternatives(createEnumLiteral(createKeyword("metamodel"), org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.METAMODEL_KIND.getEEnumLiteral("METAMODEL")), createEnumLiteral(createKeyword("package"), org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.METAMODEL_KIND.getEEnumLiteral("PACKAGE"))));
			ER_ModuleKindEnum.setAlternatives(createAlternatives(createEnumLiteral(createKeyword("library"), org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.MODULE_KIND_ENUM.getEEnumLiteral("library")), createEnumLiteral(createKeyword("transformation"), org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.MODULE_KIND_ENUM.getEEnumLiteral("transformation"))));
		}
		
		private static final @NonNull ParserRule PR_ClassCS = createParserRule("ClassCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.CLASS_CS));
		private static final @NonNull ParserRule PR_ClassifierOperationCS = createParserRule("ClassifierOperationCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.QV_TO_OPERATION_CS));
		private static final @NonNull ParserRule PR_ClassifierPropertyCS = createParserRule("ClassifierPropertyCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.CLASSIFIER_PROPERTY_CS));
		private static final @NonNull ParserRule PR_DataTypeCS = createParserRule("DataTypeCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.DATA_TYPE_CS));
		private static final @NonNull ParserRule PR_EnumerationCS = createParserRule("EnumerationCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.ENUMERATION_CS));
		private static final @NonNull ParserRule PR_EnumerationLiteralCS = createParserRule("EnumerationLiteralCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.ENUMERATION_LITERAL_CS));
		private static final @NonNull ParserRule PR_ExceptionCS = createParserRule("ExceptionCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.STRUCTURED_CLASS_CS));
		private static final @NonNull ParserRule PR_FeatureQualifier = createParserRule("FeatureQualifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_ImportCS = createParserRule("ImportCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.QV_TO_IMPORT_CS));
		private static final @NonNull ParserRule PR_InitPartCS = createParserRule("InitPartCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.INIT_PART_CS));
		private static final @NonNull ParserRule PR_LibraryCS = createParserRule("LibraryCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.QV_TO_LIBRARY_CS));
		private static final @NonNull ParserRule PR_LibraryDeclCS = createParserRule("LibraryDeclCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.QV_TO_LIBRARY_CS));
		private static final @NonNull ParserRule PR_LibraryDefCS = createParserRule("LibraryDefCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.QV_TO_LIBRARY_CS));
		private static final @NonNull ParserRule PR_LibraryHeaderCS = createParserRule("LibraryHeaderCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.QV_TO_LIBRARY_CS));
		private static final @NonNull ParserRule PR_LibraryQualifier = createParserRule("LibraryQualifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_MappingDeclarationCS = createParserRule("MappingDeclarationCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.MAPPING_OPERATION_CS));
		private static final @NonNull ParserRule PR_MappingDefinitionCS = createParserRule("MappingDefinitionCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.MAPPING_OPERATION_CS));
		private static final @NonNull ParserRule PR_MappingOperationCS = createParserRule("MappingOperationCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.MAPPING_OPERATION_CS));
		private static final @NonNull ParserRule PR_MappingOperationHeaderCS = createParserRule("MappingOperationHeaderCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.MAPPING_OPERATION_CS));
		private static final @NonNull ParserRule PR_MetamodelCS = createParserRule("MetamodelCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.METAMODEL_CS));
		private static final @NonNull ParserRule PR_ModelTypeCS = createParserRule("ModelTypeCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.MODEL_TYPE_CS));
		private static final @NonNull ParserRule PR_ModelTypeRefCS = createParserRule("ModelTypeRefCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.MODEL_TYPE_REF_CS));
		private static final @NonNull ParserRule PR_ModuleOperationCS = createParserRule("ModuleOperationCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.OPERATION_CS));
		private static final @NonNull ParserRule PR_ModulePropertyCS = createParserRule("ModulePropertyCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS));
		private static final @NonNull ParserRule PR_ModuleRefCS = createParserRule("ModuleRefCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.MODULE_REF_CS));
		private static final @NonNull ParserRule PR_ModuleUsageCS = createParserRule("ModuleUsageCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.MODULE_USAGE_CS));
		private static final @NonNull ParserRule PR_MultiplicityCS = createParserRule("MultiplicityCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS));
		private static final @NonNull ParserRule PR_OperationQualifier = createParserRule("OperationQualifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_PackageRefCS = createParserRule("PackageRefCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.PACKAGE_REF_CS));
		private static final @NonNull ParserRule PR_ParameterCS = createParserRule("ParameterCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PARAMETER_CS));
		private static final @NonNull ParserRule PR_ParameterDeclarationCS = createParserRule("ParameterDeclarationCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.PARAMETER_DECLARATION_CS));
		private static final @NonNull ParserRule PR_PathElement2CS = createParserRule("PathElement2CS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.PATH_ELEMENT2_CS));
		private static final @NonNull ParserRule PR_PathName2CS = createParserRule("PathName2CS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.PATH_NAME2_CS));
		private static final @NonNull ParserRule PR_QVToClassCS = createParserRule("QVToClassCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.QV_TO_CLASS_CS));
		private static final @NonNull ParserRule PR_StereotypeQualifierCS = createParserRule("StereotypeQualifierCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.STEREOTYPE_QUALIFIER_CS));
		private static final @NonNull ParserRule PR_TagCS = createParserRule("TagCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.TAG_CS));
		private static final @NonNull ParserRule PR_TopLevelCS = createParserRule("TopLevelCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.TOP_LEVEL_CS));
		private static final @NonNull ParserRule PR_TransformationCS = createParserRule("TransformationCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.TRANSFORMATION_CS));
		private static final @NonNull ParserRule PR_TransformationDeclCS = createParserRule("TransformationDeclCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.TRANSFORMATION_CS));
		private static final @NonNull ParserRule PR_TransformationDefCS = createParserRule("TransformationDefCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.TRANSFORMATION_CS));
		private static final @NonNull ParserRule PR_TransformationHeaderCS = createParserRule("TransformationHeaderCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.TRANSFORMATION_CS));
		private static final @NonNull ParserRule PR_TransformationQualifier = createParserRule("TransformationQualifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_TypeRef2CS = createParserRule("TypeRef2CS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPE_REF_CS));
		private static final @NonNull ParserRule PR_TypeSpecCS = createParserRule("TypeSpecCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.TYPE_SPEC_CS));
		private static final @NonNull ParserRule PR_TypedMultiplicityRef2CS = createParserRule("TypedMultiplicityRef2CS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypedRef2CS = createParserRule("TypedRef2CS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypedTypeRef2CS = createParserRule("TypedTypeRef2CS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.TYPED_TYPE_REF2_CS));
		private static final @NonNull ParserRule PR_UnitCS = createParserRule("UnitCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.UNIT_CS));
		private static final @NonNull ParserRule PR_UnitPackageCS = createParserRule("UnitPackageCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PACKAGE_CS));
		private static final @NonNull ParserRule PR_UnitTypeCS = createParserRule("UnitTypeCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPE_CS));
		
		private static void initParserRules() {
			PR_ClassCS.setAlternatives(createGroup(createAlternatives(createRuleCall(PR_DataTypeCS), createRuleCall(PR_ExceptionCS), createRuleCall(PR_QVToClassCS)), setCardinality("?", createKeyword(";"))));
			PR_ClassifierOperationCS.setAlternatives(createGroup(setCardinality("?", createAssignment("stereotypes", "=", createRuleCall(PR_StereotypeQualifierCS))), setCardinality("*", createAssignment("qualifiers", "+=", createRuleCall(PR_FeatureQualifier))), createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)), createKeyword("("), setCardinality("?", createGroup(createAssignment("ownedParameters", "+=", createRuleCall(PR_ParameterCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedParameters", "+=", createRuleCall(PR_ParameterCS)))))), createKeyword(")"), setCardinality("?", createGroup(createKeyword(":"), createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRef2CS))))));
			PR_ClassifierPropertyCS.setAlternatives(createGroup(setCardinality("?", createAssignment("stereotypes", "=", createRuleCall(PR_StereotypeQualifierCS))), setCardinality("*", createAssignment("qualifiers", "+=", createRuleCall(PR_FeatureQualifier))), createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)), createKeyword(":"), createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRef2CS)), setCardinality("?", createAssignment("default", "=", createRuleCall(_Base.TR_SINGLE_QUOTED_STRING))), setCardinality("?", createGroup(createKeyword("opposites"), setCardinality("?", createKeyword("~")), createAssignment("opposite", "=", createRuleCall(_Base.PR_Identifier))))));
			PR_DataTypeCS.setAlternatives(createGroup(createAlternatives(createKeyword("datatype"), createGroup(createAction(null, null, createTypeRef(MM, org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage.Literals.PRIMITIVE_TYPE_CS)), createKeyword("primitive"))), createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName))));
			PR_EnumerationCS.setAlternatives(createGroup(createKeyword("enum"), createAssignment("name", "=", createRuleCall(_Base.PR_Identifier)), createGroup(createKeyword("{"), createGroup(createAssignment("ownedLiterals", "+=", createRuleCall(PR_EnumerationLiteralCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedLiterals", "+=", createRuleCall(PR_EnumerationLiteralCS))))), createKeyword("}")), setCardinality("?", createKeyword(";"))));
			PR_EnumerationLiteralCS.setAlternatives(createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)));
			PR_ExceptionCS.setAlternatives(createGroup(createKeyword("exception"), createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)), setCardinality("?", createGroup(createKeyword("extends"), createGroup(createAssignment("ownedSuperTypes", "+=", createRuleCall(_Base.PR_TypedRefCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedSuperTypes", "+=", createRuleCall(_Base.PR_TypedRefCS)))))))));
			PR_FeatureQualifier.setAlternatives(createAlternatives(createKeyword("composes"), createKeyword("references"), createKeyword("readonly"), createKeyword("derived"), createKeyword("static")));
			PR_ImportCS.setAlternatives(createAlternatives(createGroup(createKeyword("import"), createAssignment("unit", "=", createRuleCall(PR_UnitCS)), createKeyword(";")), createGroup(createKeyword("from"), createAssignment("unit", "=", createRuleCall(PR_UnitCS)), createKeyword("import"), createAlternatives(createGroup(createAssignment("importedUnitElement", "+=", createRuleCall(_Base.PR_Identifier)), setCardinality("*", createGroup(createKeyword(","), createAssignment("importedUnitElement", "+=", createRuleCall(_Base.PR_Identifier))))), createAssignment("isAll", "?=", createKeyword("*"))), createKeyword(";"))));
			PR_InitPartCS.setAlternatives(createGroup(createAssignment("initOp", "=", createRuleCall(ER_InitOp)), createAssignment("expression", "=", createRuleCall(_EssentialOCL.PR_ExpCS))));
			PR_LibraryCS.setAlternatives(createAlternatives(createRuleCall(PR_LibraryDeclCS), createRuleCall(PR_LibraryDefCS)));
			PR_LibraryDeclCS.setAlternatives(createGroup(createRuleCall(PR_LibraryHeaderCS), createKeyword(";")));
			PR_LibraryDefCS.setAlternatives(createGroup(createRuleCall(PR_LibraryHeaderCS), createKeyword("{"), setCardinality("*", createAlternatives(createAssignment("ownedProperties", "+=", createRuleCall(PR_ModulePropertyCS)), createAssignment("ownedOperations", "+=", createRuleCall(PR_ModuleOperationCS)))), createKeyword("}"), setCardinality("?", createKeyword(";"))));
			PR_LibraryHeaderCS.setAlternatives(createGroup(setCardinality("*", createAssignment("qualifiers", "+=", createRuleCall(PR_LibraryQualifier))), createKeyword("library"), createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)), createKeyword("("), createAssignment("parameters", "+=", createRuleCall(PR_ModelTypeRefCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("parameters", "+=", createRuleCall(PR_ModelTypeRefCS)))), createKeyword(")"), setCardinality("*", createAssignment("moduleUsages", "+=", createRuleCall(PR_ModuleUsageCS)))));
			PR_LibraryQualifier.setAlternatives(createKeyword("blackbox"));
			PR_MappingDeclarationCS.setAlternatives(createGroup(createRuleCall(PR_MappingOperationHeaderCS), createKeyword(";")));
			PR_MappingDefinitionCS.setAlternatives(createGroup(createRuleCall(PR_MappingOperationHeaderCS), createKeyword("{"), createKeyword("}")));
			PR_MappingOperationCS.setAlternatives(createAlternatives(createRuleCall(PR_MappingDeclarationCS), createRuleCall(PR_MappingDefinitionCS)));
			PR_MappingOperationHeaderCS.setAlternatives(createGroup(setCardinality("*", createAssignment("qualifiers", "+=", createRuleCall(PR_OperationQualifier))), createKeyword("mapping"), setCardinality("?", createAssignment("direction", "=", createRuleCall(ER_DirectionKindCS))), createAssignment("scopedName", "=", createRuleCall(PR_PathName2CS)), createKeyword("("), setCardinality("?", createGroup(createAssignment("ownedParameters", "+=", createRuleCall(PR_ParameterDeclarationCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedParameters", "+=", createRuleCall(PR_ParameterDeclarationCS)))))), createKeyword(")"), setCardinality("?", createGroup(createKeyword(":"), createAssignment("results", "+=", createRuleCall(PR_ParameterDeclarationCS)), createGroup(createKeyword(","), createAssignment("results", "+=", createRuleCall(PR_ParameterDeclarationCS))))), createUnorderedGroup(setCardinality("?", createGroup(createKeyword("inherits"), createAssignment("inherits", "+=", createRuleCall(PR_PathName2CS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("inherits", "+=", createRuleCall(PR_PathName2CS)))))), setCardinality("?", createGroup(createKeyword("merges"), createAssignment("merges", "+=", createRuleCall(PR_PathName2CS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("merges", "+=", createRuleCall(PR_PathName2CS)))))), setCardinality("?", createGroup(createKeyword("disjuncts"), createAssignment("disjuncts", "+=", createRuleCall(PR_PathName2CS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("disjuncts", "+=", createRuleCall(PR_PathName2CS)))))), setCardinality("?", createGroup(createKeyword("refines"), createAssignment("refines", "=", createRuleCall(PR_PathName2CS))))), setCardinality("?", createGroup(createKeyword("when"), createAssignment("when", "=", createRuleCall(_ImperativeOCL.PR_BlockExpCS)))), setCardinality("?", createGroup(createKeyword("where"), createAssignment("where", "=", createRuleCall(_ImperativeOCL.PR_BlockExpCS))))));
			PR_MetamodelCS.setAlternatives(createGroup(createAssignment("metamodelKind", "=", createRuleCall(ER_MetamodelKind)), createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)), createKeyword("{"), setCardinality("*", createAlternatives(createAssignment("ownedClasses", "+=", createRuleCall(PR_ClassCS)), createAssignment("ownedClasses", "+=", createRuleCall(PR_EnumerationCS)), createAssignment("ownedAnnotations", "+=", createRuleCall(PR_TagCS)))), createKeyword("}"), setCardinality("?", createKeyword(";"))));
			PR_ModelTypeCS.setAlternatives(createGroup(createKeyword("modeltype"), createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)), setCardinality("?", createAssignment("complianceKind", "=", createRuleCall(_ImperativeOCL.PR_StringLiteral))), createKeyword("uses"), createAssignment("packageRefs", "+=", createRuleCall(PR_PackageRefCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("packageRefs", "+=", createRuleCall(PR_PackageRefCS)))), setCardinality("?", createGroup(createKeyword("where"), createKeyword("{"), createKeyword("}"))), createKeyword(";")));
			PR_ModelTypeRefCS.setAlternatives(createAssignment("ownedType", "=", createRuleCall(PR_TypedTypeRef2CS)));
			PR_ModuleOperationCS.setAlternatives(createRuleCall(PR_MappingOperationCS));
			PR_ModulePropertyCS.setAlternatives(createRuleCall(PR_ClassifierPropertyCS));
			PR_ModuleRefCS.setAlternatives(createGroup(createAssignment("modulePath", "=", createRuleCall(PR_PathName2CS)), setCardinality("?", createGroup(createKeyword("("), createAssignment("parameters", "+=", createRuleCall(PR_ParameterDeclarationCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("parameters", "+=", createRuleCall(PR_ParameterDeclarationCS)))), createKeyword(")")))));
			PR_ModuleUsageCS.setAlternatives(createGroup(createAssignment("importKind", "=", createRuleCall(ER_ImportKindEnum)), setCardinality("?", createAssignment("moduleKind", "=", createRuleCall(ER_ModuleKindEnum))), createAssignment("moduleRefs", "+=", createRuleCall(PR_ModuleRefCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("moduleRefs", "+=", createRuleCall(PR_ModuleRefCS))))));
			PR_MultiplicityCS.setAlternatives(createGroup(createKeyword("["), setCardinality("?", createGroup(createAssignment("lowerBound", "=", createRuleCall(_Base.PR_LOWER)), createKeyword("..."))), createAssignment("upperBound", "=", createRuleCall(_Base.PR_UPPER)), createKeyword("]")));
			PR_OperationQualifier.setAlternatives(createKeyword("blackbox"));
			PR_PackageRefCS.setAlternatives(createAlternatives(createAssignment("uri", "=", createRuleCall(_EssentialOCL.PR_StringLiteralExpCS)), createGroup(createAssignment("packagePath", "=", createRuleCall(PR_PathName2CS)), createKeyword("("), createAssignment("uri", "=", createRuleCall(_EssentialOCL.PR_StringLiteralExpCS)), createKeyword(")"))));
			PR_ParameterCS.setAlternatives(createGroup(createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)), setCardinality("?", createGroup(createKeyword(":"), createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRef2CS))))));
			PR_ParameterDeclarationCS.setAlternatives(createGroup(setCardinality("?", createAssignment("direction", "=", createRuleCall(ER_DirectionKindCS))), createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)), setCardinality("?", createGroup(createKeyword(":"), createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRef2CS)))), setCardinality("?", createAssignment("initPart", "=", createRuleCall(PR_InitPartCS)))));
			PR_PathElement2CS.setAlternatives(createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)));
			PR_PathName2CS.setAlternatives(createGroup(createAssignment("ownedPathElements2", "+=", createRuleCall(PR_PathElement2CS)), setCardinality("*", createGroup(createKeyword("::"), createAssignment("ownedPathElements2", "+=", createRuleCall(PR_PathElement2CS))))));
			PR_QVToClassCS.setAlternatives(createGroup(setCardinality("?", createAssignment("intermediate", "?=", createKeyword("intermediate"))), createKeyword("class"), createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)), setCardinality("?", createGroup(createKeyword("extends"), createGroup(createAssignment("ownedSuperTypes", "+=", createRuleCall(_Base.PR_TypedRefCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedSuperTypes", "+=", createRuleCall(_Base.PR_TypedRefCS))))))), setCardinality("?", createGroup(createKeyword("{"), setCardinality("+", createGroup(createAlternatives(createAssignment("ownedProperties", "+=", createRuleCall(PR_ClassifierPropertyCS)), createAssignment("ownedOperations", "+=", createRuleCall(PR_ClassifierOperationCS)), createAssignment("ownedAnnotations", "+=", createRuleCall(PR_TagCS))), createKeyword(";"))), createKeyword("}")))));
			PR_StereotypeQualifierCS.setAlternatives(createGroup(createKeyword("<<"), createGroup(createAssignment("stereotype", "+=", createRuleCall(_Base.PR_Identifier)), setCardinality("*", createGroup(createKeyword(","), createAssignment("stereotype", "+=", createRuleCall(_Base.PR_Identifier))))), createKeyword(">>")));
			PR_TagCS.setAlternatives(createGroup(createKeyword("tag"), setCardinality("?", createAssignment("name", "=", createAlternatives(createRuleCall(_EssentialOCL.PR_UnrestrictedName), createRuleCall(_Base.TR_SINGLE_QUOTED_STRING)))), createAssignment("elementPath", "=", createRuleCall(PR_PathName2CS)), setCardinality("?", createGroup(createKeyword("="), createAssignment("expression", "=", createRuleCall(_EssentialOCL.PR_ExpCS)))), createKeyword(";")));
			PR_TopLevelCS.setAlternatives(createGroup(setCardinality("*", createAssignment("ownedImports", "+=", createRuleCall(PR_ImportCS))), setCardinality("*", createAlternatives(createAssignment("ownedPackages", "+=", createRuleCall(PR_UnitPackageCS)), createAssignment("ownedTypes", "+=", createRuleCall(PR_UnitTypeCS))))));
			PR_TransformationCS.setAlternatives(createAlternatives(createRuleCall(PR_TransformationDeclCS), createRuleCall(PR_TransformationDefCS)));
			PR_TransformationDeclCS.setAlternatives(createGroup(createRuleCall(PR_TransformationHeaderCS), createKeyword(";")));
			PR_TransformationDefCS.setAlternatives(createGroup(createRuleCall(PR_TransformationHeaderCS), createKeyword("{"), setCardinality("*", createAlternatives(createAssignment("ownedProperties", "+=", createRuleCall(PR_ModulePropertyCS)), createAssignment("ownedOperations", "+=", createRuleCall(PR_ModuleOperationCS)))), createKeyword("}"), setCardinality("?", createKeyword(";"))));
			PR_TransformationHeaderCS.setAlternatives(createGroup(setCardinality("*", createAssignment("qualifiers", "+=", createRuleCall(PR_TransformationQualifier))), createKeyword("transformation"), createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)), createKeyword("("), createAssignment("parameters", "+=", createRuleCall(PR_ParameterDeclarationCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("parameters", "+=", createRuleCall(PR_ParameterDeclarationCS)))), createKeyword(")"), setCardinality("*", createAssignment("moduleUsages", "+=", createRuleCall(PR_ModuleUsageCS))), setCardinality("?", createGroup(createKeyword("refines"), createAssignment("refines", "=", createRuleCall(PR_ModuleRefCS))))));
			PR_TransformationQualifier.setAlternatives(createAlternatives(createKeyword("blackbox"), createKeyword("abstract"), createKeyword("static")));
			PR_TypeRef2CS.setAlternatives(createRuleCall(PR_TypedRef2CS));
			PR_TypeSpecCS.setAlternatives(createGroup(createAssignment("ownedType", "=", createRuleCall(_Base.PR_TypedRefCS)), setCardinality("?", createGroup(createKeyword("@"), createAssignment("extentLocation", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName))))));
			PR_TypedMultiplicityRef2CS.setAlternatives(createGroup(createRuleCall(PR_TypedRef2CS), setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(PR_MultiplicityCS)))));
			PR_TypedRef2CS.setAlternatives(createAlternatives(createRuleCall(_ImperativeOCL.PR_TypeLiteralCS), createRuleCall(PR_TypedTypeRef2CS)));
			PR_TypedTypeRef2CS.setAlternatives(createGroup(createAssignment("ownedPathName", "=", createRuleCall(PR_PathName2CS)), setCardinality("?", createGroup(createKeyword("("), createAssignment("ownedBinding", "=", createRuleCall(_Base.PR_TemplateBindingCS)), createKeyword(")")))));
			PR_UnitCS.setAlternatives(createGroup(createAssignment("segment", "+=", createRuleCall(_Base.PR_Identifier)), setCardinality("*", createGroup(createKeyword("."), createAssignment("segment", "+=", createRuleCall(_Base.PR_Identifier))))));
			PR_UnitPackageCS.setAlternatives(createRuleCall(PR_MetamodelCS));
			PR_UnitTypeCS.setAlternatives(createAlternatives(createRuleCall(PR_ModelTypeCS), createRuleCall(PR_TransformationCS), createRuleCall(PR_LibraryCS)));
		}
		
		private static @NonNull Grammar initGrammar() {
			initEnumRules();
			initParserRules();
			Grammar grammar = G_QVTOperational;
			{
				List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
				metamodelDeclarations.add(MM);
				metamodelDeclarations.add(MM_ecore);
				metamodelDeclarations.add(MM_base);
				metamodelDeclarations.add(MM_essentialocl);
				metamodelDeclarations.add(MM_imperativeocl);
			}
			{
				List<AbstractRule> rules = grammar.getRules();
				rules.add(PR_TopLevelCS);
				rules.add(ER_InitOp);
				rules.add(ER_MetamodelKind);
				rules.add(ER_DirectionKindCS);
				rules.add(ER_ImportKindEnum);
				rules.add(ER_ModuleKindEnum);
				rules.add(PR_TransformationQualifier);
				rules.add(PR_LibraryQualifier);
				rules.add(PR_FeatureQualifier);
				rules.add(PR_OperationQualifier);
				rules.add(PR_PathName2CS);
				rules.add(PR_PathElement2CS);
				rules.add(PR_ImportCS);
				rules.add(PR_UnitCS);
				rules.add(PR_UnitPackageCS);
				rules.add(PR_UnitTypeCS);
				rules.add(PR_ParameterCS);
				rules.add(PR_ParameterDeclarationCS);
				rules.add(PR_InitPartCS);
				rules.add(PR_TypeSpecCS);
				rules.add(PR_MetamodelCS);
				rules.add(PR_ClassCS);
				rules.add(PR_DataTypeCS);
				rules.add(PR_ExceptionCS);
				rules.add(PR_QVToClassCS);
				rules.add(PR_TypedMultiplicityRef2CS);
				rules.add(PR_TypeRef2CS);
				rules.add(PR_TypedRef2CS);
				rules.add(PR_TypedTypeRef2CS);
				rules.add(PR_ClassifierPropertyCS);
				rules.add(PR_StereotypeQualifierCS);
				rules.add(PR_MultiplicityCS);
				rules.add(PR_ClassifierOperationCS);
				rules.add(PR_EnumerationCS);
				rules.add(PR_EnumerationLiteralCS);
				rules.add(PR_TagCS);
				rules.add(PR_ModuleRefCS);
				rules.add(PR_ModuleUsageCS);
				rules.add(PR_TransformationCS);
				rules.add(PR_TransformationDeclCS);
				rules.add(PR_TransformationDefCS);
				rules.add(PR_TransformationHeaderCS);
				rules.add(PR_LibraryCS);
				rules.add(PR_LibraryDeclCS);
				rules.add(PR_LibraryDefCS);
				rules.add(PR_LibraryHeaderCS);
				rules.add(PR_ModelTypeCS);
				rules.add(PR_ModelTypeRefCS);
				rules.add(PR_PackageRefCS);
				rules.add(PR_ModulePropertyCS);
				rules.add(PR_ModuleOperationCS);
				rules.add(PR_MappingOperationCS);
				rules.add(PR_MappingDeclarationCS);
				rules.add(PR_MappingDefinitionCS);
				rules.add(PR_MappingOperationHeaderCS);
			}
			{
				List<Grammar> usedGrammars = grammar.getUsedGrammars();
				usedGrammars.add(G_ImperativeOCL);
			}
			return grammar;
		}
	}
	
	private static class _ImperativeOCL
	{
		private static final @NonNull ReferencedMetamodel MM = createReferencedMetamodel(org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage.eINSTANCE, null); // http://www.eclipse.org/qvt/pivot/1.0/ImperativeOCLCS
		private static final @NonNull ReferencedMetamodel MM_base = createReferencedMetamodel(org.eclipse.ocl.xtext.basecs.BaseCSPackage.eINSTANCE, "base"); // http://www.eclipse.org/ocl/2015/BaseCS
		private static final @NonNull ReferencedMetamodel MM_ecore = createReferencedMetamodel(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, "ecore"); // http://www.eclipse.org/emf/2002/Ecore
		private static final @NonNull ReferencedMetamodel MM_essentialocl = createReferencedMetamodel(org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.eINSTANCE, "essentialocl"); // http://www.eclipse.org/ocl/2015/EssentialOCLCS
		
		private static final @NonNull TerminalRule TR_ACCESS_OP = createTerminalRule("ACCESS_OP", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ASSIGN_OP = createTerminalRule("ASSIGN_OP", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_CMP_OP = createTerminalRule("CMP_OP", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_MULTI_ITERATOR_OP = createTerminalRule("MULTI_ITERATOR_OP", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_MULT_OP = createTerminalRule("MULT_OP", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_RESOLVE_IN_KIND = createTerminalRule("RESOLVE_IN_KIND", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_RESOLVE_KIND = createTerminalRule("RESOLVE_KIND", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_SIMPLE_ITERATOR_OP = createTerminalRule("SIMPLE_ITERATOR_OP", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_UNARY_OP = createTerminalRule("UNARY_OP", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		
		private static void initTerminalRules() {
			TR_ACCESS_OP.setAlternatives(createAlternatives(createKeyword("."), createKeyword("->"), createKeyword("!->")));
			TR_ASSIGN_OP.setAlternatives(createAlternatives(createKeyword(":="), createKeyword("::="), createKeyword("+="), createKeyword("-=")));
			TR_CMP_OP.setAlternatives(createAlternatives(createKeyword("="), createKeyword("=="), createKeyword("<>"), createKeyword("<"), createKeyword(">"), createKeyword("<="), createKeyword(">=")));
			TR_MULTI_ITERATOR_OP.setAlternatives(createKeyword("forAll"));
			TR_MULT_OP.setAlternatives(createAlternatives(createKeyword("*"), createKeyword("/"), createKeyword("%")));
			TR_RESOLVE_IN_KIND.setAlternatives(createAlternatives(createKeyword("resolveIn"), createKeyword("resolveoneIn"), createKeyword("invresolveIn"), createKeyword("invresolveoneIn")));
			TR_RESOLVE_KIND.setAlternatives(createAlternatives(createKeyword("resolve"), createKeyword("resolveone"), createKeyword("invresolve"), createKeyword("invresolveone")));
			TR_SIMPLE_ITERATOR_OP.setAlternatives(createAlternatives(createKeyword("reject"), createKeyword("select"), createKeyword("collect"), createKeyword("exists"), createKeyword("one"), createKeyword("any"), createKeyword("isUnique"), createKeyword("collectNested"), createKeyword("sortedBy"), createKeyword("xselect"), createKeyword("xcollect"), createKeyword("selectOne"), createKeyword("collectOne"), createKeyword("collectselect"), createKeyword("collectselectOne")));
			TR_UNARY_OP.setAlternatives(createAlternatives(createKeyword("-"), createKeyword("not"), createKeyword("#"), createKeyword("##"), createKeyword("*")));
		}
		
		private static final @NonNull ParserRule PR_BlockExpCS = createParserRule("BlockExpCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage.Literals.BLOCK_EXP_CS));
		private static final @NonNull ParserRule PR_DictLiteralExpCS = createParserRule("DictLiteralExpCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage.Literals.DICT_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_DictLiteralPartCS = createParserRule("DictLiteralPartCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage.Literals.DICT_LITERAL_PART_CS));
		private static final @NonNull ParserRule PR_DictTypeCS = createParserRule("DictTypeCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage.Literals.DICT_TYPE_CS));
		private static final @NonNull ParserRule PR_GrammmarCS = createParserRule("GrammmarCS", createTypeRef(MM_essentialocl, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_ImperativeOCLExpCS = createParserRule("ImperativeOCLExpCS", createTypeRef(MM_essentialocl, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_ImperativeOCLInfixOperator = createParserRule("ImperativeOCLInfixOperator", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_ImperativeOCLNavigationOperator = createParserRule("ImperativeOCLNavigationOperator", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_ImperativeOCLPrefixOperator = createParserRule("ImperativeOCLPrefixOperator", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_ImperativeOCLReservedKeyword = createParserRule("ImperativeOCLReservedKeyword", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_ListLiteralExpCS = createParserRule("ListLiteralExpCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage.Literals.LIST_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_ListTypeCS = createParserRule("ListTypeCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage.Literals.LIST_TYPE_CS));
		private static final @NonNull ParserRule PR_PrimaryExpCS = createParserRule("PrimaryExpCS", createTypeRef(MM_essentialocl, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_ReturnExpCS = createParserRule("ReturnExpCS", createTypeRef(MM, org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage.Literals.RETURN_EXP_CS));
		private static final @NonNull ParserRule PR_StringLiteral = createParserRule("StringLiteral", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_TypeLiteralCS = createParserRule("TypeLiteralCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		
		private static void initParserRules() {
			PR_BlockExpCS.setAlternatives(createGroup(createKeyword("{"), createAssignment("expressions", "+=", createRuleCall(_EssentialOCL.PR_ExpCS)), createKeyword("}")));
			PR_DictLiteralExpCS.setAlternatives(createGroup(createKeyword("Dict"), createKeyword("{"), createAction(null, null, createTypeRef(MM, org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage.Literals.DICT_LITERAL_EXP_CS)), setCardinality("?", createGroup(createAssignment("ownedParts", "+=", createRuleCall(PR_DictLiteralPartCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedParts", "+=", createRuleCall(PR_DictLiteralPartCS)))))), createKeyword("}")));
			PR_DictLiteralPartCS.setAlternatives(createGroup(createAssignment("key", "=", createRuleCall(_EssentialOCL.PR_PrimitiveLiteralExpCS)), createKeyword("="), createAssignment("value", "=", createRuleCall(_EssentialOCL.PR_ExpCS))));
			PR_DictTypeCS.setAlternatives(createGroup(createKeyword("Dict"), createKeyword("("), createAssignment("keyType", "=", createRuleCall(_EssentialOCL.PR_TypeExpCS)), createKeyword(","), createAssignment("valueType", "=", createRuleCall(_EssentialOCL.PR_TypeExpCS)), createKeyword(")")));
			PR_GrammmarCS.setAlternatives(createRuleCall(PR_ImperativeOCLExpCS));
			PR_ImperativeOCLExpCS.setAlternatives(createRuleCall(_EssentialOCL.PR_ExpCS));
			PR_ImperativeOCLInfixOperator.setAlternatives(createAlternatives(createRuleCall(TR_ASSIGN_OP), createKeyword("default"), createKeyword("==")));
			PR_ImperativeOCLNavigationOperator.setAlternatives(createKeyword("!->"));
			PR_ImperativeOCLPrefixOperator.setAlternatives(createAlternatives(createKeyword("#"), createKeyword("##"), createKeyword("*")));
			PR_ImperativeOCLReservedKeyword.setAlternatives(createAlternatives(createKeyword("default"), createKeyword("elif"), createRuleCall(TR_RESOLVE_KIND), createRuleCall(TR_RESOLVE_IN_KIND)));
			PR_ListLiteralExpCS.setAlternatives(createGroup(createKeyword("List"), createKeyword("{"), createAction(null, null, createTypeRef(MM, org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage.Literals.LIST_LITERAL_EXP_CS)), setCardinality("?", createGroup(createAssignment("ownedParts", "+=", createRuleCall(_EssentialOCL.PR_CollectionLiteralPartCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedParts", "+=", createRuleCall(_EssentialOCL.PR_CollectionLiteralPartCS)))))), createKeyword("}")));
			PR_ListTypeCS.setAlternatives(createGroup(createKeyword("List"), createKeyword("("), createAssignment("type", "=", createRuleCall(_EssentialOCL.PR_TypeExpCS)), createKeyword(")")));
			PR_PrimaryExpCS.setAlternatives(createAlternatives(createRuleCall(_EssentialOCL.PR_NestedExpCS), createRuleCall(_EssentialOCL.PR_IfExpCS), createRuleCall(_EssentialOCL.PR_SelfExpCS), createRuleCall(_EssentialOCL.PR_PrimitiveLiteralExpCS), createRuleCall(_EssentialOCL.PR_TupleLiteralExpCS), createRuleCall(_EssentialOCL.PR_MapLiteralExpCS), createRuleCall(_EssentialOCL.PR_CollectionLiteralExpCS), createRuleCall(_EssentialOCL.PR_LambdaLiteralExpCS), createRuleCall(PR_ListLiteralExpCS), createRuleCall(PR_DictLiteralExpCS), createRuleCall(_EssentialOCL.PR_TypeLiteralExpCS), createRuleCall(PR_ReturnExpCS), createRuleCall(_EssentialOCL.PR_NameExpCS)));
			PR_ReturnExpCS.setAlternatives(createGroup(createKeyword("return"), createAction(null, null, createTypeRef(MM, org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage.Literals.RETURN_EXP_CS)), setCardinality("?", createAssignment("value", "=", createRuleCall(_EssentialOCL.PR_ExpCS)))));
			PR_StringLiteral.setAlternatives(createAlternatives(createRuleCall(_Base.TR_SINGLE_QUOTED_STRING), createRuleCall(_Base.TR_DOUBLE_QUOTED_STRING)));
			PR_TypeLiteralCS.setAlternatives(createAlternatives(createRuleCall(_EssentialOCL.PR_PrimitiveTypeCS), createRuleCall(_EssentialOCL.PR_CollectionTypeCS), createRuleCall(_EssentialOCL.PR_MapTypeCS), createRuleCall(_EssentialOCL.PR_TupleTypeCS), createRuleCall(PR_ListTypeCS), createRuleCall(PR_DictTypeCS)));
		}
		
		private static @NonNull Grammar initGrammar() {
			initTerminalRules();
			initParserRules();
			Grammar grammar = G_ImperativeOCL;
			{
				List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
				metamodelDeclarations.add(MM);
				metamodelDeclarations.add(MM_ecore);
				metamodelDeclarations.add(MM_base);
				metamodelDeclarations.add(MM_essentialocl);
			}
			{
				List<AbstractRule> rules = grammar.getRules();
				rules.add(PR_GrammmarCS);
				rules.add(TR_ACCESS_OP);
				rules.add(TR_ASSIGN_OP);
				rules.add(TR_CMP_OP);
				rules.add(TR_MULT_OP);
				rules.add(TR_MULTI_ITERATOR_OP);
				rules.add(TR_RESOLVE_IN_KIND);
				rules.add(TR_RESOLVE_KIND);
				rules.add(TR_SIMPLE_ITERATOR_OP);
				rules.add(TR_UNARY_OP);
				rules.add(PR_ImperativeOCLReservedKeyword);
				rules.add(PR_ImperativeOCLPrefixOperator);
				rules.add(PR_ImperativeOCLInfixOperator);
				rules.add(PR_ImperativeOCLNavigationOperator);
				rules.add(PR_ImperativeOCLExpCS);
				rules.add(PR_TypeLiteralCS);
				rules.add(PR_ListTypeCS);
				rules.add(PR_DictTypeCS);
				rules.add(PR_PrimaryExpCS);
				rules.add(PR_ListLiteralExpCS);
				rules.add(PR_DictLiteralExpCS);
				rules.add(PR_DictLiteralPartCS);
				rules.add(PR_ReturnExpCS);
				rules.add(PR_BlockExpCS);
				rules.add(PR_StringLiteral);
			}
			{
				List<Grammar> usedGrammars = grammar.getUsedGrammars();
				usedGrammars.add(G_EssentialOCL);
			}
			return grammar;
		}
	}
	
	private static class _EssentialOCL
	{
		private static final @NonNull ReferencedMetamodel MM = createReferencedMetamodel(org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.eINSTANCE, null); // http://www.eclipse.org/ocl/2015/EssentialOCLCS
		private static final @NonNull ReferencedMetamodel MM_base = createReferencedMetamodel(org.eclipse.ocl.xtext.basecs.BaseCSPackage.eINSTANCE, "base"); // http://www.eclipse.org/ocl/2015/BaseCS
		private static final @NonNull ReferencedMetamodel MM_ecore = createReferencedMetamodel(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, "ecore"); // http://www.eclipse.org/emf/2002/Ecore
		private static final @NonNull ReferencedMetamodel MM_pivot = createReferencedMetamodel(org.eclipse.ocl.pivot.PivotPackage.eINSTANCE, "pivot"); // http://www.eclipse.org/ocl/2015/Pivot
		
		private static final @NonNull ParserRule PR_BinaryOperatorName = createParserRule("BinaryOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_BooleanLiteralExpCS = createParserRule("BooleanLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_CollectionLiteralExpCS = createParserRule("CollectionLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_CollectionLiteralPartCS = createParserRule("CollectionLiteralPartCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS));
		private static final @NonNull ParserRule PR_CollectionPatternCS = createParserRule("CollectionPatternCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS));
		private static final @NonNull ParserRule PR_CollectionTypeCS = createParserRule("CollectionTypeCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS));
		private static final @NonNull ParserRule PR_CollectionTypeIdentifier = createParserRule("CollectionTypeIdentifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_CurlyBracketedClauseCS = createParserRule("CurlyBracketedClauseCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS));
		private static final @NonNull ParserRule PR_ElseIfThenExpCS = createParserRule("ElseIfThenExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS));
		private static final @NonNull ParserRule PR_EssentialOCLInfixOperatorName = createParserRule("EssentialOCLInfixOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLNavigationOperatorName = createParserRule("EssentialOCLNavigationOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLReservedKeyword = createParserRule("EssentialOCLReservedKeyword", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLUnaryOperatorName = createParserRule("EssentialOCLUnaryOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLUnreservedName = createParserRule("EssentialOCLUnreservedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLUnrestrictedName = createParserRule("EssentialOCLUnrestrictedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_ExpCS = createParserRule("ExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_IfExpCS = createParserRule("IfExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.IF_EXP_CS));
		private static final @NonNull ParserRule PR_InfixOperatorName = createParserRule("InfixOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_InvalidLiteralExpCS = createParserRule("InvalidLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.INVALID_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_LambdaLiteralExpCS = createParserRule("LambdaLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_LetExpCS = createParserRule("LetExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.LET_EXP_CS));
		private static final @NonNull ParserRule PR_LetVariableCS = createParserRule("LetVariableCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.LET_VARIABLE_CS));
		private static final @NonNull ParserRule PR_MapLiteralExpCS = createParserRule("MapLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_MapLiteralPartCS = createParserRule("MapLiteralPartCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS));
		private static final @NonNull ParserRule PR_MapTypeCS = createParserRule("MapTypeCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.MAP_TYPE_CS));
		private static final @NonNull ParserRule PR_Model = createParserRule("Model", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.CONTEXT_CS));
		private static final @NonNull ParserRule PR_NameExpCS = createParserRule("NameExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAME_EXP_CS));
		private static final @NonNull ParserRule PR_NavigatingArgCS = createParserRule("NavigatingArgCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS));
		private static final @NonNull ParserRule PR_NavigatingArgExpCS = createParserRule("NavigatingArgExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_NavigatingBarArgCS = createParserRule("NavigatingBarArgCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS));
		private static final @NonNull ParserRule PR_NavigatingCommaArgCS = createParserRule("NavigatingCommaArgCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS));
		private static final @NonNull ParserRule PR_NavigatingSemiArgCS = createParserRule("NavigatingSemiArgCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS));
		private static final @NonNull ParserRule PR_NavigationOperatorName = createParserRule("NavigationOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_NestedExpCS = createParserRule("NestedExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NESTED_EXP_CS));
		private static final @NonNull ParserRule PR_NullLiteralExpCS = createParserRule("NullLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NULL_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_NumberLiteralExpCS = createParserRule("NumberLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_PatternExpCS = createParserRule("PatternExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.PATTERN_EXP_CS));
		private static final @NonNull ParserRule PR_PrefixedLetExpCS = createParserRule("PrefixedLetExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_PrefixedPrimaryExpCS = createParserRule("PrefixedPrimaryExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_PrimaryExpCS = createParserRule("PrimaryExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_PrimitiveLiteralExpCS = createParserRule("PrimitiveLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.PRIMITIVE_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_PrimitiveTypeCS = createParserRule("PrimitiveTypeCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS));
		private static final @NonNull ParserRule PR_PrimitiveTypeIdentifier = createParserRule("PrimitiveTypeIdentifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_RoundBracketedClauseCS = createParserRule("RoundBracketedClauseCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS));
		private static final @NonNull ParserRule PR_SelfExpCS = createParserRule("SelfExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.SELF_EXP_CS));
		private static final @NonNull ParserRule PR_ShadowPartCS = createParserRule("ShadowPartCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.SHADOW_PART_CS));
		private static final @NonNull ParserRule PR_SquareBracketedClauseCS = createParserRule("SquareBracketedClauseCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS));
		private static final @NonNull ParserRule PR_StringLiteralExpCS = createParserRule("StringLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_TupleLiteralExpCS = createParserRule("TupleLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_TupleLiteralPartCS = createParserRule("TupleLiteralPartCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.TUPLE_LITERAL_PART_CS));
		private static final @NonNull ParserRule PR_TuplePartCS = createParserRule("TuplePartCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TUPLE_PART_CS));
		private static final @NonNull ParserRule PR_TupleTypeCS = createParserRule("TupleTypeCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TUPLE_TYPE_CS));
		private static final @NonNull ParserRule PR_TypeExpCS = createParserRule("TypeExpCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypeLiteralCS = createParserRule("TypeLiteralCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypeLiteralExpCS = createParserRule("TypeLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_TypeLiteralWithMultiplicityCS = createParserRule("TypeLiteralWithMultiplicityCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypeNameExpCS = createParserRule("TypeNameExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS));
		private static final @NonNull ParserRule PR_URIFirstPathElementCS = createParserRule("URIFirstPathElementCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_ELEMENT_CS));
		private static final @NonNull ParserRule PR_URIPathNameCS = createParserRule("URIPathNameCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_NAME_CS));
		private static final @NonNull ParserRule PR_UnaryOperatorName = createParserRule("UnaryOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_UnlimitedNaturalLiteralExpCS = createParserRule("UnlimitedNaturalLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_UnreservedName = createParserRule("UnreservedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_UnrestrictedName = createParserRule("UnrestrictedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		
		private static void initParserRules() {
			PR_BinaryOperatorName.setAlternatives(createAlternatives(createRuleCall(PR_InfixOperatorName), createRuleCall(PR_NavigationOperatorName)));
			PR_BooleanLiteralExpCS.setAlternatives(createAlternatives(createAssignment("symbol", "=", createKeyword("true")), createAssignment("symbol", "=", createKeyword("false"))));
			PR_CollectionLiteralExpCS.setAlternatives(createGroup(createAssignment("ownedType", "=", createRuleCall(PR_CollectionTypeCS)), createKeyword("{"), setCardinality("?", createGroup(createAssignment("ownedParts", "+=", createRuleCall(PR_CollectionLiteralPartCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedParts", "+=", createRuleCall(PR_CollectionLiteralPartCS)))))), createKeyword("}")));
			PR_CollectionLiteralPartCS.setAlternatives(createAlternatives(createGroup(createAssignment("ownedExpression", "=", createRuleCall(PR_ExpCS)), setCardinality("?", createGroup(createKeyword(".."), createAssignment("ownedLastExpression", "=", createRuleCall(PR_ExpCS))))), createAssignment("ownedExpression", "=", createRuleCall(PR_PatternExpCS))));
			PR_CollectionPatternCS.setAlternatives(createGroup(createAssignment("ownedType", "=", createRuleCall(PR_CollectionTypeCS)), createKeyword("{"), setCardinality("?", createGroup(createAssignment("ownedParts", "+=", createRuleCall(PR_PatternExpCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedParts", "+=", createRuleCall(PR_PatternExpCS)))), createGroup(createKeyword("++"), createAssignment("restVariableName", "=", createRuleCall(_Base.PR_Identifier))))), createKeyword("}")));
			PR_CollectionTypeCS.setAlternatives(createGroup(createAssignment("name", "=", createRuleCall(PR_CollectionTypeIdentifier)), setCardinality("?", createGroup(createKeyword("("), createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)), createKeyword(")")))));
			PR_CollectionTypeIdentifier.setAlternatives(createAlternatives(createKeyword("Set"), createKeyword("Bag"), createKeyword("Sequence"), createKeyword("Collection"), createKeyword("OrderedSet")));
			PR_CurlyBracketedClauseCS.setAlternatives(createGroup(createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS)), createKeyword("{"), createAlternatives(setCardinality("?", createGroup(createAssignment("ownedParts", "+=", createRuleCall(PR_ShadowPartCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedParts", "+=", createRuleCall(PR_ShadowPartCS)))))), createAssignment("value", "=", createRuleCall(_ImperativeOCL.PR_StringLiteral))), createKeyword("}")));
			PR_ElseIfThenExpCS.setAlternatives(createGroup(createKeyword("elseif"), createAssignment("ownedCondition", "=", createRuleCall(PR_ExpCS)), createKeyword("then"), createAssignment("ownedThenExpression", "=", createRuleCall(PR_ExpCS))));
			PR_EssentialOCLInfixOperatorName.setAlternatives(createAlternatives(createKeyword("*"), createKeyword("/"), createKeyword("+"), createKeyword("-"), createKeyword(">"), createKeyword("<"), createKeyword(">="), createKeyword("<="), createKeyword("="), createKeyword("<>"), createKeyword("and"), createKeyword("or"), createKeyword("xor"), createKeyword("implies")));
			PR_EssentialOCLNavigationOperatorName.setAlternatives(createAlternatives(createKeyword("."), createKeyword("->"), createKeyword("?."), createKeyword("?->")));
			PR_EssentialOCLReservedKeyword.setAlternatives(createAlternatives(createKeyword("and"), createKeyword("else"), createKeyword("endif"), createKeyword("if"), createKeyword("implies"), createKeyword("in"), createKeyword("let"), createKeyword("not"), createKeyword("or"), createKeyword("then"), createKeyword("xor")));
			PR_EssentialOCLUnaryOperatorName.setAlternatives(createAlternatives(createKeyword("-"), createKeyword("not")));
			PR_EssentialOCLUnreservedName.setAlternatives(createAlternatives(createRuleCall(PR_UnrestrictedName), createRuleCall(PR_CollectionTypeIdentifier), createRuleCall(PR_PrimitiveTypeIdentifier), createKeyword("Map"), createKeyword("Tuple")));
			PR_EssentialOCLUnrestrictedName.setAlternatives(createRuleCall(_Base.PR_Identifier));
			PR_ExpCS.setAlternatives(createAlternatives(createGroup(createRuleCall(PR_PrefixedPrimaryExpCS), setCardinality("?", createGroup(createAction("ownedLeft", "=", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.INFIX_EXP_CS)), createAssignment("name", "=", createRuleCall(PR_BinaryOperatorName)), createAssignment("ownedRight", "=", createRuleCall(PR_ExpCS))))), createRuleCall(PR_PrefixedLetExpCS)));
			PR_IfExpCS.setAlternatives(createGroup(createKeyword("if"), createAssignment("ownedCondition", "=", createAlternatives(createRuleCall(PR_ExpCS), createRuleCall(PR_PatternExpCS))), createKeyword("then"), createAssignment("ownedThenExpression", "=", createRuleCall(PR_ExpCS)), setCardinality("*", createAssignment("ownedIfThenExpressions", "+=", createRuleCall(PR_ElseIfThenExpCS))), createKeyword("else"), createAssignment("ownedElseExpression", "=", createRuleCall(PR_ExpCS)), createKeyword("endif")));
			PR_InfixOperatorName.setAlternatives(createRuleCall(PR_EssentialOCLInfixOperatorName));
			PR_InvalidLiteralExpCS.setAlternatives(createGroup(createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.INVALID_LITERAL_EXP_CS)), createKeyword("invalid")));
			PR_LambdaLiteralExpCS.setAlternatives(createGroup(createKeyword("Lambda"), createKeyword("{"), createAssignment("ownedExpressionCS", "=", createRuleCall(PR_ExpCS)), createKeyword("}")));
			PR_LetExpCS.setAlternatives(createGroup(createKeyword("let"), createAssignment("ownedVariables", "+=", createRuleCall(PR_LetVariableCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedVariables", "+=", createRuleCall(PR_LetVariableCS)))), createKeyword("in"), createAssignment("ownedInExpression", "=", createRuleCall(PR_ExpCS))));
			PR_LetVariableCS.setAlternatives(createGroup(createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)), setCardinality("?", createAssignment("ownedRoundBracketedClause", "=", createRuleCall(PR_RoundBracketedClauseCS))), setCardinality("?", createGroup(createKeyword(":"), createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)))), createKeyword("="), createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))));
			PR_MapLiteralExpCS.setAlternatives(createGroup(createAssignment("ownedType", "=", createRuleCall(PR_MapTypeCS)), createKeyword("{"), setCardinality("?", createGroup(createAssignment("ownedParts", "+=", createRuleCall(PR_MapLiteralPartCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedParts", "+=", createRuleCall(PR_MapLiteralPartCS)))))), createKeyword("}")));
			PR_MapLiteralPartCS.setAlternatives(createGroup(createAssignment("ownedKey", "=", createRuleCall(PR_ExpCS)), createKeyword("<-"), createAssignment("ownedValue", "=", createRuleCall(PR_ExpCS))));
			PR_MapTypeCS.setAlternatives(createGroup(createAssignment("name", "=", createKeyword("Map")), setCardinality("?", createGroup(createKeyword("("), createAssignment("ownedKeyType", "=", createRuleCall(PR_TypeExpCS)), createKeyword(","), createAssignment("ownedValueType", "=", createRuleCall(PR_TypeExpCS)), createKeyword(")")))));
			PR_Model.setAlternatives(createAssignment("ownedExpression", "=", createRuleCall(PR_ExpCS)));
			PR_NameExpCS.setAlternatives(createGroup(createAssignment("ownedPathName", "=", createRuleCall(_Base.PR_PathNameCS)), setCardinality("*", createAssignment("ownedSquareBracketedClauses", "+=", createRuleCall(PR_SquareBracketedClauseCS))), setCardinality("?", createAssignment("ownedRoundBracketedClause", "=", createRuleCall(PR_RoundBracketedClauseCS))), setCardinality("?", createAssignment("ownedCurlyBracketedClause", "=", createRuleCall(PR_CurlyBracketedClauseCS))), setCardinality("?", createGroup(createAssignment("isPre", "?=", createKeyword("@")), createKeyword("pre")))));
			PR_NavigatingArgCS.setAlternatives(createAlternatives(createGroup(createAssignment("ownedNameExpression", "=", createRuleCall(PR_NavigatingArgExpCS)), setCardinality("?", createAlternatives(createGroup(createKeyword(":"), createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)), setCardinality("?", createGroup(createKeyword("="), createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))), createGroup(createKeyword("in"), createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS)))))), createGroup(createKeyword(":"), createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)))));
			PR_NavigatingArgExpCS.setAlternatives(createRuleCall(PR_ExpCS));
			PR_NavigatingBarArgCS.setAlternatives(createGroup(createAssignment("prefix", "=", createKeyword("|")), createAssignment("ownedNameExpression", "=", createRuleCall(PR_NavigatingArgExpCS)), setCardinality("?", createGroup(createKeyword(":"), createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)), setCardinality("?", createGroup(createKeyword("="), createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))))));
			PR_NavigatingCommaArgCS.setAlternatives(createGroup(createAssignment("prefix", "=", createKeyword(",")), createAssignment("ownedNameExpression", "=", createRuleCall(PR_NavigatingArgExpCS)), setCardinality("?", createAlternatives(createGroup(createKeyword(":"), createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)), setCardinality("?", createGroup(createKeyword("="), createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))), createGroup(createKeyword("in"), createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS)))))));
			PR_NavigatingSemiArgCS.setAlternatives(createGroup(createAssignment("prefix", "=", createKeyword(";")), createAssignment("ownedNameExpression", "=", createRuleCall(PR_NavigatingArgExpCS)), setCardinality("?", createGroup(createKeyword(":"), createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)), setCardinality("?", createGroup(createKeyword("="), createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))))));
			PR_NavigationOperatorName.setAlternatives(createRuleCall(PR_EssentialOCLNavigationOperatorName));
			PR_NestedExpCS.setAlternatives(createGroup(createKeyword("("), createAssignment("ownedExpression", "=", createRuleCall(PR_ExpCS)), createKeyword(")")));
			PR_NullLiteralExpCS.setAlternatives(createGroup(createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NULL_LITERAL_EXP_CS)), createKeyword("null")));
			PR_NumberLiteralExpCS.setAlternatives(createAssignment("symbol", "=", createRuleCall(_Base.PR_NUMBER_LITERAL)));
			PR_PatternExpCS.setAlternatives(createGroup(setCardinality("?", createAssignment("patternVariableName", "=", createRuleCall(PR_UnrestrictedName))), createKeyword(":"), createAssignment("ownedPatternType", "=", createRuleCall(PR_TypeExpCS))));
			PR_PrefixedLetExpCS.setAlternatives(createAlternatives(createGroup(createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.PREFIX_EXP_CS)), createAssignment("name", "=", createRuleCall(PR_UnaryOperatorName)), createAssignment("ownedRight", "=", createRuleCall(PR_PrefixedLetExpCS))), createRuleCall(PR_LetExpCS)));
			PR_PrefixedPrimaryExpCS.setAlternatives(createAlternatives(createGroup(createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.PREFIX_EXP_CS)), createAssignment("name", "=", createRuleCall(PR_UnaryOperatorName)), createAssignment("ownedRight", "=", createRuleCall(PR_PrefixedPrimaryExpCS))), createRuleCall(_ImperativeOCL.PR_PrimaryExpCS)));
			PR_PrimaryExpCS.setAlternatives(createAlternatives(createRuleCall(PR_NestedExpCS), createRuleCall(PR_IfExpCS), createRuleCall(PR_SelfExpCS), createRuleCall(PR_PrimitiveLiteralExpCS), createRuleCall(PR_TupleLiteralExpCS), createRuleCall(PR_MapLiteralExpCS), createRuleCall(PR_CollectionLiteralExpCS), createRuleCall(PR_LambdaLiteralExpCS), createRuleCall(PR_TypeLiteralExpCS), createRuleCall(PR_NameExpCS)));
			PR_PrimitiveLiteralExpCS.setAlternatives(createAlternatives(createRuleCall(PR_NumberLiteralExpCS), createRuleCall(PR_StringLiteralExpCS), createRuleCall(PR_BooleanLiteralExpCS), createRuleCall(PR_UnlimitedNaturalLiteralExpCS), createRuleCall(PR_InvalidLiteralExpCS), createRuleCall(PR_NullLiteralExpCS)));
			PR_PrimitiveTypeCS.setAlternatives(createAssignment("name", "=", createRuleCall(PR_PrimitiveTypeIdentifier)));
			PR_PrimitiveTypeIdentifier.setAlternatives(createAlternatives(createKeyword("Boolean"), createKeyword("Integer"), createKeyword("Real"), createKeyword("String"), createKeyword("UnlimitedNatural"), createKeyword("OclAny"), createKeyword("OclInvalid"), createKeyword("OclVoid")));
			PR_RoundBracketedClauseCS.setAlternatives(createGroup(createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS)), createKeyword("("), setCardinality("?", createGroup(createAssignment("ownedArguments", "+=", createRuleCall(PR_NavigatingArgCS)), setCardinality("*", createAssignment("ownedArguments", "+=", createRuleCall(PR_NavigatingCommaArgCS))), setCardinality("?", createGroup(createAssignment("ownedArguments", "+=", createRuleCall(PR_NavigatingSemiArgCS)), setCardinality("*", createAssignment("ownedArguments", "+=", createRuleCall(PR_NavigatingCommaArgCS))))), setCardinality("*", createGroup(createAssignment("ownedArguments", "+=", createRuleCall(PR_NavigatingBarArgCS)), setCardinality("*", createAssignment("ownedArguments", "+=", createRuleCall(PR_NavigatingCommaArgCS))))))), createKeyword(")")));
			PR_SelfExpCS.setAlternatives(createGroup(createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.SELF_EXP_CS)), createKeyword("self")));
			PR_ShadowPartCS.setAlternatives(createGroup(createAssignment("referredProperty", "=", createCrossReference(createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.PROPERTY), createRuleCall(PR_UnrestrictedName))), createKeyword("="), createAssignment("ownedInitExpression", "=", createAlternatives(createRuleCall(PR_ExpCS), createRuleCall(PR_PatternExpCS)))));
			PR_SquareBracketedClauseCS.setAlternatives(createGroup(createKeyword("["), createAssignment("ownedTerms", "+=", createRuleCall(PR_ExpCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedTerms", "+=", createRuleCall(PR_ExpCS)))), createKeyword("]")));
			PR_StringLiteralExpCS.setAlternatives(setCardinality("+", createAssignment("segments", "+=", createRuleCall(_ImperativeOCL.PR_StringLiteral))));
			PR_TupleLiteralExpCS.setAlternatives(createGroup(createKeyword("Tuple"), createKeyword("{"), createAssignment("ownedParts", "+=", createRuleCall(PR_TupleLiteralPartCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedParts", "+=", createRuleCall(PR_TupleLiteralPartCS)))), createKeyword("}")));
			PR_TupleLiteralPartCS.setAlternatives(createGroup(createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)), setCardinality("?", createGroup(createKeyword(":"), createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)))), createKeyword("="), createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))));
			PR_TuplePartCS.setAlternatives(createGroup(createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)), createKeyword(":"), createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS))));
			PR_TupleTypeCS.setAlternatives(createGroup(createAssignment("name", "=", createKeyword("Tuple")), setCardinality("?", createGroup(createKeyword("("), setCardinality("?", createGroup(createAssignment("ownedParts", "+=", createRuleCall(PR_TuplePartCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedParts", "+=", createRuleCall(PR_TuplePartCS)))))), createKeyword(")")))));
			PR_TypeExpCS.setAlternatives(createGroup(createAlternatives(createRuleCall(PR_TypeNameExpCS), createRuleCall(_ImperativeOCL.PR_TypeLiteralCS), createRuleCall(PR_CollectionPatternCS)), setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(_QVTOperational.PR_MultiplicityCS)))));
			PR_TypeLiteralCS.setAlternatives(createAlternatives(createRuleCall(PR_PrimitiveTypeCS), createRuleCall(PR_CollectionTypeCS), createRuleCall(PR_MapTypeCS), createRuleCall(PR_TupleTypeCS)));
			PR_TypeLiteralExpCS.setAlternatives(createAssignment("ownedType", "=", createRuleCall(PR_TypeLiteralWithMultiplicityCS)));
			PR_TypeLiteralWithMultiplicityCS.setAlternatives(createGroup(createRuleCall(_ImperativeOCL.PR_TypeLiteralCS), setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(_QVTOperational.PR_MultiplicityCS)))));
			PR_TypeNameExpCS.setAlternatives(createGroup(createAssignment("ownedPathName", "=", createRuleCall(_Base.PR_PathNameCS)), setCardinality("?", createGroup(createAssignment("ownedCurlyBracketedClause", "=", createRuleCall(PR_CurlyBracketedClauseCS)), setCardinality("?", createGroup(createKeyword("{"), createAssignment("ownedPatternGuard", "=", createRuleCall(PR_ExpCS)), createKeyword("}")))))));
			PR_URIFirstPathElementCS.setAlternatives(createAlternatives(createAssignment("referredElement", "=", createCrossReference(createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMED_ELEMENT), createRuleCall(PR_UnrestrictedName))), createGroup(createAction(null, null, createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_ELEMENT_WITH_URICS)), createAssignment("referredElement", "=", createCrossReference(createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMESPACE), createRuleCall(_Base.PR_URI))))));
			PR_URIPathNameCS.setAlternatives(createGroup(createAssignment("ownedPathElements", "+=", createRuleCall(PR_URIFirstPathElementCS)), setCardinality("*", createGroup(createKeyword("::"), createAssignment("ownedPathElements", "+=", createRuleCall(_Base.PR_NextPathElementCS))))));
			PR_UnaryOperatorName.setAlternatives(createRuleCall(PR_EssentialOCLUnaryOperatorName));
			PR_UnlimitedNaturalLiteralExpCS.setAlternatives(createGroup(createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP_CS)), createKeyword("*")));
			PR_UnreservedName.setAlternatives(createRuleCall(PR_EssentialOCLUnreservedName));
			PR_UnrestrictedName.setAlternatives(createRuleCall(PR_EssentialOCLUnrestrictedName));
		}
		
		private static @NonNull Grammar initGrammar() {
			initParserRules();
			Grammar grammar = G_EssentialOCL;
			{
				List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
				metamodelDeclarations.add(MM_ecore);
				metamodelDeclarations.add(MM_pivot);
				metamodelDeclarations.add(MM_base);
				metamodelDeclarations.add(MM);
			}
			{
				List<AbstractRule> rules = grammar.getRules();
				rules.add(PR_Model);
				rules.add(PR_EssentialOCLReservedKeyword);
				rules.add(PR_EssentialOCLUnaryOperatorName);
				rules.add(PR_EssentialOCLInfixOperatorName);
				rules.add(PR_EssentialOCLNavigationOperatorName);
				rules.add(PR_BinaryOperatorName);
				rules.add(PR_InfixOperatorName);
				rules.add(PR_NavigationOperatorName);
				rules.add(PR_UnaryOperatorName);
				rules.add(PR_EssentialOCLUnrestrictedName);
				rules.add(PR_UnrestrictedName);
				rules.add(PR_EssentialOCLUnreservedName);
				rules.add(PR_UnreservedName);
				rules.add(PR_URIPathNameCS);
				rules.add(PR_URIFirstPathElementCS);
				rules.add(PR_PrimitiveTypeIdentifier);
				rules.add(PR_PrimitiveTypeCS);
				rules.add(PR_CollectionTypeIdentifier);
				rules.add(PR_CollectionTypeCS);
				rules.add(PR_MapTypeCS);
				rules.add(PR_TupleTypeCS);
				rules.add(PR_TuplePartCS);
				rules.add(PR_CollectionLiteralExpCS);
				rules.add(PR_CollectionLiteralPartCS);
				rules.add(PR_CollectionPatternCS);
				rules.add(PR_ShadowPartCS);
				rules.add(PR_PatternExpCS);
				rules.add(PR_LambdaLiteralExpCS);
				rules.add(PR_MapLiteralExpCS);
				rules.add(PR_MapLiteralPartCS);
				rules.add(PR_PrimitiveLiteralExpCS);
				rules.add(PR_TupleLiteralExpCS);
				rules.add(PR_TupleLiteralPartCS);
				rules.add(PR_NumberLiteralExpCS);
				rules.add(PR_StringLiteralExpCS);
				rules.add(PR_BooleanLiteralExpCS);
				rules.add(PR_UnlimitedNaturalLiteralExpCS);
				rules.add(PR_InvalidLiteralExpCS);
				rules.add(PR_NullLiteralExpCS);
				rules.add(PR_TypeLiteralCS);
				rules.add(PR_TypeLiteralWithMultiplicityCS);
				rules.add(PR_TypeLiteralExpCS);
				rules.add(PR_TypeNameExpCS);
				rules.add(PR_TypeExpCS);
				rules.add(PR_ExpCS);
				rules.add(PR_PrefixedLetExpCS);
				rules.add(PR_PrefixedPrimaryExpCS);
				rules.add(PR_PrimaryExpCS);
				rules.add(PR_NameExpCS);
				rules.add(PR_CurlyBracketedClauseCS);
				rules.add(PR_RoundBracketedClauseCS);
				rules.add(PR_SquareBracketedClauseCS);
				rules.add(PR_NavigatingArgCS);
				rules.add(PR_NavigatingBarArgCS);
				rules.add(PR_NavigatingCommaArgCS);
				rules.add(PR_NavigatingSemiArgCS);
				rules.add(PR_NavigatingArgExpCS);
				rules.add(PR_IfExpCS);
				rules.add(PR_ElseIfThenExpCS);
				rules.add(PR_LetExpCS);
				rules.add(PR_LetVariableCS);
				rules.add(PR_NestedExpCS);
				rules.add(PR_SelfExpCS);
			}
			{
				List<Grammar> usedGrammars = grammar.getUsedGrammars();
				usedGrammars.add(G_Base);
			}
			return grammar;
		}
	}
	
	private static class _Base
	{
		private static final @NonNull ReferencedMetamodel MM = createReferencedMetamodel(org.eclipse.ocl.xtext.basecs.BaseCSPackage.eINSTANCE, null); // http://www.eclipse.org/ocl/2015/BaseCS
		private static final @NonNull ReferencedMetamodel MM_ecore = createReferencedMetamodel(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, "ecore"); // http://www.eclipse.org/emf/2002/Ecore
		private static final @NonNull ReferencedMetamodel MM_pivot = createReferencedMetamodel(org.eclipse.ocl.pivot.PivotPackage.eINSTANCE, "pivot"); // http://www.eclipse.org/ocl/2015/Pivot
		
		private static final @NonNull TerminalRule TR_ANY_OTHER = createTerminalRule("ANY_OTHER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_DOUBLE_QUOTED_STRING = createTerminalRule("DOUBLE_QUOTED_STRING", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ESCAPED_CHARACTER = createTerminalRule("ESCAPED_CHARACTER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ESCAPED_ID = createTerminalRule("ESCAPED_ID", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_INT = createTerminalRule("INT", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_LETTER_CHARACTER = createTerminalRule("LETTER_CHARACTER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ML_COMMENT = createTerminalRule("ML_COMMENT", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ML_SINGLE_QUOTED_STRING = createTerminalRule("ML_SINGLE_QUOTED_STRING", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_SIMPLE_ID = createTerminalRule("SIMPLE_ID", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_SINGLE_QUOTED_STRING = createTerminalRule("SINGLE_QUOTED_STRING", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_SL_COMMENT = createTerminalRule("SL_COMMENT", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_WS = createTerminalRule("WS", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		
		private static void initTerminalRules() {
			TR_ANY_OTHER.setAlternatives(createWildcard());
			TR_DOUBLE_QUOTED_STRING.setAlternatives(createGroup(createKeyword("\""), setCardinality("*", createAlternatives(createRuleCall(TR_ESCAPED_CHARACTER), createNegatedToken(createAlternatives(createKeyword("\\"), createKeyword("\""))))), createKeyword("\"")));
			TR_ESCAPED_CHARACTER.setFragment(true);
			TR_ESCAPED_CHARACTER.setAlternatives(createGroup(createKeyword("\\"), createAlternatives(createKeyword("b"), createKeyword("t"), createKeyword("n"), createKeyword("f"), createKeyword("r"), createKeyword("u"), createKeyword("\""), createKeyword("\'"), createKeyword("\\"))));
			TR_ESCAPED_ID.setAlternatives(createGroup(createKeyword("_"), createRuleCall(TR_SINGLE_QUOTED_STRING)));
			TR_INT.setAlternatives(setCardinality("+", createCharacterRange(createKeyword("0"), createKeyword("9"))));
			TR_LETTER_CHARACTER.setFragment(true);
			TR_LETTER_CHARACTER.setAlternatives(createAlternatives(createCharacterRange(createKeyword("a"), createKeyword("z")), createCharacterRange(createKeyword("A"), createKeyword("Z")), createKeyword("_")));
			TR_ML_COMMENT.setAlternatives(createGroup(createKeyword("/*"), createUntilToken(createKeyword("*/"))));
			TR_ML_SINGLE_QUOTED_STRING.setAlternatives(createGroup(createKeyword("/\'"), createUntilToken(createKeyword("\'/"))));
			TR_SIMPLE_ID.setAlternatives(createGroup(createRuleCall(TR_LETTER_CHARACTER), setCardinality("*", createAlternatives(createRuleCall(TR_LETTER_CHARACTER), createCharacterRange(createKeyword("0"), createKeyword("9"))))));
			TR_SINGLE_QUOTED_STRING.setAlternatives(createGroup(createKeyword("\'"), setCardinality("*", createAlternatives(createRuleCall(TR_ESCAPED_CHARACTER), createNegatedToken(createAlternatives(createKeyword("\\"), createKeyword("\'"))))), createKeyword("\'")));
			TR_SL_COMMENT.setAlternatives(createGroup(createKeyword("--"), setCardinality("*", createNegatedToken(createAlternatives(createKeyword("\n"), createKeyword("\r")))), setCardinality("?", createGroup(setCardinality("?", createKeyword("\r")), createKeyword("\n")))));
			TR_WS.setAlternatives(setCardinality("+", createAlternatives(createKeyword(" "), createKeyword("\t"), createKeyword("\r"), createKeyword("\n"))));
		}
		
		private static final @NonNull ParserRule PR_FirstPathElementCS = createParserRule("FirstPathElementCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_ELEMENT_CS));
		private static final @NonNull ParserRule PR_ID = createParserRule("ID", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_Identifier = createParserRule("Identifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_LOWER = createParserRule("LOWER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.EINT));
		private static final @NonNull ParserRule PR_MultiplicityBoundsCS = createParserRule("MultiplicityBoundsCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS));
		private static final @NonNull ParserRule PR_MultiplicityCS = createParserRule("MultiplicityCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.MULTIPLICITY_CS));
		private static final @NonNull ParserRule PR_MultiplicityStringCS = createParserRule("MultiplicityStringCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.MULTIPLICITY_STRING_CS));
		private static final @NonNull ParserRule PR_NUMBER_LITERAL = createParserRule("NUMBER_LITERAL", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.BIG_NUMBER));
		private static final @NonNull ParserRule PR_NextPathElementCS = createParserRule("NextPathElementCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_ELEMENT_CS));
		private static final @NonNull ParserRule PR_PathNameCS = createParserRule("PathNameCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_NAME_CS));
		private static final @NonNull ParserRule PR_StringLiteral = createParserRule("StringLiteral", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_TemplateBindingCS = createParserRule("TemplateBindingCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TEMPLATE_BINDING_CS));
		private static final @NonNull ParserRule PR_TemplateParameterSubstitutionCS = createParserRule("TemplateParameterSubstitutionCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS));
		private static final @NonNull ParserRule PR_TemplateSignatureCS = createParserRule("TemplateSignatureCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS));
		private static final @NonNull ParserRule PR_TypeParameterCS = createParserRule("TypeParameterCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPE_PARAMETER_CS));
		private static final @NonNull ParserRule PR_TypeRefCS = createParserRule("TypeRefCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPE_REF_CS));
		private static final @NonNull ParserRule PR_TypedRefCS = createParserRule("TypedRefCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypedTypeRefCS = createParserRule("TypedTypeRefCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_TYPE_REF_CS));
		private static final @NonNull ParserRule PR_UPPER = createParserRule("UPPER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.EINT));
		private static final @NonNull ParserRule PR_URI = createParserRule("URI", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_UnreservedName = createParserRule("UnreservedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_UnrestrictedName = createParserRule("UnrestrictedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_WildcardTypeRefCS = createParserRule("WildcardTypeRefCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS));
		
		private static void initParserRules() {
			PR_FirstPathElementCS.setAlternatives(createAssignment("referredElement", "=", createCrossReference(createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMED_ELEMENT), createRuleCall(_EssentialOCL.PR_UnrestrictedName))));
			PR_ID.setAlternatives(createAlternatives(createRuleCall(TR_SIMPLE_ID), createRuleCall(TR_ESCAPED_ID)));
			PR_Identifier.setAlternatives(createRuleCall(PR_ID));
			PR_LOWER.setAlternatives(createRuleCall(TR_INT));
			PR_MultiplicityBoundsCS.setAlternatives(createGroup(createAssignment("lowerBound", "=", createRuleCall(PR_LOWER)), setCardinality("?", createGroup(createKeyword(".."), createAssignment("upperBound", "=", createRuleCall(PR_UPPER))))));
			PR_MultiplicityCS.setAlternatives(createGroup(createKeyword("["), createAlternatives(createRuleCall(PR_MultiplicityBoundsCS), createRuleCall(PR_MultiplicityStringCS)), setCardinality("?", createAlternatives(createKeyword("|?"), createAssignment("isNullFree", "?=", createKeyword("|1")))), createKeyword("]")));
			PR_MultiplicityStringCS.setAlternatives(createAssignment("stringBounds", "=", createAlternatives(createKeyword("*"), createKeyword("+"), createKeyword("?"))));
			PR_NUMBER_LITERAL.setAlternatives(createRuleCall(TR_INT));
			PR_NextPathElementCS.setAlternatives(createAssignment("referredElement", "=", createCrossReference(createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMED_ELEMENT), createRuleCall(_EssentialOCL.PR_UnreservedName))));
			PR_PathNameCS.setAlternatives(createGroup(createAssignment("ownedPathElements", "+=", createRuleCall(PR_FirstPathElementCS)), setCardinality("*", createGroup(createKeyword("::"), createAssignment("ownedPathElements", "+=", createRuleCall(PR_NextPathElementCS))))));
			PR_StringLiteral.setAlternatives(createRuleCall(TR_SINGLE_QUOTED_STRING));
			PR_TemplateBindingCS.setAlternatives(createGroup(createAssignment("ownedSubstitutions", "+=", createRuleCall(PR_TemplateParameterSubstitutionCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedSubstitutions", "+=", createRuleCall(PR_TemplateParameterSubstitutionCS)))), setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(_QVTOperational.PR_MultiplicityCS)))));
			PR_TemplateParameterSubstitutionCS.setAlternatives(createAssignment("ownedActualParameter", "=", createRuleCall(PR_TypeRefCS)));
			PR_TemplateSignatureCS.setAlternatives(createGroup(createKeyword("("), createAssignment("ownedParameters", "+=", createRuleCall(PR_TypeParameterCS)), setCardinality("*", createGroup(createKeyword(","), createAssignment("ownedParameters", "+=", createRuleCall(PR_TypeParameterCS)))), createKeyword(")")));
			PR_TypeParameterCS.setAlternatives(createGroup(createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)), setCardinality("?", createGroup(createKeyword("extends"), createAssignment("ownedExtends", "+=", createRuleCall(PR_TypedRefCS)), setCardinality("*", createGroup(createKeyword("&&"), createAssignment("ownedExtends", "+=", createRuleCall(PR_TypedRefCS))))))));
			PR_TypeRefCS.setAlternatives(createAlternatives(createRuleCall(PR_TypedRefCS), createRuleCall(PR_WildcardTypeRefCS)));
			PR_TypedRefCS.setAlternatives(createRuleCall(PR_TypedTypeRefCS));
			PR_TypedTypeRefCS.setAlternatives(createGroup(createAssignment("ownedPathName", "=", createRuleCall(PR_PathNameCS)), setCardinality("?", createGroup(createKeyword("("), createAssignment("ownedBinding", "=", createRuleCall(PR_TemplateBindingCS)), createKeyword(")")))));
			PR_UPPER.setAlternatives(createAlternatives(createRuleCall(TR_INT), createKeyword("*")));
			PR_URI.setAlternatives(createRuleCall(TR_SINGLE_QUOTED_STRING));
			PR_UnreservedName.setAlternatives(createRuleCall(_EssentialOCL.PR_UnrestrictedName));
			PR_UnrestrictedName.setAlternatives(createRuleCall(PR_Identifier));
			PR_WildcardTypeRefCS.setAlternatives(createGroup(createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS)), createKeyword("?"), setCardinality("?", createGroup(createKeyword("extends"), createAssignment("ownedExtends", "=", createRuleCall(PR_TypedRefCS))))));
		}
		
		private static @NonNull Grammar initGrammar() {
			initTerminalRules();
			initParserRules();
			Grammar grammar = G_Base;
			grammar.setDefinesHiddenTokens(true);
			{
				List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
				metamodelDeclarations.add(MM_ecore);
				metamodelDeclarations.add(MM_pivot);
				metamodelDeclarations.add(MM);
			}
			{
				List<AbstractRule> rules = grammar.getRules();
				rules.add(PR_MultiplicityBoundsCS);
				rules.add(PR_MultiplicityCS);
				rules.add(PR_MultiplicityStringCS);
				rules.add(PR_PathNameCS);
				rules.add(PR_FirstPathElementCS);
				rules.add(PR_NextPathElementCS);
				rules.add(PR_TemplateBindingCS);
				rules.add(PR_TemplateParameterSubstitutionCS);
				rules.add(PR_TemplateSignatureCS);
				rules.add(PR_TypeParameterCS);
				rules.add(PR_TypeRefCS);
				rules.add(PR_TypedRefCS);
				rules.add(PR_TypedTypeRefCS);
				rules.add(PR_UnreservedName);
				rules.add(PR_UnrestrictedName);
				rules.add(PR_WildcardTypeRefCS);
				rules.add(PR_ID);
				rules.add(PR_Identifier);
				rules.add(PR_LOWER);
				rules.add(PR_NUMBER_LITERAL);
				rules.add(PR_StringLiteral);
				rules.add(PR_UPPER);
				rules.add(PR_URI);
				rules.add(TR_ESCAPED_CHARACTER);
				rules.add(TR_LETTER_CHARACTER);
				rules.add(TR_DOUBLE_QUOTED_STRING);
				rules.add(TR_SINGLE_QUOTED_STRING);
				rules.add(TR_ML_SINGLE_QUOTED_STRING);
				rules.add(TR_SIMPLE_ID);
				rules.add(TR_ESCAPED_ID);
				rules.add(TR_INT);
				rules.add(TR_ML_COMMENT);
				rules.add(TR_SL_COMMENT);
				rules.add(TR_WS);
				rules.add(TR_ANY_OTHER);
			}
			{
				List<AbstractRule> hiddenTokens = grammar.getHiddenTokens();
				hiddenTokens.add(TR_WS);
				hiddenTokens.add(TR_ML_COMMENT);
				hiddenTokens.add(TR_SL_COMMENT);
			}
			return grammar;
		}
	}
}
