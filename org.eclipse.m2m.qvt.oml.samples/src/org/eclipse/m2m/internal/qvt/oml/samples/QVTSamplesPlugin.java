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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * @author vrepeshko
 */
public class QVTSamplesPlugin extends AbstractUIPlugin {
	
	public static final String ID = "org.eclipse.m2m.qvt.oml.samples"; //$NON-NLS-1$
    
    public QVTSamplesPlugin() {
		ourPlugin = this;
	}

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
	}
	
	@Override
	public void stop(final BundleContext context) throws Exception {
		super.stop(context);
		ourPlugin = null;
	}

	public static QVTSamplesPlugin getDefault() {
		return ourPlugin;
	}

	public static ImageDescriptor getImageDescriptor(final String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(ID, path);
	}

    private static QVTSamplesPlugin ourPlugin;
}
