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
package org.eclipse.m2m.internal.qvt.oml.debug.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.texteditor.AbstractRulerActionDelegate;
import org.eclipse.ui.texteditor.ITextEditor;

public class QVTOBreakpointPropertiesRulerActionDelegate  extends AbstractRulerActionDelegate {

    /**
     * @see AbstractRulerActionDelegate#createAction(ITextEditor, IVerticalRulerInfo)
     */
    protected IAction createAction(ITextEditor editor, IVerticalRulerInfo rulerInfo) {
    	
    	
        return new QVTOBreakpointPropertiesRulerAction(editor, rulerInfo);
    }
}