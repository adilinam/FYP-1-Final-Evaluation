/*******************************************************************************
 * Copyright (c) 2009, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.ant;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegateBase;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;

/**
 * A model class for ant Task. toString renders task XML
 * 
 * @author abreslav
 * 
 */
public class TaskModel {

	public TaskModel(ILaunchConfiguration config, String name) throws CoreException {
		myTaskName = name;

        myModuleUri = config.getAttribute(IQvtLaunchConstants.MODULE, ""); //$NON-NLS-1$
        myTraceFile = config.getAttribute(IQvtLaunchConstants.TRACE_FILE, ""); //$NON-NLS-1$
        myIsUseTraceFile = config.getAttribute(IQvtLaunchConstants.USE_TRACE_FILE, false); 
        myIsIncrementalUpdate = config.getAttribute(IQvtLaunchConstants.IS_INCREMENTAL_UPDATE, false); 
    	myTargetUris = QvtLaunchUtil.getTargetUris(config);
    	myConfigProps = QvtLaunchUtil.getConfigurationProperty(config);
    	
    	myAttributes = new LinkedHashMap<String, Object>();
    	myAttributes.put(IQvtLaunchConstants.MODULE.substring(IQvtLaunchConstants.PREFIX.length()), myModuleUri);
    	myAttributes.put(IQvtLaunchConstants.TRACE_FILE.substring(IQvtLaunchConstants.PREFIX.length()), myTraceFile);

        myTransformation = new QvtInterpretedTransformation(QvtLaunchConfigurationDelegateBase.getQvtModule(config));
	}
	
	public String getTaskName() {
		return myTaskName;
	}
	
	public String getName() {
		try {
			return myTransformation.getModuleName();
		} catch (MdaException e) {
		}
		return ""; //$NON-NLS-1$
	}

	public Map<String, Object> getAttributes() {
		return Collections.unmodifiableMap(myAttributes);
	}

	@Override
	public String toString() {
		try {
			return toXMLString();
		} catch (MdaException e) {
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * @return Ant XML representation of the task
	 * @throws MdaException 
	 */
	public String toXMLString() throws MdaException {
		String result = ""; //$NON-NLS-1$

		result += "<" + myTaskName + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
		result += INDENT + "uri=\"" + myModuleUri + "\"\n";
		result += INDENT + ">\n";
		
		if (!myTargetUris.isEmpty()) {
			result += "\n";
		}
		Iterator<TargetUriData> itrTargetUri = myTargetUris.iterator();
		for (TransformationParameter transfParam : myTransformation.getParameters()) {
			if (!itrTargetUri.hasNext()) {
				break;
			}
			TargetUriData targetUri = itrTargetUri.next();
			
			if (transfParam.getDirectionKind() == DirectionKind.IN) {
				result += INDENT + "<in\n";
				result += INDENT + INDENT + "uri=\"" + targetUri.getUriString() + "\"\n";
				result += INDENT + "/>";
			}
			else if (transfParam.getDirectionKind() == DirectionKind.INOUT) {
				result += INDENT + "<inout\n";
				result += INDENT + INDENT + "uri=\"" + targetUri.getUriString() + "\"\n";
				result += INDENT + INDENT + "outuri=\"" + targetUri.getUriString() + "\"\n";
				result += INDENT + "/>";
			}
			else if (transfParam.getDirectionKind() == DirectionKind.OUT) {
				result += INDENT + "<out\n";
				result += INDENT + INDENT + "uri=\"" + targetUri.getUriString();
				String feature = targetUri.getFeature();
				if (feature != null && feature.trim().length() > 0) {
					result += "\">\n";
					result += INDENT + INDENT + "<feature\n";
					result += INDENT + INDENT + INDENT + "name=\"" + targetUri.getFeature() + "\"\n";
					result += INDENT + INDENT + INDENT + "clearcontents=\"" + Boolean.valueOf(targetUri.isClearContents()).toString() + "\"\n";
					result += INDENT + INDENT + "/>\n";
					result += INDENT + "</out>";
				}
				else {
					result += "\"\n";
					result += INDENT + "/>";
				}
			}
			result += "\n";
		}
		
		if ((myIsUseTraceFile || myIsIncrementalUpdate)
				&& myTraceFile != null && myTraceFile.trim().length() > 0) {
			result += "\n";
			result += INDENT + "<trace\n";
			result += INDENT + INDENT + "uri=\"" + myTraceFile + "\"\n";
			result += INDENT + INDENT + "generate=\"" + myIsUseTraceFile + "\"\n";
			result += INDENT + INDENT + "incrementalUpdate=\"" + myIsIncrementalUpdate + "\"\n";
			result += INDENT + "/>\n";
		}
		
		if (!myConfigProps.isEmpty()) {
			result += "\n";
			result += INDENT + "<configProperty\n";
		}
		for (Entry<String, Object> entry : myConfigProps.entrySet()) {
			Object value = entry.getValue();
			if (value != null && value.toString() != "") { //$NON-NLS-1$
				result += INDENT + INDENT + "name=\"" + entry.getKey() + "\"\n";
				result += INDENT + INDENT + "value=\"" + value + "\"\n"; //$NON-NLS-1$//$NON-NLS-2$
			}
		}
		if (!myConfigProps.isEmpty()) {
			result += INDENT + "/>\n";
		}
		
		result += "</" + myTaskName + ">\n"; //$NON-NLS-1$ //$NON-NLS-2$
		
		return result;
	}

	/**
	 * Indents a given string with given indent string. NOTE: The string must be
	 * separated with '\n' line delimiters
	 * 
	 * @param s -
	 *            a string to be indented
	 * @param indent -
	 *            an indent string to be added to the begining of the each line
	 *            in s
	 * @param delim -
	 *            line delimiter to separate resulting lines
	 * @return indented string
	 */
	public static String indentString(String s, String indent, String delim) {
		String result = ""; //$NON-NLS-1$
		String[] strings = s.split("\\n"); //$NON-NLS-1$
		for (int i = 0; i < strings.length; i++) {
			result += indent + strings[i] + ((i < strings.length - 1) ? delim : ""); //$NON-NLS-1$
		}
		return result;
	}
	
	private final String myTaskName;
	private final String myModuleUri;
	private final String myTraceFile;
	private final boolean myIsUseTraceFile;
	private final boolean myIsIncrementalUpdate;
	private final List<TargetUriData> myTargetUris;
	private final Map<String, Object> myConfigProps;
	private final QvtTransformation myTransformation;
	private final Map<String, Object> myAttributes;
	
	private static final String INDENT = "    "; //$NON-NLS-1$    

}
