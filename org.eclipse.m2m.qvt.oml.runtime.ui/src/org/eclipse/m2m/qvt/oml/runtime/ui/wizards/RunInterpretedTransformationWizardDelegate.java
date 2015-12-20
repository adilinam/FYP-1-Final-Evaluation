/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.runtime.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.RunInterpretedTransformationWizard;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.eclipse.ui.wizards.IWizardRegistry;

/**
 * @author sboyko
 */
public class RunInterpretedTransformationWizardDelegate extends RunInterpretedTransformationWizard {
	
	public RunInterpretedTransformationWizardDelegate(URI uriTransf, List<URI> paramUris) {
		super(uriTransf, getTargetUris(paramUris));
	}

    public IWorkbenchWizard getProjectWizard() {
    	IWizardRegistry wizardRegistry = PlatformUI.getWorkbench().getNewWizardRegistry();
    	if (wizardRegistry == null) {
    		return null;
    	}
		IWizardDescriptor wizardDescriptor = wizardRegistry.findWizard(""); //$NON-NLS-1$
		if (wizardDescriptor == null) {
			return null;
		}
        IWorkbenchWizard transformationWizard = null;
		try {
			transformationWizard = wizardDescriptor.createWizard();
			transformationWizard.init(PlatformUI.getWorkbench(), null);
		} catch (CoreException e) {
			transformationWizard = null;
		}
		return transformationWizard;
    }
    
    private static List<TargetUriData> getTargetUris(List<URI> paramUris) {
    	List<TargetUriData> targetUris = new ArrayList<TargetUriData>(paramUris.size());
    	for (URI uri : paramUris) {
    		targetUris.add(new TargetUriData(uri.toString()));
    	}
    	return targetUris;    	
    }
	
}
