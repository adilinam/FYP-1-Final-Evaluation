/*****************************************************************************
 * Copyright (c) 2014,2015 ASML Netherlands B.V. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  ASML Netherlands B.V. - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.tools.coverage.ui;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.m2m.qvt.oml.tools.coverage.ui.CoveragePlugin;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * The page for setting debugger preferences. Built on the 'field editor' infrastructure.
 */
public class QVTOCoveragePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    public QVTOCoveragePreferencePage() {
        super(FieldEditorPreferencePage.GRID);

        IPreferenceStore store = CoveragePlugin.getDefault().getPreferenceStore();
        setPreferenceStore(store);
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
    }

    @Override
    protected void createFieldEditors() {
        IntegerFieldEditor highThreshold = new IntegerFieldEditor(CoveragePlugin.HIGH_THRESHOLD_PREFERENCE,
                "&High coverage threshold:", getFieldEditorParent());
        highThreshold.setValidRange(0, 100);
        addField(highThreshold);

        IntegerFieldEditor lowThreshold = new IntegerFieldEditor(CoveragePlugin.LOW_THRESHOLD_PREFERENCE,
                "&Low coverage threshold:", getFieldEditorParent());
        lowThreshold.setValidRange(0, 100);
        addField(lowThreshold);
    }

    @Override
    public void init(IWorkbench workbench) {
    }

}
