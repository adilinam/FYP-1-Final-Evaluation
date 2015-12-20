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
 * $Id: ResolveExpItemProvider.java,v 1.3 2009/01/25 23:12:44 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
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
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLFactory;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalFactory;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.provider.CallExpItemProvider;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplateFactory;



/**
 * This is the item provider adapter for a {@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ResolveExpItemProvider
	extends CallExpItemProvider
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
	public ResolveExpItemProvider(AdapterFactory adapterFactory) {
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

			addIsDeferredPropertyDescriptor(object);
			addIsInversePropertyDescriptor(object);
			addOnePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is Deferred feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsDeferredPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ResolveExp_isDeferred_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ResolveExp_isDeferred_feature", "_UI_ResolveExp_type"),
				 QVTOperationalPackage.Literals.RESOLVE_EXP__IS_DEFERRED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Inverse feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsInversePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ResolveExp_isInverse_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ResolveExp_isInverse_feature", "_UI_ResolveExp_type"),
				 QVTOperationalPackage.Literals.RESOLVE_EXP__IS_INVERSE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the One feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOnePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ResolveExp_one_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ResolveExp_one_feature", "_UI_ResolveExp_type"),
				 QVTOperationalPackage.Literals.RESOLVE_EXP__ONE,
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
			childrenFeatures.add(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION);
			childrenFeatures.add(QVTOperationalPackage.Literals.RESOLVE_EXP__TARGET);
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
	 * This returns ResolveExp.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ResolveExp"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ResolveExp)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ResolveExp_type") :
			getString("_UI_ResolveExp_type") + " " + label;
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

		switch (notification.getFeatureID(ResolveExp.class)) {
			case QVTOperationalPackage.RESOLVE_EXP__IS_DEFERRED:
			case QVTOperationalPackage.RESOLVE_EXP__IS_INVERSE:
			case QVTOperationalPackage.RESOLVE_EXP__ONE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case QVTOperationalPackage.RESOLVE_EXP__CONDITION:
			case QVTOperationalPackage.RESOLVE_EXP__TARGET:
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
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 QVTOperationalFactory.eINSTANCE.createImperativeCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 QVTOperationalFactory.eINSTANCE.createMappingCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 QVTOperationalFactory.eINSTANCE.createObjectExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 QVTOperationalFactory.eINSTANCE.createResolveExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 QVTOperationalFactory.eINSTANCE.createResolveInExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createAltExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createAssertExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createAssignExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createBlockExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createBreakExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createCatchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createComputeExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createContinueExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createDictLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createForExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createImperativeIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createInstantiationExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createLogExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createOrderedTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createRaiseExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createReturnExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createSwitchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createTryExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createUnlinkExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createUnpackExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createVariableInitExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createWhileExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 QVTRelationFactory.eINSTANCE.createOppositePropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 QVTRelationFactory.eINSTANCE.createRelationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 QVTTemplateFactory.eINSTANCE.createObjectTemplateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 QVTTemplateFactory.eINSTANCE.createCollectionTemplateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 QVTOperationalFactory.eINSTANCE.createImperativeCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 QVTOperationalFactory.eINSTANCE.createMappingCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 QVTOperationalFactory.eINSTANCE.createObjectExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 QVTOperationalFactory.eINSTANCE.createResolveExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 QVTOperationalFactory.eINSTANCE.createResolveInExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createAltExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createAssertExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createAssignExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createBlockExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createBreakExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createCatchExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createComputeExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createContinueExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createDictLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createForExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createImperativeIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createInstantiationExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createLogExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createOrderedTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createRaiseExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createReturnExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createSwitchExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createTryExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createUnlinkExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createUnpackExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createVariableInitExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createWhileExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 QVTRelationFactory.eINSTANCE.createOppositePropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 QVTRelationFactory.eINSTANCE.createRelationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 QVTTemplateFactory.eINSTANCE.createObjectTemplateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 QVTTemplateFactory.eINSTANCE.createCollectionTemplateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__TARGET,
				 QVTOperationalFactory.eINSTANCE.createVarParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__TARGET,
				 QVTOperationalFactory.eINSTANCE.createMappingParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__TARGET,
				 QVTOperationalFactory.eINSTANCE.createModelParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__TARGET,
				 QVTBaseFactory.eINSTANCE.createFunctionParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.RESOLVE_EXP__TARGET,
				 EcoreFactory.eINSTANCE.createVariable()));
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
			childFeature == ExpressionsPackage.Literals.CALL_EXP__SOURCE ||
			childFeature == QVTOperationalPackage.Literals.RESOLVE_EXP__CONDITION;

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
