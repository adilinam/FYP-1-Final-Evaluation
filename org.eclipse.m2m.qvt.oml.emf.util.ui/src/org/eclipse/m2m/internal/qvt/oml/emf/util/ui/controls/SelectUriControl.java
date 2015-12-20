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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.controls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.provider.EmfModelContentProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.provider.EmfModelLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class SelectUriControl extends Composite {
    public static interface ISelectionListener {
        void selectionChanged(URI uri);
    }
    
    public SelectUriControl(Composite parentComposite, String defaultFileName, boolean isConsiderAdaptes, ResourceSet resourceSet) {
        super(parentComposite,SWT.NULL);
        mySelectionListeners = new ArrayList<ISelectionListener>();
        myDefaultFileName = defaultFileName;
        myIsConsiderAdaptes = isConsiderAdaptes;
        
        myResourceSet = resourceSet;
        
        setLayout(new GridLayout());
        
        myViewer = new TreeViewer(this, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        
        Label secondLabel = new Label(this, SWT.LEFT);
        secondLabel.setText(Messages.SelectFileControl_SelectedFile);
        
        myUriText = new Text(this, SWT.BORDER);
        myUriText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        myUriText.setEnabled(false);
        myUriText.addModifyListener(FNAME_LISTENER);
        
        myViewer.setContentProvider(CONTENT_PROVIDER);
        myViewer.setLabelProvider(LABEL_PROVIDER);
        myViewer.setAutoExpandLevel(DEFAUL_AUTO_EXPAND_LEVEL);
        myViewer.setSorter(VIEWER_SORTER);
        myViewer.addSelectionChangedListener(VIEWER_LISTENER);
        
        myViewer.setColumnProperties(new String[] {NAME_COLUMN});
        
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.FILL;
        data.grabExcessVerticalSpace = true;
        data.heightHint = 250;
        data.widthHint = 350;
        myViewer.getControl().setLayoutData(data);

        IResource root = ResourcesPlugin.getWorkspace().getRoot();
        myViewer.setInput(root);
    }
    
    public void addSelectionListener(ISelectionListener listener) {
        mySelectionListeners.add(listener);
    }
    
    public void removeSelectionListener(ISelectionListener listener) {
        mySelectionListeners.remove(listener);
    }
    
    public void setSelection(ISelection selection) {
        myViewer.setSelection(selection);
    }
    
    private void fireSelectionChanged(URI uri) {
        for (Iterator<ISelectionListener> it = new ArrayList<ISelectionListener>(mySelectionListeners).iterator(); it.hasNext();) {
            ISelectionListener listener = it.next();
            try {
                listener.selectionChanged(uri);
            }
            catch(Exception e) {
            }
        }
    }
    
    public URI getSelectedUri() {
        return myUri;
    }
    
    public TreeViewer getViewer() {
    	return myViewer;
    }
    
    private Object getAdapterSafe(Object adaptable, Class<?> adapterType) {
    	if (adaptable == null || !myIsConsiderAdaptes) {
    		return null;
    	}
		return org.eclipse.core.runtime.Platform.getAdapterManager().getAdapter(adaptable, adapterType);
    }
    
    private final TreeViewer myViewer;
    private final Text myUriText;
    private URI myUri;
    private Object myResource;
    private final String myDefaultFileName;
    private final boolean myIsConsiderAdaptes;
    
    private final List<ISelectionListener> mySelectionListeners;
    
    private final ResourceSet myResourceSet;
    
    private static final int DEFAUL_AUTO_EXPAND_LEVEL = 0;
    private static final String NAME_COLUMN = "name"; //$NON-NLS-1$
    
    private ITreeContentProvider CONTENT_PROVIDER = new ITreeContentProvider () {
    	private final ITreeContentProvider myWorkbenchProvider = new WorkbenchContentProvider();
		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof IFile) {
				IFile file = (IFile)parentElement;
				List<EmfModelContentProvider.Node> children = new ArrayList<EmfModelContentProvider.Node>();
				try {
					ModelContent res = EmfUtil.loadModel(URI.createPlatformResourceURI(file.getFullPath().toString(), false), myResourceSet);
					for(EObject obj : res.getContent()) {
						children.add(new EmfModelContentProvider.EObjectNode(obj, file));
					}
					
				}
				catch(RuntimeException ignore) {
				}
				
				return children.toArray();
			}
			else if(parentElement instanceof EmfModelContentProvider.Node) {
				return ((EmfModelContentProvider.Node)parentElement).getChildren();
			}
			else {
				return myWorkbenchProvider.getChildren(parentElement);
			}
		}

		public Object getParent(Object element) {
			if(element instanceof EmfModelContentProvider.Node) {
				return ((EmfModelContentProvider.Node)element).getParent();
			}
			else {
				return myWorkbenchProvider.getParent(element);
			}
		}

		public boolean hasChildren(Object element) {
			if(element instanceof IFile) {
				return true;
			}
			else if(element instanceof EmfModelContentProvider.Node) {
				return ((EmfModelContentProvider.Node)element).hasChildren();
			}
			else {
				return myWorkbenchProvider.hasChildren(element);
			}
		}

		public Object[] getElements(Object inputElement) {
			Object[] elements = myWorkbenchProvider.getElements(inputElement);
			
			Object[] clonedElems = new Object[elements.length];
			for (int  i = 0; i < elements.length; ++i) {
				EObject eObject = (EObject) getAdapterSafe(elements[i], EObject.class);
	            if (eObject != null) {
	            	clonedElems[i] = new EmfModelContentProvider.EObjectNode(eObject, null);
	            }
	            else {
	            	clonedElems[i] = elements[i];
	            }
			}
			return clonedElems;
		}

		public void dispose() {
			myWorkbenchProvider.dispose();
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			myWorkbenchProvider.inputChanged(viewer, oldInput, newInput);
		}
		
    };
    
    private ILabelProvider LABEL_PROVIDER = new LabelProvider() {
    	private final ILabelProvider myWorkbenchLabelProvider = new WorkbenchLabelProvider();
    	private final ILabelProvider myEmfModelLabelProvider = new EmfModelLabelProvider();
    	private final ILabelProvider myEObjectLabelProvider = new AdapterFactoryLabelProvider(
        		new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
    	
    	@Override
		public String getText(Object element) {
    		if(element instanceof EmfModelContentProvider.Node) {
    			return myEmfModelLabelProvider.getText(element);
    		}
    		else {
				EObject eObject = (EObject) getAdapterSafe(element, EObject.class);
	            if (eObject != null) {
	            	return myEObjectLabelProvider.getText(eObject);
	            }
            	return myWorkbenchLabelProvider.getText(element);
    		}
    	};
    	
    	@Override
		public Image getImage(Object element) {
    		if(element instanceof EmfModelContentProvider.Node) {
    			return myEmfModelLabelProvider.getImage(element);
    		}
    		else {
				EObject eObject = (EObject) getAdapterSafe(element, EObject.class);
	            if (eObject != null) {
	            	return myEObjectLabelProvider.getImage(eObject);
	            }
            	return myWorkbenchLabelProvider.getImage(element);
    		}
    	}
    };
    
    private static final ViewerSorter VIEWER_SORTER = new ViewerSorter() {
        @Override
		public int compare(Viewer viewer, Object e1, Object e2) {
            boolean folderLeft = (e1 instanceof IContainer);
            boolean folderRight = (e2 instanceof IContainer);
            if (folderLeft == folderRight) {
                return super.compare(viewer, e1, e2);
            }
            return folderLeft ? -1 : 1;
        }
    };
    
    private final ISelectionChangedListener VIEWER_LISTENER = new ISelectionChangedListener() {
        public void selectionChanged(SelectionChangedEvent event) {
            ISelection selection = event.getSelection();
            URI uri;
            if(selection instanceof IStructuredSelection == false) {
            	uri = null;
            }
            else {
            	Object selected = ((IStructuredSelection)selection).getFirstElement();
            	if (selected instanceof IFile) {
            		IFile file = (IFile)selected;
            		uri = URI.createPlatformResourceURI(file.getFullPath().toString(), false);
            	}
            	else if(selected instanceof EmfModelContentProvider.EObjectNode) {
            		EObject obj = ((EmfModelContentProvider.EObjectNode)selected).getObject();
            		uri = EcoreUtil.getURI(obj);
            	}
            	else {
    				EObject eObject = (EObject) getAdapterSafe(selected, EObject.class);
    	            if (eObject != null) {
    	            	uri = EcoreUtil.getURI(eObject);
    	            }
    	            else {
    	            	uri = null;
    	            }
            	}
            }
            
            myUriText.setEnabled(false);
            myResource = null;
            myUriText.setText(uri == null ? "" : uri.toString()); //$NON-NLS-1$

            if (uri == null && selection instanceof IStructuredSelection && myDefaultFileName != null) {
            	myResource = ((IStructuredSelection) selection).getFirstElement();
                if(myResource instanceof IContainer) {
                	myUriText.setEnabled(true);
                	myUriText.setText(myDefaultFileName);
                	return;
                }
            }
            
            fireSelectionChanged(myUri = uri);
        }
    };

    private final ModifyListener FNAME_LISTENER = new ModifyListener() {
        public void modifyText(ModifyEvent e) {
        	if (myResource instanceof IContainer) {
	        	URI uri = IPathUtils.getUri(IPathUtils.computePath((IResource) myResource, myUriText.getText()));
	            fireSelectionChanged(myUri = uri);
        	}
        }
    };
}
