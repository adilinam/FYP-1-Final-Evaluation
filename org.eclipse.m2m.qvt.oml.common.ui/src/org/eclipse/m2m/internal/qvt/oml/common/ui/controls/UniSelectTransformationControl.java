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
package org.eclipse.m2m.internal.qvt.oml.common.ui.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.project.CompiledTransformation;
import org.eclipse.m2m.internal.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.common.ui.CommonPluginImages;
import org.eclipse.m2m.internal.qvt.oml.common.ui.controls.UniSelectTransformationControl.ISelectionListener.TreeAction;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.Messages;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.progress.DeferredTreeContentManager;
import org.eclipse.ui.progress.IDeferredWorkbenchAdapter;
import org.eclipse.ui.progress.PendingUpdateAdapter;
import org.eclipse.ui.progress.WorkbenchJob;

public class UniSelectTransformationControl extends Composite {
	
	public static final IResourceFilter QVTO_FILE_FILTER = new IResourceFilter() {
        public boolean accept(IResource resource) {
            return resource instanceof IFile && MDAConstants.QVTO_FILE_EXTENSION.equalsIgnoreCase(resource.getFileExtension());
        }
	};
	
    public static interface IResourceFilter {
        boolean accept(IResource resource);
    }
    
    public static interface ISelectionListener {
    	
    	enum TreeAction {
    		NONE,
    		EXPAND,
    		SELECT
    	}

		boolean accept(URI uri);
		
		TreeAction getTreeAction(URI uri);
		
		IStatus selectionChanged(URI uri);
    }
    
    public static abstract class SelectionListenerAdapter implements ISelectionListener {
    	
    	private final ISelectionListener delegate;
    	
    	public SelectionListenerAdapter(ISelectionListener delegate) {
    		this.delegate = delegate;
    	}
    	
    	public SelectionListenerAdapter() {
    		delegate = null;
    	}
    	
		public boolean accept(URI uri) {
			if (delegate != null) {
				return delegate.accept(uri);
			}
			return true;
		}

		public TreeAction getTreeAction(URI uri) {
			if (delegate != null) {
				return delegate.getTreeAction(uri);
			}
			return TreeAction.NONE;
		}
    }

