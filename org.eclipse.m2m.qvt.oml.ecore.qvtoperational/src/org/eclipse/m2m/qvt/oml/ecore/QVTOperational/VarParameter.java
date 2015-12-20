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
 * $Id: VarParameter.java,v 1.2 2009/01/25 23:12:24 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational;

import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.VarParameter#getCtxOwner <em>Ctx Owner</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.VarParameter#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.VarParameter#getResOwner <em>Res Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getVarParameter()
 * @model
 * @generated
 */
public interface VarParameter extends Variable, EParameter {
	/**
	 * Returns the value of the '<em><b>Ctx Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ImperativeOperation#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ctx Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ctx Owner</em>' container reference.
	 * @see #setCtxOwner(ImperativeOperation)
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getVarParameter_CtxOwner()
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ImperativeOperation#getContext
	 * @model opposite="context" resolveProxies="false"
	 * @generated
	 */
	ImperativeOperation getCtxOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.VarParameter#getCtxOwner <em>Ctx Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ctx Owner</em>' container reference.
	 * @see #getCtxOwner()
	 * @generated
	 */
	void setCtxOwner(ImperativeOperation value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.DirectionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.DirectionKind
	 * @see #setKind(DirectionKind)
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getVarParameter_Kind()
	 * @model
	 * @generated
	 */
	DirectionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.VarParameter#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.DirectionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(DirectionKind value);

	/**
	 * Returns the value of the '<em><b>Res Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ImperativeOperation#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Res Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Res Owner</em>' container reference.
	 * @see #setResOwner(ImperativeOperation)
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getVarParameter_ResOwner()
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ImperativeOperation#getResult
	 * @model opposite="result" resolveProxies="false"
	 * @generated
	 */
	ImperativeOperation getResOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.VarParameter#getResOwner <em>Res Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Res Owner</em>' container reference.
	 * @see #getResOwner()
	 * @generated
	 */
	void setResOwner(ImperativeOperation value);

} // VarParameter
