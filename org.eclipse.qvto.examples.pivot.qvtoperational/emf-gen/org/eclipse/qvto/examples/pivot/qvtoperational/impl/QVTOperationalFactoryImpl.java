/**
 * <copyright>
 * Copyright (c) 2013 Willink Transformations, University of York, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo (University of York) - Bug397429
 * </copyright>
 */
package org.eclipse.qvto.examples.pivot.qvtoperational.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvto.examples.pivot.qvtoperational.Constructor;
import org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty;
import org.eclipse.qvto.examples.pivot.qvtoperational.DirectionKind;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.Helper;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImportKind;
import org.eclipse.qvto.examples.pivot.qvtoperational.Library;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelType;
import org.eclipse.qvto.examples.pivot.qvtoperational.Module;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport;
import org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalFactory;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.Tag;
import org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTOperationalFactoryImpl extends EFactoryImpl implements QVTOperationalFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTOperationalFactory init() {
		try {
			QVTOperationalFactory theQVTOperationalFactory = (QVTOperationalFactory)EPackage.Registry.INSTANCE.getEFactory(QVTOperationalPackage.eNS_URI);
			if (theQVTOperationalFactory != null) {
				return theQVTOperationalFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTOperationalFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTOperationalFactoryImpl() {
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
			case QVTOperationalPackage.CONSTRUCTOR: return createConstructor();
			case QVTOperationalPackage.CONSTRUCTOR_BODY: return createConstructorBody();
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY: return createContextualProperty();
			case QVTOperationalPackage.DUMMY_RELATION: return createDummyRelation();
			case QVTOperationalPackage.DUMMY_RELATION_DOMAIN: return createDummyRelationDomain();
			case QVTOperationalPackage.DUMMY_RELATIONAL_TRANSFORMATION: return createDummyRelationalTransformation();
			case QVTOperationalPackage.ENTRY_OPERATION: return createEntryOperation();
			case QVTOperationalPackage.HELPER: return createHelper();
			case QVTOperationalPackage.IMPERATIVE_CALL_EXP: return createImperativeCallExp();
			case QVTOperationalPackage.IMPERATIVE_OPERATION: return createImperativeOperation();
			case QVTOperationalPackage.LIBRARY: return createLibrary();
			case QVTOperationalPackage.MAPPING_BODY: return createMappingBody();
			case QVTOperationalPackage.MAPPING_CALL_EXP: return createMappingCallExp();
			case QVTOperationalPackage.MAPPING_OPERATION: return createMappingOperation();
			case QVTOperationalPackage.MAPPING_PARAMETER: return createMappingParameter();
			case QVTOperationalPackage.MODEL_PARAMETER: return createModelParameter();
			case QVTOperationalPackage.MODEL_TYPE: return createModelType();
			case QVTOperationalPackage.MODULE: return createModule();
			case QVTOperationalPackage.MODULE_IMPORT: return createModuleImport();
			case QVTOperationalPackage.OBJECT_EXP: return createObjectExp();
			case QVTOperationalPackage.OPERATION_BODY: return createOperationBody();
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION: return createOperationalTransformation();
			case QVTOperationalPackage.RESOLVE_EXP: return createResolveExp();
			case QVTOperationalPackage.RESOLVE_IN_EXP: return createResolveInExp();
			case QVTOperationalPackage.VAR_PARAMETER: return createVarParameter();
			case QVTOperationalPackage.TAG: return createTag();
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
			case QVTOperationalPackage.DIRECTION_KIND:
				return createDirectionKindFromString(eDataType, initialValue);
			case QVTOperationalPackage.IMPORT_KIND:
				return createImportKindFromString(eDataType, initialValue);
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
			case QVTOperationalPackage.DIRECTION_KIND:
				return convertDirectionKindToString(eDataType, instanceValue);
			case QVTOperationalPackage.IMPORT_KIND:
				return convertImportKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constructor createConstructor() {
		ConstructorImpl constructor = new ConstructorImpl();
		return constructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstructorBody createConstructorBody() {
		ConstructorBodyImpl constructorBody = new ConstructorBodyImpl();
		return constructorBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextualProperty createContextualProperty() {
		ContextualPropertyImpl contextualProperty = new ContextualPropertyImpl();
		return contextualProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DummyRelation createDummyRelation() {
		DummyRelationImpl dummyRelation = new DummyRelationImpl();
		return dummyRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DummyRelationDomain createDummyRelationDomain() {
		DummyRelationDomainImpl dummyRelationDomain = new DummyRelationDomainImpl();
		return dummyRelationDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DummyRelationalTransformation createDummyRelationalTransformation() {
		DummyRelationalTransformationImpl dummyRelationalTransformation = new DummyRelationalTransformationImpl();
		return dummyRelationalTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryOperation createEntryOperation() {
		EntryOperationImpl entryOperation = new EntryOperationImpl();
		return entryOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Helper createHelper() {
		HelperImpl helper = new HelperImpl();
		return helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeCallExp createImperativeCallExp() {
		ImperativeCallExpImpl imperativeCallExp = new ImperativeCallExpImpl();
		return imperativeCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOperation createImperativeOperation() {
		ImperativeOperationImpl imperativeOperation = new ImperativeOperationImpl();
		return imperativeOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library createLibrary() {
		LibraryImpl library = new LibraryImpl();
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingBody createMappingBody() {
		MappingBodyImpl mappingBody = new MappingBodyImpl();
		return mappingBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingCallExp createMappingCallExp() {
		MappingCallExpImpl mappingCallExp = new MappingCallExpImpl();
		return mappingCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingOperation createMappingOperation() {
		MappingOperationImpl mappingOperation = new MappingOperationImpl();
		return mappingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingParameter createMappingParameter() {
		MappingParameterImpl mappingParameter = new MappingParameterImpl();
		return mappingParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelParameter createModelParameter() {
		ModelParameterImpl modelParameter = new ModelParameterImpl();
		return modelParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelType createModelType() {
		ModelTypeImpl modelType = new ModelTypeImpl();
		return modelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module createModule() {
		ModuleImpl module = new ModuleImpl();
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleImport createModuleImport() {
		ModuleImportImpl moduleImport = new ModuleImportImpl();
		return moduleImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectExp createObjectExp() {
		ObjectExpImpl objectExp = new ObjectExpImpl();
		return objectExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationBody createOperationBody() {
		OperationBodyImpl operationBody = new OperationBodyImpl();
		return operationBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationalTransformation createOperationalTransformation() {
		OperationalTransformationImpl operationalTransformation = new OperationalTransformationImpl();
		return operationalTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolveExp createResolveExp() {
		ResolveExpImpl resolveExp = new ResolveExpImpl();
		return resolveExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolveInExp createResolveInExp() {
		ResolveInExpImpl resolveInExp = new ResolveInExpImpl();
		return resolveInExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarParameter createVarParameter() {
		VarParameterImpl varParameter = new VarParameterImpl();
		return varParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag createTag() {
		TagImpl tag = new TagImpl();
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKind createDirectionKindFromString(EDataType eDataType, String initialValue) {
		DirectionKind result = DirectionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportKind createImportKindFromString(EDataType eDataType, String initialValue) {
		ImportKind result = ImportKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImportKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTOperationalPackage getQVTOperationalPackage() {
		return (QVTOperationalPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTOperationalPackage getPackage() {
		return QVTOperationalPackage.eINSTANCE;
	}

} //QVTOperationalFactoryImpl
