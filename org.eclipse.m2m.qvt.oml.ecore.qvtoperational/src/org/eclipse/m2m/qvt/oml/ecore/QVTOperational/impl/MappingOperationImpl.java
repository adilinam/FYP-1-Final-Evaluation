/**
 * <copyright>
 * Copyright (c) 2008 Open Canarias and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: MappingOperationImpl.java,v 1.2 2009/01/25 23:12:23 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.MappingOperation;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.MappingOperationImpl#getDisjunct <em>Disjunct</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.MappingOperationImpl#getInherited <em>Inherited</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.MappingOperationImpl#getMerged <em>Merged</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.MappingOperationImpl#getRefinedRelation <em>Refined Relation</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.MappingOperationImpl#getWhen <em>When</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.MappingOperationImpl#getWhere <em>Where</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingOperationImpl extends ImperativeOperationImpl implements MappingOperation {
	/**
	 * The cached value of the '{@link #getDisjunct() <em>Disjunct</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisjunct()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingOperation> disjunct;

	/**
	 * The cached value of the '{@link #getInherited() <em>Inherited</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInherited()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingOperation> inherited;

	/**
	 * The cached value of the '{@link #getMerged() <em>Merged</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMerged()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingOperation> merged;

	/**
	 * The cached value of the '{@link #getRefinedRelation() <em>Refined Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinedRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation refinedRelation;

	/**
	 * The cached value of the '{@link #getWhen() <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression when;

	/**
	 * The cached value of the '{@link #getWhere() <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhere()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression where;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.MAPPING_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingOperation> getDisjunct() {
		if (disjunct == null) {
			disjunct = new EObjectResolvingEList<MappingOperation>(MappingOperation.class, this, QVTOperationalPackage.MAPPING_OPERATION__DISJUNCT);
		}
		return disjunct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingOperation> getInherited() {
		if (inherited == null) {
			inherited = new EObjectResolvingEList<MappingOperation>(MappingOperation.class, this, QVTOperationalPackage.MAPPING_OPERATION__INHERITED);
		}
		return inherited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingOperation> getMerged() {
		if (merged == null) {
			merged = new EObjectResolvingEList<MappingOperation>(MappingOperation.class, this, QVTOperationalPackage.MAPPING_OPERATION__MERGED);
		}
		return merged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getRefinedRelation() {
		if (refinedRelation != null && refinedRelation.eIsProxy()) {
			InternalEObject oldRefinedRelation = (InternalEObject)refinedRelation;
			refinedRelation = (Relation)eResolveProxy(oldRefinedRelation);
			if (refinedRelation != oldRefinedRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalPackage.MAPPING_OPERATION__REFINED_RELATION, oldRefinedRelation, refinedRelation));
			}
		}
		return refinedRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetRefinedRelation() {
		return refinedRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinedRelation(Relation newRefinedRelation) {
		Relation oldRefinedRelation = refinedRelation;
		refinedRelation = newRefinedRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MAPPING_OPERATION__REFINED_RELATION, oldRefinedRelation, refinedRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getWhen() {
		return when;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhen(OCLExpression newWhen, NotificationChain msgs) {
		OCLExpression oldWhen = when;
		when = newWhen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MAPPING_OPERATION__WHEN, oldWhen, newWhen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhen(OCLExpression newWhen) {
		if (newWhen != when) {
			NotificationChain msgs = null;
			if (when != null)
				msgs = ((InternalEObject)when).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalPackage.MAPPING_OPERATION__WHEN, null, msgs);
			if (newWhen != null)
				msgs = ((InternalEObject)newWhen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalPackage.MAPPING_OPERATION__WHEN, null, msgs);
			msgs = basicSetWhen(newWhen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MAPPING_OPERATION__WHEN, newWhen, newWhen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getWhere() {
		return where;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhere(OCLExpression newWhere, NotificationChain msgs) {
		OCLExpression oldWhere = where;
		where = newWhere;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MAPPING_OPERATION__WHERE, oldWhere, newWhere);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhere(OCLExpression newWhere) {
		if (newWhere != where) {
			NotificationChain msgs = null;
			if (where != null)
				msgs = ((InternalEObject)where).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalPackage.MAPPING_OPERATION__WHERE, null, msgs);
			if (newWhere != null)
				msgs = ((InternalEObject)newWhere).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalPackage.MAPPING_OPERATION__WHERE, null, msgs);
			msgs = basicSetWhere(newWhere, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MAPPING_OPERATION__WHERE, newWhere, newWhere));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.MAPPING_OPERATION__WHEN:
				return basicSetWhen(null, msgs);
			case QVTOperationalPackage.MAPPING_OPERATION__WHERE:
				return basicSetWhere(null, msgs);
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
			case QVTOperationalPackage.MAPPING_OPERATION__DISJUNCT:
				return getDisjunct();
			case QVTOperationalPackage.MAPPING_OPERATION__INHERITED:
				return getInherited();
			case QVTOperationalPackage.MAPPING_OPERATION__MERGED:
				return getMerged();
			case QVTOperationalPackage.MAPPING_OPERATION__REFINED_RELATION:
				if (resolve) return getRefinedRelation();
				return basicGetRefinedRelation();
			case QVTOperationalPackage.MAPPING_OPERATION__WHEN:
				return getWhen();
			case QVTOperationalPackage.MAPPING_OPERATION__WHERE:
				return getWhere();
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
			case QVTOperationalPackage.MAPPING_OPERATION__DISJUNCT:
				getDisjunct().clear();
				getDisjunct().addAll((Collection<? extends MappingOperation>)newValue);
				return;
			case QVTOperationalPackage.MAPPING_OPERATION__INHERITED:
				getInherited().clear();
				getInherited().addAll((Collection<? extends MappingOperation>)newValue);
				return;
			case QVTOperationalPackage.MAPPING_OPERATION__MERGED:
				getMerged().clear();
				getMerged().addAll((Collection<? extends MappingOperation>)newValue);
				return;
			case QVTOperationalPackage.MAPPING_OPERATION__REFINED_RELATION:
				setRefinedRelation((Relation)newValue);
				return;
			case QVTOperationalPackage.MAPPING_OPERATION__WHEN:
				setWhen((OCLExpression)newValue);
				return;
			case QVTOperationalPackage.MAPPING_OPERATION__WHERE:
				setWhere((OCLExpression)newValue);
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
			case QVTOperationalPackage.MAPPING_OPERATION__DISJUNCT:
				getDisjunct().clear();
				return;
			case QVTOperationalPackage.MAPPING_OPERATION__INHERITED:
				getInherited().clear();
				return;
			case QVTOperationalPackage.MAPPING_OPERATION__MERGED:
				getMerged().clear();
				return;
			case QVTOperationalPackage.MAPPING_OPERATION__REFINED_RELATION:
				setRefinedRelation((Relation)null);
				return;
			case QVTOperationalPackage.MAPPING_OPERATION__WHEN:
				setWhen((OCLExpression)null);
				return;
			case QVTOperationalPackage.MAPPING_OPERATION__WHERE:
				setWhere((OCLExpression)null);
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
			case QVTOperationalPackage.MAPPING_OPERATION__DISJUNCT:
				return disjunct != null && !disjunct.isEmpty();
			case QVTOperationalPackage.MAPPING_OPERATION__INHERITED:
				return inherited != null && !inherited.isEmpty();
			case QVTOperationalPackage.MAPPING_OPERATION__MERGED:
				return merged != null && !merged.isEmpty();
			case QVTOperationalPackage.MAPPING_OPERATION__REFINED_RELATION:
				return refinedRelation != null;
			case QVTOperationalPackage.MAPPING_OPERATION__WHEN:
				return when != null;
			case QVTOperationalPackage.MAPPING_OPERATION__WHERE:
				return where != null;
		}
		return super.eIsSet(featureID);
	}

} //MappingOperationImpl
