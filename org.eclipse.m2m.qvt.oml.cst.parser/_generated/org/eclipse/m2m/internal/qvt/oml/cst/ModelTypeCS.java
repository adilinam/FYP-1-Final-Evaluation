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
 * $Id: ModelTypeCS.java,v 1.4 2010/01/29 15:23:42 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Type CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getIdentifierCS <em>Identifier CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getComplianceKindCS <em>Compliance Kind CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getPackageRefs <em>Package Refs</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getWhereStatements <em>Where Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getModelTypeCS()
 * @model
 * @generated
 */
public interface ModelTypeCS extends CSTNode, ElementWithBody {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Identifier CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier CS</em>' containment reference.
	 * @see #setIdentifierCS(SimpleNameCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getModelTypeCS_IdentifierCS()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SimpleNameCS getIdentifierCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getIdentifierCS <em>Identifier CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier CS</em>' containment reference.
	 * @see #getIdentifierCS()
	 * @generated
	 */
	void setIdentifierCS(SimpleNameCS value);

	/**
	 * Returns the value of the '<em><b>Compliance Kind CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compliance Kind CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compliance Kind CS</em>' containment reference.
	 * @see #setComplianceKindCS(StringLiteralExpCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getModelTypeCS_ComplianceKindCS()
	 * @model containment="true"
	 * @generated
	 */
	StringLiteralExpCS getComplianceKindCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS#getComplianceKindCS <em>Compliance Kind CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compliance Kind CS</em>' containment reference.
	 * @see #getComplianceKindCS()
	 * @generated
	 */
	void setComplianceKindCS(StringLiteralExpCS value);

	/**
	 * Returns the value of the '<em><b>Package Refs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Refs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Refs</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getModelTypeCS_PackageRefs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<PackageRefCS> getPackageRefs();

	/**
	 * Returns the value of the '<em><b>Where Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.cst.OCLExpressionCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where Statements</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getModelTypeCS_WhereStatements()
	 * @model containment="true"
	 * @generated
	 */
	EList<OCLExpressionCS> getWhereStatements();

} // ModelTypeCS
