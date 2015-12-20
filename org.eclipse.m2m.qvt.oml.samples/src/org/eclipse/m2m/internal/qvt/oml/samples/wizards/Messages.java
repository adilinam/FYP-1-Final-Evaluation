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
package org.eclipse.m2m.internal.qvt.oml.samples.wizards;

import org.eclipse.osgi.util.NLS;

public class Messages {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.samples.wizards.messages"; //$NON-NLS-1$


	private Messages() {
	}

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
	public static String SamplesWizardPage_LaunchConfiguration;
	public static String SamplesWizardPage_notLaunchName;
	public static String SamplesWizardPage_existingLaunch;
		
	public static String Uml2RdbSampleProjectWizard_simpleUml2rdbWizardTitle;
	public static String Uml2RdbSampleProjectWizard_defaultProjectName;
	public static String Uml2RdbSampleProjectWizard_defaultLaunchName;


    public static String Uml2RdbSampleProjectWizard_Transfomarions_project;	
}
