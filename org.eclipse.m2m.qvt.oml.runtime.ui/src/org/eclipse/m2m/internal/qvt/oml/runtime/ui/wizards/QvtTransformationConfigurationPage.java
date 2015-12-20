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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards;

import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtTransformationConfigurationUI;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtTransformationConfigurationUI.PropertyChangeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessageEx;
import org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.AbstractCompositeWizardPage;

/**
 * @author abreslav
 */
public class QvtTransformationConfigurationPage extends AbstractCompositeWizardPage {
	
    public QvtTransformationConfigurationPage(String pageName, ApplyTransformationData data) {
        super(pageName);
        
        myUI = new QvtTransformationConfigurationUI(data, new ISetMessageEx() {
            public void setErrorMessage(String message) {
                QvtTransformationConfigurationPage.this.setErrorMessage(message);
            }

            public void setMessage(String message) {
                QvtTransformationConfigurationPage.this.setMessage(message, WARNING);
            }

			public void setWarningMessage(String message) {
                QvtTransformationConfigurationPage.this.setMessage(message, WARNING);
			}
        });
        myUI.addPropertyChangeListener(new PropertyChangeListener() {
            public void changePerformed(QvtConfigurationProperty property) {
                myUI.performApply();
                myUI.validate();
            }
        });
    }

    @Override
    protected void doCreateControl(Composite parent) {
        myUI.createControl(parent);
        setPageComplete(true);
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            myUI.loadValues();
        }
        super.setVisible(visible);
    }

    private final QvtTransformationConfigurationUI myUI;
}
