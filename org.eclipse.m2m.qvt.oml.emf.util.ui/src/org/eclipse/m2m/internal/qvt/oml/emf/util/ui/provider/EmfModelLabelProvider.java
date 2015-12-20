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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.provider;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.WorkspaceMetamodelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.model.WorkbenchLabelProvider;


public class EmfModelLabelProvider extends LabelProvider {
	ILabelProvider myDefaultProvider = new WorkbenchLabelProvider();
	ILabelProvider myEmfProvider = new EMFLabelProvider();
	
	@Override
	public String getText(Object element) {
		if(element instanceof EmfModelContentProvider.ResourceNode) {
			Resource resource = ((EmfModelContentProvider.ResourceNode)element).getResource();
			return String.valueOf(resource.getURI());
		}
		else if(element instanceof EmfModelContentProvider.Node) {
			Object data = ((EmfModelContentProvider.Node)element).getData();
			return myEmfProvider.getText(data);
		}
		
		return myDefaultProvider.getText(element);
	}
	
	@Override
	public Image getImage(Object element) {
		if(element instanceof EmfModelContentProvider.ResourceNode) {
			Resource res = ((EmfModelContentProvider.ResourceNode)element).getResource();
			EPackage ePackage = WorkspaceMetamodelProvider.getFirstEPackageContent(res);
			if(ePackage != null) {
				return myEmfProvider.getImage(ePackage);
			}
		}
		if(element instanceof EmfModelContentProvider.Node) {
			Object data = ((EmfModelContentProvider.Node)element).getData();
			return myEmfProvider.getImage(data);
		}
		
		return myDefaultProvider.getImage(element);
	}
}
