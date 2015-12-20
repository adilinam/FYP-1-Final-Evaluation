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
package org.eclipse.m2m.internal.qvt.oml.samples.wizards.launch;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;

public class QVTInterpreter implements ILaunchData{
	
	public final static String TARGET_TYPE_TEMPLATE = "{0}"; //$NON-NLS-1$
	public final static String MODULE_TEMPLATE = "/{0}/{1}"; //$NON-NLS-1$

	public QVTInterpreter(Data self, Data source, Data target) {
		mySource = source;
		myTarget = target;
		mySelf = self;
	}
	
	public void addParameter(String key, String value){
		if(key == null || value == null){
			throw new IllegalArgumentException();
		}
		myMap.put(key, value);
	}
	
	public Map<String, Object> getAttributesMap() {
		Map<String, Object> atrMap = new HashMap<String, Object>();
		atrMap.put(IQvtLaunchConstants.MODULE, mySelf.getURI());
		atrMap.put(IQvtLaunchConstants.CONFIGURATION_PROPERTIES, myMap);
		atrMap.put(IQvtLaunchConstants.ELEM_COUNT, 2);
		atrMap.put(IQvtLaunchConstants.TARGET_MODEL+"1", mySource.getURI()); //$NON-NLS-1$
		atrMap.put(IQvtLaunchConstants.TARGET_MODEL+"2", myTarget.getURI()); //$NON-NLS-1$
		return atrMap;
	}
	
	public String getTransformationType() {
		return TRANSFORMATION_TYPE;
	}
	
	private final Data mySelf;
	private final Data mySource;
	private final Data myTarget;
	
	private final Map<String, String> myMap = new HashMap<String, String>(); 
	
	private static final String TRANSFORMATION_TYPE = "org.eclipse.m2m.qvt.oml.QvtTransformation"; //$NON-NLS-1$
	
}
