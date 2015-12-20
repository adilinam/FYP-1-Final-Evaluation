/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectors;

import org.eclipse.osgi.util.NLS;

/**
 * @author aigdalov
 * Created on Jul 6, 2007
 */

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectors.messages"; //$NON-NLS-1$
	public static String RegisteredMetamodelCollector_RetrievingMetamodelsTaskName;
	public static String WorkspaceMetamodelCollector_EPackageLoadError;
	public static String WorkspaceMetamodelCollector_EPackageNameOrNsUriIsNull;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}