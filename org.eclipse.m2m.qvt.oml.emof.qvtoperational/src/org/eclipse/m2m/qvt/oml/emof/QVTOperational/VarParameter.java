/**
 * <copyright>
 * </copyright>
 *
 * $Id: VarParameter.java,v 1.2 2009/02/20 12:55:55 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational;

import org.eclipse.qvt.declarative.emof.EMOF.Parameter;
import org.eclipse.qvt.declarative.emof.EssentialOCL.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.VarParameter#getCtxOwner <em>Ctx Owner</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.VarParameter#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.VarParameter#getResOwner <em>Res Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getVarParameter()
 * @model
 * @generated
 */
public interface VarParameter extends Variable, Parameter {
	/**
	 * Returns the value of the '<em><b>Ctx Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImperativeOperation#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ctx Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ctx Owner</em>' container reference.
	 * @see #setCtxOwner(ImperativeOperation)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getVarParameter_CtxOwner()
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImperativeOperation#getContext
	 * @model opposite="context"
	 * @generated
	 */
	ImperativeOperation getCtxOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.VarParameter#getCtxOwner <em>Ctx Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ctx Owner</em>' container reference.
	 * @see #getCtxOwner()
	 * @generated
	 */
	void setCtxOwner(ImperativeOperation value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.DirectionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.DirectionKind
	 * @see #setKind(DirectionKind)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getVarParameter_Kind()
	 * @model
	 * @generated
	 */
	DirectionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.VarParameter#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.DirectionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(DirectionKind value);

	/**
	 * Returns the value of the '<em><b>Res Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImperativeOperation#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Res Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Res Owner</em>' container reference.
	 * @see #setResOwner(ImperativeOperation)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getVarParameter_ResOwner()
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImperativeOperation#getResult
	 * @model opposite="result"
	 * @generated
	 */
	ImperativeOperation getResOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.VarParameter#getResOwner <em>Res Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Res Owner</em>' container reference.
	 * @see #getResOwner()
	 * @generated
	 */
	void setResOwner(ImperativeOperation value);

} // VarParameter
