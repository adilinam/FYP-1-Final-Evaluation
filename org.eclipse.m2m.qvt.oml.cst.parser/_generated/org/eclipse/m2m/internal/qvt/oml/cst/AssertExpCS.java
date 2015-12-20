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
 * $Id: AssertExpCS.java,v 1.3 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assert Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS#getAssertion <em>Assertion</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS#getLog <em>Log</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getAssertExpCS()
 * @model
 * @generated
 */
public interface AssertExpCS extends StatementCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Assertion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assertion</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assertion</em>' containment reference.
	 * @see #setAssertion(OCLExpressionCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getAssertExpCS_Assertion()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OCLExpressionCS getAssertion();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS#getAssertion <em>Assertion</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assertion</em>' containment reference.
	 * @see #getAssertion()
	 * @generated
	 */
	void setAssertion(OCLExpressionCS value);

	/**
	 * Returns the value of the '<em><b>Log</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log</em>' containment reference.
	 * @see #setLog(LogExpCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getAssertExpCS_Log()
	 * @model containment="true"
	 * @generated
	 */
	LogExpCS getLog();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS#getLog <em>Log</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log</em>' containment reference.
	 * @see #getLog()
	 * @generated
	 */
	void setLog(LogExpCS value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' containment reference.
	 * @see #setSeverity(SimpleNameCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getAssertExpCS_Severity()
	 * @model containment="true"
	 * @generated
	 */
	SimpleNameCS getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS#getSeverity <em>Severity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' containment reference.
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(SimpleNameCS value);

} // AssertExpCS
