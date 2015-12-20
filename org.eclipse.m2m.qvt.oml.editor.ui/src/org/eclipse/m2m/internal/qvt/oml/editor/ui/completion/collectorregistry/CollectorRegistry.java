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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectorregistry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionDelta;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.ui.IPluginContribution;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.ActivityManagerEvent;
import org.eclipse.ui.activities.IActivityManagerListener;
import org.eclipse.ui.activities.WorkbenchActivityHelper;

/**
 * @author aigdalov
 */

public final class CollectorRegistry {
    public static final String EXT_POINT_ID = "codeCompletionCollectors"; //$NON-NLS-1$
    
    public static final String ELEMENT_CATEGORY = "category"; //$NON-NLS-1$
    public static final String ATTRIBUTE_ID = "id"; //$NON-NLS-1$
    public static final String ATTRIBUTE_LABEL = "label"; //$NON-NLS-1$
    public static final String ATTRIBUTE_PRIORITY = "priority"; //$NON-NLS-1$
    
    public static final String ELEMENT_COLLECTOR = "collector"; //$NON-NLS-1$
    public static final String ATTRIBUTE_CLASS = "class"; //$NON-NLS-1$
    public static final String ATTRIBUTE_CATEGORY= "category"; //$NON-NLS-1$
    
    private static CategoryDescriptor[] ourCategories;
    private static Map<String, List<CollectorDescriptor>> ourCollectors;

    private static IRegistryChangeListener ourRegistryChangeListener = new IRegistryChangeListener() {
        public void registryChanged(IRegistryChangeEvent event) {
            IExtensionDelta[] extensionDeltas = event.getExtensionDeltas(Activator.PLUGIN_ID, EXT_POINT_ID);
            if (extensionDeltas.length != 0) {
                refresh();
            }
        }
    };
    
    private static IActivityManagerListener ourActivityChangeListener = new IActivityManagerListener() {
    	public void activityManagerChanged(ActivityManagerEvent event) {
    		if(event.haveEnabledActivityIdsChanged()) {
                refresh();
    		}
        }
    };
    
    
    static {
        refresh();
        Platform.getExtensionRegistry().addRegistryChangeListener(ourRegistryChangeListener, Activator.PLUGIN_ID);
        PlatformUI.getWorkbench().getActivitySupport().getActivityManager().addActivityManagerListener(ourActivityChangeListener);
    }
    
    public static CategoryDescriptor[] getCategories() {
		return ourCategories;
	}

	public static final List<CollectorDescriptor>  getCollectors(String categoryId) {
        return ourCollectors.get(categoryId);
    }

	private static CategoryDescriptor[] initCategories() {
        List<CategoryDescriptor> categories = new ArrayList<CategoryDescriptor>();
        IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(Activator.PLUGIN_ID, EXT_POINT_ID);
        for (IConfigurationElement configurationElement : configurationElements) {
        	if (ELEMENT_CATEGORY.equals(configurationElement.getName())) {
        		CategoryDescriptor categoryDescriptor = initCategory(configurationElement);
            	categories.add(categoryDescriptor);
        	}
        }
        Collections.sort(categories, new Comparator<CategoryDescriptor>() {
			public int compare(CategoryDescriptor o1, CategoryDescriptor o2) {
				return o1.getPriority() - o2.getPriority();
			}
        });
        return categories.toArray(new CategoryDescriptor[categories.size()]);
	}

    private static CategoryDescriptor initCategory(IConfigurationElement configurationElement) {
    	String id = configurationElement.getAttribute(ATTRIBUTE_ID);
    	String label = configurationElement.getAttribute(ATTRIBUTE_LABEL);
    	String strPriority = configurationElement.getAttribute(ATTRIBUTE_PRIORITY);
    	int priority = Integer.parseInt(strPriority);
    	return new CategoryDescriptor(id, label, priority);
    }

    private static Map<String, List<CollectorDescriptor>> initCollectors() {
    	Map<String, List<CollectorDescriptor>> result = new HashMap<String, List<CollectorDescriptor>>();
        IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(Activator.PLUGIN_ID, EXT_POINT_ID);
        for (IConfigurationElement configurationElement : configurationElements) {
        	if(isFiltered(configurationElement)) {
        		continue;
        	}
        	if (ELEMENT_COLLECTOR.equals(configurationElement.getName())) {
            	CollectorDescriptor collector = initCollector(configurationElement);
            	List<CollectorDescriptor> collectorsForCategory = result.get(collector.getCategoryDescriptor().getId()); 
            	if (collectorsForCategory == null) {
            		collectorsForCategory = new ArrayList<CollectorDescriptor>();
            		result.put(collector.getCategoryDescriptor().getId(), collectorsForCategory);
            	}
            	collectorsForCategory.add(collector);
        	}
        }
        return result;
    }

    private static CollectorDescriptor initCollector(IConfigurationElement configurationElement) {
    	String category = configurationElement.getAttribute(ATTRIBUTE_CATEGORY);
    	return new CollectorDescriptor(category, ATTRIBUTE_CLASS, configurationElement);
    }
    
    public static final void refresh() {
        ourCategories = initCategories();
        ourCollectors = initCollectors();
    }
    
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
}