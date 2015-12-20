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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.EmfUtilUiPlugin;

public class MetamodelHandlerManager {
    private MetamodelHandlerManager() {
        myHandlers = null;
    }
    
    public static MetamodelHandlerManager getInstance() {
        return ourInstance;
    }
    
    public IMetamodelHandler[] getHandlers() {
        Set<IMetamodelHandler> handlers = new LinkedHashSet<IMetamodelHandler>();
        
        if(myHandlers == null) {
            myHandlers = computeHandlers();
        }
        
        handlers.addAll(myHandlers.values());
        
        return handlers.toArray(new IMetamodelHandler[handlers.size()]);
    }
    
    public IMetamodelHandler getHandler(EClassifier cls) {
        String uri = EmfUtil.getRootPackage(cls.getEPackage()).getNsURI();
        return getHandler(uri);
    }
    
    public IMetamodelHandler getHandler(String uri) {
        if(myHandlers == null) {
            myHandlers = computeHandlers();
        }
        
        IMetamodelHandler handler = myHandlers.get(uri);
        if(handler == null) {
            handler = myHandlers.get("*"); //$NON-NLS-1$
            if(handler == null) {
                throw new RuntimeException("No default handler for " + POINT); //$NON-NLS-1$
            }
        }
        
        return handler;
    }

    private static Map<String, IMetamodelHandler> computeHandlers() {
    	String pluginId = EmfUtilUiPlugin.getDefault().getBundle().getSymbolicName();
        IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(pluginId, POINT);        
        if(elements.length == 0) {
            throw new RuntimeException("No extension for " + pluginId + "." + POINT); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        Map<String, IMetamodelHandler> handlers = new HashMap<String, IMetamodelHandler>();
        for(int j = 0; j < elements.length; j++) {
           try {
                Object instance = elements[j].createExecutableExtension("class"); //$NON-NLS-1$
                if(instance instanceof IMetamodelHandler == false) {
                    continue;
                }
                
                IMetamodelHandler handler = (IMetamodelHandler) instance;
                IConfigurationElement[] metamodels = elements[j].getChildren("package"); //$NON-NLS-1$
                for (int i = 0; i < metamodels.length; i++) {
					IConfigurationElement metamodel = metamodels[i];
					String uri = metamodel.getAttribute("uri"); //$NON-NLS-1$
					handlers.put(uri, handler);
				}
           }
           catch(Exception e) {
               Logger.getLogger().log(Logger.SEVERE, "Faile to instantiate metamodel handler for " + elements[j], e); //$NON-NLS-1$
           }
        }
        return handlers;
      }
    
    private Map<String, IMetamodelHandler> myHandlers;
    private static final MetamodelHandlerManager ourInstance = new MetamodelHandlerManager();

    private static final String POINT = "metamodelHandler"; //$NON-NLS-1$
}
