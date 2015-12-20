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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ITextPresentationListener;
import org.eclipse.jface.text.ITextViewerExtension;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.actions.OpenDeclarationAction;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.QVTColorManager;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.SemanticHighlightingManager;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.outline.QvtOutlineContentProvider;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.outline.QvtOutlineInput;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.outline.QvtOutlineLabelProvider;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.outline.QvtOutlineNodeSelector;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.outline.QvtOutlineSelectionListener;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.project.builder.QVTOBuilder;
import org.eclipse.m2m.internal.qvt.oml.project.builder.QVTOBuilderConfig;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;


public class QvtEditor extends TextEditor implements IQVTReconcilingListener {
	
	public final static String ID = "org.eclipse.m2m.qvt.oml.editor.ui.QvtEditor"; //$NON-NLS-1$
    public final static String MATCHING_BRACKETS = "matchingBrackets"; //$NON-NLS-1$
    public final static String MATCHING_BRACKETS_COLOR = "matchingBracketsColors"; //$NON-NLS-1$
    protected final static char[] BRACKETS= { '{', '}', '(', ')', '[', ']' };
    
	private static final String QVT_EDITOR_UI_CONTEXT = "org.eclipse.m2m.qvt.oml.editor.ui.context"; //$NON-NLS-1$
	
	// copied from 'org.eclipse.jdt.ui.JavaUI' in order to remove dependencies on "org.eclipse.jdt.ui" plug-in
	private static final String ID_PACKAGES = "org.eclipse.jdt.ui.PackageExplorer"; //$NON-NLS-1$


	
    private ProjectionSupport myProjectionSupport;    
    private ContentOutlinePage myOutlinePage;
    private TreeViewer myTreeViewer;
    private QVTColorManager myColorManager;
    private QvtPairMatcher myBracketMatcher = new QvtPairMatcher(BRACKETS);
    private QvtEditorSelectionChangedListener mySelectionChangedListener;
    private QvtOutlineSelectionListener myOutlineSelectionListener;
    private QvtOutlineNodeSelector myOutlineSelector;
    private BracketInserter myBracketInserter;

    private ASTProvider fASTProvider; 
    
    private UnitProxy fUnitProxy;
    
    private Object fASTProviderLock = new Object();
    
    private QvtReconciler fReconciler;
    
    private OverrideIndicatorManager fOverrideIndicatorManager;
    
    private FoldingStructureUpdater fFoldingUpdater;
    
    private List<IQVTReconcilingListener> fReconcileListeners = new LinkedList<IQVTReconcilingListener>();
    
    
    public QvtEditor() {
        
        setRulerContextMenuId("#QvtoEditorRulerContext"); //$NON-NLS-1$
        setEditorContextMenuId("#QvtoEditorContext");   //$NON-NLS-1$
        
        //QVTOBuilder.addBuildListener(myBuildListener);        
    }
        
    @Override
    protected void initializeKeyBindingScopes() {
    	setKeyBindingScopes(new String[] { QVT_EDITOR_UI_CONTEXT });    
    }
    
    @Override
	public void dispose() {
        if(myBracketMatcher != null) {
            myBracketMatcher.dispose();
            myBracketMatcher = null;
        }
        
        if(myColorManager != null) {
            myColorManager.dispose();
            myColorManager = null;
        }
        
        if (mySelectionChangedListener != null) {
        	mySelectionChangedListener.uninstall();
        	mySelectionChangedListener = null;
        }
        
        if(myBuildListener != null) {
            QVTOBuilder.removeBuildListener(myBuildListener);
            myBuildListener = null;
        }
        
        if(fASTProvider != null) {
        	fASTProvider.dispose();
        }
        
        super.dispose();
    }
    
    @Override
    protected void doSetInput(IEditorInput input) throws CoreException {
    	super.doSetInput(input);
    	
    	// FIXME - should handle bundle units too 
    	if(input instanceof IFileEditorInput) {
    		IFileEditorInput fileInput = (IFileEditorInput) input; 
    		fUnitProxy = UnitResolverFactory.Registry.INSTANCE.getUnit(URIUtils.getResourceURI(fileInput.getFile()));
    	}

    	if(isEditingInQVTSourceContainer(input)) {
    		installProblemUpdater();
    	}
    	installOverrideIndicator();
    }
    
