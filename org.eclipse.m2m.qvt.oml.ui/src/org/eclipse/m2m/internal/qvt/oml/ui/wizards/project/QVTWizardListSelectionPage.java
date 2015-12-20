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
package org.eclipse.m2m.internal.qvt.oml.ui.wizards.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.jface.wizard.WizardSelectionPage;
import org.eclipse.m2m.internal.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.pde.ui.IPluginContentWizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IPluginContribution;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.WorkbenchActivityHelper;
import org.eclipse.ui.wizards.IWizardCategory;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.eclipse.ui.wizards.IWizardRegistry;


/**
 * This wizard page is provides a mechanism for selecting one of available
 * QVT Project element wizards applicable within QVT project which is used for further
 * navigation in the containing wizard. 
 */
class QVTWizardListSelectionPage extends WizardSelectionPage implements ISelectionChangedListener {	
	
	private static final String POINT_ID = "projectElementsWizards"; //$NON-NLS-1$
	private static final String REF_ID_ATTR = "refId"; //$NON-NLS-1$
	
	private TableViewer myWizardSelectionViewer;
	private Button myUseTransformation;
	private WizardElement myOldSelectedWizardElement;
	private Text myDescriptionText;
	private INewQVTElementDestinationWizardDelegate fDestinationProvider;

	
	QVTWizardListSelectionPage(INewQVTElementDestinationWizardDelegate destinationProvider) {
		super(QVTWizardListSelectionPage.class.getSimpleName());

		if(destinationProvider == null) {
			throw new IllegalArgumentException();
		}
		
		setTitle(Messages.WizardListSelectionPage_title);
		setDescription(getWizardListPageDescription()); 
		
		this.fDestinationProvider = destinationProvider;
	}

    @Override
    public boolean canFlipToNextPage() {
        if (myUseTransformation.getSelection() && getSelectedNode() == null) {
            return false;
        }
        if (validate() != null) {
            return false;
        }
        return super.canFlipToNextPage();
    } 
		
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.verticalSpacing = 10;
		container.setLayout(layout);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		createTransormationCheckBtn(container, 1);
		
		Label label = new Label(container, SWT.NONE);
		label.setText(Messages.WizardListSelectionPage_message);
		GridData gd = new GridData();
		label.setLayoutData(gd);
		
		SashForm sashForm = new SashForm(container, SWT.HORIZONTAL);
		gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 300;
		sashForm.setLayoutData(gd);
		
		myWizardSelectionViewer = new TableViewer(sashForm, SWT.BORDER);
		myWizardSelectionViewer.setContentProvider(new ArrayContentProvider());
		myWizardSelectionViewer.setLabelProvider(new LabelProvider() {
			@Override
			public Image getImage(Object element) {
				return ((WizardElement)element).image;
			}
			
			@Override
			public String getText(Object element) {
				WizardElement wizardElement = (WizardElement)element;
				IWizardCategory category = wizardElement.descriptor.getCategory();
				if(category == null) {
					return wizardElement.name;
				}
				return wizardElement.name;
			}
		});
		
		myWizardSelectionViewer.setComparator(new WizardComparator());
		
		myWizardSelectionViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				selectionChanged(new SelectionChangedEvent(myWizardSelectionViewer, myWizardSelectionViewer.getSelection()));				
				getContainer().showPage(getNextPage());
			}
		});
		
		this.myDescriptionText = new Text(sashForm, SWT.BORDER);
		GridData descGD = new GridData(GridData.FILL_BOTH);
		descGD.widthHint = 200;
		myDescriptionText.setLayoutData(descGD);		
		
		myWizardSelectionViewer.setInput(getAvailableTransformationWizards());
		myWizardSelectionViewer.addSelectionChangedListener(this);
		
		Dialog.applyDialogFont(container);
		setControl(container);
		
		setSelectionToViewer();
		updateControl();
        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, 
			"org.eclipse.m2m.qvt.oml.transformation_project"); //$NON-NLS-1$		
	}
	
    @Override
	public boolean isPageComplete() {
        setErrorMessage(validate());
        return !myUseTransformation.getSelection();
    }
    
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			myUseTransformation.setFocus();
		}
	}    
    				
	public void selectionChanged(SelectionChangedEvent event) {
		setErrorMessage(null);
		IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		WizardElement currentWizardSelection = null;
		Iterator<?> iter = selection.iterator();
		if (iter.hasNext())
			currentWizardSelection = (WizardElement) iter.next();
		if (currentWizardSelection == null) {
			myDescriptionText.setText(""); //$NON-NLS-1$
			setSelectedNode(null);
			return;
		}
		final WizardElement finalSelection = currentWizardSelection;
		setSelectedNode(new WizardNode(finalSelection));
		myDescriptionText.setText(finalSelection.description);
		getContainer().updateButtons();
	}	
	
	protected void createTransormationCheckBtn(Composite container, int span) {
		myUseTransformation = new Button(container, SWT.CHECK);
		myUseTransformation.setText(Messages.WizardListSelectionPage_label);
		GridData gd = new GridData();
		gd.horizontalSpan = span;
		myUseTransformation.setLayoutData(gd);
		myUseTransformation.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateControl();
			}
		});
		myUseTransformation.setSelection(false);
	}	
	
	protected IPluginContentWizard getSelectedWizard() {
		IWizardNode node = getSelectedNode();
		if (node != null)
			return (IPluginContentWizard)node.getWizard();
		return null;
	}	
	
	private void updateControl() {
		if (!myUseTransformation.getSelection()) {
			IStructuredSelection selection = (IStructuredSelection)myWizardSelectionViewer.getSelection();
			myOldSelectedWizardElement = (WizardElement)selection.getFirstElement();
		}
		setSelectionToViewer();
		myWizardSelectionViewer.getControl().setEnabled(myUseTransformation.getSelection());
		myDescriptionText.setEnabled(myUseTransformation.getSelection());	
		if (myUseTransformation.getSelection()) {
			myWizardSelectionViewer.getControl().forceFocus();
		}
	}	
	
	@SuppressWarnings("unchecked")
	private void setSelectionToViewer() {
		if (myUseTransformation.getSelection()) {
			List<WizardElement> input = (List<WizardElement>)myWizardSelectionViewer.getInput();			
			WizardElement welement = null; 
			if (myOldSelectedWizardElement != null) {
				welement = myOldSelectedWizardElement;
			} else if (!input.isEmpty()) {
				welement = input.get(0);
			}
			
			if (welement != null) {
				myWizardSelectionViewer.setSelection(new StructuredSelection(welement));
				setSelectedNode(new WizardNode(welement));

				myDescriptionText.setText(welement.description);
			}
		} else {
			myWizardSelectionViewer.setSelection(new StructuredSelection());
			setSelectedNode(null);
			myDescriptionText.setText(""); //$NON-NLS-1$
		}
	}		
		
	private List<WizardElement> getAvailableTransformationWizards() {
		
		IWizardRegistry wizardRegistry = PlatformUI.getWorkbench().getNewWizardRegistry();		
	
		List<WizardElement> wizards = new ArrayList<WizardElement>();
			
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(QVTUIPlugin.PLUGIN_ID, POINT_ID);
		if (point == null) {
			return wizards;
		}
		
		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			final IExtension nextExtension = extensions[i];

			IPluginContribution contribution = new IPluginContribution() {
				public String getLocalId() {				
					return nextExtension.getSimpleIdentifier();
				}
				public String getPluginId() {
					return nextExtension.getContributor().getName();
				}
			};
			
			if(WorkbenchActivityHelper.filterItem(contribution)) {
				continue;
			}
			
			IConfigurationElement[] elements = nextExtension.getConfigurationElements();			
			for (int j = 0; j < elements.length; j++) {
				IConfigurationElement element = elements[j];
				String refID = element.getAttribute(REF_ID_ATTR);

				if (refID != null) {
					IWizardDescriptor wizardDescriptor = wizardRegistry.findWizard(refID);
					if(wizardDescriptor != null) {
						wizards.add(new WizardElement(wizardDescriptor));
					}
				}
			}
		}

		return wizards;
	}	
	
    private String validate() {
        return null;
    }
    
	private static String getWizardListPageDescription() {
		return Messages.WizardListSelectionPage_desc;		
	}    
    	
	private static class WizardElement {
		Image image;
		String name;
		String description;
		IWizardDescriptor descriptor;
				
		WizardElement(IWizardDescriptor descriptor) {
			assert descriptor != null;

			this.name = descriptor.getLabel();
			this.description = descriptor.getDescription();
			if(descriptor.getImageDescriptor() != null) {
				this.image = descriptor.getImageDescriptor().createImage();				
			}
			
			this.descriptor = descriptor;
		}
						
		void dispose() {
			if(image != null) image.dispose();
		}
		
		IWizard createWizard() throws CoreException {
			return descriptor.createWizard();
		}
	}
	
	private class WizardNode implements IWizardNode {
		WizardElement myWizardElement;
		INewQVTProjectElementWizard myWizard;

		public WizardNode(WizardElement element) {
			assert element != null;
			myWizardElement = element;
		}
		
		public void dispose() {
			if (myWizardElement != null) {
				myWizardElement.dispose();	
			}
		}

		public Point getExtent() {
			return new Point(-1, -1);
		}

		public IWizard getWizard() {
			if (!myUseTransformation.getSelection()) {
				return null;
			}

			if (myWizard == null && getSelectedNode() != null) {
				try {
					IWizard wizard = myWizardElement.createWizard();
					if(wizard instanceof INewQVTProjectElementWizard) {
						myWizard = (INewQVTProjectElementWizard)wizard;
					}					
				} catch (CoreException e) {
					QVTUIPlugin.log(e);
				}
				
				if(myWizard == null) {
					return null;
				}

				myWizard.init(fDestinationProvider);
				myWizard.addPages();
			}
			
			return myWizard;
		}

		public boolean isContentCreated() {
			IWizard wizard = getWizard();
			return (wizard != null) ? ((INewQVTProjectElementWizard) getWizard()).isContentCreated() : false;
		}
	}
	
	private static class WizardComparator extends ViewerComparator {
		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			WizardElement w1 = (WizardElement)e1;
			WizardElement w2 = (WizardElement)e2;
			return safeName(w1).compareTo(safeName(w2));
		}
		
		static String safeName(WizardElement we) {
			return we.name != null ? we.name : ""; //$NON-NLS-1$
		}
	}
}
