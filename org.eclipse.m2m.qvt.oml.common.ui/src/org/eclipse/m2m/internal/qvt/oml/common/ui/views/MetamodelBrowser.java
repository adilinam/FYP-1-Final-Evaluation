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
package org.eclipse.m2m.internal.qvt.oml.common.ui.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.ui.CommonUIPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.m2m.internal.qvt.oml.common.ui.CommonPluginImages;
import org.eclipse.m2m.internal.qvt.oml.common.ui.dialogs.ComplexClassifierProvider;
import org.eclipse.m2m.internal.qvt.oml.common.ui.dialogs.OpenClassifierDialog;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtilPlugin;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.WorkspaceMetamodelProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.DelegatingPropertySource;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.metamodel.MetamodelImageRegistry;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.provider.EMFProviderUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetPage;


public class MetamodelBrowser  implements IAdaptable {
	/*
	 * Browser style constants 
	 */
	public static final int SHOW_PACKAGE_ONLY = 0;	
	public static final int SHOW_PACKAGE_CONTENTS = 1;
	public static final int SHOW_CLASSIFIER_CONTENTS = 2;		
	public static final int CHECK_STYLE = 4;	
	public static final int DEFAULT = SHOW_CLASSIFIER_CONTENTS | SHOW_PACKAGE_CONTENTS;
	
    private static final String FIND_CLASSIFIER_COMMAND_ID = "org.eclipse.m2m.qvt.oml.findClassifier"; //$NON-NLS-1$
    private static final String CONTEXT_ID = "org.eclipse.m2m.qvt.oml.metamodelBrowser"; //$NON-NLS-1$
    private static final String EXTENDED_CLASSES = " -> "; //$NON-NLS-1$
    private static final String EXTENDED_CLASSES_SEPARATOR = ", "; //$NON-NLS-1$
    private static final String INSTANCE_CLASS_NAME_START = " <"; //$NON-NLS-1$
    private static final String INSTANCE_CLASS_NAME_END = ">"; //$NON-NLS-1$
    private static final String NAME_AND_TYPE_SEPARATOR = " : "; //$NON-NLS-1$
    private static final String PARAMETERS_START = "("; //$NON-NLS-1$
    private static final String PARAMETERS_SEPARATOR = ", "; //$NON-NLS-1$
    private static final String PARAMETERS_END = ")"; //$NON-NLS-1$		
	
    private IContextService contextService;
    private IContextActivation contextActivation;
    private IHandlerService handlerService;
    private IHandlerActivation handlerActivation;
    
    private TreeViewer myViewer;
    private DrillDownAdapter myDrillDownAdapter;
    private IAction myDoubleClickAction;
    private IAction myCollapseAllAction;
    private IAction myShowInheritedFeaturesAction;
    private IAction myShowFullQualifiedNamesAction;
    private IAction myOpenClassifierAction;
    private PropertySheetPage myPropertySheetPage;
    private boolean myShowInheritedFeatures = false;
    private boolean myShowFullQualifiedNames = false;
    	
	private int browserStyle;
	private ViewForm control;
	private IToolBarManager toolBarManager;
	private BrowserNode workspaceModels;	
	
	public MetamodelBrowser(Composite parent) {
		this(parent, DEFAULT);
	}
	
	public MetamodelBrowser(Composite parent, int browserStyle) {		
		Composite container = parent;
		this.browserStyle = browserStyle;			 
		this.control = new ViewForm(container, SWT.NONE);

        GridData data = new GridData(GridData.FILL_BOTH);
        data.heightHint = 250;
        data.grabExcessHorizontalSpace = true;
        data.grabExcessVerticalSpace = true;
        this.control.setLayoutData(data);
		
		this.toolBarManager = getToolBarManager();
		
		myViewer = createTreeViewer(control);
		control.setContent(myViewer.getControl());
		
		setupFilters();		
		myViewer.setContentProvider(createTreeContentProvider());
		myViewer.setLabelProvider(createLabelProvider());
        myViewer.setSorter(createSorter());
		myViewer.setInput(createInput());
		myDrillDownAdapter = new DrillDownAdapter(myViewer);
			
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();

        myViewer.expandToLevel(((BrowserNode)myViewer.getInput()).getChildren(false).get(0), 1);
        myViewer.getTree().setFocus();
		
        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, "org.eclipse.m2m.qvt.oml.metamodel_browser"); //$NON-NLS-1$
        
