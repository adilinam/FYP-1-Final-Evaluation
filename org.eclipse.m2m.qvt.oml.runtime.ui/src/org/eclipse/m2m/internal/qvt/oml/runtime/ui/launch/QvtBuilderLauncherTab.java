/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch;

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtBuilderLaunchConfigurationDelegate;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.ITransformationMaker;

/**
 * @author sboyko
 *
 */
public class QvtBuilderLauncherTab extends QvtLauncherTab {

	public QvtBuilderLauncherTab(ITransformationMaker transformationMaker) {
		super(transformationMaker);
	}
	
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);

        setBuildTypes(configuration, new String[] {
        		QvtBuilderLaunchConfigurationDelegate.BUILD_TYPE_FULL,
        		QvtBuilderLaunchConfigurationDelegate.BUILD_TYPE_INCREMENTAL,
        		QvtBuilderLaunchConfigurationDelegate.BUILD_TYPE_AUTO,
        		QvtBuilderLaunchConfigurationDelegate.BUILD_TYPE_CLEAN,
        });

	}

    private void setBuildTypes(ILaunchConfigurationWorkingCopy configuration, String [] buildTypes) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < buildTypes.length; i++) {
            String buildType = buildTypes[i];
            if(s.length() > 0) {
                s.append(","); //$NON-NLS-1$
            }
            
            s.append(buildType);
        }
        
        configuration.setAttribute(QvtBuilderLaunchConfigurationDelegate.ATTR_RUN_BUILD_KINDS, s.toString());
    }
    
}
