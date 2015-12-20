/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.metamodel;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;

public class EPackageNodeUtil {
	private EPackageNodeUtil() {}
    
    public static interface IProcessor {
    	boolean process(ChooserNode node);
    }
    
	/**
     * Collects nodes of the same package as <code>template</code>
     * @param root - tree node to start with
     * @param nodes - collection to put equal elements into
     * @param template - the element which is comared with others
     */
    public static ChooserNode[] collectEqualNodes(ChooserNode[] roots, final String packUri) {
        final List<ChooserNode> nodes = new ArrayList<ChooserNode>();
        
		IProcessor processor = new IProcessor() {
			public boolean process(ChooserNode node) {
		    	if (node instanceof EPackageNode == false) {
		    		return false;
		    	}
		    	
		        EPackageNode packNode = (EPackageNode) node;
	            if(packNode.getEPackage().getNsURI().equals(packUri)) {
	            	nodes.add(packNode);
	            }
	            
	            return false;
			}
        };
        
        walkNodes(roots, processor);
        return nodes.toArray(new ChooserNode[nodes.size()]);
    }
    
    public static boolean walkNodes(ChooserNode[] roots, IProcessor processor) {
    	for(ChooserNode root: roots) {
	    	{
		    	boolean shouldStop = processor.process(root);
		    	if(shouldStop) {
		    		return true;
		    	}
	    	}
	    	
	        ChooserNode[] children = root.getChildren();
	        if(children != null) {
		        for (int i = 0; i < children.length; i++) {
		            boolean shouldStop = walkNodes(new ChooserNode[] {children[i]}, processor);
		            if(shouldStop) {
		            	return true;
		            }
		        }
	        }
    	}
    	
    	return false;
    }
    
    /**
     * Checks or unchecks all the nodes equal to the element if it is an EPackageNode
     * Recursively processes all the element's children as the viewer does not call
     * a selection event on them   
     * @param viewer - tree viewer containing the element
     * @param element - the node being processes
     * @param checked - checked state of the <code>element</code>
     */
    public static void checkOrUncheckEqualNodes(ContainerCheckedTreeViewer viewer, ChooserNode[] roots, ChooserNode element, boolean checked) {
        if (element instanceof EPackageNode) {
            EPackageNode packNode = (EPackageNode) element;
            ChooserNode[] nodes = collectEqualNodes(roots, packNode.getEPackage().getNsURI());
            for (int i = 0; i < nodes.length; i++) {
                Object equal = nodes[i];
                if (viewer.getChecked(equal) != checked)
                    viewer.setChecked(equal, checked);;                
            }
        }
        
        ChooserNode[] children = element.getChildren();
        if(children != null) {
	        for (int i = 0; i < children.length; i++) {
	            checkOrUncheckEqualNodes(viewer, roots, children[i], checked);
	        }
        }
    }
    
    public static Set<String> getMetamodelIds(Object[] checked) {
        Set<String> metamodelIds = new LinkedHashSet<String>();
        for (int i = 0; i < checked.length; i++) {
        	EPackage ePackage = null;
        	if(checked[i] instanceof EPackage) {
        		
        	} else if (checked[i] instanceof EPackageNode) {
                EPackageNode node = (EPackageNode) checked[i];
                ePackage = node.getEPackage();
            }
        	
        	
        	if(ePackage != null && ePackage.getNsURI() != null) {
        		metamodelIds.add(ePackage.getNsURI().toString());
        	}
        }
        
        return metamodelIds;
    }
}
