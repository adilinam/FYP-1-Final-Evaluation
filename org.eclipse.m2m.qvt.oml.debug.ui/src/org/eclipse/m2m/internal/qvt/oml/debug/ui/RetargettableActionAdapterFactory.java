/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.debug.ui;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.ui.actions.IRunToLineTarget;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.ui.texteditor.ITextEditor;


/**
 * Creates adapters for retargettable actions in debug platform.
 * Contributed via <code>org.eclipse.core.runtime.adapters</code> 
 * extension point. 
 */
public class RetargettableActionAdapterFactory implements IAdapterFactory {
	
	public RetargettableActionAdapterFactory() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adaptableObject instanceof ITextEditor == false) {
			return null;
        }
		
		ITextEditor editorPart = (ITextEditor) adaptableObject;
        IResource resource = (IResource) editorPart.getEditorInput().getAdapter(IResource.class);
        if (resource != null) {
            String editorID = editorPart.getEditorSite().getId();
			if(!QVTODebugUIPlugin.DEBUG_EDITOR_ID.equals(editorID)) {
				return null;
            }
        }

        if(IRunToLineTarget.class == adapterType) {
			return new QVTORunToLineAdapter();
        } else  if(IToggleBreakpointsTarget.class == adapterType) {
			return new QVTOToggleBreakpointAdapter();
        } 

		return null;
	}

	@SuppressWarnings("unchecked")
	public Class[] getAdapterList() {
		return new Class[] { QVTOToggleBreakpointAdapter.class, QVTORunToLineAdapter.class };
	}
}
