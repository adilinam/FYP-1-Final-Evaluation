/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.samples.wizards;

import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.samples.QVTSamplesPlugin;
import org.eclipse.m2m.internal.qvt.oml.samples.ui.SampleProject;
import org.eclipse.m2m.internal.qvt.oml.samples.wizards.launch.Data;
import org.eclipse.m2m.internal.qvt.oml.samples.wizards.launch.LaunchWizard;
import org.eclipse.m2m.internal.qvt.oml.samples.wizards.launch.QVTInterpreter;


public class Uml2RdbSampleProjectWizard extends LaunchWizard {
    public Uml2RdbSampleProjectWizard() {
        super(new SampleProject[]{
        				new SampleProject(Messages.Uml2RdbSampleProjectWizard_defaultProjectName,
        		                "$nl$/samples/simpleuml2rdb.zip", //$NON-NLS-1$
        		                QVTSamplesPlugin.ID,
        		                "Simpleuml_To_Rdb" + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT, //$NON-NLS-1$
        		                Messages.Uml2RdbSampleProjectWizard_Transfomarions_project)}); 
        
        Data self = new Data("/{0}/Simpleuml_To_Rdb" + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT, getProject(0)); //$NON-NLS-1$
        Data source = new Data("platform:/resource/{0}/pim.simpleuml#/", getProject(0)); //$NON-NLS-1$
		Data target = new Data("platform:/resource/{0}/Simpleuml_To_Rdb.rdb", getProject(0)); //$NON-NLS-1$
		
        setLaunchData(Messages.Uml2RdbSampleProjectWizard_defaultLaunchName, new QVTInterpreter(self, source, target));
        setWindowTitle(Messages.Uml2RdbSampleProjectWizard_simpleUml2rdbWizardTitle);
    }
}