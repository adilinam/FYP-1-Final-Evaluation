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

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

public class CreateQvtoAntTaskWizard extends Wizard {

	public CreateQvtoAntTaskWizard() {
		setWindowTitle(Messages.AntTaskWizard_windowTitle);
	}

	@Override
	public void addPages() {
		myChooseDataSourcePage = new ChooseDataSourcePage();
		addPage(myChooseDataSourcePage);
		myResultPage = new ResultPage();
		addPage(myResultPage);
		super.addPages();
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage result = super.getNextPage(page);
		if (result == myResultPage) {
			myResultPage.setTextData(getResText());
		}
		return result;
	}

	private String getResText() {
		TaskModel taskModel = myChooseDataSourcePage.getTaskModel();
		return taskModel == null ? "" : taskModel.toString(); //$NON-NLS-1$
	}

	@Override
	public boolean canFinish() {
		if (getContainer().getCurrentPage() == myResultPage) {
			return true;
		}
		if (getContainer().getCurrentPage() == myChooseDataSourcePage) {
			return myChooseDataSourcePage.canFlipToNextPage();
		}
		return false;
	}

	@Override
	public boolean performFinish() {
		myResultText = getResText();
		myResult = myChooseDataSourcePage.getTaskModel();
		return true;
	}

	public String getResultText() {
		return myResultText;
	}

	public TaskModel getResult() {
		return myResult;
	}

	private ChooseDataSourcePage myChooseDataSourcePage;
	private ResultPage myResultPage;
	private String myResultText;
	private TaskModel myResult;
}