	protected void installProblemUpdater() {
		IAnnotationModel annotationModel = getDocumentProvider().getAnnotationModel(getEditorInput());
		if(annotationModel != null) {
			addReconcilingListener(new ProblemUpdater(annotationModel));			
		}
	}
    
	protected void installOverrideIndicator() {
		IAnnotationModel model = getDocumentProvider().getAnnotationModel(getEditorInput());
		if(model != null) {
			fOverrideIndicatorManager = new OverrideIndicatorManager(model);
			addReconcilingListener(fOverrideIndicatorManager);
		}
	}
		
	public void aboutToBeReconciled() {
		IQVTReconcilingListener[] listeners = null;
		synchronized (fReconcileListeners) {
			listeners = fReconcileListeners.toArray(new IQVTReconcilingListener[fReconcileListeners.size()]);
		}
		
		for (IQVTReconcilingListener listener : listeners) {
			listener.aboutToBeReconciled();
		}
	}
	
	public void reconciled(CompiledUnit unit, IProgressMonitor monitor) {
		IQVTReconcilingListener[] listeners = null;
		synchronized (fReconcileListeners) {
			listeners = fReconcileListeners.toArray(new IQVTReconcilingListener[fReconcileListeners.size()]);
		}
		
		for (IQVTReconcilingListener listener : listeners) {
			if(monitor != null && monitor.isCanceled()) {
				break;
			}
			listener.reconciled(unit, monitor);
		}

		// Update QVT Outline page selection
		if (monitor != null && !monitor.isCanceled()) {
			refresh(unit);
		}
	}
    
    public UnitProxy getUnit() {
    	return fUnitProxy;
    }
    
    @Override
	public void doSave(IProgressMonitor progress) {
        super.doSave(progress);
        CompiledUnit unit = ((QvtDocumentProvider)getDocumentProvider()).getCompiledModule();
        if(unit != null) {
        	refresh(unit);
        }
    }
    
    void selectionChanged(final TextSelection selection) {
        if (myTreeViewer != null && !myTreeViewer.getControl().isDisposed()) {
            myTreeViewer.removeSelectionChangedListener(myOutlineSelectionListener);
            
            try {
	            if(isOutlineVisible()) {            
	            	myOutlineSelector.selectCorrespondingNode(selection);
	            }
            } catch(RuntimeException e) {
            	Activator.log(e);
            }
            
            myTreeViewer.addSelectionChangedListener(myOutlineSelectionListener);
        }
        
        updateStatusLine();
    }
    
