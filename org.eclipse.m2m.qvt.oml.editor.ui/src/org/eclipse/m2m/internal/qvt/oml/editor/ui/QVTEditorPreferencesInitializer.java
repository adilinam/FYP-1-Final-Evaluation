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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.QVTColorManager;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.editors.text.EditorsUI;


public class QVTEditorPreferencesInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		EditorsUI.useAnnotationsPreferencePage(store);

		QVTColorManager manager = new QVTColorManager(store, null);
		manager.initializeDefaults();
		manager.dispose();

		store.setDefault(QvtEditor.MATCHING_BRACKETS, true);
		store.setDefault(QvtEditor.MATCHING_BRACKETS_COLOR, StringConverter.asString(new RGB(196, 196, 196)));
	}
}
