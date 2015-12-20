/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.ui.IModelParameterInfo;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.IChooser;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author sboyko
 *
 */
public class UriGroupIn extends BaseUriGroup {
	
	public UriGroupIn(Composite parent, String name, ResourceSet validationRS) {
    	super(parent, SWT.NONE);
    	
		setLayout(new GridLayout(3, false));
        
		createLabel(name, 1);
		
		myValidationRS = validationRS;
		
        myUriText = TransformationControls.createText(this, 1);
        myUriText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				fireModified();
			}
        });
        
        myBrowseButton = TransformationControls.createButton(this, Messages.BrowseButtonLabel);
        myBrowseButton.setEnabled(false);
        myBrowseButton.addSelectionListener(new SelectionAdapter() {
            @Override
			public void widgetSelected(SelectionEvent e) {
                if (myActiveListener != null) {
                    myActiveListener.widgetSelected(e);
                }
            }
        });
    }
    
    public void initializeFrom(TargetUriData uriData) {
        myContentProvider = uriData.getContentProvider();
        myUriText.setText(uriData.getUriString());
    }

	public TargetUriData getUriData() {
		return new TargetUriData(getText(), myContentProvider);
	}
    
    public String getText() {
        return myUriText.getText();
    }
    
    public void update(String uri, Shell shell) {
        if(uri == null) {
            myUriText.setEnabled(false);
            myBrowseButton.setEnabled(false);
            myActiveListener = null;
        }
        else {
            IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(uri);
            if (handler == null) {
                throw new RuntimeException("No handler for URI " + uri); //$NON-NLS-1$
            }
            else {
                myActiveListener = new UriChooserListener(myUriText, getChooser(handler), shell);
                myUriText.setEnabled(myContentProvider == null);
                myBrowseButton.setEnabled(myContentProvider == null);
            }
        }
    }
    
    protected IChooser getChooser(IMetamodelHandler handler) {
    	return handler.getSourceAdaptableChooser(myValidationRS);
    }

	public void update(String moduleName, IModelParameterInfo paramInfo, Shell shell) {
		EClassifier classifier = paramInfo.getEntryParamType();
		if (classifier == null) {
			classifier = paramInfo.getMetamodel().eClass();
		}
		UriGroupIn.this.update(EmfUtil.getRootPackageUri(classifier), shell);
	}
    
    private final Text myUriText;
    private TargetUriData.ContentProvider myContentProvider;
    private final Button myBrowseButton;
    private SelectionListener myActiveListener;
    private final ResourceSet myValidationRS;

}
