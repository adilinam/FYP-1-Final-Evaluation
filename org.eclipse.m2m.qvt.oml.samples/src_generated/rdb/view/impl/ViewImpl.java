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
package rdb.view.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import rdb.impl.NamedColumnSetImpl;
import rdb.view.View;
import rdb.view.ViewAlias;
import rdb.view.ViewColumn;
import rdb.view.ViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.view.impl.ViewImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link rdb.view.impl.ViewImpl#getReferencedTablesAndViews <em>Referenced Tables And Views</em>}</li>
 *   <li>{@link rdb.view.impl.ViewImpl#getDdl <em>Ddl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewImpl extends NamedColumnSetImpl implements View {
	/**
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
    protected EList<ViewColumn> columns = null;

	/**
	 * The cached value of the '{@link #getReferencedTablesAndViews() <em>Referenced Tables And Views</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getReferencedTablesAndViews()
	 * @generated
	 * @ordered
	 */
    protected EList<ViewAlias> referencedTablesAndViews = null;

	/**
	 * The default value of the '{@link #getDdl() <em>Ddl</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDdl()
	 * @generated
	 * @ordered
	 */
    protected static final String DDL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDdl() <em>Ddl</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDdl()
	 * @generated
	 * @ordered
	 */
    protected String ddl = DDL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				protected EClass eStaticClass() {
		return ViewPackage.Literals.VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<ViewColumn> getColumns() {
		if (columns == null) {
			columns = new EObjectContainmentEList<ViewColumn>(ViewColumn.class, this, ViewPackage.VIEW__COLUMNS);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<ViewAlias> getReferencedTablesAndViews() {
		if (referencedTablesAndViews == null) {
			referencedTablesAndViews = new EObjectContainmentEList<ViewAlias>(ViewAlias.class, this, ViewPackage.VIEW__REFERENCED_TABLES_AND_VIEWS);
		}
		return referencedTablesAndViews;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getDdl() {
		return ddl;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setDdl(String newDdl) {
		String oldDdl = ddl;
		ddl = newDdl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.VIEW__DDL, oldDdl, ddl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ViewPackage.VIEW__COLUMNS:
				return ((InternalEList<?>)getColumns()).basicRemove(otherEnd, msgs);
			case ViewPackage.VIEW__REFERENCED_TABLES_AND_VIEWS:
				return ((InternalEList<?>)getReferencedTablesAndViews()).basicRemove(otherEnd, msgs);
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
			case ViewPackage.VIEW__COLUMNS:
				return getColumns();
			case ViewPackage.VIEW__REFERENCED_TABLES_AND_VIEWS:
				return getReferencedTablesAndViews();
			case ViewPackage.VIEW__DDL:
				return getDdl();
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
			case ViewPackage.VIEW__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection<? extends ViewColumn>)newValue);
				return;
			case ViewPackage.VIEW__REFERENCED_TABLES_AND_VIEWS:
				getReferencedTablesAndViews().clear();
				getReferencedTablesAndViews().addAll((Collection<? extends ViewAlias>)newValue);
				return;
			case ViewPackage.VIEW__DDL:
				setDdl((String)newValue);
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
			case ViewPackage.VIEW__COLUMNS:
				getColumns().clear();
				return;
			case ViewPackage.VIEW__REFERENCED_TABLES_AND_VIEWS:
				getReferencedTablesAndViews().clear();
				return;
			case ViewPackage.VIEW__DDL:
				setDdl(DDL_EDEFAULT);
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
			case ViewPackage.VIEW__COLUMNS:
				return columns != null && !columns.isEmpty();
			case ViewPackage.VIEW__REFERENCED_TABLES_AND_VIEWS:
				return referencedTablesAndViews != null && !referencedTablesAndViews.isEmpty();
			case ViewPackage.VIEW__DDL:
				return DDL_EDEFAULT == null ? ddl != null : !DDL_EDEFAULT.equals(ddl);
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
		result.append(" (ddl: "); //$NON-NLS-1$
		result.append(ddl);
		result.append(')');
		return result.toString();
	}

} //ViewImpl
