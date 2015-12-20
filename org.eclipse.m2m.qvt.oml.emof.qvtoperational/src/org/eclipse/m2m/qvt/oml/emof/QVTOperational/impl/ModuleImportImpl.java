/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModuleImportImpl.java,v 1.3 2009/12/09 14:03:26 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImportKind;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModelType;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.Module;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ModuleImport;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage;
import org.eclipse.qvt.declarative.emof.EMOF.impl.ElementImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImportImpl#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImportImpl#getImportedModule <em>Imported Module</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImportImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.ModuleImportImpl#getModule <em>Module</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModuleImportImpl extends ElementImpl implements ModuleImport {
	/**
	 * The cached value of the '{@link #getBinding() <em>Binding</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelType> binding;

	/**
	 * The cached value of the '{@link #getImportedModule() <em>Imported Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedModule()
	 * @generated
	 * @ordered
	 */
	protected Module importedModule;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ImportKind KIND_EDEFAULT = ImportKind.EXTENSION;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ImportKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleImportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.MODULE_IMPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelType> getBinding() {
		if (binding == null) {
			binding = new EObjectResolvingEList<ModelType>(ModelType.class, this, QVTOperationalPackage.MODULE_IMPORT__BINDING);
		}
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module getImportedModule() {
		if (importedModule != null && importedModule.eIsProxy()) {
			InternalEObject oldImportedModule = (InternalEObject)importedModule;
			importedModule = (Module)eResolveProxy(oldImportedModule);
			if (importedModule != oldImportedModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalPackage.MODULE_IMPORT__IMPORTED_MODULE, oldImportedModule, importedModule));
			}
		}
		return importedModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module basicGetImportedModule() {
		return importedModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportedModule(Module newImportedModule) {
		Module oldImportedModule = importedModule;
		importedModule = newImportedModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE_IMPORT__IMPORTED_MODULE, oldImportedModule, importedModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(ImportKind newKind) {
		ImportKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE_IMPORT__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module getModule() {
		if (eContainerFeatureID() != QVTOperationalPackage.MODULE_IMPORT__MODULE) return null;
		return (Module)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModule(Module newModule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newModule, QVTOperationalPackage.MODULE_IMPORT__MODULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModule(Module newModule) {
		if (newModule != eInternalContainer() || (eContainerFeatureID() != QVTOperationalPackage.MODULE_IMPORT__MODULE && newModule != null)) {
			if (EcoreUtil.isAncestor(this, newModule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newModule != null)
				msgs = ((InternalEObject)newModule).eInverseAdd(this, QVTOperationalPackage.MODULE__MODULE_IMPORT, Module.class, msgs);
			msgs = basicSetModule(newModule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE_IMPORT__MODULE, newModule, newModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.MODULE_IMPORT__MODULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetModule((Module)otherEnd, msgs);
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
			case QVTOperationalPackage.MODULE_IMPORT__MODULE:
				return basicSetModule(null, msgs);
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
			case QVTOperationalPackage.MODULE_IMPORT__MODULE:
				return eInternalContainer().eInverseRemove(this, QVTOperationalPackage.MODULE__MODULE_IMPORT, Module.class, msgs);
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
			case QVTOperationalPackage.MODULE_IMPORT__BINDING:
				return getBinding();
			case QVTOperationalPackage.MODULE_IMPORT__IMPORTED_MODULE:
				if (resolve) return getImportedModule();
				return basicGetImportedModule();
			case QVTOperationalPackage.MODULE_IMPORT__KIND:
				return getKind();
			case QVTOperationalPackage.MODULE_IMPORT__MODULE:
				return getModule();
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
			case QVTOperationalPackage.MODULE_IMPORT__BINDING:
				getBinding().clear();
				getBinding().addAll((Collection<? extends ModelType>)newValue);
				return;
			case QVTOperationalPackage.MODULE_IMPORT__IMPORTED_MODULE:
				setImportedModule((Module)newValue);
				return;
			case QVTOperationalPackage.MODULE_IMPORT__KIND:
				setKind((ImportKind)newValue);
				return;
			case QVTOperationalPackage.MODULE_IMPORT__MODULE:
				setModule((Module)newValue);
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
			case QVTOperationalPackage.MODULE_IMPORT__BINDING:
				getBinding().clear();
				return;
			case QVTOperationalPackage.MODULE_IMPORT__IMPORTED_MODULE:
				setImportedModule((Module)null);
				return;
			case QVTOperationalPackage.MODULE_IMPORT__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case QVTOperationalPackage.MODULE_IMPORT__MODULE:
				setModule((Module)null);
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
			case QVTOperationalPackage.MODULE_IMPORT__BINDING:
				return binding != null && !binding.isEmpty();
			case QVTOperationalPackage.MODULE_IMPORT__IMPORTED_MODULE:
				return importedModule != null;
			case QVTOperationalPackage.MODULE_IMPORT__KIND:
				return kind != KIND_EDEFAULT;
			case QVTOperationalPackage.MODULE_IMPORT__MODULE:
				return getModule() != null;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //ModuleImportImpl
