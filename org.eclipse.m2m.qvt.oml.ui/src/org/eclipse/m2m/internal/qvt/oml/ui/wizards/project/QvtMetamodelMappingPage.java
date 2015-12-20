/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ui.wizards.project;

import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.WorkspaceMetamodelProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapPackage;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MappingContainer;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MetamodelURIMappingHelper;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping;
import org.eclipse.m2m.internal.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PropertyPage;
	
public class QvtMetamodelMappingPage extends PropertyPage {
	
	private TableViewer myTableViewer;
	
    private IProject myProject;

    private Button addButton;
    private Button removeButton;
    private Button editButton;
    private Button removeAllButton;    
    
    private MappingContainer uriMap;
    private Map<URIMapping, ProblemInfo> uriProblems;
    private IStatus status = Status.OK_STATUS;
        	
    
    public QvtMetamodelMappingPage() {
    	super();
	}
            
    @Override
	public boolean performOk() {
        performApply();
        return status.isOK();
    }

    @Override
	protected void performApply() {
    	if(uriMap != null) {
    		try {
    			status = Status.OK_STATUS;
    			Resource res = uriMap.eResource();
				res.save(null);
				
				
				doValidatePage();
			} catch (IOException e) {
				setErrorMessage(Messages.QvtMetamodelMappingPage_saveIOError);		
				status = new Status(IStatus.ERROR, QVTUIPlugin.PLUGIN_ID, getErrorMessage(), e);
				QVTUIPlugin.log(status);
				return;
			}
    	}
    	
    	if(myProject != null) {
    		try {
    			IFile mappingFile = MetamodelURIMappingHelper.getMappingFileHandle(myProject);
    			mappingFile.refreshLocal(IResource.DEPTH_ZERO, null);
			} catch (CoreException e) {
				QVTUIPlugin.log(e.getStatus());
			}
    	}
    }

    @Override
	protected void performDefaults() {
    	if(uriMap != null) {
    		load();    		
    	}
    }
    
    protected boolean doValidatePage() {
        setMessage(null);
        setErrorMessage(null);

        boolean valid = uriProblems == null || uriProblems.isEmpty();        
        if(!valid) {
        	setErrorMessage(Messages.QvtMetamodelMappingPage_invalidItemsInMappingTable);
        }
        return valid;
    }    
    
    @Override
	protected Control createContents(Composite parent) {
    	IProject project = getSelectedProject();
    	if(project == null) {
    		setValid(false);
    		setErrorMessage(Messages.QvtMetamodelMappingPage_no_QVT_projectSelected);
    		return new Composite(parent, SWT.BORDER);
    	}
    	
        Composite containerGroup = new Composite(parent, SWT.BORDER);
		GridLayout containerLayout = new GridLayout(1, true);
		containerLayout.marginHeight = containerLayout.marginWidth = 5;
		containerGroup.setLayout(containerLayout);
        
        int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION;
      
        myTableViewer = new TableViewer(containerGroup, style);

        GridData gridData = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
        myTableViewer.getControl().setLayoutData(gridData);
        
        myTableViewer.setContentProvider(new Contents());
        myTableViewer.setLabelProvider(new Labels());
        
        Table table = myTableViewer.getTable(); 
        TableLayout layout = new TableLayout();
        table.setLayout(layout);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        
        createColumn(table, layout, Messages.QvtMetamodelMappingPage_sourceURILabel);
        createColumn(table, layout, Messages.QvtMetamodelMappingPage_targetURILabel);        
        
        createButtons(containerGroup);

        myTableViewer.addSelectionChangedListener(
        	new ISelectionChangedListener() {
        		public void selectionChanged(SelectionChangedEvent event) {
        			boolean hasSelection = !event.getSelection().isEmpty();
        			
        			removeButton.setEnabled(hasSelection);
        			editButton.setEnabled(hasSelection);
        			
        			ProblemInfo problemInfo = getProblemInfo(getSelectedElement());        			
        			if(hasSelection && problemInfo != null && !problemInfo.isOK()) {
       					setErrorMessage(problemInfo.summaryMessage());
        			} else {
        				doValidatePage();
        			}
        		}
        	}
        );
        
        myTableViewer.getTable().addMouseTrackListener(new MouseTracker());

    	load();        
        return containerGroup;
    }
    
