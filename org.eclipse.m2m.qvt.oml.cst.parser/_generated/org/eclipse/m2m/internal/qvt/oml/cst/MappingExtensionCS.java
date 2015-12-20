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
 * $Id: MappingExtensionCS.java,v 1.2 2010/01/29 15:23:42 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.cst.CSTNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Extension CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS#getMappingIdentifiers <em>Mapping Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingExtensionCS()
 * @model
 * @generated
 */
public interface MappingExtensionCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"disjuncts"</code>.
	 * The literals are from the enumeration {@link org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionKindCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionKindCS
	 * @see #setKind(MappingExtensionKindCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingExtensionCS_Kind()
	 * @model default="disjuncts"
	 * @generated
	 */
	MappingExtensionKindCS getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionKindCS
	 * @see #getKind()
	 * @generated
	 */
	void setKind(MappingExtensionKindCS value);

	/**
	 * Returns the value of the '<em><b>Mapping Identifiers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Identifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Identifiers</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingExtensionCS_MappingIdentifiers()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ScopedNameCS> getMappingIdentifiers();

} // MappingExtensionCS
