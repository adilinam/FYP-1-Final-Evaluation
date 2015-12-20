/*******************************************************************************
 * Copyright (c) 2009, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.service.prefs.BackingStoreException;


public class QVTColorsPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	private QVTColorsConfigurationBlock fConfigurationBlock;

	private OverlayPreferenceStore fOverlayStore;
	
	public QVTColorsPreferencePage() {
		setDescription();
		setPreferenceStore();
		fOverlayStore = new OverlayPreferenceStore(getPreferenceStore(), new OverlayPreferenceStore.OverlayKey[] {});
		fConfigurationBlock = createConfigurationBlock(fOverlayStore);
	}

	protected void setDescription() {
		setDescription("Synta&x"); //$NON-NLS-1$
	}

	@Override
	protected Label createDescriptionLabel(Composite parent) {
		return null;
	}

	protected void setPreferenceStore() {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	protected QVTColorsConfigurationBlock createConfigurationBlock(OverlayPreferenceStore overlayPreferenceStore) {
		return new QVTColorsConfigurationBlock(overlayPreferenceStore);
	}

	public void init(IWorkbench workbench) {
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
	}

	@Override
	protected Control createContents(Composite parent) {

		fOverlayStore.load();
		fOverlayStore.start();

		Control content = fConfigurationBlock.createControl(parent);

		initialize();

		Dialog.applyDialogFont(content);
		return content;
	}

	private void initialize() {
		fConfigurationBlock.initialize();
	}

	@Override
	public boolean performOk() {
		fOverlayStore.propagate();
		try {
			InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID).flush();			
		} catch (BackingStoreException e) {
			Activator.log(e);
		}
		
		return true;
	}

	@Override
	public void performDefaults() {

		fOverlayStore.loadDefaults();
		fConfigurationBlock.performDefaults();

		super.performDefaults();
	}

	@Override
	public void dispose() {
		fConfigurationBlock.dispose();

		if (fOverlayStore != null) {
			fOverlayStore.stop();
			fOverlayStore = null;
		}

		super.dispose();
	}
}
