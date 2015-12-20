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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolve In Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp#getInMapping <em>In Mapping</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getResolveInExp()
 * @model
 * @generated
 */
public interface ResolveInExp extends ResolveExp {
	/**
	 * Returns the value of the '<em><b>In Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Mapping</em>' reference.
	 * @see #setInMapping(MappingOperation)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getResolveInExp_InMapping()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='resolveExpression'"
	 * @generated
	 */
	MappingOperation getInMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp#getInMapping <em>In Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Mapping</em>' reference.
	 * @see #getInMapping()
	 * @generated
	 */
	void setInMapping(MappingOperation value);

} // ResolveInExp
