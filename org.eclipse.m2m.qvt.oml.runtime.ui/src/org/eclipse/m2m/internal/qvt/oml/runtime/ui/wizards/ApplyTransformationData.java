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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;


public class ApplyTransformationData {
	
    public QvtTransformation getTransformation() {
        return myTransformation;
    }
    
    public ApplyTransformationData setTransformation(QvtTransformation transformation) {
        myTransformation = transformation;
        return this;
    }

    public String getTraceFile() {
        return myTraceFile != null ? myTraceFile : ""; //$NON-NLS-1$
    }
    
    public ApplyTransformationData setTraceFile(String traceFile) {
        myTraceFile = traceFile;
        return this;
    }

    public boolean isUseTraceFile() {
        return myUseTraceFile;
    }

    public void setUseTraceFile(boolean myUseTraceFile) {
        this.myUseTraceFile = myUseTraceFile;
    }
    
    public void setIncrementalUpdate(boolean flag) {
        myIsIncrementalUpdate = flag;
    }
    
    public boolean isIncrementalUpdate() {
        return myIsIncrementalUpdate;
    }

    public boolean isOpenResult() {
        return myIsOpenResult;
    }
    
    public ApplyTransformationData setOpenResult(boolean isOpenResult) {
        myIsOpenResult = isOpenResult;
        return this;
    }

    public Map<String, String> getConfiguration() {
        if (myConfiguration == null) {
            myConfiguration = new HashMap<String, String>();
        }
        return myConfiguration;
    }
    
    private QvtTransformation myTransformation;
    private String myTraceFile;
    private boolean myIsOpenResult;
    private boolean myUseTraceFile;
    private boolean myIsIncrementalUpdate;
    private Map<String, String> myConfiguration;
}
