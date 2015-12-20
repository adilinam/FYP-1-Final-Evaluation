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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class EmfUtilUiImages {
	private EmfUtilUiImages() {}
	
	public static ImageDescriptor getImageDescriptor(String key) {
        ImageDescriptor descriptor = EmfUtilUiPlugin.getDefault().getImageRegistry().getDescriptor(key);
        if (descriptor == null) {
            ImageDescriptor id = AbstractUIPlugin.imageDescriptorFromPlugin(EmfUtilUiPlugin.ID, "icons/" + key + ".gif"); //$NON-NLS-1$ //$NON-NLS-2$
            EmfUtilUiPlugin.getDefault().getImageRegistry().put(key, id);
            return EmfUtilUiPlugin.getDefault().getImageRegistry().getDescriptor(key);
        }
        return descriptor;
	}
	
    public static Image getImage(String key) {
        Image image = EmfUtilUiPlugin.getDefault().getImageRegistry().get(key);
        if (image == null) {
            ImageDescriptor id = AbstractUIPlugin.imageDescriptorFromPlugin(EmfUtilUiPlugin.ID, "icons/" + key + ".gif"); //$NON-NLS-1$ //$NON-NLS-2$
            EmfUtilUiPlugin.getDefault().getImageRegistry().put(key, id);
            return EmfUtilUiPlugin.getDefault().getImageRegistry().get(key);
        }
        return image;
    }
	
	public static final String FOLDER = "folder"; //$NON-NLS-1$
	public static final String METAMODELS = "metamodels"; //$NON-NLS-1$
}
