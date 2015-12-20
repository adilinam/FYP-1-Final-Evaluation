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
package org.eclipse.m2m.internal.qvt.oml.ui.wizards.project;

import org.eclipse.ui.INewWizard;

/**
 * Wizard for new elements to be created in a <code>just being created</code>
 * QVT project.
 */
public interface INewQVTProjectElementWizard extends INewWizard {

	/**
	 * Must be called just after wizard creation
	 * 
	 * @param destinationProvider
	 *            the destination provider to be used by this wizard
	 * @throws IllegalStateException
	 *             if after the contents is created
	 */
	void init(INewQVTElementDestinationWizardDelegate destinationProvider);

	/**
	 * Get the destination provider with which this wizard has been initialized.
	 * 
	 * @see #init(INewQVTElementDestinationWizardDelegate)
	 */
	INewQVTElementDestinationWizardDelegate getDestinationProvider();

	/**
	 * Returns whether a wizard content has been created.
	 * <p>
	 * Note: The contents is created after pages are added to this wizard.
	 * 
	 * @return <code>true</code> if a wizard has been created, and
	 *         <code>false</code> otherwise
	 */
	boolean isContentCreated();
}
