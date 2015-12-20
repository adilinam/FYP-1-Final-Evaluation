/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package rdb.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import rdb.RdbFactory;
import rdb.RdbPackage;
import rdb.Table;
import rdb.constraints.ConstraintsFactory;

/**
 * This is the item provider adapter for a {@link rdb.Table} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TableItemProvider
    extends NamedColumnSetItemProvider
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
    public TableItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

    /**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
	public List getPropertyDescriptors(Object object) {
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
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(RdbPackage.Literals.TABLE__COLUMNS);
			childrenFeatures.add(RdbPackage.Literals.TABLE__PRIMARY_KEY);
			childrenFeatures.add(RdbPackage.Literals.TABLE__UNIQUE_CONSTRAINTS);
			childrenFeatures.add(RdbPackage.Literals.TABLE__FOREIGN_KEYS);
			childrenFeatures.add(RdbPackage.Literals.TABLE__INDICES);
			childrenFeatures.add(RdbPackage.Literals.TABLE__CHECKS);
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
	 * This returns Table.gif.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Table")); //$NON-NLS-1$
	}

    /**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
	public String getText(Object object) {
		String label = ((Table)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Table_type") : //$NON-NLS-1$
			getString("_UI_Table_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(Table.class)) {
			case RdbPackage.TABLE__COLUMNS:
			case RdbPackage.TABLE__PRIMARY_KEY:
			case RdbPackage.TABLE__UNIQUE_CONSTRAINTS:
			case RdbPackage.TABLE__FOREIGN_KEYS:
			case RdbPackage.TABLE__INDICES:
			case RdbPackage.TABLE__CHECKS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

    /**
	 * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing all of the children that can be created under this object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(RdbPackage.Literals.TABLE__COLUMNS,
				 RdbFactory.eINSTANCE.createTableColumn()));

		newChildDescriptors.add
			(createChildParameter
				(RdbPackage.Literals.TABLE__PRIMARY_KEY,
				 ConstraintsFactory.eINSTANCE.createPrimaryKey()));

		newChildDescriptors.add
			(createChildParameter
				(RdbPackage.Literals.TABLE__UNIQUE_CONSTRAINTS,
				 ConstraintsFactory.eINSTANCE.createUniqueConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(RdbPackage.Literals.TABLE__UNIQUE_CONSTRAINTS,
				 ConstraintsFactory.eINSTANCE.createPrimaryKey()));

		newChildDescriptors.add
			(createChildParameter
				(RdbPackage.Literals.TABLE__FOREIGN_KEYS,
				 ConstraintsFactory.eINSTANCE.createForeignKey()));

		newChildDescriptors.add
			(createChildParameter
				(RdbPackage.Literals.TABLE__INDICES,
				 ConstraintsFactory.eINSTANCE.createIndex()));

		newChildDescriptors.add
			(createChildParameter
				(RdbPackage.Literals.TABLE__CHECKS,
				 ConstraintsFactory.eINSTANCE.createCheckConstraint()));
	}

    /**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == RdbPackage.Literals.TABLE__PRIMARY_KEY ||
			childFeature == RdbPackage.Literals.TABLE__UNIQUE_CONSTRAINTS;

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
		return RdbEditPlugin.INSTANCE;
	}

}
