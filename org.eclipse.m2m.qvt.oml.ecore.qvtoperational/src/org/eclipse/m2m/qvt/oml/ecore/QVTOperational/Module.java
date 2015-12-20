/**
 * <copyright>
 * Copyright (c) 2008 Open Canarias and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: Module.java,v 1.3 2009/01/25 23:12:24 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module#getConfigProperty <em>Config Property</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module#isIsBlackbox <em>Is Blackbox</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module#getModuleImport <em>Module Import</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module#getOwnedVariable <em>Owned Variable</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module#getUsedModelType <em>Used Model Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getModule()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='WellFormedNsURI WellFormedNsPrefix UniqueNsURIs UniqueOperationSignatures UniqueClassifierNames'"
 * @generated
 */
public interface Module extends EClass, EPackage {
	/**
	 * Returns the value of the '<em><b>Config Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config Property</em>' reference list.
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getModule_ConfigProperty()
	 * @model
	 * @generated
	 */
	EList<EStructuralFeature> getConfigProperty();

	/**
	 * Returns the value of the '<em><b>Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry</em>' reference.
	 * @see #setEntry(EntryOperation)
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getModule_Entry()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='entryContext'"
	 * @generated
	 */
	EntryOperation getEntry();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module#getEntry <em>Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry</em>' reference.
	 * @see #getEntry()
	 * @generated
	 */
	void setEntry(EntryOperation value);

	/**
	 * Returns the value of the '<em><b>Is Blackbox</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Blackbox</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Blackbox</em>' attribute.
	 * @see #isSetIsBlackbox()
	 * @see #unsetIsBlackbox()
	 * @see #setIsBlackbox(boolean)
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getModule_IsBlackbox()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isIsBlackbox();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module#isIsBlackbox <em>Is Blackbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Blackbox</em>' attribute.
	 * @see #isSetIsBlackbox()
	 * @see #unsetIsBlackbox()
	 * @see #isIsBlackbox()
	 * @generated
	 */
	void setIsBlackbox(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module#isIsBlackbox <em>Is Blackbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsBlackbox()
	 * @see #isIsBlackbox()
	 * @see #setIsBlackbox(boolean)
	 * @generated
	 */
	void unsetIsBlackbox();

	/**
	 * Returns whether the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module#isIsBlackbox <em>Is Blackbox</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Blackbox</em>' attribute is set.
	 * @see #unsetIsBlackbox()
	 * @see #isIsBlackbox()
	 * @see #setIsBlackbox(boolean)
	 * @generated
	 */
	boolean isSetIsBlackbox();

	/**
	 * Returns the value of the '<em><b>Module Import</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ModuleImport}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ModuleImport#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Import</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Import</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getModule_ModuleImport()
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ModuleImport#getModule
	 * @model opposite="module" containment="true"
	 * @generated
	 */
	EList<ModuleImport> getModuleImport();

	/**
	 * Returns the value of the '<em><b>Owned Tag</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tag</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getModule_OwnedTag()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='owner'"
	 * @generated
	 */
	EList<EAnnotation> getOwnedTag();

	/**
	 * Returns the value of the '<em><b>Owned Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.ecore.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Variable</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getModule_OwnedVariable()
	 * @model containment="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='variableOwner'"
	 * @generated
	 */
	EList<Variable> getOwnedVariable();

	/**
	 * Returns the value of the '<em><b>Used Model Type</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ModelType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Model Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Model Type</em>' reference list.
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getModule_UsedModelType()
	 * @model
	 * @generated
	 */
	EList<ModelType> getUsedModelType();

} // Module