    private void createButtons(final Composite composite) {
		Composite buttonArea = new Composite(composite, SWT.NONE);
		buttonArea.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END | GridData.VERTICAL_ALIGN_CENTER));
		
		GridLayout layout = new GridLayout(4, true);
		layout.marginHeight = layout.marginWidth = 0;
	
		
		buttonArea.setLayout(layout);
		GridData data = new GridData(GridData.VERTICAL_ALIGN_END);
		buttonArea.setLayoutData(data);

		addButton = new Button(buttonArea, SWT.PUSH);
		addButton.setFont(composite.getFont());
		setButtonLayoutData(addButton);
		addButton.setText(Messages.QvtMetamodelMappingPage_addBtnLabel);
		addButton.addSelectionListener(new AddListener());
				
		editButton = new Button(buttonArea, SWT.PUSH);
		editButton.setEnabled(false);
		editButton.setFont(composite.getFont());
		editButton.setText(Messages.QvtMetamodelMappingPage_editBtnLabel);
		editButton.addSelectionListener(new EditListener());
		setButtonLayoutData(editButton);
		
		removeButton = new Button(buttonArea, SWT.PUSH);
		removeButton.setEnabled(false);
		removeButton.setFont(composite.getFont());
		removeButton.setText(Messages.QvtMetamodelMappingPage_removeBtnLabel);
		removeButton.addSelectionListener(new RemoveListener());
		setButtonLayoutData(removeButton);		
				
		removeAllButton = new Button(buttonArea, SWT.PUSH);		
		removeAllButton.setFont(composite.getFont());
		removeAllButton.setText(Messages.QvtMetamodelMappingPage_removeAllBtnLabel);
		removeAllButton.addSelectionListener(new RemoveAllListener());
		setButtonLayoutData(editButton);		
    }

    private IProject getSelectedProject() {
        Object element = getElement();
        if(element instanceof IProject) {
            return (IProject)element;
        } else if(element instanceof IJavaProject) {
            IJavaProject javaProject = (IJavaProject)element;
            return javaProject.getProject();
        } else {
            return null;
        }
    }
    
    private static EPackage loadEPackage(String uriStr) {    	
		try {
			return WorkspaceMetamodelProvider.loadResourceMetamodel(uriStr);
		} catch (RuntimeException exc) {
			// do nothing here
		}
		return null;
    }    
    
    private void createColumn(Table table, TableLayout layout, String name) {
        TableColumn nameColumn = new TableColumn(table, SWT.NONE);
        layout.addColumnData(new ColumnWeightData(3, true));
        nameColumn.setText(name);
    }    
        
    private void loadMappings() {
    	assert myTableViewer != null;
    	
    	// ensure mapping package gets into registry before loading
    	MModelURIMapPackage.eINSTANCE.getNsURI();

		Resource res = MetamodelURIMappingHelper.createMappingResource(getSelectedProject());
		try {
			status = Status.OK_STATUS;
			if(MetamodelURIMappingHelper.hasMappingResource(getSelectedProject())) {
				res.load(null);
			}
		} catch (IOException e) {
			setErrorMessage(Messages.QvtMetamodelMappingPage_loadIOError);			
			status = new Status(IStatus.ERROR, QVTUIPlugin.PLUGIN_ID, getErrorMessage(), e);
			QVTUIPlugin.log(status);
		}
		
		if(res.getContents().isEmpty()) {
			uriMap = MetamodelURIMappingHelper.createNewMappings(res);			
			if(!super.isValid()) {
				return;
			}
		} else {
			uriMap = MetamodelURIMappingHelper.getMappings(res);
			EObject root = res.getContents().get(0);
			if(root instanceof MappingContainer) {
				uriMap = (MappingContainer) root;
			}
		}

		this.uriProblems = null;
		if(status.isOK()) {
			int pos = 0;
			for (URIMapping nextMapping : uriMap.getMapping()) {
				IStatus sourceStatus = validateURI(nextMapping.getSourceURI(), Messages.QvtMetamodelMappingPage_sourceURILabel);
				IStatus targetStatus = validateTargetMappingURI(nextMapping.getTargetURI());

				if(sourceStatus.isOK()) {
					sourceStatus = getSourceUriAlreadyExistsStatus(nextMapping.getSourceURI(), pos++);
				}
				
				if(!sourceStatus.isOK() || !targetStatus.isOK()) {
					if(uriProblems == null) {
						uriProblems = new IdentityHashMap<URIMapping, ProblemInfo>();
					}
					
					uriProblems.put(nextMapping, new ProblemInfo(sourceStatus, targetStatus));
				}
			}
	
			doValidatePage();
		}	
    }
    
    private IStatus getSourceUriAlreadyExistsStatus(String uri, int upToIndex) {
    	if(uri != null && uriMap != null) {
    		int pos = 0;
    		for (URIMapping mapping : uriMap.getMapping()) {
    			if(upToIndex >= 0 && pos++ == upToIndex) break;
				if(uri.equals(mapping.getSourceURI())) {
					String message = Messages.QvtMetamodelMappingPage_URIAlreadyMapped;
					return new Status(IStatus.ERROR, QVTUIPlugin.PLUGIN_ID, NLS.bind(message, uri));
				}
			}
    	}
    	return Status.OK_STATUS;
    }
        
	private static IStatus validateURI(String uriStr, String uriLabel) {
		if(uriStr == null || uriStr.trim().length() == 0) {
			String message = NLS.bind(Messages.QvtMetamodelMappingPage_noURISpecified, uriLabel);
			return new Status(IStatus.ERROR, QVTUIPlugin.PLUGIN_ID, message);			
		}
		
		try {
			URI.createURI(uriStr);
		} catch (IllegalArgumentException e) {
			String message = NLS.bind(Messages.QvtMetamodelMappingPage_invalidModelURI, uriLabel);
			return new Status(IStatus.ERROR, QVTUIPlugin.PLUGIN_ID, message + ":" + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return Status.OK_STATUS;
	}
	
	private static IStatus validateTargetMappingURI(String uriStr) {
		IStatus status = validateURI(uriStr, Messages.QvtMetamodelMappingPage_targetURILabel);
		if(status.isOK()) {
			URI targetUri = URI.createURI(uriStr);			
			if(!targetUri.isPlatformResource()) {
				String message = NLS.bind(Messages.QvtMetamodelMappingPage_platformResourceURIexpected,
						Messages.QvtMetamodelMappingPage_targetURILabel);
				status = new Status(IStatus.ERROR, QVTUIPlugin.PLUGIN_ID, message);
			}
		}
		
		if(status.isOK()) {
			if(loadEPackage(uriStr) == null) {
				String message = NLS.bind(Messages.QvtMetamodelMappingPage_loadResourceMetamodelError, uriStr);				
		 		status = new Status(IStatus.ERROR, QVTUIPlugin.PLUGIN_ID, message);
			}
		}
		return status;
	}
	
    
    private class Labels extends LabelProvider implements ITableLabelProvider {    
    	
    	public String getColumnText(Object element, int columnIndex) {
    		if(element instanceof URIMapping) {
    			URIMapping mapping = (URIMapping) element;
    			return columnIndex == 0 ? mapping.getSourceURI() : mapping.getTargetURI();
    		}
    		
    		return null;
    	}
    	
    	public Image getColumnImage(Object element, int columnIndex) {
    		if (!(element instanceof URIMapping)) {
				return null;
			}
    		
    		URIMapping mapping = (URIMapping)element;
    		ProblemInfo problemInfo = getProblemInfo(mapping);
    		if(problemInfo != null && !problemInfo.isOK()) {
    			IStatus status = columnIndex == 0 ? problemInfo.sourceUriStatus : problemInfo.targetUriStatus;    			
    			String imageName = status.isOK() ? null : ISharedImages.IMG_OBJS_INFO_TSK;
    			
    			switch (status.getSeverity()) {
				case IStatus.ERROR:
					imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
					break;
				case IStatus.WARNING:
					imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
					break;
				}
    			
    			if(imageName != null) {
    				return PlatformUI.getWorkbench().getSharedImages().getImage(imageName);
    			}
    		}
    		
    		return null;
    	}
    }
    
    private static class Contents implements IStructuredContentProvider {    	
    	
    	public Object[] getElements(Object inputElement) {
    		if(inputElement instanceof MappingContainer) {
    			return ((MappingContainer)inputElement).getMapping().toArray();
    		}
    		
    		return new Object[0];
    	}
    	
    	public void dispose() {
    	}

    	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    	}
    }
    
    private void load() {
        myProject = getSelectedProject();
        if(myProject != null) {
        	loadMappings();
        	if(uriMap != null && myTableViewer != null) {
        		myTableViewer.setInput(uriMap);        	
        	}
        }
    }
    
    private ProblemInfo getProblemInfo(URIMapping mapping) {
    	return uriProblems != null ? uriProblems.get(mapping) : null;
    }
    
    private class MouseTracker implements MouseTrackListener {

    	public void mouseExit(MouseEvent e) {
			resetToolTip();     				
		}
		
		public void mouseEnter(MouseEvent e) {
			resetToolTip(); 
		}
		
		public void mouseHover(MouseEvent e) {
			TableItem item = myTableViewer.getTable().getItem(new Point(e.x, e.y));
			if(item != null) {
				ProblemInfo problemInfo = getProblemInfo((URIMapping)item.getData());
				if(problemInfo != null) {
					String tooltip = buildTooltipText(problemInfo);
					myTableViewer.getControl().setToolTipText(tooltip);
				}
			} else {
				resetToolTip();
			}
		}
		
		void resetToolTip() {
			myTableViewer.getControl().setToolTipText(null);
		}
		
		String buildTooltipText(ProblemInfo problemInfo) {
			StringBuilder buf = new StringBuilder();
			if(!problemInfo.sourceUriStatus.isOK()) {
				buf.append("<b>Source</b> URI:").append('\n'); //$NON-NLS-1$
				buf.append('-').append(problemInfo.sourceUriStatus.getMessage());
			}
			
			if(!problemInfo.targetUriStatus.isOK()) {
				if(buf.length() > 0) buf.append('\n');
				buf.append("Target URI:").append('\n'); //$NON-NLS-1$
				buf.append('-').append(problemInfo.targetUriStatus.getMessage());
			}
			
			return buf.toString();
		}
		
		
	}
    
    private URIMapping getSelectedElement() {
		ISelection sel = myTableViewer.getSelection();
		if(!sel.isEmpty()) {	
			return (URIMapping)((IStructuredSelection)sel).getFirstElement();
		}
		return null;
    }
    
    
    private class AddListener extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {			
			URIMappingDialog dlg = new URIMappingDialog(getShell());
			if(IDialogConstants.OK_ID == dlg.open()) {
				URIMapping mapping = dlg.data;
				if(mapping != null) {
					uriMap.getMapping().add(mapping);
					myTableViewer.add(mapping);
					doValidatePage();
				}
    		}
		}
	}
    
    private class RemoveListener extends SelectionAdapter {
    	@Override
		public void widgetSelected(SelectionEvent e) {    		
    		URIMapping mapping = getSelectedElement();
    		if(mapping != null) {
				myTableViewer.remove(mapping);
				if(uriProblems != null) {
					uriProblems.remove(mapping);
				}
				
				uriMap.getMapping().remove(mapping);
    		}
    		
    		doValidatePage();    		
		}
	}
    
    
    private class EditListener extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
    		URIMapping mapping = getSelectedElement();
    		if(mapping != null) {
				if(IDialogConstants.OK_ID == new URIMappingDialog(getShell(), mapping).open()) {
					if(uriProblems != null) uriProblems.remove(mapping);					
					myTableViewer.refresh();
					doValidatePage();					
				}
    		}
		}
	}
    
    private class RemoveAllListener extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			myTableViewer.setItemCount(0);
			uriMap.getMapping().clear();
			
			if(uriProblems != null) {
				uriProblems.clear();
			}
			
			doValidatePage();			
		}
	}    
    
    private static class ProblemInfo {
    	final IStatus sourceUriStatus;
    	final IStatus targetUriStatus;
    	
		ProblemInfo(IStatus sourceUriStatus, IStatus targetUriStatus) {
			if(sourceUriStatus == null || targetUriStatus == null) {
				throw new NullPointerException();
			}
			this.sourceUriStatus = sourceUriStatus;
			this.targetUriStatus = targetUriStatus;
		}
		
		boolean isOK() {
			return sourceUriStatus.isOK() && targetUriStatus.isOK();
		}
		
		String summaryMessage() {
			return targetUriStatus.isOK() ? sourceUriStatus.getMessage() : targetUriStatus.getMessage();
		}
    }
    
    private class URIMappingDialog extends StatusDialog {
    	private URIMapping data;
    	private Text modelURIText;
    	private Text targetURIText;
    	
		public URIMappingDialog(Shell parent) {
			this(parent, null);						
		}
		
		public URIMappingDialog(Shell parent, URIMapping mappingData) {
			super(parent);
			this.data = mappingData;
			
			String title = Messages.QvtMetamodelMappingPage_addNewMappingTitle;
			if(data != null) {
				title = Messages.QvtMetamodelMappingPage_editMappingTitle;
			} else {
				// Add new mode
				data = MModelURIMapFactory.eINSTANCE.createURIMapping();				
			}
			
			setTitle(title);
			setHelpAvailable(false);
			setStatusLineAboveButtons(true);			
		}
				
		@Override
		protected void buttonPressed(int buttonId) {
			if(buttonId == IDialogConstants.OK_ID) {
				data.setSourceURI(modelURIText.getText());
				data.setTargetURI(targetURIText.getText());				
			}
			super.buttonPressed(buttonId);			
		}
		
		@Override
		protected Control createContents(Composite parent) {
			// TODO Auto-generated method stub
			Control control = super.createContents(parent);
			updateStatus(getStatus());
			return control;
		}
		
		@Override
		protected Control createDialogArea(Composite parent) {
			Composite composite = (Composite)super.createDialogArea(parent);			
			createResourceURIControls(parent, 2);
			
			if(data.eContainer() == null) {
				// when adding new one, intially empty, take as invalid
				updateStatus(validateURI(modelURIText.getText(), Messages.QvtMetamodelMappingPage_sourceURILabel));				
				modelURIText.setFocus();
				targetURIText.setText("platform:/resource/*"); //$NON-NLS-1$				
			} else {
				modelURIText.setText(safeURIValue(data.getSourceURI()));
				targetURIText.setText(safeURIValue(data.getTargetURI()));
			}
														
			return composite;
		}
		
		protected void createResourceURIControls(Composite parent, int columnsPerLine) {
			Composite inner= new Composite(parent, SWT.NONE);
			GridLayout layout= new GridLayout();
			layout.marginHeight= 5;
			layout.marginWidth= 5;
			layout.numColumns= 4;
			inner.setLayout(layout);			
			
			Label sourceURILabel = new Label(inner, SWT.NONE);
			sourceURILabel.setText(Messages.QvtMetamodelMappingPage_sourceURILabel); 
			modelURIText = new Text(inner, SWT.BORDER);
			
			GridData gd = new GridData(GridData.FILL, GridData.CENTER, true, false);
			gd.widthHint = convertWidthInCharsToPixels(40);
			gd.horizontalSpan = 3;
			modelURIText.setLayoutData(gd);
			modelURIText.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					IStatus status = validateSourceURI();
					if(status.isOK()) {
						status = validateTargetMappingURI(targetURIText.getText());
					}
					updateStatus(status);
				}
			});		

			Label targetURILabel = new Label(inner, SWT.NONE);
			targetURILabel.setText(Messages.QvtMetamodelMappingPage_targetURILabel); 
			targetURIText = new Text(inner, SWT.BORDER);

			GridData gd2 = new GridData(GridData.FILL, GridData.CENTER, true, false);
			gd2.widthHint = convertWidthInCharsToPixels(40);
			gd2.horizontalSpan = 2;			
			targetURIText.setLayoutData(gd2);
			targetURIText.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					IStatus status = validateTargetMappingURI(targetURIText.getText());
					if(status.isOK()) {
						if(modelURIText.getText() == null || modelURIText.getText().length() == 0) {
							modelURIText.setText(loadEPackage(targetURIText.getText()).getNsURI());
						}
						status = validateSourceURI();
					}
					updateStatus(status);
				}
			});	
			
			
			Button browse = new Button(inner, SWT.PUSH);
			browse.setText(Messages.QvtMetamodelMappingPage_browseWorkspaceBtnLabel);
			
			GridData bgd = new GridData(GridData.END, GridData.CENTER, true, false);
			bgd.horizontalSpan = 1;			
			browse.setLayoutData(bgd);
			
			browse.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), null, null, false, null, null);
					
					if(files != null && files.length > 0) {
						URI uri = URI.createPlatformResourceURI(files[0].getFullPath().toString(), false);
						targetURIText.setText(uri.toString());
						// if source URI not defined yet, take it from the resource's EPackage
						String srcURI = modelURIText.getText();
						if(srcURI == null || srcURI.trim().length() == 0) {
							EPackage ePackage = loadEPackage(uri.toString());
							if(ePackage != null) {
								modelURIText.setText(ePackage.getNsURI());
							}
						}
					}
				}
			});		
		}		
		
		private IStatus validateSourceURI() {
			String uri = modelURIText.getText();
			IStatus status = validateURI(uri, Messages.QvtMetamodelMappingPage_sourceURILabel);
			if(status.isOK()) {
				status = getSourceUriAlreadyExistsStatus(uri, uriMap.getMapping().indexOf(data));
			}
			return status;
		}
		
		private String safeURIValue(String uriStr) {
			return uriStr != null ? uriStr : ""; //$NON-NLS-1$
		}
    }        
}
