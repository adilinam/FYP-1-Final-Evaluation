/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.ant;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

public class CompositeTransformationContentPage extends WizardPage {
	private final CompositeTransformationModel myModel;

	private boolean myWasEverShown;
	private Text myProjectNameText;
	private Text myTargetNameText;
	private TreeViewer myTreeViewer;
	private Button myUp;
	private Button myDown;
	private Button myDelete;

	public CompositeTransformationContentPage(CompositeTransformationModel model) {
		super("transformationPage"); //$NON-NLS-1$
		myModel = model;
		setTitle(Messages.TransformPage_title);
		setDescription(Messages.TransformPage_descr);
	}

	@Override
	public boolean isPageComplete() {
		return myWasEverShown && super.isPageComplete();
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		Label label = new Label(container, SWT.NULL);
		label.setText(Messages.TransformPage_project);

		myProjectNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		myProjectNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		myProjectNameText.setText(myModel.getProjectName());
		myProjectNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				myModel.setProjectName(myProjectNameText.getText());
			}
		});

		label = new Label(container, SWT.NULL);
		label.setText(Messages.TransformPage_task);

		myTargetNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		myTargetNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		myTargetNameText.setText(myModel.getTargetName());
		myTargetNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				myModel.setTargetName(myTargetNameText.getText());
			}
		});

		Composite composite = new Composite(container, SWT.NONE);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 2;
		composite.setLayoutData(data);
		layout = new GridLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		layout.marginWidth = 0;
		layout.marginRight = 0;
		composite.setLayout(layout);

		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.HIDE_SELECTION;
		myTreeViewer = new TreeViewer(composite, style);
		myTreeViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		final DataProvider dp = new DataProvider();
		myTreeViewer.setContentProvider(dp);
		myTreeViewer.setLabelProvider(dp);
		myTreeViewer.setInput(myModel);

		myTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				updateButtons(event.getSelection());
			}
		});

		Tree tree = myTreeViewer.getTree();
		TableLayout tableLayout = new TableLayout();

		TreeColumn col = new TreeColumn(tree, SWT.NONE);
		tableLayout.addColumnData(new ColumnWeightData(3, true));
		col.setText(Messages.Name);

		col = new TreeColumn(tree, SWT.NONE);
		tableLayout.addColumnData(new ColumnWeightData(3, true));
		col.setText(Messages.Value);

		tree.setLayout(tableLayout);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);

		Composite buttons = new Composite(composite, SWT.NONE);
		buttons.setLayoutData(new GridData(GridData.FILL_VERTICAL));
		layout = new GridLayout();
		layout.numColumns = 1;
		layout.verticalSpacing = 9;
		layout.marginTop = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.marginRight = 0;
		buttons.setLayout(layout);

		newButton(buttons, Messages.Add, new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CreateQvtoAntTaskWizard taskWizard = new CreateQvtoAntTaskWizard();
				WizardDialog dialog = new WizardDialog(getContainer().getShell(), taskWizard);
				dialog.create();
				if (dialog.open() == Window.OK) {
					myModel.getTaskModels().add(taskWizard.getResult());
					myTreeViewer.refresh();
				}
			}
		});

		myDelete = newButton(buttons, Messages.Delete, new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Object selectedElement = getSelectedElement();
				if (selectedElement instanceof TaskModel) {
					myModel.getTaskModels().remove(selectedElement);
					myTreeViewer.refresh();
				}
			}
		});
		myUp = newButton(buttons, Messages.Up, new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Object selectedElement = getSelectedElement();
				if (selectedElement instanceof TaskModel) {
					int i = myModel.getTaskModels().indexOf(selectedElement);
					if (i > 0) {
						TaskModel p = myModel.getTaskModels().get(i - 1);
						myModel.getTaskModels().set(i - 1, (TaskModel) selectedElement);
						myModel.getTaskModels().set(i, p);
						myTreeViewer.refresh();
					}
				}
			}
		});
		myDown = newButton(buttons, Messages.Down, new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Object selectedElement = getSelectedElement();
				if (selectedElement instanceof TaskModel) {
					int i = myModel.getTaskModels().indexOf(selectedElement);
					if (i < myModel.getTaskModels().size() - 1) {
						TaskModel n = myModel.getTaskModels().get(i + 1);
						myModel.getTaskModels().set(i + 1, (TaskModel) selectedElement);
						myModel.getTaskModels().set(i, n);
						myTreeViewer.refresh();
					}
				}
			}
		});

		setControl(container);
		updateButtons(StructuredSelection.EMPTY);
	}

	private Object getSelectedElement() {
		IStructuredSelection sel = (IStructuredSelection) myTreeViewer.getSelection();
		return sel.getFirstElement();
	}

	protected void updateButtons(ISelection selection) {
		IStructuredSelection sel = (IStructuredSelection) selection;
		Object firstElement = sel.getFirstElement();
		boolean up = false;
		boolean down = false;
		boolean del = false;
		if (firstElement instanceof TaskModel) {
			int i = myModel.getTaskModels().indexOf(firstElement);
			up = i > 0;
			down = i < myModel.getTaskModels().size() - 1;
			del = true;
		}
		myDelete.setEnabled(!selection.isEmpty() && del);
		myUp.setEnabled(!selection.isEmpty() && up);
		myDown.setEnabled(!selection.isEmpty() && down);
	}

	private static Button newButton(Composite buttons, String caption, SelectionListener listener) {
		Button button = new Button(buttons, SWT.PUSH);
		button.setText(caption);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		button.setLayoutData(gridData);
		button.addSelectionListener(listener);
		return button;
	}

	private static class DataProvider extends LabelProvider implements ITableLabelProvider, ITreeContentProvider {

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof TaskModel) {
				TaskModel value = (TaskModel) element;
				return columnIndex == 0 ? value.getTaskName() : " < " + value.getName() + " >"; //$NON-NLS-1$ //$NON-NLS-2$
			}
			if (element instanceof Map.Entry<?, ?>) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, Object> value = (Entry<String, Object>) element;
				return columnIndex == 0 ? value.getKey() : String.valueOf(value.getValue());
			}
			return element.toString();
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		// ITreeContentProvider
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof TaskModel) {
				TaskModel model = (TaskModel) parentElement;
				Set<Entry<String, Object>> entrySet = model.getAttributes().entrySet();
				for (Entry<String, Object> entry : entrySet) {
					myParentCache.put(entry, parentElement);
				}
				return entrySet.toArray();
			}
			return null;
		}

		public Object getParent(Object element) {
			return myParentCache.get(element);
		}

		public boolean hasChildren(Object element) {
			return element instanceof TaskModel;
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof CompositeTransformationModel) {
				CompositeTransformationModel model = (CompositeTransformationModel) inputElement;
				return model.getTaskModels().toArray();
			}
			return null;
		}

		public void dispose() {
			myParentCache.clear();
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		private final Map<Object, Object> myParentCache = new HashMap<Object, Object>();
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			myWasEverShown = true;
		}
		super.setVisible(visible);
	}
}