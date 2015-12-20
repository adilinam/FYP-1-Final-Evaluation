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
package org.eclipse.m2m.internal.qvt.oml.common.ui.launch;

import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.ChooserDialogAdapter;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.IChooser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class UriChooserListener extends SelectionAdapter {
    public UriChooserListener(Text uriText, IChooser chooser, Shell shell) {
        myUriText = uriText;
        myDialog = new ChooserDialogAdapter(shell, chooser);
    }
    
    @Override
	public void widgetSelected(SelectionEvent e) {
        myDialog.getChooser().setInitialSelection(myUriText.getText());
        if(myDialog.open() == Window.OK) {
            String uriString = myDialog.getChooser().getUriString();
            myUriText.setText(uriString);
        }
    }
    
    private final Text myUriText;
    private final ChooserDialogAdapter myDialog;
}
