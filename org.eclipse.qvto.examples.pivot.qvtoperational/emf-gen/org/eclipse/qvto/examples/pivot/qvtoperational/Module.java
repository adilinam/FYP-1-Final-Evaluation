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
package org.eclipse.qvto.examples.pivot.qvtoperational;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.Module#getConfigProperty <em>Config Property</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.Module#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.Module#isIsBlackbox <em>Is Blackbox</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.Module#getModuleImport <em>Module Import</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.Module#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.Module#getOwnedVariable <em>Owned Variable</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.Module#getUsedModelType <em>Used Model Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends org.eclipse.ocl.pivot.Class {
	/**
	 * Returns the value of the '<em><b>Config Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config Property</em>' reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getModule_ConfigProperty()
	 * @model
	 * @generated
	 */
	EList<Property> getConfigProperty();

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
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getModule_Entry()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='entryContext'"
	 * @generated
	 */
	EntryOperation getEntry();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.Module#getEntry <em>Entry</em>}' reference.
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
	 * @see #setIsBlackbox(boolean)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getModule_IsBlackbox()
	 * @model dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsBlackbox();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.Module#isIsBlackbox <em>Is Blackbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Blackbox</em>' attribute.
	 * @see #isIsBlackbox()
	 * @generated
	 */
	void setIsBlackbox(boolean value);

	/**
	 * Returns the value of the '<em><b>Module Import</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Import</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Import</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getModule_ModuleImport()
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport#getModule
	 * @model opposite="module" containment="true"
	 * @generated
	 */
	EList<ModuleImport> getModuleImport();

	/**
	 * Returns the value of the '<em><b>Owned Tag</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.TemplateableElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tag</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getModule_OwnedTag()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='owner'"
	 * @generated
	 */
	EList<TemplateableElement> getOwnedTag();

	/**
	 * Returns the value of the '<em><b>Owned Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Variable</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getModule_OwnedVariable()
	 * @model containment="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='variableOwner'"
	 * @generated
	 */
	EList<Variable> getOwnedVariable();

	/**
	 * Returns the value of the '<em><b>Used Model Type</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvto.examples.pivot.qvtoperational.ModelType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Model Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Model Type</em>' reference list.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getModule_UsedModelType()
	 * @model
	 * @generated
	 */
	EList<ModelType> getUsedModelType();

} // Module
