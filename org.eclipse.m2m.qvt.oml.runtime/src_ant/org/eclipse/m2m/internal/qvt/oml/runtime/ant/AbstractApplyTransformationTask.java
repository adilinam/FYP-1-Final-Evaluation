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
package org.eclipse.m2m.internal.qvt.oml.runtime.ant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegateBase;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.osgi.util.NLS;


/**
 * @author abreslav
 *
 *  Common ancestor for all apply QVT transformation tasks 
 *  
 *  NOTE: all the paths are workspace-relative
 */
public abstract class AbstractApplyTransformationTask extends Task {
	private static final String TAG_TRANSFORMATION = "transformation"; //$NON-NLS-1$
	private static final String TAG_TARGET_URI = "targeturi"; //$NON-NLS-1$


    /**
     *  A configuration property element - specifies a configuration property value 
     *  for the transformation 
     */
    public static class ConfigurationProperty {
        
        public ConfigurationProperty() {
        }
        
        public ConfigurationProperty(String name, String value) {
            this.name = name;
            this.value = value;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getValue() {
            return value;
        }
        
        public void setValue(String value) {
            this.value = value;
        }
        
        private String name;
        private String value;
    }
    
    /**
     *  A target URI element - specifies a target URI structure of the transformation's parameter 
     */
    public static class TargetUriDef {
        
        public TargetUriDef() {
        }
        
        public TargetUriDef(String targeturi, String targettype, String feature, String clearcontents) {
            this.targeturi = targeturi;
            this.targettype = targettype;
            this.feature = feature;
            this.clearcontents = clearcontents;
        }
        
        public String getTargetUri() {
            return targeturi;
        }
        
        public void setTargetUri(String targeturi) {
            this.targeturi = targeturi;
        }
        
        public String getTargetType() {
            return targettype;
        }
        
        public void setTargetType(String targettype) {
            this.targettype = targettype;
        }
        
        public String getFeature() {
            return feature;
        }
        
        public void setFeature(String feature) {
            this.feature = feature;
        }
        
        public String getClearContents() {
            return clearcontents;
        }
        
        public void setClearContents(String clearcontents) {
            this.clearcontents = clearcontents;
        }
        
        private String targeturi;
        private String targettype;
        private String feature;
        private String clearcontents;
    }
    
    /**
     * Throws an exception if the given object is null
     */
    public void checkAttribute(Object attr, String attrName) throws BuildException {
        if (attr == null) {
            throw new BuildException(
                    NLS.bind(
                            org.eclipse.m2m.internal.qvt.oml.runtime.ant.Messages.AbstractApplyTransformationTask_Required_attribute_is_not_specified,
                            attrName
                    )
            );
        }
    }
    
