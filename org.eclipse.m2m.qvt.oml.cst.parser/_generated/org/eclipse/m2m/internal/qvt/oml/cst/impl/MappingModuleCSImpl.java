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
 * $Id: MappingModuleCSImpl.java,v 1.5 2010/01/29 15:23:40 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.RenameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TagCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;

import org.eclipse.ocl.cst.impl.CSTNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Module CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingModuleCSImpl#getHeaderCS <em>Header CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingModuleCSImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingModuleCSImpl#getMetamodels <em>Metamodels</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingModuleCSImpl#getRenamings <em>Renamings</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingModuleCSImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingModuleCSImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingModuleCSImpl#getClassifierDefCS <em>Classifier Def CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingModuleCSImpl#getTags <em>Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingModuleCSImpl extends CSTNodeImpl implements MappingModuleCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getHeaderCS() <em>Header CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderCS()
	 * @generated
	 * @ordered
	 */
	protected TransformationHeaderCS headerCS;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportCS> imports;

	/**
	 * The cached value of the '{@link #getMetamodels() <em>Metamodels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodels()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelTypeCS> metamodels;

	/**
	 * The cached value of the '{@link #getRenamings() <em>Renamings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenamings()
	 * @generated
	 * @ordered
	 */
	protected EList<RenameCS> renamings;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<ModulePropertyCS> properties;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingMethodCS> methods;

	/**
	 * The cached value of the '{@link #getClassifierDefCS() <em>Classifier Def CS</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifierDefCS()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassifierDefCS> classifierDefCS;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<TagCS> tags;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingModuleCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.MAPPING_MODULE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationHeaderCS getHeaderCS() {
		return headerCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeaderCS(TransformationHeaderCS newHeaderCS, NotificationChain msgs) {
		TransformationHeaderCS oldHeaderCS = headerCS;
		headerCS = newHeaderCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_MODULE_CS__HEADER_CS, oldHeaderCS, newHeaderCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderCS(TransformationHeaderCS newHeaderCS) {
		if (newHeaderCS != headerCS) {
			NotificationChain msgs = null;
			if (headerCS != null)
				msgs = ((InternalEObject)headerCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_MODULE_CS__HEADER_CS, null, msgs);
			if (newHeaderCS != null)
				msgs = ((InternalEObject)newHeaderCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_MODULE_CS__HEADER_CS, null, msgs);
			msgs = basicSetHeaderCS(newHeaderCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_MODULE_CS__HEADER_CS, newHeaderCS, newHeaderCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImportCS> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<ImportCS>(ImportCS.class, this, CSTPackage.MAPPING_MODULE_CS__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelTypeCS> getMetamodels() {
		if (metamodels == null) {
			metamodels = new EObjectContainmentEList<ModelTypeCS>(ModelTypeCS.class, this, CSTPackage.MAPPING_MODULE_CS__METAMODELS);
		}
		return metamodels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RenameCS> getRenamings() {
		if (renamings == null) {
			renamings = new EObjectContainmentEList<RenameCS>(RenameCS.class, this, CSTPackage.MAPPING_MODULE_CS__RENAMINGS);
		}
		return renamings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModulePropertyCS> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<ModulePropertyCS>(ModulePropertyCS.class, this, CSTPackage.MAPPING_MODULE_CS__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingMethodCS> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentEList<MappingMethodCS>(MappingMethodCS.class, this, CSTPackage.MAPPING_MODULE_CS__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassifierDefCS> getClassifierDefCS() {
		if (classifierDefCS == null) {
			classifierDefCS = new EObjectContainmentEList<ClassifierDefCS>(ClassifierDefCS.class, this, CSTPackage.MAPPING_MODULE_CS__CLASSIFIER_DEF_CS);
		}
		return classifierDefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TagCS> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList<TagCS>(TagCS.class, this, CSTPackage.MAPPING_MODULE_CS__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.MAPPING_MODULE_CS__HEADER_CS:
				return basicSetHeaderCS(null, msgs);
			case CSTPackage.MAPPING_MODULE_CS__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case CSTPackage.MAPPING_MODULE_CS__METAMODELS:
				return ((InternalEList<?>)getMetamodels()).basicRemove(otherEnd, msgs);
			case CSTPackage.MAPPING_MODULE_CS__RENAMINGS:
				return ((InternalEList<?>)getRenamings()).basicRemove(otherEnd, msgs);
			case CSTPackage.MAPPING_MODULE_CS__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case CSTPackage.MAPPING_MODULE_CS__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
			case CSTPackage.MAPPING_MODULE_CS__CLASSIFIER_DEF_CS:
				return ((InternalEList<?>)getClassifierDefCS()).basicRemove(otherEnd, msgs);
			case CSTPackage.MAPPING_MODULE_CS__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
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
			case CSTPackage.MAPPING_MODULE_CS__HEADER_CS:
				return getHeaderCS();
			case CSTPackage.MAPPING_MODULE_CS__IMPORTS:
				return getImports();
			case CSTPackage.MAPPING_MODULE_CS__METAMODELS:
				return getMetamodels();
			case CSTPackage.MAPPING_MODULE_CS__RENAMINGS:
				return getRenamings();
			case CSTPackage.MAPPING_MODULE_CS__PROPERTIES:
				return getProperties();
			case CSTPackage.MAPPING_MODULE_CS__METHODS:
				return getMethods();
			case CSTPackage.MAPPING_MODULE_CS__CLASSIFIER_DEF_CS:
				return getClassifierDefCS();
			case CSTPackage.MAPPING_MODULE_CS__TAGS:
				return getTags();
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
			case CSTPackage.MAPPING_MODULE_CS__HEADER_CS:
				setHeaderCS((TransformationHeaderCS)newValue);
				return;
			case CSTPackage.MAPPING_MODULE_CS__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends ImportCS>)newValue);
				return;
			case CSTPackage.MAPPING_MODULE_CS__METAMODELS:
				getMetamodels().clear();
				getMetamodels().addAll((Collection<? extends ModelTypeCS>)newValue);
				return;
			case CSTPackage.MAPPING_MODULE_CS__RENAMINGS:
				getRenamings().clear();
				getRenamings().addAll((Collection<? extends RenameCS>)newValue);
				return;
			case CSTPackage.MAPPING_MODULE_CS__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends ModulePropertyCS>)newValue);
				return;
			case CSTPackage.MAPPING_MODULE_CS__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends MappingMethodCS>)newValue);
				return;
			case CSTPackage.MAPPING_MODULE_CS__CLASSIFIER_DEF_CS:
				getClassifierDefCS().clear();
				getClassifierDefCS().addAll((Collection<? extends ClassifierDefCS>)newValue);
				return;
			case CSTPackage.MAPPING_MODULE_CS__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends TagCS>)newValue);
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
			case CSTPackage.MAPPING_MODULE_CS__HEADER_CS:
				setHeaderCS((TransformationHeaderCS)null);
				return;
			case CSTPackage.MAPPING_MODULE_CS__IMPORTS:
				getImports().clear();
				return;
			case CSTPackage.MAPPING_MODULE_CS__METAMODELS:
				getMetamodels().clear();
				return;
			case CSTPackage.MAPPING_MODULE_CS__RENAMINGS:
				getRenamings().clear();
				return;
			case CSTPackage.MAPPING_MODULE_CS__PROPERTIES:
				getProperties().clear();
				return;
			case CSTPackage.MAPPING_MODULE_CS__METHODS:
				getMethods().clear();
				return;
			case CSTPackage.MAPPING_MODULE_CS__CLASSIFIER_DEF_CS:
				getClassifierDefCS().clear();
				return;
			case CSTPackage.MAPPING_MODULE_CS__TAGS:
				getTags().clear();
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
			case CSTPackage.MAPPING_MODULE_CS__HEADER_CS:
				return headerCS != null;
			case CSTPackage.MAPPING_MODULE_CS__IMPORTS:
				return imports != null && !imports.isEmpty();
			case CSTPackage.MAPPING_MODULE_CS__METAMODELS:
				return metamodels != null && !metamodels.isEmpty();
			case CSTPackage.MAPPING_MODULE_CS__RENAMINGS:
				return renamings != null && !renamings.isEmpty();
			case CSTPackage.MAPPING_MODULE_CS__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case CSTPackage.MAPPING_MODULE_CS__METHODS:
				return methods != null && !methods.isEmpty();
			case CSTPackage.MAPPING_MODULE_CS__CLASSIFIER_DEF_CS:
				return classifierDefCS != null && !classifierDefCS.isEmpty();
			case CSTPackage.MAPPING_MODULE_CS__TAGS:
				return tags != null && !tags.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MappingModuleCSImpl
