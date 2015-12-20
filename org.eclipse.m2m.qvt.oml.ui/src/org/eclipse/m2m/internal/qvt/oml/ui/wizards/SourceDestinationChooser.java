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
package org.eclipse.m2m.internal.qvt.oml.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.project.QvtProjectUtil;
import org.eclipse.m2m.internal.qvt.oml.project.builder.QVTOBuilderConfig;
import org.eclipse.m2m.internal.qvt.oml.project.model.IQvtElement;
import org.eclipse.m2m.internal.qvt.oml.project.model.IQvtNamespace;
import org.eclipse.m2m.internal.qvt.oml.project.model.IQvtProject;
import org.eclipse.m2m.internal.qvt.oml.project.model.QvtModelException;
import org.eclipse.m2m.internal.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.m2m.internal.qvt.oml.ui.QvtPluginImages;
import org.eclipse.m2m.internal.qvt.oml.ui.wizards.project.QvtProjectLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

public class SourceDestinationChooser extends ElementTreeSelectionDialog {
	
	private IQvtNamespace selectedNamespace;
	
	
	private SourceDestinationChooser(Shell parent, Object initialSelection) {
		super(parent, createWorkbenchDelegatingProvider(), new ContentProviderImpl());

		setComparator(new ResourceComparator(ResourceComparator.NAME));
		setInput(ResourcesPlugin.getWorkspace().getRoot());
		if(initialSelection != null) {
			setInitialSelection(initialSelection);
		}
		
		setAllowMultiple(false);
	}
	
