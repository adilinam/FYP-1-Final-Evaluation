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
package rdb.constraints.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import rdb.Element;
import rdb.NamedElement;
import rdb.constraints.CheckConstraint;
import rdb.constraints.ColumnRefConstraint;
import rdb.constraints.Constraint;
import rdb.constraints.ConstraintsPackage;
import rdb.constraints.ForeignKey;
import rdb.constraints.Index;
import rdb.constraints.IndexedColumn;
import rdb.constraints.PrimaryKey;
import rdb.constraints.UniqueConstraint;

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
 * @see rdb.constraints.ConstraintsPackage
 * @generated
 */
public class ConstraintsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static ConstraintsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ConstraintsSwitch() {
		if (modelPackage == null) {
			modelPackage = ConstraintsPackage.eINSTANCE;
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
			case ConstraintsPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = caseNamedElement(constraint);
				if (result == null) result = caseElement(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintsPackage.CHECK_CONSTRAINT: {
				CheckConstraint checkConstraint = (CheckConstraint)theEObject;
				T result = caseCheckConstraint(checkConstraint);
				if (result == null) result = caseConstraint(checkConstraint);
				if (result == null) result = caseNamedElement(checkConstraint);
				if (result == null) result = caseElement(checkConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT: {
				ColumnRefConstraint columnRefConstraint = (ColumnRefConstraint)theEObject;
				T result = caseColumnRefConstraint(columnRefConstraint);
				if (result == null) result = caseConstraint(columnRefConstraint);
				if (result == null) result = caseNamedElement(columnRefConstraint);
				if (result == null) result = caseElement(columnRefConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintsPackage.UNIQUE_CONSTRAINT: {
				UniqueConstraint uniqueConstraint = (UniqueConstraint)theEObject;
				T result = caseUniqueConstraint(uniqueConstraint);
				if (result == null) result = caseColumnRefConstraint(uniqueConstraint);
				if (result == null) result = caseConstraint(uniqueConstraint);
				if (result == null) result = caseNamedElement(uniqueConstraint);
				if (result == null) result = caseElement(uniqueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintsPackage.PRIMARY_KEY: {
				PrimaryKey primaryKey = (PrimaryKey)theEObject;
				T result = casePrimaryKey(primaryKey);
				if (result == null) result = caseUniqueConstraint(primaryKey);
				if (result == null) result = caseColumnRefConstraint(primaryKey);
				if (result == null) result = caseConstraint(primaryKey);
				if (result == null) result = caseNamedElement(primaryKey);
				if (result == null) result = caseElement(primaryKey);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintsPackage.FOREIGN_KEY: {
				ForeignKey foreignKey = (ForeignKey)theEObject;
				T result = caseForeignKey(foreignKey);
				if (result == null) result = caseColumnRefConstraint(foreignKey);
				if (result == null) result = caseConstraint(foreignKey);
				if (result == null) result = caseNamedElement(foreignKey);
				if (result == null) result = caseElement(foreignKey);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintsPackage.INDEX: {
				Index index = (Index)theEObject;
				T result = caseIndex(index);
				if (result == null) result = caseConstraint(index);
				if (result == null) result = caseNamedElement(index);
				if (result == null) result = caseElement(index);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintsPackage.INDEXED_COLUMN: {
				IndexedColumn indexedColumn = (IndexedColumn)theEObject;
				T result = caseIndexedColumn(indexedColumn);
				if (result == null) result = caseNamedElement(indexedColumn);
				if (result == null) result = caseElement(indexedColumn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Check Constraint</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Check Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseCheckConstraint(CheckConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Column Ref Constraint</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Column Ref Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseColumnRefConstraint(ColumnRefConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Unique Constraint</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Unique Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseUniqueConstraint(UniqueConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Primary Key</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Primary Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T casePrimaryKey(PrimaryKey object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Foreign Key</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Foreign Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseForeignKey(ForeignKey object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Index</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Index</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseIndex(Index object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Indexed Column</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Indexed Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseIndexedColumn(IndexedColumn object) {
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

} //ConstraintsSwitch
