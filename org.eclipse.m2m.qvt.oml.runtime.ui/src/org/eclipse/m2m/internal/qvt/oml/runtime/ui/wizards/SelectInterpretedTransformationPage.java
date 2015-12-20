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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData.ContentProvider;
import org.eclipse.m2m.internal.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.common.ui.controls.UniSelectTransformationControl;
import org.eclipse.m2m.internal.qvt.oml.common.ui.controls.UniSelectTransformationControl.ISelectionListener;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.ITransformationSelector;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.ITransformationMaker;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch.Messages;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

/**
 * @author sboyko
 */
public class SelectInterpretedTransformationPage extends WizardPage implements ITransformationSelector {

	public SelectInterpretedTransformationPage(String pageId, URI transfUri, List<TargetUriData> targetUris) {
        super(pageId);
        setDescription(org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.Messages.SelectWorkspaceTransformationPage_Description);
        
        myTransfUri = transfUri;
        myTargetUris = targetUris;
    }
	
	public void createControl(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout(1, true));
        doCreateControl(composite);
        setControl(composite);
        
        setPageComplete(validatePage().isOK());

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, MDAConstants.QVTO_TRANSFORMATION_CONTEXTID);
    }
    
    protected void doCreateControl(Composite parent) {
        ISelectionListener selectionListener = new UniSelectTransformationControl.SelectionListenerAdapter() {
        	
            public IStatus selectionChanged(URI uri) {
            	IStatus status = validatePage();
                setPageComplete(status.isOK());
                return status;
            }

			public boolean accept(URI uri) {
		        try {
		        	QvtTransformation transformation = TRANSFORMATION_MAKER.makeTransformation(uri);
		        	
		        	List<TransformationParameter> parameters = transformation.getParameters();
		        	for (int i = 0; i < parameters.size() && i < myTargetUris.size(); ++i) {
		        		ContentProvider contentProvider = myTargetUris.get(i).getContentProvider();
		        		if (contentProvider == null) {
		        			continue;
		        		}
		        		List<URI> targetMetamodels = contentProvider.getMetamodels();
		        		if (targetMetamodels.isEmpty()) {
		        			continue;
		        		}
		        		
		        		List<EPackage> paramMetamodels = parameters.get(i).getMetamodels();		        		
		        		for (int j = 0; j < targetMetamodels.size() && j < paramMetamodels.size(); ++j) {
		        			if (!targetMetamodels.get(j).toString().equals(paramMetamodels.get(j).getNsURI())) {
		        				return false;
		        			}
		        		}
		        	}
		        	
		        	return true;
		        }
		        catch (Exception e) {
		        }
	            return false;
			}
			
			@Override
			public TreeAction getTreeAction(URI uri) {
				if (myTransfUri == null) {
					return TreeAction.NONE;
				}
				if (myTransfUri.equals(uri)) {
					return TreeAction.SELECT;
				}
				return myTransfUri.toString().startsWith(uri.toString()) ? TreeAction.EXPAND : TreeAction.NONE;
			}
        };
        
        myControl = new UniSelectTransformationControl(parent, UniSelectTransformationControl.QVTO_FILE_FILTER,
        		QvtTransformationRegistry.getInstance(), TransformationRegistry.TRANSFORMATION_FILTER, selectionListener);
    }
    
	protected IStatus validatePage() {
        setMessage(null);
        setErrorMessage(null);
        myTransformation = null;
        
        QvtTransformation transformation;
        String transfName = null;
        try {
            URI uri = getSelectedUri();
            if (uri == null) {
            	return TransformationControls.makeStatus(IStatus.ERROR, Messages.QvtLauncherTab_NoTransformationModule);
            }
            
			transformation = TRANSFORMATION_MAKER.makeTransformation(uri);
            transfName = transformation.getModuleName();
        }
        catch (Exception e) {
            setErrorMessage(e.getMessage());
            return TransformationControls.makeStatus(IStatus.ERROR, e.getMessage());
        }

        setMessage(NLS.bind(Messages.QvtLauncherTab_TransformationSelected, transfName));
        myTransformation = transformation;
        return TransformationControls.makeStatus(IStatus.OK, NLS.bind(Messages.QvtLauncherTab_TransformationSelected, transfName));
    }
        
	public QvtTransformation getTransformation() {
		return myTransformation;
	}

    public void setSelectedTransformationId(String id) {
        myControl.selectTransformationByUri(id);
    }

	public String getSelectedTransformationId() {
		URI selectedUri = getSelectedUri();
		if (selectedUri == null) {
			return null;
		}
		return selectedUri.path();
	}
	
	@Override
	public void dispose() {
		super.dispose();
    	try {
			TRANSFORMATION_MAKER.cleanup();
		} catch (MdaException e) {
		}
	}
    
    private URI getSelectedUri() {
        return myControl != null ? myControl.getSelectedUri() : null;
    }
    
    private QvtTransformation myTransformation;
    private final ITransformationMaker TRANSFORMATION_MAKER = new ITransformationMaker.CachedTransformationMaker();

    private final URI myTransfUri;
    private final List<TargetUriData> myTargetUris;
    private UniSelectTransformationControl myControl;

}