	@Override
	protected TreeViewer createTreeViewer(Composite parent) {
		TreeViewer viewer = super.createTreeViewer(parent);
		viewer.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				IProject project = adaptObject(element, IProject.class);
				if(project != null) {
					return QvtProjectUtil.isQvtProject(project);
				}
				
				return true;
			}
		});
		
		viewer.expandToLevel(2);
		
		return viewer;
	}
	
	<T> T getSelectedElement(Class<T> type) {
		ISelection selection = getTreeViewer().getSelection();		
		if(!selection.isEmpty() && selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			return adaptObject(structuredSelection.getFirstElement(), type);
		}
		return null;		
	}
		
	/**
	 * @param initialPath initial context path or null
	 */
	public static IContainer chooseSourceContainer(Shell shell, IContainer initialSourceContainer) {
		Object initialSelection = initialSourceContainer != null && initialSourceContainer.getType() != IResource.PROJECT ? 
				new SourceContainer(initialSourceContainer) : initialSourceContainer;
		
		SourceDestinationChooser dialog = new SourceDestinationChooser(shell, initialSelection);
		dialog.setTitle(Messages.SourceDestinationChooser_SourceContainerSelectionTitle);
		dialog.setMessage(Messages.SourceDestinationChooser_ChooseSourceFolder);
		
		dialog.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				IProject project = adaptObject(element, IProject.class);
				return (project != null || element instanceof SourceContainer);
			}
		});
		
		dialog.setValidator(dialog.createSourceContainerValidator());		
		
		if(dialog.open() == Window.OK) {
			if(dialog.selectedNamespace != null) {
				// deduce the source container from the chosen name-space
				try {
					IResource resource = dialog.selectedNamespace.getQvtProject().getDefaultNamespace().getUnderlyingResource();
					assert resource instanceof IContainer;
					
					return resource instanceof IContainer ? (IContainer) resource : null;
				} catch (QvtModelException e) {
					QVTUIPlugin.log(e);
				}
			}
		}
		return null;
	}
	
	public static IQvtNamespace chooseNamespaceFolder(Shell shell) {
		final SourceDestinationChooser dialog = new SourceDestinationChooser(shell, null);
		
		dialog.setTitle(Messages.SourceDestinationChooser_NamespaceSelectionTitle);
		dialog.setMessage(Messages.SourceDestinationChooser_ChooseCUNamespaceFolder);

		dialog.setValidator(dialog.createNamespaceValidator());
		
		dialog.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				// show project, source folders and name-spaces
				if(element instanceof SourceContainer) {
					return true;
				}
				IContainer container = adaptObject(element, IContainer.class);
				if(container == null) {
					return false;
				}
				return  container.getType() == IResource.PROJECT || 
						(container.getType() == IResource.FOLDER && QvtProjectUtil.isNamespaceFolder((IFolder)container));
			}
		});		
				
		if(dialog.open() == Window.OK) {
			return dialog.selectedNamespace;
		}
		
		return null;
	}

	private ISelectionStatusValidator createNamespaceValidator() {
		return new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {
				if(selection == null || selection.length == 0) {
					return QVTUIPlugin.createStatus(IStatus.ERROR, Messages.SourceDestinationChooser_NoNamespaceSelected, null);
				}
				
				IQvtNamespace namespace = computeQvtNamespaceSelection();
				IStatus status = null;

				if(namespace == null) {
					status = QVTUIPlugin.createStatus(IStatus.ERROR, "Not a namespace selection", null); //$NON-NLS-1$							
				} 
				else if(IQvtNamespace.DEFAULT_NAMESPACE_NAME.equals(namespace.getName())) {
					status = QVTUIPlugin.createStatus(IStatus.OK, "The default namespace will be applied", null); //$NON-NLS-1$
				} else {
					status = QVTUIPlugin.createStatus(IStatus.OK, "", null); //$NON-NLS-1$ 
				}
				
				if(status.isOK()) {
					selectedNamespace = namespace;
				}
				
				return status;				
			} 
		};
	}
	
	private ISelectionStatusValidator createSourceContainerValidator() {
		return new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {
				if(selection == null || selection.length == 0) {
					return QVTUIPlugin.createStatus(IStatus.ERROR, Messages.SourceDestinationChooser_NoSourceContainerSelected, null);
				}
				
				IContainer container = getSelectedElement(IContainer.class);
				IQvtNamespace namespace = computeQvtNamespaceSelection();
				IStatus status = null;

				// we expect the default name-space only here, as it corresponds to the source container
				if(namespace == null || !IQvtNamespace.DEFAULT_NAMESPACE_NAME.equals(namespace.getName()) ||
					(container instanceof IProject && !container.getFullPath().equals(namespace.getFullPath())) ) {
					
					status = QVTUIPlugin.createStatus(IStatus.ERROR, "Not a source container selection", null); //$NON-NLS-1$							
				} else if(container != null) {
					if(!container.exists()) {
						status = QVTUIPlugin.createStatus(IStatus.ERROR, "Source container does not exist", null); //$NON-NLS-1$
					} else {
						status = QVTUIPlugin.createStatus(IStatus.OK, "", null); //$NON-NLS-1$
					}
				}
				
				if(status.isOK()) {
					selectedNamespace = namespace;
				} else {
					selectedNamespace = null;
				}
				
				return status;				
			} 
		};
	}
	
	private IQvtNamespace computeQvtNamespaceSelection() {
		IQvtProject project = null; 
		IContainer container = getSelectedElement(IContainer.class);
		if(container != null) {
			project = QvtProjectUtil.getQvtProject(container.getProject());
		}
		
		if(project != null) {
			try {
				IQvtElement qvtSelection = project.findElement(container, true);
				if(qvtSelection != null) {
					if(qvtSelection.getElementType() == IQvtElement.QVT_PROJECT) {
						return ((IQvtProject) qvtSelection).getDefaultNamespace();
					} else if(qvtSelection.getElementType() == IQvtElement.QVT_NAMESPACE) {
						return (IQvtNamespace) qvtSelection;
					}
				}
				
			} catch (QvtModelException e) {
				QVTUIPlugin.log(e);
			}
			
		}
		
		return null;
	}
		
	private static ILabelProvider createWorkbenchDelegatingProvider() {
		return new LabelProvideImpl(new QvtProjectLabelProvider());
	}
	
	private static class SourceContainer implements IAdaptable, IWorkbenchAdapter {
		private final IContainer resource;

		SourceContainer(IContainer resource) {
			this.resource = resource;
		}
		
		public Object[] getChildren(Object o) {			
			try {
				if(resource.exists()) {
					return resource.members();
				}
			} catch (CoreException e) {
				QVTUIPlugin.log(e.getStatus());
			}
			return new Object[0];
		}

		public ImageDescriptor getImageDescriptor(Object object) {
			return QvtPluginImages.getInstance().getImageDescriptor(QvtPluginImages.SRC_CONTAINER);
		}

		public String getLabel(Object o) {
			return resource.getProjectRelativePath().toString();
		}

		public Object getParent(Object o) {
			return resource.getProject();
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Object getAdapter(Class adapter) {
			return adaptObject(resource, adapter);
		}
		
		@Override
		public boolean equals(Object o) {
			if(o instanceof SourceContainer) {
				SourceContainer another = (SourceContainer) o;
				return resource.equals(another.resource);
			}
			return false;
		}
		
		@Override
		public int hashCode() {		
			return resource.getFullPath().hashCode();
		}
	}
	
	private static class ContentProviderImpl extends WorkbenchContentProvider {
		@Override
		public Object[] getChildren(Object element) {
			
			Object[] regularChildren = super.getChildren(element);
			IProject project = adaptObject(element, IProject.class);
			if(project != null) {
				// add top level source container if the project itself is not a container 
				QVTOBuilderConfig config = getBuilderConfig(project);
				if (config != null) {
					IContainer sourceContainer = config.getSourceContainer();
					if(sourceContainer.getType() != IResource.PROJECT) {
						List<Object> children = new ArrayList<Object>(regularChildren.length + 1);
						children.add(new SourceContainer(sourceContainer));
						return children.toArray();
					}
				}
			}
			return super.getChildren(element);
		}
		
		@Override
		public Object getParent(Object element) {
			SourceContainer container = adaptObject(element, SourceContainer.class);
			if(container != null) {
				// the top level container additional node -> make the project the parent
				return container.resource.getProject();
			}
			return super.getParent(element);
		}
	}
	
	private static class LabelProvideImpl extends LabelProvider {
		
		private ILabelProvider delegate;
		private ILabelProvider provider;
		
		protected LabelProvideImpl(ILabelProvider delegate) {		
			this.provider = new WorkbenchLabelProvider();
			this.delegate = delegate;
			
			assert delegate != null;
			assert provider != null;
		}
		
		@Override
		public Image getImage(Object element) {
			Image image = delegate.getImage(element);
			if(image != null) {
				return image;
			}
			
			return provider.getImage(element);
		}		
		
		@Override
		public String getText(Object element) {
			if(element instanceof IContainer) {
				IContainer resource = (IContainer) element;
				if(resource.getType() != IResource.PROJECT) {
					QVTOBuilderConfig config = getBuilderConfig(resource);
					if(config != null) {
						IContainer sourceContainer = config.getSourceContainer();
						if(sourceContainer.getType() != IResource.PROJECT && resource.equals(sourceContainer)) {
							return resource.getProjectRelativePath().toString(); 
						}
					}
				}
			}

			String text = delegate.getText(element);
			if(text != null) {
				return text;
			}
			
			return provider.getText(element);
		}
	}
	
	private static <T> T adaptObject(Object adaptee, Class<T> adapterType) {
		if(adapterType.isInstance(adaptee)) {
			return adapterType.cast(adaptee);
		} else if (adaptee instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) adaptee;
			return adapterType.cast(adaptable.getAdapter(adapterType));
		}
		
		return null;
	}
	
	
	
	private static QVTOBuilderConfig getBuilderConfig(Object element) {
		try {
			IResource resource = adaptObject(element, IResource.class);
			if (resource != null) {
				IProject project = resource.getProject();
				if(QvtProjectUtil.isQvtProject(project)) {
					return QVTOBuilderConfig.getConfig(project);
				}
			}
		} catch (CoreException e) {
			return null;
		}
		
		return null;
	}
}
