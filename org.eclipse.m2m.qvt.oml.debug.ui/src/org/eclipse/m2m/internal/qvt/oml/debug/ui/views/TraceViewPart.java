/*******************************************************************************
 * Copyright (c) 2010 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sergey Boyko - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.debug.ui.views;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.contexts.DebugContextEvent;
import org.eclipse.debug.ui.contexts.IDebugContextListener;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.common.TraceActionBarContributor;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.common.TraceWorkbenchPart;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;
import org.eclipse.m2m.qvt.oml.debug.core.QVTOStackFrame;
import org.eclipse.m2m.qvt.oml.debug.core.QVTOThread;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchActionConstants;

public class TraceViewPart extends AbstractDebugView implements IDebugContextListener {
	
    @Override
	protected Viewer createViewer(Composite parent) {
        myTraceWorkbenchPart.createPartControl(parent);
		DebugUITools.getDebugContextManager().getContextService(getSite().getWorkbenchWindow()).addDebugContextListener(this);
		TreeViewer viewer = myTraceWorkbenchPart.getViewer();
        myTraceActionBarContributor.setViewer(viewer);
        return viewer;
	}
    
    @Override
    public void dispose() {
        DebugUITools.getDebugContextManager().getContextService(getSite().getWorkbenchWindow()).removeDebugContextListener(this);
        super.dispose();
    }
	
    @Override
	protected String getHelpContextId() {
		return ID;
	}
	
    @Override
	protected void configureToolBar(IToolBarManager toolBarManager) {
        myTraceActionBarContributor.contributeToToolBar(toolBarManager);
	}
	
    @Override
    protected void createActions() {
    }
    
    @Override
	protected void fillContextMenu(IMenuManager menu) {
        menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
    @Override
	protected void becomesHidden() {
		myTraceWorkbenchPart.setInput(null);
	}

    @Override
	protected void becomesVisible() {
		ISelection selection = DebugUITools.getDebugContextManager().getContextService(getSite().getWorkbenchWindow()).getActiveContext();
		contextActivated(selection);
	}
	
	public void debugContextChanged(DebugContextEvent event) {
		if ((event.getFlags() & DebugContextEvent.ACTIVATED) > 0) {
			contextActivated(event.getContext());
		}
	}

	private void contextActivated(ISelection selection) {
		if (!isAvailable() || !isVisible()) {
			return;
		}
		
		if (selection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection)selection).getFirstElement();
            if (firstElement == null) {
                return;
            }
            
            IDebugTarget debugTarget = null;
            if (firstElement instanceof QVTOThread) {
            	QVTOThread qvtThread = (QVTOThread) firstElement;
                try {
                    IStackFrame[] stackFrames = qvtThread.getStackFrames();
                    if (stackFrames.length == 0 
                    		|| false == stackFrames[0] instanceof QVTOStackFrame) {
                    	return;
                    }
                    debugTarget = ((QVTOStackFrame) stackFrames[0]).getDebugTarget();
                } catch (DebugException e) {
                	QVTODebugCore.log(e);
                }
            }
            else if (firstElement instanceof QVTOStackFrame) {
				debugTarget = ((QVTOStackFrame) firstElement).getDebugTarget();
			}
            else if (firstElement instanceof IDebugTarget) {
				debugTarget = (IDebugTarget) firstElement;
			}

			if (debugTarget != null) {
            	QvtOperationalEvaluationEnv evalEnv = (QvtOperationalEvaluationEnv) debugTarget.getAdapter(QvtOperationalEvaluationEnv.class);
            	if (evalEnv != null) {
	                InternalEvaluationEnv internEnv = evalEnv.getAdapter(InternalEvaluationEnv.class);
	                Trace trace = internEnv.getTraces();
	                activate(trace);
	                return;
            	}
            }
		}
        deactivate();
	}
    
    private void activate(Trace trace) {
        if (trace == myTraceWorkbenchPart.getInput()) {
            Display.getDefault().asyncExec(new Runnable() {
                public void run() {
                    myTraceWorkbenchPart.getViewer().refresh();
                }
            });
        } else {
            myTraceWorkbenchPart.setInput(trace);
            setEnabled(true);
        }
    }

    private void deactivate() {
        myTraceWorkbenchPart.setInput(null);
        setEnabled(false);
    }
    
    private void setEnabled(boolean enabled) {
        getDefaultPage().getControl().setVisible(enabled);
        for (IAction action : myTraceActionBarContributor.getActions()) {
            action.setEnabled(enabled);
        }
    }

	private static final String ID = "org.eclipse.m2m.internal.qvt.oml.debug.ui.views.trace"; //$NON-NLS-1$
	
    private final TraceWorkbenchPart myTraceWorkbenchPart = new TraceWorkbenchPart(this);
    private final TraceActionBarContributor myTraceActionBarContributor = new TraceActionBarContributor();

}

