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
 * $Id: TagCS.java,v 1.3 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.TagCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.TagCS#getScopedNameCS <em>Scoped Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.TagCS#getOclExpressionCS <em>Ocl Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getTagCS()
 * @model
 * @generated
 */
public interface TagCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(StringLiteralExpCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getTagCS_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StringLiteralExpCS getName();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.TagCS#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(StringLiteralExpCS value);

	/**
	 * Returns the value of the '<em><b>Scoped Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scoped Name CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scoped Name CS</em>' containment reference.
	 * @see #setScopedNameCS(ScopedNameCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getTagCS_ScopedNameCS()
	 * @model containment="true"
	 * @generated
	 */
	ScopedNameCS getScopedNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.TagCS#getScopedNameCS <em>Scoped Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scoped Name CS</em>' containment reference.
	 * @see #getScopedNameCS()
	 * @generated
	 */
	void setScopedNameCS(ScopedNameCS value);

	/**
	 * Returns the value of the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Expression CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Expression CS</em>' containment reference.
	 * @see #setOclExpressionCS(OCLExpressionCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getTagCS_OclExpressionCS()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpressionCS getOclExpressionCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.TagCS#getOclExpressionCS <em>Ocl Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Expression CS</em>' containment reference.
	 * @see #getOclExpressionCS()
	 * @generated
	 */
	void setOclExpressionCS(OCLExpressionCS value);

} // TagCS
