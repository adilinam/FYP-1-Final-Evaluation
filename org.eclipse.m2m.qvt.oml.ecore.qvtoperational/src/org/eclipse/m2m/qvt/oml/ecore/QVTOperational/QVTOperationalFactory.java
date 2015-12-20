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
 * $Id: QVTOperationalFactory.java,v 1.1 2008/09/02 20:02:27 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage
 * @generated
 */
public interface QVTOperationalFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTOperationalFactory eINSTANCE = org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.QVTOperationalFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constructor</em>'.
	 * @generated
	 */
	Constructor createConstructor();

	/**
	 * Returns a new object of class '<em>Constructor Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constructor Body</em>'.
	 * @generated
	 */
	ConstructorBody createConstructorBody();

	/**
	 * Returns a new object of class '<em>Contextual Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contextual Property</em>'.
	 * @generated
	 */
	ContextualProperty createContextualProperty();

	/**
	 * Returns a new object of class '<em>Entry Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry Operation</em>'.
	 * @generated
	 */
	EntryOperation createEntryOperation();

	/**
	 * Returns a new object of class '<em>Helper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Helper</em>'.
	 * @generated
	 */
	Helper createHelper();

	/**
	 * Returns a new object of class '<em>Imperative Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Call Exp</em>'.
	 * @generated
	 */
	ImperativeCallExp createImperativeCallExp();

	/**
	 * Returns a new object of class '<em>Imperative Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Operation</em>'.
	 * @generated
	 */
	ImperativeOperation createImperativeOperation();

	/**
	 * Returns a new object of class '<em>Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library</em>'.
	 * @generated
	 */
	Library createLibrary();

	/**
	 * Returns a new object of class '<em>Mapping Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Body</em>'.
	 * @generated
	 */
	MappingBody createMappingBody();

	/**
	 * Returns a new object of class '<em>Mapping Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Call Exp</em>'.
	 * @generated
	 */
	MappingCallExp createMappingCallExp();

	/**
	 * Returns a new object of class '<em>Mapping Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Operation</em>'.
	 * @generated
	 */
	MappingOperation createMappingOperation();

	/**
	 * Returns a new object of class '<em>Mapping Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Parameter</em>'.
	 * @generated
	 */
	MappingParameter createMappingParameter();

	/**
	 * Returns a new object of class '<em>Model Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Parameter</em>'.
	 * @generated
	 */
	ModelParameter createModelParameter();

	/**
	 * Returns a new object of class '<em>Model Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Type</em>'.
	 * @generated
	 */
	ModelType createModelType();

	/**
	 * Returns a new object of class '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module</em>'.
	 * @generated
	 */
	Module createModule();

	/**
	 * Returns a new object of class '<em>Module Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Import</em>'.
	 * @generated
	 */
	ModuleImport createModuleImport();

	/**
	 * Returns a new object of class '<em>Object Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Exp</em>'.
	 * @generated
	 */
	ObjectExp createObjectExp();

	/**
	 * Returns a new object of class '<em>Operation Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Body</em>'.
	 * @generated
	 */
	OperationBody createOperationBody();

	/**
	 * Returns a new object of class '<em>Operational Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operational Transformation</em>'.
	 * @generated
	 */
	OperationalTransformation createOperationalTransformation();

	/**
	 * Returns a new object of class '<em>Resolve Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolve Exp</em>'.
	 * @generated
	 */
	ResolveExp createResolveExp();

	/**
	 * Returns a new object of class '<em>Resolve In Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolve In Exp</em>'.
	 * @generated
	 */
	ResolveInExp createResolveInExp();

	/**
	 * Returns a new object of class '<em>Var Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var Parameter</em>'.
	 * @generated
	 */
	VarParameter createVarParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTOperationalPackage getQVTOperationalPackage();

} //QVTOperationalFactory
