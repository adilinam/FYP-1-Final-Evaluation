/**
 * <copyright>
 * Copyright (c) 2013 Willink Transformations, University of York, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo (University of York) - Bug397429
 * </copyright>
 */
package org.eclipse.qvto.examples.pivot.qvtoperational;

import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imperative Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp#isIsVirtual <em>Is Virtual</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getImperativeCallExp()
 * @model
 * @generated
 */
public interface ImperativeCallExp extends OperationCallExp, ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Is Virtual</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Virtual</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Virtual</em>' attribute.
	 * @see #setIsVirtual(boolean)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getImperativeCallExp_IsVirtual()
	 * @model default="true" dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsVirtual();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp#isIsVirtual <em>Is Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Virtual</em>' attribute.
	 * @see #isIsVirtual()
	 * @generated
	 */
	void setIsVirtual(boolean value);

} // ImperativeCallExp
