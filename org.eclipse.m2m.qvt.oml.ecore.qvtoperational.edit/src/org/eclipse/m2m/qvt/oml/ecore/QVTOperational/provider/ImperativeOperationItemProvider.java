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
 * $Id: ImperativeOperationItemProvider.java,v 1.2 2009/01/25 23:12:44 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EOperationItemProvider;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalFactory;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;


/**
 * This is the item provider adapter for a {@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ImperativeOperation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ImperativeOperationItemProvider
	extends EOperationItemProvider
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
	public ImperativeOperationItemProvider(AdapterFactory adapterFactory) {
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

			addIsBlackboxPropertyDescriptor(object);
			addOverriddenPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_ImperativeOperation_isBlackbox_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ImperativeOperation_isBlackbox_feature", "_UI_ImperativeOperation_type"),
				 QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__IS_BLACKBOX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Overridden feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOverriddenPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ImperativeOperation_overridden_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ImperativeOperation_overridden_feature", "_UI_ImperativeOperation_type"),
				 QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__OVERRIDDEN,
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
			childrenFeatures.add(QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__BODY);
			childrenFeatures.add(QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__CONTEXT);
			childrenFeatures.add(QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__RESULT);
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
	 * This returns ImperativeOperation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ImperativeOperation"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ImperativeOperation)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ImperativeOperation_type") :
			getString("_UI_ImperativeOperation_type") + " " + label;
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

		switch (notification.getFeatureID(ImperativeOperation.class)) {
			case QVTOperationalPackage.IMPERATIVE_OPERATION__IS_BLACKBOX:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case QVTOperationalPackage.IMPERATIVE_OPERATION__BODY:
			case QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT:
			case QVTOperationalPackage.IMPERATIVE_OPERATION__RESULT:
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
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 QVTOperationalFactory.eINSTANCE.createVarParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 QVTOperationalFactory.eINSTANCE.createMappingParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 QVTOperationalFactory.eINSTANCE.createModelParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 QVTBaseFactory.eINSTANCE.createFunctionParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__BODY,
				 QVTOperationalFactory.eINSTANCE.createOperationBody()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__BODY,
				 QVTOperationalFactory.eINSTANCE.createConstructorBody()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__BODY,
				 QVTOperationalFactory.eINSTANCE.createMappingBody()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__CONTEXT,
				 QVTOperationalFactory.eINSTANCE.createVarParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__CONTEXT,
				 QVTOperationalFactory.eINSTANCE.createMappingParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__CONTEXT,
				 QVTOperationalFactory.eINSTANCE.createModelParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__RESULT,
				 QVTOperationalFactory.eINSTANCE.createVarParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__RESULT,
				 QVTOperationalFactory.eINSTANCE.createMappingParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__RESULT,
				 QVTOperationalFactory.eINSTANCE.createModelParameter()));
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
			childFeature == EcorePackage.Literals.ETYPED_ELEMENT__EGENERIC_TYPE ||
			childFeature == EcorePackage.Literals.EOPERATION__EGENERIC_EXCEPTIONS ||
			childFeature == EcorePackage.Literals.EOPERATION__EPARAMETERS ||
			childFeature == QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__CONTEXT ||
			childFeature == QVTOperationalPackage.Literals.IMPERATIVE_OPERATION__RESULT;

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
