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
 * $Id: UnitCSImpl.java,v 1.3 2010/01/29 15:23:40 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;

import org.eclipse.ocl.cst.CSTNode;

import org.eclipse.ocl.cst.impl.CSTNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.UnitCSImpl#getTopLevelElements <em>Top Level Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.UnitCSImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.UnitCSImpl#getModelTypes <em>Model Types</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.UnitCSImpl#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitCSImpl extends CSTNodeImpl implements UnitCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getTopLevelElements() <em>Top Level Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopLevelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<CSTNode> topLevelElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.UNIT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CSTNode> getTopLevelElements() {
		if (topLevelElements == null) {
			topLevelElements = new EObjectContainmentEList<CSTNode>(CSTNode.class, this, CSTPackage.UNIT_CS__TOP_LEVEL_ELEMENTS);
		}
		return topLevelElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<MappingModuleCS> getModules() {
		EList<MappingModuleCS> result = new BasicEList<MappingModuleCS>();
		for (CSTNode nextTopLevelCS : getTopLevelElements()) {
			if(nextTopLevelCS instanceof MappingModuleCS) {
				result.add((MappingModuleCS) nextTopLevelCS);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ModelTypeCS> getModelTypes() {
		EList<ModelTypeCS> result = new BasicEList<ModelTypeCS>();
		for (CSTNode nextTopLevelCS : getTopLevelElements()) {
			if(nextTopLevelCS instanceof ModelTypeCS) {
				result.add((ModelTypeCS) nextTopLevelCS);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ImportCS> getImports() {
		EList<ImportCS> result = new BasicEList<ImportCS>();
		for (CSTNode nextTopLevelCS : getTopLevelElements()) {
			if(nextTopLevelCS instanceof ImportCS) {
				result.add((ImportCS) nextTopLevelCS);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.UNIT_CS__TOP_LEVEL_ELEMENTS:
				return ((InternalEList<?>)getTopLevelElements()).basicRemove(otherEnd, msgs);
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
			case CSTPackage.UNIT_CS__TOP_LEVEL_ELEMENTS:
				return getTopLevelElements();
			case CSTPackage.UNIT_CS__MODULES:
				return getModules();
			case CSTPackage.UNIT_CS__MODEL_TYPES:
				return getModelTypes();
			case CSTPackage.UNIT_CS__IMPORTS:
				return getImports();
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
			case CSTPackage.UNIT_CS__TOP_LEVEL_ELEMENTS:
				getTopLevelElements().clear();
				getTopLevelElements().addAll((Collection<? extends CSTNode>)newValue);
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
			case CSTPackage.UNIT_CS__TOP_LEVEL_ELEMENTS:
				getTopLevelElements().clear();
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
			case CSTPackage.UNIT_CS__TOP_LEVEL_ELEMENTS:
				return topLevelElements != null && !topLevelElements.isEmpty();
			case CSTPackage.UNIT_CS__MODULES:
				return !getModules().isEmpty();
			case CSTPackage.UNIT_CS__MODEL_TYPES:
				return !getModelTypes().isEmpty();
			case CSTPackage.UNIT_CS__IMPORTS:
				return !getImports().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UnitCSImpl
