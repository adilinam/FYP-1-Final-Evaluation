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
 * $Id: TransformationHeaderCSImpl.java,v 1.3 2010/01/29 15:23:41 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.impl.CSTNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation Header CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationHeaderCSImpl#getQualifiers <em>Qualifiers</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationHeaderCSImpl#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationHeaderCSImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationHeaderCSImpl#getModuleUsages <em>Module Usages</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.TransformationHeaderCSImpl#getTransformationRefineCS <em>Transformation Refine CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationHeaderCSImpl extends CSTNodeImpl implements TransformationHeaderCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getQualifiers() <em>Qualifiers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<QualifierKindCS> qualifiers;

	/**
	 * The cached value of the '{@link #getPathNameCS() <em>Path Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathNameCS()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS pathNameCS;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterDeclarationCS> parameters;

	/**
	 * The cached value of the '{@link #getModuleUsages() <em>Module Usages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleUsages()
	 * @generated
	 * @ordered
	 */
	protected EList<ModuleUsageCS> moduleUsages;

	/**
	 * The cached value of the '{@link #getTransformationRefineCS() <em>Transformation Refine CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformationRefineCS()
	 * @generated
	 * @ordered
	 */
	protected TransformationRefineCS transformationRefineCS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationHeaderCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.TRANSFORMATION_HEADER_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QualifierKindCS> getQualifiers() {
		if (qualifiers == null) {
			qualifiers = new EDataTypeEList<QualifierKindCS>(QualifierKindCS.class, this, CSTPackage.TRANSFORMATION_HEADER_CS__QUALIFIERS);
		}
		return qualifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getPathNameCS() {
		return pathNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPathNameCS(PathNameCS newPathNameCS, NotificationChain msgs) {
		PathNameCS oldPathNameCS = pathNameCS;
		pathNameCS = newPathNameCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS, oldPathNameCS, newPathNameCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathNameCS(PathNameCS newPathNameCS) {
		if (newPathNameCS != pathNameCS) {
			NotificationChain msgs = null;
			if (pathNameCS != null)
				msgs = ((InternalEObject)pathNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS, null, msgs);
			if (newPathNameCS != null)
				msgs = ((InternalEObject)newPathNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS, null, msgs);
			msgs = basicSetPathNameCS(newPathNameCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS, newPathNameCS, newPathNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDeclarationCS> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<ParameterDeclarationCS>(ParameterDeclarationCS.class, this, CSTPackage.TRANSFORMATION_HEADER_CS__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModuleUsageCS> getModuleUsages() {
		if (moduleUsages == null) {
			moduleUsages = new EObjectContainmentEList<ModuleUsageCS>(ModuleUsageCS.class, this, CSTPackage.TRANSFORMATION_HEADER_CS__MODULE_USAGES);
		}
		return moduleUsages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationRefineCS getTransformationRefineCS() {
		return transformationRefineCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformationRefineCS(TransformationRefineCS newTransformationRefineCS, NotificationChain msgs) {
		TransformationRefineCS oldTransformationRefineCS = transformationRefineCS;
		transformationRefineCS = newTransformationRefineCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS, oldTransformationRefineCS, newTransformationRefineCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformationRefineCS(TransformationRefineCS newTransformationRefineCS) {
		if (newTransformationRefineCS != transformationRefineCS) {
			NotificationChain msgs = null;
			if (transformationRefineCS != null)
				msgs = ((InternalEObject)transformationRefineCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS, null, msgs);
			if (newTransformationRefineCS != null)
				msgs = ((InternalEObject)newTransformationRefineCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS, null, msgs);
			msgs = basicSetTransformationRefineCS(newTransformationRefineCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS, newTransformationRefineCS, newTransformationRefineCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS:
				return basicSetPathNameCS(null, msgs);
			case CSTPackage.TRANSFORMATION_HEADER_CS__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case CSTPackage.TRANSFORMATION_HEADER_CS__MODULE_USAGES:
				return ((InternalEList<?>)getModuleUsages()).basicRemove(otherEnd, msgs);
			case CSTPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS:
				return basicSetTransformationRefineCS(null, msgs);
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
			case CSTPackage.TRANSFORMATION_HEADER_CS__QUALIFIERS:
				return getQualifiers();
			case CSTPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS:
				return getPathNameCS();
			case CSTPackage.TRANSFORMATION_HEADER_CS__PARAMETERS:
				return getParameters();
			case CSTPackage.TRANSFORMATION_HEADER_CS__MODULE_USAGES:
				return getModuleUsages();
			case CSTPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS:
				return getTransformationRefineCS();
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
			case CSTPackage.TRANSFORMATION_HEADER_CS__QUALIFIERS:
				getQualifiers().clear();
				getQualifiers().addAll((Collection<? extends QualifierKindCS>)newValue);
				return;
			case CSTPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS:
				setPathNameCS((PathNameCS)newValue);
				return;
			case CSTPackage.TRANSFORMATION_HEADER_CS__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ParameterDeclarationCS>)newValue);
				return;
			case CSTPackage.TRANSFORMATION_HEADER_CS__MODULE_USAGES:
				getModuleUsages().clear();
				getModuleUsages().addAll((Collection<? extends ModuleUsageCS>)newValue);
				return;
			case CSTPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS:
				setTransformationRefineCS((TransformationRefineCS)newValue);
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
			case CSTPackage.TRANSFORMATION_HEADER_CS__QUALIFIERS:
				getQualifiers().clear();
				return;
			case CSTPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS:
				setPathNameCS((PathNameCS)null);
				return;
			case CSTPackage.TRANSFORMATION_HEADER_CS__PARAMETERS:
				getParameters().clear();
				return;
			case CSTPackage.TRANSFORMATION_HEADER_CS__MODULE_USAGES:
				getModuleUsages().clear();
				return;
			case CSTPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS:
				setTransformationRefineCS((TransformationRefineCS)null);
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
			case CSTPackage.TRANSFORMATION_HEADER_CS__QUALIFIERS:
				return qualifiers != null && !qualifiers.isEmpty();
			case CSTPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS:
				return pathNameCS != null;
			case CSTPackage.TRANSFORMATION_HEADER_CS__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case CSTPackage.TRANSFORMATION_HEADER_CS__MODULE_USAGES:
				return moduleUsages != null && !moduleUsages.isEmpty();
			case CSTPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS:
				return transformationRefineCS != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (qualifiers: "); //$NON-NLS-1$
		result.append(qualifiers);
		result.append(')');
		return result.toString();
	}

} //TransformationHeaderCSImpl
