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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class ChooserDialogAdapter extends Dialog {
    public ChooserDialogAdapter(Shell shell, final IChooser chooser){
        super(shell);
        setShellStyle(getShellStyle() | SWT.RESIZE);        
        chooser.addChangeListener(new IChooser.IChangeListener() {
            public void changed() {
                Button button = getButton(IDialogConstants.OK_ID); 
                if(button != null && !button.isDisposed()) {
                    boolean enabled = chooser.getUriString() != null;
                    button.setEnabled(enabled);
                }            
            }
        });
        myChooser = chooser;
    }
    
    public IChooser getChooser(){
        return myChooser;
    }
    
    @Override
	protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(myChooser.getTitle());
    }
    
    @Override
	protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);        
        composite.setLayout(new GridLayout());
        Control control = myChooser.createControl(composite);
        control.setLayoutData(new GridData(GridData.FILL_BOTH));
        return control;
    }
    
    private IChooser myChooser; 
}
