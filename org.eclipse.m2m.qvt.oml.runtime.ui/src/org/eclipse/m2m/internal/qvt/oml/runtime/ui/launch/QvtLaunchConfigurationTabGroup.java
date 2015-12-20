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
 *     Christopher Gerking - bug 428610
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.ITransformationMaker;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;


/** @author pkobiakov */
public class QvtLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {
	
	public QvtLaunchConfigurationTabGroup() {
		super();
	}
	
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
                new QvtLauncherTab(TRANSFORMATION_MAKER),
                new QvtTransformationConfigurationTab(TRANSFORMATION_MAKER),
                new CommonTab()
		};
		
		setTabs(tabs);
	}
	
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		final ILaunchConfiguration config = configuration;
		final ILaunchConfigurationTab[] tabs = getTabs();
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				for (int i = 0; i < tabs.length; i++) {
					tabs[i].initializeFrom(config);
				}
			}
		});
	}
	
	@Override
	public void dispose() {
		super.dispose();
    	try {
			TRANSFORMATION_MAKER.cleanup();
		} catch (MdaException e) {
		}
	}
	
    protected final ITransformationMaker TRANSFORMATION_MAKER = new ITransformationMaker.CachedTransformationMaker();
    
}
