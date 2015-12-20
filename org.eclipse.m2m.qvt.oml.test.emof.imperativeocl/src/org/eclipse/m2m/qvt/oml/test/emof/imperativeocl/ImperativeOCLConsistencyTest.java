/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.test.emof.imperativeocl;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.util.ImperativeOCLMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.test.emof.emof.EMOFConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.AbstractEssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.EssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreDifference;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceHelper;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public class ImperativeOCLConsistencyTest extends AbstractEssentialOCLConsistencyTest
{	
	public static void expectedEcoreDifferences(EquivalenceHelper helper, Set<EcoreDifference> differences, ResourceSet rightResourceSet) {
		changeOfURI(differences, helper, org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage.eINSTANCE);
		changeOfPrefix(differences, helper, org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage.eINSTANCE);			
		//
		//	Ecore limitation on EBoolean rather than EBooleanObject
		//
		changeOfUnsettable(differences, helper, org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage.Literals.ASSIGN_EXP__IS_RESET);
		//
		//	Ecore added value
		//
		missingConstraint(differences, helper, org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage.Literals.ASSIGN_EXP);
		missingConstraint(differences, helper, org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage.Literals.IMPERATIVE_ITERATE_EXP);
		missingConstraint(differences, helper, org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage.Literals.ORDERED_TUPLE_TYPE);
	}

	public static void expectedEmofDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper, ResourceSet rightResourceSet) {
		changeOfURI(differences, helper, ImperativeOCLPackage.eINSTANCE);
		changeOfPrefix(differences, helper, ImperativeOCLPackage.eINSTANCE);
		changeOfName(differences, helper, ImperativeOCLPackage.eINSTANCE);

		EPackage rightImperativeOCL = getPackage(rightResourceSet, IMPERATIVE_OCL_PACKAGE_NAME.toLowerCase());
		extraObject(differences, helper, getClass(rightImperativeOCL, "TemplateParameterType"));
//		extraObject(differences, helper, getFeature(getClass(rightPackage, "TemplateParameterType"), "specification"));
		missingClass(differences, helper, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP);
//		missingObject(differences, helper, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP__ELEMENT);
//		missingOppositeAnnotation(differences, helper, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP__ELEMENT);
		changeOfListObject(differences, helper, ImperativeOCLPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP, getClass(rightImperativeOCL, "TemplateParameterType"));		
	}

	public static void expectedEmof2OmgEmofDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper, ResourceSet rightResourceSet) {
		missingURI(differences, helper, ImperativeOCLPackage.eINSTANCE);
		missingPrefix(differences, helper, ImperativeOCLPackage.eINSTANCE);
		changeOfName(differences, helper, ImperativeOCLPackage.eINSTANCE);
		EPackage rightImperativeOCL = getPackage(rightResourceSet, IMPERATIVE_OCL_PACKAGE_NAME.toLowerCase());
		changeOfListObject(differences, helper, ImperativeOCLPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP, getClass(rightImperativeOCL, "TemplateParameterType"));		
	}

	@Override
	protected Set<EcoreDifference> getExpectedEcore2EmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		ImperativeOCLConsistencyTest.expectedEcoreDifferences(helper, differences, rightResourceSet);		
		helper.setLogStream(null);
		EssentialOCLConsistencyTest.expectedEcoreDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEcore2RoseDifferences(helper, differences, rightResourceSet);		
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEcoreDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfURI(differences, helper, ImperativeOCLPackage.eINSTANCE);
		changeOfPrefix(differences, helper, ImperativeOCLPackage.eINSTANCE);
		changeOfName(differences, helper, ImperativeOCLPackage.eINSTANCE);
		changeOfName(differences, helper, ImperativeOCLPackage.Literals.TRY_EXP__EXCEPT_CLAUSE);
		changeOfContainment(differences, helper, ImperativeOCLPackage.Literals.UNPACK_EXP__TARGET_VARIABLE);
		changeOfOrdered(differences, helper, ImperativeOCLPackage.Literals.DICT_LITERAL_EXP__PART);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.RETURN_EXP__VALUE);
		changeOfDefaultValue(differences, helper, ImperativeOCLPackage.Literals.ASSERT_EXP__SEVERITY);
		changeOfDefaultValue(differences, helper, ImperativeOCLPackage.Literals.VARIABLE_INIT_EXP__WITH_RESULT);

		extraObject(differences, helper, getClass(rightPackage, "TemplateParameterType"));
		extraObject(differences, helper, getFeature(getClass(rightPackage, "TemplateParameterType"), "specification"));
		missingClass(differences, helper, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP);
		missingObject(differences, helper, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP__ELEMENT);
		missingOppositeAnnotation(differences, helper, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP__ELEMENT);
		changeOfListObject(differences, helper, ImperativeOCLPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP, getClass(rightPackage, "TemplateParameterType"));		

		changeOfList(differences, helper, ImperativeOCLPackage.Literals.SWITCH_EXP, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ALT_EXP__BODY);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ALT_EXP__CONDITION);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ASSERT_EXP__ASSERTION);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.BLOCK_EXP__BODY);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.CATCH_EXP__EXCEPTION);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.COMPUTE_EXP__BODY);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.COMPUTE_EXP__RETURNED_ELEMENT);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.DICTIONARY_TYPE__KEY_TYPE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.DICT_LITERAL_EXP__PART);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.DICT_LITERAL_PART__KEY);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.DICT_LITERAL_PART__VALUE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.IMPERATIVE_ITERATE_EXP__TARGET);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.INSTANTIATION_EXP__ARGUMENT);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.LOG_EXP__CONDITION);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ORDERED_TUPLE_LITERAL_EXP__PART);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ORDERED_TUPLE_LITERAL_PART__VALUE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ORDERED_TUPLE_TYPE__ELEMENT_TYPE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.RAISE_EXP__EXCEPTION);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.SWITCH_EXP__ALTERNATIVE_PART);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.SWITCH_EXP__ELSE_PART);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.TRY_EXP__EXCEPT_CLAUSE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.TRY_EXP__TRY_BODY);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.UNLINK_EXP__ITEM);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.UNLINK_EXP__TARGET);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.VARIABLE_INIT_EXP__REFERRED_VARIABLE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.WHILE_EXP__BODY);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.WHILE_EXP__CONDITION);
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		EssentialOCLConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		missingURI(differences, helper, ImperativeOCLPackage.eINSTANCE);
		changeOfName(differences, helper, ImperativeOCLPackage.eINSTANCE);

		changeOfName(differences, helper, ImperativeOCLPackage.Literals.TRY_EXP__EXCEPT_CLAUSE);
		changeOfContainment(differences, helper, ImperativeOCLPackage.Literals.UNPACK_EXP__TARGET_VARIABLE);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.RETURN_EXP__VALUE);
		changeOfDefaultValue(differences, helper, ImperativeOCLPackage.Literals.ASSERT_EXP__SEVERITY);
		changeOfDefaultValue(differences, helper, ImperativeOCLPackage.Literals.VARIABLE_INIT_EXP__WITH_RESULT);
		changeOfList(differences, helper, ImperativeOCLPackage.Literals.SWITCH_EXP, EcorePackage.Literals.ECLASS__ESUPER_TYPES);

		extraObject(differences, helper, getClass(rightPackage, "TemplateParameterType"));
		extraObject(differences, helper, getFeature(getClass(rightPackage, "TemplateParameterType"), "specification"));
		missingClass(differences, helper, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP);
		missingObject(differences, helper, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP__ELEMENT);
		missingOppositeAnnotation(differences, helper, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP__ELEMENT);
		changeOfListObject(differences, helper, ImperativeOCLPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP, getClass(rightPackage, "TemplateParameterType"));		

		changeOfSize(differences, helper, ImperativeOCLPackage.Literals.SEVERITY_KIND, EcorePackage.Literals.EENUM__ELITERALS);
		missingEnumerationLiteral(differences, helper, ImperativeOCLPackage.Literals.SEVERITY_KIND.getEEnumLiteral("error"));
		missingEnumerationLiteral(differences, helper, ImperativeOCLPackage.Literals.SEVERITY_KIND.getEEnumLiteral("fatal"));
		missingEnumerationLiteral(differences, helper, ImperativeOCLPackage.Literals.SEVERITY_KIND.getEEnumLiteral("warning"));
		
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.ASSERT_EXP__SEVERITY);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.ASSIGN_EXP__IS_RESET);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.ASSERT_EXP__LOG);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.BLOCK_EXP__BODY);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.CATCH_EXP__BODY);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.CATCH_EXP__EXCEPTION);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.DICTIONARY_TYPE__KEY_TYPE);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.DICT_LITERAL_EXP__PART);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.IMPERATIVE_ITERATE_EXP__TARGET);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.INSTANTIATION_EXP__ARGUMENT);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.INSTANTIATION_EXP__EXTENT);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.LOG_EXP__CONDITION);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.ORDERED_TUPLE_LITERAL_EXP__PART);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.ORDERED_TUPLE_TYPE__ELEMENT_TYPE);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.RAISE_EXP__ARGUMENT);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.SWITCH_EXP__ALTERNATIVE_PART);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.SWITCH_EXP__ELSE_PART);
//		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.TEMPLATE_PARAMETER_TYPE__SPECIFICATION);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.TRY_EXP__EXCEPT_CLAUSE);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.TRY_EXP__TRY_BODY);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.TYPEDEF__CONDITION);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.VARIABLE_INIT_EXP__WITH_RESULT);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ALT_EXP__BODY);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ALT_EXP__CONDITION);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ASSERT_EXP__ASSERTION);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.BLOCK_EXP__BODY);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.CATCH_EXP__EXCEPTION);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.COMPUTE_EXP__BODY);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.COMPUTE_EXP__RETURNED_ELEMENT);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.DICTIONARY_TYPE__KEY_TYPE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.DICT_LITERAL_EXP__PART);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.DICT_LITERAL_PART__KEY);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.DICT_LITERAL_PART__VALUE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.IMPERATIVE_ITERATE_EXP__TARGET);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.INSTANTIATION_EXP__ARGUMENT);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.LOG_EXP__CONDITION);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ORDERED_TUPLE_LITERAL_EXP__PART);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ORDERED_TUPLE_LITERAL_PART__VALUE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.ORDERED_TUPLE_TYPE__ELEMENT_TYPE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.RAISE_EXP__EXCEPTION);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.SWITCH_EXP__ALTERNATIVE_PART);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.SWITCH_EXP__ELSE_PART);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.TRY_EXP__EXCEPT_CLAUSE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.TRY_EXP__TRY_BODY);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.UNLINK_EXP__ITEM);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.UNLINK_EXP__TARGET);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.VARIABLE_INIT_EXP__REFERRED_VARIABLE);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.WHILE_EXP__BODY);
		missingOpposite(differences, helper, ImperativeOCLPackage.Literals.WHILE_EXP__CONDITION);
		helper.setLogStream(null);
		missingPrefix(differences, helper, ImperativeOCLPackage.eINSTANCE);
		missingURI(differences, helper, org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage.eINSTANCE);
		missingPrefix(differences, helper, org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage.eINSTANCE);
		changeOfName(differences, helper, org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage.eINSTANCE);
		changeOfSize(differences, helper, org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		missingURI(differences, helper, org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.eINSTANCE);
		missingPrefix(differences, helper, org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.eINSTANCE);
		changeOfName(differences, helper, org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.eINSTANCE);
		changeOfSize(differences, helper, org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgRoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfURI(differences, helper, ImperativeOCLPackage.eINSTANCE);
		changeOfPrefix(differences, helper, ImperativeOCLPackage.eINSTANCE);
		changeOfName(differences, helper, ImperativeOCLPackage.eINSTANCE);
		changeOfName(differences, helper, ImperativeOCLPackage.Literals.TRY_EXP__EXCEPT_CLAUSE);
		changeOfContainment(differences, helper, ImperativeOCLPackage.Literals.UNPACK_EXP__TARGET_VARIABLE);
		changeOfLower(differences, helper, ImperativeOCLPackage.Literals.RETURN_EXP__VALUE);
		changeOfDefaultValue(differences, helper, ImperativeOCLPackage.Literals.ASSERT_EXP__SEVERITY);
		changeOfDefaultValue(differences, helper, ImperativeOCLPackage.Literals.VARIABLE_INIT_EXP__WITH_RESULT);

		extraObject(differences, helper, getClass(rightPackage, "TemplateParameterType"));
		extraObject(differences, helper, getFeature(getClass(rightPackage, "TemplateParameterType"), "specification"));
		missingClass(differences, helper, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP);
		missingObject(differences, helper, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP__ELEMENT);
		missingOppositeAnnotation(differences, helper, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP__ELEMENT);
		changeOfListObject(differences, helper, ImperativeOCLPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS, ImperativeOCLPackage.Literals.LIST_LITERAL_EXP, getClass(rightPackage, "TemplateParameterType"));		

		extraListObject(differences, helper, ImperativeOCLPackage.Literals.SWITCH_EXP, EcorePackage.Literals.ECLASS__ESUPER_TYPES, getClass(rightPackage, "SwitchExp").getESuperTypes().get(0));		
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		EssentialOCLConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2RoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfPrefix(differences, helper, ImperativeOCLPackage.eINSTANCE);			
		return differences;
	}

	@Override
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		IMappingMetaDataRegistry mappingMetaDataRegistry = super.getMappingMetaDataRegistry();
		ImperativeOCLMappingMetaData.INSTANCE.getFactory(mappingMetaDataRegistry);
		return mappingMetaDataRegistry;
	}

	@Override
	public String getPackageName() {
		return IMPERATIVE_OCL_PACKAGE_NAME;
	}

	@Override
	protected void installEcoreEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEcoreEclipseMappings(comparator, resourceSet);
		EPackage imperativeOCLPackage = getPackage(resourceSet, IMPERATIVE_OCL_PACKAGE_NAME);
		comparator.putEquivalence(org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage.eINSTANCE, imperativeOCLPackage);
