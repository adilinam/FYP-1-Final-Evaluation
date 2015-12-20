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
 * $Id: ModuleItemProvider.java,v 1.3 2009/12/09 14:02:29 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EClassItemProvider;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLFactory;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalFactory;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;



/**
 * This is the item provider adapter for a {@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ModuleItemProvider
	extends EClassItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNsURIPropertyDescriptor(object);
			addNsPrefixPropertyDescriptor(object);
			addEFactoryInstancePropertyDescriptor(object);
			addConfigPropertyPropertyDescriptor(object);
			addEntryPropertyDescriptor(object);
			addIsBlackboxPropertyDescriptor(object);
			addUsedModelTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Ns URI feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNsURIPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPackage_nsURI_feature"),
				 getString("_UI_EPackage_nsURI_description"),
				 EcorePackage.Literals.EPACKAGE__NS_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ns Prefix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNsPrefixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPackage_nsPrefix_feature"),
				 getString("_UI_EPackage_nsPrefix_description"),
				 EcorePackage.Literals.EPACKAGE__NS_PREFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the EFactory Instance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEFactoryInstancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPackage_eFactoryInstance_feature"),
				 getString("_UI_EPackage_eFactoryInstance_description"),
				 EcorePackage.Literals.EPACKAGE__EFACTORY_INSTANCE,
				 false,
				 false,
				 false,
				 null,
				 null,
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
	}

	/**
	 * This adds a property descriptor for the Config Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConfigPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Module_configProperty_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Module_configProperty_feature", "_UI_Module_type"),
				 QVTOperationalPackage.Literals.MODULE__CONFIG_PROPERTY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Entry feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEntryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Module_entry_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Module_entry_feature", "_UI_Module_type"),
				 QVTOperationalPackage.Literals.MODULE__ENTRY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Blackbox feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsBlackboxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Module_isBlackbox_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Module_isBlackbox_feature", "_UI_Module_type"),
				 QVTOperationalPackage.Literals.MODULE__IS_BLACKBOX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Used Model Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsedModelTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Module_usedModelType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Module_usedModelType_feature", "_UI_Module_type"),
				 QVTOperationalPackage.Literals.MODULE__USED_MODEL_TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
			childrenFeatures.add(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES);
			childrenFeatures.add(QVTOperationalPackage.Literals.MODULE__MODULE_IMPORT);
			childrenFeatures.add(QVTOperationalPackage.Literals.MODULE__OWNED_TAG);
			childrenFeatures.add(QVTOperationalPackage.Literals.MODULE__OWNED_VARIABLE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Module.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Module"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Module)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Module_type") :
			getString("_UI_Module_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Module.class)) {
			case QVTOperationalPackage.MODULE__NS_URI:
			case QVTOperationalPackage.MODULE__NS_PREFIX:
			case QVTOperationalPackage.MODULE__EFACTORY_INSTANCE:
			case QVTOperationalPackage.MODULE__IS_BLACKBOX:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case QVTOperationalPackage.MODULE__ECLASSIFIERS:
			case QVTOperationalPackage.MODULE__ESUBPACKAGES:
			case QVTOperationalPackage.MODULE__MODULE_IMPORT:
			case QVTOperationalPackage.MODULE__OWNED_TAG:
			case QVTOperationalPackage.MODULE__OWNED_VARIABLE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.ECLASS__EOPERATIONS,
				 QVTOperationalFactory.eINSTANCE.createImperativeOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.ECLASS__EOPERATIONS,
				 QVTOperationalFactory.eINSTANCE.createConstructor()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.ECLASS__EOPERATIONS,
				 QVTOperationalFactory.eINSTANCE.createEntryOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.ECLASS__EOPERATIONS,
				 QVTOperationalFactory.eINSTANCE.createHelper()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.ECLASS__EOPERATIONS,
				 QVTOperationalFactory.eINSTANCE.createMappingOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.ECLASS__EOPERATIONS,
				 QVTBaseFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES,
				 QVTOperationalFactory.eINSTANCE.createContextualProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 QVTOperationalFactory.eINSTANCE.createModule()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 QVTOperationalFactory.eINSTANCE.createLibrary()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 QVTOperationalFactory.eINSTANCE.createModelType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 QVTOperationalFactory.eINSTANCE.createOperationalTransformation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 EcoreFactory.eINSTANCE.createEClass()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 EcoreFactory.eINSTANCE.createEDataType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 EcoreFactory.eINSTANCE.createEEnum()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 ImperativeOCLFactory.eINSTANCE.createDictionaryType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 ImperativeOCLFactory.eINSTANCE.createListType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 ImperativeOCLFactory.eINSTANCE.createOrderedTupleType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 ImperativeOCLFactory.eINSTANCE.createTypedef()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 QVTBaseFactory.eINSTANCE.createTransformation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 QVTRelationFactory.eINSTANCE.createRelationalTransformation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createAnyType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createCollectionType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createBagType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createElementType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createInvalidType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createMessageType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createOrderedSetType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createSequenceType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createSetType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createTupleType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createTypeType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createVoidType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES,
				 QVTOperationalFactory.eINSTANCE.createModule()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES,
				 QVTOperationalFactory.eINSTANCE.createLibrary()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES,
				 QVTOperationalFactory.eINSTANCE.createOperationalTransformation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES,
				 EcoreFactory.eINSTANCE.createEPackage()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES,
				 QVTBaseFactory.eINSTANCE.createTransformation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES,
				 QVTRelationFactory.eINSTANCE.createRelationalTransformation()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.MODULE__MODULE_IMPORT,
				 QVTOperationalFactory.eINSTANCE.createModuleImport()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.MODULE__OWNED_TAG,
				 EcoreFactory.eINSTANCE.createEAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.MODULE__OWNED_VARIABLE,
				 QVTOperationalFactory.eINSTANCE.createVarParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.MODULE__OWNED_VARIABLE,
				 QVTOperationalFactory.eINSTANCE.createMappingParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.MODULE__OWNED_VARIABLE,
				 QVTOperationalFactory.eINSTANCE.createModelParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.MODULE__OWNED_VARIABLE,
				 QVTBaseFactory.eINSTANCE.createFunctionParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.MODULE__OWNED_VARIABLE,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createVariable()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS ||
			childFeature == QVTOperationalPackage.Literals.MODULE__OWNED_TAG ||
			childFeature == EcorePackage.Literals.EPACKAGE__ECLASSIFIERS ||
			childFeature == EcorePackage.Literals.EPACKAGE__ESUBPACKAGES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return QVTOperationalEditPlugin.INSTANCE;
	}

}
