/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResolveExp.java,v 1.1 2008/09/02 20:36:01 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational;

import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeExpression;
import org.eclipse.qvt.declarative.emof.EssentialOCL.CallExp;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;
import org.eclipse.qvt.declarative.emof.EssentialOCL.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolve Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveExp#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveExp#getIsDeferred <em>Is Deferred</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveExp#getIsInverse <em>Is Inverse</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveExp#getOne <em>One</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveExp#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getResolveExp()
 * @model
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
	 * @see #setCondition(OclExpression)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getResolveExp_Condition()
	 * @model containment="true"
	 * @generated
	 */
	OclExpression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveExp#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Is Deferred</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Deferred</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Deferred</em>' attribute.
	 * @see #setIsDeferred(Boolean)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getResolveExp_IsDeferred()
	 * @model dataType="org.eclipse.qvt.declarative.emof.EMOF.Boolean"
	 * @generated
	 */
	Boolean getIsDeferred();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveExp#getIsDeferred <em>Is Deferred</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Deferred</em>' attribute.
	 * @see #getIsDeferred()
	 * @generated
	 */
	void setIsDeferred(Boolean value);

	/**
	 * Returns the value of the '<em><b>Is Inverse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Inverse</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Inverse</em>' attribute.
	 * @see #setIsInverse(Boolean)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getResolveExp_IsInverse()
	 * @model dataType="org.eclipse.qvt.declarative.emof.EMOF.Boolean"
	 * @generated
	 */
	Boolean getIsInverse();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveExp#getIsInverse <em>Is Inverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Inverse</em>' attribute.
	 * @see #getIsInverse()
	 * @generated
	 */
	void setIsInverse(Boolean value);

	/**
	 * Returns the value of the '<em><b>One</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One</em>' attribute.
	 * @see #setOne(Boolean)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getResolveExp_One()
	 * @model dataType="org.eclipse.qvt.declarative.emof.EMOF.Boolean"
	 * @generated
	 */
	Boolean getOne();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveExp#getOne <em>One</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One</em>' attribute.
	 * @see #getOne()
	 * @generated
	 */
	void setOne(Boolean value);

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
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getResolveExp_Target()
	 * @model containment="true"
	 * @generated
	 */
	Variable getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveExp#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Variable value);

} // ResolveExp
