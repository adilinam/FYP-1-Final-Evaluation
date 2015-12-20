/*******************************************************************************
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     A. Sanchez-Barbudo  - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.emof.QVTOperational.util;

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalFactory;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.util.ImperativeOCLMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EMOF.util.AbstractEMOFMappingMetaData;
import org.eclipse.qvt.declarative.emof.QVTRelation.util.QVTRelationMappingMetaData;

/**
 * QVTOperationalMappingMetaData defines the mapping between an EMOF-based QVT Operational
 * adapting model and an Ecore-based EQVT Operational model.
 * The mapping is established by adapting model elements that adapt their Ecore counterparts.
 * The mapping is established lazily, typically by invoking load or save on an
 * AdaptingXMIResource.
 */
public class QVTOperationalMappingMetaData extends AbstractEMOFMappingMetaData
{
	protected static class Factory extends AbstractEMOFMappingMetaData.Factory
	{
		protected Factory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, QVTOperationalMappingMetaData mappingMetaData) {
			super(mappingMetaDataRegistry, mappingMetaData);
		}
		
		@Override
		public EObject create(EClass ecoreClass) {
			if (ecoreClass.getEPackage() == org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.eINSTANCE) {
				switch (ecoreClass.getClassifierID()) {
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.CONSTRUCTOR: return getAdapter(QVTOperationalFactory.eINSTANCE.createConstructor());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.CONSTRUCTOR_BODY: return getAdapter(QVTOperationalFactory.eINSTANCE.createConstructorBody());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.CONTEXTUAL_PROPERTY: return getAdapter(QVTOperationalFactory.eINSTANCE.createContextualProperty());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.ENTRY_OPERATION: return getAdapter(QVTOperationalFactory.eINSTANCE.createEntryOperation());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.HELPER: return getAdapter(QVTOperationalFactory.eINSTANCE.createHelper());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.IMPERATIVE_CALL_EXP: return getAdapter(QVTOperationalFactory.eINSTANCE.createImperativeCallExp());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.IMPERATIVE_OPERATION: return getAdapter(QVTOperationalFactory.eINSTANCE.createImperativeOperation());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.LIBRARY: return getAdapter(QVTOperationalFactory.eINSTANCE.createLibrary());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.MAPPING_BODY: return getAdapter(QVTOperationalFactory.eINSTANCE.createMappingBody());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.MAPPING_CALL_EXP: return getAdapter(QVTOperationalFactory.eINSTANCE.createMappingCallExp());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.MAPPING_OPERATION: return getAdapter(QVTOperationalFactory.eINSTANCE.createMappingOperation());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.MAPPING_PARAMETER: return getAdapter(QVTOperationalFactory.eINSTANCE.createMappingParameter());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.MODEL_PARAMETER: return getAdapter(QVTOperationalFactory.eINSTANCE.createModelParameter());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.MODEL_TYPE: return getAdapter(QVTOperationalFactory.eINSTANCE.createModelType());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.MODULE: return getAdapter(QVTOperationalFactory.eINSTANCE.createModule());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.MODULE_IMPORT: return getAdapter(QVTOperationalFactory.eINSTANCE.createModuleImport());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.OBJECT_EXP: return getAdapter(QVTOperationalFactory.eINSTANCE.createObjectExp());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.OPERATIONAL_TRANSFORMATION: return getAdapter(QVTOperationalFactory.eINSTANCE.createOperationalTransformation());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.OPERATION_BODY: return getAdapter(QVTOperationalFactory.eINSTANCE.createOperationBody());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.RESOLVE_EXP: return getAdapter(QVTOperationalFactory.eINSTANCE.createResolveExp());
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.RESOLVE_IN_EXP: return getAdapter(QVTOperationalFactory.eINSTANCE.createResolveInExp());				
					case org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.VAR_PARAMETER: return getAdapter(QVTOperationalFactory.eINSTANCE.createVarParameter());
				}
			}
			return super.create(ecoreClass);
		}
	}

	public static QVTOperationalMappingMetaData INSTANCE = new QVTOperationalMappingMetaData(
			org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.eINSTANCE,
			org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.eINSTANCE,
			null);
	
		
	public QVTOperationalMappingMetaData(EPackage adaptingEPackage, EPackage ecoreEPackage, String[] uriAliases) {
		super(adaptingEPackage, ecoreEPackage, uriAliases);
	}	

	@Override
	protected List<IMappingMetaData> computeImports(Stack<IMappingMetaData> forMappingMetaDatas) {
		List<IMappingMetaData> imports = super.computeImports(forMappingMetaDatas);
		return computeImports(forMappingMetaDatas, imports, ImperativeOCLMappingMetaData.INSTANCE, QVTRelationMappingMetaData.INSTANCE);
	}

	public Factory createFactory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		return new Factory(mappingMetaDataRegistry, this);
	}
	
	@Override
	public String getAdaptingContentTypeIdentifier() {
		return org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.eCONTENT_TYPE;
	}
	
	@Override
	public Resource.Factory getAdaptingResourceFactory(IMappingMetaDataRegistry mappingMetaDataRegistry) {
		return new QVTOperationalResourceFactoryImpl(mappingMetaDataRegistry);
	}
	
	@Override
	public String getEcoreContentTypeIdentifier() {
		return org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.eCONTENT_TYPE;
	}
	
	public void initialize(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		mappingMetaDataRegistry.installPackagePair(this,
				org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage.eINSTANCE,
				org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage.eINSTANCE);
	}
}
