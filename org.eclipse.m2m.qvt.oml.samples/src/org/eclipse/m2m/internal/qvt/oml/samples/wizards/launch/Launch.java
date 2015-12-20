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
package org.eclipse.m2m.internal.qvt.oml.samples.wizards.launch;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;

public class Launch {
	private String myLaunchName;
	private final ILaunchData myLaunchData;

	public Launch(String defaultLaunchName, ILaunchData launchData) {
		myLaunchName = defaultLaunchName;
		myLaunchData = launchData;
	}

	public String getLaunchName() {
		return myLaunchName;
	}

	public void setLaunchName(String newLaunchName) {
		myLaunchName = newLaunchName;
	}

	public void registerLaunchConfiguration(IContainer location)
			throws CoreException {
		String transformationType = myLaunchData.getTransformationType();
		String configName = DebugPlugin.getDefault().getLaunchManager().generateLaunchConfigurationName(getLaunchName());
		ILaunchConfigurationType launchType = DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurationType(transformationType);
		
		ILaunchConfigurationWorkingCopy store = launchType.newInstance(location, configName);
		
		Map<String, Object> attributesMap = myLaunchData.getAttributesMap();
		for (String atrKey : attributesMap.keySet()) {
			Object atrVal = attributesMap.get(atrKey);
			if(atrVal == null){
				throw new IllegalStateException(atrKey);
			}
			setAttribute(store, atrKey, atrVal);
		}
		
		ILaunchConfiguration launchConfig = store.doSave();
		DebugPlugin.getDefault().getLaunchManager()
			.addLaunch(new org.eclipse.debug.core.Launch(launchConfig, "debug", null)); //$NON-NLS-1$
	}

	private void setAttribute(ILaunchConfigurationWorkingCopy store, String atrKey, Object atrVal) {
		if (atrVal instanceof String) {
			String string = (String) atrVal;
			store.setAttribute(atrKey, string);
			return;
		}
		if (atrVal instanceof Map) {
			Map map = (Map) atrVal;
			store.setAttribute(atrKey, map);
			return;
		}
		if (atrVal instanceof Boolean) {
			Boolean bool = (Boolean) atrVal;
			store.setAttribute(atrKey, bool);
			return;
		}
		if (atrVal instanceof Integer) {
			Integer val = (Integer) atrVal;
			store.setAttribute(atrKey, val);
			return;
		}
		if (atrVal instanceof List) {
			List list = (List) atrVal;
			store.setAttribute(atrKey, list);
			return;
		}
		throw new IllegalArgumentException(atrVal.toString());
	}
}
