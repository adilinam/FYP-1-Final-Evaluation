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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.debug.ui.ILaunchGroup;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegate;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.model.WorkbenchViewerComparator;

public class ChooseDataSourcePage extends AbstractCompositeWizardPage {

	protected ChooseDataSourcePage() {
		super("dataSourcePage"); //$NON-NLS-1$
        setTitle(Messages.SourcePage_title1);
        setDescription(Messages.SourcePage_descr1);
	}
	
	@Override
	public void setVisible(boolean visible) {
		if (visible && getSelectedLaunchConfiguration() == null) {
			myViewer.setSelection(new IStructuredSelection() {
				
				public Object getFirstElement() {
					Object[] array = toArray();
					if (array.length == 0) {
						return null;
					}
					return array[0];
				}
	
				public Iterator<Object> iterator() {
					return toList().iterator();
				}
	
				public int size() {
					return toArray().length;
				}
	
				public Object[] toArray() {
					return ((ITreeContentProvider) myViewer.getContentProvider()).getElements(null);
				}
	
				public List<Object> toList() {
					Object[] array = toArray();
					List<Object> list = new ArrayList<Object>(array.length);
					for (Object o : array) {
						list.add(o);
					}
					return list;
				}
	
				public boolean isEmpty() {
					return toArray().length > 0;
				}
				
			});
		}
		super.setVisible(visible);
	}

	@Override
	protected void doCreateControl(Composite parent) {
		myViewer = new TreeViewer(parent);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		myViewer.getControl().setLayoutData(data);
		myViewer.setLabelProvider(new TypeNamesWithTaskTypes(DebugUITools.newDebugModelPresentation()));
		myViewer.setComparator(new WorkbenchViewerComparator());
		myViewer.setContentProvider(new LaunchConfigurationTreeContentProvider(ILaunchManager.RUN_MODE, parent.getShell()));
		myViewer.addFilter(new AntFilter());
		myViewer.setInput(ResourcesPlugin.getWorkspace().getRoot());
		myViewer.expandAll();

		myViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				getContainer().updateButtons();
				myConfigButton.setEnabled(getSelectedConfigType() != null);
			}
		});

		myConfigButton = new Button(parent, SWT.NULL);
		myConfigButton.setText(Messages.SourcePage_configBtn);
		myConfigButton.setEnabled(false);
		myConfigButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				ILaunchConfigurationType configType = getSelectedConfigType();
				if (configType == null) {
					return;
				}
				try {
					if ((myCreatedConfig == null) || (!configType.equals(myCreatedConfig.getType()))) {
						ILaunchConfigurationWorkingCopy wc = configType.newInstance(null, "qvto.antTask.newConfiguration"); //$NON-NLS-1$
						wc.setAttribute(IDebugUIConstants.ATTR_PRIVATE, true);
						myCreatedConfig = wc.doSave();
					}
					ILaunchGroup launchGroup = DebugUITools.getLaunchGroup(myCreatedConfig, ILaunchManager.RUN_MODE);
					if (DebugUITools.openLaunchConfigurationPropertiesDialog(getShell(), myCreatedConfig, launchGroup.getIdentifier()) == Window.OK) {
						myConfig = myCreatedConfig;
						if (canFlipToNextPage()) {
							getContainer().showPage(getNextPage());
							myConfig = null;
						}
					}
					getContainer().updateButtons();
				} catch (CoreException e1) {
					e1.printStackTrace();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		Composite container = new Composite(parent, SWT.NULL);
		container.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
	}

	@Override
	public boolean canFlipToNextPage() {
		setErrorMessage(null);
		myTaskModel = null;
		
		ILaunchConfiguration conf = getSelectedLaunchConfiguration();
		if (conf == null) {
			return false;
		}
		
		try {
			myTaskModel = new TaskModel(conf, QVTO_ANTTASK_NAME);
		}
		catch (Exception e) {
			setErrorMessage(e.getMessage());
			return false;
		}
		
		return true;
	}

	public TaskModel getTaskModel() {
		return myTaskModel;
	}

	private ILaunchConfiguration getSelectedLaunchConfiguration() {
		if (myConfig != null) {
			return myConfig;
		}
		
		ISelection selection = myViewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			Object firstElement = ssel.getFirstElement();
			if (firstElement instanceof ILaunchConfiguration) {
				return (ILaunchConfiguration) firstElement;
			}
		}
		return null;
	}
	
	private ILaunchConfigurationType getSelectedConfigType() {
		ISelection selection = myViewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			Object firstElement = ssel.getFirstElement();
			if (firstElement instanceof ILaunchConfigurationType) {
				return (ILaunchConfigurationType) firstElement;
			}
			if (firstElement instanceof ILaunchConfiguration) {
				try {
					return ((ILaunchConfiguration) firstElement).getType();
				} catch (CoreException e) {
				}
			}
		}
		return null;
	}
	
	private class AntFilter extends ViewerFilter {

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (element instanceof ILaunchConfigurationType) {
				ILaunchConfigurationType type = (ILaunchConfigurationType) element;
				return isTypeSupported(type);
			}
			if (element instanceof ILaunchConfiguration) {
				ILaunchConfiguration config = (ILaunchConfiguration) element;
				boolean priv = false;
				try {
					priv = config.getAttribute(IDebugUIConstants.ATTR_PRIVATE, false);
				} catch (CoreException e) {
					// Ignored
				}
				if (priv) {
					return false;
				}
				ILaunchConfigurationType type = null;
				try {
					type = config.getType();
				} catch (CoreException e) {
					return false;
				}
				return isTypeSupported(type);
			}

			return false;
		}

		private boolean isTypeSupported(ILaunchConfigurationType type) {
			return QvtLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE_ID.equals(type.getIdentifier());
		}

	}

	private static class TypeNamesWithTaskTypes implements ILabelProvider {

		TypeNamesWithTaskTypes(ILabelProvider dmp) {
			myWrapped = dmp;
		}

		public Image getImage(Object element) {
			return myWrapped.getImage(element);
		}

		public String getText(Object element) {
			String suffix = ""; //$NON-NLS-1$
			if (element instanceof ILaunchConfigurationType) {
				ILaunchConfigurationType type = (ILaunchConfigurationType) element;
				suffix = " (" + getTaskName(type) + ")"; //$NON-NLS-1$//$NON-NLS-2$
			}
			return myWrapped.getText(element) + suffix;
		}

		private String getTaskName(ILaunchConfigurationType type) {
			return QVTO_ANTTASK_NAME;
		}

		public void addListener(ILabelProviderListener listener) {
			myWrapped.addListener(listener);
		}

		public void dispose() {
			myWrapped.dispose();
		}

		public boolean isLabelProperty(Object element, String property) {
			return myWrapped.isLabelProperty(element, property);
		}

		public void removeListener(ILabelProviderListener listener) {
			myWrapped.removeListener(listener);
		}

		private final ILabelProvider myWrapped;

	}

	private TreeViewer myViewer;
	private Button myConfigButton;
	private ILaunchConfiguration myConfig;
	private ILaunchConfiguration myCreatedConfig;
	private TaskModel myTaskModel;

	private static final String QVTO_ANTTASK_NAME = "qvto:transformation"; //$NON-NLS-1$
	
}
