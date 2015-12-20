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

package org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch;

import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.RefreshTab;

/**
 * @author sboyko
 *
 */
public class QvtBuilderLaunchConfigurationTabGroup extends QvtLaunchConfigurationTabGroup {

    @Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
        		new QvtBuilderLauncherTab(TRANSFORMATION_MAKER),
        		new QvtTransformationConfigurationTab(TRANSFORMATION_MAKER),
                //new ExternalToolsBuilderTab(false),                
                new CommonTab(),
                new RefreshTab(),
            };
        setTabs(tabs);
    }

}
