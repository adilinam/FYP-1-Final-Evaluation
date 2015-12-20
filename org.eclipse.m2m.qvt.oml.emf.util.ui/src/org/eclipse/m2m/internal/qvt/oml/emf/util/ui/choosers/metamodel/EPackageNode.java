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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.metamodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;


public class EPackageNode extends EObjectNode {
    public EPackageNode(EPackage pack, ChooserNode parent) {
        super(pack, parent);
        myChildren = null;
    }
    
    public EPackage getEPackage() {
        return (EPackage)getObj();
    }

    @Override
	public boolean hasChildren() {
        if(myChildren == null) {
            myChildren = getChildNodes();
        }

        return myChildren.length > 0;
    }

    @Override
	public ChooserNode[] getChildren() {
        if(myChildren == null) {
            myChildren = getChildNodes();
        }
        
        return myChildren;
    }
    
    protected ChooserNode[] getChildNodes() {
        return getChildNodes(getEPackage(), new NodeMaker() {
            public ChooserNode makePackageNode(EPackage pack) {
                return new EPackageNode(pack, EPackageNode.this);
            }

            public ChooserNode makeClassNode(EClass cls) {
                return new EClassNode(cls, EPackageNode.this);
            }});
    }
    
    public static interface NodeMaker {
        ChooserNode makePackageNode(EPackage pack);
        ChooserNode makeClassNode(EClass cls);
    }
    
    public static ChooserNode[] getChildNodes(EPackage pack, NodeMaker maker) {
        List<ChooserNode> nodes = new ArrayList<ChooserNode>();
        for(Iterator<?> it = pack.getESubpackages().iterator(); it.hasNext(); ) {
            EPackage subPack = (EPackage)it.next();
            nodes.add(maker.makePackageNode(subPack));
        }
            
        for(Iterator<?> it = pack.getEClassifiers().iterator(); it.hasNext(); ) {
            EClassifier classifier = (EClassifier) it.next();
            if(classifier instanceof EClass) {
                EClass cls = (EClass)classifier;
                nodes.add(maker.makeClassNode(cls));
            }
        }
        
        return nodes.toArray(new ChooserNode[nodes.size()]);
    }

    private ChooserNode[] myChildren;
}
