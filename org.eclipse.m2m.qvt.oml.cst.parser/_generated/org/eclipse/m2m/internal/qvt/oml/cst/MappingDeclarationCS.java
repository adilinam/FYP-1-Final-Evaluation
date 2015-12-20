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
 * $Id: MappingDeclarationCS.java,v 1.7 2010/01/29 15:23:42 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TypeCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getQualifiers <em>Qualifiers</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getDirectionKindCS <em>Direction Kind CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getMappingExtension <em>Mapping Extension</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#isIsQuery <em>Is Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingDeclarationCS()
 * @model
 * @generated
 */
public interface MappingDeclarationCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Qualifiers</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS}.
	 * The literals are from the enumeration {@link org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifiers</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifiers</em>' attribute list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingDeclarationCS_Qualifiers()
	 * @model unique="false"
	 * @generated
	 */
	EList<QualifierKindCS> getQualifiers();

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
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingDeclarationCS_SimpleNameCS()
	 * @model containment="true"
	 * @generated
	 */
	SimpleNameCS getSimpleNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getSimpleNameCS <em>Simple Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name CS</em>' containment reference.
	 * @see #getSimpleNameCS()
	 * @generated
	 */
	void setSimpleNameCS(SimpleNameCS value);

	/**
	 * Returns the value of the '<em><b>Context Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Type</em>' containment reference.
	 * @see #setContextType(TypeCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingDeclarationCS_ContextType()
	 * @model containment="true"
	 * @generated
	 */
	TypeCS getContextType();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getContextType <em>Context Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Type</em>' containment reference.
	 * @see #getContextType()
	 * @generated
	 */
	void setContextType(TypeCS value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingDeclarationCS_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterDeclarationCS> getParameters();

	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingDeclarationCS_Result()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterDeclarationCS> getResult();

	/**
	 * Returns the value of the '<em><b>Direction Kind CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction Kind CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction Kind CS</em>' containment reference.
	 * @see #setDirectionKindCS(DirectionKindCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingDeclarationCS_DirectionKindCS()
	 * @model containment="true"
	 * @generated
	 */
	DirectionKindCS getDirectionKindCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#getDirectionKindCS <em>Direction Kind CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction Kind CS</em>' containment reference.
	 * @see #getDirectionKindCS()
	 * @generated
	 */
	void setDirectionKindCS(DirectionKindCS value);

	/**
	 * Returns the value of the '<em><b>Mapping Extension</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Extension</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Extension</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingDeclarationCS_MappingExtension()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingExtensionCS> getMappingExtension();

	/**
	 * Returns the value of the '<em><b>Is Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Query</em>' attribute.
	 * @see #setIsQuery(boolean)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingDeclarationCS_IsQuery()
	 * @model
	 * @generated
	 */
	boolean isIsQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS#isIsQuery <em>Is Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Query</em>' attribute.
	 * @see #isIsQuery()
	 * @generated
	 */
	void setIsQuery(boolean value);

} // MappingDeclarationCS
