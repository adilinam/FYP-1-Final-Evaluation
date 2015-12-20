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
 * $Id: ParameterDeclarationCS.java,v 1.3 2010/01/29 15:23:42 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getTypeSpecCS <em>Type Spec CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getDirectionKind <em>Direction Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getParameterDeclarationCS()
 * @model
 * @generated
 */
public interface ParameterDeclarationCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Name CS</em>' containment reference.
	 * @see #setSimpleNameCS(SimpleNameCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getParameterDeclarationCS_SimpleNameCS()
	 * @model containment="true"
	 * @generated
	 */
	SimpleNameCS getSimpleNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getSimpleNameCS <em>Simple Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name CS</em>' containment reference.
	 * @see #getSimpleNameCS()
	 * @generated
	 */
	void setSimpleNameCS(SimpleNameCS value);

	/**
	 * Returns the value of the '<em><b>Type Spec CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Spec CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Spec CS</em>' containment reference.
	 * @see #setTypeSpecCS(TypeSpecCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getParameterDeclarationCS_TypeSpecCS()
	 * @model containment="true"
	 * @generated
	 */
	TypeSpecCS getTypeSpecCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getTypeSpecCS <em>Type Spec CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Spec CS</em>' containment reference.
	 * @see #getTypeSpecCS()
	 * @generated
	 */
	void setTypeSpecCS(TypeSpecCS value);

	/**
	 * Returns the value of the '<em><b>Direction Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction Kind</em>' attribute.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum
	 * @see #isSetDirectionKind()
	 * @see #unsetDirectionKind()
	 * @see #setDirectionKind(DirectionKindEnum)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getParameterDeclarationCS_DirectionKind()
	 * @model unsettable="true"
	 * @generated
	 */
	DirectionKindEnum getDirectionKind();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getDirectionKind <em>Direction Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction Kind</em>' attribute.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum
	 * @see #isSetDirectionKind()
	 * @see #unsetDirectionKind()
	 * @see #getDirectionKind()
	 * @generated
	 */
	void setDirectionKind(DirectionKindEnum value);

	/**
	 * Unsets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getDirectionKind <em>Direction Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDirectionKind()
	 * @see #getDirectionKind()
	 * @see #setDirectionKind(DirectionKindEnum)
	 * @generated
	 */
	void unsetDirectionKind();

	/**
	 * Returns whether the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS#getDirectionKind <em>Direction Kind</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Direction Kind</em>' attribute is set.
	 * @see #unsetDirectionKind()
	 * @see #getDirectionKind()
	 * @see #setDirectionKind(DirectionKindEnum)
	 * @generated
	 */
	boolean isSetDirectionKind();

} // ParameterDeclarationCS
