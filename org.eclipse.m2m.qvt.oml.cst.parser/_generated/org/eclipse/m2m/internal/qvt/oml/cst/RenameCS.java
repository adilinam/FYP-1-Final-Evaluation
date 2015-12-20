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
 * $Id: RenameCS.java,v 1.2 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TypeCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rename CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.RenameCS#getTypeCS <em>Type CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.RenameCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.RenameCS#getOriginalName <em>Original Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getRenameCS()
 * @model
 * @generated
 */
public interface RenameCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type CS</em>' containment reference.
	 * @see #setTypeCS(TypeCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getRenameCS_TypeCS()
	 * @model containment="true"
	 * @generated
	 */
	TypeCS getTypeCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.RenameCS#getTypeCS <em>Type CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type CS</em>' containment reference.
	 * @see #getTypeCS()
	 * @generated
	 */
	void setTypeCS(TypeCS value);

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
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getRenameCS_SimpleNameCS()
	 * @model containment="true"
	 * @generated
	 */
	SimpleNameCS getSimpleNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.RenameCS#getSimpleNameCS <em>Simple Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name CS</em>' containment reference.
	 * @see #getSimpleNameCS()
	 * @generated
	 */
	void setSimpleNameCS(SimpleNameCS value);

	/**
	 * Returns the value of the '<em><b>Original Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Name</em>' containment reference.
	 * @see #setOriginalName(StringLiteralExpCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getRenameCS_OriginalName()
	 * @model containment="true"
	 * @generated
	 */
	StringLiteralExpCS getOriginalName();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.RenameCS#getOriginalName <em>Original Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Name</em>' containment reference.
	 * @see #getOriginalName()
	 * @generated
	 */
	void setOriginalName(StringLiteralExpCS value);

} // RenameCS
