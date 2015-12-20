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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.project.builder.QVTOBuilderConfig;
import org.eclipse.m2m.internal.qvt.oml.ui.QvtPluginImages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class QvtProjectLabelProvider extends LabelProvider {

	private ILabelProvider delegate = WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider();
	
	public QvtProjectLabelProvider() {
		super();
	}
	
	@Override
	public String getText(Object element) {
		/*if(element instanceof IContainer) {
			IContainer resource = (IContainer) element;
			QVTOBuilderConfig config = getBuilderConfig(resource);		
			if(config != null && resource.equals(config.getSourceContainer())) {				
				return resource.getProjectRelativePath().toString(); 
			}
		}
*/		
		return delegate.getText(element);
	}
	
	@Override
	public Image getImage(Object element) {
		QVTOBuilderConfig config = getBuilderConfig(element);
		if(config == null) {
			return delegate.getImage(element); 
		}
		
		if(element instanceof IFolder) {
			IFolder folder = (IFolder) element;

			IContainer sourceContainer = config.getSourceContainer();
			if(sourceContainer.equals(folder)) {
				return QvtPluginImages.getInstance().getImage(QvtPluginImages.SRC_CONTAINER);
			} 
			else if((sourceContainer.getType() & IResource.PROJECT) == 0 && config.isInSourceContainer(folder)) {
				return QvtPluginImages.getInstance().getImage(QvtPluginImages.CU_NAMESPACE);
			}
		} 
		else if(element instanceof IFile) {
			IFile file = (IFile)element;
			if(MDAConstants.QVTO_FILE_EXTENSION.equals(file.getFileExtension())) {
				if(!config.isInSourceContainer(file)) {
					return QvtPluginImages.getInstance().getImage(QvtPluginImages.UNB0UND_QVT_CU);
				}
			}
		}

		return null;
	}
		
	private static QVTOBuilderConfig getBuilderConfig(Object element) {
		try {
			if (element instanceof IResource) {
				return QVTOBuilderConfig.getConfig(((IResource) element).getProject());				
			}
		} catch (CoreException e) {
			return null;
		}
		
		return null;		
	}
}
