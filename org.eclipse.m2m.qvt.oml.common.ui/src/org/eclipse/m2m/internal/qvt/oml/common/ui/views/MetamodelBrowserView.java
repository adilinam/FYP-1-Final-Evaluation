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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.CommonUIPlugin;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.m2m.internal.qvt.oml.common.CommonPlugin;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.services.IServiceLocator;


/**
 * @author vrepeshko
 */
public class MetamodelBrowserView extends ViewPart implements IResourceChangeListener {
	
	public static final String ID = "org.eclipse.m2m.internal.qvt.oml.common.views.MetamodelBrowserView"; //$NON-NLS-1$
	
    private MetamodelBrowser browser;
    
    /**
     * Default constructor.
     */
    public MetamodelBrowserView() {
    	super();
    	
    	ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
    }

    public void resourceChanged(IResourceChangeEvent event) {
    	try {
    		handleResourceChanged(event);
    	} catch (Exception e) {
    		CommonUIPlugin.getPlugin().log(e);
		}
    }
    
    private void handleResourceChanged(IResourceChangeEvent event) {    	
    	IResourceDelta delta = event.getDelta();
    	if(delta == null) {
    		// nothing applicable
    		return;
    	}
    	
        final WorkspaceMetamodelsDelta wsDelta = new WorkspaceMetamodelsDelta();    		
    	try {
			delta.accept(new IResourceDeltaVisitor() {
				public boolean visit(IResourceDelta delta) throws CoreException {
					if(delta.getResource().getType() == IResource.FILE && MetamodelRegistry.isMetamodelFileName(delta.getResource().getName())) {
						if(delta.getKind() == IResourceDelta.ADDED) {
					    	wsDelta.addAddition(delta.getFullPath());
						} else if(delta.getKind() == IResourceDelta.REMOVED) {
							wsDelta.addDeletion(delta.getFullPath());						
						} else if(delta.getKind() == IResourceDelta.CHANGED) { 
							wsDelta.addModification(delta.getFullPath());						
						} else if(delta.getKind() == IResourceDelta.MOVED_FROM) {
							wsDelta.addMove(delta.getMovedFromPath(), delta.getMovedToPath());
						}
					}
					return true;
				}
			});
		} catch (CoreException e) {
			CommonPlugin.log(e);
		}
		
		getSite().getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				if(!browser.getControl().isDisposed()) {
					if(!wsDelta.isEmpty()) {
						browser.update(wsDelta);
					}
				}
			}
		});
    }
    
	public EObject navigate(EModelElement eModelElement) {
		if(browser != null) {
			return browser.navigate(eModelElement);
		}
		return null;
	}
		
    @Override
	public void createPartControl(final Composite parent) {

		browser = new MetamodelBrowser(parent) {
			@Override
			protected IServiceLocator getServiceLocator() {			
				//return org.eclipse.ui.PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite();
				return MetamodelBrowserView.this.getSite();
			}
			
			@Override
			protected IToolBarManager getToolBarManager() {
				return MetamodelBrowserView.super.getViewSite().getActionBars().getToolBarManager();
			}
		};

		getSite().setSelectionProvider(browser.getViewer());
	} 
            	
    @Override
	public void setFocus() {
        if(browser != null) {
            browser.setFocus();
        }
    }

    @SuppressWarnings({ "rawtypes" })
	@Override
	public Object getAdapter(Class key) {
        Object adaptedObject = browser != null ? browser.getAdapter(key) : null;
        if(adaptedObject == null) {
            adaptedObject = super.getAdapter(key);
        }
        
        return adaptedObject;
    }
    
    @Override
    public void dispose() {
    	ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
    	
    	super.dispose();
    }
}