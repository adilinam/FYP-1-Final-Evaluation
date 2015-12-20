/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.ui.IModelParameterInfo;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.IUriGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtValidator;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtValidator.ValidationType;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * @author sboyko
 *
 */
public class TransformationSignatureLaunchControl extends ScrolledComposite {

	public TransformationSignatureLaunchControl(Composite parent, int style) {
		super(parent, style|SWT.V_SCROLL);
		
		setExpandHorizontal(true);
		setExpandVertical(true);
		setAlwaysShowScrollBars(true);
		
		setCompositeLayout(this);
		
		setTransformation(null, Collections.<IUriGroup.IModifyListener>emptyList());
	}
	
	public void setTransformation(QvtTransformation transformation, List<IUriGroup.IModifyListener> listeners) {
		myTransformation = transformation;

		List<TargetUriData> oldUriData = new ArrayList<TargetUriData>();
		Control content = getContent();
		if (content != null) {
			for (Map.Entry<ModelParameterInfo, IUriGroup> entry : myParamGroups.entrySet()) {
				oldUriData.add(entry.getValue().getUriData());
	    	}
			content.dispose();
		}
		final Composite area = new Composite(this, SWT.NONE);
		setContent(area);
		setCompositeLayout(area);
		
		createContents(area, listeners);
		
		Iterator<TargetUriData> itrOldUriData = oldUriData.iterator();
		for (Map.Entry<ModelParameterInfo, IUriGroup> entry : myParamGroups.entrySet()) {
			if (!itrOldUriData.hasNext()) {
				break;
			}
			entry.getValue().initializeFrom(itrOldUriData.next());
    	}

		Point computeSize = area.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		setMinSize(computeSize);
		setSize(getSize().x, computeSize.y);
		area.layout();
		getParent().layout();
	}

	public IStatus validate(String moduleName, Shell shell, String traceFilePath, boolean useTrace, 
			boolean isIncrementalUpdate, ValidationType validationType) {
		for (Map.Entry<ModelParameterInfo, IUriGroup> entry : myParamGroups.entrySet()) {
			entry.getValue().update(moduleName, entry.getKey(), shell);
		}
		
		List<TargetUriData> targetUris = new ArrayList<TargetUriData>(myParamGroups.size());
		for (Map.Entry<ModelParameterInfo, IUriGroup> entry : myParamGroups.entrySet()) {
			targetUris.add(entry.getValue().getUriData());
		}

		try {
			return QvtValidator.validateTransformation(myTransformation, targetUris,
					traceFilePath, useTrace, isIncrementalUpdate, validationType);
		}
		catch (Exception e) {
	        return StatusUtil.makeErrorStatus(e.getMessage(), e);
		}
	}

	public void initializeFrom(ILaunchConfiguration configuration) throws CoreException {
		List<TargetUriData> targetUris = QvtLaunchUtil.getTargetUris(configuration);
    	int i = 0;
		for (Map.Entry<ModelParameterInfo, IUriGroup> entry : myParamGroups.entrySet()) {
			if (i >= targetUris.size()) {
				break;
			}
    		entry.getValue().initializeFrom(targetUris.get(i));
    		i++;
    	}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		if (!isTransformationValid()) {
			return;
		}
    	configuration.setAttribute(IQvtLaunchConstants.ELEM_COUNT, myParamGroups.size());
    	int i = 0;
		for (Map.Entry<ModelParameterInfo, IUriGroup> entry : myParamGroups.entrySet()) {
    		QvtLaunchUtil.saveTargetUriData(configuration, entry.getValue().getUriData(), i+1);
    		i++;
    	}
	}
	
	private boolean isTransformationValid() {
		if (myTransformation == null) {
			return false;
		}
		try {
			return myTransformation.getModuleName().length() > 0;
		} catch (MdaException e) {
			return false;
		}
	}

