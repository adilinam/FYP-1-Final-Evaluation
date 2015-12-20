/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 * 
 * 
 *
 * $Id: CompleteSignatureCS.java,v 1.3 2010/01/29 15:23:42 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.cst.CSTNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Signature CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS#getSimpleSignature <em>Simple Signature</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS#getResultParams <em>Result Params</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getCompleteSignatureCS()
 * @model
 * @generated
 */
public interface CompleteSignatureCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Simple Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Signature</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Signature</em>' containment reference.
	 * @see #setSimpleSignature(SimpleSignatureCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getCompleteSignatureCS_SimpleSignature()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SimpleSignatureCS getSimpleSignature();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS#getSimpleSignature <em>Simple Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Signature</em>' containment reference.
	 * @see #getSimpleSignature()
	 * @generated
	 */
	void setSimpleSignature(SimpleSignatureCS value);

	/**
	 * Returns the value of the '<em><b>Result Params</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Params</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getCompleteSignatureCS_ResultParams()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterDeclarationCS> getResultParams();

} // CompleteSignatureCS
