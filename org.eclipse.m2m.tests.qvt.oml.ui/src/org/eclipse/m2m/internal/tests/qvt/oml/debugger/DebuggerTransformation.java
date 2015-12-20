/*******************************************************************************
 * Copyright (c) 2013, 2015 S.Boyko and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     S.Boyko - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.tests.qvt.oml.debugger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.Launch;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegate;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.qvt.oml.debug.core.launch.QVTODebugConfiguration;
import org.eclipse.m2m.qvt.oml.debug.core.srclookup.QVTOSourceLookupDirector;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.transform.TestTransformation;
import org.eclipse.swt.widgets.Display;


/**
 * A JUnit test class for QVTO Debugger launching
 * @author sboyko
 */
public class DebuggerTransformation extends TestTransformation {

	private ILaunchConfigurationWorkingCopy myLaunchConfigurationWorkingCopy;


    public DebuggerTransformation(ModelTestData data) {
    	super(data);
	}
	
    @Override
    protected void runTest() throws Throwable {
        checkTransformation(new TransformationChecker(new DebuggerTransformer()));
    }
	
    /**
     * Launches the debugger with a configuration set up by {@link #setTestData(String)}
     * @throws CoreException
     * @throws InterruptedException 
     */
    public void runDebugger() throws CoreException, InterruptedException {
		ILaunchConfiguration config = myLaunchConfigurationWorkingCopy.doSave();
		
		QVTODebugConfiguration debugConfig = new QVTODebugConfiguration();
		ILaunch launch = new Launch(config, ILaunchManager.DEBUG_MODE, new QVTOSourceLookupDirector());
		
		debugConfig.launch(config, ILaunchManager.DEBUG_MODE, launch, new NullProgressMonitor());

        while(!launch.isTerminated()) {
        	while (Display.getDefault().readAndDispatch()) {
        	}
        	Thread.sleep(10);
        }
    }

    
	private class DebuggerTransformer implements ITransformer {
		
		public List<URI> transform(IFile transformation, List<URI> inUris, URI traceUri, IContext qvtContext) throws Exception {
	        ILaunchConfigurationType type = DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurationType(QvtLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE_ID);
	        myLaunchConfigurationWorkingCopy = type.newInstance(null, "debugConfig"); //$NON-NLS-1$
	        
	        List<URI> resultUri = new ArrayList<URI>(2);
			
	        int index = 1;
	        for (URI uri : inUris) {
	    		IResource resource = URIUtils.getResource(uri);
	    		uri = URIUtils.getResourceURI(resource);
	        	QvtLaunchUtil.saveTargetUriData(myLaunchConfigurationWorkingCopy, new TargetUriData(TargetType.EXISTING_CONTAINER, uri.toString(), null, false), index);
	        	index++;
	        }
	        for (URI uri : getData().getExpected(getProject())) {
	    		IResource resource = URIUtils.getResource(uri);
	    		uri = URIUtils.getResourceURI(resource).appendFileExtension("ecore"); //$NON-NLS-1$
	        	resultUri.add(uri);
	        	QvtLaunchUtil.saveTargetUriData(myLaunchConfigurationWorkingCopy, new TargetUriData(TargetType.NEW_MODEL, uri.toString(), null, false), index);
	        	index++;
	        }
	        
	        myLaunchConfigurationWorkingCopy.setAttribute(IQvtLaunchConstants.TRACE_FILE, traceUri.toString());
			if (new ResourceSetImpl().getURIConverter().exists(traceUri, Collections.emptyMap())) {
		        myLaunchConfigurationWorkingCopy.setAttribute(IQvtLaunchConstants.IS_INCREMENTAL_UPDATE, true);
			}

	    	myLaunchConfigurationWorkingCopy.setAttribute(IQvtLaunchConstants.MODULE, URIUtils.getResourceURI(transformation).toString());
	        myLaunchConfigurationWorkingCopy.setAttribute(IQvtLaunchConstants.ELEM_COUNT, index-1);
	        
	        Map<String, String> configProps = new LinkedHashMap<String, String>();
	        for (Map.Entry<String, Object> e : qvtContext.getConfigProperties().entrySet()) {
	        	configProps.put(e.getKey(), e.getValue() == null ? null : String.valueOf(e.getValue()));
	        }
	        myLaunchConfigurationWorkingCopy.setAttribute(IQvtLaunchConstants.CONFIGURATION_PROPERTIES, configProps);
	        
	        runDebugger();
	        
	        return resultUri;
		}

	}

}
