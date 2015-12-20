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
package org.eclipse.m2m.qvt.oml.debug.core;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IWatchExpressionDelegate;
import org.eclipse.debug.core.model.IWatchExpressionListener;
import org.eclipse.debug.core.model.IWatchExpressionResult;

public class QVTOWatchExpressionDelegate implements IWatchExpressionDelegate {
	
    public void evaluateExpression(String expression, IDebugElement context, IWatchExpressionListener listener) {
        myExpressionText= expression;
        myListener= listener;

        IStackFrame frame = null;
        if (context instanceof IStackFrame) {
            frame = (IStackFrame)context;
        } 
        else if (context instanceof IThread) {
            try {
                frame = ((IThread)context).getTopStackFrame();
            }
            catch (DebugException e) {
            }
        }
        
        if(frame instanceof QVTOStackFrame == false) {
            myListener.watchEvaluationFinished(null);
            return;
        }
        
        QVTOStackFrame qvtFrame = (QVTOStackFrame)frame;
        evaluate(qvtFrame);
    }
    
    protected void evaluate(final QVTOStackFrame qvtFrame) {
        QVTOThread thread = (QVTOThread)qvtFrame.getThread();
        if (!canEvaluate(thread)) {
            myListener.watchEvaluationFinished(null);
            return;
        } 
        
        Job evalJob = new Job("Evaluating " + myExpressionText) { //$NON-NLS-1$
            @Override
			protected IStatus run(IProgressMonitor monitor) {
                IValue value = null;
                String[] errorMessages = new String[0];
                try {
                    value = qvtFrame.evaluate(myExpressionText);
                } 
                catch(Exception e) {
                    errorMessages = new String[] {e.getMessage()};
                }
                
                IWatchExpressionResult watchResult = new QVTOWatchExpressionResult(myExpressionText, value, errorMessages);
                myListener.watchEvaluationFinished(watchResult);
                
                return QVTODebugCore.createStatus(IStatus.OK, ""); //$NON-NLS-1$
            }
        };
        
        evalJob.setRule(new SequentialSchedulingRule());
        evalJob.schedule();
    }
    
    private boolean canEvaluate(QVTOThread qvtThread) {
        return qvtThread != null;
    }
    
    private String myExpressionText;
    private IWatchExpressionListener myListener;
}

class SequentialSchedulingRule implements ISchedulingRule {
    public boolean contains(ISchedulingRule rule) {
        return rule instanceof SequentialSchedulingRule;
    }

    public boolean isConflicting(ISchedulingRule rule) {
        return rule instanceof SequentialSchedulingRule;
    }
}
