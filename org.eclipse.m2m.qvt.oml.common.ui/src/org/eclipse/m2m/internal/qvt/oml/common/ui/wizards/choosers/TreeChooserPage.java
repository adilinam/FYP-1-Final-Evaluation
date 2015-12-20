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
package org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.choosers;

import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.metamodel.ChooserNode;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.metamodel.ChooserNodeContentProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.metamodel.EPackageDecoratingLabelProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.metamodel.EPackageSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;


public abstract class TreeChooserPage extends WizardPage {
    
    public TreeChooserPage(String pageId, String title, boolean useCheckboxes, String helpId) {
        super(pageId);
        myTitle = title;
        myHelpId = helpId;
        myUseCheckboxes = useCheckboxes;
    }
    
    /**
     * Implement to validate page
     * @return <code>true</code> if page is valid, <code>false</code> otherwise
     */
    protected abstract boolean validatePage();
    
    /**
     * A factory method for myViewer object creation
     */
    protected AbstractTreeViewer createViewer(Composite parent, int style) {
        return new TreeViewer(parent, style);
    }
    
    /**
     * Implement to specify root elements of the tree 
     * @return an array of ChooserNode objects which will be root elements in the tree
     */
    protected abstract ChooserNode[] getTreeRoots();

    public void createControl(Composite parent) {
        setPageComplete(false);
        Composite composite = new Composite(parent, SWT.NULL);
        composite.setLayout(new GridLayout());
        
        Label firstLabel = new Label(composite, SWT.LEFT);
        firstLabel.setText(myTitle);
        
        int style = SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER;
        myViewer = createViewer(composite, style);
        
        if(myViewer.getContentProvider() == null) {
        	myViewer.setContentProvider(CONTENT_PROVIDER);
        }
        
        if(myViewer.getSorter() == null) {
        	myViewer.setSorter(VIEWER_SORTER);
        }
        
        if(myViewer.getLabelProvider() == null) {
        	myViewer.setLabelProvider(LABEL_PROVIDER);
        }

        GridData data = new GridData(GridData.FILL_BOTH);
        data.heightHint = 250;
        data.grabExcessHorizontalSpace = true;
        data.grabExcessVerticalSpace = true;
        myViewer.getControl().setLayoutData(data);
        
        if(myViewer.getInput() == null) {
        	myViewer.setInput(getTreeRoots());
        }
        setupViewer(myViewer);
        
        setControl(composite);
        setPageComplete(validatePage());
        
        PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, myHelpId); 
    }
    
    /**
     * Called after myViewer is created and initialized
     * Override to perform some actions 
     * (add listener or expand some nodes for example)
     * @param viewer - the viewer used
     */
    protected void setupViewer(AbstractTreeViewer viewer) {
        viewer.addSelectionChangedListener(new ISelectionChangedListener() {
            public void selectionChanged(SelectionChangedEvent event) {
                setPageComplete(validatePage());
                if (isCurrentPage()) {
                    getContainer().updateButtons();
                }
            }
        });
    }
    
    @Override
	public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            myViewer.getControl().setFocus();
        }
    }
    
    /**
     * @return tree viewer selection
     */
    public ISelection getSelection() {
        return myViewer.getSelection();        
    }
    
    /**
     * @return whether the tree view displays checkboxes
     */
    public boolean isUseCheckboxes() {
        return myUseCheckboxes;
    }

    protected AbstractTreeViewer getViewer() {
        return myViewer;
    }
    
    private final boolean myUseCheckboxes;
    private AbstractTreeViewer myViewer;
    private final String myHelpId;
    private final String myTitle;
    
    private static final ITreeContentProvider CONTENT_PROVIDER = new ChooserNodeContentProvider();
    private static final ILabelProvider LABEL_PROVIDER = new EPackageDecoratingLabelProvider();
    private static final ViewerSorter VIEWER_SORTER = new EPackageSorter();
}