	protected void updateStatusLine() {
		setStatusLineErrorMessage(null);
		setStatusLineMessage(null);
	}
    
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class required) {
        if (IContentOutlinePage.class.equals(required)) {
            return myOutlinePage;
        }
        if (IShowInTargetList.class.equals(required)) {
            return new IShowInTargetList() {

                public String[] getShowInTargetIds() {
                    return new String[] {
                            IPageLayout.ID_PROJECT_EXPLORER,
                            ID_PACKAGES
                    };
                }
                
            };
        }
        
        if(UnitProxy.class.equals(required)) {
        	return getUnit();
        }
        return super.getAdapter(required);
    }

    /**
     * Forces the reconciler of this editor to reconcile (if available)
     */
    public void forceReconciling() {
    	SrcViewer srcViewer = (SrcViewer) getSourceViewer();
    	IReconciler reconciler = srcViewer.getReconciler();
    	
    	if(reconciler instanceof QvtReconciler) {
    		QvtReconciler qvtReconciler = (QvtReconciler) reconciler;
    		qvtReconciler.doForceReconciling();
    		return;
    	}
    	
    	if(fReconciler != null) {
    		fReconciler.doForceReconciling();
    	}
    }
    
    public ISourceViewer getSourceViewerOpened() {
        return getSourceViewer();
    }
    
    public QvtDocumentProvider getQVTDocumentProvider() {
    	// We know for sure we set this kind of provider
		return (QvtDocumentProvider) getDocumentProvider();
    }
    
    @Override
    protected void initializeEditor() {
    	super.initializeEditor();

        setDocumentProvider(new QvtDocumentProvider());    	
    	setPreferenceStore(createCombinedPreferenceStore(null));
        
        myColorManager = new QVTColorManager(getPreferenceStore(), Activator.getDefault().getColorManager());
		setSourceViewerConfiguration(new QvtConfiguration(this, myColorManager, getPreferenceStore()));
    }
 
	@Override
	protected void handlePreferenceStoreChanged(PropertyChangeEvent event) {
		try {
			if (myColorManager != null) {
				myColorManager.propertyChange(event);
				getSourceViewer().invalidateTextPresentation();
			}
		} finally {
			super.handlePreferenceStoreChanged(event);
		}
	}
    
    @Override
	public void createPartControl(Composite parent) {

        super.createPartControl(parent);
        
        myOutlinePage = new ContentOutlinePage() {
            @Override
			public void createControl(Composite parent) {
                super.createControl(parent);
                myTreeViewer = getTreeViewer();
                myTreeViewer.setContentProvider(new QvtOutlineContentProvider());
                myTreeViewer.setLabelProvider(new QvtOutlineLabelProvider());
                myOutlineSelectionListener = new QvtOutlineSelectionListener(QvtEditor.this.getSourceViewerOpened());
                myTreeViewer.addSelectionChangedListener(myOutlineSelectionListener);
                myTreeViewer.addDoubleClickListener(myOutlineSelectionListener);
                myOutlineSelector = new QvtOutlineNodeSelector(myTreeViewer);
                myTreeViewer.setInput(new QvtOutlineInput());
                myTreeViewer.getControl().addDisposeListener(new DisposeListener() {
				
					public void widgetDisposed(DisposeEvent e) {
						myTreeViewer.removeSelectionChangedListener(myOutlineSelectionListener);
						myTreeViewer.removeDoubleClickListener(myOutlineSelectionListener);
						myTreeViewer = null;
						myOutlineSelectionListener = null;
						myOutlineSelector = null;
					}
				
				});
               // refresh();
            }                   
        };
        
        mySelectionChangedListener = new QvtEditorSelectionChangedListener(this);
        mySelectionChangedListener.install();
        
        myProjectionSupport = new ProjectionSupport(getProjectionSourceViewer(), getAnnotationAccess(), getSharedColors());
//		myProjectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.error"); //$NON-NLS-1$
//		myProjectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.warning"); //$NON-NLS-1$
//		myProjectionSupport.setHoverControlCreator(new IInformationControlCreator() {
//			public IInformationControl createInformationControl(Shell shell) {
//				return new CustomSourceInformationControl(shell, IDocument.DEFAULT_CONTENT_TYPE);
//			}
//		});
		myProjectionSupport.install();

		getProjectionSourceViewer().doOperation(ProjectionViewer.TOGGLE);
		
		ISourceViewer sourceViewer = getSourceViewer();
        if (sourceViewer instanceof ITextViewerExtension) {
            if (myBracketInserter == null) {
            	myBracketInserter = new BracketInserter(getSourceViewer());
            }
            ((ITextViewerExtension) sourceViewer).prependVerifyKeyListener(myBracketInserter);
        }

        initASTProvider();
    	IDocumentProvider documentProvider = getDocumentProvider();
    	if(documentProvider != null) {
    		IDocument document = documentProvider.getDocument(this.getEditorInput());
    		if(document != null) {    			
    			ProjectionViewer projectionSourceViewer = getProjectionSourceViewer();
    			if(projectionSourceViewer != null) {
	    			fFoldingUpdater = new FoldingStructureUpdater(projectionSourceViewer);
	    			addReconcilingListener(fFoldingUpdater);
    			}
    		}
    	}    
    	
    	// install semantical highlighting
		new SemanticHighlightingManager().install(this,
				(SrcViewer) sourceViewer, myColorManager, getPreferenceStore());
    	
    }

	private void initASTProvider() {
		synchronized (fASTProviderLock) {
        	fASTProvider = new ASTProvider();
        	addReconcilingListener(fASTProvider);
        	
        	// notify possible waiting clients
        	fASTProviderLock.notifyAll();
        }
	}
        
    private ProjectionViewer getProjectionSourceViewer() {
    	return (ProjectionViewer) getSourceViewer();
    }
    
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		try {
			super.init(site, input);
		}
		catch(PartInitException e) {
			Logger.getLogger().log(Logger.SEVERE, "Failed to initialize QVT editor", e); //$NON-NLS-1$
			throw e;
		}		
	}
	    
    public int getTabWidth() {
        return getSourceViewerConfiguration().getTabWidth(getSourceViewer());
    }
    
    @Override
	protected void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
        support.setCharacterPairMatcher(myBracketMatcher);
        support.setMatchingCharacterPainterPreferenceKeys(MATCHING_BRACKETS, MATCHING_BRACKETS_COLOR);        
        super.configureSourceViewerDecorationSupport(support);
    }
    
    @Override
	protected void createActions() {
        super.createActions();
        IAction action = new ContentAssistAction(ActionMessages.getResourceBundle(), "ContentAssistProposal.", this); //$NON-NLS-1$
        action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
        setAction("ContentAssistProposal", action); //$NON-NLS-1$
		markAsStateDependentAction("ContentAssistProposal", true); //$NON-NLS-1$
		
		action = new OpenDeclarationAction(ActionMessages.getResourceBundle(), "OpenDeclaration.", this); //$NON-NLS-1$
 
		setAction(action.getActionDefinitionId(), action);
    }
    
    
    private void refresh(final CompiledUnit unit) {
        IWorkbenchPartSite s = getSite();
        if (s == null) {
            return;
        }
        if(s.getShell() == null || s.getShell().isDisposed() || s.getShell().getDisplay() == null ||
        	s.getShell().getDisplay().isDisposed()) {
        	// NPE and disposed status check
        	return;
        }
        s.getShell().getDisplay().asyncExec(new Runnable() {
            public void run() {
            	if (myTreeViewer != null && !myTreeViewer.getControl().isDisposed()) {
                    if (unit != null) {
                    	QvtOutlineInput input = (QvtOutlineInput) myTreeViewer.getInput();
                    	input.compilationUnitUpdated(unit);
                        myTreeViewer.refresh();
                        if(getSelectionProvider() != null) {
                        	selectionChanged((TextSelection)getSelectionProvider().getSelection());
                        }
                    }
                }
            }
        });
    }
    
    /**
	 * Returns the annotation model to be used for problem reporting or
	 * <code>null</code> in case the editor's part has not been created or
	 * has been disposed.
	 * 
	 * @return the annotation model to be used for problem reporting or
	 *         <code>null</code>
	 */
    public IAnnotationModel getAnnotationModel() {
    	ISourceViewer sourceViewer = getSourceViewer();
		return (sourceViewer != null) ? sourceViewer.getAnnotationModel() : null;
    }
    
    @Override
	protected ISourceViewer createSourceViewer(final Composite parent, final IVerticalRuler ruler, final int styles) {
        ProjectionViewer viewer = new SrcViewer(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles);
        
        // ensure decoration support has been created and configured.
        getSourceViewerDecorationSupport(viewer);
        
        return viewer;
    }
    
    // FIXME
    private QVTOBuilder.BuildListener myBuildListener = new QVTOBuilder.BuildListener() {
        public void buildPerformed() {
            //refresh();
        }
    };
    
    public QvtConfiguration getQvtConfiguration() {
    	return (QvtConfiguration) getSourceViewerConfiguration();
    }

    public ISourceViewer getEditorSourceViewer() {
    	return getSourceViewer();
    }
 
    /**
     * Retrieves module AST from the edited QVT module.
     * 
     * @param timeoutInMilisec number of milliseconds to wait if the a valid () AST is not available right-away
     * 			Note: The argument semantics conforms to Object::wait(long)
     *   
     * @return compilation unit or <code>null</code> if it was not available within the specified timeout  
     */
    public CompiledUnit getValidCompiledModule(long timeoutInMilisec) {
    	return fASTProvider.getValidCompiledModule(timeoutInMilisec);
    }
    
    IQVTReconcilingListener getReconcilingListener() {

    	synchronized (fASTProviderLock) {
    		while(fASTProvider == null) {
    			try {    				
					fASTProviderLock.wait();					
				} catch (InterruptedException e) {
					// do nothing 
				}
    		}
    	}
    	
    	return fASTProvider;
    }
 
	public void addReconcilingListener(IQVTReconcilingListener listener) {
		synchronized (fReconcileListeners) {		
			fReconcileListeners.add(listener);
		}
	}
	
	public boolean removeReconcilingListener(IQVTReconcilingListener listener) {
		synchronized (fReconcileListeners) {		
			return fReconcileListeners.remove(listener);
		}
	}	
        
	private static boolean isEditingInQVTSourceContainer(IEditorInput editorInput) {
		if(editorInput instanceof IFileEditorInput == false) {
			return false;
		}
		
		IFile file = ((IFileEditorInput) editorInput).getFile();
		if(file != null && file.exists()) {
			try {
				IContainer srcContainer = QVTOBuilderConfig.getConfig(file.getProject()).getSourceContainer();
				if(srcContainer.exists()) {
					IPath editedPath = file.getFullPath();
					IPath srcPath = srcContainer.getFullPath();
					return srcPath.isPrefixOf(editedPath);
				}
			} catch (CoreException e) {
				QvtPlugin.getDefault().log(e.getStatus());
			}
		}
		return false;
	}    

	private boolean isOutlineVisible() {
		if(getSite() == null) {
			return false;
		}
		
		if(getSite().getPage() != null) {
	    	IViewPart findView = getSite().getPage().findView("org.eclipse.ui.views.ContentOutline"); //$NON-NLS-1$
	    	if(findView != null && findView.getViewSite().getPage().isPartVisible(findView)) {
	    		return true;
	    	}
		}
		
		return false;
	}
	
	private IPreferenceStore createCombinedPreferenceStore(IEditorInput input) {
		List<IPreferenceStore> stores = new ArrayList<IPreferenceStore>(3);
		stores.add(Activator.getDefault().getPreferenceStore());
		stores.add(EditorsUI.getPreferenceStore());
		return new ChainedPreferenceStore(stores.toArray(new IPreferenceStore[stores.size()]));
	}

    private class ASTProvider implements IQVTReconcilingListener {
    	private IDocumentListener fDocListener;
        private boolean fNeedsReconciling = true;
        private long fModifyTimeStamp = 0;
        private long fStartReconcileTimeStamp = 0;
    	private Object fLock = new Object();
 
    	public ASTProvider() {    		
    		IDocument doc = getDoc();
			if(doc == null) {
    			throw new IllegalStateException("Editor source viewer document must be available"); //$NON-NLS-1$
    		}
    		
			fDocListener = new IDocumentListener() {
				public void documentAboutToBeChanged(DocumentEvent event) {
			    	synchronized(fLock) {
			    		fNeedsReconciling = true;
			    		fModifyTimeStamp = event.fModificationStamp;
			    	}
				}
				
				public void documentChanged(DocumentEvent event) {
					// do nothing        				
				}
			};
			
			doc.addDocumentListener(fDocListener);
		}
    	
        public CompiledUnit getValidCompiledModule(long timeoutInMilisec) {
        	QvtDocumentProvider documentProvider = (QvtDocumentProvider) getDocumentProvider();
        	synchronized (fLock) {
        		while(fNeedsReconciling) {
        			try {
    					fLock.wait(timeoutInMilisec);
    					if(fNeedsReconciling) {
    						// time-outed
    						return null;
    					}
    				} catch (InterruptedException e) {
    					return null;
    				}
        		}
        		return documentProvider.getCompiledModule();
    		}
        }    	
    	
	    public void aboutToBeReconciled() {
	    	synchronized(fLock) {    	
	    		fStartReconcileTimeStamp = fModifyTimeStamp;
	    	}
	    }
	    
	    public void reconciled(CompiledUnit unit, IProgressMonitor monitor) {
	    	synchronized(fLock) {
	        	if(fModifyTimeStamp == fStartReconcileTimeStamp) {
	        		fNeedsReconciling = false;
	        	}
	        		        	
	        	// wake-up clients waiting for AST
	    		fLock.notifyAll();
	    	}
	    }

	    private IDocument getDoc() {
	   		ISourceViewer viewer = getEditorSourceViewer();
			if(viewer != null) { 
				return viewer.getDocument();
    		}	    	
			return null;
	    }
	    
	    void dispose() {
	   		IDocument doc = getDoc();
	   		if(doc != null) {
	   			doc.removeDocumentListener(fDocListener);
	   		}
	    }
    }
    
    public static class SrcViewer extends ProjectionViewer {
    	
		public SrcViewer(Composite parent, IVerticalRuler verticalRuler,
				IOverviewRuler overviewRuler, boolean showAnnotationsOverview,
				int styles) {
			super(parent, verticalRuler, overviewRuler,
					showAnnotationsOverview, styles);
		}
		
		IReconciler getReconciler() {
			return fReconciler;
		}
    	
    	@SuppressWarnings("unchecked")
		public void prependTextPresentationListener(ITextPresentationListener listener) {

    		if (fTextPresentationListeners == null)
    			fTextPresentationListeners = new ArrayList<Object>();

    		fTextPresentationListeners.remove(listener);
    		fTextPresentationListeners.add(0, listener);
    	}    	
    }
}