    public UniSelectTransformationControl(Composite parentComposite, IResourceFilter resourceFilter,
    		TransformationRegistry transfRegistry, TransformationRegistry.Filter transfFilter, ISelectionListener listener) {
        super(parentComposite,SWT.NULL);
        myResourceFilter = resourceFilter;
        mySelectionListener = listener;
        
        setLayout(new GridLayout());
        setLayoutData(new GridData(GridData.FILL_BOTH));
        
        List<ITreeContentProviderEx> contentProviders = new ArrayList<ITreeContentProviderEx>(2);
        contentProviders.add(new WorkspaceContentProvider());
        contentProviders.add(new CompiledTransfContentProvider());

        List<ILabelProviderEx> labelProviders = new ArrayList<ILabelProviderEx>(3);
        
        labelProviders.add(new LabelProviderDelegate(new WorkbenchLabelProvider()) {
			public boolean canHandle(Object element) {
				return element instanceof IResource;
			}
        });
        
        labelProviders.add(new LabelProviderDelegate(new QvtCompiledTransformationLabelProvider()) {
			public boolean canHandle(Object element) {
				return element instanceof CompiledTransformation
						|| element instanceof CompiledTransformationRoot;
			}
			@Override
			public String getText(Object element) {
				if (element instanceof CompiledTransformationRoot) {
					return Messages.UniSelectTransformationControl_DeployedTransformations;
				}
				return super.getText(element);
			}
			@Override
			public Image getImage(Object element) {
				if (element instanceof CompiledTransformationRoot) {
					return CommonPluginImages.getInstance().getImage(CommonPluginImages.REGISTRY);
				}
				return super.getImage(element);
			}
        });
        
        labelProviders.add(new ILabelProviderEx() {
        	
			public boolean canHandle(Object element) {
				return element instanceof PendingUpdateAdapter;
			}

			public Image getImage(Object element) {
				return CommonPluginImages.getInstance().getImage(CommonPluginImages.ACTIVITY);
			}
			
			public String getText(Object element) {
				return Messages.UniSelectTransformationControl_fetchingTransformations;
			}
			
			public void addListener(ILabelProviderListener listener) {
			}
			
			public void dispose() {
			}
			
			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
			}
        });
        
        
        myViewer = new TreeViewer(this, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        myViewer.setContentProvider(new CompositeContentProvider(contentProviders));
        myViewer.setLabelProvider(new CompositeLabelProvider(labelProviders));
        myViewer.setAutoExpandLevel(DEFAUL_AUTO_EXPAND_LEVEL);
        myViewer.addFilter(VIEWER_FILTER);
        myViewer.setSorter(VIEWER_SORTER);
        myViewer.addSelectionChangedListener(VIEWER_LISTENER);
        
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.FILL;
        data.grabExcessVerticalSpace = true;
        data.heightHint = 250;
        data.widthHint = 350;
        myViewer.getControl().setLayoutData(data);
        
        myContentManager = new DeferredTreeContentManager(myViewer) {
			protected void addChildren(final Object parent, final Object[] children, IProgressMonitor monitor) {
				WorkbenchJob updateJob = new WorkbenchJob(Messages.UniSelectTransformationControl_addingTransformations) {
					public IStatus runInUIThread(IProgressMonitor updateMonitor) {
						// Cancel the job if the tree viewer got closed
						if (myViewer.getControl().isDisposed() || updateMonitor.isCanceled()) {
							return Status.CANCEL_STATUS;
						}
						myViewer.add(parent, children);
						return Status.OK_STATUS;
					}
				};
				updateJob.setSystem(true);
				updateJob.schedule();
				try {
					updateJob.join();
				} catch (InterruptedException e) {
				}
			}
		};
        
        List<Object> inputs = new ArrayList<Object>(2);
        inputs.add(ResourcesPlugin.getWorkspace().getRoot());
        myCompiledTransformations = transfRegistry.getTransformations(transfFilter);
        inputs.add(new CompiledTransformationRoot(myCompiledTransformations));
        myViewer.setInput(inputs);

        TransformationControls.createLabel(this, Messages.UniSelectTransformationControl_CurrentSelection, TransformationControls.GRID);
        
        myFileNameText = new Text(this, SWT.BORDER);
        myFileNameText.setEnabled(false);
        myFileNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    }
    
    public URI getSelectedUri() {
        return myUri;
    }
    
    public void selectTransformationByUri(String uriString) {
        URI uri = EmfUtil.makeUri(uriString);
        if (uri == null) {
        	return;
        }
        
		if (uri.isPlatformPlugin()) {
			for (CompiledTransformation compiledTransf : myCompiledTransformations) {
				if (compiledTransf.getUri().equals(uri)) {
		            StructuredSelection sel = new StructuredSelection(new Object[] {compiledTransf});
		            myViewer.setSelection(sel);
		            return;
				}
			}
			final String transfId = uri.toPlatformString(false).replace("/", ""); //$NON-NLS-1$ //$NON-NLS-2$
			for (CompiledTransformation compiledTransf : myCompiledTransformations) {
				if (compiledTransf.getId().equals(transfId)) {
		            StructuredSelection sel = new StructuredSelection(new Object[] {compiledTransf});
		            myViewer.setSelection(sel);
		            return;
				}
			}
		}
		else {
			IFile ifile = WorkspaceUtils.getWorkspaceFile(uri);
			if (ifile != null) {
	            StructuredSelection sel = new StructuredSelection(new Object[] {ifile});
	            myViewer.setSelection(sel);
			}
		}
    }
    
    private void fileSelectionChanged(URI selectedUri) {
        if (mySelectionListener != null) {
            try {
            	mySelectionListener.selectionChanged(selectedUri);
            }
            catch(Exception e) {
            }
        }
    }
    
