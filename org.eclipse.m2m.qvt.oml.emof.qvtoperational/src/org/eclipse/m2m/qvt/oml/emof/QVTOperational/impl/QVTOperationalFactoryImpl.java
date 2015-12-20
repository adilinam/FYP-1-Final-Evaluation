/**
 * <copyright>
 * </copyright>
 *
 * $Id: QVTOperationalFactoryImpl.java,v 1.3 2009/12/09 14:03:26 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.Constructor;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ConstructorBody;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ContextualProperty;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.DirectionKind;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.EntryOperation;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.Helper;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImperativeCallExp;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImportKind;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.Library;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.MappingBody;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.MappingCallExp;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.MappingOperation;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.MappingParameter;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModelParameter;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModelType;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.Module;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModuleImport;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ObjectExp;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.OperationBody;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.OperationalTransformation;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalFactory;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveExp;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveInExp;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.VarParameter;

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
			QVTOperationalFactory theQVTOperationalFactory = (QVTOperationalFactory)EPackage.Registry.INSTANCE.getEFactory("http://schema.omg.org/spec/QVT/1.1/qvtoperational.xml"); 
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
