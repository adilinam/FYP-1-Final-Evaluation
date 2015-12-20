/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
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

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.runtime.project.messages"; //$NON-NLS-1$
	
	public static String QvtInterpretedTransformation_NotExecutable;
	public static String QvtInterpreter_Transformation_failed;
	
	public static String QvtProjectTransformation_NoProject;
	public static String QvtProjectTransformation_NotAJavaProject;
	public static String QvtProjectTransformation_ProjectNotBuilt;
	public static String QvtProjectTransformation_NoJavaGenerated;
	
	public static String TransformationUtil_ParseTransformationError;
	public static String TransformationUtil_InvalidUri;
	
	public static String NoQvtImplementorFactoryRegistered;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
