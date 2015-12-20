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
 * $Id: WhileExpCS.java,v 1.4 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.VariableCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS#getResultVar <em>Result Var</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getWhileExpCS()
 * @model
 * @generated
 */
public interface WhileExpCS extends StatementCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(OCLExpressionCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getWhileExpCS_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OCLExpressionCS getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OCLExpressionCS value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(OCLExpressionCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getWhileExpCS_Condition()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpressionCS getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(OCLExpressionCS value);

	/**
	 * Returns the value of the '<em><b>Result Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Var</em>' containment reference.
	 * @see #setResultVar(VariableCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getWhileExpCS_ResultVar()
	 * @model containment="true"
	 * @generated
	 */
	VariableCS getResultVar();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS#getResultVar <em>Result Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Var</em>' containment reference.
	 * @see #getResultVar()
	 * @generated
	 */
	void setResultVar(VariableCS value);

} // WhileExpCS
