/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.ant;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

abstract class AbstractCompositeWizardPage extends WizardPage {

	protected AbstractCompositeWizardPage(String pageName) {
		super(pageName);
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		setUpLayout(layout);
		composite.setLayout(layout);

		initializeDialogUnits(composite);

		doCreateControl(composite);

		setControl(composite);
		Dialog.applyDialogFont(parent);
	}

	protected abstract void doCreateControl(Composite parent);

	protected void setUpLayout(GridLayout layout) {
		layout.numColumns = 1;
	}

}
