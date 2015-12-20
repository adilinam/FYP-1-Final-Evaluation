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
 * $Id: OperationBodyItemProvider.java,v 1.3 2009/01/25 23:12:44 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EModelElementItemProvider;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLFactory;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.OperationBody;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalFactory;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplateFactory;



/**
 * This is the item provider adapter for a {@link org.eclipse.m2m.qvt.oml.ecore.QVTOperational.OperationBody} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationBodyItemProvider
	extends EModelElementItemProvider
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
	public OperationBodyItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT);
			childrenFeatures.add(QVTOperationalPackage.Literals.OPERATION_BODY__VARIABLE);
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
	 * This returns OperationBody.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/OperationBody"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_OperationBody_type");
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

		switch (notification.getFeatureID(OperationBody.class)) {
			case QVTOperationalPackage.OPERATION_BODY__CONTENT:
			case QVTOperationalPackage.OPERATION_BODY__VARIABLE:
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
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 QVTOperationalFactory.eINSTANCE.createImperativeCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 QVTOperationalFactory.eINSTANCE.createMappingCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 QVTOperationalFactory.eINSTANCE.createObjectExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 QVTOperationalFactory.eINSTANCE.createResolveExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 QVTOperationalFactory.eINSTANCE.createResolveInExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createAltExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createAssertExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createAssignExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createBlockExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createBreakExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createCatchExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createComputeExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createContinueExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createDictLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createForExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createImperativeIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createInstantiationExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createLogExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createOrderedTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createRaiseExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createReturnExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createSwitchExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createTryExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createUnlinkExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createUnpackExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createVariableInitExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 ImperativeOCLFactory.eINSTANCE.createWhileExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 QVTRelationFactory.eINSTANCE.createOppositePropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 QVTRelationFactory.eINSTANCE.createRelationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 QVTTemplateFactory.eINSTANCE.createObjectTemplateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 QVTTemplateFactory.eINSTANCE.createCollectionTemplateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__CONTENT,
				 EcoreFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__VARIABLE,
				 QVTOperationalFactory.eINSTANCE.createVarParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__VARIABLE,
				 QVTOperationalFactory.eINSTANCE.createMappingParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__VARIABLE,
				 QVTOperationalFactory.eINSTANCE.createModelParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__VARIABLE,
				 QVTBaseFactory.eINSTANCE.createFunctionParameter()));

		newChildDescriptors.add
			(createChildParameter
				(QVTOperationalPackage.Literals.OPERATION_BODY__VARIABLE,
				 EcoreFactory.eINSTANCE.createVariable()));
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
