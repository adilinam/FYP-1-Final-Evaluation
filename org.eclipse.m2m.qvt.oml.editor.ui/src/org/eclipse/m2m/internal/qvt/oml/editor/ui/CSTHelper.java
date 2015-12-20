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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.utilities.ASTNode;

public class CSTHelper {

	private CSTHelper() {
	}

	/**
	 * Gets CST elements targeted by the given region.
	 * @param root the initial context for elements lookup
	 * @param region the scope for CST node lookup
	 * 
	 * @return nodes that are targeted by the region, ordered as inner most 
	 * to the region first the outer most as last.
	 */
	public static List<CSTNode> selectTargetedElements(CSTNode root, IRegion region) {
		List<CSTNode> elements = new ArrayList<CSTNode>();
		int startOffset = region.getOffset();
		int endOffset = startOffset + region.getLength();
		
		for(TreeIterator<EObject> it = root.eAllContents(); it.hasNext();) {
			EObject nextObject = it.next();
			if(!(nextObject instanceof CSTNode)) continue;
			
			CSTNode nextNode = (CSTNode) nextObject;
			if(startOffset >= nextNode.getStartOffset() && endOffset <= nextNode.getEndOffset() ) {
				elements.add(nextNode);
			}
		}
		
		Collections.reverse(elements);
		return elements;	
	}	

	/**
	 * Gets owning mapping module for the given CST node.
	 * 
	 * @param nodeCS CST node to start search from
	 * 
	 * @return {@link MappingModuleCS} instance or <code>null</code> if no owning module is found.
	 */
	public static MappingModuleCS getModule(CSTNode nodeCS) {
		EObject parent = nodeCS;
		while(parent != null && !(parent instanceof MappingModuleCS)) {
			parent = parent.eContainer();
		}
		
		return (MappingModuleCS) parent;
	}
	
	public static URI getSourceFile(CSTNode nodeCS) {
		MappingModuleCS moduleCST = getModule(nodeCS);
		if(moduleCST == null) {
			return null;
		}
		
		return ASTBindingHelper.resolveModuleFile(moduleCST);
	}
	
	public static EcoreEnvironment getEnvironment(CSTNode nodeCS) {
		MappingModuleCS moduleCS = CSTHelper.getModule(nodeCS);
		if(moduleCS != null) {
			ASTNode moduleAS = ASTBindingHelper.resolveASTNode(moduleCS);
			if(moduleAS != null) {
				return ASTBindingHelper.resolveEnvironment(moduleAS);
			}
		}
		return null;
	}	
}
