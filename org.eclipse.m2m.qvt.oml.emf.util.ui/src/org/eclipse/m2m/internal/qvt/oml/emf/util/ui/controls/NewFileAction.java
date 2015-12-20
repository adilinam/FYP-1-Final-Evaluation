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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.controls;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;


public class NewFileAction extends Action {
    public NewFileAction(SelectFileControl control, IContainer container, String fileName) {
        myControl = control;
        myContainer = container;
        
        int lastDot = fileName.lastIndexOf("."); //$NON-NLS-1$
        if(lastDot == -1) {
            myBaseName = fileName;
            myExtension = ""; //$NON-NLS-1$
        }
        else {
            myBaseName = fileName.substring(0, lastDot);
            myExtension = lastDot < fileName.length() - 1 ? fileName.substring(lastDot+1) : ""; //$NON-NLS-1$
        }
    }
    

    @Override
	public void run() {
        IFile file = getFile();
        //file.create(new StringBufferInputStream(""), true, null); //$NON-NLS-1$
        myControl.addCreatedFile(file);
        myControl.getViewer().refresh();
        myControl.getViewer().editElement(file, 0);
    }
    
    private IFile getFile() {
        int idx = 0;
        for(; ;idx++) {
            StringBuffer fname = new StringBuffer();
            fname.append(myBaseName);
            if(idx > 0) {
                fname.append(""+idx); //$NON-NLS-1$
            }
            
            if(myExtension.length() > 0) {
                fname.append("." + myExtension); //$NON-NLS-1$
            }
            
            IPath path = new Path(fname.toString());
            IFile file = myContainer.getFile(path);
            if(!file.exists()) {
                return file;
            }
        }
    }

    private final SelectFileControl myControl;
    private final IContainer myContainer;
    private final String myBaseName;
    private final String myExtension;
}
