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
package org.eclipse.m2m.internal.qvt.oml.common.ui.launch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.provider.EMFLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;


public class ReferenceSelectionDialog extends Dialog {
	public ReferenceSelectionDialog(EClass cls, EReference initialSelection, Shell shell) {
		this(cls,initialSelection, shell, IRefFilter.DEFAULT);
	}	
	
	public ReferenceSelectionDialog(EClass cls, EReference initialSelection, Shell shell, IRefFilter refFilter) {
		super(shell);
        setShellStyle(getShellStyle() | SWT.RESIZE);        
		myClass = cls;
		myInitialSelection = initialSelection;
		myRefFilter = refFilter;
		myRoot = new Object();
	}
	
    @Override
	protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.ReferenceSelectionDialog_Title);
    }
	
	public EReference getReference() {
		return myReference;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		
        myViewer = new TreeViewer(composite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        myViewer.setContentProvider(CONTENT_PROVIDER);
        myViewer.setLabelProvider(new EMFLabelProvider());
        myViewer.addSelectionChangedListener(VIEWER_LISTENER);
        
        GridData data = new GridData(GridData.FILL_BOTH);
        data.heightHint = 250;
        data.widthHint = 350;
        myViewer.getControl().setLayoutData(data);
        
        myViewer.setInput(myRoot);
        
    	myViewer.expandAll();
        if(myInitialSelection != null) {
        	myViewer.setSelection(new StructuredSelection(myInitialSelection), true);
        }
		
		return composite;
	}
	
	public EClass getEClass() {
		return myClass;
	}
	
	private final Object myRoot;
	private final EClass myClass;
	private final EReference myInitialSelection;
	private final IRefFilter myRefFilter;
	private EReference myReference;	
	private TreeViewer myViewer;
	
	private IContentProvider CONTENT_PROVIDER = new ITreeContentProvider() {
		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof EClass) {
				EClass cls = (EClass)parentElement;
				List<EReference> validRefs = new ArrayList<EReference>();
				for(EReference ref : cls.getEAllContainments()) {
					if(myRefFilter == null || myRefFilter.accept(ref)) {
						validRefs.add(ref);
					}
				}
				
				return validRefs.toArray();
			}
			
			return new Object[0];
		}

		public Object getParent(Object element) {
			if(element instanceof EReference) {
				return myClass;
			}
			
			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}

		public Object[] getElements(Object inputElement) {
			if(inputElement == myRoot) {
				return new Object[] { myClass };
			}
			
			return new Object[0];
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	};
	
	private ISelectionChangedListener VIEWER_LISTENER = new ISelectionChangedListener() {
		public void selectionChanged(SelectionChangedEvent event) {
            IStructuredSelection selection = (IStructuredSelection)event.getSelection();
            if(selection.getFirstElement() instanceof EReference == false) {
            	myReference = null;
            }
            else {
            	myReference = (EReference)selection.getFirstElement();
            }
            
            Button button = getButton(IDialogConstants.OK_ID); 
            if(button != null && !button.isDisposed()) {
            	button.setEnabled(myReference != null);
            }
		}
	};
	
	public static interface IRefFilter {
		boolean accept(EReference ref);
		
		IRefFilter DEFAULT = new IRefFilter(){
			public boolean accept(EReference ref) {
				return ref.isChangeable();
			}
		};
	}
	
}