        control.addDisposeListener(new DisposeListener() {
        	public void widgetDisposed(DisposeEvent e) {
        		dispose();
        	}
        });
	}

	private void setupFilters() {
		List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
		if((browserStyle & SHOW_CLASSIFIER_CONTENTS) == 0) {
			filters.add(new ClassifierContentsFilter());
		}
		if((browserStyle & SHOW_PACKAGE_CONTENTS) == 0) {
			filters.add(new PackageContentsFilter());
		}
		
		
		myViewer.setFilters(filters.toArray(new ViewerFilter[filters.size()]));		
	}
	
	public <T extends EModelElement> List<T> getModelElementSelection(Class<T> type) {
		List<T> result = new ArrayList<T>();
		
		for (EModelElement element : getModelElementSelection()) {
			if(type.isInstance(element)) {
				result.add(type.cast(element));
			}
		}
		
		return result;
	}
	
	public List<EModelElement> getModelElementSelection() {
		List<EModelElement> result = new ArrayList<EModelElement>();
		
    	if(!getViewer().getSelection().isEmpty()) {
    		for (Iterator<?> it = ((IStructuredSelection)getViewer().getSelection()).iterator(); it.hasNext();) {
        		BrowserNode selObj = (BrowserNode) it.next();        		
        		if(selObj.getEObject() instanceof EModelElement) {
        			result.add((EModelElement)selObj.getEObject());
        		}
    		}    		
    	}
    	
		if(getViewer() instanceof ContainerCheckedTreeViewer) {
			ContainerCheckedTreeViewer checkedViewer = (ContainerCheckedTreeViewer) getViewer();
			Object[] elements = checkedViewer.getCheckedElements();
			for (int i = 0; i < elements.length; i++) {
				Object nextObject = elements[i];
				EModelElement modelElement = getElementAdapter(nextObject, EModelElement.class); 				
				if(modelElement instanceof EModelElement) { 
					result.add((EModelElement)modelElement);
				}
			}
		}
    	
    	return result;
	}
	
	public <T> T getElementAdapter(Object element, Class<T> adapter) {
		if(!(element instanceof IAdaptable)) {
			return null;
		}
		
		IAdaptable adaptable = (IAdaptable)element;
		Object adapted = adaptable.getAdapter(adapter);
		if(adapted != null) {
			return (T)adapter.cast(adapted);			
		}
		
		return null;
	}
	
	public Composite getControl() {
		return control;
	}

	protected IToolBarManager getToolBarManager() {
		if(toolBarManager != null) {
			return toolBarManager;
		}
		
		ToolBar tb = new ToolBar(control, SWT.FLAT);
		toolBarManager = new ToolBarManager(tb);
		control.setTopLeft(tb);
		return toolBarManager;
	}
	
	protected TreeViewer createTreeViewer(Composite parent) {
		int style = SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL; 
		
		if((browserStyle & CHECK_STYLE) != 0) {
			return new ContainerCheckedTreeViewer(parent, style);
		}
		return new TreeViewer(parent, style); 
	}
	
	private static MetamodelContainerNode createRootMetamodelContainer() {
		return new MetamodelContainerNode(MetamodelContainerNode.GLOBAL_REGISTRY_TYPE, null, null, null);
	}
	
	protected IServiceLocator getServiceLocator() {		
		return org.eclipse.ui.PlatformUI.getWorkbench();		
	}
	
	
	public TreeViewer getViewer() {
		return myViewer;
	}
    
    protected ViewerSorter createSorter() {
        return new ViewerSorter() {
            @Override
			public int category(final Object element) {
                int category = super.category(element);
                if (((BrowserNode) element).getEObject() instanceof EPackage) {
                    return category - 1;
                }
                return category;
            }
            
            @Override
            public int compare(Viewer viewer, Object e1, Object e2) {
            	if(e1 instanceof MetamodelNode && e2 instanceof MetamodelNode) {
            		MetamodelNode n1 = (MetamodelNode) e1;
					MetamodelNode n2 = (MetamodelNode) e2;
					String key1 = n1.getDescriptor().getId();
					String key2 = n2.getDescriptor().getId();

					if(n1.getPackage() != null && isOK(n1.getDescriptor())) {
						key1 = n1.getPackage().getName();
					}
					
					if(n2.getPackage() != null && isOK(n2.getDescriptor())) {
						key2 = n2.getPackage().getName();
					}
					
					return key1.compareTo(key2);
            	}
            	return super.compare(viewer, e1, e2);
            }
        };
    }

    protected ITreeContentProvider createTreeContentProvider() {
        return new ITreeContentProvider() {
            public Object[] getChildren(final Object parentElement) {
                return ((BrowserNode) parentElement).getChildren(myShowInheritedFeatures).toArray();
            }

            public Object getParent(final Object element) {
                return ((BrowserNode) element).getParent();
            }

            public boolean hasChildren(final Object element) {
            	BrowserNode node = (BrowserNode) element;
            	if((browserStyle & SHOW_CLASSIFIER_CONTENTS) == 0 && node.getEObject() instanceof EClassifier) {
            		return false;
            	} else if((browserStyle & SHOW_PACKAGE_CONTENTS) == 0 && node.getEObject() instanceof EPackage) {
            		EPackage ePackage = (EPackage)node.getEObject();
            		if(ePackage.getESubpackages().isEmpty()) {
            			return false;
            		}
            	}
                return ((BrowserNode) element).hasChildren(myShowInheritedFeatures);
            }

            public Object[] getElements(Object inputElement) {
            	if(!hasChildren(inputElement)) {
            		return new Object[0];
            	}
                return getChildren(inputElement);
            }

            public void dispose() {
            }

            public void inputChanged(final Viewer viewer, final Object oldInput, 
                    final Object newInput) {
            }
        };
    }
    
    protected ILabelProvider createLabelProvider() {
    	final ILabelProvider provider = EMFProviderUtil.createLabelProvider(); 
        return new ILabelProvider() {
			public void removeListener(final ILabelProviderListener listener) {
				provider.removeListener(listener);
			}
		
			public boolean isLabelProperty(final Object element, final String property) {
				return provider.isLabelProperty(((BrowserNode) element).getEObject(), property);
			}
		
			public void dispose() {
				provider.dispose();
			}
		
			public void addListener(final ILabelProviderListener listener) {
				provider.addListener(listener);
			}
		
			public String getText(final Object element) {
				BrowserNode node = (BrowserNode) element;
				String availableText = node.getText();
				if(availableText != null) {
					return availableText;
				}
 
				EObject eObject = ((BrowserNode) element).getEObject();
				if (myShowFullQualifiedNames && eObject instanceof EClassifier) {
					EClassifier eClassifier = (EClassifier) eObject;
					StringBuilder text = new StringBuilder();
					text.append(eClassifier.getName());
					if (eClassifier instanceof EClass) {
						EClass eClass = (EClass) eClassifier;
						if (!eClass.getESuperTypes().isEmpty()) {
							text.append(EXTENDED_CLASSES);
							for (Iterator<EClass> iter = eClass.getESuperTypes().iterator(); iter.hasNext();) {
								EClass eSuperType = (EClass) iter.next();
								text.append(EmfUtil.getFullName(eSuperType));
								if (iter.hasNext()) {
									text.append(EXTENDED_CLASSES_SEPARATOR);
								}
							}
						}
					}
					if (eClassifier.getInstanceClassName() != null) {
						text.append(INSTANCE_CLASS_NAME_START);
						text.append(eClassifier.getInstanceClassName());
						text.append(INSTANCE_CLASS_NAME_END);
					}
					return text.toString();
				}
				if (myShowFullQualifiedNames && eObject instanceof ETypedElement) {
					ETypedElement eTypedElement = (ETypedElement) eObject;
					StringBuilder text = new StringBuilder();
					text.append(eTypedElement.getName());
					if (eTypedElement instanceof EOperation) {
						EOperation eOperation = (EOperation) eTypedElement;
						text.append(PARAMETERS_START);
						for (Iterator<EParameter> iter = eOperation.getEParameters().iterator(); iter.hasNext();) {
							EParameter eParameter = (EParameter) iter.next();
							text.append(EmfUtil.getFullName(eParameter.getEType()));
							if (iter.hasNext()) {
								text.append(PARAMETERS_SEPARATOR);
							}
						}
						text.append(PARAMETERS_END);
					}
					if (eTypedElement.getEType() != null) {
						text.append(NAME_AND_TYPE_SEPARATOR);
						text.append(EmfUtil.getFullName(eTypedElement.getEType()));
					}
					return text.toString();
				}
				
				String text = provider.getText(eObject);
	            if (eObject instanceof EPackage && eObject.eContainer() == null) {
	            	String nsURI = ((EPackage) eObject).getNsURI();
	            	if (nsURI != null && nsURI.length() > 0) {
	            		text += " (" + ((EPackage) eObject).getNsURI() + ")";  //$NON-NLS-1$//$NON-NLS-2$
	            	}
	            }
	            return text;
			}
		
			public Image getImage(final Object element) {
				BrowserNode node = (BrowserNode) element;
				Image availableImage = node.getImage();
				if(availableImage != null) {
					return availableImage;
				}
								
				EObject eObject = node.getEObject();
				if (eObject instanceof EPackage) {					
					Image image = MetamodelImageRegistry.INSTANCE.getImage((EPackage) eObject);
					if (image != null) {
						return image;
					}
				}
				return provider.getImage(eObject);
			}
		
		};
    }
    
    protected Object createInput() {
    	final Object[] input = new Object[1];
    	// initializing java generated registry is a long running task
    	BusyIndicator.showWhile(null, new Runnable() {
    		public void run() {
    			input[0] = doCreateInput();
    		}
    	});
    	
    	assert input.length == 1;
    	
    	return input[0];
    }
    
    protected Object doCreateInput() {
        BrowserNode rootContainer = createRootMetamodelContainer();
        
    	BrowserNode globalRegistryNode = new MetamodelContainerNode(
    			MetamodelContainerNode.GLOBAL_REGISTRY_TYPE,
    			Messages.MetamodelBrowserView_platformMetamodelsLabel,
    			CommonPluginImages.getInstance().getImage(CommonPluginImages.METAMODELS), rootContainer);
    	
    	// TODO - add dedicated image to workspace metamodels
        workspaceModels = new MetamodelContainerNode(
        		MetamodelContainerNode.WORKSPACE_MODELS_TYPE,
        		Messages.MetamodelBrowserView_workspaceMetamodelsLabel,        		
        		CommonPluginImages.getInstance().getImage(CommonPluginImages.METAMODELS), rootContainer);    	


        Map<EPackage, IMetamodelDesc> rootNodes = new HashMap<EPackage, IMetamodelDesc>();        
        String[] ids = MetamodelRegistry.getInstance().getMetamodelIds();        
        for (int i = 0; i < ids.length; i++) {
        	try {
                IMetamodelDesc desc = MetamodelRegistry.getInstance().getMetamodelDesc(ids[i]);
                EPackage pack = desc.getModel();
                if (pack != null) {
                	if(pack.getESuperPackage() == null) {
                		rootNodes.put(pack, desc);
                	} else {
                		// Note:
                		// check for empty packages not registered in global EPackage.Registry
                		// but created programmatically as containers, as EMF ignores packages with 
                		// empty content
                		EPackage parent = EmfUtil.getRootPackage(pack);
                		if(parent != pack && !rootNodes.containsKey(parent)) {                 			
                			rootNodes.put(parent, new DelegatingDesc(parent));
                		}
                	}
                }
            } catch (EmfException ignore) {
    			CommonUIPlugin.getPlugin().log(ignore);            	
            }	
        }
 
        for (Map.Entry<EPackage, IMetamodelDesc> rootEntry : rootNodes.entrySet()) {
        	globalRegistryNode.addChild(new MetamodelNode(rootEntry.getValue(), globalRegistryNode, false));    		
		}        
        
        WorkspaceMetamodelProvider ws = new WorkspaceMetamodelProvider(new ResourceSetImpl());
        List<IResource> wsModels = collectWorkspaceMetamodels();
                
        for (IResource res : wsModels) {
			URI resURI = URI.createPlatformResourceURI(res.getFullPath().toString(), false);
			IMetamodelDesc wsMModelDesc = ws.addMetamodel(resURI.toString(), resURI);
			workspaceModels.addChild(new ResourceModelNode(resURI, wsMModelDesc, workspaceModels));			
		}
   
        rootContainer.addChild(globalRegistryNode);
        rootContainer.addChild(workspaceModels);
        return rootContainer;
    }        
    
    /**
     * Synchronizes the browser contents with the given the workspace changes about ecore files.
     * @param wsDelta an object grouping workspace changes related to ecore files.
     */
    void update(WorkspaceMetamodelsDelta wsDelta) {
		if(!wsDelta.isEmpty()) {
			for (IPath addedPath : wsDelta.getAdditions()) {
				metamodelFileAdded(addedPath);
			}
			
			for (IPath modifiedPath : wsDelta.getModifications()) {
				metamodelFileModified(modifiedPath);
			}			
			
			for (IPath deletedPath : wsDelta.getDeletions()) {
				metamodelDeletedFile(deletedPath);
			}
			
			for (Map.Entry<IPath, IPath> entry : wsDelta.getMoves().entrySet()) {
				metamodelDeletedFile(entry.getKey());
				metamodelFileAdded(entry.getValue());
			}
			
			myViewer.refresh();			
		}    	
    }
    
	protected void hookContextMenu() {
		MenuManager menuManager = new MenuManager("#PopupMenu"); //$NON-NLS-1$
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				MetamodelBrowser.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuManager.createContextMenu(myViewer.getControl());
		myViewer.getControl().setMenu(menu);
	}

	protected void contributeToActionBars() {
		fillLocalToolBar(toolBarManager);
	}

	protected void fillContextMenu(final IMenuManager manager) {
		myDrillDownAdapter.addNavigationActions(manager);
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	protected void fillLocalToolBar(IToolBarManager manager) {
		myDrillDownAdapter.addNavigationActions(manager);
        manager.add(new Separator());
        manager.add(myCollapseAllAction);
        manager.add(new Separator());
        manager.add(myShowInheritedFeaturesAction);
        manager.add(myShowFullQualifiedNamesAction);
        
        if(myOpenClassifierAction != null) {
        	manager.add(new Separator());      
        	manager.add(myOpenClassifierAction);
        }
        
        manager.update(true);
	}

	protected void makeActions() {
		myDoubleClickAction = new Action() {
			@Override
			public void run() {
//				ISelection selection = myViewer.getSelection();
//				Object obj = ((IStructuredSelection) selection).getFirstElement();
			}
		};
		
        myCollapseAllAction = new Action() {
            @Override
			public void run() {
                myViewer.collapseAll();
            }
        };
        myCollapseAllAction.setToolTipText(Messages.MetamodelBrowserView_collapseAll);
        myCollapseAllAction.setImageDescriptor(CommonPluginImages.getInstance().getImageDescriptor(CommonPluginImages.COLLAPSE_ALL)); 
        
        myShowInheritedFeaturesAction = new Action(null, IAction.AS_CHECK_BOX) {
        	@Override
			public void run() {
        		myShowInheritedFeatures = isChecked();
        		myViewer.refresh();
        	}
        };
        myShowInheritedFeaturesAction.setToolTipText(Messages.MetamodelBrowserView_showInheritedFeatures);
        myShowInheritedFeaturesAction.setImageDescriptor(CommonPluginImages.getInstance().getImageDescriptor(CommonPluginImages.SHOW_INHERITED_FEATURES)); 
        
        myShowFullQualifiedNamesAction = new Action(null, IAction.AS_CHECK_BOX) {
        	@Override
			public void run() {
        		myShowFullQualifiedNames = isChecked();
        		myViewer.refresh();
        	}
        };
        myShowFullQualifiedNamesAction.setToolTipText(Messages.MetamodelBrowserView_showFullQualifiedNames);
        myShowFullQualifiedNamesAction.setImageDescriptor(CommonPluginImages.getInstance().getImageDescriptor(CommonPluginImages.SHOW_FULL_QUALIFIED_NAMES));
        
        if((browserStyle & SHOW_PACKAGE_CONTENTS) != 0) {
	        myOpenClassifierAction = createFindClassifierAction(myViewer);
	        this.contextService = (IContextService)getServiceLocator().getService(IContextService.class);
	        this.contextService.getShellType(control.getShell());
	        this.contextActivation = contextService.activateContext(CONTEXT_ID);
	        
	        this.handlerService = (IHandlerService)getServiceLocator().getService(IHandlerService.class);
	        this.handlerActivation = handlerService.activateHandler("org.eclipse.m2m.qvt.oml.findClassifier", new ActionHandler(myOpenClassifierAction)); //$NON-NLS-1$
        }
	}

	private Display getDisplay() {
		return getControl().getDisplay();
	}
	
	private void dispose() {
		if(contextActivation != null) {
			contextService.deactivateContext(contextActivation);
		}
		if(handlerActivation != null) {
			handlerService.deactivateHandler(handlerActivation);
		}
	}
	
	private IAction createFindClassifierAction(final TreeViewer viewer) {
		Action action = new Action() {
        	@Override
			public void run() {
        		final List<EPackage> rootPackages = new ArrayList<EPackage>();
        		
        		if(viewer != null) {
        			BusyIndicator.showWhile(getDisplay(), 
        					new Runnable() {
        						public void run() {
        							List<BrowserNode> rootChildren = ((BrowserNode)viewer.getInput()).getChildren(false);
        							for (int i = 0; i < rootChildren.size(); i++) {			
        								collectSearchScopePackages(rootChildren.get(i), rootPackages);        						
        							}
        						}
        					}
        			); // end of show while   
        		}
        		
        		OpenClassifierDialog dialog = new OpenClassifierDialog(viewer.getControl().getShell(), 
        				new ComplexClassifierProvider(Collections.unmodifiableList(rootPackages)));
        		
        		if (dialog.open() == IDialogConstants.OK_ID) {
        			ISelection selection = dialog.getSelection();
        			if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
        				navigate((EClassifier) ((IStructuredSelection) selection).getFirstElement());
        			}
        		}
        	}
        };
        
        action.setToolTipText(Messages.MetamodelBrowserView_openClassifier);
        action.setImageDescriptor(CommonPluginImages.getInstance().getImageDescriptor(CommonPluginImages.OPEN_CLASSIFIER));
        action.setActionDefinitionId(FIND_CLASSIFIER_COMMAND_ID);
        return action;
	}

	private static void collectSearchScopePackages(BrowserNode browserNode, List<EPackage> result) {			
		if(browserNode instanceof MetamodelContainerNode) {
			List<BrowserNode> mmodelNodes = browserNode.getChildren(false);				
			for (int i = 0; i < mmodelNodes.size(); i++) {
				BrowserNode mmNode = mmodelNodes.get(i);				
				collectSearchScopePackages(mmNode, result);
			}
		} else {
			if(browserNode instanceof MetamodelNode) {
				EPackage ePackage = ((MetamodelNode)browserNode).getSearchScopePackage();
				if(ePackage != null) result.add(ePackage);
			} else if(browserNode.getEObject() instanceof EClassifier) {
				EClassifier eClassifier = (EClassifier)browserNode.getEObject();
				EPackage scope = eClassifier.getEPackage();
				if(scope != null) result.add(scope);
			} else if(browserNode.getEObject() instanceof EPackage) {
				result.add((EPackage)browserNode.getEObject());
			}
		}
	}
	
	public EObject navigate(final EModelElement eModelElement) {
		if (myViewer == null) {		
			return null;
		}
		
        BrowserNode targetNode = null;
        Object root = myViewer.getInput();
        if (root instanceof MetamodelContainerNode) {
            MetamodelContainerNode metamodelContainerNode = (MetamodelContainerNode) root;
            targetNode = metamodelContainerNode.resolve(eModelElement);
        } else if (root instanceof BrowserNode) {
            BrowserNode browserNode = (BrowserNode) root;
            targetNode = BrowserNode.findNodeForInstance(browserNode, eModelElement);
        }
		if(targetNode != null) {
			myViewer.setSelection(new StructuredSelection(targetNode), true);
			myViewer.expandToLevel(targetNode, 1);
			myViewer.getControl().setFocus();
			return targetNode.getEObject();
		}
		
		return null;
	}

	protected void hookDoubleClickAction() {
		myViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				myDoubleClickAction.run();
			}
		});
	}
    
	public boolean setFocus() {
        if(myViewer != null) {
            myViewer.getControl().setFocus();
        }
        return false;
    }

    @SuppressWarnings({ "rawtypes" })
	public Object getAdapter(Class key) {
        if (key.equals(IPropertySheetPage.class)) {
            return getPropertySheetPage();
        }

        return null;
    }
    
    public IPropertySheetPage getPropertySheetPage() {
        if (myPropertySheetPage == null) {
            myPropertySheetPage = new PropertySheetPage();
            final AdapterFactoryContentProvider provider = EMFProviderUtil.createAdapterFactoryContentProvider();
            myPropertySheetPage.setPropertySourceProvider(new IPropertySourceProvider() {
                public IPropertySource getPropertySource(Object object) {
                	IPropertySource source = null;
                	if (object instanceof BrowserNode) {
                		source =provider.getPropertySource(((BrowserNode) object).getEObject());
                	} else {
                		source = provider.getPropertySource(object);
                	}
                    if (source == null) {
                        return null;
                    }
                    return new DelegatingPropertySource(source);
                }
            });
        }

        return myPropertySheetPage;
    }
    
    private static List<IResource> collectWorkspaceMetamodels() {
    	final List<IResource> result = new ArrayList<IResource>();
    
    	try {
			ResourcesPlugin.getWorkspace().getRoot().accept(new IResourceProxyVisitor() {
				public boolean visit(IResourceProxy proxy) throws CoreException {
					if(proxy.getType() == IResource.FILE && MetamodelRegistry.isMetamodelFileName(proxy.getName())) {
						result.add(proxy.requestResource());
					}
					return true;
				}
			}, IResource.NONE);
		} catch (CoreException e) {
			CommonUIPlugin.getPlugin().log(e.getStatus());
		}
		
		return result;
    }
    
    private static class DelegatingDesc implements IMetamodelDesc {
		
    	final EPackage ePackage;
    	
    	DelegatingDesc(EPackage delegatedPackage) {
    		assert delegatedPackage != null;
    		this.ePackage = delegatedPackage;    
    	}
    	
    	public String getId() {
    		return ePackage.getNsURI();
		}

		public Diagnostic getLoadStatus() {
			return Diagnostic.OK_INSTANCE;
		}

		public EPackage getModel() {
			return ePackage;
		}

		public boolean isLoaded() {
			return true;
		}    	
    }
    
    private void metamodelFileAdded(IPath ecoreFilePath) {
    	if(this.workspaceModels == null) {
    		return;
    	}
    	
		URI resURI = URI.createPlatformResourceURI(ecoreFilePath.toString(), false);
		WorkspaceMetamodelProvider ws = new WorkspaceMetamodelProvider(new ResourceSetImpl());
		IMetamodelDesc modelFileDesc = ws.addMetamodel(resURI.toString(), resURI);
		
		this.workspaceModels.addChild(new ResourceModelNode(resURI, modelFileDesc, workspaceModels));
    }

    private void metamodelDeletedFile(IPath ecoreFilePath) {
		ResourceModelNode resourceModelNode = findResourceMetamodelNode(ecoreFilePath);
		if(resourceModelNode != null) {
			resourceModelNode.getParent().removeChild(resourceModelNode);
		}
    }
    
    private void metamodelFileModified(IPath ecoreFilePath) {
		ResourceModelNode resourceModelNode = findResourceMetamodelNode(ecoreFilePath);
		if(resourceModelNode != null) {			
			URI resourceURI = resourceModelNode.uri;
			
			WorkspaceMetamodelProvider ws = new WorkspaceMetamodelProvider(new ResourceSetImpl());			
			IMetamodelDesc modelFileDesc = ws.addMetamodel(resourceURI.toString(), resourceURI);
			
			ResourceModelNode newNode = new ResourceModelNode(resourceURI, modelFileDesc, workspaceModels);
			
			resourceModelNode.getParent().removeChild(resourceModelNode);	
			resourceModelNode.getParent().addChild(newNode);

			myViewer.collapseToLevel(resourceModelNode, 2);
		}
    }
    
    private ResourceModelNode findResourceMetamodelNode(IPath ecoreFilePath) {
    	if(this.workspaceModels == null) {
    		return null;
    	}
    	
		URI resURI = URI.createPlatformResourceURI(ecoreFilePath.toString(), false);
		for (ListIterator<BrowserNode> it = workspaceModels.getChildren(false).listIterator(); it.hasNext();) {
			BrowserNode child = it.next();			
			if(child instanceof ResourceModelNode) {
				ResourceModelNode resourceModelNode = (ResourceModelNode) child;
				if(resURI.equals(resourceModelNode.uri)) {
					return resourceModelNode;
				}
			}
		}
		return null;
    }

	private static class ClassifierContentsFilter extends ViewerFilter {
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			BrowserNode node = (BrowserNode) parentElement;
			return !(node.getEObject() instanceof EClass);
		}
	};
	
	private static class PackageContentsFilter extends ViewerFilter {
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			BrowserNode node = (BrowserNode) element;
			BrowserNode parentNode = (BrowserNode) parentElement;
			return !(parentNode.getEObject() instanceof EPackage) || node.getEObject() instanceof EPackage;
		}
	};   
	
	private static boolean isOK(IMetamodelDesc metamodelDesc) {
		return EmfUtilPlugin.isSuccess(metamodelDesc.getLoadStatus());
	}
}