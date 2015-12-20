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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rdb.RdbPackage;
import rdb.TableColumn;
import rdb.datatypes.Domain;
import rdb.datatypes.PrimitiveDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.impl.TableColumnImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link rdb.impl.TableColumnImpl#getType <em>Type</em>}</li>
 *   <li>{@link rdb.impl.TableColumnImpl#getIsPrimaryKey <em>Is Primary Key</em>}</li>
 *   <li>{@link rdb.impl.TableColumnImpl#getIsForeignKey <em>Is Foreign Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableColumnImpl extends ColumnImpl implements TableColumn {
	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
    protected Domain domain = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
    protected PrimitiveDataType type = null;

	/**
	 * The default value of the '{@link #getIsPrimaryKey() <em>Is Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getIsPrimaryKey()
	 * @generated
	 * @ordered
	 */
    protected static final Boolean IS_PRIMARY_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsPrimaryKey() <em>Is Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getIsPrimaryKey()
	 * @generated
	 * @ordered
	 */
    protected Boolean isPrimaryKey = IS_PRIMARY_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsForeignKey() <em>Is Foreign Key</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getIsForeignKey()
	 * @generated
	 * @ordered
	 */
    protected static final Boolean IS_FOREIGN_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsForeignKey() <em>Is Foreign Key</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getIsForeignKey()
	 * @generated
	 * @ordered
	 */
    protected Boolean isForeignKey = IS_FOREIGN_KEY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected TableColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				protected EClass eStaticClass() {
		return RdbPackage.Literals.TABLE_COLUMN;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Domain getDomain() {
		if (domain != null && domain.eIsProxy()) {
			InternalEObject oldDomain = (InternalEObject)domain;
			domain = (Domain)eResolveProxy(oldDomain);
			if (domain != oldDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RdbPackage.TABLE_COLUMN__DOMAIN, oldDomain, domain));
			}
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Domain basicGetDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setDomain(Domain newDomain) {
		Domain oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE_COLUMN__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public PrimitiveDataType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetType(PrimitiveDataType newType, NotificationChain msgs) {
		PrimitiveDataType oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE_COLUMN__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setType(PrimitiveDataType newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdbPackage.TABLE_COLUMN__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdbPackage.TABLE_COLUMN__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE_COLUMN__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Boolean getIsPrimaryKey() {
		return isPrimaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setIsPrimaryKey(Boolean newIsPrimaryKey) {
		Boolean oldIsPrimaryKey = isPrimaryKey;
		isPrimaryKey = newIsPrimaryKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE_COLUMN__IS_PRIMARY_KEY, oldIsPrimaryKey, isPrimaryKey));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Boolean getIsForeignKey() {
		return isForeignKey;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setIsForeignKey(Boolean newIsForeignKey) {
		Boolean oldIsForeignKey = isForeignKey;
		isForeignKey = newIsForeignKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE_COLUMN__IS_FOREIGN_KEY, oldIsForeignKey, isForeignKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RdbPackage.TABLE_COLUMN__TYPE:
				return basicSetType(null, msgs);
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
			case RdbPackage.TABLE_COLUMN__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case RdbPackage.TABLE_COLUMN__TYPE:
				return getType();
			case RdbPackage.TABLE_COLUMN__IS_PRIMARY_KEY:
				return getIsPrimaryKey();
			case RdbPackage.TABLE_COLUMN__IS_FOREIGN_KEY:
				return getIsForeignKey();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RdbPackage.TABLE_COLUMN__DOMAIN:
				setDomain((Domain)newValue);
				return;
			case RdbPackage.TABLE_COLUMN__TYPE:
				setType((PrimitiveDataType)newValue);
				return;
			case RdbPackage.TABLE_COLUMN__IS_PRIMARY_KEY:
				setIsPrimaryKey((Boolean)newValue);
				return;
			case RdbPackage.TABLE_COLUMN__IS_FOREIGN_KEY:
				setIsForeignKey((Boolean)newValue);
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
			case RdbPackage.TABLE_COLUMN__DOMAIN:
				setDomain((Domain)null);
				return;
			case RdbPackage.TABLE_COLUMN__TYPE:
				setType((PrimitiveDataType)null);
				return;
			case RdbPackage.TABLE_COLUMN__IS_PRIMARY_KEY:
				setIsPrimaryKey(IS_PRIMARY_KEY_EDEFAULT);
				return;
			case RdbPackage.TABLE_COLUMN__IS_FOREIGN_KEY:
				setIsForeignKey(IS_FOREIGN_KEY_EDEFAULT);
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
			case RdbPackage.TABLE_COLUMN__DOMAIN:
				return domain != null;
			case RdbPackage.TABLE_COLUMN__TYPE:
				return type != null;
			case RdbPackage.TABLE_COLUMN__IS_PRIMARY_KEY:
				return IS_PRIMARY_KEY_EDEFAULT == null ? isPrimaryKey != null : !IS_PRIMARY_KEY_EDEFAULT.equals(isPrimaryKey);
			case RdbPackage.TABLE_COLUMN__IS_FOREIGN_KEY:
				return IS_FOREIGN_KEY_EDEFAULT == null ? isForeignKey != null : !IS_FOREIGN_KEY_EDEFAULT.equals(isForeignKey);
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
		result.append(" (isPrimaryKey: "); //$NON-NLS-1$
		result.append(isPrimaryKey);
		result.append(", isForeignKey: "); //$NON-NLS-1$
		result.append(isForeignKey);
		result.append(')');
		return result.toString();
	}

} //TableColumnImpl
