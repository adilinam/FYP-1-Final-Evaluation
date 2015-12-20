/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package rdb.impl;

import org.eclipse.emf.ecore.EClass;

import rdb.NamedColumnSet;
import rdb.RdbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Column Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class NamedColumnSetImpl extends SchemaElementImpl implements NamedColumnSet {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected NamedColumnSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				protected EClass eStaticClass() {
		return RdbPackage.Literals.NAMED_COLUMN_SET;
	}

} //NamedColumnSetImpl
