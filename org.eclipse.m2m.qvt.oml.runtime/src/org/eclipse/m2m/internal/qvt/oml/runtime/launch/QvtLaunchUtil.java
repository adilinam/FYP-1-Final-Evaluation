/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;


public class QvtLaunchUtil {
	
	private QvtLaunchUtil() {}

	public static ILaunchConfigurationType getInMemoryLaunchConfigurationType() {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
        ILaunchConfigurationType type = manager.getLaunchConfigurationType(InMemoryQvtLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE_ID);
        if (type == null) {
            throw new RuntimeException("No launch configuration for id " + InMemoryQvtLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE_ID); //$NON-NLS-1$
        }
		return type;
	}
	
	public static List<TargetUriData> getTargetUris(ILaunchConfiguration configuration) throws CoreException {
    	int elemCount = configuration.getAttribute(IQvtLaunchConstants.ELEM_COUNT, 0);
		List<TargetUriData> targetUris = new ArrayList<TargetUriData>(elemCount);
    	for (int i = 0; i < elemCount; ++i) {
    		TargetUriData targetData = QvtLaunchUtil.getTargetUriData(configuration, i+1);
    		targetUris.add(targetData);
    	}
    	return targetUris;
	}
		
	public static String getTransformationURI(ILaunchConfiguration configuration) throws CoreException {
		return configuration.getAttribute(IQvtLaunchConstants.MODULE, (String) null);
	}
	
	public static String getTraceFileURI(ILaunchConfiguration configuration) throws CoreException {
		return configuration.getAttribute(IQvtLaunchConstants.TRACE_FILE, (String) null);
	}	
	
	public static boolean shouldGenerateTraceFile(ILaunchConfiguration configuration) throws CoreException {
		return configuration.getAttribute(IQvtLaunchConstants.USE_TRACE_FILE, false);
	}
	
	public static boolean isIncrementalUpdate(ILaunchConfiguration configuration) throws CoreException {
		return configuration.getAttribute(IQvtLaunchConstants.IS_INCREMENTAL_UPDATE, false);
	}
	
    public static TargetUriData getTargetUriData(ILaunchConfiguration configuration, int index) throws CoreException {
    	TargetUriData.TargetType targetType = TargetUriData.TargetType.NEW_MODEL;
    	try {
   	        targetType = TargetType.valueOf(configuration.getAttribute(getIndexedName(IQvtLaunchConstants.TARGET_TYPE, index), "NEW_MODEL")); //$NON-NLS-1$
    	}
    	catch (Exception e) {
    		targetType = TargetUriData.TargetType.NEW_MODEL;
    	}
    	
        String uri = configuration.getAttribute(getIndexedName(IQvtLaunchConstants.TARGET_MODEL, index), ""); //$NON-NLS-1$
    	String feature = configuration.getAttribute(getIndexedName(IQvtLaunchConstants.FEATURE_NAME, index), ""); //$NON-NLS-1$
    	boolean clearContents = configuration.getAttribute(getIndexedName(IQvtLaunchConstants.CLEAR_CONTENTS, index), true);
    	
    	TargetUriData.ContentProvider contentProvider = null;
		if (configuration.getAttributes() != null) {
			contentProvider = (TargetUriData.ContentProvider) configuration.getAttributes().get(getIndexedName(IQvtLaunchConstants.CONTENT_PROVIDER, index));
		}
    	
    	return new TargetUriData(targetType, uri, feature, clearContents, contentProvider);
    }
    
    public static void saveTargetUriData(ILaunchConfigurationWorkingCopy configuration, List<TargetUriData> targetData) {
        int index = 1;
        for (TargetUriData targetUri : targetData) {
    		QvtLaunchUtil.saveTargetUriData(configuration, targetUri, index);
    		++index;
        }
    }
    
    public static void saveTargetUriData(ILaunchConfigurationWorkingCopy configuration, TargetUriData targetData, int index) {
    	configuration.setAttribute(getIndexedName(IQvtLaunchConstants.TARGET_TYPE, index), targetData.getTargetType().toString()); 
		configuration.setAttribute(getIndexedName(IQvtLaunchConstants.TARGET_MODEL, index), targetData.getUriString()); 
    	configuration.setAttribute(getIndexedName(IQvtLaunchConstants.FEATURE_NAME, index), targetData.getFeature()); 
    	configuration.setAttribute(getIndexedName(IQvtLaunchConstants.CLEAR_CONTENTS, index), targetData.isClearContents()); 

		if (targetData.getContentProvider() != null) {
			try {
				Map<String, Object> attributes = new LinkedHashMap<String, Object>(configuration.getAttributes());
				attributes.put(getIndexedName(IQvtLaunchConstants.CONTENT_PROVIDER, index), targetData.getContentProvider());
				configuration.setAttributes(attributes);
			} catch (CoreException e) {
			}
		}
    }
    
    public static Map<String, Object> getConfigurationProperty(ILaunchConfiguration configuration) {
        return loadConfigurationProperties(configuration);
    }
    
    public static Context createContext(ILaunchConfiguration configuration) {
    	Map<String, Object> configProps = getConfigurationProperty(configuration);
    	return createContext(configProps);
    }

	public static Context createContext(Map<String, Object> configProps) {
		Context context = new Context();
		if (configProps != null) {
	    	for (String name : configProps.keySet()) {
				context.setConfigProperty(name, configProps.get(name));
			}
		}
        return context;
	}
    

    public static Map<String, Object> loadConfigurationProperties(ILaunchConfiguration configuration) {
        Map<String, Object> map;
        try {
			Map<String, String> configProps = configuration.getAttribute(IQvtLaunchConstants.CONFIGURATION_PROPERTIES, Collections.<String, String>emptyMap());
            map = new LinkedHashMap<String, Object>(configProps);
        } catch (CoreException e) {
            map = Collections.<String, Object>emptyMap();
            QvtRuntimePlugin.getDefault().getLog().log(MiscUtil.makeErrorStatus(e)); 
        }
        return map;
    }


    
    private static String getIndexedName(String name, int index){
    	if (index == 0) {
    		return name;
    	}
    	return name + index;
    }
    
}

