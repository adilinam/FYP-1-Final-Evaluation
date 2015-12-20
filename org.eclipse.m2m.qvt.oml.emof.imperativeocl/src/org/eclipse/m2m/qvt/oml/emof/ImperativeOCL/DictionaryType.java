/**
 * <copyright>
 * </copyright>
 *
 * $Id: DictionaryType.java,v 1.2 2009/01/25 23:11:18 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.ImperativeOCL;

import org.eclipse.qvt.declarative.emof.EMOF.Type;
import org.eclipse.qvt.declarative.emof.EssentialOCL.CollectionType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dictionary Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictionaryType#getKeyType <em>Key Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getDictionaryType()
 * @model
 * @generated
 */
public interface DictionaryType extends CollectionType {
	/**
	 * Returns the value of the '<em><b>Key Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Type</em>' reference.
	 * @see #setKeyType(Type)
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#getDictionaryType_KeyType()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='keyDict'"
	 * @generated
	 */
	Type getKeyType();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictionaryType#getKeyType <em>Key Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Type</em>' reference.
	 * @see #getKeyType()
	 * @generated
	 */
	void setKeyType(Type value);

} // DictionaryType
