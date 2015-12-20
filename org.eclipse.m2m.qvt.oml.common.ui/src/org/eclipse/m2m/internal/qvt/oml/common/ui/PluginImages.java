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
package org.eclipse.m2m.internal.qvt.oml.common.ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;


public abstract class PluginImages {
    protected PluginImages(URL baseUrl) {
        myBaseUrl = baseUrl;
        
        myImageRegistry = new ImageRegistry(getStandardDisplay());
        myImageDescriptors = new HashMap<String, ImageDescriptor>();
        
        myMissingImageDescriptor = ImageDescriptor.getMissingImageDescriptor();
        myMissingImage = null;
        
        declareImages();
    }
    
    protected abstract void declareImages();

    public Image getImage(String key) {
        Image image = myImageRegistry.get(key);
        if(image == null) {
            image = getMissingImage();
        }
        
        return image;
    }

    public ImageDescriptor getImageDescriptor(String key) {
        ImageDescriptor desc = (ImageDescriptor)myImageDescriptors.get(key);
        if(desc == null) {
            desc = myMissingImageDescriptor;
        }
        
        return desc;
    }
    
    private Image getMissingImage() {
        if(myMissingImage == null) {
            myMissingImage = myMissingImageDescriptor.createImage();
        }
        
        return myMissingImage;
    }
    
    protected void declareRegistryImage(String key, String path) {
        ImageDescriptor desc;
        try {
            desc = ImageDescriptor.createFromURL(makeURL(path));
        } 
        catch (MalformedURLException e) {
            Logger.getLogger().log(Logger.SEVERE, "Failed to load " + path, e); //$NON-NLS-1$
            desc = myMissingImageDescriptor;            
        }
        
        declareImage(key, desc);
    }
    
    public void declareImage(String key, ImageDescriptor desc) {
        myImageRegistry.put(key, desc);
        myImageDescriptors.put(key, desc);
    }
    
    private URL makeURL(String path) throws MalformedURLException {
        URL url = new URL(myBaseUrl, path);
        return url;
    }
    
	public static Display getStandardDisplay() {
		Display display = Display.getCurrent();
		if (display == null) {
			display = Display.getDefault();
		}
		
		return display;		
	}	

    private final URL myBaseUrl;
    private final ImageRegistry myImageRegistry;
    private final HashMap<String, ImageDescriptor> myImageDescriptors;
    
    private final ImageDescriptor myMissingImageDescriptor;
    private Image myMissingImage;
}
