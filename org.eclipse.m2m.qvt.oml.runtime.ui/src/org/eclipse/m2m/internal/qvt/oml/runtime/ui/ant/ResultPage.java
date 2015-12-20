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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class ResultPage extends AbstractCompositeWizardPage {

	protected ResultPage() {
		super("ResultPage"); //$NON-NLS-1$
	}

	@Override
	public void doCreateControl(Composite parent) {
		setTitle(Messages.ResultPage_title);
		setDescription(Messages.ResultPage_descr);

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);

		myTextField = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		myTextField.setEditable(false);
		myTextField.setLayoutData(data);
	}

	public void setTextData(String textData) {
		myTextField.setText(textData);
	}

	private Text myTextField;
}
