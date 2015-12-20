/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.debug.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.qvt.oml.debug.core.QVTOBreakpoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;



public class QVTOLineBreakpointPage extends QVTOBreakpointPage {
    
    private Button fEnableConditionButton;
    private BreakpointConditionEditor fConditionEditor;
    private Button fConditionIsTrue;
    private Button fConditionHasChanged;
    private Label fSuspendWhenLabel;

    protected void doStore() throws CoreException {
        QVTOBreakpoint breakpoint= (QVTOBreakpoint) getBreakpoint();
        super.doStore();
        if (fConditionEditor != null) {
            boolean enableCondition = fEnableConditionButton.getSelection();
            String condition = fConditionEditor.getCondition();
            boolean suspendOnTrue= fConditionIsTrue.getSelection();
            if (breakpoint.isConditionEnabled() != enableCondition) {
                breakpoint.setConditionEnabled(enableCondition);
            }
            if (!condition.equals(breakpoint.getCondition())) {
                breakpoint.setCondition(condition);
            }
            if (breakpoint.isConditionSuspendOnTrue() != suspendOnTrue) {
                breakpoint.setConditionSuspendOnTrue(suspendOnTrue);
            }
        }
    }

    protected void createTypeSpecificLabels(Composite parent) {
        // Line number
        QVTOBreakpoint breakpoint = (QVTOBreakpoint) getBreakpoint();
        StringBuffer lineNumber = new StringBuffer(4);
        try {
            int lNumber = breakpoint.getLineNumber();
            if (lNumber > 0) {
                lineNumber.append(lNumber);
            }
        } catch (CoreException ce) {
            QVTODebugUIPlugin.log(ce);
        }
        if (lineNumber.length() > 0) {
            createLabel(parent, DebugUIMessages.QVTOLineBreakpointPage_LineNumber); 
            Text text = SWTFactory.createText(parent, SWT.READ_ONLY, 1, lineNumber.toString());
            text.setBackground(parent.getBackground());
        }
    }
    
    protected void createTypeSpecificEditors(Composite parent) throws CoreException {
        setTitle(DebugUIMessages.QVTOLineBreakpointPage_LineBreakpoint);
        QVTOBreakpoint breakpoint = (QVTOBreakpoint) getBreakpoint();
        if (breakpoint.supportsCondition()) {
            createConditionEditor(parent);
        }
    }

    /**
     * Creates the controls that allow the user to specify the breakpoint's
     * condition
     * @param parent the composite in which the condition editor should be created
     * @throws CoreException if an exception occurs accessing the breakpoint
     */
    private void createConditionEditor(Composite parent) throws CoreException {
        QVTOBreakpoint breakpoint = (QVTOBreakpoint) getBreakpoint();
        String label = DebugUIMessages.QVTOLineBreakpointPage_EnableCondition; 
        
        Composite conditionComposite = SWTFactory.createGroup(parent, EMPTY_STRING, 1, 1, GridData.FILL_BOTH);
        fEnableConditionButton = createCheckButton(conditionComposite, label);
        fEnableConditionButton.setSelection(breakpoint.isConditionEnabled());
        fEnableConditionButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                setConditionEnabled(fEnableConditionButton.getSelection());
            }
        });
        fConditionEditor = new BreakpointConditionEditor(conditionComposite, this); 
        fSuspendWhenLabel = createLabel(conditionComposite, DebugUIMessages.QVTOLineBreakpointPage_SuspendCondition); 
        fConditionIsTrue = createRadioButton(conditionComposite, DebugUIMessages.QVTOLineBreakpointPage_ConditionTrue); 
        fConditionHasChanged = createRadioButton(conditionComposite, DebugUIMessages.QVTOLineBreakpointPage_ConditionValueChange); 
        if (breakpoint.isConditionSuspendOnTrue()) {
            fConditionIsTrue.setSelection(true);
        } 
        else {
            fConditionHasChanged.setSelection(true);
        }
        setConditionEnabled(fEnableConditionButton.getSelection());
    }

    /**
     * Sets the enabled state of the condition editing controls.
     * @param enabled
     */
    private void setConditionEnabled(boolean enabled) {
        fConditionEditor.setEnabled(enabled);
        fSuspendWhenLabel.setEnabled(enabled);
        fConditionIsTrue.setEnabled(enabled);
        fConditionHasChanged.setEnabled(enabled);
    }
    
    public int convertHeightInCharsToPixels(int chars) {
        return super.convertHeightInCharsToPixels(chars);
    }
    
    public int convertWidthInCharsToPixels(int chars) {
        return super.convertWidthInCharsToPixels(chars);
    }

    public void dispose() {
        if (fConditionEditor != null) {
            fConditionEditor.dispose();
        }
        super.dispose();
    }
    
    public void createControl(Composite parent) {
        super.createControl(parent);
    }
}