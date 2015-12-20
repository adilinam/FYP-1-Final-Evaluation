/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModuleImpl.java,v 1.4 2009/12/09 14:03:26 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl;

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.EntryOperation;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModelType;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.Module;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModuleImport;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;
import org.eclipse.qvt.declarative.emof.EMOF.Property;
import org.eclipse.qvt.declarative.emof.EMOF.Tag;
import org.eclipse.qvt.declarative.emof.EMOF.Type;
import org.eclipse.qvt.declarative.emof.EMOF.impl.ClassImpl;
import org.eclipse.qvt.declarative.emof.EssentialOCL.Variable;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImpl#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImpl#getNestingPackage <em>Nesting Package</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImpl#getConfigProperty <em>Config Property</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImpl#getIsBlackbox <em>Is Blackbox</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImpl#getModuleImport <em>Module Import</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImpl#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImpl#getOwnedVariable <em>Owned Variable</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImpl#getUsedModelType <em>Used Model Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModuleImpl extends ClassImpl implements Module {
	/**
	 * The cached value of the '{@link #getNestedPackage() <em>Nested Package</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.qvt.declarative.emof.EMOF.Package> nestedPackage;

	/**
	 * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedType()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> ownedType;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

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
	 * The default value of the '{@link #getIsBlackbox() <em>Is Blackbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsBlackbox()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean IS_BLACKBOX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsBlackbox() <em>Is Blackbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsBlackbox()
	 * @generated
	 * @ordered
	 */
	protected Boolean isBlackbox = IS_BLACKBOX_EDEFAULT;

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
	protected EList<Tag> ownedTag;

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
	public EList<org.eclipse.qvt.declarative.emof.EMOF.Package> getNestedPackage() {
		if (nestedPackage == null) {
			nestedPackage = new EObjectContainmentWithInverseEList<org.eclipse.qvt.declarative.emof.EMOF.Package>(org.eclipse.qvt.declarative.emof.EMOF.Package.class, this, QVTOperationalPackage.MODULE__NESTED_PACKAGE, EMOFPackage.PACKAGE__NESTING_PACKAGE);
		}
		return nestedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvt.declarative.emof.EMOF.Package getNestingPackage() {
		if (eContainerFeatureID() != QVTOperationalPackage.MODULE__NESTING_PACKAGE) return null;
		return (org.eclipse.qvt.declarative.emof.EMOF.Package)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNestingPackage(org.eclipse.qvt.declarative.emof.EMOF.Package newNestingPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNestingPackage, QVTOperationalPackage.MODULE__NESTING_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestingPackage(org.eclipse.qvt.declarative.emof.EMOF.Package newNestingPackage) {
		if (newNestingPackage != eInternalContainer() || (eContainerFeatureID() != QVTOperationalPackage.MODULE__NESTING_PACKAGE && newNestingPackage != null)) {
			if (EcoreUtil.isAncestor(this, newNestingPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNestingPackage != null)
				msgs = ((InternalEObject)newNestingPackage).eInverseAdd(this, EMOFPackage.PACKAGE__NESTED_PACKAGE, org.eclipse.qvt.declarative.emof.EMOF.Package.class, msgs);
			msgs = basicSetNestingPackage(newNestingPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__NESTING_PACKAGE, newNestingPackage, newNestingPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getOwnedType() {
		if (ownedType == null) {
			ownedType = new EObjectContainmentWithInverseEList<Type>(Type.class, this, QVTOperationalPackage.MODULE__OWNED_TYPE, EMOFPackage.TYPE__PACKAGE);
		}
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__URI, oldUri, uri));
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
	public Boolean getIsBlackbox() {
		return isBlackbox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBlackbox(Boolean newIsBlackbox) {
		Boolean oldIsBlackbox = isBlackbox;
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
	public EList<Tag> getOwnedTag() {
		if (ownedTag == null) {
			ownedTag = new EObjectContainmentEList<Tag>(Tag.class, this, QVTOperationalPackage.MODULE__OWNED_TAG);
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
			case QVTOperationalPackage.MODULE__NESTED_PACKAGE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNestedPackage()).basicAdd(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNestingPackage((org.eclipse.qvt.declarative.emof.EMOF.Package)otherEnd, msgs);
			case QVTOperationalPackage.MODULE__OWNED_TYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedType()).basicAdd(otherEnd, msgs);
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
			case QVTOperationalPackage.MODULE__NESTED_PACKAGE:
				return ((InternalEList<?>)getNestedPackage()).basicRemove(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				return basicSetNestingPackage(null, msgs);
			case QVTOperationalPackage.MODULE__OWNED_TYPE:
				return ((InternalEList<?>)getOwnedType()).basicRemove(otherEnd, msgs);
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
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				return eInternalContainer().eInverseRemove(this, EMOFPackage.PACKAGE__NESTED_PACKAGE, org.eclipse.qvt.declarative.emof.EMOF.Package.class, msgs);
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
			case QVTOperationalPackage.MODULE__NESTED_PACKAGE:
				return getNestedPackage();
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				return getNestingPackage();
			case QVTOperationalPackage.MODULE__OWNED_TYPE:
				return getOwnedType();
			case QVTOperationalPackage.MODULE__URI:
				return getUri();
			case QVTOperationalPackage.MODULE__CONFIG_PROPERTY:
				return getConfigProperty();
			case QVTOperationalPackage.MODULE__ENTRY:
				if (resolve) return getEntry();
				return basicGetEntry();
			case QVTOperationalPackage.MODULE__IS_BLACKBOX:
				return getIsBlackbox();
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
			case QVTOperationalPackage.MODULE__NESTED_PACKAGE:
				getNestedPackage().clear();
				getNestedPackage().addAll((Collection<? extends org.eclipse.qvt.declarative.emof.EMOF.Package>)newValue);
				return;
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				setNestingPackage((org.eclipse.qvt.declarative.emof.EMOF.Package)newValue);
				return;
			case QVTOperationalPackage.MODULE__OWNED_TYPE:
				getOwnedType().clear();
				getOwnedType().addAll((Collection<? extends Type>)newValue);
				return;
			case QVTOperationalPackage.MODULE__URI:
				setUri((String)newValue);
				return;
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
				getOwnedTag().addAll((Collection<? extends Tag>)newValue);
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
			case QVTOperationalPackage.MODULE__NESTED_PACKAGE:
				getNestedPackage().clear();
				return;
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				setNestingPackage((org.eclipse.qvt.declarative.emof.EMOF.Package)null);
				return;
			case QVTOperationalPackage.MODULE__OWNED_TYPE:
				getOwnedType().clear();
				return;
			case QVTOperationalPackage.MODULE__URI:
				setUri(URI_EDEFAULT);
				return;
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
			case QVTOperationalPackage.MODULE__NESTED_PACKAGE:
				return nestedPackage != null && !nestedPackage.isEmpty();
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				return getNestingPackage() != null;
			case QVTOperationalPackage.MODULE__OWNED_TYPE:
				return ownedType != null && !ownedType.isEmpty();
			case QVTOperationalPackage.MODULE__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case QVTOperationalPackage.MODULE__CONFIG_PROPERTY:
				return configProperty != null && !configProperty.isEmpty();
			case QVTOperationalPackage.MODULE__ENTRY:
				return entry != null;
			case QVTOperationalPackage.MODULE__IS_BLACKBOX:
				return IS_BLACKBOX_EDEFAULT == null ? isBlackbox != null : !IS_BLACKBOX_EDEFAULT.equals(isBlackbox);
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
		if (baseClass == org.eclipse.qvt.declarative.emof.EMOF.Package.class) {
			switch (derivedFeatureID) {
				case QVTOperationalPackage.MODULE__NESTED_PACKAGE: return EMOFPackage.PACKAGE__NESTED_PACKAGE;
				case QVTOperationalPackage.MODULE__NESTING_PACKAGE: return EMOFPackage.PACKAGE__NESTING_PACKAGE;
				case QVTOperationalPackage.MODULE__OWNED_TYPE: return EMOFPackage.PACKAGE__OWNED_TYPE;
				case QVTOperationalPackage.MODULE__URI: return EMOFPackage.PACKAGE__URI;
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
		if (baseClass == org.eclipse.qvt.declarative.emof.EMOF.Package.class) {
			switch (baseFeatureID) {
				case EMOFPackage.PACKAGE__NESTED_PACKAGE: return QVTOperationalPackage.MODULE__NESTED_PACKAGE;
				case EMOFPackage.PACKAGE__NESTING_PACKAGE: return QVTOperationalPackage.MODULE__NESTING_PACKAGE;
				case EMOFPackage.PACKAGE__OWNED_TYPE: return QVTOperationalPackage.MODULE__OWNED_TYPE;
				case EMOFPackage.PACKAGE__URI: return QVTOperationalPackage.MODULE__URI;
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(", isBlackbox: ");
		result.append(isBlackbox);
		result.append(')');
		return result.toString();
	}

} //ModuleImpl
