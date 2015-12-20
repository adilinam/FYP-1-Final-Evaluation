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
package org.eclipse.qvto.examples.pivot.imperativeocl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ordered Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType#getElementType <em>Element Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getOrderedTupleType()
 * @model
 * @generated
 */
public interface OrderedTupleType extends org.eclipse.ocl.pivot.Class {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' reference list.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getOrderedTupleType_ElementType()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='eltTuple'"
	 * @generated
	 */
	EList<Type> getElementType();

} // OrderedTupleType
