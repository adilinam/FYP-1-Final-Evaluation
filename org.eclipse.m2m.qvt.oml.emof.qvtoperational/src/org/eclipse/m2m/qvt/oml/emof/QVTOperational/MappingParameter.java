/**
 * <copyright>
 * </copyright>
 *
 * $Id: MappingParameter.java,v 1.1 2008/09/02 20:36:00 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational;

import org.eclipse.qvt.declarative.emof.QVTRelation.RelationDomain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.MappingParameter#getExtent <em>Extent</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.MappingParameter#getReferredDomain <em>Referred Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getMappingParameter()
 * @model
 * @generated
 */
public interface MappingParameter extends VarParameter {
	/**
	 * Returns the value of the '<em><b>Extent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extent</em>' reference.
	 * @see #setExtent(ModelParameter)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getMappingParameter_Extent()
	 * @model
	 * @generated
	 */
	ModelParameter getExtent();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.MappingParameter#getExtent <em>Extent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extent</em>' reference.
	 * @see #getExtent()
	 * @generated
	 */
	void setExtent(ModelParameter value);

	/**
	 * Returns the value of the '<em><b>Referred Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Domain</em>' reference.
	 * @see #setReferredDomain(RelationDomain)
	 * @see org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage#getMappingParameter_ReferredDomain()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='referringParameter'"
	 * @generated
	 */
	RelationDomain getReferredDomain();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.MappingParameter#getReferredDomain <em>Referred Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Domain</em>' reference.
	 * @see #getReferredDomain()
	 * @generated
	 */
	void setReferredDomain(RelationDomain value);

} // MappingParameter