    private final ViewerFilter VIEWER_FILTER = new ViewerFilter() {
        @Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
            if (element instanceof IContainer) {
				return hasMatchingChildrenRecursive((IContainer) element, myResourceFilter);
            }
            else if (element instanceof IResource) { 
            	return resourceMatches(myResourceFilter, (IResource) element);
            }
            else {
            	return true;
            }
        }
        
        private boolean hasMatchingChildrenRecursive(IContainer container, final IResourceFilter filter) {
            try {
				IResource[] members = container.members();
                for (IResource member : members) {
                    if (resourceMatches(filter, member)) {
                        return true;
                    }
                    
                    if(member instanceof IContainer) {
                    	boolean has = hasMatchingChildrenRecursive((IContainer) member, filter);
                    	if(has) {
                    		return true;
                    	}
                    }
                }
            } 
            catch (Exception e) {
            }
            
            return false;
        }

		private boolean resourceMatches(final IResourceFilter filter, IResource member) {
			return filter == null || filter.accept(member);
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
            IStructuredSelection selection = (IStructuredSelection)event.getSelection();
            
            myFileNameText.setText(""); //$NON-NLS-1$
            myUri = null;
            
            if (selection != null && selection.getFirstElement() instanceof IFile){
            	IFile ifile = (IFile) selection.getFirstElement();
                myUri = URI.createPlatformResourceURI(ifile.getFullPath().toOSString(), false);
                myFileNameText.setText(myUri.toString());
            }
            else if (selection != null && selection.getFirstElement() instanceof CompiledTransformation){
            	CompiledTransformation transf = (CompiledTransformation) selection.getFirstElement();
                myUri = transf.getUri();
                myFileNameText.setText(myUri.toString());
            }
            
            fileSelectionChanged(myUri);
        }
    };
    
    
    private final TreeViewer myViewer;
    private Text myFileNameText;
    private final IResourceFilter myResourceFilter;
    private final ISelectionListener mySelectionListener;
    private URI myUri;
    private final List<CompiledTransformation> myCompiledTransformations;
    
    private final DeferredTreeContentManager myContentManager;
    
    private static final int DEFAUL_AUTO_EXPAND_LEVEL = 2;
    
    private static interface ITreeContentProviderEx extends ITreeContentProvider {
    	boolean canHandle(Object element);
    }
    
    private static class CompositeContentProvider implements ITreeContentProvider {
    	CompositeContentProvider(List<ITreeContentProviderEx> providers) {
    		myProviders = providers;
    	}

		public Object[] getChildren(Object parentElement) {
			for (ITreeContentProviderEx provider : myProviders) {
				if (provider.canHandle(parentElement)) {
					return provider.getChildren(parentElement);
				}
			}
			return null;
		}

		public Object getParent(Object element) {
			for (ITreeContentProviderEx provider : myProviders) {
				if (provider.canHandle(element)) {
					return provider.getParent(element);
				}
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			for (ITreeContentProviderEx provider : myProviders) {
				if (provider.canHandle(element)) {
					return provider.hasChildren(element);
				}
			}
			return false;
		}

		public Object[] getElements(Object inputElement) {
            if (inputElement instanceof List<?>) {
                return ((List<?>)inputElement).toArray();
            }
			for (ITreeContentProviderEx provider : myProviders) {
				if (provider.canHandle(inputElement)) {
					return provider.getChildren(inputElement);
				}
			}
			return null;
		}

		public void dispose() {
			for (ITreeContentProviderEx provider : myProviders) {
				provider.dispose();
			}
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			for (ITreeContentProviderEx provider : myProviders) {
				//if (provider.canHandle(oldInput) || provider.canHandle(newInput)) {
					provider.inputChanged(viewer, oldInput, newInput);
				//}
			}
		}
    	
		private final List<ITreeContentProviderEx> myProviders;
    }

    private static interface ILabelProviderEx extends ILabelProvider {
    	boolean canHandle(Object element);
    }
    
    private static class CompositeLabelProvider implements ILabelProvider {
    	CompositeLabelProvider(List<ILabelProviderEx> providers) {
    		myProviders = providers;
    	}

		public Image getImage(Object element) {
			for (ILabelProviderEx provider : myProviders) {
				if (provider.canHandle(element)) {
					return provider.getImage(element);
				}
			}
			return null;
		}

		public String getText(Object element) {
			for (ILabelProviderEx provider : myProviders) {
				if (provider.canHandle(element)) {
					return provider.getText(element);
				}
			}
			return null;
		}

		public void addListener(ILabelProviderListener listener) {
			for (ILabelProviderEx provider : myProviders) {
				provider.addListener(listener);
			}
		}

		public void dispose() {
			for (ILabelProviderEx provider : myProviders) {
				provider.dispose();
			}
		}

		public boolean isLabelProperty(Object element, String property) {
			for (ILabelProviderEx provider : myProviders) {
				if (provider.canHandle(element)) {
					return provider.isLabelProperty(element, property);
				}
			}
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
			for (ILabelProviderEx provider : myProviders) {
				provider.removeListener(listener);
			}
		}

		private final List<ILabelProviderEx> myProviders;
    }
    
    private class WorkspaceContentProvider implements ITreeContentProviderEx {

	    private AbstractDeferredAdapter workspaceContentAdapter;
		private IAdapterFactory workspaceContentProviderFactory;
		
        public Object[] getChildren(Object parentElement) {
        	return getElements(parentElement);
        }
        
        public Object getParent(Object element) {
        	return myProvider.getParent(element);
        }

        public boolean hasChildren(Object element) {
        	if (element instanceof IFile) {
        		return false;
        	}
        	return myContentManager.mayHaveChildren(element);
        }

        public Object[] getElements(Object inputElement) {
			return myContentManager.getChildren(inputElement);
        }

        public void dispose() {
            myProvider.dispose();
            workspaceContentAdapter.cancel();
            IAdapterManager adapterManager = Platform.getAdapterManager();
            adapterManager.unregisterAdapters(workspaceContentProviderFactory);
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        	if (workspaceContentAdapter == null) {
	    	    workspaceContentAdapter = new AbstractDeferredAdapter((TreeViewer) viewer) {
	    			
	    			public String getLabel(Object o) {
	    				return Messages.UniSelectTransformationControl_workspaceTransformations;
	    			}
	    			
	    			@Override
	    			public Object[] getChildren(Object o) {
	    				return myProvider.getElements(o);
	    			}
	
	    			@Override
	    			public boolean isAccepted(Object object, IProgressMonitor monitor) {
	    				if (myResourceFilter == null || !myResourceFilter.accept((IResource) object)) {
	    					return true;					
	    				}
	    				if (mySelectionListener == null) {
	    					return true;
	    				}
	    				
	    				URI uri = URIUtils.getResourceURI((IResource) object);
	    				return mySelectionListener.accept(uri);
	    			}
	
	    			@Override
	    		    public TreeAction getTreeAction(Object object, IProgressMonitor monitor) {
	    				if (mySelectionListener == null) {
	    					return TreeAction.NONE;
	    				}

	    				URI uri = URIUtils.getResourceURI((IResource) object);
	    				return mySelectionListener.getTreeAction(uri);
	    		    }    			
	    		};
	
	    		workspaceContentProviderFactory = new IAdapterFactory() {
	    			
	    			@SuppressWarnings("rawtypes")
					public Object getAdapter(Object adaptableObject, Class adapterType) {
	    				return workspaceContentAdapter;
	    			}
	
	    			@SuppressWarnings("rawtypes")
					public Class[] getAdapterList() {
	    		        return new Class[] { IWorkbenchAdapter.class, IDeferredWorkbenchAdapter.class };
	    			}			
	    		};
	
		        IAdapterManager adapterManager = Platform.getAdapterManager();
		        adapterManager.registerAdapters(workspaceContentProviderFactory, IResource.class);
        	}
        	
        	myProvider.inputChanged(viewer, oldInput, newInput);
        }

		public boolean canHandle(Object element) {
			return element instanceof IResource;
		} 

        private final ITreeContentProvider myProvider = new WorkbenchContentProvider();
    };

    private static abstract class LabelProviderDelegate implements ILabelProviderEx {
    	LabelProviderDelegate(ILabelProvider provider) {
    		myDelegate = provider;
    	}

		public Image getImage(Object element) {
			return myDelegate.getImage(element);
		}

		public String getText(Object element) {
			return myDelegate.getText(element);
		}

		public void addListener(ILabelProviderListener listener) {
			myDelegate.addListener(listener);
		}

		public void dispose() {
			myDelegate.dispose();
		}

		public boolean isLabelProperty(Object element, String property) {
			return myDelegate.isLabelProperty(element, property);
		}

		public void removeListener(ILabelProviderListener listener) {
			myDelegate.removeListener(listener);
		}
		
		private final ILabelProvider myDelegate;
    };
    
    private static class CompiledTransformationRoot {
    	CompiledTransformationRoot(List<CompiledTransformation> trasformations) {
    		myTrasformations = trasformations;
    	}
    	
    	Object[] getChildren() {
    		return myTrasformations.toArray();
    	}
    	
    	private final List<CompiledTransformation> myTrasformations;
    }
    
    private class CompiledTransfContentProvider implements ITreeContentProviderEx {
    	
	    private AbstractDeferredAdapter compiledTransformationAdapter;
		private IAdapterFactory compiledTransformationProviderFactory;
		
        public Object[] getChildren(Object parentElement) {
            return getElements(parentElement);
        }

        public Object getParent(Object element) {
            return null;
        }

        public boolean hasChildren(Object element) {
			return myContentManager.mayHaveChildren(element);
        }

        public Object[] getElements(Object inputElement) {
			return myContentManager.getChildren(inputElement);
        }

        public void dispose() {
			compiledTransformationAdapter.cancel();
            IAdapterManager adapterManager = Platform.getAdapterManager();
            adapterManager.unregisterAdapters(compiledTransformationProviderFactory);
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        	if (compiledTransformationAdapter == null) {
	    	    compiledTransformationAdapter = new AbstractDeferredAdapter(myViewer) {
	    			
	    			public String getLabel(Object o) {
	    				return Messages.UniSelectTransformationControl_platformTransformations;
	    			}
	    			
	    			@Override
	    			public Object[] getChildren(Object o) {
	    				return ((CompiledTransformationRoot) o).getChildren();
	    			}
	
	    			@Override
	    			public boolean isAccepted(Object object, IProgressMonitor monitor) {
	    				if (mySelectionListener == null) {
	    					return true;
	    				}
	    				return mySelectionListener.accept(((CompiledTransformation) object).getUri());
	    			}

	    			@Override
	    		    public TreeAction getTreeAction(Object object, IProgressMonitor monitor) {
	    				if (mySelectionListener == null) {
	    					return TreeAction.NONE;
	    				}
	    				return mySelectionListener.getTreeAction(((CompiledTransformation) object).getUri());
	    		    }    			
	    	    };
	
	    		compiledTransformationProviderFactory = new IAdapterFactory() {
	
	    			@SuppressWarnings("rawtypes")
					public Object getAdapter(Object adaptableObject, Class adapterType) {
	    				return compiledTransformationAdapter;
	    			}
	
	    			@SuppressWarnings("rawtypes")
					public Class[] getAdapterList() {
	    		        return new Class[] { IWorkbenchAdapter.class, IDeferredWorkbenchAdapter.class };
	    			}			
	    		};

		        IAdapterManager adapterManager = Platform.getAdapterManager();
		        adapterManager.registerAdapters(compiledTransformationProviderFactory, CompiledTransformationRoot.class);
        	}
        }

		public boolean canHandle(Object element) {
			return element instanceof CompiledTransformation 
					|| element instanceof CompiledTransformationRoot;
		}
    };

}
