/**
 * <copyright>
 * Copyright (c) 2008, 2009 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo  - initial API and implementation
 * </copyright>
 *
 * $Id: AssignExpItemProvider.java,v 1.3 2009/12/09 14:02:55 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLFactory;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.ocl.ecore.EcoreFactory;


/**
 * This is the item provider adapter for a {@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AssignExpItemProvider
	extends ImperativeExpressionItemProvider
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
	public AssignExpItemProvider(AdapterFactory adapterFactory) {
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

			addIsResetPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is Reset feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsResetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AssignExp_isReset_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AssignExp_isReset_feature", "_UI_AssignExp_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ImperativeOCLPackage.Literals.ASSIGN_EXP__IS_RESET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE);
			childrenFeatures.add(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT);
			childrenFeatures.add(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE);
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
	 * This returns AssignExp.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AssignExp")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AssignExp)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_AssignExp_type") : //$NON-NLS-1$
			getString("_UI_AssignExp_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(AssignExp.class)) {
			case ImperativeOCLPackage.ASSIGN_EXP__IS_RESET:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ImperativeOCLPackage.ASSIGN_EXP__DEFAULT_VALUE:
			case ImperativeOCLPackage.ASSIGN_EXP__LEFT:
			case ImperativeOCLPackage.ASSIGN_EXP__VALUE:
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
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createAltExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createAssertExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createAssignExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createBlockExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createBreakExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createCatchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createComputeExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createContinueExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createDictLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createForExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createImperativeIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createInstantiationExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createListLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createLogExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createOrderedTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createRaiseExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createReturnExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createSwitchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createTryExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createUnlinkExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createUnpackExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createVariableInitExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 ImperativeOCLFactory.eINSTANCE.createWhileExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE,
				 EcoreFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createAltExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createAssertExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createAssignExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createBlockExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createBreakExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createCatchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createComputeExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createContinueExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createDictLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createForExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createImperativeIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createInstantiationExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createListLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createLogExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createOrderedTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createRaiseExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createReturnExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createSwitchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createTryExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createUnlinkExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createUnpackExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createVariableInitExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 ImperativeOCLFactory.eINSTANCE.createWhileExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT,
				 EcoreFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createAltExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createAssertExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createAssignExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createBlockExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createBreakExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createCatchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createComputeExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createContinueExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createDictLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createForExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createImperativeIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createInstantiationExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createListLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createLogExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createOrderedTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createRaiseExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createReturnExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createSwitchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createTryExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createUnlinkExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createUnpackExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createVariableInitExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 ImperativeOCLFactory.eINSTANCE.createWhileExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE,
				 EcoreFactory.eINSTANCE.createVariableExp()));
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
			childFeature == ImperativeOCLPackage.Literals.ASSIGN_EXP__DEFAULT_VALUE ||
			childFeature == ImperativeOCLPackage.Literals.ASSIGN_EXP__LEFT ||
			childFeature == ImperativeOCLPackage.Literals.ASSIGN_EXP__VALUE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
