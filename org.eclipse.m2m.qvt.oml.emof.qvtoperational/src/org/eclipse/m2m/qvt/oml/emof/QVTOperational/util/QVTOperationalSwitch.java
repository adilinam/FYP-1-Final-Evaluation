/**
 * <copyright>
 * </copyright>
 *
 * $Id: QVTOperationalSwitch.java,v 1.3 2009/12/09 14:03:27 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeExpression;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.Constructor;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ConstructorBody;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ContextualProperty;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.EntryOperation;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.Helper;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImperativeCallExp;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImperativeOperation;
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
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveExp;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveInExp;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.VarParameter;
import org.eclipse.qvt.declarative.emof.EMOF.Element;
import org.eclipse.qvt.declarative.emof.EMOF.MultiplicityElement;
import org.eclipse.qvt.declarative.emof.EMOF.NamedElement;
import org.eclipse.qvt.declarative.emof.EMOF.Operation;
import org.eclipse.qvt.declarative.emof.EMOF.Parameter;
import org.eclipse.qvt.declarative.emof.EMOF.Property;
import org.eclipse.qvt.declarative.emof.EMOF.Type;
import org.eclipse.qvt.declarative.emof.EMOF.TypedElement;
import org.eclipse.qvt.declarative.emof.EssentialOCL.CallExp;
import org.eclipse.qvt.declarative.emof.EssentialOCL.FeatureCallExp;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OperationCallExp;
import org.eclipse.qvt.declarative.emof.EssentialOCL.Variable;



/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage
 * @generated
 */
