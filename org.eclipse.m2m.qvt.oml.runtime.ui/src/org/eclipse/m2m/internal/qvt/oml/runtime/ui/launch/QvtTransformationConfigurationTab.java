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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessageEx;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.ITransformationMaker;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtRuntimeUIPlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtTransformationConfigurationUI;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtTransformationConfigurationUI.PropertyChangeListener;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.ApplyTransformationData;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class QvtTransformationConfigurationTab extends AbstractLaunchConfigurationTab {

    public QvtTransformationConfigurationTab(ITransformationMaker transformationMaker) {
        myTransformationMaker = transformationMaker;
        myData = new ApplyTransformationData();
        myUI = new QvtTransformationConfigurationUI(myData, new ISetMessageEx() {
            public void setErrorMessage(String message) {
                QvtTransformationConfigurationTab.this.setErrorMessage(message);
                QvtTransformationConfigurationTab.this.getLaunchConfigurationDialog().updateMessage();
            }

            public void setMessage(String message) {
                QvtTransformationConfigurationTab.this.setMessage(message);
                QvtTransformationConfigurationTab.this.getLaunchConfigurationDialog().updateMessage();
            }

			public void setWarningMessage(String message) {
				if (!AbstractLaunchConfigurationTabCompatibility.setWarningMessage(QvtTransformationConfigurationTab.this, message)) {
					QvtTransformationConfigurationTab.this.setMessage(message);
				}
			
                QvtTransformationConfigurationTab.this.getLaunchConfigurationDialog().updateMessage();
			}
        });
        myUI.addPropertyChangeListener(new PropertyChangeListener() {
            public void changePerformed(QvtConfigurationProperty property) {
                updateLaunchConfigurationDialog();
            }
        });
    }
    
    public void createControl(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout(TransformationControls.GRID, false));
        
        myUI.createControl(composite);
        
        setControl(composite);
        Dialog.applyDialogFont(composite);
    }

	public void initializeFrom(ILaunchConfiguration configuration) {
        String fileName = ""; //$NON-NLS-1$
        try {
            fileName = configuration.getAttribute(IQvtLaunchConstants.MODULE, ""); //$NON-NLS-1$
        } catch (CoreException e) {
           QvtRuntimeUIPlugin.getDefault().getLog().log(MiscUtil.makeErrorStatus(e));
        }
        
        QvtTransformation qvtTransformation = null;
        try {
        	URI uri = EmfUtil.makeUri(fileName);
        	if (uri != null) {
        		qvtTransformation = myTransformationMaker.makeTransformation(uri);
        	}
		} catch (MdaException e) {
			QvtRuntimeUIPlugin.getDefault().getLog().log(MiscUtil.makeErrorStatus(e));
		}
        myData.setTransformation(qvtTransformation);
        
        Map<String, String> valueMap = Collections.<String, String>emptyMap();
        try {
            valueMap = configuration.getAttribute(IQvtLaunchConstants.CONFIGURATION_PROPERTIES, Collections.<String, String>emptyMap());
        } catch (CoreException e) {
            QvtRuntimeUIPlugin.getDefault().getLog().log(MiscUtil.makeErrorStatus(e));
        }
        myData.getConfiguration().clear();
        myData.getConfiguration().putAll(valueMap);
        
        myUI.loadValues();
    }

    public void performApply(ILaunchConfigurationWorkingCopy configuration) {
        myUI.performApply();
        Map<String, String> map = new HashMap<String, String>(myData.getConfiguration());
        configuration.setAttribute(IQvtLaunchConstants.CONFIGURATION_PROPERTIES, map);
   }

    public String getName() {
        return Messages.QvtTransformationConfigurationTab_Name;
    }
    
    @Override
    public boolean isValid(ILaunchConfiguration launchConfig) {
        myUI.validate();
        return myUI.isValid();
    }
    
    @Override
    public Image getImage() {
        return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_DEF_VIEW);
    }
    
    public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

    }

    private final ApplyTransformationData myData;
    private final QvtTransformationConfigurationUI myUI;
    private final ITransformationMaker myTransformationMaker;
}
