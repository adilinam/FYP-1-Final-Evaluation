/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package rdb.view.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import rdb.Column;
import rdb.Element;
import rdb.NamedColumnSet;
import rdb.NamedElement;
import rdb.SchemaElement;
import rdb.view.ReferencedViewColumn;
import rdb.view.View;
import rdb.view.ViewAlias;
import rdb.view.ViewColumn;
import rdb.view.ViewExpressionColumn;
import rdb.view.ViewPackage;

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
 * @see rdb.view.ViewPackage
 * @generated
 */
public class ViewSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static ViewPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ViewSwitch() {
		if (modelPackage == null) {
			modelPackage = ViewPackage.eINSTANCE;
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
			case ViewPackage.VIEW: {
				View view = (View)theEObject;
				T result = caseView(view);
				if (result == null) result = caseNamedColumnSet(view);
				if (result == null) result = caseSchemaElement(view);
				if (result == null) result = caseNamedElement(view);
				if (result == null) result = caseElement(view);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.VIEW_ALIAS: {
				ViewAlias viewAlias = (ViewAlias)theEObject;
				T result = caseViewAlias(viewAlias);
				if (result == null) result = caseNamedElement(viewAlias);
				if (result == null) result = caseElement(viewAlias);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.VIEW_COLUMN: {
				ViewColumn viewColumn = (ViewColumn)theEObject;
				T result = caseViewColumn(viewColumn);
				if (result == null) result = caseColumn(viewColumn);
				if (result == null) result = caseNamedElement(viewColumn);
				if (result == null) result = caseElement(viewColumn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.VIEW_EXPRESSION_COLUMN: {
				ViewExpressionColumn viewExpressionColumn = (ViewExpressionColumn)theEObject;
				T result = caseViewExpressionColumn(viewExpressionColumn);
				if (result == null) result = caseViewColumn(viewExpressionColumn);
				if (result == null) result = caseColumn(viewExpressionColumn);
				if (result == null) result = caseNamedElement(viewExpressionColumn);
				if (result == null) result = caseElement(viewExpressionColumn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ViewPackage.REFERENCED_VIEW_COLUMN: {
				ReferencedViewColumn referencedViewColumn = (ReferencedViewColumn)theEObject;
				T result = caseReferencedViewColumn(referencedViewColumn);
				if (result == null) result = caseViewColumn(referencedViewColumn);
				if (result == null) result = caseColumn(referencedViewColumn);
				if (result == null) result = caseNamedElement(referencedViewColumn);
				if (result == null) result = caseElement(referencedViewColumn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>View</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseView(View object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Alias</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Alias</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseViewAlias(ViewAlias object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Column</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseViewColumn(ViewColumn object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Expression Column</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Expression Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseViewExpressionColumn(ViewExpressionColumn object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Referenced View Column</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Referenced View Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseReferencedViewColumn(ReferencedViewColumn object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Schema Element</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Schema Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSchemaElement(SchemaElement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Named Column Set</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Named Column Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseNamedColumnSet(NamedColumnSet object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Column</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseColumn(Column object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
    public T defaultCase(EObject object) {
		return null;
	}

} //ViewSwitch
