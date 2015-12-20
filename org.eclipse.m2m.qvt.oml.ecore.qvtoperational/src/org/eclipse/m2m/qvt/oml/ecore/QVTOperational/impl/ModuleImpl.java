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
 * $Id: ModuleImpl.java,v 1.5 2009/02/20 11:04:08 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.EntryOperation;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ModelType;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ModuleImport;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage;
import org.eclipse.ocl.ecore.Variable;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ModuleImpl#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ModuleImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ModuleImpl#getEFactoryInstance <em>EFactory Instance</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ModuleImpl#getEClassifiers <em>EClassifiers</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ModuleImpl#getESubpackages <em>ESubpackages</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ModuleImpl#getESuperPackage <em>ESuper Package</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ModuleImpl#getConfigProperty <em>Config Property</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ModuleImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ModuleImpl#isIsBlackbox <em>Is Blackbox</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ModuleImpl#getModuleImport <em>Module Import</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ModuleImpl#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ModuleImpl#getOwnedVariable <em>Owned Variable</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.impl.ModuleImpl#getUsedModelType <em>Used Model Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModuleImpl extends EClassImpl implements Module {

	// Needed since Module is simultaneously an EClass and EPackage and it is only extending EClass
	// so missed EPackageImpl needs to be hand-coded
	private Map<String, EClassifier> eNameToEClassifierMap;

	/**
	 * The default value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected String nsURI = NS_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String nsPrefix = NS_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEFactoryInstance() <em>EFactory Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEFactoryInstance()
	 * @generated
	 * @ordered
	 */
	protected EFactory eFactoryInstance;

	/**
	 * The cached value of the '{@link #getEClassifiers() <em>EClassifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClassifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<EClassifier> eClassifiers;

	/**
	 * The cached value of the '{@link #getESubpackages() <em>ESubpackages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getESubpackages()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackage> eSubpackages;

	/**
	 * The cached value of the '{@link #getConfigProperty() <em>Config Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<EStructuralFeature> configProperty;

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
	 * This is true if the Is Blackbox attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isBlackboxESet;

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
	protected EList<EAnnotation> ownedTag;

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
	 * @generated NOT
	 */
	protected ModuleImpl() {
		super();
	    setEFactoryInstance(new EFactoryImpl() {});	// FIXME this avoids a validation error
													//  it should really be a factory that supports
													//   creation of elements defined by the Module
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
	public String getNsURI() {
		return nsURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsURI(String newNsURI) {
		String oldNsURI = nsURI;
		nsURI = newNsURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__NS_URI, oldNsURI, nsURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsPrefix(String newNsPrefix) {
		String oldNsPrefix = nsPrefix;
		nsPrefix = newNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFactory getEFactoryInstance() {
		return eFactoryInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEFactoryInstance(EFactory newEFactoryInstance, NotificationChain msgs) {
		EFactory oldEFactoryInstance = eFactoryInstance;
		eFactoryInstance = newEFactoryInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__EFACTORY_INSTANCE, oldEFactoryInstance, newEFactoryInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEFactoryInstance(EFactory newEFactoryInstance) {
		if (newEFactoryInstance != eFactoryInstance) {
			NotificationChain msgs = null;
			if (eFactoryInstance != null)
				msgs = ((InternalEObject)eFactoryInstance).eInverseRemove(this, EcorePackage.EFACTORY__EPACKAGE, EFactory.class, msgs);
			if (newEFactoryInstance != null)
				msgs = ((InternalEObject)newEFactoryInstance).eInverseAdd(this, EcorePackage.EFACTORY__EPACKAGE, EFactory.class, msgs);
			msgs = basicSetEFactoryInstance(newEFactoryInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__EFACTORY_INSTANCE, newEFactoryInstance, newEFactoryInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClassifier> getEClassifiers() {
		if (eClassifiers == null) {
			eClassifiers = new EObjectContainmentWithInverseEList.Resolving<EClassifier>(EClassifier.class, this, QVTOperationalPackage.MODULE__ECLASSIFIERS, EcorePackage.ECLASSIFIER__EPACKAGE);
		}
		return eClassifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackage> getESubpackages() {
		if (eSubpackages == null) {
			eSubpackages = new EObjectContainmentWithInverseEList.Resolving<EPackage>(EPackage.class, this, QVTOperationalPackage.MODULE__ESUBPACKAGES, EcorePackage.EPACKAGE__ESUPER_PACKAGE);
		}
		return eSubpackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getESuperPackage() {
		if (eContainerFeatureID() != QVTOperationalPackage.MODULE__ESUPER_PACKAGE) return null;
		return (EPackage)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetESuperPackage() {
		if (eContainerFeatureID() != QVTOperationalPackage.MODULE__ESUPER_PACKAGE) return null;
		return (EPackage)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EStructuralFeature> getConfigProperty() {
		if (configProperty == null) {
			configProperty = new EObjectResolvingEList<EStructuralFeature>(EStructuralFeature.class, this, QVTOperationalPackage.MODULE__CONFIG_PROPERTY);
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
		boolean oldIsBlackboxESet = isBlackboxESet;
		isBlackboxESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__IS_BLACKBOX, oldIsBlackbox, isBlackbox, !oldIsBlackboxESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsBlackbox() {
		boolean oldIsBlackbox = isBlackbox;
		boolean oldIsBlackboxESet = isBlackboxESet;
		isBlackbox = IS_BLACKBOX_EDEFAULT;
		isBlackboxESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTOperationalPackage.MODULE__IS_BLACKBOX, oldIsBlackbox, IS_BLACKBOX_EDEFAULT, oldIsBlackboxESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsBlackbox() {
		return isBlackboxESet;
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
	public EList<EAnnotation> getOwnedTag() {
		if (ownedTag == null) {
			ownedTag = new EObjectContainmentEList<EAnnotation>(EAnnotation.class, this, QVTOperationalPackage.MODULE__OWNED_TAG);
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
	   * @generated NOT
	   */
	public EClassifier getEClassifier(String name)
	{
		return getEClassifierGen(name);
	}

	// Needed since Module is simultaneously an EClass and EPackage and it is only extending EClass
	// so missed EPackageImpl needs to be hand-coded
	public EClassifier getEClassifierGen(String name)
	{
		if (eNameToEClassifierMap == null)
		{
			EList<EClassifier> eClassifiers = getEClassifiers();
			Map<String, EClassifier> result = new HashMap<String, EClassifier>(eClassifiers.size());
			for (EClassifier eClassifier : eClassifiers)
			{
				result.put(eClassifier.getName(), eClassifier);
			}
			eNameToEClassifierMap = result;
		}
		return eNameToEClassifierMap.get(name);
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
			case QVTOperationalPackage.MODULE__EFACTORY_INSTANCE:
				if (eFactoryInstance != null)
					msgs = ((InternalEObject)eFactoryInstance).eInverseRemove(this, EcorePackage.EFACTORY__EPACKAGE, EFactory.class, msgs);
				return basicSetEFactoryInstance((EFactory)otherEnd, msgs);
			case QVTOperationalPackage.MODULE__ECLASSIFIERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEClassifiers()).basicAdd(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__ESUBPACKAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getESubpackages()).basicAdd(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__ESUPER_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, QVTOperationalPackage.MODULE__ESUPER_PACKAGE, msgs);
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
			case QVTOperationalPackage.MODULE__EFACTORY_INSTANCE:
				return basicSetEFactoryInstance(null, msgs);
			case QVTOperationalPackage.MODULE__ECLASSIFIERS:
				return ((InternalEList<?>)getEClassifiers()).basicRemove(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__ESUBPACKAGES:
				return ((InternalEList<?>)getESubpackages()).basicRemove(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__ESUPER_PACKAGE:
				return eBasicSetContainer(null, QVTOperationalPackage.MODULE__ESUPER_PACKAGE, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QVTOperationalPackage.MODULE__ESUPER_PACKAGE:
				return eInternalContainer().eInverseRemove(this, EcorePackage.EPACKAGE__ESUBPACKAGES, EPackage.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTOperationalPackage.MODULE__NS_URI:
				return getNsURI();
			case QVTOperationalPackage.MODULE__NS_PREFIX:
				return getNsPrefix();
			case QVTOperationalPackage.MODULE__EFACTORY_INSTANCE:
				return getEFactoryInstance();
			case QVTOperationalPackage.MODULE__ECLASSIFIERS:
				return getEClassifiers();
			case QVTOperationalPackage.MODULE__ESUBPACKAGES:
				return getESubpackages();
			case QVTOperationalPackage.MODULE__ESUPER_PACKAGE:
				if (resolve) return getESuperPackage();
				return basicGetESuperPackage();
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
			case QVTOperationalPackage.MODULE__NS_URI:
				setNsURI((String)newValue);
				return;
			case QVTOperationalPackage.MODULE__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case QVTOperationalPackage.MODULE__EFACTORY_INSTANCE:
				setEFactoryInstance((EFactory)newValue);
				return;
			case QVTOperationalPackage.MODULE__ECLASSIFIERS:
				getEClassifiers().clear();
				getEClassifiers().addAll((Collection<? extends EClassifier>)newValue);
				return;
			case QVTOperationalPackage.MODULE__ESUBPACKAGES:
				getESubpackages().clear();
				getESubpackages().addAll((Collection<? extends EPackage>)newValue);
				return;
			case QVTOperationalPackage.MODULE__CONFIG_PROPERTY:
				getConfigProperty().clear();
				getConfigProperty().addAll((Collection<? extends EStructuralFeature>)newValue);
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
				getOwnedTag().addAll((Collection<? extends EAnnotation>)newValue);
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
			case QVTOperationalPackage.MODULE__NS_URI:
				setNsURI(NS_URI_EDEFAULT);
				return;
			case QVTOperationalPackage.MODULE__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case QVTOperationalPackage.MODULE__EFACTORY_INSTANCE:
				setEFactoryInstance((EFactory)null);
				return;
			case QVTOperationalPackage.MODULE__ECLASSIFIERS:
				getEClassifiers().clear();
				return;
			case QVTOperationalPackage.MODULE__ESUBPACKAGES:
				getESubpackages().clear();
				return;
			case QVTOperationalPackage.MODULE__CONFIG_PROPERTY:
				getConfigProperty().clear();
				return;
			case QVTOperationalPackage.MODULE__ENTRY:
				setEntry((EntryOperation)null);
				return;
			case QVTOperationalPackage.MODULE__IS_BLACKBOX:
				unsetIsBlackbox();
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
			case QVTOperationalPackage.MODULE__NS_URI:
				return NS_URI_EDEFAULT == null ? nsURI != null : !NS_URI_EDEFAULT.equals(nsURI);
			case QVTOperationalPackage.MODULE__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case QVTOperationalPackage.MODULE__EFACTORY_INSTANCE:
				return eFactoryInstance != null;
			case QVTOperationalPackage.MODULE__ECLASSIFIERS:
				return eClassifiers != null && !eClassifiers.isEmpty();
			case QVTOperationalPackage.MODULE__ESUBPACKAGES:
				return eSubpackages != null && !eSubpackages.isEmpty();
			case QVTOperationalPackage.MODULE__ESUPER_PACKAGE:
				return basicGetESuperPackage() != null;
			case QVTOperationalPackage.MODULE__CONFIG_PROPERTY:
				return configProperty != null && !configProperty.isEmpty();
			case QVTOperationalPackage.MODULE__ENTRY:
				return entry != null;
			case QVTOperationalPackage.MODULE__IS_BLACKBOX:
				return isSetIsBlackbox();
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EPackage.class) {
			switch (derivedFeatureID) {
				case QVTOperationalPackage.MODULE__NS_URI: return EcorePackage.EPACKAGE__NS_URI;
				case QVTOperationalPackage.MODULE__NS_PREFIX: return EcorePackage.EPACKAGE__NS_PREFIX;
				case QVTOperationalPackage.MODULE__EFACTORY_INSTANCE: return EcorePackage.EPACKAGE__EFACTORY_INSTANCE;
				case QVTOperationalPackage.MODULE__ECLASSIFIERS: return EcorePackage.EPACKAGE__ECLASSIFIERS;
				case QVTOperationalPackage.MODULE__ESUBPACKAGES: return EcorePackage.EPACKAGE__ESUBPACKAGES;
				case QVTOperationalPackage.MODULE__ESUPER_PACKAGE: return EcorePackage.EPACKAGE__ESUPER_PACKAGE;
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
		if (baseClass == EPackage.class) {
			switch (baseFeatureID) {
				case EcorePackage.EPACKAGE__NS_URI: return QVTOperationalPackage.MODULE__NS_URI;
				case EcorePackage.EPACKAGE__NS_PREFIX: return QVTOperationalPackage.MODULE__NS_PREFIX;
				case EcorePackage.EPACKAGE__EFACTORY_INSTANCE: return QVTOperationalPackage.MODULE__EFACTORY_INSTANCE;
				case EcorePackage.EPACKAGE__ECLASSIFIERS: return QVTOperationalPackage.MODULE__ECLASSIFIERS;
				case EcorePackage.EPACKAGE__ESUBPACKAGES: return QVTOperationalPackage.MODULE__ESUBPACKAGES;
				case EcorePackage.EPACKAGE__ESUPER_PACKAGE: return QVTOperationalPackage.MODULE__ESUPER_PACKAGE;
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
		result.append(" (nsURI: ");
		result.append(nsURI);
		result.append(", nsPrefix: ");
		result.append(nsPrefix);
		result.append(", isBlackbox: ");
		if (isBlackboxESet) result.append(isBlackbox); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ModuleImpl
