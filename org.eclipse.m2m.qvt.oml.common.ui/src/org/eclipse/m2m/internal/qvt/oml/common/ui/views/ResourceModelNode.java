/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.common.ui.CommonPluginImages;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtilPlugin;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.WorkspaceMetamodelProvider;
import org.eclipse.swt.graphics.Image;

class ResourceModelNode extends MetamodelContainerNode {		
	final URI uri;
	final MetamodelNode contentNode;
	
	ResourceModelNode(URI resourceURI, IMetamodelDesc descriptor, BrowserNode parent) {
		super(WORKSPACE_MODELS_TYPE, getLabel(resourceURI), image(), parent);
		
		this.uri = resourceURI;			
		this.contentNode = new MetamodelNode(descriptor, this, true) {
			@Override
			public boolean mayContain(EModelElement element) {
				return uri.equals(EcoreUtil.getURI(element).trimFragment()) && EmfUtilPlugin.isSuccess(descriptor().getLoadStatus());
			}
			
			@Override
			public BrowserNode resolveModelElement(EModelElement element) {
				String uriFragment = EcoreUtil.getURI(element).fragment();
				EObject rootPackage = contentNode.getEObject();								
				if(rootPackage != null && EmfUtilPlugin.isSuccess(descriptor().getLoadStatus())) {					
					// in the underlying resource, look for EObject by the URI fragment
					if(rootPackage.eResource() != null && uriFragment != null) {
						EObject collocatedElement = rootPackage.eResource().getEObject(uriFragment);
						if(collocatedElement != null) {
							// find node by the same EObject		
							return findNodeForInstance(contentNode, collocatedElement);
						}
					} 
				}
				return null;
			}		
			
			@Override
			public EPackage getSearchScopePackage() {
				if(descriptor().isLoaded()) {				
					return contentNode.getPackage();
				}
				
				EPackage result = null;
				try {
					result = WorkspaceMetamodelProvider.loadResourceMetamodel(uri.toString());
				} catch (RuntimeException e) {
					return null;
				}
				return result;
			}
		};	
	}
	
	static Image image() {
		return CommonPluginImages.getInstance().getImage(CommonPluginImages.METAMODEL_FILE);			
	}
	
	IMetamodelDesc descriptor() {
		return contentNode.descriptor;
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == URI.class) {
			return uri;
		}
		return super.getAdapter(adapter);
	}

	@Override
	public boolean hasChildren(boolean includeInheritedFeatures) {		
		return !descriptor().isLoaded() || super.hasChildren(includeInheritedFeatures);
	}
	
	@Override
	public List<BrowserNode> getChildren(boolean includeInheritedFeatures) {
		return Collections.<BrowserNode>singletonList(contentNode);
	}		
	
	private static String getLabel(URI resourceUri) {
		if(!resourceUri.isPlatformResource()) {
			return resourceUri.toString();
		}
		
		IPath path = new Path(resourceUri.path());
		IPath wsPath = path.removeFirstSegments(1);
		return wsPath.toString();		
	}	
}