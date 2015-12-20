/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.debug.ui;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

public class QVTODebugImages {

	public static final String CONDITIONAL_BPNT_ENABLED = "conditionalBreakpointEnabled"; //$NON-NLS-1$

	public static final String CONDITIONAL_BPNT_DISABLED = "conditionalBreakpointDisabled"; //$NON-NLS-1$

	public static final String MODEL_PARAMETER = "modelParameter"; //$NON-NLS-1$

	public static final String REFERENCE = "reference"; //$NON-NLS-1$

	public static final String ATTRIBUTE = "attribute"; //$NON-NLS-1$

	public static final String INTERM_PROPERTY = "intermediateProperty"; //$NON-NLS-1$

	public static final String THIS_VARIABLE = "thisVariable"; //$NON-NLS-1$
	
	public static final String PREDEFINED_VARIABLE = "predefinedVariable"; //$NON-NLS-1$

	public static final String LOCAL_VARIABLE = "localVariable"; //$NON-NLS-1$
	
	public static final String COLLECTION_ELEMENT = "collectionElement"; //$NON-NLS-1$
	
	private static ImageRegistry fgImageRegistry = QVTODebugUIPlugin
			.getDefault().getImageRegistry();

	private QVTODebugImages() {
		super();
	}

	public static Image getImage(String key) {
		return fgImageRegistry.get(key);
	}

}
