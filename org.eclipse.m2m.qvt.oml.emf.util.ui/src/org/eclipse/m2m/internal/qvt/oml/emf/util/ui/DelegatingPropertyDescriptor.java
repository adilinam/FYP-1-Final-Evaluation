/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

/**
 * @author pkobiakov
 */
public class DelegatingPropertyDescriptor implements IPropertyDescriptor {

	public DelegatingPropertyDescriptor(IPropertyDescriptor desc) {
		myDescriptor = desc;
	}

	public CellEditor createPropertyEditor(Composite parent) {
		return null;
	}

	public String getCategory() {
		return myDescriptor.getCategory();
	}

	public String getDescription() {
		return myDescriptor.getDescription();
	}

	public String getDisplayName() {
		return myDescriptor.getDisplayName();
	}

	public String[] getFilterFlags() {
		return myDescriptor.getFilterFlags();
	}

	public Object getHelpContextIds() {
		return myDescriptor.getHelpContextIds();
	}

	public Object getId() {
		return myDescriptor.getId();
	}

	public ILabelProvider getLabelProvider() {
		return myDescriptor.getLabelProvider();
	}

	public boolean isCompatibleWith(IPropertyDescriptor anotherProperty) {
		return myDescriptor.isCompatibleWith(anotherProperty);
	}

	private final IPropertyDescriptor myDescriptor;

}