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
package org.eclipse.m2m.internal.qvt.oml.ui.wizards;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.m2m.internal.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.m2m.internal.qvt.oml.ui.wizards.project.INewQVTElementDestinationWizardDelegate;
import org.eclipse.m2m.internal.qvt.oml.ui.wizards.project.INewQVTProjectElementWizard;
import org.eclipse.ui.IWorkbench;

/**
 * A base class for all new QVT project wizard elements.
 * <p>
 * Subclasses based on this implementation can be added to artifacts available
 * for creation within a new QVT project.
 * <p>
 * If used on existing project, no <code>destination wizard</code> is set and
 * this wizard is responsible for selecting a destination on its own.
 */
public abstract class AbstractNewQVTElementWizard extends Wizard implements INewQVTProjectElementWizard {

	private INewQVTElementDestinationWizardDelegate fDestinationProvider;
	private boolean fContentsCreated;
	private IWorkbench fWorkbench;
	private IStructuredSelection fSelection;

	protected AbstractNewQVTElementWizard() {
		super();
		setNeedsProgressMonitor(true);		
	}

	protected IStructuredSelection getSelection() {
		return fSelection;
	}

	protected IWorkbench getWorkbench() {
		return fWorkbench;
	}
	
	protected void setContentsCreated(boolean isCreated) {
		fContentsCreated = isCreated;
	}

	protected abstract boolean doPerformFinish(IProgressMonitor monitor);
	

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		fWorkbench = workbench;
		fSelection = selection;
	}

	public void init(INewQVTElementDestinationWizardDelegate destinationProvider) {
		if(isContentCreated()) {
			throw new IllegalStateException("Must be called after creation"); //$NON-NLS-1$
		}
		
		fDestinationProvider = destinationProvider;
	}

	public INewQVTElementDestinationWizardDelegate getDestinationProvider() {
		return fDestinationProvider;
	}

	public boolean isContentCreated() {
		return fContentsCreated;
	}
	
	
	@Override
	public final boolean performFinish() {
		if(fDestinationProvider != null) {
			if(!fDestinationProvider.createDestination()) {
				QVTUIPlugin.log(QVTUIPlugin.createStatus(IStatus.ERROR, Messages.AbstractNewQVTElementWizard_ProjectCreationFailed));
				return false;
			}
		}
		
		return doPerformFinish(null);
	}
}