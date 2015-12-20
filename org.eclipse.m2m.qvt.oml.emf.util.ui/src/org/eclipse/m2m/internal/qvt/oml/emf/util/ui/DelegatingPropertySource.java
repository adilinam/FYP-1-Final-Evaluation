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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

/**
 * @author pkobiakov
 */
public class DelegatingPropertySource implements IPropertySource {

	public DelegatingPropertySource(IPropertySource source) {
		mySource = source;
	}

	public Object getEditableValue() {
		return mySource.getEditableValue();
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		IPropertyDescriptor[] descs = mySource.getPropertyDescriptors();
		if (descs == null) {
			return null;
		}

		List<IPropertyDescriptor> newDescs = new ArrayList<IPropertyDescriptor>();
		for (int i = 0; i < descs.length; i++) {
			IPropertyDescriptor desc = descs[i];
			newDescs.add(new DelegatingPropertyDescriptor(desc));
		}

		return newDescs.toArray(new IPropertyDescriptor[newDescs.size()]);
	}

	public Object getPropertyValue(Object id) {
		return mySource.getPropertyValue(id);
	}

	public boolean isPropertySet(Object id) {
		return mySource.isPropertySet(id);
	}

	public void resetPropertyValue(Object id) {
	}

	public void setPropertyValue(Object id, Object value) {
	}

	private final IPropertySource mySource;

}