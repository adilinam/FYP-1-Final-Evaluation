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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtRuntimeUIPlugin;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;

public class NewCompositeTransformationWizard extends Wizard implements INewWizard {
	public NewCompositeTransformationWizard() {
		setNeedsProgressMonitor(true);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		mySelection = selection;
		setWindowTitle(Messages.TransformWizard_windowTitle);
	}

	@Override
	public void addPages() {
		myNewFilePage = new WizardNewFileCreationPage("newTransformFilePage", mySelection); //$NON-NLS-1$
		myNewFilePage.setTitle(Messages.TransformFilePage_title);
		
		String defaultFileName = "composite.xml"; //$NON-NLS-1$
		if (mySelection.getFirstElement() instanceof IFile) {
			final IFile file = (IFile) mySelection.getFirstElement();
			if (!"xml".equals(file.getFileExtension())) { //$NON-NLS-1$
				defaultFileName = file.getProjectRelativePath().removeFileExtension().addFileExtension("xml").lastSegment(); //$NON-NLS-1$
			} else {
				defaultFileName = file.getProjectRelativePath().lastSegment();
			}
		}
		myNewFilePage.setFileName(defaultFileName);
		addPage(myNewFilePage);

		myContentsPage = new CompositeTransformationContentPage(myModel);

		addPage(myContentsPage);
	}

	@Override
	public boolean performFinish() {
		final String containerName = myNewFilePage.getContainerFullPath().toPortableString();
		final String fileName = myNewFilePage.getFileName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(containerName, fileName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage()); //$NON-NLS-1$
			return false;
		}
		return true;
	}

	private void doFinish(String containerName, String fileName, IProgressMonitor monitor) throws CoreException {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2); //$NON-NLS-1$
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("Container \"" + containerName + "\" does not exist.", null); //$NON-NLS-1$ //$NON-NLS-2$
		}
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(fileName));
		try {
			InputStream stream = openContentStream();
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
			throwCoreException("Error creating file [" + fileName + "]", e); //$NON-NLS-1$ //$NON-NLS-2$
		}
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing..."); //$NON-NLS-1$
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}

	private InputStream openContentStream() throws UnsupportedEncodingException, CoreException {
		String encoding = getCharset();
		String result = "<?xml version=\"1.0\" encoding=\"" + encoding + "\"?>\n" + //$NON-NLS-1$//$NON-NLS-2$
				"<project name=\"" + myModel.getProjectName() + "\" " + //$NON-NLS-1$//$NON-NLS-2$
				"default=\"" + myModel.getTargetName() + "\" xmlns:qvto=\"http://www.eclipse.org/qvt/1.0.0/Operational\">\n"; //$NON-NLS-1$//$NON-NLS-2$
		result += "    <target name=\"" + myModel.getTargetName() + "\">\n"; //$NON-NLS-1$//$NON-NLS-2$
		List<TaskModel> value = myModel.getTaskModels();
		for (TaskModel model : value) {
			result += TaskModel.indentString(model.toString(), "        ", "\n") + "\n"; //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
		}
		result += "    </target>\n"; //$NON-NLS-1$
		result += "</project>"; //$NON-NLS-1$
		return new ByteArrayInputStream(result.getBytes(encoding));
	}

	private String getCharset() throws CoreException {
//		if (mySelection != null) {
//			Object firstElement = mySelection.getFirstElement();
//			if (firstElement instanceof IResource) {
//				IResource resource = (IResource) firstElement;
//				String charset = resource.getProject().getDefaultCharset();
//				if ((charset != null) && Charset.isSupported(charset)) {
//					return charset;
//				}
//			}
//		}
//		String charset = ResourcesPlugin.getEncoding();
//		if (Charset.isSupported(charset)) {
//			return charset;
//		}
		return "UTF-8"; //$NON-NLS-1$
	}

	private static void throwCoreException(String message, Throwable exception) throws CoreException {
		IStatus status = new Status(IStatus.ERROR, QvtRuntimeUIPlugin.PLUGIN_ID, IStatus.OK, message, exception);
		throw new CoreException(status);
	}

	private WizardNewFileCreationPage myNewFilePage;
	private CompositeTransformationContentPage myContentsPage;
	private IStructuredSelection mySelection;

	private CompositeTransformationModel myModel = new CompositeTransformationModel();
}