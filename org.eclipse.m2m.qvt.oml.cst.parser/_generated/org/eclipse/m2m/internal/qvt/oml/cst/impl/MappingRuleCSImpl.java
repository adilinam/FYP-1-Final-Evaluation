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
 * $Id: MappingRuleCSImpl.java,v 1.4 2010/01/29 15:23:41 sboyko Exp $
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
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;

import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Rule CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingRuleCSImpl#getGuards <em>Guards</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingRuleCSImpl#getPosts <em>Posts</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingRuleCSImpl#getMappingBody <em>Mapping Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingRuleCSImpl extends MappingMethodCSImpl implements MappingRuleCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getGuards() <em>Guards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpressionCS> guards;

	/**
	 * The cached value of the '{@link #getPosts() <em>Posts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosts()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpressionCS> posts;

	/**
	 * The cached value of the '{@link #getMappingBody() <em>Mapping Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingBody()
	 * @generated
	 * @ordered
	 */
	protected MappingSectionsCS mappingBody;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingRuleCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.MAPPING_RULE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpressionCS> getGuards() {
		if (guards == null) {
			guards = new EObjectContainmentEList<OCLExpressionCS>(OCLExpressionCS.class, this, CSTPackage.MAPPING_RULE_CS__GUARDS);
		}
		return guards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpressionCS> getPosts() {
		if (posts == null) {
			posts = new EObjectContainmentEList<OCLExpressionCS>(OCLExpressionCS.class, this, CSTPackage.MAPPING_RULE_CS__POSTS);
		}
		return posts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingSectionsCS getMappingBody() {
		return mappingBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingBody(MappingSectionsCS newMappingBody, NotificationChain msgs) {
		MappingSectionsCS oldMappingBody = mappingBody;
		mappingBody = newMappingBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_RULE_CS__MAPPING_BODY, oldMappingBody, newMappingBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingBody(MappingSectionsCS newMappingBody) {
		if (newMappingBody != mappingBody) {
			NotificationChain msgs = null;
			if (mappingBody != null)
				msgs = ((InternalEObject)mappingBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_RULE_CS__MAPPING_BODY, null, msgs);
			if (newMappingBody != null)
				msgs = ((InternalEObject)newMappingBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_RULE_CS__MAPPING_BODY, null, msgs);
			msgs = basicSetMappingBody(newMappingBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_RULE_CS__MAPPING_BODY, newMappingBody, newMappingBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.MAPPING_RULE_CS__GUARDS:
				return ((InternalEList<?>)getGuards()).basicRemove(otherEnd, msgs);
			case CSTPackage.MAPPING_RULE_CS__POSTS:
				return ((InternalEList<?>)getPosts()).basicRemove(otherEnd, msgs);
			case CSTPackage.MAPPING_RULE_CS__MAPPING_BODY:
				return basicSetMappingBody(null, msgs);
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
			case CSTPackage.MAPPING_RULE_CS__GUARDS:
				return getGuards();
			case CSTPackage.MAPPING_RULE_CS__POSTS:
				return getPosts();
			case CSTPackage.MAPPING_RULE_CS__MAPPING_BODY:
				return getMappingBody();
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
			case CSTPackage.MAPPING_RULE_CS__GUARDS:
				getGuards().clear();
				getGuards().addAll((Collection<? extends OCLExpressionCS>)newValue);
				return;
			case CSTPackage.MAPPING_RULE_CS__POSTS:
				getPosts().clear();
				getPosts().addAll((Collection<? extends OCLExpressionCS>)newValue);
				return;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_BODY:
				setMappingBody((MappingSectionsCS)newValue);
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
			case CSTPackage.MAPPING_RULE_CS__GUARDS:
				getGuards().clear();
				return;
			case CSTPackage.MAPPING_RULE_CS__POSTS:
				getPosts().clear();
				return;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_BODY:
				setMappingBody((MappingSectionsCS)null);
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
			case CSTPackage.MAPPING_RULE_CS__GUARDS:
				return guards != null && !guards.isEmpty();
			case CSTPackage.MAPPING_RULE_CS__POSTS:
				return posts != null && !posts.isEmpty();
			case CSTPackage.MAPPING_RULE_CS__MAPPING_BODY:
				return mappingBody != null;
		}
		return super.eIsSet(featureID);
	}

} //MappingRuleCSImpl
