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
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rdb.datatypes.DataType;
import rdb.datatypes.DatatypesPackage;
import rdb.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.datatypes.impl.DataTypeImpl#getSize <em>Size</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DataTypeImpl#getDecimalDigits <em>Decimal Digits</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DataTypeImpl#isNullable <em>Nullable</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DataTypeImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DataTypeImpl#getCheck <em>Check</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DataTypeImpl#getVar <em>Var</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DataTypeImpl extends NamedElementImpl implements DataType {
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
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected DataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				protected EClass eStaticClass() {
		return DatatypesPackage.Literals.DATA_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DATA_TYPE__SIZE, oldSize, size));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DATA_TYPE__DECIMAL_DIGITS, oldDecimalDigits, decimalDigits));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DATA_TYPE__NULLABLE, oldNullable, nullable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DATA_TYPE__DEFAULT, oldDefault, default_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DATA_TYPE__CHECK, oldCheck, check));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DATA_TYPE__VAR, oldVar, var));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatatypesPackage.DATA_TYPE__SIZE:
				return new Integer(getSize());
			case DatatypesPackage.DATA_TYPE__DECIMAL_DIGITS:
				return new Integer(getDecimalDigits());
			case DatatypesPackage.DATA_TYPE__NULLABLE:
				return isNullable() ? Boolean.TRUE : Boolean.FALSE;
			case DatatypesPackage.DATA_TYPE__DEFAULT:
				return getDefault();
			case DatatypesPackage.DATA_TYPE__CHECK:
				return getCheck();
			case DatatypesPackage.DATA_TYPE__VAR:
				return getVar();
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
			case DatatypesPackage.DATA_TYPE__SIZE:
				setSize(((Integer)newValue).intValue());
				return;
			case DatatypesPackage.DATA_TYPE__DECIMAL_DIGITS:
				setDecimalDigits(((Integer)newValue).intValue());
				return;
			case DatatypesPackage.DATA_TYPE__NULLABLE:
				setNullable(((Boolean)newValue).booleanValue());
				return;
			case DatatypesPackage.DATA_TYPE__DEFAULT:
				setDefault((String)newValue);
				return;
			case DatatypesPackage.DATA_TYPE__CHECK:
				setCheck((String)newValue);
				return;
			case DatatypesPackage.DATA_TYPE__VAR:
				setVar((String)newValue);
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
			case DatatypesPackage.DATA_TYPE__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case DatatypesPackage.DATA_TYPE__DECIMAL_DIGITS:
				setDecimalDigits(DECIMAL_DIGITS_EDEFAULT);
				return;
			case DatatypesPackage.DATA_TYPE__NULLABLE:
				setNullable(NULLABLE_EDEFAULT);
				return;
			case DatatypesPackage.DATA_TYPE__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case DatatypesPackage.DATA_TYPE__CHECK:
				setCheck(CHECK_EDEFAULT);
				return;
			case DatatypesPackage.DATA_TYPE__VAR:
				setVar(VAR_EDEFAULT);
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
			case DatatypesPackage.DATA_TYPE__SIZE:
				return size != SIZE_EDEFAULT;
			case DatatypesPackage.DATA_TYPE__DECIMAL_DIGITS:
				return decimalDigits != DECIMAL_DIGITS_EDEFAULT;
			case DatatypesPackage.DATA_TYPE__NULLABLE:
				return nullable != NULLABLE_EDEFAULT;
			case DatatypesPackage.DATA_TYPE__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case DatatypesPackage.DATA_TYPE__CHECK:
				return CHECK_EDEFAULT == null ? check != null : !CHECK_EDEFAULT.equals(check);
			case DatatypesPackage.DATA_TYPE__VAR:
				return VAR_EDEFAULT == null ? var != null : !VAR_EDEFAULT.equals(var);
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
		result.append(')');
		return result.toString();
	}

} //DataTypeImpl
