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
package org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private Messages() {
    }

    public static String MetamodelRegistry_0;
    public static String MetamodelRegistry_LoadError;
	public static String WorskpaceMetamodelProvider_URINotReferringMetamodel;    
    
    private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.messages"; //$NON-NLS-1$
    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }
}
