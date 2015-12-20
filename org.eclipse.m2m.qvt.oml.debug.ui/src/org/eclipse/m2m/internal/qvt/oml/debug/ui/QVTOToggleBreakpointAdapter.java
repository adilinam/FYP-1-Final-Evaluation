/*******************************************************************************
 * Copyright (c) 2009, 2013 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.debug.ui;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.qvt.oml.debug.core.QVTOBreakpoint;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;
import org.eclipse.ui.IWorkbenchPart;


public class QVTOToggleBreakpointAdapter implements IToggleBreakpointsTarget {
	
	public QVTOToggleBreakpointAdapter() {
		super();
	}

	public void toggleLineBreakpoints(final IWorkbenchPart part, ISelection selection) throws CoreException {
		final QvtEditor qvtEditor = getEditor(part);
		if(qvtEditor == null) {
			return;
		}

		IFile unitFile = (IFile) qvtEditor.getEditorInput().getAdapter(IResource.class);		
		ITextSelection textSelection = (ITextSelection) selection;
		int lineNumber = textSelection.getStartLine() + 1;
		
		List<ILineBreakpoint> breakpoints = QVTODebugCore.getQVTOBreakpoints(ILineBreakpoint.class);
		for(ILineBreakpoint next : breakpoints) {			 
			if(!unitFile.equals(next.getMarker().getResource())) {
				continue;
			}

			if(next.getLineNumber() == lineNumber) {
				try {
					// a breakpoint already exists at this line =>toggle again means remove
					DebugPlugin.getDefault().getBreakpointManager().removeBreakpoint(next, true);
				} catch (CoreException e) {
					QVTODebugUIPlugin.log(e.getStatus());
				}
				next.delete();
				return;
			}
		}

		URI sourceURI = URIUtils.getResourceURI(unitFile);
		final QVTOBreakpoint lineBreakpoint = new QVTOBreakpoint(sourceURI, lineNumber);
		lineBreakpoint.register(true);
        
        Job job = new Job(DebugUIMessages.QVTOToggleBreakpointAdapter_VerifyBreakpointJob) {
            @Override
			protected IStatus run(IProgressMonitor monitor) {
				return new BreakpointLocationVerifier(qvtEditor, lineBreakpoint,
						DebugUIMessages.QVTOToggleBreakpointAdapter_CannotSetBreakpoint).run();
            }
            
            @Override
            public boolean belongsTo(Object family) {
            	return QVTOBreakpoint.QVTO_BREAKPOINT_JOBFAMILY == family;
            }
        };
        
        job.setPriority(Job.INTERACTIVE);
        job.setSystem(true);
        job.schedule();        
	} 

	public boolean canToggleLineBreakpoints(IWorkbenchPart part, ISelection selection) {
		return getEditor(part) != null;
	}
		
	public void toggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
	}

	public boolean canToggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) {
		return false;
	}

	public void toggleWatchpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
	}

	public boolean canToggleWatchpoints(IWorkbenchPart part, ISelection selection) {
		return false;
	}
	
	private QvtEditor getEditor(IWorkbenchPart part) {
		if(part instanceof QvtEditor) {
			return (QvtEditor) part;
 		}
		
		return null;		
	}	
}
