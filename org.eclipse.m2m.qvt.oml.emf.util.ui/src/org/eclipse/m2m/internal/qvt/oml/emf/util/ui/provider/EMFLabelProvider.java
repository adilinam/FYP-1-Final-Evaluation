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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.provider;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.ExtendedEMFUtil;
import org.eclipse.swt.graphics.Image;


/**
 * @author vrepeshko
 */
public class EMFLabelProvider implements ILabelProvider {

	private static class NullLabelProvider implements ILabelProvider {

		public static final NullLabelProvider INSTANCE = new NullLabelProvider();
		
		private NullLabelProvider() {}
		
		public Image getImage(Object element) {
			return null;
		}

		public String getText(Object element) {
			return ""; //$NON-NLS-1$
		}

		public void addListener(ILabelProviderListener listener) {}

		public void dispose() {}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {}
		
	}
	
	public Image getImage(Object element) {
		return getLabelProvider(element).getImage(element);
	}

	public String getText(Object element) {
		return getLabelProvider(element).getText(element);
	}

	private ILabelProvider getLabelProvider(Object element) {
		if (element == null) {
			return NullLabelProvider.INSTANCE;
		}
		ILabelProvider labelProvider = null;
		if (element instanceof EObject) {
			EPackage ePackage = ((EObject) element).eClass().getEPackage();
			labelProvider = (ILabelProvider) myLabelProvidersMap.get(ePackage);
			if (labelProvider == null) {
				labelProvider = new AdapterFactoryLabelProvider(getAdapterFactory(ePackage));
				myLabelProvidersMap.put(ePackage, labelProvider);
			}
		} else /* if (element != null) */{
			labelProvider = (ILabelProvider) myLabelProvidersMap.get(element.getClass());
			if (labelProvider == null) {
				labelProvider = new AdapterFactoryLabelProvider(new ReflectiveItemProviderAdapterFactory());
				myLabelProvidersMap.put(element.getClass(), labelProvider);
			}
		}
		return labelProvider;
	}

	private static AdapterFactory getAdapterFactory(EPackage ePackage) {
		return ExtendedEMFUtil.createComposedAdapterFactory(ExtendedEMFUtil.getAdapterFactories(ePackage, REQUIRED_CLASSES));
	}

	public void dispose() {
		Set<ILabelProvider> providers = new HashSet<ILabelProvider>(myLabelProvidersMap.values());
		for (Iterator<?> iter = providers.iterator(); iter.hasNext();) {
			ILabelProvider labelProvider = (ILabelProvider) iter.next();
			labelProvider.dispose();
		}
	}

	public boolean isLabelProperty(Object element, String property) {
		return true;
	}

	public void addListener(ILabelProviderListener listener) {}
	
	public void removeListener(ILabelProviderListener listener) {}
	
	private final Map<Object, ILabelProvider> myLabelProvidersMap = new HashMap<Object, ILabelProvider>();

	private static final Class<?>[] REQUIRED_CLASSES = { IItemLabelProvider.class };
	
}

