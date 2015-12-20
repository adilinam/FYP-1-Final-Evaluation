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
 * $Id: AssignStatementCS.java,v 1.2 2010/01/29 15:23:42 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assign Statement CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS#getLValueCS <em>LValue CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS#getOclExpressionCS <em>Ocl Expression CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS#isIncremental <em>Incremental</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getAssignStatementCS()
 * @model
 * @generated
 */
public interface AssignStatementCS extends StatementCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>LValue CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LValue CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LValue CS</em>' containment reference.
	 * @see #setLValueCS(OCLExpressionCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getAssignStatementCS_LValueCS()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpressionCS getLValueCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS#getLValueCS <em>LValue CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LValue CS</em>' containment reference.
	 * @see #getLValueCS()
	 * @generated
	 */
	void setLValueCS(OCLExpressionCS value);

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
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getAssignStatementCS_OclExpressionCS()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpressionCS getOclExpressionCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS#getOclExpressionCS <em>Ocl Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Expression CS</em>' containment reference.
	 * @see #getOclExpressionCS()
	 * @generated
	 */
	void setOclExpressionCS(OCLExpressionCS value);

	/**
	 * Returns the value of the '<em><b>Incremental</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incremental</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incremental</em>' attribute.
	 * @see #setIncremental(boolean)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getAssignStatementCS_Incremental()
	 * @model
	 * @generated
	 */
	boolean isIncremental();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS#isIncremental <em>Incremental</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incremental</em>' attribute.
	 * @see #isIncremental()
	 * @generated
	 */
	void setIncremental(boolean value);

} // AssignStatementCS
