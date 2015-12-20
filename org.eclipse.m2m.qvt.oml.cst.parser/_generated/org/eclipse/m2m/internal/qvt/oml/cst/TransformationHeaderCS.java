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
 * $Id: TransformationHeaderCS.java,v 1.3 2010/01/29 15:23:42 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation Header CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getQualifiers <em>Qualifiers</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getModuleUsages <em>Module Usages</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getTransformationRefineCS <em>Transformation Refine CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getTransformationHeaderCS()
 * @model
 * @generated
 */
public interface TransformationHeaderCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Qualifiers</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS}.
	 * The literals are from the enumeration {@link org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifiers</em>' attribute list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getTransformationHeaderCS_Qualifiers()
	 * @model unique="false"
	 * @generated
	 */
	EList<QualifierKindCS> getQualifiers();

	/**
	 * Returns the value of the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name CS</em>' containment reference.
	 * @see #setPathNameCS(PathNameCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getTransformationHeaderCS_PathNameCS()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PathNameCS getPathNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getPathNameCS <em>Path Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name CS</em>' containment reference.
	 * @see #getPathNameCS()
	 * @generated
	 */
	void setPathNameCS(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getTransformationHeaderCS_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterDeclarationCS> getParameters();

	/**
	 * Returns the value of the '<em><b>Module Usages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Usages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Usages</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getTransformationHeaderCS_ModuleUsages()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModuleUsageCS> getModuleUsages();

	/**
	 * Returns the value of the '<em><b>Transformation Refine CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Refine CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation Refine CS</em>' containment reference.
	 * @see #setTransformationRefineCS(TransformationRefineCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getTransformationHeaderCS_TransformationRefineCS()
	 * @model containment="true"
	 * @generated
	 */
	TransformationRefineCS getTransformationRefineCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS#getTransformationRefineCS <em>Transformation Refine CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation Refine CS</em>' containment reference.
	 * @see #getTransformationRefineCS()
	 * @generated
	 */
	void setTransformationRefineCS(TransformationRefineCS value);

} // TransformationHeaderCS
