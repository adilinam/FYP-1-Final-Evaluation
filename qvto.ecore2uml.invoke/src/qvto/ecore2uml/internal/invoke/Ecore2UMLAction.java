/*******************************************************************************
 * Copyright (c) 2009, 2013 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland - initial API and implementation
 *******************************************************************************/
package qvto.ecore2uml.internal.invoke;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import qvto.ecore2uml.invoke.ConvertEcore2UML;


public class Ecore2UMLAction implements IObjectActionDelegate {

	@SuppressWarnings("unused")
	private Shell shell;
	
	private	IPath inModelPath;	
	
	/**
	 * Constructor for Action1.
	 */
	public Ecore2UMLAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		if(inModelPath == null) {
			return;
		}

		URI inURI = URI.createPlatformResourceURI(inModelPath.toString(), true);
		Resource inResource = new ResourceSetImpl().getResource(inURI, true);

		URI outURI = inURI.trimFileExtension().appendFileExtension("uml");
		Resource outResource = new ResourceSetImpl().createResource(outURI);
		try {
			ConvertEcore2UML.convertEcore2UML(inResource, outResource);			
			outResource.save(Collections.emptyMap());
			
		} catch (Exception e) {
			Diagnostic diagnostic = BasicDiagnostic.toDiagnostic(e);
			InvokeActivator.getDefault().getLog().log(BasicDiagnostic.toIStatus(diagnostic));
		}		
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		inModelPath = null;
		
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if(!selection.isEmpty()) {
				Object firstElement = structuredSelection.getFirstElement();
				if(firstElement instanceof IFile) {
					IFile ecoreFile = (IFile) firstElement;
					inModelPath = ecoreFile.getFullPath();
				}
			}
		}
	}

	

}
