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
 * $Id: ClassifierPropertyCS.java,v 1.5 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.cst.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier Property CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getStereotypeQualifiers <em>Stereotype Qualifiers</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getFeatureKeys <em>Feature Keys</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#isIsOrdered <em>Is Ordered</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getClassifierPropertyCS()
 * @model
 * @generated
 */
public interface ClassifierPropertyCS extends LocalPropertyCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Stereotype Qualifiers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.cst.SimpleNameCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype Qualifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype Qualifiers</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getClassifierPropertyCS_StereotypeQualifiers()
	 * @model containment="true"
	 * @generated
	 */
	EList<SimpleNameCS> getStereotypeQualifiers();

	/**
	 * Returns the value of the '<em><b>Feature Keys</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.cst.SimpleNameCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Keys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Keys</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getClassifierPropertyCS_FeatureKeys()
	 * @model containment="true"
	 * @generated
	 */
	EList<SimpleNameCS> getFeatureKeys();

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' containment reference.
	 * @see #setMultiplicity(MultiplicityDefCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getClassifierPropertyCS_Multiplicity()
	 * @model containment="true"
	 * @generated
	 */
	MultiplicityDefCS getMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getMultiplicity <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' containment reference.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(MultiplicityDefCS value);

	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite</em>' containment reference.
	 * @see #setOpposite(OppositePropertyCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getClassifierPropertyCS_Opposite()
	 * @model containment="true"
	 * @generated
	 */
	OppositePropertyCS getOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#getOpposite <em>Opposite</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' containment reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(OppositePropertyCS value);

	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Ordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(boolean)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getClassifierPropertyCS_IsOrdered()
	 * @model default="true"
	 * @generated
	 */
	boolean isIsOrdered();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS#isIsOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #isIsOrdered()
	 * @generated
	 */
	void setIsOrdered(boolean value);

} // ClassifierPropertyCS
