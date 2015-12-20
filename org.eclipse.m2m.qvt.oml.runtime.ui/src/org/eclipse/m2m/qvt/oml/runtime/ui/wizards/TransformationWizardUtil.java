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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.m2m.internal.qvt.oml.ModelExtentHelper;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.RunInterpretedTransformationWizard;

/**
 * @author sboyko
 * 
 * @since 3.5
 */
public class TransformationWizardUtil {
	
	private TransformationWizardUtil() {		
	}
	
	public static IWizard createTransformationWizard(URI uriTransf, List<URI> sources) {
		List<TargetUriData> paramUris = new ArrayList<TargetUriData>(sources.size());
		for (URI uri : sources) {
			paramUris.add(new TargetUriData(uri.toString()));
		}
		
		return new RunInterpretedTransformationWizard(uriTransf, paramUris);
	}
	
	public static IWizard createTransformationWizard(final Resource resource, boolean isRunInBackground) {
		List<TargetUriData> targetUris = new ArrayList<TargetUriData>(1);
		targetUris.add(new TargetUriData(resource.getURI().toString(), new TargetUriData.ContentProvider() {
			
			public List<URI> getMetamodels() {
				if (resource.getContents().isEmpty()) {
					return Collections.emptyList();
				}

				URI uri = URI.createURI(resource.getContents().get(0).eClass().getEPackage().getNsURI());
				return Arrays.asList(uri);
			}
			
			public List<EObject> getContents() {
				return resource.getContents();
			}
			
			@SuppressWarnings("restriction")
			public void setContents(final List<? extends EObject> contents) {
				ModelExtentHelper.mergeExtentToResource(resource, contents);
			}
			
		}));
		
		RunInterpretedTransformationWizard wizard = new RunInterpretedTransformationWizard(null, targetUris);
		wizard.setRunInBackground(isRunInBackground);
		wizard.setNeedsProgressMonitor(!isRunInBackground);
		return wizard;
	}
	
}
