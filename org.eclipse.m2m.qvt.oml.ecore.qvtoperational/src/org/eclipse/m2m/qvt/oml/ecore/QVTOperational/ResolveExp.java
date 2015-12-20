/**
 * <copyright>
 * Copyright (c) 2008 Open Canarias and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ResolveExp.java,v 1.3 2009/01/25 23:12:24 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational;

import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeExpression;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolve Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#isIsDeferred <em>Is Deferred</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#isIsInverse <em>Is Inverse</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#isOne <em>One</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getResolveExp()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='wellFormedCondition'"
 * @generated
 */
public interface ResolveExp extends CallExp, ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(OCLExpression)
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getResolveExp_Condition()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Is Deferred</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Deferred</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Deferred</em>' attribute.
	 * @see #isSetIsDeferred()
	 * @see #unsetIsDeferred()
	 * @see #setIsDeferred(boolean)
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getResolveExp_IsDeferred()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isIsDeferred();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#isIsDeferred <em>Is Deferred</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Deferred</em>' attribute.
	 * @see #isSetIsDeferred()
	 * @see #unsetIsDeferred()
	 * @see #isIsDeferred()
	 * @generated
	 */
	void setIsDeferred(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#isIsDeferred <em>Is Deferred</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsDeferred()
	 * @see #isIsDeferred()
	 * @see #setIsDeferred(boolean)
	 * @generated
	 */
	void unsetIsDeferred();

	/**
	 * Returns whether the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#isIsDeferred <em>Is Deferred</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Deferred</em>' attribute is set.
	 * @see #unsetIsDeferred()
	 * @see #isIsDeferred()
	 * @see #setIsDeferred(boolean)
	 * @generated
	 */
	boolean isSetIsDeferred();

	/**
	 * Returns the value of the '<em><b>Is Inverse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Inverse</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Inverse</em>' attribute.
	 * @see #isSetIsInverse()
	 * @see #unsetIsInverse()
	 * @see #setIsInverse(boolean)
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getResolveExp_IsInverse()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isIsInverse();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#isIsInverse <em>Is Inverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Inverse</em>' attribute.
	 * @see #isSetIsInverse()
	 * @see #unsetIsInverse()
	 * @see #isIsInverse()
	 * @generated
	 */
	void setIsInverse(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#isIsInverse <em>Is Inverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsInverse()
	 * @see #isIsInverse()
	 * @see #setIsInverse(boolean)
	 * @generated
	 */
	void unsetIsInverse();

	/**
	 * Returns whether the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#isIsInverse <em>Is Inverse</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Inverse</em>' attribute is set.
	 * @see #unsetIsInverse()
	 * @see #isIsInverse()
	 * @see #setIsInverse(boolean)
	 * @generated
	 */
	boolean isSetIsInverse();

	/**
	 * Returns the value of the '<em><b>One</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One</em>' attribute.
	 * @see #isSetOne()
	 * @see #unsetOne()
	 * @see #setOne(boolean)
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getResolveExp_One()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isOne();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#isOne <em>One</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One</em>' attribute.
	 * @see #isSetOne()
	 * @see #unsetOne()
	 * @see #isOne()
	 * @generated
	 */
	void setOne(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#isOne <em>One</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOne()
	 * @see #isOne()
	 * @see #setOne(boolean)
	 * @generated
	 */
	void unsetOne();

	/**
	 * Returns whether the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#isOne <em>One</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>One</em>' attribute is set.
	 * @see #unsetOne()
	 * @see #isOne()
	 * @see #setOne(boolean)
	 * @generated
	 */
	boolean isSetOne();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Variable)
	 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage#getResolveExp_Target()
	 * @model containment="true"
	 * @generated
	 */
	Variable getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Variable value);

} // ResolveExp
