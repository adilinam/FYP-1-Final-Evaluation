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
package org.eclipse.m2m.internal.qvt.oml.samples.ui;

import java.text.MessageFormat;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.samples.ui.messages";//$NON-NLS-1$

	private Messages() {
		// Do not instantiate
	}
    
    public static String getString(final String template, final Object[] arguments) {
        return MessageFormat.format(template, arguments);
    }

	public static String SampleProjectsCreationOperation_creatingProjects;
	public static String SampleProjectsCreationOperation_overwrite_title;
	public static String SampleProjectsCreationOperation_overwrite_message;
	public static String SampleProjectsCreationOperation_NoEntry;
	public static String SamplesWizardPage_title;
	public static String SamplesWizardPage_desc;
	
	public static String SamplesWizardPage_projectName;
	public static String SamplesWizardPage_projectNameIndexed;	
	public static String SamplesWizardPage_alreadyExists;
	public static String SamplesWizard_ErrorTitle;
	public static String SamplesWizard_LogMessage;
	public static String SamplesWizard_ErrorMessage;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
