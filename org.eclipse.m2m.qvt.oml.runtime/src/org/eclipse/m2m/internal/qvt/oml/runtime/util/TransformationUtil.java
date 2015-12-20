/*******************************************************************************
 * Copyright (c) 2008, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.util;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.runtime.util.QvtoTransformationHelper;

@SuppressWarnings("deprecation")
public class TransformationUtil {
	
	private TransformationUtil() {		
	}
	
	/**
	 * Create helper object for transformation execution
	 * 
	 * @param module
	 *            the transformation module to execute
	 * @return the helper object, never <code>null</code>
	 */
	public static QvtoTransformationHelper createTransformationHelper(Module module) {		
		return new QvtoTransformationHelper(EcoreUtil.getURI(module).trimFragment());
	}
}
