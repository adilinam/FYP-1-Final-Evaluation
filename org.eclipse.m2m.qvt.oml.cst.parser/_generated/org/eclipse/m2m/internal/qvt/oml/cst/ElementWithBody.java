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
 * $Id: ElementWithBody.java,v 1.2 2010/01/29 15:23:42 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element With Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody#getBodyStartLocation <em>Body Start Location</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody#getBodyEndLocation <em>Body End Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getElementWithBody()
 * @model abstract="true"
 * @generated
 */
public interface ElementWithBody extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Body Start Location</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Start Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Start Location</em>' attribute.
	 * @see #setBodyStartLocation(int)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getElementWithBody_BodyStartLocation()
	 * @model default="0"
	 * @generated
	 */
	int getBodyStartLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody#getBodyStartLocation <em>Body Start Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Start Location</em>' attribute.
	 * @see #getBodyStartLocation()
	 * @generated
	 */
	void setBodyStartLocation(int value);

	/**
	 * Returns the value of the '<em><b>Body End Location</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body End Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body End Location</em>' attribute.
	 * @see #setBodyEndLocation(int)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getElementWithBody_BodyEndLocation()
	 * @model default="0"
	 * @generated
	 */
	int getBodyEndLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody#getBodyEndLocation <em>Body End Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body End Location</em>' attribute.
	 * @see #getBodyEndLocation()
	 * @generated
	 */
	void setBodyEndLocation(int value);

} // ElementWithBody
