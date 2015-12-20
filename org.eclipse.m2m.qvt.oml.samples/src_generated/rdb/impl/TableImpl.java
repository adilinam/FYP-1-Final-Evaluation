/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package rdb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import rdb.RdbPackage;
import rdb.Table;
import rdb.TableColumn;
import rdb.constraints.CheckConstraint;
import rdb.constraints.ForeignKey;
import rdb.constraints.Index;
import rdb.constraints.PrimaryKey;
import rdb.constraints.UniqueConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.impl.TableImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link rdb.impl.TableImpl#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link rdb.impl.TableImpl#getUniqueConstraints <em>Unique Constraints</em>}</li>
 *   <li>{@link rdb.impl.TableImpl#getForeignKeys <em>Foreign Keys</em>}</li>
 *   <li>{@link rdb.impl.TableImpl#getIndices <em>Indices</em>}</li>
 *   <li>{@link rdb.impl.TableImpl#getChecks <em>Checks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends NamedColumnSetImpl implements Table {
	/**
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
    protected EList<TableColumn> columns = null;

	/**
	 * The cached value of the '{@link #getPrimaryKey() <em>Primary Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getPrimaryKey()
	 * @generated
	 * @ordered
	 */
    protected PrimaryKey primaryKey = null;

	/**
	 * The cached value of the '{@link #getUniqueConstraints() <em>Unique Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getUniqueConstraints()
	 * @generated
	 * @ordered
	 */
    protected EList<UniqueConstraint> uniqueConstraints = null;

	/**
	 * The cached value of the '{@link #getForeignKeys() <em>Foreign Keys</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getForeignKeys()
	 * @generated
	 * @ordered
	 */
    protected EList<ForeignKey> foreignKeys = null;

	/**
	 * The cached value of the '{@link #getIndices() <em>Indices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getIndices()
	 * @generated
	 * @ordered
	 */
    protected EList<Index> indices = null;

	/**
	 * The cached value of the '{@link #getChecks() <em>Checks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getChecks()
	 * @generated
	 * @ordered
	 */
    protected EList<CheckConstraint> checks = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected TableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				protected EClass eStaticClass() {
		return RdbPackage.Literals.TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<TableColumn> getColumns() {
		if (columns == null) {
			columns = new EObjectContainmentEList<TableColumn>(TableColumn.class, this, RdbPackage.TABLE__COLUMNS);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public PrimaryKey getPrimaryKey() {
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetPrimaryKey(PrimaryKey newPrimaryKey, NotificationChain msgs) {
		PrimaryKey oldPrimaryKey = primaryKey;
		primaryKey = newPrimaryKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE__PRIMARY_KEY, oldPrimaryKey, newPrimaryKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setPrimaryKey(PrimaryKey newPrimaryKey) {
		if (newPrimaryKey != primaryKey) {
			NotificationChain msgs = null;
			if (primaryKey != null)
				msgs = ((InternalEObject)primaryKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdbPackage.TABLE__PRIMARY_KEY, null, msgs);
			if (newPrimaryKey != null)
				msgs = ((InternalEObject)newPrimaryKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdbPackage.TABLE__PRIMARY_KEY, null, msgs);
			msgs = basicSetPrimaryKey(newPrimaryKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE__PRIMARY_KEY, newPrimaryKey, newPrimaryKey));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<UniqueConstraint> getUniqueConstraints() {
		if (uniqueConstraints == null) {
			uniqueConstraints = new EObjectContainmentEList<UniqueConstraint>(UniqueConstraint.class, this, RdbPackage.TABLE__UNIQUE_CONSTRAINTS);
		}
		return uniqueConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<ForeignKey> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new EObjectContainmentEList<ForeignKey>(ForeignKey.class, this, RdbPackage.TABLE__FOREIGN_KEYS);
		}
		return foreignKeys;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Index> getIndices() {
		if (indices == null) {
			indices = new EObjectContainmentEList<Index>(Index.class, this, RdbPackage.TABLE__INDICES);
		}
		return indices;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<CheckConstraint> getChecks() {
		if (checks == null) {
			checks = new EObjectContainmentEList<CheckConstraint>(CheckConstraint.class, this, RdbPackage.TABLE__CHECKS);
		}
		return checks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RdbPackage.TABLE__COLUMNS:
				return ((InternalEList<?>)getColumns()).basicRemove(otherEnd, msgs);
			case RdbPackage.TABLE__PRIMARY_KEY:
				return basicSetPrimaryKey(null, msgs);
			case RdbPackage.TABLE__UNIQUE_CONSTRAINTS:
				return ((InternalEList<?>)getUniqueConstraints()).basicRemove(otherEnd, msgs);
			case RdbPackage.TABLE__FOREIGN_KEYS:
				return ((InternalEList<?>)getForeignKeys()).basicRemove(otherEnd, msgs);
			case RdbPackage.TABLE__INDICES:
				return ((InternalEList<?>)getIndices()).basicRemove(otherEnd, msgs);
			case RdbPackage.TABLE__CHECKS:
				return ((InternalEList<?>)getChecks()).basicRemove(otherEnd, msgs);
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
			case RdbPackage.TABLE__COLUMNS:
				return getColumns();
			case RdbPackage.TABLE__PRIMARY_KEY:
				return getPrimaryKey();
			case RdbPackage.TABLE__UNIQUE_CONSTRAINTS:
				return getUniqueConstraints();
			case RdbPackage.TABLE__FOREIGN_KEYS:
				return getForeignKeys();
			case RdbPackage.TABLE__INDICES:
				return getIndices();
			case RdbPackage.TABLE__CHECKS:
				return getChecks();
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
			case RdbPackage.TABLE__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection<? extends TableColumn>)newValue);
				return;
			case RdbPackage.TABLE__PRIMARY_KEY:
				setPrimaryKey((PrimaryKey)newValue);
				return;
			case RdbPackage.TABLE__UNIQUE_CONSTRAINTS:
				getUniqueConstraints().clear();
				getUniqueConstraints().addAll((Collection<? extends UniqueConstraint>)newValue);
				return;
			case RdbPackage.TABLE__FOREIGN_KEYS:
				getForeignKeys().clear();
				getForeignKeys().addAll((Collection<? extends ForeignKey>)newValue);
				return;
			case RdbPackage.TABLE__INDICES:
				getIndices().clear();
				getIndices().addAll((Collection<? extends Index>)newValue);
				return;
			case RdbPackage.TABLE__CHECKS:
				getChecks().clear();
				getChecks().addAll((Collection<? extends CheckConstraint>)newValue);
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
			case RdbPackage.TABLE__COLUMNS:
				getColumns().clear();
				return;
			case RdbPackage.TABLE__PRIMARY_KEY:
				setPrimaryKey((PrimaryKey)null);
				return;
			case RdbPackage.TABLE__UNIQUE_CONSTRAINTS:
				getUniqueConstraints().clear();
				return;
			case RdbPackage.TABLE__FOREIGN_KEYS:
				getForeignKeys().clear();
				return;
			case RdbPackage.TABLE__INDICES:
				getIndices().clear();
				return;
			case RdbPackage.TABLE__CHECKS:
				getChecks().clear();
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
			case RdbPackage.TABLE__COLUMNS:
				return columns != null && !columns.isEmpty();
			case RdbPackage.TABLE__PRIMARY_KEY:
				return primaryKey != null;
			case RdbPackage.TABLE__UNIQUE_CONSTRAINTS:
				return uniqueConstraints != null && !uniqueConstraints.isEmpty();
			case RdbPackage.TABLE__FOREIGN_KEYS:
				return foreignKeys != null && !foreignKeys.isEmpty();
			case RdbPackage.TABLE__INDICES:
				return indices != null && !indices.isEmpty();
			case RdbPackage.TABLE__CHECKS:
				return checks != null && !checks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TableImpl
