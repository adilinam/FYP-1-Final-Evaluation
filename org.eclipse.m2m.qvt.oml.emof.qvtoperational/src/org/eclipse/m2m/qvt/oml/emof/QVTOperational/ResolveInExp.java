/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResolveInExp.java,v 1.1 2008/09/02 20:36:00 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolve In Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveInExp#getInMapping <em>In Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getResolveInExp()
 * @model
 * @generated
 */
public interface ResolveInExp extends ResolveExp {
	/**
	 * Returns the value of the '<em><b>In Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Mapping</em>' reference.
	 * @see #setInMapping(MappingOperation)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getResolveInExp_InMapping()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='resolveExpression'"
	 * @generated
	 */
	MappingOperation getInMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.ResolveInExp#getInMapping <em>In Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Mapping</em>' reference.
	 * @see #getInMapping()
	 * @generated
	 */
	void setInMapping(MappingOperation value);

} // ResolveInExp
