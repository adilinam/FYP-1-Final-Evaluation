/*****************************************************************************
 * Copyright (c) 2014,2015 ASML Netherlands B.V. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  ASML Netherlands B.V. - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.tools.coverage.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.m2m.internal.qvt.oml.tools.coverage.ui.CoverageView;
import org.eclipse.m2m.qvt.oml.tools.coverage.Activator;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 *
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ClearCoverageDataCommandHandler extends AbstractHandler {

    /**
     * the command has been executed, so extract extract the needed information from the application context.
     */
	@Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        try {
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(CoverageView.VIEW_ID);
            CoverageView view = (CoverageView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                    .findView(CoverageView.VIEW_ID);
            view.clear();

        } catch (PartInitException e) {
        	Activator.error("Failed to cleanup coverage viewer", e);
        }
        return null;
    }
}