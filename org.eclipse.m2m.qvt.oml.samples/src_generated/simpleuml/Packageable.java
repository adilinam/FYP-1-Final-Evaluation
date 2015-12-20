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
 * A representation of the model object '<em><b>Packageable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link simpleuml.Packageable#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see simpleuml.SimpleumlPackage#getPackageable()
 * @model abstract="true"
 * @generated
 */
public interface Packageable extends EObject {
    /**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link simpleuml.Package#getOwnedElements <em>Owned Elements</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owner</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Package)
	 * @see simpleuml.SimpleumlPackage#getPackageable_Owner()
	 * @see simpleuml.Package#getOwnedElements
	 * @model opposite="ownedElements" transient="false"
	 * @generated
	 */
    Package getOwner();

    /**
	 * Sets the value of the '{@link simpleuml.Packageable#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Package value);

} // Packageable
