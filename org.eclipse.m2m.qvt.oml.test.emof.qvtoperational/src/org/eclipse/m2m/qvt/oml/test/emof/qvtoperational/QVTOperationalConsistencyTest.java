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
package org.eclipse.m2m.qvt.oml.test.emof.qvtoperational;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.util.QVTOperationalMappingMetaData;
import org.eclipse.m2m.qvt.oml.test.emof.imperativeocl.ImperativeOCLConsistencyTest;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.test.emof.emof.EMOFConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.AbstractEssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.EssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.qvtrelation.QVTRelationConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreDifference;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceHelper;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public class QVTOperationalConsistencyTest extends AbstractEssentialOCLConsistencyTest
{	
	public static void expectedEcoreDifferences(EquivalenceHelper helper, Set<EcoreDifference> differences, ResourceSet rightResourceSet) {
		changeOfURI(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.eINSTANCE);
		changeOfPrefix(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.eINSTANCE);			
		//
		//	EMOF to Ecore
		//
		changeOfObject(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.MODULE__OWNED_TAG, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		//
		//	Ecore limitation on EBoolean rather than EBooleanObject
		//
		changeOfUnsettable(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.HELPER__IS_QUERY);
		changeOfUnsettable(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__IS_BLACKBOX);
		changeOfUnsettable(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.MAPPING_CALL_EXP__IS_STRICT);
		changeOfUnsettable(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.MODULE__IS_BLACKBOX);
		changeOfUnsettable(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.RESOLVE_EXP__IS_DEFERRED);
		changeOfUnsettable(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.RESOLVE_EXP__IS_INVERSE);
		changeOfUnsettable(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.RESOLVE_EXP__ONE);
		//
		//	Ecore added value
		//
		missingConstraint(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.ENTRY_OPERATION);
		missingConstraint(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.IMPERATIVE_CALL_EXP);
		missingConstraint(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.MODULE);
		missingConstraint(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.OBJECT_EXP);
		missingConstraint(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION);
		missingConstraint(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.RESOLVE_EXP);
		missingConstraint(differences, helper, org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.Literals.RESOLVE_IN_EXP);
	}

	@Override
	protected Set<EcoreDifference> getExpectedEcore2EmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		QVTOperationalConsistencyTest.expectedEcoreDifferences(helper, differences, rightResourceSet);
		helper.setLogStream(null);
		EssentialOCLConsistencyTest.expectedEcoreDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEcore2RoseDifferences(helper, differences, rightResourceSet);		
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEcoreDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfURI(differences, helper, QVTOperationalPackage.eINSTANCE);
		changeOfPrefix(differences, helper, QVTOperationalPackage.eINSTANCE);
		changeOfName(differences, helper, QVTOperationalPackage.eINSTANCE);
		changeOfName(differences, helper, QVTOperationalPackage.Literals.MAPPING_PARAMETER__REFERRED_DOMAIN);
		changeOfMappedObject(differences, helper, QVTOperationalPackage.Literals.MODULE__ENTRY, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		changeOfList(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_CALL_EXP, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfList(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfList(differences, helper, QVTOperationalPackage.Literals.MODEL_TYPE, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfList(differences, helper, QVTOperationalPackage.Literals.RESOLVE_EXP, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfUpper(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__WHEN);
		changeOfUpper(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__WHERE);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODEL_TYPE__METAMODEL);		
		changeOfDefaultValue(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_CALL_EXP__IS_VIRTUAL);
		changeOfDefaultValue(differences, helper, QVTOperationalPackage.Literals.MODEL_TYPE__CONFORMANCE_KIND);
		changeOfOrdered(differences, helper, QVTOperationalPackage.Literals.MODULE__OWNED_VARIABLE);
		changeOfOrdered(differences, helper, QVTOperationalPackage.Literals.OPERATION_BODY__VARIABLE);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.CONTEXTUAL_PROPERTY__INIT_EXPRESSION);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.CONTEXTUAL_PROPERTY__OVERRIDDEN);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__OVERRIDDEN);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_BODY__END_SECTION);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_BODY__INIT_SECTION);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__DISJUNCT);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__INHERITED);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__MERGED);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__REFINED_RELATION);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__WHEN);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__WHERE);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_PARAMETER__REFERRED_DOMAIN);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MODEL_TYPE__ADDITIONAL_CONDITION);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MODULE_IMPORT__IMPORTED_MODULE);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MODULE__ENTRY);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MODULE__OWNED_TAG);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MODULE__OWNED_VARIABLE);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OBJECT_EXP__REFERRED_OBJECT);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATION_BODY__VARIABLE);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_CLASS);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_PROPERTY);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__MODEL_PARAMETER);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__REFINED);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__RELATION);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.RESOLVE_IN_EXP__IN_MAPPING);
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		QVTRelationConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		ImperativeOCLConsistencyTest.expectedEmofDifferences(differences, helper, rightPackage.eResource().getResourceSet());
		EssentialOCLConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		missingURI(differences, helper, QVTOperationalPackage.eINSTANCE);
		changeOfName(differences, helper, QVTOperationalPackage.eINSTANCE);
		changeOfName(differences, helper, QVTOperationalPackage.Literals.MAPPING_PARAMETER__REFERRED_DOMAIN);
		changeOfMappedObject(differences, helper, QVTOperationalPackage.Literals.MODULE__ENTRY, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		changeOfList(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_CALL_EXP, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfList(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfList(differences, helper, QVTOperationalPackage.Literals.MODEL_TYPE, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfList(differences, helper, QVTOperationalPackage.Literals.RESOLVE_EXP, EcorePackage.Literals.ECLASS__ESUPER_TYPES);

		changeOfSize(differences, helper, QVTOperationalPackage.Literals.DIRECTION_KIND, EcorePackage.Literals.EENUM__ELITERALS);
		missingEnumerationLiteral(differences, helper, QVTOperationalPackage.Literals.DIRECTION_KIND.getEEnumLiteral("in"));
		missingEnumerationLiteral(differences, helper, QVTOperationalPackage.Literals.DIRECTION_KIND.getEEnumLiteral("inout"));
		missingEnumerationLiteral(differences, helper, QVTOperationalPackage.Literals.DIRECTION_KIND.getEEnumLiteral("out"));
		changeOfSize(differences, helper, QVTOperationalPackage.Literals.IMPORT_KIND, EcorePackage.Literals.EENUM__ELITERALS);
		missingEnumerationLiteral(differences, helper, QVTOperationalPackage.Literals.IMPORT_KIND.getEEnumLiteral("access"));
		missingEnumerationLiteral(differences, helper, QVTOperationalPackage.Literals.IMPORT_KIND.getEEnumLiteral("extension"));
		
		changeOfDefaultValue(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_CALL_EXP__IS_VIRTUAL);
		changeOfDefaultValue(differences, helper, QVTOperationalPackage.Literals.MODEL_TYPE__CONFORMANCE_KIND);

		changeOfTransient(differences, helper, QVTOperationalPackage.Literals.MODULE_IMPORT__MODULE);
		changeOfTransient(differences, helper, QVTOperationalPackage.Literals.OPERATION_BODY__OPERATION);
		changeOfTransient(differences, helper, QVTOperationalPackage.Literals.VAR_PARAMETER__CTX_OWNER);
		changeOfTransient(differences, helper, QVTOperationalPackage.Literals.VAR_PARAMETER__RES_OWNER);
		changeOfUpper(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__WHEN);
		changeOfUpper(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__WHERE);

		changeOfLower(differences, helper, QVTOperationalPackage.Literals.CONTEXTUAL_PROPERTY__INIT_EXPRESSION);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.CONTEXTUAL_PROPERTY__OVERRIDDEN);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.HELPER__IS_QUERY);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_CALL_EXP__IS_VIRTUAL);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__BODY);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__CONTEXT);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__IS_BLACKBOX);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__OVERRIDDEN);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__RESULT);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MAPPING_BODY__END_SECTION);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MAPPING_BODY__INIT_SECTION);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MAPPING_CALL_EXP__IS_STRICT);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__DISJUNCT);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MAPPING_PARAMETER__EXTENT);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__INHERITED);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__MERGED);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__REFINED_RELATION);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__WHEN);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__WHERE);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MAPPING_PARAMETER__REFERRED_DOMAIN);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODEL_TYPE__ADDITIONAL_CONDITION);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODEL_TYPE__CONFORMANCE_KIND);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODULE_IMPORT__BINDING);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODULE_IMPORT__KIND);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODULE_IMPORT__MODULE);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODULE__CONFIG_PROPERTY);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODULE__ENTRY);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODULE__IS_BLACKBOX);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODULE__MODULE_IMPORT);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODULE__OWNED_TAG);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODULE__OWNED_VARIABLE);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODULE__USED_MODEL_TYPE);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.OPERATION_BODY__OPERATION);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.OPERATION_BODY__VARIABLE);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_CLASS);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_PROPERTY);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__MODEL_PARAMETER);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__REFINED);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__RELATION);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.RESOLVE_EXP__IS_DEFERRED);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.RESOLVE_EXP__IS_INVERSE);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.RESOLVE_EXP__ONE);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.RESOLVE_EXP__TARGET);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.RESOLVE_IN_EXP__IN_MAPPING);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.VAR_PARAMETER__CTX_OWNER);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.VAR_PARAMETER__KIND);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.VAR_PARAMETER__RES_OWNER);

		missingOpposite(differences, helper, QVTOperationalPackage.Literals.CONTEXTUAL_PROPERTY__INIT_EXPRESSION);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.CONTEXTUAL_PROPERTY__OVERRIDDEN);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__OVERRIDDEN);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_BODY__END_SECTION);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_BODY__INIT_SECTION);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__DISJUNCT);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__INHERITED);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__MERGED);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__REFINED_RELATION);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__WHEN);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION__WHERE);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MAPPING_PARAMETER__REFERRED_DOMAIN);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MODEL_TYPE__ADDITIONAL_CONDITION);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MODULE_IMPORT__IMPORTED_MODULE);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MODULE__ENTRY);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MODULE__OWNED_TAG);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.MODULE__OWNED_VARIABLE);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OBJECT_EXP__REFERRED_OBJECT);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATION_BODY__VARIABLE);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_CLASS);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__INTERMEDIATE_PROPERTY);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__MODEL_PARAMETER);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__REFINED);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION__RELATION);
		missingOpposite(differences, helper, QVTOperationalPackage.Literals.RESOLVE_IN_EXP__IN_MAPPING);
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
//		missingOppositeAnnotation(differences, helper, QVTOperationalPackage.Literals.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION);
		missingPrefix(differences, helper, QVTOperationalPackage.eINSTANCE);
		QVTRelationConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		ImperativeOCLConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		EssentialOCLConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgRoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfPrefix(differences, helper, QVTOperationalPackage.eINSTANCE);
		changeOfURI(differences, helper, QVTOperationalPackage.eINSTANCE);
		changeOfName(differences, helper, QVTOperationalPackage.eINSTANCE);
		changeOfName(differences, helper, QVTOperationalPackage.Literals.MAPPING_PARAMETER__REFERRED_DOMAIN);
		changeOfList(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_CALL_EXP, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfList(differences, helper, QVTOperationalPackage.Literals.MAPPING_OPERATION, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfList(differences, helper, QVTOperationalPackage.Literals.MODEL_TYPE, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfList(differences, helper, QVTOperationalPackage.Literals.RESOLVE_EXP, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfMappedObject(differences, helper, QVTOperationalPackage.Literals.MODULE__ENTRY, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		changeOfLower(differences, helper, QVTOperationalPackage.Literals.MODEL_TYPE__METAMODEL);		
		changeOfDefaultValue(differences, helper, QVTOperationalPackage.Literals.IMPERATIVE_CALL_EXP__IS_VIRTUAL);
		changeOfDefaultValue(differences, helper, QVTOperationalPackage.Literals.MODEL_TYPE__CONFORMANCE_KIND);
		changeOfOrdered(differences, helper, QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT);
		changeOfOppositeAnnotation(differences, helper, QVTOperationalPackage.Literals.MAPPING_PARAMETER__REFERRED_DOMAIN, getFeature(getClass(rightPackage, "MappingParameter"), "refinedDomain"));
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		QVTRelationConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		ImperativeOCLConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		EssentialOCLConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2RoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfPrefix(differences, helper, QVTOperationalPackage.eINSTANCE);			
		return differences;
	}

	@Override
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		IMappingMetaDataRegistry mappingMetaDataRegistry = super.getMappingMetaDataRegistry();
		QVTOperationalMappingMetaData.INSTANCE.getFactory(mappingMetaDataRegistry);
		return mappingMetaDataRegistry;
	}

	@Override
	public String getPackageName() {
		return QVTOPERATIONAL_PACKAGE_NAME;
	}

	@Override
	protected void installEcoreEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEcoreEclipseMappings(comparator, resourceSet);
		comparator.putEquivalence(org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.eINSTANCE, getPackage(resourceSet, QVTOPERATIONAL_PACKAGE_NAME));
	}

	@Override
	protected void installEmofEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofEclipseMappings(comparator, resourceSet);
		comparator.putEquivalence(QVTOperationalPackage.eINSTANCE, getPackage(resourceSet, QVTOPERATIONAL_PACKAGE_NAME));
	}

	@Override
	protected void installEmofOmgMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofOmgMappings(comparator, resourceSet);

		EPackage emofPackage = getPackage(resourceSet, IMPERATIVE_OCL_PACKAGE_NAME.toLowerCase());
		comparator.putEquivalence(ImperativeOCLPackage.eINSTANCE, emofPackage);
		comparator.putEquivalence(ImperativeOCLPackage.Literals.LIST_LITERAL_EXP, null);
		comparator.putEquivalence(null, getClass(emofPackage, "TemplateParameterType"));
		
		comparator.putEquivalence(QVTRelationPackage.eINSTANCE, getPackage(resourceSet, QVTRELATION_PACKAGE_NAME.toLowerCase()));
		comparator.putEquivalence(QVTOperationalPackage.eINSTANCE, getPackage(resourceSet, QVTOPERATIONAL_PACKAGE_NAME.toLowerCase()));
		comparator.putEquivalence(QVTOperationalPackage.Literals.MAPPING_PARAMETER__REFERRED_DOMAIN, getFeature(getClass(getPackage(resourceSet, QVTOPERATIONAL_PACKAGE_NAME.toLowerCase()), "MappingParameter"), "refinedDomain"));
	}

	@Override
	protected void installEmof2EmofMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmof2EmofMappings(comparator, resourceSet);
		comparator.putEquivalence(ImperativeOCLPackage.eINSTANCE, getPackage(resourceSet, IMPERATIVE_OCL_PACKAGE_NAME.toLowerCase()));
		comparator.putEquivalence(QVTRelationPackage.eINSTANCE, getPackage(resourceSet, QVTRELATION_PACKAGE_NAME.toLowerCase()));
		comparator.putEquivalence(QVTOperationalPackage.eINSTANCE, getPackage(resourceSet, QVTOPERATIONAL_PACKAGE_NAME.toLowerCase()));
		comparator.putEquivalence(QVTOperationalPackage.Literals.MAPPING_PARAMETER__REFERRED_DOMAIN, getFeature(getClass(getPackage(resourceSet, QVTOPERATIONAL_PACKAGE_NAME.toLowerCase()), "MappingParameter"), "refinedDomain"));
	}
	
	public void testQVTOperationalConsistency() throws IOException, MappingConfigurationException {
		Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		htmlStream.setEnabled(false);
		getExpectedDerivedPackageInconsistencies(ecoreInconsistencies, adaptingInconsistencies);
		htmlStream.setEnabled(true);
		ecore2EmofAdapterConsistencyTest(ecoreInconsistencies, adaptingInconsistencies);
		emof2OmgRoseConsistencyTest(QVTOperationalPackage.eNS_URI, "qvtoperational.ecore");
		emof2OmgEcoreConsistencyTest(QVTOperationalPackage.eNS_URI, "qvtoperational.ecore");
		emof2OmgEmofConsistencyTest(QVTOperationalPackage.eNS_URI);
		emof2RoseConsistencyTest(QVTOperationalPackage.eNS_URI, "QVTOperational.ecore");
		ecore2EmofConsistencyTest(org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.eNS_URI,
				QVTOperationalPackage.eINSTANCE,
				org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.eINSTANCE);
	}
}