    /**
     * Checks up parameters validity and calls doExecute()
     */
    @Override
	public void execute() throws BuildException {

        checkAttribute(myTransformation, TAG_TRANSFORMATION);
        if (myTargetUris.isEmpty()) {
            throw new BuildException(
                    NLS.bind(
                            org.eclipse.m2m.internal.qvt.oml.runtime.ant.Messages.AbstractApplyTransformationTask_Required_attribute_is_not_specified,
                            TAG_TARGET_URI
                    )
            );
        }
        
        final List<TargetUriData> targetUris = new ArrayList<TargetUriData>(myTargetUris.size());
        for (TargetUriDef targetUriDef : myTargetUris) {
        	if (targetUriDef.targeturi == null) {
                throw new BuildException(
                        NLS.bind(
                                org.eclipse.m2m.internal.qvt.oml.runtime.ant.Messages.AbstractApplyTransformationTask_Required_attribute_is_not_specified,
                                TAG_TARGET_URI
                        )
                );
        	}
        	TargetType type = targetUriDef.targettype != null ? TargetType.valueOf(targetUriDef.targettype) : TargetType.NEW_MODEL;
        	String feature = targetUriDef.feature != null ? targetUriDef.feature : ""; //$NON-NLS-1$
        	boolean isClear = targetUriDef.clearcontents != null ? Boolean.valueOf(targetUriDef.clearcontents).booleanValue() : false;
        	targetUris.add(new TargetUriData(type, targetUriDef.targeturi, feature, isClear));
        }
        
        final List<URI> inUris = new ArrayList<URI>();
        final List<URI> outUris = new ArrayList<URI>();
        final QvtTransformation transformation = getTransformationObject();
        try {
            ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {
                public void run() throws Exception {
                	try {
	                	List<ModelContent> inObjects = new ArrayList<ModelContent>();
	                	List<TargetUriData> targetData = new ArrayList<TargetUriData>();
	                	
	            		Iterator<TargetUriData> itrTargetData = targetUris.iterator();
	            		for (TransformationParameter transfParam : transformation.getParameters()) {
	            			if (!itrTargetData.hasNext()) {
	            	            throw new BuildException(NLS.bind(org.eclipse.m2m.internal.qvt.oml.runtime.ant.Messages.AbstractApplyTransformationTask_Required_attribute_is_not_specified,
	            	            		transfParam.getName()));
	            			}
	            			TargetUriData nextUri = itrTargetData.next();
	            			if (transfParam.getDirectionKind() == DirectionKind.IN || transfParam.getDirectionKind() == DirectionKind.INOUT) {
	            		        URI inUri = resolveUri(nextUri.getUriString());
	            		        inUris.add(inUri);
	            		        ModelContent inModel = transformation.loadInput(inUri);
	            		        inObjects.add(inModel);
	            			}
	            			if (transfParam.getDirectionKind() == DirectionKind.OUT || transfParam.getDirectionKind() == DirectionKind.INOUT) {
	            				targetData.add(nextUri);
	            			}
	            		}
	
	            		List<URI> resultUris = QvtLaunchConfigurationDelegateBase.doLaunch(transformation, inObjects, targetData,
	            				getTraceFile(), QvtLaunchUtil.createContext(getConfiguration()));
	            		outUris.addAll(resultUris);
                	}
                	finally {
                		transformation.cleanup();
                	}
                }
            };
            
            r = QvtLaunchConfigurationDelegateBase.getSafeRunnable(transformation, r);
            
            r.run();
            
            if (getProject() != null && getResultUriProperty() != null) {
            	int index = 1;
            	for (URI uri : outUris) {
                    getProject().setProperty(getResultUriProperty() + index, uri == null ? "" : uri.toString()); //$NON-NLS-1$
            	}
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            throw new BuildException(StatusUtil.getExceptionMessages(e), e);
        }

        System.out.println(NLS.bind(
                org.eclipse.m2m.internal.qvt.oml.runtime.ant.Messages.AbstractApplyTransformationTask_Transformation_has_been_applied,
                new String[] {
                        getTransformation(),
                        inUris.toString(),
                        outUris.toString()
                    }
                )
        );   
    }    
    
    /**
     * @return a transformation to be executed
     */
    protected abstract QvtTransformation getTransformationObject();

    public boolean isTraceUsed() {
        return getTraceFile() != null;
    }
    
    public String getTransformation() {
        return myTransformation;
    }
    
    public void setTransformation(String transformation) {
        this.myTransformation = transformation;
    }
    
    public String getSourceUri() {
        return mySourceUri;
    }
    
    public void setSourceUri(String input) {
        this.mySourceUri = input;
    }
    
    public String getTargetUri() {
        return myTargetUri;
    }
    
    public void setTargetUri(String output) {
        this.myTargetUri = output;
    }
    
    public String getFeature() {
    	return myFeature;
    }
    
    public void setFeature(String feature) {
    	myFeature = feature;
    }
    
    public String getTargetType() {
    	return myTargetType;
    }
    
    public void setTargetType(String targetType) {
    	myTargetType = targetType;
    }
    
    public String getClearContents() {
    	return myClearContents;
    }
    
    public void setClearContents(String clearContents) {
    	myClearContents = clearContents;
    }
    
    public String getTraceFile() {
        return myTraceFile;
    }
    
    public void setTraceFile(String trace) {
        this.myTraceFile = trace;
    }
    
    public String getResultUriProperty() {
        return myResultUriProperty;
    }
    
    public void setResultUriProperty(String resultUriProperty) {
        myResultUriProperty = resultUriProperty;
    }
    
    public ConfigurationProperty createConfigurationProperty() {
        ConfigurationProperty configurationProperty = new ConfigurationProperty();
        myConfigurationProperties.add(configurationProperty);
        return configurationProperty;
    }
    
    public void addConfigurationProperty(ConfigurationProperty configurationProperty) {
        if (!myConfigurationProperties.contains(configurationProperty)) {
            myConfigurationProperties.add(configurationProperty);
        }
    }
    
    public void addConfiguredConfigurationProperty(ConfigurationProperty configurationProperty) {
        addConfigurationProperty(configurationProperty);
    }
    
    public TargetUriDef createTargetUriDef() {
    	TargetUriDef targetUriDef = new TargetUriDef();
        myTargetUris.add(targetUriDef);
        return targetUriDef;
    }
    
    public void addTargetUriDef(TargetUriDef targetUriDef) {
        if (!myTargetUris.contains(targetUriDef)) {
        	myTargetUris.add(targetUriDef);
        }
    }
    
    public void addConfiguredTargetUriDef(TargetUriDef targetUriDef) {
        addTargetUriDef(targetUriDef);
    }
    
    protected static IFile resolveFile(String path) throws BuildException {
        IFile file = WorkspaceUtils.getWorkspaceFile(path);
        if (file == null) {
            throw new BuildException(
                    NLS.bind(
                            org.eclipse.m2m.internal.qvt.oml.runtime.ant.Messages.AbstractApplyTransformationTask_File_not_found, 
                            path
                        )
                    );
        }
        return file; 
    }
    
    protected static URI resolveUri(String uriString) throws BuildException {
        try {
        	URI uri = URI.createURI(uriString);
        	if(uri == null) {
        		throw new BuildException(NLS.bind(org.eclipse.m2m.internal.qvt.oml.runtime.ant.Messages.AbstractApplyTransformationTask_File_not_found, uriString));
        	}
        	return uri;
        }
        catch(Exception e) {
        	throw new BuildException(e);
        }
    }
    
    protected Map<String, Object> getConfiguration() {
        Map<String, Object> props = new HashMap<String, Object>();
        for (ConfigurationProperty property : myConfigurationProperties) {
            props.put(property.getName(), property.getValue());
        }
        return Collections.unmodifiableMap(props);
    }
        
    private String myTransformation;
    private String mySourceUri;
    
    private String myTargetType;
    private String myTargetUri;
    private String myFeature;
    private String myClearContents;
    
    private String myTraceFile;
    
    private String myResultUriProperty;
    
    private final List<ConfigurationProperty> myConfigurationProperties = new ArrayList<ConfigurationProperty>();
    private final List<TargetUriDef> myTargetUris = new ArrayList<TargetUriDef>();
}