	public URI getDefaultTraceName() {
		URI traceUri = null;
		for (Map.Entry<ModelParameterInfo, IUriGroup> entry : myParamGroups.entrySet()) {
			if (entry.getKey().isInOutParameter() || entry.getKey().isOutParameter()) {
				traceUri = URI.createURI(entry.getValue().getUriData().getUriString());
				break;
			}
    	}
		
		String moduleName = null;
		if (myTransformation != null) {
			try {
				if (traceUri == null || traceUri.toString().length() == 0) {
					traceUri = myTransformation.getURI();
				}
				else {
					moduleName = myTransformation.getModuleName();
				}
			} catch (MdaException e) {
			}
		}

        if (traceUri == null || traceUri.toString().length() == 0) {
        	return null;
        }

        if (traceUri.segmentCount() > 0) {
    		traceUri = traceUri.trimFileExtension();
    	}
    	if (moduleName != null) {
    		traceUri = traceUri.appendFileExtension(moduleName);
    	}
    	traceUri = traceUri.appendFileExtension(MDAConstants.QVTO_TRACEFILE_EXTENSION);
		
		return traceUri;
	}
	
	private void createContents(Composite parent, final List<IUriGroup.IModifyListener> listeners) {
		try {
        	myParamGroups = new LinkedHashMap<ModelParameterInfo, IUriGroup>();
        	
			List<ModelParameterInfo> transfParameters = getTransfParameters();
			if (transfParameters.size() > 0) {
				createValidationButton(parent, listeners);

				ResourceSet mappingAwareRS = CompilerUtils.cloneResourceSet(myTransformation.getURI(), myTransformation.getResourceSet());				
				
				for (ModelParameterInfo paramInfo : transfParameters) {
					IUriGroup uriGroup = TransformationControls.createUriGroup(parent, paramInfo, mappingAwareRS);
					myParamGroups.put(paramInfo, uriGroup);
					for (IUriGroup.IModifyListener listener : listeners) {
						uriGroup.addModifyListener(listener);
					}
				}
			}
		} catch (MdaException e) {
			myParamGroups = Collections.emptyMap();
		}
	}

	private void createValidationButton(Composite parent, final List<IUriGroup.IModifyListener> listeners) {
		Button validateModelsButton = new Button(parent, SWT.PUSH);
		validateModelsButton.setText(Messages.QvtLauncherTab_ValidateModels);
		validateModelsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (IUriGroup.IModifyListener listener : listeners) {
					listener.performValidation(false);
				}
			}
		});
		
		GridData gridData = new GridData();
		gridData.horizontalSpan = 1;
		gridData.horizontalIndent = 3;
		gridData.verticalIndent = 3;
		validateModelsButton.setLayoutData(gridData);
	}
	
	private void setCompositeLayout(Composite cm) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		cm.setLayout(layout);
		
    	GridData data = new GridData(GridData.FILL_BOTH);
        data.horizontalSpan = TransformationControls.GRID;
        cm.setLayoutData(data);		
	}
	
	private List<ModelParameterInfo> getTransfParameters() throws MdaException {
		if (myTransformation == null) {
			return Collections.emptyList();
		}
		
		List<ModelParameterInfo> modelParams = new ArrayList<ModelParameterInfo>();
		for (TransformationParameter param : myTransformation.getParameters()) {
			modelParams.add(createModelParamInfo(param));
		}		
		return modelParams;
	}
	
	private ModelParameterInfo createModelParamInfo(TransformationParameter param) {
		return new ModelParameterInfo(param);
	}

	private static class ModelParameterInfo implements IModelParameterInfo {
		ModelParameterInfo(TransformationParameter transfParam) {
			myTransfParam = transfParam;
		}
		
		public Direction getDirection() {
			if (myTransfParam.getDirectionKind() == DirectionKind.IN) {
				return Direction.in;
			}
			if (myTransfParam.getDirectionKind() == DirectionKind.OUT) {
				return Direction.out;
			}
			return Direction.inout;
		}

		public EClassifier getEntryParamType() {
			return myTransfParam.getEntryType();
		}

		public String getEntryParamTypeName() {
			return myTransfParam.getEntryName();
		}

		public EPackage getMetamodel() {
			List<EPackage> metamodels = myTransfParam.getMetamodels();
			return metamodels.isEmpty()? null : metamodels.get(0);
		}

		public String getModelTypeName() {
			return myTransfParam.getModelTypeName();
		}

		public String getName() {
			return myTransfParam.getName();
		}

		public boolean isInOutParameter() {
			return getDirection() == Direction.inout;
		}

		public boolean isInParameter() {
			return getDirection() == Direction.in;
		}

		public boolean isOutParameter() {
			return getDirection() == Direction.out;
		}
		
		private final TransformationParameter myTransfParam;
	}
	
	private QvtTransformation myTransformation;
	private Map<ModelParameterInfo, IUriGroup> myParamGroups = Collections.emptyMap();

}
