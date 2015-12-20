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
package org.eclipse.m2m.internal.qvt.oml.runtime.ant;

import org.eclipse.osgi.util.NLS;


public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.runtime.ant.messages"; //$NON-NLS-1$
			
	
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	public static String AbstractApplyTransformationTask_Required_attribute_is_not_specified;
	public static String AbstractApplyTransformationTask_Transformation_has_been_applied;
	public static String AbstractApplyTransformationTask_File_not_found;
	
	public static String InvalidUriSpecified;
	public static String ModelParameterTypeMismatch;
	public static String ExtraModelParameter;
	public static String TransformationExecuted;

	private Messages() {
	}
}
