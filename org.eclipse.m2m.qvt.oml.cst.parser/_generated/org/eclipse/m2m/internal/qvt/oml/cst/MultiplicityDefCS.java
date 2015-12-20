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
 * $Id: MultiplicityDefCS.java,v 1.3 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PrimitiveLiteralExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity Def CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMultiplicityDefCS()
 * @model
 * @generated
 */
public interface MultiplicityDefCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' reference.
	 * @see #setLowerBound(PrimitiveLiteralExpCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMultiplicityDefCS_LowerBound()
	 * @model required="true"
	 * @generated
	 */
	PrimitiveLiteralExpCS getLowerBound();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS#getLowerBound <em>Lower Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' reference.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(PrimitiveLiteralExpCS value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' reference.
	 * @see #setUpperBound(PrimitiveLiteralExpCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMultiplicityDefCS_UpperBound()
	 * @model required="true"
	 * @generated
	 */
	PrimitiveLiteralExpCS getUpperBound();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS#getUpperBound <em>Upper Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' reference.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(PrimitiveLiteralExpCS value);

} // MultiplicityDefCS
