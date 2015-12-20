/**
 * <copyright>
 * Copyright (c) 2013 Willink Transformations, University of York, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo (University of York) - Bug397429
 * </copyright>
 */
package org.eclipse.qvto.examples.pivot.qvtoperational.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.ClassImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelType;
import org.eclipse.qvto.examples.pivot.qvtoperational.Module;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getConfigProperty <em>Config Property</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#isIsBlackbox <em>Is Blackbox</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getModuleImport <em>Module Import</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getOwnedVariable <em>Owned Variable</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getUsedModelType <em>Used Model Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModuleImpl extends ClassImpl implements Module {
	/**
	 * The cached value of the '{@link #getConfigProperty() <em>Config Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> configProperty;

	/**
	 * The cached value of the '{@link #getEntry() <em>Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntry()
	 * @generated
	 * @ordered
	 */
	protected EntryOperation entry;

	/**
	 * The default value of the '{@link #isIsBlackbox() <em>Is Blackbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBlackbox()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_BLACKBOX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsBlackbox() <em>Is Blackbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBlackbox()
	 * @generated
	 * @ordered
	 */
	protected boolean isBlackbox = IS_BLACKBOX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModuleImport() <em>Module Import</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleImport()
	 * @generated
	 * @ordered
	 */
	protected EList<ModuleImport> moduleImport;

	/**
	 * The cached value of the '{@link #getOwnedTag() <em>Owned Tag</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTag()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateableElement> ownedTag;

	/**
	 * The cached value of the '{@link #getOwnedVariable() <em>Owned Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> ownedVariable;

	/**
	 * The cached value of the '{@link #getUsedModelType() <em>Used Model Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedModelType()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelType> usedModelType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getConfigProperty() {
		if (configProperty == null) {
			configProperty = new EObjectResolvingEList<Property>(Property.class, this, QVTOperationalPackage.MODULE__CONFIG_PROPERTY);
		}
		return configProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryOperation getEntry() {
		if (entry != null && entry.eIsProxy()) {
			InternalEObject oldEntry = (InternalEObject)entry;
			entry = (EntryOperation)eResolveProxy(oldEntry);
			if (entry != oldEntry) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalPackage.MODULE__ENTRY, oldEntry, entry));
			}
		}
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryOperation basicGetEntry() {
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntry(EntryOperation newEntry) {
		EntryOperation oldEntry = entry;
		entry = newEntry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__ENTRY, oldEntry, entry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsBlackbox() {
		return isBlackbox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBlackbox(boolean newIsBlackbox) {
		boolean oldIsBlackbox = isBlackbox;
		isBlackbox = newIsBlackbox;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__IS_BLACKBOX, oldIsBlackbox, isBlackbox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModuleImport> getModuleImport() {
		if (moduleImport == null) {
			moduleImport = new EObjectContainmentWithInverseEList<ModuleImport>(ModuleImport.class, this, QVTOperationalPackage.MODULE__MODULE_IMPORT, QVTOperationalPackage.MODULE_IMPORT__MODULE);
		}
		return moduleImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplateableElement> getOwnedTag() {
		if (ownedTag == null) {
			ownedTag = new EObjectContainmentEList<TemplateableElement>(TemplateableElement.class, this, QVTOperationalPackage.MODULE__OWNED_TAG);
		}
		return ownedTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getOwnedVariable() {
		if (ownedVariable == null) {
			ownedVariable = new EObjectContainmentEList<Variable>(Variable.class, this, QVTOperationalPackage.MODULE__OWNED_VARIABLE);
		}
		return ownedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelType> getUsedModelType() {
		if (usedModelType == null) {
			usedModelType = new EObjectResolvingEList<ModelType>(ModelType.class, this, QVTOperationalPackage.MODULE__USED_MODEL_TYPE);
		}
		return usedModelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.MODULE__MODULE_IMPORT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getModuleImport()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.MODULE__MODULE_IMPORT:
				return ((InternalEList<?>)getModuleImport()).basicRemove(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__OWNED_TAG:
				return ((InternalEList<?>)getOwnedTag()).basicRemove(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__OWNED_VARIABLE:
				return ((InternalEList<?>)getOwnedVariable()).basicRemove(otherEnd, msgs);
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
			case QVTOperationalPackage.MODULE__CONFIG_PROPERTY:
				return getConfigProperty();
			case QVTOperationalPackage.MODULE__ENTRY:
				if (resolve) return getEntry();
				return basicGetEntry();
			case QVTOperationalPackage.MODULE__IS_BLACKBOX:
				return isIsBlackbox();
			case QVTOperationalPackage.MODULE__MODULE_IMPORT:
				return getModuleImport();
			case QVTOperationalPackage.MODULE__OWNED_TAG:
				return getOwnedTag();
			case QVTOperationalPackage.MODULE__OWNED_VARIABLE:
				return getOwnedVariable();
			case QVTOperationalPackage.MODULE__USED_MODEL_TYPE:
				return getUsedModelType();
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
			case QVTOperationalPackage.MODULE__CONFIG_PROPERTY:
				getConfigProperty().clear();
				getConfigProperty().addAll((Collection<? extends Property>)newValue);
				return;
			case QVTOperationalPackage.MODULE__ENTRY:
				setEntry((EntryOperation)newValue);
				return;
			case QVTOperationalPackage.MODULE__IS_BLACKBOX:
				setIsBlackbox((Boolean)newValue);
				return;
			case QVTOperationalPackage.MODULE__MODULE_IMPORT:
				getModuleImport().clear();
				getModuleImport().addAll((Collection<? extends ModuleImport>)newValue);
				return;
			case QVTOperationalPackage.MODULE__OWNED_TAG:
				getOwnedTag().clear();
				getOwnedTag().addAll((Collection<? extends TemplateableElement>)newValue);
				return;
			case QVTOperationalPackage.MODULE__OWNED_VARIABLE:
				getOwnedVariable().clear();
				getOwnedVariable().addAll((Collection<? extends Variable>)newValue);
				return;
			case QVTOperationalPackage.MODULE__USED_MODEL_TYPE:
				getUsedModelType().clear();
				getUsedModelType().addAll((Collection<? extends ModelType>)newValue);
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
			case QVTOperationalPackage.MODULE__CONFIG_PROPERTY:
				getConfigProperty().clear();
				return;
			case QVTOperationalPackage.MODULE__ENTRY:
				setEntry((EntryOperation)null);
				return;
			case QVTOperationalPackage.MODULE__IS_BLACKBOX:
				setIsBlackbox(IS_BLACKBOX_EDEFAULT);
				return;
			case QVTOperationalPackage.MODULE__MODULE_IMPORT:
				getModuleImport().clear();
				return;
			case QVTOperationalPackage.MODULE__OWNED_TAG:
				getOwnedTag().clear();
				return;
			case QVTOperationalPackage.MODULE__OWNED_VARIABLE:
				getOwnedVariable().clear();
				return;
			case QVTOperationalPackage.MODULE__USED_MODEL_TYPE:
				getUsedModelType().clear();
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
			case QVTOperationalPackage.MODULE__CONFIG_PROPERTY:
				return configProperty != null && !configProperty.isEmpty();
			case QVTOperationalPackage.MODULE__ENTRY:
				return entry != null;
			case QVTOperationalPackage.MODULE__IS_BLACKBOX:
				return isBlackbox != IS_BLACKBOX_EDEFAULT;
			case QVTOperationalPackage.MODULE__MODULE_IMPORT:
				return moduleImport != null && !moduleImport.isEmpty();
			case QVTOperationalPackage.MODULE__OWNED_TAG:
				return ownedTag != null && !ownedTag.isEmpty();
			case QVTOperationalPackage.MODULE__OWNED_VARIABLE:
				return ownedVariable != null && !ownedVariable.isEmpty();
			case QVTOperationalPackage.MODULE__USED_MODEL_TYPE:
				return usedModelType != null && !usedModelType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(Visitor<R> visitor) {
		return (R) ((QVTOperationalVisitor<?>)visitor).visitModule(this);
	}

} //ModuleImpl
