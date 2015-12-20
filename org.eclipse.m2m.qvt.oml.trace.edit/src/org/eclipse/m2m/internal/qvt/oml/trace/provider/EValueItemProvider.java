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
 * $Id: EValueItemProvider.java,v 1.8 2009/12/09 12:41:52 radvorak Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.trace.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.m2m.internal.qvt.oml.trace.EValue;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceFactory;
import org.eclipse.m2m.internal.qvt.oml.trace.TracePackage;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLFactory;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.types.TypesFactory;

/**
 * This is the item provider adapter for a {@link org.eclipse.m2m.internal.qvt.oml.trace.EValue} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EValueItemProvider
	extends ItemProviderAdapter
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EValueItemProvider(AdapterFactory adapterFactory) {
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

			addPrimitiveValuePropertyDescriptor(object);
			addModelElementPropertyDescriptor(object);
			addOclObjectPropertyDescriptor(object);
			addCollectionTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Primitive Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrimitiveValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EValue_primitiveValue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EValue_primitiveValue_feature", "_UI_EValue_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 TracePackage.Literals.EVALUE__PRIMITIVE_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Model Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModelElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EValue_modelElement_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EValue_modelElement_feature", "_UI_EValue_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 TracePackage.Literals.EVALUE__MODEL_ELEMENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ocl Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOclObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EValue_oclObject_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EValue_oclObject_feature", "_UI_EValue_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 TracePackage.Literals.EVALUE__OCL_OBJECT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Collection Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCollectionTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EValue_collectionType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EValue_collectionType_feature", "_UI_EValue_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 TracePackage.Literals.EVALUE__COLLECTION_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT);
			childrenFeatures.add(TracePackage.Literals.EVALUE__COLLECTION);
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
	 * This returns EValue.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EValue")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((EValue)object).getPrimitiveValue();
		return label == null || label.length() == 0 ?
			getString("_UI_EValue_type") : //$NON-NLS-1$
			getString("_UI_EValue_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(EValue.class)) {
			case TracePackage.EVALUE__PRIMITIVE_VALUE:
			case TracePackage.EVALUE__OCL_OBJECT:
			case TracePackage.EVALUE__COLLECTION_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TracePackage.EVALUE__INTERMEDIATE_ELEMENT:
			case TracePackage.EVALUE__COLLECTION:
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
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TraceFactory.eINSTANCE.createTrace()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TraceFactory.eINSTANCE.createTraceRecord()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TraceFactory.eINSTANCE.createVarParameterValue()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TraceFactory.eINSTANCE.create(TracePackage.Literals.MAPPING_OPERATION_TO_TRACE_RECORD_MAP_ENTRY)));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TraceFactory.eINSTANCE.createEMappingOperation()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TraceFactory.eINSTANCE.createEValue()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TraceFactory.eINSTANCE.createETuplePartValue()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TraceFactory.eINSTANCE.createEMappingContext()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TraceFactory.eINSTANCE.createEMappingParameters()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TraceFactory.eINSTANCE.createEMappingResults()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TraceFactory.eINSTANCE.create(TracePackage.Literals.OBJECT_TO_TRACE_RECORD_MAP_ENTRY)));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createEAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createEAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createEClass()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createEDataType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createEEnum()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createEEnumLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createEFactory()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createEObject()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createEOperation()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createEPackage()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createEParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createEReference()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.create(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY)));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createEGenericType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 EcoreFactory.eINSTANCE.createETypeParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createAnyType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createCollectionType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createBagType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createElementType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createInvalidType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createMessageType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createOrderedSetType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createSequenceType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createSetType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createTemplateParameterType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createTupleType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createTypeType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 TypesFactory.eINSTANCE.createVoidType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createCollectionItem()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createCollectionRange()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createTupleLiteralPart()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ExpressionsFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createAnyType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createCollectionType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createBagType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createElementType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createInvalidType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createMessageType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createOrderedSetType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createSequenceType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createSetType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createTemplateParameterType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createTupleType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createTypeType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createVoidType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createCallOperationAction()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createSendSignalAction()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createExpressionInOCL()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createCollectionItem()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createCollectionRange()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createTupleLiteralPart()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createImperativeOperation()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createConstructor()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createOperationBody()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createConstructorBody()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createContextualProperty()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createEntryOperation()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createHelper()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createImperativeCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createModule()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createLibrary()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createMappingBody()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createMappingCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createMappingOperation()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createVarParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createMappingParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createModelParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createModelType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createModuleImport()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createObjectExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createOperationalTransformation()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createResolveExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createResolveInExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createAltExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createAssertExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createAssignExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createBlockExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createBreakExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createCatchExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createComputeExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createContinueExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createDictLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createDictLiteralPart()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createDictionaryType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createForExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createImperativeIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createInstantiationExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createListLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createListType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createLogExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createOrderedTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createOrderedTupleLiteralPart()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createOrderedTupleType()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createRaiseExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createReturnExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createSwitchExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createTryExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createTypedef()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createUnlinkExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createUnpackExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createVariableInitExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT,
				 ImperativeOCLFactory.eINSTANCE.createWhileExp()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__COLLECTION,
				 TraceFactory.eINSTANCE.createEValue()));

		newChildDescriptors.add
			(createChildParameter
				(TracePackage.Literals.EVALUE__COLLECTION,
				 TraceFactory.eINSTANCE.createETuplePartValue()));
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
			childFeature == TracePackage.Literals.EVALUE__INTERMEDIATE_ELEMENT ||
			childFeature == TracePackage.Literals.EVALUE__COLLECTION;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
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
		return TraceEditPlugin.INSTANCE;
	}

}
