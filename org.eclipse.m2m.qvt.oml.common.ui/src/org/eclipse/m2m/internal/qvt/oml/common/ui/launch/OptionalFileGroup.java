/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.ChooserDialogAdapter;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.ResourceDestinationChooser;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


public class OptionalFileGroup {
    public static interface IModifyListener {
        void modified();
    }
    
    public OptionalFileGroup(final Composite parent, String name) {
        myText = ""; //$NON-NLS-1$
        myModifyListeners = new ArrayList<IModifyListener>();
            
        myCheckBox = TransformationControls.createCheckBox(parent, name);
        myCheckBox.addSelectionListener(new SelectionAdapter() {
            @Override
			public void widgetSelected(SelectionEvent e) {
                setUseFileFlag(getUseFileFlag());
                //fireModifiedEvent();
            }
        });

        myTextControl = TransformationControls.createText(parent, TransformationControls.TEXT_GRID);
        myTextControl.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                myText = myTextControl.getText();
                fireModifiedEvent();
            }
        });
        
        myBrowse = TransformationControls.createButton(parent, Messages.BrowseButtonLabel);
        myChooser = new ResourceDestinationChooser();
        myBrowse.addSelectionListener(new SelectionAdapter() {
            @Override
			public void widgetSelected(SelectionEvent e) {
                ChooserDialogAdapter dialog = new ChooserDialogAdapter(parent.getShell(), myChooser);
                
                if(myTextControl.getCharCount() > 0) {
                    URI uri = URI.createURI(myTextControl.getText());
                    if(uri != null) {
                        dialog.getChooser().setInitialSelection(uri.toString());
                    }
                }
                
                if(dialog.open() == Window.OK) {
                    IPath path = myChooser.getPath();
                    if(path != null) {
                        setText(URI.createPlatformResourceURI(path.toOSString().toString(), false).toString());
                    }
                    else {
                        setText(""); //$NON-NLS-1$
                    }
                }
            }
        });
        setUseFileFlag(false);
    }
    
    public void addModifyListener(IModifyListener listener) {
        myModifyListeners.add(listener);
    }
    
    public void removeModifyListener(IModifyListener listener) {
        myModifyListeners.remove(listener);
    }
    
    private void fireModifiedEvent() {
        for (IModifyListener listener : myModifyListeners) {
            try {
                listener.modified();
            }
            catch(Exception e) {
            }
        }
    }
    
    public boolean getUseFileFlag() {
        return myCheckBox.getSelection();
    }
    
    public String getText() {
        return myText;
    }

    void setUseFileFlag(boolean flag) {
        myCheckBox.setSelection(flag);
        myBrowse.setEnabled(getUseFileFlag());
        myTextControl.setEnabled(getUseFileFlag());
        myTextControl.setText(myText);
    }
    
    public void setText(String text) {
        if (text == null) {
            text = ""; //$NON-NLS-1$
        }
        
        myTextControl.setText(myText = text);
        myTextControl.setSelection(myTextControl.getCharCount());
    }
    
    public void update(String baseName, String extension) {
        myChooser.initNewName(baseName, extension);
    }
    
    final Button myCheckBox;

    final Text myTextControl;
    String myText;
    
    final Button myBrowse;
    private final ResourceDestinationChooser myChooser;
    
    private List<IModifyListener> myModifyListeners;
}
