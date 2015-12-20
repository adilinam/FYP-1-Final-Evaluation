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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.outline;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ocl.cst.CSTNode;



public class QvtOutlineNodeSelector {
	public QvtOutlineNodeSelector(final TreeViewer viewer) {
		myViewer = viewer;
		myContentProvider = (QvtOutlineContentProvider)myViewer.getContentProvider();
	}
	
    public void selectCorrespondingNode(final TextSelection selection) {
    	OutlineNode nodeToSelect = null;
    	Object[] roots = ((QvtOutlineInput) myViewer.getInput()).getChildren();
    	for (int i = 0; i < roots.length; i++) {
    		nodeToSelect = findCorrespondingNode((OutlineNode)roots[i], selection);
    		if (nodeToSelect != null) {
    			break;
    		}
    	}
    	
    	select(nodeToSelect);
    }
    
	private void select(OutlineNode node) {
		ISelection currentSelection = myViewer.getSelection();
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection)currentSelection;
			List<?> elements = ss.toList();
			if (!elements.contains(node)) {
                //if(node == null) {
                //    node = getRulesNode(myViewer.getInput());
                //}

                if(node != null) {
                    myViewer.setSelection(new StructuredSelection(node), false);
                }
			}
		}
	}
    
    private OutlineNode findCorrespondingNode(final OutlineNode root, final TextSelection selection) {
    	Object[] children = myContentProvider.getChildren(root);
    	for (int i = 0; i < children.length; i++) {
    		OutlineNode node = (OutlineNode)children[i];
    		CSTNode elem = node.getSyntaxElement();
    		if (elem != null) {
    			CSTNode pos = (CSTNode) EcoreUtil.create(elem.eClass());
    			pos.setStartOffset(elem.getStartOffset());
    			pos.setEndOffset(elem.getEndOffset());
    			if (isInside(selection, pos)) {
    				List<OutlineNode> nextChildren = node.getChildren();
    				if(nextChildren == null || nextChildren.isEmpty()) {
    					return node;
    				}
    			}
    		}

    		OutlineNode subResult = findCorrespondingNode(node, selection);
    		if (subResult != null) {
    			return subResult;
    		}
    	}
    	
    	CSTNode rootSyntaxElement = root.getSyntaxElement();
		if(rootSyntaxElement != null && isInside(selection, rootSyntaxElement)) {
    		return root;
    	}
    	return null;
    }
    
    private boolean isInside(final TextSelection selection, final CSTNode elementPositions) {
    	int startOffset = elementPositions.getStartOffset();
		int endOffset = elementPositions.getEndOffset();
		int selectedOffset = selection.getOffset();
		return startOffset <= selectedOffset && endOffset >= selectedOffset;
    }
    
	private final TreeViewer myViewer;
	private final QvtOutlineContentProvider myContentProvider;
}
