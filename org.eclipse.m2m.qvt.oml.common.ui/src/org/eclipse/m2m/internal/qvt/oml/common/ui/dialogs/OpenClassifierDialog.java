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
package org.eclipse.m2m.internal.qvt.oml.common.ui.dialogs;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.provider.EMFProviderUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


/**
 * @author vrepeshko
 */
public class OpenClassifierDialog extends Dialog implements ISelectionProvider {

	public OpenClassifierDialog(final Shell parentShell, final IClassifierProvider classifierProvider) {
		super(parentShell);
		myClassifierProvider = classifierProvider;
	}
	
	public ISelection getSelection() {
		return mySelection;
	}
	
	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		throw new UnsupportedOperationException();
	}
	
	public void removeSelectionChangedListener(final ISelectionChangedListener listener) {
		throw new UnsupportedOperationException();
	}
	
	public void setSelection(final ISelection selection) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean close() {
		if (!myResultsViewer.getSelection().isEmpty()) {
			mySelection = myResultsViewer.getSelection();
		}
		return super.close();
	}
	
	@Override
	protected void configureShell(final Shell newShell) {
		super.configureShell(newShell);
		newShell.setMinimumSize(500, 400);
		newShell.setText(Messages.OpenClassifierDialog_title);
	}
	
	@Override
	protected Control createDialogArea(final Composite parent) {
		 Composite composite = (Composite) super.createDialogArea(parent);

		 composite.setLayout(new GridLayout(1, true));
		 
		 Label queryLabel = new Label(composite, SWT.LEFT);
		 queryLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		 queryLabel.setText(Messages.OpenClassifierDialog_queryLabel);
		 
		 myQueryText = new Text(composite, SWT.LEFT | SWT.SINGLE | SWT.BORDER);
		 myQueryText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		 myQueryText.addModifyListener(createQueryModifyListener());
		 myQueryText.addKeyListener(createQueryKeyListener());
		 myQueryText.setFocus();
		 
		 Label resultsLabel = new Label(composite, SWT.LEFT);
		 resultsLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		 resultsLabel.setText(Messages.OpenClassifierDialog_resultsLabel);
		 
		 myResultsViewer = new TableViewer(composite, SWT.SINGLE | SWT.BORDER);
		 myResultsViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		 myResultsViewer.setContentProvider(createContentProvider());
		 myResultsViewer.setLabelProvider(createLabelProvider());
		 myResultsViewer.addOpenListener(createOpenListener());
		 
		 return composite;
	}
	
	protected IContentProvider createContentProvider() {
		return new IStructuredContentProvider() {
		
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
		
			public void dispose() {
			}

			public Object[] getElements(final Object inputElement) {
				if (inputElement instanceof EClassifier[]) {
					return (EClassifier[]) inputElement;
				}
				return EMPTY_ARRAY;
			}
		
			private final Object[] EMPTY_ARRAY = new Object[0];
		};
	}
	
	protected ILabelProvider createLabelProvider() {
		final ILabelProvider provider = EMFProviderUtil.createLabelProvider();
		return new ILabelProvider() {

			public Image getImage(final Object element) {
				return provider.getImage(element);
			}

			public String getText(final Object element) {
				if (element instanceof EClassifier) {
					EClassifier classifier = (EClassifier) element;
					return classifier.getName() + PACKAGE_SEPARATOR + EmfUtil.getFullName(classifier);
				}
				return null;
			}
			
			public void addListener(final ILabelProviderListener listener) {
				provider.addListener(listener);
			}

			public void dispose() {
				provider.dispose();
			}

			public boolean isLabelProperty(final Object element, final String property) {
				return provider.isLabelProperty(element, property);
			}

			public void removeListener(final ILabelProviderListener listener) {
				provider.removeListener(listener);
			}
			
		};
	}
	
	protected IOpenListener createOpenListener() {
		return new IOpenListener() {

			public void open(OpenEvent event) {
				if (!myResultsViewer.getSelection().isEmpty()) {
					okPressed();
				}
			}
			
		};
	}
	
	protected KeyListener createQueryKeyListener() {
		return new KeyListener() {
			public void keyReleased(KeyEvent e) {
			}
			
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode == SWT.ARROW_DOWN) {
					myResultsViewer.getControl().setFocus();
				}
			}
		};
	}

	protected ModifyListener createQueryModifyListener() {
		return new ModifyListener() {

			public void modifyText(final ModifyEvent e) {
				updateResults();
			}
			
		};
	}
	
	protected void updateResults() {
		EClassifier[] classifiers = myClassifierProvider.getClassifiers(myQueryText.getText());
		myResultsViewer.setInput(classifiers);
		if (classifiers.length > 0) {
			myResultsViewer.setSelection(new StructuredSelection(classifiers[0]));
		}
	}
	
	protected Text getQueryText() {
		return myQueryText;
	}
	
	protected TableViewer getResultsViewer() {
		return myResultsViewer;
	}
	
	private IClassifierProvider myClassifierProvider;
	private Text myQueryText;
	private TableViewer myResultsViewer;
	private ISelection mySelection = StructuredSelection.EMPTY;
	
	private static final String PACKAGE_SEPARATOR = " - ";  //$NON-NLS-1$
}