public class QVTOperationalSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTOperationalPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTOperationalSwitch() {
		if (modelPackage == null) {
			modelPackage = QVTOperationalPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case QVTOperationalPackage.CONSTRUCTOR: {
				Constructor constructor = (Constructor)theEObject;
				T result = caseConstructor(constructor);
				if (result == null) result = caseImperativeOperation(constructor);
				if (result == null) result = caseOperation(constructor);
				if (result == null) result = caseTypedElement(constructor);
				if (result == null) result = caseMultiplicityElement(constructor);
				if (result == null) result = caseNamedElement(constructor);
				if (result == null) result = caseElement(constructor);
				if (result == null) result = caseObject(constructor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.CONSTRUCTOR_BODY: {
				ConstructorBody constructorBody = (ConstructorBody)theEObject;
				T result = caseConstructorBody(constructorBody);
				if (result == null) result = caseOperationBody(constructorBody);
				if (result == null) result = caseElement(constructorBody);
				if (result == null) result = caseObject(constructorBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY: {
				ContextualProperty contextualProperty = (ContextualProperty)theEObject;
				T result = caseContextualProperty(contextualProperty);
				if (result == null) result = caseProperty(contextualProperty);
				if (result == null) result = caseTypedElement(contextualProperty);
				if (result == null) result = caseMultiplicityElement(contextualProperty);
				if (result == null) result = caseNamedElement(contextualProperty);
				if (result == null) result = caseElement(contextualProperty);
				if (result == null) result = caseObject(contextualProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.ENTRY_OPERATION: {
				EntryOperation entryOperation = (EntryOperation)theEObject;
				T result = caseEntryOperation(entryOperation);
				if (result == null) result = caseImperativeOperation(entryOperation);
				if (result == null) result = caseOperation(entryOperation);
				if (result == null) result = caseTypedElement(entryOperation);
				if (result == null) result = caseMultiplicityElement(entryOperation);
				if (result == null) result = caseNamedElement(entryOperation);
				if (result == null) result = caseElement(entryOperation);
				if (result == null) result = caseObject(entryOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.HELPER: {
				Helper helper = (Helper)theEObject;
				T result = caseHelper(helper);
				if (result == null) result = caseImperativeOperation(helper);
				if (result == null) result = caseOperation(helper);
				if (result == null) result = caseTypedElement(helper);
				if (result == null) result = caseMultiplicityElement(helper);
				if (result == null) result = caseNamedElement(helper);
				if (result == null) result = caseElement(helper);
				if (result == null) result = caseObject(helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.IMPERATIVE_CALL_EXP: {
				ImperativeCallExp imperativeCallExp = (ImperativeCallExp)theEObject;
				T result = caseImperativeCallExp(imperativeCallExp);
				if (result == null) result = caseOperationCallExp(imperativeCallExp);
				if (result == null) result = caseImperativeExpression(imperativeCallExp);
				if (result == null) result = caseFeatureCallExp(imperativeCallExp);
				if (result == null) result = caseCallExp(imperativeCallExp);
				if (result == null) result = caseOclExpression(imperativeCallExp);
				if (result == null) result = caseTypedElement(imperativeCallExp);
				if (result == null) result = caseNamedElement(imperativeCallExp);
				if (result == null) result = caseElement(imperativeCallExp);
				if (result == null) result = caseObject(imperativeCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.IMPERATIVE_OPERATION: {
				ImperativeOperation imperativeOperation = (ImperativeOperation)theEObject;
				T result = caseImperativeOperation(imperativeOperation);
				if (result == null) result = caseOperation(imperativeOperation);
				if (result == null) result = caseTypedElement(imperativeOperation);
				if (result == null) result = caseMultiplicityElement(imperativeOperation);
				if (result == null) result = caseNamedElement(imperativeOperation);
				if (result == null) result = caseElement(imperativeOperation);
				if (result == null) result = caseObject(imperativeOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.LIBRARY: {
				Library library = (Library)theEObject;
				T result = caseLibrary(library);
				if (result == null) result = caseModule(library);
				if (result == null) result = caseClass(library);
				if (result == null) result = casePackage(library);
				if (result == null) result = caseType(library);
				if (result == null) result = caseNamedElement(library);
				if (result == null) result = caseElement(library);
				if (result == null) result = caseObject(library);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.MAPPING_BODY: {
				MappingBody mappingBody = (MappingBody)theEObject;
				T result = caseMappingBody(mappingBody);
				if (result == null) result = caseOperationBody(mappingBody);
				if (result == null) result = caseElement(mappingBody);
				if (result == null) result = caseObject(mappingBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.MAPPING_CALL_EXP: {
				MappingCallExp mappingCallExp = (MappingCallExp)theEObject;
				T result = caseMappingCallExp(mappingCallExp);
				if (result == null) result = caseImperativeCallExp(mappingCallExp);
				if (result == null) result = caseOperationCallExp(mappingCallExp);
				if (result == null) result = caseImperativeExpression(mappingCallExp);
				if (result == null) result = caseFeatureCallExp(mappingCallExp);
				if (result == null) result = caseCallExp(mappingCallExp);
				if (result == null) result = caseOclExpression(mappingCallExp);
				if (result == null) result = caseTypedElement(mappingCallExp);
				if (result == null) result = caseNamedElement(mappingCallExp);
				if (result == null) result = caseElement(mappingCallExp);
				if (result == null) result = caseObject(mappingCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.MAPPING_OPERATION: {
				MappingOperation mappingOperation = (MappingOperation)theEObject;
				T result = caseMappingOperation(mappingOperation);
				if (result == null) result = caseImperativeOperation(mappingOperation);
				if (result == null) result = caseOperation(mappingOperation);
				if (result == null) result = caseTypedElement(mappingOperation);
				if (result == null) result = caseMultiplicityElement(mappingOperation);
				if (result == null) result = caseNamedElement(mappingOperation);
				if (result == null) result = caseElement(mappingOperation);
				if (result == null) result = caseObject(mappingOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.MAPPING_PARAMETER: {
				MappingParameter mappingParameter = (MappingParameter)theEObject;
				T result = caseMappingParameter(mappingParameter);
				if (result == null) result = caseVarParameter(mappingParameter);
				if (result == null) result = caseVariable(mappingParameter);
				if (result == null) result = caseParameter(mappingParameter);
				if (result == null) result = caseTypedElement(mappingParameter);
				if (result == null) result = caseMultiplicityElement(mappingParameter);
				if (result == null) result = caseNamedElement(mappingParameter);
				if (result == null) result = caseElement(mappingParameter);
				if (result == null) result = caseObject(mappingParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.MODEL_PARAMETER: {
				ModelParameter modelParameter = (ModelParameter)theEObject;
				T result = caseModelParameter(modelParameter);
				if (result == null) result = caseVarParameter(modelParameter);
				if (result == null) result = caseVariable(modelParameter);
				if (result == null) result = caseParameter(modelParameter);
				if (result == null) result = caseTypedElement(modelParameter);
				if (result == null) result = caseMultiplicityElement(modelParameter);
				if (result == null) result = caseNamedElement(modelParameter);
				if (result == null) result = caseElement(modelParameter);
				if (result == null) result = caseObject(modelParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.MODEL_TYPE: {
				ModelType modelType = (ModelType)theEObject;
				T result = caseModelType(modelType);
				if (result == null) result = caseClass(modelType);
				if (result == null) result = caseType(modelType);
				if (result == null) result = caseNamedElement(modelType);
				if (result == null) result = caseElement(modelType);
				if (result == null) result = caseObject(modelType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.MODULE: {
				Module module = (Module)theEObject;
				T result = caseModule(module);
				if (result == null) result = caseClass(module);
				if (result == null) result = casePackage(module);
				if (result == null) result = caseType(module);
				if (result == null) result = caseNamedElement(module);
				if (result == null) result = caseElement(module);
				if (result == null) result = caseObject(module);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.MODULE_IMPORT: {
				ModuleImport moduleImport = (ModuleImport)theEObject;
				T result = caseModuleImport(moduleImport);
				if (result == null) result = caseElement(moduleImport);
				if (result == null) result = caseObject(moduleImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.OBJECT_EXP: {
				ObjectExp objectExp = (ObjectExp)theEObject;
				T result = caseObjectExp(objectExp);
				if (result == null) result = caseInstantiationExp(objectExp);
				if (result == null) result = caseImperativeExpression(objectExp);
				if (result == null) result = caseOclExpression(objectExp);
				if (result == null) result = caseTypedElement(objectExp);
				if (result == null) result = caseNamedElement(objectExp);
				if (result == null) result = caseElement(objectExp);
				if (result == null) result = caseObject(objectExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.OPERATION_BODY: {
				OperationBody operationBody = (OperationBody)theEObject;
				T result = caseOperationBody(operationBody);
				if (result == null) result = caseElement(operationBody);
				if (result == null) result = caseObject(operationBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION: {
				OperationalTransformation operationalTransformation = (OperationalTransformation)theEObject;
				T result = caseOperationalTransformation(operationalTransformation);
				if (result == null) result = caseModule(operationalTransformation);
				if (result == null) result = caseClass(operationalTransformation);
				if (result == null) result = casePackage(operationalTransformation);
				if (result == null) result = caseType(operationalTransformation);
				if (result == null) result = caseNamedElement(operationalTransformation);
				if (result == null) result = caseElement(operationalTransformation);
				if (result == null) result = caseObject(operationalTransformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.RESOLVE_EXP: {
				ResolveExp resolveExp = (ResolveExp)theEObject;
				T result = caseResolveExp(resolveExp);
				if (result == null) result = caseCallExp(resolveExp);
				if (result == null) result = caseImperativeExpression(resolveExp);
				if (result == null) result = caseOclExpression(resolveExp);
				if (result == null) result = caseTypedElement(resolveExp);
				if (result == null) result = caseNamedElement(resolveExp);
				if (result == null) result = caseElement(resolveExp);
				if (result == null) result = caseObject(resolveExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.RESOLVE_IN_EXP: {
				ResolveInExp resolveInExp = (ResolveInExp)theEObject;
				T result = caseResolveInExp(resolveInExp);
				if (result == null) result = caseResolveExp(resolveInExp);
				if (result == null) result = caseCallExp(resolveInExp);
				if (result == null) result = caseImperativeExpression(resolveInExp);
				if (result == null) result = caseOclExpression(resolveInExp);
				if (result == null) result = caseTypedElement(resolveInExp);
				if (result == null) result = caseNamedElement(resolveInExp);
				if (result == null) result = caseElement(resolveInExp);
				if (result == null) result = caseObject(resolveInExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTOperationalPackage.VAR_PARAMETER: {
				VarParameter varParameter = (VarParameter)theEObject;
				T result = caseVarParameter(varParameter);
				if (result == null) result = caseVariable(varParameter);
				if (result == null) result = caseParameter(varParameter);
				if (result == null) result = caseTypedElement(varParameter);
				if (result == null) result = caseMultiplicityElement(varParameter);
				if (result == null) result = caseNamedElement(varParameter);
				if (result == null) result = caseElement(varParameter);
				if (result == null) result = caseObject(varParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstructor(Constructor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstructorBody(ConstructorBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contextual Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contextual Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextualProperty(ContextualProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntryOperation(EntryOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHelper(Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeCallExp(ImperativeCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeOperation(ImperativeOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibrary(Library object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingBody(MappingBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingCallExp(MappingCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingOperation(MappingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingParameter(MappingParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelParameter(ModelParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelType(ModelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModule(Module object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleImport(ModuleImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectExp(ObjectExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationBody(OperationBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operational Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operational Transformation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationalTransformation(OperationalTransformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolve Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolve Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResolveExp(ResolveExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolve In Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolve In Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResolveInExp(ResolveInExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVarParameter(VarParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObject(org.eclipse.qvt.declarative.emof.EMOF.Object object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicity Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicity Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicityElement(MultiplicityElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclExpression(OclExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallExp(CallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureCallExp(FeatureCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCallExp(OperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClass(org.eclipse.qvt.declarative.emof.EMOF.Class object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackage(org.eclipse.qvt.declarative.emof.EMOF.Package object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeExpression(ImperativeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instantiation Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instantiation Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstantiationExp(InstantiationExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //QVTOperationalSwitch
