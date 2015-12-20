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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.metamodel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.EmfUtilUiPlugin;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;


/**
 * @author vrepeshko
 */
public class MetamodelImageRegistry {

	public static final MetamodelImageRegistry INSTANCE = new MetamodelImageRegistry();
	
	private MetamodelImageRegistry() {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(EmfUtilUiPlugin.ID, EXTENSTION_POINT_ID);
		if (extensionPoint == null) {
			return;
		}
		IConfigurationElement[] metamodelImageElements = extensionPoint.getConfigurationElements();
		for (IConfigurationElement metamodelImageElement : metamodelImageElements) {
			if (METAMODEL_IMAGE.equals(metamodelImageElement.getName())) {
				readMetamodelImage(metamodelImageElement);
			} else {
				log(IStatus.ERROR, NLS.bind(Messages.MetamodelImageRegistry_elementError, METAMODEL_IMAGE, metamodelImageElement.getName()));
			}
		}
	}
	
	/**
	 * Returns the image registered for the given metamodel or <code>null</code>.
	 * 
	 * @param metamodel
	 *            the metamodel
	 * @return the image registered for the given metamodel or <code>null</code>
	 */
	public Image getImage(EPackage metamodel) {
		if (metamodel == null) {
			throw new IllegalArgumentException();
		}
		String metamodelURI = metamodel.getNsURI();
		return (metamodelURI != null) ? getImage(metamodelURI) : null;
	}
	
	/**
	 * Returns the image registered for the given metamodel or <code>null</code>.
	 * 
	 * @param metamodelURI
	 *            the metamodel URI
	 * @return the image registered for the given metamodel or <code>null</code>
	 */
	public Image getImage(String metamodelURI) {
		if (metamodelURI == null) {
			throw new IllegalArgumentException();
		}
		String imageKey = getImageKey(metamodelURI);
		ImageRegistry imageRegistry = EmfUtilUiPlugin.getDefault().getImageRegistry();
		Image image = imageRegistry.get(imageKey);
		if (image == null) {
			URL url = myMetamodelURIToImageURLMap.get(metamodelURI);
			if (url == null) {
				return null;
			}
			ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
			imageRegistry.put(imageKey, imageDescriptor);
			image = imageRegistry.get(imageKey);
		}
		return image;
	}
	
	private void readMetamodelImage(IConfigurationElement metamodelImageElement) {
		String metamodelURI = metamodelImageElement.getAttribute(METAMODEL_IMAGE__METAMODEL_URI);
		if (metamodelURI == null) {
			log(IStatus.ERROR, NLS.bind(Messages.MetamodelImageRegistry_elementAttributeError, METAMODEL_IMAGE, METAMODEL_IMAGE__METAMODEL_URI));
			return;
		}
		String imagePath = metamodelImageElement.getAttribute(METAMODEL_IMAGE__IMAGE_PATH);
		if (imagePath == null) {
			log(IStatus.ERROR, NLS.bind(Messages.MetamodelImageRegistry_elementAttributeError, METAMODEL_IMAGE, METAMODEL_IMAGE__IMAGE_PATH));
			return;
		}
		Bundle bundle = Platform.getBundle(metamodelImageElement.getNamespaceIdentifier());
        if (bundle == null) {
        	log(IStatus.ERROR, Messages.MetamodelImageRegistry_imageURLError);
        	return;
        }
        URL baseURL = bundle.getEntry("/"); //$NON-NLS-1$
        URL url;
        try {
            url = new URL(baseURL, imagePath);
        } catch (MalformedURLException e) {
        	log(IStatus.ERROR, Messages.MetamodelImageRegistry_imageURLError, e);
            return;
        }
		myMetamodelURIToImageURLMap.put(metamodelURI, url);
	}
	
	private String getImageKey(String metamodelURI) {
		return IMAGE_KEY_PREFIX + metamodelURI;
	}
	
	private static void log(int severity, String message) {
		log(severity, message, null);
	}
	
	private static void log(int severity, String message, Throwable t) {
		EmfUtilUiPlugin.getDefault().getLog().log(new Status(severity, EmfUtilUiPlugin.ID, 0, message, t));
	}
	
	private final Map<String, URL> myMetamodelURIToImageURLMap = new HashMap<String, URL>();
	
	private static final String EXTENSTION_POINT_ID = "metamodelImages"; //$NON-NLS-1$
	
	private static final String METAMODEL_IMAGE = "metamodelImage"; //$NON-NLS-1$
	
	private static final String METAMODEL_IMAGE__METAMODEL_URI = "metamodelURI"; //$NON-NLS-1$
	
	private static final String METAMODEL_IMAGE__IMAGE_PATH= "imagePath"; //$NON-NLS-1$
	
	private static final String IMAGE_KEY_PREFIX = METAMODEL_IMAGE;
	
}
