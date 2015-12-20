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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class SelectFileControl extends Composite {
    public static interface IFilter {
        boolean accept(IResource resource);
    }
    
    public static interface ISelectionListener {
        void selectionChanged(IPath selectedPath);
    }
    
    public SelectFileControl(Composite parentComposite, boolean onlyExisting, IFilter resourceFilter) {
        this(parentComposite, DEFAULT_FNAME, DEFAULT_FNAME, onlyExisting, resourceFilter);
    }

    public SelectFileControl(Composite parentComposite, String fileName, String defaultFileName, boolean onlyExisting, IFilter resourceFilter) {
        super(parentComposite,SWT.NULL);
        myResourceFilter = resourceFilter;
        mySelectionListeners = new ArrayList<ISelectionListener>();
        myOnlyExisting = onlyExisting;
        
        myDefaultFileName = defaultFileName == null ? DEFAULT_FNAME : defaultFileName;
        myFileName = fileName == null ? myDefaultFileName : fileName;
    
        myCreatedFiles = new HashSet<IFile>();
        
        IResource root = ResourcesPlugin.getWorkspace().getRoot();
        
        setLayout(new GridLayout());
        
        myViewer = new TreeViewer(this, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        
        Label secondLabel = new Label(this, SWT.LEFT);
        secondLabel.setText(Messages.SelectFileControl_SelectedFile);
        
        myFileNameText = new Text(this, SWT.BORDER);
        myFileNameText.setEnabled(!myOnlyExisting);
        myFileNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        myFileNameText.setText(myFileName);
        myFileNameText.addModifyListener(FNAME_LISTENER);
        
        myViewer.setContentProvider(CONTENT_PROVIDER);
        myViewer.setLabelProvider(new WorkbenchLabelProvider());
        myViewer.setAutoExpandLevel(DEFAUL_AUTO_EXPAND_LEVEL);
        myViewer.addFilter(VIEWER_FILTER);
        myViewer.setSorter(VIEWER_SORTER);
        myViewer.addSelectionChangedListener(VIEWER_LISTENER);
        
        myViewer.setColumnProperties(new String[] {NAME_COLUMN});
        Tree tree = (Tree) myViewer.getControl();
        myViewer.setCellEditors(new CellEditor[] {
                new TextCellEditor(tree, SWT.BORDER | SWT.SINGLE),
        });
        myViewer.setCellModifier(FILE_CELL_MODIFIER);
        
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.FILL;
        data.grabExcessVerticalSpace = true;
        data.heightHint = 250;
        data.widthHint = 350;
        myViewer.getControl().setLayoutData(data);
        myViewer.setInput(root);
        
        hookContextMenu();
    }
    
    void addCreatedFile(IFile file) {
        myCreatedFiles.add(file);
    }
    
    void removeCreatedFile(IFile file) {
        myCreatedFiles.remove(file);
    }
    
    private void hookContextMenu() {
        MenuManager menuMgr = new MenuManager("#PopupMenu"); //$NON-NLS-1$
        menuMgr.setRemoveAllWhenShown(true);
        menuMgr.addMenuListener(new IMenuListener() {
            public void menuAboutToShow(IMenuManager manager) {
                SelectFileControl.this.fillContextMenu(manager);
            }
        });
        
        Menu menu = menuMgr.createContextMenu(myViewer.getControl());
        myViewer.getControl().setMenu(menu);
    }
    
    protected void fillContextMenu(IMenuManager manager) {
        if(!myOnlyExisting) {
            addNewFileAction(manager);
        }
    }
    
    private void addNewFileAction(IMenuManager manager) {
        ISelection selection = myViewer.getSelection();
        if(selection == null || selection.isEmpty()) {
            return;
        }

        if(selection instanceof IStructuredSelection == false) {
            return;
        }
        
        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
        Object obj = structuredSelection.iterator().next();
        if(obj instanceof IContainer == false) {
            return;
        }
        
        IContainer cont = (IContainer)obj;
        
        IAction newFileAction = new NewFileAction(this, cont, myDefaultFileName); 
        newFileAction.setText(Messages.SelectFileControl_NewFile);
        newFileAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
                getImageDescriptor(ISharedImages.IMG_OBJ_FILE));
        
        manager.add(newFileAction);
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
    
    private void fileSelectionChanged(IPath selectedPath) {
        for (Iterator<ISelectionListener> it = new ArrayList<ISelectionListener>(mySelectionListeners).iterator(); it.hasNext();) {
            ISelectionListener listener = it.next();
            try {
                listener.selectionChanged(selectedPath);
            }
            catch(Exception e) {
            }
        }
    }
    
    public TreeViewer getViewer(){
        return myViewer;
    }
    
    public IPath getSelectedPath() {
        return myPath;
    }
    
    public IFile getSelectedFile() {
        return myPath == null ? null : WorkspaceUtils.getWorkspaceFile(myPath.toString());
    }
    
    private final ViewerFilter VIEWER_FILTER = new ViewerFilter() {
        @Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
            if (element instanceof IResource == false) {
            	return false;
            }
            
            if(element instanceof IContainer) {
                IContainer container = (IContainer)element;
                if(!myOnlyExisting) {
                	return true;
                }

				boolean has = hasMatchingChildrenRecursive(container, myResourceFilter);
				return has;
            }
            else { 
            	return resourceMatches(myResourceFilter, (IResource)element);
            }
        }
        
        private boolean hasMatchingChildrenRecursive(IContainer container, final IFilter filter) {
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

		private boolean resourceMatches(final IFilter filter, IResource member) {
			return filter == null || filter.accept(member);
		}
    };
    
    public void selectFileByPath(String path) {
        IFile file = WorkspaceUtils.getWorkspaceFile(path); 
        if (file != null) {
            StructuredSelection sel = new StructuredSelection(new Object[] {file});
            myViewer.setSelection(sel);
        }
    }
    
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
            
            try {
                myFileNameText.removeModifyListener(FNAME_LISTENER);
                
                IResource resource;
                if(selection == null) {
                    resource = null;
                    myFileNameText.setText("");//$NON-NLS-1$
                }
                else {
                    resource = (IResource)selection.getFirstElement();
                    if(resource instanceof IFile) {
                        myFileNameText.setText(resource.getName());
                        myFileNameText.setEnabled(false);
                    }
                    else {
                        if(myOnlyExisting) {
                            myFileNameText.setText(""); //$NON-NLS-1$
                            myFileNameText.setEnabled(false);
                        }
                        else {
                            myFileNameText.setEnabled(true);
                            IPath computePath = IPathUtils.computePath(myResource, myFileNameText.getText());
                            if (computePath != null && myDefaultFileName != null) {
                	            IFile file = WorkspaceUtils.getWorkspaceFile(computePath.toString());
                	            if (file != null && file.exists()) {
                            		myFileNameText.setText(myDefaultFileName);
                            	}
                            }
                            
                        }
                    }
                }
                
                myResource = resource;
                myPath = IPathUtils.computePath(myResource, myFileNameText.getText());
                fileSelectionChanged(myPath);
            }
            finally {
                myFileNameText.addModifyListener(FNAME_LISTENER);
            }
        }
    };
    
    private final ModifyListener FNAME_LISTENER = new ModifyListener() {
        public void modifyText(ModifyEvent e) {
            myFileName = myFileNameText.getText();
            myPath = IPathUtils.computePath(myResource, myFileName);
            fileSelectionChanged(myPath);
        }
    };

    
    private final boolean myOnlyExisting;
    private TreeViewer myViewer;
    private Text myFileNameText;
    private String myFileName;
    private String myDefaultFileName;
    private final IFilter myResourceFilter;
    private IResource myResource;
    private IPath myPath;
    
    private final Set<IFile> myCreatedFiles;

    private final List<ISelectionListener> mySelectionListeners;
    
    private static final int DEFAUL_AUTO_EXPAND_LEVEL = 0;
    private static final String NAME_COLUMN = "name"; //$NON-NLS-1$
    
    private static final String DEFAULT_FNAME = "New File"; //$NON-NLS-1$
    
    private final ICellModifier FILE_CELL_MODIFIER = new ICellModifier() {
        public boolean canModify(Object element, String property) {
            return element instanceof IFile && myCreatedFiles.contains(element);
        }

        public Object getValue(Object element, String property) {
            if(element instanceof IFile == false || !NAME_COLUMN.equals(property)) {
                return null;
            }
            
            return ((IFile)element).getName();
        }

        public void modify(Object element, String property, Object value) {
            if (element instanceof TreeItem == false || !NAME_COLUMN.equals(property)) {
                return;
            }
            
            Object data = ((TreeItem)element).getData();
            if(data instanceof IFile == false ) {
                return;
            }

            IFile file = (IFile)data;
            String newName = (String)value;
            if(newName == null || newName.length() == 0) {
            	return;
            }
            
            if(file.getName().equals(newName)) {
                return;
            }
            
            IStatus status = file.getProject().getWorkspace().validateName(newName, IResource.FILE);
            if(StatusUtil.isError(status)) {
            	Logger.getLogger().log(Logger.WARNING, "Validation failed for " + newName + ": " + status.getMessage()); //$NON-NLS-1$ //$NON-NLS-2$
            	return;
            }
            
            IPath newPath = new Path(newName);
            IFile newFile;
            
            try {
            	newFile = file.getParent().getFile(newPath); 
            }
            catch(Exception e) {
            	Logger.getLogger().log(Logger.WARNING, "Failed to get file " + newPath + "parent= " + file.getParent(), e); //$NON-NLS-1$ //$NON-NLS-2$
            	return;
            }
            
            if(!newFile.getParent().equals(file.getParent())) {
            	return;
            }
            
            if(newFile.exists()) {
                return;
            }
            
            removeCreatedFile(file);
            addCreatedFile(newFile);
            myViewer.refresh();
            myViewer.setSelection(new StructuredSelection(newFile));
        }
    };
    
    private ITreeContentProvider CONTENT_PROVIDER = new ITreeContentProvider() {
        ITreeContentProvider myProvider = new WorkbenchContentProvider();
        
        public Object[] getChildren(Object parentElement) {
            Object[] children = myProvider.getChildren(parentElement);
            if(myOnlyExisting) {
            	return children;
            }
            
            if(parentElement instanceof IContainer == false) {
                return children;
            }
            
            List<Object> allChildren = new ArrayList<Object>();
            if(children != null) {
                allChildren.addAll(Arrays.asList(children));
            }
            
            IContainer container = (IContainer)parentElement;
            allChildren.addAll(getCreatedChildren(container));
            
            return allChildren.toArray();
        }
        
        private List<Object> getCreatedChildren(IContainer container) {
            List<Object> children = new ArrayList<Object>();
            
            for(IFile file : myCreatedFiles) {
                if(container.equals(file.getParent())) {
                    children.add(file);
                }
            }
            
            return children;
        }

        public Object getParent(Object element) {
            Object parent = myProvider.getParent(element);
            if(parent != null) {
                return parent;
            }
            
            if(element instanceof IFile == false) {
                return null;
            }
            
            IFile file = (IFile) element;
            return file.getParent();
        }

        public boolean hasChildren(Object element) {
            if(myProvider.hasChildren(element)) {
                return true;
            }
            
            if(element instanceof IContainer == false) {
                return false;
            }
            
            return !getCreatedChildren((IContainer) element).isEmpty();
        }

        public Object[] getElements(Object inputElement) {
            return myProvider.getElements(inputElement);
        }

        public void dispose() {
            myProvider.dispose();
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            myProvider.inputChanged(viewer, oldInput, newInput);
        } 
    };
}
