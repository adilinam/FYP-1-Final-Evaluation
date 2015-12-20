/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.swt.graphics.Image;

class MetamodelContainerNode extends BrowserNode {

	static final int GLOBAL_REGISTRY_TYPE = 0;
	static final int WORKSPACE_MODELS_TYPE = 1;		
	
	final int type;
	final String label;
	final Image image;
	
	MetamodelContainerNode(int type, String label, Image image, BrowserNode parent) {
		super(null, parent);
		
		this.label = label;
		this.image = image;
		this.type = type;
		
		assert type >= GLOBAL_REGISTRY_TYPE && type <= WORKSPACE_MODELS_TYPE;
	}
	
	@Override
	public String getText() {		
		return label;
	}
	
	@Override
	public Image getImage() {
		return image;
	}
			
	public BrowserNode resolve(EModelElement element) {
		// resolve in packages from global registry first by usingf
		// instance based equality
		List<MetamodelContainerNode> childContainers = childContainers();			
		Collections.sort(childContainers, new Comparator<MetamodelContainerNode>() {
			public int compare(MetamodelContainerNode o1, MetamodelContainerNode o2) {
				return o1.type - o2.type;
			}
		});
		
		BrowserNode result = null;
		List<BrowserNode> allChildNodes = getChildren(false);
		for (int i = 0; i < allChildNodes.size(); i++) {
			BrowserNode node = allChildNodes.get(i);
			if(node instanceof MetamodelNode) {
				MetamodelNode mmNode = (MetamodelNode)node;
				if(mmNode.mayContain(element)) {
					result = mmNode.resolveModelElement(element);
					if(result != null) break;
				}
			}
		}

		if(result == null) {
			for (MetamodelContainerNode metamodelContainerNode : childContainers) {
				result = metamodelContainerNode.resolve(element);
				if(result != null) break;
			}
		}
		return result;
	}
	
	public List<MetamodelContainerNode> childContainers() {
		List<MetamodelContainerNode> childContainers = new ArrayList<MetamodelContainerNode>();
		List<BrowserNode> childNodes = getChildren(false);
		for (int i = 0; i < childNodes.size(); i++) {
			BrowserNode node = childNodes.get(i);
			if(node instanceof MetamodelContainerNode) {
				childContainers.add((MetamodelContainerNode)node);
			}
		}
		return childContainers;
	}
}