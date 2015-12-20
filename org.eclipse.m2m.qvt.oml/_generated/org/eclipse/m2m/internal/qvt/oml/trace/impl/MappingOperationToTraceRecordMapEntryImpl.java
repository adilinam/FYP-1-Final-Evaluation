/**
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *
 * $Id: MappingOperationToTraceRecordMapEntryImpl.java,v 1.3 2009/05/15 12:07:10 radvorak Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.trace.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.trace.TracePackage;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Operation To Trace Record Map Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.trace.impl.MappingOperationToTraceRecordMapEntryImpl#getTypedValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.trace.impl.MappingOperationToTraceRecordMapEntryImpl#getTypedKey <em>Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingOperationToTraceRecordMapEntryImpl extends EObjectImpl implements BasicEMap.Entry<MappingOperation,EList<TraceRecord>> {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

    /**
	 * The cached value of the '{@link #getTypedValue() <em>Value</em>}' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
    protected EList<TraceRecord> value;

    /**
	 * The cached value of the '{@link #getTypedKey() <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTypedKey()
	 * @generated
	 * @ordered
	 */
    protected MappingOperation key;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected MappingOperationToTraceRecordMapEntryImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return TracePackage.Literals.MAPPING_OPERATION_TO_TRACE_RECORD_MAP_ENTRY;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<TraceRecord> getTypedValue() {
		if (value == null) {
			value = new EObjectResolvingEList<TraceRecord>(TraceRecord.class, this, TracePackage.MAPPING_OPERATION_TO_TRACE_RECORD_MAP_ENTRY__VALUE);
		}
		return value;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public MappingOperation getTypedKey() {
		if (key != null && key.eIsProxy()) {
			InternalEObject oldKey = (InternalEObject)key;
			key = (MappingOperation)eResolveProxy(oldKey);
			if (key != oldKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.MAPPING_OPERATION_TO_TRACE_RECORD_MAP_ENTRY__KEY, oldKey, key));
			}
		}
		return key;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public MappingOperation basicGetTypedKey() {
		return key;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setTypedKey(MappingOperation newKey) {
		MappingOperation oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.MAPPING_OPERATION_TO_TRACE_RECORD_MAP_ENTRY__KEY, oldKey, key));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TracePackage.MAPPING_OPERATION_TO_TRACE_RECORD_MAP_ENTRY__VALUE:
				return getTypedValue();
			case TracePackage.MAPPING_OPERATION_TO_TRACE_RECORD_MAP_ENTRY__KEY:
				if (resolve) return getTypedKey();
				return basicGetTypedKey();
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
			case TracePackage.MAPPING_OPERATION_TO_TRACE_RECORD_MAP_ENTRY__VALUE:
				getTypedValue().clear();
				getTypedValue().addAll((Collection<? extends TraceRecord>)newValue);
				return;
			case TracePackage.MAPPING_OPERATION_TO_TRACE_RECORD_MAP_ENTRY__KEY:
				setTypedKey((MappingOperation)newValue);
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
			case TracePackage.MAPPING_OPERATION_TO_TRACE_RECORD_MAP_ENTRY__VALUE:
				getTypedValue().clear();
				return;
			case TracePackage.MAPPING_OPERATION_TO_TRACE_RECORD_MAP_ENTRY__KEY:
				setTypedKey((MappingOperation)null);
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
			case TracePackage.MAPPING_OPERATION_TO_TRACE_RECORD_MAP_ENTRY__VALUE:
				return value != null && !value.isEmpty();
			case TracePackage.MAPPING_OPERATION_TO_TRACE_RECORD_MAP_ENTRY__KEY:
				return key != null;
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected int hash = -1;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getHash() {
		if (hash == -1) {
			Object theKey = getKey();
			hash = (theKey == null ? 0 : theKey.hashCode());
		}
		return hash;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setHash(int hash) {
		this.hash = hash;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public MappingOperation getKey() {
		return getTypedKey();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setKey(MappingOperation key) {
		setTypedKey(key);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<TraceRecord> getValue() {
		return getTypedValue();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<TraceRecord> setValue(EList<TraceRecord> value) {
		EList<TraceRecord> oldValue = getValue();
		getTypedValue().clear();
		getTypedValue().addAll(value);
		return oldValue;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    public EMap<MappingOperation, EList<TraceRecord>> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<MappingOperation, EList<TraceRecord>>)container.eGet(eContainmentFeature());
	}

} //MappingOperationToTraceRecordMapEntryImpl
