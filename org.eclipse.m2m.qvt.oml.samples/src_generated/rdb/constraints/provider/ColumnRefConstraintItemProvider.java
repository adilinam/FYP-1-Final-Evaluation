/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package rdb.constraints.provider;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import rdb.TableColumn;
import rdb.constraints.ColumnRefConstraint;
import rdb.constraints.ConstraintsPackage;
import rdb.provider.RdbEditPlugin;

/**
 * This is the item provider adapter for a {@link rdb.constraints.ColumnRefConstraint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ColumnRefConstraintItemProvider
    extends ConstraintItemProvider
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
    public ColumnRefConstraintItemProvider(AdapterFactory adapterFactory) {
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

			addIncludedColumnsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

    /**
	 * This adds a property descriptor for the Included Columns feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addIncludedColumnsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ColumnRefConstraint_includedColumns_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ColumnRefConstraint_includedColumns_feature", "_UI_ColumnRefConstraint_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ConstraintsPackage.Literals.COLUMN_REF_CONSTRAINT__INCLUDED_COLUMNS,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

    /**
	 * This returns ColumnRefConstraint.gif.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ColumnRefConstraint")); //$NON-NLS-1$
	}

    /**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
	public String getText(Object object) {
		String label = ((ColumnRefConstraint)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ColumnRefConstraint_type") : //$NON-NLS-1$
			getString("_UI_ColumnRefConstraint_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	};
    
    public String getConstraintText(Object object) {
        ColumnRefConstraint con = (ColumnRefConstraint) object;
        String label = con.getName();
        EList cols = con.getIncludedColumns();
        String columns = ""; //$NON-NLS-1$
        for (Iterator i = cols.iterator(); i.hasNext();) {
            TableColumn col = (TableColumn) i.next();
            String name = col.getName();
            columns += name == null?"":name + (i.hasNext()?", ":"");  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
        }
        return (label == null?"":label) + "(" + columns + ")";  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
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
