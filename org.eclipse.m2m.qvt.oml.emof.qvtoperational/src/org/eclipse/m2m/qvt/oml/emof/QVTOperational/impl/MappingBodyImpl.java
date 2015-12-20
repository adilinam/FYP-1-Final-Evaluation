/**
 * <copyright>
 * </copyright>
 *
 * $Id: MappingBodyImpl.java,v 1.2 2009/02/20 12:55:55 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.MappingBody;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.MappingBodyImpl#getEndSection <em>End Section</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.MappingBodyImpl#getInitSection <em>Init Section</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingBodyImpl extends OperationBodyImpl implements MappingBody {
	/**
	 * The cached value of the '{@link #getEndSection() <em>End Section</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndSection()
	 * @generated
	 * @ordered
	 */
	protected EList<OclExpression> endSection;

	/**
	 * The cached value of the '{@link #getInitSection() <em>Init Section</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitSection()
	 * @generated
	 * @ordered
	 */
	protected EList<OclExpression> initSection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingBodyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.MAPPING_BODY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OclExpression> getEndSection() {
		if (endSection == null) {
			endSection = new EObjectContainmentEList<OclExpression>(OclExpression.class, this, QVTOperationalPackage.MAPPING_BODY__END_SECTION);
		}
		return endSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OclExpression> getInitSection() {
		if (initSection == null) {
			initSection = new EObjectContainmentEList<OclExpression>(OclExpression.class, this, QVTOperationalPackage.MAPPING_BODY__INIT_SECTION);
		}
		return initSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.MAPPING_BODY__END_SECTION:
				return ((InternalEList<?>)getEndSection()).basicRemove(otherEnd, msgs);
			case QVTOperationalPackage.MAPPING_BODY__INIT_SECTION:
				return ((InternalEList<?>)getInitSection()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTOperationalPackage.MAPPING_BODY__END_SECTION:
				return getEndSection();
			case QVTOperationalPackage.MAPPING_BODY__INIT_SECTION:
				return getInitSection();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QVTOperationalPackage.MAPPING_BODY__END_SECTION:
				getEndSection().clear();
				getEndSection().addAll((Collection<? extends OclExpression>)newValue);
				return;
			case QVTOperationalPackage.MAPPING_BODY__INIT_SECTION:
				getInitSection().clear();
				getInitSection().addAll((Collection<? extends OclExpression>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case QVTOperationalPackage.MAPPING_BODY__END_SECTION:
				getEndSection().clear();
				return;
			case QVTOperationalPackage.MAPPING_BODY__INIT_SECTION:
				getInitSection().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QVTOperationalPackage.MAPPING_BODY__END_SECTION:
				return endSection != null && !endSection.isEmpty();
			case QVTOperationalPackage.MAPPING_BODY__INIT_SECTION:
				return initSection != null && !initSection.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MappingBodyImpl
