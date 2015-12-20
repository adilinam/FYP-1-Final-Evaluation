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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.actions;

import java.util.Arrays;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.m2m.internal.qvt.oml.common.ui.action.EObjectWindowActionDelegate;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.Messages;
import org.eclipse.m2m.qvt.oml.runtime.ui.wizards.TransformationWizardUtil;
import org.eclipse.osgi.util.NLS;

/**
 * @author sboyko
 */
public class RunInterpretedTransformationAction extends EObjectWindowActionDelegate {

	@Override
	protected void runImpl(IAction action) throws Exception {
		URI source = getSelectedEObject();
		
		if (source == null) {
			String title = Messages.RunInterpretedTransformationAction_title;
	        String message = Messages.RunInterpretedTransformationAction_message;
	        
			MessageDialog.openInformation(getShell(), title, NLS.bind(message, String.valueOf((Object)getSelectedElement())));
		} else {
			invokeWizard(source);
		}
	}
	
	/**
	 * Runs transformation wizard on source model
	 * @param source source can't be null
	 */
	protected void invokeWizard(URI source) {
		IWizard wizard = TransformationWizardUtil.createTransformationWizard(null, Arrays.asList(source));
		WizardDialog wizardDialog = new WizardDialog(getShell(), wizard);
		wizardDialog.open();
	}
	
}
