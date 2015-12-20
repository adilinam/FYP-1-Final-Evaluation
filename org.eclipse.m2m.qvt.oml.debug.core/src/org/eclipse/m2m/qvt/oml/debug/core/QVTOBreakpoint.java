/*******************************************************************************
 * Copyright (c) 2009, 2013 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.LineBreakpoint;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.BreakpointData;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.NewBreakpointData;


public class QVTOBreakpoint extends LineBreakpoint {
	
	/**
	 * Family for breakpoint validation job (@see QVTOToggleBreakpointAdapter::toggleLineBreakpoints())
	 * @since 1.3
	 */
	public static final Object QVTO_BREAKPOINT_JOBFAMILY = new Object();

	protected static final String HIT_COUNT = QVTODebugCore.PLUGIN_ID + ".hitCount"; //$NON-NLS-1$
	
    protected static final int HIT_COUNT_UNDEFINED = -1;
    
    /**
     * Breakpoint attribute storing a breakpoint's conditional expression
     */
    protected static final String CONDITION = QVTODebugCore.PLUGIN_ID + ".condition"; //$NON-NLS-1$

    /**
     * Breakpoint attribute storing a breakpoint's condition enablement
     */
    protected static final String CONDITION_ENABLED = QVTODebugCore.PLUGIN_ID + ".conditionEnabled"; //$NON-NLS-1$

    /**
     * Breakpoint attribute storing a breakpoint's condition suspend policy
     */
    protected static final String CONDITION_SUSPEND_ON_TRUE = QVTODebugCore.PLUGIN_ID + ".conditionSuspendOnTrue"; //$NON-NLS-1$

    
    protected static final String TARGET_URI_ATTR = QVTODebugCore.PLUGIN_ID + ".unitUri"; //$NON-NLS-1$
    
    protected static final String RUN_TO_LINE = QVTODebugCore.PLUGIN_ID + ".runToLine"; //$NON-NLS-1$


    /* 
     * Remark: Keep the default constructor to allow the breakpoint manager to create breakpoint from markers
     */
    public QVTOBreakpoint() {
    	super();
    }

    public QVTOBreakpoint(final URI sourceURI, int lineNumber) throws CoreException {
    	this(sourceURI, lineNumber, false);
    }
    
    QVTOBreakpoint(final URI sourceURI, int lineNumber, final boolean isRunToLine) throws CoreException {        
        final IFile sourceFile = QVTODebugUtil.toFile(sourceURI);
        final IResource markerResource = (sourceFile != null && !isRunToLine) ? sourceFile : ResourcesPlugin.getWorkspace().getRoot();
        
        final Integer lineNum = new Integer(lineNumber);
        
        IWorkspaceRunnable wr = new IWorkspaceRunnable() {
            public void run(IProgressMonitor monitor) throws CoreException {
				// create the marker
                IMarker marker = markerResource.createMarker(QVTODebugCore.BREAKPOINT_MARKER_ID);
                setMarker(marker);
				
                // add attributes
                final Map<String, Object> attributes = new HashMap<String, Object>();
                
                if(isRunToLine) {
            		attributes.put(IBreakpoint.PERSISTED, Boolean.FALSE);		
            		attributes.put(QVTOBreakpoint.RUN_TO_LINE, Boolean.TRUE);                	
                }

                attributes.put(IBreakpoint.ENABLED, Boolean.TRUE);
				attributes.put(IMarker.LINE_NUMBER, lineNum);
                attributes.put(IBreakpoint.ID, getModelIdentifier());
                if(sourceFile == null || isRunToLine) {
                	attributes.put(TARGET_URI_ATTR, sourceURI.toString());
                }

                ensureMarker().setAttributes(attributes);
            }
        };
        
        run(getMarkerRule(markerResource), wr);
    }
    
    public static QVTOBreakpoint createRunToLineBreakpoint(URI sourceURI, int lineNumber) throws CoreException {
    	return new QVTOBreakpoint(sourceURI, lineNumber, true);
    }
    
    public static QVTOBreakpoint getBreakpointByID(long id) {
    	for (QVTOBreakpoint qvtBreakpoint : QVTODebugCore.getQVTOBreakpoints(QVTOBreakpoint.class)) {
			if(qvtBreakpoint.getID() == id) {
				return qvtBreakpoint;
			}
		}
    	
    	return null;
    }
    
    public long getID() {
    	return getMarker().getId();
    }

    public URI getUnitURI() throws CoreException {
    	IMarker marker = getMarker();    
    	IResource res = marker.getResource();
    	if(res.getType() == IResource.FILE) {
    		return QVTODebugUtil.getResourceURI(marker.getResource());
    	}
    			
    	String uriStr = marker.getAttribute(TARGET_URI_ATTR, null);
    	assert uriStr != null;
    	return URI.createURI(uriStr);
    }

    public NewBreakpointData createNewBreakpointData() throws CoreException {
		NewBreakpointData newBpData = new NewBreakpointData();
		newBpData.ID = getID();
		newBpData.line = getLineNumber();
		
		URI uri = getUnitURI();
		newBpData.targetURI = uri.toString();
		
    	setBreakpointData(newBpData);
    	return newBpData;
    }
    
    public BreakpointData createBreakpointData() throws CoreException {
    	BreakpointData bpData = new BreakpointData();
    	setBreakpointData(bpData);
    	return bpData;
    }
    
    public void setBreakpointData(BreakpointData bpData) throws CoreException {
    	bpData.condition = getCondition();
    	bpData.hitCount = getHitCount();
    	bpData.conditionEnabled = isConditionEnabled();
    	bpData.conditionSuspendOnTrue = isConditionSuspendOnTrue();
    }
    
    public String getModelIdentifier() {
        return QVTODebugCore.MODEL_ID;
    }

	/**
	 * Add this breakpoint to the breakpoint manager,
	 * or sets it as unregistered.
	 */    
    public void register(boolean register) throws CoreException {
        if (register) {
            DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(this);
        } else {
            setRegistered(false);
        }
    }

    public int getHitCount() throws CoreException {
        return ensureMarker().getAttribute(HIT_COUNT, HIT_COUNT_UNDEFINED);
    }

    public void setHitCount(int count) throws CoreException {   
        if (getHitCount() != count) {
            if (!isEnabled() && count > -1) {
				setAttributes(new String[] { ENABLED, HIT_COUNT },
						new Object[] { Boolean.TRUE, new Integer(count) });
            } else {
				setAttributes(new String[] { HIT_COUNT },
						new Object[] { new Integer(count) });
            }
        }
    }

    public boolean isLineToRunBreakpoint() {
    	return getMarker().getAttribute(QVTOBreakpoint.RUN_TO_LINE, false);
    }
        
    public boolean supportsCondition() {
        return true;
    }
    
    public String getCondition() throws CoreException {
        return ensureMarker().getAttribute(CONDITION, null);
    }

    public void setCondition(String condition) throws CoreException {
        if (condition != null && condition.trim().length() == 0) {
            condition = null;
        }
        setAttribute(CONDITION, condition);
    }
    
    public boolean isConditionEnabled() {
        return getMarker().getAttribute(CONDITION_ENABLED, false);
    }

    public void setConditionEnabled(boolean conditionEnabled) throws CoreException {
        setAttribute(CONDITION_ENABLED, Boolean.valueOf(conditionEnabled));
    }

    public boolean isConditionSuspendOnTrue() throws DebugException {
        return ensureMarker().getAttribute(CONDITION_SUSPEND_ON_TRUE, true);
    }

    public void setConditionSuspendOnTrue(boolean suspendOnTrue) throws CoreException {
        if (isConditionSuspendOnTrue() != suspendOnTrue) {
            setAttribute(CONDITION_SUSPEND_ON_TRUE, Boolean.valueOf(suspendOnTrue));
        }
    }

}