//		if (isOMG)
//			comparator.putEquivalence(org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage.Literals.TRY_EXP__EXCEPT_CLAUSE, getFeature(getClass(imperativeOCLPackage, "TryExp"), "catchClause"));
	}

	@Override
	protected void installEmofEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofEclipseMappings(comparator, resourceSet);
		comparator.putEquivalence(ImperativeOCLPackage.eINSTANCE, getPackage(resourceSet, IMPERATIVE_OCL_PACKAGE_NAME));
	}

	@Override
	protected void installEmofOmgMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofOmgMappings(comparator, resourceSet);
		EPackage emofPackage = getPackage(resourceSet, IMPERATIVE_OCL_PACKAGE_NAME.toLowerCase());
		comparator.putEquivalence(ImperativeOCLPackage.eINSTANCE, emofPackage);
		comparator.putEquivalence(ImperativeOCLPackage.Literals.LIST_LITERAL_EXP, null);
		comparator.putEquivalence(null, getClass(emofPackage, "TemplateParameterType"));
	}

	@Override
	protected void installEmof2EmofMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmof2EmofMappings(comparator, resourceSet);
		EPackage emofPackage = getPackage(resourceSet, IMPERATIVE_OCL_PACKAGE_NAME.toLowerCase());
		comparator.putEquivalence(ImperativeOCLPackage.eINSTANCE, emofPackage);
		comparator.putEquivalence(ImperativeOCLPackage.Literals.LIST_LITERAL_EXP, null);
		comparator.putEquivalence(null, getClass(emofPackage, "TemplateParameterType"));
	}
	
	public void testImperativeOCLConsistency() throws IOException, MappingConfigurationException {
		Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		htmlStream.setEnabled(false);
		getExpectedDerivedPackageInconsistencies(ecoreInconsistencies, adaptingInconsistencies);
		htmlStream.setEnabled(true);
		ecore2EmofAdapterConsistencyTest(ecoreInconsistencies, adaptingInconsistencies);
		emof2OmgRoseConsistencyTest(ImperativeOCLPackage.eNS_URI, "imperativeocl.ecore");
		emof2OmgEcoreConsistencyTest(ImperativeOCLPackage.eNS_URI, "imperativeocl.ecore");
		emof2OmgEmofConsistencyTest(ImperativeOCLPackage.eNS_URI);
		emof2RoseConsistencyTest(ImperativeOCLPackage.eNS_URI, "ImperativeOCL.ecore");
		ecore2EmofConsistencyTest(org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage.eNS_URI,
				ImperativeOCLPackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.eINSTANCE);
	}
}
