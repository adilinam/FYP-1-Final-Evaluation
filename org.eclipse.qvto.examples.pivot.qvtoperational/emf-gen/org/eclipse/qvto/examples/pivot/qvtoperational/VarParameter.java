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

import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter#getCtxOwner <em>Ctx Owner</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter#getResOwner <em>Res Owner</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getVarParameter()
 * @model
 * @generated
 */
public interface VarParameter extends Variable, Parameter {
	/**
	 * Returns the value of the '<em><b>Ctx Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ctx Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ctx Owner</em>' container reference.
	 * @see #setCtxOwner(ImperativeOperation)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getVarParameter_CtxOwner()
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation#getContext
	 * @model opposite="context" resolveProxies="false"
	 * @generated
	 */
	ImperativeOperation getCtxOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter#getCtxOwner <em>Ctx Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ctx Owner</em>' container reference.
	 * @see #getCtxOwner()
	 * @generated
	 */
	void setCtxOwner(ImperativeOperation value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvto.examples.pivot.qvtoperational.DirectionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.DirectionKind
	 * @see #setKind(DirectionKind)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getVarParameter_Kind()
	 * @model
	 * @generated
	 */
	DirectionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.DirectionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(DirectionKind value);

	/**
	 * Returns the value of the '<em><b>Res Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Res Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Res Owner</em>' container reference.
	 * @see #setResOwner(ImperativeOperation)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getVarParameter_ResOwner()
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation#getResult
	 * @model opposite="result" resolveProxies="false"
	 * @generated
	 */
	ImperativeOperation getResOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter#getResOwner <em>Res Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Res Owner</em>' container reference.
	 * @see #getResOwner()
	 * @generated
	 */
	void setResOwner(ImperativeOperation value);

} // VarParameter
