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
 * $Id: MappingSectionsCS.java,v 1.2 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.ocl.cst.CSTNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Sections CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS#getMappingInitCS <em>Mapping Init CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS#getMappingBodyCS <em>Mapping Body CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS#getMappingEndCS <em>Mapping End CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingSectionsCS()
 * @model
 * @generated
 */
public interface MappingSectionsCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Mapping Init CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Init CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Init CS</em>' containment reference.
	 * @see #setMappingInitCS(MappingInitCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingSectionsCS_MappingInitCS()
	 * @model containment="true"
	 * @generated
	 */
	MappingInitCS getMappingInitCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS#getMappingInitCS <em>Mapping Init CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Init CS</em>' containment reference.
	 * @see #getMappingInitCS()
	 * @generated
	 */
	void setMappingInitCS(MappingInitCS value);

	/**
	 * Returns the value of the '<em><b>Mapping Body CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Body CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Body CS</em>' containment reference.
	 * @see #setMappingBodyCS(MappingBodyCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingSectionsCS_MappingBodyCS()
	 * @model containment="true"
	 * @generated
	 */
	MappingBodyCS getMappingBodyCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS#getMappingBodyCS <em>Mapping Body CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Body CS</em>' containment reference.
	 * @see #getMappingBodyCS()
	 * @generated
	 */
	void setMappingBodyCS(MappingBodyCS value);

	/**
	 * Returns the value of the '<em><b>Mapping End CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping End CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping End CS</em>' containment reference.
	 * @see #setMappingEndCS(MappingEndCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingSectionsCS_MappingEndCS()
	 * @model containment="true"
	 * @generated
	 */
	MappingEndCS getMappingEndCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS#getMappingEndCS <em>Mapping End CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping End CS</em>' containment reference.
	 * @see #getMappingEndCS()
	 * @generated
	 */
	void setMappingEndCS(MappingEndCS value);

} // MappingSectionsCS
