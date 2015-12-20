/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.resourcesetprovider;

import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionDelta;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.common.CommonPlugin;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;

/**
 * @author aigdalov
 * Created on Feb 27, 2008
 */
public class ResourceSetProviderRegistry {
    public static final String EXT_POINT_ID = "resourceSetProviders"; //$NON-NLS-1$
    
    public static final String ELEMENT_PROVIDER = "provider"; //$NON-NLS-1$
    public static final String ATTRIBUTE_CLASS = "class"; //$NON-NLS-1$
    public static final String ATTRIBUTE_PRIORITY = "priority"; //$NON-NLS-1$
    
    private static TreeMap<Integer, IResourceSetProvider> ourProviders;

    private static IRegistryChangeListener ourRegistryChangeListener = new IRegistryChangeListener() {
        public void registryChanged(IRegistryChangeEvent event) {
            IExtensionDelta[] extensionDeltas = event.getExtensionDeltas(CommonPlugin.ID, EXT_POINT_ID);
            if (extensionDeltas.length != 0) {
                refresh();
            }
        }
    };

/*  
 * Commented out by [271896]: Eliminate UI dependencies from 'org.eclipse.m2m.qvt.oml.common' plugin
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=271896   
 * 
 * FIXME - needs a different solution anyway as this functionality should not be UI dependent
    private static IActivityManagerListener ourActivityChangeListener = new IActivityManagerListener() {
        public void activityManagerChanged(ActivityManagerEvent event) {
            if(event.haveEnabledActivityIdsChanged()) {
                refresh();
            }
        }
    };
    
    private static boolean isFiltered(IConfigurationElement configurationElement) {
        final IExtension extension = configurationElement.getDeclaringExtension();
        IPluginContribution contribution = new IPluginContribution() {
            public String getLocalId() {                
                return extension.getSimpleIdentifier();
            }
            public String getPluginId() {
                return extension.getContributor().getName();
            }
        };
        return WorkbenchActivityHelper.filterItem(contribution);
    }    
*/    
    static {
        refresh();
        Platform.getExtensionRegistry().addRegistryChangeListener(ourRegistryChangeListener, CommonPlugin.ID);
/*        if(PlatformUI.isWorkbenchRunning()) {
        	PlatformUI.getWorkbench().getActivitySupport().getActivityManager().addActivityManagerListener(ourActivityChangeListener);
        }
*/        
    }
    
    public static final ResourceSetResourceSetProviderPair getResourceSetResourceSetProviderPair(CFile script) {
        for (IResourceSetProvider provider : ourProviders.values()) {
            ResourceSet resourceSet = provider.getResourceSet(script);
            if (resourceSet != null) {
                return new ResourceSetResourceSetProviderPair(resourceSet, provider);
            }
        }
        return null;
    }

    private static TreeMap<Integer, IResourceSetProvider> initProviders() {
        TreeMap<Integer, IResourceSetProvider> result = new TreeMap<Integer, IResourceSetProvider>();
        IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(CommonPlugin.ID, EXT_POINT_ID);
        for (IConfigurationElement configurationElement : configurationElements) {
/*          if(isFiltered(configurationElement)) {
                continue;
            }
*/            
            if (ELEMENT_PROVIDER.equals(configurationElement.getName())) {
                try {
                    IResourceSetProvider provider = (IResourceSetProvider) configurationElement.createExecutableExtension(ATTRIBUTE_CLASS);
                    Integer priority = new Integer(configurationElement.getAttribute(ATTRIBUTE_PRIORITY));
                    result.put(priority, provider);
                } catch (CoreException ex) {
                    CommonPlugin.log(ex);
                }
            }
        }
        return result;
    }

    public static final void refresh() {
        ourProviders = initProviders();
    }
        
    public static class ResourceSetResourceSetProviderPair {
        private ResourceSet myResourceSet;
        private IResourceSetProvider myResourceSetProvider;
        
        public ResourceSetResourceSetProviderPair(ResourceSet resourceSet, IResourceSetProvider resourceSetProvider) {
            myResourceSet = resourceSet;
            myResourceSetProvider = resourceSetProvider;
        }

        public ResourceSet getResourceSet() {
            return myResourceSet;
        }

        public IResourceSetProvider getResourceSetProvider() {
            return myResourceSetProvider;
        }
    }
}