/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package simpleuml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generalization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link simpleuml.Generalization#getGeneral <em>General</em>}</li>
 *   <li>{@link simpleuml.Generalization#isIsSubstitutable <em>Is Substitutable</em>}</li>
 * </ul>
 * </p>
 *
 * @see simpleuml.SimpleumlPackage#getGeneralization()
 * @model
 * @generated
 */
public interface Generalization extends EObject {
    /**
	 * Returns the value of the '<em><b>General</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>General</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>General</em>' reference.
	 * @see #setGeneral(Class)
	 * @see simpleuml.SimpleumlPackage#getGeneralization_General()
	 * @model
	 * @generated
	 */
    Class getGeneral();

    /**
	 * Sets the value of the '{@link simpleuml.Generalization#getGeneral <em>General</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>General</em>' reference.
	 * @see #getGeneral()
	 * @generated
	 */
	void setGeneral(Class value);

				/**
	 * Returns the value of the '<em><b>Is Substitutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Substitutable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Substitutable</em>' attribute.
	 * @see #setIsSubstitutable(boolean)
	 * @see simpleuml.SimpleumlPackage#getGeneralization_IsSubstitutable()
	 * @model
	 * @generated
	 */
    boolean isIsSubstitutable();

    /**
	 * Sets the value of the '{@link simpleuml.Generalization#isIsSubstitutable <em>Is Substitutable</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Substitutable</em>' attribute.
	 * @see #isIsSubstitutable()
	 * @generated
	 */
    void setIsSubstitutable(boolean value);

} // Generalization
