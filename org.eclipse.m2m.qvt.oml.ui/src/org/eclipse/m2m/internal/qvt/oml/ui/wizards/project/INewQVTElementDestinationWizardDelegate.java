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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;

/**
 * This interface represents destination where <code>QVT Project</code>
 * elements, like  for instance compilation units, can be placed.
 * <p>
 * 
 * The motivation behind this interface is to allow clients dependent on related
 * settings (possibly modified) in other wizard pages to handle to these changes.
 * <p>
 * There is no active listening mechanism involved here, the way to handle this
 * is just considering elements maintained by this provider as
 * <code>volatile</code>.
 */
public interface INewQVTElementDestinationWizardDelegate {
	/**
	 * Get the project handle for this destination.
	 * <p>
	 * <code>Remark:</code> The project may or may not exist, depending
	 * whether the project to contain the element to be created is also newly
	 * created during the same wizard session.
	 * 
	 * @return The project handle. The returned instance may be different
	 *         between multiple calls to this method as the implementor may
	 *         allow modification of this settings/
	 */
	IProject getProjectHandle();

	/**
	 * Get the source container for QVT source elements within the project
	 * associated with this provider.
	 * 
	 * @return The container handle. The returned instance may be different
	 *         between multiple calls to this method as the implementor may
	 *         allow modification of this settings.
	 */
	IContainer getSourceContainer();

	/**
	 * Creates the project and source container for the currently handle objects
	 * with this provider.
	 * 
	 * @return <code>true</code> if successfully created, <code>false</code>
	 *         if an error occurred
	 */
	boolean createDestination();
}
