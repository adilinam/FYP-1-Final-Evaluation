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
 * $Id: ModuleUsageCS.java,v 1.3 2010/01/29 15:23:42 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.cst.CSTNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Usage CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS#getImportKind <em>Import Kind</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS#getModuleKindCS <em>Module Kind CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS#getModuleRefs <em>Module Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getModuleUsageCS()
 * @model
 * @generated
 */
public interface ModuleUsageCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Import Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Kind</em>' attribute.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum
	 * @see #setImportKind(ImportKindEnum)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getModuleUsageCS_ImportKind()
	 * @model
	 * @generated
	 */
	ImportKindEnum getImportKind();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS#getImportKind <em>Import Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Kind</em>' attribute.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum
	 * @see #getImportKind()
	 * @generated
	 */
	void setImportKind(ImportKindEnum value);

	/**
	 * Returns the value of the '<em><b>Module Kind CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Kind CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Kind CS</em>' containment reference.
	 * @see #setModuleKindCS(ModuleKindCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getModuleUsageCS_ModuleKindCS()
	 * @model containment="true"
	 * @generated
	 */
	ModuleKindCS getModuleKindCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS#getModuleKindCS <em>Module Kind CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module Kind CS</em>' containment reference.
	 * @see #getModuleKindCS()
	 * @generated
	 */
	void setModuleKindCS(ModuleKindCS value);

	/**
	 * Returns the value of the '<em><b>Module Refs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Refs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Refs</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getModuleUsageCS_ModuleRefs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ModuleRefCS> getModuleRefs();

} // ModuleUsageCS
