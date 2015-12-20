/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ui.wizards.project;

import java.util.StringTokenizer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.JavaConventions;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Version;

import com.ibm.icu.lang.UCharacter;


public class NewQVTProjectContentPage extends WizardPage {

	protected final static int PROPERTIES_GROUP = 1;
	protected final static int CLASS_GROUP = 2;
	protected int myChangedGroups = 0;
	
	private NewQVTProjectCreationPage myMainPage;
	private NewProjectData myData;
	private Text myIdText;
	private Text myVersionText;
	private Text myNameText;
	private Text myProviderText;
	private Button myGenerateClass;
	private Label myClassLabel;
	private Text myClassText;
	private boolean myInitialized;

	
	public NewQVTProjectContentPage(String pageName, NewQVTProjectCreationPage page, NewProjectData data) {
		super(pageName);
		myMainPage = page;
		myData = data;
		setTitle(Messages.ContentPage_title);
		setDescription(Messages.ContentPage_desc); 
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout());
		
		createPluginPropertiesGroup(container);
		createPluginClassGroup(container);
		
		setControl(container);	
		
        PlatformUI.getWorkbench().getHelpSystem().setHelp(container, 
			"org.eclipse.m2m.qvt.oml.transformation_project"); //$NON-NLS-1$
		
	}

	protected Text createText(Composite parent, ModifyListener listener) {
		Text text = new Text(parent, SWT.BORDER | SWT.SINGLE);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		text.addModifyListener(listener);
		return text;
	}
	
	private void createPluginPropertiesGroup(Composite container) {
		ModifyListener propertiesListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (myInitialized) {
					myChangedGroups |= PROPERTIES_GROUP;
				}
				validatePage();
			}
		};
		Group propertiesGroup = new Group(container, SWT.NONE);
		propertiesGroup.setLayout(new GridLayout(2, false));
		propertiesGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		propertiesGroup.setText(Messages.ContentPage_pGroup);

		Label label = new Label(propertiesGroup, SWT.NONE);
		label.setText(Messages.ContentPage_pid);
		myIdText = createText(propertiesGroup, propertiesListener);
		
		label = new Label(propertiesGroup, SWT.NONE);
		label.setText(Messages.ContentPage_pversion);
		myVersionText = createText(propertiesGroup, propertiesListener);

		label = new Label(propertiesGroup, SWT.NONE);
		label.setText(Messages.ContentPage_pname);
		myNameText = createText(propertiesGroup, propertiesListener);

		label = new Label(propertiesGroup, SWT.NONE);
		label.setText(Messages.ContentPage_pprovider); 
		myProviderText = createText(propertiesGroup, propertiesListener);
	}

	private void createPluginClassGroup(Composite container) {
		ModifyListener classListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (myInitialized) {
					myChangedGroups |= CLASS_GROUP;
				}
				validatePage();
			}
		};
		Group classGroup = new Group(container, SWT.NONE);
		classGroup.setLayout(new GridLayout(2, false));
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		classGroup.setLayoutData(gd);
		classGroup.setText(Messages.ContentPage_pClassGroup);

		myGenerateClass = new Button(classGroup, SWT.CHECK);
		myGenerateClass.setText(Messages.ContentPage_generate);
		myGenerateClass.setSelection(myData.isDoGenerateClass());
		gd = new GridData();
		gd.horizontalSpan = 2;
		myGenerateClass.setLayoutData(gd);
		myGenerateClass.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				myClassLabel.setEnabled(myGenerateClass.getSelection());
				myClassText.setEnabled(myGenerateClass.getSelection());
				updateData();
				validatePage();
			}
		});

		myClassLabel = new Label(classGroup, SWT.NONE);
		myClassLabel.setText(Messages.ContentPage_classname);
        myClassLabel.setEnabled(myGenerateClass.getSelection());
		gd = new GridData();
		gd.horizontalIndent = 20;
		myClassLabel.setLayoutData(gd);
		myClassText = createText(classGroup, classListener);
        myClassText.setEnabled(myGenerateClass.getSelection());
	}
	
	protected String computeId() {
		return myMainPage.getProjectName().replaceAll("[^a-zA-Z0-9\\._]", "_"); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	private void presetNameField(String id) {
		StringTokenizer tok = new StringTokenizer(id, "."); //$NON-NLS-1$
		while (tok.hasMoreTokens()) {
			String token = tok.nextToken();
			if (!tok.hasMoreTokens()) {
				myNameText.setText(Character.toUpperCase(token.charAt(0))
								+ ((token.length() > 1) ? token.substring(1) : "") //$NON-NLS-1$
								+ " " + getNameFieldQualifier()); //$NON-NLS-1$
			}
		}
	}

	private void presetClassField(Text text, String id, String suffix) {
		StringBuffer buffer = new StringBuffer();
        IStatus status;
		for (int i = 0; i < id.length(); i++) {
			char ch = id.charAt(i);
			if (buffer.length() == 0) {
				if (UCharacter.isJavaIdentifierStart(ch)) {
					buffer.append(Character.toLowerCase(ch));
				}
			} else {
				if (UCharacter.isJavaIdentifierPart(ch)) {
                    buffer.append(ch);
				}
                else if (ch == '.'){
                    status = validatePackageName(buffer.toString());
                    if (status.getSeverity() == IStatus.ERROR) {
                        buffer.append(suffix.toLowerCase());
                    }
					buffer.append(ch);
                }
			}
		}
		StringTokenizer tok = new StringTokenizer(buffer.toString(), "."); //$NON-NLS-1$
		while (tok.hasMoreTokens()) {
			String token = tok.nextToken();
			if (!tok.hasMoreTokens()){
                status = validatePackageName(buffer.toString());
                if (status.getSeverity() == IStatus.ERROR) {
                    buffer.append(suffix.toLowerCase());
                }
				buffer.append("." + Character.toUpperCase(token.charAt(0)) + token.substring(1) + suffix); //$NON-NLS-1$ 
            }
		}
		text.setText(buffer.toString());
	}
	
	private void presetProviderField(String id) {
		StringTokenizer tok = new StringTokenizer(id, "."); //$NON-NLS-1$
		int count = tok.countTokens();
		if (count > 2 && tok.nextToken().equals("com")) {//$NON-NLS-1$
			myProviderText.setText(tok.nextToken().toUpperCase());
		}
	}
	
	private String getNameFieldQualifier() {
		return Messages.ContentPage_plugin;
	}
	
	@Override
	public IWizardPage getNextPage() {
		updateData();
		return super.getNextPage();
	}
	
	public void updateData() {
		myData.setID(myIdText.getText().trim());
		myData.setVersion(myVersionText.getText().trim());
		myData.setName(myNameText.getText().trim());
		myData.setProviderName(myProviderText.getText().trim());

		myData.setClassName(myClassText.getText().trim());
		myData.setDoGenerateClass(myGenerateClass.isEnabled() && myGenerateClass.getSelection());
	}

	protected void validatePage() {
		setMessage(null);
		String errorMessage = validateProperties();

		if (errorMessage == null && myGenerateClass.isEnabled() && myGenerateClass.getSelection()) {
			IStatus status = validateJavaTypeName(myClassText.getText().trim());
			if (status.getSeverity() == IStatus.ERROR) {
				errorMessage = status.getMessage();
			} else if (status.getSeverity() == IStatus.WARNING) {
				setMessage(status.getMessage(), IMessageProvider.WARNING);
			}
		}
		setErrorMessage(errorMessage);
		setPageComplete(errorMessage == null);
	}

	protected String validateProperties() {
		String errorMessage = validateId();
		if (errorMessage != null)
			return errorMessage;
		
		if (myVersionText.getText().trim().length() == 0) {
			errorMessage = Messages.ContentPage_noversion;
		} else if (!isVersionValid(myVersionText.getText().trim())) {
			errorMessage = Messages.ContentPage_badversion;
		} else if (myNameText.getText().trim().length() == 0) {
			errorMessage = Messages.ContentPage_noname;
		}
		
		if (errorMessage != null)
			return errorMessage;
		
		return errorMessage;
	}
	
	private String validateId() {
		String id = myIdText.getText().trim();
		if (id.length() == 0)
			return Messages.ContentPage_noid;

		if (!isValidPluginId(id)) {
			return Messages.ContentPage_invalidId;
		}
		return null;
	}

	protected boolean isVersionValid(String version) {
		try {
			new Version(version);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {		
    		myMainPage.updateData();
			String id = computeId();
			if ((myChangedGroups & PROPERTIES_GROUP) == 0) {
				int oldChanged = myChangedGroups;				
				myIdText.setText(id);
				myVersionText.setText("1.0.0"); //$NON-NLS-1$
				presetNameField(id);
				presetProviderField(id);
				myChangedGroups = oldChanged;
			}
			if ((myChangedGroups & CLASS_GROUP) == 0) {
				int oldChanged = myChangedGroups;
				presetClassField(myClassText, computeId(), "Activator"); //$NON-NLS-1$
				myChangedGroups = oldChanged;
			}
			
			if (myInitialized) {
				validatePage();
			}
			else {
				myInitialized = true;
			}
			
			boolean isGenerateClassAllowed = myData.isCreateJava();
			if(!isGenerateClassAllowed) {
				myGenerateClass.setSelection(false);
			}
			
			myGenerateClass.setEnabled(isGenerateClassAllowed);
			myClassText.setEnabled(isGenerateClassAllowed);
			myClassLabel.setEnabled(isGenerateClassAllowed);
			
			myIdText.setFocus();
		} 
	}

	private static boolean isValidPluginId(String name) {
		if (name.length() <= 0) {
			return false;
		}
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if ((c < 'A' || 'Z' < c) && (c < 'a' || 'z' < c)
					&& (c < '0' || '9' < c) && c != '_') {
				if (i == 0 || i == name.length() - 1 || c != '.') {
					return false;
				}
			}
		}
		return true;
	}
	
	private static IStatus validatePackageName(String name) {
		return JavaConventions.validatePackageName(name, JavaCore.VERSION_1_3, JavaCore.VERSION_1_3);
	}
	
	private static IStatus validateJavaTypeName(String name) {
		return JavaConventions.validateJavaTypeName(name, JavaCore.VERSION_1_3, JavaCore.VERSION_1_3);
	}	
}
