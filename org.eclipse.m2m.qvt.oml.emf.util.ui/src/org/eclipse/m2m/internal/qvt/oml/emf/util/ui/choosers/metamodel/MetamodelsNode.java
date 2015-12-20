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
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.EmfUtilUiPlugin;

public class MetamodelsNode extends ChooserNode {

	private MetamodelRegistry registry;
	
    public MetamodelsNode(IEPackageNodeFactory factory, MetamodelRegistry metamodelRegistry) {
        super(null);
        myFactory = factory;
        registry = metamodelRegistry;
    }

    @Override
	public boolean hasChildren() {
        return true;
    }

    @Override
	public ChooserNode[] getChildren() {
        if(myChildren == null) {
            myChildren = getRootPackageNodes();
        }
        
        return myChildren;
    }
    
    private EPackageNode[] getRootPackageNodes() {
        EPackage[] roots = getRootPackages();
        EPackageNode[] nodes = new EPackageNode[roots.length];
        for (int i = 0; i < roots.length; i++) {
            nodes[i] = myFactory.createNode(roots[i], this);
        }
        
        return nodes;
    }
    
    private EPackage[] getRootPackages() {
        List<EPackage> nodes = new ArrayList<EPackage>();
        String[] metamodelIds = registry.getMetamodelIds();
        for (int i = 0; i < metamodelIds.length; i++) {
            String metamodelId = metamodelIds[i];
            try {
                IMetamodelDesc desc = registry.getMetamodelDesc(metamodelId);
                EPackage descPackage = desc.getModel();
                if(descPackage.getESuperPackage() == null) {
                    nodes.add(descPackage);
                }
            } 
            catch (EmfException ignore) {
            	IStatus status = new Status(IStatus.ERROR, EmfUtilUiPlugin.ID, 
            			"Failed to get root EPackage:" + metamodelId, ignore); //$NON-NLS-1$
            	
            	EmfUtilUiPlugin.getDefault().getLog().log(status);
            }
        }
        
        return nodes.toArray(new EPackage[nodes.size()]);
    }

    private EPackageNode[] myChildren;
    
    private final IEPackageNodeFactory myFactory;
}
