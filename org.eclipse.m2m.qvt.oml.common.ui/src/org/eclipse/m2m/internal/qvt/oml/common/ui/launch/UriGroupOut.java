/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.internal.qvt.oml.common.ui.IModelParameterInfo;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.IChooser;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.IDestinationChooser;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author sboyko
 *
 */
public class UriGroupOut extends BaseUriGroup {
	
	public UriGroupOut(Composite parent, String name, ResourceSet validationRS) {
		super(parent, SWT.NONE);
		
		myValidationRS = validationRS;
		myData = new TargetUriData(""); //$NON-NLS-1$
		myUpdating = false;
		
		setLayout(new GridLayout(3, false));
		
		{
			createLabel(name, 1);
			
			myUriText = TransformationControls.createText(this, 1);
			myUriText.addModifyListener(MODIFY_LISTENER);

			myUriButton = TransformationControls.createButton(this, Messages.TargetUriSelector_Browse);
			myUriButton.addSelectionListener(new SelectionAdapter(){
	            @Override
				public void widgetSelected(SelectionEvent e) {
	                if (myActiveListener != null) {
	                    myActiveListener.widgetSelected(e);
	                }
	            }
			});
		}
		
		{
			createLabel(Messages.TargetUriSelector_Feature, 1);
		
			myFeatureText = TransformationControls.createText(this, 1);
			myFeatureText.addModifyListener(MODIFY_LISTENER);
			
			myFeatureButton = TransformationControls.createButton(this, Messages.TargetUriSelector_Select);
			myFeatureButton.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					if (myObject == null) {
						TargetUriData oldData = new TargetUriData(myData);
						EObject oldObject = myObject;
						myObject = getEObject(oldData.getUriString(), oldObject);
					}
					if (myObject == null) {
						return;
					}

					EStructuralFeature feature = myObject.eClass().getEStructuralFeature(myData.getFeature());
					EReference initRef = feature instanceof EReference ? (EReference)feature : null;
					ReferenceSelectionDialog dialog = new ReferenceSelectionDialog(myObject.eClass(), initRef, getShell(), refFilter);
					if (dialog.open() == Window.OK) {
						EReference ref = dialog.getReference();
						myFeatureText.setText(ref.getName());
					}
					else {
						updateData();
					}
				}
			});
		}
		
		{
			createLabel("", 1); //$NON-NLS-1$

			myClearContentsCheckbox = new Button(this, SWT.CHECK);
			myClearContentsCheckbox.setText(Messages.TargetUriSelector_ClearContents);
			myClearContentsCheckbox.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					updateData();
				}
			});
			
			GridData gridData = new GridData();
			gridData.horizontalSpan = 1;
			myClearContentsCheckbox.setLayoutData(gridData);
		}
		
		initializeFrom(myData);
	}
	
	public void initializeFrom(TargetUriData targetData) {
		myUpdating = true;
		try {
			myContentProvider = targetData.getContentProvider();
			myUriText.setText(targetData.getUriString() == null ? "" : targetData.getUriString()); //$NON-NLS-1$
			myFeatureText.setText(targetData.getFeature() == null ? "" : targetData.getFeature()); //$NON-NLS-1$
			myClearContentsCheckbox.setSelection(targetData.isClearContents());
		}
		finally {
			myUpdating = false;
		}
		
		updateData();
	}
	
	public TargetUriData getUriData() {
		return new TargetUriData(
				myData.getFeature().trim().length() == 0 ? TargetType.NEW_MODEL : myData.getTargetType(),
				myData.getUriString(), myData.getFeature(), myData.isClearContents(), myContentProvider);
	}
	
    public String getText() {
        return myUriText.getText();
    }
    
	public void update(String uri, String baseName, String extension, Shell shell) {
        if (uri == null) {
        	myUriText.setEnabled(false);
        	myUriButton.setEnabled(false);
            myActiveListener = null;
        }
        else {
            IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(uri);
            if (handler == null) {
                throw new RuntimeException("No handler for URI " + uri); //$NON-NLS-1$
            }
            else {
                IChooser chooser = handler.getSourceDestChooser(myValidationRS);
                ((IDestinationChooser) chooser).initNewName(baseName, extension);
                
                myActiveListener = new UriChooserListener(myUriText, chooser, shell);
            	myUriText.setEnabled(myContentProvider == null);
            	myUriButton.setEnabled(myContentProvider == null);
            }
        }
    }
	
	private void updateData() {
		if (myUpdating) {
			return;
		}
		
		try {
	        URI destUri = EmfUtil.makeUri(getText());
			
			TargetType targetType = (destUri != null && EmfUtil.isUriExists(destUri, myValidationRS, true)) ? TargetType.EXISTING_CONTAINER : TargetType.NEW_MODEL;
			myData = new TargetUriData(targetType,
					myUriText.getText().trim(),
					myFeatureText.getText(),
					myClearContentsCheckbox.getSelection());
			
			switch(myData.getTargetType()) {
				case NEW_MODEL: { 
					myFeatureText.setEnabled(false);
					myFeatureButton.setEnabled(false);
					myClearContentsCheckbox.setEnabled(false);
					myUriText.setEnabled(myContentProvider == null);
					myUriButton.setEnabled(myContentProvider == null);
					break;
				}
				
				case EXISTING_CONTAINER: {
					myFeatureText.setEnabled(myContentProvider == null && myObject != null);
					myFeatureButton.setEnabled(myContentProvider == null);

					if (myObject != null) {
			        	EStructuralFeature feature = myObject.eClass().getEStructuralFeature(myFeatureText.getText());
						myClearContentsCheckbox.setEnabled(myContentProvider == null && feature instanceof EReference);
		        	}
		        	else {
		        		myClearContentsCheckbox.setEnabled(false);
		        	}
					break;
				}
				
				case INPLACE:
					myFeatureText.setEnabled(false);
					myFeatureButton.setEnabled(false);
	        		myClearContentsCheckbox.setEnabled(false);
	        		break;
			}
		}
		finally {
			fireModified();
		}
	}
	
	private EObject getEObject(String oldUri, EObject oldObject) {
		boolean sameUri = oldUri == null ? myData.getUriString() == null : oldUri.equals(myData.getUriString());
		EObject  obj;
		if (sameUri && oldObject != null) {
			obj = oldObject;
		}
		else {
			URI uri = null;
            try {
                uri = URI.createURI(myData.getUriString());
            } catch (IllegalArgumentException e) {                
            }
            
			if(uri == null) {
				return null;
			}
			
			try {
				ModelContent loadModel = EmfUtil.loadModel(uri, myValidationRS);
				obj = (loadModel != null && !loadModel.getContent().isEmpty() ? loadModel.getContent().get(0) : null);
			}
			catch(Exception e) {
				obj = null;
			}
		}
		
		return obj;
	}
	
	public void update(String moduleName, IModelParameterInfo paramInfo, Shell shell) {
		EClassifier classifier = paramInfo.getEntryParamType();
		if (classifier == null) {
			classifier = paramInfo.getMetamodel().eClass();
		}
        String extension = paramInfo.getMetamodel().getName();//EmfUtil.getExtensionForResult(classifier);
		UriGroupOut.this.update(EmfUtil.getRootPackageUri(classifier),
				moduleName, extension, shell);
		
		//final EClassifier paramType = classifier; 
		refFilter = new ReferenceSelectionDialog.IRefFilter() {
			public boolean accept(EReference ref) {
				return ref.isChangeable();// && EmfUtil.isAssignableFrom(ref.getEType(), paramType);
			}
		};
	}
    
	private TargetUriData myData;
	private TargetUriData.ContentProvider myContentProvider;
	private boolean myUpdating;
	private EObject myObject;
	private final ResourceSet myValidationRS;

	private final Text myUriText;
	private final Button myUriButton;
    private SelectionListener myActiveListener;
	private final Text myFeatureText;
	private final Button myFeatureButton;
	private final Button myClearContentsCheckbox;
	
	private final ModifyListener MODIFY_LISTENER = new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			updateData();
		}
	};

	private ReferenceSelectionDialog.IRefFilter refFilter = ReferenceSelectionDialog.IRefFilter.DEFAULT;

}
