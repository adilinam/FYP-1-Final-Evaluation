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
package org.eclipse.m2m.internal.qvt.oml.samples;

import java.io.InputStream;
import java.net.URL;
import java.text.MessageFormat;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;


public class ResLocator implements ResourceLocator {
    public ResLocator(Plugin plugin) {
        myPlugin = plugin;
    }
      
    public URL getBaseURL() {
      return myPlugin.getBundle().getEntry("/"); //$NON-NLS-1$
    }

    public Object getImage(String key) {
        try {
            URL url = new URL(getBaseURL() + "icons/" + key + ".gif");  //$NON-NLS-1$//$NON-NLS-2$
            InputStream inputStream = url.openStream(); 
            inputStream.close();
            return url;
        }
        catch(Exception e) {
            return getMissingImage();
        }
    }

    public String getString(String key) {
        return Platform.getResourceBundle(myPlugin.getBundle()).getString(key);
    }

    public String getString(String key, Object [] substitutions) {
        return MessageFormat.format(getString(key), substitutions);
    }
    
    public String getString(String key, boolean translate) {
        return getString(key);
    }

    public String getString(String key, Object[] substitutions, boolean translate) {
        return MessageFormat.format(getString(key, translate), substitutions);
    }
    
    private Image getMissingImage() {
        if(myMissingImage == null) {
            myMissingImage = ImageDescriptor.getMissingImageDescriptor().createImage();
        }
        
        return myMissingImage;
    }

    private final Plugin myPlugin;
    private Image myMissingImage;
}
