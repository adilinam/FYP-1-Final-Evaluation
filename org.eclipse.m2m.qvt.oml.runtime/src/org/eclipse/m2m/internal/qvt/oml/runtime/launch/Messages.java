/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.launch;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.runtime.launch.messages"; //$NON-NLS-1$
		
	public static String QvtValidator_NoTraceFileExtension;
	public static String QvtValidator_DestinationExists;
	public static String QvtValidator_NewDestinationHasFragment;
	public static String QvtValidator_EmptyInput;
	public static String QvtValidator_InvalidSourceUri;
	public static String QvtValidator_InvalidTargetUri;
	public static String QvtValidator_NoTraceFile;
	public static String QvtValidator_NoFeature;
	public static String QvtValidator_InvalidFeature;
	public static String QvtValidator_IncompatibleInputTypes;
	public static String QvtValidator_EmptyInputTransfParam;
	public static String QvtValidator_MissedInputTransfParam;
	public static String QvtValidator_SuperfluousInputTransfParam;
	public static String QvtValidator_IncompatibleInputMetamodels;
	public static String QvtValidator_DestinationReadonly;
	public static String QvtValidator_DestinationReadonlyParam;
	public static String QvtValidator_DestinationExistsNonEObject;
	public static String QvtValidator_TransformationMissedEntryOp;

    public static String QvtValidator_InvalidTraceObjectUri;
	
	public static String QvtValidator_InvalidUri;
	public static String QvtValidator_UriNotFile;
	public static String QvtValidator_UriNotFileParam;
	public static String QvtValidator_UriCorrupted;
	public static String QvtValidator_InplaceConfigNotSupported;
	
	public static String InMemoryQvtLaunchConfigurationDelegate_TransformationJobName;
	public static String InMemoryQvtLaunchConfigurationDelegate_RunningTaskName;
	
	public static String QvtLaunchConfigurationDelegate_transformationFileNotFound;
	
	public static String QvtBuilderLaunchTab_TransformationNotFound;	
	
	public static String QvtLaunchConfigurationDelegateBase_InplaceFailure;
	public static String QvtLaunchConfigurationDelegateBase_FeatureSetFailure;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
