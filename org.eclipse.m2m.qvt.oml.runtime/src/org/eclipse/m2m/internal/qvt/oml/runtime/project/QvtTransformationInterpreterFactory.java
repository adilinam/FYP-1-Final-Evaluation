/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;

public interface QvtTransformationInterpreterFactory {
	interface Descriptor {
	    String FACTORY_POINT_ID = QvtRuntimePlugin.ID + ".qvtTransformationImplFactory";		 //$NON-NLS-1$
		String FACTORY_ELEM = "factory"; //$NON-NLS-1$
		String CLASS_ATTR = "class"; //$NON-NLS-1$
	}
	
	QvtTransformation create(String moduleID) throws MdaException;
}
