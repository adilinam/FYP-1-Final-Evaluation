/*******************************************************************************
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     A. Sanchez-Barbudo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.util;

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLFactory;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EMOF.util.AbstractEMOFMappingMetaData;
import org.eclipse.qvt.declarative.emof.EssentialOCL.util.EssentialOCLMappingMetaData;

/**
 * ImperativeOCLMappingMetaData defines the mapping between an EMOF-based Imperative OCL
 * adapting model and an Ecore-based EQVT imperative OCL model.
 * The mapping is established by adapting model elements that adapt their Ecore counterparts.
 * The mapping is established lazily, typically by invoking load or save on an
 * AdaptingXMIResource.
 */
public class ImperativeOCLMappingMetaData extends AbstractEMOFMappingMetaData
{
	protected static class Factory extends AbstractEMOFMappingMetaData.Factory
	{
		protected Factory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, ImperativeOCLMappingMetaData mappingMetaData) {
			super(mappingMetaDataRegistry, mappingMetaData);
		}
		
		@Override
		public EObject create(EClass ecoreClass) {
			if (ecoreClass.getEPackage() == org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.eINSTANCE) {
				switch (ecoreClass.getClassifierID()) {
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.ALT_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createAltExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.ASSERT_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createAssertExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.ASSIGN_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createAssignExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.BLOCK_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createBlockExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.BREAK_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createBreakExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.CATCH_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createCatchExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.COMPUTE_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createComputeExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.CONTINUE_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createContinueExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.DICTIONARY_TYPE: return getAdapter(ImperativeOCLFactory.eINSTANCE.createDictionaryType());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.DICT_LITERAL_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createDictLiteralExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.DICT_LITERAL_PART: return getAdapter(ImperativeOCLFactory.eINSTANCE.createDictLiteralPart());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.FOR_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createForExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.IMPERATIVE_ITERATE_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createImperativeIterateExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.INSTANTIATION_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createInstantiationExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.LIST_LITERAL_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createListLiteralExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.LIST_TYPE: return getAdapter(ImperativeOCLFactory.eINSTANCE.createListType());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.LOG_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createLogExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.ORDERED_TUPLE_LITERAL_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createOrderedTupleLiteralExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.ORDERED_TUPLE_LITERAL_PART: return getAdapter(ImperativeOCLFactory.eINSTANCE.createOrderedTupleLiteralPart());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.ORDERED_TUPLE_TYPE: return getAdapter(ImperativeOCLFactory.eINSTANCE.createOrderedTupleType());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.RAISE_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createRaiseExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.RETURN_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createReturnExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.SWITCH_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createSwitchExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.TRY_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createTryExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.TYPEDEF: return getAdapter(ImperativeOCLFactory.eINSTANCE.createTypedef());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.UNLINK_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createUnlinkExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.UNPACK_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createUnpackExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.VARIABLE_INIT_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createVariableInitExp());
					case org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.WHILE_EXP: return getAdapter(ImperativeOCLFactory.eINSTANCE.createWhileExp());				
				}
			}
			return super.create(ecoreClass);
		}
	}
	
	public static ImperativeOCLMappingMetaData INSTANCE = new ImperativeOCLMappingMetaData(
			org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.eINSTANCE,
			org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage.eINSTANCE,
			null);
		
	public ImperativeOCLMappingMetaData(EPackage adaptingEPackage, EPackage ecoreEPackage, String[] uriAliases) {
		super(adaptingEPackage, ecoreEPackage, uriAliases);
	}

	@Override
	protected List<IMappingMetaData> computeImports(Stack<IMappingMetaData> forMappingMetaDatas) {
		List<IMappingMetaData> imports = super.computeImports(forMappingMetaDatas);
		return computeImports(forMappingMetaDatas, imports, EssentialOCLMappingMetaData.INSTANCE);
	}

	public Factory createFactory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		return new Factory(mappingMetaDataRegistry, this);
	}
	
	@Override
	public String getAdaptingContentTypeIdentifier() {
		return org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.eCONTENT_TYPE;
	}
	
	@Override
	public Resource.Factory getAdaptingResourceFactory(IMappingMetaDataRegistry mappingMetaDataRegistry) {
		return new ImperativeOCLResourceFactoryImpl(mappingMetaDataRegistry);
	}
	
	@Override
	public String getEcoreContentTypeIdentifier() {
		return org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage.eCONTENT_TYPE;
	}
	
	public void initialize(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		mappingMetaDataRegistry.installPackagePair(this,
				org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage.eINSTANCE,
				org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage.eINSTANCE);
	}
}
