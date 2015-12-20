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
package rdb.datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rdb.datatypes.DataType;
import rdb.datatypes.DatatypesPackage;
import rdb.datatypes.Domain;
import rdb.datatypes.PrimitiveDataType;
import rdb.impl.SchemaElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.datatypes.impl.DomainImpl#getSize <em>Size</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DomainImpl#getDecimalDigits <em>Decimal Digits</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DomainImpl#isNullable <em>Nullable</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DomainImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DomainImpl#getCheck <em>Check</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DomainImpl#getVar <em>Var</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DomainImpl#getType <em>Type</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DomainImpl#getParentDomain <em>Parent Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainImpl extends SchemaElementImpl implements Domain {
	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
    protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
    protected int size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDecimalDigits() <em>Decimal Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDecimalDigits()
	 * @generated
	 * @ordered
	 */
    protected static final int DECIMAL_DIGITS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDecimalDigits() <em>Decimal Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDecimalDigits()
	 * @generated
	 * @ordered
	 */
    protected int decimalDigits = DECIMAL_DIGITS_EDEFAULT;

	/**
	 * The default value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
    protected static final boolean NULLABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
    protected boolean nullable = NULLABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
    protected static final String DEFAULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
    protected String default_ = DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCheck() <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getCheck()
	 * @generated
	 * @ordered
	 */
    protected static final String CHECK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCheck() <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getCheck()
	 * @generated
	 * @ordered
	 */
    protected String check = CHECK_EDEFAULT;

	/**
	 * The default value of the '{@link #getVar() <em>Var</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getVar()
	 * @generated
	 * @ordered
	 */
    protected static final String VAR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVar() <em>Var</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getVar()
	 * @generated
	 * @ordered
	 */
    protected String var = VAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
    protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
    protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParentDomain() <em>Parent Domain</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getParentDomain()
	 * @generated
	 * @ordered
	 */
    protected Domain parentDomain = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected DomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				protected EClass eStaticClass() {
		return DatatypesPackage.Literals.DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DOMAIN__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getDecimalDigits() {
		return decimalDigits;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setDecimalDigits(int newDecimalDigits) {
		int oldDecimalDigits = decimalDigits;
		decimalDigits = newDecimalDigits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DOMAIN__DECIMAL_DIGITS, oldDecimalDigits, decimalDigits));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public boolean isNullable() {
		return nullable;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setNullable(boolean newNullable) {
		boolean oldNullable = nullable;
		nullable = newNullable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DOMAIN__NULLABLE, oldNullable, nullable));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setDefault(String newDefault) {
		String oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DOMAIN__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getCheck() {
		return check;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setCheck(String newCheck) {
		String oldCheck = check;
		check = newCheck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DOMAIN__CHECK, oldCheck, check));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getVar() {
		return var;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setVar(String newVar) {
		String oldVar = var;
		var = newVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DOMAIN__VAR, oldVar, var));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DOMAIN__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Domain getParentDomain() {
		if (parentDomain != null && parentDomain.eIsProxy()) {
			InternalEObject oldParentDomain = (InternalEObject)parentDomain;
			parentDomain = (Domain)eResolveProxy(oldParentDomain);
			if (parentDomain != oldParentDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatatypesPackage.DOMAIN__PARENT_DOMAIN, oldParentDomain, parentDomain));
			}
		}
		return parentDomain;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Domain basicGetParentDomain() {
		return parentDomain;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setParentDomain(Domain newParentDomain) {
		Domain oldParentDomain = parentDomain;
		parentDomain = newParentDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DOMAIN__PARENT_DOMAIN, oldParentDomain, parentDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatatypesPackage.DOMAIN__SIZE:
				return new Integer(getSize());
			case DatatypesPackage.DOMAIN__DECIMAL_DIGITS:
				return new Integer(getDecimalDigits());
			case DatatypesPackage.DOMAIN__NULLABLE:
				return isNullable() ? Boolean.TRUE : Boolean.FALSE;
			case DatatypesPackage.DOMAIN__DEFAULT:
				return getDefault();
			case DatatypesPackage.DOMAIN__CHECK:
				return getCheck();
			case DatatypesPackage.DOMAIN__VAR:
				return getVar();
			case DatatypesPackage.DOMAIN__TYPE:
				return getType();
			case DatatypesPackage.DOMAIN__PARENT_DOMAIN:
				if (resolve) return getParentDomain();
				return basicGetParentDomain();
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
			case DatatypesPackage.DOMAIN__SIZE:
				setSize(((Integer)newValue).intValue());
				return;
			case DatatypesPackage.DOMAIN__DECIMAL_DIGITS:
				setDecimalDigits(((Integer)newValue).intValue());
				return;
			case DatatypesPackage.DOMAIN__NULLABLE:
				setNullable(((Boolean)newValue).booleanValue());
				return;
			case DatatypesPackage.DOMAIN__DEFAULT:
				setDefault((String)newValue);
				return;
			case DatatypesPackage.DOMAIN__CHECK:
				setCheck((String)newValue);
				return;
			case DatatypesPackage.DOMAIN__VAR:
				setVar((String)newValue);
				return;
			case DatatypesPackage.DOMAIN__TYPE:
				setType((String)newValue);
				return;
			case DatatypesPackage.DOMAIN__PARENT_DOMAIN:
				setParentDomain((Domain)newValue);
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
			case DatatypesPackage.DOMAIN__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case DatatypesPackage.DOMAIN__DECIMAL_DIGITS:
				setDecimalDigits(DECIMAL_DIGITS_EDEFAULT);
				return;
			case DatatypesPackage.DOMAIN__NULLABLE:
				setNullable(NULLABLE_EDEFAULT);
				return;
			case DatatypesPackage.DOMAIN__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case DatatypesPackage.DOMAIN__CHECK:
				setCheck(CHECK_EDEFAULT);
				return;
			case DatatypesPackage.DOMAIN__VAR:
				setVar(VAR_EDEFAULT);
				return;
			case DatatypesPackage.DOMAIN__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case DatatypesPackage.DOMAIN__PARENT_DOMAIN:
				setParentDomain((Domain)null);
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
			case DatatypesPackage.DOMAIN__SIZE:
				return size != SIZE_EDEFAULT;
			case DatatypesPackage.DOMAIN__DECIMAL_DIGITS:
				return decimalDigits != DECIMAL_DIGITS_EDEFAULT;
			case DatatypesPackage.DOMAIN__NULLABLE:
				return nullable != NULLABLE_EDEFAULT;
			case DatatypesPackage.DOMAIN__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case DatatypesPackage.DOMAIN__CHECK:
				return CHECK_EDEFAULT == null ? check != null : !CHECK_EDEFAULT.equals(check);
			case DatatypesPackage.DOMAIN__VAR:
				return VAR_EDEFAULT == null ? var != null : !VAR_EDEFAULT.equals(var);
			case DatatypesPackage.DOMAIN__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case DatatypesPackage.DOMAIN__PARENT_DOMAIN:
				return parentDomain != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DataType.class) {
			switch (derivedFeatureID) {
				case DatatypesPackage.DOMAIN__SIZE: return DatatypesPackage.DATA_TYPE__SIZE;
				case DatatypesPackage.DOMAIN__DECIMAL_DIGITS: return DatatypesPackage.DATA_TYPE__DECIMAL_DIGITS;
				case DatatypesPackage.DOMAIN__NULLABLE: return DatatypesPackage.DATA_TYPE__NULLABLE;
				case DatatypesPackage.DOMAIN__DEFAULT: return DatatypesPackage.DATA_TYPE__DEFAULT;
				case DatatypesPackage.DOMAIN__CHECK: return DatatypesPackage.DATA_TYPE__CHECK;
				case DatatypesPackage.DOMAIN__VAR: return DatatypesPackage.DATA_TYPE__VAR;
				default: return -1;
			}
		}
		if (baseClass == PrimitiveDataType.class) {
			switch (derivedFeatureID) {
				case DatatypesPackage.DOMAIN__TYPE: return DatatypesPackage.PRIMITIVE_DATA_TYPE__TYPE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DataType.class) {
			switch (baseFeatureID) {
				case DatatypesPackage.DATA_TYPE__SIZE: return DatatypesPackage.DOMAIN__SIZE;
				case DatatypesPackage.DATA_TYPE__DECIMAL_DIGITS: return DatatypesPackage.DOMAIN__DECIMAL_DIGITS;
				case DatatypesPackage.DATA_TYPE__NULLABLE: return DatatypesPackage.DOMAIN__NULLABLE;
				case DatatypesPackage.DATA_TYPE__DEFAULT: return DatatypesPackage.DOMAIN__DEFAULT;
				case DatatypesPackage.DATA_TYPE__CHECK: return DatatypesPackage.DOMAIN__CHECK;
				case DatatypesPackage.DATA_TYPE__VAR: return DatatypesPackage.DOMAIN__VAR;
				default: return -1;
			}
		}
		if (baseClass == PrimitiveDataType.class) {
			switch (baseFeatureID) {
				case DatatypesPackage.PRIMITIVE_DATA_TYPE__TYPE: return DatatypesPackage.DOMAIN__TYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (size: "); //$NON-NLS-1$
		result.append(size);
		result.append(", decimalDigits: "); //$NON-NLS-1$
		result.append(decimalDigits);
		result.append(", nullable: "); //$NON-NLS-1$
		result.append(nullable);
		result.append(", default: "); //$NON-NLS-1$
		result.append(default_);
		result.append(", check: "); //$NON-NLS-1$
		result.append(check);
		result.append(", var: "); //$NON-NLS-1$
		result.append(var);
		result.append(", type: "); //$NON-NLS-1$
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //DomainImpl
