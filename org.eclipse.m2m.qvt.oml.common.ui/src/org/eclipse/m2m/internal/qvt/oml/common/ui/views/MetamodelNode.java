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
package org.eclipse.m2m.internal.qvt.oml.common.ui.views;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtilPlugin;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

class MetamodelNode extends BrowserNode {
	IMetamodelDesc descriptor;
	
	MetamodelNode(IMetamodelDesc descriptor, BrowserNode root, boolean loadLazily) {
		super(!loadLazily ? descriptorToEObject(descriptor) : null, root);
		this.descriptor = descriptor;
	}
	
	public boolean mayContain(EModelElement element) {
		Resource elementResource = element.eResource();
		if(elementResource != null) {
			return getPackage().eResource() == elementResource;
		} 
		
		return EcoreUtil.getRootContainer(getEObject()) == EcoreUtil.getRootContainer(element);
	}
	
	public BrowserNode resolveModelElement(EModelElement element) {
		return findNodeForInstance(this, element);
	}
	
	public IMetamodelDesc getDescriptor() {
		return descriptor;
	}
	
	@Override
	public EObject getEObject() {
		return descriptorToEObject(descriptor);
	}
	
	public EPackage getPackage() {
		return (EPackage)getEObject();
	}
	
	public EPackage getSearchScopePackage() {
		return getPackage();
	}

	@Override
	public String getText() {
		Diagnostic status = getDescriptor().getLoadStatus();
		if(!EmfUtilPlugin.isSuccess(status)) {
			return "[" + getDescriptor().getId() + "] " + status.getMessage(); //$NON-NLS-1$ //$NON-NLS-2$
		}					
		
		return super.getText();
	}
	
	@Override
	public Image getImage() {
		getPackage(); // ensure package loaded
		if(!EmfUtilPlugin.isSuccess(getDescriptor().getLoadStatus())) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
		}
		return super.getImage();
	}
	
	private static EPackage descriptorToEObject(IMetamodelDesc descriptor) {
		return descriptor.getModel();
	}
}