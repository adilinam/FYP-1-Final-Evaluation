/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectors;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CategoryImageConstants;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

/**
 * @author Aleksandr Igdalov
 * Created on Jul 4, 2007
 */

public class RegisteredMetamodelCollector extends AbstractMetamodelCollector {
	public void addPropoposals(final Collection<ICompletionProposal> proposals, final QvtCompletionData data) {
		if (isInitialized(data)) {
			retrieveMetamodels(proposals, data, null);
		} else {
			IWorkbench workbench = PlatformUI.getWorkbench();
			IProgressService progressService = workbench.getProgressService();
			try {
				progressService.busyCursorWhile(new IRunnableWithProgress() {
					public void run(IProgressMonitor monitor) {
						retrieveMetamodels(proposals, data, monitor);
					}
				});
			} catch (InvocationTargetException e) {
				Activator.log(e);
			} catch (InterruptedException e) {
				Activator.log(e);
			}
		}
	}

	private boolean isInitialized(QvtCompletionData data) {
		MetamodelRegistry metamodelRegistry = data.getMetamodelRegistry();
		String[] metamodelIds = metamodelRegistry.getMetamodelIds();
		for (String id : metamodelIds) {
			try {
				IMetamodelDesc metamodelDesc = metamodelRegistry.getMetamodelDesc(id);
				if (!metamodelDesc.isLoaded()) {
					return false;
				}
			} catch (EmfException e) {
				Activator.log(e);
			}
		}
		return true;
	}

	private void retrieveMetamodels(Collection<ICompletionProposal> proposals,
			QvtCompletionData data, IProgressMonitor monitor) {
		MetamodelRegistry metamodelRegistry = data.getMetamodelRegistry();
		String[] metamodelIds = metamodelRegistry.getMetamodelIds();
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		monitor.beginTask(Messages.RegisteredMetamodelCollector_RetrievingMetamodelsTaskName, metamodelIds.length);
		
		List<String> rootPackages = new ArrayList<String>();
		Collection<Object> activeMetamodelURIs = Arrays.asList(data.getEnvironment().getEPackageRegistry().keySet().toArray());		
		
		for (String id : metamodelIds) {
			try {
				IMetamodelDesc metamodelDesc = metamodelRegistry.getMetamodelDesc(id);
				monitor.worked(1);

				EPackage pack = EmfUtil.getRootPackage(metamodelDesc.getModel());
								
				if (!rootPackages.contains(pack) 
				        && (!activeMetamodelURIs.contains(pack.getNsURI()))) {
		            String proposalString = getProposalString(data, pack);
				    rootPackages.add(proposalString);
				}
				
			} catch (EmfException e) {
				Activator.log(e);
			}
		}
		Collections.sort(rootPackages);
		for (String proposalString : rootPackages) {
            QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(proposalString, CategoryImageConstants.PACKAGE, data);
            CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
        }
		monitor.done();
	}
}